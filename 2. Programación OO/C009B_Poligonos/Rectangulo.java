package es.medac.alu.ftt0003;

import java.util.Arrays;

public class Rectangulo extends Poligono implements Dibujable, Calculable {

    public Rectangulo(Punto[] puntos) {
        super(puntos);
        if (puntos.length != 4)
            throw new IllegalArgumentException("Rectángulo debe tener 4 puntos.");
    }

    @Override
    public String toString() {
        return "Rectángulo con puntos: " + Arrays.toString(getPuntos());
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
        System.out.println("Dibujando rectángulo:");
        Punto[] puntos = getPuntos();
        for (int i = 0; i < puntos.length; i++)
            lineaRecta(puntos[i], puntos[(i + 1) % puntos.length]);
    }

    @Override
    public double calcularArea() {
        Punto[] p = getPuntos();
        return distancia(p[0], p[1]) * distancia(p[1], p[2]);
    }

    @Override
    public double calcularPerimetro() {
        Punto[] p = getPuntos();
        return 2 * (distancia(p[0], p[1]) + distancia(p[1], p[2]));
    }

    private double distancia(Punto a, Punto b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
}