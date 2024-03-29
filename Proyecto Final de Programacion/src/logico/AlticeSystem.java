package logico;

import java.awt.Component;
import java.io.Serializable;
import java.security.KeyStore.PasswordProtection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import Visual.ReportePlan;

public class AlticeSystem implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final Component PasswordProtection =null;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Persona> misPersonas;
	private ArrayList<Cuenta> misCuentas;
	private ArrayList<PlanAdquirido> misPlanesAd;
	private int generadorCodigoPlanAd = 1;
	public static AlticeSystem ALS = null;
	private int genFac;
	public static Persona loginUser=null;

	ZoneId defaultZoneId = ZoneId.systemDefault();

	
	public AlticeSystem() {
		super();
		this.misPlanes = new ArrayList<Plan>();
		this.misPlanesAd = new ArrayList<PlanAdquirido>();
		this.misFacturas = new ArrayList<Factura>();
		this.misPersonas = new ArrayList<Persona>();
		this.misCuentas = new ArrayList<Cuenta>();
		this.genFac = 1;
	}

	public static AlticeSystem getInstance(){
		if(ALS==null){
			ALS= new AlticeSystem();	
		}
		return ALS;
	}

	public static void setAltice(AlticeSystem altice) {
		AlticeSystem.ALS = altice;
	}

	public static Persona getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(Persona loginUser) {
		AlticeSystem.loginUser = loginUser;
	}

	public boolean confirmarLogin(String usuario, String password) {
		boolean validar = false;
		for (Persona per : misPersonas) {
			if(per instanceof P_Administrador) {
				if (((P_Administrador) per).getCuenta().getUsuario().equalsIgnoreCase(usuario) && ((P_Administrador) per).getCuenta().getPassword().equalsIgnoreCase(password)) {
					setLoginUser(per);
					validar = true;
				}
			}
			if(per instanceof P_Trabajador) {
				if (((P_Trabajador) per).getCuenta().getUsuario().equalsIgnoreCase(usuario) && ((P_Trabajador) per).getCuenta().getPassword().equalsIgnoreCase(password)) {
					setLoginUser(per);
					validar = true;
				}
			}
		}
		return validar;
	}

	public int getGeneradorCodigoPlanAd() {
		return generadorCodigoPlanAd;
	}

	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public ArrayList<PlanAdquirido> getmisPlanesAd() {
		return misPlanesAd;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public void insertarPlan(Plan auxPlan) {
		misPlanes.add(auxPlan);
	}

	public void insertarPlanAd(PlanAdquirido auxPlanAd) {
		misPlanesAd.add(auxPlanAd);
		generadorCodigoPlanAd++;
	}



	public void insertarPersona(Persona auxPersona) {
		misPersonas.add(auxPersona);
	}

	public void modificarPlan(Plan auxPlan) {
		int ind = buscarIndexByNomb(auxPlan.getNombre());
		if(ind != -1) {
			misPlanes.get(ind).setNombre(auxPlan.getNombre());
			misPlanes.get(ind).setPrecioInicial(auxPlan.getPrecioInicial());
			misPlanes.get(ind).setPrecioMensual(auxPlan.getPrecioMensual());
		}
	}

	public PlanAdquirido buscarPlanEnCliente(Persona cli,String code) {
		PlanAdquirido aux = null; 
		boolean encontrado = false;
		int ind = 0;
		if(cli instanceof Cliente) {
			while(!encontrado && ind < ((Cliente) cli).getMisPlanesAd().size()) {
				if(((Cliente) cli).getMisPlanesAd().get(ind).getCodigo().equalsIgnoreCase(code)) {
					encontrado = true;
					aux=((Cliente) cli).getMisPlanesAd().get(ind);
				}
			}
		}
		return aux;
	}

	public Plan buscarPlanByNomb(String nombre) {
		Plan plan = null;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < misPlanes.size()) {
			if(misPlanes.get(i).getNombre().equalsIgnoreCase(nombre)) {
				encontrado=true;
				plan = misPlanes.get(i);
			}
			i++;
		}
		return plan;
	}

	private int buscarIndexByNomb(String nombre) {
		int ind = -1;
		int i = 0;
		boolean encontrado = false;
		while (i < misPlanes.size() && !encontrado) {
			if (misPlanes.get(i).getNombre().equalsIgnoreCase(nombre)) {
				encontrado = true;
				ind = i;
			}
			i++;
		}
		return ind;
	}

	private int buscarIndexFactura(Cliente cli, String codigo) {
		int ind = -1;
		int i = 0;
		boolean encontrado = false;
		while (i < cli.getMisFacturas().size() && !encontrado) {
			if (cli.getMisFacturas().get(i).getCodigo().equalsIgnoreCase(codigo)) {
				encontrado = true;
				ind = i;
			}
			i++;
		}
		return ind;
	}
	
	public boolean PersonaExiste(String Persona, Persona aux) {
		int i = 0;
		boolean encontrado = false;
		while (!encontrado && i < misPersonas.size()) {
			if(aux != null && aux instanceof P_Administrador) {
				if(Persona.equals(((P_Administrador) aux).getCuenta().getUsuario())) {
					return false;
				}
			}
			else if(aux != null && aux instanceof P_Trabajador) {
				if(Persona.equals(((P_Trabajador) aux).getCuenta().getUsuario())) {
					return false;
				}
			}
			if (misPersonas.get(i) instanceof P_Administrador) {
				if(((P_Administrador) misPersonas.get(i)).getCuenta().getUsuario().equalsIgnoreCase(Persona)) {
					encontrado = true;	
				}
			}
			else if (misPersonas.get(i) instanceof P_Trabajador) {
				if(((P_Trabajador) misPersonas.get(i)).getCuenta().getUsuario().equalsIgnoreCase(Persona)) {
					encontrado = true;	
				}
			}
			i++;
		}
		return encontrado;
	}

	public void modificarPersona(Persona auxPersona, Cuenta cuenta) {
		Persona Persona = buscarPersonaByCedula(auxPersona.getCedula());
		if(Persona != null && auxPersona instanceof P_Administrador) {
			Persona.setTelefono(auxPersona.getTelefono());
			Persona.setNombre(auxPersona.getNombre());
			Persona.setApellido(auxPersona.getApellido());
			Persona.setNacionalidad(auxPersona.getNacionalidad());
			Persona.setDireccion(auxPersona.getDireccion());
			((P_Administrador) Persona).addCuenta(cuenta);
		}
		if(Persona != null && auxPersona instanceof P_Trabajador) {
			Persona.setTelefono(auxPersona.getTelefono());
			Persona.setNombre(auxPersona.getNombre());
			Persona.setApellido(auxPersona.getApellido());
			Persona.setNacionalidad(auxPersona.getNacionalidad());
			Persona.setDireccion(auxPersona.getDireccion());
			((P_Trabajador) Persona).addCuenta(cuenta);
		}
	}


	public void pagarFac(Cliente cli, Factura fac) {
		int ind = buscarIndexFactura(cli, fac.getCodigo());
		if(fac!=null) { 
			String contrasenia =JOptionPane.showInputDialog(PasswordProtection,"Favor confirmar su Contrase�a");
			if(((P_Administrador)loginUser).getCuenta().getPassword().equals(contrasenia)) {
				if(fac.getMiPlanAd().isPIniPend()) {
					fac.getMiPlanAd().setPIniPend(false);
				}
				fac.setEstado("Pagada");
				cli.getMisFacturas().get(ind).setEstado("Pagada");
				fac.getMiPlanAd().setPagoPendiente(true);
				JOptionPane.showMessageDialog(null, "Factura Pagada");
			}else {
				JOptionPane.showMessageDialog(null, "Contrase�a incorrecta, intente de nuevo.");
			}
		}
	}


	public void eliminarPersona(Persona auxPersona) {
		if(auxPersona != null) {
			if(auxPersona instanceof Cliente) {
				if(((Cliente)auxPersona).getMisPlanesAd().size()>0) {
					JOptionPane.showMessageDialog(null, "No se puede eliminar clientes con planes activado.", "Error!", JOptionPane.ERROR_MESSAGE);
				}else {
					String contrasenia =JOptionPane.showInputDialog(PasswordProtection,"Favor confirmar su Contrase�a");
					if(((P_Administrador)loginUser).getCuenta().getPassword().equals(contrasenia)) {
						misPersonas.remove(auxPersona);
					}else {
						JOptionPane.showMessageDialog(null, "Contrase�a incorrecta, intente de nuevo.");
					}
				}

			}else {
				String contrasenia =JOptionPane.showInputDialog(PasswordProtection,"Favor confirmar su Contrase�a");
				if(((P_Administrador)loginUser).getCuenta().getPassword().equals(contrasenia)) {
					misPersonas.remove(auxPersona);
				}else {
					JOptionPane.showMessageDialog(null, "Contrase�a incorrecta, intente de nuevo.");
				}
			}
		}
	}

	public void addUser(String cedula,Cuenta cuenta) {
		Persona aux = buscarPersonaByCedula(cedula);

		if(aux!=null && cuenta!=null) {
			if(aux instanceof P_Administrador) {
				P_Administrador admi = (P_Administrador)aux;
				misCuentas.add(cuenta);
				admi.addCuenta(cuenta);
			}else 
				if(aux instanceof P_Trabajador) {
					P_Trabajador tra = (P_Trabajador)aux;
					misCuentas.add(cuenta);
					tra.addCuenta(cuenta);
				}
		}

	}

	public Persona buscarPersonaByCedula(String cedula) {
		Persona persona = null;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < misPersonas.size()) {
			if(misPersonas.get(i).getCedula().equalsIgnoreCase(cedula)) {
				encontrado=true;
				persona = misPersonas.get(i);
			}
			i++;
		}
		return persona;
	}

	public Persona filtroG(String filtro) {
		Persona aux = null;

		for(Persona per: misPersonas) {
			if(per.getCedula().equalsIgnoreCase(filtro) || per.getNombre().equalsIgnoreCase(filtro) || per.getTelefono().equalsIgnoreCase(filtro)) {
				aux=per;
			}
		}

		if(aux==null)
			JOptionPane.showMessageDialog(null,"Usuario no encontrado");

		return aux;
	}


	public String tipoP(Persona person) {
		String tipo =null;

		if(person instanceof P_Administrador) 
			tipo = "Administrador";


		if(person instanceof P_Trabajador) 
			tipo = "Trabajador";


		if(person instanceof Cliente)
			tipo = "Cliente";
		return tipo;
	}

	public void eliminarPlanAd(PlanAdquirido auxPlanAd, Persona auxCliente) {
		if(auxPlanAd != null && auxCliente != null) {

			if(auxCliente instanceof Cliente && ((Cliente) auxCliente).getMisPlanesAd().size() > 0) {
				if(!auxPlanAd.isPagoPendiente()) {
					int resp = JOptionPane.showConfirmDialog(null, "�Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
					if(resp!=1) { 
						((Cliente) auxCliente).getMisPlanesAd().remove(auxPlanAd);
						JOptionPane.showMessageDialog(null, "Plan "+ auxPlanAd.getCodigo()+ " ha sido eliminado correctamente");
					}else {
						
					}
				}else {
					JOptionPane.showMessageDialog(null,"Favor completar pago pendiente para continuar.");
				}
			}
			else if(auxCliente instanceof Cliente && ((Cliente) auxCliente).getMisPlanesAd().size()==1) {
				misPersonas.remove(auxCliente);
			}
		}
	}

	//Se va a generar las facturas cada 27 de cada mes
	public void generarFacturaPorFecha() {
		Calendar fecha = new GregorianCalendar();
		if(fecha.get(Calendar.DAY_OF_MONTH)==5) {
			for(Persona per: misPersonas) {
				if(per instanceof Cliente) {
					addFactura((Cliente)per);
				}
			}
		}
	}

	public Factura buscarFac(String code) {
		Factura aux = null;
		int ind=0;
		boolean encontrado = false;

		while(ind<misFacturas.size() && !encontrado) {
			if(misFacturas.get(ind).getCodigo().equalsIgnoreCase(code)) {
				aux = misFacturas.get(ind);
				encontrado = true;
			}
			ind++;
		}
		return aux;
	}
	
	
	public void addFactura(Cliente cli) {
		int ind;
		LocalDate localDate = LocalDate.now();

		for(ind=0; ind<cli.getMisPlanesAd().size(); ind++) {
			if(!cli.getMisPlanesAd().get(ind).isFacGen()) {
				Factura fact = new Factura(cli, localDate,"F-"+genFac,cli.getMisPlanesAd().get(ind).total(),cli.getMisPlanesAd().get(ind));
				fact.setEstado("Pendiente");
				cli.addFactura(fact);
				misFacturas.add(fact);
				fact.getMiPlanAd().setFacGen(true);
				fact.getMiPlanAd().setPagoPendiente(true);
				genFac++;
			}
		}
	}
	
	public static long diasEntreDosFechas(Date fechaDesde, Date fechaHasta){
		long startTime = fechaDesde.getTime() ;
		long endTime = fechaHasta.getTime();
		long diasDesde = (long) Math.floor(startTime / (1000*60*60*24)); 
		long diasHasta = (long) Math.floor(endTime / (1000*60*60*24)); 
		long dias = diasHasta - diasDesde;

		return dias;
	}

	public int[] cantPersonasByTipo(){
		int[] cant = {0,0,0};

		for(Persona per : misPersonas)
		{
			if(per instanceof Cliente)
				cant[0]++;
			if(per instanceof P_Administrador)
				cant[1]++;
			if(per instanceof P_Trabajador)
				cant[2]++;
		}
		return cant;
	}

	public float cantDineroEstimado() {

		float suma = 0, total = 0, total2 = 0;
		for(int i = 0; i < misPlanesAd.size(); i++) {
			total += misPlanesAd.get(i).getPagoInicial();
			total2 += misPlanesAd.get(i).getpagoMensual();

		}
		suma = total + total2;
		return suma;
	}

	public float cantDineroGenerado() {

		float total = 0;
		for(int j = 0; j < misFacturas.size(); j++) {
			if(misFacturas.get(j).getEstado().equalsIgnoreCase("Pagada")) {
				total += misFacturas.get(j).getPago();
			}
		}
		return total;
	}

	/*
	public void cantDineroPorPlan() {
       float total = 0;
       for(int i = 0; i < misFacturas.size(); i++) {
    	   for(int j = 0; j < misPlanes.size(); j++) {
    		   if(misFacturas.get(i).getMiPlanAd().getPlan().getNombre().equalsIgnoreCase(misPlanes.get(j).getNombre()) 
    				   && misFacturas.get(i).getEstado().equalsIgnoreCase("Pagada")) {
    			   total += misFacturas.get(i).getPago();
    	           misPlanes.get(j).setDineroGenerado(total); 
    		   }
    	   }
       }
		
	}
	*/
	public void cantDineroPorPlan() { 
	   
	   float total = 0; 
	   String code = null;  
	   
	   for(Factura fac: misFacturas) { 
	      code = fac.getCodigo(); 
		  if(code.equalsIgnoreCase(fac.getCodigo()) && fac.getEstado().equalsIgnoreCase("Pagada")) { 
		     total = fac.getPago(); 
		     fac.getMiPlanAd().getPlan().setDineroGenerado(total*fac.getMiPlanAd().getPlan().getCantVentas()); 
		  } 
		  total = 0; 
	   } 
	} 

	public void supender(PlanAdquirido pl) {
		pl.setSwitch1("Supendido");
	}
}

