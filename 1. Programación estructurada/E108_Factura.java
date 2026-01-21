/**
 * E108_Factura
 * 
 * @author Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Creación de factura básica
 *
 * Especificaciones:
 * - El usuario introducirá los datos de la primera línea de factura: nombre de
 * producto, cantidad, precio, tipo de IVA.
 * 		- Si quieres, puedes mostrar la línea de factura introducida.
 * - A continuación, se preguntará al usuario si quiere introducir otra línea.
 * - El proceso se repite hasta que el usuario decida no introducir más líneas.
 * - Para finalizar, se imprimirá por pantalla la factura completa, con el total 
 * con (importe total) y sin IVA (base imponible).
 * - Los tipos impositivos posibles son: 
 * 		- Normal: 21%
 * 		- Reducido: 10%
 * 		- Superreducido: 4%
 *   
 */

import java.util.Scanner;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class


public class E108_Factura {

	// Contantes con caracteres unicode para cambiar los colores en la consola
	static final String ANSI_BLACK = "\u001B[30m";
	static final String ANSI_RED = "\u001B[31m";
	static final String ANSI_GREEN = "\u001B[32m";
	static final String ANSI_YELLOW = "\u001B[33m";
	static final String ANSI_BLUE = "\u001B[34m";
	static final String ANSI_PURPLE = "\u001B[35m";
	static final String ANSI_CYAN = "\u001B[36m";
	static final String ANSI_WHITE = "\u001B[37m";
	
	// Constante para eliminar cualquier color que hayamos aplicado a la consola
	static final String ANSI_RESET = "\u001B[0m";
	
	// Variables globales a la clase para llevar el conteo de los totales
	static double 	total = 0, 
					baseImponible = 0;

	public static void main(String[] args) {

		System.out.println("\n\n\n* E108_Factura *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
		char opcion;
		String factura = "";	// Inicializamos al elemento neutro, que en el caso de los strings es ""

		// Metemos la cabecera de la factura
		factura += introducirCabecera();
		
		// Utilizamos un bucle do while porque se tiene que ejecutar como mínimo una vez
		// Todas las facturas deben tener como mínimo una línea
		do
		{ 
			// Introducimos las líneas de factura
			factura += introducirLineaFactura();
			
			// Preguntamos al usuario si quiere seguir introduciendo líneas de factura
			System.out.println("¿Quieres introducir otra línea de factura? (S/N)");
			opcion = sc.next().charAt(0);
		} 
		while (opcion == 'S' || opcion == 's'); // Seguimos mientras el usuario introduzca una ese

		// Otra forma de hacer el bloque de código anterior
		/*
		opcion = 's';
		while (opcion == 'S' || opcion == 's');
		{ 
			factura = introducirLineaFactura();
			
			System.out.println("¿Quieres introducir otra línea de factura? (S/N)");
			opcion = sc.next().charAt(0);
		} 
		*/	
		
		// Introducimos el pie de la factura con los totales
		factura += introducirPie();
		
		// Borramos la consola para mejorar la impresión final de la factura
		borrarPantalla();
		
		// Mostramos la factura por la pantalla
		System.out.println(factura);

        sc.close();
		System.out.println("\n\n  --- Fin del programa ---\n\n");
	}
	
	/**
	 * Función: introducirCabecera
	 * 
	 * Crea y devuelve la cabecera de la factura
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada: void
	 * 
	 * Salida:
	 * @return String			Cadena con la cabecera de la factura
	 * 
	 */
	static String introducirCabecera()
	{
		// Para la fecha y la hora
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);

		// Devolvemos el string con la cabecera
		return "\n\n\t\t\t\t\t " + ANSI_BLUE + "Factura:\n\t\t\t\t\t ________" + ANSI_RESET + "\n\n" + 
			"\nFecha y hora: " + formattedDate + "\n" +
			"\n+-----------------+--------------+-----------+-----------+---------------+--------------+" +
			"\n| Producto \t  | Precio  \t | Cantidad  | IVA \t | Base Imp. \t | Total \t|" + 
			"\n+-----------------+--------------+-----------+-----------+---------------+--------------+";
	}
	
