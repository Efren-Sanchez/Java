/*******************************************************************************
 * 
 * E073A_Intervalo
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Intervalo entre dos números
 *
 * Programa que muestre por pantalla los números comprendidos entre dos 
 * introducidos por teclado.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E073A_Intervalo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E073A_Intervalo *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        int num1, num2;    

        System.out.print("Introduce el primer número: ");
        num1 = sc.nextInt();
        System.out.print("\nIntroduce el segundo número: ");
        num2 = sc.nextInt();
        
        if (num1 > num2) {
            for (int i = num1; i >= num2; i--)  // Bucle decreciente
                System.out.print("\n" + i);
        } else {
            for (int i = num1; i <= num2; i++)  // Bucle creciente
                System.out.print("\n" + i);
        }
                    
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}