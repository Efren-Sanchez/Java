public class Triangulo extends Poligono {

    // Constructores
    public Triangulo(Punto[] puntos, String color) {
        super(puntos, color);
        if (puntos == null || puntos.length != 3) {
            throw new IllegalArgumentException("Un triángulo debe tener 3 puntos.");
        }
    }

    public Triangulo(Triangulo otroTriangulo) {
        super(otroTriangulo);
    }

    // Métodos específicos
    public boolean esEquilatero() {
        double lado1 = Calculable.calcularDistancia(puntos[0], puntos[1]);
        double lado2 = Calculable.calcularDistancia(puntos[1], puntos[2]);
        double lado3 = Calculable.calcularDistancia(puntos[2], puntos[0]);
        return lado1 == lado2 && lado2 == lado3;
    }

    public boolean esIsosceles() {
        double lado1 = Calculable.calcularDistancia(puntos[0], puntos[1]);
        double lado2 = Calculable.calcularDistancia(puntos[1], puntos[2]);
        double lado3 = Calculable.calcularDistancia(puntos[2], puntos[0]);
        return lado1 == lado2 || lado1 == lado3 || lado2 == lado3;
    }

    public boolean esEscaleno() {
        double lado1 = Calculable.calcularDistancia(puntos[0], puntos[1]);
        double lado2 = Calculable.calcularDistancia(puntos[1], puntos[2]);
        double lado3 = Calculable.calcularDistancia(puntos[2], puntos[0]);
        return lado1 != lado2 && lado1 != lado3 && lado2 != lado3;
    }

    public boolean esRectangulo() {
        double lado1 = Calculable.calcularDistancia(puntos[0], puntos[1]);
        double lado2 = Calculable.calcularDistancia(puntos[1], puntos[2]);
        double lado3 = Calculable.calcularDistancia(puntos[2], puntos[0]);
        double lado1Sq = lado1 * lado1;
        double lado2Sq = lado2 * lado2;
        double lado3Sq = lado3 * lado3;
        return Math.abs(lado1Sq + lado2Sq - lado3Sq) < 1e-10 ||
               Math.abs(lado1Sq + lado3Sq - lado2Sq) < 1e-10 ||
               Math.abs(lado2Sq + lado3Sq - lado1Sq) < 1e-10;
    }

    // Métodos sobreescritos
    @Override
    public double calcularArea() {
        double lado1 = Calculable.calcularDistancia(puntos[0], puntos[1]);
        double lado2 = Calculable.calcularDistancia(puntos[1], puntos[2]);
        double lado3 = Calculable.calcularDistancia(puntos[2], puntos[0]);
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    public double calcularPerimetro() {
        double lado1 = Calculable.calcularDistancia(puntos[0], puntos[1]);
        double lado2 = Calculable.calcularDistancia(puntos[1], puntos[2]);
        double lado3 = Calculable.calcularDistancia(puntos[2], puntos[0]);
        return lado1 + lado2 + lado3;
    }

    @Override
    public boolean esConvexo() {
        return true; // Todos los triángulos son convexos
    }

    @Override
    public boolean esConcavo() {
        return false; // Ningún triángulo es cóncavo
    }

    @Override
    public double calcularApotema() {
        if (!esEquilatero()) {
            return 0.0; // La apotema solo se define para triángulos equiláteros
        }
        double lado = Calculable.calcularDistancia(puntos[0], puntos[1]);
        return lado / (2 * Math.sqrt(3));
        
        // return calcularArea() / calcularPerimetro() * 2;
    }

    @Override
    public String toString() {
        return "Triángulo [" + super.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Triangulo otroTriangulo = (Triangulo) obj;
        return super.equals(otroTriangulo);
    }
}