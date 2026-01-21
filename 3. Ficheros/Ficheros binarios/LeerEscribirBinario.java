// Programa Java que lee y escribe en fichero binario
import java.io.*;

// Drver Class
public class LeerEscribirBinario {
    public static void main(String[] args) {
        try {
            OutputStream Stream = new FileOutputStream("data.bin");
            
            // Valores ASCII de la palabra "Hola"
            Stream.write(new byte[]{0x48, 0x6F, 0x6C, 0x60 }); 
            
            Stream.close();
            
            // Leemos el fichero binario
            InputStream inputStream = new FileInputStream("ejemplo.bin");
            
            int datos;
          
            // Leemos byte a byte
            while ((datos = inputStream.read()) != -1) {
                System.out.print((char) datos); // Convierte el byte leido en un carácter
            }

            inputStream.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}