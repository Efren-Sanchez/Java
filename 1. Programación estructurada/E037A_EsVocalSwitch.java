/*******************************************************************************
 * 
 * E037A_EsVocalSwitch
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

public class E037A_EsVocalSwitch {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E037A_EsVocalSwitch *\n\n  --- Inicio del programa ---\n\n");

		char caracter;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Es vocal o no?\n\n");
		
		System.out.println("Por favor, introduce un caracter: ");
		caracter = sc.next().charAt(0);

		switch(caracter)
		{
			// Vocales minúsculas
			case 97:
			case 101:
			case 105:
			case 111:
			case 117:
				System.out.println("Has introducido una vocal (en minúsculas)");
				break;
			
			// Vocales mayúsculas
			case 65:
			case 69:
			case 73:
			case 79:
			case 85:
				System.out.println("Has introducido una vocal (en mayúsculas)");
				break;
			
			// Todo lo demás
			default:
				System.out.println("El caracter introducido NO es una vocal");			
		}
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}