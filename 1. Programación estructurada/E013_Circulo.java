/*******************************************************************************
 * 
 * E013_Circulo
 * 
 * Autor: Efrén Sánchez
 * Fecha: 24/09/2025
 *  
 * Cálculos sobre el radio de un círculo.
 * 
 * Programa que calcula la longitud y el área de un círculo a partir de su 
 * radio, y el volumen de la esfera.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E013_Circulo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E013_Circulo *\n\n  --- Inicio del programa ---\n\n");

		double radio, area, longitud, volumen;
        Scanner sc = new Scanner(System.in);

		// Introducción de los datos de entrada
        System.out.println("\nIntroduce el radio del círculo: ");
        radio = sc.nextDouble();

		// Calculos requeridos
		longitud = 2 * Math.PI * radio;
		area = Math.PI * Math.pow(radio, 2);
        volumen = (4/3) * Math.PI * Math.pow(radio, 3);
		
		// Resultados finales
		System.out.println("\nEjercicio de cálculos con el radio de un círculo");
		System.out.println("------------------------------------------------");
		System.out.println("");
		System.out.println("El lado del círculo es: " + radio + " metros.");
		System.out.println("");
		System.out.println("La longitud del círculo es: " + longitud + " metros.");
		System.out.println("El área del círculo es: " + area + " metros cuadrados.");
		System.out.println("El volumen de la esfera es: " + volumen + " metros cúbicos.");

        sc.close();	// Cerramos Scanner

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}