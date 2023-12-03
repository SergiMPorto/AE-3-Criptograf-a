package al_03_criptografia;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncriptarDesencriptar {
	public static void main (String args[]) {
	
		try {
			
	/*
	 * GENERADIR DE CLAVES
	 */
	    KeyGenerator generador = KeyGenerator.getInstance("AES");	
	/*
	 * GENERANOS LA CLAVE SIMTERICA
	 */
        SecretKey paloEspartano = generador.generateKey();
    /*
     * CREMOS EL OBJETO QUE NOS PEMITIRA ENCRIPTAR O DESENCRIPTAR A PARTIR DE UNA CLAVE 
     */
	    Cipher cifrador = Cipher.getInstance("AES");
	/*
	 * CONFIGURAMOS EL CIFRADOR PARA QUE USE LA CLAVE SIMETRICA PARA ENCRIPATR 
	 */
		cifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);
	/*
	 * LA FRASE PARA INCRIPTAR
	 */			
	    String fraseOriginal = "";
	/*
	 * EL CIFRADOR TRABAJA CON BYTES POR LO CUAL LO CONVERTIMOS
	 */	
	    byte[] bytesfraseOriginal = fraseOriginal.getBytes();
	/*
	 * EL CIFRADOR DEVUELVE UNA CADENA DE BYTES 
	 */
		byte[] bytesfraseCifrado = cifrador.doFinal(bytesfraseOriginal);
		String fraseCifrado = new String(bytesfraseCifrado);
		System.out.println(" FRASE ORIGINAL : " + fraseOriginal);
		System.out.println(" FRASE CIFRADA : " + fraseCifrado);
	/*
	 * CONFIGURAMOS UN DESCIFRADOR PARA QUE USE LA CLAVE SIMETRICA PARA DESENCRIPTAR 
	 * TENEMOS QUE USAR LA MISMA CLAVE PAAR DESCIFRAR, NO PODEMOS USAR O GENERAR UN CLAVE DIFRENTE 
	 */
		Cipher descifrador = Cipher.getInstance("AES");
		descifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
		byte[] bytesfraseDescifrado = descifrador.doFinal(bytesfraseCifrado);
		System.out.println("FRASE DESCIFRADA " + new String(bytesfraseDescifrado));
	/*
	 * SIMPLIFICAMOS LAS EXCEPCIONES CAPTIRANDO GeneralSecurityExcepcion
	 */
		} catch (GeneralSecurityException gse) {
			System.out.println("ALGO HA FALLADO..." + gse.getMessage());
			gse.printStackTrace();
		}
	}
}