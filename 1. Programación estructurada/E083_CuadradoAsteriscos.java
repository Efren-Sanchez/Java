/*******************************************************************************
 * 
 * E083_CuadradoAsteriscos
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Cuadrado de asteriscos
 *
 * Programa que muestra por pantalla un cuadrado de asteriscos del tamaño 
 * indicado por el usuario.
 * 
 * Ej: 4
 * 
 *      * * * * 
 *      * * * *
 *      * * * * 
 *      * * * *
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E083_CuadradoAsteriscos {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E083_CuadradoAsteriscos *\n\n  --- Inicio del programa ---\n\n");
		
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println(("Introduce un número: "));
        n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {  // Filas
            for (int j = 1; j <= n; j++) {  // Columnas
                System.out.print((" * "));
            }
            System.out.print(("\n"));   
        }
        

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}