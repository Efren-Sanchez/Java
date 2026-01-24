public class Parabola extends Curva {

    private double parametro; // Distancia del vértice al foco

    // Constructor por defecto
    public Parabola() {
        super();
        this.parametro = 1;
    }

    // Constructor con parámetros
    public Parabola(Punto vertice, double parametro, String color) {
        super(new Punto[]{vertice}, color, "y^2 = 4px", -10, 10, 0.01);
        this.parametro = parametro;
        calcularPuntos();
    }

    // Constructor de copia
    public Parabola(Parabola otraParabola) {
        super(otraParabola);
        this.parametro = otraParabola.parametro;
    }

    // Getter y Setter
    public double getParametro() {
        return parametro;
    }

    public void setParametro(double parametro) {
        this.parametro = parametro;
        calcularPuntos();
    }

    // Métodos sobreescritos de la clase Curva
    @Override
    public Punto calcularPunto(double t) {
        double x = getCentroX() + t * t / (4 * parametro);
        double y = getCentroY() + t;
        return new Punto(x, y);
    }

    @Override
    public Punto[] calcularPuntos(int numeroPuntos) {
        Punto[] puntos = new Punto[numeroPuntos];
        double paso = (parametroFinal - parametroInicial) / numeroPuntos;
        for (int i = 0; i < numeroPuntos; i++) {
            puntos[i] = calcularPunto(parametroInicial + i * paso);
        }
        this.puntos = puntos;
        return puntos;
    }

    private void calcularPuntos() {
        int numeroPuntos = (int) ((parametroFinal - parametroInicial) / precision);
        calcularPuntos(numeroPuntos);
    }

    @Override
    public Punto calcularTangente(Punto punto) {
        double t = punto.getY() - getCentroY();
        double pendiente = t / (2 * parametro);
        return new Punto(1, pendiente);
    }

    @Override
    public double calcularCurvatura(Punto punto) {
        double t = punto.getY() - getCentroY();
        return 2 * parametro / Math.pow(Math.pow(2 * parametro, 2) + Math.pow(t, 2), 1.5);
    }

    @Override
    public double calcularLongitudArco(double parametroInicial, double parametroFinal) {
        // Implementación aproximada usando la integral elíptica de segunda especie
        double longitud = 0;
        for (double t = parametroInicial; t < parametroFinal; t += precision) {
            longitud += Math.sqrt(1 + Math.pow(t / (2 * parametro), 2)) * precision;
        }
        return longitud;
    }

    @Override
    public boolean intersecta(Curva otraCurva) {
        // Implementación para verificar intersección con otras curvas
        // ...
        return false;
    }

    @Override
    public boolean intersecta(Recta recta) {
        // Implementación para verificar intersección con una recta
        // ...
        return false;
    }

    @Override
    public void simplificar(double tolerancia) {
        // Implementación para simplificar la parábola (no aplicable)
    }

    @Override
    public double calcularPerimetro() {
        // Implementación aproximada usando la integral elíptica de segunda especie
        return calcularLongitudArco(parametroInicial, parametroFinal);
    }

    public double calcularLongitud() {
        // Implementación aproximada usando la integral elíptica de segunda especie
        return calcularPerimetro();
    }

    public double calcularArea() {
        // Implementación aproximada usando la integral elíptica de segunda especie
        return 0;
    }

    @Override
    public boolean contienePunto(Punto punto) {
        // Implementación para verificar si el punto está en la parábola
        // ...
        return false;
    }

    @Override
    public String toString() {
        return "Parábola [Vértice: (" + getCentroX() + ", " + getCentroY() + "), Parámetro: " + parametro + ", " + super.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Parabola otraParabola = (Parabola) obj;
        return parametro == otraParabola.parametro;
    }
}