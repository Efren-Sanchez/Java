/*******************************************************************************
 * 
 * E024A_ParImpar
 * 
 * Autor: Efrén Sánchez
 * Fecha: 1/10/2025
 * 
 * Par o impar
 *
 * Programa que pide un número por teclado e indica si es par o impar.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E024A_ParImpar {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E024A_ParImpar *\n\n  --- Inicio del programa ---\n\n");

		int numero;
		Scanner sc = new Scanner(System.in);

		System.out.println("\n\n\n  --- Inicio del programa ---\n\n");
		
		System.out.println("Por favor, introduce un número y te diré si es par o impar");
		numero = sc.nextInt();
		
		System.out.println("El número introducido es " + ((numero % 2 == 0) ? "par" : "impar"));

		System.out.println("\n\n  --- Fin del programa ---\n\n");

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}