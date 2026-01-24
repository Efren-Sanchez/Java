/**
 * Clase principal que gestiona todos los elementos de la biblioteca.
 * Controla los arrays de libros, usuarios, trabajadores y préstamos,
 * así como las operaciones CRUD sobre cada uno de ellos.
 */
public class Biblioteca {
    /** Número máximo de libros que puede almacenar la biblioteca */
    private static final int MAX_LIBROS = 100;
    /** Número máximo de usuarios que puede tener la biblioteca */
    private static final int MAX_USUARIOS = 50;
    /** Número máximo de trabajadores que puede tener la biblioteca */
    private static final int MAX_TRABAJADORES = 20;
    /** Número máximo de préstamos que puede gestionar la biblioteca */
    private static final int MAX_PRESTAMOS = 200;

    /** Array para almacenar los libros de la biblioteca */
    private Libro[] libros;
    /** Array para almacenar los usuarios de la biblioteca */
    private Usuario[] usuarios;
    /** Array para almacenar los trabajadores de la biblioteca */
    private Trabajador[] trabajadores;
    /** Array para almacenar los préstamos de la biblioteca */
    private Prestamo[] prestamos;

    /** Contador del número actual de libros registrados */
    private int contadorLibros;
    /** Contador del número actual de usuarios registrados */
    private int contadorUsuarios;
    /** Contador del número actual de trabajadores registrados */
    private int contadorTrabajadores;
    /** Contador del número actual de préstamos registrados */
    private int contadorPrestamos;
    /** Contador para asignar IDs únicos a los préstamos */
    private int siguienteIdPrestamo;

    /**
     * Constructor que inicializa la biblioteca con todos los arrays vacíos
     * y los contadores a cero.
     */
    public Biblioteca() {
        this.libros = new Libro[MAX_LIBROS];
        this.usuarios = new Usuario[MAX_USUARIOS];
        this.trabajadores = new Trabajador[MAX_TRABAJADORES];
        this.prestamos = new Prestamo[MAX_PRESTAMOS];
        this.contadorLibros = 0;
        this.contadorUsuarios = 0;
        this.contadorTrabajadores = 0;
        this.contadorPrestamos = 0;
        this.siguienteIdPrestamo = 1;
    }

    // ==================== MÉTODOS DE LIBROS ====================

    /**
     * Da de alta un nuevo libro en la biblioteca.
     *
     * @param libro El objeto libro a añadir
     * @return true si se añadió correctamente, false si el array está lleno
     *         o ya existe un libro con el mismo ISBN
     */
    public boolean altaLibro(Libro libro) {
        if (contadorLibros >= MAX_LIBROS) {
            return false;
        }

        // Verificar que no existe un libro con el mismo ISBN
        if (buscarLibroPorIsbn(libro.getIsbn()) != null) {
            return false;
        }

        libros[contadorLibros] = libro;
        contadorLibros++;
        return true;
    }

    /**
     * Da de baja un libro de la biblioteca buscando por ISBN.
     *
     * @param isbn El ISBN del libro a eliminar
     * @return true si se eliminó correctamente, false si no se encontró el libro
     */
    public boolean bajaLibro(String isbn) {
        int indice = buscarIndiceLibroPorIsbn(isbn);
        if (indice == -1) {
            return false;
        }

        // Desplazar todos los elementos siguientes una posición a la izquierda
        for (int i = indice; i < contadorLibros - 1; i++) {
            libros[i] = libros[i + 1];
        }
        libros[contadorLibros - 1] = null;
        contadorLibros--;
        return true;
    }

