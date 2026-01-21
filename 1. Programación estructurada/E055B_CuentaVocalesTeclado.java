/*******************************************************************************
 * 
 * E055B_CuentaVocalesTeclado
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Cuenta las vocales introducidas por teclado
 *
 * Programa que va pidiendo letras por teclado hasta que se introduce un 0, y 
 * cuenta el número de vocales que se han introducido.
 * 
 * Versión con bucle infinito y break.
 * 
 ******************************************************************************/

 import java.util.Scanner;

public class E055B_CuentaVocalesTeclado {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E055B_CuentaVocalesTeclado *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        int vocales = 0, contador = 0;
        char letra;

        // Nos metemos en un bucle cuya condición de parada nunca fallará (bucle infinito)
        // Hay que meter dentro del cuerpo del bucle alguna condición de parada
        while (true) {
            System.out.println("Por favor, introduce una letra: ");
            letra = sc.next().charAt(0);
            
            if (letra == '0') break;    // Utilizamos break para salir del bucle

            if (letra == 'a' || letra == 'e' || letra == 'i' ||  letra == 'o' || letra == 'u' || 
            letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') {
                vocales++;
            }
            contador++;
        }
        
        System.out.println("Se han introducido " + contador + " caracteres de los cuales " + vocales + " han sido vocales.");
		
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}