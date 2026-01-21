/*******************************************************************************
 * 
 * E008A_SalidaPorPantallaColores
 * 
 * Autor: Efrén Sánchez
 * Fecha: 23/09/2025
 * 
 * Salida por pantalla: colores de texto y fondo
 * 
 ******************************************************************************/
public class E008A_SalidaPorPantallaColores {
    // Colores de texto (fuente)
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_MAGENTA = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Colores de texto brillantes
    public static final String ANSI_BRIGHT_BLACK = "\u001B[90m";
    public static final String ANSI_BRIGHT_RED = "\u001B[91m";
    public static final String ANSI_BRIGHT_GREEN = "\u001B[92m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BRIGHT_BLUE = "\u001B[94m";
    public static final String ANSI_BRIGHT_MAGENTA = "\u001B[95m";
    public static final String ANSI_BRIGHT_CYAN = "\u001B[96m";
    public static final String ANSI_BRIGHT_WHITE = "\u001B[97m";

    // Colores de fondo
    public static final String ANSI_BG_BLACK = "\u001B[40m";
    public static final String ANSI_BG_RED = "\u001B[41m";
    public static final String ANSI_BG_GREEN = "\u001B[42m";
    public static final String ANSI_BG_YELLOW = "\u001B[43m";
    public static final String ANSI_BG_BLUE = "\u001B[44m";
    public static final String ANSI_BG_MAGENTA = "\u001B[45m";
    public static final String ANSI_BG_CYAN = "\u001B[46m";
    public static final String ANSI_BG_WHITE = "\u001B[47m";

    // Fondos brillantes
    public static final String ANSI_BG_BRIGHT_BLACK = "\u001B[100m";
    public static final String ANSI_BG_BRIGHT_RED = "\u001B[101m";
    public static final String ANSI_BG_BRIGHT_GREEN = "\u001B[102m";
    public static final String ANSI_BG_BRIGHT_YELLOW = "\u001B[103m";
    public static final String ANSI_BG_BRIGHT_BLUE = "\u001B[104m";
    public static final String ANSI_BG_BRIGHT_MAGENTA = "\u001B[105m";
    public static final String ANSI_BG_BRIGHT_CYAN = "\u001B[106m";
    public static final String ANSI_BG_BRIGHT_WHITE = "\u001B[107m";

    // Reset para volver al color por defecto
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        System.out.println("\n\n\n* E008A_SalidaPorPantallaColores *\n\n  --- Inicio del programa ---\n\n");

        System.out.println(ANSI_BG_YELLOW + ANSI_RED + "Texto rojo con fondo amarillo" + ANSI_RESET);
        System.out.println(ANSI_BG_BLACK + ANSI_GREEN + "Texto verde con fondo negro" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Texto solo azul" + ANSI_RESET);

        System.out.println(ANSI_BG_BRIGHT_BLUE + ANSI_BRIGHT_YELLOW + "Texto amarillo brillante con fondo azul brillante" + ANSI_RESET);
        System.out.println(ANSI_BG_BRIGHT_WHITE + ANSI_BRIGHT_MAGENTA + "Texto magenta brillante con fondo blanco brillante" + ANSI_RESET);
        System.out.println(ANSI_BG_GREEN + ANSI_BRIGHT_BLACK + "Texto negro brillante con fondo verde" + ANSI_RESET);
        System.out.println(ANSI_BG_RED + ANSI_BRIGHT_CYAN + "Texto cian brillante con fondo rojo" + ANSI_RESET);
        System.out.println(ANSI_BG_MAGENTA + ANSI_WHITE + "Texto blanco con fondo magenta" + ANSI_RESET);

        /*
        Otros formatos extendidos
        Texto 256 colores: \u001B[38;5;<n>m (n = 0..255)
        Fondo 256 colores: \u001B[48;5;<n>m
        Texto RGB: \u001B[38;2;<r>;<g>;<b>m
        Fondo RGB: \u001B[48;2;<r>;<g>;<b>m
        */

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}