public class Arco extends Curva {

    private double radio;
    private double anguloInicial;
    private double anguloFinal;

    // Constructor por defecto
    public Arco() {
        super();
        this.radio = 1;
        this.anguloInicial = 0;
        this.anguloFinal = Math.PI / 2;
    }

    // Constructor con parámetros
    public Arco(Punto centro, double radio, double anguloInicial, double anguloFinal, String color) {
        super(new Punto[]{centro}, color, "Arco de circunferencia", anguloInicial, anguloFinal, 0.01);
        this.radio = radio;
        this.anguloInicial = anguloInicial;
        this.anguloFinal = anguloFinal;
        calcularPuntos();
    }

    // Constructor de copia
    public Arco(Arco otroArco) {
        super(otroArco);
        this.radio = otroArco.radio;
        this.anguloInicial = otroArco.anguloInicial;
        this.anguloFinal = otroArco.anguloFinal;
    }

    // Getters y Setters
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
        calcularPuntos();
    }

    public double getAnguloInicial() {
        return anguloInicial;
    }

    public void setAnguloInicial(double anguloInicial) {
        this.anguloInicial = anguloInicial;
        calcularPuntos();
    }

    public double getAnguloFinal() {
        return anguloFinal;
    }

    public void setAnguloFinal(double anguloFinal) {
        this.anguloFinal = anguloFinal;
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
        double paso = (anguloFinal - anguloInicial) / numeroPuntos;
        for (int i = 0; i < numeroPuntos; i++) {
            puntos[i] = calcularPunto(anguloInicial + i * paso);
        }
        this.puntos = puntos;
        return puntos;
    }

    private void calcularPuntos() {
        int numeroPuntos = (int) (Math.abs(anguloFinal - anguloInicial) / precision);
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
        // Implementación para simplificar el arco (no aplicable)
    }

    // No aplica para esta figura
    @Override
    public double calcularArea() {
        return 0;
    }

    @Override
    public double calcularPerimetro() {
        return radio * Math.abs(anguloFinal - anguloInicial);
    }

    public double calcularLongitud() {
        return calcularPerimetro();
    }

    @Override
    public boolean contienePunto(Punto punto) {
        // Implementación para verificar si el punto está en el arco
        // ...
        return false;
    }

    @Override
    public String toString() {
        return "Arco [Centro: (" + getCentroX() + ", " + getCentroY() + "), Radio: " + radio + ", Ángulo Inicial: " + anguloInicial + ", Ángulo Final: " + anguloFinal + ", " + super.toString() + "]";
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
        Arco otroArco = (Arco) obj;
        return radio == otroArco.radio && anguloInicial == otroArco.anguloInicial && anguloFinal == otroArco.anguloFinal;
    }
}