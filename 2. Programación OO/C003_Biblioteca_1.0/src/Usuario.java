/**
 * C003_Biblioteca_1.0
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
public class Usuario {
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;

    // Constructores
    public Usuario() {
        this.nombre     = "";
        this.apellido   = "";
        this.dni        = "";
        this.edad       = 0;
    }

    public Usuario(String nombre, String apellido, String dni, int edad) {
        this.nombre     = nombre  ;
        this.apellido   = apellido;
        this.dni        = dni;
        this.edad       = edad;
    }

    public Usuario(Usuario u) {
        this.nombre     = u.nombre  ;
        this.apellido   = u.apellido;
        this.dni        = u.dni;
        this.edad       = u.edad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
        return "\n\nUsuario:\n======\nNombre: " + this.nombre + "\nApellido: " + this.apellido + "\nDNI: " + this.dni + "\nEdad: " + this.edad;
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
        Usuario u = (Usuario) obj;

        return ((this.nombre.equals(u.nombre)) && (this.apellido.equals(u.apellido)) && (this.dni.equals(u.dni)) && (this.edad == u.edad));
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
        
    }
}
