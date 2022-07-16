package logico;

import java.util.ArrayList;

public class Cliente extends Persona {
	//arrayList tipo Plan
	//arrayList tipo Servicio
	private ArrayList<String> misPlanes;
	private ArrayList<String> misServicios;
	

	public Cliente(String identificacion, String nombre, String apellido, String genero, String nacionalidad,
			String correE, String direccion, String telefono) {
		super(identificacion, nombre, apellido, genero, nacionalidad, correE, direccion, telefono);
	
		this.misServicios = new ArrayList<String>();
		this.misPlanes = new ArrayList<String>();
		
	}

	public ArrayList<String> getMisPlanes() {
		return misPlanes;
	}

	public ArrayList<String> getMisServicios() {
		return misServicios;
	}
	
	
	

}
