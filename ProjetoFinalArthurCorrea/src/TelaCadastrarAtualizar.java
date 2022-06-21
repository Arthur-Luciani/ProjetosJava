import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class TelaCadastrarAtualizar extends JFrame {

	
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDataDeNascimento;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JLabel lblTitulo;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private ArrayList<Paciente>listaPacientes = new ArrayList<Paciente>();
	protected boolean cadastrar;
	private int posicaoPaciente;
	private Paciente pacienteSelecionado;
	
	

	/**
	 * Create the frame.
	 */
	public TelaCadastrarAtualizar(TelaInicial telaInicial) {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastrarAtualizar.class.getResource("/imagens/keys.png")));
		setTitle("Calculadora IMC");
		Mensagem mensagem = new Mensagem();
		
		
		
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
		
		lblTitulo = new JLabel("Texto Desejado");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout_4 = (FlowLayout) panel_2.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEADING);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout_5 = (FlowLayout) panel_3.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEADING);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Data de nasciemento");
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		FlowLayout flowLayout_6 = (FlowLayout) panel_4.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEADING);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Altura (m)");
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		FlowLayout flowLayout_7 = (FlowLayout) panel_5.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEADING);
		panel_1.add(panel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Peso (kg)");
		panel_5.add(lblNewLabel_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		contentPane.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_8.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel_6.add(panel_8);
		
		txtNome = new JFormattedTextField();
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtNome.setCaretPosition(0);
			}
		});
		panel_8.add(txtNome);
		txtNome.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_9.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		panel_6.add(panel_9);
		
		txtDataDeNascimento = new JFormattedTextField();
		txtDataDeNascimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtDataDeNascimento.setCaretPosition(0);
			}
		});
		panel_9.add(txtDataDeNascimento);
		txtDataDeNascimento.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel_10.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEADING);
		panel_6.add(panel_10);
		
		txtAltura = new JFormattedTextField();
		txtAltura.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtAltura.setCaretPosition(0);
			}
		});
		panel_10.add(txtAltura);
		txtAltura.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEADING);
		panel_6.add(panel_7);
		
		txtPeso = new JFormattedTextField();
		txtPeso.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPeso.setCaretPosition(0);
			}
		});
		panel_7.add(txtPeso);
		txtPeso.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		contentPane.add(panel_11, BorderLayout.SOUTH);
		panel_11.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		FlowLayout flowLayout_8 = (FlowLayout) panel_12.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEADING);
		panel_11.add(panel_12);
		
		//mascaras
		mascara(null, " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÃ§Ã‡Ã©Ã¡Ã­ÃºÃ³Ã�Ã‰Ã“Ã�ÃšÃ£ÃµÃƒÃ•", txtNome);
		mascara("**/**/****", "0123456789", txtDataDeNascimento);
		mascara("*****", "0123456789.", txtAltura);
		mascara("*****", "0123456789.", txtPeso);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(153, 204, 255));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cadastrar==true) {
					try {
						if (txtNome.getText().equals("") || txtDataDeNascimento.getText().equals("  /  /    ") || txtAltura.getText().equals("") || txtPeso.getText().equals("")) {
							mensagem.setMensagem("Prrencha todos os campos");
							mensagem.setVisible(true);
						}else {
							cadastrar();
							mensagem.setMensagem("Paciente cadastrado com sucesso!");
							mensagem.setVisible(true);
						}
						
					} catch (NumberFormatException e) {
						mensagem.setMensagem("Preencha os campos corretamente");
						mensagem.setVisible(true);
					} catch (DateTimeException e) {
						mensagem.setMensagem("Preencha os campos corretamente");
						mensagem.setVisible(true);
					}
				}else {
					atualizar(posicaoPaciente, pacienteSelecionado);
					mensagem.setMensagem("Paciente atualizado com sucesso");
					mensagem.setVisible(true);
					setVisible(false);
				}
				limpar();
				TelaInicial.escreverArquivo(listaPacientes, "dados.dat");
			}
		});
		panel_12.add(btnSalvar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(153, 204, 255));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pacienteSelecionado != null) {
					listaPacientes.remove(posicaoPaciente);
					limpar();
					mensagem.setMensagem("Paciente excluido com sucesso!");
					mensagem.setVisible(true);
				}
				TelaInicial.escreverArquivo(listaPacientes, "dados.dat");
			}
		});
		panel_12.add(btnExcluir);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		FlowLayout flowLayout_9 = (FlowLayout) panel_13.getLayout();
		flowLayout_9.setAlignment(FlowLayout.TRAILING);
		panel_11.add(panel_13);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(153, 204, 255));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				telaInicial.setVisible(true);
				limpar();				
			}
		});
		panel_13.add(btnVoltar);
	}
	protected void limpar() {
		txtNome.setText("");
		txtDataDeNascimento.setText("");
		txtAltura.setText("");
		txtPeso.setText("");
	}
	
	protected void textoTitulo(String textoDesejado) {
		lblTitulo.setText(textoDesejado);
	}
	protected void botaoExcluir(boolean btnExcluir) {
		this.btnExcluir.setVisible(btnExcluir);
		this.btnExcluir.setEnabled(btnExcluir);
	}
	protected void cadastrar() {
		Paciente p = new Paciente();
		p.setNome(txtNome.getText().trim());
		p.setDataDeNascimento(txtDataDeNascimento.getText());
		p.setAltura(Float.parseFloat(txtAltura.getText()));
		p.setPeso(Float.parseFloat(txtPeso.getText()));
		
		Atualizacao a = new Atualizacao();
		a.setDataAtualizacao(LocalDate.now());
		a.setAlturaAtuazalicao(p.getAltura());
		a.setPesoAtualizacao(p.getPeso());
		
		p.addAtualizacao(a);
		listaPacientes.add(p);
		
		limpar();
	}
	
	protected void atualizar(int posicaoPaciente, Paciente pacienteSelecionado) {
		pacienteSelecionado.setNome(txtNome.getText().trim());
		pacienteSelecionado.setDataDeNascimento(txtDataDeNascimento.getText());
		pacienteSelecionado.setAltura(Float.parseFloat(txtAltura.getText()));
		pacienteSelecionado.setPeso(Float.parseFloat(txtPeso.getText()));
		
		Atualizacao a = new Atualizacao();
		a.setDataAtualizacao(LocalDate.now());
		a.setAlturaAtuazalicao(pacienteSelecionado.getAltura());
		a.setPesoAtualizacao(pacienteSelecionado.getPeso());
		
		pacienteSelecionado.addAtualizacao(a);
		listaPacientes.set(posicaoPaciente, pacienteSelecionado);
		
		limpar();
	}
	
	protected void camposAtualizar(Paciente pacienteSelecionado) {
		txtNome.setText(pacienteSelecionado.getNome());
		txtDataDeNascimento.setText(pacienteSelecionado.getDataDeNascimento());
		txtAltura.setText(String.valueOf(pacienteSelecionado.getAltura()));
		txtPeso.setText(String.valueOf(pacienteSelecionado.getPeso()));
	}
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
		    }
	}
	
	
	public ArrayList<Paciente> getListaPacientes() {
		return listaPacientes;
	}
	public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}
	public int getPosicaoPaciente() {
		return posicaoPaciente;
	}
	public void setPosicaoPaciente(int posicaoPaciente) {
		this.posicaoPaciente = posicaoPaciente;
	}
	public Paciente getPacienteSelecionado() {
		return pacienteSelecionado;
	}
	public void setPacienteSelecionado(Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}
}
