/*******************************************************************************
 * 
 * E009_EntradaPorTeclado
 * 
 * Autor: Efrén Sánchez
 * Fecha: 24/09/2025
 * 
 * Lectura de datos por teclado con Scanner
 * 
 ******************************************************************************/

import java.util.Scanner;   // Imprescindible importar Scanner de java.util

public class E009_EntradaPorTeclado {
    public static void main(String[] args) {

        System.out.println("\n\n\n* E009_EntradaPorTeclado *\n\n  --- Inicio del programa ---\n\n");

        // Declarar el objeto e inicializar con el objeto de entrada estándar predefinido
        Scanner sc = new Scanner(System.in);

        // Entrada de una cadena de caracteres
        System.out.println("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        // Entrada de un carácter
        System.out.println("Introduce tu género: ");
        char genero = sc.next().charAt(0);

        // Entrada de datos numéricos
        System.out.println("Introduce tu edad: ");
        int edad = sc.nextInt();

        System.out.println("Introduce tu móvil: ");
        long movil = sc.nextLong();

        System.out.println("Introduce tu peso: ");
        double peso = sc.nextDouble();

        System.out.println("\nDatos leidos por teclado\nNombre: " + nombre);
        System.out.println("Género: " + genero);
        System.out.println("Edad: " + edad);
        System.out.println("Teléfono: " + movil);
        System.out.println("Peso: " + peso);

        sc.close();

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}