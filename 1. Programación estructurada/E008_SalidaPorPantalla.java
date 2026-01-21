/*******************************************************************************
 * 
 * E008_SalidaPorPantalla
 * 
 * Autor: Efrén Sánchez
 * Fecha: 23/09/2025
 * 
 * Salida por pantalla con print, println y printf
 * 
 ******************************************************************************/
public class E008_SalidaPorPantalla {
    public static void main(String[] args) {
        
        System.out.println("\n\n\n* E008_SalidaPorPantalla *\n\n  --- Inicio del programa ---\n\n");

        int a = 1, b = 2, c = 3, d = 27;
        double e = 3, f = 4.0;

        // Con print imprimimos en pantalla a continuación de donde está el cursor
        // No introduce líneas nuevas, ni delante ni detrás
        System.out.print(a);

        System.out.print("Esto es un texto");

        System.out.print("Esto es texto " + a + " el texto contnua después del valor de la variable");

        String frase = "En un lugar de la Mancha" + " de cuyo nombre no quiero acordarme...";
        System.out.print(frase); 

        System.out.print(frase + a); 

        System.out.print(a + b);         // OJO: aquí suma primero los enteros y muestra el valor
        System.out.print(frase + a + b); // Aqui no hace ninguna suma, concatena la frase y por detrás los valores de las variables

        // Podemos introducir manualmente un salto de línea con el carácter '\n'
        frase = "\nEn un lugar de la Mancha" + "\nde cuyo nombre no quiero acordarme...\n";
        System.out.print(frase); 
        
        // Con println imprimimos en pantalla y mete una nueva línea al final
        System.out.print("Primer texto");
        System.out.println("Segundo texto");
        System.out.println("Tercer texto");

        // Con printf imprimimos formateando las variables
        System.out.printf("\nEl valor de la variable 'a' es %d, y el valor de la variable 'b' es %05d. 'c' vale %d, y 'd' vale %X", a, b, c, d);
        System.out.printf("\nEl valor de la variable 'e' es %f, y el valor de la variable 'f' es %2.3f.", e, f);

        /* 
        Nota: printf
        List of conversions
        Character	Conversion	Description
        %	    Percent	Displays a literal "%" character in the output.
        n	    Line break	Displays a line break in the output.
        b or B	Boolean	Displays the boolean value of an argument as "true" or "false". If "B" is used then it displays "TRUE" or "FALSE" instead.
        c or C	Unicode character	Displays a unicode character representation of the argument. For whole numbers, this is the unicode character that corresponds to the number. If "C" is used then the character will be converted to uppercase where possible.
        s or S	String	Displays the default string representation of the argument. If "S" is used then the string will be converted to uppercase where possible.
        d	    Decimal integer	Represents a whole number as a decimal integer.
        h or H	Unsigned hexadecimal integer	Represents an argument's binary data as an unsigned hexadecimal integer. If "H" is used then digits A to F are shown in uppercase.
                Note:   For any data other than positive integers this does not represent its real value.
        o	    Octal integer	Represents a whole number as an octal integer. The "#" flag will prefix the number with "0".
        x or X	Hexadecimal integer	Represents a whole number as a hexadecimal integer. The "#" flag will prefix the number with "0x". If "X" is used then digits A to F and the letter X are shown in uppercase.
        e or E	Scientific notation	Represents a floating point number in scientific notation. If "E" is used then the letter "E" of the representation will be uppercase. The "#" flag will force a decimal point even if there are no decimal digits.
        f	    Floating point number	Represents a floating point number. The "#" flag will force a decimal point even if there are no decimal digits.
        g or G	General number	Displays the shortest representation between f and eor E for a floating point number.
        a or A	Hexadecimal floating point number	Display a floating point number's internal representation with hexadecimal digits.
        t or T	Time or date	Displays a formatted date or time. The t or T must be followed by one more character indicating how the date or time should be formatted. If "T" is used then text parts of a date or time such as "JANUARY" will be uppercase.
            The following characters can be used for date and time formatting:
            H - 24-hour format of an hour (00 to 23)
            I - 12-hour format of an hour (01 to 12)
            k - 24-hour format of an hour (0 to 23)
            l (lowercase 'L') - 12-hour format of an hour (1 to 12)
            M - Minutes with leading zeros (00 to 59)
            S - Seconds with leading zeros (00 to 59) (The value 60 may occur for leap seconds)
            L - Milliseconds with leading zeroes (000 to 999)
            N - Nanoseconds with leading zeroes (000000000 to 999999999)
            p - "am", "pm", "AM" or "PM" to indicate morning or afternoon
            z - Difference to Greenwich time (Example: -0800)
            Z - Timezone abbreviations (Examples: EST, MDT)
            s - The seconds since the Unix Epoch (January 1 1970 00:00:00 GMT)
            Q - The milliseconds since the Unix Epoch (January 1 1970 00:00:00 GMT)
            B - A full textual representation of a month (January through December)
            b or h - A short textual representation of a month (three letters)
            A - A full textual representation of a day (Example: Monday)
            a - A short textual representation of a day (Example: Mon)
            C - The first two digits of the year (For 1970, "19" would be shown)
            Y - A four digit representation of a year
            y - A two digit representation of a year
            j - The day of the year with leading zeroes (001 to 366)
            m - A numeric representation of a month (01 to 12)
            d - The day of the month (01 to 31)
            e - The day of the month without leading zeros (1 to 31)
            R - The time in 24-hour format (Example: 21:30)
            T - The time in 24-hour format with seconds (Example: 21:30:02)
            r - The time in 12-hour format with seconds (Example: 09:30:02 PM) ("AM" and "PM" are always uppercase)
            D - Date representation as month/day/year (Example: 12/17/23)
            F - Date representation as year-month-day (Example: 2023-12-17)
            c - Full date and time (Example: Thu Mar 28 10:51:00 EDT 2024)
        */

        System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}