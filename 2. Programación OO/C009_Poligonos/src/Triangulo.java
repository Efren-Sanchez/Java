public class Triangulo extends Poligono implements Dibujable, Calculable {
    // Constructores
    public Triangulo() {
        super(3);
    }

    public Triangulo(Punto p1, Punto p2, Punto p3) {
        super(3);
        this.getPuntos()[0] = p1;
        this.getPuntos()[1] = p2;
        this.getPuntos()[2] = p3;
    }

    public Triangulo(Punto [] puntos) {
        super(3, puntos);
    }

    public Triangulo(Triangulo t) {
        super(t);
        //super(3, t.getPuntos());
    }

    @Override
    public String toString() {
        String salida = "Triángulo: ";
        for (int i = 0; i < this.getNumLados(); i++) {
            salida += this.getPuntos()[i].toString() + ", ";
        }
        return salida;
    }

    // Interfaces
    @Override
    public void dibujar() {
        System.out.println("Dibujo un triángulo");
    } 

    @Override
    public double calcularArea() {
        return Math.abs(getPuntos()[0].getX()*(getPuntos()[1].getY() - getPuntos()[2].getY()) 
            + getPuntos()[1].getX()*(getPuntos()[2].getY() - getPuntos()[0].getY()) 
            + getPuntos()[2].getX()*(getPuntos()[0].getY() - getPuntos()[1].getY())) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return getPuntos()[0].calcularDistancia(getPuntos()[1]) + 
                Punto.calcularDistancia(getPuntos()[1], getPuntos()[2]) +
                Punto.calcularDistancia(getPuntos()[2].getX(), getPuntos()[2].getY(), getPuntos()[0].getX(), getPuntos()[0].getY());
        /*
        return getPuntos()[0].calcularDistancia(getPuntos()[1]) + 
                getPuntos()[1].calcularDistancia(getPuntos()[2]) + 
                getPuntos()[2].calcularDistancia(getPuntos()[0]) + 
        */
    }

    public static void main(String[] args) {
        Triangulo t1 = new Triangulo();
        
        Punto p1 = new Punto(1, 1);
        Punto p2 = new Punto(3, 3);
        Punto p3 = new Punto(-1, 5);
        Triangulo t2 = new Triangulo(p1, p2, p3);
        System.out.println(t2.toString());
        
        Punto [] puntos = new Punto[3];
        puntos[0] = p1;
        puntos[1] = p2;
        puntos[2] = p3;
        Triangulo t3 = new Triangulo(puntos);
        System.out.println(t3.toString());
        
        Triangulo t4 = new Triangulo(t3);
        System.out.println(t4.toString());
        
        t1.setNumLados(3);
        t1.setPuntos(puntos);
        System.out.println(t1.toString());
        
        System.out.println("El area del triángulo t1 es: " + t1.calcularArea());
        System.out.println("El perímetro del triángulo t1 es: " + t1.calcularPerimetro());
    }
}
