/**
 * E117_TorresHanoi
 * 
 * @author Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Torres de Hanoi
 * 
 * Programa que resuelve el juego de las Torres de Hanoi.
 * 
 * Las Torres de Hanói es un rompecabezas o juego matemático inventado en 1883 
 * por el matemático francés Édouard Lucas. El juego consiste en tres postes, 
 * en el primero de los cuales hay varios discos perforados colocados en orden
 * decreciente. El objetivo consiste en pasar todos los discos desde el poste 
 * ocupado (es decir, el que posee la torre) a uno de los otros postes vacíos. 
 * Para realizar este objetivo, es necesario seguir tres simples reglas:
 * - Solo se puede mover un disco cada vez y para mover otro los demás tienen 
 * que estar en postes.
 * - Un disco de mayor tamaño no puede estar sobre uno más pequeño que él mismo.
 * - Solo se puede desplazar el disco que se encuentre arriba en cada poste.
 * Existen diversas formas de llegar a la solución final, todas ellas siguiendo 
 * estrategias diversas.
 * 
 * Mediante recursividad: 
 * Este problema se suele plantear a menudo en programación, especialmente para 
 * explicar la recursividad. Si numeramos los discos desde 1 hasta n, si 
 * llamamos origen a la primera pila de discos, destino a la tercera y auxiliar 
 * a la intermedia, y si a la función la denomináramos hanoi, con origen, 
 * auxiliar y destino como parámetros, el algoritmo de la función sería el 
 * siguiente:
 * 
 * Algoritmo Torres de Hanói (Complejidad Θ(2^n − 1)
 * - Entrada: Tres pilas de números origen, auxiliar, destino, con la pila origen 
 * ordenada.
 * - Salida: La pila destino.
 * 1. si origen =={1} entonces
 * 		1. mover el disco 1 de pila origen a la pila destino (insertarlo arriba 
 * 			de la pila destino) 
 * 		2. terminar 
 * 2. si no 
 * 		1. hanoi({1,…,n−1},origen,destino, auxiliar)    //mover todas las fichas menos la más grande (n) a la varilla auxiliar
 * 3. mover disco n a destino                			//mover la ficha grande hasta la varilla final
 * 4. hanoi (auxiliar, origen, destino)          		//mover todas las fichas restantes, 1...n–1, encima de la ficha grande (n)
 * 5. terminar
 * 
 * Más información: https://es.wikipedia.org/wiki/Torres_de_Han%C3%B3i
 * 
 */

import java.util.Scanner;

public class E117_TorresHanoi {
	public static void main(String[] args) {

		System.out.println("\n\n\n* E117_TorresHanoi *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.print("\n\nIntroduce un número de discos: ");
		n = sc.nextInt();

        hanoi(n, 'A', 'B', 'C'); // Torres: A origen, B auxiliar, C destino

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
	}
	
	/**
	 * Función: hanoi
	 * 
	 * Resuelve el juego de las Torres de Hanoi de manera recursiva.
	 * 
     * @author Efrén Sánchez
     * 
	 * Entrada:
	 * @param int n				Entero positivo que indica el número de discos
	 * @param char origen		Nombre de la torre origen
	 * @param char auxiliar		Nombre de la torre auxiliar
	 * @param char destino		Nombre de la torre de destino
	 * 
	 * Salida: void
	 * 
	 */
	public static void hanoi(int n, char origen, char auxiliar, char destino) {
        if (n == 1) System.out.println("Mover disco 1 de " + origen + " a " + destino);
        else {
            // Mover n-1 discos de origen a auxiliar, usando destino como auxiliar
            hanoi(n - 1, origen, destino, auxiliar);
            // Mover el disco restante de origen a destino
            System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
            // Mover los n-1 discos de auxiliar a destino, usando origen como auxiliar
            hanoi(n - 1, auxiliar, origen, destino);
        }
    }
}