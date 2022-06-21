import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;

public class Mensagem extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblMensagem;

	/**
	 * Create the dialog.
	 */
	public Mensagem() {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mensagem.class.getResource("/imagens/keys.png")));
		setTitle("Calculadora IMC");
		setBounds(100, 100, 332, 168);
		getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			lblMensagem = new JLabel("mensagem desejada");
			contentPanel.add(lblMensagem);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(153, 204, 255));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	protected void setMensagem(String mensagemDesejada) {
		lblMensagem.setText(mensagemDesejada);
	}

}
