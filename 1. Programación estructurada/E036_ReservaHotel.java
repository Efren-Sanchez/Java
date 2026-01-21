/*******************************************************************************
 * 
 * E036_ReservaHotel
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

public class E036_ReservaHotel {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E036_ReservaHotel *\n\n  --- Inicio del programa ---\n\n");

		Scanner sc = new Scanner(System.in);
        
        // Precios por noche según pensión
        final double DOBLE_AD = 130.0;
        final double DOBLE_MP = 180.0;
        final double DOBLE_PC = 230.0;

        // Precios de extras
        final double PARKING_NOCHE = 10.0;
        final double VISITA_PERSONA = 35.0;
        final double CATA_PERSONA = 27.0;

        // Descuento habitación individual
        final double DESCUENTO_INDIVIDUAL = 0.35;

        // Datos de entrada
        System.out.print("Número de personas: ");
        int personas = sc.nextInt();
        System.out.print("Número de noches: ");
        int noches = sc.nextInt();
        System.out.print("Tipo pensión (AD/MP/PC): ");
        String pension = sc.next().toUpperCase();

        System.out.print("¿Parking? (s/n): ");
        String parking = sc.next();
        System.out.print("¿Visita centro histórico? (s/n): ");
        String visita = sc.next();
        System.out.print("¿Cata de vinos? (s/n): ");
        String cata = sc.next();

        // Cálculo habitaciones necesarias
        int dobles = personas / 2;
        int individuales = personas % 2;
        int totalHabitaciones = dobles + individuales;

        double precioBase = 0;
        switch (pension) {
            case "AD": precioBase = DOBLE_AD; break;
            case "MP": precioBase = DOBLE_MP; break;
            case "PC": precioBase = DOBLE_PC; break;
            default: System.out.println("Tipo de pensión erróneo."); sc.close(); return;
        }

        // Habitaciones dobles
        double precioDobles = dobles * precioBase * noches;

        // Habitación individual con descuento
        double precioIndividual = individuales * precioBase * noches * (1 - DESCUENTO_INDIVIDUAL);

        // Calcular extras
        double precioParking = (parking.equalsIgnoreCase("s")) ? totalHabitaciones * PARKING_NOCHE * noches : 0;
        double precioVisita = (visita.equalsIgnoreCase("s")) ? personas * VISITA_PERSONA : 0;
        double precioCata = (cata.equalsIgnoreCase("s")) ? personas * CATA_PERSONA : 0;

        double precioTotal = precioDobles + precioIndividual + precioParking + precioVisita + precioCata;

        // Resumen
        System.out.println("\n--- RESUMEN DE RESERVA ---");
        System.out.println("Habitaciones dobles: " + dobles);
        System.out.println("Habitación individual: " + individuales + " (descuento 35%)");
        System.out.println("Precio habitaciones: " + (precioDobles + precioIndividual) + "€");
        System.out.println("Parking: " + precioParking + "€");
        System.out.println("Visita centro histórico: " + precioVisita + "€");
        System.out.println("Cata de vinos: " + precioCata + "€");
        System.out.println("----------------------------");
        System.out.println("Total a pagar: " + precioTotal + "€");
		
		sc.close();

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}