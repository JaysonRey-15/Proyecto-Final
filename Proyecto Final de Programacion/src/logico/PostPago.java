package logico;

import java.util.Date;

public class PostPago extends Planes {
	
	private float rentaMensual;
	private Date tiempo;
	private String minutos;
	private String internet;
	
	public PostPago(String nombre, String tipo, Date fecha, float rentaMensual, Date tiempo, String minutos,
			String internet) {
		super(nombre, tipo, fecha);
		this.rentaMensual = rentaMensual;
		this.tiempo = tiempo;
		this.minutos = minutos;
		this.internet = internet;
	}

	public float getRentaMensual() {
		return rentaMensual;
	}

	public void setRentaMensual(float rentaMensual) {
		this.rentaMensual = rentaMensual;
	}

	public Date getTiempo() {
		return tiempo;
	}

	public void setTiempo(Date tiempo) {
		this.tiempo = tiempo;
	}

	public String getMinutos() {
		return minutos;
	}

	public void setMinutos(String minutos) {
		this.minutos = minutos;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}
}
