/**
 * E109_Combinatoria
 * 
 * @author Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Combinatoria
 * 
 * Programa que realiza operaciones de combinatoria
 * 
 * Requisitos:
 * Crea un programa que permita realizar las principales operaciones de combinatoria
 * (se recomienda leer el artículo de Wikipedia para entender el problema): 
 * - C: Combinaciones sin repetición.
 * - V: Variaciones sin repetición.
 * - P: Permutaciones sin repetición. 
 * - CR: Combinaciones con repetición.
 * - VR: Variaciones con repetición.
 * - PR: Permutaciones con repetición.
 * 
 * El programa debe utilizar una función factorial que reciba un número y devuelva el 
 * resultado de su productorio. No se permite codificarla de manera recursiva, debe ser 
 * iterativa.
 * El usuario realizará el número de operaciones que desee. Para salir debe pulsar el cero.
 * El programa debe ofrecer la posibilidad de mostrar una pequeña explicación y ejemplo de
 * cada una de las opciones disponibles.
 * 
 */

import java.util.Scanner;

public class E109_Combinatoria {
	public static void main(String[] args) {

		System.out.println("\n\n\n* E109_Combinatoria *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		int opcion; 
		long total, numero, resultado;
		
		do {
			// Menú de opciones
			System.out.println("\nPor favor, elige la opción que desees: ");
			System.out.println("\n1) Combinaciones");
			System.out.println("2) Variaciones");
			System.out.println("3) Permutaciones");
			System.out.println("4) Combinaciones con repetición");
			System.out.println("5) Variaciones con repetición");
			System.out.println("6) permutaciones con repetición");
			System.out.println("9) Ayuda");
			System.out.println("0) Salir");
			System.out.println("..............");
			
			opcion = sc.nextInt();
	
			// En función de la opción elegida se llama a la función correspondiente
			switch(opcion) {
				case 1:
					System.out.print("\nIntroduce el número total de elementos: ");
					total = sc.nextLong();
					System.out.print("\n¿De cuántos en cuántos quieres cogerlos?: ");
					numero = sc.nextLong();
					resultado = combinaciones(total, numero);
					System.out.println("Hay " + resultado + " combinaciones distintas en un conjunto de " + total + " cogidos de " + numero + " en " + numero);
					break;
				case 2:
					System.out.print("\nIntroduce el número total de elementos: ");
					total = sc.nextLong();
					System.out.print("\n¿De cuántos en cuántos quieres cogerlos?: ");
					numero = sc.nextLong();
					resultado = variaciones(total, numero);
					System.out.println("Hay " + resultado + " variaciones distintas en un conjunto de " + total + " cogidos de " + numero + " en " + numero);
					break;
				case 3:
					System.out.print("\nIntroduce el número total de elementos: ");
					total = sc.nextLong();
					resultado = permutaciones(total);
					System.out.println("Hay " + resultado + " permutaciones distintas en un conjunto de " + total + " elementos");
					break;
				case 4:
					System.out.print("\nIntroduce el número total de elementos: ");
					total = sc.nextLong();
					System.out.print("\n¿De cuántos en cuántos quieres cogerlos?: ");
					numero = sc.nextLong();
					resultado = combinacionesRepeticion(total, numero);
					System.out.println("Hay " + resultado + " combinaciones distintas en un conjunto de " + total + " cogidos de " + numero + " en " + numero);
					break;
				case 5:
					System.out.print("\nIntroduce el número total de elementos: ");
					total = sc.nextLong();
					System.out.print("\n¿De cuántos en cuántos quieres cogerlos?: ");
					numero = sc.nextLong();
					resultado = variacionesRepeticion(total, numero);
					System.out.println("Hay " + resultado + " variaciones distintas en un conjunto de " + total + " cogidos de " + numero + " en " + numero);
					break;
				case 6:
					// OJO con este caso: la función acepta parámetros variables que aquí no se están usando
					System.out.print("\nIntroduce el número total de elementos: ");
					total = sc.nextLong();
					System.out.print("\n¿De cuántos en cuántos quieres cogerlos?: ");
					numero = sc.nextLong();
					resultado = permutacionesRepeticion(total, numero);
					System.out.println("Hay " + resultado + " permutaciones distintas en un conjunto de " + total + " cogidos de " + numero + " en " + numero);
					break;
				case 9:
					mostrarAyuda();
					break;
				default:
			}
		  // Mientras el usuario no introduzca una ese	
		} while (opcion != 0);	

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
	}
	

	/**
	 * Función: factorial
	 * 
	 * Calcula el factorial de un número de manera iterativa
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada:
	 * @param long n			Entero positivo para calcular el factorial
	 * 
	 * Salida:
	 * @return long			Factorial
	 * 
	 */
	static long factorial(long n)
	{	
		long fact = 1;
		
		for (long i = 2; i <= n; i++)
			fact *= i; // Acumulamos el productorio
		
		return fact;
	}

	/**
	 * Función: combinaciones
	 * 
	 * Calcula las combinaciones de n elementos tomados de r en r:
	 * posibles muestras sin orden de r elementos distintos que se pueden 
	 * extraer de un conjunto de n elementos (r ≤ n).
	 * 
	 * Ejemplo: En una reunión de 8 personas debe nombrarse una comisión 
	 * formada por dos de ellas. ¿Cuántas comisiones distintas podrían 
	 * nombrarse?
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada:
	 * @param long n			Número total de elementos
	 * @param long r			Cuantos tomamos del total
	 * 
	 * Salida:
	 * @return long			Combinaciones distintas posibles
	 * 
	 */
	static long combinaciones(long n, long r)
	{			
		return (factorial(n) / (factorial(r) * factorial(n - r)));
		// OJO: he hecho pruebas y no va muy bien... Puede ser un problema de precisión
	}

	/**
	 * Función: variaciones
	 * 
	 * Calcula las variaciones de n elementos tomados de r en r: 
	 * posibles muestras ordenadas de r elementos distintos que se pueden 
	 * extraer de un conjunto de n elementos, siendo r ≤ n.
	 * 
	 * Ejemplo: En una carrera con 6 atletas, ¿de cuántas formas distintas 
	 * podrían repartirse las medallas de oro y plata?
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada:
	 * @param long n			Número total de elementos
	 * @param long r			Cuantos tomamos del total
	 * 
	 * Salida:
	 * @return long			Variaciones distintas posibles
	 * 
	 */
	static long variaciones(long n, long r)
	{			
		return (factorial(n) / (factorial(n - r)));
	}

	/**
	 * Función: permutaciones
	 * 
	 * Calcula las permutaciones de n elementos:
	 * son las posibles ordenaciones de un conjunto de n elementos distintos.
	 * 
	 * Ejemplo: ¿Cuántos números de 4 cifras distintas pueden escribirse con 
	 * los dígitos 2, 3 , 5 y 8?
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada:
	 * @param long n			Número total de elementos
	 * 
	 * Salida:
	 * @return long			Variaciones distintas posibles
	 * 
	 */
	static long permutaciones(long n)
	{			
		return factorial(n);
	}

	/**
	 * Función: combinacionesRepeticion
	 * 
	 * Calcula las combinaciones con repetición de n elementos tomados de r en r: 
	 * posibles muestras no ordenadas de r elementos no necesariamente distintos 
	 * que se pueden extraer de un conjunto de n elementos.
	 * 
	 * Ejemplo: Un banco ofrece un regalo a elegir entre 5 posibles regalos por 
	 * cada cartilla. Un señor que tiene tres cartillas en dicho banco ¿de cuántas 
	 * formas puede elegir el lote de tres obsequios si no le importa repetir 
	 * regalos?
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada:
	 * @param long n			Número total de elementos
	 * @param long r			Cuantos tomamos del total
	 * 
	 * Salida:
	 * @return long			Combinaciones distintas posibles
	 * 
	 */
	static long combinacionesRepeticion(long n, long r)
	{			
		return (factorial(n + r - 1) / (factorial(r) * factorial(n - 1)));
	}

	/**
	 * Función: variacionesRepeticion
	 * 
	 * Calcula lLas variaciones con repetición de n elementos tomados de r en r: 
	 * posibles muestras ordenadas de r elementos no necesariamente distintos 
	 * que se pueden extraer de un conjunto de n elementos.
	 * 
	 * Ejemplo: ¿Cuántos números distintos de 3 cifras se escriben usando 
	 * solamente las cifras 1, 2, 5 y 8?
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada:
	 * @param long n			Número total de elementos
	 * @param long r			Cuantos tomamos del total
	 * 
	 * Salida:
	 * @return long			Variaciones distintas posibles
	 * 
	 */
	static long variacionesRepeticion(long n, long r)
	{			
		return (long) Math.pow(n, r);
	}

	/**
	 * Función: permutacionesRepeticion
	 * 
	 * Calcula las permutaciones con repetición son las posibles ordenaciones 
	 * de una secuencia de n signos entre los que hay algunos repetidos (uno 
	 * se repite x veces, otro y veces, otro z veces… etc.).
	 * 
	 * Ejemplo: ¿Cuántos números distintos de 6 cifras se pueden escribir 
	 * usando tres unos, dos cincos y un ocho?
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada:
	 * @param long n			Número total de elementos
	 * 
	 * Salida:
	 * @return long			Variaciones distintas posibles
	 * 
	 */
	static long permutacionesRepeticion(long n, long... repetidos)
	{
		long divisor = 1;
		
		for (int i = 0; i < repetidos.length; i++)
			divisor += factorial(repetidos[i]);
			
		return (long)(factorial(n) / divisor);
	}

	static void mostrarAyuda()
	{
		System.out.println("\nCalcula las combinaciones de n elementos tomados de r en r:");
		System.out.println("posibles muestras sin orden de r elementos distintos que se pueden"); 
		System.out.println("extraer de un conjunto de n elementos (r ≤ n).");
		System.out.println("\nEjemplo: En una reunión de 8 personas debe nombrarse una comisión"); 
		System.out.println("formada por dos de ellas. ¿Cuántas comisiones distintas podrían");
		System.out.println("nombrarse?");
				
		// OJO: falta acabar!!
	}
}
