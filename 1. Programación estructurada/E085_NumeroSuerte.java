/*******************************************************************************
 * 
 * E085_NumeroSuerte
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Número de la suerte
 * 
 * Se desea conocer el lucky number (número de la suerte) de cualquier persona. 
 * El número de la suerte se consigue reduciendo la fecha de nacimiento a un 
 * número de un solo dígito. Por ejemplo, la fecha de nacimiento de Emma es la 
 * siguiente: 16/08/1973: 16+8+1973=1997, 1+9+9+7=26, 2+6=8.
 * El número de la suerte de Emma será el 8. Realiza un programa que calcule el 
 * lucky number de cualquier persona. 
 * (No uséis una solución hecha a mano, usad un bucle mientras hayan dígitos) .
 * El usuario introduce la fecha en el formato dd/mm/aaaaaaaaaa... 
 * Los años validos van desde 0 hasta el año mil millones DC.
 * 
 * Nota del programador:
 * ---------------------
 * Conversión de char a int:
 * Tenemos distintas formas de pasar de char a int (sacar el valor númerico de 
 * un char que representa un número):
 * 
 * Juagndo con el código ASCII
 * - caracter.charAt(i) - '0'
 * - caracter.charAt(i) - 48
 * 
 * Método de la clase Character
 * - Character.getNumericValue(caracter.charAt(i)
 * 
 ******************************************************************************/

import java.util.Scanner;

public class E085_NumeroSuerte {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E085_NumeroSuerte *\n\n  --- Inicio del programa ---\n\n");
		
		Scanner sc=new Scanner(System.in);
		String fecha;
		int numero, dia, mes, año = 0, aux = 0;
		
		// Introducción de datos
		System.out.println("Introduce la fecha de nacimiento en formato dd/mm/aaaaaa... :");		
		fecha = sc.nextLine();	
		
		// Comprobación de errores
		if (fecha.charAt(2) != '/' || fecha.charAt(5) != '/')
		{
			System.out.println("Error al introducir los datos!!");
            sc.close();
			return;
		}	
		
		// Asignación de los carácteres a variables int
		dia = ((fecha.charAt(0) - '0') * 10) + (fecha.charAt(1) - '0');
		mes = (Character.getNumericValue(fecha.charAt(3)) * 10) + Character.getNumericValue(fecha.charAt(4));
		
		
		for (int i = 6; i < fecha.length(); i++)
			if (i == 6) año = fecha.charAt(i) - 48;
			else		año = (año * 10) + (fecha.charAt(i) - 48);
		
		System.out.println("Día: " + dia);
		System.out.println("Mes: " + mes);
		System.out.println("Año: " + año);
		
		// Empiezo a calcular el Lucky Number
		numero = dia + mes + año;
		System.out.println("Número: " + numero);
		
		// Mientras el número tenga más de un dígito
		while (numero > 9) {
			aux = 0;
			
			// Sumamos todos los dígitos
			while (numero > 9) {
				aux += numero % 10;
				numero /= 10;
				//System.out.println("aux: " + aux);
				//System.out.println("Número: " + numero);
			}
			aux += numero;
			
			numero = aux;
			//System.out.println("Número: " + numero);
		}
		
		System.out.println("Número de la suerte: " + numero);

		sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}