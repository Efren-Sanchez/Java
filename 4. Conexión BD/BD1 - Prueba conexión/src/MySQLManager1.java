import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase de utilidad para gestionar operaciones CRUD en MySQL de forma segura y eficiente.
 */
public class MySQLManager1 {

    // Configuración de la base de datos (Ajusta según tu entorno)
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASS = "";

    // ==========================================
    // 1. GESTIÓN DE CONEXIÓN
    // ==========================================

    /**
     * Establece la conexión con la base de datos.
     * Se recomienda usar este método dentro de un try-with-resources.
     */
    public static Connection conectar() throws SQLException {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("[INFO] Conexión establecida con éxito.");
            return con;
        } catch (SQLException e) {
            System.err.println("[ERROR] Error al conectar: " + e.getMessage());
            throw e; 
        }
    }

    // ==========================================
    // 2. OPERACIONES DE ESCRITURA (CUD - Create, Update, Delete)
    // ==========================================

    /**
     * Inserta un autor usando PreparedStatement para evitar SQL Injection.
     */
    public static int insertarAutor(Connection con, int id, String nombre, String apellido, String nacionalidad, String fechaNac) {
        String sql = "INSERT INTO autores (id_autor, nombre, apellido1, nacionalidad, fecha_nac) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, nacionalidad);
            ps.setString(5, fechaNac);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("[ERROR] Error al insertar: " + e.getMessage());
            return -1;
        }
    }

    /**
     * Actualiza cualquier columna de cualquier tabla (Genérico).
     */
    public static int actualizarRegistro(Connection con, String tabla, String columnaSet, String nuevoValor, String columnaId, int id) {
        String sql = "UPDATE " + tabla + " SET " + columnaSet + " = ? WHERE " + columnaId + " = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nuevoValor);
            ps.setInt(2, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("[ERROR] Error al actualizar: " + e.getMessage());
            return -1;
        }
    }

    /**
     * Elimina un registro de forma genérica.
     */
    public static int eliminarRegistro(Connection con, String tabla, String columnaId, int id) {
        String sql = "DELETE FROM " + tabla + " WHERE " + columnaId + " = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("[ERROR] Error al eliminar: " + e.getMessage());
            return -1;
        }
    }

    // ==========================================
    // 3. OPERACIONES DE CONSULTA (Read)
    // ==========================================

    /**
     * Verifica si un registro ya existe en la base de datos.
     */
    public static boolean existeRegistro(Connection con, String tabla, String columna, int id) {
        String sql = "SELECT COUNT(*) FROM " + tabla + " WHERE " + columna + " = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Ejecuta una consulta SQL y devuelve una lista de mapas.
     * Cada mapa representa una fila (Clave: nombre columna, Valor: dato).
     */
    public static List<Map<String, Object>> consultarGenerico(Connection con, String sql) {
        List<Map<String, Object>> lista = new ArrayList<>();
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            ResultSetMetaData metaData = rs.getMetaData();
            int numColumnas = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> fila = new HashMap<>();
                for (int i = 1; i <= numColumnas; i++) {
                    fila.put(metaData.getColumnName(i), rs.getObject(i));
                }
                lista.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] Error en consulta genérica: " + e.getMessage());
        }
        return lista;
    }

    // ==========================================
    // 4. GESTIÓN DE TRANSACCIONES
    // ==========================================

    public static void iniciarTransaccion(Connection con) throws SQLException {
        if (con != null) con.setAutoCommit(false);
    }

    public static void finalizarTransaccion(Connection con) throws SQLException {
        if (con != null) {
            con.commit();
            con.setAutoCommit(true);
        }
    }

    public static void cancelarTransaccion(Connection con) {
        try {
            if (con != null) con.rollback();
        } catch (SQLException e) {
            System.err.println("No se pudo hacer rollback: " + e.getMessage());
        }
    }

    // ==========================================
    // 5. MÉTODO PRINCIPAL (PRUEBAS)
    // ==========================================

    public static void main(String[] args) {
        // Usamos try-with-resources para asegurar que la conexión se cierre siempre
        try (Connection con = conectar()) {

            System.out.println("\n--- 1. Probando Existencia e Inserción ---");
            int idPrueba = 99;
            if (!existeRegistro(con, "autores", "id_autor", idPrueba)) {
                int insertadas = insertarAutor(con, idPrueba, "H.P.", "Lovecraft", "EEUU", "1890-08-20");
                System.out.println("Filas insertadas: " + insertadas);
            } else {
                System.out.println("El autor con ID " + idPrueba + " ya existe.");
            }

            System.out.println("\n--- 2. Probando Actualización ---");
            actualizarRegistro(con, "autores", "nacionalidad", "Reino Unido", "id_autor", idPrueba);
            System.out.println("Registro actualizado.");

            System.out.println("\n--- 3. Probando Consulta Genérica ---");
            String sql = "SELECT nombre, apellido1, nacionalidad FROM autores LIMIT 5";
            List<Map<String, Object>> resultados = consultarGenerico(con, sql);
            
            for (Map<String, Object> fila : resultados) {
                System.out.println("Autor: " + fila.get("nombre") + " " + fila.get("apellido1") + 
                                   " | País: " + fila.get("nacionalidad"));
            }

            System.out.println("\n--- 4. Probando Eliminación ---");
            int eliminadas = eliminarRegistro(con, "autores", "id_autor", idPrueba);
            System.out.println("Filas eliminadas: " + eliminadas);

        } catch (SQLException e) {
            System.err.println("Error crítico en la ejecución: " + e.getMessage());
        }
    }
}