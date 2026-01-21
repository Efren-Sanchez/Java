/*******************************************************************************
 * 
 * E092_CuentaPalabras
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

public class E092_CuentaPalabras {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E092_CuentaPalabras *\n\n  --- Inicio del programa ---\n\n");
		
        Scanner sc = new Scanner(System.in);
        int palabras = 0;
		
        System.out.println("Introduce un texto para contar sus caracteres: ");
        String texto = sc.nextLine();

        for (int i = 0; i < texto.length()-1; i++) {
            if (texto.charAt(i) != ' ' && texto.charAt(i+1) == ' ') 
                palabras++;
        }

        if (texto.charAt(texto.length()-1) != ' ') palabras++;

        System.out.println("El texto: \n-----------\n" + texto + "\n------------\ntiene " + palabras + " palabras.");

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}