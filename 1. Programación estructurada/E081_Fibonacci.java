/*******************************************************************************
 * 
 * E081_Fibonacci
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

public class E081_Fibonacci {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E081_Fibonacci *\n\n  --- Inicio del programa ---\n\n");
		
        Scanner sc = new Scanner(System.in);
        int num, n1 = 0, n2 = 1, n;

        System.out.println("Introduce un numero: ");
        num = sc.nextInt();

        if (num < 0) System.out.println("El número introducido es incorrecto!!!");
        else {
            System.out.print("\n\n\nSerie de Fibonacci: 0, 1, ");

            //for (int i = 1; i <= num; i++) {
            for (int i = 3; i <= num; i++) {            
                n = n2 + n1;    // Calculo el siguiente término a partir de los dos anteriores
                System.out.print(n + ", ");

                // Sustituyo n1 por n2, y el nuevo número calculado lo meto en n2
                // Intercambiamos las variables necesarias para la siguiente iteración
                n1 = n2;
                n2 = n;
            }
        }

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}