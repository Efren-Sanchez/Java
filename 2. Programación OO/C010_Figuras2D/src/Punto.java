public class Punto {
    private double x;
    private double y;

    // Constructor por defecto
    public Punto() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Constructor con parámetros
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Constructor de copia
    public Punto(Punto otroPunto) {
        this.x = otroPunto.getX();
        this.y = otroPunto.getY();
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Setters
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Método toString()
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Método equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Punto otroPunto = (Punto) obj;
        return Double.compare(otroPunto.x, x) == 0 && Double.compare(otroPunto.y, y) == 0;
    }

    //Este método es muy útil para cálculos geométricos y podría ser una alternativa al método estático en la interfaz Calculable
    public double distanciaA(Punto otroPunto) {
        double deltaX = otroPunto.getX() - this.x;
        double deltaY = otroPunto.getY() - this.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    // Operaciones vectoriales
    public Punto sumar(Punto otroPunto) {
        return new Punto(this.x + otroPunto.getX(), this.y + otroPunto.getY());
    }
    
    public Punto restar(Punto otroPunto) {
        return new Punto(this.x - otroPunto.getX(), this.y - otroPunto.getY());
    }
    
    public Punto escalar(double factor) {
        return new Punto(this.x * factor, this.y * factor);
    }

    // Calcula el ángulo con otro punto (relativo al origen)
    public double anguloCon(Punto otroPunto) {
        return Math.atan2(otroPunto.getY() - this.y, otroPunto.getX() - this.x);
    }

    // Desplaza un punto en el espacio
    public void desplazar(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    /**
     * Devuelve la magnitud (longitud) del vector desde el origen hasta el punto.
     *
     * @return La magnitud del vector.
     */
    public double magnitud() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Devuelve el ángulo del vector desde el origen hasta el punto
     * con respecto al eje x positivo (en radianes).
     *
     * @return El ángulo en radianes.
     */
    public double angulo() {
        return Math.atan2(y, x);
    }

    /**
     * Devuelve un nuevo punto con la misma dirección pero con magnitud 1.
     *
     * @return Un nuevo punto normalizado.
     */
    public Punto normalizar() {
        double magnitud = magnitud();
        if (magnitud == 0) {
            return new Punto(0, 0); // Evitar división por cero
        }
        return new Punto(x / magnitud, y / magnitud);
    }
}