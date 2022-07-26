package logico;

public class Plan {

	private String nombre;
	private String cantCanales;
	private String cantMinutos;
	private String cantInternet;
	private float precioInicial;
	private float precioMensual;
	
	public Plan(String nombre, String cantCanales, String cantMinutos, String cantInternet,
			float precioInicial, float precioMensual) {
		super();
		this.nombre = nombre;
		this.cantCanales = cantCanales;
		this.cantMinutos = cantMinutos;
		this.cantInternet = cantInternet;
		this.precioInicial = precioInicial;
		this.precioMensual = precioMensual;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCantCanales() {
		return cantCanales;
	}

	public void setCantCanales(String cantCanales) {
		this.cantCanales = cantCanales;
	}

	public String getCantMinutos() {
		return cantMinutos;
	}

	public void setCantMinutos(String cantMinutos) {
		this.cantMinutos = cantMinutos;
	}

	public String getCantInternet() {
		return cantInternet;
	}

	public void setCantInternet(String cantInternet) {
		this.cantInternet = cantInternet;
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
