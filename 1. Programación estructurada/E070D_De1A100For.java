/*******************************************************************************
 * 
 * E070D_De1A100For
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * De 1 a 100
 *
 * Programa que muestra por pantalla los números de 1 a 100. 
 * 
 ******************************************************************************/

public class E070D_De1A100For {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E070D_De1A100For *\n\n  --- Inicio del programa ---\n\n");

        int ini = 1,
            fin = 100,
            i = ini;    // Inicializamos i antes del bucle

        for ( ; i <= fin; i++)  // For sin inicialización, no podemos omitir los dos puntos
            System.out.println(i);

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}