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
import java.awt.CardLayout;
import java.awt.Canvas;
import javax.swing.JToggleButton;

public class Principal extends JFrame {

	private Dimension dim;

	private JPanel contentPane;
	FondoPanel fondo = new FondoPanel();
	private JPanel panelSystem;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JButton btnNewButton_1;
	private JPanel panelNav;
	private JPanel panelHead;
	private JTextField txtMostrarUsuario;

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
	private JTextField textField_5;
	private JTextField textField_6;

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

		JMenu mnNewMenu_1 = new JMenu("Usuarios");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Control usuario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlUsuario vistaU = new ControlUsuario();
				vistaU.setVisible(true);

				//	txtMostrarUsuario.setText(txtCedula.getText());

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registrar usuario");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPersona regis = new RegistrarPersona(null);
				regis.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu = new JMenu("Plan");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registrar Plan");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPlan plan = new RegistrarPlan(null);
				plan.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Adquirir Plan");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdquirirPlan planAd = new AdquirirPlan();
				planAd.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 0, 1356, 53);
		contentPane.add(panel_1);

		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.LIGHT_GRAY);
		textField_5.setBounds(1021, 10, 170, 31);
		panel_1.add(textField_5);

		JButton button = new JButton("Cerrar Sessi\u00F3n");
		button.setForeground(Color.LIGHT_GRAY);
		button.setFont(new Font("Sitka Small", Font.BOLD, 12));
		button.setBackground(Color.RED);
		button.setBounds(1201, 10, 134, 32);
		panel_1.add(button);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(25, 12, 153, 27);
		panel_1.add(textField_6);

		JButton button_1 = new JButton("Buscar");
		button_1.setForeground(new Color(255, 228, 181));
		button_1.setFont(new Font("Sitka Small", Font.BOLD, 16));
		button_1.setBackground(Color.GREEN);
		button_1.setBounds(188, 11, 113, 27);
		panel_1.add(button_1);


	}
}
