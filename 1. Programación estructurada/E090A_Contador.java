/*******************************************************************************
 * 
 * E090A_Contador
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Contador con E en lugar de 3
 *
 * Programa que muestra por pantalla un contador de 0-0-0-0-0 a 9-9-9-9-9. pero
 * cambiando los 3 por E.
 * 
 ******************************************************************************/

public class E090A_Contador {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E090A_Contador *\n\n  --- Inicio del programa ---\n\n");
		
        int n1, n2, n3, n4, n5;
        
        for (n1 = 0; n1 < 10; n1++)
            for (n2 = 0; n2 < 10; n2++)
                for (n3 = 0; n3 < 10; n3++)
                    for (n4 = 0; n4 < 10; n4++)
                        for (n5 = 0; n5 < 10; n5++) {
                            if (n1 == 3) System.out.print("E-");
                            else System.out.print(n1 + "-");
                            if (n2 == 3) System.out.print("E-");
                            else System.out.print(n2 + "-");
                            if (n3 == 3) System.out.print("E-");
                            else System.out.print(n3 + "-");
                            if (n4 == 3) System.out.print("E-");
                            else System.out.print(n4 + "-");
                            if (n5 == 3) System.out.print("E\n");
                            else System.out.print(n5 + "\n");
                        }
                        
		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}