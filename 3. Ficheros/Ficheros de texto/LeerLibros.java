import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerLibros {
    private static final String NOMBRE_ARCHIVO = "libros.txt";

    public static void main(String[] args) {
        try (BufferedReader lector = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            System.out.println("Lista de libros en el fichero " + NOMBRE_ARCHIVO + ":\n");

            while ((linea = lector.readLine()) != null) {
                // Separar los datos usando el delimitador #
                String[] datos = linea.split("#");

                // Verificar que la línea tiene los 4 campos esperados
                if (datos.length == 4) {
                    System.out.println("Título: " + datos[0]);
                    System.out.println("Autor: " + datos[1]);
                    System.out.println("Páginas: " + datos[2]);
                    System.out.println("Editorial: " + datos[3]);
                    System.out.println("----------------------------");
                } else {
                    System.out.println("Línea con formato incorrecto: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}