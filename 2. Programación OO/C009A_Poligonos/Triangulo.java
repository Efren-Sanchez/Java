// 👁️: La clase no requiere atributos adicionales a los definidos en la clase Polígono.

public class Triangulo extends Poligono implements Dibujable, Calculable {
    
    /* Constructores */
    public Triangulo(Punto p1, Punto p2, Punto p3) {
        super(new Punto[]{p1, p2, p3}, 3);
    }

    public Triangulo(Triangulo t) {
        super(t);
    }

    /* Getters y Setters */
    public Punto getPunto(int index) {
        if (index >= 0 && index < 3) return puntos[index];
        else throw new IllegalArgumentException("Índice fuera de rango (0-2)");
    }

    public void setPunto(int index, Punto p) {
        if (index >= 0 && index < 3) puntos[index] = new Punto(p);
        else throw new IllegalArgumentException("Índice fuera de rango (0-2)");
    }

    /* Métodos de cálculo */
    @Override
    public double calcularArea() {
        double x1 = puntos[0].getX(), y1 = puntos[0].getY();
        double x2 = puntos[1].getX(), y2 = puntos[1].getY();
        double x3 = puntos[2].getX(), y3 = puntos[2].getY();

        // Fórmula del área de un triángulo con coordenadas
        return 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    }

    @Override
    public double calcularPerimetro() {
        double lado1 = distancia(puntos[0], puntos[1]);
        double lado2 = distancia(puntos[1], puntos[2]);
        double lado3 = distancia(puntos[2], puntos[0]);
        return lado1 + lado2 + lado3;
    }

    private double distancia(Punto p1, Punto p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    /* Métodos de la interfaz Dibujar */
    @Override
    public void lineaRecta(Punto p1, Punto p2) {
        System.out.println("Dibujando línea recta de " + p1 + " a " + p2);
    }

    @Override
    public void lineaCurva(Punto p1, Punto p2, Punto control) {
        System.out.println("Dibujando línea curva de " + p1 + " a " + p2 + " con punto de control " + control);
    }

    /* Método de representación */
    @Override
    public void dibujar() {
        System.out.println("Dibujando " + getClass().getSimpleName() + " en la consola:");
        lineaRecta(puntos[0], puntos[1]);
        lineaRecta(puntos[1], puntos[2]);
        lineaRecta(puntos[2], puntos[0]);
    }

     /* Métodos comunes */
     @Override
     public String toString() {
         return super.toString() + " (Área: " + calcularArea() + ", Perímetro: " + calcularPerimetro() + ")";
     }
 
     @Override
     public boolean equals(Object obj) {
         if (!super.equals(obj)) return false;
         return obj instanceof Triangulo;
     }
}
