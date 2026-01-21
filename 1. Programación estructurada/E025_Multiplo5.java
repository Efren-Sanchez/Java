/*******************************************************************************
 * 
 * E025_Multiplo5
 * 
 * Autor: Efrén Sánchez
 * Fecha: 1/10/2025
 * 
 * Par o impar
 *
 * Programa que pide un número por teclado e indica si es par o impar.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E025_Multiplo5 {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E025_Multiplo5 *\n\n  --- Inicio del programa ---\n\n");

		int numero;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Por favor, introduce un número y te diré si es múltiplo de 5");
		numero = sc.nextInt();
		
		// Condición simple if
		if (numero % 5 == 0) {	// ¿El número es multiplo de 5?
			System.out.println("El número introducido es múltiplo de 5 :D");
		} else {
			System.out.println("El número introducido es múltiplo de 5 :D");
		}

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}