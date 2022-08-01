package logico;

import java.awt.Component;
import java.io.Serializable;
import java.security.KeyStore.PasswordProtection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class AlticeSystem implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final Component PasswordProtection =null;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Persona> misPersonas;
	private ArrayList<Cuenta> misCuentas;
	private ArrayList<PlanAdquirido> misPlanesAd;
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

	public void eliminarPersona(Persona auxPersona) {
		if(auxPersona != null) {
			if(auxPersona instanceof Cliente) {
				if(((Cliente)auxPersona).getMisPlanesAd()!=null) {
					JOptionPane.showMessageDialog(null, "No se puede eliminar clientes con planes activado.", "¡Atención!", JOptionPane.ERROR_MESSAGE);
				}else {
					String contrasenia =JOptionPane.showInputDialog(PasswordProtection,"Favor confirmar su contraseña");
					if(((P_Administrador)loginUser).getCuenta().getPassword().equals(contrasenia)) {
						misPersonas.remove(auxPersona);
					}else {
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta, intente de nuevo.");
					}
				}

			}else {
				String contrasenia =JOptionPane.showInputDialog(PasswordProtection,"Favor confirmar su contraseña");
				if(((P_Administrador)loginUser).getCuenta().getPassword().equals(contrasenia)) {
					misPersonas.remove(auxPersona);
				}else {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta, intente de nuevo.");
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

	public void eliminarPlanAd(PlanAdquirido auxPlanAd) {
		if(auxPlanAd != null) {
			if(!auxPlanAd.isPagoPendiente()) {
				misPlanesAd.remove(auxPlanAd); 
			}
		}
	}


	//Se va a generar las facturas cada 27 de cada mes
	public void generarFacturaPorFecha() {
		if(LocalDateTime.now().getDayOfMonth()==27) {
			for(Persona per: misPersonas) {
				if(per instanceof Cliente) {
					addFactura((Cliente)per);
				}
				genFac++;
			}
		}
	}
	public void addFactura(Cliente cli) {
		int ind;
		LocalDate localDate = LocalDate.now();
		Date date = (Date) Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		for(ind=0; ind<cli.getMisPlanesAd().size(); ind++) {
			Factura fact = new Factura(cli, date,"F"+genFac,cli.getMisPlanesAd().get(ind).getpagoMensual());
			BalancePendiente newBalance= new BalancePendiente("Plan Aquirido",cli.getMisPlanesAd().get(ind).getpagoMensual(),date);
			cli.addFactura(fact);
			cli.BalancePendienteAd(newBalance);
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
}


