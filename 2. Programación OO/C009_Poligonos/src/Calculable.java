public interface Calculable {
    double calcularArea();
    double calcularPerimetro();

    /*
    public static double calcularDistancia(Punto p1, Punto p2) {
        // Distancia de Manhattan
        return (Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY()));
    }

    public static double calcularDistancia(int x1, int y1, int x2, int y2) {
        // Distancia de Manhattan
        return (Math.abs(x1 - x2) + Math.abs(y1 - y2));
    }
    */
}
