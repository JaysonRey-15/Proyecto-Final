package logico;

import java.util.ArrayList;

public class Cliente extends Persona {
	
	private static final long serialVersionUID = 1L;
	private ArrayList <Factura> misFacturas;
	private PlanAdquirido miPlan;
	
	public Cliente(String cedula, String nombre, String genero, String nacionalidad, String direccion, String telefono,
			String codigoUsuario, String tipo, PlanAdquirido miPlan) {
		super(cedula, nombre, genero, nacionalidad, direccion, telefono, codigoUsuario, tipo);
		this.miPlan = miPlan;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}	
	
	public PlanAdquirido getMiPlan() {
		return miPlan;
	}
}
