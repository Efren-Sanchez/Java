/*******************************************************************************
 * 
 * E005_Castings
 * 
 * Autor: Efrén Sánchez
 * Fecha: 23/09/2025
 * 
 * Conversiones de tipo implicitas y explicitas
 * - Implicitas: aquellas que hace Java automáticamente.
 * - Explicitas: aquellas que el programador ordena mediante código.
 * 
 * 
 * En Java, existen dos tipos principales de conversiones de tipo (casting):
 * Casting implícito (Widening Casting) (automática) – convertir un tipo más 
 * pequeño en un tipo de mayor tamaño.
 * byte -> short -> char -> int -> long -> float -> double
 * 
 * Casting Explícito (Narrowing Casting) (manual) – convertir un tipo más 
 * grande en un tipo de menor tamaño.
 * double -> float -> long -> int -> char -> short -> byte
 * 
 ******************************************************************************/
public class E005_Castings {
    public static void main(String[] args) {
        
        System.out.println("\n\n\n* E005_Castings *\n\n  --- Inicio del programa ---\n\n");

        // Conversiones de tipo implicitas entre enteros
        // ---------------------------------------------
        byte    b1 = 1;
        short   s1 = 1;
        int     i1 = 1;
        long    l1 = 1;

        // Operaciones incorrectas 
        // Una variable de menor precisión no puede contener el valor de otra de mayor precisión sin perder digitos. Java no lo permite.
        // b1 = s1;
        // b1 = i1;
        // b1 = l1;
        // s1 = i1;
        // s1 = l1;
        // i1 = l1;

        // Operaciones correctas
        // Una variable de mayor precisión puede contener el valor de otra de menor precisión.
        l1 = i1;
        l1 = s1;
        l1 = b1;
        i1 = s1;
        i1 = b1;
        s1 = b1;

        // Conversiones de tipo implicitas entre reales
        // --------------------------------------------
        float f1 = 1;   // En esta declaración Java ya está convirtiendo un entero en float
        double d1 = 1;  // En esta declaración Java ya está convirtiendo un entero en double

        // Operaciones incorrectas
        //f1 = d1;
        //f1 = 0.1;

        // Operaciones correctas
        d1 = f1;
        f1 = 1F;

        // Conversiones de tipo implicitas entre enteros y reales
        // ----------------------------------
        // Incorrectas
        // i1 = d1;
        // i1 = f1;
        // l1 = f1;
        // l1 = d1; // Pese a tener la misma precisión, no se puede convertir de double a long

        // Correctas
        d1 = l1;
        d1 = i1;
        d1 = s1;
        d1 = b1;
        f1 = l1;
        f1 = i1;
        f1 = s1;
        f1 = b1;

        // Conversiones de tipo implicitas entre enteros y caracteres
        // --------------------------------------
        char c1 = 'a';
        
        // Incorrectas
        // c1 = d1;
        // c1 = f1;
        // c1 = l1;
        // c1 = i1;
        // c1 = s1;
        // c1 = b1;
        // s1 = c1;
        // b1 = c1;

        // Correctas
        l1 = c1;
        i1 = c1;
        f1 = c1;
        d1 = c1;
        
        // Operaciones con booleanos
        // -------------------------
        boolean bool = true;

        // Incorrectas
        // bool = l1;
        // bool = i1;
        // bool = s1;
        // bool = b1;
        // bool = c1;
        // l1 = bool;
        // i1 = bool;
        // s1 = bool;
        // b1 = bool;
        // c1 = bool;


        // Conversiones de tipo explícitas
        // -------------------------------
        // Al convertir de un tipo más grande a uno más pequeño, puede llevar a la pérdida de la parte decimal o información valiosa
        // No se puede realizar casting entre todos los tipos de datos; solo se puede hacer entre tipos que guardan una relación, como los tipos numéricos o entre tipos con una relación de herencia en el caso de objetos.
        f1 = (float) d1;
        l1 = (long) d1;
        l1 = (long) f1;
        i1 = (int) d1;
        i1 = (int) f1;
        i1 = (int) l1;
        s1 = (short) d1;
        s1 = (short) f1;
        s1 = (short) l1;
        s1 = (short) i1;
        b1 = (byte) d1;
        b1 = (byte) f1;
        b1 = (byte) l1;
        b1 = (byte) i1;
        b1 = (byte) s1;
        c1 = (char) d1;
        c1 = (char) f1;
        c1 = (char) l1;
        c1 = (char) i1;
        c1 = (char) s1;
        c1 = (char) b1;
        
        // Incorrectas
        // i1 = (int) bool;
        // d1 = (double) bool;
        // s1 = (char) c1;
        // b1 = (char) c1;
        // d1 = (double) bool;
        // l1 = (long) bool;
        // i1 = (int) bool;
        // s1 = (short) bool;
        // b1 = (byte) bool;
        // c1 = (char) bool;

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}