package logico;

import java.util.ArrayList;

public class Cliente extends Persona {
	
	private ArrayList<Plan> misPlanes;
	private ArrayList <Factura> misFacturas;

	public Cliente(String identificacion, String nombre, String apellido, String genero, String nacionalidad,String direccion, String telefono) {
		super(identificacion, nombre, apellido, genero, nacionalidad, direccion, telefono);
	
		this.misPlanes = new ArrayList<Plan>();
		this.misFacturas = new ArrayList<Factura>();
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}
	
	public ArrayList<Factura> getmisFacturas() {
		return misFacturas;
	}
	
	public void insertarFactura(Factura auxFactura) {
		misFacturas.add(auxFactura);
	}
	
	public void insertarPlan(Plan auxPlan) {
		misPlanes.add(auxPlan);
	}
}
