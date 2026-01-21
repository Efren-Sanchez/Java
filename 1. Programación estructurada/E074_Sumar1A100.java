/*******************************************************************************
 * 
 * E074_Sumar1A100
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Sumar ee 1 a 100
 *
 * Programa que suma los números comprendidos entre el 1 y el 100.
 * Se compara el resultado con el calculado con la suma progresiva aritmética:
 * 
 *                          Sn = n(a1 + an) / 2
 * 
 * siendo n el número total de números que se suman, a1 el primero de ellos,
 * y an el último.
 * 
 * Más información: 
 *      https://es.wikipedia.org/wiki/Progresi%C3%B3n_aritm%C3%A9tica
 * 
 ******************************************************************************/

public class E074_Sumar1A100 {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E074_Sumar1A100 *\n\n  --- Inicio del programa ---\n\n");

        int sum = 0;    // La variable donde vamos a ir acumulando la suma de valores debe estar inicializada a 0
        
        for (int i = 1; i <= 100; i++)
            sum += i;
        
        System.out.println("La suma de los números de 1 a 100 es: " + sum);
        System.out.println("La suma utilizando la fórmula es: " + ((100 * (1 + 100)) / 2));    

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}