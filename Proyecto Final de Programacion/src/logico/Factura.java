package logico;

import java.io.Serializable;
import java.sql.Date;

public class Factura implements Serializable{
	
   private static final long serialVersionUID = 1L;
   private Cliente cliente;
   private PlanAdquirido miPlanAd;
   private Date fechaGen;
   private Date fechaPagado;
   private String codigo;
   private boolean estado;
   private float pago;
   
   public Factura(Cliente cliente, Date date, String codigo, float pago) {
	super();
      this.cliente = cliente;
	  this.fechaGen = date;
	  this.fechaPagado = null;
	  this.codigo = codigo;
	  this.pago = pago;
	  this.miPlanAd = null;
	  this.estado = false;
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
		return fechaGen;
	}
	
	public void setFecha(Date fecha) {
		this.fechaGen = fecha;
	}
	
	public Date getFechaPago() {
		return fechaPagado;
	}
	
	public void setFechaPago(Date fechaPago) {
		this.fechaPagado = fechaPago;
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
	
	public Date getFechaGen() {
		return fechaGen;
	}

	public Date getFechaPagado() {
		return fechaPagado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setPago(float pago) {
		this.pago = pago;
	} 
}