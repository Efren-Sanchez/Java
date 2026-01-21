/*******************************************************************************
 * 
 * E084_ArbolNavidad
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Arbol de Navidad
 *
 * Programa que muestra por pantalla un arbol de navidad con ASCII art de tamaño
 * proporcionado por el usuario.
 * 
 * Ej: 7
 * 
 *            *
 *           ***
 *          *****
 *         *******
 *        *********
 *       ***********
 *      *************
 *            |
 *            |
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E084_ArbolNavidad {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E084_ArbolNavidad *\n\n  --- Inicio del programa ---\n\n");
		
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println(("Introduce un número: "));
        n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {  // Niveles de altura del arbol

            // Pone espacios al inicio
            for (int j = 1; j <= n - i; j++) {
                System.out.print((" "));
            }
            
            // Pinta la mitad izquierda
            for (int j = 0; j < i-1; j++) {
                System.out.print(("*"));
            }
            
            // Pinta la mitad derecha del arbol
            for (int j = 1; j <= i; j++) {
                System.out.print(("*"));
            }
            System.out.print(("\n"));
        }
        
        // Pinta el tronco del arbol
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < n-1; j++) {
                System.out.print((" "));
            }
            System.out.print(("|\n"));

        }

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}