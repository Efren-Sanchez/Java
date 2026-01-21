/**
 * E110_PotenciaRecursiva
 * 
 * @author Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Potencia recursiva
 * 
 * Programa que calcula la potencia de un número de manera recursiva e 
 * iterativa.
 * 
 * Se muestra en pantalla el tiempo invertido en cada proceso.
 * Nanosegundo: 10e-9 segundos
 * 
 */

import java.util.Scanner;

public class E110_PotenciaRecursiva {
	public static void main(String[] args) {

		System.out.println("\n\n\n* E110_PotenciaRecursiva *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
		int r;
		long t1, t2;
		double resultado;

        System.out.println("Introduce la base: ");
        int base = sc.nextInt();
        System.out.println("Introduce el exponente: ");
        int exp = sc.nextInt();

        // Saco el tiempo en milisegundos antes y después
		t1 = System.nanoTime();
        r = potenciaRecursiva(base, exp);
		t2 = System.nanoTime();
        
		System.out.println("\n\nPotencia recursiva: " + base + "^" + exp + " = " + r);
        System.out.println("Tiempo invertido: " + (t2 - t1));
		//System.out.println("T1: " + (t1));
		//System.out.println("T2: " + (t2));
		
        // Saco el tiempo en milisegundos antes y después
		t1 = System.nanoTime();
        r = potenciaIterativa(base, exp);
		t2 = System.nanoTime();
		
        System.out.println("\n\nPotencia iterativa: " + base + "^" + exp + " = " + r);
		System.out.println("Tiempo invertido: " + (t2 - t1));
		
		t1 = System.nanoTime();
		resultado = Math.pow(base, exp);
		t2 = System.nanoTime();
		
        System.out.println("\n\nMath.pow: " + base + "^" + exp + " = " + resultado);
		System.out.println("Tiempo invertido: " + (t2 - t1));

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
	}
	

	/**
	 * Función: potenciaRecursiva
	 * 
	 * Calcula la potencia n-esima de un número de forma recursiva
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada:
	 * @param int base		Base
	 * @param int exp		Exponente 
	 * 
	 * Salida:
	 * @return int			Potencia
	 * 
	 */
    public static int potenciaRecursiva(int base, int exp) {
        if (exp == 0) return 1;	// Caso base, rompe la recursión
        else return base * potenciaRecursiva(base, exp - 1); // Caso general, recursivo
    }

	/**
	 * Función: potenciaIterativa
	 * 
	 * Calcula la potencia n-esima de un número de forma iterativa
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada:
	 * @param int base		Base
	 * @param int exp		Exponente
	 * 
	 * Salida:
	 * @return int			Potencia
	 * 
	 */
    public static int potenciaIterativa(int base, int exp) {
        int res = 1;        
        for(int i = 1; i <= exp; i++) {
            res = res * base;
        }
		return res;
    }
}