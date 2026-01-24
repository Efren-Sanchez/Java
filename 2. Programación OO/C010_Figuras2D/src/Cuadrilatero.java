public class Cuadrilatero extends Poligono {

    // Constructores
    public Cuadrilatero() {
        super();
    }

    public Cuadrilatero(Punto[] puntos, String color) {
        super(puntos, color);
        if (puntos == null || puntos.length != 4) {
            throw new IllegalArgumentException("Un cuadrilátero debe tener 4 puntos.");
        }
    }

    public Cuadrilatero(Cuadrilatero otroCuadrilatero) {
        super(otroCuadrilatero);
    }

    // Métodos específicos
    public boolean esParalelogramo() {
        double lado1 = Calculable.calcularDistancia(puntos[0], puntos[1]);
        double lado2 = Calculable.calcularDistancia(puntos[1], puntos[2]);
        double lado3 = Calculable.calcularDistancia(puntos[2], puntos[3]);
        double lado4 = Calculable.calcularDistancia(puntos[3], puntos[0]);
        return lado1 == lado3 && lado2 == lado4;
    }

    public boolean esTrapecio() {
        Recta lado1 = new Recta(puntos[0], puntos[1]);
        Recta lado2 = new Recta(puntos[2], puntos[3]);
        Recta lado3 = new Recta(puntos[1], puntos[2]);
        Recta lado4 = new Recta(puntos[3], puntos[0]);

        return (lado1.calcularPendiente() == lado2.calcularPendiente()) ||
               (lado3.calcularPendiente() == lado4.calcularPendiente());
    }

    public boolean esTrapezoide() {
        return !esParalelogramo() && !esTrapecio();
    }

    public boolean esCuadrado() {
        double lado1 = Calculable.calcularDistancia(puntos[0], puntos[1]);
        double lado2 = Calculable.calcularDistancia(puntos[1], puntos[2]);
        double lado3 = Calculable.calcularDistancia(puntos[2], puntos[3]);
        double lado4 = Calculable.calcularDistancia(puntos[3], puntos[0]);
        double diagonal1 = Calculable.calcularDistancia(puntos[0], puntos[2]);
        double diagonal2 = Calculable.calcularDistancia(puntos[1], puntos[3]);

        return lado1 == lado2 && lado2 == lado3 && lado3 == lado4 && diagonal1 == diagonal2;
    }

    public boolean esRectangulo() {
        double lado1 = Calculable.calcularDistancia(puntos[0], puntos[1]);
        double lado2 = Calculable.calcularDistancia(puntos[1], puntos[2]);
        double lado3 = Calculable.calcularDistancia(puntos[2], puntos[3]);
        double lado4 = Calculable.calcularDistancia(puntos[3], puntos[0]);
        double diagonal1 = Calculable.calcularDistancia(puntos[0], puntos[2]);
        double diagonal2 = Calculable.calcularDistancia(puntos[1], puntos[3]);

        return lado1 == lado3 && lado2 == lado4 && diagonal1 == diagonal2;
    }

    public boolean esRombo() {
        double lado1 = Calculable.calcularDistancia(puntos[0], puntos[1]);
        double lado2 = Calculable.calcularDistancia(puntos[1], puntos[2]);
        double lado3 = Calculable.calcularDistancia(puntos[2], puntos[3]);
        double lado4 = Calculable.calcularDistancia(puntos[3], puntos[0]);

        return lado1 == lado2 && lado2 == lado3 && lado3 == lado4;
    }

    // Métodos sobreescritos
    @Override
    public double calcularArea() {
        // Usando la fórmula de Brahmagupta para cuadriláteros cíclicos (inscriptibles)
        double lado1 = Calculable.calcularDistancia(puntos[0], puntos[1]);
        double lado2 = Calculable.calcularDistancia(puntos[1], puntos[2]);
        double lado3 = Calculable.calcularDistancia(puntos[2], puntos[3]);
        double lado4 = Calculable.calcularDistancia(puntos[3], puntos[0]);
        double s = (lado1 + lado2 + lado3 + lado4) / 2;
        return Math.sqrt((s - lado1) * (s - lado2) * (s - lado3) * (s - lado4));
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
        return 0; // La apotema no se define para cuadriláteros en general
    }

    @Override
    public String toString() {
        return "Cuadrilátero [" + super.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cuadrilatero otroCuadrilatero = (Cuadrilatero) obj;
        return super.equals(otroCuadrilatero);
    }

    // Getters y Setters (heredados de Poligono)
    // ...
}