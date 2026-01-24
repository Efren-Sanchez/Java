public class Circulo extends Curva {

    private double radio;

    // Constructor por defecto
    public Circulo() {
        super();
        this.radio = 1;
    }

    // Constructor con parámetros
    public Circulo(Punto centro, double radio, String color) {
        super(new Punto[]{centro}, color, "x^2 + y^2 = r^2", 0, 2 * Math.PI, 0.01);
        this.radio = radio;
        calcularPuntos();
    }

    // Constructor de copia
    public Circulo(Circulo otroCirculo) {
        super(otroCirculo);
        this.radio = otroCirculo.radio;
    }

    // Getter y Setter para el radio
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
        calcularPuntos();
    }

    // Métodos sobreescritos de la clase Curva
    @Override
    public Punto calcularPunto(double parametro) {
        double x = getCentroX() + radio * Math.cos(parametro);
        double y = getCentroY() + radio * Math.sin(parametro);
        return new Punto(x, y);
    }

    @Override
    public Punto[] calcularPuntos(int numeroPuntos) {
        Punto[] puntos = new Punto[numeroPuntos];
        double paso = 2 * Math.PI / numeroPuntos;
        for (int i = 0; i < numeroPuntos; i++) {
            puntos[i] = calcularPunto(i * paso);
        }
        this.puntos = puntos;
        return puntos;
    }

    private void calcularPuntos() {
        int numeroPuntos = (int) (2 * Math.PI / precision);
        calcularPuntos(numeroPuntos);
    }

    @Override
    public Punto calcularTangente(Punto punto) {
        double angulo = Math.atan2(punto.getY() - getCentroY(), punto.getX() - getCentroX()) + Math.PI / 2;
        return new Punto(Math.cos(angulo), Math.sin(angulo));
    }

    @Override
    public double calcularCurvatura(Punto punto) {
        return 1 / radio;
    }

    @Override
    public double calcularLongitudArco(double parametroInicial, double parametroFinal) {
        return radio * Math.abs(parametroFinal - parametroInicial);
    }

    @Override
    public boolean intersecta(Curva otraCurva) {
        if (otraCurva instanceof Circulo) {
            Circulo otroCirculo = (Circulo) otraCurva;
            double distanciaCentros = Calculable.calcularDistancia(new Punto(getCentroX(), getCentroY()), new Punto(otroCirculo.getCentroX(), otroCirculo.getCentroY()));
            return distanciaCentros <= radio + otroCirculo.radio;
        }
        // Implementación para otros tipos de curvas
        return false;
    }

    @Override
    public boolean intersecta(Recta recta) {
        // Distancia del centro del círculo a la recta
        double distanciaCentroRecta = recta.calcularDistanciaPunto(new Punto(getCentroX(), getCentroY()));

        // Si la distancia es menor o igual al radio, hay intersección
        return distanciaCentroRecta <= radio;
    }

    @Override
    public void simplificar(double tolerancia) {
        // Implementación para simplificar el círculo (no aplicable)
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    public double calcularLongitud() {
        return calcularPerimetro();
    }

    @Override
    public boolean contienePunto(Punto punto) {
        double distanciaCentroPunto = Calculable.calcularDistancia(new Punto(getCentroX(), getCentroY()), punto);
        return distanciaCentroPunto <= radio;
    }

    @Override
    public String toString() {
        return "Círculo [Centro: (" + getCentroX() + ", " + getCentroY() + "), Radio: " + radio + ", " + super.toString() + "]";
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
        Circulo otroCirculo = (Circulo) obj;
        return radio == otroCirculo.radio;
    }

    // Métodos adicionales
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }
}