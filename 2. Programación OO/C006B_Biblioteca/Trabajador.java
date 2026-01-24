/**
 * Clase que representa un trabajador de la biblioteca.
 * Hereda de la clase abstracta Persona e incorpora información del cargo.
 */
public class Trabajador extends Persona {
    /** Cargo o puesto de trabajo del trabajador */
    private String cargo;

    /**
     * Constructor completo para crear un nuevo trabajador.
     *
     * @param dni       El DNI del trabajador (debe ser único)
     * @param nombre    El nombre del trabajador
     * @param apellidos Los apellidos del trabajador
     * @param cargo     El cargo o puesto de trabajo del trabajador
     */
    public Trabajador(String dni, String nombre, String apellidos, String cargo) {
        super(dni, nombre, apellidos);
        this.cargo = cargo;
    }

    /**
     * Obtiene el cargo del trabajador.
     *
     * @return El cargo o puesto de trabajo del trabajador
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Establece el cargo del trabajador.
     *
     * @param cargo El nuevo cargo o puesto de trabajo del trabajador
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Compara si este trabajador es igual a otro objeto.
     * Dos trabajadores son iguales si tienen el mismo DNI.
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
     * Genera un código hash para este trabajador basado en su DNI.
     *
     * @return El código hash del trabajador
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Devuelve una representación en forma de cadena del trabajador.
     * Sobrescribe el método toString de la clase Persona.
     *
     * @return Una cadena con la información del trabajador formateada
     */
    @Override
    public String toString() {
        return String.format("%s | Cargo: %s", super.toString(), cargo);
    }
}
