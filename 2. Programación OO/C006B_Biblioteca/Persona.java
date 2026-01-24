/**
 * Clase abstracta que representa a una persona en el sistema de la biblioteca.
 * Esta clase contiene los atributos y métodos comunes para todas las personas
 * que interactúan con la biblioteca (usuarios y trabajadores).
 */
public abstract class Persona {
    /** Documento Nacional de Identidad único de la persona */
    private String dni;
    /** Nombre de la persona */
    private String nombre;
    /** Apellidos de la persona */
    private String apellidos;

    /**
     * Constructor completo para crear una nueva persona.
     *
     * @param dni       El DNI de la persona (debe ser único)
     * @param nombre    El nombre de la persona
     * @param apellidos Los apellidos de la persona
     */
    public Persona(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el DNI de la persona.
     *
     * @return El DNI de la persona
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI de la persona.
     *
     * @param dni El nuevo DNI de la persona
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nuevo nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos de la persona.
     *
     * @return Los apellidos de la persona
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos de la persona.
     *
     * @param apellidos Los nuevos apellidos de la persona
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Compara si esta persona es igual a otro objeto.
     * Dos personas son iguales si tienen el mismo DNI.
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
        Persona otraPersona = (Persona) objeto;
        if (dni == null) {
            return otraPersona.dni == null;
        }
        return dni.equals(otraPersona.dni);
    }

    /**
     * Genera un código hash para esta persona basado en su DNI.
     *
     * @return El código hash de la persona
     */
    @Override
    public int hashCode() {
        if (dni == null) {
            return 0;
        }
        return dni.hashCode();
    }

    /**
     * Devuelve una representación en forma de cadena de la persona.
     *
     * @return Una cadena con la información básica de la persona
     */
    @Override
    public String toString() {
        return String.format("DNI: %s | Nombre: %s %s", dni, nombre, apellidos);
    }
}
