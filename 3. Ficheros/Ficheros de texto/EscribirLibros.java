import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirLibros {
    private static final String NOMBRE_ARCHIVO = "libros.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true; // Condición de parada

        while (continuar) {
            // Solicitar datos del libro por teclado
            System.out.print("Introduce el título del libro: ");
            String titulo = scanner.nextLine();
            
            System.out.print("Introduce el autor: ");
            String autor = scanner.nextLine();
            
            System.out.print("Introduce el número de páginas: ");
            // Convierto el dato en entero
            int paginas = Integer.parseInt(scanner.nextLine()); 
            
            System.out.print("Introduce la editorial: ");
            String editorial = scanner.nextLine();

            // Guardar en el archivo
            guardarLibro(titulo, autor, paginas, editorial);

            // Preguntar si desea agregar más libros
            System.out.print("¿Deseas introducir otro libro? (s/n): ");
            String respuesta = scanner.nextLine();

            // Si se introduce una 's' devuelve un true. False en cualquier otro caso
            continuar = respuesta.equalsIgnoreCase("s");
        }

        System.out.println("Libros guardados correctamente.");
        scanner.close();
    }

    private static void guardarLibro(String titulo, String autor, int paginas, String editorial) {
        try (FileWriter escritor = new FileWriter(NOMBRE_ARCHIVO, true)) {
            escritor.write(titulo + "#" + 
                            autor + "#" + 
                            paginas + "#" + 
                            editorial + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el libro: " + e.getMessage());
        }
    }
}