package logico;

public class Persona {
	protected String identificacion;
	protected String nombre;
	protected String apellido;
	protected String genero;
	protected String nacionalidad;
	protected String correE;
	protected String direccion;
	protected String telefono;
	protected String password;
	
	public Persona(String identificacion, String nombre, String apellido, String genero, String nacionalidad,
			String correE, String direccion,String telefono,String passwrd) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.nacionalidad = nacionalidad;
		this.correE = correE;
		this.direccion = direccion;
		this.telefono = telefono;
		this.password = passwrd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getCorreE() {
		return correE;
	}

	public void setCorreE(String correE) {
		this.correE = correE;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public String getPassword() {
		return password;
	}
	
	
	

	

}
