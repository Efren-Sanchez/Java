/*******************************************************************************
 * 
 * E090_Contador
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

public class E090_Contador {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E090_Contador *\n\n  --- Inicio del programa ---\n\n");
		
        int n1, n2, n3, n4, n5;
        char c1, c2, c3, c4, c5;

        for (n1 = 0; n1 < 10; n1++)
            for (n2 = 0; n2 < 10; n2++)
                for (n3 = 0; n3 < 10; n3++)
                    for (n4 = 0; n4 < 10; n4++)
                        for (n5 = 0; n5 < 10; n5++) {
                            if (n1 == 3) c1 = 'E';
                            else c1 = (char) (n1+48);

                            if (n2 == 3) c2 = 'E';
                            else c2 = (char) (n2+48);

                            if (n3 == 3) c3 = 'E';
                            else c3 = (char) (n3+48);

                            if (n4 == 3) c4 = 'E';
                            else c4 = (char) (n4+48);

                            if (n5 == 3) c5 = 'E';
                            else c5 = (char) (n5+48);

                            System.out.println(c1 + "-" + c2 + "-" + c3 + "-" + c4 + "-" + c5);
                        }

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}