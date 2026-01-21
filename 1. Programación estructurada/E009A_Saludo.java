/*******************************************************************************
 * 
 * E009A_Saludo
 * 
 * Autor: Efrén Sánchez
 * Fecha: 24/09/2025
 * 
 * Saludo personalizado por pantalla
 *
 * Programa que pide por teclado el nombre y los dos apellidos y muestra un
 * mensaje por pantalla.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E009A_Saludo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E009A_Saludo *\n\n  --- Inicio del programa ---\n\n");

		String nombre, ape1, ape2;
		
		// Declaramos una variable de tipo Scanner asignandole el teclado
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Por favor, introduce tu nombre: ");
		nombre = sc.nextLine();	// Leemos una cadena de caracteres por teclado
		
		System.out.println("Por favor, introduce tu primer apellido: ");
		ape1 = sc.nextLine();	// Leemos otro String para el 1º apellido
		
		System.out.println("Por favor, introduce tu segundo apellido: ");
		ape2 = sc.nextLine();
		
		// Presentamos la información inicial del problema al usuario
		System.out.println("Hola, " + nombre + " " + ape1 + " " + ape2 + ", ¿cómo estás?");
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}