	/**
	 * Función: introducirPie
	 * 
	 * Crea y devuelve el pie de la factura
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada: void
	 * 
	 * Salida:
	 * @return String			Cadena con el pie de la factura
	 * 
	 */
	static String introducirPie()
	{
		String s;
	
		s = "\n+-----------------+--------------+-----------+-----------+---------------+--------------+";
		s += "\n|                                                                                       |";

		// Ponemos el importe de la base imponible en amarillo
		// Usamos String.format para poder alinear los datos más fácilmente
		s += String.format("%n| Base imponible:\t\t\t\t\t\t\t\u001B[33m%15.2f \u001B[0m|", baseImponible);	

		// Ponemos toda la línea en rojo
		s += ANSI_RED;
		s += String.format("%n| Total\t\t\t\t\t\t\t\t\t%15.2f |", total);	
		s += ANSI_RESET;
		
		s +="\n|                                                                                       |";
		s += "\n+-----------------+--------------+-----------+-----------+---------------+--------------+\n";
		
		return s;
	}
	
	/**
	 * Función: borrarPantalla
	 * 
	 * Borra la pantalla de la consola
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada: void
	 * 
	 * Salida:	void
	 * 
	 */
	static void borrarPantalla()
	{
		System.out.print("\033[H\033[2J");  // Caracteres unicode
		System.out.flush();  
	}
	
	/**
	 * Función: introducirLineaFactura
	 * 
	 * Solicita al usuario los datos para crear una línea de factura, la monta
	 * y la devuelve 
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada: void
	 * 
	 * Salida:
	 * @return String		Cadena con la línea de factura introducida por el usuario
	 * 
	 */
	static String introducirLineaFactura()
	{
		Scanner sc = new Scanner(System.in);
		String nombre, linea;
		double precio, impuesto;
		int cantidad, opImpuesto = 0;
		
		System.out.println("\n\n..................................\n");
		
		// Petición de datos al usuario
		System.out.println("Introduce el nombre del producto: ");
		nombre = sc.nextLine();

		System.out.println("Introduce el precio del producto: ");
		precio = sc.nextDouble();

		System.out.println("Introduce la cantidad del producto: ");
		cantidad = sc.nextInt();

		while (opImpuesto < 1 || opImpuesto > 3)
		{
			System.out.println("Introduce el tipo impositivo del producto: ");
			System.out.println("1) Normal: 21%\n2) Reducido: 10%\n3)Superreducido: 4%\n");
			opImpuesto = sc.nextInt();
		}
		
		impuesto = calcularImpuesto(opImpuesto);
		
		// Montamos la línea que vamos a devolver
		linea = String.format("%n| %-15s", nombre);		
		linea += String.format(" | \t   %5.2f", precio);
		linea += String.format(" | \t%4d", cantidad);		
		linea += String.format(" | \t %6.2f%%", (impuesto*100));
		linea += String.format(" |\t %7.2f", (cantidad*precio));
		linea += String.format(" |\t%7.2f |", (cantidad*precio*(1+impuesto)));
		
		// Acumulamos los valores del total y la base imponible
		baseImponible += (cantidad * precio);
		total += (cantidad * precio * (1+impuesto));
		
        sc.close();

		// Devolvemos la línea
		return linea;
	}
	
	/**
	 * Función: calcularImpuesto
	 * 
	 * Recibe un indicador de tipo impositivo y devuelve su valor numérico
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada:
	 * @param int op		Opción: 1 para normal, 2 para reducido, 3 para superreducido
	 * 
	 * Salida:
	 * @return double		Valor en tanto por 1 del impuesto
	 * 
	 */	
	static double calcularImpuesto(int op)
	{
		double impuesto;
		
		if (op == 3) // 4% - Superreducido
			impuesto = 0.04;
		else if (op == 2) // 10% - Reducido
			impuesto = 0.10;
		else // if (opImpuesto == 1) // 21% - Normal
			impuesto = 0.21;
		
		return impuesto;
	}

	/**
	 * Función: calcularImpuesto
	 * 
	 * Recibe un indicador de tipo impositivo y devuelve su valor numérico
	 * Sobrecargamos esta función para que también pueda recibir parámetros de tipo char
	 * 
	 * @author Efrén Sánchez
	 * 
	 * Entrada:
	 * @param int op		Opción: 1 para normal, 2 para reducido, 3 para superreducido
	 * 
	 * Salida:
	 * @return double		Valor en tanto por 1 del impuesto
	 * 
	 */	
	static double calcularImpuesto(char op)
	{
		double impuesto;
		
		if (op == 's' || op == 'S') // 4% - Superreducido
			impuesto = 0.04;
		else if (op == 'r' || op == 'R') // 10% - Reducido
			impuesto = 0.10;
		else // if (op == 'n' || op == 'N') // 21% - Normal
			impuesto = 0.21;
		
		return impuesto;
	}

}
