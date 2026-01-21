/**
 * C005_Biblioteca_2.0
 * 
 * Ejemplo básico de aplicación con POO. 
 * 
 * @author  Efrén Sánchez
 * Fecha    23/09/2025
 * 
 * Clase Usuario
 * 
 * Cláse que representa a un usuario de una biblioteca.
 */
public class Trabajador extends Persona{
    private String nss; // Número de Seguridad Social
    private String ncc; // Número de Cuenta Corriente
    
    // Constructores
    public Trabajador() {
        super();
        this.nss = "";
        this.ncc = "";
    }

    public Trabajador(String nombre, String apellido, String dni, int edad, String nscoio, String finscripcion) {
        super(nombre, apellido, dni, edad);
        this.nss = "";
        this.ncc = "";
    }

    public Trabajador(Persona p, String nscoio, String finscripcion) {
        super(p);
        this.nss = "";
        this.ncc = "";
    }

    public Trabajador(Trabajador t) {
        super(t);
        this.nss = t.nss;
        this.ncc = t.ncc;
    }

    // Getters y Setters
    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNcc() {
        return ncc;
    }

    public void setNcc(String ncc) {
        this.ncc = ncc;
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
        return "\n\nTrabajador:\n======" + 
                "\nNombre: " + this.getNombre() + 
                "\nApellido: " + this.getApellido() + 
                "\nDNI: " + this.getDni() + 
                "\nEdad: " + this.getEdad() + 
                "\nNºSS: " + this.getNss() + 
                "\nC/C: " + this.getNcc();
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
        Trabajador t = (Trabajador) obj;

        return ((this.getNombre().equals(t.getNombre())) && 
                (this.getApellido().equals(t.getApellido())) && 
                (this.getDni().equals(t.getDni())) && 
                (this.getEdad() == t.getEdad()) && 
                (this.getNss().equals(t.getNss())) && 
                (this.getNcc().equals(t.getNcc())));
        // return (this.dni.equals(l.dni));
    }

    /**
     * Método main
     * 
     * Para pruebas unitarias de la clase
     * 
     * @param args
     */
    public static void main(String[] args) {
        Trabajador t1 = new Trabajador();
        Trabajador t2 = new Trabajador("Juan", "Fernandez", "87654321A", 44, "ES00-1234-1234-1234-1234-1234", "12121212121");
        Trabajador t3 = new Trabajador(t2);

        Persona p = new Persona("Juan", "", "", 10);
        Trabajador t4 = new Trabajador(p, "1238", "01/10/2022");

        t1.setNombre("Juan");
        t1.setApellido("Juánez");
        t1.setDni("22446688A");
        t1.setEdad(50);

        t3.setNombre("Perico");

        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
        System.out.println(t4.toString());

        if (t3.equals(t2))
            System.out.println("\n\nLos objetos t2 y t3 son iguales.");
        else
            System.out.println("\n\nLos objetos t2 y t3 NO son iguales.");

        if (t1.equals(t2))
            System.out.println("\n\nLos objetos t1 y t2 son iguales.");
        else
            System.out.println("\n\nLos objetos t1 y t2 NO son iguales.");
    }
}
