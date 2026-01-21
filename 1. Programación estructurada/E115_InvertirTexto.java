/**
 * E115_InvertirTexto
 * 
 * @author Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Programa que calcula el máximo comín divisor (MCD) de dos números 
 * utillizando el algoritmo recursivo de Euclides.
 * 
 */

import java.util.Scanner;

public class E115_InvertirTexto {
	public static void main(String[] args) {

		System.out.println("\n\n\n* E115_InvertirTexto *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		String texto;
		
		System.out.print("\n\nIntroduce una frase para invertirla: ");
		texto = sc.nextLine();

		System.out.println(invertir(texto));

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
	}
	
	/**
	 * Función: invertir
	 * 
	 * Invierte una cadena pasada por parámetro de manersa recursiva
	 * 
	 * Entrada:
	 * @param String n		Entero positivo término de la conjetura de Collatz
	 * 
	 * Salida:
	 * @return String			Cadena invertida
	 * 
	 */
	static String invertir(String s) 
	{
        if (s.isEmpty()) 
            return s; // Caso base: cadena vacía
        
        return invertir(s.substring(1)) + s.charAt(0); // Caso recursivo
    }
}