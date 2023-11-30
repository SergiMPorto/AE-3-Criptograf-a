package Encriptar;

import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;

public class MainDes {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        try {
            KeyGenerator generador = KeyGenerator.getInstance("DES");
            SecretKey raboToledano = generador.generateKey();    
            Cipher cifrador = Cipher.getInstance("DES");
            Cipher descifrador = Cipher.getInstance("DES");

            while (true) {
                System.out.println("1. Encriptar frase");
                System.out.println("2. Desencriptar frase");
                System.out.println("3. Salir del programa");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1: {
                        System.out.println("Escriba la frase que quiere encriptar");
                        String frase = scanner.next();
                        cifrador.init(Cipher.ENCRYPT_MODE, raboToledano);
                        byte[] bytesFrase = frase.getBytes();
                        byte[] bytesFraseCifrar = cifrador.doFinal(bytesFrase);
                        System.out.println("Frase encriptada: " + new String(bytesFraseCifrar));
                        break;
                    }
                    case 2: {
                        descifrador.init(Cipher.DECRYPT_MODE, raboToledano);
                        System.out.println("Escriba la frase encriptada que quiere desencriptar");
                        String fraseEncriptada = scanner.next();
                        byte[] bytesFraseDescifrar = descifrador.doFinal(fraseEncriptada.getBytes());
                        System.out.println("Frase desencriptada: " + new String(bytesFraseDescifrar));
                        break;
                    }
                    case 3:
                        System.out.println("Saliendo del programa");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
