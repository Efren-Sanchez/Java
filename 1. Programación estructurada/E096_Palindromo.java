/*******************************************************************************
 * 
 * E096_Palindromo
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

public class E096_Palindromo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E096_Palindromo *\n\n  --- Inicio del programa ---\n\n");
		
        Scanner sc = new Scanner(System.in);
		String texto;
		
		// Petición de datos
		System.out.println("\nPor favor, introduce un texto: ");
		texto = sc.nextLine();
		
		// Recorremos hasta la mitad del texto, ya que vamos mirando por delante
		// y por detrás al mismo tiempo. No hay problema en recorrer todo el texto,
		// pero es innecesario y, por lo tanto, ineficiente
		for (int i = 0; i < (texto.length() / 2); i++)
		
			// Intentamos demostrar que no es un palíndromo
			if (texto.charAt(i) != texto.charAt((texto.length() - 1) - i)) {
		
				// Si encontramos dos caracteres distintos no es palíndromo
				System.out.println("\nEl texto introducido NO es un palindromo");			
				sc.close();
				return;
			}
		
		// Si no podemos demostrar que NO lo es, es que es un palíndromo
		System.out.println("\nEl texto introducido es un palindromo");

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}