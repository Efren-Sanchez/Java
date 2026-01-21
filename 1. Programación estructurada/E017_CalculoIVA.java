/*******************************************************************************
 * 
 * E017_CalculoIVA
 * 
 * Autor: Efrén Sánchez
 * Fecha: 25/09/2025
 * 
 * Cálculo del IVA
 * 
 * A partir de un importe inicial y un porcentaje calculamos el importe con 
 * impuestos incluidos.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E017_CalculoIVA {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E017_CalculoIVA *\n\n  --- Inicio del programa ---\n\n");

		double importe, importeConIVA; 
		double IVA = 21;
		
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce el importe: ");
        importe = sc.nextInt();
		
		// Primera forma de calcularlo
		importeConIVA = importe + (importe * (IVA / 100));

		System.out.println("");
		System.out.println("Primera forma de cálculo");
		System.out.println("");
		System.out.println("Importe inicial: " + importe);
		System.out.println("IVA:             " + IVA);
		System.out.println("Importe con IVA: " + importeConIVA);
		System.out.println("--------------------------");
		System.out.println("");
		
		// Segunda forma de calcularlo
		importeConIVA = importe * ((100 + IVA) / 100);

		System.out.println("");
		System.out.println("Primera forma de cálculo");
		System.out.println("");
		System.out.println("Importe inicial: " + importe);
		System.out.println("IVA:             " + IVA);
		System.out.println("Importe con IVA: " + importeConIVA);
		System.out.println("--------------------------");
		System.out.println("");

		// Tercera forma de calcularlo
		IVA = 0.21;
		importeConIVA = importe * (1 + IVA);

		System.out.println("");
		System.out.println("Primera forma de cálculo");
		System.out.println("");
		System.out.println("Importe inicial: " + importe);
		System.out.println("IVA:             " + IVA);
		System.out.println("Importe con IVA: " + importeConIVA);
		System.out.println("--------------------------");
		System.out.println("");

		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}