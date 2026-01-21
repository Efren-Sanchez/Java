import java.io.*;
//import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestorFicheros {

    // Método para guardar las facturas en un archivo XML
    public static void guardarFacturasXML(Factura[] facturas, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("<facturas>\n");
            for (int i = 0; i < facturas.length; i++) {
                Factura factura = facturas[i];
                writer.write("  <factura>\n");
                writer.write("    <numero>" + factura.getNumero() + "</numero>\n");
                writer.write("    <fecha>" + factura.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + "</fecha>\n");
                writer.write("    <cliente>\n");
                writer.write("      <nombre>" + factura.getCliente().getNombre() + "</nombre>\n");
                writer.write("      <nifCif>" + factura.getCliente().getNifCif() + "</nifCif>\n");
                writer.write("      <telefono>" + factura.getCliente().getTelefono() + "</telefono>\n");
                writer.write("      <email>" + factura.getCliente().getEmail() + "</email>\n");
                writer.write("    </cliente>\n");

                writer.write("    <empresa>\n");
                writer.write("      <nombre>" + factura.getEmpresa().getNombre() + "</nombre>\n");
                writer.write("      <direccion>" + factura.getEmpresa().getDireccion() + "</direccion>\n");
                writer.write("      <cif>" + factura.getEmpresa().getCif() + "</cif>\n");
                writer.write("      <telefono>" + factura.getEmpresa().getTelefono() + "</telefono>\n");
                writer.write("      <email>" + factura.getEmpresa().getEmail() + "</email>\n");
                writer.write("    </empresa>\n");

                writer.write("    <lineas>\n");
                // Guardar cada línea de la factura
                for (int j = 0; j < factura.getLineas().length; j++) {
                    LineaFactura linea = factura.getLineas()[j];
                    writer.write("      <linea>\n");
                    writer.write("        <articulo>" + linea.getArticulo() + "</articulo>\n");
                    writer.write("        <cantidad>" + linea.getCantidad() + "</cantidad>\n");
                    writer.write("        <precio>" + linea.getPrecio() + "</precio>\n");
                    writer.write("        <iva>" + linea.getIva().name() + "</iva>\n");
                    writer.write("        <total>" + linea.calcularTotal() + "</total>\n");
                    writer.write("      </linea>\n");
                }
                writer.write("    </lineas>\n");

                // Incluir el total de la factura
                writer.write("    <totalFactura>" + factura.calcularTotal() + "</totalFactura>\n");
                writer.write("  </factura>\n");
            }
            writer.write("</facturas>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer las facturas desde un archivo XML
    public static Factura[] leerFacturasXML(String nombreArchivo) {
        // Aquí iría la implementación para leer el archivo XML y crear las facturas a partir de éls
        return new Factura[0]; // Devuelve un array vacío como placeholder
    }

    // Método para guardar las facturas en un archivo binario
    public static void guardarFacturasBinario(Factura[] facturas, String nombreArchivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            out.writeInt(facturas.length); // Escribimos la cantidad de facturas
            for (int i = 0; i < facturas.length; i++) {
                out.writeObject(facturas[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer las facturas desde un archivo binario
    public static Factura[] leerFacturasBinario(String nombreArchivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            int cantidad = in.readInt();
            Factura[] facturas = new Factura[cantidad];
            for (int i = 0; i < cantidad; i++) {
                facturas[i] = (Factura) in.readObject();
            }
            return facturas;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Factura[0]; // Retorna un array vacío en caso de error
        }
    }
}
