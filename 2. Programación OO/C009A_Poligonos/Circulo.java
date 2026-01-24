public class Circulo extends Poligono implements Dibujable, Calculable {

    private double radio; // Radio del círculo

    /* Constructores */
    public Circulo(Punto centro, double radio) {
        super(new Punto[]{centro}, 1); // Solo un punto (centro), numLados es irrelevante aquí
        this.radio = radio;
    }

    public Circulo(Circulo c) {
        super(c);
        this.radio = c.radio;
    }

    /* Getters y Setters */
    public Punto getCentro() {
        return puntos[0]; // El único punto es el centro
    }

    public void setCentro(Punto centro) {
        this.puntos[0] = new Punto(centro);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    /* Métodos de cálculo */
    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    /* Métodos de la interfaz Dibujar */
    @Override
    public void lineaRecta(Punto p1, Punto p2) {
        System.out.println("Dibujando línea recta de " + p1 + " a " + p2);
    }

    @Override
    public void lineaCurva(Punto p1, Punto p2, Punto control) {
        System.out.println("Dibujando línea curva de " + p1 + " a " + p2 + " con punto de control " + control);
    }

    /* Método de representación */
    @Override
    public void dibujar() {
        System.out.println("Dibujando " + getClass().getSimpleName() + " en la consola:");
        System.out.println("Centro: " + getCentro() + " | Radio: " + radio);
        System.out.println("O");
    }

    /* Métodos comunes */
    @Override
    public String toString() {
        return getClass().getSimpleName() + " [Centro: " + getCentro() + ", Radio: " + radio +
                ", Área: " + calcularArea() + ", Perímetro: " + calcularPerimetro() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Circulo)) return false;
        Circulo c = (Circulo) obj;
        return Double.compare(radio, c.radio) == 0;
    }
}
