package logico;

import java.util.ArrayList;

public class PlanAdquirido {

	private String cedulaCliente;
	private String numCliente;
	private ArrayList<Plan> misPlanes;
	private String fecha;
	private float pagoInicial;
	private float pagoMensual;
	private boolean pagoPendiente;
	private String switch1;
	public PlanAdquirido(String cedulaCliente, String numCliente, String fecha, float pagoInicial, float pagoMensual,
			boolean pagoPendiente) {
		super();
		this.cedulaCliente = cedulaCliente;
		this.numCliente = numCliente;
		this.fecha = fecha;
		this.pagoInicial = pagoInicial;
		this.pagoMensual = pagoMensual;
		this.pagoPendiente = pagoPendiente;
		this.misPlanes = new ArrayList<Plan>();
		this.switch1 = "Activado";
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}


	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public void setMisPlanes(ArrayList<Plan> misPlanes) {
		this.misPlanes = misPlanes;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getPagoInicial() {
		return pagoInicial;
	}

	public void setPagoInicial(float pagoInicial) {
		this.pagoInicial = pagoInicial;
	}
	
	public float getpagoMensual() {
		return pagoMensual;
	}

	public void setpagoMensual(float pagoMensual) {
		this.pagoMensual = pagoMensual;
	}

	public boolean isPagoPendiente() {
		return pagoPendiente;
	}

	public void setPagoPendiente(boolean pagoPendiente) {
		this.pagoPendiente = pagoPendiente;
	}

	
	public String getSwitch1() {
		return switch1;
	}

	public void insertarPlan(Plan auxPlan) {
		misPlanes.add(auxPlan);
	}
}
