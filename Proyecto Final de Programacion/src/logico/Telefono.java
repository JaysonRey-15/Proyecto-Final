package logico;

public class Telefono extends Plan {

	private String cantMinutos;

	public Telefono(String codigo, String tipo, float precioInicial, float precioMensual, String cantMinutos) {
		super(codigo, tipo, precioInicial, precioMensual);
		this.cantMinutos = cantMinutos;
	}

	public String getCantMinutos() {
		return cantMinutos;
	}

	public void setCantMinutos(String cantMinutos) {
		this.cantMinutos = cantMinutos;
	}
}
