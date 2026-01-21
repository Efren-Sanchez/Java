/*******************************************************************************
 * 
 * E079_Primo
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * ¿Es un número primo?
 *
 * Programa que comprueba si un número introducido por teclado es primo o no.
 * 
 * En este caso, podemos demostrar que un número N sea primo comprobando que no 
 * tiene divisores entre el 2 y N-1.
 * - Si demuestro que tiene algún divisor, no es primo.
 * - Si no consigo encontrar ningún divisor, entonces el número es primo.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E079_Primo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E079_Primo *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        int n;
        boolean esPrimo = true;

        System.out.println("Por favor, introduce un número para saber si es primo:");
        n = sc.nextInt();

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {   // Comprobamos si es divisible
                System.out.println("El número " + n + " NO es primo.");
                esPrimo = false;
                break;  // En cuanto encuentro un divisor ya he demostrado que NO es primo, salgo del bucle
            }
        }

        if(esPrimo) System.out.println("El numero es PRIMO!! :D");
        
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}