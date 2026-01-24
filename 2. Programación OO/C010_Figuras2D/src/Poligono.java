public abstract class Poligono extends Figura {

    protected double apotema;
    protected double[] angulosInternos;

    // Constructor por defecto
    public Poligono() {
        super();
        this.apotema = 0;
        this.angulosInternos = new double[0];
    }

    // Constructor con parámetros (vector de puntos)
    public Poligono(Punto[] puntos, String color) {
        super(puntos, color);
        if (esPoligonoValido(puntos)) {
            calcularCentroide();
            calcularApotema();
            calcularAngulosInternos();
        } else {
            throw new IllegalArgumentException("Los puntos dados no forman un polígono válido.");
        }
    }

    // Constructor de copia
    public Poligono(Poligono otroPoligono) {
        super(otroPoligono);
        this.apotema = otroPoligono.apotema;
        this.angulosInternos = otroPoligono.angulosInternos.clone();
    }

    // Método para obtener el número de lados
    public int getNumeroLados() {
        return puntos.length;
    }

    // Método para obtener los vértices
    public Punto[] getVertices() {
        return super.getPuntos();
    }

    public boolean esConvexo() {
        if (puntos == null || puntos.length < 3) {
            return false; // Un polígono con menos de 3 puntos no puede ser convexo
        }
        for (int i = 0; i < puntos.length; i++) {
            Punto p1 = puntos[i];
            Punto p2 = puntos[(i + 1) % puntos.length];
            Punto p3 = puntos[(i + 2) % puntos.length];
            if (Calculable.calcularProductoCruz(p1, p2, p3) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean esConcavo() {
        return !esConvexo();
    }


    public double getApotema() {
        return apotema;
    }

    public double[] getAngulosInternos() {
        return angulosInternos.clone();
    }

    // Métodos sobreescritos de la clase Figura
    @Override
    public void rotar(double angulo) {
        double rad = Math.toRadians(angulo);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        for (Punto punto : puntos) {
            double x = punto.getX() - centroX;
            double y = punto.getY() - centroY;
            punto.setX(centroX + x * cos - y * sin);
            punto.setY(centroY + x * sin + y * cos);
        }
    }

    @Override
    public boolean contienePunto(Punto punto) {
        // Implementación genérica usando el método de ray casting
        int intersecciones = 0;
        for (int i = 0; i < puntos.length; i++) {
            Punto p1 = puntos[i];
            Punto p2 = puntos[(i + 1) % puntos.length];

            if (((p1.getY() <= punto.getY() && punto.getY() < p2.getY()) ||
                    (p2.getY() <= punto.getY() && punto.getY() < p1.getY())) &&
                    punto.getX() < (p2.getX() - p1.getX()) * (punto.getY() - p1.getY()) / (p2.getY() - p1.getY()) + p1.getX()) {
                intersecciones++;
            }
        }
        return intersecciones % 2 != 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Polígono ID: ").append(getId()).append(", Color: ").append(getColor()).append(", Centro: (").append(getCentroX()).append(", ").append(getCentroY()).append("), Lados: ").append(getNumeroLados()).append(", Puntos: [");
        if (puntos != null) {
            for (int i = 0; i < puntos.length; i++) {
                sb.append(puntos[i].toString());
                if (i < puntos.length - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append("], Apotema: ").append(apotema).append(", Ángulos: [");
        if (angulosInternos != null) {
            for (int i = 0; i < angulosInternos.length; i++) {
                sb.append(angulosInternos[i]);
                if (i < angulosInternos.length - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Poligono otroPoligono = (Poligono) obj;
        if (!super.equals(otroPoligono)) {
            return false;
        }
        if (Double.compare(apotema, otroPoligono.apotema) != 0) {
            return false;
        }
        if (angulosInternos.length != otroPoligono.angulosInternos.length) {
            return false;
        }
        for (int i = 0; i < angulosInternos.length; i++) {
            if (Double.compare(angulosInternos[i], otroPoligono.angulosInternos[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    // Métodos adicionales
    private boolean esPoligonoValido(Punto[] puntos) {
        if (puntos == null || puntos.length < 3) {
            return false;
        }
        // Implementación para verificar la validez de la forma
        // ...
        return true;
    }

    private void calcularCentroide() {
        if (puntos == null || puntos.length == 0) {
            return;
        }
        double sumaX = 0;
        double sumaY = 0;
        for (Punto punto : puntos) {
            sumaX += punto.getX();
            sumaY += punto.getY();
        }
        centroX = sumaX / puntos.length;
        centroY = sumaY / puntos.length;
    }

    public abstract double calcularApotema();

    private void calcularAngulosInternos() {
        if (puntos == null || puntos.length < 3) {
            return;
        }
        angulosInternos = new double[puntos.length];
        for (int i = 0; i < puntos.length; i++) {
            Punto p1 = puntos[i];
            Punto p2 = puntos[(i + 1) % puntos.length];
            Punto p3 = puntos[(i + 2) % puntos.length];

            double angulo = Math.toDegrees(Math.atan2(p3.getY() - p2.getY(), p3.getX() - p2.getX()) -
                    Math.atan2(p1.getY() - p2.getY(), p1.getX() - p2.getX()));

            angulosInternos[i] = (angulo + 360) % 360; // Asegurar ángulo positivo
        }
    }
}

/* ------------------------------------------------------------------------- */

/*
import java.util.Arrays;

public abstract class Poligono extends Figura {

    protected double apotema;
    protected double[] angulosInternos;

    // Constructor por defecto
    public Poligono() {
        super();
        this.apotema = 0;
        this.angulosInternos = new double[0];
    }

    // Constructor con parámetros (vector de puntos)
    public Poligono(Punto[] puntos, String color) {
        super(puntos, color);
        if (esPoligonoValido(puntos)) {
            calcularCentroide();
            calcularApotema();
            calcularAngulosInternos();
        } else {
            throw new IllegalArgumentException("Los puntos dados no forman un polígono válido.");
        }
    }

    // Constructor de copia
    public Poligono(Poligono otroPoligono) {
        super(otroPoligono);
        this.apotema = otroPoligono.apotema;
        this.angulosInternos = otroPoligono.angulosInternos.clone();
    }

    // Método para obtener el número de lados
    public int getNumeroLados() {
        return puntos.length;
    }

    // Método para obtener los vértices
    public Punto[] getVertices() {
        return super.getPuntos();
    }

    // Métodos abstractos adicionales (implementados por las subclases)
    public abstract boolean esConvexo();

    public abstract boolean esConcavo();

    public double getApotema() {
        return apotema;
    }

    public double[] getAngulosInternos() {
        return angulosInternos.clone();
    }

    // Métodos sobreescritos de la clase Figura
    @Override
    public void rotar(double angulo) {
        double rad = Math.toRadians(angulo);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        for (Punto punto : puntos) {
            double x = punto.getX() - centroX;
            double y = punto.getY() - centroY;
            punto.setX(centroX + x * cos - y * sin);
            punto.setY(centroY + x * sin + y * cos);
        }
    }

    @Override
    public boolean contienePunto(Punto punto) {
        // Implementación genérica usando el método de ray casting
        int intersecciones = 0;
        for (int i = 0; i < puntos.length; i++) {
            Punto p1 = puntos[i];
            Punto p2 = puntos[(i + 1) % puntos.length];

            if (((p1.getY() <= punto.getY() && punto.getY() < p2.getY()) ||
                    (p2.getY() <= punto.getY() && punto.getY() < p1.getY())) &&
                    punto.getX() < (p2.getX() - p1.getX()) * (punto.getY() - p1.getY()) / (p2.getY() - p1.getY()) + p1.getX()) {
                intersecciones++;
            }
        }
        return intersecciones % 2 != 0;
    }

    @Override
    public String toString() {
        return "Polígono ID: " + getId() + ", Color: " + getColor() + ", Centro: (" + getCentroX() + ", " + getCentroY() + 
                "), Lados: " + getNumeroLados() + ", Puntos: " + Arrays.toString(puntos) + ", Apotema: " + apotema + 
                ", Ángulos: " + Arrays.toString(angulosInternos);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Poligono otroPoligono = (Poligono) obj;
        return super.equals(otroPoligono) && apotema == otroPoligono.apotema && Arrays.equals(angulosInternos, otroPoligono.angulosInternos);
    }

    // Métodos adicionales
    private boolean esPoligonoValido(Punto[] puntos) {
        if (puntos == null || puntos.length < 3) {
            return false;
        }
        // Implementación para verificar la validez de la forma
        // ...
        return true;
    }

    private void calcularCentroide() {
        if (puntos == null || puntos.length == 0) {
            return;
        }
        double sumaX = 0;
        double sumaY = 0;
        for (Punto punto : puntos) {
            sumaX += punto.getX();
            sumaY += punto.getY();
        }
        centroX = sumaX / puntos.length;
        centroY = sumaY / puntos.length;
    }

    public abstract double calcularApotema();

    private void calcularAngulosInternos() {
        if (puntos == null || puntos.length < 3) {
            return;
        }
        angulosInternos = new double[puntos.length];
        for (int i = 0; i < puntos.length; i++) {
            Punto p1 = puntos[i];
            Punto p2 = puntos[(i + 1) % puntos.length];
            Punto p3 = puntos[(i + 2) % puntos.length];

            double angulo = Math.toDegrees(Math.atan2(p3.getY() - p2.getY(), p3.getX() - p2.getX()) -
                    Math.atan2(p1.getY() - p2.getY(), p1.getX() - p2.getX()));

            angulosInternos[i] = (angulo + 360) % 360; // Asegurar ángulo positivo
        }
    }
}
*/