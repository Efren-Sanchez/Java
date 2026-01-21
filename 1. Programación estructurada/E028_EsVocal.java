/*******************************************************************************
 * 
 * E028_EsVocal
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

public class E028_EsVocal {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E028_EsVocal *\n\n  --- Inicio del programa ---\n\n");

		char caracter;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Es vocal o no?\n\n");
		
		System.out.println("Por favor, introduce un caracter: ");
		caracter = sc.next().charAt(0);
		
		if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u')
		{
			System.out.println("Has introducido una vocal (en minúsculas)");
		}
		else if (caracter == 'A' || caracter == 'E' || caracter == 'I' || caracter == 'O' || caracter == 'U')
		{
			System.out.println("Has introducido una vocal (en mayúsculas)");
		}
		else
		{
			System.out.println("El caracter introducido NO es una vocal");			
		}
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}