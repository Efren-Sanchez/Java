/*******************************************************************************
 * 
 * E023A_Mayor3Numeros
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

public class E023A_Mayor3Numeros {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E023A_Mayor3Numeros *\n\n  --- Inicio del programa ---\n\n");

		double num1, num2, num3, mayor;
		Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce el valor del primer número: ");
        num1 = sc.nextDouble();		

		System.out.println("\nIntroduce el valor del segundo número: ");
        num2 = sc.nextDouble();	

		System.out.println("\nIntroduce el valor del tercer número: ");
        num3 = sc.nextDouble();	

		if 		(num1 >= num2 && num1 >= num3) mayor = num1;
		else if (num2 >= num1 && num2 >= num3) mayor = num2;
		else								   mayor = num3;

		System.out.println("\nEl mayor es: " + mayor);

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}