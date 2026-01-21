/*******************************************************************************
 * 
 * E003_OperadoresAritmeticos
 * 
 * Autor: Efrén Sánchez
 * Fecha: 22/09/2025
 * 
 * Operadores aritméticos
 * 
 * Programa con ejemplos de uso de todos los operadores aritméticos.
 * 
 ******************************************************************************/
public class E003_OperadoresAritmeticos {
    public static void main(String[] args) {

        System.out.println("\n\n\n* E003_OperadoresAritmeticos *\n\n  --- Inicio del programa ---\n\n");

        int a = 1, b = 2, c = 3, d = 4;
        int resultadoInt;
        double e = 3, f = 4.0;
        double resultadoDouble;

        // Suma
        resultadoInt = a + 5;
        System.out.println(resultadoInt);

        resultadoInt = 3 + a;
        System.out.println(resultadoInt);

        resultadoInt = a + 5 + 9;
        System.out.println(resultadoInt);

        resultadoInt = a + b;
        System.out.println(resultadoInt);

        resultadoInt = a + b + c;
        System.out.println(resultadoInt);

        // Resta
        resultadoInt = a - 5;
        System.out.println(resultadoInt);

        // Multiplicación
        resultadoInt = a * 5;
        System.out.println(resultadoInt);

        // División: si tanto el dividendo como el divisor son enteros, el resultado no tendrá decimales
        // Esta operación entre enteros devuelve el cociente de la operación
        // Recuerda: D = (d * c) + r
        resultadoInt = a / 5;
        System.out.println(resultadoInt);

        resultadoInt = d / b;
        System.out.println(resultadoInt);

        // Resto de la división enetera
        resultadoInt = c % b;
        System.out.println(resultadoInt);

        // Incremento
        resultadoInt = a++; // Equivalente a (a = a + 1) y (a += 1)
        System.out.println(resultadoInt);

        // Decremento
        resultadoInt = a--;
        System.out.println(resultadoInt);

        // División real: no tiene resto, cociente con tantos decimales como sea posible
        resultadoDouble = d / c;
        System.out.println(resultadoDouble);

        resultadoDouble = f / c;
        System.out.println(resultadoDouble);

        resultadoDouble = d / e;
        System.out.println(resultadoDouble);

        resultadoDouble = f / e;
        System.out.println(resultadoDouble);

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}