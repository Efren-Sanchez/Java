/*******************************************************************************
 * 
 * E076_TablaPorTeclado
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Tabla de multiplicar 
 *
 * Programa que muestra por pantalla la tabla de multiplicar que indique el 
 * usuario.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E076_TablaPorTeclado {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E076_TablaPorTeclado *\n\n  --- Inicio del programa ---\n\n");

    Scanner sc = new Scanner(System.in);

    System.out.println("Introduce un número:");
    int num = sc.nextInt();

    for (int i = 0; i <= 10; i++)
        System.out.println(num + " x " + i + " = " + (num*i));

    sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}