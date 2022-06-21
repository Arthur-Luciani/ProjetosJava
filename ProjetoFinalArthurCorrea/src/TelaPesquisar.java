import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class TelaPesquisar extends JFrame {

	private JPanel contentPane;
	private JTable tablePacientes;
	private ArrayList<Paciente>listaPacientes = new ArrayList<Paciente>();

	protected int posicaoPaciente;
	protected Paciente pacienteSelecionado;

	

	/**
	 * Create the frame.
	 */
	public TelaPesquisar(TelaInicial telaInicial) {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPesquisar.class.getResource("/imagens/keys.png")));
		setTitle("Calculadora IMC");
		listaPacientes = TelaInicial.lerArquivo("dados.dat");
		Mensagem mensagem = new Mensagem();		
		
		TelaPesquisar telaPesquisar=this;
		TelaCadastrarAtualizar telaAtualizar = new TelaCadastrarAtualizar(telaInicial);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				atualizarPesquisa();
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Pesquisar Paciente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tablePacientes = new JTable();
		tablePacientes.setBackground(Color.WHITE);
		tablePacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				posicaoPaciente = tablePacientes.getSelectedRow();
				pacienteSelecionado= listaPacientes.get(posicaoPaciente);				
			}
		});
		tablePacientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Idade", "Altura (m)", "Peso (kg)", "IMC", "Situa\u00E7\u00E3o IMC"
			}
		));
		tablePacientes.getColumnModel().getColumn(0).setPreferredWidth(104);
		tablePacientes.getColumnModel().getColumn(1).setPreferredWidth(54);
		tablePacientes.getColumnModel().getColumn(2).setPreferredWidth(72);
		tablePacientes.getColumnModel().getColumn(3).setPreferredWidth(72);
		tablePacientes.getColumnModel().getColumn(4).setPreferredWidth(54);
		tablePacientes.getColumnModel().getColumn(5).setPreferredWidth(141);
		scrollPane.setViewportView(tablePacientes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel_1.add(panel_2);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(new Color(153, 204, 255));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					telaAtualizar.setPacienteSelecionado(pacienteSelecionado);
					telaAtualizar.setPosicaoPaciente(posicaoPaciente);
					telaAtualizar.setListaPacientes(listaPacientes);
					
					telaAtualizar.cadastrar= false;
					telaAtualizar.textoTitulo("Atualizar Paciente");
					telaAtualizar.botaoExcluir(true);
					telaAtualizar.camposAtualizar(pacienteSelecionado);
									
					telaAtualizar.setVisible(true);
				} catch (NullPointerException e2) {
					mensagem.setMensagem("Selecione um paciente!");
					mensagem.setVisible(true);
				}
			}
		});
		panel_2.add(btnAtualizar);
		
		JButton btnDados = new JButton("Dados");
		btnDados.setBackground(new Color(153, 204, 255));
		btnDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					TelaDados telaDados = new TelaDados(telaPesquisar, pacienteSelecionado.getListaAtualizacao(), pacienteSelecionado);
					telaDados.setVisible(true);
					
					setVisible(false);
				} catch (NullPointerException e2) {
					setVisible(true);
					mensagem.setMensagem("Selecione um paciente!");
					mensagem.setVisible(true);
				}				
			}
		});
		panel_2.add(btnDados);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.TRAILING);
		panel_1.add(panel_3);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(153, 204, 255));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				telaInicial.setVisible(true);
			}
		});
		panel_3.add(btnVoltar);
	}
	protected void atualizarPesquisa() {		
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nome", "Idade", "Peso (kg)", "Altura (m)", "IMC", "Situa\u00E7\u00E3o IMC"
				}
			);
		tablePacientes.getColumnModel().getColumn(0).setPreferredWidth(104);
		tablePacientes.getColumnModel().getColumn(1).setPreferredWidth(54);
		tablePacientes.getColumnModel().getColumn(2).setPreferredWidth(72);
		tablePacientes.getColumnModel().getColumn(3).setPreferredWidth(72);
		tablePacientes.getColumnModel().getColumn(4).setPreferredWidth(54);
		tablePacientes.getColumnModel().getColumn(5).setPreferredWidth(141);
		
		
			for(int i=0; i< listaPacientes.size(); i++) {
				Paciente p = listaPacientes.get(i);
				modelo.addRow(new Object[] { p.getNome(), p.getIdade(), p.getPeso(), p.getAltura(), p.imc(p.getPeso(), p.getAltura()), p.situacaoImc() });
			}
			tablePacientes.setModel(modelo);			
	}

	public ArrayList<Paciente> getListaPacientes() {
		return listaPacientes;
	}
	public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}
}
