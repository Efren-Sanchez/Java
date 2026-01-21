/*******************************************************************************
 * 
 * E008D_SalidaPorPantallaOtrosEfectos
 * 
 * Autor: Efrén Sánchez
 * Fecha: 23/09/2025
 * 
 * Salida por pantalla: formato de texto
 * 
 ******************************************************************************/
public class E008D_SalidaPorPantallaOtrosEfectos {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_STRIKETHROUGH = "\u001B[9m";
    public static final String ANSI_DOUBLE_UNDERLINE = "\u001B[21m";
    public static final String ANSI_HIDDEN = "\u001B[8m";   // OJO: no acaba de funcionar

    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("\n\n\n* E008D_SalidaPorPantallaOtrosEfectos *\n\n  --- Inicio del programa ---\n\n");

        System.out.println(ANSI_STRIKETHROUGH + "Texto tachado" + ANSI_RESET);
        System.out.println(ANSI_DOUBLE_UNDERLINE + "Texto doble subrayado" + ANSI_RESET);
        System.out.print("Texto oculto (será invisible por 2 segundos)");
        Thread.sleep(2000);
        System.out.print(ANSI_HIDDEN); // OJO: no acaba de funcionar
        Thread.sleep(2000);
        System.out.print(ANSI_RESET);
        System.out.println(" <-- ahora visible de nuevo");

        /*
        Existen códigos ANSI adicionales y combinaciones que permiten funcionalidades más avanzadas y personalizados, tales como:
        Control de la visibilidad del cursor:
            Ocultar cursor: \u001B[?25l
            Mostrar cursor: \u001B[?25h
        Guardar y restaurar posición del cursor:
            Guardar posición: \u001B[s
            Restaurar posición: \u001B[u
        Borrado selectivo:
            Borrar desde cursor hasta el inicio de línea: \u001B[1K
            Borrar toda la línea: \u001B[2K
            Borrar desde cursor hasta inicio de pantalla: \u001B[1J
            Borrar desde cursor hasta final de pantalla: \u001B[0J
        Modo de teclado alternativo (útil para aplicaciones de texto avanzadas):
            Habilitar modo del teclado alternativo: \u001B[?1049h
            Deshabilitar modo del teclado alternativo: \u001B[?1049l
        Control del scroll en pantalla:
            Limitar área de scroll (scrolling region): \u001B[<top>;<bottom>r
        */

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}
