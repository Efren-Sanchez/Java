/*******************************************************************************
 * 
 * E011_Cuadrado
 * 
 * Autor: Efrén Sánchez
 * Fecha: 24/09/2025
 *  
 * Cálculos sobre el lado de un cuadrado
 * 
 * Programa que calcula el perímetro y el área de un cuadrado a partir de su 
 * lado, y el volumen del cubo.
 * 
 ******************************************************************************/

 import java.util.Scanner;

public class E011_Cuadrado {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E011_Cuadrado *\n\n  --- Inicio del programa ---\n\n");

		double lado, area, perimetro, volumen;
        Scanner sc = new Scanner(System.in);

		// Introducción del lado del cuadrado por teclado
        System.out.println("\nIntroduce el lado del cuadrado: ");
        lado = sc.nextDouble();

		// Calculos requeridos
		perimetro = lado * 4;
		area = lado * lado;
        volumen = lado * lado * lado;
		
		// Resultados finales
		System.out.println("\nEjercicio de cálculos con el lado de un cuadrado");
		System.out.println("------------------------------------------------");
		System.out.println("");
		System.out.println("El lado del cuadrado es: " + lado + " metros.");
		System.out.println("");
		System.out.println("El perímetro del cuadrado es: " + perimetro + " metros.");
		System.out.println("El área del cuadrado es: " + area + " metros cuadrados.");
		System.out.println("El volumen del cubo es: " + volumen + " metros cúbicos.");

        sc.close(); // Cerramos Scanner

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}