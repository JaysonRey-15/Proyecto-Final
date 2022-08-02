package logico;

import java.sql.Date;

public class Reporte {
	
	private Date fecha;
	private String codigoReporte;
	private Persona persona;
	
	public Reporte(Date fecha, String codigoReporte, Persona persona) {
		super();
		this.fecha = fecha;
		this.codigoReporte = codigoReporte;
		this.persona = persona;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getCodigoReporte() {
		return codigoReporte;
	}

	public Persona getPersona() {
		return persona;
	}
	

}
