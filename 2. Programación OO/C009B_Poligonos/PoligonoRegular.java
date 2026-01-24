package es.medac.alu.ftt0003;

import java.util.Arrays;

public class PoligonoRegular extends Poligono implements Dibujable, Calculable {

    public PoligonoRegular(Punto[] puntos) {
        super(puntos);
    }

    @Override
    public String toString() {
        return "Polígono regular de " + getNumLados() + " lados. Puntos: " + Arrays.toString(getPuntos());
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
        System.out.println("Dibujando polígono regular:");
        Punto[] puntos = getPuntos();
        for (int i = 0; i < puntos.length; i++)
            lineaRecta(puntos[i], puntos[(i + 1) % puntos.length]);
    }

    @Override
    public double calcularArea() {
        int n = getNumLados();
        double s = calcularLongitudLado();
        return (n * s * s) / (4 * Math.tan(Math.PI / n));
    }

    @Override
    public double calcularPerimetro() {
        return calcularLongitudLado() * getNumLados();
    }

    private double calcularLongitudLado() {
        Punto[] puntos = getPuntos();
        if (puntos.length < 2) return 0;
        return distancia(puntos[0], puntos[1]);
    }

    private double distancia(Punto a, Punto b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
}