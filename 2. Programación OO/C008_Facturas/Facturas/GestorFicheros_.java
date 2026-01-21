import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestorFicheros_ {
    public static void guardarFacturasBinario(Factura[] facturas, String nombreFichero) {
        java.io.FileOutputStream fos = null;
        java.io.ObjectOutputStream oos = null;
        try {
            fos = new java.io.FileOutputStream(nombreFichero);
            oos = new java.io.ObjectOutputStream(fos);
            oos.writeObject(facturas);
            System.out.println("Facturas guardadas en el fichero binario: " + nombreFichero);
        } catch (java.io.IOException e) {
            System.err.println("Error al guardar las facturas en el fichero binario: " + e.getMessage());
        } finally {
            try {
                if (oos != null) oos.close();
                if (fos != null) fos.close();
            } catch (java.io.IOException e) {
                System.err.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }
    }

    public static Factura[] leerFacturasBinario(String nombreFichero) {
        java.io.FileInputStream fis = null;
        java.io.ObjectInputStream ois = null;
        Factura[] facturas = new Factura[0];
        java.io.File archivo = new java.io.File(nombreFichero);
        if (!archivo.exists()) {
            return facturas;
        }
        try {
            fis = new java.io.FileInputStream(nombreFichero);
            ois = new java.io.ObjectInputStream(fis);
            facturas = (Factura[]) ois.readObject();
        } catch (java.io.IOException | ClassNotFoundException e) {
            System.err.println("Error al leer las facturas del fichero binario: " + e.getMessage());
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (java.io.IOException e) {
                System.err.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }
        return facturas;
    }

    public static void guardarFacturasXML(Factura[] facturas, String nombreFichero) {
        // Implementación manual de guardado en XML
        StringBuilder xmlContent = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<facturas>\n");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        for (Factura factura : facturas) {
            xmlContent.append("  <factura>\n");
            xmlContent.append("    <numero>").append(factura.numero).append("</numero>\n");
            xmlContent.append("    <fecha>").append(factura.fecha.format(formato)).append("</fecha>\n");
            xmlContent.append("    <empresa>\n");
            xmlContent.append("      <razonSocial>").append(sanitizarXML(factura.empresa.razonSocial)).append("</razonSocial>\n");
            xmlContent.append("      <direccion>").append(sanitizarXML(factura.empresa.direccion)).append("</direccion>\n");
            xmlContent.append("      <cif>").append(sanitizarXML(factura.empresa.cif)).append("</cif>\n");
            xmlContent.append("      <telefono>").append(sanitizarXML(factura.empresa.telefono)).append("</telefono>\n");
            xmlContent.append("      <email>").append(sanitizarXML(factura.empresa.email)).append("</email>\n");
            xmlContent.append("    </empresa>\n");
            xmlContent.append("    <cliente>\n");
            xmlContent.append("      <nombre>").append(sanitizarXML(factura.cliente.nombre)).append("</nombre>\n");
            xmlContent.append("      <nifCif>").append(sanitizarXML(factura.cliente.nifCif)).append("</nifCif>\n");
            xmlContent.append("      <telefono>").append(sanitizarXML(factura.cliente.telefono == null ? "" : factura.cliente.telefono)).append("</telefono>\n");
            xmlContent.append("      <email>").append(sanitizarXML(factura.cliente.email == null ? "" : factura.cliente.email)).append("</email>\n");
            xmlContent.append("    </cliente>\n");
            xmlContent.append("    <lineas>\n");
            for (LineaFactura linea : factura.lineas) {
                xmlContent.append("      <linea>\n");
                xmlContent.append("        <articulo>").append(sanitizarXML(linea.articulo)).append("</articulo>\n");
                xmlContent.append("        <cantidad>").append(linea.cantidad).append("</cantidad>\n");
                xmlContent.append("        <precio>").append(linea.precio).append("</precio>\n");
                xmlContent.append("        <iva>").append(linea.iva).append("</iva>\n");
                xmlContent.append("      </linea>\n");
            }
            xmlContent.append("    </lineas>\n");
            xmlContent.append("  </factura>\n");
        }
        xmlContent.append("</facturas>\n");

        java.io.FileWriter fw = null;
        java.io.BufferedWriter bw = null;
        try {
            fw = new java.io.FileWriter(nombreFichero);
            bw = new java.io.BufferedWriter(fw);
            bw.write(xmlContent.toString());
            System.out.println("Facturas guardadas en el fichero XML: " + nombreFichero);
        } catch (java.io.IOException e) {
            System.err.println("Error al guardar las facturas en el fichero XML: " + e.getMessage());
        } finally {
            try {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            } catch (java.io.IOException e) {
                System.err.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }
    }

    private static String sanitizarXML(String texto) {
        return texto.replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("&", "&amp;")
                .replace("'", "&apos;")
                .replace("\"", "&quot;");
    }

    public static Factura[] leerFacturasXML(String nombreFichero) {
        java.io.File archivo = new java.io.File(nombreFichero);
        if (!archivo.exists()) {
            return new Factura[0];
        }
        java.io.FileReader fr = null;
        java.io.BufferedReader br = null;
        StringBuilder xmlContent = new StringBuilder();
        try {
            fr = new java.io.FileReader(nombreFichero);
            br = new java.io.BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                xmlContent.append(linea.trim());
            }
        } catch (java.io.IOException e) {
            System.err.println("Error al leer el fichero XML: " + e.getMessage());
            return new Factura[0];
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (java.io.IOException e) {
                System.err.println("Error al cerrar el fichero XML: " + e.getMessage());
            }
        }

        // Implementación manual de parsing XML (muy básica y no robusta)
        java.util.List<Factura> facturasList = new java.util.ArrayList<>();
        String content = xmlContent.toString();
        String[] facturaTags = content.split("<factura>");

        if (facturaTags.length > 1) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            for (int i = 1; i < facturaTags.length; i++) {
                String facturaData = facturaTags[i];
                Factura factura = new Factura();
                factura.numero = Integer.parseInt(obtenerValorTag(facturaData, "numero"));
                factura.fecha = LocalDateTime.parse(obtenerValorTag(facturaData, "fecha"), formato);

                String empresaData = obtenerBloqueTag(facturaData, "empresa");
                factura.empresa = new Empresa(
                        obtenerValorTag(empresaData, "razonSocial"),
                        obtenerValorTag(empresaData, "direccion"),
                        obtenerValorTag(empresaData, "cif"),
                        obtenerValorTag(empresaData, "telefono"),
                        obtenerValorTag(empresaData, "email")
                );

                String clienteData = obtenerBloqueTag(facturaData, "cliente");
                factura.cliente = new Cliente(
                        obtenerValorTag(clienteData, "nombre"),
                        obtenerValorTag(clienteData, "nifCif"),
                        obtenerValorTag(clienteData, "telefono"),
                        obtenerValorTag(clienteData, "email")
                );

                String lineasData = obtenerBloqueTag(facturaData, "lineas");
                String[] lineaTags = lineasData.split("<linea>");
                LineaFactura[] lineas = new LineaFactura[lineaTags.length - 1];
                for (int j = 1; j < lineaTags.length; j++) {
                    String lineaData = lineaTags[j];
                    lineas[j - 1] = new LineaFactura(
                            obtenerValorTag(lineaData, "articulo"),
                            Integer.parseInt(obtenerValorTag(lineaData, "cantidad")),
                            Double.parseDouble(obtenerValorTag(lineaData, "precio")),
                            TipoIVA.valueOf(obtenerValorTag(lineaData, "iva"))
                    );
                }
                factura.lineas = lineas;
                facturasList.add(factura);
            }
        }
        Factura[] facturasArray = new Factura[facturasList.size()];
        for (int i = 0; i < facturasList.size(); i++) {
            facturasArray[i] = facturasList.get(i);
        }
        System.out.println("Lectura desde XML implementada (de forma básica). Fichero: " + nombreFichero);
        return facturasArray;
    }

    private static String obtenerValorTag(String texto, String tag) {
        String inicioTag = "<" + tag + ">";
        String finTag = "</" + tag + ">";
        int inicio = texto.indexOf(inicioTag);
        int fin = texto.indexOf(finTag);
        if (inicio != -1 && fin != -1 && inicio < fin) {
            return texto.substring(inicio + inicioTag.length(), fin);
        }
        return "";
    }

    private static String obtenerBloqueTag(String texto, String tag) {
        String inicioTag = "<" + tag + ">";
        String finTag = "</" + tag + ">";
        int inicio = texto.indexOf(inicioTag);
        int fin = texto.indexOf(finTag);
        if (inicio != -1 && fin != -1 && inicio < fin) {
            return texto.substring(inicio + inicioTag.length(), fin);
        }
        return "";
    }
}
