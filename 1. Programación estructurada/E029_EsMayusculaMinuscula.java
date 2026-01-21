/*******************************************************************************
 * 
 * E029_EsMayusculaMinuscula
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

public class E029_EsMayusculaMinuscula {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E029_EsMayusculaMinuscula *\n\n  --- Inicio del programa ---\n\n");

		char caracter;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Es mayúscula o minúscula?\n\n");
		
		System.out.println("Por favor, introduce un caracter: ");
		caracter = sc.next().charAt(0);

		// Utilizamos el código de los caracteres para saber si son mayúsculas o minúsculas
		if (caracter >= 65 && caracter <= 90)
			System.out.println("El caracter introducido es una MAYÚSCULA");
		else if (caracter >= 97 && caracter <= 122)
			System.out.println("El caracter introducido es una minúscula");
		else
			System.out.println("El caracter introducido no es una letra del alfabeto inglés");
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}