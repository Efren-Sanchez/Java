/*******************************************************************************
 * 
 * E071_De100A1For
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * De 100 a 1
 *
 * Programa que muestra por pantalla los números de 100 a 1.
 * 
 ******************************************************************************/

public class E071_De100A1For {
    public static void main(String[] args) {

        System.out.println("\n\n\n* E071_De100A1For *\n\n  --- Inicio del programa ---\n\n");

        for (int i = 100; i >= 1; i--) {
          System.out.print(i + ", ");
          if (i % 10 == 0) System.out.print("\n");
        }

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}