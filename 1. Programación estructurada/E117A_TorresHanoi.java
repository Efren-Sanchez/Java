/**
 * E117A_TorresHanoi
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

public class E117A_TorresHanoi {
    static int totalDiscos;
    static int[][] torres = new int[3][totalDiscos];
    static int[] alturas = new int[3]; // alturas actuales de cada torre

	public static void main(String[] args) {

		System.out.println("\n\n\n* E117A_TorresHanoi *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n\nIntroduce un número de discos: ");
		totalDiscos = sc.nextInt();

        torres = new int[3][totalDiscos]; // Se crea el array con tamaño correcto
        alturas = new int[3]; // Array para seguir alturas
        
        // Inicializar torre A con discos (de mayor a menor, abajo a arriba)
        for (int i = 0; i < totalDiscos; i++) {
            torres[0][i] = totalDiscos - i;
        }
        alturas[0] = totalDiscos;
        alturas[1] = 0;
        alturas[2] = 0;

        System.out.println("Estado inicial:");
        mostrarTorres();

        hanoi(totalDiscos, 0, 1, 2); // Torres: 0 origen, 1 auxiliar, 2 destino

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
	 * @param int origen		Número de la torre origen
	 * @param int auxiliar		Número de la torre auxiliar
	 * @param int destino		Número de la torre destino
	 * 
	 * Salida: void
	 * 
	 */
    public static void hanoi(int n, int origen, int auxiliar, int destino) {
        if (n == 1) {
            moverDisco(origen, destino);
        } else {
            hanoi(n - 1, origen, destino, auxiliar);
            moverDisco(origen, destino);
            hanoi(n - 1, auxiliar, origen, destino);
        }
    }

	/**
	 * Función: moverDisco
	 * 
	 * Mueve un disco de la torre origen a la de destino.
	 * 
     * @author Efrén Sánchez
     * 
	 * Entrada: 
     * @param int origen    Número del disco de origen
     * @param int destino   Número del disco de destino
	 * 
	 * Salida: void
	 * 
	 */
    public static void moverDisco(int origen, int destino) {
        int disco = torres[origen][alturas[origen] - 1];
        torres[origen][alturas[origen] - 1] = 0;
        alturas[origen]--;

        torres[destino][alturas[destino]] = disco;
        alturas[destino]++;

        System.out.println("Mover disco " + disco + " de torre " + (char)('A' + origen) 
                           + " a torre " + (char)('A' + destino));
        mostrarTorres();
    }

	/**
	 * Función: mostrarTorres
	 * 
	 * Muestra las torres por pantalla.
	 * 
     * @author Efrén Sánchez
     * 
	 * Entrada: void
	 * 
	 * Salida: void
	 * 
	 */
    public static void mostrarTorres() {
        System.out.println("-----------------------------");
        for (int nivel = totalDiscos - 1; nivel >= 0; nivel--) {
            for (int t = 0; t < 3; t++) {
                int disco = torres[t][nivel];
                if (disco == 0) {
                    System.out.print(centro("|", totalDiscos * 2) + " ");
                } else {
                    System.out.print(centro("=".repeat(disco * 2 - 1), totalDiscos * 2) + " ");
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
        System.out.println("   A               B               C");
    }

	/**
	 * Función: centro
	 * 
	 * Calcula donde está el centro de un disco para pintar el poste de la torre.
	 * 
     * @author Efrén Sánchez
     * 
	 * Entrada:
     * @param String s          Carácter que representa la torre
     * @param int    ancho      Anchura del disco
	 * 
	 * Salida: 
     * @return String           Cadena con el centro pintado
	 * 
	 */
    public static String centro(String s, int ancho) {
        int espacios = (ancho - s.length()) / 2;
        return " ".repeat(espacios) + s + " ".repeat(espacios);
    }
}