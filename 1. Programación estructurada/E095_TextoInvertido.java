/*******************************************************************************
 * 
 * E095_TextoInvertido
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Texto inverso
 *
 * Programa que invierte un texto dado.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E095_TextoInvertido {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E095_TextoInvertido *\n\n  --- Inicio del programa ---\n\n");
		
        Scanner sc = new Scanner(System.in);
		String texto;
		
		System.out.print("Por favor, introduce un texto: ");
		texto = sc.nextLine();

		// Imprimimos el texto en una línea
		for (int i = 0; i < texto.length(); i++)
			System.out.print(texto.charAt(texto.length() - 1 - i));

		System.out.println("\n");

		// Imprimimos cada letra en una línea
		for (int i = 0; i < texto.length(); i++)
			System.out.println(texto.charAt(texto.length() - 1 - i));

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}