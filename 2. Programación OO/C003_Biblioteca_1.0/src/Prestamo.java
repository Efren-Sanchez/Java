/**
 * C003_Biblioteca_1.0
 * 
 * Ejemplo básico de aplicación con POO. 
 * 
 * @author  Efrén Sánchez
 * Fecha    23/09/2025
 * 
 * Clase Préstamo
 * 
 * Cláse que representa a un préstamos de un libro a un socio de una biblioteca.
 */
public class Prestamo {
    private Libro l;
    private Usuario u;
    private String fecha;

    // Constructores
    public Prestamo() {
        this.l      = new Libro();
        this.u      = new Usuario();
        this.fecha  = "";
    }

    public Prestamo(Libro l, Usuario u, String fecha) {
        this.l      = l;
        this.u      = u;
        this.fecha  = fecha;
    }

    // Este constructor parece que no tiene sentido en este caso, pero en otros sí que podría tenerlo
    public Prestamo(String titulo, String autor, String isbn, int ejemplares, String nombre, String apellido, String dni, int edad, String fecha) {
        this.l      = new Libro(titulo, autor, isbn, ejemplares);
        this.u      = new Usuario(nombre, apellido, dni, edad);
        this.fecha  = fecha;
    }

    public Prestamo(Prestamo p) {
        this.l      = p.l;
        this.u      = p.u;
        this.fecha  = p.fecha;
    }

    // Getters y Setters
    public Libro getL() {
        return l;
    }

    public void setL(Libro l) {
        this.l = l;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // Métodos comunes

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
        return "\n\nPréstamo:\n=========\n" + this.l.toString() + u.toString() + "\nFecha: " + this.fecha;
    }

    /**
     * Método pintarBonito
     * 
     * Imprime por pantalla un préstamo con formato presentable al usuario.
     * 
     * @author Efrén Sánchez
     * 
     * Entrada: void
     * 
     * Salida:  
     *   @return String     Cadena de texto que representa al objeto
     */
    public String pintarBonito() {
        return "\n\nPréstamo:\n=========\nTítulo: " + this.l.getTitulo() + "\nUsuario: " + this.u.getDni() + "\nFecha: " + this.fecha;
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
    public boolean equals(Object obj) {
        if (obj == null) return false; // Comparo con nulo
        if (obj == this) return true;  // Comparo si es el propio objeto
        if (obj.getClass() != this.getClass()) return false; // Comparo si son de diferente clase
        
        // Llegados a este punto, puedo afirmar que el objeto pasado por parámetro es de toipo Libro
        Prestamo p = (Prestamo) obj;

        return (this.l.equals(p.l) && this.u.equals(p.u) && this.fecha.equals(p.fecha));
    }

    /**
     * Método main
     * 
     * Para pruebas unitarias de la clase
     * 
     * @param args
     */
    public static void main(String[] args) {
        Libro l = new Libro("Mortadelo y Filemón", "Ibañez", "9876543210", 32);
        System.out.println(l.toString());

        Usuario u = new Usuario("Efrén", "Sánchez", "12345678Z", 22);
        System.out.println(u.toString());
        
        Prestamo p = new Prestamo(l, u, "05/12/2025");
        System.out.println(p.toString());

        System.out.println("\n--------------------------------------------\n");
        System.out.println(p.pintarBonito());
    }
}