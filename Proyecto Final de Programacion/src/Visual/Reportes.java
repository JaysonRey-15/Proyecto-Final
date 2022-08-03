package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Persona;

import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Reportes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaReportes;
	private JScrollPane scrollPane;
	private JPanel panel;
	private Object[] row, row1, row2;
	private DefaultTableModel model1;

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
		setBounds(100, 100, 854, 496);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setResizable(false);
		setModal(true);
		{
			JCheckBox checkBox = new JCheckBox("CANTIDAD DE VENTAS POR CADA PLAN");
			checkBox.setSelected(true);
			checkBox.setFont(new Font("Sitka Text", Font.PLAIN, 13));
			checkBox.setBounds(42, 61, 356, 23);
			contentPanel.add(checkBox);
		}
		{
			JCheckBox checkBox = new JCheckBox("CANTIDAD DE DINERO GENERADO POR CADA PLAN");
			checkBox.setSelected(true);
			checkBox.setFont(new Font("Sitka Text", Font.PLAIN, 13));
			checkBox.setBounds(425, 61, 356, 23);
			contentPanel.add(checkBox);
		}
		{
			JCheckBox checkBox = new JCheckBox("CANTIDAD DE CLIENTES");
			checkBox.setSelected(true);
			checkBox.setFont(new Font("Sitka Text", Font.PLAIN, 13));
			checkBox.setBounds(42, 97, 356, 23);
			contentPanel.add(checkBox);
		}
		{
			JCheckBox checkBox = new JCheckBox("CANTIDAD DE CLIENTES CON MAS DE 1 PLAN");
			checkBox.setSelected(true);
			checkBox.setFont(new Font("Sitka Text", Font.PLAIN, 13));
			checkBox.setBounds(425, 97, 356, 23);
			contentPanel.add(checkBox);
		}
		
		JLabel lblGeneradorDeReportes = new JLabel("GENERADOR DE REPORTES");
		lblGeneradorDeReportes.setFont(new Font("Sitka Text", Font.PLAIN, 17));
		lblGeneradorDeReportes.setBounds(263, 23, 235, 14);
		contentPanel.add(lblGeneradorDeReportes);
		
		panel = new JPanel();
		panel.setBounds(16, 143, 788, 270);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 768, 248);
		panel.add(scrollPane);
		{
			tablaReportes = new JTable();
			scrollPane.setViewportView(tablaReportes);{
				model1 = new DefaultTableModel();
				String[] header = {"Fecha", "Cant. Ventas por Plan", "Cant. Clientes", "Cant. Dinero Generado", "Clientes con multiplan"};
				model1.setColumnIdentifiers(header);
			}
				tablaReportes.setModel(model1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("GENERAR");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				
				JButton btnNewButton = new JButton("GUARDAR REPORTE");
				buttonPane.add(btnNewButton);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("SALIR");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
