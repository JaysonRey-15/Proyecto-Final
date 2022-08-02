package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JLabel;

public class Reportes extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reportes dialog = new Reportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reportes() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JCheckBox checkBox = new JCheckBox("CANTIDAD DE VENTAS POR CADA PLAN");
			checkBox.setFont(new Font("Sitka Text", Font.PLAIN, 13));
			checkBox.setBounds(39, 62, 356, 23);
			contentPanel.add(checkBox);
		}
		{
			JCheckBox checkBox = new JCheckBox("CANTIDAD DE DINERO GENERADO POR CADA PLAN");
			checkBox.setFont(new Font("Sitka Text", Font.PLAIN, 13));
			checkBox.setBounds(39, 104, 356, 23);
			contentPanel.add(checkBox);
		}
		{
			JCheckBox checkBox = new JCheckBox("CANTIDAD DE CLIENTES");
			checkBox.setFont(new Font("Sitka Text", Font.PLAIN, 13));
			checkBox.setBounds(39, 145, 356, 23);
			contentPanel.add(checkBox);
		}
		{
			JCheckBox checkBox = new JCheckBox("CANTIDAD DE CLIENTES CON MAS DE 1 PLAN");
			checkBox.setFont(new Font("Sitka Text", Font.PLAIN, 13));
			checkBox.setBounds(39, 184, 356, 23);
			contentPanel.add(checkBox);
		}
		
		JLabel lblGeneradorDeReportes = new JLabel("GENERADOR DE REPORTES");
		lblGeneradorDeReportes.setFont(new Font("Sitka Text", Font.PLAIN, 17));
		lblGeneradorDeReportes.setBounds(101, 28, 235, 14);
		contentPanel.add(lblGeneradorDeReportes);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("GENERAR");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("SALIR");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
