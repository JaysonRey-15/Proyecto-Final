package logico;

import java.util.ArrayList;

public class P_Administrador extends Persona {
	private float sueldoBruto;
	private float salario;
	private int cantHorasTXmes;
	private ArrayList<String> actividades;
	private int puntosGanados;
	private int gradoPermiso; // 1 o 2

	public P_Administrador(String identificacion, String nombre, String apellido, String genero, String nacionalidad,
			String correE, String direccion, String telefono,String passwrd) {
		super(identificacion, nombre, apellido, genero, nacionalidad, correE, direccion, telefono,passwrd);
		
		this.actividades = new ArrayList<String>();
		this.puntosGanados=0;
		this.gradoPermiso = 1;
		this.cantHorasTXmes=0;
	}
	
	public float getSueldoBruto() {
		return sueldoBruto;
	}

	public ArrayList<String> getActividades() {
		return actividades;
	}

	public int getPuntosGanados() {
		return puntosGanados;
	}
	
	public String getPassword() {
		return password;
	}

	public float calSalario() {
		return (salario*cantHorasTXmes)+puntosGanados;
	}
	
	public int getGradoPermiso() {
		return gradoPermiso;
	}

}
