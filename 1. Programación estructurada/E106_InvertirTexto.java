/**
 * E106_InvertirTexto
 * 
 * @author: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Invertir texto
 *
 * Programa que invierte un texto suministrado por teclado.
 *  
 */

import java.util.Scanner;

public class E106_InvertirTexto {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E106_InvertirTexto *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un texto para invertirlo: ");
        String palabra = sc.nextLine();

        System.out.println("El texto invertido es: " + invertir(palabra));

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }

    /**
     * Función invertir
     * 
     * Invierte una cadena de texto pasada por parámetro.
     * 
     * @author: Efrén Sánchez
     * 
     * @parm t String Texto para invertir
     * @return String Texto invertido
     * 
     */
    public static String invertir(String t) {
        String fraseInvertida = "";
        for (int i = t.length() - 1; i >= 0; i--)
            fraseInvertida += t.charAt(i);

        return fraseInvertida;
    }
}