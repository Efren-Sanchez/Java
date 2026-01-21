/*******************************************************************************
 * 
 * E012_RectanguloTriangulo
 * 
 * Autor: Efrén Sánchez
 * Fecha: 24/09/2025
 *  
 * Cálculos sobre la base y la altura de un rectángulo y un triángulo
 * 
 * Programa que calcula la longitud y el área de un ractángulo y un triángulo 
 * a partir de su radio.
 * 
 ******************************************************************************/

 import java.util.Scanner;

public class E012_RectanguloTriangulo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E012_RectanguloTriangulo *\n\n  --- Inicio del programa ---\n\n");

		double base, altura, area, longitud;
        Scanner sc = new Scanner(System.in);

		// Introducción de los datos de entrada
        System.out.println("\nIntroduce la base: ");
        base = sc.nextDouble();

        System.out.println("\nIntroduce la altura: ");
        altura = sc.nextDouble();

		// Calculos requeridos
        longitud = 2 * base + 2 * altura;
		area = base * altura;
		
		// Resultados finales
		System.out.println("\nEjercicio de cálculos con la base y altura de un rectángulo y un triángulo");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("La base es: " + base + " metros.");
        System.out.println("La altura es: " + altura + " metros.");
		System.out.println("");
		System.out.println("El perímetro del rectángulo es: " + longitud + " metros.");
		System.out.println("El área del rectángulo es: " + area + " metros cuadrados.");
		System.out.println("El perímetro del rectángulo es: " + (3*base) + " metros.");     // Supongo que es un triángulo equilátero
		System.out.println("El área del triángulo es: " + (area/2) + " metros cuadrados.");

        sc.close(); // Cerramos Scanner

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}