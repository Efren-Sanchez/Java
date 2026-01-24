import java.util.Objects;

public class LineaFactura {
    private String articulo;
    private int cantidad;
    private double precio;
    private TipoIVA iva;

    // Constructor por defecto
    public LineaFactura() {
        this.articulo = "";
        this.cantidad = 0;
        this.precio = 0.0;
        this.iva = TipoIVA.NORMAL;
    }

    // Constructor con parámetros
    public LineaFactura(String articulo, int cantidad, double precio, TipoIVA iva) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.iva = iva;
    }

    // Constructor de copia
    public LineaFactura(LineaFactura otra) {
        this.articulo = otra.articulo;
        this.cantidad = otra.cantidad;
        this.precio = otra.precio;
        this.iva = otra.iva;
    }

    // Getters y Setters
    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoIVA getIva() {
        return iva;
    }

    public void setIva(TipoIVA iva) {
        this.iva = iva;
    }

    // Método para calcular el total de la línea de factura
    public double calcularTotal() {
        return cantidad * precio * (1 + iva.getPorcentaje() / 100);
    }

    // Método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineaFactura that = (LineaFactura) o;
        return cantidad == that.cantidad &&
               Double.compare(that.precio, precio) == 0 &&
               Objects.equals(articulo, that.articulo) &&
               iva == that.iva;
    }

    // Método toString
    @Override
    public String toString() {
        return "\n\nLineaFactura: " +
               "articulo='" + articulo + '\'' +
               ", cantidad=" + cantidad +
               ", precio=" + precio +
               ", iva=" + iva +
               ", total=" + calcularTotal() +
               ';';
    }
}
