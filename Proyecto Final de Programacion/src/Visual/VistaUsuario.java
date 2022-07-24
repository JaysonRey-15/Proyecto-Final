package Visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.beans.PropertyVetoException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import logico.AlticeSystem;
import logico.Persona;

import java.awt.Component;


public class VistaUsuario extends JDialog {
	
	private Dimension dim;
	private JPanel contentPane;
	private JPanel panelSystem;
	private JButton btnVer;
	private JButton btnEliminar;
	private JButton btnNewButton_1;
	private JPanel panelNav;
	private JPanel panelHead;
	
	 // ImageIcon iconobtn = new ImageIcon(Principal.class.getResource("/imagenes/icon.png"));
	  private JTextField textBuscar;
	  private JButton btnEnviar;
	  private JPanel panelInfo;
	  private DefaultTableModel model;
	  private Object[] row;
	  private JScrollPane scrollPane;
	  private JPanel panel;
	  private JTextField mID;
	  private JTextField mNombre;
	  private JTextField mTel;
	  private JLabel lblNewLabel_3;
	  private JLabel lblNewLabel_4;
	  private JLabel lblNewLabel_5;
	  private JTextField mDir;
	  private JLabel lblNewLabel_6;
	  private JLabel lblNewLabel_7;
	  private JTextField mNacionalidad;
	  private JLabel lblCargo;
	  private JTable tableInfo;
	  private JTable tableHPagos;
	  private JTable tableAdcional;
	  private JComboBox cmbCargo;
	  private JComboBox cmbGenero;
	  private JButton btnModi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaUsuario frame = new VistaUsuario();
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
	public VistaUsuario() {
		setModal(true);
		
		setTitle("Control usuario");
		setBounds(100, 100, 1039, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		dim = getToolkit().getScreenSize();
		setSize(dim.width-200, dim.height-100);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		panelSystem = new JPanel();
		panelSystem.setOpaque(false);
		panelSystem.setRequestFocusEnabled(false);
		panelSystem.setBackground(SystemColor.control);
		panelSystem.setBounds(0, 0,1166,606);
		contentPane.add(panelSystem);
		//panelSystem.setBounds(138, 219, 247, 31);
		panelSystem.setLayout(null);
		
		panelNav = new JPanel();
		panelNav.setBackground(new Color(0, 0, 51));
		panelNav.setBounds(0, 547, 1166, 59);
		panelSystem.add(panelNav);
		panelNav.setLayout(null);
		
		btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo=null;
				Persona perso = null;
				if (tableInfo.getSelectedRow() != -1) {
					codigo = (String) tableInfo.getValueAt(tableInfo.getSelectedRow(),0);
					perso = AlticeSystem.getInstance().buscarPersona(codigo);
				}
				
				mID.setText(perso.getIdentificacion());
				mNombre.setText(perso.getNombre());
				mDir.setText(perso.getDireccion());
				mNacionalidad.setText(perso.getNacionalidad());
				mTel.setText(perso.getTelefono());
				cmbGenero.setSelectedItem(perso.getGenero());
				
			}
		});
		btnVer.setForeground(Color.WHITE);
		btnVer.setBackground(new Color(0, 0, 255));
		btnVer.setFont(new Font("Sitka Small", Font.BOLD, 14));

		btnVer.setBounds(293, 11, 112, 37);
		panelNav.add(btnVer);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persona perso = null;
				String codigo=null;
				if (tableInfo.getSelectedRow() != -1) {
					codigo = (String) tableInfo.getValueAt(tableInfo.getSelectedRow(),0);
					perso = AlticeSystem.getInstance().buscarPersona(codigo);
				}
				
				AlticeSystem.getInstance().eliminarPersona(perso);
				cargarCarrito();
			}
		});
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(0, 0, 255));
		btnEliminar.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnEliminar.setBounds(537, 11, 112, 37);
		panelNav.add(btnEliminar);
		
		btnNewButton_1 = new JButton("Nuevo");
		btnNewButton_1.setToolTipText("Agregar Personal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPersona addPersona = new RegistrarPersona();
				addPersona.setVisible(true);
				addPersona.setModal(true);
				cargarCarrito();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButton_1.setBounds(659, 11, 125, 37);
		panelNav.add(btnNewButton_1);
		
		btnModi = new JButton("Modificar");
		btnModi.setForeground(Color.WHITE);
		btnModi.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnModi.setBackground(Color.BLUE);
		btnModi.setBounds(415, 11, 112, 37);
		panelNav.add(btnModi);
		
		panelHead = new JPanel();
		panelHead.setBackground(Color.LIGHT_GRAY);
		panelHead.setBounds(0, 0, 1156, 53);
		panelSystem.add(panelHead);
		panelHead.setLayout(null);
		
		textBuscar = new JTextField();
		textBuscar.setBounds(10, 12, 153, 27);
		panelHead.add(textBuscar);
		textBuscar.setColumns(10);
		
		btnEnviar = new JButton("Buscar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persona perso = null;
				perso =AlticeSystem.getInstance().filtroG(textBuscar.getText());
				
				mID.setText(perso.getIdentificacion());
				mNombre.setText(perso.getNombre());
				mDir.setText(perso.getDireccion());
				mNacionalidad.setText(perso.getNacionalidad());
				mTel.setText(perso.getTelefono());
				cmbGenero.setSelectedItem(perso.getGenero());
			}
		});
		btnEnviar.setBackground(new Color(0, 255, 0));
		btnEnviar.setForeground(new Color(255, 228, 181));
		btnEnviar.setFont(new Font("Sitka Small", Font.BOLD, 16));
		btnEnviar.setBounds(173, 12, 113, 27);
		panelHead.add(btnEnviar);
		
		panelInfo = new JPanel();
		panelInfo.setBounds(675, 64, 470, 285);
		panelSystem.add(panelInfo);
		panelInfo.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 471, 285);
		panelInfo.add(scrollPane_1);
		
		tableInfo = new JTable();
		scrollPane_1.setViewportView(tableInfo);
		{
			model = new DefaultTableModel();
			String[] header = {"Identificación","Nombres","Apellidos","Teléfono"};
			model.setColumnIdentifiers(header);
		}
		
		tableInfo.setModel(model);
		
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n Personal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 64, 655, 285);
		panelSystem.add(panel);
		panel.setLayout(null);
		
		mID = new JTextField();
		mID.setEditable(false);
		mID.setBounds(30, 64, 259, 20);
		panel.add(mID);
		mID.setColumns(10);
		
		mNombre = new JTextField();
		mNombre.setEditable(false);
		mNombre.setBounds(30, 120, 259, 20);
		panel.add(mNombre);
		mNombre.setColumns(10);
		
		mTel = new JTextField();
		mTel.setEditable(false);
		mTel.setBounds(30, 176, 259, 20);
		panel.add(mTel);
		mTel.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Tel\u00E9fono");
		lblNewLabel_3.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_3.setBounds(30, 151, 109, 14);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Nombres");
		lblNewLabel_4.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_4.setBounds(30, 95, 72, 14);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("C\u00E9dula");
		lblNewLabel_5.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_5.setBounds(30, 39, 46, 14);
		panel.add(lblNewLabel_5);
		
		
		mDir = new JTextField();
		mDir.setEditable(false);
		mDir.setBounds(340, 222, 305, 20);
		panel.add(mDir);
		mDir.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Direcci\u00F3n");
		lblNewLabel_6.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_6.setBounds(340, 197, 83, 14);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("G\u00E9nero");
		lblNewLabel_7.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_7.setBounds(340, 119, 46, 14);
		panel.add(lblNewLabel_7);
		
		cmbGenero = new JComboBox();
		cmbGenero.setEnabled(false);
		cmbGenero.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona>", "Hombre", "Mujer"}));
		cmbGenero.setBounds(340, 145, 132, 20);
		panel.add(cmbGenero);
		
		mNacionalidad = new JTextField();
		mNacionalidad.setEditable(false);
		mNacionalidad.setBounds(30, 236, 159, 20);
		panel.add(mNacionalidad);
		mNacionalidad.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nacionalidad");
		lblNewLabel_8.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_8.setBounds(30, 211, 83, 14);
		panel.add(lblNewLabel_8);
		
		cmbCargo = new JComboBox();
		cmbCargo.setEnabled(false);
		cmbCargo.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Trabajador", "Administrador"}));
		cmbCargo.setBounds(340, 64, 132, 20);
		panel.add(cmbCargo);
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblCargo.setBounds(340, 38, 46, 14);
		panel.add(lblCargo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Adicionales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 360, 291, 176);
		panelSystem.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 22, 271, 143);
		panel_1.add(scrollPane_3);
		
		tableAdcional = new JTable();
		scrollPane_3.setViewportView(tableAdcional);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new TitledBorder(null, "Historial De Pagos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(311, 360, 834, 176);
		panelSystem.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 22, 814, 143);
		panel_2.add(scrollPane_2);
		
		tableHPagos = new JTable();
		scrollPane_2.setViewportView(tableHPagos);
		panelSystem.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelNav, btnVer, btnEliminar, btnNewButton_1, panelHead, textBuscar, btnEnviar, panelInfo, scrollPane_1, tableInfo, panel, mID, mNombre, mTel, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, mDir, lblNewLabel_6, lblNewLabel_7, cmbGenero, mNacionalidad, lblNewLabel_8, cmbCargo, lblCargo, panel_1, panel_2}));
		
		cargarCarrito();
		
	}
	
	private void cargarCarrito() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(Persona person: AlticeSystem.getInstance().getPersona()) {
			row[0]= person.getIdentificacion();
			row[1]= person.getNombre();
			row[2]= person.getApellido();
			row[3] = person.getTelefono();
			model.addRow(row);
		}
	}
}
