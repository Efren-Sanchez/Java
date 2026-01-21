/*******************************************************************************
 * 
 * E060_Password
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Comprobación de password
 *
 * Programa que comprueba si una contraseña introducida por teclado coincide con
 * otra establecida en el código.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E060_Password {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E060_Password *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
        String  pass,                   // Password introducida por el usuario
                pass_ok = "Java123";    // Passsword correcta
        boolean iguales;

        do {
            System.out.println("Introduce la contraseña: ");
            pass = sc.nextLine();

            iguales = (pass.equals(pass_ok));   // Necesario para comparar cadenas de texto como queremos en este caso

            if (iguales)
                System.out.println("¡Contraseña correcta!");
            else
                System.out.println("¡Contraseña incorrecta!");
        } while(!iguales);

        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}