public class Elipse extends Poligono implements Dibujable, Calculable {

    private double radioMayor;
    private double radioMenor;

    /* Constructores */
    public Elipse(Punto foco1, Punto foco2, double radioMayor, double radioMenor) {
        super(new Punto[]{foco1, foco2}, 1); // Se almacenan los focos como puntos
        this.radioMayor = radioMayor;
        this.radioMenor = radioMenor;
    }

    public Elipse(Elipse e) {
        super(e);
        this.radioMayor = e.radioMayor;
        this.radioMenor = e.radioMenor;
    }

    /* Getters y Setters */
    public Punto getFoco1() {
        return puntos[0]; 
    }

    public void setFoco1(Punto foco1) {
        this.puntos[0] = new Punto(foco1);
    }

    public Punto getFoco2() {
        return puntos[1];
    }

    public void setFoco2(Punto foco2) {
        this.puntos[1] = new Punto(foco2);
    }

    public double getRadioMayor() {
        return radioMayor;
    }

    public void setRadioMayor(double radioMayor) {
        this.radioMayor = radioMayor;
    }

    public double getRadioMenor() {
        return radioMenor;
    }

    public void setRadioMenor(double radioMenor) {
        this.radioMenor = radioMenor;
    }

    /* Métodos de cálculo */
    @Override
    public double calcularArea() {
        return Math.PI * radioMayor * radioMenor;
    }

    @Override
    public double calcularPerimetro() {
        // Fórmula aproximada de Ramanujan para el perímetro de una elipse:
        double a = radioMayor;
        double b = radioMenor;
        return Math.PI * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
    }

    /* Métodos de la interfaz Dibujar */
    @Override
    public void lineaRecta(Punto p1, Punto p2) {
        System.out.println("Dibujando línea recta de " + p1 + " a " + p2);
    }

    @Override
    public void lineaCurva(Punto p1, Punto p2, Punto control) {
        System.out.println("Dibujando línea curva de " + p1 + " a " + p2 + " con punto de control " + control);
    }

    /* Método de representación */
    @Override
    public void dibujar() {
        System.out.println("Dibujando " + getClass().getSimpleName() + " en la consola:");
        System.out.println("Foco1: " + getFoco1() + " | Foco2: " + getFoco2());
        System.out.println("Radio Mayor: " + radioMayor + " | Radio Menor: " + radioMenor);
        System.out.println("()"); // Representación simbólica de una elipse
    }

    /* Métodos comunes */
    @Override
    public String toString() {
        return getClass().getSimpleName() + " [Foco1: " + getFoco1() + ", Foco2: " + getFoco2() +
                ", Radio Mayor: " + radioMayor + ", Radio Menor: " + radioMenor +
                ", Área: " + calcularArea() + ", Perímetro: " + calcularPerimetro() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Elipse)) return false;
        Elipse e = (Elipse) obj;
        return Double.compare(radioMayor, e.radioMayor) == 0 &&
               Double.compare(radioMenor, e.radioMenor) == 0;
    }
}

