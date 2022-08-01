package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import imagenes.FondoPanel;

import logico.AlticeSystem;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Canvas;
import javax.swing.JToggleButton;

public class Principal extends JFrame {

	private Dimension dim;

	private JPanel contentPane;
	FondoPanel fondo = new FondoPanel();
	private JMenuItem menuItemControlUsuario;
	private JMenuItem menuItemRegUsuario;
	private JMenu menuUsuarios;
	private JMenu menuPlan;
	private JMenuItem menuItemRegPlan;
	private JMenuItem menuItemAdPlan;
	private JMenuItem menuItemListPlan;
	private JMenu menuReporte;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Guardar("altice.dat");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-35);
		setLocationRelativeTo(null);
		ImageIcon logo = new ImageIcon("src/imagenes/download.jpg");
		setIconImage(logo.getImage());
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuUsuarios = new JMenu("Usuarios");
		menuBar.add(menuUsuarios);

		menuItemControlUsuario = new JMenuItem("Control usuario");
		menuItemControlUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlUsuario vistaU = new ControlUsuario();
				vistaU.setVisible(true);

				//	txtMostrarUsuario.setText(txtCedula.getText());

			}
		});
		menuUsuarios.add(menuItemControlUsuario);
		
		menuItemRegUsuario = new JMenuItem("Registrar usuario");
		menuItemRegUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPersona regis = new RegistrarPersona(null);
				regis.setVisible(true);
			}
		});
		menuUsuarios.add(menuItemRegUsuario);
		
		menuPlan = new JMenu("Planes");
		menuBar.add(menuPlan);
		
		menuItemRegPlan = new JMenuItem("Registrar Plan");
		menuItemRegPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPlan plan = new RegistrarPlan(null);
				plan.setVisible(true);
			}
		});
		menuPlan.add(menuItemRegPlan);
		
		menuItemAdPlan = new JMenuItem("Adquirir Plan");
		menuItemAdPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdquirirPlan planAd = new AdquirirPlan();
				planAd.setVisible(true);
			}
		});
		menuPlan.add(menuItemAdPlan);
		
		menuItemListPlan = new JMenuItem("Listar Planes");
		menuItemListPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPlanes listPlan = new ListarPlanes();
				listPlan.setVisible(true);
			}
		});
		menuPlan.add(menuItemListPlan);
		
		menuReporte = new JMenu("Reportes");
		menuBar.add(menuReporte);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		JButton btnCerrar = new JButton("Cerrar Sesion");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Guardar("altice.dat");
				Login login = new Login();
				dispose();
				login.setVisible(true);
			}
		});
		btnCerrar.setBounds(1762, 13, 118, 33);
		panelPrincipal.add(btnCerrar);


	}
	
	public void Guardar(String nombre)
	{
		try {
			FileOutputStream altice2;
			ObjectOutputStream alticeWrite;
			altice2 = new  FileOutputStream(nombre);
			alticeWrite = new ObjectOutputStream(altice2);
			alticeWrite.writeObject(AlticeSystem.getInstance());
			alticeWrite.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
