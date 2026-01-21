// Programa Java que lee y escribe en fichero binario
import java.io.*;

// Drver Class
public class EscribirFicheroBinario {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("ejemplo.bin");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            
            //Escribimos valores numéricos
            bufferedWriter.write(3); 
            bufferedWriter.write(5f); 

            //Escribimos un texto
            bufferedWriter.write("Hola, caracola :)"); 
            
            bufferedWriter.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}