/*******************************************************************************
 * 
 * E004A_Math
 * 
 * Autor: Efrén Sánchez
 * Fecha: Sep 2025
 * 
 * Constantes y librería Math
 * 
 * Programa que muestra el uso de algunas funciones de la librería Math:
 * - abs
 * - round
 * - random
 * - ceil
 * - floor
 * - toRadians
 * - toDegrees
 * - sin
 * - cos
 * - tan
 * - cbrt
 * - hypot 
 * - signum
 * 
 * Más información: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E004A_Math {
    public static void main(String[] args) {
        
        System.out.println("\n\n\n* E004A_Math *\n\n  --- Inicio del programa ---\n\n");
        
        Scanner scanner = new Scanner(System.in);

        // Valor absoluto
        System.out.print("Introduce un número entero: ");
        int numeroInt = scanner.nextInt();
        
        int valorAbsoluto = Math.abs(numeroInt);
		System.out.println("\nEl valor absoluto es: " + valorAbsoluto);
		
		
		// Redondeo de un número decimal
		System.out.print("\n\nIntroduce un número decimal: ");
        double numero = scanner.nextDouble();
        
        long numeroRedondeado = Math.round(numero);
        System.out.println("\nEl número redondeado es: " + numeroRedondeado);
		
		// Número aleatorio en un rango específico
		System.out.print("\n\nVamos a obtener un núnero aleatorio en un rango.\nIntroduce el valor mínimo: ");
        int min = scanner.nextInt();
        System.out.print("\nIntroduce el valor máximo: ");
        int max = scanner.nextInt();
        
        int numeroAleatorio = (int) (Math.random() * (max - min + 1)) + min;
        System.out.println("\nEl número aleatorio es: " + numeroAleatorio);
		
		// Redondeo hacia arriba (Ceil)
		System.out.print("\n\nIntroduce un número decimal: ");
        double numero2 = scanner.nextDouble();
        
        double numeroRedondeado2 = Math.ceil(numero2);
        System.out.println("\nEl número redondeado hacia arriba es: " + numeroRedondeado2);
        
        // Redondeo hacia abajo (Floor)
        System.out.print("\n\nIntroduce un número decimal: ");
        double numero3 = scanner.nextDouble();
        
        double numeroRedondeado3 = Math.floor(numero3);
        System.out.println("\nEl número redondeado hacia abajo es: " + numeroRedondeado3);
        
        // Conversión de grados a radianes
        System.out.print("\n\nIntroduce un ángulo en grados: ");
        double grados = scanner.nextDouble();
        
        double radianes = Math.toRadians(grados);
        System.out.println("\nEl ángulo en radianes es: " + radianes);
        
        // Conversión de radianes a grados
        grados = Math.toDegrees(radianes);
        System.out.println("\nEl ángulo en grados es: " + grados);
        
        // Cálculo de Seno, Coseno y Tangente
        double seno = Math.sin(radianes);
        double coseno = Math.cos(radianes);
        double tangente = Math.tan(radianes);
        
        System.out.println("\nSeno: " + seno);
        System.out.println("Coseno: " + coseno);
        System.out.println("Tangente: " + tangente);
        
        // Raíz cúbica de un número
        System.out.print("\n\nIntroduce un número para calcular su raiz cúbica: ");
        numero = scanner.nextDouble();
        
        double raizCubica = Math.cbrt(numero);
        System.out.println("\nLa raíz cúbica de " + numero + " es: " + raizCubica);
        
        // Distancia entre dos puntos en un plano
        System.out.print("\n\nCalculemos la distancia entre dos puntos.\nIntroduce la coordenada x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("\nIntroduce la coordenada y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("\nIntroduce la coordenada x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("\nIntroduce la coordenada y2: ");
        double y2 = scanner.nextDouble();
        
        double distancia = Math.hypot(x2 - x1, y2 - y1);
        System.out.println("\nLa distancia entre los puntos es: " + distancia);
        
        // Calcular el signo de un número
        System.out.print("\n\nIntroduce un número: ");
        numero = scanner.nextDouble();
        
        // signum devuelve 1.0 si es positivo, o -1.0 si es negativo
        double signo = Math.signum(numero);
        System.out.println("\nEl signo del número es: " + signo);
        
        // Constantes en Math
        numero = Math.PI;
        numero = Math.E;

        System.out.println("\n\n  --- Fin del programa ---\n\n");

        scanner.close();
    }
}