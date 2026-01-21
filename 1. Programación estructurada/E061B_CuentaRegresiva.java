/*******************************************************************************
 * 
 * E061B_CuentaRegresiva
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Cuenta regresiva
 *
 * Programa que hace una cuenta regresiva de 10 a 0 borrando caracteres para una
 * impresión cuidada.
 * 
 * Versión que borra la línea con \r
 * 
 ******************************************************************************/

import java.lang.Thread;    // Para usar sleep

public class E061B_CuentaRegresiva {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E061B_CuentaRegresiva *\n\n  --- Inicio del programa ---\n\n");

        try {
            for (int i = 10; i >= 0; i--) {
                // Imprime el número y vuelve al inicio de la línea
                System.out.print("\rCuenta regresiva: " + i + "  ");
                // Pausa de 1 segundo
                Thread.sleep(1000);
            }
            
            // Limpia la línea al final de la cuenta regresiva
            System.out.print("\r¡Lanzamiento!      ");
        } catch (Exception e) {
            System.err.println(e);
        }

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}