/**
 * E104A_NumeroPrimo
 * 
 * @author: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Número primo
 *
 * Programa que muestra por pantalla los números primos hasta el 100.
 *  
 */

public class E104A_NumeroPrimo {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E104A_NumeroPrimo *\n\n  --- Inicio del programa ---\n\n");

        // Imprime los número primos hasta el 100
        for (int num = 2; num <= 100; num++) {
            if(esPrimo(num)) System.out.println("El numero " + num + " es PRIMO!! :D");
            else             System.out.println("El numero " + num + " NO es primo :(");
        }

        for (int num = 2; num <= 100; num++) {
            if(esPrimo(num)) System.out.print(num + ", ");
        }

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }

    /**
     * Función esPrimo
     * 
     * Indica si un número es primo o no
     * 
     * @author: Efrén Sánchez
     * 
     * @parm n Int Número candidato
     * @return Bool True si es primo, false si no lo es
     */
    public static boolean esPrimo(int n) {
        boolean primo = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                primo = false;
                break;
            }
        }
        return primo;
    }
}