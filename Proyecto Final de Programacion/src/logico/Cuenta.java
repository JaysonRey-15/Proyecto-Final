package logico;

public class Cuenta {
	
	private String password;
	private String usuario;
	
	public Cuenta(String password, String usuario) {
		super();
		this.password = password;
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public String getUsuario() {
		return usuario;
	}	
}
