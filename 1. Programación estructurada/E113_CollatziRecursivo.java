/**
 * E113_CollatziRecursivo
 * 
 * @author Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Conjetura de Collatz recursiva
 * 
 * Programa que muestra la conjetura de Collatz sobre un número introducido 
 * por teclado.
 * 
 * Sea la siguiente operación, aplicable a cualquier número entero positivo:
 * - Si el número es par, se divide entre 2. 
 * - Si el número es impar, se multiplica por 3 y se suma 1.
 * 
 * Ahora, se forma una sucesión mediante la aplicación de esta operación 
 * repetidamente, comenzando por cualquier entero positivo, y tomando el 
 * resultado de cada paso como la entrada del siguiente.
 * 
 * La conjetura dice que siempre alcanzaremos el 1 independientemente del 
 * número con el que comencemos.
 * 
 * La conjetura de Collatz, conocida también como conjetura 3n+1 o conjetura 
 * de Ulam (entre otros nombres), fue enunciada por el matemático Lothar 
 * Collatz en 1937, y aún no ha sido resuelta.
 * 
 * https://es.wikipedia.org/wiki/Conjetura_de_Collatz
 * 
 */

import java.util.Scanner;

public class E113_CollatziRecursivo {
	public static void main(String[] args) {

		System.out.println("\n\n\n* E113_CollatziRecursivo *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num = sc.nextInt();

        conjeturaRecursiva(num);
        conjeturaIterativa(num);

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
	}
	
	/**
	 * Función: conjeturaRecursiva
	 * 
	 * Intenta demostrar la conjetura de Collatz de manera recursiva.
	 * 
	 * Entrada:
	 * @param int n			Entero positivo sobre el que demostrar la conjetura de Collatz
	 * 
	 * Salida: void
	 * 
	 */
    public static void conjeturaRecursiva(int n) {
        System.out.println(n);
        if (n == 1) return;     // Caso final / Caso base

        // Caso general
        if (n % 2 == 0) conjeturaRecursiva(n/2);
        else            conjeturaRecursiva((n * 3) + 1);
    }

	/**
	 * Función: conjeturaIterativa
	 * 
	 * Intenta demostrar la conjetura de Collatz de manera iterativa.
	 * 
	 * Entrada:
	 * @param int n			Entero positivo sobre el que demostrar la conjetura de Collatz
	 * 
	 * Salida: void
	 * 
	 */
    public static void conjeturaIterativa(int n) {
        System.out.println("\n\n--------------------------");
        System.out.println(n);
        /*
        //while (n > 1) {
        while (n != 1) {
            if (n % 2 == 0) n = n/2;
            else            n = (n * 3) + 1;
            System.out.println(n);
        }
        */
        for( ; n!= 1; ) {
            System.out.println(n);
            if (n % 2 == 0) n = n/2;
            else            n = (n * 3) + 1;
        }
    }
}