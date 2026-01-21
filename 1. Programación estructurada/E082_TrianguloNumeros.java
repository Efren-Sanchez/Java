/*******************************************************************************
 * 
 * E082_TrianguloNumeros
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Triángulo de números
 *
 * Programa que muestra por pantalla un triángulo de números hasta un nivel 
 * indicado por el usuario.
 * 
 * Ej: 5
 * 
 * 1
 * 22
 * 333
 * 4444
 * 55555
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E082_TrianguloNumeros {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E082_TrianguloNumeros *\n\n  --- Inicio del programa ---\n\n");
		
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println(("Introduce un número: "));
        n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {  // Nos indica el nivel
            for (int j = 1; j <= i; j++) {  // Nos indica la cantidad de números
                System.out.print((i));
            }
            System.out.print(("\n"));   // Saltamos de línea al final de cada nivel
        }

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}