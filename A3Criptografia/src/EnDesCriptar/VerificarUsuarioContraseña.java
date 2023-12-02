package EnDesCriptar;

import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class VerificarUsuarioContraseña {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        KeyGenerator generador;
        SecretKey raboToledano;
        Cipher cifrador;
        Cipher descifrador;

        // Creamos la clase persona
        Personas p1 = new Personas("Brando", "Marlon");
        Personas p2 = new Personas("Lucia", "Berlin");
        Personas p3 = new Personas("Alexander", "Portnoy");

        try {
            generador = KeyGenerator.getInstance("AES");
            raboToledano = generador.generateKey();
            cifrador = Cipher.getInstance("AES");
            descifrador = Cipher.getInstance("AES");

            int intento = 1;
            boolean acierto = false;

            while (intento <= 3 && !acierto) {
                System.out.println("Escriba el nombre del usuario");
                String usuario = scanner.nextLine();
                System.out.println("Escriba su contraseña");
                String password = scanner.nextLine();

                if (usuario.equals(p1.getUsuario()) && password.equals(p1.getPassword())) {
                    System.out.println("Bienvenido " + p1.getUsuario());
                    acierto = true;
                } else if (usuario.equals(p2.getUsuario()) && password.equals(p2.getPassword())) {
                    System.out.println("Bienvenido " + p2.getUsuario());
                    acierto = true;
                } else if (usuario.equals(p3.getUsuario()) && password.equals(p3.getPassword())) {
                    System.out.println("Bienvenido " + p3.getUsuario());
                    acierto = true;
                } else {
                    System.out.println("Usuario o contraseña incorrectos. Intento " + intento + "/3");
                    intento++;
                    if (intento > 3) {
                        System.out.println("Número máximo de intentos alcanzado. Acceso bloqueado.");
                        System.exit(0);
                    }
                }
            }

           
            while (acierto) {
                System.out.println("Elija una opción:");
                System.out.println("1. Encriptar frase");
                System.out.println("2. Desencriptar frase");
                System.out.println("3. Salir del programa");

                String opcion = scanner.nextLine();

                switch (opcion) {
                    case "1": {
                        System.out.println("Escriba la frase que quiere encriptar");
                        String frase = scanner.nextLine();
                        cifrador.init(Cipher.ENCRYPT_MODE, raboToledano);
                        byte[] bytesFraseCifrar = cifrador.doFinal(frase.getBytes());
                        String fraseEncriptada = Base64.getEncoder().encodeToString(bytesFraseCifrar);
                        System.out.println("Frase encriptada: " + fraseEncriptada);
                        break;
                    }
                    case "2": {
                        System.out.println("Escriba la frase encriptada que quiere desencriptar");
                        descifrador.init(Cipher.DECRYPT_MODE, raboToledano);
                        String fraseEncriptada = scanner.nextLine();
                        byte[] bytesFraseDescifrar = descifrador.doFinal(Base64.getDecoder().decode(fraseEncriptada));
                        System.out.println("Frase desencriptada: " + new String(bytesFraseDescifrar));
                        break;
                    }
                    case "3":
                        System.out.println("Saliendo del programa");
                        acierto = false;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
