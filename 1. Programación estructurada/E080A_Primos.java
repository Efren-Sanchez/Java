/*******************************************************************************
 * 
 * E080A_Primos
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Números primos del 2 hasta N
 *
 * Programa que calcula los números primos comprendidos entre el 2 y un nçumero
 * introducido por teclado.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E080A_Primos {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E080A_Primos *\n\n  --- Inicio del programa ---\n\n");
		
        Scanner sc = new Scanner(System.in);
        int n;
        boolean esPrimo = true;
		
		System.out.print("Por favor, introduce un número para calcular los primos hasta él:");
		n = sc.nextInt();

        for (int num = 2; num <= n; num++) {
            esPrimo = true;
            for (int i = 2; i < Math.sqrt(num); i++) {
                if (num % i == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo) System.out.print(num + ", ");
        }

		sc.close();
		
		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}