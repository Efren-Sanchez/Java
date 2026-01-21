/**
 * E112_FibonacciRecursivo
 * 
 * @author Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Fibonacci recursivo
 * 
 * Programa que muestra el término de la sucesión de Fibonacci que le indica el usuario.
 * Se muestra en pantalla el tiempo invertido en cada proceso.
 * 
 */

import java.util.Scanner;

public class E112_FibonacciRecursivo {
	public static void main(String[] args) {

		System.out.println("\n\n\n* E112_FibonacciRecursivo *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		int numero = 0;
		char opcion;
		long t1Ini, t1Fin, t1Total, t2Ini, t2Fin, t2Total;
		
		do {
			System.out.print("\n\nIntroduce el número del término de la serie de Fibonacci que quieres saber: ");
			numero = sc.nextInt();

			t1Ini = System.nanoTime();
			System.out.println("\n\nEl término " + numero + " es: " + fibonacciRecursivo(numero) + " --> Calculado recursivamente");
			t1Fin = System.nanoTime(); 
			t1Total = t1Fin - t1Ini;
			System.out.println("\n" + t1Total + " nanosegundos invertidos en este proceso.\n");
 
			t2Ini = System.nanoTime();
			System.out.println("\nEl término " + numero + " es: " + fibonacciIterativo(numero) + " --> Calculado iterativamente");
			t2Fin = System.nanoTime(); 
			t2Total = t2Fin - t2Ini;
			System.out.println("\n" + t2Total + " nanosegundos invertidos en este proceso.");

			
			System.out.print("\n\n................................................");			
			System.out.print("\n\n¿Quieres volver a calcular otro término de la sucesión de Fibonacci? (S/N) ");			
			opcion = sc.next().charAt(0);	
			System.out.print("\n\n................................................");			
		} while (opcion != 'n' && opcion != 'N');	

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
	}
	
	/**
	 * Función: fibonacciRecursivo
	 * 
	 * Calcula el término indicado de la sucesión de Fibonacci
	 * 
	 * Entrada:
	 * @param int n			Entero positivo que indica el término de la sucesión de Fibonacci a calcular
	 * 
	 * Salida:
	 * @return int			Valor del término
	 * 
	 */
	static int fibonacciRecursivo(int n)
	{	
		// Condición de parada
		if (n <= 2)
			return 1;
		// Caso general
		else
			return (fibonacciRecursivo(n -1) + fibonacciRecursivo(n - 2)); // Llamada a la propia función
	}

	/**
	 * Función: fibonacciIterativo
	 * 
	 * Calcula el factorial de un número de manera iterativa
	 * 
	 * Entrada:
	 * @param int n			Entero positivo que indica el término de la sucesión de Fibonacci a calcular
	 * 
	 * Salida:
	 * @return int			Valor del término
	 * 
	 */
	static int fibonacciIterativo(int n)
	{	
		int f1 = 1, f2 = 1, fact = 0;
		
		for (int i = 3; i <= n; i++)
		{
			fact = f1 + f2;
			f1 = f2;
			f2 = fact;
		}
		
		return fact;
	}
}
