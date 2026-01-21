/*******************************************************************************
 * 
 * E077_TablasMultiplicar
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * De 1 a 100
 *
 * Programa que muestra por pantalla los números de 1 a 100.
 * 
 ******************************************************************************/

public class E077_TablasMultiplicar {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E077_TablasMultiplicar *\n\n  --- Inicio del programa ---\n\n");

        int tabla = 0, ini = 0, fin = 10;

        for ( ; tabla <= 10; tabla++) {

            System.out.println("Tabla del " + tabla);
            System.out.println("------------\n");
            
            for (int i = ini; i <= fin; i++) {
                System.out.println(tabla + " x " + i + " = " + (tabla*i));
            }
            
            System.out.println("\n");
        }

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}