package logico;

import java.util.ArrayList;

public class P_Trabajador extends Persona{
	private ArrayList<String> actividades;
	private int puntosGanados;
	private float salario;
	private int cantHorasTXmes;
	private String password;
	
	
	public P_Trabajador(String identificacion, String nombre, String apellido, String genero, String nacionalidad,
			String correE, String direccion, String telefono,String passwrd) {
		super(identificacion, nombre, apellido, genero, nacionalidad, correE, direccion, telefono,passwrd);
		this.actividades = new ArrayList<String>();
		this.puntosGanados = 0;
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
	
}
