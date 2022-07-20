package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import imagenes.FondoPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {
	
	private Dimension dim;

	private JPanel contentPane;
	FondoPanel fondo = new FondoPanel();
	private JTextField txtCedula;
	private JPanel panelLogin;
	private JPanel panelDatosLogin;
	private JPasswordField loginPass;
	private JPanel panelSystem;

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
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelSystem = new JPanel();
		panelSystem.setBackground(Color.ORANGE);
		panelSystem.setBounds(0, 0,getWidth(),getHeight());
		contentPane.add(panelSystem);
		panelSystem.setVisible(false);
		//panelSystem.setBounds(138, 219, 247, 31);
		panelSystem.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Bienvenido a Altice");
		lblNewLabel_3.setFont(new Font("Stencil", Font.PLAIN, 52));
		lblNewLabel_3.setBounds(182, 79, 599, 254);
		panelSystem.add(lblNewLabel_3);
		
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
				panelSystem.setVisible(true);
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
		//this.setContentPane(fondo);
		
		
	}
}
