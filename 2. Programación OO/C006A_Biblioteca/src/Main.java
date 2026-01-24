import java.time.LocalDate;

public class Main {
    private static int maxLibros = 10;
    private static int numLibros = 0;
    private static Libro [] vecLibros = new Libro[maxLibros];

    private static int maxUsuarios = 10;
    private static int numUsuarios = 0;
    private static Usuario [] vecUsuarios = new Usuario[maxUsuarios];

    private static int maxTrabajadores = 10;
    private static int numTrabajadores = 0;
    private static Trabajador [] vecTrabajadores = new Trabajador[maxTrabajadores];

    private static int maxPrestamos = 10;
    private static int numPrestamos = 0;
    private static Prestamo [] vecPrestamos = new Prestamo[maxPrestamos];

    public static void main(String[] args) throws Exception {
        
        // ---------------------------------------------------------------------------------------------------------------------------------------------------------
        // Pruebas con la clase Libro 
        System.out.println("Vamos a probar las distintas opcines de la clase Libro\n");

        // Creo un libro vacío
        Libro libro1 = new Libro();
        
        System.out.println("\n\nMuestro el libro vacío:\n");
        // Si intento mostrar un objeto por pantalla, aunque no lo especifique, se llama al metodo toString
        // Este método simepre existe, ya que esta definido en la clase Object, de la que hereda cualquier otra clase que cree
        System.out.println(libro1.toString());
        System.out.println(libro1);
        

        // Informo las propiedades del libro vacío
        libro1.setTitulo("Canción de hielo y fuego");
        libro1.setAutor("GRR Martin");
        libro1.setPaginas(752);
        libro1.setIsbn("978-3-16-148410-0");
        libro1.setCategoria("Novela de ficción/Fantasía");
        libro1.setEjemplares(5);
        libro1.setDisponibles(5);

        System.out.println("\n\nMuestro el libro después de informarlo:\n");
        System.out.println(libro1.toString());
        System.out.println(libro1);

        // Creo un libro con el constructor por defecto
        Libro libro2 = new Libro("Choque de reyes", "GRR Martin", 643, "978-3-16-148411-0", "Novela de ficción/Fantasía", 7);

        System.out.println("\n\nMuestro el segundo libro:\n");
        System.out.println(libro2);

        // Opero con los libros
        System.out.println("\n\nPresto un ejemplar:\n");
        libro2.prestar();
        System.out.println(libro2);

        System.out.println("\n\nDevuelvo un ejemplar:\n");
        libro2.devolver();
        System.out.println(libro2);

        System.out.println("\n\nAñado 3 ejemplares:\n");
        libro2.anadir(3);
        System.out.println(libro2);

        System.out.println("\n\nElimino 4 ejemplares:\n");
        libro2.eliminar(4);
        System.out.println(libro2);

        // Voy a intentar prestar un libro del que no hay ejemplares
        libro2.eliminar(6);
        System.out.println(libro2);

        if (libro2.prestar()) {
            System.out.println("\nEl libro se ha prestado correctamente :)");
            System.out.println(libro2);
        }
        else
            System.out.println("\nEl libro NO se ha podido prestar :(");
            

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------
        // Pruebas con la clase Usuario
        System.out.println("Vamos a probar las distintas opcines de la clase Usuario\n");

        // Creo un usuario vacío
        Usuario usuario1 = new Usuario();
        
        System.out.println("\n\nMuestro el usuario vacío:\n");
        //System.out.println(usuario1.toString());
        System.out.println(usuario1);
        

        // Informo las propiedades del usuario vacío
        usuario1.setNombre("Antonio García García");
        usuario1.setDireccion("C/ Mayor, 1, 1ºA");
        usuario1.setTelefono("964 964 964");
        usuario1.setFechaNac(LocalDate.of(2001, 1, 1));
        usuario1.setEstado(Estado.ACTIVO);

        System.out.println("\n\nMuestro el usuario después de informarlo:\n");
        //System.out.println(usuario1.toString());
        System.out.println(usuario1);

        // Creo un usuario con el constructor por defecto
        Usuario usuario2 = new Usuario("Juan Pérez Pérez", "C/ Enmedio, 1, 1ºA", "964 123 123", LocalDate.of(2002, 2, 2), Estado.ACTIVO);

        System.out.println("\n\nMuestro el segundo usuario:\n");
        System.out.println(usuario2);


        // ---------------------------------------------------------------------------------------------------------------------------------------------------------
        // Pruebas con la clase Trabajador
        System.out.println("Vamos a probar las distintas opcines de la clase Trabajador\n");

        // Creo un trabajador vacío
        Trabajador trabajador1 = new Trabajador();
        
        System.out.println("\n\nMuestro el trabajador vacío:\n");
        System.out.println(trabajador1);
        

        // Informo las propiedades del libro vacío
        trabajador1.setNombre("Rosa Vidal Juarez");
        trabajador1.setDireccion("C/ Mayor, 1, 1ºA");
        trabajador1.setTelefono("964 964 964");
        trabajador1.setFechaNac(LocalDate.of(2001, 1, 1));
        trabajador1.setNss("123456789012");
        trabajador1.setSalario(30000);

        System.out.println("\n\nMuestro el trabajador después de informarlo:\n");
        System.out.println(trabajador1);

        // Creo un libro con el constructor por defecto
        Trabajador trabajador2 = new Trabajador("Rebeca García Perez", "C/ Enmedio, 1, 1ºA", "964 123 123", LocalDate.of(2002, 2, 2), "123456789012", 32000);

        System.out.println("\n\nMuestro el segundo trabajador:\n");
        System.out.println(trabajador2);


        // ---------------------------------------------------------------------------------------------------------------------------------------------------------
        // Pruebas con la clase Préstamo
        System.out.println("Vamos a probar las distintas opcines de la clase Usuario\n");

        // Creo un libro vacío
        Prestamo prestamo1 = new Prestamo();
        
        System.out.println("\n\nMuestro el préstamo vacío:\n");
        //System.out.println(prestamo1.toString());
        System.out.println(prestamo1);
        

        // Informo las propiedades del libro vacío
        prestamo1.setLibro(libro1);
        prestamo1.setUsuario(usuario1);
        prestamo1.setTrabajador(trabajador1);
        prestamo1.setFecha(LocalDate.now());
        prestamo1.setDias(7);

        System.out.println("\n\nMuestro el préstamo después de informarlo:\n");
        System.out.println(prestamo1.toString());
        System.out.println(prestamo1);

        // Creo un libro con el constructor por defecto
        Prestamo prestamo2 = new Prestamo(libro2, usuario2, trabajador2, LocalDate.now());

        System.out.println("\n\nMuestro el segundo usuario:\n");
        System.out.println(prestamo2);


        // ---------------------------------------------------------------------------------------------------------------------------------------------------------
        // Empezamos con el proceso principal
        // Metemos libros, usuarios y préstamos en sus vectores de manera manual --> No recomendable
        vecLibros[numLibros] = libro1;
        numLibros++;

        vecUsuarios[numUsuarios] = usuario1;
        numUsuarios++;

        vecPrestamos[numPrestamos] = prestamo1;
        numPrestamos++;

        // Metemos libros, usuarios y préstamos en sus vectores utilizando métodos --> Así se debería hacer siempre
        if(nuevoLibro(libro1)) 
            System.out.println("\n\nEl libro se ha insertado correctamente");
        else 
            System.out.println("\n\nEl libro NO se ha insertado correctamente. Falta espacio en el vector");

        if(nuevoUsuario(usuario1)) 
            System.out.println("\n\nEl usuario se ha insertado correctamente");
        else 
            System.out.println("\n\nEl usuario NO se ha insertado correctamente. Falta espacio en el vector");

        if(nuevoPrestamo(prestamo1)) 
            System.out.println("\n\nEl préstamo se ha insertado correctamente");
        else 
            System.out.println("\n\nEl préstamo NO se ha insertado correctamente. Falta espacio en el vector");


        if(nuevoLibro(libro2)) 
            System.out.println("\n\nEl libro se ha insertado correctamente");
        else 
            System.out.println("\n\nEl libro NO se ha insertado correctamente. Falta espacio en el vector");

        if(nuevoUsuario(usuario2)) 
            System.out.println("\n\nEl usuario se ha insertado correctamente");
        else 
            System.out.println("\n\nEl usuario NO se ha insertado correctamente. Falta espacio en el vector");

        if(nuevoPrestamo(prestamo2)) 
            System.out.println("\n\nEl préstamo se ha insertado correctamente");
        else 
            System.out.println("\n\nEl préstamo NO se ha insertado correctamente. Falta espacio en el vector");
        

        System.out.println("\n\nProbamos los métodos consultarLibros para usuarios:\n");
        System.out.println("\n---------------------------------------------------\n");
        System.out.println("\n\nLibros prestados al usuario1:\n");
        usuario1.consultarLibros(vecPrestamos, numPrestamos);

        System.out.println("\n\nLibros prestados al usuario2:\n");
        usuario2.consultarLibros(vecPrestamos, numPrestamos);
        
        System.out.println("\n\nProbamos los métodos consultarLibros para trabajadores:\n");
        System.out.println("\n-------------------------------------------------------\n");
        System.out.println("\n\nLibros prestados al trabajador1:\n");
        trabajador1.consultarLibros(vecPrestamos, numPrestamos);

        System.out.println("\n\nLibros prestados al trabajador2:\n");
        trabajador2.consultarLibros(vecPrestamos, numPrestamos);
    }


