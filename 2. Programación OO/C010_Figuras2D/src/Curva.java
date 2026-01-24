public abstract class Curva extends Figura {

    protected String ecuacion;
    protected double parametroInicial;
    protected double parametroFinal;
    protected double precision;

    // Constructor por defecto
    public Curva() {
        super();
        this.ecuacion = "Sin ecuación";
        this.parametroInicial = 0;
        this.parametroFinal = 1;
        this.precision = 0.01;
    }

    // Constructor con parámetros
    public Curva(Punto[] puntos, String color, String ecuacion, double parametroInicial, double parametroFinal, double precision) {
        super(puntos, color);
        this.ecuacion = ecuacion;
        this.parametroInicial = parametroInicial;
        this.parametroFinal = parametroFinal;
        this.precision = precision;
    }

    // Constructor de copia
    public Curva(Curva otraCurva) {
        super(otraCurva);
        this.ecuacion = otraCurva.ecuacion;
        this.parametroInicial = otraCurva.parametroInicial;
        this.parametroFinal = otraCurva.parametroFinal;
        this.precision = otraCurva.precision;
    }

    // Getters y Setters
    public String getEcuacion() {
        return ecuacion;
    }

    public void setEcuacion(String ecuacion) {
        this.ecuacion = ecuacion;
    }

    public double getParametroInicial() {
        return parametroInicial;
    }

    public void setParametroInicial(double parametroInicial) {
        this.parametroInicial = parametroInicial;
    }

    public double getParametroFinal() {
        return parametroFinal;
    }

    public void setParametroFinal(double parametroFinal) {
        this.parametroFinal = parametroFinal;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    // Métodos sobreescritos de la clase Figura
    @Override
    public void rotar(double angulo) {
        double rad = Math.toRadians(angulo);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        for (int i = 0; i < puntos.length; i++) {
            double x = puntos[i].getX() - centroX;
            double y = puntos[i].getY() - centroY;
            puntos[i].setX(centroX + x * cos - y * sin);
            puntos[i].setY(centroY + x * sin + y * cos);
        }
    }

    @Override
    public boolean contienePunto(Punto punto) {
        // Implementación genérica (puede ser sobreescrita por subclases)
        // Por defecto, se asume que la curva no contiene ningún punto
        return false;
    }

    @Override
    public String toString() {
        StringBuilder puntosStr = new StringBuilder("[");
        if (puntos != null) {
            for (int i = 0; i < puntos.length; i++) {
                puntosStr.append("(").append(puntos[i].getX()).append(", ").append(puntos[i].getY()).append(")");
                if (i < puntos.length - 1) {
                    puntosStr.append(", ");
                }
            }
        }
        puntosStr.append("]");

        return "Curva ID: " + getId() + ", Color: " + getColor() + ", Centro: (" + getCentroX() + ", " + getCentroY() + "), Puntos: " + puntosStr.toString() + ", Ecuación: " + ecuacion + ", Rango: [" + parametroInicial + ", " + parametroFinal + "], Precisión: " + precision;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Curva otraCurva = (Curva) obj;
        return super.equals(otraCurva) &&
                ecuacion.equals(otraCurva.ecuacion) &&
                parametroInicial == otraCurva.parametroInicial &&
                parametroFinal == otraCurva.parametroFinal &&
                precision == otraCurva.precision;
    }

    public abstract double calcularPerimetro();

    public double calcularLongitud() {
        return calcularPerimetro();
    }

    // Métodos Adicionales
    public Punto calcularPunto(double parametro) {
        // Implementación específica en subclases
        return null;
    }

    public Punto[] calcularPuntos(int numeroPuntos) {
        // Implementación específica en subclases
        return null;
    }

    public Punto calcularTangente(Punto punto) {
        // Implementación específica en subclases
        return null;
    }

    public double calcularCurvatura(Punto punto) {
        // Implementación específica en subclases
        return 0;
    }

    public double calcularLongitudArco(double parametroInicial, double parametroFinal) {
        // Implementación específica en subclases
        return 0;
    }

    public boolean intersecta(Curva otraCurva) {
        // Implementación específica en subclases
        return false;
    }

    public boolean intersecta(Recta recta) {
        // Implementación específica en subclases
        return false;
    }

    public void simplificar(double tolerancia) {
        // Implementación específica en subclases
    }
}

/* ------------------------------------------------------------------------- */

/*
import java.util.Arrays;

public abstract class Curva extends Figura {

    protected String ecuacion;
    protected double parametroInicial;
    protected double parametroFinal;
    protected double precision;

    // Constructor por defecto
    public Curva() {
        super();
        this.ecuacion = "Sin ecuación";
        this.parametroInicial = 0;
        this.parametroFinal = 1;
        this.precision = 0.01;
    }

    // Constructor con parámetros (vector de puntos)
    public Curva(Punto[] puntos, String color, String ecuacion, double parametroInicial, double parametroFinal, double precision) {
        super(puntos, color);
        this.ecuacion = ecuacion;
        this.parametroInicial = parametroInicial;
        this.parametroFinal = parametroFinal;
        this.precision = precision;
    }

    // Constructor de copia
    public Curva(Curva otraCurva) {
        super(otraCurva);
        this.ecuacion = otraCurva.ecuacion;
        this.parametroInicial = otraCurva.parametroInicial;
        this.parametroFinal = otraCurva.parametroFinal;
        this.precision = otraCurva.precision;
    }

    // Getters y Setters
    public String getEcuacion() {
        return ecuacion;
    }

    public void setEcuacion(String ecuacion) {
        this.ecuacion = ecuacion;
    }

    public double getParametroInicial() {
        return parametroInicial;
    }

    public void setParametroInicial(double parametroInicial) {
        this.parametroInicial = parametroInicial;
    }

    public double getParametroFinal() {
        return parametroFinal;
    }

    public void setParametroFinal(double parametroFinal) {
        this.parametroFinal = parametroFinal;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
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
        // Implementación genérica (puede ser sobreescrita por subclases)
        // Por defecto, se asume que la curva no contiene ningún punto
        return false;
    }

    @Override
    public String toString() {
        return "Curva ID: " + getId() + ", Color: " + getColor() + ", Centro: (" + getCentroX() + ", " + getCentroY() + 
        "), Puntos: " + Arrays.toString(puntos) + ", Ecuación: " + ecuacion + ", Rango: [" + parametroInicial + ", " + 
        parametroFinal + "], Precisión: " + precision;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Curva otraCurva = (Curva) obj;
        return super.equals(otraCurva) && 
                ecuacion.equals(otraCurva.ecuacion) && 
                parametroInicial == otraCurva.parametroInicial && 
                parametroFinal == otraCurva.parametroFinal && 
                precision == otraCurva.precision;
    }

    // Métodos Adicionales
    public Punto calcularPunto(double parametro) {
        // Implementación específica en subclases
        return null;
    }

    public Punto[] calcularPuntos(int numeroPuntos) {
        // Implementación específica en subclases
        return null;
    }

    public Punto calcularTangente(Punto punto) {
        // Implementación específica en subclases
        return null;
    }

    public double calcularCurvatura(Punto punto) {
        // Implementación específica en subclases
        return 0;
    }

    public double calcularLongitudArco(double parametroInicial, double parametroFinal) {
        // Implementación específica en subclases
        return 0;
    }

    public boolean intersecta(Curva otraCurva) {
        // Implementación específica en subclases
        return false;
    }

    public boolean intersecta(Recta recta) {
        // Implementación específica en subclases
        return false;
    }

    public void simplificar(double tolerancia) {
        // Implementación específica en subclases
    }
}
*/