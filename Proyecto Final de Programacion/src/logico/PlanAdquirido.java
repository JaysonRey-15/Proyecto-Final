package logico;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;


public class PlanAdquirido implements Serializable{

	private static final long serialVersionUID = 1L;
	private String cedulaCliente;
	private String numCliente;
	private ArrayList<Plan> misPlanes;
	private Date fecha;
	private float pagoInicial;
	private float pagoMensual;
	private boolean pagoPendiente;
	private String switch1;
	private String codigo;
	
	public PlanAdquirido(String cedulaCliente, String numCliente, Date fecha, float pagoInicial, float pagoMensual, String codigo,
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
		this.codigo = codigo;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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
	
	public String getCodigo() {
		return codigo;
	}

	public void insertarPlan(Plan auxPlan) {
		auxPlan.cantVentas = auxPlan.cantVentas + 1;
		misPlanes.add(auxPlan);
	}
}
