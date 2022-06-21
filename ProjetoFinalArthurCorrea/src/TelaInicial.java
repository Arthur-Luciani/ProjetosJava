import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private ArrayList<Paciente>listaPacientes =  new ArrayList<Paciente>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/imagens/keys.png")));
		
		setTitle("Calculadora IMC");
		TelaInicial telaInicial=this;
		TelaCadastrarAtualizar telaCadastrar = new TelaCadastrarAtualizar(telaInicial);
		TelaPesquisar telaPesquisar = new  TelaPesquisar(telaInicial);
		
		addWindowListener(new WindowAdapter() {
			
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				listaPacientes= telaPesquisar.getListaPacientes();
				escreverArquivo(listaPacientes, "dados.dat");
			}
			@Override
			public void windowActivated(WindowEvent e) {
				listaPacientes = lerArquivo("dados.dat");
				telaPesquisar.setListaPacientes(listaPacientes);
				telaCadastrar.setListaPacientes(listaPacientes);
			}
		});
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 234);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Calculadora IMC");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_1.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_1.add(panel_5);
		
		JButton btnCadastrar = new JButton("Cadastrar Paciente");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				
				setVisible(false);
				telaCadastrar.cadastrar= true;
				telaCadastrar.textoTitulo("Cadastrar Paciente");
				telaCadastrar.botaoExcluir(false);
				telaCadastrar.setVisible(true);
			}
		});
		btnCadastrar.setBackground(new Color(153, 204, 255));
		panel_5.add(btnCadastrar);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_1.add(panel_6);
		
		JButton btnPesquisar = new JButton("Pesquisar Paciente");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				setVisible(false);
				telaPesquisar.setVisible(true);
			}
		});
		btnPesquisar.setBackground(new Color(153, 204, 255));
		panel_6.add(btnPesquisar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_1.add(panel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnFechar.setBackground(new Color(153, 204, 255));
		panel_2.add(btnFechar);
	}
	public static void escreverArquivo(ArrayList<Paciente>listaPacientes, String nomeArquivo) {
		try {
			File arq = new File(nomeArquivo);
			arq.delete();
			arq.createNewFile();
			
			ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
			objOutput.writeObject(listaPacientes);
			objOutput.close();
					
		} catch (IOException erro) {
			System.out.printf("Erro %s", erro.getMessage());
		}
	}
	public static ArrayList<Paciente> lerArquivo(String nomeArquivo) {
		ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
		try {
			File arq = new File(nomeArquivo);
			if (arq.exists()) {
				ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
				listaPacientes = (ArrayList<Paciente>) objInput.readObject();
				objInput.close();
				
			}
		} catch (IOException erro1) {
			System.out.printf("Erro: %s", erro1.getMessage());
		} catch (ClassNotFoundException erro2) {
			System.out.printf("Erro: %s", erro2.getMessage());
		}
		return listaPacientes;		
	}
	
	public ArrayList<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}
}
