/**
 * C006_Biblioteca_3.0
 * 
 * Ejemplo básico de aplicación con POO. 
 * 
 * @author  Efrén Sánchez
 * Fecha    23/09/2025
 * 
 * Clase Biblioteca
 * 
 * Cláse que representa a una biblioteca, con sus libros, trabajadores, usuarios y préstamos.
 */
public class Biblioteca {
    // Tamaño inicial por defecto de los vectores
    private final int MAX_VEC = 10;

    // Vectores con los distintos elementos
    private Usuario [] usuarios;
    private Trabajador [] trabajadores;
    private Libro [] libros;
    private Prestamo [] prestamos;
    
    // Tamaño de los vectores
    private int tUsuarios     = MAX_VEC;
    private int tTrabajadores = MAX_VEC;
    private int tLibros       = MAX_VEC; 
    private int tPrestamos    = MAX_VEC;

    // Ocupación de los vectores
    private int nUsuarios     = 0;
    private int nTrabajadores = 0;
    private int nLibros       = 0; 
    private int nPrestamos    = 0;
    
    //private int id            = 0;
    //private static int ultimoId = 0;
    private String nombre;
    private String descripcion;
    
    // Constructores
    public Biblioteca() {
        this.usuarios     = new Usuario[MAX_VEC];
        this.trabajadores = new Trabajador[MAX_VEC];
        this.libros       = new Libro[MAX_VEC];
        this.prestamos    = new Prestamo[MAX_VEC];
        
        this.nombre       = "";
        this.descripcion  = "";
    }

    // Constructor indicando el tamaño inicial de los vectores
    public Biblioteca(int n) {
        this.tUsuarios     = n;
        this.tTrabajadores = n;
        this.tLibros       = n;
        this.tPrestamos    = n;

        this.usuarios     = new Usuario[n];
        this.trabajadores = new Trabajador[n];
        this.libros       = new Libro[n];
        this.prestamos    = new Prestamo[n];
        
        this.nombre       = "";
        this.descripcion  = "";
    }

    public Biblioteca(int n, String nombre) {
        this.tUsuarios     = n;
        this.tTrabajadores = n;
        this.tLibros       = n;
        this.tPrestamos    = n;
        
        this.usuarios     = new Usuario[n];
        this.trabajadores = new Trabajador[n];
        this.libros       = new Libro[n];
        this.prestamos    = new Prestamo[n];
        
        this.nombre       = nombre;
        this.descripcion  = "";
    }

    public Biblioteca(int n, String nombre, String descripcion) {
        this.tUsuarios     = n;
        this.tTrabajadores = n;
        this.tLibros       = n;
        this.tPrestamos    = n;
        
        this.usuarios     = new Usuario[n];
        this.trabajadores = new Trabajador[n];
        this.libros       = new Libro[n];
        this.prestamos    = new Prestamo[n];
        
        this.nombre       = nombre;
        this.descripcion  = descripcion;
    }
    
    // Contructor con todos los parámetros
    public Biblioteca(  Usuario [] usuarios, int tUsuarios, int nUsuarios, 
                        Trabajador [] trabajadores, int tTrabajadores, int nTrabajadores, 
                        Libro[] libros, int tLibros, int nLibros,
                        Prestamo[] prestamos, int tPrestamos, int nPrestamos,
                        String nombre, String descripcion) {
        this.tUsuarios     = tUsuarios;
        this.tTrabajadores = tTrabajadores;
        this.tLibros       = tLibros;
        this.tPrestamos    = tPrestamos;
        this.nUsuarios     = nUsuarios;
        this.nTrabajadores = nTrabajadores;
        this.nLibros       = nLibros;
        this.nPrestamos    = nPrestamos;
        
        this.usuarios     = usuarios;
        this.trabajadores = trabajadores;
        this.libros       = libros;
        this.prestamos    = prestamos;
        this.nombre       = nombre;
        this.descripcion  = descripcion;
    }

    // Constructor de copia
    public Biblioteca(Biblioteca b) {
        this.tUsuarios     = b.tUsuarios;
        this.tTrabajadores = b.tTrabajadores;
        this.tLibros       = b.tLibros;
        this.tPrestamos    = b.tPrestamos;
        this.nUsuarios     = b.nUsuarios;
        this.nTrabajadores = b.nTrabajadores;
        this.nLibros       = b.nLibros;
        this.nPrestamos    = b.nPrestamos;

        this.usuarios      = b.usuarios;
        this.trabajadores  = b.trabajadores;
        this.libros        = b.libros;
        this.prestamos     = b.prestamos;
        this.nombre        = b.nombre;
        this.descripcion   = b.descripcion;
    }

    // Getters y setters
    public void setLibros(Libro[] libros) {
        this.libros = libros;
    }

    public void setTrabajadores(Trabajador[] trabajadores) {
        this.trabajadores = trabajadores;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public void setPrestamos(Prestamo[] prestamos) {
        this.prestamos = prestamos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMAX_VEC() {
        return MAX_VEC;
    }

    public Libro[] getLibros() {
        return libros;
    }

    public Trabajador[] getTrabajadores() {
        return trabajadores;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public Prestamo[] getPrestamos() {
        return prestamos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Getters para tamaño y ocupación de los vectores
    // No se implementan setters para estas propiedades, su gestión se hará automática a partir de los métodos apropiados
    public int getnLibros() {
        return nLibros;
    }

    public int getnPrestamos() {
        return nPrestamos;
    }

    public int getnTrabajadores() {
        return nTrabajadores;
    }

    public int getnUsuarios() {
        return nUsuarios;
    }

    public int gettLibros() {
        return tLibros;
    }

    public int gettPrestamos() {
        return tPrestamos;
    }

    public int gettTrabajadores() {
        return tTrabajadores;
    }

    public int gettUsuarios() {
        return tUsuarios;
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
        // OJO: Falta mostrar los libros, trabajadores, usuarios y préstamos
        return "\n\nBiblioteca:\n-------------\nNombre:" + this.nombre + "\nDescripción:" + this.descripcion;
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
        if (this == obj) return true;
        if (obj.getClass() != this.getClass()) return false;

        Biblioteca b = (Biblioteca) obj;
        return (this.nombre == b.nombre);
    }

    /**
     * Método main
     * 
     * Para pruebas unitarias de la clase
     * 
     * @param args
     */
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();
        System.out.println(b.toString());
    }

}
