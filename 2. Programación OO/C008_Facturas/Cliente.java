import java.util.Objects;

public class Cliente {
    private String nombre;
    private String nifCif;
    private String telefono;
    private String email;

    // Constructor por defecto
    public Cliente() {
        this.nombre = "";
        this.nifCif = "";
        this.telefono = "";
        this.email = "";
    }

    // Constructor con parámetros
    public Cliente(String nombre, String nifCif, String telefono, String email) {
        this.nombre = nombre;
        this.nifCif = nifCif;
        this.telefono = telefono;
        this.email = email;
    }

    // Constructor de copia
    public Cliente(Cliente otro) {
        this.nombre = otro.nombre;
        this.nifCif = otro.nifCif;
        this.telefono = otro.telefono;
        this.email = otro.email;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNifCif() {
        return nifCif;
    }

    public void setNifCif(String nifCif) {
        this.nifCif = nifCif;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) &&
               Objects.equals(nifCif, cliente.nifCif) &&
               Objects.equals(telefono, cliente.telefono) &&
               Objects.equals(email, cliente.email);
    }

    // Método toString
    @Override
    public String toString() {
        return "\n\nCliente: " +
               "nombre = '" + nombre + '\'' +
               ", nifCif = '" + nifCif + '\'' +
               ", telefono = '" + telefono + '\'' +
               ", email = '" + email + '\'' +
               ';';
    }
}
