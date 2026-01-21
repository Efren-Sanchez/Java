/*******************************************************************************
 * 
 * E077B_TablasMultiplicar
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Tablas de multiplicar
 *
 * Programa que muestra por pantalla las tabla de multiplicar en forma de 
 * matriz.
 * 
 ******************************************************************************/

public class E077B_TablasMultiplicar {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E077B_TablasMultiplicar *\n\n  --- Inicio del programa ---\n\n");

        int tabla, fila;

        System.out.print("      ");
        for (tabla = 0; tabla <= 10; tabla++) {
            System.out.printf("%3d ", tabla);
        }
        System.out.print("\n    +--------------------------------------------\n");

        for (tabla = 0; tabla <= 10; tabla++) {
            // Esta instruccion es para la columna de cabecera
            System.out.printf("%3d | ", tabla);
            
            // Este bucle pinta cada una de las líneas
            for (fila = 0; fila <= 10; fila++) {
                System.out.printf("%3d ", (tabla*fila));
            }
            System.out.print("\n");
        }

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}