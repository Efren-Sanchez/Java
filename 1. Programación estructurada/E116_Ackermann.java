/**
 * E116_Ackermann
 * 
 * @author Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Función de Ackermann
 * 
 * Programa que ejecuta la función recursiva de Ackermann.
 * 
 * En teoría de la computación, una función de Ackermann es una función 
 * matemática recursiva encontrada en 1926 por Wilhelm Ackermann. Tiene un 
 * crecimiento extremadamente rápido, lo que es de interés para la ciencia 
 * computacional teórica y la teoría de la computabilidad.
 * 
 * Más información: https://es.wikipedia.org/wiki/Funci%C3%B3n_de_Ackermann
 * 
 */

import java.util.Scanner;

public class E116_Ackermann {
	public static void main(String[] args) {

		System.out.println("\n\n\n* E116_Ackermann *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		int m, n;
		
		System.out.print("\n\nIntroduce un número para M: ");
		m = sc.nextInt();
		System.out.print("\n\nIntroduce un número para N: ");
		n = sc.nextInt();

        System.out.println("Ackermann(" + m + ", " + n + ") = " + ackermann(m, n));

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
	}
	
	/**
	 * Función: ackermann
	 * 
	 * Implementa la función de Ackermann de manera recursiva.
	 * 
	 * Entrada:
	 * @param String m		Entero positivo para el término m
	 * @param String n		Entero positivo para el término n
	 * 
	 * Salida:
	 * @return int			Resultado de la función
	 * 
	 */
	public static int ackermann(int m, int n) {
        if (m == 0) 	 return n + 1;
        else if (n == 0) return ackermann(m - 1, 1);
        else             return ackermann(m - 1, ackermann(m, n - 1));
    }
}