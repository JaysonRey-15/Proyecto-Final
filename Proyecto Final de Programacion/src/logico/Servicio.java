package logico;

public class Servicio {
    
	private String cable;
	private String telefono;
	private String internet;
	
	public Servicio(String cable, String telefono, String internet) {
		super();
		this.cable = cable;
		this.telefono = telefono;
		this.internet = internet;
	}

	public String getCable() {
		return cable;
	}

	public void setCable(String cable) {
		this.cable = cable;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}
}
