package main;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import entidad.Encriptacion;

public class Main {

	public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException {
		
		//Encriptacion e1 = new Encriptacion();
		
		//e1.encriptarFrase("Mi nombre es Anton");
		//System.out.println(e1.desencriptarFrase());
		menu();

	}
	
	public static void menu() throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
	    Encriptacion e1 = new Encriptacion();
	    Scanner scanner = new Scanner(System.in);

	    boolean bandera = true;

	    while (bandera) {
	        System.out.println("MENU");
	        System.out.println("------------");
	        System.out.println("1. Encriptar frase");
	        System.out.println("2. Desencriptar frase");
	        System.out.println("3. Salir");
	        System.out.println("-------------");
	        

	        int opcion = 0;
	        try {
	            System.out.println("Introduzca una opción");
	            opcion = scanner.nextInt();
	        } catch (InputMismatchException e) {
	            System.out.println("Error: Introduzca un número entero válido.");
	            // Limpiar el búfer de entrada para evitar bucle infinito
	            scanner.nextLine();
	            continue;  // Ir al siguiente ciclo del bucle
	        }

	        // Consumir la línea en blanco después de la lectura de la opción
	        scanner.nextLine();

	        switch (opcion) {
	            case 1:
	                System.out.println("Introduzca la frase que quiere encriptar");
	                // Leer la frase y encriptarla
	                String frase = scanner.nextLine();
	                e1.encriptarFrase(frase);
	                break;
	            case 2:
	                System.out.println("Frase desencriptada: " + e1.desencriptarFrase());
	                break;
	            case 3:
	                System.out.println("Adiós");
	                bandera = false;
	                break;
	            default:
	                System.out.println("Opción incorrecta. Introduzca una opción");
	                break;
	        }
	       
	    }
	    System.out.println("Has salido del programa");
	    // Cerrar el scanner para liberar recursos
	    scanner.close();
	}
	
}


