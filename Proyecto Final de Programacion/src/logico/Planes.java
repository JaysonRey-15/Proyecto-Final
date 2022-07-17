package logico;

import java.util.Date;

public abstract class Planes {

	protected String nombre;
	protected String tipo;
	protected Date fecha;
	
	public Planes(String nombre, String tipo, Date fecha) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.fecha = fecha;
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
}
