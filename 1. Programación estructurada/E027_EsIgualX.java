/*******************************************************************************
 * 
 * E027_EsIgualX
 * 
 * Autor: Efrén Sánchez
 * Fecha: 1/10/2025
 * 
 * Par o impar
 *
 * Programa que pide tres números al usuario, y después un cuarto, e indica si 
 * el cuarto número es igual a alguno de los anteriores
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E027_EsIgualX {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E027_EsIgualX *\n\n  --- Inicio del programa ---\n\n");

		int X, A, B, C;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Numeros iguales?\n\n");
		
		System.out.println("Por favor, introduce el valor de A: ");
		A = sc.nextInt();
		System.out.println("Por favor, introduce el valor de B: ");
		B = sc.nextInt();
		System.out.println("Por favor, introduce el valor de C: ");
		C = sc.nextInt();
		System.out.println("Por favor, introduce el valor de X: ");
		X = sc.nextInt();

		if (X == A || X == B || X == C)
			System.out.println("El valor de X es igual al valor de A, B o C");
		else
			System.out.println("El valor de X NO 5es igual al valor de A, B o C");
				
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}