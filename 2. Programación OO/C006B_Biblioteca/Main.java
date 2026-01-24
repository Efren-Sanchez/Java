import java.util.Scanner;

/**
 * Clase principal que contiene el menú y la interfaz de línea de comandos
 * para gestionar la biblioteca. Permite al usuario interactuar con todas
 * las funcionalidades de la biblioteca a través de un menú console.
 */
public class Main {
    /** Objeto Scanner para leer la entrada del usuario */
    private static Scanner scanner = new Scanner(System.in);
    /** Objeto Biblioteca que gestiona todos los datos */
    private static Biblioteca biblioteca = new Biblioteca();

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    menuGestionLibros();
                    break;
                case 2:
                    menuGestionUsuarios();
                    break;
                case 3:
                    menuGestionTrabajadores();
                    break;
                case 4:
                    menuGestionPrestamos();
                    break;
                case 5:
                    System.out.println("\n¡Gracias por usar el Sistema de Gestión de Biblioteca!");
                    System.out.println("¡Hasta luego!");
                    continuar = false;
                    break;
                default:
                    System.out.println("\n[ERROR] Opción no válida. Por favor, seleccione una opción del 1 al 5.");
            }
        }

        scanner.close();
    }

    /**
     * Muestra el menú principal de la aplicación.
     */
    private static void mostrarMenuPrincipal() {
        System.out.println("\n========================================");
        System.out.println("    SISTEMA DE GESTIÓN DE BIBLIOTECA");
        System.out.println("========================================");
        System.out.println("1. Gestión de Libros");
        System.out.println("2. Gestión de Usuarios");
        System.out.println("3. Gestión de Trabajadores");
        System.out.println("4. Gestión de Préstamos");
        System.out.println("5. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Lee una opción numérica del usuario.
     *
     * @return La opción seleccionada como número entero
     */
    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Lee una cadena de texto del usuario.
     *
     * @return La cadena introducida por el usuario
     */
    private static String leerTexto() {
        return scanner.nextLine();
    }

    /**
     * Lee un valor booleano del usuario (s/n).
     *
     * @return true si el usuario introduce 's' o 'S', false en caso contrario
     */
    private static boolean leerBooleano() {
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("s");
    }

    // ==================== MENÚ DE GESTIÓN DE LIBROS ====================

    /**
     * Muestra el submenú de gestión de libros y procesa las opciones.
     */
    private static void menuGestionLibros() {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n========================================");
            System.out.println("         GESTIÓN DE LIBROS");
            System.out.println("========================================");
            System.out.println("1. Dar de alta un nuevo libro");
            System.out.println("2. Dar de baja un libro");
            System.out.println("3. Modificar datos de un libro");
            System.out.println("4. Listar todos los libros");
            System.out.println("5. Buscar libro por ISBN");
            System.out.println("6. Buscar libros por título o autor");
            System.out.println("7. Volver al menú principal");
            System.out.println("========================================");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    altaLibro();
                    break;
                case 2:
                    bajaLibro();
                    break;
                case 3:
                    modificarLibro();
                    break;
                case 4:
                    listarLibros();
                    break;
                case 5:
                    buscarLibroPorIsbn();
                    break;
                case 6:
                    buscarLibrosPorTexto();
                    break;
                case 7:
                    System.out.println("\n[VUELTA] Volviendo al menú principal...");
                    volver = true;
                    break;
                default:
                    System.out.println("\n[ERROR] Opción no válida.");
            }
        }
    }

    /**
     * Solicita los datos de un libro y lo da de alta en la biblioteca.
     */
    private static void altaLibro() {
        System.out.println("\n--- Alta de Nuevo Libro ---");

        System.out.print("Introduzca el ISBN del libro: ");
        String isbn = leerTexto();

        // Verificar si el libro ya existe
        if (biblioteca.buscarLibroPorIsbn(isbn) != null) {
            System.out.println("\n[ERROR] Ya existe un libro con el ISBN: " + isbn);
            return;
        }

        System.out.print("Introduzca el título del libro: ");
        String titulo = leerTexto();

        System.out.print("Introduzca el autor del libro: ");
        String autor = leerTexto();

        System.out.print("Introduzca el género del libro: ");
        String genero = leerTexto();

        Libro libro = new Libro(isbn, titulo, autor, genero);

        if (biblioteca.altaLibro(libro)) {
            System.out.println("\n[ÉXITO] Libro dado de alta correctamente.");
        } else {
            System.out.println("\n[ERROR] No se pudo dar de alta el libro. La biblioteca está llena.");
        }
    }

    /**
     * Solicita el ISBN de un libro y lo da de baja de la biblioteca.
     */
    private static void bajaLibro() {
        System.out.println("\n--- Baja de Libro ---");

        System.out.print("Introduzca el ISBN del libro a eliminar: ");
        String isbn = leerTexto();

        // Verificar si el libro existe
        if (biblioteca.buscarLibroPorIsbn(isbn) == null) {
            System.out.println("\n[ERROR] No se encontró ningún libro con el ISBN: " + isbn);
            return;
        }

        // Verificar si el libro está en préstamo
        Prestamo[] prestamos = biblioteca.buscarPrestamosPorLibro(isbn);
        boolean tienePrestamosActivos = false;
        for (Prestamo p : prestamos) {
            if (p != null && p.isActivo()) {
                tienePrestamosActivos = true;
                break;
            }
        }

        if (tienePrestamosActivos) {
            System.out.println("\n[ERROR] No se puede eliminar el libro porque tiene préstamos activos.");
            return;
        }

        if (biblioteca.bajaLibro(isbn)) {
            System.out.println("\n[ÉXITO] Libro dado de baja correctamente.");
        } else {
            System.out.println("\n[ERROR] No se pudo dar de baja el libro.");
        }
    }

    /**
     * Solicita el ISBN de un libro y sus nuevos datos, y lo modifica.
     */
    private static void modificarLibro() {
        System.out.println("\n--- Modificación de Libro ---");

        System.out.print("Introduzca el ISBN del libro a modificar: ");
        String isbn = leerTexto();

        // Verificar si el libro existe
        if (biblioteca.buscarLibroPorIsbn(isbn) == null) {
            System.out.println("\n[ERROR] No se encontró ningún libro con el ISBN: " + isbn);
            return;
        }

        System.out.print("Introduzca el nuevo título del libro: ");
        String titulo = leerTexto();

        System.out.print("Introduzca el nuevo autor del libro: ");
        String autor = leerTexto();

        System.out.print("Introduzca el nuevo género del libro: ");
        String genero = leerTexto();

        Libro nuevoLibro = new Libro(isbn, titulo, autor, genero);

        if (biblioteca.modificarLibro(isbn, nuevoLibro)) {
            System.out.println("\n[ÉXITO] Libro modificado correctamente.");
        } else {
            System.out.println("\n[ERROR] No se pudo modificar el libro.");
        }
    }

    /**
     * Lista todos los libros registrados en la biblioteca.
     */
    private static void listarLibros() {
        System.out.println("\n--- Listado de Libros ---");

        Libro[] libros = biblioteca.getTodosLosLibros();

        if (libros.length == 0 || libros[0] == null) {
            System.out.println("\n[INFO] No hay libros registrados en la biblioteca.");
            return;
        }

        System.out.println("\nNúmero de libros: " + biblioteca.getNumeroLibros());
        System.out.println("--------------------------------------------------");
        for (Libro libro : libros) {
            if (libro != null) {
                System.out.println(libro.toString());
            }
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     * Busca un libro por su ISBN y muestra sus datos.
     */
    private static void buscarLibroPorIsbn() {
        System.out.println("\n--- Búsqueda de Libro por ISBN ---");

        System.out.print("Introduzca el ISBN del libro a buscar: ");
        String isbn = leerTexto();

        Libro libro = biblioteca.buscarLibroPorIsbn(isbn);

        if (libro == null) {
            System.out.println("\n[INFO] No se encontró ningún libro con el ISBN: " + isbn);
        } else {
            System.out.println("\n[RESULTADO] Libro encontrado:");
            System.out.println(libro.toString());
        }
    }

    /**
     * Busca libros por título o autor y muestra los resultados.
     */
    private static void buscarLibrosPorTexto() {
        System.out.println("\n--- Búsqueda de Libros por Título o Autor ---");

        System.out.print("Introduzca el texto de búsqueda: ");
        String texto = leerTexto();

        Libro[] resultados = biblioteca.buscarLibrosPorTexto(texto);

        System.out.println("\n[RESULTADOS] Libros encontrados (" +
                contarElementos(resultados) + "):");
        System.out.println("--------------------------------------------------");

        for (Libro libro : resultados) {
            if (libro != null) {
                System.out.println(libro.toString());
            }
        }
        System.out.println("--------------------------------------------------");
    }

    // ==================== MENÚ DE GESTIÓN DE USUARIOS ====================

    /**
     * Muestra el submenú de gestión de usuarios y procesa las opciones.
     */
    private static void menuGestionUsuarios() {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n========================================");
            System.out.println("         GESTIÓN DE USUARIOS");
            System.out.println("========================================");
            System.out.println("1. Dar de alta un nuevo usuario");
            System.out.println("2. Dar de baja un usuario");
            System.out.println("3. Modificar datos de un usuario");
            System.out.println("4. Listar todos los usuarios");
            System.out.println("5. Buscar usuario por DNI");
            System.out.println("6. Buscar usuarios por nombre o apellidos");
            System.out.println("7. Volver al menú principal");
            System.out.println("========================================");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    altaUsuario();
                    break;
                case 2:
                    bajaUsuario();
                    break;
                case 3:
                    modificarUsuario();
                    break;
                case 4:
                    listarUsuarios();
                    break;
                case 5:
                    buscarUsuarioPorDni();
                    break;
                case 6:
                    buscarUsuariosPorTexto();
                    break;
                case 7:
                    System.out.println("\n[VUELTA] Volviendo al menú principal...");
                    volver = true;
                    break;
                default:
                    System.out.println("\n[ERROR] Opción no válida.");
            }
        }
    }

    /**
     * Solicita los datos de un usuario y lo da de alta en la biblioteca.
     */
    private static void altaUsuario() {
        System.out.println("\n--- Alta de Nuevo Usuario ---");

        System.out.print("Introduzca el DNI del usuario: ");
        String dni = leerTexto();

        // Verificar si el usuario ya existe
        if (biblioteca.buscarUsuarioPorDni(dni) != null) {
            System.out.println("\n[ERROR] Ya existe un usuario con el DNI: " + dni);
            return;
        }

        System.out.print("Introduzca el nombre del usuario: ");
        String nombre = leerTexto();

        System.out.print("Introduzca los apellidos del usuario: ");
        String apellidos = leerTexto();

        System.out.print("Introduzca el teléfono del usuario: ");
        String telefono = leerTexto();

        Usuario usuario = new Usuario(dni, nombre, apellidos, telefono);

        if (biblioteca.altaUsuario(usuario)) {
            System.out.println("\n[ÉXITO] Usuario dado de alta correctamente.");
        } else {
            System.out.println("\n[ERROR] No se pudo dar de alta el usuario. Capacidad máxima alcanzada.");
        }
    }

    /**
     * Solicita el DNI de un usuario y lo da de baja de la biblioteca.
     */
    private static void bajaUsuario() {
        System.out.println("\n--- Baja de Usuario ---");

        System.out.print("Introduzca el DNI del usuario a eliminar: ");
        String dni = leerTexto();

        // Verificar si el usuario existe
        if (biblioteca.buscarUsuarioPorDni(dni) == null) {
            System.out.println("\n[ERROR] No se encontró ningún usuario con el DNI: " + dni);
            return;
        }

        // Verificar si el usuario tiene préstamos activos
        Prestamo[] prestamos = biblioteca.buscarPrestamosPorUsuario(dni);
        boolean tienePrestamosActivos = false;
        for (Prestamo p : prestamos) {
            if (p != null) {
                tienePrestamosActivos = true;
                break;
            }
        }

        if (tienePrestamosActivos) {
            System.out.println("\n[ERROR] No se puede eliminar el usuario porque tiene préstamos activos.");
            return;
        }

        if (biblioteca.bajaUsuario(dni)) {
            System.out.println("\n[ÉXITO] Usuario dado de baja correctamente.");
        } else {
            System.out.println("\n[ERROR] No se pudo dar de baja el usuario.");
        }
    }

    /**
     * Solicita el DNI de un usuario y sus nuevos datos, y lo modifica.
     */
    private static void modificarUsuario() {
        System.out.println("\n--- Modificación de Usuario ---");

        System.out.print("Introduzca el DNI del usuario a modificar: ");
        String dni = leerTexto();

        // Verificar si el usuario existe
        if (biblioteca.buscarUsuarioPorDni(dni) == null) {
            System.out.println("\n[ERROR] No se encontró ningún usuario con el DNI: " + dni);
            return;
        }

        System.out.print("Introduzca el nuevo nombre del usuario: ");
        String nombre = leerTexto();

        System.out.print("Introduzca los nuevos apellidos del usuario: ");
        String apellidos = leerTexto();

        System.out.print("Introduzca el nuevo teléfono del usuario: ");
        String telefono = leerTexto();

        Usuario nuevoUsuario = new Usuario(dni, nombre, apellidos, telefono);

        if (biblioteca.modificarUsuario(dni, nuevoUsuario)) {
            System.out.println("\n[ÉXITO] Usuario modificado correctamente.");
        } else {
            System.out.println("\n[ERROR] No se pudo modificar el usuario.");
        }
    }

    /**
     * Lista todos los usuarios registrados en la biblioteca.
     */
    private static void listarUsuarios() {
        System.out.println("\n--- Listado de Usuarios ---");

        Usuario[] usuarios = biblioteca.getTodosLosUsuarios();

        if (usuarios.length == 0 || usuarios[0] == null) {
            System.out.println("\n[INFO] No hay usuarios registrados en la biblioteca.");
            return;
        }

        System.out.println("\nNúmero de usuarios: " + biblioteca.getNumeroUsuarios());
        System.out.println("--------------------------------------------------");
        for (Usuario usuario : usuarios) {
            if (usuario != null) {
                System.out.println(usuario.toString());
            }
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     * Busca un usuario por su DNI y muestra sus datos.
     */
    private static void buscarUsuarioPorDni() {
        System.out.println("\n--- Búsqueda de Usuario por DNI ---");

        System.out.print("Introduzca el DNI del usuario a buscar: ");
        String dni = leerTexto();

        Usuario usuario = biblioteca.buscarUsuarioPorDni(dni);

        if (usuario == null) {
            System.out.println("\n[INFO] No se encontró ningún usuario con el DNI: " + dni);
        } else {
            System.out.println("\n[RESULTADO] Usuario encontrado:");
            System.out.println(usuario.toString());
        }
    }

    /**
     * Busca usuarios por nombre o apellidos y muestra los resultados.
     */
    private static void buscarUsuariosPorTexto() {
        System.out.println("\n--- Búsqueda de Usuarios por Nombre o Apellidos ---");

        System.out.print("Introduzca el texto de búsqueda: ");
        String texto = leerTexto();

        Usuario[] resultados = biblioteca.buscarUsuariosPorTexto(texto);

        System.out.println("\n[RESULTADOS] Usuarios encontrados (" +
                contarElementos(resultados) + "):");
        System.out.println("--------------------------------------------------");

        for (Usuario usuario : resultados) {
            if (usuario != null) {
                System.out.println(usuario.toString());
            }
        }
        System.out.println("--------------------------------------------------");
    }

    // ==================== MENÚ DE GESTIÓN DE TRABAJADORES ====================

    /**
     * Muestra el submenú de gestión de trabajadores y procesa las opciones.
     */
    private static void menuGestionTrabajadores() {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n========================================");
            System.out.println("        GESTIÓN DE TRABAJADORES");
            System.out.println("========================================");
            System.out.println("1. Dar de alta un nuevo trabajador");
            System.out.println("2. Dar de baja un trabajador");
            System.out.println("3. Modificar datos de un trabajador");
            System.out.println("4. Listar todos los trabajadores");
            System.out.println("5. Buscar trabajador por DNI");
            System.out.println("6. Buscar trabajadores por nombre, apellido o cargo");
            System.out.println("7. Volver al menú principal");
            System.out.println("========================================");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    altaTrabajador();
                    break;
                case 2:
                    bajaTrabajador();
                    break;
                case 3:
                    modificarTrabajador();
                    break;
                case 4:
                    listarTrabajadores();
                    break;
                case 5:
                    buscarTrabajadorPorDni();
                    break;
                case 6:
                    buscarTrabajadoresPorTexto();
                    break;
                case 7:
                    System.out.println("\n[VUELTA] Volviendo al menú principal...");
                    volver = true;
                    break;
                default:
                    System.out.println("\n[ERROR] Opción no válida.");
            }
        }
    }

    /**
     * Solicita los datos de un trabajador y lo da de alta en la biblioteca.
     */
    private static void altaTrabajador() {
        System.out.println("\n--- Alta de Nuevo Trabajador ---");

        System.out.print("Introduzca el DNI del trabajador: ");
        String dni = leerTexto();

        // Verificar si el trabajador ya existe
        if (biblioteca.buscarTrabajadorPorDni(dni) != null) {
            System.out.println("\n[ERROR] Ya existe un trabajador con el DNI: " + dni);
            return;
        }

        System.out.print("Introduzca el nombre del trabajador: ");
        String nombre = leerTexto();

        System.out.print("Introduzca los apellidos del trabajador: ");
        String apellidos = leerTexto();

        System.out.print("Introduzca el cargo del trabajador: ");
        String cargo = leerTexto();

        Trabajador trabajador = new Trabajador(dni, nombre, apellidos, cargo);

        if (biblioteca.altaTrabajador(trabajador)) {
            System.out.println("\n[ÉXITO] Trabajador dado de alta correctamente.");
        } else {
            System.out.println("\n[ERROR] No se pudo dar de alta el trabajador. Capacidad máxima alcanzada.");
        }
    }

    /**
     * Solicita el DNI de un trabajador y lo da de baja de la biblioteca.
     */
    private static void bajaTrabajador() {
        System.out.println("\n--- Baja de Trabajador ---");

        System.out.print("Introduzca el DNI del trabajador a eliminar: ");
        String dni = leerTexto();

        if (biblioteca.buscarTrabajadorPorDni(dni) == null) {
            System.out.println("\n[ERROR] No se encontró ningún trabajador con el DNI: " + dni);
            return;
        }

        if (biblioteca.bajaTrabajador(dni)) {
            System.out.println("\n[ÉXITO] Trabajador dado de baja correctamente.");
        } else {
            System.out.println("\n[ERROR] No se pudo dar de baja el trabajador.");
        }
    }

    /**
     * Solicita el DNI de un trabajador y sus nuevos datos, y lo modifica.
     */
    private static void modificarTrabajador() {
        System.out.println("\n--- Modificación de Trabajador ---");

        System.out.print("Introduzca el DNI del trabajador a modificar: ");
        String dni = leerTexto();

        if (biblioteca.buscarTrabajadorPorDni(dni) == null) {
            System.out.println("\n[ERROR] No se encontró ningún trabajador con el DNI: " + dni);
            return;
        }

        System.out.print("Introduzca el nuevo nombre del trabajador: ");
        String nombre = leerTexto();

        System.out.print("Introduzca los nuevos apellidos del trabajador: ");
        String apellidos = leerTexto();

        System.out.print("Introduzca el nuevo cargo del trabajador: ");
        String cargo = leerTexto();

        Trabajador nuevoTrabajador = new Trabajador(dni, nombre, apellidos, cargo);

        if (biblioteca.modificarTrabajador(dni, nuevoTrabajador)) {
            System.out.println("\n[ÉXITO] Trabajador modificado correctamente.");
        } else {
            System.out.println("\n[ERROR] No se pudo modificar el trabajador.");
        }
    }

    /**
     * Lista todos los trabajadores registrados en la biblioteca.
     */
    private static void listarTrabajadores() {
        System.out.println("\n--- Listado de Trabajadores ---");

        Trabajador[] trabajadores = biblioteca.getTodosLosTrabajadores();

        if (trabajadores.length == 0 || trabajadores[0] == null) {
            System.out.println("\n[INFO] No hay trabajadores registrados en la biblioteca.");
            return;
        }

        System.out.println("\nNúmero de trabajadores: " + biblioteca.getNumeroTrabajadores());
        System.out.println("--------------------------------------------------");
        for (Trabajador trabajador : trabajadores) {
            if (trabajador != null) {
                System.out.println(trabajador.toString());
            }
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     * Busca un trabajador por su DNI y muestra sus datos.
     */
    private static void buscarTrabajadorPorDni() {
        System.out.println("\n--- Búsqueda de Trabajador por DNI ---");

        System.out.print("Introduzca el DNI del trabajador a buscar: ");
        String dni = leerTexto();

        Trabajador trabajador = biblioteca.buscarTrabajadorPorDni(dni);

        if (trabajador == null) {
            System.out.println("\n[INFO] No se encontró ningún trabajador con el DNI: " + dni);
        } else {
            System.out.println("\n[RESULTADO] Trabajador encontrado:");
            System.out.println(trabajador.toString());
        }
    }

    /**
     * Busca trabajadores por nombre, apellido o cargo y muestra los resultados.
     */
    private static void buscarTrabajadoresPorTexto() {
        System.out.println("\n--- Búsqueda de Trabajadores ---");

        System.out.print("Introduzca el texto de búsqueda: ");
        String texto = leerTexto();

        Trabajador[] resultados = biblioteca.buscarTrabajadoresPorTexto(texto);

        System.out.println("\n[RESULTADOS] Trabajadores encontrados (" +
                contarElementos(resultados) + "):");
        System.out.println("--------------------------------------------------");

        for (Trabajador trabajador : resultados) {
            if (trabajador != null) {
                System.out.println(trabajador.toString());
            }
        }
        System.out.println("--------------------------------------------------");
    }

    // ==================== MENÚ DE GESTIÓN DE PRÉSTAMOS ====================

    /**
     * Muestra el submenú de gestión de préstamos y procesa las opciones.
     */
    private static void menuGestionPrestamos() {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n========================================");
            System.out.println("        GESTIÓN DE PRÉSTAMOS");
            System.out.println("========================================");
            System.out.println("1. Realizar un nuevo préstamo");
            System.out.println("2. Devolver un libro (finalizar préstamo)");
            System.out.println("3. Listar todos los préstamos");
            System.out.println("4. Listar préstamos activos");
            System.out.println("5. Buscar préstamo por ID");
            System.out.println("6. Ver préstamos de un usuario");
            System.out.println("7. Ver historial de préstamos de un libro");
            System.out.println("8. Generar informe estadístico");
            System.out.println("9. Volver al menú principal");
            System.out.println("========================================");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    crearPrestamo();
                    break;
                case 2:
                    devolverLibro();
                    break;
                case 3:
                    listarTodosPrestamos();
                    break;
                case 4:
                    listarPrestamosActivos();
                    break;
                case 5:
                    buscarPrestamoPorId();
                    break;
                case 6:
                    verPrestamosDeUsuario();
                    break;
                case 7:
                    verHistorialPrestamoLibro();
                    break;
                case 8:
                    mostrarInformeEstadistico();
                    break;
                case 9:
                    System.out.println("\n[VUELTA] Volviendo al menú principal...");
                    volver = true;
                    break;
                default:
                    System.out.println("\n[ERROR] Opción no válida.");
            }
        }
    }

    /**
     * Solicita los datos para realizar un nuevo préstamo.
     */
    private static void crearPrestamo() {
        System.out.println("\n--- Realizar Nuevo Préstamo ---");

        System.out.print("Introduzca el ISBN del libro a prestar: ");
        String isbn = leerTexto();

        // Verificar que el libro existe
        Libro libro = biblioteca.buscarLibroPorIsbn(isbn);
        if (libro == null) {
            System.out.println("\n[ERROR] No se encontró ningún libro con el ISBN: " + isbn);
            return;
        }

        // Verificar disponibilidad
        if (!libro.isDisponible()) {
            System.out.println("\n[ERROR] El libro no está disponible para préstamo.");
            return;
        }

        System.out.print("Introduzca el DNI del usuario: ");
        String dniUsuario = leerTexto();

        // Verificar que el usuario existe
        if (biblioteca.buscarUsuarioPorDni(dniUsuario) == null) {
            System.out.println("\n[ERROR] No se encontró ningún usuario con el DNI: " + dniUsuario);
            return;
        }

        System.out.print("Introduzca el DNI del trabajador que realiza el préstamo: ");
        String dniTrabajador = leerTexto();

        // Verificar que el trabajador existe
        if (biblioteca.buscarTrabajadorPorDni(dniTrabajador) == null) {
            System.out.println("\n[ERROR] No se encontró ningún trabajador con el DNI: " + dniTrabajador);
            return;
        }

        System.out.print("Introduzca la fecha de inicio (dd/mm/yyyy): ");
        String fechaInicio = leerTexto();

        System.out.print("Introduzca la fecha de fin (dd/mm/yyyy): ");
        String fechaFin = leerTexto();

        if (biblioteca.crearPrestamo(isbn, dniUsuario, dniTrabajador, fechaInicio, fechaFin)) {
            System.out.println("\n[ÉXITO] Préstamo realizado correctamente.");
            System.out.println("El libro '" + libro.getTitulo() + "' ha sido prestado.");
        } else {
            System.out.println("\n[ERROR] No se pudo realizar el préstamo.");
        }
    }

    /**
     * Solicita el ID de un préstamo para devolver el libro.
     */
    private static void devolverLibro() {
        System.out.println("\n--- Devolver Libro ---");

        System.out.print("Introduzca el ID del préstamo: ");
        int idPrestamo;
        try {
            idPrestamo = Integer.parseInt(leerTexto());
        } catch (NumberFormatException e) {
            System.out.println("\n[ERROR] ID de préstamo no válido.");
            return;
        }

        Prestamo prestamo = biblioteca.buscarPrestamoPorId(idPrestamo);

        if (prestamo == null) {
            System.out.println("\n[ERROR] No se encontró ningún préstamo con el ID: " + idPrestamo);
            return;
        }

        if (!prestamo.isActivo()) {
            System.out.println("\n[INFO] Este préstamo ya estaba marcado como devuelto.");
            return;
        }

        if (biblioteca.devolverLibro(idPrestamo)) {
            System.out.println("\n[ÉXITO] Devolución registrada correctamente.");
            System.out.println("El libro con ISBN " + prestamo.getIsbnLibro() + " está disponible nuevamente.");
        } else {
            System.out.println("\n[ERROR] No se pudo registrar la devolución.");
        }
    }

    /**
     * Lista todos los préstamos registrados.
     */
    private static void listarTodosPrestamos() {
        System.out.println("\n--- Listado de Todos los Préstamos ---");

        Prestamo[] prestamos = biblioteca.getTodosLosPrestamos();

        if (prestamos.length == 0 || prestamos[0] == null) {
            System.out.println("\n[INFO] No hay préstamos registrados.");
            return;
        }

        System.out.println("\nNúmero de préstamos: " + biblioteca.getNumeroPrestamos());
        System.out.println("--------------------------------------------------");
        for (Prestamo prestamo : prestamos) {
            if (prestamo != null) {
                System.out.println(prestamo.toString());
            }
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     * Lista todos los préstamos activos.
     */
    private static void listarPrestamosActivos() {
        System.out.println("\n--- Listado de Préstamos Activos ---");

        Prestamo[] prestamos = biblioteca.getPrestamosActivos();

        if (prestamos.length == 0 || prestamos[0] == null) {
            System.out.println("\n[INFO] No hay préstamos activos actualmente.");
            return;
        }

        System.out.println("\nNúmero de préstamos activos: " + prestamos.length);
        System.out.println("--------------------------------------------------");
        for (Prestamo prestamo : prestamos) {
            if (prestamo != null) {
                System.out.println(prestamo.toString());
            }
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     * Busca un préstamo por su ID.
     */
    private static void buscarPrestamoPorId() {
        System.out.println("\n--- Búsqueda de Préstamo por ID ---");

        System.out.print("Introduzca el ID del préstamo a buscar: ");
        int idPrestamo;
        try {
            idPrestamo = Integer.parseInt(leerTexto());
        } catch (NumberFormatException e) {
            System.out.println("\n[ERROR] ID de préstamo no válido.");
            return;
        }

        Prestamo prestamo = biblioteca.buscarPrestamoPorId(idPrestamo);

        if (prestamo == null) {
            System.out.println("\n[INFO] No se encontró ningún préstamo con el ID: " + idPrestamo);
        } else {
            System.out.println("\n[RESULTADO] Préstamo encontrado:");
            System.out.println(prestamo.toString());
        }
    }

    /**
     * Muestra los préstamos activos de un usuario.
     */
    private static void verPrestamosDeUsuario() {
        System.out.println("\n--- Préstamos de un Usuario ---");

        System.out.print("Introduzca el DNI del usuario: ");
        String dni = leerTexto();

        // Verificar que el usuario existe
        if (biblioteca.buscarUsuarioPorDni(dni) == null) {
            System.out.println("\n[ERROR] No se encontró ningún usuario con el DNI: " + dni);
            return;
        }

        Prestamo[] prestamos = biblioteca.buscarPrestamosPorUsuario(dni);
        int count = contarElementos(prestamos);

        System.out.println("\n[RESULTADOS] Préstamos activos del usuario (" + count + "):");
        System.out.println("--------------------------------------------------");

        for (Prestamo prestamo : prestamos) {
            if (prestamo != null) {
                System.out.println(prestamo.toString());
            }
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     * Muestra el historial de préstamos de un libro.
     */
    private static void verHistorialPrestamoLibro() {
        System.out.println("\n--- Historial de Préstamos de un Libro ---");

        System.out.print("Introduzca el ISBN del libro: ");
        String isbn = leerTexto();

        // Verificar que el libro existe
        if (biblioteca.buscarLibroPorIsbn(isbn) == null) {
            System.out.println("\n[ERROR] No se encontró ningún libro con el ISBN: " + isbn);
            return;
        }

        Prestamo[] prestamos = biblioteca.buscarPrestamosPorLibro(isbn);
        int count = 0;
        for (Prestamo p : prestamos) {
            if (p != null) count++;
        }

        System.out.println("\n[RESULTADOS] Historial del libro (" + count + " préstamos):");
        System.out.println("--------------------------------------------------");

        for (Prestamo prestamo : prestamos) {
            if (prestamo != null) {
                System.out.println(prestamo.toString());
            }
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     * Muestra el informe estadístico de la biblioteca.
     */
    private static void mostrarInformeEstadistico() {
        System.out.println(biblioteca.generarInformeEstadistico());
    }

    // ==================== MÉTODOS AUXILIARES ====================

    /**
     * Cuenta el número de elementos no nulos en un array.
     *
     * @param array El array a contar
     * @return El número de elementos no nulos
     */
    private static int contarElementos(Object[] array) {
        int contador = 0;
        for (Object elemento : array) {
            if (elemento != null) {
                contador++;
            }
        }
        return contador;
    }
}
