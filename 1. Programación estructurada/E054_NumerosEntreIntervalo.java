/*******************************************************************************
 * 
 * E054_NumerosEntreIntervalo
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Números entre 2 introducidos por teclado
 *
 * Programa que muestra por pantalla los números comprendidos entre otros 2 
 * introducidos por teclado de manera creciente. El programa acepta que se 
 * introduzca el número mayor antes que el menor.
 * 
 ******************************************************************************/

 import java.util.Scanner;

public class E054_NumerosEntreIntervalo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E054_NumerosEntreIntervalo *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
		int contador, ini, fin, a, b;

        System.out.println("Por favor, introduce el primer número");
        a = sc.nextInt();
        
        System.out.println("Por favor, introduce el segundo número");
        b = sc.nextInt();

        if (a > b) {
            ini = b;
            fin = a;
        } else {
            ini = a;
            fin = b;
        }

        contador = ini;
        while (contador <= fin) { 
            System.out.print(contador + ", ");
            contador++;  
        }		
		
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}