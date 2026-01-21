/*******************************************************************************
 * 
 * E077A_TablasMultiplicar
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Tablas de multiplicar
 *
 * Programa que muestra por pantalla las tabla de multiplicar de manera 
 * horizontal.
 * 
 ******************************************************************************/

public class E077A_TablasMultiplicar {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E077A_TablasMultiplicar *\n\n  --- Inicio del programa ---\n\n");

        int tabla, fila;

        for (fila = 0; fila <= 10; fila++) {
            for (tabla = 0; tabla <= 10; tabla++) {
                System.out.printf(" | %2d x %2d = %3d | ", tabla, fila, tabla*fila);
            }
            System.out.print("\n");
        }


		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}