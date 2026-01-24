package es.medac.alu.ftt0003;

import java.util.Arrays;

abstract class Poligono {
    protected Punto[] puntos;
    protected int numLados;

    public Poligono(Punto[] puntos) {
        this.puntos = puntos;
        this.numLados = puntos.length;
    }

    public Punto[] getPuntos() {
        return puntos;
    }

    public int getNumLados() {
        return numLados;
    }

    @Override
    public String toString() {
        return "Polígono de " + numLados + " lados. Puntos: " + Arrays.toString(puntos);
    }
}
