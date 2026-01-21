/*******************************************************************************
 * 
 * E093_BuscaTexto
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

public class E093_BuscaTexto {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E093_BuscaTexto *\n\n  --- Inicio del programa ---\n\n");
		
        Scanner sc = new Scanner(System.in);
        String texto, palabra;
        boolean ok = false;

        System.out.print("Por favor, introduce un texto: ");
        texto = sc.nextLine();

        System.out.print("Por favor, introduce la palabra a buscar en el texto: ");
        palabra = sc.nextLine();

        for (int i = 0; i < texto.length(); i++) {  // Vamos recorriendo el texto en el que buscar
            if (texto.charAt(i) == palabra.charAt(0)) { // Si coincide el caracter sobre el que estamos y el primer caracter de lo buscado
                ok = true;
                for (int j = 1; j < palabra.length(); j++) {  // Comparamos el resto de caracteres     
                    if (texto.charAt(i+j) != palabra.charAt(j)) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) {
                System.out.println("La palabra " + palabra + " aparece en el texto.");
                System.out.println("Posición en el texto: " + (i+1));
                break;
            }
        }
        
        if (!ok) System.out.println("La palabra " + palabra + " NO aparece en el texto.");
        
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}