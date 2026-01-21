/*******************************************************************************
 * 
 * E039_Estaciones
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Estaciones
 *
 * Programa que un número de mes e indique la estación del año que le 
 * corresponde. Ej: los meses 3, 4 y 5 deben devolver primavera, 6, 7 y 8 
 * mostrarán verano", etc.  El programa debe utilizar un switch.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E039_Estaciones {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E039_Estaciones *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número de un mes (1-12): ");
        int mes = sc.nextInt();

        String estacion = switch (mes) {
            case 3, 4, 5 -> "Primavera";
            case 6, 7, 8 -> "Verano";
            case 9, 10, 11 -> "Otoño";
            case 12, 1, 2 -> "Invierno";
            default -> "Mes no válido";
        };
        System.out.println(estacion); 

        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}