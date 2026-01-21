/*******************************************************************************
 * 
 * E035_ParqueAcuatico
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Parque acuático
 *
 * Programa que calcule el precio de las entradas para un parque acuático según 
 * las siguientes condiciones:
 * 
 * - Cada adulto paga 25€ por la entrada de medio día, o 40€ por la entrada de 
 * día completo.
 * - Los niños pagan 17,50€ por medio día, o 28€ por día completo.
 * - Como extras se puede añadir (preguntar por la cantidad, puede ser distinta 
 * al número de entradas):
 * 		Tumbona: 3€ por persona.
 * 		Consigna: 1€ por persona.
 * 
 * Al finalizar la introducción de datos, el programa calculará el importe 
 * total y presentará un resumen de lo reservado en pantalla.
 * 
 ******************************************************************************/

 import java.util.Scanner;

public class E035_ParqueAcuatico {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E035_ParqueAcuatico *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
        
		// Tarifas
        final double ADULTO_MEDIO_DIA = 25.0;
        final double ADULTO_DIA_COMPLETO = 40.0;
        final double NINO_MEDIO_DIA = 17.5;
        final double NINO_DIA_COMPLETO = 28.0;
        final double TUMBONA = 3.0;
        final double CONSIGNA = 1.0;

        // Datos de entradas
        System.out.print("Número de adultos: ");
        int numAdultos = sc.nextInt();
        System.out.print("¿Entrada de día completo para adultos?(s/n): ");
        String tipoAdulto = sc.next();

        System.out.print("Número de niños: ");
        int numNinos = sc.nextInt();
        System.out.print("¿Entrada de día completo para niños?(s/n): ");
        String tipoNino = sc.next();

        // Extras
        System.out.print("Cantidad de tumbonas: ");
        int cantidadTumbonas = sc.nextInt();
        System.out.print("Cantidad de consignas: ");
        int cantidadConsignas = sc.nextInt();

        // Cálculo entradas adultos
        double precioAdultos = 0;
        if (tipoAdulto.equalsIgnoreCase("s")) {
            precioAdultos = numAdultos * ADULTO_DIA_COMPLETO;
        } else {
            precioAdultos = numAdultos * ADULTO_MEDIO_DIA;
        }

        // Cálculo entradas niños
        double precioNinos = 0;
        if (tipoNino.equalsIgnoreCase("s")) {
            precioNinos = numNinos * NINO_DIA_COMPLETO;
        } else {
            precioNinos = numNinos * NINO_MEDIO_DIA;
        }

        // Cálculo extras
        double precioTumbonas = cantidadTumbonas * TUMBONA;
        double precioConsignas = cantidadConsignas * CONSIGNA;

        // Precio total
        double precioTotal = precioAdultos + precioNinos + precioTumbonas + precioConsignas;

        // Resumen
        System.out.println("\n--- RESUMEN DE RESERVA ---");
        System.out.println("Entradas adultos: " + numAdultos + (tipoAdulto.equalsIgnoreCase("s") ? " (día completo)" : " (medio día)") + " => " + precioAdultos + "€");
        System.out.println("Entradas niños: " + numNinos + (tipoNino.equalsIgnoreCase("s") ? " (día completo)" : " (medio día)") + " => " + precioNinos + "€");
        System.out.println("Tumbonas: " + cantidadTumbonas + " => " + precioTumbonas + "€");
        System.out.println("Consignas: " + cantidadConsignas + " => " + precioConsignas + "€");
        System.out.println("----------------------------");
        System.out.println("Total a pagar: " + precioTotal + "€");
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}