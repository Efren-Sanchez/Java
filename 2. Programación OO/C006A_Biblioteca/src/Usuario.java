import java.time.LocalDate;

public class Usuario extends Persona {
    private int       id;
    private Estado    estado;

    private static int ultimoId = 0;
    
    // OJO: aquí habría que pensar el tema de las sanciones

    //----------------------------------------------------------------
    // Constructores
    Usuario () {
        super();
        this.estado     = Estado.BAJA;
        this.id         = nuevoId();
    }

    Usuario (String nombre, String direccion, String telefono, LocalDate fechaNac, Estado estado) {
        super(nombre, direccion, telefono, fechaNac);
        this.estado     = estado;
        this.id         = nuevoId();
    }

    Usuario (Usuario u) {
        super(u.nombre, u.direccion, u.telefono, u.fechaNac);
        this.estado     = u.estado;
        this.id         = u.id;
    }

    //----------------------------------------------------------------
    // Getters y setters

    // OJO: no permitimos que se pueda actualizar el id manualmente, se hace automáticamente
    // ¡¡No hay setId!!
    public int getId() {
        return id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    //----------------------------------------------------------------
    // Operaciones comunes
    @Override
    public String toString() {
        return  "ID:\t\t" + this.id +
                "\nNombre:\t\t" + this.nombre +
                "\nDirección:\t" + this.direccion +
                "\nTeléfono:\t\t" + this.telefono +
                "\nFecha Nac:\t" + this.fechaNac +
                "\nEstado:\t" + this.estado;
    }

    public boolean equals(Usuario u) {
        if (this.id        == u.id &&
            this.nombre    == u.nombre &&
            this.direccion == u.direccion &&
            this.telefono  == u.telefono &&
            this.fechaNac  == u.fechaNac &&
            this.estado    == u.estado)
            return true;
        else   
            return false;
    }


    //----------------------------------------------------------------
    // Funciones propias de un usuario
    public static int nuevoId() {
        ultimoId++;
        return ultimoId;
    }

    // Desarrollamos el método abstracto de Persona
    public void consultarLibros(Prestamo [] vecPrestamos, int numPrestamos) {
        for (int i = 0; i < numPrestamos; i++) 
            if (vecPrestamos[i].getUsuario().getId() == this.id)
                System.out.println(vecPrestamos[i]);
    }
}
