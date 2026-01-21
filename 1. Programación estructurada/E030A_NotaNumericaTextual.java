/*******************************************************************************
 * 
 * E030A_NotaNumericaTextual
 * 
 * Autor: Efrén Sánchez
 * Fecha: 1/10/2025
 * 
 * Nota numérica a textual
 *
 * Programa que da la nota textual a partir de una nota numérica 
 * 
 * Programa que pide por teclado una nota y muestra por pantalla la nota textual
 * según estas normas:
 * - nota < 5 --> suspendido
 * - nota entre 5 y 5,99 --> suficiente
 * - nota entre 6 y 6,99 --> bien
 * - nota entre 7 y 8,49 --> notable
 * - nota entre 8,5 y 9.99 --> sobresaliente
 * - nota igual a 10 --> matrícula de honor
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E030A_NotaNumericaTextual {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E030A_NotaNumericaTextual *\n\n  --- Inicio del programa ---\n\n");

		double nota;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Por favor, introduce la nota numérica: ");
		nota = sc.nextDouble();
		
		// Este primer caso sería una comprobación de errores:
		// si la nota es inferior a 0 o superior a 10 acabamos
		if (nota < 0 || nota > 10) 	System.out.println("** Error: la nota introducida no es correcta. Debe estar entre 0 y 10. **");
		else if (nota < 5) 			System.out.println("INSUFICIENTE");
		else if (nota < 6)			System.out.println("SUFICIENTE");
		else if (nota < 7)			System.out.println("BIEN");
		else if (nota < 8.5)		System.out.println("NOTABLE");
		else if (nota < 9.99)		System.out.println("SOBRESALIENTE");
		else if (nota == 10)		System.out.println("MATRICULA DE HONOR");
		else						System.out.println(" ** Error desconocido **");
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}