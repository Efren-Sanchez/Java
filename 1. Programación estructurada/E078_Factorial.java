/*******************************************************************************
 * 
 * E078_Factorial
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Factorial de un número
 *
 * Programa que muestra por pantalla el factorial de un número introducido por
 * teclado.
 * 
 * Ej: 7! = 7 x 6 x 5 x 4 x 3 x 2 x 1
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E078_Factorial {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E078_Factorial *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        int num, fact = 1;  // En fact iremos acumulando el productorio, es necesario inicializarla a 1

        System.out.println("Introduce un numero: ");
        num = sc.nextInt();

        if (num < 0) {  // Comprobación de errores
            System.out.println("El número introducido es incorrecto!!!");
        }
        else {
            for (int i = num; i >= 1; i--) fact *= i;   // Cálculo del factorial

            // Como la multiplicación es conmutativa, da igual hacerla de n a 1 que de 1 a n
            //for (int i = 1; i <= num; i++) fact = fact * i;

            System.out.println("El factorial de " + num + " es: " + fact);
        }
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}