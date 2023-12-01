package EnDesCriptar;

import java.io.Serializable;

public class Personas implements Serializable {


	private static final long serialVersionUID = -3999977146484347198L;

	
	private String nombre;
	private String usuario;
	private String correo;
	
	
	
	


	public Personas(String nombre, String usuario, String correo) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.correo = correo;
	}



	@Override
	public String toString() {
		return "Personas [nombre=" + nombre + ", usuario=" + usuario + ", correo=" + correo + "]";
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}
	

}
