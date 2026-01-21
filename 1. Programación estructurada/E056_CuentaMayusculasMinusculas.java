/*******************************************************************************
 * 
 * E056_CuentaMayusculasMinusculas
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Cuenta las mayúsculas y minúsculas introducidas por teclado
 *
 * Programa que va pidiendo letras por teclado hasta que se introduce un 0, y 
 * cuenta el número de mayúsculas y minúsculas que se han introducido.
 *  
 ******************************************************************************/

 import java.util.Scanner;

public class E056_CuentaMayusculasMinusculas {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E056_CuentaMayusculasMinusculas *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        int mayus = 0,  // Mayúsculas
            minus = 0,  // Minúsculas
            otros = 0,  // Otro tipo de caracteres (números, letras no anglosajonas, símbolos...)
            contador = 0;   // Total de caracteres introducidos
        char letra;

        do {
            System.out.println("Por favor, introduce una letra: ");
            letra = sc.next().charAt(0);

            if(letra >= 'a' && letra <= 'z')
                minus++;
            else if (letra >= 'A' && letra <= 'Z')
                mayus++;
            else
                otros++;

            contador++;
            
        } while (letra != '0');
        
        System.out.println("Se han introducido " + contador + " caracteres de los cuales " + mayus + " han sido mayúsculas y " + minus + "han sido minúsculas.");
        System.out.println("Se han introducido " + otros + " símbolos distintos de las letras.");
		
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}