    /**
     * Modifica los datos de un libro existente.
     *
     * @param isbn      El ISBN del libro a modificar
     * @param nuevoLibro El objeto libro con los nuevos datos
     * @return true si se modificó correctamente, false si no se encontró el libro
     */
    public boolean modificarLibro(String isbn, Libro nuevoLibro) {
        int indice = buscarIndiceLibroPorIsbn(isbn);
        if (indice == -1) {
            return false;
        }

        // Actualizar los campos del libro
        libros[indice].setTitulo(nuevoLibro.getTitulo());
        libros[indice].setAutor(nuevoLibro.getAutor());
        libros[indice].setGenero(nuevoLibro.getGenero());
        // Mantenemos la disponibilidad actual del libro
        return true;
    }

    /**
     * Busca un libro por su ISBN.
     *
     * @param isbn El ISBN del libro a buscar
     * @return El libro encontrado o null si no existe
     */
    public Libro buscarLibroPorIsbn(String isbn) {
        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i].getIsbn().equals(isbn)) {
                return libros[i];
            }
        }
        return null;
    }

    /**
     * Busca libros por título o autor que contengan el texto de búsqueda.
     *
     * @param texto El texto a buscar en el título o autor
     * @return Un array con los libros encontrados
     */
    public Libro[] buscarLibrosPorTexto(String texto) {
        Libro[] resultados = new Libro[MAX_LIBROS];
        int contador = 0;

        for (int i = 0; i < contadorLibros; i++) {
            String titulo = libros[i].getTitulo().toLowerCase();
            String autor = libros[i].getAutor().toLowerCase();
            String busqueda = texto.toLowerCase();

            if (titulo.contains(busqueda) || autor.contains(busqueda)) {
                resultados[contador] = libros[i];
                contador++;
            }
        }
        return resultados;
    }

    /**
     * Obtiene todos los libros de la biblioteca.
     *
     * @return Un array con todos los libros
     */
    public Libro[] getTodosLosLibros() {
        Libro[] resultado = new Libro[contadorLibros];
        for (int i = 0; i < contadorLibros; i++) {
            resultado[i] = libros[i];
        }
        return resultado;
    }

    /**
     * Obtiene el número de libros registrados.
     *
     * @return El número de libros
     */
    public int getNumeroLibros() {
        return contadorLibros;
    }

    /**
     * Busca el índice de un libro por su ISBN.
     *
     * @param isbn El ISBN del libro a buscar
     * @return El índice del libro en el array o -1 si no existe
     */
    private int buscarIndiceLibroPorIsbn(String isbn) {
        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i].getIsbn().equals(isbn)) {
                return i;
            }
        }
        return -1;
    }

    // ==================== MÉTODOS DE USUARIOS ====================

    /**
     * Da de alta un nuevo usuario en la biblioteca.
     *
     * @param usuario El objeto usuario a añadir
     * @return true si se añadió correctamente, false si el array está lleno
     *         o ya existe un usuario con el mismo DNI
     */
    public boolean altaUsuario(Usuario usuario) {
        if (contadorUsuarios >= MAX_USUARIOS) {
            return false;
        }

        // Verificar que no existe un usuario con el mismo DNI
        if (buscarUsuarioPorDni(usuario.getDni()) != null) {
            return false;
        }

        usuarios[contadorUsuarios] = usuario;
        contadorUsuarios++;
        return true;
    }

    /**
     * Da de baja un usuario de la biblioteca buscando por DNI.
     *
     * @param dni El DNI del usuario a eliminar
     * @return true si se eliminó correctamente, false si no se encontró el usuario
     */
    public boolean bajaUsuario(String dni) {
        int indice = buscarIndiceUsuarioPorDni(dni);
        if (indice == -1) {
            return false;
        }

        // Desplazar todos los elementos siguientes una posición a la izquierda
        for (int i = indice; i < contadorUsuarios - 1; i++) {
            usuarios[i] = usuarios[i + 1];
        }
        usuarios[contadorUsuarios - 1] = null;
        contadorUsuarios--;
        return true;
    }

    /**
     * Modifica los datos de un usuario existente.
     *
     * @param dni        El DNI del usuario a modificar
     * @param nuevoUsuario El objeto usuario con los nuevos datos
     * @return true si se modificó correctamente, false si no se encontró el usuario
     */
    public boolean modificarUsuario(String dni, Usuario nuevoUsuario) {
        int indice = buscarIndiceUsuarioPorDni(dni);
        if (indice == -1) {
            return false;
        }

        // Actualizar los campos del usuario (mantenemos el DNI)
        usuarios[indice].setNombre(nuevoUsuario.getNombre());
        usuarios[indice].setApellidos(nuevoUsuario.getApellidos());
        usuarios[indice].setTelefono(nuevoUsuario.getTelefono());
        return true;
    }

    /**
     * Busca un usuario por su DNI.
     *
     * @param dni El DNI del usuario a buscar
     * @return El usuario encontrado o null si no existe
     */
    public Usuario buscarUsuarioPorDni(String dni) {
        for (int i = 0; i < contadorUsuarios; i++) {
            if (usuarios[i].getDni().equals(dni)) {
                return usuarios[i];
            }
        }
        return null;
    }

    /**
     * Busca usuarios por nombre o apellidos que contengan el texto de búsqueda.
     *
     * @param texto El texto a buscar en el nombre o apellidos
     * @return Un array con los usuarios encontrados
     */
    public Usuario[] buscarUsuariosPorTexto(String texto) {
        Usuario[] resultados = new Usuario[MAX_USUARIOS];
        int contador = 0;

        for (int i = 0; i < contadorUsuarios; i++) {
            String nombre = usuarios[i].getNombre().toLowerCase();
            String apellidos = usuarios[i].getApellidos().toLowerCase();
            String busqueda = texto.toLowerCase();

            if (nombre.contains(busqueda) || apellidos.contains(busqueda)) {
                resultados[contador] = usuarios[i];
                contador++;
            }
        }
        return resultados;
    }

    /**
     * Obtiene todos los usuarios de la biblioteca.
     *
     * @return Un array con todos los usuarios
     */
    public Usuario[] getTodosLosUsuarios() {
        Usuario[] resultado = new Usuario[contadorUsuarios];
        for (int i = 0; i < contadorUsuarios; i++) {
            resultado[i] = usuarios[i];
        }
        return resultado;
    }

    /**
     * Obtiene el número de usuarios registrados.
     *
     * @return El número de usuarios
     */
    public int getNumeroUsuarios() {
        return contadorUsuarios;
    }

    /**
     * Busca el índice de un usuario por su DNI.
     *
     * @param dni El DNI del usuario a buscar
     * @return El índice del usuario en el array o -1 si no existe
     */
    private int buscarIndiceUsuarioPorDni(String dni) {
        for (int i = 0; i < contadorUsuarios; i++) {
            if (usuarios[i].getDni().equals(dni)) {
                return i;
            }
        }
        return -1;
    }

    // ==================== MÉTODOS DE TRABAJADORES ====================

    /**
     * Da de alta un nuevo trabajador en la biblioteca.
     *
     * @param trabajador El objeto trabajador a añadir
     * @return true si se añadió correctamente, false si el array está lleno
     *         o ya existe un trabajador con el mismo DNI
     */
    public boolean altaTrabajador(Trabajador trabajador) {
        if (contadorTrabajadores >= MAX_TRABAJADORES) {
            return false;
        }

        // Verificar que no existe un trabajador con el mismo DNI
        if (buscarTrabajadorPorDni(trabajador.getDni()) != null) {
            return false;
        }

        trabajadores[contadorTrabajadores] = trabajador;
        contadorTrabajadores++;
        return true;
    }

    /**
     * Da de baja un trabajador de la biblioteca buscando por DNI.
     *
     * @param dni El DNI del trabajador a eliminar
     * @return true si se eliminó correctamente, false si no se encontró el trabajador
     */
    public boolean bajaTrabajador(String dni) {
        int indice = buscarIndiceTrabajadorPorDni(dni);
        if (indice == -1) {
            return false;
        }

        // Desplazar todos los elementos siguientes una posición a la izquierda
        for (int i = indice; i < contadorTrabajadores - 1; i++) {
            trabajadores[i] = trabajadores[i + 1];
        }
        trabajadores[contadorTrabajadores - 1] = null;
        contadorTrabajadores--;
        return true;
    }

    /**
     * Modifica los datos de un trabajador existente.
     *
     * @param dni           El DNI del trabajador a modificar
     * @param nuevoTrabajador El objeto trabajador con los nuevos datos
     * @return true si se modificó correctamente, false si no se encontró el trabajador
     */
    public boolean modificarTrabajador(String dni, Trabajador nuevoTrabajador) {
        int indice = buscarIndiceTrabajadorPorDni(dni);
        if (indice == -1) {
            return false;
        }

        // Actualizar los campos del trabajador (mantenemos el DNI)
        trabajadores[indice].setNombre(nuevoTrabajador.getNombre());
        trabajadores[indice].setApellidos(nuevoTrabajador.getApellidos());
        trabajadores[indice].setCargo(nuevoTrabajador.getCargo());
        return true;
    }

    /**
     * Busca un trabajador por su DNI.
     *
     * @param dni El DNI del trabajador a buscar
     * @return El trabajador encontrado o null si no existe
     */
    public Trabajador buscarTrabajadorPorDni(String dni) {
        for (int i = 0; i < contadorTrabajadores; i++) {
            if (trabajadores[i].getDni().equals(dni)) {
                return trabajadores[i];
            }
        }
        return null;
    }

    /**
     * Busca trabajadores por nombre, apellidos o cargo que contengan el texto de búsqueda.
     *
     * @param texto El texto a buscar en el nombre, apellidos o cargo
     * @return Un array con los trabajadores encontrados
     */
    public Trabajador[] buscarTrabajadoresPorTexto(String texto) {
        Trabajador[] resultados = new Trabajador[MAX_TRABAJADORES];
        int contador = 0;

        for (int i = 0; i < contadorTrabajadores; i++) {
            String nombre = trabajadores[i].getNombre().toLowerCase();
            String apellidos = trabajadores[i].getApellidos().toLowerCase();
            String cargo = trabajadores[i].getCargo().toLowerCase();
            String busqueda = texto.toLowerCase();

            if (nombre.contains(busqueda) || apellidos.contains(busqueda) || cargo.contains(busqueda)) {
                resultados[contador] = trabajadores[i];
                contador++;
            }
        }
        return resultados;
    }

    /**
     * Obtiene todos los trabajadores de la biblioteca.
     *
     * @return Un array con todos los trabajadores
     */
    public Trabajador[] getTodosLosTrabajadores() {
        Trabajador[] resultado = new Trabajador[contadorTrabajadores];
        for (int i = 0; i < contadorTrabajadores; i++) {
            resultado[i] = trabajadores[i];
        }
        return resultado;
    }

    /**
     * Obtiene el número de trabajadores registrados.
     *
     * @return El número de trabajadores
     */
    public int getNumeroTrabajadores() {
        return contadorTrabajadores;
    }

    /**
     * Busca el índice de un trabajador por su DNI.
     *
     * @param dni El DNI del trabajador a buscar
     * @return El índice del trabajador en el array o -1 si no existe
     */
    private int buscarIndiceTrabajadorPorDni(String dni) {
        for (int i = 0; i < contadorTrabajadores; i++) {
            if (trabajadores[i].getDni().equals(dni)) {
                return i;
            }
        }
        return -1;
    }

    // ==================== MÉTODOS DE PRÉSTAMOS ====================

    /**
     * Crea un nuevo préstamo de un libro a un usuario.
     *
     * @param isbnLibro     El ISBN del libro a prestar
     * @param dniUsuario    El DNI del usuario que solicita el préstamo
     * @param dniTrabajador El DNI del trabajador que realiza el préstamo
     * @param fechaInicio   La fecha de inicio del préstamo
     * @param fechaFin      La fecha de fin del préstamo
     * @return true si se creó el préstamo correctamente, false en caso de error
     */
    public boolean crearPrestamo(String isbnLibro, String dniUsuario, String dniTrabajador,
                                  String fechaInicio, String fechaFin) {
        // Verificar que el libro existe
        Libro libro = buscarLibroPorIsbn(isbnLibro);
        if (libro == null) {
            return false;
        }

        // Verificar que el libro está disponible
        if (!libro.isDisponible()) {
            return false;
        }

        // Verificar que el usuario existe
        if (buscarUsuarioPorDni(dniUsuario) == null) {
            return false;
        }

        // Verificar que el trabajador existe
        if (buscarTrabajadorPorDni(dniTrabajador) == null) {
            return false;
        }

        // Verificar que hay espacio para más préstamos
        if (contadorPrestamos >= MAX_PRESTAMOS) {
            return false;
        }

        // Crear el préstamo
        Prestamo prestamo = new Prestamo(siguienteIdPrestamo, isbnLibro, dniUsuario,
                dniTrabajador, fechaInicio, fechaFin);
        prestamos[contadorPrestamos] = prestamo;
        contadorPrestamos++;
        siguienteIdPrestamo++;

        // Marcar el libro como no disponible
        libro.setDisponible(false);

        return true;
    }

    /**
     * Finaliza un préstamo marcando el libro como devuelto.
     *
     * @param idPrestamo El ID del préstamo a finalizar
     * @return true si se completó la devolución, false si no se encontró el préstamo
     */
    public boolean devolverLibro(int idPrestamo) {
        Prestamo prestamo = buscarPrestamoPorId(idPrestamo);
        if (prestamo == null) {
            return false;
        }

        if (!prestamo.isActivo()) {
            return false; // El libro ya había sido devuelto
        }

        // Marcar el préstamo como inactivo
        prestamo.setActivo(false);

        // Marcar el libro como disponible
        Libro libro = buscarLibroPorIsbn(prestamo.getIsbnLibro());
        if (libro != null) {
            libro.setDisponible(true);
        }

        return true;
    }

    /**
     * Busca un préstamo por su ID.
     *
     * @param idPrestamo El ID del préstamo a buscar
     * @return El préstamo encontrado o null si no existe
     */
    public Prestamo buscarPrestamoPorId(int idPrestamo) {
        for (int i = 0; i < contadorPrestamos; i++) {
            if (prestamos[i].getIdPrestamo() == idPrestamo) {
                return prestamos[i];
            }
        }
        return null;
    }

    /**
     * Busca préstamos activos de un usuario.
     *
     * @param dniUsuario El DNI del usuario
     * @return Un array con los préstamos activos del usuario
     */
    public Prestamo[] buscarPrestamosPorUsuario(String dniUsuario) {
        Prestamo[] resultados = new Prestamo[MAX_PRESTAMOS];
        int contador = 0;

        for (int i = 0; i < contadorPrestamos; i++) {
            if (prestamos[i].getDniUsuario().equals(dniUsuario) && prestamos[i].isActivo()) {
                resultados[contador] = prestamos[i];
                contador++;
            }
        }
        return resultados;
    }

    /**
     * Busca préstamos por libro.
     *
     * @param isbnLibro El ISBN del libro
     * @return Un array con los préstamos del libro
     */
    public Prestamo[] buscarPrestamosPorLibro(String isbnLibro) {
        Prestamo[] resultados = new Prestamo[MAX_PRESTAMOS];
        int contador = 0;

        for (int i = 0; i < contadorPrestamos; i++) {
            if (prestamos[i].getIsbnLibro().equals(isbnLibro)) {
                resultados[contador] = prestamos[i];
                contador++;
            }
        }
        return resultados;
    }

    /**
     * Obtiene todos los préstamos de la biblioteca.
     *
     * @return Un array con todos los préstamos
     */
    public Prestamo[] getTodosLosPrestamos() {
        Prestamo[] resultado = new Prestamo[contadorPrestamos];
        for (int i = 0; i < contadorPrestamos; i++) {
            resultado[i] = prestamos[i];
        }
        return resultado;
    }

    /**
     * Obtiene todos los préstamos activos de la biblioteca.
     *
     * @return Un array con todos los préstamos activos
     */
    public Prestamo[] getPrestamosActivos() {
        Prestamo[] resultado = new Prestamo[contadorPrestamos];
        int contador = 0;

        for (int i = 0; i < contadorPrestamos; i++) {
            if (prestamos[i].isActivo()) {
                resultado[contador] = prestamos[i];
                contador++;
            }
        }

        // Crear un array del tamaño exacto
        Prestamo[] resultadoFinal = new Prestamo[contador];
        for (int i = 0; i < contador; i++) {
            resultadoFinal[i] = resultado[i];
        }
        return resultadoFinal;
    }

    /**
     * Obtiene el número de préstamos registrados.
     *
     * @return El número de préstamos
     */
    public int getNumeroPrestamos() {
        return contadorPrestamos;
    }

    /**
     * Obtiene el número de préstamos activos.
     *
     * @return El número de préstamos activos
     */
    public int getNumeroPrestamosActivos() {
        int contador = 0;
        for (int i = 0; i < contadorPrestamos; i++) {
            if (prestamos[i].isActivo()) {
                contador++;
            }
        }
        return contador;
    }

    // ==================== MÉTODOS DE CONSULTA ESTADÍSTICA ====================

    /**
     * Genera un informe con las estadísticas de la biblioteca.
     *
     * @return Una cadena con el informe estadístico
     */
    public String generarInformeEstadistico() {
        StringBuilder informe = new StringBuilder();
        informe.append("\n========================================\n");
        informe.append("    INFORME ESTADÍSTICO DE LA BIBLIOTECA\n");
        informe.append("========================================\n\n");

        informe.append(String.format("Libros registrados: %d / %d\n", contadorLibros, MAX_LIBROS));
        informe.append(String.format("Usuarios registrados: %d / %d\n", contadorUsuarios, MAX_USUARIOS));
        informe.append(String.format("Trabajadores registrados: %d / %d\n", contadorTrabajadores, MAX_TRABAJADORES));
        informe.append(String.format("Préstamos totales: %d\n", contadorPrestamos));
        informe.append(String.format("Préstamos activos: %d\n", getNumeroPrestamosActivos()));
        informe.append(String.format("Préstamos finalizados: %d\n", contadorPrestamos - getNumeroPrestamosActivos()));

        // Calcular libros disponibles
        int librosDisponibles = 0;
        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i].isDisponible()) {
                librosDisponibles++;
            }
        }
        informe.append(String.format("Libros disponibles: %d\n", librosDisponibles));
        informe.append(String.format("Libros en préstamo: %d\n", contadorLibros - librosDisponibles));

        // Calcular porcentaje de ocupación
        double ocupacionLibros = (contadorLibros * 100.0) / MAX_LIBROS;
        double ocupacionUsuarios = (contadorUsuarios * 100.0) / MAX_USUARIOS;
        double ocupacionPrestamos = (contadorPrestamos * 100.0) / MAX_PRESTAMOS;

        informe.append(String.format("\nPorcentaje de ocupación:\n"));
        informe.append(String.format("  - Libros: %.1f%%\n", ocupacionLibros));
        informe.append(String.format("  - Usuarios: %.1f%%\n", ocupacionUsuarios));
        informe.append(String.format("  - Préstamos: %.1f%%\n", ocupacionPrestamos));

        informe.append("\n========================================\n");
        return informe.toString();
    }
}
