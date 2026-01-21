/*******************************************************************************
 * 
 * E062_GirarMatriz
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Girar matriz
 *
 * Programa que pide al usuario una opción, 'd' para girar a la derecha e 'i' 
 * para girar a la izquierda. A continuación, mueve los caracteres de la matriz
 * formada por las cariables C1, C2, C3 y C4 en el sentido indicado. Pulsar 's'
 * para salir.
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E062_GirarMatriz {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E062_GirarMatriz *\n\n  --- Inicio del programa ---\n\n");

        Scanner sc = new Scanner(System.in);
		char C1 = 'A', 
			 C2 = 'B', 
			 C3 = 'C', 
			 C4 = 'D', 
			 aux, 
			 opcion = ' ';
		
		
		System.out.println("Estado actual de la tabla:");
		System.out.println(C1 + "  " + C2);
		System.out.println(C3 + "  " + C4);
				
		while (opcion != 's')
		{
            System.out.println("Introduce la operación a realizar:");
            System.out.println("d) Girar a la derecha (sentido horario)");
            System.out.println("i) Girar a la izquierda (sentido antihorario)");
            System.out.println("s) Salir");
            opcion = sc.next().charAt(0);
            
			switch (opcion)
			{
				case 'd':
					aux = C2;
					C2 = C1;
					C1 = C3;
					C3 = C4;
					C4 = aux;
					break;
				case 'i':
					aux = C1;
					C1 = C2;
					C2 = C4;
					C4 = C3;
					C3 = aux;
					break;	
                case 's':
                    break;
                default:
                    System.out.println("¡Opción incorrecta!");

			}
			
			System.out.println("\n\nEstado actual de la tabla:");
			System.out.println(C1 + "  " + C2);
			System.out.println(C3 + "  " + C4);	
		}

        sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}