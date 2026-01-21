import java.io.FileQutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class ObjectWriter {
    public static void main(String[] args) {
        String filePath = "objeto.dat";

        // Crear un objeto que se va a escribir en el archivo
        MiObjeto objetoAEscribir = new MiObjeto("Datos de ejemplo");

        try (FileOutputStream fileQutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            // Escribir el objeto en el archivo
            objectOutputStream.writeObject(objetoAEscribir);
            System.out.println("Objeto escrito en el archivo correctamente.");
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            objectOutputStream. close();
            fileOutputStream.close();
        }
    }
}