package es.medac.alu.ftt0003;

public class Elipse extends Poligono implements Dibujable, Calculable {
    private double radio;

    public Elipse(Punto centro1, Punto centro2, double radio) {
        super(new Punto[]{centro1, centro2});
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Elipse: Centros en " + getPuntos()[0] + " y " + getPuntos()[1] + ", Radio: " + radio;
    }

    @Override
    public void lineaRecta(Punto p1, Punto p2) {
        System.out.println("Línea recta de " + p1 + " a " + p2);
    }

    @Override
    public void lineaCurva(Punto p1, Punto p2, Punto control) {
        System.out.println("Curva de " + p1 + " a " + p2 + " con control en " + control);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando elipse:");
        Punto centro1 = getPuntos()[0];
        Punto centro2 = getPuntos()[1];
        lineaCurva(centro1, centro2, new Punto(centro1.getX() + radio, centro1.getY()));
        lineaCurva(centro2, centro1, new Punto(centro2.getX() - radio, centro2.getY()));
    }

    @Override
    public double calcularArea() {
        double distancia = Math.sqrt(Math.pow(getPuntos()[0].getX() - getPuntos()[1].getX(), 2) +
                Math.pow(getPuntos()[0].getY() - getPuntos()[1].getY(), 2));
        double c = distancia / 2;
        double a = radio;
        double b = Math.sqrt(a * a - c * c);
        return Math.PI * a * b;
    }

    @Override
    public double calcularPerimetro() {
        double distancia = Math.sqrt(Math.pow(getPuntos()[0].getX() - getPuntos()[1].getX(), 2) +
                Math.pow(getPuntos()[0].getY() - getPuntos()[1].getY(), 2));
        double c = distancia / 2;
        double a = radio;
        double b = Math.sqrt(a * a - c * c);
        return Math.PI * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
    }
}