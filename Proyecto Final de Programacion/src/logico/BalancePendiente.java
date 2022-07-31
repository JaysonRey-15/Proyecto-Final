package logico;

import java.io.Serializable;
import java.sql.Date;

public class BalancePendiente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String detalle;
	private float blcePendiente;
	private Date fechaVencido;
	
	public BalancePendiente(String detalle, float blcePendiente, Date fechaVencido) {
		super();
		this.detalle = detalle;
		this.blcePendiente = blcePendiente;
		this.fechaVencido = fechaVencido;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Date getFechaVencido() {
		return fechaVencido;
	}

	public void setFechaVencido(Date fechaVencido) {
		this.fechaVencido = fechaVencido;
	}

	public float getBlcePendiente() {
		return blcePendiente;
	}
	
	
}
