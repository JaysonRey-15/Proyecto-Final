package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import imagenes.FondoPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private Dimension dim;

	private JPanel contentPane;
	FondoPanel fondo = new FondoPanel();
	private JTextField txtCedula;
	private JPanel panelLogin;
	private JPanel panelDatosLogin;
	private JPasswordField loginPass;
	private JPanel panelSystem;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JButton btnNewButton_1;
	private JPanel panelNav;
	private JPanel panelHead;
	private JTextField txtMostrarUsuario;

	ImageIcon iconobtn = new ImageIcon(Principal.class.getResource("/imagenes/icon.png"));
	private JTextField textBuscar;
	private JButton btnEnviar;
	private JPanel panelInfo;
	private JTable tableInfo;
	private DefaultTableModel model;
	private Object[] row;
	private JScrollPane scrollPane;
	private JButton btnNewButton_2;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_3;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_4;
	private JLabel lblCargo;
	private JButton btnUsuario;
	private JButton btnConsulta;
	private JButton btnFactura;
	private JComboBox cmbxServicio;
	private JButton btnPlan;
	private JPanel panelMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-35);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenu mnNewMenu = new JMenu("Ayuda\r\n");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Usuarios");
		mnNewMenu_1.setVisible(false);
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Usuario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(false);
				VistaUsuario vistaU = new VistaUsuario();
				contentPane.add(vistaU);
				vistaU.setVisible(true);
				vistaU.toFront();
				vistaU.setLocation(getWidth()/15, 0);

				//	txtMostrarUsuario.setText(txtCedula.getText());

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//		
		//		panelSystem = new JPanel();
		//		panelSystem.setBackground(SystemColor.control);
		//		panelSystem.setBounds(0, 0,getWidth(),getHeight());
		//		contentPane.add(panelSystem);
		//		panelSystem.setVisible(false);
		//		//panelSystem.setBounds(138, 219, 247, 31);
		//		panelSystem.setLayout(null);
		//		
		//		panelNav = new JPanel();
		//		panelNav.setBackground(new Color(0, 0, 51));
		//		panelNav.setBounds(0, 601, 1356, 59);
		//		panelSystem.add(panelNav);
		//		panelNav.setLayout(null);
		//		
		//		btnRegistrar = new JButton("Registrar");
		//		btnRegistrar.setForeground(Color.WHITE);
		//		btnRegistrar.setBackground(new Color(0, 0, 255));
		//		btnRegistrar.setFont(new Font("Sitka Small", Font.BOLD, 14));
		//
		//        
		//        
		//		btnRegistrar.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//			}
		//		});
		//		btnRegistrar.setBounds(520, 11, 112, 37);
		//		panelNav.add(btnRegistrar);
		//		
		//		btnEliminar = new JButton("Eliminar");
		//		btnEliminar.setForeground(Color.WHITE);
		//		btnEliminar.setBackground(new Color(0, 0, 255));
		//		btnEliminar.setFont(new Font("Sitka Small", Font.BOLD, 14));
		//		btnEliminar.setBounds(642, 11, 112, 37);
		//		panelNav.add(btnEliminar);
		//		
		//		btnNewButton_1 = new JButton("Cuentas");
		//		btnNewButton_1.setForeground(Color.WHITE);
		//		btnNewButton_1.setBackground(new Color(0, 0, 255));
		//		btnNewButton_1.setFont(new Font("Sitka Small", Font.BOLD, 14));
		//		btnNewButton_1.setBounds(764, 11, 112, 37);
		//		panelNav.add(btnNewButton_1);
		//		
		//		panelHead = new JPanel();
		//		panelHead.setBackground(new Color(0, 0, 128));
		//		panelHead.setBounds(0, 0, 1356, 53);
		//		panelSystem.add(panelHead);
		//		panelHead.setLayout(null);
		//		
		//		txtMostrarUsuario = new JTextField();
		//		txtMostrarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		//		txtMostrarUsuario.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		//		txtMostrarUsuario.setForeground(Color.WHITE);
		//		txtMostrarUsuario.setBackground(new Color(255, 140, 0));
		//		txtMostrarUsuario.setEditable(false);
		//		txtMostrarUsuario.setBounds(1023, 10, 170, 31);
		//		panelHead.add(txtMostrarUsuario);
		//		txtMostrarUsuario.setColumns(10);
		//		
		//		btnNewButton_2 = new JButton("Cerrar Sessi\u00F3n");
		//		btnNewButton_2.setForeground(new Color(192, 192, 192));
		//		btnNewButton_2.setBackground(new Color(255, 0, 0));
		//		btnNewButton_2.setFont(new Font("Sitka Small", Font.BOLD, 12));
		//		btnNewButton_2.setBounds(1203, 10, 134, 32);
		//		panelHead.add(btnNewButton_2);
		//		
		//		textBuscar = new JTextField();
		//		textBuscar.setBounds(10, 12, 153, 27);
		//		panelHead.add(textBuscar);
		//		textBuscar.setColumns(10);
		//		
		//		btnEnviar = new JButton("Buscar");
		//		btnEnviar.setBackground(new Color(0, 255, 0));
		//		btnEnviar.setForeground(new Color(255, 228, 181));
		//		btnEnviar.setFont(new Font("Sitka Small", Font.BOLD, 16));
		//		btnEnviar.setBounds(173, 12, 113, 27);
		//		panelHead.add(btnEnviar);
		//		
		//		panelInfo = new JPanel();
		//		panelInfo.setBounds(675, 64, 664, 285);
		//		panelSystem.add(panelInfo);
		//		panelInfo.setLayout(null);
		//		
		//		JScrollPane scrollPane = new JScrollPane();
		//		scrollPane.setBounds(675, 64, 664, 216);
		//		panelSystem.add(scrollPane);
		////		
		//		tableInfo = new JTable();
		//		tableInfo.setFillsViewportHeight(true);
		//		tableInfo.setFont(new Font("Sitka Text", Font.ITALIC, 11));
		//		tableInfo.setBounds(700, 64, 645, 216);
		//		{
		//			model = new DefaultTableModel();
		//			String[] header = {"Identificación","Nombres","Apellidos","Teléfono"};
		//			model.setColumnIdentifiers(header);
		//		}
		//		tableInfo.setModel(model);
		//		scrollPane.setViewportView(tableInfo);
		//		
		//		panel = new JPanel();
		//		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n Personal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		//		panel.setBackground(Color.LIGHT_GRAY);
		//		panel.setBounds(10, 64, 655, 285);
		//		panelSystem.add(panel);
		//		panel.setLayout(null);
		//		
		//		textField = new JTextField();
		//		textField.setEditable(false);
		//		textField.setBounds(30, 64, 259, 20);
		//		panel.add(textField);
		//		textField.setColumns(10);
		//		
		//		textField_1 = new JTextField();
		//		textField_1.setEditable(false);
		//		textField_1.setBounds(30, 120, 259, 20);
		//		panel.add(textField_1);
		//		textField_1.setColumns(10);
		//		
		//		textField_2 = new JTextField();
		//		textField_2.setEditable(false);
		//		textField_2.setBounds(30, 176, 259, 20);
		//		panel.add(textField_2);
		//		textField_2.setColumns(10);
		//		
		//		lblNewLabel_3 = new JLabel("Tel\u00E9fono");
		//		lblNewLabel_3.setFont(new Font("Sitka Small", Font.BOLD, 11));
		//		lblNewLabel_3.setBounds(30, 151, 109, 14);
		//		panel.add(lblNewLabel_3);
		//		
		//		lblNewLabel_4 = new JLabel("Nombres");
		//		lblNewLabel_4.setFont(new Font("Sitka Small", Font.BOLD, 11));
		//		lblNewLabel_4.setBounds(30, 95, 72, 14);
		//		panel.add(lblNewLabel_4);
		//		
		//		lblNewLabel_5 = new JLabel("C\u00E9dula");
		//		lblNewLabel_5.setFont(new Font("Sitka Small", Font.BOLD, 11));
		//		lblNewLabel_5.setBounds(30, 39, 46, 14);
		//		panel.add(lblNewLabel_5);
		//		
		//		textField_3 = new JTextField();
		//		textField_3.setEditable(false);
		//		textField_3.setBounds(340, 222, 305, 20);
		//		panel.add(textField_3);
		//		textField_3.setColumns(10);
		//		
		//		lblNewLabel_6 = new JLabel("Direcci\u00F3n");
		//		lblNewLabel_6.setFont(new Font("Sitka Small", Font.BOLD, 11));
		//		lblNewLabel_6.setBounds(340, 197, 83, 14);
		//		panel.add(lblNewLabel_6);
		//		
		//		lblNewLabel_7 = new JLabel("G\u00E9nero");
		//		lblNewLabel_7.setFont(new Font("Sitka Small", Font.BOLD, 11));
		//		lblNewLabel_7.setBounds(340, 119, 46, 14);
		//		panel.add(lblNewLabel_7);
		//		
		//		JComboBox comboBox = new JComboBox();
		//		comboBox.setEditable(true);
		//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona>", "Hombre", "Mujer"}));
		//		comboBox.setBounds(340, 145, 132, 20);
		//		panel.add(comboBox);
		//		
		//		textField_4 = new JTextField();
		//		textField_4.setEditable(false);
		//		textField_4.setBounds(30, 236, 159, 20);
		//		panel.add(textField_4);
		//		textField_4.setColumns(10);
		//		
		//		JLabel lblNewLabel_8 = new JLabel("Nacionalidad");
		//		lblNewLabel_8.setFont(new Font("Sitka Small", Font.BOLD, 11));
		//		lblNewLabel_8.setBounds(30, 211, 83, 14);
		//		panel.add(lblNewLabel_8);
		//		
		//		JRadioButton radioButton = new JRadioButton("New radio button");
		//		radioButton.setBounds(507, 144, 109, 23);
		//		panel.add(radioButton);
		//		
		//		JComboBox comboBox_1 = new JComboBox();
		//		comboBox_1.setEditable(true);
		//		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona>", "Trabajador", "Administrador", "Cliente"}));
		//		comboBox_1.setBounds(340, 64, 132, 20);
		//		panel.add(comboBox_1);
		//		
		//		lblCargo = new JLabel("Cargo");
		//		lblCargo.setFont(new Font("Sitka Small", Font.BOLD, 11));
		//		lblCargo.setBounds(340, 38, 46, 14);
		//		panel.add(lblCargo);
		//		
		//		JPanel panel_1 = new JPanel();
		//		panel_1.setBorder(new TitledBorder(null, "Datos Adicionales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//		panel_1.setBackground(Color.LIGHT_GRAY);
		//		panel_1.setBounds(10, 360, 291, 230);
		//		panelSystem.add(panel_1);
		//		
		//		JPanel panel_2 = new JPanel();
		//		panel_2.setBackground(Color.LIGHT_GRAY);
		//		panel_2.setBorder(new TitledBorder(null, "Historial De Pagos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//		panel_2.setBounds(311, 360, 1028, 230);
		//		panelSystem.add(panel_2);


		panelLogin = new JPanel();
		panelLogin.setBounds(362, 36, 638, 552);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		panelLogin.setLocation((dim.width/2)-(panelLogin.getWidth()/2), (dim.height/2)-(panelLogin.getHeight()/2));

		panelDatosLogin = new JPanel();
		panelDatosLogin.setBackground(Color.LIGHT_GRAY);
		panelDatosLogin.setBounds(0, 124, 638, 349);
		panelLogin.add(panelDatosLogin);
		panelDatosLogin.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
		lblNewLabel.setBounds(260, 32, 77, 56);
		panelDatosLogin.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("C\u00E9dula");
		lblNewLabel_1.setLabelFor(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Yu Mincho Demibold", Font.BOLD, 16));
		lblNewLabel_1.setBounds(138, 114, 112, 24);
		panelDatosLogin.add(lblNewLabel_1);

		txtCedula = new JTextField();
		txtCedula.setToolTipText("Identificaci\u00F3n\r\n");
		txtCedula.setBackground(Color.WHITE);
		txtCedula.setBounds(138, 140, 247, 31);
		panelDatosLogin.add(txtCedula);
		txtCedula.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Yu Mincho Demibold", Font.BOLD, 16));
		lblNewLabel_2.setBounds(138, 193, 112, 24);
		panelDatosLogin.add(lblNewLabel_2);

		loginPass = new JPasswordField();
		loginPass.setToolTipText("Contrase\u00F1a");
		loginPass.setBounds(138, 219, 247, 31);
		panelDatosLogin.add(loginPass);

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(false);

				//	txtMostrarUsuario.setText(txtCedula.getText());
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		btnNewButton.setBounds(138, 268, 247, 31);
		panelDatosLogin.add(btnNewButton);

		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(Color.BLUE);
		panelHeader.setBounds(0, -1, 638, 125);
		panelLogin.add(panelHeader);
		panelHeader.setLayout(null);
		
		panelMenu = new JPanel();
		panelMenu.setInheritsPopupMenu(true);
		panelMenu.setForeground(new Color(255, 255, 255));
		panelMenu.setBackground(new Color(105, 105, 105));
		panelMenu.setBounds(0, 67, 244, 593);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		btnUsuario = new JButton("Usuarios");
		btnUsuario.setBorder(null);
		
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(false);
				panelLogin.setVisible(false);
				VistaUsuario vistaU = new VistaUsuario();
				contentPane.add(vistaU);
				vistaU.setVisible(true);
				vistaU.toFront();
				vistaU.setLocation(getWidth()/15, 0);
			}
		});
		btnUsuario.setBackground(new Color(0, 0, 255));
		btnUsuario.setForeground(new Color(255, 255, 255));
		btnUsuario.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnUsuario.setBounds(26, 33, 175, 32);
		panelMenu.add(btnUsuario);
		
		btnPlan = new JButton("Planes");
		btnPlan.setBackground(new Color(0, 0, 255));
		btnPlan.setForeground(new Color(255, 255, 255));
		btnPlan.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnPlan.setBounds(26, 99, 175, 32);
		btnPlan.setBorder(null);
		panelMenu.add(btnPlan);
		
		btnConsulta = new JButton("Consultas");
		btnConsulta.setBackground(new Color(0, 0, 255));
		btnConsulta.setForeground(new Color(255, 255, 255));
		btnConsulta.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnConsulta.setBounds(26, 172, 175, 32);
		btnConsulta.setBorder(null);
		panelMenu.add(btnConsulta);
		
		btnFactura = new JButton("Facturas");
		btnFactura.setBackground(new Color(0, 0, 255));
		btnFactura.setForeground(new Color(255, 255, 255));
		btnFactura.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnFactura.setBounds(26, 248, 175, 32);
		btnFactura.setBorder(null);
		panelMenu.add(btnFactura);
		
		cmbxServicio = new JComboBox();
		cmbxServicio.setBackground(new Color(0, 0, 255));
		cmbxServicio.setForeground(new Color(255, 255, 255));
		cmbxServicio.setFont(new Font("Sitka Small", Font.BOLD, 13));
		cmbxServicio.setModel(new DefaultComboBoxModel(new String[] {"Servicios", "Facturar", "Asignar planes", "Crear usuario"}));
		cmbxServicio.setBounds(26, 320, 175, 32);
		panelMenu.add(cmbxServicio);


	}
}
