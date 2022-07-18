package logico;

public class Factura {

	private String cedulaCliente;
	private Plan miPlan;
	private String fecha;
	private String codigo;
	private float precio;
	
	public Factura(String cedulaCliente, Plan miPlan, String fecha, String codigo, float precio) {
		super();
		this.cedulaCliente = cedulaCliente;
		this.miPlan = miPlan;
		this.fecha = fecha;
		this.codigo = codigo;
		this.precio = precio;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public Plan getMiPlan() {
		return miPlan;
	}

	public void setMiPlan(Plan miPlan) {
		this.miPlan = miPlan;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
