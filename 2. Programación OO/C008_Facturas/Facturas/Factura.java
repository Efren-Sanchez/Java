import java.time.LocalDateTime;
import java.util.Objects;

public class Factura {
    private static int contadorFacturas = 1;
    private int numero;
    private LocalDateTime fecha;
    private Empresa empresa;
    private Cliente cliente;
    private LineaFactura[] lineas;

    // Constructor por defecto
    public Factura() {
        this.numero = contadorFacturas++;
        this.fecha = LocalDateTime.now();
        this.empresa = new Empresa();
        this.cliente = new Cliente();
        this.lineas = new LineaFactura[0];
    }

    // Constructor con parámetros
    public Factura(Empresa empresa, Cliente cliente, LineaFactura[] lineas) {
        this.numero = contadorFacturas++;
        this.fecha = LocalDateTime.now();
        this.empresa = empresa;
        this.cliente = cliente;
        this.lineas = new LineaFactura[lineas.length];
        for (int i = 0; i < lineas.length; i++) {
            this.lineas[i] = lineas[i];
        }
    }

    // Constructor con parámetros
    public Factura(int numero, LocalDateTime fecha, Empresa empresa, Cliente cliente, LineaFactura[] lineas) {
        this.numero = numero;
        this.fecha = fecha;
        this.empresa = empresa;
        this.cliente = cliente;
        this.lineas = new LineaFactura[lineas.length];
        for (int i = 0; i < lineas.length; i++) {
            this.lineas[i] = lineas[i];
        }
    }
    
    // Constructor de copia
    public Factura(Factura otra) {
        this.numero = otra.numero;
        this.fecha = otra.fecha;
        this.empresa = new Empresa(otra.empresa);
        this.cliente = new Cliente(otra.cliente);
        this.lineas = new LineaFactura[otra.lineas.length];
        for (int i = 0; i < otra.lineas.length; i++) {
            this.lineas[i] = otra.lineas[i];
        }
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LineaFactura[] getLineas() {
        LineaFactura[] copia = new LineaFactura[lineas.length];
        for (int i = 0; i < lineas.length; i++) {
            copia[i] = lineas[i];
        }
        return copia;
    }

    public void setLineas(LineaFactura[] lineas) {
        this.lineas = new LineaFactura[lineas.length];
        for (int i = 0; i < lineas.length; i++) {
            this.lineas[i] = lineas[i];
        }
    }

    // Método para calcular el total de la factura
    public double calcularTotal() {
        double total = 0.0;
        for (int i = 0; i < lineas.length; i++) {
            total += lineas[i].calcularTotal();
        }
        return total;
    }

    // Método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        if (numero != factura.numero || !Objects.equals(fecha, factura.fecha) ||
            !Objects.equals(empresa, factura.empresa) || !Objects.equals(cliente, factura.cliente)) {
            return false;
        }
        if (lineas.length != factura.lineas.length) {
            return false;
        }
        for (int i = 0; i < lineas.length; i++) {
            if (!lineas[i].equals(factura.lineas[i])) {
                return false;
            }
        }
        return true;
    }

    // Método toString
    @Override
    public String toString() {
        return "\n\nFactura: " +
               "numero=" + numero +
               ", fecha=" + fecha +
               ", empresa=" + empresa +
               ", cliente=" + cliente +
               ", total=" + calcularTotal() +
               ';';
    }
}
