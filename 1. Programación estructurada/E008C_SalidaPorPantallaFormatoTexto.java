/*******************************************************************************
 * 
 * E008C_SalidaPorPantallaFormatoTexto
 * 
 * Autor: Efrén Sánchez
 * Fecha: 23/09/2025
 * 
 * Salida por pantalla: formato de texto
 * 
 ******************************************************************************/
public class E008C_SalidaPorPantallaFormatoTexto {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_DIM = "\u001B[2m";
    public static final String ANSI_ITALIC = "\u001B[3m";
    public static final String ANSI_UNDERLINE = "\u001B[4m";
    public static final String ANSI_BLINK = "\u001B[5m";
    public static final String ANSI_REVERSE = "\u001B[7m";

    public static void main(String[] args) {

        System.out.println("\n\n\n* E008C_SalidaPorPantallaFormatoTexto *\n\n  --- Inicio del programa ---\n\n");

        System.out.println(ANSI_BOLD + "Texto en negrita" + ANSI_RESET);
        System.out.println(ANSI_DIM + "Texto difuminado/opaco" + ANSI_RESET);
        System.out.println(ANSI_ITALIC + "Texto en cursiva" + ANSI_RESET);
        System.out.println(ANSI_UNDERLINE + "Texto subrayado" + ANSI_RESET);
        System.out.println(ANSI_BLINK + "Texto parpadeante" + ANSI_RESET);
        System.out.println(ANSI_REVERSE + "Texto colores invertidos" + ANSI_RESET);

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}
