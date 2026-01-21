/**
 * E111A_FactorialRecursivo
 * 
 * @author Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Factorial recursivo
 * 
 * Programa que resuelve el factorial de un número de manera recursiva e
 * iterativa.
 * 
 * Se muestra en pantalla el tiempo invertido en cada proceso.
 * Nanosegundo: 10e-9 segundos
 * 
 */

import java.util.Scanner;

public class E111A_FactorialRecursivo {
	public static void main(String[] args) {

		System.out.println("\n\n\n* E111A_FactorialRecursivo *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		int numero = 0;
		char opcion;
		long t1Ini, t1Fin, t1Total, t2Ini, t2Fin, t2Total;
		
		do {
			System.out.print("\n\nIntroduce el valor para carlular su factoral: ");
			numero = sc.nextInt();

			t1Ini = System.nanoTime();
			System.out.println("\n\n" + numero + "! = " + factorialRecursivo(numero) + " --> Calculado recursivamente");
			t1Fin = System.nanoTime(); 
			t1Total = t1Fin - t1Ini;
			System.out.println("\n" + t1Total + " nanosegundos invertidos en este proceso.\n");

			t2Ini = System.nanoTime();
			System.out.println("\n" + numero + "! = " + factorialIterativo(numero) + " --> Calculado iterativamente");
			t2Fin = System.nanoTime(); 
			t2Total = t2Fin - t2Ini;
			System.out.println("\n" + t2Total + " nanosegundos invertidos en este proceso.");

			if (t1Total > t2Total)
				System.out.println("\nEl proceso recursivo es " + ((t1Total - t2Total) * 1e-9) + " segundos más lento.");
			else
				System.out.println("\nEl proceso iterativo es " + ((t2Total - t1Total) * 1e-9) + " segundos más lento.");
			
			System.out.print("\n\n.................................................");			
			System.out.print("\n\n¿Quieres volver a calcular otro factorial? (S/N) ");			
			opcion = sc.next().charAt(0);	
			System.out.print("\n\n.................................................");			
		} while (opcion != 'n' && opcion != 'N');	

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
	}
	

	/**
	 * Función: factorialRecursivo
	 * 
	 * Calcula el factorial de un número de manera recursiva
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada:
	 * @param int n		Número a calcular el factorial
	 * 
	 * Salida:
	 * @return int		Factorial
	 * 
	 */
	static int factorialRecursivo(int n)
	{	
		// Condición de parada
		if (n <= 1)
			return 1;
		// Caso general
		else
			return n * factorialRecursivo(n - 1); // Llamada a la propia función
	}

	/**
	 * Función: factorialIterativo
	 * 
	 * Calcula el factorial de un número de manera iterativa
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada:
	 * @param int n		Número a calcular el factorial
	 * 
	 * Salida:
	 * @return int		Factorial
	 * 
	 */
	static int factorialIterativo(int n)
	{	
		int fact = 1;
		
		for (int i = 2; i <= n; i++)
			fact *= i; // Acumulamos el productorio
		
		return fact;
	}

}
