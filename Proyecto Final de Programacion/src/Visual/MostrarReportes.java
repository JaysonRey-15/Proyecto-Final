package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarReportes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaDeReportes;
	private JTable tablaDinero;
	private JTable tablaVenta;
	private JTextField textField;
	private Object[] row;
	private DefaultTableModel model1;
	private Object[] row1;
	private DefaultTableModel model2;
	private Object[] row2;
	private DefaultTableModel model3;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JPanel panelClientes;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarReportes dialog = new MostrarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarReportes() {
		setBounds(100, 100, 747, 459);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelTabla = new JPanel();
			panelTabla.setBounds(62, 11, 612, 168);
			contentPanel.add(panelTabla);
			panelTabla.setLayout(null);
			
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(10, 11, 592, 157);
			panelTabla.add(scrollPane_2);
			
			tablaDeReportes = new JTable();
			tablaDeReportes.setCellSelectionEnabled(true);
			tablaDeReportes.setToolTipText("");
			scrollPane_2.setViewportView(tablaDeReportes);{
				model1 = new DefaultTableModel();
				String[] header = {"Fecha","Codigo de la Factura","Generado Por"};
				model1.setColumnIdentifiers(header);
			}
			
			tablaDeReportes.setModel(model1);
		}
		{
			JPanel panelcuadro = new JPanel();
			panelcuadro.setBounds(62, 190, 612, 186);
			contentPanel.add(panelcuadro);
			panelcuadro.setLayout(null);
			
			JPanel panelVentas = new JPanel();
			panelVentas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelVentas.setBounds(10, 11, 169, 170);
			panelcuadro.add(panelVentas);
			panelVentas.setLayout(null);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 149, 148);
			panelVentas.add(scrollPane);
			
			tablaVenta = new JTable();
			scrollPane.setViewportView(tablaVenta);{
				model2 = new DefaultTableModel();
				String[] header = {"Plan","Cant. Venta"};
				model2.setColumnIdentifiers(header);
			}
			
			tablaVenta.setModel(model2);
			
			JPanel panelDinero = new JPanel();
			panelDinero.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelDinero.setBounds(214, 11, 169, 170);
			panelcuadro.add(panelDinero);
			panelDinero.setLayout(null);
			
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 11, 149, 148);
			panelDinero.add(scrollPane_1);
			
			tablaDinero = new JTable();
			scrollPane_1.setViewportView(tablaDinero); {
				model3 = new DefaultTableModel();
				String[] header = {"Plan","Cant. Dinero"};
				model3.setColumnIdentifiers(header);
			}
			
			tablaDinero.setModel(model3);
			
			panelClientes = new JPanel();
			panelClientes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "CLIENTES CON MULTIPLAN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelClientes.setBounds(421, 11, 169, 170);
			panelcuadro.add(panelClientes);
			panelClientes.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(34, 76, 106, 20);
			panelClientes.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Ok");
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
