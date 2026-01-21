/*******************************************************************************
 * 
 * E094_CuentaTexto
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

public class E094_CuentaTexto {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E094_CuentaTexto *\n\n  --- Inicio del programa ---\n\n");
		
        Scanner sc = new Scanner(System.in);
        String texto, palabra;
        boolean ok;// = false;
        int cont = 0;

        System.out.print("Por favor, introduce un texto: ");
        texto = sc.nextLine();

        System.out.print("Por favor, introduce la palabra a buscar en el texto: ");
        palabra = sc.nextLine();

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == palabra.charAt(0)) {
                ok = true;
                for (int j = 1; j < palabra.length(); j++) {
                    if (texto.charAt(i+j) != palabra.charAt(j)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) cont++;
            }
        }
        
        System.out.println("La palabra " + palabra + " aparece " + cont + " en el texto.");

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}