/** 
 * Calculable:
 * 
 * Define los métodos calcularArea() y calcularPerimetro() que deben ser 
 * implementados por todas las figuras que puedan calcular su área y perímetro.
 * Incluye un método estático calcularDistancia() para calcular la distancia 
 * entre dos puntos, que puede ser utilizado por cualquier clase sin necesidad 
 * de implementar la interfaz. 
 */
public interface Calculable {
    /**
     * Calcula y devuelve el área de la figura.
     *
     * @return El área de la figura.
     */
    double calcularArea();

    /**
     * Calcula y devuelve el perímetro de la figura.
     *
     * @return El perímetro de la figura.
     */
    double calcularPerimetro();

    /**
     * Calcula la distancia entre dos puntos.
     *
     * @param p1 El primer punto.
     * @param p2 El segundo punto.
     * @return La distancia entre los puntos.
     */
    static double calcularDistancia(Punto p1, Punto p2) {
        double deltaX = p2.getX() - p1.getX();
        double deltaY = p2.getY() - p1.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    /**
     * Calcula el producto cruz de tres puntos.
     *
     * @param p1 El primer punto.
     * @param p2 El segundo punto.
     * @param p3 El tercer punto.
     * @return El producto cruz de los tres puntos.
     */
    static double calcularProductoCruz(Punto p1, Punto p2, Punto p3) {
        return (p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());
    }
}