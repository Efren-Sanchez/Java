import java.util.Arrays;

public abstract class Poligono {
    //public final int MAX_LADOS = 15; // Número máximo de lados que acepta el sistema
    private Punto [] puntos;
    private int numLados;

    public Poligono() {
        this.numLados   = 0;
        this.puntos     = new Punto[numLados];
    }
    
    public Poligono(int n) {
        this.numLados   = n;
        this.puntos     = new Punto[n];
    }

    public Poligono(int n, Punto [] puntos) {
        this.numLados   = n;
        this.puntos     = puntos;
    }

    public Poligono(Poligono p) {
        this.numLados   = p.numLados;
        this.puntos     = p.puntos;
    }

    public void setNumLados(int numLados) {
        this.numLados = numLados;
    }

    public void setPuntos(Punto[] puntos) {
        this.puntos = puntos;
    }

    public int getNumLados() {
        return numLados;
    }

    public Punto[] getPuntos() {
        return puntos;
    }

    @Override
    public String toString() {
        String salida = "Poligono de " + this.numLados + " lados: ";
        for (int i = 0; i < this.numLados; i++) {
            salida += this.puntos[i].toString() + ", ";
        }
        return salida;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;
        Poligono p = (Poligono) obj;
        // OJO: cuidado con el orden de los puntos, siendo iguales puede fallar
        return this.numLados == p.numLados && Arrays.equals(this.puntos, p.puntos);
    }

    // ordenarPuntos(Punto [] p)

    /*
    public static void main(String[] args) {
        Poligono p1 = new Poligono();
        Poligono p2 = new Poligono();

    }
    */
}
