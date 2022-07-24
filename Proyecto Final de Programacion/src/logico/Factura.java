package logico;

import java.util.ArrayList;

public class Factura {

	private String cedulaCliente;
	private ArrayList<Plan> misPlanes;
	private String fecha;
	private String codigo;
	private float pago;
	
	public Factura(String cedulaCliente, String fecha, String codigo, float pago) {
		super();
		this.cedulaCliente = cedulaCliente;
		this.fecha = fecha;
		this.codigo = codigo;
		this.pago = pago;
		misPlanes = new ArrayList<Plan>();
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
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

	public float getPago() {
		return pago;
	}

	public void setPago(float pago) {
		this.pago = pago;
	}
	
	public void insertarPlan(Plan auxPlan) {
		misPlanes.add(auxPlan);
	}
}
