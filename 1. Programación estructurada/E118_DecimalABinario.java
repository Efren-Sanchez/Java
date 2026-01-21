/**
 * E118_DecimalABinario
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

public class E118_DecimalABinario {
	public static void main(String[] args) {

		System.out.println("\n\n\n* E118_DecimalABinario *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número decimal: ");
        int numero = sc.nextInt();

        String binario = decimalABinario(numero);
        System.out.println("El número " + numero + " en binario es: " + binario);

		binario = decimalABinarioIterativo(numero);
        System.out.println("El número " + numero + " en binario es: " + binario);

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
	public static String decimalABinario(int n) {
        if (n < 2) {
            return String.valueOf(n);
        }
        return decimalABinario(n / 2) + (n % 2);
    }

	/**
	 * Función: decimalABinarioIterativo
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
	public static String decimalABinarioIterativo(int n) {
        if (n == 0) return "0";

        StringBuilder binario = new StringBuilder();
        while (n > 0) {
            binario.insert(0, n % 2);
            n = n / 2;
        }

		return binario.toString();
    }
}