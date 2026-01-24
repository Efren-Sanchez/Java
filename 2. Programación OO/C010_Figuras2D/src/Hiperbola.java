public class Hiperbola extends Curva {

    private double a; // Semieje mayor
    private double b; // Semieje menor

    // Constructor por defecto
    public Hiperbola() {
        super();
        this.a = 1;
        this.b = 1;
    }

    // Constructor con parámetros
    public Hiperbola(Punto centro, double a, double b, String color) {
        super(new Punto[]{centro}, color, "x^2/a^2 - y^2/b^2 = 1", -10, 10, 0.01);
        this.a = a;
        this.b = b;
        calcularPuntos();
    }

    // Constructor de copia
    public Hiperbola(Hiperbola otraHiperbola) {
        super(otraHiperbola);
        this.a = otraHiperbola.a;
        this.b = otraHiperbola.b;
    }

    // Getters y Setters
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
        calcularPuntos();
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
        calcularPuntos();
    }

    // Métodos sobreescritos de la clase Curva
    @Override
    public Punto calcularPunto(double t) {
        double x = getCentroX() + a * Math.cosh(t);
        double y = getCentroY() + b * Math.sinh(t);
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

    public static double acosh(double x) {
        return Math.log(x + Math.sqrt(x * x - 1.0));
    }

    @Override
    public Punto calcularTangente(Punto punto) {
        //double t = Math.acosh((punto.getX() - getCentroX()) / a); // No disponoble en mi versión del JDK
        double t = acosh((punto.getX() - getCentroX()) / a); 
        double pendiente = (b * Math.cosh(t)) / (a * Math.sinh(t));
        return new Punto(1, pendiente);
    }

    @Override
    public double calcularCurvatura(Punto punto) {
        //double t = Math.acosh((punto.getX() - getCentroX()) / a); // No disponoble en mi versión del JDK
        double t = acosh((punto.getX() - getCentroX()) / a); 
        return (a * b) / Math.pow(Math.pow(b * Math.cosh(t), 2) - Math.pow(a * Math.sinh(t), 2), 1.5);
    }

    @Override
    public double calcularLongitudArco(double parametroInicial, double parametroFinal) {
        // Implementación aproximada usando la integral elíptica de segunda especie
        double longitud = 0;
        for (double t = parametroInicial; t < parametroFinal; t += precision) {
            longitud += Math.sqrt(Math.pow(a * Math.sinh(t), 2) + Math.pow(b * Math.cosh(t), 2)) * precision;
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
        // Implementación para simplificar la hipérbola (no aplicable)
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

    @Override
    public double calcularArea() {
        // Implementación aproximada usando la integral elíptica de segunda especie
        return 0;
    }

    @Override
    public boolean contienePunto(Punto punto) {
        double x = punto.getX() - getCentroX();
        double y = punto.getY() - getCentroY();
        return Math.pow(x / a, 2) - Math.pow(y / b, 2) >= 1;
    }

    @Override
    public String toString() {
        return "Hipérbola [Centro: (" + getCentroX() + ", " + getCentroY() + "), Semieje Mayor: " + a + ", Semieje Menor: " + b + ", " + super.toString() + "]";
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
        Hiperbola otraHiperbola = (Hiperbola) obj;
        return a == otraHiperbola.a && b == otraHiperbola.b;
    }
}