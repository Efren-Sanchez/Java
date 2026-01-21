/**
 * E101_FuncionSuma
 * 
 * @author: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Función Suma
 *
 * Programa que muestra el uso de una función saludo, que recibe un nombre 
 * introducido por teclado e imprime un saludo por pantalla.
 *  
 */

import java.util.Scanner;

public class E101_FuncionSuma {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E101_FuncionSuma *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, introduce el primer sumando: ");
        int x = sc.nextInt();
        System.out.println("Por favor, introduce el segundo sumando: ");
        int y = sc.nextInt();

        suma(2,3);
        System.out.println("La suma de 2 + 3 = " + suma(2,3));
        System.out.println("La suma de 12 + 13 = " + suma(12,13));

        System.out.println("La suma de " + x + " + " + y + " = " + suma(x,y));
        
        int s = suma(2,3);
        System.out.println("La suma de 2 y 3 es: " + s);
        
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }

    /**
     * Función Suma
     * 
     * Devuelve la suma de dos enteros recibidos por parámetro.
     * 
     * @author: Efrén Sánchez
     * 
     * @param a Int Primer sumando
     * @param b Int Segundo sumando
     * @return Suma de a + b
     * 
     */
    public static int suma(int a, int b) {
        //return a + b;
        int resultado = a + b;
        return resultado;
    }

    // Ejemplo de sobrecarga: declaración de funciones con el mismo nombre pero
    // distinto número o tipo de parámetros, característica permitida en Java

    /**
     * Función Suma
     * 
     * Devuelve la suma de tres enteros recibidos por parámetro.
     * 
     * @author: Efrén Sánchez
     * 
     * @param a Int Primer sumando
     * @param b Int Segundo sumando
     * @param b Int Tercer sumando
     * @return Suma de a + b + c
     * 
     */
    public static int suma(int a, int b, int c) {
        return a + b + c; 
    }

    /**
     * Función Suma
     * 
     * Devuelve la suma de cuatro enteros recibidos por parámetro.
     * 
     * @author: Efrén Sánchez
     * 
     * @param a Int Primer sumando
     * @param b Int Segundo sumando
     * @param c Int Tercer sumando
     * @param d Int Cuarto sumando
     * @return Suma de a + b + c + d
     * 
     */
    public static int suma(int a, int b, int c, int d) {
        return a + b + c + d; 
    }
}