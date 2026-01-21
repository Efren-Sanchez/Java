/*******************************************************************************
 * 
 * E061_CuentaRegresiva
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Cuenta regresiva
 *
 * Programa que pide un número al usuario y realiza una cuenta regresiva desde
 * ese número hasta 0.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E061_CuentaRegresiva {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E061_CuentaRegresiva *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        int num;

        System.out.println("Introduce el valor: ");
        num = sc.nextInt();

        while (num >= 0) {
            System.out.println(num--); 
            //System.out.println(num); 
            //num--;
        } 

        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}