/**
 * E119_Resto
 * 
 * @author Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Conversión de decimal a binario
 * 
 * Programa que convierte un número decimal a binario de manera recursiva e 
 * iterativa.
 * 
 */

import java.util.Scanner;

public class E119_Resto {
	public static void main(String[] args) {

		System.out.println("\n\n\n* E119_Resto *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el dividendo: ");
        int dividendo = sc.nextInt();
        System.out.print("Introduce el divisor: ");
        int divisor = sc.nextInt();

        if (divisor == 0) 
            System.out.println("Error: división por cero.");
        else {
            int resultado = resto(dividendo, divisor);
            System.out.println("El resto de la división de " + dividendo + " entre " + divisor + " es: " + resultado);
        }

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
	}
	
	/**
	 * Función: decimalABinario
	 * 
	 * Convierte un número en base decimal a binario.
	 * 
	 * Entrada:
	 * @param int n			Entero positivo a convertir
	 * 
	 * Salida:
	 * @return String		Número en binario
	 * 
	 */
public static int resto(int dividendo, int divisor) {
        if (dividendo < divisor) return dividendo;
        else return resto(dividendo - divisor, divisor);
    }
}