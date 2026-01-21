/*******************************************************************************
 * 
 * E070B_De1A100For
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * De 1 a 100
 *
 * Programa que muestra por pantalla los números de 1 a 100 en filas de 10.
 * 
 ******************************************************************************/

public class E070B_De1A100For {
    public static void main(String[] args) {

        System.out.println("\n\n\n* E070B_De1A100For *\n\n  --- Inicio del programa ---\n\n");

        for (int i = 1; i <= 100; i++) {
            System.out.print(i + ", ");
            if (i % 10 == 0) System.out.print("\n");
        }

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}