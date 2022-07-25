package logico;

public class Cable extends Plan {
	
	private String cantCanales;

	public Cable(String codigo, String tipo, float precioInicial, float precioMensual, String cantCanales) {
		super(codigo, tipo, precioInicial, precioMensual);
		this.cantCanales = cantCanales;
	}

	public String getCantCanales() {
		return cantCanales;
	}

	public void setCantCanales(String cantCanales) {
		this.cantCanales = cantCanales;
	}
}
