package logico;

import java.util.ArrayList;
import java.util.Date;

public abstract class Plan {

	private String nombre;
	private String tipo;
	private Date fecha;
	private ArrayList <Servicio> misServicios;
	
	public Plan(String nombre, String tipo, Date fecha, ArrayList<Servicio> misServicios) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.fecha = fecha;
		this.misServicios = misServicios;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Servicio> getMisServicios() {
		return misServicios;
	}

	public void setMisServicios(ArrayList<Servicio> misServicios) {
		this.misServicios = misServicios;
	}
}
