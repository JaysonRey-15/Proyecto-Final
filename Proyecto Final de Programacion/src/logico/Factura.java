package logico;

import java.sql.Date;

public class Factura {
	
   private Cliente cliente;
   private PlanAdquirido miPlanAd;
   private Date fecha;
   private Date fechaPago;
   private String codigo;
   private float pago;
   
   public Factura(Cliente cliente, Date fecha, Date fechaPago, String codigo, float pago) {
	super();
      this.cliente = cliente;
	  this.fecha = fecha;
	  this.fechaPago = fechaPago;
	  this.codigo = codigo;
	  this.pago = pago;
	  miPlanAd = null;
   }

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public PlanAdquirido getMiPlanAd() {
		return miPlanAd;
	}
	
	public void setMiPlanAd(PlanAdquirido miPlanAd) {
		this.miPlanAd = miPlanAd;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Date getFechaPago() {
		return fechaPago;
	}
	
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
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
}