package logico;

import java.util.ArrayList;

public class P_Administrador extends PersonaAutorizado {
	private float sueldoBruto;
	private ArrayList<String> actividades;
	private int puntosGanados;
	private int gradoPermiso; // 1 o 2
	//Pienso que puede haber varios administradores y debería haber uno de grado único, el cúal tiene privilegio sobre el administrado norrmal
//Por ejemplo, se necesitaria para registrar adminitradores y actualizar sueldos de ellos.

	public P_Administrador(String identificacion, String nombre, String apellido, String genero, String nacionalidad,
			String correE, String direccion, String telefono, String cargo, String tarea, String status,
			String fechaEntrada, String horararioDeTrabajo, float salario) {
		super(identificacion, nombre, apellido, genero, nacionalidad, correE, direccion, telefono, cargo, tarea, status,
				fechaEntrada, horararioDeTrabajo);
		
		this.actividades = new ArrayList<String>();
		this.puntosGanados=0;
		this.gradoPermiso = 1;
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


	@Override
	public float calSalario() {
		return (salario*cantHorasTXmes)+puntosGanados;
	}

}
