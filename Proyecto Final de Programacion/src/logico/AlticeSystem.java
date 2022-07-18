package logico;

import java.util.ArrayList;

public class AlticeSystem {
	private ArrayList<Persona>persona;
	//private ArrayList<Plan> plan;
	//private ArrayList<Servicio> servicio;
	//private ArrayList<Factura> factura;
	private Persona PersonaConectada;

	//Recuerden agregarle los demas datos al constructor
	public AlticeSystem() {
		super();
		this.persona = new ArrayList<Persona>();
		this.PersonaConectada=null;
	}

	public ArrayList<Persona> getPersona() {
		return persona;
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
	public boolean login(String cedula,String passwrd) {
		Persona aux =null;
		boolean conectado = false;

		if(buscarPersona(cedula)!=null) {
			aux =buscarPersona(cedula);
			if(aux.getPassword().contentEquals(passwrd)) {
				conectado = true;
				PersonaConectada = aux;
			}
		}

		return conectado;
	}
}
