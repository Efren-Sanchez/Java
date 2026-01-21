/*******************************************************************************
 * 
 * E055A_CuentaVocalesTeclado
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Cuenta las vocales introducidas por teclado
 *
 * Programa que va pidiendo letras por teclado hasta que se introduce un 0, y 
 * cuenta el número de vocales que se han introducido.
 * 
 * Versión con 1 petición de datos al usuariodentro del bucle.
 * 
 ******************************************************************************/

 import java.util.Scanner;

public class E055A_CuentaVocalesTeclado {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E055A_CuentaVocalesTeclado *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        int vocales = 0, contador = 0;
        char letra;

        letra = 'a';    // Inicializamos letra para que cumpla la condición del bucle entrando antes de pedir el carácter

        while (letra != '0') {
            // Solo hacemos la petición de datos una única vez, dentro del bucle
            System.out.println("Por favor, introduce una letra: ");
            letra = sc.next().charAt(0);
            
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