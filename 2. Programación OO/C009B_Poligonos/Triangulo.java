package es.medac.alu.ftt0003;

import java.util.Arrays;

public class Triangulo extends Poligono implements Dibujable, Calculable {

    public Triangulo(Punto[] puntos) {
        super(puntos);
        if (puntos.length != 3)
            throw new IllegalArgumentException("Triángulo debe tener 3 puntos.");
    }

    @Override
    public String toString() {
        return "Triángulo con puntos: " + Arrays.toString(getPuntos());
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
        System.out.println("Dibujando triángulo:");
        Punto[] puntos = getPuntos();
        for (int i = 0; i < puntos.length; i++)
            lineaRecta(puntos[i], puntos[(i + 1) % puntos.length]);
    }

    @Override
    public double calcularArea() {
        Punto[] p = getPuntos();
        double v = (0.5 * Math.abs(
                (p[0].getX() * (p[1].getY() - p[2].getY()) +
                        (p[1].getX() * (p[2].getY() - p[0].getY()) +
                                (p[2].getX() * (p[0].getY() - p[1].getY()))
                        ))));
        return v;
    }

    @Override
    public double calcularPerimetro() {
        Punto[] p = getPuntos();
        return distancia(p[0], p[1]) + distancia(p[1], p[2]) + distancia(p[2], p[0]);
    }

    private double distancia(Punto a, Punto b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
}