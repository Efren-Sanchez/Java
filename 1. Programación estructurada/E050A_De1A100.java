/*******************************************************************************
 * 
 * E050A_De1A100
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

public class E050A_De1A100 {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E050A_De1A100 *\n\n  --- Inicio del programa ---\n\n");

		int inicio = 1,	// Inicio de la sucesión
			fin = 100, 	// Fin de la sucesión
			contador;	// Variable donde almacenaremos el valor a mostrar por pantalla 
		
		// Inicializamos el contador con el inicio de la sucesión
		contador = inicio;
		
		// Mientras el contador sea menor que el fin (es una secesión creciente) lo iremos incrementando
		while (contador <= fin)
		{
			// Si el número que vamos a mostrar es menor de 10, entonces solo ocupa un espacio.
			// Añadimos un espacio en blanco por delante para que quede alineado
			if (contador < 10)
				System.out.print(" ");
			
			// Si el contador no ha llegado a 100 añadimos una coma como separador de los números.
			// Al final, en lugar de añadir una coma ponemos un punto
			if (contador != 100)	
				System.out.print(contador + ", ");	// Para todos los números menos el 100
			else
				System.out.print(contador + ".");	// Esto solo se hace en el 100
			
			// Si el número es múltiplo de 10 insertamos un salto de línea, para que aparezcan solo
			// 10 elementos por fila
			if (contador % 10 == 0)
				System.out.print("\n");
			
			contador++;	// Incrementamos el contador
		}

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}