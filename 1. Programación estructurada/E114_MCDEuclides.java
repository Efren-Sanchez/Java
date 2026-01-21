/**
 * E114_MCDEuclides
 * 
 * @author Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Programa que calcula el máximo comín divisor (MCD) de dos números 
 * utillizando el algoritmo recursivo de Euclides.
 * 
 */

import java.util.Scanner;

public class E114_MCDEuclides {
	public static void main(String[] args) {

		System.out.println("\n\n\n* E114_MCDEuclides *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		int numero1, numero2;
		
		System.out.print("\n\nIntroduce el primer número para calcular el MCD: ");
		numero1 = sc.nextInt();
		System.out.print("\n\nIntroduce el segundo número: ");
		numero2 = sc.nextInt();
			
		System.out.println("El MCD de " + numero1 + " y " + numero2 + " es: " + mcd(48, 18));  

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
	}
	
	/**
     * Función: mcd
     * 
     * Calcula el MCD de dos números pasados por parámetro utilizando el
     * añgoritmo recurasivo de Euclides.
     * 
     * Entrada:
     * @param int a			Primer número
     * @param int b			Segundo número
     * 
     * Salida:
     * @return int			MCD de los números de entrada
     * 
	 */
	static int mcd(int a, int b) 
	{
        if (b == 0) return a; // Caso base
        
        return mcd(b, a % b); // Caso recursivo
    }
}