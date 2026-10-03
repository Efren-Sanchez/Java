import java.sql.*;

public class MySQLMetodos2 {

    // Usamos constantes para la configuración
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASS = "";

    // Mejor devolver la conexión y que el llamador la gestione (como ya hacías en el main)
    public static Connection conectar() throws SQLException {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión con MySQL establecida.");
            return conexion;
        } catch (SQLException e) {
            System.err.println("ERROR: La conexión con MySQL ha fallado.\n\nExcepción: " + e.getMessage());
            throw e; // Relanzamos para que el main sepa que falló
        }
    }

    // Uso de PreparedStatement para evitar SQL Injection y errores de formato
    public static int insertarAutor(Connection conexion, int id, String nombre, String apellido, String nacionalidad, String fechaNac, String fechaDep) {
        String sql = "INSERT INTO autores (id_autor, nombre, apellido1, nacionalidad, fecha_nac, fecha_dep) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, nacionalidad);
            ps.setString(5, fechaNac);
            ps.setString(5, fechaDep);
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
            return -1;
        }
    }

    // Consulta con try-with-resources para asegurar el cierre del ResultSet
    public static void mostrarAutores(Connection conexion) {
        String sql = "SELECT nombre, apellido1, nacionalidad, fecha_nac FROM autores";
        
        try (Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(sql)) {
            
            while (resultado.next()) {
                System.out.printf("Autor: %s %s | Nacionalidad: %s | Nacimiento: %s%n",
                        resultado.getString("nombre"),
                        resultado.getString("apellido1"),
                        resultado.getString("nacionalidad"),
                        resultado.getString("fecha_nac"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try (Connection conexion = conectar()) {
            
            // Insertar datos de forma segura
            int filas = insertarAutor(conexion, 44, "Aldous", "Huxley", "Reino Unido", "1864-07-26", "1963-11-22");
            if (filas > 0) {
                System.out.println("Registro insertado con éxito.");
            }

            // Mostrar datos
            System.out.println("\n--- LISTA DE AUTORES ---");
            mostrarAutores(conexion);

        } catch (SQLException e) {
            // Aquí capturamos cualquier error de la conexión inicial
            System.err.println("Error en la aplicación: " + e.getMessage());
        }
    }
}