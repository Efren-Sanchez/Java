/*******************************************************************************
 * 
 * E015_Ecucacion2Grado
 * 
 * Autor: Efrén Sánchez
 * Fecha: 24/09/2025
 * 
 * Ecuaciones de segundo grado
 *
 * Programa que resuelve ecuaciones de 2º grado del tipo Ax^2 + Bx + C = 0 
 * mediante la fórmula:
 * 
 * 		-b +-√(b² - 4ac)
 * x =  -------------------
 * 				2a
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E015_Ecucacion2Grado {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E015_Ecucacion2Grado *\n\n  --- Inicio del programa ---\n\n");

		// Variables necesarias
		double  A = 2, 
				B = 4, 
				C = -6,
				X1, X2;
				
		// Variables auxiliares
		double numerador, denominador, raiz, radicando, Bexp2;

        Scanner sc = new Scanner(System.in);

        System.out.println("\nIntroduce el primer número: ");
        A = sc.nextInt();

        System.out.println("\nIntroduce el segundo número: ");
        B = sc.nextInt();

        System.out.println("\nIntroduce el tercer número: ");
        C = sc.nextInt();
        
		// Presentamos la información inicial del problema al usuario
		System.out.println("Ecuación de 2º grado");
		System.out.println("--------------------\n");
		System.out.println(A + "x^2 + " + B + "x + " + C + " = 0\n\n");
		
		// Resolución paso por paso ------------------------------------
		// Calculamos X1 (-b + raiz)
		Bexp2		= Math.pow(B, 2);		// Calculo B al cuadrado
		radicando 	= Bexp2 - ( 4 * A * C);	// Calculo el radicando de la raiz
		raiz 		= Math.sqrt(radicando);	// Hago la raiz cuadrada
		numerador 	= -B + raiz;			// Calculo el numerador
		denominador = 2 * A;				// Calculo el denominador
		X1 			= numerador / denominador;
		
		// Calculamos X2 (-b - raiz)
		Bexp2		= Math.pow(B, 2);		// Calculo B al cuadrado
		radicando 	= Bexp2 - ( 4 * A * C);	// Calculo el radicando de la raiz
		raiz 		= Math.sqrt(radicando);	// Hago la raiz cuadrada
		numerador 	= -B - raiz;			// Calculo el numerador
		denominador = 2 * A;				// Calculo el denominador
		X2 			= numerador / denominador;
		
		// Mostramos los resultados al usuario
		System.out.println("X1 = " + X1);
		System.out.println("X2 = " + X2);
		
		
		// De forma directa --------------------------------------------
		X1 = (-B + Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
		X2 = (-B - Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
		
		System.out.println("\n\nX1 = " + X1);
		System.out.println("X2 = " + X2);

        sc.close();
    }
}