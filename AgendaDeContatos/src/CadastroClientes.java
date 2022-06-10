import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import javafx.scene.control.ComboBox;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CadastroClientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JFormattedTextField txtTelefone;
	private ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();	
	private static Pessoa pessoaSelecionada;
	private int posicaoPessoa;
	private JComboBox comboSexo = new JComboBox();
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnAlterar = new JButton("Alterar");
	
	
	
	public void setBotoes(boolean salvar, boolean excluir, boolean alterar) {
		btnSalvar.setEnabled(salvar);
		btnExcluir.setEnabled(excluir);
		btnAlterar.setEnabled(alterar);		
	}
	
	public static void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		CadastroClientes.pessoaSelecionada = pessoaSelecionada;
	}

	public void setPosicaoPessoa(int posicaoPessoa) {
		this.posicaoPessoa = posicaoPessoa;
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroClientes frame = new CadastroClientes();
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
	public CadastroClientes() {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\Imagens\\icon.png"));
		CadastroClientes cadastroClientes =this;
		
		setTitle("Agenda de Contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setForeground(Color.BLACK);
		lblId.setBounds(21, 11, 46, 14);
		panel_2.add(lblId);
		
		
		txtId = new JFormattedTextField();
		
		txtId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtId.setCaretPosition(0);
			}
		});
		txtId.setBounds(92, 8, 86, 20);
		panel_2.add(txtId);
		txtId.setColumns(10);
		mascara("****", " 0123456789", txtId);
				
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.BLACK);
		lblNome.setBounds(21, 11, 46, 14);
		panel_3.add(lblNome);
		
		txtNome = new JFormattedTextField();
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtNome.setCaretPosition(0);
			}
		});
		txtNome.setBackground(Color.WHITE);
		txtNome.setBounds(92, 8, 233, 20);
		panel_3.add(txtNome);
		txtNome.setColumns(10);
		mascara(null, " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZçÇéáíúóÁÉÓÍÚãõÃÕ", txtNome);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.window);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setForeground(Color.BLACK);
		lblEndereo.setBounds(22, 11, 96, 14);
		panel_4.add(lblEndereo);
		
		txtEndereco = new JFormattedTextField();
		txtEndereco.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtEndereco.setCaretPosition(0);
			}
		});
		txtEndereco.setBounds(92, 8, 233, 20);
		panel_4.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.activeCaption);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setBounds(22, 11, 46, 14);
		panel_5.add(lblEmail);
		
		txtEmail = new JFormattedTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtEmail.setCaretPosition(0);
			}
		});
		txtEmail.setBounds(92, 8, 233, 20);
		panel_5.add(txtEmail);
		txtEmail.setColumns(10);
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.window);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(Color.BLACK);
		lblTelefone.setBounds(22, 11, 117, 14);
		panel_6.add(lblTelefone);
		
		txtTelefone = new JFormattedTextField();
		txtTelefone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtTelefone.setCaretPosition(1);
			}
		});
		txtTelefone.setBounds(92, 8, 96, 20);
		panel_6.add(txtTelefone);
		txtTelefone.setColumns(10);
		mascara("(**)*****-****", " 0123456789", txtTelefone);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(198, 11, 46, 14);
		panel_6.add(lblSexo);
		
		comboSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		comboSexo.setBounds(240, 8, 86, 20);
		panel_6.add(comboSexo);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		ImageIcon iconSalvar = new ImageIcon("src/Imagens/iconSalvar.png");
		iconSalvar.setImage(iconSalvar.getImage().getScaledInstance(15, 15, 15));
		btnSalvar.setIcon(iconSalvar);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(SystemColor.activeCaption);
		
		btnSalvar.setEnabled(true);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa p = new Pessoa();
				
				p.setId(txtId.getText());
				p.setNome(txtNome.getText());
				p.setEndereco(txtEndereco.getText());
				p.setEmail(txtEmail.getText());
				p.setTelefone(txtTelefone.getText());
				p.setSexo(comboSexo.getSelectedIndex());
				if (p.pessoaVazia()==true) {
					setMensagem("Preencha os campos para cadastrar um contato!");
				}else {
					listaPessoas.add(p);
					setMensagem("Contato salvo com sucesso!");
					limparCampos();
				}
			}
		});
		panel_1.add(btnSalvar);
		btnExcluir.setBackground(Color.WHITE);
		ImageIcon iconExcluir = new ImageIcon("src/Imagens/iconExcluir.png");
		iconExcluir.setImage(iconExcluir.getImage().getScaledInstance(15, 15, 15));
		btnExcluir.setIcon(iconExcluir);
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pessoaSelecionada != null) {
					listaPessoas.remove(posicaoPessoa);
					limparCampos();
					setMensagem("Contato excluido com sucesso!");
				}else {
					setMensagem("Selecione um contato para excluir!");
				}
			}
		});
		panel_1.add(btnExcluir);
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setBackground(SystemColor.activeCaption);
		ImageIcon iconAlterar = new ImageIcon("src/Imagens/iconAlterar.png");
		iconAlterar.setImage(iconAlterar.getImage().getScaledInstance(15, 15, 15));
		btnAlterar.setIcon(iconAlterar);
	
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					alterarPessoa(posicaoPessoa, pessoaSelecionada);
					setBotoes(true, false, false);
					setMensagem("Contato alterado com sucesso!");
				} catch (NullPointerException e2) {
					setMensagem("Selecione um contato para alterar!");
				}
				
			}
		});
		panel_1.add(btnAlterar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(Color.WHITE);
		ImageIcon iconPesquisar = new ImageIcon("src/Imagens/iconPesquisar.png");
		iconPesquisar.setImage(iconPesquisar.getImage().getScaledInstance(15, 15, 15));
		btnPesquisar.setIcon(iconPesquisar);
		
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisaContatos janelaPesquisa = new PesquisaContatos(listaPessoas, cadastroClientes);
				janelaPesquisa.setVisible(true);
				cadastroClientes.limparCampos();
				setVisible(false);		
			}			
		});
		panel_1.add(btnPesquisar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(SystemColor.activeCaption);
		ImageIcon iconLimpar = new ImageIcon("src/Imagens/iconLimpar.png");
		iconLimpar.setImage(iconLimpar.getImage().getScaledInstance(15, 15, 15));
		btnLimpar.setIcon(iconLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		panel_1.add(btnLimpar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBackground(Color.WHITE);
		ImageIcon iconFechar = new ImageIcon("src/Imagens/iconFechar.png");
		iconFechar.setImage(iconFechar.getImage().getScaledInstance(10, 10, 10));
		btnFechar.setIcon(iconFechar);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel_1.add(btnFechar);
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.activeCaption);
		contentPane.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_7.add(lblNewLabel);
	}
	
	/*
	usar o trim quando for adicionar no objeto pessoa

p.setId(txtId.getText().trim());
	*/

	protected void mascara(String mascara, String caracteres, JTextField txtFormatado) {
		try {
			MaskFormatter mascaraDesejada = new MaskFormatter(mascara);
			if (mascara==null) {
				mascaraDesejada.setMask("**************************************");
				mascaraDesejada.setValidCharacters(caracteres);
				
			}else {
				mascaraDesejada.setValidCharacters(caracteres);
			}
		      mascaraDesejada.install((JFormattedTextField) txtFormatado);
		    } catch (ParseException ex) {
		      Logger.getLogger(MaskFormatterTest.class.getName()).log(Level.SEVERE, null, ex);
		    }
	}
	
	protected void limparCampos() {
		txtId.setText("");
		txtNome.setText("");
		txtEndereco.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		comboSexo.setSelectedItem(null);
	}

	protected void setMensagem(String mensagemDesejada) {
		Mensagem mensagem = new Mensagem();
		mensagem.mensagem(mensagemDesejada);
		mensagem.setVisible(true);
	}
	protected void pessoaSelecionada(Pessoa pessoaSelecionada) {
		txtId.setText(pessoaSelecionada.getId());
		txtNome.setText(pessoaSelecionada.getNome());
		txtEndereco.setText(pessoaSelecionada.getEndereco());
		txtEmail.setText(pessoaSelecionada.getEmail());
		txtTelefone.setText(pessoaSelecionada.getTelefone());	
		comboSexo.setSelectedIndex(pessoaSelecionada.getSexo());
	}
	public void alterarPessoa(int posicao, Pessoa pessoaSelecionada) {
		pessoaSelecionada.setId(txtId.getText());
		pessoaSelecionada.setNome(txtNome.getText());
		pessoaSelecionada.setEndereco(txtEndereco.getText());
		pessoaSelecionada.setEmail(txtEmail.getText());
		pessoaSelecionada.setTelefone(txtTelefone.getText());
		pessoaSelecionada.setSexo(comboSexo.getSelectedIndex());
		listaPessoas.set(posicao, pessoaSelecionada);
		limparCampos();		
	}
}
