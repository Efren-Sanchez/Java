/*******************************************************************************
 * 
 * E061A_CuentaRegresiva
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Cuenta regresiva
 *
 * Programa que pide un número al usuario y realiza una cuenta regresiva desde
 * ese número hasta 0 con un retraso de 1 segundo.
 * 
 ******************************************************************************/

import java.util.Scanner;
import java.lang.Thread;    // Para usar sleep

public class E061A_CuentaRegresiva {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E061A_CuentaRegresiva *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        int num;

        System.out.println("Introduce el valor: ");
        num = sc.nextInt();

        try {   // Para usar sleep debemos capturar las posibles excepciones
            while (num >= 0) {
                System.out.println(num--); 
                Thread.sleep(1000); // Tiempo de pausa en milisegundos
            } 
        } catch (Exception e) {
            System.err.println(e);
        }
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}