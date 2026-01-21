public class Circulo extends Poligono implements Calculable, Dibujable {
    private double radio;

    public Circulo() {
        super(1);
        this.radio = 0;
    }

    public Circulo(double radio) {
        super(1);
        this.radio = radio;
        this.getPuntos()[0] = new Punto(0, 0);
    }

    public Circulo(double radio, Punto centro) {
        super(1);
        this.radio = radio;
        this.getPuntos()[0] = centro;
    }

    public Circulo(Circulo c) {
        super(c);
        this.radio = c.radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setCentro(Punto p) {
        this.getPuntos()[0] = p;
    }

    public void setCentro(int x, int y) {
        this.getPuntos()[0] = new Punto(x, y);
    }

    @Override
    public String toString() {
        return "Círculo: Centro " + this.getPuntos()[0].toString() + " - Radio: " + this.radio;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;
        Circulo c = (Circulo) obj;
        return this.radio == c.radio && this.getPuntos()[0].equals(c.getPuntos()[0]);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujo un círculo");
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * this.radio;    
    }

    // Pruebas unitarias
    public static void main(String[] args) {
        Circulo c1 = new Circulo();
        Punto p1 = new Punto(1, 1);
        c1.setRadio(2);
        c1.setCentro(p1);
        System.out.println(c1.toString());
        
        Circulo c2 = new Circulo(5);
        System.out.println(c2.toString());
        
        Circulo c3 = new Circulo(5, p1);
        System.out.println(c3.toString());
        
        Circulo c4 = new Circulo(5, new Punto(2, 2));
        System.out.println(c4.toString());
        
        Circulo c5 = new Circulo(c4);
        System.out.println(c5.toString());

        if (c5.equals(c4)) System.out.println("Los círculos c5 y c4 son iguales.");
        else System.out.println("Los círculos c5 y c4 NO son iguales.");

        if (c1.equals(c2)) System.out.println("Los círculos c1 y c2 son iguales.");
        else System.out.println("Los círculos c1 y c2 NO son iguales.");

        System.out.println("El perímetro del círculo c1 es: " + c1.calcularPerimetro());
        System.out.println("El área del círculo c1 es: " + c1.calcularArea());
        System.out.println("El perímetro del círculo c2 es: " + c2.calcularPerimetro());
        System.out.println("El área del círculo c2 es: " + c2.calcularArea());
        
        c3.dibujar();
        c5.dibujar();
    }
}
