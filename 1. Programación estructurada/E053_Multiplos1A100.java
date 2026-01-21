/*******************************************************************************
 * 
 * E053_Multiplos1A100
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Múltiplos de 7 de 1 a 100
 *
 * Programa que muestra por pantalla los números de 1 a 100 que son múltiplos de
 * 7 utilizando un bucle while.
 * 
 ******************************************************************************/

public class E053_Multiplos1A100 {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E053_Multiplos1A100 *\n\n  --- Inicio del programa ---\n\n");

		int contador = 1, fin = 100;

        while (contador <= fin) { 
            if (contador % 7 == 0) System.out.print(contador + ", ");
            contador++;  
        }		
		
		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}