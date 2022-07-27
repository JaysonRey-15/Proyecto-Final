package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class AdquirirPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtFecha;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtTotal;
	private JTextField txtDia;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AdquirirPlan dialog = new AdquirirPlan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AdquirirPlan() {
		setTitle("Adquirir Plan");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 457, 514);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Cedula:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(10, 10, 104, 23);
			panel.add(lblNewLabel);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(10, 30, 206, 23);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			{
				JLabel lblNewLabel_1 = new JLabel("Fecha:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
				lblNewLabel_1.setBounds(367, 14, 56, 16);
				panel.add(lblNewLabel_1);
			}
			{
				txtFecha = new JTextField();
				txtFecha.setEditable(false);
				txtFecha.setBounds(356, 30, 67, 22);
				panel.add(txtFecha);
				txtFecha.setColumns(10);
			}
			
			JButton btnNewButton = new JButton("Buscar");
			btnNewButton.setBounds(222, 29, 97, 22);
			panel.add(btnNewButton);
			
			JLabel lblNewLabel_2 = new JLabel("Nombre:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(10, 63, 104, 23);
			panel.add(lblNewLabel_2);
			
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setBounds(10, 83, 206, 23);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			{
				JLabel lblNewLabel_3 = new JLabel("Telefono:");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabel_3.setBounds(238, 63, 104, 23);
				panel.add(lblNewLabel_3);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setEditable(false);
				txtTelefono.setBounds(238, 83, 185, 23);
				panel.add(txtTelefono);
				txtTelefono.setColumns(10);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Direccion:");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabel_4.setBounds(10, 123, 104, 23);
				panel.add(lblNewLabel_4);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setEditable(false);
				txtDireccion.setBounds(10, 143, 413, 23);
				panel.add(txtDireccion);
				txtDireccion.setColumns(10);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Planes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 180, 413, 190);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel_1.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
				}
			}
			
			JLabel lblNewLabel_6 = new JLabel("Total:");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_6.setBounds(10, 383, 90, 35);
			panel.add(lblNewLabel_6);
			
			txtTotal = new JTextField();
			txtTotal.setEditable(false);
			txtTotal.setBounds(50, 390, 104, 23);
			panel.add(txtTotal);
			txtTotal.setColumns(10);
			{
				JLabel lblNewLabel_7 = new JLabel("Dia de pago:");
				lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabel_7.setBounds(238, 383, 90, 35);
				panel.add(lblNewLabel_7);
			}
			{
				txtDia = new JTextField();
				txtDia.setEditable(false);
				txtDia.setBounds(319, 389, 104, 23);
				panel.add(txtDia);
				txtDia.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Adquirir");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
