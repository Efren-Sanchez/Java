/*******************************************************************************
 * 
 * E004_MathConstantes
 * 
 * Autor: Efrén Sánchez
 * Fecha: 22/09/2025
 * 
 * Constantes y librería Math
 * 
 * Programa con definición de constantes (final) y uso de métodos de la librería
 * matemática.
 * 
 * - Math es una librería proporcianada con la API de Java. Está disponible para
 * que la usemos cuando la necesitemos. Contiene muchas funciones matemáticas
 * necesarias para hacer calculos avanzados.
 * 
 ******************************************************************************/
public class E004_MathConstantes {
    public static void main(String[] args) {
        
        System.out.println("\n\n\n* E004_MathConstantes *\n\n  --- Inicio del programa ---\n\n");
        

        int a = 1, b = 2, c = 3;

        // Las contantes se declaran con la palabra clave 'final'
        // Por convención, siempre van en mayúsculas, separando las palabras (si hay más de una) con guion bajo (snake-case).
        final int D = 4;            // Constante
        int resultadoInt = 10;

        double e = 3;
        final double F = 4.0;       // Constante
        double resultadoDouble;

        // Uso de la librería Math
        // -----------------------
        // Math es una de las pocas librerías que podemos usar sin tener que importarla
        
        resultadoDouble = Math.pow(2, 4);   // Potencia -> 2^4
        System.out.println(resultadoDouble);

        resultadoDouble = Math.pow(a, 4);  

        resultadoDouble = Math.pow(2, b);  
        System.out.println(resultadoDouble);

        resultadoDouble = Math.pow(a, b);  
        System.out.println(resultadoDouble);

        resultadoDouble = Math.pow(D, F);  
        System.out.println(resultadoDouble);

        resultadoDouble = Math.sqrt(9);       // Raiz cuadrada de 9
        System.out.println(resultadoDouble);

        resultadoDouble = Math.sin(0.7);      // Seno de 0.7
        System.out.println(resultadoDouble);

        resultadoDouble = Math.abs(-1.7);       // Valor absoluto
        System.out.println(resultadoDouble);

        resultadoDouble = Math.PI * 2;          // El número Pi está definido en Marh como constante
        System.out.println(resultadoDouble);

        // Operadores aritméticas con asignación
        // -------------------------------------
        c += 3; // Equivalente a c = c + 3
        System.out.println(c);

        c -= 2; // Equivalente a c = c - 2
        System.out.println(c);
        
        c *= 7; // Equivalente a c = c * 7
        System.out.println(c);
        
        c /= 4; // Equivalente a c = c / 4
        System.out.println(c);
        
        c %= 2; // Equivalente a c = c % 2
        System.out.println(c);


        // OJO, cuidado con expresiones de este tipo, pueden producir resultados inesperados
        resultadoInt *= D + c + e;      // El resultado es 80
        System.out.println(resultadoInt);

        resultadoInt *= (D + c + e);    // El resultado es 640
        System.out.println(resultadoInt);

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}