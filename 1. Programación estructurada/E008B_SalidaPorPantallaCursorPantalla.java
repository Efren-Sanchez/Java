/*******************************************************************************
 * 
 * E008B_SalidaPorPantallaCursorPantalla
 * 
 * Autor: Efrén Sánchez
 * Fecha: 23/09/2025
 * 
 * Salida por pantalla: opciones de cursor y pantalla
 * 
 ******************************************************************************/
public class E008B_SalidaPorPantallaCursorPantalla {
    public static final String ANSI_ESC = "\u001B[";

    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("\n\n\n* E008B_SalidaPorPantallaCursorPantalla *\n\n  --- Inicio del programa ---\n\n");

        System.out.print(ANSI_ESC + "2J");   // Limpiar pantalla
        System.out.print(ANSI_ESC + "H");    // Mover cursor a esquina superior izquierda
        System.out.println("Inicio de pantalla");

        Thread.sleep(1000); // Hace una pausa de 1 segundo

        System.out.print(ANSI_ESC + "5;10H"); // Mover cursor a fila 5, columna 10
        System.out.print("Texto en fila 5, columna 10");

        Thread.sleep(1000);

        System.out.print(ANSI_ESC + "10;20H"); // Mover cursor fila 10, columna 20
        System.out.print("Texto en fila 10, columna 20");

        Thread.sleep(1000);

        // Borrar desde cursor hasta fin de línea
        System.out.print(ANSI_ESC + "K");
        
        // Mover cursor arriba 3 líneas
        System.out.print(ANSI_ESC + "3A");
        System.out.println("Texto después de mover cursor arriba 3 líneas");

        // Mover cursor abajo 2 líneas
        System.out.print(ANSI_ESC + "2B");
        System.out.println("Texto después de mover cursor abajo 2 líneas");

        // Mover cursor a la izquierda 5 posiciones
        System.out.print(ANSI_ESC + "5D");
        System.out.println("Texto desplazado a la izquierda 5 posiciones");

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}
