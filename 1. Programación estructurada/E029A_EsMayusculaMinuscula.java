/*******************************************************************************
 * 
 * E029A_EsMayusculaMinuscula
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
//import java.util.Locale;
//import java.nio.charset.Charset; 

public class E029A_EsMayusculaMinuscula {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E029A_EsMayusculaMinuscula *\n\n  --- Inicio del programa ---\n\n");

		char caracter;
		//Scanner sc = new Scanner(System.in); 
		Scanner sc = new Scanner(System.in, "ISO-8859-1"); // Añadimos la codificación de la consola de Windows para que lea correctamente las eñes
		
		System.out.println("\n¿Es mayúscula o minúscula?\n\n");
		
		System.out.print("Por favor, introduce un caracter: ");
		caracter = sc.next().charAt(0);

		if ((caracter >= 65 && caracter <= 90) || caracter == 165)
			System.out.println("\n\nEl caracter introducido es una MAYÚSCULA");
		else if ((caracter >= 97 && caracter <= 122) || caracter == 164) 
			System.out.println("\n\nEl caracter introducido es una minúscula");
		else
			System.out.println("\n\nEl caracter introducido no es una letra del alfabeto inglés");
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}