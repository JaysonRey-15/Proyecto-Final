package Visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
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
import logico.P_Trabajador;
import logico.Persona;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

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
	  private JTextField txtCodigo;
	  private JTextField txtGenero;
	  private JTextField txtCargo;
	  private JLabel Usuario;
	  private JTextField txtpersona;
	  private JButton btnCerrar;
	  private JButton btnModificar;
	  private JTextField textField;
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
		panelHead.setBackground(Color.LIGHT_GRAY);
		panelHead.setBounds(10, 0, 1156, 70);
		panelSystem.add(panelHead);
		panelHead.setLayout(null);
		
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(SystemColor.activeCaptionBorder);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auxPersona = AlticeSystem.getInstance().buscarPersonaByCode(txtBuscar.getText());
				if(auxPersona == null) {
					JOptionPane.showMessageDialog(null, "Usuario No Esta Registrado", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				clean();
			}
		});
		btnBuscar.setBounds(150, 31, 100, 27);
		panelHead.add(btnBuscar);
		
		JComboBox cbxTipo = new JComboBox();
		cbxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPersonasByTipo(cbxTipo.getSelectedIndex());
				clean();
			}
		});
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Cliente", "Administradores", "Trabajadores"}));
		cbxTipo.setBounds(441, 31, 153, 27);
		panelHead.add(cbxTipo);
		
		textField = new JTextField();
		textField.setBounds(24, 31, 114, 27);
		panelHead.add(textField);
		textField.setColumns(10);
		
		panelInfo = new JPanel();
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
					auxPersona = AlticeSystem.getInstance().buscarPersonaByCode(id);
				}
			}
		});
		scrollPane_1.setViewportView(tableInfo);
		{
			model = new DefaultTableModel();
			String[] header = {"Codigo","Nombre","Cedula","Tel�fono", "Cargo"};
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
		txtCedula.setBounds(184, 46, 143, 22);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(12, 101, 315, 22);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(12, 164, 143, 22);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_3.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_3.setBounds(12, 148, 109, 14);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Nombre:");
		lblNewLabel_4.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_4.setBounds(12, 82, 72, 14);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("C\u00E9dula:");
		lblNewLabel_5.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_5.setBounds(184, 28, 46, 14);
		panel.add(lblNewLabel_5);
		
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(12, 228, 479, 22);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_6.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_6.setBounds(12, 210, 83, 14);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("G\u00E9nero:");
		lblNewLabel_7.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_7.setBounds(350, 28, 46, 14);
		panel.add(lblNewLabel_7);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setEditable(false);
		txtNacionalidad.setBounds(184, 165, 143, 22);
		panel.add(txtNacionalidad);
		txtNacionalidad.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nacionalidad:");
		lblNewLabel_8.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_8.setBounds(184, 148, 83, 14);
		panel.add(lblNewLabel_8);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblCargo.setBounds(350, 82, 46, 14);
		panel.add(lblCargo);
		
		lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel.setBounds(12, 27, 56, 16);
		panel.add(lblNewLabel);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(12, 45, 143, 22);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
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
		Usuario.setBounds(350, 147, 56, 16);
		panel.add(Usuario);
		
		txtpersona = new JTextField();
		txtpersona.setEditable(false);
		txtpersona.setBounds(348, 164, 143, 22);
		panel.add(txtpersona);
		txtpersona.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Adicionales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(12, 406, 288, 176);
		panelSystem.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 22, 271, 143);
		panel_1.add(scrollPane_3);
		
		tableAdcional = new JTable();
		scrollPane_3.setViewportView(tableAdcional);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Historial De Pagos Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(306, 406, 850, 176);
		panelSystem.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 22, 814, 143);
		panel_2.add(scrollPane_2);
		
		tableHPagos = new JTable();
		scrollPane_2.setViewportView(tableHPagos);
		
		panelNav = new JPanel();
		panelNav.setBounds(0, 586, 1154, 59);
		contentPane.add(panelNav);
		panelNav.setBackground(Color.LIGHT_GRAY);
		panelNav.setLayout(null);
		
		btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableInfo.getSelectedRow() != -1) {
					String codigo = (String) tableInfo.getValueAt(tableInfo.getSelectedRow(),0);
					auxPersona = AlticeSystem.getInstance().buscarPersonaByCode(codigo);
				}
				txtCedula.setText(auxPersona.getCedula());
				txtNombre.setText(auxPersona.getNombre());
				txtDireccion.setText(auxPersona.getDireccion());
				txtNacionalidad.setText(auxPersona.getNacionalidad());
				txtTelefono.setText(auxPersona.getTelefono());
				txtGenero.setText(auxPersona.getGenero());
				if(auxPersona instanceof P_Trabajador) {
					txtpersona.setText(((P_Trabajador) auxPersona).getMiCuenta().getUsuario());
				}
				if(auxPersona instanceof P_Administrador) {
					txtpersona.setText(((P_Administrador) auxPersona).getMiCuenta().getUsuario());
				}
				txtCargo.setText(auxPersona.getTipo());
				txtCodigo.setText(auxPersona.getCodigoUsuario());
			}
		});
		btnVer.setForeground(Color.WHITE);
		btnVer.setBackground(SystemColor.inactiveCaption);
		btnVer.setFont(new Font("Sitka Small", Font.BOLD, 14));
		
				btnVer.setBounds(257, 11, 112, 37);
				panelNav.add(btnVer);
				
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String codigo = (String) tableInfo.getValueAt(tableInfo.getSelectedRow(),0);
						if (tableInfo.getSelectedRow() != -1) {
							auxPersona = AlticeSystem.getInstance().buscarPersonaByCode(codigo);
						}
						AlticeSystem.getInstance().eliminarPersona(auxPersona);
						clean();
						loadPersonasByTipo(0);
					}
				});
				btnEliminar.setForeground(Color.WHITE);
				btnEliminar.setBackground(SystemColor.inactiveCaption);
				btnEliminar.setFont(new Font("Sitka Small", Font.BOLD, 14));
				btnEliminar.setBounds(505, 11, 112, 37);
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
				btnNewButton_1.setBounds(634, 11, 125, 37);
				panelNav.add(btnNewButton_1);
				
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (tableInfo.getSelectedRow() != -1) {
							String codigo = (String) tableInfo.getValueAt(tableInfo.getSelectedRow(),0);
							auxPersona = AlticeSystem.getInstance().buscarPersonaByCode(codigo);
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
				btnModificar.setBounds(381, 11, 112, 37);
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
				btnCerrar.setBounds(771, 11, 112, 37);
				panelNav.add(btnCerrar);
		
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
		txtCodigo.setText("");
	}
	private void loadPersonasByCode(Persona auxPersona) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		
		if(auxPersona == null) {
			for(int ind = 0; ind < AlticeSystem.getInstance().getMisPersonas().size(); ind++) {
				row[0]= AlticeSystem.getInstance().getMisPersonas().get(ind).getCodigoUsuario();
				row[1]= AlticeSystem.getInstance().getMisPersonas().get(ind).getNombre();
				row[2]= AlticeSystem.getInstance().getMisPersonas().get(ind).getCedula();
				row[3] = AlticeSystem.getInstance().getMisPersonas().get(ind).getTelefono();
				row[4] =AlticeSystem.getInstance().getMisPersonas().get(ind).getTipo();
				model.addRow(row);
			}
		}
		else {
			row[0] = auxPersona.getCodigoUsuario();
			row[1] = auxPersona.getNombre();
			row[2] = auxPersona.getCedula();
			row[3] = auxPersona.getTelefono();
			row[4] = auxPersona.getTipo();
			model.addRow(row);
		}
	}
	
	private void loadPersonasByTipo(int i) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		switch(i) {
		    case 0:
				for(Persona persona : AlticeSystem.getInstance().getMisPersonas()) {
					if(persona instanceof P_Administrador) {
						row[0]= persona.getCodigoUsuario();
						row[1]= persona.getNombre();
						row[2]= persona.getCedula();
						row[3]= persona.getTelefono();
						row[4]= persona.getTipo();
						model.addRow(row);
					}
					if(persona instanceof P_Trabajador) {
						row[0]= persona.getCodigoUsuario();
						row[1]= persona.getNombre();
						row[2]= persona.getCedula();
						row[3]= persona.getTelefono();
						row[4]= persona.getTipo();
						model.addRow(row);
					}
				}
			break;
			
		    case 1:
		    	for(int ind = 0; ind < AlticeSystem.getInstance().getMisPersonas().size(); ind++) {
		    		if(AlticeSystem.getInstance().getMisPersonas().get(ind).getTipo().equalsIgnoreCase("Administrador")) {
						row[0]= AlticeSystem.getInstance().getMisPersonas().get(ind).getCodigoUsuario();
						row[1]= AlticeSystem.getInstance().getMisPersonas().get(ind).getNombre();
						row[2]= AlticeSystem.getInstance().getMisPersonas().get(ind).getCedula();
						row[3] = AlticeSystem.getInstance().getMisPersonas().get(ind).getTelefono();
						row[4] =AlticeSystem.getInstance().getMisPersonas().get(ind).getTipo();
						model.addRow(row);
		    		}
				}
		    break;
		    
		    case 2: 
		    	for(int ind = 0; ind < AlticeSystem.getInstance().getMisPersonas().size(); ind++) {
		    		if(AlticeSystem.getInstance().getMisPersonas().get(ind).getTipo().equalsIgnoreCase("Trabajador")) {
						row[0]= AlticeSystem.getInstance().getMisPersonas().get(ind).getCodigoUsuario();
						row[1]= AlticeSystem.getInstance().getMisPersonas().get(ind).getNombre();
						row[2]= AlticeSystem.getInstance().getMisPersonas().get(ind).getCedula();
						row[3] = AlticeSystem.getInstance().getMisPersonas().get(ind).getTelefono();
						row[4] =AlticeSystem.getInstance().getMisPersonas().get(ind).getTipo();
						model.addRow(row);
		    		}
				}
		    break;
	   }
	   btnModificar.setEnabled(false);
	   btnVer.setEnabled(false);
	   btnEliminar.setEnabled(false);
	}
}
