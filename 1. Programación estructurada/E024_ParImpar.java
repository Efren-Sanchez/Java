/*******************************************************************************
 * 
 * E024_ParImpar
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

public class E024_ParImpar {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E024_ParImpar *\n\n  --- Inicio del programa ---\n\n");

		int numero;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Por favor, introduce un número y te diré si es múltiplo de 5");
		numero = sc.nextInt();
		
		// Preguntamos si el número es par
		if (numero % 2 == 0)
		{
			System.out.println("Es par!! :D");
		}
		// Si no lo es
		else
		{
			System.out.println("Es IMPAR!! :(");
		}
		
		// Este bloque de código es equivalente al anterior más largo
		/* 
		if (numero % 2 == 0) 	System.out.println("Es par!! :D");
		else 					System.out.println("Es IMPAR!! :(");
		*/
		
		System.out.println("Fin");

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}