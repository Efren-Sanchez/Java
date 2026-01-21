import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static Factura[] facturas = new Factura[10]; // Inicializamos con una capacidad de 10, se puede ajustar
    private static int numFacturas = 0;
    private static int siguienteNumeroFactura = 1;
    private static final String FICHERO_BINARIO = "facturas.dat";
    private static final String FICHERO_XML = "facturas.xml";
    private static final DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        cargarFacturasBinario();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    introducirFactura(scanner);
                    break;
                case 2:
                    visualizarFacturas();
                    break;
                case 0:
                    GestorFicheros.guardarFacturasBinario(copiarArrayFacturas(), FICHERO_BINARIO);
                    GestorFicheros.guardarFacturasXML(copiarArrayFacturas(), FICHERO_XML);
                    System.out.println("Saliendo del programa. Facturas guardadas.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("--- Gestión de Facturas ---");
        System.out.println("1. Introducir nueva factura");
        System.out.println("2. Visualizar facturas");
        System.out.println("0. Salir y guardar");
    }

    private static void introducirFactura(Scanner scanner) {
        if (numFacturas >= facturas.length) {
            System.out.println("No se pueden añadir más facturas. Límite alcanzado.");
            return;
        }

        Empresa empresa = leerDatosEmpresa(scanner);
        Cliente cliente = leerDatosCliente(scanner);

        LocalDateTime fechaHoraActual = LocalDateTime.now();
        Factura factura = new Factura(siguienteNumeroFactura++, fechaHoraActual, empresa, cliente, new LineaFactura[0]);

        LineaFactura[] lineas = new LineaFactura[5]; // Inicializamos con una capacidad de 5 líneas, se puede ajustar
        int numLineas = 0;
        boolean agregarLinea = true;

        while (agregarLinea) {
            if (numLineas >= lineas.length) {
                System.out.println("No se pueden añadir más líneas a esta factura. Límite alcanzado.");
                break;
            }
            LineaFactura linea = leerLineaFactura(scanner);
            lineas[numLineas++] = linea;
            System.out.print("¿Desea añadir otra línea de factura? (s/n): ");
            String respuesta = scanner.nextLine().toLowerCase();
            agregarLinea = respuesta.equals("s");
        }

        // Crear un nuevo array de líneas con el tamaño exacto
        LineaFactura[] lineasFinales = new LineaFactura[numLineas];
        for (int i = 0; i < numLineas; i++) {
            lineasFinales[i] = lineas[i];
        }
        factura.setLineas(lineasFinales);

        facturas[numFacturas++] = factura;
        System.out.println("Factura introducida correctamente.");
    }

    private static Empresa leerDatosEmpresa(Scanner scanner) {
        System.out.println("\n--- Datos de la Empresa ---");
        System.out.print("Razón Social: ");
        String razonSocial = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("CIF: ");
        String cif = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        return new Empresa(razonSocial, direccion, cif, telefono, email);
    }

    private static Cliente leerDatosCliente(Scanner scanner) {
        System.out.println("\n--- Datos del Cliente ---");
        System.out.print("Nombre o Razón Social: ");
        String nombre = scanner.nextLine();
        System.out.print("NIF/CIF: ");
        String nifCif = scanner.nextLine();
        return new Cliente(nombre, nifCif, "", ""); // No pedimos teléfono ni email del cliente
    }

    private static LineaFactura leerLineaFactura(Scanner scanner) {
        System.out.println("\n--- Línea de Factura ---");
        System.out.print("Artículo: ");
        String articulo = scanner.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.println("IVA disponible:");
        TipoIVA[] ivas = TipoIVA.values();
        for (int i = 0; i < ivas.length; i++) {
            System.out.println((i + 1) + ". " + ivas[i]);
        }

        TipoIVA ivaSeleccionado = null;
        while (ivaSeleccionado == null) {
            System.out.print("Seleccione el IVA (1-" + ivas.length + "): ");
            int opcionIVA = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
            if (opcionIVA >= 1 && opcionIVA <= ivas.length) {
                ivaSeleccionado = ivas[opcionIVA - 1];
            } else {
                System.out.println("Opción de IVA no válida. Intente de nuevo.");
            }
        }

        return new LineaFactura(articulo, cantidad, precio, ivaSeleccionado);
    }

    private static void visualizarFacturas() {
        if (numFacturas == 0) {
            System.out.println("No hay facturas registradas.");
            return;
        }

        System.out.println("\n--- Listado de Facturas ---");
        for (int i = 0; i < numFacturas; i++) {
            System.out.println("Número de Factura: " + facturas[i].getNumero());
            System.out.println("Fecha y Hora: " + facturas[i].getFecha().format(FORMATO_FECHA_HORA));
            System.out.println(facturas[i].getEmpresa());
            System.out.println(facturas[i].getCliente());
            LineaFactura[] lineas = facturas[i].getLineas();
            System.out.println("\n--- Líneas de Factura ---");
            if (lineas.length == 0) {
                System.out.println("No hay líneas en esta factura.");
            } else {
                for (int j = 0; j < lineas.length; j++) {
                    System.out.println("  Artículo: " + lineas[j].getArticulo());
                    System.out.println("  Cantidad: " + lineas[j].getCantidad());
                    System.out.println("  Precio: " + lineas[j].getPrecio());
                    System.out.println("  IVA: " + lineas[j].getIva());
                    System.out.println("  Total Línea: " + lineas[j].calcularTotal());
                }
            }
            System.out.println("Total Factura: " + facturas[i].calcularTotal());
            System.out.println("-------------------------");
        }
    }

    private static void cargarFacturasBinario() {
        File archivo = new File(FICHERO_BINARIO);
        if (archivo.exists()) {
            Factura[] facturasCargadas = GestorFicheros.leerFacturasBinario(FICHERO_BINARIO);
            if (facturasCargadas.length > 0) {
                facturas = new Factura[facturasCargadas.length + 10]; // Aumentamos la capacidad si es necesario
                for (int i = 0; i < facturasCargadas.length; i++) {
                    facturas[i] = facturasCargadas[i];
                }
                numFacturas = facturasCargadas.length;
                siguienteNumeroFactura = (numFacturas > 0) ? facturas[numFacturas - 1].getNumero() + 1 : 1;
                System.out.println("Facturas cargadas desde el fichero binario.");
                visualizarFacturas();
            } else {
                siguienteNumeroFactura = 1;
                System.out.println("Fichero binario de facturas vacío.");
            }
        } else {
            System.out.println("No se encontró el fichero binario de facturas. Se empezará con la factura número 1.");
            siguienteNumeroFactura = 1;
        }
    }

    // Método para crear una copia del array de facturas sin elementos nulos
    private static Factura[] copiarArrayFacturas() {
        Factura[] copia = new Factura[numFacturas];
        for (int i = 0; i < numFacturas; i++) {
            copia[i] = facturas[i];
        }
        return copia;
    }
}