import java.util.Arrays;

public abstract class Poligono {
    
    /* Atributos */
    protected Punto[] puntos; // Array de puntos
    protected int numLados; // Número de lados

    /* Constructores */
    // Vacío
    public Poligono() {
        this.puntos = new Punto[0];
        this.numLados = 0;
    }

    // Predeterminado
    public Poligono(Punto[] puntos, int numLados) {
        // Asignar longitud al array de puntos
        this.puntos = new Punto[puntos.length];
        // Guardar cada punto
        for (int i = 0; i < puntos.length; i++) {
            this.puntos[i] = new Punto(puntos[i]);
        }
        // Guardar el número de lados
        this.numLados = numLados;
    }

    // Copia
    public Poligono(Poligono p) {
        if (p != null && p.puntos != null) {
            // Asignar longitud al array de puntos
            this.puntos = new Punto[p.puntos.length];
            // Copiar cada punto
            for (int i = 0; i < p.puntos.length; i++) {
                this.puntos[i] = new Punto(p.puntos[i]);
            }
            // Guardar el número de lados
            this.numLados = p.numLados;
        // Crear un array vacío si el poligono a copiar es nulo
        } else {
            this.puntos = new Punto[0];
            this.numLados = 0;
        }
    }

    /* Getters y Setters */
    public Punto[] getPuntos() {
        return this.puntos;
    }

    public void setPuntos(Punto[] puntos) {
        // Si hicieramos un this.puntos = puntos, estaríamos pasando la referencia, no el valor de los puntos
        this.puntos = new Punto[puntos.length];
        for (int i = 0; i < puntos.length; i++) {
            this.puntos[i] = new Punto(puntos[i]);
        }
    }

    public int getNumLados() {
        return this.numLados;
    }

    public void setNumLados(int numLados) {
        this.numLados = numLados;
    }

    /* Métodos comunes */
    @Override
    public String toString() {
        // Se devuelve el nombre de la clase seguido de los puntos entre corchetes
        StringBuilder sb = new StringBuilder(getClass().getSimpleName() + " [");
        for (int i = 0; i < puntos.length; i++) {
            sb.append(puntos[i].toString());
            if (i < puntos.length - 1) sb.append(", "); // Evita espacio extra
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Poligono pol = (Poligono) obj;
        return numLados == pol.numLados && Arrays.equals(puntos, pol.puntos);
    }
}
