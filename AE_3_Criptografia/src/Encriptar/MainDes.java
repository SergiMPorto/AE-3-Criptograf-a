package Encriptar;
import javax.crypto.KeyGenerator;
import javax.crypto.*;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;



public class MainDes {

	public static void main(String[] args) {
		
   
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println("1. Encriptar frase");
			System.out.println("2. Desencriptar frase");
			System.out.println("3. Salir del programa");
			
			int opcion =scanner.nextInt();
			
			switch(opcion) {
			case 1: {
				System.out.println("Escriba la frase que quiere encriptar");
				try {
					KeyGenerator generador = KeyGenerator.getInstance("DES");
			SecretKey	
					
					
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			}
			
		
		
		}	
	}

}
