/*******************************************************************************
 * 
 * E026_Multiplo2Y5
 * 
 * Autor: Efrén Sánchez
 * Fecha: 1/10/2025
 * 
 * Par o impar
 *
 * Programa que pide un número por teclado e indica si un número es múltiplo de 2, 5, o 2 y 5 a la vez.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E026_Multiplo2Y5 {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E026_Multiplo2Y5 *\n\n  --- Inicio del programa ---\n\n");

		int numero;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Por favor, introduce un número y te diré si es múltiplo de 5");
		numero = sc.nextInt();
		
		// Si el número es multiplo de 2 y 5
		if ((numero % 2 == 0) && (numero % 5 == 0))
		{
			System.out.println("Es multiplo de 2 y de 5");
		}
		// Si no lo es, preguntamos por separado
		else
		{
			if (numero % 2 == 0)
			{
				System.out.println("Es multiplo de 2");
			}
			
			if (numero % 5 == 0)
			{
				System.out.println("Es multiplo de 5");
			}
		}

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}