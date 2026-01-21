/*******************************************************************************
 * 
 * E014_MediaAritmeticaGeometrica
 * 
 * Autor: Efrén Sánchez
 * Fecha: 25/09/2025
 * 
 * Cálculo de medias aritmética y geométrica
 * 
 * Programa que calcula las medias aritmética y geométrica de 3 números 
 * introducidos por teclado.
 * 
 * Para calcular la media geométrica se deben multiplicar todos los números 
 * de los que hacer la media, y hacer la raiz enésima de ese resultado, siendo
 * n la cantidad de números implicados.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E014_MediaAritmeticaGeometrica {
    public static void main(String[] args) {

        System.out.println("\n\n\n* E014_MediaAritmeticaGeometrica *\n\n  --- Inicio del programa ---\n\n");

		double  a, b, c, mediaArit, mediaGeo;
        Scanner sc = new Scanner(System.in);

        // Introducción de datos de entrada
        System.out.println("\nIntroduce el primer número: ");
        a = sc.nextInt();

        System.out.println("\nIntroduce el segundo número: ");
        b = sc.nextInt();

        System.out.println("\nIntroduce el tercer número: ");
        c = sc.nextInt();

		// Debemos hacer uso de los paréntesis para conseguir el resultado adecuado
		mediaArit = (a + b + c) / 3;
		
		System.out.println("La media aritmética de " + a + ", " + b + " y " + c + " es: " + mediaArit);
		
		// No hace falta guardar el resultado de la operación en una variable intermedia. 
		// Podemos imprimir directamente el resultado del cálculo.
		System.out.println((a + b + c) / 3);

        // Hacemos la raiz cúbica
   		mediaGeo = Math.cbrt(a * b * c);

		System.out.println("La media geométrica de " + a + ", " + b + " y " + c + " es: " + mediaGeo);

        // Usando pow en lugar de cbrt
   		mediaGeo = Math.pow((a * b * c), (1.0/3)); // OJO, si pasamos (1/3) como exponente, el resultado es entero y es 0
        System.out.println("La media geométrica de " + a + ", " + b + " y " + c + " es: " + mediaGeo);

        sc.close();

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}