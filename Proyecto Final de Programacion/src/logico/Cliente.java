package logico;

import java.util.ArrayList;

public class Cliente extends Persona {
	//arrayList tipo Plan
	//arrayList tipo Servicio
	private ArrayList<Plan> misPlanes;
	private ArrayList<String> misServicios;
	

	public Cliente(String identificacion, String nombre, String apellido, String genero, String nacionalidad,
			String correE, String direccion, String telefono,String passwrd) {
		super(identificacion, nombre, apellido, genero, nacionalidad, correE, direccion, telefono,passwrd);
	
		this.misServicios = new ArrayList<String>();
		this.misPlanes = new ArrayList<Plan>();
		
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public ArrayList<String> getMisServicios() {
		return misServicios;
	}
	
	
	

}
