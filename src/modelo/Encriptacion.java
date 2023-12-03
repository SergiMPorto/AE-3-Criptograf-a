package modelo;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Encriptacion {
	
	private String frase, fraseEncriptada, fraseDesencriptada;
	private Cipher cifrador;
	private SecretKey paloEspartano;
	private byte[] bytesMensajeCifrado;
	
	public Encriptacion() {
		try {
			KeyGenerator generador = KeyGenerator.getInstance("AES");
			System.out.println("Paso 1: Se ha obtenido el generador de claves");
			
			//Generamos la clave simetrica. (Una escítala espartana)
			paloEspartano = generador.generateKey();
			//Si se hiciera otra vez, obtendria otra clave DIFERENTE, por ejemplo
			//otro palo espartano con otras medidas
			System.out.println("Paso 2: Se ha obtenido la clave");
			
			//Objeto que nos permitira encriptar o desencriptar a partir de una
			//clave (o palo espartano)
			//cifrador = Cipher.getInstance("AES");
			//System.out.println("Paso 3: Hemos obtenido el cifrador/descifrador");
			
			//Ahora el cifrador lo configuramos para que use la clave simetrica
			//para encriptar
			//cifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);
			//System.out.println("Paso 4: Hemos configurado el cifrador");
						
			
			
			
				
		//Simplificamos las excepciones capturando GeneralSecurityException
		} catch (GeneralSecurityException gse) {
			System.out.println("Algo ha fallado.." + gse.getMessage());
			gse.printStackTrace();
		}
	}

	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}

	public String getFraseEncriptada() {
		return fraseEncriptada;
	}

	public void setFraseEncriptada(String fraseEncriptada) {
		this.fraseEncriptada = fraseEncriptada;
	}
	
	public void encriptarFrase(String frase) throws IllegalBlockSizeException, BadPaddingException {
	    try {
	    	cifrador = Cipher.getInstance("AES");
			System.out.println("Paso 3: Hemos obtenido el cifrador/descifrador");
			
			//Ahora el cifrador lo configuramos para que use la clave simetrica
			//para encriptar
			cifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);
			System.out.println("Paso 4: Hemos configurado el cifrador");
	        // El cifrador trabaja con bytes, lo convertimos
	        byte[] bytesFrase = frase.getBytes("UTF-8");
	        System.out.println("Paso 5.1: Ciframos el mensaje original");

	        // El cifrador devuelve una cadena de bytes
	        bytesMensajeCifrado = cifrador.doFinal(bytesFrase);

	        // Puedes almacenar directamente los bytes cifrados si lo necesitas en el futuro
	        // bytesMensajeCifrado = cifrador.doFinal(bytesFrase);

	        System.out.println("Paso 5.2: Mensaje Original: " + frase);
	        System.out.println("Paso 5.3: Mensaje Cifrado: " + new String(bytesMensajeCifrado, "UTF-8"));
	    } catch (UnsupportedEncodingException | GeneralSecurityException e) {
	        // Maneja las excepciones adecuadamente, imprime el mensaje de error o lanza una nueva excepción si es necesario
	        System.out.println("Error al encriptar: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public String desencriptarFrase() throws UnsupportedEncodingException {
		if(bytesMensajeCifrado == null) {
			return "No hay ninguna frase para desencriptar";
		}else {
		    try {
		        System.out.println("Paso 6.1: Desciframos el criptograma:");
	
		        // Utilizamos la misma instancia de cifrador que se utilizó para el cifrado
		        cifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
	
		        // Desciframos el mensaje
		        byte[] bytesMensajeDescifrado = cifrador.doFinal(bytesMensajeCifrado);
	
		        // Convertimos los bytes descifrados a una cadena
		        String fraseDesencriptada = new String(bytesMensajeDescifrado, "UTF-8");
	
		        return fraseDesencriptada;
		    } catch (GeneralSecurityException e) {
		        // Maneja las excepciones adecuadamente, imprime el mensaje de error o lanza una nueva excepción si es necesario
		        System.out.println("Error al desencriptar: " + e.getMessage());
		        e.printStackTrace();
		        return "Error al desencriptar el mensaje";
		    }
		}
	}

}
