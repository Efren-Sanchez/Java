/*******************************************************************************
 * 
 * E051_De100A1
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Números de 100 a 1
 *
 * Programa que muestra por pantalla los números de 1 a 100 utilizando un bucle
 * while.
 * 
 ******************************************************************************/

public class E051_De100A1 {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E051_De100A1 *\n\n  --- Inicio del programa ---\n\n");

		int inicio = 100, 	// Inicio de la sucesión
			fin = 1, 		// Fin de la sucesión
			contador;		// En esta variable almacenamos el valor de 100 a 1 para mostrarla por pantalla
		
		// Inicializamos el contador al valor de inicio de la sucesión
		contador = inicio;
		
		// Mientras el contador sea mayor o igual que fin (es una sucesión decreciente)
		while (contador >= fin)
		{
			System.out.println(contador);
			
			// Decrementamos el contador, le quitamos 1
			contador--;
		}
		
		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}