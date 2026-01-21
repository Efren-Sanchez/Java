/**
 * E100_FuncionSaludo
 * 
 * @author: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Función Saludo
 *
 * Programa que muestra el uso de una función saludo, que recibe un nombre 
 * introducido por teclado e imprime un saludo por pantalla.
 *  
 */

import java.util.Scanner;

public class E100_FuncionSaludo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E100_FuncionSaludo *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, introduce un nombre: ");
        String nombre = sc.nextLine();

        // Ejemplos de llamadas a un procedimiento o función de tipo void (que no devuelve nada)
        saludo(nombre); // Podemos hacer la llamada pasando una variable como parámetro

        saludo("Nombre Apellido");  // Podemos pasar una cadena
        saludo("NA");

        nombre = "Fulanito Menganito Zutanito";
        saludo(nombre);

        String lalala = "lalala";
        saludo(lalala);
        
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }

    /**
     * Función Saludo
     * 
     * Imprime un saludo por pantalla con el nombre recibido por parámetro.
     * 
     * @author: Efrén Sánchez
     * 
     * @param n String Nombre a imprimir
     * 
     */
    public static void saludo(String n) {
        System.out.println("Hola " + n + ". ¿Cómo estás?");
    }
}