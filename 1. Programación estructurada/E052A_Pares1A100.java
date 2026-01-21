/*******************************************************************************
 * 
 * E052A_Pares1A100
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

public class E052A_Pares1A100 {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E052A_Pares1A100 *\n\n  --- Inicio del programa ---\n\n");

		int inicio = 2, 	// Inicio de la sucesión
			fin = 100, 		// Fin de la sucesión
			contador;		// En esta variable almacenamos el valor de 1 a 100 para mostrarla por pantalla
		
		// Inicializamos el contador al valor de inicio de la sucesión
		contador = inicio;
		
		// Mientras el contador sea menor o igual que fin (es una sucesión decreciente)
		while (contador <= fin)
		{
			// Imprimimos solo los números pares
			if (contador % 2 == 0)	System.out.println(contador);
			
			// Incrementamos el contador en 2 para dar solo múltiplos
			contador += 2;
		}
		
		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}