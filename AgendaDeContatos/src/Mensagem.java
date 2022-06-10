import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;

public class Mensagem extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Mensagem dialog = new Mensagem();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Mensagem() {
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\arthu\\OneDrive\\Área de Trabalho\\Arthur\\IFSC\\5 semestre\\PDS\\Atividade Avaliativa 3\\Projeto3\\AgendaDeContatos\\src\\Imagens\\icon.png"));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Mensagem");
		setBounds(100, 100, 315, 144);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setForeground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPanel.add(panel);
		
		
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPanel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton);
	}

	protected void mensagem(String textoMensagem) {
		lblNewLabel.setText(textoMensagem);
	}

}
