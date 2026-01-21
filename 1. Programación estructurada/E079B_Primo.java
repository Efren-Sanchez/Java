/*******************************************************************************
 * 
 * E079B_Primo
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * ¿Es un número primo?
 *
 * Programa que comprueba si un número introducido por teclado es primo o no.
 * 
 * Realmente, no hace falta recorrer todos los divisores entre 2 y N-1. Con
 * recorrer de 2 a la raiz de N es suficiente.
 * 
 * Más información: https://es.wikipedia.org/wiki/N%C3%BAmero_primo
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E079B_Primo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E079B_Primo *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("Por favor, introduce un número para saber si es primo:");
        n = sc.nextInt();

        for (int i = 2; i <= Math.sqrt(n); i++) {    // Recorremos hasta la raiz
            if (n % i == 0) {   // Comprobamos si es divisible
                System.out.println("El número " + n + " NO es primo.");
                sc.close();
                return; // Salgo del programa
            }
        }

        // Si llego hasta aquí es que no hay divisores
        System.out.println("El numero es PRIMO!! :D");
        
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}