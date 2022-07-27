package logico;

import java.util.ArrayList;

public class Cliente extends Persona {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Plan> misPlanes;
	private ArrayList <Factura> misFacturas;
	private ArrayList<Object> PPendientes;
	
	public Cliente(String cedula, String nombre,String apellido, String genero, String nacionalidad, String direccion, String telefono) {
		super(cedula, nombre, apellido,genero, nacionalidad, direccion, telefono);
		this.misPlanes = new ArrayList<Plan>();
		this.misFacturas = new ArrayList<Factura>();
		this.PPendientes = new ArrayList<Object>();
	}
	
	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}
	
	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}	
}
