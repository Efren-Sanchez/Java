/*******************************************************************************
 * 
 * E032_Bisiesto
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Año bisiesto
 * 
 *  Programa que dado un año indica si es un año bisiesto o no.
 * 
 * Un año es bisiesto si es:
 * - Divisible por 4.
 * - No divisible por 100.
 * - Salvo si es divisible por 400. 
 * 
 * (2000 y 2400 son bisiestos pues aún siendo divisibles por 100 lo son también por 400. 
 * Pero los años 1800, 1900, 2100, 2200 y 2300 no lo son porque solo son divisibles por 100).
 * 
 ******************************************************************************/

 import java.util.Scanner;

public class E032_Bisiesto {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E032_Bisiesto *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		int anyo;
		
		// Petición de datos al usuario	
		System.out.print("Por favor, introduce el año: ");
		anyo = sc.nextInt();
		
		// Calculo de si es bisiesto o no
		if (anyo % 4 == 0)
		{
			if (anyo % 100 == 0)
			{
				if (anyo % 400 == 0)
					System.out.print("El año es bisiesto");
				else
					System.out.print("El año NO es bisiesto");
			}
			else
				System.out.print("El año es bisiesto");
		}
		else
			System.out.print("El año NO es bisiesto");	
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}