/*******************************************************************************
 * 
 * E050_De1A100
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Números de 1 a 100
 *
 * Programa que muestra por pantalla los números de 1 a 100 utilizando un bucle
 * while.
 * 
 ******************************************************************************/

public class E050_De1A100 {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E050_De1A100 *\n\n  --- Inicio del programa ---\n\n");

        int inicio = 1,	// Inicio de la sucesión 
			fin = 100, 	// Fin de la sucesión
			contador;	// Variable donde almacenaremos el valor a mostrar por pantalla
		
		// Inicializamos el contador con el inicio de la sucesión
		contador = inicio;
		
		// Mientras el contador sea menor que el fin (es una secesión creciente) lo iremos incrementando
		while (contador <= fin)
		{
			System.out.println(contador);
			
			// Aumentamos en 1 el valor del contador
			contador++;
		}

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}