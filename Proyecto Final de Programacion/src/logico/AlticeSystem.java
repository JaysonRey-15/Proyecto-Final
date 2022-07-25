package logico;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AlticeSystem {
	
	private ArrayList<Persona>persona;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Cuenta> misCuentas;
	private Persona PersonaConectada;
	public static AlticeSystem ALS= null;
	
	public AlticeSystem() {
		super();
		this.persona = new ArrayList<Persona>();
		this.PersonaConectada=null;
		this.misCuentas = new ArrayList<Cuenta>();
		this.misPlanes = new ArrayList<Plan>();
		this.misFacturas = new ArrayList<Factura>();
		
	}

	public static AlticeSystem getInstance(){
		if(ALS==null){
			ALS= new AlticeSystem();	
		}
		return ALS;
	}
	
	public ArrayList<Persona> getPersona() {
		return persona;
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public ArrayList<Cuenta> getMisCuentas() {
		return misCuentas;
	}

	//Crud Personas

	public Persona getPersonaConectada() {
		return PersonaConectada;
	}

	public void ingresarPersona(Persona person) {
		if(person!=null) {
			if(!existe(person.getIdentificacion())) {
				persona.add(person);
				JOptionPane.showMessageDialog(null,"Exito");
			}
		}
	}

	public boolean existe(String code) {
		boolean valor = false;
		for(Persona per:persona) {
			if(per.getIdentificacion().equalsIgnoreCase(code)) {
				valor=true;
			}
		}
		return valor;
	}

	public void eliminarPersona(Persona person) {
		if(person!=null) {
			if(existe(person.getIdentificacion())){
				persona.remove(person);
			}
		}
	}

	public Persona buscarPersona(String codPer) {
		Persona perso = null;

		for(Persona per: persona) {
			if(per.getIdentificacion().equalsIgnoreCase(codPer)) {
				perso = per;
			}
		}
		return perso;
	}

	/*
	 * recibe la cedula y la contraseña que se capturó
	 * Asigna a la variable de conexion esa persona
	 * Retorna el estado de conectado
	 */

	public boolean login(String cedula,String correo,String passwrd) {
		Persona aux =buscarPersona(cedula);
		boolean conectado = false;

		if(aux!=null) {
			if(aux instanceof P_Trabajador || aux instanceof P_Administrador) {
				conectado = true;
				PersonaConectada = aux;
			}
		}

		return conectado;
	}

	public void addUser(String cedula,Cuenta cuenta) {
		Persona aux =buscarPersona(cedula);
		
		if(aux!=null && cuenta!=null) {
			if(aux instanceof P_Administrador) {
				P_Administrador admi = (P_Administrador)aux;
				misCuentas.add(cuenta);
				admi.addCuenta(cuenta);
			}else 
				if(aux instanceof P_Trabajador) {
					P_Administrador tra = (P_Administrador)aux;
					misCuentas.add(cuenta);
					tra.addCuenta(cuenta);
				}

			JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente");
		}
	}
	
	public Persona filtroG(String filtro) {
		Persona aux = null;
		
		for(Persona per: persona) {
			if(per.getIdentificacion().equalsIgnoreCase(filtro) || per.getNombre().equalsIgnoreCase(filtro) || per.getTelefono().equalsIgnoreCase(filtro)) {
				aux=per;
			}else
				JOptionPane.showMessageDialog(null,"Usuario no encontrado");
		}
		
		return aux;
	}
}
