public class Libro {
    private String  titulo;
    private String  autor;
    private int     paginas;
    private String  isbn;
    private String  categoria;
    private int     ejemplares;
    private int     disponibles;

    //----------------------------------------------------------------
    // Constructores

    // Contructor vacio
    Libro (){
        this.titulo      = "";
        this.autor       = "";
        this.paginas     = 0;
        this.isbn        = "";
        this.categoria   = "";
        this.ejemplares  = 0;
        this.disponibles = 0;
    }

    // Constructor por defecto
    Libro (String titulo, String autor, int paginas, String isbn, String categoria, int ejemplares){
        this.titulo      = titulo;
        this.autor       = autor;
        this.paginas     = paginas;
        this.isbn        = isbn;
        this.categoria   = categoria;
        this.ejemplares  = ejemplares;
        this.disponibles = ejemplares;
    }

    // Copnstructor de copia
    Libro (Libro l){
        this.titulo      = l.titulo;
        this.autor       = l.autor;
        this.paginas     = l.paginas;
        this.isbn        = l.isbn;
        this.categoria   = l.categoria;
        this.ejemplares  = l.ejemplares;
        this.disponibles = l.disponibles;
    }

    //----------------------------------------------------------------
    // Getters y setters
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    //----------------------------------------------------------------
    // Operaciones comunes
    @Override
    public String toString() {
        return "Título:\t\t" + this.titulo +
                "\nAutor:\t\t" + this.autor +
                "\nPáginas:\t" + this.paginas +
                "\nISBN:\t\t" + this.isbn +
                "\nCategoría:\t" + this.categoria +
                "\nEjemplares:\t" + this.ejemplares +
                "\nDisponibles:\t" + this.disponibles;
    }

    public boolean equals(Libro l) {
        if (this.titulo      == l.titulo &&
            this.autor       == l.autor &&
            this.paginas     == l.paginas &&
            this.isbn        == l.isbn &&
            this.categoria   == l.categoria &&
            this.ejemplares  == l.ejemplares &&
            this.disponibles == l.disponibles)
            return true;
        else   
            return false;
    }

    //----------------------------------------------------------------
    // Funciones propias de un libro

    // Devuelve true o false en función de si hay ejemplares disponible para prestar o no
    public boolean disponible() {
        if (this.disponibles > 0)
            return true;
        else
            return false;
    }
    
    // Presta un libro
    // El libro tiene que estar disponible para poder prestarlo
    public boolean prestar() {
        if (disponible()) {
            //this.disponibles = this.disponibles - 1;
            this.disponibles--;
            return true;
        }
        else 
            return false;
    }

    // Devuelve un libro prestado
    public void devolver() {
        //this.disponibles = this.disponibles + 1;
        this.disponibles++;
    }

    // Añade un número de ejemplares pasado por parámetro
    public void anadir(int n) {
        // this.ejemplares = this.ejemplares + n;
        this.ejemplares += n;
        this.disponibles += n;
    }

    // Elimina un número de ejemplares pasado por parámetro
    // Considero que no se pueden eliminar ejemplares que no tenga físicamente en la biblioteca
    public boolean eliminar(int n) {
        if (this.ejemplares >= n && this.disponibles >= n) {
            this.ejemplares -= n;
            this.disponibles -= n;
            return true;
        }
        else
            return false;
    }
}
