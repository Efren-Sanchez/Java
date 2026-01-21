/**
 * E102A_FuncionDiaSemana
 * 
 * @author: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Función Suma
 *
 * Programa que muestra el uso de una función saludo, que recibe un nombre 
 * introducido por teclado e imprime un saludo por pantalla.
 *  
 ******************************************************************************/

import java.util.Scanner;

public class E102A_FuncionDiaSemana {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E102A_FuncionDiaSemana *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, introduce el número del día se la semana: ");
        int x = sc.nextInt();
        
        System.out.println("El día " + x + " es: " + diaSemana(x));
        
        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }

    /**
     * Función diaSemana
     * 
     * Devuelve el nombre del día a partir de su número.
     * 
     * @author: Efrén Sánchez
     * 
     * @param d Int Número del día se la saman
     * @return Nombre del día
     * 
     */
    public static String diaSemana(int d) {
        return switch(d) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miécoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            case 7 -> "Domingo";
            default -> "Error: número fuera de rango (1-7)";
        };
    }
}