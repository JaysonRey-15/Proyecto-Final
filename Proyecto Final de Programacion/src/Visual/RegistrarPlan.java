package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logico.AlticeSystem;
import logico.Cable;
import logico.Internet;
import logico.Plan;
import logico.Telefono;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class RegistrarPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecioInicial;
	private JTextField txtPrecioMensual;
	private JRadioButton rdbTelefono;
	private JRadioButton rdbInternet;
	private JRadioButton rdbCable;
	private JTextField txtVelocidad;
	private JTextField txtMinutos;
	private JTextField txtCanales;
	private JPanel panelTelefono;
	private JPanel panelInternet;
	private JPanel panelCable;
	private Plan auxPlan = null;
	private JLabel labelPrecioM;
	private JLabel labelPrecioIni;
	private JLabel labelVelocidad;
	private JLabel labelMinutos;
	private JLabel labelCanales;
	private JLabel lblNewLabel_5;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarPlan dialog = new RegistrarPlan(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarPlan(Plan plan) {
		auxPlan = plan;
		if(auxPlan == null){
			setTitle("Registrar Plan");
		}else {
			setTitle("Modificar Plan");
		}
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 545, 391);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInfo.setBounds(10, 10, 510, 135);
		contentPanel.add(panelInfo);
		panelInfo.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Precio Inicial:");
			lblNewLabel.setBounds(12, 63, 87, 16);
			panelInfo.add(lblNewLabel);
		}
		
		txtPrecioInicial = new JTextField();
		txtPrecioInicial.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE) && (c != '.' || txtPrecioInicial.getText().contains("."))) {
					e.consume();
				}
			}
		});
		txtPrecioInicial.setBounds(121, 60, 200, 23);
		if(auxPlan != null) {
			txtPrecioInicial.setText(String.valueOf(auxPlan.getPrecioInicial()));;
		}
		
		panelInfo.add(txtPrecioInicial);
		txtPrecioInicial.setColumns(10);
		{
			JLabel lblNewLabel_1 = new JLabel("Precio Mensual:");
			lblNewLabel_1.setBounds(12, 92, 102, 16);
			panelInfo.add(lblNewLabel_1);
		}
		{
			txtPrecioMensual = new JTextField();
			txtPrecioMensual.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE) && (c != '.' || txtPrecioMensual.getText().contains("."))) {
						e.consume();
					}
				}
			});
			txtPrecioMensual.setBounds(121, 89, 200, 23);
			if(auxPlan != null) {
				txtPrecioMensual.setText(String.valueOf(auxPlan.getPrecioMensual()));;
			}
			panelInfo.add(txtPrecioMensual);
			txtPrecioMensual.setColumns(10);
		}
		
		labelPrecioIni = new JLabel("*");
		labelPrecioIni.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelPrecioIni.setVisible(false);
		labelPrecioIni.setForeground(Color.RED);
		labelPrecioIni.setBounds(324, 63, 56, 16);
		panelInfo.add(labelPrecioIni);
		
		labelPrecioM = new JLabel("*");
		labelPrecioM.setForeground(Color.RED);
		labelPrecioM.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelPrecioM.setVisible(false);
		labelPrecioM.setBounds(324, 92, 56, 16);
		panelInfo.add(labelPrecioM);
		
		lblNewLabel_5 = new JLabel("Codigo:");
		lblNewLabel_5.setBounds(12, 34, 56, 16);
		panelInfo.add(lblNewLabel_5);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(121, 31, 200, 23);
		txtCodigo.setText("P-"+AlticeSystem.getInstance().getGeneradorCodigoPlan());
		panelInfo.add(txtCodigo);
		txtCodigo.setColumns(10);
		{
			JPanel panelTipo = new JPanel();
			panelTipo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Plan", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelTipo.setBounds(10, 150, 510, 70);
			contentPanel.add(panelTipo);
			panelTipo.setLayout(null);
			
			rdbTelefono = new JRadioButton("Telefono");
			rdbTelefono.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbInternet.setSelected(false);
					rdbCable.setSelected(false);
					panelTelefono.setVisible(true);
					panelInternet.setVisible(false);
					panelCable.setVisible(false);
				}
			});
			rdbTelefono.setBounds(204, 35, 91, 23);
			panelTipo.add(rdbTelefono);
			
			rdbInternet = new JRadioButton("Internet");
			rdbInternet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbTelefono.setSelected(false);
					rdbCable.setSelected(false);
					panelTelefono.setVisible(false);
					panelInternet.setVisible(true);
					panelCable.setVisible(false);
				}
			});
			rdbInternet.setSelected(true);
			rdbInternet.setBounds(80, 35, 105, 23);
			panelTipo.add(rdbInternet);
			
			rdbCable = new JRadioButton("Cable");
			rdbCable.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbTelefono.setSelected(false);
					rdbInternet.setSelected(false);
					panelTelefono.setVisible(false);
					panelInternet.setVisible(false);
					panelCable.setVisible(true);
				}
			});
			rdbCable.setBounds(331, 35, 121, 23);
			panelTipo.add(rdbCable);
		}
		
		panelInternet = new JPanel();
		panelInternet.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInternet.setBounds(10, 226, 510, 70);
		contentPanel.add(panelInternet);
		panelInternet.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Velocidad:");
		lblNewLabel_2.setBounds(10, 25, 76, 16);
		panelInternet.add(lblNewLabel_2);
		
		txtVelocidad = new JTextField();
		txtVelocidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))) {
					e.consume();
				}
			}
		});
		txtVelocidad.setBounds(75, 22, 76, 23);
		if(auxPlan != null && auxPlan instanceof Internet) {
			txtVelocidad.setText(((Internet) auxPlan).getCantInternet());;
			txtVelocidad.setEditable(false);
		}
		panelInternet.add(txtVelocidad);
		txtVelocidad.setColumns(10);
		
		labelVelocidad = new JLabel("*");
		labelVelocidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelVelocidad.setVisible(false);
		labelVelocidad.setForeground(Color.RED);
		labelVelocidad.setBounds(152, 25, 56, 16);
		panelInternet.add(labelVelocidad);
		
		panelTelefono = new JPanel();
		panelTelefono.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTelefono.setBounds(10, 226, 510, 70);
		contentPanel.add(panelTelefono);
		panelTelefono.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Minutos:");
		lblNewLabel_3.setBounds(10, 25, 76, 16);
		panelTelefono.add(lblNewLabel_3);
		
		txtMinutos = new JTextField();
		txtMinutos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		txtMinutos.setBounds(75, 22, 76, 23);
		if(auxPlan != null && auxPlan instanceof Telefono) {
			txtMinutos.setText(((Telefono) auxPlan).getCantMinutos());;
			txtMinutos.setEditable(false);
		}
		panelTelefono.add(txtMinutos);
		txtMinutos.setColumns(10);
		
		labelMinutos = new JLabel("*");
		labelMinutos.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelMinutos.setVisible(false);
		labelMinutos.setForeground(Color.RED);
		labelMinutos.setBounds(152, 25, 56, 16);
		panelTelefono.add(labelMinutos);
		
		panelCable = new JPanel();
		panelCable.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCable.setBounds(10, 226, 510, 70);
		contentPanel.add(panelCable);
		panelCable.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Canales:");
		lblNewLabel_4.setBounds(10, 25, 76, 16);
		panelCable.add(lblNewLabel_4);
		
		txtCanales = new JTextField();
		txtCanales.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
		txtCanales.setBounds(75, 22, 76, 23);
		if(auxPlan != null && auxPlan instanceof Cable) {
			txtCanales.setText(((Cable) auxPlan).getCantCanales());;
			txtCanales.setEditable(false);
		}
		panelCable.add(txtCanales);
		txtCanales.setColumns(10);
		
		labelCanales = new JLabel("*");
		labelCanales.setForeground(Color.RED);
		labelCanales.setVisible(false);
		labelCanales.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelCanales.setBounds(152, 25, 56, 16);
		panelCable.add(labelCanales);
		
		if(auxPlan instanceof Internet) {
			rdbInternet.setSelected(true);
			rdbTelefono.setEnabled(false);
			rdbCable.setEnabled(false);
			panelCable.setVisible(false);
			panelInternet.setVisible(true);
			panelTelefono.setVisible(false);
		}
		if(auxPlan instanceof Telefono) {
			rdbTelefono.setSelected(true);
			rdbInternet.setEnabled(false);
			rdbCable.setEnabled(false);
			panelCable.setVisible(false);
			panelInternet.setVisible(false);
			panelTelefono.setVisible(true);
		}
		if(auxPlan instanceof Cable) {
			rdbCable.setSelected(true);
			rdbInternet.setEnabled(false);
			rdbTelefono.setEnabled(false);
			panelCable.setVisible(true);
			panelInternet.setVisible(false);
			panelTelefono.setVisible(false);
		}
		if(auxPlan == null) {
			rdbInternet.setSelected(true);
			panelInternet.setVisible(true);
			panelCable.setVisible(false);
			panelTelefono.setVisible(false);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				if(auxPlan != null) {
					btnRegistrar.setText("Modificar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(auxPlan == null) {
							if(validarCampos()) {
								JOptionPane.showConfirmDialog(null, "Por favor llenar los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
							}
							else {
								Plan p1 = null;
								String id = txtCodigo.getText();
								float precioIni = Float.valueOf(txtPrecioInicial.getText());
								float precioM = Float.valueOf(txtPrecioMensual.getText());
								
								if(rdbInternet.isSelected()) {
									p1 = new Internet(id, "Internet", precioIni, precioM, txtVelocidad.getText());
								}
								if(rdbCable.isSelected()) {
									p1 = new Cable(id, "Cable", precioIni, precioM, txtCanales.getText());
								}
								AlticeSystem.getInstance().insertarPlan(p1);
								JOptionPane.showMessageDialog(null, "Registro Exitoso", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								clean();
							}
						}
						else {
						   auxPlan.setPrecioInicial(Float.valueOf(txtPrecioInicial.getText()));
						   auxPlan.setPrecioMensual(Float.valueOf(txtPrecioMensual.getText()));
						   if(auxPlan instanceof Internet) {
					          ((Internet) auxPlan).setCantInternet((txtVelocidad.getText()));
						   }
						   if(auxPlan instanceof Telefono) {
						      ((Telefono) auxPlan).setCantMinutos((txtMinutos.getText()));
						   }
						   if(auxPlan instanceof Cable) {
						      ((Cable) auxPlan).setCantCanales((txtCanales.getText()));
						   }
						   AlticeSystem.getInstance().modificarPlan(auxPlan);
						   dispose();
					    }
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
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
	    txtPrecioInicial.setText("");
		txtPrecioMensual.setText("");
		txtVelocidad.setText("");
		txtMinutos.setText("");
		txtCanales.setText("");
		txtCodigo.setText("P-"+AlticeSystem.getInstance().getGeneradorCodigoPlan());
	}
	
	private boolean validarCampos(){
		boolean validar = false;
		
		if(txtPrecioInicial.getText().trim().isEmpty()) {
			labelPrecioIni.setVisible(true);
			validar = true;
		}
		else {
			labelPrecioIni.setVisible(false);
		}
		
		if(txtPrecioMensual.getText().trim().isEmpty()) {
			labelPrecioM.setVisible(true);
			validar = true;
		}
		else {
			labelPrecioM.setVisible(false);
		}
		
		if(rdbInternet.isSelected() && txtVelocidad.getText().trim().isEmpty()) {
			labelVelocidad.setVisible(true);
			validar = true;
		}
		else {
			labelVelocidad.setVisible(false);
		}
		
		if(rdbTelefono.isSelected() && txtMinutos.getText().trim().isEmpty()) {
			labelMinutos.setVisible(true);
			validar = true;
		}
		else {
			labelMinutos.setVisible(false);
		}
		
		if(rdbCable.isSelected() && txtCanales.getText().trim().isEmpty()) {
			labelCanales.setVisible(true);
			validar = true;
		}
		else {
			labelCanales.setVisible(false);
		}
		return validar;
	}
}
