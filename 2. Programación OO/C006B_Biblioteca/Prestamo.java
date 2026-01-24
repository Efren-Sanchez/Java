/**
 * Clase que representa un préstamo de un libro a un usuario.
 * Contiene información sobre el libro prestado, el usuario, las fechas y el estado del préstamo.
 */
public class Prestamo {
    /** Identificador único del préstamo */
    private int idPrestamo;
    /** ISBN del libro prestado */
    private String isbnLibro;
    /** DNI del usuario que realiza el préstamo */
    private String dniUsuario;
    /** DNI del trabajador que realiza el préstamo */
    private String dniTrabajador;
    /** Fecha de inicio del préstamo en formato dd/mm/yyyy */
    private String fechaInicio;
    /** Fecha de fin del préstamo en formato dd/mm/yyyy */
    private String fechaFin;
    /** Indica si el préstamo está activo (no ha sido devuelto) */
    private boolean activo;

    /**
     * Constructor completo para crear un nuevo préstamo.
     *
     * @param idPrestamo     El identificador único del préstamo
     * @param isbnLibro      El ISBN del libro prestado
     * @param dniUsuario     El DNI del usuario que realiza el préstamo
     * @param dniTrabajador  El DNI del trabajador que realiza el préstamo
     * @param fechaInicio    La fecha de inicio del préstamo
     * @param fechaFin       La fecha de fin del préstamo
     * @param activo         Indica si el préstamo está activo
     */
    public Prestamo(int idPrestamo, String isbnLibro, String dniUsuario,
                    String dniTrabajador, String fechaInicio, String fechaFin, boolean activo) {
        this.idPrestamo = idPrestamo;
        this.isbnLibro = isbnLibro;
        this.dniUsuario = dniUsuario;
        this.dniTrabajador = dniTrabajador;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activo = activo;
    }

    /**
     * Constructor simplificado que crea un préstamo activo.
     *
     * @param idPrestamo    El identificador único del préstamo
     * @param isbnLibro     El ISBN del libro prestado
     * @param dniUsuario    El DNI del usuario que realiza el préstamo
     * @param dniTrabajador El DNI del trabajador que realiza el préstamo
     * @param fechaInicio   La fecha de inicio del préstamo
     * @param fechaFin      La fecha de fin del préstamo
     */
    public Prestamo(int idPrestamo, String isbnLibro, String dniUsuario,
                    String dniTrabajador, String fechaInicio, String fechaFin) {
        this(idPrestamo, isbnLibro, dniUsuario, dniTrabajador, fechaInicio, fechaFin, true);
    }

    /**
     * Obtiene el identificador del préstamo.
     *
     * @return El identificador único del préstamo
     */
    public int getIdPrestamo() {
        return idPrestamo;
    }

    /**
     * Establece el identificador del préstamo.
     *
     * @param idPrestamo El nuevo identificador del préstamo
     */
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    /**
     * Obtiene el ISBN del libro prestado.
     *
     * @return El ISBN del libro prestado
     */
    public String getIsbnLibro() {
        return isbnLibro;
    }

    /**
     * Establece el ISBN del libro prestado.
     *
     * @param isbnLibro El nuevo ISBN del libro prestado
     */
    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    /**
     * Obtiene el DNI del usuario que realizó el préstamo.
     *
     * @return El DNI del usuario
     */
    public String getDniUsuario() {
        return dniUsuario;
    }

    /**
     * Establece el DNI del usuario que realizó el préstamo.
     *
     * @param dniUsuario El nuevo DNI del usuario
     */
    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    /**
     * Obtiene el DNI del trabajador que realizó el préstamo.
     *
     * @return El DNI del trabajador
     */
    public String getDniTrabajador() {
        return dniTrabajador;
    }

    /**
     * Establece el DNI del trabajador que realizó el préstamo.
     *
     * @param dniTrabajador El nuevo DNI del trabajador
     */
    public void setDniTrabajador(String dniTrabajador) {
        this.dniTrabajador = dniTrabajador;
    }

    /**
     * Obtiene la fecha de inicio del préstamo.
     *
     * @return La fecha de inicio en formato dd/mm/yyyy
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio del préstamo.
     *
     * @param fechaInicio La nueva fecha de inicio en formato dd/mm/yyyy
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de fin del préstamo.
     *
     * @return La fecha de fin en formato dd/mm/yyyy
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de fin del préstamo.
     *
     * @param fechaFin La nueva fecha de fin en formato dd/mm/yyyy
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Indica si el préstamo está activo.
     *
     * @return true si el préstamo está activo, false si ha sido devuelto
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Establece el estado del préstamo.
     *
     * @param activo true si el préstamo está activo, false si ha sido devuelto
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Compara si este préstamo es igual a otro objeto.
     * Dos préstamos son iguales si tienen el mismo ID de préstamo.
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
        Prestamo otroPrestamo = (Prestamo) objeto;
        return idPrestamo == otroPrestamo.idPrestamo;
    }

    /**
     * Genera un código hash para este préstamo basado en su ID.
     *
     * @return El código hash del préstamo
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(idPrestamo);
    }

    /**
     * Devuelve una representación en forma de cadena del préstamo.
     *
     * @return Una cadena con la información del préstamo formateada
     */
    @Override
    public String toString() {
        String estado = activo ? "Activo" : "Devuelto";
        return String.format("ID Préstamo: %d | Libro ISBN: %s | Usuario DNI: %s | " +
                        "Trabajador DNI: %s | Inicio: %s | Fin: %s | Estado: %s",
                idPrestamo, isbnLibro, dniUsuario, dniTrabajador,
                fechaInicio, fechaFin, estado);
    }
}
