/*******************************************************************************
 * 
 * E006_OperadoresRelacionales
 * 
 * Autor: Efrén Sánchez
 * Fecha: 23/09/2025
 * 
 * Operadores relacionales (==, !=, <, <=, >, >=)
 * 
 * Programa con ejemplos de uso de cada uno de los operadores relacionales
 * Los operadores relacionales siempre devuelven un booleano, true o false.
 * 
 ******************************************************************************/
public class E006_OperadoresRelacionales {
    public static void main(String[] args) {
        
        System.out.println("\n\n\n* E006_OperadoresRelacionales *\n\n  --- Inicio del programa ---\n\n");

        boolean a, b;  // Solo puede almacenar true o false
        int x = 1, y = 2, z = 3;
        char c = 'a';

        a = 7 < 3;  // Menor
        System.out.println(a);

        a = z <= x; // Menor o igual
        System.out.println(a);
        
        a = z > 5;  // Mayor
        System.out.println(a);
        
        a = x >= y; // Mayor o igual
        System.out.println(a);

        a = x == y; // Igual
        System.out.println(a);

        a = x != z; // Distinto
        System.out.println(a);

        a = c == 'a';
        System.out.println(a);

        b = !a;
        System.out.println(b);

        // Nota: las expresiones anteriores son perfectamente válidas, aunque poco usadas.
        // Los operadores relacionales se usan principalmente en expresiones condicionales.

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}