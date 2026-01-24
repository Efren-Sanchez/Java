// 👁️: La clase no requiere atributos adicionales a los definidos en la clase Polígono.

public class Rectangulo extends Poligono implements Dibujable, Calculable {

    /* Constructores */
    public Rectangulo(Punto p1, Punto p2, Punto p3, Punto p4) {
        super(new Punto[]{p1, p2, p3, p4}, 4);
    }

    public Rectangulo(Rectangulo r) {
        super(r);
    }

     /* Getters y Setters */
     public Punto getPunto(int index) {
        if (index >= 0 && index < 4) return puntos[index];
        else throw new IllegalArgumentException("Índice fuera de rango (0-3)");
    }

    public void setPunto(int index, Punto p) {
        if (index >= 0 && index < 4) puntos[index] = new Punto(p);
        else throw new IllegalArgumentException("Índice fuera de rango (0-3)");
    }

    /* Métodos de cálculo */
    @Override
    public double calcularArea() {
        double base = Math.abs(puntos[0].getX() - puntos[1].getX());
        double altura = Math.abs(puntos[1].getY() - puntos[2].getY());
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        double base = Math.abs(puntos[0].getX() - puntos[1].getX());
        double altura = Math.abs(puntos[1].getY() - puntos[2].getY());
        return 2 * (base + altura);
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
        lineaRecta(puntos[2], puntos[3]);
        lineaRecta(puntos[3], puntos[0]);
    }

     /* Métodos comunes */
     @Override
     public String toString() {
         return super.toString() + " (Área: " + calcularArea() + ", Perímetro: " + calcularPerimetro() + ")";
     }
 
     @Override
     public boolean equals(Object obj) {
         if (!super.equals(obj)) return false;
         return obj instanceof Rectangulo;
     }
}
