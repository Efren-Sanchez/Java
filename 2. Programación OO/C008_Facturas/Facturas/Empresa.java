import java.util.Objects;

public class Empresa {
    private String nombre;
    private String direccion;
    private String cif;
    private String telefono;
    private String email;

    // Constructor por defecto
    public Empresa() {
        this.nombre = "";
        this.direccion = "";
        this.cif = "";
        this.telefono = "";
        this.email = "";
    }

    // Constructor con parámetros
    public Empresa(String nombre, String direccion, String cif, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cif = cif;
        this.telefono = telefono;
        this.email = email;
    }

    // Constructor de copia
    public Empresa(Empresa otra) {
        this.nombre = otra.nombre;
        this.direccion = otra.direccion;
        this.cif = otra.cif;
        this.telefono = otra.telefono;
        this.email = otra.email;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
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
        Empresa empresa = (Empresa) o;
        return Objects.equals(nombre, empresa.nombre) &&
               Objects.equals(direccion, empresa.direccion) &&
               Objects.equals(cif, empresa.cif) &&
               Objects.equals(telefono, empresa.telefono) &&
               Objects.equals(email, empresa.email);
    }

    // Método toString
    @Override
    public String toString() {
        return "\n\nEmpresa: " +
               "nombre='" + nombre + '\'' +
               ", direccion='" + direccion + '\'' +
               ", cif='" + cif + '\'' +
               ", telefono='" + telefono + '\'' +
               ", email='" + email + '\'' +
               ';';
    }
}
