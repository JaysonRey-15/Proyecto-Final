package logico;

import java.util.ArrayList;

public class AlticeSystem {
	
	private ArrayList<Cliente> misClientes;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Persona> misPersonas;
	private ArrayList<PlanAdquirido> misPlanesAd;
	private int generadorCodigoPersona;
	public static AlticeSystem ALS = null;
	
	public AlticeSystem() {
		super();
		this.misClientes = new ArrayList<Cliente>();
		this.misPlanes = new ArrayList<Plan>();
		this.misPlanesAd = new ArrayList<PlanAdquirido>();
		this.misFacturas = new ArrayList<Factura>();
		this.misPersonas = new ArrayList<Persona>();
		generadorCodigoPersona = 1;
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

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
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
		generadorCodigoPersona++;
	}
	
	public void modificarPlan(Plan auxPlan) {
		int ind = buscarIndexByNomb(auxPlan.getNombre());
		if(ind != -1) {
			misPlanes.get(ind).setNombre(auxPlan.getNombre());
			misPlanes.get(ind).setPrecioInicial(auxPlan.getPrecioInicial());
			misPlanes.get(ind).setPrecioMensual(auxPlan.getPrecioMensual());
		}
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
				if(Persona.equals(((P_Administrador) aux).getMiCuenta().getUsuario())) {
					return false;
				}
			}
			else if(aux != null && aux instanceof P_Trabajador) {
				if(Persona.equals(((P_Trabajador) aux).getMiCuenta().getUsuario())) {
					return false;
				}
			}
			if (misPersonas.get(i) instanceof P_Administrador) {
				if(((P_Administrador) misPersonas.get(i)).getMiCuenta().getUsuario().equalsIgnoreCase(Persona)) {
					encontrado = true;	
				}
			}
			else if (misPersonas.get(i) instanceof P_Trabajador) {
				if(((P_Trabajador) misPersonas.get(i)).getMiCuenta().getUsuario().equalsIgnoreCase(Persona)) {
					encontrado = true;	
				}
			}
			i++;
		}
		return encontrado;
	}

	public void modificarPersona(Persona auxPersona, Cuenta cuenta) {
		Persona Persona = buscarPersonaByCode(auxPersona.getCodigoUsuario());
		if(Persona != null && auxPersona instanceof P_Administrador) {
			Persona.setTelefono(auxPersona.getTelefono());
			Persona.setNombre(auxPersona.getNombre());
			Persona.setTipo(auxPersona.getTipo());
			Persona.setNacionalidad(auxPersona.getNacionalidad());
			Persona.setDireccion(auxPersona.getDireccion());
			((P_Administrador) Persona).setMiCuenta(cuenta);
		}
		if(Persona != null && auxPersona instanceof P_Trabajador) {
			Persona.setTelefono(auxPersona.getTelefono());
			Persona.setNombre(auxPersona.getNombre());
			Persona.setTipo(auxPersona.getTipo());
			Persona.setNacionalidad(auxPersona.getNacionalidad());
			Persona.setDireccion(auxPersona.getDireccion());
			((P_Trabajador) Persona).setMiCuenta(cuenta);
		}
	}

	public Persona buscarPersonaByCode(String codigoPersona) {
		Persona Persona = null;
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < misPersonas.size()) {
			if(misPersonas.get(i).getCodigoUsuario().equalsIgnoreCase(codigoPersona)) {
				encontrado=true;
				Persona = misPersonas.get(i);
			}
			i++;
		}
		return Persona;
	}

	public void eliminarPersona(Persona auxPersona) {
		if(auxPersona != null) {
			misPersonas.remove(auxPersona);
		}
	}
}