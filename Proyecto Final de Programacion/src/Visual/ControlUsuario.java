package Visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import logico.P_Administrador;
import logico.AlticeSystem;
import logico.Cliente;
import logico.Factura;
import logico.P_Trabajador;
import logico.Persona;
import logico.PlanAdquirido;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import javax.swing.border.LineBorder;

public class ControlUsuario extends JDialog {

	private Dimension dim;
	private JPanel contentPane;
	private JPanel panelSystem;
	private JButton btnVer;
	private JButton btnEliminar;
	private JButton btnNewButton_1;
	private JPanel panelNav;
	private JPanel panelHead;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JPanel panelInfo;
	private DefaultTableModel model;
	private Object[] row;
	private DefaultTableModel model1;
	private Object[] row1;
	private DefaultTableModel model2;
	private Object[] row2;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtDireccion;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtNacionalidad;
	private JLabel lblCargo;
	private JTable tableInfo;
	private JTable tableHPagos;
	private JTable tableAdcional;
	private Persona auxPersona = null;
	private JLabel lblNewLabel;
	private JTextField txtApellido;
	private JTextField txtGenero;
	private JTextField txtCargo;
	private JLabel Usuario;
	private JTextField txtpersona;
	private JButton btnCerrar;
	private JButton btnModificar;
	private JTextField textBuscar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlUsuario frame = new ControlUsuario();
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
	public ControlUsuario() {
		setModal(true);
		setResizable(false);
		setTitle("Control Usuario");
		setBounds(100, 100, 1039, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		dim = getToolkit().getScreenSize();
		setSize(1178, 692);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		ImageIcon logo = new ImageIcon("src/imagenes/download.jpg");
		setIconImage(logo.getImage());
		contentPane.setLayout(null);
		panelSystem = new JPanel();
		panelSystem.setOpaque(false);
		panelSystem.setRequestFocusEnabled(false);
		panelSystem.setBackground(SystemColor.control);
		panelSystem.setBounds(0, 0,1166,590);
		contentPane.add(panelSystem);
		//panelSystem.setBounds(138, 219, 247, 31);
		panelSystem.setLayout(null);

		panelHead = new JPanel();
		panelHead.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Filtros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelHead.setBackground(Color.LIGHT_GRAY);
		panelHead.setBounds(10, 13, 1144, 82);
		panelSystem.add(panelHead);
		panelHead.setLayout(null);


		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(SystemColor.activeCaptionBorder);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auxPersona = AlticeSystem.getInstance().filtroG(textBuscar.getText());

				txtCedula.setText(auxPersona.getCedula());
				txtNombre.setText(auxPersona.getNombre());
				txtApellido.setText(auxPersona.getApellido());
				txtDireccion.setText(auxPersona.getDireccion());
				txtNacionalidad.setText(auxPersona.getNacionalidad());
				txtTelefono.setText(auxPersona.getTelefono());
				txtGenero.setText(auxPersona.getGenero());
				if(auxPersona instanceof P_Trabajador) {
					txtpersona.setText(((P_Trabajador) auxPersona).getCuenta().getUsuario());
				}
				if(auxPersona instanceof P_Administrador) {
					txtpersona.setText(((P_Administrador) auxPersona).getCuenta().getUsuario());
				}
				txtCargo.setText(AlticeSystem.getInstance().tipoP(auxPersona));


				clean();
			}
		});
		btnBuscar.setBounds(191, 31, 100, 27);
		panelHead.add(btnBuscar);

		JComboBox cbxTipo = new JComboBox();
		cbxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPersonasByTipo(cbxTipo.getSelectedIndex());
				clean();
			}
		});
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Clientes", "Administradores", "Trabajadores"}));
		cbxTipo.setBounds(367, 31, 153, 27);
		panelHead.add(cbxTipo);

		textBuscar = new JTextField();
		textBuscar.setBounds(13, 31, 166, 27);
		panelHead.add(textBuscar);
		textBuscar.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Tipo:");
		lblNewLabel_1.setBounds(367, 13, 56, 16);
		panelHead.add(lblNewLabel_1);

		panelInfo = new JPanel();
		panelInfo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfo.setBounds(10, 108, 600, 285);
		panelSystem.add(panelInfo);
		panelInfo.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 600, 285);
		panelInfo.add(scrollPane_1);

		tableInfo = new JTable();
		tableInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int aux = tableInfo.getSelectedRow();
				if(aux != -1) {
					btnModificar.setEnabled(true);
					btnVer.setEnabled(true);
					btnEliminar.setEnabled(true);
					String id = (String) tableInfo.getValueAt(aux, 0);
					auxPersona = AlticeSystem.getInstance().buscarPersonaByCedula(id);
				}
			}
		});
		scrollPane_1.setViewportView(tableInfo);
		{
			model = new DefaultTableModel();
			String[] header = {"Cedula","Nombre","Apellido","Telefono"};
			model.setColumnIdentifiers(header);
		}

		tableInfo.setModel(model);


		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n Personal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(624, 108, 532, 285);
		panelSystem.add(panel);
		panel.setLayout(null);

		txtCedula = new JTextField();
		txtCedula.setEditable(false);
		txtCedula.setBounds(12, 101, 143, 22);
		panel.add(txtCedula);
		txtCedula.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(12, 46, 143, 22);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(184, 101, 143, 22);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		lblNewLabel_3 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_3.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_3.setBounds(184, 82, 109, 14);
		panel.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Nombre:");
		lblNewLabel_4.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_4.setBounds(12, 28, 72, 14);
		panel.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("C\u00E9dula:");
		lblNewLabel_5.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_5.setBounds(12, 82, 46, 14);
		panel.add(lblNewLabel_5);


		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(12, 153, 315, 22);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);

		lblNewLabel_6 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_6.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_6.setBounds(12, 130, 83, 14);
		panel.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("G\u00E9nero:");
		lblNewLabel_7.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_7.setBounds(350, 28, 46, 14);
		panel.add(lblNewLabel_7);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setEditable(false);
		txtNacionalidad.setBounds(350, 153, 143, 22);
		panel.add(txtNacionalidad);
		txtNacionalidad.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Nacionalidad:");
		lblNewLabel_8.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_8.setBounds(350, 130, 83, 14);
		panel.add(lblNewLabel_8);

		lblCargo = new JLabel("Tipo:");
		lblCargo.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblCargo.setBounds(350, 82, 46, 14);
		panel.add(lblCargo);

		txtGenero = new JTextField();
		txtGenero.setEditable(false);
		txtGenero.setBounds(348, 46, 143, 22);
		panel.add(txtGenero);
		txtGenero.setColumns(10);

		txtCargo = new JTextField();
		txtCargo.setEditable(false);
		txtCargo.setBounds(348, 101, 143, 22);
		panel.add(txtCargo);
		txtCargo.setColumns(10);

		Usuario = new JLabel("Usuario:");
		Usuario.setFont(new Font("Dialog", Font.BOLD, 11));
		Usuario.setBounds(12, 188, 56, 16);
		panel.add(Usuario);

		txtpersona = new JTextField();
		txtpersona.setEditable(false);
		txtpersona.setBounds(12, 208, 143, 22);
		panel.add(txtpersona);
		txtpersona.setColumns(10);

		lblNewLabel = new JLabel("Apellido:");
		lblNewLabel.setBounds(184, 28, 56, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 11));

		txtApellido = new JTextField();
		txtApellido.setBounds(184, 46, 143, 22);
		panel.add(txtApellido);
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Adicionales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(12, 406, 288, 176);
		panelSystem.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(12, 22, 269, 143);
		panel_1.add(scrollPane_3);

		tableAdcional = new JTable();
		scrollPane_3.setViewportView(tableAdcional);
		{
			model2 = new DefaultTableModel();
			String[] header = {"Nombre","Estado"};
			model2.setColumnIdentifiers(header);
		}

		tableAdcional.setModel(model2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Historial De Facturas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(306, 406, 850, 176);
		panelSystem.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 22, 814, 143);
		panel_2.add(scrollPane_2);

		tableHPagos = new JTable();
		scrollPane_2.setViewportView(tableHPagos);
		{
			model1 = new DefaultTableModel();
			String[] header = {"Cliente","CodFactura","Fecha Facturaci??n","Total","Fecha Pagada","Estado"};
			model1.setColumnIdentifiers(header);
		}

		tableHPagos.setModel(model1);

		panelNav = new JPanel();
		panelNav.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNav.setBounds(0, 586, 1160, 59);
		contentPane.add(panelNav);
		panelNav.setBackground(Color.LIGHT_GRAY);
		panelNav.setLayout(null);

		btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableInfo.getSelectedRow() != -1) {
					String codigo = (String) tableInfo.getValueAt(tableInfo.getSelectedRow(),0);
					auxPersona = AlticeSystem.getInstance().buscarPersonaByCedula(codigo);
				}
				txtCedula.setText(auxPersona.getCedula());
				txtApellido.setText(auxPersona.getApellido());
				txtNombre.setText(auxPersona.getNombre());
				txtDireccion.setText(auxPersona.getDireccion());
				txtNacionalidad.setText(auxPersona.getNacionalidad());
				txtTelefono.setText(auxPersona.getTelefono());
				txtGenero.setText(auxPersona.getGenero());
				if(auxPersona instanceof P_Trabajador) {
					txtpersona.setText(((P_Trabajador) auxPersona).getCuenta().getUsuario());
				}
				if(auxPersona instanceof P_Administrador) {
					txtpersona.setText(((P_Administrador) auxPersona).getCuenta().getUsuario());
				}
				txtCargo.setText(AlticeSystem.getInstance().tipoP(auxPersona));

				loadFactura((Cliente)auxPersona);
				loadPlanAquirido((Cliente)auxPersona);
			}
		});
		btnVer.setForeground(Color.WHITE);
		btnVer.setBackground(SystemColor.inactiveCaption);
		btnVer.setFont(new Font("Sitka Small", Font.BOLD, 14));

		btnVer.setBounds(357, 12, 112, 37);
		panelNav.add(btnVer);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = (String) tableInfo.getValueAt(tableInfo.getSelectedRow(),0);
				if (tableInfo.getSelectedRow() != -1) {
					auxPersona = AlticeSystem.getInstance().buscarPersonaByCedula(codigo);
				}
				AlticeSystem.getInstance().eliminarPersona(auxPersona);
				clean();
				loadPersonasByTipo(0);
			}
		});
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(SystemColor.inactiveCaption);
		btnEliminar.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnEliminar.setBounds(605, 12, 112, 37);
		panelNav.add(btnEliminar);

		btnNewButton_1 = new JButton("Nuevo");
		btnNewButton_1.setToolTipText("Agregar Personal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPersona addPersona = new RegistrarPersona(null);
				addPersona.setVisible(true);
				addPersona.setModal(true);
				loadPersonasByTipo(0);
				clean();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButton_1.setBounds(220, 12, 125, 37);
		panelNav.add(btnNewButton_1);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableInfo.getSelectedRow() != -1) {
					String codigo = (String) tableInfo.getValueAt(tableInfo.getSelectedRow(),0);
					auxPersona = AlticeSystem.getInstance().buscarPersonaByCedula(codigo);
				}
				if(auxPersona != null) {
					RegistrarPersona user = new RegistrarPersona(auxPersona);
					user.setVisible(true);
					loadPersonasByTipo(0);
					clean();
				}
			}
		});
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnModificar.setBackground(SystemColor.inactiveCaption);
		btnModificar.setBounds(481, 12, 112, 37);
		panelNav.add(btnModificar);
		panelSystem.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelNav, btnVer, btnEliminar, btnNewButton_1, panelHead, txtBuscar, btnBuscar, panelInfo, scrollPane_1, tableInfo, panel, txtCedula, txtNombre, txtTelefono, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, txtDireccion, lblNewLabel_6, lblNewLabel_7, txtNacionalidad, lblNewLabel_8, lblCargo, panel_1, panel_2}));

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCerrar.setBackground(SystemColor.inactiveCaption);
		btnCerrar.setBounds(871, 12, 112, 37);
		panelNav.add(btnCerrar);

		JButton btnPagar = new JButton("Pagar");
		btnPagar.setToolTipText("Agregar Personal");
		btnPagar.setForeground(Color.WHITE);
		btnPagar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnPagar.setBackground(Color.GRAY);
		btnPagar.setBounds(729, 12, 125, 37);
		panelNav.add(btnPagar);

		loadPersonasByTipo(0);

	}

	private void clean() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
		txtNacionalidad.setText("");
		txtTelefono.setText("");
		txtGenero.setText("");
		txtpersona.setText("");
		txtCargo.setText("");
		txtApellido.setText("");
	}

	private void loadPersonasByTipo(int i) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		switch(i) {

		case 0:
			for(Persona persona : AlticeSystem.getInstance().getMisPersonas()) {
				if(persona instanceof Cliente) {
					row[0]= persona.getCedula();
					row[1]= persona.getNombre();
					row[2]=persona.getApellido();
					row[3]= persona.getTelefono();
					model.addRow(row);
				}
			}
			break;


		case 1: 
			for(Persona persona : AlticeSystem.getInstance().getMisPersonas()) {
				if(persona instanceof P_Administrador) {
					row[0]= persona.getCedula();
					row[1]= persona.getNombre();
					row[2]=persona.getApellido();
					row[3]= persona.getTelefono();
					model.addRow(row);
				}
			}
			break;

		case 2: 
			for(Persona persona : AlticeSystem.getInstance().getMisPersonas()) {
				if(persona instanceof P_Trabajador) {
					row[0]= persona.getCedula();
					row[1]= persona.getNombre();
					row[2]=persona.getApellido();
					row[3]= persona.getTelefono();
					model.addRow(row);
				}
			}
			break;
		}
		btnModificar.setEnabled(false);
		btnVer.setEnabled(false);
		btnEliminar.setEnabled(false);
	}

	public void loadFactura(Persona cli) {
		model1.setRowCount(0);
		row1 = new Object[model1.getColumnCount()];
		for(PlanAdquirido plan:((Cliente) cli).getMisPlanesAd()) {
			row[0]=cli.getCedula();
			row[3]=plan.getpagoMensual();

			for(Factura fac: ((Cliente) cli).getMisFacturas()) {
				row[1]=fac.getCodigo();
				row[2]=fac.getFechaGen();
				row[4]=fac.getFechaPagado();
				row[5]=fac.isEstado();
			}
		}
	}
	
	public void loadPlanAquirido(Persona cli) {
		model2.setRowCount(0);
		int index=0;
		row2 = new Object[model2.getColumnCount()];
		for(PlanAdquirido plAq:((Cliente) cli).getMisPlanesAd()) {
			row[0] = plAq.getMisPlanes().get(index).getNombre();
			row[1]=plAq.getSwitch1();
			index++;
		}
	}
}
