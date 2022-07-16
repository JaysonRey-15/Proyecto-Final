package logico;

import java.util.ArrayList;

public class P_Trabajador extends PersonaAutorizado{
	private ArrayList<String> actividades;
	private int puntosGanados;
	
	public P_Trabajador(String identificacion, String nombre, String apellido, String genero, String nacionalidad,
			String correE, String direccion, String telefono, String cargo, String tarea, String status,
			String fechaEntrada, String horararioDeTrabajo) {
		super(identificacion, nombre, apellido, genero, nacionalidad, correE, direccion, telefono, cargo, tarea, status,
				fechaEntrada, horararioDeTrabajo);
		this.actividades = new ArrayList<String>();
		this.puntosGanados = 0;
		
	}

	public ArrayList<String> getActividades() {
		return actividades;
	}

	public int getPuntosGanados() {
		return puntosGanados;
	}
	
	@Override
	public float calSalario() {
		return (salario*cantHorasTXmes)+puntosGanados;
	}
	
}
