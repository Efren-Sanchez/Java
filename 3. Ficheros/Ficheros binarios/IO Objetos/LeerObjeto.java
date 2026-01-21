import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class LeerObjeto {
    public static void main(String[] args) {
        String filePath = "objeto.dat";
        try (FileInputStream fileInputStream = new FilelnputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // Leer el objeto desde el archivo
            Object objetoLeido = objectInputStream.readObject();
            // Realizar un casting al tipo de objeto adecuado
            MiObjeto miObjeto = (MiObjeto) objetolLeido;
            // Ahora puedes trabajar con el objeto leido
            System.out.println("Objeto leido: " + miObjeto);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.toString());
        } finally {
            objectInputStream.close();
            fileInputStream.close();
        }
    }
}