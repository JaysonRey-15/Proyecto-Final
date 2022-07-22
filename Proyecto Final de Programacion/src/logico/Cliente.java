package logico;

import java.util.ArrayList;

public class Cliente extends Persona {
	
	private ArrayList<Plan> misPlanes;
	private ArrayList<Servicio> misServicios;

	public Cliente(String identificacion, String nombre, String apellido, String genero, String nacionalidad,String direccion, String telefono) {
		super(identificacion, nombre, apellido, genero, nacionalidad, direccion, telefono);
	
		this.misServicios = new ArrayList<Servicio>();
		this.misPlanes = new ArrayList<Plan>();
		
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public ArrayList<Servicio> getMisServicios() {
		return misServicios;
	}

	
	
	
	

}
