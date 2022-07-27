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

import javax.swing.text.MaskFormatter;

import logico.P_Administrador;
import logico.AlticeSystem;
import logico.Cuenta;
import logico.P_Trabajador;
import logico.Persona;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class RegistrarPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField txtCedula;
	private JFormattedTextField txtTelefono;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtNacionalidad;
	private JComboBox<String> cbxCargo;
	private JTextField txtUser;
	private JLabel labelCedula;
	private JLabel labelTelefono;
	private JLabel labelNombre;
	private JLabel labelNacionalidad;
	private JLabel labelDireccion;
	private JLabel labelPersona;
	private JLabel labelPassword;
	private JPasswordField txtPassword = new JPasswordField();
	private Persona auxPersona = null;
	private JLabel lblNewLabel_1;
	private JTextField txtCodigo;
	private JComboBox<String> cbxGenero;
    private Cuenta cuenta = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarPersona dialog = new RegistrarPersona(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarPersona(Persona Persona) {
		auxPersona = Persona;
		setTitle("Registrar Usuario");
		if(auxPersona != null) {
			setTitle("Modificar Usuario");
		}
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 608,427);
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
		panel.setBounds(12, 12, 565, 238);
		contentPanel.add(panel);
		MaskFormatter cedula = null;
		try {
			cedula = new MaskFormatter("###-#######-#");
			cedula.setPlaceholderCharacter('_');
		} catch (ParseException e) {}
		txtCedula = new JFormattedTextField(cedula);
		txtCedula.setColumns(10);
		txtCedula.setBounds(202, 40, 171, 22);
		if(auxPersona != null) {
			txtCedula.setEditable(false);
			txtCedula.setText(auxPersona.getCedula());
		}
		panel.add(txtCedula);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(12, 91, 361, 22);
		if(auxPersona != null) {
			txtNombre.setText(auxPersona.getNombre());
		}
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
		txtTelefono.setBounds(12, 142, 171, 22);
		if(auxPersona != null) {
			txtTelefono.setText(auxPersona.getTelefono());
		}
		panel.add(txtTelefono);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblTelfono.setBounds(12, 126, 109, 14);
		panel.add(lblTelfono);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNombre.setBounds(12, 75, 72, 14);
		panel.add(lblNombre);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblCdula.setBounds(202, 22, 46, 14);
		panel.add(lblCdula);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(12, 195, 361, 22);
		if(auxPersona != null) {
			txtDireccion.setText(auxPersona.getDireccion());
		}
		panel.add(txtDireccion);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblDireccin.setBounds(12, 177, 83, 14);
		panel.add(lblDireccin);

		JLabel lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblGnero.setBounds(405, 22, 46, 14);
		panel.add(lblGnero);

		cbxGenero = new JComboBox<String>();
		cbxGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbxGenero.setModel(new DefaultComboBoxModel<String>(new String[] {"Hombre", "Mujer"}));
		cbxGenero.setBounds(402, 40, 119, 22);
		if(auxPersona != null) {
			cbxGenero.setEnabled(false);
		}
		panel.add(cbxGenero);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(202, 142, 171, 22);
		if(auxPersona != null) {
			txtNacionalidad.setText(auxPersona.getNacionalidad());
		}
		panel.add(txtNacionalidad);

		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNacionalidad.setBounds(202, 126, 119, 14);
		panel.add(lblNacionalidad);



		cbxCargo = new JComboBox<String>();
		cbxCargo.setEnabled(false);
		cbxCargo.setForeground(SystemColor.textText);
		cbxCargo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbxCargo.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Administrador", "Trabajador"}));
		cbxCargo.setSelectedIndex(0);
		cbxCargo.setBounds(402, 91, 119, 22);
		if(auxPersona != null && auxPersona.getTipo().equalsIgnoreCase("Administrador")) {
			cbxCargo.setSelectedIndex(0);
		}
		if(auxPersona != null && auxPersona.getTipo().equalsIgnoreCase("Trabajador")) {
			cbxCargo.setSelectedIndex(1);
		}
		panel.add(cbxCargo);

		JLabel lblTipo = new JLabel("Cargo:");
		lblTipo.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblTipo.setBounds(405, 75, 46, 14);
		panel.add(lblTipo);
		
		labelCedula = new JLabel("*");
		labelCedula.setForeground(Color.RED);
		labelCedula.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelCedula.setBounds(373, 43, 20, 16);
		labelCedula.setVisible(false);
		panel.add(labelCedula);
		
		labelNombre = new JLabel("*");
		labelNombre.setForeground(Color.RED);
		labelNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelNombre.setBounds(373, 94, 20, 16);
		labelNombre.setVisible(false);
		panel.add(labelNombre);
		
		labelTelefono = new JLabel("*");
		labelTelefono.setForeground(Color.RED);
		labelTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTelefono.setBounds(184, 145, 20, 16);
		labelTelefono.setVisible(false);
		panel.add(labelTelefono);
		
		labelNacionalidad = new JLabel("*");
		labelNacionalidad.setForeground(Color.RED);
		labelNacionalidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelNacionalidad.setBounds(373, 145, 20, 16);
		labelNacionalidad.setVisible(false);
		panel.add(labelNacionalidad);
		
		labelDireccion = new JLabel("*");
		labelDireccion.setForeground(Color.RED);
		labelDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelDireccion.setBounds(373, 198, 20, 16);
		labelDireccion.setVisible(false);
		panel.add(labelDireccion);
		
		lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setBounds(12, 21, 56, 16);
		panel.add(lblNewLabel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(12, 40, 171, 22);
		if(auxPersona != null) {
			txtCodigo.setText(auxPersona.getCodigoUsuario());
		}
		else {
			txtCodigo.setText("P-"+AlticeSystem.getInstance().getGeneradorCodigoPersona());
		}
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Asignar usuario");
		rdbtnNewRadioButton.setBounds(408, 141, 149, 23);
		panel.add(rdbtnNewRadioButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Crear Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(12, 256, 565, 85);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(12, 28, 111, 16);
		panel_1.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setEditable(false);
		txtUser.setBounds(12, 50, 187, 22);
		if(auxPersona != null && auxPersona instanceof P_Administrador) {
			txtUser.setText(((P_Administrador) auxPersona).getMiCuenta().getUsuario());
		}
		panel_1.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel2.setBounds(236, 28, 121, 16);
		panel_1.add(lblNewLabel2);
		
		labelPersona = new JLabel("*");
		labelPersona.setForeground(Color.RED);
		labelPersona.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelPersona.setBounds(204, 53, 20, 16);
		labelPersona.setVisible(false);
		panel_1.add(labelPersona);
		
		labelPassword = new JLabel("*");
		labelPassword.setForeground(Color.RED);
		labelPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelPassword.setBounds(427, 53, 20, 16);
		labelPassword.setVisible(false);
		panel_1.add(labelPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setEditable(false);
		txtPassword.setBounds(236, 50, 187, 22);
		if(auxPersona != null && auxPersona instanceof P_Administrador) {
			txtPassword.setText(((P_Administrador) auxPersona).getMiCuenta().getPassword());
		}
		panel_1.add(txtPassword);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setForeground(Color.WHITE);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnRegistrar = new JButton("Registrar");
			if(auxPersona != null) {
				btnRegistrar.setText("Modificar");
			}
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean Persona = AlticeSystem.getInstance().PersonaExiste(txtUser.getText(), auxPersona);
					String password = new String(txtPassword.getPassword());
					if(!Persona) {
						if(auxPersona == null) {
							if(validarCampos()) {
								JOptionPane.showConfirmDialog(null, "Por favor llenar los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
							}
							else {
								Persona aux = null;
								cuenta = new Cuenta(password, txtUser.getText());
								if(cbxCargo.getSelectedIndex()== 0) {
									aux = new P_Administrador(txtCedula.getText(), txtNombre.getText(), cbxGenero.getSelectedItem().toString(), txtNacionalidad.getText(), txtDireccion.getText(), txtTelefono.getText(), txtCodigo.getText(), cbxCargo.getSelectedItem().toString(), cuenta);
								}
								if(cbxCargo.getSelectedIndex()== 1) {
									aux = new P_Trabajador(txtCedula.getText(), txtNombre.getText(), cbxGenero.getSelectedItem().toString(), txtNacionalidad.getText(), txtDireccion.getText(), txtTelefono.getText(), txtCodigo.getText(), cbxCargo.getSelectedItem().toString(), cuenta);
								}
								AlticeSystem.getInstance().ingresarPersona(aux);
								JOptionPane.showMessageDialog(null, "Registro Exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								clean();
							}
						}
						else {
							if(validarCampos()) {
								JOptionPane.showConfirmDialog(null, "Por favor llenar los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
							}
							else {
								auxPersona.setNombre(txtNombre.getText());
								auxPersona.setDireccion(txtDireccion.getText());
								auxPersona.setNacionalidad(txtNacionalidad.getText());
								auxPersona.setTelefono(txtTelefono.getText());
								if(auxPersona instanceof P_Administrador) {
									((P_Administrador) auxPersona).setMiCuenta(cuenta);
								}
								if(auxPersona instanceof P_Trabajador) {
									((P_Trabajador) auxPersona).setMiCuenta(cuenta);
								}
								if(cbxCargo.getSelectedIndex() == 0) {
									auxPersona.setTipo(cbxCargo.getSelectedItem().toString());
								}
								if(cbxCargo.getSelectedIndex() == 1) {
									auxPersona.setTipo(cbxCargo.getSelectedItem().toString());
								}
								AlticeSystem.getInstance().modificarPersona(auxPersona, cuenta);
								dispose();
							}
						}
					}
					else if(Persona) {
						JOptionPane.showMessageDialog(null, "Este Usuario ya Existe", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnRegistrar.setActionCommand("OK");
			buttonPane.add(btnRegistrar);
			{
				
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	private void clean() {
	    txtCedula.setValue(null);
		txtNombre.setText("");
		txtNacionalidad.setText("");
		txtTelefono.setValue(null);
		txtDireccion.setText("");
		txtUser.setText("");
		txtPassword.setText("");
		cbxGenero.setSelectedIndex(0);
		cbxCargo.setSelectedIndex(0);
		txtCodigo.setText("P-"+AlticeSystem.getInstance().getGeneradorCodigoPersona());
	}
	
	private boolean validarCampos(){
		boolean validar = false;
		
		if(!txtCedula.isEditValid()) {
			labelCedula.setVisible(true);
			validar = true;
		}
		else {
			labelCedula.setVisible(false);
		}
		
		if(!txtTelefono.isEditValid()) {
			labelTelefono.setVisible(true);
			validar = true;
		}
		else {
			labelTelefono.setVisible(false);
		}
		
		if(txtNombre.getText().trim().isEmpty()) {
			labelNombre.setVisible(true);
			validar = true;
		}
		else {
			labelNombre.setVisible(false);
		}
		
		if(txtNacionalidad.getText().trim().isEmpty()) {
			labelNacionalidad.setVisible(true);
			validar = true;
		}
		else {
			labelNacionalidad.setVisible(false);
		}
		
		if(txtDireccion.getText().trim().isEmpty()) {
			labelDireccion.setVisible(true);
			validar = true;
		}
		else {
			labelDireccion.setVisible(false);
		}
		
		if(txtUser.getText().trim().isEmpty()) {
			labelPersona.setVisible(true);
			validar = true;
		}
		else {
			labelPersona.setVisible(false);
		}
		
		if(txtPassword.getPassword().length == 0) {
			labelPassword.setVisible(true);
			validar = true;
		}
		else {
			labelPassword.setVisible(false);
		}
		return validar;
	}
}
