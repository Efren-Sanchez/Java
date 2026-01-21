/*******************************************************************************
 * 
 * E010_IntercambioValores
 * 
 * Autor: Efrén Sánchez
 * Fecha: 24/09/2025
 *  
 * Intercambio del valor de dos variables
 * 
 * Programa que intercambia el valor de dos variables, mostrando que es 
 * imprescindible el uso de una variable auxiliar para realizar esta acción.
 * 
 ******************************************************************************/

 public class E010_IntercambioValores {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E010_IntercambioValores *\n\n  --- Inicio del programa ---\n\n");
		
		int x = 1, y = 2, aux;
		
		// Valores iniciales de las variables
        System.out.println(x);
		System.out.println(y);

		// No se puede hacer el intercambio de valores sin usar una variable auxilliar o temporal
		aux = x;
		x = y;
		y = aux;
		
		// Valores de las variables después del intercambio
		System.out.println(x);
		System.out.println(y);

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}