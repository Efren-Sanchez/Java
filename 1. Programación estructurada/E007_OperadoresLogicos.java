/*******************************************************************************
 * 
 * E007_OperadoresLogicos
 * 
 * Autor: Efrén Sánchez
 * Fecha: 23/09/2025
 * 
 * Operadores lógicos (&&, ||, !)
 * 
 * Programa con ejemplos de uso de operadores lógicos (and, or y not).
 * 
 ******************************************************************************/
public class E007_OperadoresLogicos {
    public static void main(String[] args) {

        System.out.println("\n\n\n* E007_OperadoresLogicos *\n\n  --- Inicio del programa ---\n\n");

        boolean a;
        int x = 1, y = 2, z = 3;

        // And: todas las condiciones deben ser ciertas para que el resultado sea cierto
        a = 7 < x && z <= 1;        
        System.out.println(a);

        // Or: al menos una condición debe ser cierta para que el resultado sea cierto
        a = 4 >= y || z <= x;      
        System.out.println(a);
        
        // Not: negación, convierte true en false y vice versa
        a = !(x < y && z <= x);     
        System.out.println(a);
        
        a = (1 == y || !(z <= x));  // Not
        System.out.println(a);

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}