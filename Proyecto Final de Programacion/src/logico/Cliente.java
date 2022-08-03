package logico;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	
	public void eliminarPlanAd(PlanAdquirido auxPlanAd) {
	    if(auxPlanAd != null) {
	      if(auxPlanAd.isPagoPendiente()) {
	         JOptionPane.showMessageDialog(null, "Favor completar el pago de su factura.");
	      }else {
	    	  misPlanesAd.remove(auxPlanAd); 
	      }
	    }
	}
	
	public void addFactura(Factura fac) {
		misFacturas.add(fac);
	}
	public void BalancePendienteAd(BalancePendiente newBalance) {
		PPendientes.add(newBalance);
	}
}