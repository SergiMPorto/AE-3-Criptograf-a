package EnDesCriptar;

import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.util.Base64;

public class MainDes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        KeyGenerator generador;
        SecretKey raboToledano;
        Cipher cifrador;
        Cipher descifrador;

        try {
            generador = KeyGenerator.getInstance("AES");
            raboToledano = generador.generateKey();
            cifrador = Cipher.getInstance("AES");
            descifrador = Cipher.getInstance("AES");

            while (true) {
                System.out.println("1. Encriptar frase");
                System.out.println("2. Desencriptar frase");
                System.out.println("3. Salir del programa");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1: {
                        System.out.println("Escriba la frase que quiere encriptar");
                        String frase = scanner.nextLine();
                        cifrador.init(Cipher.ENCRYPT_MODE, raboToledano);
                        byte[] bytesFraseCifrar = cifrador.doFinal(frase.getBytes());
                        String fraseEncriptada = Base64.getEncoder().encodeToString(bytesFraseCifrar);
                        System.out.println("Frase encriptada: " + fraseEncriptada);
                        break;
                    }
                    case 2: {
                        System.out.println("Escriba la frase encriptada que quiere desencriptar");
                        descifrador.init(Cipher.DECRYPT_MODE, raboToledano);
                        String fraseEncriptada = scanner.nextLine();
                        byte[] bytesFraseDescifrar = descifrador.doFinal(Base64.getDecoder().decode(fraseEncriptada));
                        System.out.println("Frase desencriptada: " + new String(bytesFraseDescifrar));
                        break;
                    }
                    case 3:
                        System.out.println("Saliendo del programa");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
