/**
 * C002_ClienteTrabajador
 * 
 * Ejemplo básico de aplicación POO con herencia
 * 
 * @author  Efrén Sánchez
 * Fecha    01/12/2025
 * 
 * Clase Persona
 * 
 * Cláse padre de la que descienden las clases Trabajador y Cliente
 */
public class Persona {
    private String nombre;
    private String dni;
    private String direccion;
    //protected String nombre;
    //protected String dni;
    //protected String direccion;

    // Constructor por defecto
    public Persona() {
        this.nombre     = "";
        this.dni        = "";
        this.direccion  = "";
    }

    // Constructor con parámetros
    public Persona(String nombre, String dni, String dir ) {
        this.nombre     = nombre;
        this.dni        = dni;
        this.direccion  = dir;
    }

    // Constructor de copia
    public Persona(Persona p) {
        this.nombre     = p.nombre;
        this.dni        = p.dni;
        this.direccion  = p.direccion;
    }

    // Getters y setters
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return  "\nPersona:" + 
                "\nNombre: " + nombre + 
                "\nDNI: " + dni + 
                "\nDirección: " + direccion;
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
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;

        Persona o = (Persona) obj;
        return (this.nombre.equals(o.nombre) && this.dni.equals(o.dni) && this.direccion.equals(o.direccion));
    }

    /**
     * Método main
     * 
     * Para pruebas unitarias de la clase
     * 
     * @param args
     */
    public static void main(String[] args) {
        Persona p1 = new Persona();
        p1.setNombre("Camilo José Cela");
        p1.setDni("11223344X");
        p1.setDireccion("Debajo de un puento, 32");
        System.out.println(p1);
        
        Persona p2 = new Persona("Carlos Ruiz Zafón", "12345678Z", "C/ Ensenada 21");
        System.out.println(p2);
        
        Persona p3 = new Persona(p2);
        System.out.println(p3);
        
        System.out.println("¿p2 y p3 son iguales? " + p2.equals(p3)); // Si
        System.out.println("¿p1 y p3 son iguales? " + p1.equals(p3)); // No
    }
}
