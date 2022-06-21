import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.GridLayout;

public class TelaDados extends JFrame {

	private JPanel contentPane;
	private JTable tableDados;
	private ArrayList<Atualizacao>listaAtualizacoes = new ArrayList<Atualizacao>();

	

	/**
	 * Create the frame.
	 */
	public TelaDados(TelaPesquisar telaPesquisar, ArrayList<Atualizacao>listaAtualizacoes, Paciente pacienteSelecionado) {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDados.class.getResource("/imagens/keys.png")));
		setTitle("Calculadora IMC");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				atualizar();
			}
		});
		this.listaAtualizacoes= listaAtualizacoes;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Dados do Paciente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Nome: "+ pacienteSelecionado.getNome()+"          Idade: "+ pacienteSelecionado.getIdade());
		panel_2.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		tableDados = new JTable();
		tableDados.setBackground(Color.WHITE);
		tableDados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data de atualiza\u00E7\u00E3o", "Altura (m)", "Peso (kg)", "IMC", "Situa\u00E7\u00E3o IMC"
			}
		));
		tableDados.getColumnModel().getColumn(0).setPreferredWidth(123);
		scrollPane.setViewportView(tableDados);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEADING);
		panel_3.add(panel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.TRAILING);
		panel_3.add(panel_4);
		
		JButton btnVoltar = new JButton("Voltar");
		panel_4.add(btnVoltar);
		btnVoltar.setBackground(new Color(153, 204, 255));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				telaPesquisar.setVisible(true);
			}
		});
	}
	
	protected void atualizar() {		
		DefaultTableModel modelo = new DefaultTableModel(	
				new Object[][] {
				},
				new String[] {
						"Data de atualiza\u00E7\u00E3o", "Altura (m)", "Peso (kg)", "IMC", "Situa\u00E7\u00E3o IMC"
				}
			);
		
		
			for(int i=listaAtualizacoes.size()-1; i> -1; i--) {
				Atualizacao a = listaAtualizacoes.get(i);
				modelo.addRow(new Object[] { a.getDataAtualizacao(), a.getAlturaAtuazalicao(), a.getPesoAtualizacao(), a.imc(a.getPesoAtualizacao(), a.getAlturaAtuazalicao()), a.situacaoImc() });
			}
			tableDados.setModel(modelo);			
	}

}
