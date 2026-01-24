/**
 * Clase que representa un libro en la biblioteca.
 * Contiene información sobre el ISBN, título, autor, género y disponibilidad del libro.
 */
public class Libro {
    /** Código ISBN único que identifica al libro */
    private String isbn;
    /** Título del libro */
    private String titulo;
    /** Autor del libro */
    private String autor;
    /** Género literario del libro */
    private String genero;
    /** Indica si el libro está disponible para préstamo */
    private boolean disponible;

    /**
     * Constructor completo para crear un nuevo libro.
     *
     * @param isbn       El código ISBN del libro (debe ser único)
     * @param titulo     El título del libro
     * @param autor      El autor del libro
     * @param genero     El género literario del libro
     * @param disponible Indica si el libro está disponible para préstamo
     */
    public Libro(String isbn, String titulo, String autor, String genero, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponible = disponible;
    }

    /**
     * Constructor simplificado que crea un libro como disponible por defecto.
     *
     * @param isbn   El código ISBN del libro
     * @param titulo El título del libro
     * @param autor  El autor del libro
     * @param genero El género literario del libro
     */
    public Libro(String isbn, String titulo, String autor, String genero) {
        this(isbn, titulo, autor, genero, true);
    }

    /**
     * Obtiene el ISBN del libro.
     *
     * @return El código ISBN del libro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establece el ISBN del libro.
     *
     * @param isbn El nuevo código ISBN del libro
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return El título del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del libro.
     *
     * @param titulo El nuevo título del libro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return El autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro.
     *
     * @param autor El nuevo autor del libro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene el género del libro.
     *
     * @return El género literario del libro
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del libro.
     *
     * @param genero El nuevo género literario del libro
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Indica si el libro está disponible para préstamo.
     *
     * @return true si el libro está disponible, false en caso contrario
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Establece la disponibilidad del libro para préstamo.
     *
     * @param disponible true si el libro está disponible, false en caso contrario
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Compara si este libro es igual a otro objeto.
     * Dos libros son iguales si tienen el mismo ISBN.
     *
     * @param objeto El objeto a comparar
     * @return true si los objetos son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }
        Libro otroLibro = (Libro) objeto;
        if (isbn == null) {
            return otroLibro.isbn == null;
        }
        return isbn.equals(otroLibro.isbn);
    }

    /**
     * Genera un código hash para este libro basado en su ISBN.
     *
     * @return El código hash del libro
     */
    @Override
    public int hashCode() {
        if (isbn == null) {
            return 0;
        }
        return isbn.hashCode();
    }

    /**
     * Devuelve una representación en forma de cadena del libro.
     *
     * @return Una cadena con la información del libro formateada
     */
    @Override
    public String toString() {
        return String.format("ISBN: %s | Título: %s | Autor: %s | Género: %s | Disponible: %s",
                isbn, titulo, autor, genero, disponible ? "Sí" : "No");
    }
}
