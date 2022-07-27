package logico;

import java.util.ArrayList;

public class Cliente extends Persona {
	
	private static final long serialVersionUID = 1L;
	private ArrayList <Factura> misFacturas;
	private PlanAdquirido miPlan;
	private ArrayList<Object> PPendientes;

	public Cliente(String cedula, String nombre, String apellido, String genero, String nacionalidad, String direccion,
			String telefono, String tipo, String codigoUsuario, PlanAdquirido miPlan) {
		super(cedula, nombre, apellido, genero, nacionalidad, direccion, telefono, tipo, codigoUsuario);
		this.miPlan = miPlan;
		this.misFacturas = new ArrayList<Factura>();
		this.PPendientes = new ArrayList<Object>();
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}	
	
	public PlanAdquirido getMiPlan() {
		return miPlan;
	}
}
