/**
 * E107_ConversionTemperaturas
 * 
 * @author Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Cenversión de temperaturas
 *
 * Programa que convierte temperaturas entre ºCelsius, Fahrenheit y Kelvin.
 * 
 * Requisitos:
 * - El programa debe estar estructurado con dos funciones que reciban una 
 *   temperatura y devuelvan su conversión de ºC a ºF y de ºF a ºC. 
 * - El programa debe mostrar un menú con las opciones de conversión, y para 
 *   terminar la ejecución el usuario debe introducir una ese (s).
 * - Opcional: puedes añadir conversiones adicionales con º Kelvin.
 *  
 */

import java.util.Scanner;

public class E107_ConversionTemperaturas {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E107_ConversionTemperaturas *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		char opcion;
		double temperatura = 0, conversion;

		do
		{
			// Menú de opciones
			System.out.println("\nPor favor, elige la opción que desees: ");
			System.out.println("\n1) De ºC a ºF");
			System.out.println("2) De ºC a ºK");
			System.out.println("3) De ºF a ºC");
			System.out.println("4) De ºF a ºK");
			System.out.println("5) De ºK a ºC");
			System.out.println("6) De ºK a ºF");
			System.out.println("S) Salir");
			System.out.println("..............");
			
			opcion = sc.next().charAt(0);
			
			if (opcion != 'S' && opcion != 's')
			{
				System.out.print("\nIntroduce el valor de la temperatura: ");
				temperatura = sc.nextDouble();
			}
			
			System.out.println("\n");
			
			// En función de la opción elegida se llama a la función correspondiente
			switch(opcion)
			{
				case '1':
					conversion = deGradosCAF(temperatura);
					System.out.println(temperatura + "ºC = " + conversion + "ºF");
					break;
				case '2':
					conversion = deGradosCAK(temperatura);
					System.out.println(temperatura + "ºC = " + conversion + "ºK");
					break;
				case '3':
					conversion = deGradosFAC(temperatura);
					System.out.println(temperatura + "ºF = " + conversion + "ºC");
					break;
				case '4':
					conversion = deGradosFAK(temperatura);
					System.out.println(temperatura + "ºF = " + conversion + "ºK");
					break;
				case '5':
					conversion = deGradosKAC(temperatura);
					System.out.println(temperatura + "ºK = " + conversion + "ºC");
					break;
				case '6':
					conversion = deGradosKAF(temperatura);
					System.out.println(temperatura + "ºK = " + conversion + "ºF");
					break;
				default:
			}
		  // Mientras el usuario no introduzca una ese	
		} while (opcion != 's' && opcion != 'S');	

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
	}
	
	/**
	 * Función: deGradosCAF
	 * 
	 * Convierte de ºCelsius a ºFahrenheit
	 * 
     * @author Efrén Sánchez
     * 
	 * Entrada:
	 * @parm double t		Temperatura en ºCelsius
	 * 
	 * Salida:
	 * @return double		Temperatura en ºFahrenheit
	 * 
	 */
	static double deGradosCAF(double t)
	{	
		return (t * (9 / 5) + 32);
	}

	/**
	 * Función: deGradosCAK
	 * 
	 * Convierte de ºCelsius a Kelvin
	 * 
     * @author Efrén Sánchez
     * 
	 * Entrada:
	 * @parm  double t		Temperatura en ºCelsius
	 * 
	 * Salida:
	 * @return  double			Temperatura en Kelvin
	 * 
	 */
	static double deGradosCAK(double t)
	{	
		return (t + 273.15);
	}

	/**
	 * Función: deGradosFAC
	 * 
	 * Convierte de ºFahrenheit a ºCelsius
	 * 
     * @author Efrén Sánchez
     * 
	 * Entrada:
	 * @parm  double t		Temperatura en ºFahrenheit
	 * 
	 * Salida:
	 * @return  double			Temperatura en ºCelsius
	 * 
	 */
	static double deGradosFAC(double t)
	{	
		return ((t - 32) * 5 / 9);
	}

	/**
	 * Función: deGradosFAK
	 * 
	 * Convierte de ºFahrenheit a ºKelvin
	 * 
     * @author Efrén Sánchez
     * 
	 * Entrada:
	 * @parm  double t		Temperatura en ºFahrenheit
	 * 
	 * Salida:
	 * @return  double			Temperatura en ºKelvin
	 * 
	 */
	static double deGradosFAK(double t)
	{	
		return ((t * (9 / 5) + 32) + 273.15);
	}

	/**
	 * Función: deGradosKAC
	 * 
	 * Convierte de ºKelvin a ºCelsius
	 * 
     * @author Efrén Sánchez
     * 
	 * Entrada:
	 * @parm  double t		Temperatura en ºKelvin
	 * 
	 * Salida:
	 * @return  double			Temperatura en ºCelsius
	 * 
	 */
	static double deGradosKAC(double t)
	{	
		return (t - 273.15);
	}

	/**
	 * Función: deGradosKAF
	 * 
	 * Convierte de ºKelvin a ºFahrenheit
	 * 
     * @author Efrén Sánchez
     * 
	 * Entrada:
	 * @parm  double t		Temperatura en ºKelvin
	 * 
	 * Salida:
	 * @return  double			Temperatura en ºFahrenheit
	 * 
	 */
	static double deGradosKAF(double t)
	{	
		return ((t - 273.15) * 9 / 5 + 32);
	}
}
