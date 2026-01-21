/*******************************************************************************
 * 
 * E040_Calculadora
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Calculadora
 *
 * Programa que muestre un menú por pantalla en el que se ofrezca al usuario 
 * realizar una operación matemática: suma, resta, multiplicación, división, 
 * raiz cuadrada, ecuación de 2º grado. El programa debe utilizar un switch.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E040_Calculadora {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E040_Calculadora *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);

        System.out.println("Menú de operaciones:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Raíz cuadrada");
        System.out.println("6. Ecuación de 2º grado");
        System.out.print("Elige una opción (1-6): ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Introduce el primer número: ");
                double num1 = sc.nextDouble();
                System.out.print("Introduce el segundo número: ");
                double num2 = sc.nextDouble();
                System.out.println("Resultado: " + (num1 + num2));
                break;
            case 2:
                System.out.print("Introduce el primer número: ");
                num1 = sc.nextDouble();
                System.out.print("Introduce el segundo número: ");
                num2 = sc.nextDouble();
                System.out.println("Resultado: " + (num1 - num2));
                break;
            case 3:
                System.out.print("Introduce el primer número: ");
                num1 = sc.nextDouble();
                System.out.print("Introduce el segundo número: ");
                num2 = sc.nextDouble();
                System.out.println("Resultado: " + (num1 * num2));
                break;
            case 4:
                System.out.print("Introduce el primer número: ");
                num1 = sc.nextDouble();
                System.out.print("Introduce el segundo número: ");
                num2 = sc.nextDouble();
                if (num2 != 0) {
                    System.out.println("Resultado: " + (num1 / num2));
                } else {
                    System.out.println("No se puede dividir por cero.");
                }
                break;
            case 5:
                System.out.print("Introduce el número: ");
                num1 = sc.nextDouble();
                if (num1 >= 0) {
                    System.out.println("Raíz cuadrada: " + Math.sqrt(num1));
                } else {
                    System.out.println("No se puede calcular la raíz cuadrada de un número negativo.");
                }
                break;
            case 6:
                System.out.println("Resolver ecuación de 2º grado: ax^2 + bx + c = 0");
                System.out.print("Introduce a: ");
                double a = sc.nextDouble();
                System.out.print("Introduce b: ");
                double b = sc.nextDouble();
                System.out.print("Introduce c: ");
                double c = sc.nextDouble();
                double discriminante = b*b - 4*a*c;

                if (a == 0) {
                    System.out.println("No es una ecuación de segundo grado.");
                } else if (discriminante > 0) {
                    double x1 = (-b + Math.sqrt(discriminante)) / (2*a);
                    double x2 = (-b - Math.sqrt(discriminante)) / (2*a);
                    System.out.println("Soluciones reales: x1 = " + x1 + ", x2 = " + x2);
                } else if (discriminante == 0) {
                    double x = -b / (2*a);
                    System.out.println("Solución única real: x = " + x);
                } else {
                    System.out.println("No existen soluciones reales.");
                }
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}