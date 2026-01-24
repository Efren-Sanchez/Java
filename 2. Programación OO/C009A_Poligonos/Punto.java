public class Punto {

    /* Atributos */
    private double x; // Coordenada x del punto
    private double y; // Coordenada y del punto

    /* Constructores */
    // Vacío
    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    // Predeterminado
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Copia
    public Punto(Punto p) {
        this.x = p.x;
        this.y = p.y;
    }

    /* Getters y Setters */
    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /* Métodos comunes */
    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", this.x, this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Punto p = (Punto) obj;
        double EPSILON = 1e-6; // Se utiliza para evitar errores de precisión
        return Math.abs(this.x - p.x) < EPSILON && Math.abs(this.y - p.y) < EPSILON;
    }
}
