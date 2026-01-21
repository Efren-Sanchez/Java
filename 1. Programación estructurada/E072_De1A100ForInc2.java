/*******************************************************************************
 * 
 * E072_De1A100ForInc2
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * De 1 a 100 de 2 en 2
 *
 * Programa que muestra por pantalla los números de 1 a 100 de 2 en dos.
 * 
 ******************************************************************************/

public class E072_De1A100ForInc2 {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E072_De1A100ForInc2 *\n\n  --- Inicio del programa ---\n\n");

        // OJO: la variable i que se declara en el for se destruye cuando el bucle acaba
        for (int i = 1; i <= 100; i += 2)
            System.out.println(i);
        
        // En este punto no podemos usar la i ya que no existe

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}