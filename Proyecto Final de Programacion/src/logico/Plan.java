package logico;

import java.util.ArrayList;

public abstract class Plan {

	private String nombre;
	private String tipo;
	private String fecha;
	private ArrayList <Servicio> misServicios;
	
	public Plan(String nombre, String tipo, String fecha) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.fecha = fecha;
		misServicios = new ArrayList<Servicio>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Servicio> getMisServicios() {
		return misServicios;
	}

	public void setMisServicios(ArrayList<Servicio> misServicios) {
		this.misServicios = misServicios;
	}
	
	public void insertarServicio(Servicio auxServicio) {
		misServicios.add(auxServicio);
	}
	
}
