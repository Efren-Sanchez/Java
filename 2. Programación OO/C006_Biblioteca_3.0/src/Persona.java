/**
 * C006_Biblioteca_3.0
 * 
 * Ejemplo básico de aplicación con POO. 
 * 
 * @author  Efrén Sánchez
 * Fecha    23/09/2025
 * 
 * Clase Persona
 * 
 * Cláse que representa a una persona. De ella descenderán Usuario y Trabajador.
 */
public abstract class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;

    // Constructores
    public Persona() {
        this.nombre     = "";
        this.apellido   = "";
        this.dni        = "";
        this.edad       = 0;
    }

    public Persona(String nombre, String apellido, String dni, int edad) {
        this.nombre     = nombre  ;
        this.apellido   = apellido;
        this.dni        = dni;
        this.edad       = edad;
    }

    public Persona(Persona u) {
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

    // Método abstracto del que no se proporciona el código, únicamente el prototipo
    // Estamos obligados a implementar este método el las clases derivadas que no sean abstractas
    public abstract void mostrarLibros(Prestamo [] prestamos, int nPrestamos);

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
        Persona u = (Persona) obj;

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
        // Como la clase persona es de tipo abstracto no podemos crear objetos
        //Persona p1 = new Persona();
        //Persona p2 = new Persona("Efrén", "Sánchez", "12345678Z", 25);
        //Persona p3 = new Persona(p2);
        //Persona p4 = new Persona(p2);
    }
}