package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import logico.AlticeSystem;
import logico.Cliente;
import logico.P_Administrador;
import logico.P_Trabajador;
import logico.Persona;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class RegistrarPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private DefaultTableModel model;
	private Object[] row;
	private JTextField textFieldCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField textFieldDirec;
	private JTextField textFieldaNacionalidad;
	private JRadioButton rbtCrear;
	private JComboBox<String> comboBoxCargo;
	private JButton okButton;
	private JTextField txtUsuario;
	private JTextField txtContrasenia;

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
		setTitle("Registrar Persona");
		setModal(true);
		setBounds(100, 100, 604,386);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.menu);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n Personal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 580, 213);
		contentPanel.add(panel);
		MaskFormatter cedula = null;
		try {
			cedula = new MaskFormatter("###-#######-#");
			cedula.setPlaceholderCharacter('_');
		} catch (ParseException e) {}
		textFieldCedula = new JFormattedTextField(cedula);
		textFieldCedula.setColumns(10);
		textFieldCedula.setBounds(12, 49, 191, 22);
		panel.add(textFieldCedula);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(12, 109, 191, 22);
		panel.add(txtNombre);
		
		MaskFormatter telefono = null;
		try {
			telefono = new MaskFormatter("###-###-####");
			telefono.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtTelefono = new JFormattedTextField(telefono);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(225, 49, 191, 22);
		panel.add(txtTelefono);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblTelfono.setBounds(225, 22, 109, 14);
		panel.add(lblTelfono);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNombre.setBounds(12, 82, 72, 14);
		panel.add(lblNombre);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblCdula.setBounds(12, 26, 46, 14);
		panel.add(lblCdula);

		textFieldDirec = new JTextField();
		textFieldDirec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(campoLleno()==true) {
					okButton.setEnabled(true);
				}
			}
		});
		textFieldDirec.setColumns(10);
		textFieldDirec.setBounds(12, 161, 403, 22);
		panel.add(textFieldDirec);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblDireccin.setBounds(12, 142, 83, 14);
		panel.add(lblDireccin);

		JLabel lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblGnero.setBounds(429, 22, 46, 14);
		panel.add(lblGnero);

		JComboBox<String> comboBoxGen = new JComboBox<String>();
		comboBoxGen.setModel(new DefaultComboBoxModel<String>(new String[] {"<Selecciona>", "Hombre", "Mujer"}));
		comboBoxGen.setBounds(429, 49, 132, 22);
		panel.add(comboBoxGen);

		textFieldaNacionalidad = new JTextField();
		textFieldaNacionalidad.setColumns(10);
		textFieldaNacionalidad.setBounds(225, 109, 191, 22);
		panel.add(textFieldaNacionalidad);

		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNacionalidad.setBounds(225, 82, 83, 14);
		panel.add(lblNacionalidad);

		rbtCrear = new JRadioButton("Crear usuario");
		rbtCrear.setBackground(SystemColor.control);
		rbtCrear.setForeground(SystemColor.activeCaptionText);
		rbtCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtCrear.isSelected()) {
					txtUsuario.setEditable(true);
					txtContrasenia.setEditable(true);
				}
			}

		});
		rbtCrear.setBounds(430, 161, 109, 22);
		panel.add(rbtCrear);



		comboBoxCargo = new JComboBox<String>();
		comboBoxCargo.setForeground(SystemColor.textText);
		comboBoxCargo.setFont(new Font("Sitka Small", Font.BOLD, 13));
		comboBoxCargo.setModel(new DefaultComboBoxModel<String>(new String[] {"Cliente", "Administrador", "Trabajador"}));
		comboBoxCargo.setSelectedIndex(0);
		comboBoxCargo.setBounds(429, 109, 132, 22);
		panel.add(comboBoxCargo);
		if((AlticeSystem.getInstance().getPersonaConectada() instanceof P_Administrador)) {
			comboBoxCargo.setEnabled(true);
			rbtCrear.setVisible(true);
		}

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblTipo.setBounds(430, 82, 46, 14);
		panel.add(lblTipo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Crear Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(0, 212, 580, 85);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(12, 28, 56, 16);
		panel_1.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setBounds(12, 50, 187, 22);
		panel_1.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel2.setBounds(236, 28, 70, 16);
		panel_1.add(lblNewLabel2);
		
		txtContrasenia = new JTextField();
		txtContrasenia.setEditable(false);
		txtContrasenia.setBounds(236, 50, 187, 22);
		panel_1.add(txtContrasenia);
		txtContrasenia.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setForeground(Color.WHITE);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Siguiente");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Persona persona = null;
						if(comboBoxCargo.getSelectedIndex()==0) {
							persona = new Cliente(textFieldCedula.getText(),txtNombre.getText(),txtNombre.getText(),comboBoxGen.getSelectedItem().toString(),textFieldaNacionalidad.getText(), textFieldDirec.getText(),txtTelefono.getText());
						}

						if(comboBoxCargo.getSelectedIndex()==1) {
							persona = new P_Administrador(textFieldCedula.getText(),txtNombre.getText(),txtNombre.getText(),comboBoxGen.getSelectedItem().toString(),textFieldaNacionalidad.getText(), textFieldDirec.getText(),txtTelefono.getText());
						}

						if(comboBoxCargo.getSelectedIndex()==2) {
							persona = new P_Trabajador(textFieldCedula.getText(),txtNombre.getText(),txtNombre.getText(),comboBoxGen.getSelectedItem().toString(),textFieldaNacionalidad.getText(), textFieldDirec.getText(),txtTelefono.getText());
							
						}
						AlticeSystem.getInstance().ingresarPersona(persona);
					}
				});
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBackground(Color.RED);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public boolean campoLleno() {
		if(textFieldCedula.getText().length()>0 && txtNombre.getText().length()>0 && txtTelefono.getText().length()>0 && textFieldDirec.getText().length()>0 && textFieldaNacionalidad.getText().length()>0) 
			return true;
		else
			return false;
	}
}
