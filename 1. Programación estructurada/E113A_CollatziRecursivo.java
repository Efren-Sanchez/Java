/**
 * E113A_CollatziRecursivo
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

public class E113A_CollatziRecursivo {
	public static void main(String[] args) {

		System.out.println("\n\n\n* E113A_CollatziRecursivo *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		int numero = 0;
		char opcion;
		long t1Ini, t1Fin, t1Total, t2Ini, t2Fin, t2Total;
		
		do {
			System.out.print("\n\nIntroduce el valor para carlular su conjetura de Collatz: ");
			numero = sc.nextInt();


			t1Ini = System.nanoTime();
			collatzRecursivo(numero);
			System.out.println("\n\n --> Calculado recursivamente");
			t1Fin = System.nanoTime(); 
			t1Total = t1Fin - t1Ini;
			System.out.println("\n" + t1Total + " nanosegundos invertidos en este proceso.\n");

			t2Ini = System.nanoTime();
			collatzIterativo(numero);
			System.out.println("\n\n --> Calculado iterativamente");
			t2Fin = System.nanoTime(); 
			t2Total = t2Fin - t2Ini;
			System.out.println("\n" + t2Total + " nanosegundos invertidos en este proceso.");

			if (t1Total > t2Total)
				System.out.println("\nEl proceso recursivo es " + ((t1Total - t2Total) * 1e-9) + " segundos más lento.");
			else
				System.out.println("\nEl proceso iterativo es " + ((t2Total - t1Total) * 1e-9) + " segundos más lento.");
			
			System.out.print("\n\n.................................................");			
			System.out.print("\n\n¿Quieres volver a calcular otra conjetura de Collatz? (S/N) ");			
			opcion = sc.next().charAt(0);	
			System.out.print("\n\n.................................................");			
		} while (opcion != 'n' && opcion != 'N');	

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
	}
	
	/**
     * Función: collatzRecursivo
     * 
     * Imprime el número pasado como parámetro y calcula el siguiente término de
     * la sucesión de Collatz haciendo una llamada recursiva
     * 
     * Entrada:
     * @param int n			Entero positivo término de la conjetura de Collatz
     * 
     * Salida:
     * @return int			Llamada recursiva excepto para el 1
     * 
	 */
	static int collatzRecursivo(int n)
	{	
		System.out.print(n + ", ");			
		
		// Condición de parada
		if (n == 1) return 1;
		
        // Caso general
		else if (n % 2 == 0) return collatzRecursivo(n / 2); 
		else    			 return collatzRecursivo(3 * n + 1);
	}

	/**
	 * Función: collatzIterativo
	 * 
	 * Muestra por pantalla todos los términos de la conjetura de Collatz
	 * partiendo del número suministrado como parámetro
	 * 
	 * Entrada:
	 * @param int n			Entero positivo término de la conjetura de Collatz
	 * 
	 * Salida: void
	 * 
	 */
	static void collatzIterativo(int n)
	{	
		System.out.print(n + ", ");			
		
		while(n != 1) {
			if (n % 2 == 0) n = n/2;
			else 			n = (3 * n) + 1;
			System.out.print(n + ", ");
		}
	}

}