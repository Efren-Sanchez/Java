/*******************************************************************************
 * 
 * E055C_CuentaVocalesTeclado
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Cuenta las vocales introducidas por teclado
 *
 * Programa que va pidiendo letras por teclado hasta que se introduce un 0, y 
 * cuenta el número de vocales que se han introducido.
 * 
 * Versión con bucle do while
 * 
 ******************************************************************************/

 import java.util.Scanner;

public class E055C_CuentaVocalesTeclado {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E055C_CuentaVocalesTeclado *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        int vocales = 0, contador = 0;
        char letra;

        do {
            System.out.println("Por favor, introduce una letra: ");
            letra = sc.next().charAt(0);
            
            if (letra == 'a' || letra == 'e' || letra == 'i' ||  letra == 'o' || letra == 'u' || 
            letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') {
                vocales++;
            }
            contador++;
        } while (letra != '0');
        
        System.out.println("Se han introducido " + contador + " caracteres de los cuales " + vocales + " han sido vocales.");
		
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}