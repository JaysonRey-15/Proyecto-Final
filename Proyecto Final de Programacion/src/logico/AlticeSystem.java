package logico;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AlticeSystem {
	
	private ArrayList<Persona>persona;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Servicio> misServicios;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Cuenta> misCuentas;
	private Persona PersonaConectada;

	public AlticeSystem() {
		super();
		this.persona = new ArrayList<Persona>();
		this.PersonaConectada=null;
		this.misCuentas = new ArrayList<Cuenta>();
		this.misPlanes = new ArrayList<Plan>();
		this.misServicios = new ArrayList<Servicio>();
		this.misFacturas = new ArrayList<Factura>();
		
	}

	public ArrayList<Persona> getPersona() {
		return persona;
	}

	public ArrayList<Plan> getMisPlanes() {
		return misPlanes;
	}

	public ArrayList<Servicio> getMisServicios() {
		return misServicios;
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

	public void addCuenta(String cedula,Cuenta cuenta) {
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
}
