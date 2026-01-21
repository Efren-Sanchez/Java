/**
 * C001_Clínica Veterinaria
 * Ejemplo básico de aplicación con POO. 
 * 
 * @author  Efrén Sánchez
 * Fecha    23/09/2025
 * 
 * Clase Consulta
 * 
 * Cláse que representa a una consulta entre un veterinario y un perro.
 */
public class Consulta {
    private Veterinario v;  // Veterinario que realiza la consulta
    private Perro p;        // Perro al que se consulta
    private String fecha;
    private String hora;
    private double precio;

    // Constructores

    // Constructor nulo
    public Consulta() {
        //this.v = null;        // No deberíamos hacerlo así
        v = new Veterinario();  // Mejor con el constructor
        
        //this.p = null;
        p = new Perro();

        this.fecha = "01/01/1900";
        this.hora = "00:00";
        this.precio = 100;
    }

    // Constructor con parámetros
    public Consulta(Veterinario v, Perro p, String f, String h, double pp) {
        this.v = v;
        this.p = p;
        this.fecha = f;
        this.hora = h;
        this.precio = pp;
    }

    // Constructor de copia
    public Consulta(Consulta c) {
        this.v = c.v;
        this.p = c.p;
        this.fecha = c.fecha;
        this.hora = c.hora;
        this.precio = c.precio;
    }

    // Getters
    public Veterinario getV() {
        return v;
    }

    public Perro getP() {
        return p;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public double getPrecio() {
        return precio;
    }

    // Setters
    public void setV(Veterinario v) {
        this.v = v;
    }

    public void setP(Perro p) {
        this.p = p;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Método toString
     * 
     * Convierte el objeto en una cadena de texto imprimible por pantalla.
     * 
     * @author Efrén Sánchez
     * 
     * Entrada: void
     * 
     * Salida:  
     *   @return String     Cadena de texto que representa al objeto
     */
    @Override
    public String toString() {
        return "\n\nConsulta:\n*********\n" + this.v + this.p + "\nFecha: " + this.fecha + "\nHora: " + this.hora + "\nPrecio: " +  this.precio;
    }

    /**
     * Método equals
     * 
     * Compara entre dos objetos del mismo tipo.
     * 
     * @author Efrén Sánchez
     * 
     * Entrada:
     * @param Objetc o  Objeto con el que comparar
     * 
     * Salida:
     * @return boolean  True si son iguales, fasle si no lo son
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Consulta c = (Consulta) o;

        return (c.v.equals(this.v) && this.p.equals(c.p) && this.fecha.equals(c.fecha) && this.hora.equals(c.hora) && this.precio == c.precio);
    }

    /**
     * Método main
     * 
     * Para pruebas unitarias de la clase
     * 
     * @param args
     */
    public static void main(String[] args) {
        Consulta c1 = new Consulta();

        Perro p = new Perro("Bobby", "Collie", 2, "negro");
        Veterinario v = new Veterinario("Pepe Pepe Pepe", "12345678Z", "", 'T', 3);
        Consulta c2 = new Consulta(v, p, "01/01/2026", "15:00", 75.25);

        System.out.println(c1);
        System.out.println(c2);
    }
}
