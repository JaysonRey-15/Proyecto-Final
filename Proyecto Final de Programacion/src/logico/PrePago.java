package logico;

import java.util.Date;

public class PrePago extends Planes{
	
	private String recarga;
	private String paqueticos;
	private Float pago;
	
	public PrePago(String nombre, String tipo, Date fecha, String recarga, String paqueticos, Float pago) {
		super(nombre, tipo, fecha);
		this.recarga = recarga;
		this.paqueticos = paqueticos;
		this.pago = pago;
	}

	public String getRecarga() {
		return recarga;
	}

	public void setRecarga(String recarga) {
		this.recarga = recarga;
	}

	public String getPaqueticos() {
		return paqueticos;
	}

	public void setPaqueticos(String paqueticos) {
		this.paqueticos = paqueticos;
	}

	public Float getPago() {
		return pago;
	}

	public void setPago(Float pago) {
		this.pago = pago;
	}
	
	

}
