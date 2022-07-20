package logico;

public class Cuenta {
	
	private String password;
	private String correE;
	
	public Cuenta(String password, String correE) {
		super();
		this.password = password;
		this.correE = correE;
	}

	public String getPassword() {
		return password;
	}

	public String getCorreE() {
		return correE;
	}
	
	
}
