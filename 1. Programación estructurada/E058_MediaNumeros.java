/*******************************************************************************
 * 
 * E058_MediaNumeros
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Media de números introducidos
 *
 * Programa que va pidiendo números positivos por teclado hasta que se introduce 
 * un 0, y calcula la media de los números introducidos sin contar el 0.
 *  
 ******************************************************************************/

 import java.util.Scanner;

public class E058_MediaNumeros {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E058_MediaNumeros *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        int contador = 0,   // Total de números introducidos
            sumatorio = 0,  // Acumulado de los números introducidos
            numero;         // Número leido por teclado

        do {
            System.out.println("Por favor, introduce un número: ");
            numero = sc.nextInt();

            if (numero > 0) {   // Ignoro los números negativos
                contador++;
                sumatorio += numero;
            }
        } while (numero != 0);
        
        System.out.println("Se han introducido " + contador + " números positivos.");
        System.out.println("La suma de todos ellos es: " + sumatorio);
        System.out.println("La media es: " + ((double)sumatorio/contador));
		
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}