/*******************************************************************************
 * 
 * E091A_CuentaCaracteres
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Cuenta caracteres
 *
 * Programa que cuenta los caracteres, los espacios no, de un texto.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E091A_CuentaCaracteres {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E091A_CuentaCaracteres *\n\n  --- Inicio del programa ---\n\n");
		
        Scanner sc = new Scanner(System.in);
        int letras = 0;
		
        System.out.println("Introduce un texto para contar sus caracteres: ");
        String texto = sc.nextLine();

        for (int i = 0; i < texto.length(); i++) if (texto.charAt(i) != ' ') letras++;

        System.out.println("El texto: \n-----------\n" + texto + "\n------------\ntiene " + letras + " caracteres.");

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}