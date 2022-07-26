package logico;

import java.util.ArrayList;

public class P_Administrador extends Persona{
	
	private static final long serialVersionUID = 1L;
	private float salario;
	private int cantHorasXmes;
	private ArrayList<String> actividades;
	private int puntosGanados;
	private Cuenta miCuenta;
	
	public P_Administrador(String cedula, String nombre, String genero, String nacionalidad, String direccion,
			String telefono, String codigoUsuario, String tipo, Cuenta miCuenta) {
		super(cedula, nombre, genero, nacionalidad, direccion, telefono, codigoUsuario, tipo);
		this.miCuenta = miCuenta;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public int getCantHorasXmes() {
		return cantHorasXmes;
	}

	public void setCantHorasXmes(int cantHorasXmes) {
		this.cantHorasXmes = cantHorasXmes;
	}

	public ArrayList<String> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<String> actividades) {
		this.actividades = actividades;
	}

	public int getPuntosGanados() {
		return puntosGanados;
	}

	public void setPuntosGanados(int puntosGanados) {
		this.puntosGanados = puntosGanados;
	}

	public Cuenta getMiCuenta() {
		return miCuenta;
	}

	public void setMiCuenta(Cuenta miCuenta) {
		this.miCuenta = miCuenta;
	}
	
	public float calSalario() {
		return (salario*cantHorasXmes)+puntosGanados;
	}
}
