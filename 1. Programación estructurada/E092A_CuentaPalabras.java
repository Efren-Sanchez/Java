/*******************************************************************************
 * 
 * E092A_CuentaPalabras
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Cuenta palabras
 *
 * Programa que cuenta las palabras de un texto.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E092A_CuentaPalabras {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E092A_CuentaPalabras *\n\n  --- Inicio del programa ---\n\n");
		
        Scanner sc = new Scanner(System.in);
		String texto;
		int palabras = 0;
		boolean estoyEnPalabra = false;
		
		System.out.print("Por favor, introduce un texto: ");
		texto = sc.nextLine();

		for (int i = 0; i < texto.length(); i++) {
			if(texto.charAt(i) != ' ' && !estoyEnPalabra) { // Si encuentro algo que no sea un espacio y NO estoy en palabra
				palabras++;
				estoyEnPalabra = true;	// Marco que me he metido en una palabra
			}
			
			// Si encuentro un espacio y estoy en una palabra
			if (texto.charAt(i) == ' ' && estoyEnPalabra) {
				estoyEnPalabra = false;	// Marco que ya no estoy en una palabra
			}
		}
		
		System.out.println(palabras);

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}