    // Mete un nuevo libro en el vector
    public static boolean nuevoLibro(Libro l) {
        // Comprobamos que hay espacio suficiente
        if (numLibros < maxLibros) {
            vecLibros[numLibros] = l;
            numLibros++;
            return true;
        }
        else 
            return false;
    }

    public static void nuevoLibroAmplia(Libro l) {
        if (numLibros == maxLibros) 
            ampliarLibros();

        vecLibros[numLibros] = l;
        numLibros++;
    }

    // Dobla el espacio en el vector 
    public static void ampliarLibros() {
        maxLibros *= 2;
        Libro [] vecAux = new Libro[maxLibros];

        for (int i = 0; i < numLibros; i++)
            vecAux[i] = vecLibros[i];
        
        vecLibros = vecAux;
    }

    public static boolean nuevoUsuario(Usuario u) {
        if (numUsuarios < maxUsuarios) {
            vecUsuarios[numUsuarios] = u;
            numUsuarios++;
            return true;
        }
        else 
            return false;
    }

    public static boolean nuevoTrabajador(Trabajador t) {
        if (numTrabajadores < maxTrabajadores) {
            vecTrabajadores[numTrabajadores] = t;
            numTrabajadores++;
            return true;
        }
        else 
            return false;
    }

    public static boolean nuevoPrestamo(Prestamo p) {
        if (numLibros < maxLibros) {
            vecPrestamos[numPrestamos] = p;
            numPrestamos++;
            return true;
        }
        else 
            return false;
    }

    // OJO: falta probar
    public static void mostrarLibros() {
        for (int i = 0; i < numLibros; i++) 
            System.out.println(vecLibros[i]);
    }

    public static void mostrarUsuarios() {
        for (int i = 0; i < numUsuarios; i++) 
            System.out.println(vecUsuarios[i]);
    }

    public static void mostrarTrabajadores() {
        for (int i = 0; i < numTrabajadores; i++) 
            System.out.println(vecTrabajadores[i]);
    }

    public static void mostrarPrestamos() {
        for (int i = 0; i < numPrestamos; i++) 
            System.out.println(vecPrestamos[i]);
    }

    public static void mostrarPrestamosActivos() {
        for (int i = 0; i < numPrestamos; i++) 
            if (!vecPrestamos[i].getDevuelto())
                System.out.println(vecPrestamos[i]);
    }

    public static void mostrarPrestamosVencidos() {
        for (int i = 0; i < numPrestamos; i++) 
            if (vecPrestamos[i].getDevuelto())
                System.out.println(vecPrestamos[i]);        
    }

}
