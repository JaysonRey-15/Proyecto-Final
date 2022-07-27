package logico;

import java.util.ArrayList;

public class Cliente extends Persona {
	
	private static final long serialVersionUID = 1L;
	private ArrayList <Factura> misFacturas;
	private ArrayList<PlanAdquirido> misPlanesAd;
	private ArrayList<BalancePendiente> PPendientes;

	public Cliente(String cedula, String nombre, String apellido, String genero, String nacionalidad, String direccion,
			String telefono, String tipo, String codigoUsuario) {
		super(cedula, nombre, apellido, genero, nacionalidad, direccion, telefono, tipo, codigoUsuario);
		this.misPlanesAd = new ArrayList<PlanAdquirido>();
		this.misFacturas = new ArrayList<Factura>();
		this.PPendientes = new ArrayList<BalancePendiente>();
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}	

	public ArrayList<PlanAdquirido> getmisPlanesAd() {
		return misPlanesAd;
	}
	
	public ArrayList<PlanAdquirido> getMisPlanesAd() {
		return misPlanesAd;
	}

	public ArrayList<BalancePendiente> getPPendientes() {
		return PPendientes;
	}
	
	public void actualizarBalance(BalancePendiente nuevoBalance) {
		PPendientes.add(nuevoBalance);
	}
	
	public void insertarPlanAd(PlanAdquirido auxPlanAd) {
		misPlanesAd.add(auxPlanAd);
	}
}
