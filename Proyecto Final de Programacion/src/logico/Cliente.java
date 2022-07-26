package logico;

import java.util.ArrayList;

public class Cliente extends Persona {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Plan> misPlanes;
	private ArrayList <Factura> misFacturas;
	
	public Cliente(String cedula, String nombre, String genero, String nacionalidad, String direccion, String telefono,
			String codigoUsuario, String tipo) {
		super(cedula, nombre, genero, nacionalidad, direccion, telefono, codigoUsuario, tipo);
	}
	
	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}
	
	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}	
}
