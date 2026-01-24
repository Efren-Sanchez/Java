public class Hexagono extends Poligono {

    // Constructores
    public Hexagono() {
        super();
    }

    public Hexagono(Punto[] puntos, String color) {
        super(puntos, color);
        if (puntos == null || puntos.length != 6) {
            throw new IllegalArgumentException("Un hexágono debe tener 6 puntos.");
        }
    }

    public Hexagono(Hexagono otroHexagono) {
        super(otroHexagono);
    }

    // Métodos sobreescritos
    @Override
    public double calcularArea() {
        if (esRegular()) {
            return calcularPerimetro() * calcularApotema() / 2;
        } else {
            return calcularAreaIrregular();
        }
    }

    private double calcularAreaIrregular() {
        double area = 0;
        Punto centroide = calcularCentroide();
        for (int i = 0; i < puntos.length; i++) {
            Punto p1 = puntos[i];
            Punto p2 = puntos[(i + 1) % puntos.length];
            area += Calculable.calcularProductoCruz(centroide, p1, p2) / 2.0;
        }
        return Math.abs(area);
    }

    @Override
    public double calcularPerimetro() {
        double perimetro = 0;
        for (int i = 0; i < puntos.length; i++) {
            perimetro += Calculable.calcularDistancia(puntos[i], puntos[(i + 1) % puntos.length]);
        }
        return perimetro;
    }

    @Override
    public double calcularApotema() {
        if (!esRegular()) {
            return calcularApotemaIrregular();
        }
        double lado = Calculable.calcularDistancia(puntos[0], puntos[1]);
        return lado * Math.sqrt(3) / 2;
    }

    private double calcularApotemaIrregular() {
        double sumaDistancias = 0;
        Punto centroide = calcularCentroide();
        for (int i = 0; i < puntos.length; i++) {
            Punto p1 = puntos[i];
            Punto p2 = puntos[(i + 1) % puntos.length];
            Recta lado = new Recta(p1, p2);
            sumaDistancias += lado.calcularDistanciaPunto(centroide);
        }
        return sumaDistancias / 6;
    }

    @Override
    public String toString() {
        return "Hexágono [" + super.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Hexagono otroHexagono = (Hexagono) obj;
        return super.equals(otroHexagono);
    }

    // Método para verificar si el hexágono es regular
    private boolean esRegular() {
        double lado1 = Calculable.calcularDistancia(puntos[0], puntos[1]);
        double angulo1 = angulosInternos[0];
        for (int i = 1; i < puntos.length; i++) {
            double lado2 = Calculable.calcularDistancia(puntos[i], puntos[(i + 1) % puntos.length]);
            double angulo2 = angulosInternos[i];
            if (Math.abs((lado1 - lado2) / lado1) > 1e-10 || Math.abs(angulo1 - angulo2) > 1e-10) {
                return false;
            }
        }
        return true;
    }

    private Punto calcularCentroide() {
        double sumaX = 0;
        double sumaY = 0;
        for (Punto punto : puntos) {
            sumaX += punto.getX();
            sumaY += punto.getY();
        }
        return new Punto(sumaX / 6, sumaY / 6);
    }
}