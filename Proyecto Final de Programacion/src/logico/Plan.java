package logico;

public abstract class Plan {

	protected String tipo;
	protected float precioInicial;
	protected float precioMensual;
	
	public Plan(String tipo , float precioInicial, float precioMensual) {
		super();
		this.tipo = tipo;
		this.precioInicial = precioInicial;
		this.precioMensual = precioMensual;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPrecioInicial() {
		return precioInicial;
	}

	public void setPrecioInicial(float precioInicial) {
		this.precioInicial = precioInicial;
	}

	public float getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(float precioMensual) {
		this.precioMensual = precioMensual;
	}
}
