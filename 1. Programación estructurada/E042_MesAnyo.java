/*******************************************************************************
 * 
 * E042_MesAnyo
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Día de la semana
 *
 * Programa que dado un número entero indique el mes del añoque le corresponde: 
 * 1 - enero .. 12 - diciembre. El programa debe utilizar un switch.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E042_MesAnyo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E042_MesAnyo *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número del 1 al 7: ");
        int dia = sc.nextInt();

        switch (dia) {
            case 1:
                System.out.println("Día: lunes");
                break;
            case 2:
                System.out.println("Día: martes");
                break;
            case 3:
                System.out.println("Día: miércoles");
                break;
            case 4:
                System.out.println("Día: jueves");
                break;
            case 5:
                System.out.println("Día: viernes");
                break;
            case 6:
                System.out.println("Día: sábado");
                break;
            case 7:
                System.out.println("Día: domingo");
                break;
            default:
                System.out.println("Número inválido. Debe ser entre 1 y 7.");
                break;
        }

        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}