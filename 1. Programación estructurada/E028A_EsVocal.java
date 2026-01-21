/*******************************************************************************
 * 
 * E028A_EsVocal
 * 
 * Autor: Efrén Sánchez
 * Fecha: 1/10/2025
 * 
 * ¿Es vocal?
 *
 * Programa que indica si un carácter introducido por teclado es una vocal o no
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E028A_EsVocal {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E028A_EsVocal *\n\n  --- Inicio del programa ---\n\n");

		char caracter;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Es vocal o no?\n\n");
		
		System.out.println("Por favor, introduce un caracter: ");
		caracter = sc.next().charAt(0);
		
		// Vocales mayúsculas
		if (caracter == 65 || caracter == 69 || caracter == 73 || caracter == 79 || caracter == 85)
		{
			System.out.println("Has introducido una vocal (en mayúsculas)");
		}
		// Vocales minúsculas
		else if (caracter == 97 || caracter == 101 || caracter == 105 || caracter == 111 || caracter == 117)
		{
			System.out.println("Has introducido una vocal (en minúsculas)");
		}
		// Todo lo demás
		else
		{
			System.out.println("El caracter introducido NO es una vocal");			
		}
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}