/*******************************************************************************
 * 
 * E019_CambioDinero
 * 
 * Autor: Efrén Sánchez
 * Fecha: 25/09/2025
 * 
 * Cambio de dinero en la menor cantidad de monedas y billetes
 * 
 * Programa que, a partir de una cantidad de euros, nos muestra por pantalla
 * el número de billetes de 50, 20, 10 y 5,e y monedas de 2 y 1€.
 * Se debe mostrar el menor número de monedas y billetes posible.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E019_CambioDinero {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E019_CambioDinero *\n\n  --- Inicio del programa ---\n\n");

		int cantidad, de50, de20, de10, de5, de2, de1;

		Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce la cantidad de dinero a cambiar: ");
        cantidad = sc.nextInt();		

		System.out.println("Cambio para " + cantidad + "euros");
			
		de50 = cantidad / 50;		// Cantidad máxima de billetes de 50
		cantidad = cantidad % 50;	// Resto de la operación
		System.out.println("Billetes de 50e: " + de50);
		
		de20 = cantidad / 20;
		cantidad = cantidad % 20;
		System.out.println("Billetes de 20e: " + de20);
		
		de10 = cantidad / 10;
		cantidad = cantidad % 10;
		System.out.println("Billetes de 10e: " + de10);
		
		de5 = cantidad / 5;
		cantidad = cantidad % 5;
		System.out.println("Billetes de 5e: " + de5);
		
		de2 = cantidad / 2;
		cantidad = cantidad % 2;
		System.out.println("Billetes de 2e: " + de2);
		
		de1 = cantidad; // / 1;
		System.out.println("Billetes de 1e: " + de1);
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}