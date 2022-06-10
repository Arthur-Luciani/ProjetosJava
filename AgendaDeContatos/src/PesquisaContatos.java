import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;

public class PesquisaContatos extends JFrame {

	private JPanel contentPane;
	private JTable tablePesquisa;
	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private Pessoa pessoaSelecionada;
	private JPanel panel;
	private JButton btnSelecionar;
	private JButton btnCancelar; 
	private int posicaoPessoa;	

	public int getPosicaoPessoa() {
		return posicaoPessoa;
	}


	/**
	 * Create the frame.
	 */
	public PesquisaContatos(ArrayList<Pessoa> listaPessoas, CadastroClientes cadastroClientes) {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Imagens\\icon.png"));
		this.listaPessoas =  listaPessoas;
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				atualizarPesquisa();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tablePesquisa = new JTable();
		tablePesquisa.setForeground(Color.BLACK);
		tablePesquisa.setBackground(SystemColor.activeCaption);
		tablePesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				posicaoPessoa = tablePesquisa.getSelectedRow();
				pessoaSelecionada = listaPessoas.get(posicaoPessoa);
			}
		});
		tablePesquisa.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Telefone"
			}
		));
		scrollPane.setViewportView(tablePesquisa);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		PesquisaContatos pesquisaContatos = this;
		btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBackground(Color.WHITE);
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastroClientes.pessoaSelecionada(pessoaSelecionada);				
					cadastroClientes.setPessoaSelecionada(pessoaSelecionada);
					cadastroClientes.setPosicaoPessoa(posicaoPessoa);
					cadastroClientes.setBotoes(false, true, true);
					cadastroClientes.setVisible(true);
					setVisible(false);
				} catch (NullPointerException e2) {
					Mensagem mensagem = new Mensagem();
					mensagem.mensagem("Selecione um contato para realizar esta ação");
					mensagem.setVisible(true);
					
				}
			}
		});
		panel.add(btnSelecionar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				cadastroClientes.setBotoes(true, false, false);
				cadastroClientes.setVisible(true);
				
			}
		});
		panel.add(btnCancelar);
	}


	protected void atualizarPesquisa() {		
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Nome", "Telefone"
				}
			);
			for(int i=0; i< listaPessoas.size(); i++) {
				Pessoa p = listaPessoas.get(i);
				modelo.addRow(new Object[] { p.getId(), p.getNome(), p.getTelefone() });
			}
			tablePesquisa.setModel(modelo);			
	}
	
}
