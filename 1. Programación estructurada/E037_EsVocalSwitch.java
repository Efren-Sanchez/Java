/*******************************************************************************
 * 
 * E037_EsVocalSwitch
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * ¿Es vocal?
 *
 * Programa que indica si un carácter introducido por teclado es una vocal o no
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E037_EsVocalSwitch {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E037_EsVocalSwitch *\n\n  --- Inicio del programa ---\n\n");

		char caracter;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Es vocal o no?\n\n");
		
		System.out.println("Por favor, introduce un caracter: ");
		caracter = sc.next().charAt(0);
		
		switch(caracter)
		{
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				System.out.println("Has introducido una vocal (en minúsculas)");
				break;
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
				System.out.println("Has introducido una vocal (en mayúsculas)");
				break;
			default:
				System.out.println("El caracter introducido NO es una vocal");			
		}
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}