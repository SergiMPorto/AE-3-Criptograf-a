package EnDesCriptar;

import java.io.Serializable;

public class Personas implements Serializable {


	private static final long serialVersionUID = -3999977146484347198L;

	
	private String usuario;
	private String password;
	
	
	
	public Personas(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Personas [usuario=" + usuario + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
}
	
	
	
	






