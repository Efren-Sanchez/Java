/**
 * E103_Calculadora
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

public class E103_Calculadora {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E103_Calculadora *\n\n  --- Inicio del programa ---\n\n");

        calculadora();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }

    /**
     * Función calculadora
     * 
     * Muestra un menú por pantalla para que el usuario pueda realizar 
     * operaciones matemáticas básicas. 
     * 
     * @author: Efrén Sánchez
     * 
     */
    public static void calculadora() {
                Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            opcion = mostrarMenu();
    
            switch (opcion) {
                // Suma
                case 1:
                    System.out.print("Introduce el primer número: ");
                    double num1 = sc.nextDouble();
                    System.out.print("Introduce el segundo número: ");
                    double num2 = sc.nextDouble();
                    System.out.println("Resultado: " + suma(num1, num2));
                    break;

                // Resta
                case 2:
                    System.out.print("Introduce el primer número: ");
                    num1 = sc.nextDouble();
                    System.out.print("Introduce el segundo número: ");
                    num2 = sc.nextDouble();
                    System.out.println("Resultado: " + resta(num1, num2));
                    break;

                // Multiplicación
                case 3:
                    System.out.print("Introduce el primer número: ");
                    num1 = sc.nextDouble();
                    System.out.print("Introduce el segundo número: ");
                    num2 = sc.nextDouble();
                    System.out.println("Resultado: " + multiplicacion(num1, num2));
                    break;
                
                // División
                case 4:
                    System.out.print("Introduce el primer número: ");
                    num1 = sc.nextDouble();
                    System.out.print("Introduce el segundo número: ");
                    num2 = sc.nextDouble();
                    if (num2 != 0) {
                        System.out.println("Resultado: " + division(num1, num2));
                    } else {
                        System.out.println("No se puede dividir por cero.");
                    }
                    break;
                
                // Raiz cuadrada
                case 5:
                    System.out.print("Introduce el número: ");
                    num1 = sc.nextDouble();
                    if (num1 >= 0) {
                        System.out.println("Raíz cuadrada: " + raiz(num1));
                    } else {
                        System.out.println("No se puede calcular la raíz cuadrada de un número negativo.");
                    }
                    break;

                // Ecuación de 2º grado
                case 6:
                    System.out.println("Resolver ecuación de 2º grado: ax^2 + bx + c = 0");
                    System.out.print("Introduce a: ");
                    double a = sc.nextDouble();
                    System.out.print("Introduce b: ");
                    double b = sc.nextDouble();
                    System.out.print("Introduce c: ");
                    double c = sc.nextDouble();
                    ecuacion2g(a, b, c);
                    break;

                // Salir
                case 0: break;  // No hacemos nada si el usuario quiere salir

                // Error
                default:
                    System.out.println("Opción no válida.");    // Avisamos del error 
            }
        } while(opcion != 0); 
        
        sc.close();
    }

    /**
     * Función suma
     * 
     * Devuelve la suma de dos reales pasados por parámetro.
     * 
     * @author: Efrén Sánchez
     * 
     * @param x Double Primer sumando
     * @param y Double Segundo sumando
     * @return Suma de los parámetros
     * 
     */
    public static double suma (double x, double y) {
        return (x + y);
    }
    
    /**
     * Función resta
     * 
     * Devuelve la resta de dos reales pasados por parámetro.
     * 
     * @author: Efrén Sánchez
     * 
     * @param x Double Minuendo
     * @param y Double Sustraendo
     * @return Resta de los parámetros
     * 
     */
    public static double resta (double x, double y) {
        return (x - y);
    }

    /**
     * Función multiplicación
     * 
     * Devuelve la multiplicación de dos reales pasados por parámetro.
     * 
     * @author: Efrén Sánchez
     * 
     * @param x Double Primer multiplicando
     * @param y Double Segundo multiplicando
     * @return Multiplicación de los parámetros
     * 
     */
    public static double multiplicacion (double x, double y) {
        return (x * y);
    }

    /**
     * Función division
     * 
     * Devuelve la división de dos reales pasados por parámetro.
     * 
     * @author: Efrén Sánchez
     * 
     * @param x Double Dividendo
     * @param y Double Divisor
     * @return Cociente de la resta
     * 
     */
    public static double division (double x, double y) {
        return (x / y);
    }

    /**
     * Función raiz
     * 
     * Devuelve la raiz cuadrada de un número recibido por parámetro.
     * 
     * @author: Efrén Sánchez
     * 
     * @param x Double Radicando
     * @return Raiz cuadrada
     * 
     */    
    public static double raiz (double x) {
        if (x >= 0)
            return Math.sqrt(x);
        else   
            return -1;
    }

    /**
     * Función ecuacion2g
     * 
     * Cualcula la solución de una ecuación de 2º grado.
     * 
     * @author: Efrén Sánchez
     * 
     * @param a Double Coeficiente A
     * @param b Double Coeficiente B
     * @param c Double Coeficiente C
     * 
     */
    public static void ecuacion2g (double a, double b, double c) {
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
    }

    /**
     * Función mostrarMenu
     * 
     * Muestra por pantalla el menú con las distintas opciones de la 
     * calculadora.
     * 
     * @author: Efrén Sánchez
     * 
     * @param a Double Coeficiente A
     * @param b Double Coeficiente B
     * @param c Double Coeficiente C
     * 
     */
    public static int mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("\n\nMenú de operaciones:");
        System.out.println("--------------------");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Raíz cuadrada");
        System.out.println("6. Ecuación de 2º grado");
        System.out.println("--------------------");
        System.out.println("0. Salir");
        System.out.println("--------------------");
        System.out.print("Elige una opción (0-6): ");
        opcion = sc.nextInt();
        
        sc.close();
        
        return opcion;
    }
}