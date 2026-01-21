/**
 * E105A_Palindromo
 * 
 * @author: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Palíndromo
 *
 * Programa que pide un texto por teclado y determina si es un palíndromo o no.
 * 
 * Una palabra o texto es palíndromo si se lee igual de derecha a izquierda que
 * de izquierda a derecha.
 * 
 * Ej: dabale arroz a la zorra el abad
 * 
 * OJO: Hay que tener cuidado con los espacios, mayúsculas y minúsculas, acentos
 * y otros caracteres que debemos ignorar.
 *  
 */
import java.util.Scanner;

public class E105_Palindromo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E105_Palindromo *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una palabra para averiguar si es un palindromo: ");
        String palabra = sc.nextLine();
        
        // Eliminamos los espacios en blanco
        String palabraSinEspacios = palabra.replaceAll("\\s","");
        
        //System.out.println("Palabra: " + palabra);
        //System.out.println("Palabra sin espacios: " + palabraSinEspacios);

        if (comprobarPalindromo(palabraSinEspacios))
            System.out.println("La palabra es un palindromo");
        else
            System.out.println("La palabra NO es un palindromo");

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }

    /**
     * Función comprobarPalindromo
     * 
     * Comprueba si una cadena de texto dada es un palíndromo (que se lee
     * igual de delante hacia atrás y vice versa).
     * 
     * @author: Efrén Sánchez
     * 
     * @parm p String Texto para comprobar si es un palíndromo
     * @return Bool True si es palíndromo, false si no lo es
     * 
     */
    public static boolean comprobarPalindromo(String p) {
        for (int i = 0; i < p.length()/2; i++)
            if (p.charAt(i) != p.charAt(p.length() - i - 1))
                return false;

        return true;
    }
}