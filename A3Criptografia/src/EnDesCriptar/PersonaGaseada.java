package EnDesCriptar;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PersonaGaseada {

	public static void main(String[] args)  throws NoSuchFieldException{
		
		Personas p1 = new Personas("Brando","Marlon");
		Personas p2=  new Personas("Lucia", "Berlin");
		Personas p3 = new Personas("Alexander", "Portnoy");
		
		
		//Vamos a hashear las personas. 
		
		byte[] persona1 = (p1.getUsuario() + p1.getPassword()).getBytes();
		byte[] persona2 = (p2.getUsuario() + p2.getPassword()).getBytes();
		byte[] persona3 = (p3.getUsuario() + p3.getPassword()).getBytes();
		
	
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			
			md.update(persona1);
			md.update(persona2);
			md.update(persona3);
			
	/*	System.out.println("Creando resumen hash...");
		byte[] contrasenhas =md.digest();
		String claves = new String(contrasenhas);
		System.out.println("Claves hash: "+ claves);*/
		
		String claveHastPersona1= Base64.getEncoder().encodeToString(persona1);
		System.out.println("Clave Persona1 "+ claveHastPersona1);
		String claveHastPersona2= Base64.getEncoder().encodeToString(persona2);
		System.out.println("Clave Persona1 "+ claveHastPersona2);
		String claveHastPersona3= Base64.getEncoder().encodeToString(persona3);
		System.out.println("Clave Persona1 "+ claveHastPersona3);
					
			
			
			
			
			
			
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		

}
}
