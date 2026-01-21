/*******************************************************************************
 * 
 * E020_CalculoResistencia
 * 
 * Autor: Efrén Sánchez
 * Fecha: 25/09/2025
 * 
 * Cálculo de resistencia equivalente
 *
 * Programa que a partir del valor de dos resistencias dispuestas en paralelo
 * devuelve el valor de la resistencia equivalente que las podría reemplazar.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E020_CalculoResistencia {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E020_CalculoResistencia *\n\n  --- Inicio del programa ---\n\n");

		double 	R1, R2, Req;

		Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce el valor de la primera resistencia: ");
        R1 = sc.nextDouble();		

		System.out.println("\nIntroduce el valor de la segunda resistencia: ");
        R2 = sc.nextDouble();	
		
		System.out.println("Valor de la resistencia 1: " + R1);
		System.out.println("Valor de la resistencia 2: " + R2);
		
		Req = (R1 * R2) / (R1 + R2);
		
		System.out.println("Valor de la resistencia equivalente calculada: " + Req);	

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}