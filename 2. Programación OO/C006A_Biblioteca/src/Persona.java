import java.time.LocalDate;

public abstract class Persona {
    protected String    nombre;
    protected String    direccion;
    protected String    telefono;
    protected LocalDate fechaNac;

    Persona () {
        this.nombre     = "";
        this.direccion  = "";
        this.telefono   = "";
        this.fechaNac   = null;
    }

    Persona (String nombre, String direccion, String telefono, LocalDate fechaNac) {
        this.nombre     = nombre;
        this.direccion  = direccion;
        this.telefono   = telefono;
        this.fechaNac   = fechaNac;
    }

    Persona (Persona p) {
        this.nombre     = p.nombre;
        this.direccion  = p.direccion;
        this.telefono   = p.telefono;
        this.fechaNac   = p.fechaNac;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }
    
    // Declaramos un método abstracto
    public abstract void consultarLibros(Prestamo [] vecPrestamos, int numPrestamos);
}
