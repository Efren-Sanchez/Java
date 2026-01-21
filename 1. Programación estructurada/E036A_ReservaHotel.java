/*******************************************************************************
 * 
 * E036A_ReservaHotel
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Reserva de hotel
 *
 * Programa que calcule el precio de una estancia de hotel según las siguiente 
 * condiciones:
 * 
 * - Precio por habitación doble por noche (2 personas):
 *      AD: 130€
 *      MP: 180€
 *      PC: 230€
 * - Extras:
 *      Parking: 10€/noche
 *      Visita al centro histórico: 35€/persona
 *      Cata de vinos: 27€/persona
 * 
 * El programa preguntará el número de personas, y calculará el número de 
 * habitaciones dobles necesarias, asignando una habitación doble a una sola 
 * persona en caso de ser necesario. En ese caso, se hará un descuento del 35% 
 * en esa habitación.
 * 
 ******************************************************************************/

 import java.util.Scanner;

public class E036A_ReservaHotel {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E036A_ReservaHotel *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
        
        // Tarifas habitación por noche
        final double PRECIO_AD = 130.0;
        final double PRECIO_MP = 180.0;
        final double PRECIO_PC = 230.0;

        // Extras
        final double PARKING = 10.0;
        final double VISITA = 35.0;
        final double CATA = 27.0;

        // Descuento habitación individual
        final double DESCUENTO_INDIVIDUAL = 0.35;

        // Solicitud de datos
        System.out.print("Número de personas: ");
        int numPersonas = sc.nextInt();
        System.out.print("Número de noches: ");
        int numNoches = sc.nextInt();

        System.out.println("Tipo de pensión: (1) AD  (2) MP  (3) PC");
        int tipoPension = sc.nextInt();

        System.out.print("¿Parking? (s/n): ");
        String parking = sc.next();

        System.out.print("¿Visita al centro histórico? (s/n): ");
        String visita = sc.next();

        System.out.print("¿Cata de vinos? (s/n): ");
        String cata = sc.next();

        // Cálculo de habitaciones dobles
        int habitacionesDobles = numPersonas / 2;
        int individuales = numPersonas % 2; // Si hay una persona sin pareja, necesita habitación individual
        double precioHabitaciones = 0;

        // Precio habitación doble completa
        double precioPorNoche = 0;
        switch (tipoPension) {
            case 1: precioPorNoche = PRECIO_AD; break;
            case 2: precioPorNoche = PRECIO_MP; break;
            case 3: precioPorNoche = PRECIO_PC; break;
            default: System.out.println("Tipo de pensión no válido."); sc.close(); return;
        }

        // Habitaciones de 2 personas
        precioHabitaciones += habitacionesDobles * precioPorNoche * numNoches;

        // Habitación individual (descuento)
        if (individuales > 0) {
            precioHabitaciones += (precioPorNoche * numNoches) * (1 - DESCUENTO_INDIVIDUAL);
        }

        // Extras
        double precioParking = 0;
        if (parking.equalsIgnoreCase("s")) {
            precioParking = (habitacionesDobles + individuales) * PARKING * numNoches;
        }

        double precioVisita = 0;
        if (visita.equalsIgnoreCase("s")) {
            precioVisita = numPersonas * VISITA;
        }

        double precioCata = 0;
        if (cata.equalsIgnoreCase("s")) {
            precioCata = numPersonas * CATA;
        }

        // Total
        double precioTotal = precioHabitaciones + precioParking + precioVisita + precioCata;

        // Resumen
        System.out.println("\n--- RESUMEN DE RESERVA ---");
        System.out.println("Habitaciones dobles (2 personas): " + habitacionesDobles);
        System.out.println("Habitación individual: " + individuales);
        System.out.println("Precio habitaciones: " + precioHabitaciones + "€");
        System.out.println("Parking: " + precioParking + "€");
        System.out.println("Visita al centro histórico: " + precioVisita + "€");
        System.out.println("Cata de vinos: " + precioCata + "€");
        System.out.println("----------------------------");
        System.out.println("Total a pagar: " + precioTotal + "€");
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}