import java.time.LocalDate;

public class Prestamo {
    private int        id;
    private Libro      libro;
    private Usuario    usuario;
    private Trabajador trabajador;
    private LocalDate  fecha;
    private int        dias;
    private boolean    devuelto;
    
    private static int ultimoId = 0;


    //----------------------------------------------------------------
    // Constructores
    Prestamo () {
        this.libro      = null;
        this.usuario    = null;
        this.trabajador = null;
        this.fecha      = null;
        this.dias       = 0;
        this.devuelto   = false;
        this.id         = nuevoId();    }

    Prestamo (Libro libro, Usuario usuario, Trabajador trabajador, LocalDate fecha, int dias) {
        this.libro      = libro;
        this.usuario    = usuario;
        this.trabajador = trabajador;
        this.fecha      = fecha;
        this.dias       = dias;
        this.devuelto   = false;
        this.id         = nuevoId();    }

    Prestamo (Libro libro, Usuario usuario, Trabajador trabajador, LocalDate fecha) {
        this.libro      = libro;
        this.usuario    = usuario;
        this.trabajador = trabajador;
        this.fecha      = fecha;
        this.dias       = 7;
        this.devuelto   = false;
        this.id         = nuevoId();    }

    Prestamo (Prestamo p) {
        this.id         = p.id;
        this.libro      = p.libro;
        this.usuario    = p.usuario;
        this.trabajador = p.trabajador;
        this.fecha      = p.fecha;
        this.devuelto   = p.devuelto;
        this.dias       = p.dias;
    }


    //----------------------------------------------------------------
    // Getters y setters
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public boolean getDevuelto() {
        return devuelto;
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    //----------------------------------------------------------------
    // Operaciones comunes
    @Override
    public String toString() {
        return  "ID:\t\t" + this.id +
                "\nLibro:\n--------------\n" + this.libro +
                "\n\nUsuario:\n--------------\n" + this.usuario +
                "\n\nTrabajador:\n--------------\n" + this.trabajador +
                "\n\nFecha:\t\t" + this.fecha +
                "\nDias:\t" + this.dias;
    }

    public boolean equals(Prestamo p) {
        if (this.id         == p.id && 
            this.libro      == p.libro &&
            this.usuario    == p.usuario &&
            this.trabajador == p.trabajador &&
            this.fecha      == p.fecha &&
            this.dias       == p.dias)
            return true;
        else   
            return false;
    }


    //----------------------------------------------------------------
    // Funciones propias de un préstamo
    public static int nuevoId() {
        ultimoId++;
        return ultimoId;
    }
}
