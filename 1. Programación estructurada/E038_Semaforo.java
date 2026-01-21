/*******************************************************************************
 * 
 * E038_Semaforo
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Semáforo
 *
 * programa que pida un color (rojo/amarillo/verde) e indique la acción a 
 * realizar (parar/frenar/pasar). El programa debe utilizar un switch.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E038_Semaforo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E038_Semaforo *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un color (rojo/amarillo/verde): ");
        String color = sc.next().toLowerCase();

        switch (color) {
            case "rojo":
                System.out.println("Acción: parar");
                break;
            case "amarillo":
                System.out.println("Acción: frenar");
                break;
            case "verde":
                System.out.println("Acción: pasar");
                break;
            default:
                System.out.println("Color no reconocido");
                break;
		}
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}