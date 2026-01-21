/**
 * E108A_Factura
 * 
 * @author Eduard Sebastian
 * Fecha:  Noviembre 2024
 * 
 * Programa que genera una factura a partir de los datos del cliente y los artículos de compra.
 * 
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class E108A_Factura {
	
	// Autor.
	static final String AUTOR = "ega0021@alu.medac.es";

	// Mensajes.
	static final String MENSAJE_DATOS_CORRECTOS = "¿Son correctos los datos introducidos? (s/n): ";
	static final String MENSAJE_NUEVA_LINEA = "¿Desea introducir más líneas a la factura? (s/n): ";
	static final String MENSAJE_REINTRODUCIR_DATOS =  "\nPor favor, vuelva a ingresar los datos. ";
	
	// Errores.
	static final String ERROR_PREGUNTA_SIN_RESPUESTA = "\nERROR - No ha respondido la pregunta.\n";
	static final String ERROR_CARACTER_INCORRECTO = "\nERROR - El carácter introducido no es correcto.\n";
	
	// Colores ANSI.
	static final String ANSI_RESET = "\u001B[0m";
	static final String ANSI_AMARILLO = "\u001B[33m";
	
	// Formato.
	static final String PATRON_TOTAL = "\t\t\t\t %13s: %10.2f E\n";
	
	// IVA.
	static final int IVA_SUPER_REDUCIDO = 4,
					 IVA_REDUCIDO = 10,
					 IVA_NORMAL = 21;
	
	// Escáner.
	static Scanner scn = new Scanner(System.in);
	
	// Bases imponibles.
	static double baseImpSupRed = 0.0, 	// Base imponible superreducida
				  baseImpRed = 0.0, 	// Base imponible reducida
				  baseImpNormal = 0.0; 	// Base imponible normal
				 
	// Totales.  
	static double subtotal = 0.0, 
				  totalIVA = 0.0,
				  totalFactura;
	
	public static void main (String[] args) {
		
		// Variable para almacenar toda la factura.
		String factura = "";
		
		// Variable para controlar el número de línea de la factura.
		int nrLinea = 1;
				
		// Imprime la pantalla de inicio y espera a que el usuario pulse ENTER para continuar.
		pantallaInicio();
		
		// Añade el encabezado al contenido de la factura.
		factura += encabezadoFactura();
		
		factura += "\n";
		
		// Pide los datos del cliente (nombre y dirección) y los añade a la factura.
		factura += datosCliente();
		
		factura += "\n";
		factura += separadorContenido();
		factura += "\n\n";
		
		// Añade el encabezado de la tabla a la factura.
		factura += encabezadoTablaFactura();
		
		// Añade a la factura todas las líneas que el usuario introduzca.
		while (true) {
		
			factura += nuevaLinea(nrLinea);
			
			System.out.printf("%n%s%n%n", separadorContenido());
			
			// Pregunta al usuario si desea introducir otra línea hasta obtener una respuesta válida.
			// Deja de añadir líneas si el usuario responde que no ('n').
			if (!validarEntrada(MENSAJE_NUEVA_LINEA)) break;
						
			limpiarConsola();
			
			// Incrementa el contador de línea para la siguiente iteración.
			nrLinea++;
			
		}
		
		// Añade el pie de la tabla a la factura.
		factura += pieTablaFactura();
		
		factura += "\n";
		
		// Añade el subtotal a la factura.
		factura += String.format(PATRON_TOTAL, "SUBTOTAL", subtotal);
		
		factura += "\n";
		
		// Añade el encabezado de la sección del IVA a la factura.
		factura += encabezadoIVA();
		factura += "\n";
		
		// Añade la tabla del IVA a la factura.
		factura += resumenIVA(); 
		factura += "\n\n";
		
		// Calcular el total de la factura.
		totalFactura = subtotal + totalIVA;
			
		// Añade el el total de la factura y el IVA total a la factura.	
		factura += String.format(PATRON_TOTAL, "TOTAL IVA", totalIVA);
		factura += String.format(PATRON_TOTAL, "TOTAL FACTURA", totalFactura);
		
		factura += "\n";
		factura += "=================================================================";
		
		// Limpia la consola, preparándola para mostrar la factura.
		limpiarConsola();
		
		// Imprime la factura.
		System.out.println(factura);	
	
	}
	
	// ============================= MÉTODOS PRINCIPALES =============================
	
	static void pantallaInicio() {
		
		String entrada;
	
		while (true) {
		
			// Imprimir pantalla de inicio.
			System.out.println("=================================================================");
			System.out.println("                     PROGRAMA DE FACTURACION                     ");
			System.out.println("=================================================================");
			System.out.println();
			System.out.println("Bienvenido/a al Programa de Facturación.");
			System.out.println("\n");
			System.out.println("Con esta aplicación podrá gestionar sus facturas de manera\nrápida y sencilla.");
			System.out.println("\n");
			System.out.println("Para una mejor experiencia, se recomienda utilizar la aplicación\nen pantalla completa.");
			System.out.print("\n\n");
			System.out.printf("Creado por %s\n", AUTOR);
			System.out.println();
			System.out.println(separadorContenido());
			System.out.printf("Por favor, pulse %sENTER%s para empezar.\n", ANSI_AMARILLO, ANSI_RESET);
			System.out.println(separadorContenido());
			
			// Leer entrada.
			entrada = scn.nextLine();
			
			// Limpiar consola.
			limpiarConsola();
			
			// Salir del método si se ha introducido un ENTER (cadena vacía).
			if (entrada.length() == 0) return;
			
		}
	}
	
	static String datosCliente() {
		
		String resultado = "";
		
		String nombre;
		String direccion;
		
		LocalDate fecha = LocalDate.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaConFormato = fecha.format(formatoFecha);
		
		while (true) {
					
			System.out.println("=================================================================");
			System.out.println("                        DATOS DEL CLIENTE                        ");
			System.out.println("=================================================================");
			System.out.println();
			
			System.out.println("FECHA: " + fechaConFormato);
			System.out.println();
			System.out.println(separadorContenido());
			System.out.println();
			
			System.out.print("[1/2] Nombre del cliente: ");
			nombre = scn.nextLine();
			
			System.out.println();
			
			System.out.print("[2/2] Dirección de facturación: ");
			direccion = scn.nextLine();
			
			System.out.println();
			System.out.println(separadorContenido());
			System.out.println();
			
			if(!validarEntrada(MENSAJE_DATOS_CORRECTOS)) {
			
				System.out.printf("%n%s%n", separadorContenido());
				System.out.print(MENSAJE_REINTRODUCIR_DATOS);
				scn.nextLine();
				limpiarConsola();
			
			} else {
			
				System.out.printf("%n%s%n", separadorContenido());
				System.out.print("\n¡Datos completos! Procedamos a añadir las líneas de la factura ");
				scn.nextLine();
				limpiarConsola();
				break;	
				
			}
		}	
		
		resultado += "Fecha: %s%n";
		resultado += "Cliente: %s%n";
		resultado += "Dirección: %s%n";
		
		return String.format(resultado, fechaConFormato, nombre, direccion);
		
	}
		
	static String nuevaLinea(int nrLinea) {
		
		// Variables de entrada de datos para cada línea.
		String articulo;
		int cantidad;
		double precio;
		String tipoIVA;
		
		// Variables auxiliares.
		double importe;
		int valorIVA = -1;
		
		// Línea que devuelve el método.
		String linea;		
		
		while (true) {
					
			System.out.println("=================================================================");
			System.out.printf("                            LINEA %2d                            \n", nrLinea);
			System.out.println("=================================================================");
			System.out.println();
			
			System.out.print("[1/4] Nombre del artículo: ");
			articulo = scn.nextLine();
						
			System.out.println();
			
			System.out.print("[2/4] Cantidad a comprar: ");
			cantidad = scn.nextInt();
			
			System.out.println();
			
			System.out.print("[3/4] Precio unitario (euros): ");
			precio = scn.nextDouble();
			
			System.out.println();
			
			scn.nextLine();
			
			while (true) {
								
				System.out.print("[4/4] Tipo de IVA (s/r/n): ");
				tipoIVA = scn.nextLine();
				
				if (tipoIVA.length() == 0) {
				
					System.out.println(ERROR_PREGUNTA_SIN_RESPUESTA);
				
				} else if (tipoIVA.charAt(0) != 's' && tipoIVA.charAt(0) != 'r' && tipoIVA.charAt(0) != 'n') {
				
					System.out.println(ERROR_CARACTER_INCORRECTO);
				
				} else break;
				
			}
			
			switch (tipoIVA.charAt(0)) {
			
				case 's':
					valorIVA = IVA_SUPER_REDUCIDO;
					break;
					
				case 'r':
					valorIVA = IVA_REDUCIDO;
					break;
					
				case 'n':
					valorIVA = IVA_NORMAL;
					break;
			
			}
			
			importe = cantidad * precio;
			
			// Imprimir vista previa.
			System.out.printf("%n%s%n%n", separadorContenido());
			
			System.out.print(encabezadoTablaFactura());
			
			linea = "| %-12s | %9dx | %9.2f E | %9.2f E | %3d %% |%n";			
			System.out.printf(linea, articulo, cantidad, precio, importe, valorIVA);
			
			System.out.println(pieTablaFactura());
			
			System.out.printf("%n%s%n%n", separadorContenido());
			
			if (!validarEntrada(MENSAJE_DATOS_CORRECTOS)) {
				
				System.out.printf("%n%s%n", separadorContenido());
				System.out.print(MENSAJE_REINTRODUCIR_DATOS);
				scn.nextLine();
				limpiarConsola();
				
			} else break;	
				
		}
		
		switch (tipoIVA.charAt(0)) {
			
			case 's':
				baseImpSupRed += importe;
				break;
					
			case 'r':
				baseImpRed += importe;
				break;
					
			case 'n':
				baseImpNormal += importe;
				break;
			
		}
		
		subtotal += importe;
		
		return String.format(linea, articulo, cantidad, precio, importe, valorIVA);

	}

	static String resumenIVA() {
		
		final String PATRON = "| %7d %% | %18.2f E | %9.2f E | %10.2f E |%n";
		String tablaIVA = "";
		
		double cuotaSupRed,
			   cuotaRed,
			   cuotaNormal;
			   
		double totalSupRed,
			   totalRed,
			   totalNormal;
			   
		// Añadir encabezado tabla IVA.
		tablaIVA += encabezadoTablaIVA();
		
		// Solamente añadir a la tabla del IVA las bases imponibles superiores a 0.
		if (baseImpSupRed > 0.0) {
		
			cuotaSupRed = ((double) IVA_SUPER_REDUCIDO / 100) * baseImpSupRed;
			totalSupRed = baseImpSupRed + cuotaSupRed;
			
			totalIVA += cuotaSupRed;
			
			tablaIVA += String.format(PATRON, IVA_SUPER_REDUCIDO, baseImpSupRed, cuotaSupRed, totalSupRed);
			
		
		}
		
		if (baseImpRed > 0.0) {
		
			cuotaRed = ((double) IVA_REDUCIDO / 100) * baseImpRed;
			totalRed = baseImpRed + cuotaRed;
			
			totalIVA += cuotaRed;
			
			tablaIVA += String.format(PATRON, IVA_REDUCIDO, baseImpRed, cuotaRed, totalRed);
		
		}
		
		if (baseImpNormal > 0.0) {
		
			cuotaNormal = ((double) IVA_NORMAL / 100) * baseImpNormal;
			totalNormal = baseImpNormal + cuotaNormal;
			
			totalIVA += cuotaNormal;
			
			tablaIVA += String.format(PATRON, IVA_NORMAL, baseImpNormal, cuotaNormal, totalNormal);
		
		}
		
		// Añadir pie tabla.
		tablaIVA += (pieTablaIVA());
		
		return tablaIVA;
	
	}
	
	// ============================= MÉTODOS AUXILIARES =============================
	
	static boolean validarEntrada(String mensaje) {
		
		String entrada;
	
		while (true) {
		
			System.out.print(mensaje);
			entrada = scn.nextLine();
			
			if (entrada.length() == 0) System.out.println(ERROR_PREGUNTA_SIN_RESPUESTA);
			else if (entrada.charAt(0) == 's') return true;
			else if (entrada.charAt(0) == 'n') return false;
			else System.out.println(ERROR_CARACTER_INCORRECTO);
		
		}
	}
	
	static void limpiarConsola() {
	
		System.out.print("\033[H\033[2J");
		System.out.flush();
	
	}
	
	// ============================= FORMATO FACTURA =============================

	static String encabezadoFactura() {
		
		String encabezado = "";
		 
		encabezado += "=================================================================\n";
		encabezado += "                             FACTURA                             \n";
		encabezado += "=================================================================\n";
		
		return encabezado;
		
	}
	
	static String encabezadoTablaFactura() {
		
		String encabezado = "";
	
		encabezado += ("+--------------+------------+-------------+-------------+-------+\n");	
		encabezado += ("|   Artículo   |  Cantidad  |  Precio U.  |   Importe   |  IVA  |\n");
		encabezado += ("+--------------+------------+-------------+-------------+-------+\n");
		
		return encabezado;
	
	}
	
	static String pieTablaFactura() {
		
		return "+--------------+------------+-------------+-------------+-------+\n";	
			
	}
	
	// ============================= FORMATO IVA =============================	
	
	static String encabezadoIVA() {
		
		String encabezado = "";
		 
		encabezado += "=================================================================\n";
		encabezado += "                           RESUMEN IVA                           \n";
		encabezado += "=================================================================\n";
		
		return encabezado;
		
	}
	
	static String encabezadoTablaIVA() {
	
		String encabezado = "";
		
		encabezado += ("+-----------+----------------------+-------------+--------------+\n");
		encabezado += ("|    IVA    |    BASE IMPONIBLE    |    CUOTA    |     TOTAL    |\n");
		encabezado += ("+-----------+----------------------+-------------+--------------+\n");
		
		return encabezado;
	
	}
	
	static String pieTablaIVA() {
	
		return "+-----------+----------------------+-------------+--------------+";
	
	}
	
	// ============================= OTROS =============================

	static String separadorContenido() {
	
		return "-----------------------------------------------------------------";
	
	}
	
	static String encabezadoDinamico(int ancho, String nombre) {
		
		String res = "";
		int longNombre = nombre.length();
	
		for (int i = 0; i < ancho; i++) res += "=";
		
		res += "\n";
		
		for (int i = 0; i < (ancho - longNombre) / 2; i++) res += " ";
		
		res += nombre;
		
		for (int i = 0; i < (ancho - longNombre) / 2; i++) res += " ";
		
		res += "\n";
		
		for (int i = 0; i < ancho; i++) res += "=";
		
		return res;
		
	}
}