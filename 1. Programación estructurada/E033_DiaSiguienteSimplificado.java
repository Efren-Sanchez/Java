/*******************************************************************************
 * 
 * E033_DiaSiguienteSimplificado
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Día siguiente (simplificado)
 *
 * Programa que dada una fecha devuelve la fecha del día siguiente.
 * Se considera que todos los meses tiene 30 días.
 * 
 ******************************************************************************/

 import java.util.Scanner;

public class E033_DiaSiguienteSimplificado {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E033_DiaSiguienteSimplificado *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		int dia, mes, anyo;
		
		// Petición de datos al usuario
		System.out.print("Por favor, introduce el dia: ");
		dia = sc.nextInt();
		
		System.out.print("Por favor, introduce el mes: ");
		mes = sc.nextInt();
		
		System.out.print("Por favor, introduce el año: ");
		anyo = sc.nextInt();
		
		System.out.println("La fecha introducida es: " + dia + "/" + mes + "/" + anyo);
		
		// Calculo el día siguiente
		dia++;
		if (dia > 30) {
			dia = 1;
			mes++;
		}
		
		if (mes > 12) {
			mes = 1;
			anyo++;
		}
		
		System.out.println("La fecha del día siguiente es: " + dia + "/" + mes + "/" + anyo);
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}