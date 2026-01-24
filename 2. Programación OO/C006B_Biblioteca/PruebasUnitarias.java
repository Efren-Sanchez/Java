/**
 * Clase de pruebas unitarias para el Sistema de Gestión de Biblioteca.
 * Contiene métodos de prueba para verificar el correcto funcionamiento
 * de todas las clases del sistema.
 */
public class PruebasUnitarias {

    /** Contador de pruebaspassed */
    private static int pruebasPasadas = 0;
    /** Contador de pruebas fallidas */
    private static int pruebasFallidas = 0;

    /**
     * Método principal que ejecuta todas las pruebas unitarias.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("    PRUEBAS UNITARIAS - BIBLIOTECA");
        System.out.println("========================================\n");

        // Ejecutar pruebas de Libro
        ejecutarPrueba("PruebaEqualsLibrosIguales", pruebaEqualsLibrosIguales());
        ejecutarPrueba("PruebaEqualsLibrosDiferentes", pruebaEqualsLibrosDiferentes());
        ejecutarPrueba("PruebaEqualsLibroNull", pruebaEqualsLibroNull());
        ejecutarPrueba("PruebaHashCodeLibrosIguales", pruebaHashCodeLibrosIguales());

        // Ejecutar pruebas de Usuario
        ejecutarPrueba("PruebaEqualsUsuariosIguales", pruebaEqualsUsuariosIguales());
        ejecutarPrueba("PruebaEqualsUsuariosDiferentes", pruebaEqualsUsuariosDiferentes());
        ejecutarPrueba("PruebaEqualsUsuarioNull", pruebaEqualsUsuarioNull());

        // Ejecutar pruebas de Trabajador
        ejecutarPrueba("PruebaEqualsTrabajadoresIguales", pruebaEqualsTrabajadoresIguales());
        ejecutarPrueba("PruebaEqualsTrabajadoresDiferentes", pruebaEqualsTrabajadoresDiferentes());
        ejecutarPrueba("PruebaEqualsTrabajadorNull", pruebaEqualsTrabajadorNull());

        // Ejecutar pruebas de Prestamo
        ejecutarPrueba("PruebaEqualsPrestamosIguales", pruebaEqualsPrestamosIguales());
        ejecutarPrueba("PruebaEqualsPrestamosDiferentes", pruebaEqualsPrestamosDiferentes());
        ejecutarPrueba("PruebaEqualsPrestamoNull", pruebaEqualsPrestamoNull());

        // Ejecutar pruebas de Biblioteca
        ejecutarPrueba("PruebaAltaLibro", pruebaAltaLibro());
        ejecutarPrueba("PruebaAltaUsuario", pruebaAltaUsuario());
        ejecutarPrueba("PruebaAltaTrabajador", pruebaAltaTrabajador());
        ejecutarPrueba("PruebaDuplicadoLibro", pruebaDuplicadoLibro());
        ejecutarPrueba("PruebaDuplicadoUsuario", pruebaDuplicadoUsuario());
        ejecutarPrueba("PruebaPrestamoCompleto", pruebaPrestamoCompleto());

        // Mostrar resumen de resultados
        mostrarResumen();
    }

    /**
     * Imprime el resultado de una prueba.
     *
     * @param nombrePrueba El nombre de la prueba
     * @param passed       true si la prueba pasó, false si falló
     */
    private static void ejecutarPrueba(String nombrePrueba, boolean passed) {
        if (passed) {
            System.out.println("[PASÓ] " + nombrePrueba);
            pruebasPasadas++;
        } else {
            System.out.println("[FALLÓ] " + nombrePrueba);
            pruebasFallidas++;
        }
    }

    /**
     * Muestra el resumen final de las pruebas.
     */
    private static void mostrarResumen() {
        System.out.println("\n========================================");
        System.out.println("         RESUMEN DE PRUEBAS");
        System.out.println("========================================");
        System.out.println("Pruebas pasadas: " + pruebasPasadas);
        System.out.println("Pruebas fallidas: " + pruebasFallidas);
        System.out.println("Total de pruebas: " + (pruebasPasadas + pruebasFallidas));
        System.out.println("========================================\n");

        if (pruebasFallidas == 0) {
            System.out.println("¡Todas las pruebas pasaron correctamente!");
        } else {
            System.out.println("Hay " + pruebasFallidas + " prueba(s) que requieren atención.");
        }
    }

    // ==================== PRUEBAS DE LIBRO ====================

