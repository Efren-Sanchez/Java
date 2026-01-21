/**
 * E111_FactorialRecursivo
 * 
 * @author Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Factorial recursivo
 * 
 * Programa que resuelve el factorial de un número de manera recursiva.
 * 
 */

import java.util.Scanner;

public class E111_FactorialRecursivo {
	public static void main(String[] args) {

		System.out.println("\n\n\n* E111_FactorialRecursivo *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nIntroduce un numero: ");
        int num = sc.nextInt();

        System.out.println("\n\nEl factorial de " + num + " es: " + factorial(num));

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
	}
	

	/**
	 * Función: factorial
	 * 
	 * Calcula el factorial de un número
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada:
	 * @param long número	Número a calcular el factorial
	 * 
	 * Salida:
	 * @return long			Factorial
	 * 
	 */
    public static long factorial(long n) {
        if (n == 1) return 1;	// Caso base, rompe la recursión
        else return n * factorial(n-1);	// Caso general, recursivo
    }
}