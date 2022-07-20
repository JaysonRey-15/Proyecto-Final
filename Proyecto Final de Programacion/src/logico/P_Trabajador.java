package logico;

import java.util.ArrayList;

public class P_Trabajador extends Persona{
	private ArrayList<String> actividades;
	private Cuenta cuenta;
	private int puntosGanados;
	private float salario;
	private int cantHorasTXmes;
	
	
	public P_Trabajador(String identificacion, String nombre, String apellido, String genero, String nacionalidad,
			String correE, String direccion, String telefono) {
		super(identificacion, nombre, apellido, genero, nacionalidad,direccion, telefono);
		this.actividades = new ArrayList<String>();
		this.puntosGanados = 0;
		this.cuenta = null;
	}

	public ArrayList<String> getActividades() {
		return actividades;
	}

	public int getPuntosGanados() {
		return puntosGanados;
	}
	
	

	public Cuenta getCuenta() {
		return cuenta;
	}

	public float calSalario() {
		return (salario*cantHorasTXmes)+puntosGanados;
	}
	
	public void addCuenta(Cuenta cuentaAsignada) {
		cuenta = cuentaAsignada;
	}
	
}
