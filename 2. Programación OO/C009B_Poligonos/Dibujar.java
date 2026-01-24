package es.medac.alu.ftt0003;

public interface Dibujar {
    void lineaRecta(Punto p1, Punto p2);
    void lineaCurva(Punto p1, Punto p2, Punto control);
}
