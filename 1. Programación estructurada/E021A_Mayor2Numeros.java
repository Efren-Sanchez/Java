/*******************************************************************************
 * 
 * E021A_Mayor2Numeros
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

public class E021A_Mayor2Numeros {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E021A_Mayor2Numeros *\n\n  --- Inicio del programa ---\n\n");

		double num1, num2, mayor;
		Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce el valor del primer número: ");
        num1 = sc.nextDouble();		

		System.out.println("\nIntroduce el valor del segundo número: ");
        num2 = sc.nextDouble();	

		if (num1 > num2) mayor = num1;
		else			 mayor = num2;
		
		System.out.println("\nEl mayor es: " + mayor);

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}