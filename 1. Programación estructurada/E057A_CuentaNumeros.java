/*******************************************************************************
 * 
 * E057A_CuentaNumeros
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Cuenta las mayúsculas y minúsculas introducidas por teclado
 *
 * Programa que va pidiendo letras por teclado hasta que se introduce una 'z', y 
 * cuenta el número de mayúsculas y minúsculas que se han introducido.
 *  
 ******************************************************************************/

 import java.util.Scanner;

public class E057A_CuentaNumeros {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E057A_CuentaNumeros *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        int numeros = 0,    // Números introducidos
            otros = 0,      // Otro tipo de caracteres (números, letras no anglosajonas, símbolos...)
            contador = 0;   // Total de caracteres introducidos
        char letra;

        do {
            System.out.println("Por favor, introduce un número: ");
            letra = sc.next().charAt(0);

            if(letra >= 48 && letra <= 57)
                numeros++;
            else
                otros++;

            contador++;
            
        } while (letra != 'z');
        
        System.out.println("Se han introducido " + contador + " caracteres de los cuales " + numeros + " han sido números.");
        System.out.println("Se han introducido " + otros + " símbolos distintos de números.");
		
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}