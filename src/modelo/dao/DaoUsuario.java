package modelo.dao;

import java.util.Arrays;
import java.util.List;

import modelo.*;
public class DaoUsuario {
    private static List<Usuario> usuarios = Arrays.asList(
        new Usuario("usuario1", "contrasenha1"), // reemplaza "contrasenha1" con la contraseña hasheada real
        new Usuario("usuario2", "contrasenha2"),
        new Usuario("usuario3", "contrasenha3")
    );
    
    public DaoUsuario() {
    	
    }

	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(List<Usuario> usuarios) {
		DaoUsuario.usuarios = usuarios;
	}
	
	

    public boolean confirmarUsuario(String nombreUsuario, String contrasenha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.compararPsswr(contrasenha)) {
                return true;
            }
        }
        return false;
    }
}
