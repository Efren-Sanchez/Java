/*******************************************************************************
 * 
 * E097_CuentaCaracter
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Busca palabras
 *
 * Programa que busca una palabra en un texto dado.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E097_CuentaCaracter {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E097_CuentaCaracter *\n\n  --- Inicio del programa ---\n\n");
		
        Scanner sc = new Scanner(System.in);
		String texto;
		char caracter;
		int apariciones = 0;
		
		System.out.print("Por favor, introduce un texto: ");
		texto = sc.nextLine();
		
		System.out.print("Por favor, introduce el carcáter a contar: ");
		caracter = sc.next().charAt(0);
		
		// Contamos las apariciones del caracter en el texto
		
		// El bucle recorre el texto caracter a caracter, desde la posición 0 a la posición (length - 1)
		for (int i = 0; i < texto.length(); i++)
		{
			// Para cada caracter del texto comprobamos si es el mismo que el caracter que queremos contar
			if (texto.charAt(i) == caracter)	// texto.charAt(i) devuelve el char en la posición i de texto 
			{
				apariciones++;
			}
		}
		
		System.out.print("El carácter " + caracter + " aparece " + apariciones + " veces en el texto.");

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}