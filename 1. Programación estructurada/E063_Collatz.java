/*******************************************************************************
 * 
 * E063_Collatz
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Conjetura de Collatz
 *
 * Programa que pide al usuario un número entero positivo y determina si la
 * conjetura de Collatz se cumple.
 * 
 * Sea la siguiente operación, aplicable a cualquier número entero positivo:
 *   Si el número es par, se divide entre 2.
 *   Si el número es impar, se multiplica por 3 y se suma 1
 * La conjetura dice que siempre alcanzaremos el 1 independientemente del número con el que comencemos.
 *  
 * Más información: https://es.wikipedia.org/wiki/Conjetura_de_Collatz
 * 
 * Esta versión del programa se resuelve iterativamente.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E063_Collatz {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E063_Collatz *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
		int x;

		System.out.println(("Introduce un número: "));
        x = sc.nextInt();

		while(x != 1)
		{
			if (x % 2 == 0)
				x = x/2;
			else
				x = (3 * x) + 1;
				
			System.out.println(x);
		}

        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}