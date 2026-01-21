/*******************************************************************************
 * 
 * E023_Mayor3Numeros
 * 
 * Autor: Efrén Sánchez
 * Fecha: 1/10/2025
 * 
 * Mayor de dos números
 *
 * Programa quepide dos números por teclado e indica cuál es el mayor.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E023_Mayor3Numeros {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E023_Mayor3Numeros *\n\n  --- Inicio del programa ---\n\n");

		double num1, num2, num3, mayor;
		Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce el valor del primer número: ");
        num1 = sc.nextDouble();		

		System.out.println("\nIntroduce el valor del segundo número: ");
        num2 = sc.nextDouble();	

		System.out.println("\nIntroduce el valor del tercer número: ");
        num3 = sc.nextDouble();	

		// Calculamos el mayor entre los dos primeros números
		if (num1 > num2) mayor = num1;
		else			 mayor = num2;

		// Comparamos el mayor anterior con num3
		if (num3 > mayor) mayor = num3; // No hace falta poner else, si mayor > num3 no hay que volver a asignarlo

		System.out.println("\nEl mayor es: " + mayor);

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}