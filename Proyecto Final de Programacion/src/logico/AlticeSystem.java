package logico;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AlticeSystem {

	private ArrayList<Plan> misPlanes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Persona> misPersonas;
	private ArrayList<Cuenta> misCuentas;
	private ArrayList<PlanAdquirido> misPlanesAd;
	private int generadorCodigoPersona;
	public static AlticeSystem ALS = null;

	public AlticeSystem() {
		super();
		this.misPlanes = new ArrayList<Plan>();
		this.misPlanesAd = new ArrayList<PlanAdquirido>();
		this.misFacturas = new ArrayList<Factura>();
		this.misPersonas = new ArrayList<Persona>();
		this.misCuentas = new ArrayList<Cuenta>();
	}

	public static AlticeSystem getInstance(){
		if(ALS==null){
			ALS= new AlticeSystem();	
		}
		return ALS;
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

	public int getGeneradorCodigoPersona() {
		return generadorCodigoPersona;
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
			misPersonas.remove(auxPersona);
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
	
	//Por discutir
//
//	public void actualizarBalanceCliente(Cliente cliente,BalancePendiente ppendiente) {
//		int ind;
//		PlanAdquirido plan = null;
//		if(cliente.getMiPlan().isPagoPendiente()) {
//			plan = cliente.getMiPlan();
//			Date date;
//			//BalancePendiente bpendiente new BalancePendiente("Cuentas por pagar", plan.getMisPlanes().get(0).getPrecioMensual(), date);
//			
//			cliente.getPPendientes().add(null);
//		}
//	}
	


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
}


