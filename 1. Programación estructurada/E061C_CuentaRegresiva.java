/*******************************************************************************
 * 
 * E061C_CuentaRegresiva
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Cuenta regresiva
 *
 * Programa que hace una cuenta regresiva de 10 a 0 borrando caracteres para una
 * impresión cuidada.
 * 
 * Versión que borra caracteres con \b
 * 
 ******************************************************************************/

import java.lang.Thread;    // Para usar sleep

public class E061C_CuentaRegresiva {
    public static void main(String[] args) throws InterruptedException {

		System.out.println("\n\n\n* E061C_CuentaRegresiva *\n\n  --- Inicio del programa ---\n\n");

        for (int i = 10; i >= 0; i--) {
            String texto = "Cuenta regresiva: " + i + "   ";
            System.out.print(texto); // Imprime el texto
            Thread.sleep(1000); // Pausa de 1 segundo

            // Borra los caracteres impresos usando \b
            for (int j = 0; j < texto.length(); j++) {
                System.out.print("\b");
            }
        }
        // Imprime el mensaje final
        System.out.print("¡Lanzamiento!               ");

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}