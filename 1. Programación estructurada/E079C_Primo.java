/*******************************************************************************
 * 
 * E079C_Primo
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

public class E079C_Primo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E079C_Primo *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
		boolean esPrimo;
		int num = -1;
		
		System.out.print("Programa que determina si un número es primo");
		System.out.print("--------------------------------------------\n\n");
		
		while (num != 0) {
			// Para cada número introducido, tengo que inicializar esPrimo a true
			// Siempre asumo que el número introducido es primo e intento demostrar lo contrario
			esPrimo = true;
			
			System.out.print("\nPor favor, introduce un número mayor que 1 (0 para salir): ");
			num = sc.nextInt();

			if (num < 2 && num != 0) {	// Comprobación de errores
				System.out.println("Error al introducir el número. Debe ser mayor a 1.\n");
				continue; // Inicio una nueva vuelta de bucle
			}

			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					esPrimo = false;
					break;
				}
			}
			
			// Resultados finales
			//if (esPrimo && num != 0)	// OJO: si ponemos la condición en este orden, cuando el número no es primo falla
			// Primer evalua esPrimo, y si este es falso, ya no evalua el num != 0 por la evaluación con cortocircuito
			if (num != 0 && esPrimo) System.out.println("El número " + num + " es PRIMO");
			else        			 System.out.println("El número " + num + " NO es primo");
		}
        
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}