    /**
     * Prueba que dos libros con el mismo ISBN son iguales.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaEqualsLibrosIguales() {
        Libro libro1 = new Libro("978-84-253-1234-5", "El Quijote", "Miguel de Cervantes", "Clásico");
        Libro libro2 = new Libro("978-84-253-1234-5", "El Quijote (Edición especial)", "M. de Cervantes", "Clásico");
        return libro1.equals(libro2);
    }

    /**
     * Prueba que dos libros con diferente ISBN no son iguales.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaEqualsLibrosDiferentes() {
        Libro libro1 = new Libro("978-84-253-1234-5", "El Quijote", "Miguel de Cervantes", "Clásico");
        Libro libro2 = new Libro("978-84-253-5678-9", "Cien Años de Soledad", "Gabriel García Márquez", "Novela");
        return !libro1.equals(libro2);
    }

    /**
     * Prueba que un libro no es igual a null.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaEqualsLibroNull() {
        Libro libro = new Libro("978-84-253-1234-5", "El Quijote", "Miguel de Cervantes", "Clásico");
        return !libro.equals(null);
    }

    /**
     * Prueba que dos libros con el mismo ISBN tienen el mismo hashCode.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaHashCodeLibrosIguales() {
        Libro libro1 = new Libro("978-84-253-1234-5", "El Quijote", "Miguel de Cervantes", "Clásico");
        Libro libro2 = new Libro("978-84-253-1234-5", "El Quijote", "M. de Cervantes", "Clásico");
        return libro1.hashCode() == libro2.hashCode();
    }

    // ==================== PRUEBAS DE USUARIO ====================

    /**
     * Prueba que dos usuarios con el mismo DNI son iguales.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaEqualsUsuariosIguales() {
        Usuario usuario1 = new Usuario("12345678A", "Juan", "García López", "612345678");
        Usuario usuario2 = new Usuario("12345678A", "Juan Antonio", "García", "611111111");
        return usuario1.equals(usuario2);
    }

    /**
     * Prueba que dos usuarios con diferente DNI no son iguales.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaEqualsUsuariosDiferentes() {
        Usuario usuario1 = new Usuario("12345678A", "Juan", "García López", "612345678");
        Usuario usuario2 = new Usuario("87654321Z", "Juan", "García López", "612345678");
        return !usuario1.equals(usuario2);
    }

    /**
     * Prueba que un usuario no es igual a null.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaEqualsUsuarioNull() {
        Usuario usuario = new Usuario("12345678A", "Juan", "García López", "612345678");
        return !usuario.equals(null);
    }

    // ==================== PRUEBAS DE TRABAJADOR ====================

    /**
     * Prueba que dos trabajadores con el mismo DNI son iguales.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaEqualsTrabajadoresIguales() {
        Trabajador trabajador1 = new Trabajador("12345678A", "María", "Fernández Ruiz", "Bibliotecaria");
        Trabajador trabajador2 = new Trabajador("12345678A", "María José", "Fernández", "Ayudante de biblioteca");
        return trabajador1.equals(trabajador2);
    }

    /**
     * Prueba que dos trabajadores con diferente DNI no son iguales.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaEqualsTrabajadoresDiferentes() {
        Trabajador trabajador1 = new Trabajador("12345678A", "María", "Fernández Ruiz", "Bibliotecaria");
        Trabajador trabajador2 = new Trabajador("87654321Z", "María", "Fernández Ruiz", "Bibliotecaria");
        return !trabajador1.equals(trabajador2);
    }

    /**
     * Prueba que un trabajador no es igual a null.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaEqualsTrabajadorNull() {
        Trabajador trabajador = new Trabajador("12345678A", "María", "Fernández Ruiz", "Bibliotecaria");
        return !trabajador.equals(null);
    }

    // ==================== PRUEBAS DE PRÉSTAMO ====================

    /**
     * Prueba que dos préstamos con el mismo ID son iguales.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaEqualsPrestamosIguales() {
        Prestamo prestamo1 = new Prestamo(1, "978-84-253-1234-5", "12345678A", "87654321Z", "01/01/2024", "15/01/2024");
        Prestamo prestamo2 = new Prestamo(1, "978-84-253-5678-9", "11111111B", "22222222C", "02/01/2024", "16/01/2024");
        return prestamo1.equals(prestamo2);
    }

    /**
     * Prueba que dos préstamos con diferente ID no son iguales.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaEqualsPrestamosDiferentes() {
        Prestamo prestamo1 = new Prestamo(1, "978-84-253-1234-5", "12345678A", "87654321Z", "01/01/2024", "15/01/2024");
        Prestamo prestamo2 = new Prestamo(2, "978-84-253-1234-5", "12345678A", "87654321Z", "01/01/2024", "15/01/2024");
        return !prestamo1.equals(prestamo2);
    }

    /**
     * Prueba que un préstamo no es igual a null.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaEqualsPrestamoNull() {
        Prestamo prestamo = new Prestamo(1, "978-84-253-1234-5", "12345678A", "87654321Z", "01/01/2024", "15/01/2024");
        return !prestamo.equals(null);
    }

    // ==================== PRUEBAS DE BIBLIOTECA ====================

    /**
     * Prueba el alta de un libro en la biblioteca.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaAltaLibro() {
        Biblioteca biblioteca = new Biblioteca();
        Libro libro = new Libro("978-84-253-1234-5", "El Quijote", "Miguel de Cervantes", "Clásico");
        return biblioteca.altaLibro(libro) && biblioteca.getNumeroLibros() == 1;
    }

    /**
     * Prueba el alta de un usuario en la biblioteca.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaAltaUsuario() {
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario = new Usuario("12345678A", "Juan", "García López", "612345678");
        return biblioteca.altaUsuario(usuario) && biblioteca.getNumeroUsuarios() == 1;
    }

    /**
     * Prueba el alta de un trabajador en la biblioteca.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaAltaTrabajador() {
        Biblioteca biblioteca = new Biblioteca();
        Trabajador trabajador = new Trabajador("12345678A", "María", "Fernández Ruiz", "Bibliotecaria");
        return biblioteca.altaTrabajador(trabajador) && biblioteca.getNumeroTrabajadores() == 1;
    }

    /**
     * Prueba que no se puede dar de alta un libro con ISBN duplicado.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaDuplicadoLibro() {
        Biblioteca biblioteca = new Biblioteca();
        Libro libro1 = new Libro("978-84-253-1234-5", "El Quijote", "Miguel de Cervantes", "Clásico");
        Libro libro2 = new Libro("978-84-253-1234-5", "El Quijote (otra edición)", "M. de Cervantes", "Clásico");

        boolean primero = biblioteca.altaLibro(libro1);
        boolean segundo = biblioteca.altaLibro(libro2);

        return primero && !segundo && biblioteca.getNumeroLibros() == 1;
    }

    /**
     * Prueba que no se puede dar de alta un usuario con DNI duplicado.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaDuplicadoUsuario() {
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario1 = new Usuario("12345678A", "Juan", "García López", "612345678");
        Usuario usuario2 = new Usuario("12345678A", "Juan Antonio", "García", "611111111");

        boolean primero = biblioteca.altaUsuario(usuario1);
        boolean segundo = biblioteca.altaUsuario(usuario2);

        return primero && !segundo && biblioteca.getNumeroUsuarios() == 1;
    }

    /**
     * Prueba completa del flujo de préstamo: alta, préstamo y devolución.
     *
     * @return true si la prueba pasó, false si falló
     */
    private static boolean pruebaPrestamoCompleto() {
        Biblioteca biblioteca = new Biblioteca();

        // Alta de libro, usuario y trabajador
        Libro libro = new Libro("978-84-253-1234-5", "El Quijote", "Miguel de Cervantes", "Clásico");
        Usuario usuario = new Usuario("12345678A", "Juan", "García López", "612345678");
        Trabajador trabajador = new Trabajador("87654321Z", "María", "Fernández Ruiz", "Bibliotecaria");

        biblioteca.altaLibro(libro);
        biblioteca.altaUsuario(usuario);
        biblioteca.altaTrabajador(trabajador);

        // Crear préstamo
        boolean creado = biblioteca.crearPrestamo(
                "978-84-253-1234-5",
                "12345678A",
                "87654321Z",
                "01/01/2024",
                "15/01/2024"
        );

        // Verificar que el libro no está disponible
        boolean libroNoDisponible = !biblioteca.buscarLibroPorIsbn("978-84-253-1234-5").isDisponible();

        // Verificar préstamo activo
        Prestamo[] prestamosActivos = biblioteca.getPrestamosActivos();
        boolean hayPrestamoActivo = prestamosActivos.length > 1 && prestamosActivos[0] != null;

        // Devolver libro
        boolean devuelto = biblioteca.devolverLibro(1);

        // Verificar que el libro está disponible
        boolean libroDisponible = biblioteca.buscarLibroPorIsbn("978-84-253-1234-5").isDisponible();

        return creado && libroNoDisponible && hayPrestamoActivo && devuelto && libroDisponible;
    }
}
