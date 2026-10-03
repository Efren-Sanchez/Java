import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySQLManager2{

    // Configuración de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASS = "";

    /**
     * Establece la conexión con la base de datos.
     */
    public static Connection conectar() throws SQLException {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("[INFO] Conexión establecida.");
            return con;
        } catch (SQLException e) {
            System.err.println("[ERROR] No se pudo conectar: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Calcula el siguiente ID disponible buscando el MAX(id) + 1.
     * Útil para tablas que no tienen AUTO_INCREMENT configurado en SQL.
     */
    public static int obtenerSiguienteId(Connection con, String tabla, String columnaId) {
        String sql = "SELECT MAX(" + columnaId + ") FROM " + tabla;
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            if (rs.next()) {
                int maxId = rs.getInt(1); // Obtiene el valor de la primera columna
                return maxId + 1;
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] No se pudo calcular el siguiente ID: " + e.getMessage());
        }
        return 1; // Si la tabla está vacía, empezamos por 1
    }

    /**
     * Método GENÉRICO para insertar registros en cualquier tabla.
     * @param sql La sentencia SQL con interrogantes (ej: "INSERT INTO tabla VALUES (?, ?, ?)")
     * @param parametros Los valores que sustituirán a los interrogantes.
     */
    public static int insertarRegistro(Connection con, String sql, Object... parametros) {
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Recorremos los parámetros y los asignamos según su tipo
            for (int i = 0; i < parametros.length; i++) {
                ps.setObject(i + 1, parametros[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("[ERROR] Error al insertar registro: " + e.getMessage());
            return -1;
        }
    }

    /**
     * Ejecuta una consulta SQL y devuelve una lista de mapas (filas).
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
            System.err.println("[ERROR] Error en consulta: " + e.getMessage());
        }
        return lista;
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
    // MÉTODO PRINCIPAL DE PRUEBAS
    // ==========================================

    public static void main(String[] args) {
        try (Connection con = conectar()) {

            // 1. Obtener automáticamente el siguiente ID para la tabla autores
            int nuevoId = obtenerSiguienteId(con, "autores", "id_autor");
            System.out.println("Siguiente ID disponible: " + nuevoId);

            // 2. Usar el nuevo método genérico insertarRegistro
            // No importa cuántas columnas tenga la tabla, pasamos los valores en orden
            String sqlInsert = "INSERT INTO autores (id_autor, nombre, apellido1, nacionalidad, fecha_nac) VALUES (?, ?, ?, ?, ?)";
            
            int filas = insertarRegistro(con, sqlInsert, 
                                        nuevoId, "Isabel", "Allende", "Chile", "1942-08-02");

            if (filas > 0) {
                System.out.println("Registro insertado con éxito con el ID: " + nuevoId);
            }

            // 3. Ver los resultados
            System.out.println("\n--- LISTADO ACTUAL DE AUTORES ---");
            List<Map<String, Object>> autores = consultarGenerico(con, "SELECT * FROM autores");
            for (Map<String, Object> autor : autores) {
                System.out.println("ID: " + autor.get("id_autor") + " | " + 
                                   autor.get("nombre") + " " + autor.get("apellido1"));
            }

            // 4. Limpieza (opcional): borrar el registro de prueba para poder repetir el ejercicio
            // eliminarRegistro(con, "autores", "id_autor", nuevoId);

        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());
        }
    }
}