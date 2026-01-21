/*******************************************************************************
 * 
 * E018_ConversionKilometrosMillas
 * 
 * Autor: Efrén Sánchez
 * Fecha: 25/09/2025
 * 
 * Conversión de kilómetros a millas
 * 
 * Programa que convierte de kilómetros a millas.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E018_ConversionKilometrosMillas {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E018_ConversionKilometrosMillas *\n\n  --- Inicio del programa ---\n\n");

		double 	km, 	// Número de kilómetros que queremos convertir
				millas; // Millas equivalentes
		final double FACTOR = 0.621371;	// Factor de conversión de km a mi
		Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce los kilómetros: ");
        km = sc.nextDouble();		
		
		millas = km * FACTOR;
		
		System.out.println("Las millas equivalentes son " + millas);

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}