package logico;

public class Internet extends Plan {

	private String cantInternet;

	public Internet(String codigo, String tipo, float precioInicial, float precioMensual, String cantInternet) {
		super(codigo, tipo, precioInicial, precioMensual);
		this.cantInternet = cantInternet;
	}

	public String getCantInternet() {
		return cantInternet;
	}

	public void setCantInternet(String cantInternet) {
		this.cantInternet = cantInternet;
	}
}
