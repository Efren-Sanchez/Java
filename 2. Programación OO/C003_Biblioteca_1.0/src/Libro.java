/**
 * C003_Biblioteca_1.0
 * 
 * Ejemplo básico de aplicación con POO. 
 * 
 * @author  Efrén Sánchez
 * Fecha    23/09/2025
 * 
 * Clase Libro
 * 
 * Cláse que representa a un libro de una biblioteca.
 */
public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private int    ejemplares;

    // Constructores
    public Libro() {
        this.titulo     = "";
        this.autor      = "";
        this.isbn       = "";
        this.ejemplares = 0;
    }

    public Libro(String titulo, String autor, String isbn, int ejemplares) {
        this.titulo     = titulo;
        this.autor      = autor;
        this.isbn       = isbn;
        this.ejemplares = ejemplares;
    }

    public Libro(Libro l) {
        this.titulo     = l.titulo;
        this.autor      = l.autor;
        this.isbn       = l.isbn;
        this.ejemplares = l.ejemplares;        
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
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
     * @return String     Cadena de texto que representa al objeto
     */
    @Override
    public String toString() {
        return "\n\nLibro:\n======\nTítulo: " + this.titulo + "\nAutor: " + this.autor + "\nISBN: " + this.isbn + "\nEjemplares: " + this.ejemplares;
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
        Libro l = (Libro) obj;

        return ((this.titulo.equals(l.titulo)) && (this.autor.equals(l.autor)) && (this.isbn.equals(l.isbn)) && (this.ejemplares == l.ejemplares));
        // return (this.isbn.equals(l.isbn));
    }

    /**
     * Método main
     * 
     * Para pruebas unitarias de la clase
     * 
     * @param args
     */
    public static void main(String[] args) {
        Libro l1 = new Libro();
        l1.setTitulo("El Quijote");
        l1.setAutor("Miguel de Cervantes");
        l1.setIsbn("1234567890");
        l1.setEjemplares(3);
    }
}
