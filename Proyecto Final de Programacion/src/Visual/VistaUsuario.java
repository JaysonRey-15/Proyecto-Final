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
import java.awt.Component;


public class VistaUsuario extends JInternalFrame {
	
	private Dimension dim;
	private JPanel contentPane;
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
	  private JTable tableInfo;
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
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setClosable(true);
		try {
			setClosed(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setOpaque(true);
		//setMaximum(true);
		setMaximizable(true);
		setNormalBounds(new Rectangle(0, 0, 1300, 0));
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setTitle("Herramienta Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1039, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		dim = getToolkit().getScreenSize();
		setIconifiable(true);
		setSize(dim.width-200, dim.height-100);

		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenu mnNewMenu = new JMenu("Ayuda\r\n");
		menuBar.add(mnNewMenu);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelSystem = new JPanel();
		panelSystem.setOpaque(false);
		panelSystem.setRequestFocusEnabled(false);
		panelSystem.setBackground(SystemColor.control);
		panelSystem.setBounds(0, 0,getWidth(),getHeight());
		contentPane.add(panelSystem);
		//panelSystem.setBounds(138, 219, 247, 31);
		panelSystem.setLayout(null);
		
		panelNav = new JPanel();
		panelNav.setBackground(new Color(0, 0, 51));
		panelNav.setBounds(0, 547, 1166, 59);
		panelSystem.add(panelNav);
		panelNav.setLayout(null);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(new Color(0, 0, 255));
		btnRegistrar.setFont(new Font("Sitka Small", Font.BOLD, 14));

		btnRegistrar.setBounds(415, 11, 112, 37);
		panelNav.add(btnRegistrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(0, 0, 255));
		btnEliminar.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnEliminar.setBounds(537, 11, 112, 37);
		panelNav.add(btnEliminar);
		
		btnNewButton_1 = new JButton("Inicio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButton_1.setBounds(659, 11, 112, 37);
		panelNav.add(btnNewButton_1);
		
		panelHead = new JPanel();
		panelHead.setBackground(new Color(0, 0, 128));
		panelHead.setBounds(0, 0, 1356, 53);
		panelSystem.add(panelHead);
		panelHead.setLayout(null);
		
		txtMostrarUsuario = new JTextField();
		txtMostrarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtMostrarUsuario.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtMostrarUsuario.setForeground(Color.WHITE);
		txtMostrarUsuario.setBackground(new Color(255, 140, 0));
		txtMostrarUsuario.setEditable(false);
		txtMostrarUsuario.setBounds(839, 10, 170, 31);
		panelHead.add(txtMostrarUsuario);
		txtMostrarUsuario.setColumns(10);
		
		btnNewButton_2 = new JButton("Cerrar Sessi\u00F3n");
		btnNewButton_2.setForeground(new Color(192, 192, 192));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnNewButton_2.setBounds(1019, 10, 134, 32);
		panelHead.add(btnNewButton_2);
		
		textBuscar = new JTextField();
		textBuscar.setBounds(10, 12, 153, 27);
		panelHead.add(textBuscar);
		textBuscar.setColumns(10);
		
		btnEnviar = new JButton("Buscar");
		btnEnviar.setBackground(new Color(0, 255, 0));
		btnEnviar.setForeground(new Color(255, 228, 181));
		btnEnviar.setFont(new Font("Sitka Small", Font.BOLD, 16));
		btnEnviar.setBounds(173, 12, 113, 27);
		panelHead.add(btnEnviar);
		
		panelInfo = new JPanel();
		panelInfo.setBounds(675, 64, 481, 285);
		panelSystem.add(panelInfo);
		panelInfo.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 481, 285);
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
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(30, 64, 259, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(30, 120, 259, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(30, 176, 259, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
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
		
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(340, 222, 305, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Direcci\u00F3n");
		lblNewLabel_6.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_6.setBounds(340, 197, 83, 14);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("G\u00E9nero");
		lblNewLabel_7.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_7.setBounds(340, 119, 46, 14);
		panel.add(lblNewLabel_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona>", "Hombre", "Mujer"}));
		comboBox.setBounds(340, 145, 132, 20);
		panel.add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(30, 236, 159, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nacionalidad");
		lblNewLabel_8.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_8.setBounds(30, 211, 83, 14);
		panel.add(lblNewLabel_8);
		
		JRadioButton radioButton = new JRadioButton("New radio button");
		radioButton.setBounds(507, 144, 109, 23);
		panel.add(radioButton);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"<Selecciona>", "Trabajador", "Administrador", "Cliente"}));
		comboBox_1.setBounds(340, 64, 132, 20);
		panel.add(comboBox_1);
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblCargo.setBounds(340, 38, 46, 14);
		panel.add(lblCargo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos Adicionales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 360, 291, 176);
		panelSystem.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new TitledBorder(null, "Historial De Pagos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(311, 360, 845, 176);
		panelSystem.add(panel_2);
		panelSystem.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelNav, btnRegistrar, btnEliminar, btnNewButton_1, panelHead, txtMostrarUsuario, btnNewButton_2, textBuscar, btnEnviar, panelInfo, scrollPane_1, tableInfo, panel, textField, textField_1, textField_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, textField_3, lblNewLabel_6, lblNewLabel_7, comboBox, textField_4, lblNewLabel_8, radioButton, comboBox_1, lblCargo, panel_1, panel_2}));
		
	}
}
