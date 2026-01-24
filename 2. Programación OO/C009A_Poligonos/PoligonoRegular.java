public class PoligonoRegular extends Poligono implements Dibujable, Calculable {

    private double lado; // Longitud de cada lado

    /* Constructores */
    public PoligonoRegular(int numLados, Punto centro, double radio) {
        super(generarVertices(numLados, centro, radio), numLados);
        this.lado = calcularLado();
    }

    public PoligonoRegular(PoligonoRegular pr) {
        super(pr);
        this.lado = pr.lado;
    }

    /* Método para calcular los vértices del polígono regular */
    private static Punto[] generarVertices(int numLados, Punto centro, double radio) {
        Punto[] vertices = new Punto[numLados];
        double anguloBase = 2 * Math.PI / numLados;

        for (int i = 0; i < numLados; i++) {
            double x = centro.getX() + radio * Math.cos(i * anguloBase);
            double y = centro.getY() + radio * Math.sin(i * anguloBase);
            vertices[i] = new Punto(x, y);
        }

        return vertices;
    }

    /* Método para calcular la longitud de un lado */
    private double calcularLado() {
        return distancia(puntos[0], puntos[1]);
    }

    private double distancia(Punto p1, Punto p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    /* Métodos de cálculo */
    @Override
    public double calcularArea() {
        double apotema = (lado / (2 * Math.tan(Math.PI / numLados)));
        return (numLados * lado * apotema) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return numLados * lado;
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
        for (int i = 0; i < numLados; i++) {
            lineaRecta(puntos[i], puntos[(i + 1) % numLados]);
        }
    }

    /* Métodos comunes */
    @Override
    public String toString() {
        return super.toString() + " (Lado: " + lado + ", Área: " + calcularArea() + ", Perímetro: " + calcularPerimetro() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof PoligonoRegular)) return false;
        PoligonoRegular pr = (PoligonoRegular) obj;
        return Double.compare(lado, pr.lado) == 0;
    }
}
