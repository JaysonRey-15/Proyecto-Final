package logico;

import java.util.ArrayList;

public class Cliente extends Persona {
	
	private static final long serialVersionUID = 1L;
	private ArrayList <Factura> misFacturas;
	private PlanAdquirido miPlan;
	private ArrayList<BalancePendiente> PPendientes;

	public Cliente(String cedula, String nombre, String apellido, String genero, String nacionalidad, String direccion,
			String telefono, String tipo, String codigoUsuario, PlanAdquirido miPlan) {
		super(cedula, nombre, apellido, genero, nacionalidad, direccion, telefono, tipo, codigoUsuario);
		this.miPlan = miPlan;
		this.misFacturas = new ArrayList<Factura>();
		this.PPendientes = new ArrayList<BalancePendiente>();
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}	
	
	public PlanAdquirido getMiPlan() {
		return miPlan;
	}

	public ArrayList<BalancePendiente> getPPendientes() {
		return PPendientes;
	}
	
	public void actualizarBalance(BalancePendiente nuevoBalance) {
		PPendientes.add(nuevoBalance);
	}
	
}
