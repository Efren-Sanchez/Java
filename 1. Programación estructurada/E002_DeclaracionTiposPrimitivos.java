/*******************************************************************************
 * 
 * E002_DeclaracionTiposPrimitivos
 * 
 * Autor: Efrén Sánchez
 * Fecha: 19/09/2025
 * 
 * Declaración de tipos primitivos en Java
 * 
 * Programa en el que se declaran todos los tipos primitivos disponibles.
 * 
 * - Los nombres de variables deben empezar por letra minúscula (por convención), por _ o $
 * - Son sensibles a mayúsculas y minúsculas (case-sensitive): abc, Abc, aBc, ABC son variables distintas
 * 
 ******************************************************************************/
public class E002_DeclaracionTiposPrimitivos {
    public static void main(String[] args) {
        
        System.out.println("\n\n\n* E002_DeclaracionTiposPrimitivos *\n\n  --- Inicio del programa ---\n\n");

        // Todos los tipos primitivos empiezan por minúscula
        
        // Enteros: números que NO tienen parte decimal
        // --------------------------------------------
        int i;
        int x, y, z;
        int alfa = 1, beta = -2;
        int gamma = 400,
            delta = -15;

        // Mostramos los valores por pantalla
        System.out.println(alfa);
        System.out.println(beta);
        System.out.println(gamma);
        System.out.println(delta);

        byte b;     // Valores entre -128 y 127, precisión de 1 byte
        short s;    // Valores entre -2^15 y (2^15)-1, precisión de 2 bytes
        long l;     // Precisión de 8 bytes

        // Por defecto, los números enteros son int, no long
        long enteroLargo1 = 5l;     // Ojo con la notación
        long enteroLargo2 = 5L;     // Preferible en mayúsculas para evitar errores de lectura

        System.out.println(enteroLargo1);
        System.out.println(enteroLargo2);

        // Reales: números que tienen parte decimal
        // ----------------------------------------
        double  d1 = 1,         // Precisión de 8 bytes
                d2 = 0.7366,
                d3 = -4.37,
                d4 = .37,       // Equivale a 0.37
                d5 = -.99,      // Equivale a -0.99
                d6 = 3.2e14,
                d7 = 3.2E14,
                d8 = -0.87e4,
                d9 = 4.23e-8;

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
        System.out.println(d6);
        System.out.println(d7);
        System.out.println(d8);
        System.out.println(d9);

        // Por defecto, los número reales son de tipo double, no float
        float   f1 = 4.78f,    // Ojo con la notación
                f2 = -3.56F;

        System.out.println(f1);
        System.out.println(f2);

        // Caracteres: representan un único símbolo (letras, números, signos de puntuación...)
        // -----------------------------------------------------------------------------------
        // Siempre van con comillas simples
        char    c1 = 'a',
                c2 = '\t',      // Carácter de tabulador (carácter no visible)
                c3 = 37;        // Estamos asignando su código ASCII
        
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        // Cadenas de caracteres: permiten almacenar textos de longitud variable
        // ---------------------------------------------------------------------
        // String no es un tipo primitivo de Java, sino una clase de la API. Empieza por mayúscula
        // Siempre van con comillas dobles
        String  S1 = "Hola mundo",
                S2 = "",        // Cadena vacia
                S3 = "\nSoy una cadena\nen varias líneas.";

        System.out.println(S1);
        System.out.println(S2);
        System.out.println(S3);

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}