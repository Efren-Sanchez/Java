/*******************************************************************************
 * 
 * E079D_Primo
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Números primos
 *
 * Programa que va pidiendo números por teclado y determina si son primos o no
 * (0 para salir).
 * 
 * Más información: https://es.wikipedia.org/wiki/N%C3%BAmero_primo
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E079D_Primo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E079D_Primo *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
		int num;
		boolean salir;
		
		System.out.print("Programa que determina si un número es primo");
		System.out.print("--------------------------------------------\n\n");
		
		while(true) {	// Bucle infinito
			System.out.print("\nPor favor, introduce un número mayor que 1 (0 para salir): ");
			num = sc.nextInt();
			
			salir = false;
			
			if (num == 0) {
				sc.close();
				System.out.println("\n\n  --- Fin del programa ---\n\n");
				return;	// Si el usuario pulsa 0 salimos
			}
			
			// Recorro los números desde 2 hasta la raiz cuadrada de num (no es necesario ir más allá. Es imposible que haya multiplos... Cosas de las matemáticas)
			for (int i = 2; i <= Math.sqrt(num); i++) {
				// Si encuentro un divisor, entonces es que el número no es primo
				if (num % i == 0) {
					System.out.println("El número " + num + " NO es primo");
					salir = true;
					break;
				}
			}
			
			if (!salir) System.out.println("El número " + num + " es PRIMO");		
		}
    }
}