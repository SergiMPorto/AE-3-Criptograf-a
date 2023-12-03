package modelo;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.w3c.dom.html.HTMLDOMImplementation;

public class Usuario {
    private String nombreUsuario, password, hashpssw;
    SecretKey paloEspartano;
    Cipher cifrador;
   
    public Usuario(String nombreUsuario, String password) {
    	try {
			KeyGenerator generador = KeyGenerator.getInstance("AES");
			//System.out.println("Paso 1: Se ha obtenido el generador de claves");
			
			//Generamos la clave simetrica. (Una escítala espartana)
			 this.paloEspartano = generador.generateKey();
			//Si se hiciera otra vez, obtendria otra clave DIFERENTE, por ejemplo
			//otro palo espartano con otras medidas
			//System.out.println("Paso 2: Se ha obtenido la clave");
			
			//Objeto que nos permitira encriptar o desencriptar a partir de una
			//clave (o palo espartano)
			 this.cifrador = Cipher.getInstance("AES");
			//System.out.println("Paso 3: Hemos obtenido el cifrador/descifrador");
			
			//Ahora el cifrador lo configuramos para que use la clave simetrica
			//para encriptar
			this.cifrador.init(Cipher.ENCRYPT_MODE, this.paloEspartano);
			//System.out.println("Paso 4: Hemos configurado el cifrador");
						
			this.password = password;
			//El cifrador trabaja con bytes, lo convertimos
			byte[] bytesMensajeOriginal = this.password.getBytes();
			//System.out.println("Paso 5.1: Ciframos el mensaje original");
			//El cifrador devuelve una cadena de bytes
			byte[] bytesMensajeCifrado = this.cifrador.doFinal(bytesMensajeOriginal);
			this.hashpssw = new String(bytesMensajeCifrado);
			System.out.println("Paso 5.2: Mensaje Original: " + this.password);
			System.out.println("Paso 5.3: Mensaje Cifrado: " + this.hashpssw);
			
			/*System.out.println("Paso 6.1: Desciframos el criptograma:");
			//Ahora configuramos un descifrador para que use la clave simetrica
			//para desencriptar. Debemos de usar la MISMA clave para descifrar, NO
			//PODEMOS usar/generar una diferente.
			Cipher descifrador = Cipher.getInstance("AES");
			descifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
			byte[] bytesMensajeDescifrado = descifrador.doFinal(bytesMensajeCifrado);
			System.out.println("Paso 6.2: Mensaje Descifrado: " + new String(bytesMensajeDescifrado)*/
				this.nombreUsuario = nombreUsuario;
		//Simplificamos las excepciones capturando GeneralSecurityException
		} catch (GeneralSecurityException gse) {
			System.out.println("Algo ha fallado en : Usuario, encriptar contraseña" + gse.getMessage());
			gse.printStackTrace();
		}
    }

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHashpssw() {
		return hashpssw;
	}

	public void setHashpssw(String hashpssw) {
		this.hashpssw = hashpssw;
	}
    
    public boolean compararPsswr(String password) {
    	if(password.isEmpty()) {
    		System.out.println("Error: metodo compararPsswr, contraseña introducida vacía");
			return false;
			
		}else {
		    try {
		    	byte[] bytesMensajeIntroducido = password.getBytes();
				//System.out.println("Paso 5.1: Ciframos el mensaje original");
				//El cifrador devuelve una cadena de bytes
				byte[] bytesMensajeCifrado = this.cifrador.doFinal(bytesMensajeIntroducido);
				String psswrdhsdm= new String(bytesMensajeCifrado);
				System.out.println("Contraseña introducida cifrada: " + psswrdhsdm);
				if(this.hashpssw.equals(psswrdhsdm)) {
					System.out.println("Método comparar contraseñas, contraseñas iguales");
					return true;	
				}else {
					System.out.println("Error: Usuario, metodo comparaPsswr,contraseña introducida no es igual");
					return false;
				}
				
		    } catch (GeneralSecurityException e) {
		        // Maneja las excepciones adecuadamente, imprime el mensaje de error o lanza una nueva excepción si es necesario
		        System.out.println("Error al desencriptar: " + e.getMessage());
		        e.printStackTrace();
		        return false;
		    }
		}
    }
}
