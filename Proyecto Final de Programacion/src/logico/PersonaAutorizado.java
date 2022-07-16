package logico;

import java.util.ArrayList;

public class PersonaAutorizado extends Persona {
	protected String cargo;
	protected ArrayList<String> tarea;
	protected String status;
	protected String fechaEntrada;
	protected String horararioDeTrabajo;
	protected float salario;
	protected int cantHorasTXmes;

	public PersonaAutorizado(String identificacion, String nombre, String apellido, String genero, String nacionalidad,
			String correE, String direccion, String telefono, String cargo, String tarea, String status,
			String fechaEntrada, String horararioDeTrabajo) {
		super(identificacion, nombre, apellido, genero, nacionalidad, correE, direccion, telefono);
		this.cargo = cargo;
		this.tarea = new ArrayList<String>();
		this.status = "Activado";
		this.fechaEntrada = fechaEntrada;
		this.horararioDeTrabajo = horararioDeTrabajo;
		this.salario = 0;
		this.cantHorasTXmes=0;
	}

	public ArrayList<String> getTarea() {
		return tarea;
	}

	public void setTarea(ArrayList<String> tarea) {
		this.tarea = tarea;
	}

	public String getCargo() {
		return cargo;
	}

	public String getStatus() {
		return status;
	}

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public String getHorararioDeTrabajo() {
		return horararioDeTrabajo;
	}

	public float getSalario() {
		return salario;
	}
	
	public float calSalario() {
		return salario*cantHorasTXmes;
	}
}
