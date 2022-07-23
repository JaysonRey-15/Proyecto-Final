package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class RegistrarPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField textFieldDirec;
	private JTextField textFieldaNacionalidad;
	private JRadioButton rbtCrear;
	private JTextField txtUsuario;
	private JPasswordField txtContrasenia;
	private JPanel panelCrear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarPersona dialog = new RegistrarPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarPersona() {
		setModal(true);
		setBounds(100, 100, 670, 452);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n Personal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 655, 378);
		contentPanel.add(panel);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setColumns(10);
		textFieldCedula.setBounds(30, 64, 259, 20);
		panel.add(textFieldCedula);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(30, 120, 259, 20);
		panel.add(txtNombre);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(30, 176, 259, 20);
		panel.add(txtTelefono);
		
		JLabel label = new JLabel("Tel\u00E9fono");
		label.setFont(new Font("Sitka Small", Font.BOLD, 11));
		label.setBounds(30, 151, 109, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Nombres");
		label_1.setFont(new Font("Sitka Small", Font.BOLD, 11));
		label_1.setBounds(30, 95, 72, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("C\u00E9dula");
		label_2.setFont(new Font("Sitka Small", Font.BOLD, 11));
		label_2.setBounds(30, 39, 46, 14);
		panel.add(label_2);
		
		textFieldDirec = new JTextField();
		textFieldDirec.setColumns(10);
		textFieldDirec.setBounds(340, 222, 275, 20);
		panel.add(textFieldDirec);
		
		JLabel label_3 = new JLabel("Direcci\u00F3n");
		label_3.setFont(new Font("Sitka Small", Font.BOLD, 11));
		label_3.setBounds(340, 197, 83, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("G\u00E9nero");
		label_4.setFont(new Font("Sitka Small", Font.BOLD, 11));
		label_4.setBounds(340, 119, 46, 14);
		panel.add(label_4);
		
		JComboBox comboBoxGen = new JComboBox();
		comboBoxGen.setEditable(true);
		comboBoxGen.setBounds(340, 145, 132, 20);
		panel.add(comboBoxGen);
		
		textFieldaNacionalidad = new JTextField();
		textFieldaNacionalidad.setColumns(10);
		textFieldaNacionalidad.setBounds(30, 236, 159, 20);
		panel.add(textFieldaNacionalidad);
		
		JLabel label_5 = new JLabel("Nacionalidad");
		label_5.setFont(new Font("Sitka Small", Font.BOLD, 11));
		label_5.setBounds(30, 211, 83, 14);
		panel.add(label_5);
		
		rbtCrear = new JRadioButton("Crear usuario");
		rbtCrear.setBounds(506, 146, 109, 23);
		panel.add(rbtCrear);
		
		if(rbtCrear.isSelected()) {
			txtUsuario.setEditable(true);
			txtContrasenia.setEditable(true);
			
			System.out.println("Seleccionado");
			
		}
		
		JComboBox comboBoxCargo = new JComboBox();
		comboBoxCargo.setEditable(true);
		comboBoxCargo.setBounds(340, 64, 132, 20);
		panel.add(comboBoxCargo);
		
		JLabel label_6 = new JLabel("Cargo");
		label_6.setFont(new Font("Sitka Small", Font.BOLD, 11));
		label_6.setBounds(340, 38, 46, 14);
		panel.add(label_6);
		
		panelCrear = new JPanel();
		panelCrear.setBackground(Color.LIGHT_GRAY);
		panelCrear.setBorder(new TitledBorder(null, "Crear usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCrear.setBounds(10, 278, 624, 89);
		panel.add(panelCrear);
		panelCrear.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre usuario");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel.setBounds(22, 22, 98, 14);
		panelCrear.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setBounds(22, 47, 155, 20);
		panelCrear.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNewLabel_1.setBounds(332, 22, 98, 14);
		panelCrear.add(lblNewLabel_1);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setEditable(false);
		txtContrasenia.setBounds(332, 47, 165, 20);
		panelCrear.add(txtContrasenia);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Siguiente");
				okButton.setForeground(Color.WHITE);
				okButton.setEnabled(false);
				okButton.setBackground(Color.GREEN);
				okButton.setFont(new Font("Sitka Small", Font.PLAIN, 12));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBackground(Color.RED);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
