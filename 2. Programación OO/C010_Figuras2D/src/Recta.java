public class Recta {
    private Punto punto1;
    private Punto punto2;
    private double pendiente;
    private double interseccionY;
    private String ecuacion;

    // Constructores
    public Recta(Punto punto1, Punto punto2) {
        this.punto1 = new Punto(punto1);
        this.punto2 = new Punto(punto2);
        calcularEcuacion();
    }

    public Recta(double x1, double y1, double x2, double y2) {
        this.punto1 = new Punto(x1, y1);
        this.punto2 = new Punto(x2, y2);
        calcularEcuacion();
    }

    public Recta(Recta otraRecta) {
        this.punto1 = new Punto(otraRecta.punto1);
        this.punto2 = new Punto(otraRecta.punto2);
        this.pendiente = otraRecta.pendiente;
        this.interseccionY = otraRecta.interseccionY;
        this.ecuacion = otraRecta.ecuacion;
    }

    // Getters
    public Punto getPunto1() {
        return new Punto(punto1);
    }

    public Punto getPunto2() {
        return new Punto(punto2);
    }

    public double getPendiente() {
        return pendiente;
    }

    public double getInterseccionY() {
        return interseccionY;
    }

    public String getEcuacion() {
        return ecuacion;
    }

    // Métodos
    private void calcularEcuacion() {
        if (punto2.getX() - punto1.getX() == 0) {
            pendiente = Double.POSITIVE_INFINITY;
            interseccionY = Double.NaN;
            ecuacion = "x = " + punto1.getX();
        } else {
            pendiente = (punto2.getY() - punto1.getY()) / (punto2.getX() - punto1.getX());
            interseccionY = punto1.getY() - pendiente * punto1.getX();
            ecuacion = "y = " + pendiente + "x + " + interseccionY;
        }
    }

    public boolean contienePunto(Punto punto) {
        if (pendiente == Double.POSITIVE_INFINITY) {
            return punto.getX() == punto1.getX();
        }
        return Math.abs(punto.getY() - (pendiente * punto.getX() + interseccionY)) < 1e-10;
    }

    public Punto calcularInterseccion(Recta otraRecta) {
        if (this.equals(otraRecta)) {
            return null;
        }
        if (pendiente == otraRecta.pendiente) {
            return null;
        }
        if (pendiente == Double.POSITIVE_INFINITY) {
            double y = otraRecta.pendiente * punto1.getX() + otraRecta.interseccionY;
            return new Punto(punto1.getX(), y);
        }
        if (otraRecta.pendiente == Double.POSITIVE_INFINITY) {
            double y = pendiente * otraRecta.punto1.getX() + interseccionY;
            return new Punto(otraRecta.punto1.getX(), y);
        }
        double x = (otraRecta.interseccionY - interseccionY) / (pendiente - otraRecta.pendiente);
        double y = pendiente * x + interseccionY;
        return new Punto(x, y);
    }

    public double calcularDistanciaAPunto(Punto punto) {
        if (pendiente == Double.POSITIVE_INFINITY) {
            return Math.abs(punto.getX() - punto1.getX());
        }
        return Math.abs(pendiente * punto.getX() - punto.getY() + interseccionY) / Math.sqrt(pendiente * pendiente + 1);
    }

    public double calcularPendiente() {
        if (punto2.getX() - punto1.getX() == 0) {
            return Double.POSITIVE_INFINITY; // Pendiente infinita para rectas verticales
        }
        return (punto2.getY() - punto1.getY()) / (punto2.getX() - punto1.getX());
    }

    public double calcularDistanciaPunto(Punto punto) {
        double x0 = punto.getX();
        double y0 = punto.getY();
        double x1 = punto1.getX();
        double y1 = punto1.getY();
        double x2 = punto2.getX();
        double y2 = punto2.getY();

        double numerador = Math.abs((x2 - x1) * (y1 - y0) - (x1 - x0) * (y2 - y1));
        double denominador = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if (denominador == 0) {
            return Calculable.calcularDistancia(punto, punto1); // Recta degenerada a un punto
        }

        return numerador / denominador;
    }

    // toString(), equals() y hashCode()
    @Override
    public String toString() {
        return "Recta [" + ecuacion + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Recta otraRecta = (Recta) obj;
        return (punto1.equals(otraRecta.punto1) && punto2.equals(otraRecta.punto2)) ||
               (punto1.equals(otraRecta.punto2) && punto2.equals(otraRecta.punto1));
    }

    @Override
    public int hashCode() {
        return punto1.hashCode() + punto2.hashCode();
    }
}