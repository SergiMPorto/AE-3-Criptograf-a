package EnDesCriptar;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class ClavePersona {

	public static void main(String[] args) {
		
		KeyGenerator generador ;
		
       
		
		
		
		try {
			generador = KeyGenerator.getInstance("AES");
			System.out.println("Optención del generador de claves");
			SecretKey raboToledano  =generador.generateKey();
			
			
			generador.generateKey();
			Cipher cifrador =Cipher.getInstance("AES");
			
			cifrador.init(Cipher.ENCRYPT_MODE, raboToledano);
			
			//Creamos la persona
			
			Personas p1 = new Personas("Brando","Marlon","BrandoMarlon@gmail.com");
			Personas p2=  new Personas("Lucia", "Berlin", "LuciaBerlin@gmail.com");
			Personas p3 = new Personas("Rocco", "Sifreddi", "eltalento@hotmail.com");
			
            SealedObject so = new SealedObject(p1, cifrador);
            SealedObject so2 = new SealedObject(p2, cifrador);
            SealedObject so3 = new SealedObject(p3, cifrador);
			
            System.out.println("Persona original "+p1);
            System.out.println("Persona cifrado "+so);
            System.out.println("Persona original "+p2);
            System.out.println("Persona cifrado "+so2);
            System.out.println("Persona original "+p3);
            System.out.println("Persona cifrado "+so3);
			
			
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | IOException e) {
			
			e.printStackTrace();
		}
		
		
		

	}

}
