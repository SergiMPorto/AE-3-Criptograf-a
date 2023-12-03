package main;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import modelo.Encriptacion;
import modelo.Usuario;
import modelo.dao.DaoUsuario;

public class Main {

    public static void main(String[] args) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
    	DaoUsuario u1 = new DaoUsuario();
    	
    	
        menu();
    }

    public static void menu() throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Encriptacion encriptacion = new Encriptacion();
        Scanner scanner = new Scanner(System.in);

        boolean bandera = true;
        int intentosFallidos = 0;

        while (intentosFallidos < 3 && bandera) {
            // Verificación de usuario
            if (!verificarUsuario()) {
                intentosFallidos++;
                System.out.println("Intento fallido. Intentos restantes: " + (3 - intentosFallidos));
                if (intentosFallidos == 3) {
                    System.out.println("Tres intentos fallidos. Saliendo del programa.");
                    break;
                }
                continue;  // Volver al inicio del bucle para el próximo intento
            } else {
                intentosFallidos = 0;  // Restablecer intentos fallidos
            }
            while(bandera) {
            // Menú principal
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
            } catch (Exception e) {
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
	                    encriptacion.encriptarFrase(frase);
	                    break;
	                case 2:
	                    System.out.println("Frase desencriptada: " + encriptacion.desencriptarFrase());
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
        }

        System.out.println("Has salido del programa");
        // Cerrar el scanner para liberar recursos
        scanner.close();
    }

    private static boolean verificarUsuario() {
        Scanner scanner = new Scanner(System.in);
        DaoUsuario daoUsuario = new DaoUsuario();

        //for (int i = 0; i < 3; i++) {
            System.out.println("Introduzca su nombre de usuario:");
            String nombreUsuario = scanner.nextLine();
            System.out.println("Introduzca su contraseña:");
            String contrasenhaUsuario = scanner.nextLine();

            if (daoUsuario.confirmarUsuario(nombreUsuario, contrasenhaUsuario)) {
                System.out.println("¡Bienvenido, " + nombreUsuario + "!");
                return true;
            } else {
                System.out.println("Credenciales incorrectas.");
            }
        //}

        //System.out.println("Tres intentos fallidos. Saliendo del programa.");
        return false;
    }
}
