/*******************************************************************************
 * 
 * E034_DiaSiguiente
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Día siguiente
 *
 * Programa que dada una fecha devuelve la fecha del día siguiente.
 * 
 ******************************************************************************/

 import java.util.Scanner;

public class E034_DiaSiguiente {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E034_DiaSiguiente *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		int dia, mes, anyo;
		boolean bisiesto;
		
		// Petición de datos al usuario
		System.out.print("Por favor, introduce el dia: ");
		dia = sc.nextInt();
		
		System.out.print("Por favor, introduce el mes: ");
		mes = sc.nextInt();
		
		System.out.print("Por favor, introduce el año: ");
		anyo = sc.nextInt();
		
		System.out.println("La fecha introducida es: " + dia + "/" + mes + "/" + anyo);
		
		// Calculo de si es bisiesto o no
		if (anyo % 4 == 0) {
			if (anyo % 100 == 0) {
				if (anyo % 400 == 0) bisiesto = true;
				else bisiesto = false;
			} else
				bisiesto = true;
		}
		else
			bisiesto = false;	
		
		// Calculo el día siguiente
		dia++;
		
		if ((dia > 31 && (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)) ||
			(dia > 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11)) ||
			(dia > 28 && mes == 2 && !bisiesto) ||
			(dia > 29 && mes == 2 && bisiesto)) {
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