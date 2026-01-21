/*******************************************************************************
 * 
 * E031_Triangulos
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Triángulos
 *
 * Programa que lee la longitud de los tres lados de un triangulo y muestra que tipo de triángulo 
 * es, de acuerdo con la siguiente casuística:
 * a denota la longitud del lado mas largo y b y c denotan la longitud de los otros dos lados:
 * 
 * 		Si a ≥ b + c, no se trata de un triangulo
 * 		Si a2 = b2 + c2, es un triangulo rectángulo
 * 		Si a2 < b2 + c2, es un triangulo acutángulo
 * 		Si a2 > b2 + c2, es un triangulo obtusángulo 
 * 
 ******************************************************************************/

 import java.util.Scanner;

public class E031_Triangulos {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E031_Triangulos *\n\n  --- Inicio del programa ---\n\n");

		int A, B, C;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Qué tipo de triángulo es?\n\n");
		
		System.out.println("Por favor, introduce el valor de A: ");
		A = sc.nextInt();
		System.out.println("Por favor, introduce el valor de B: ");
		B = sc.nextInt();
		System.out.println("Por favor, introduce el valor de C: ");
		C = sc.nextInt();
		
		if (A >= B + C)
			System.out.println("Los lados introducidos no forman un triángulo");
		else if (Math.pow(A,2) == (Math.pow(B,2) + Math.pow(C,2)))
			System.out.println("Triángulo rectángulo");
		else if (Math.pow(A,2) < (Math.pow(B,2) + Math.pow(C,2)))
			System.out.println("Triángulo acutángulo");
		else if (Math.pow(A,2) > (Math.pow(B,2) + Math.pow(C,2)))
			System.out.println("Triángulo obtusángulo");
		else 
			System.out.println("Error: caso no esperado");
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}