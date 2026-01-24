import java.time.LocalDate;

public class Trabajador extends Persona {
    private int     id;
    private String  nss;
    private double  salario;

    private static int ultimoId = 0;

    //----------------------------------------------------------------
    // Constructores
    Trabajador () {
        super();
        this.nss     = "";
        this.salario = 0;
        this.id      = nuevoId();
    }

    Trabajador (String nombre, String direccion, String telefono, LocalDate fechaNac, String nss, double salario) {
        super(nombre, direccion, telefono, fechaNac);
        this.nss     = nss;
        this.salario = salario;
        this.id      = nuevoId();
    }

    Trabajador (Trabajador t) {
        super(t.nombre, t.direccion, t.telefono, t.fechaNac);
        this.nss     = t.nss;
        this.salario = t.salario;
        this.id      = t.id;
    }


    //----------------------------------------------------------------
    // Getters y setters

    // OJO: no permitimos que se pueda actualizar el id manualmente, se hace automáticamente
    // ¡¡No hay setId!!
    public int getId() {
        return id;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String  nss) {
        this.nss = nss;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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
                "\nNSS:\t" + this.nss +
                "\nSalario:\t" + this.salario;
    }

    public boolean equals(Trabajador t) {
        if (this.id        == t.id &&
            this.nombre    == t.nombre &&
            this.direccion == t.direccion &&
            this.telefono  == t.telefono &&
            this.fechaNac  == t.fechaNac &&
            this.nss       == t.nss &&
            this.salario   == t.salario)
            return true;
        else   
            return false;
    }


    //----------------------------------------------------------------
    // Funciones propias de un trabajador
    public static int nuevoId() {
        ultimoId++;
        return ultimoId;
    }

    // Desarrollamos el método abstracto de Persona
    public void consultarLibros(Prestamo [] vecPrestamos, int numPrestamos) {
        for (int i = 0; i < numPrestamos; i++) 
            if (vecPrestamos[i].getTrabajador().getId() == this.id)
                System.out.println(vecPrestamos[i]);
    }
}
