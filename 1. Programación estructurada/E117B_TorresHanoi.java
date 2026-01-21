/**
 * E117B_TorresHanoi
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
import java.util.Stack;

public class E117B_TorresHanoi {
	static Stack<Integer> torreA = new Stack<>();
    static Stack<Integer> torreB = new Stack<>();
    static Stack<Integer> torreC = new Stack<>();
    static int totalDiscos;

	public static void main(String[] args) {

		System.out.println("\n\n\n* E117B_TorresHanoi *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n\nIntroduce un número de discos: ");
		totalDiscos = sc.nextInt();

        // Inicializar torre A con los discos (de mayor a menor)
        for (int i = totalDiscos; i >= 1; i--) 
            torreA.push(i);

        System.out.println("Estado inicial:");
        mostrarTorres();

        // Resolver Torres de Hanoi
        hanoi(totalDiscos, torreA, torreB, torreC, 'A', 'B', 'C');

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
	 * @param int n						Entero positivo término de la conjetura de Collatz
	 * @param Stack<Integer> origen		Pila con el disco de origen
	 * @param Stack<Integer> auxiliar	Pila con el disco auxiliar
	 * @param Stack<Integer> destino	Pila con el disco de destino
	 * @param char o					Letra que representa al disco de origen
	 * @param char a					Letra que representa al disco auxiliar
	 * @param char d					Letra que representa al disco de destino
	 * 
	 * Salida:
	 * @return String			Cadena invertida
	 * 
	 */
    public static void hanoi(int n, Stack<Integer> origen, Stack<Integer> auxiliar, Stack<Integer> destino,
                             char o, char a, char d) {
        if (n == 1) {
            moverDisco(origen, destino, o, d);
        } else {
            hanoi(n - 1, origen, destino, auxiliar, o, d, a);
            moverDisco(origen, destino, o, d);
            hanoi(n - 1, auxiliar, origen, destino, a, o, d);
        }
    }

	/**
	 * Función: moverDisco
	 * 
	 * Mueve un disco de la pila origen a la de destino.
	 * 
     * @author Efrén Sánchez
     * 
	 * Entrada:
	 * @param int n						Entero positivo término de la conjetura de Collatz
	 * @param Stack<Integer> origen		Pila con el disco de origen
	 * @param Stack<Integer> auxiliar	Pila con el disco auxiliar
	 * @param Stack<Integer> destino	Pila con el disco de destino
	 * @param char o					Letra que representa al disco de origen
	 * @param char a					Letra que representa al disco auxiliar
	 * @param char d					Letra que representa al disco de destino
	 * 
	 * Salida:
	 * @return String			Cadena invertida
	 * 
	 */
    public static void moverDisco(Stack<Integer> origen, Stack<Integer> destino, char o, char d) {
        int disco = origen.pop();
        destino.push(disco);
        System.out.println("Mover disco " + disco + " de " + o + " a " + d);
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
        System.out.println("-------------------------");
        for (int i = totalDiscos - 1; i >= 0; i--) {
            System.out.print(mostrarDisco(torreA, i));
            System.out.print(mostrarDisco(torreB, i));
            System.out.println(mostrarDisco(torreC, i));
        }
        System.out.println("-------------------------");
        System.out.println("  A       B       C");
    }

    /**
	 * Función: mostrarDisco
	 * 
	 * Construye la cadena de caracteres que representa un disco con su centro.
	 * 
     * @author Efrén Sánchez
     * 
	 * Entrada:
     * @param Stack<Integer> torre      Carácter que representa la torre
     * @param int index                 Anchura del disco
	 * 
	 * Salida: 
     * @return String                   Cadena con el centro pintado
	 * 
	 */
    public static String mostrarDisco(Stack<Integer> torre, int index) {
        if (index < torre.size()) {
            int disco = torre.get(index);
            return centro("=".repeat(disco * 2 - 1), totalDiscos * 2) + " ";
        } else {
            return centro("|", totalDiscos * 2) + " ";
        }
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
     * @param int ancho      Anchura del disco
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