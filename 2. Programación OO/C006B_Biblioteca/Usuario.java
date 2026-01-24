/**
 * Clase que representa un usuario de la biblioteca.
 * Hereda de la clase abstracta Persona e incorpora información de contacto.
 */
public class Usuario extends Persona {
    /** Número de teléfono del usuario */
    private String telefono;

    /**
     * Constructor completo para crear un nuevo usuario.
     *
     * @param dni       El DNI del usuario (debe ser único)
     * @param nombre    El nombre del usuario
     * @param apellidos Los apellidos del usuario
     * @param telefono  El número de teléfono del usuario
     */
    public Usuario(String dni, String nombre, String apellidos, String telefono) {
        super(dni, nombre, apellidos);
        this.telefono = telefono;
    }

    /**
     * Obtiene el teléfono del usuario.
     *
     * @return El número de teléfono del usuario
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del usuario.
     *
     * @param telefono El nuevo número de teléfono del usuario
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Compara si este usuario es igual a otro objeto.
     * Dos usuarios son iguales si tienen el mismo DNI.
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
        return super.equals(objeto);
    }

    /**
     * Genera un código hash para este usuario basado en su DNI.
     *
     * @return El código hash del usuario
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Devuelve una representación en forma de cadena del usuario.
     * Sobrescribe el método toString de la clase Persona.
     *
     * @return Una cadena con la información del usuario formateada
     */
    @Override
    public String toString() {
        return String.format("%s | Teléfono: %s", super.toString(), telefono);
    }
}
