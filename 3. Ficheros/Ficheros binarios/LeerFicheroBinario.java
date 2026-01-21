// Programa Java que lee y escribe en fichero binario
import java.io.*;

// Drver Class
public class LeerFicheroBinario {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("ejemplo.bin");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            // Leemos un entero del fichero binario
            int entero = dataInputStream.readInt();

            // Leemos un real del fichero binario
            float real = dataInputStream.readFloat();

            // Mostramos los valores leidos por pantalla
            System.out.println("Valor entero leido: " + entero);
            System.out.println("Valor real leido: " + real);

            dataInputStream.close();
            fileInputStream.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}