import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase avanzada para la gestión de bases de datos SQL.
 * Esta versión permite configurar los parámetros de conexión dinámicamente y 
 * centraliza la lógica de transacciones y operaciones CRUD genéricas.
 * 
 * @author Usuario
 * @version 2.0
 */
public class MySQLManagerFinal2 {

    // Atributos de configuración (permiten cambiar de BD sin tocar el código lógico)
    private static String urlConexion = "jdbc:mysql://localhost:3306/biblioteca";
    private static String usuarioBd = "root";
    private static String contrasenaBd = "";

    /**
     * Permite cambiar la configuración de la base de datos en tiempo de ejecución.
     * @param url Nueva URL JDBC.
     * @param usuario Nuevo usuario.
     * @param contrasena Nueva contraseña.
     */
    public static void configurarConexion(String url, String usuario, String contrasena) {
        urlConexion = url;
        usuarioBd = usuario;
        contrasenaBd = contrasena;
    }

    /**
     * Establece y devuelve una conexión a la base de datos.
     * @return Connection objeto de conexión.
     * @throws SQLException Si falla la conexión.
     */
    public static Connection obtenerConexion() throws SQLException {
        try {
            return DriverManager.getConnection(urlConexion, usuarioBd, contrasenaBd);
        } catch (SQLException e) {
            System.err.println("[LOG] Error de conexión: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Consulta el valor máximo actual de una columna y devuelve el siguiente (MAX + 1).
     * Nota: En entornos con muchos usuarios, se recomienda usar AUTO_INCREMENT en la BD.
     * 
     * @param conexion Conexión activa.
     * @param tabla Nombre de la tabla.
     * @param columnaId Nombre de la clave primaria.
     * @return El ID sugerido.
     */
    public static int consultarSiguienteId(Connection conexion, String tabla, String columnaId) {
        String sql = String.format("SELECT MAX(%s) FROM %s", columnaId, tabla);
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            System.err.println("[LOG] Error al calcular ID: " + e.getMessage());
        }
        return 1;
    }

    /**
     * Verifica si existe un registro que coincida con un criterio.
     * 
     * @param conexion Conexión activa.
     * @param tabla Tabla donde buscar.
     * @param columna Columna del criterio.
     * @param valor Valor a buscar.
     * @return true si existe al menos una coincidencia.
     */
    public static boolean registroExiste(Connection conexion, String tabla, String columna, Object valor) {
        String sql = String.format("SELECT COUNT(*) FROM %s WHERE %s = ?", tabla, columna);
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setObject(1, valor);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("[LOG] Error en verificación: " + e.getMessage());
        }
        return false;
    }

    /**
     * Inserta un nuevo registro de forma genérica.
     * @param conexion Conexión activa.
     * @param sqlInsert Sentencia SQL con '?'.
     * @param parametros Valores para la sentencia.
     * @return Filas afectadas.
     */
    public static int crearRegistro(Connection conexion, String sqlInsert, Object... parametros) {
        return ejecutarEscritura(conexion, sqlInsert, parametros);
    }

    /**
     * Actualiza registros existentes.
     * @param conexion Conexión activa.
     * @param sqlUpdate Sentencia SQL con '?'.
     * @param parametros Valores para la sentencia.
     * @return Filas afectadas.
     */
    public static int actualizarRegistro(Connection conexion, String sqlUpdate, Object... parametros) {
        return ejecutarEscritura(conexion, sqlUpdate, parametros);
    }

    /**
     * Borra registros de una tabla.
     * @param conexion Conexión activa.
     * @param tabla Nombre de la tabla.
     * @param columnaId Nombre de la columna filtro.
     * @param valorId Valor del filtro.
     * @return Filas afectadas.
     */
    public static int borrarRegistro(Connection conexion, String tabla, String columnaId, Object valorId) {
        String sql = String.format("DELETE FROM %s WHERE %s = ?", tabla, columnaId);
        return ejecutarEscritura(conexion, sql, valorId);
    }

    /**
     * Método centralizado para ejecutar operaciones de escritura (INSERT, UPDATE, DELETE).
     */
    private static int ejecutarEscritura(Connection conexion, String sql, Object... parametros) {
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("[LOG] Error de escritura: " + e.getMessage());
            return -1;
        }
    }

    /**
     * Ejecuta una consulta SELECT y devuelve los datos en una estructura de Lista de Mapas.
     * @param conexion Conexión activa.
     * @param sqlSelect Sentencia SQL.
     * @return List de Mapas con los datos.
     */
    public static List<Map<String, Object>> consultarRegistros(Connection conexion, String sqlSelect) {
        List<Map<String, Object>> resultados = new ArrayList<>();
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sqlSelect)) {
            
            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();

            while (rs.next()) {
                Map<String, Object> fila = new HashMap<>();
                for (int i = 1; i <= columnas; i++) {
                    fila.put(meta.getColumnLabel(i), rs.getObject(i));
                }
                resultados.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("[LOG] Error de consulta: " + e.getMessage());
        }
        return resultados;
    }

    // ==========================================
    // MÉTODOS DE TRANSACCIONES
    // ==========================================

    public static void iniciarTransaccion(Connection conexion) throws SQLException {
        if (conexion != null) conexion.setAutoCommit(false);
    }

    public static void finalizarTransaccion(Connection conexion) throws SQLException {
        if (conexion != null) {
            conexion.commit();
            conexion.setAutoCommit(true);
        }
    }

    public static void deshacerTransaccion(Connection conexion) {
        try {
            if (conexion != null) conexion.rollback();
        } catch (SQLException e) {
            System.err.println("[LOG] Error al hacer rollback: " + e.getMessage());
        }
    }

    // ==========================================
    // EJEMPLO DE USO (MAIN)
    // ==========================================

    public static void main(String[] args) {
        // 1. Configurar si fuera necesario (opcional si usamos los valores por defecto)
        configurarConexion("jdbc:mysql://localhost:3306/biblioteca", "root", "");

        try (Connection con = obtenerConexion()) {
            System.out.println("--- INICIANDO PRUEBAS UNITARIAS ---");

            // Obtener ID para la prueba
            int idAutor = consultarSiguienteId(con, "autores", "id_autor");

            // Iniciar bloque transaccional
            iniciarTransaccion(con);

            try {
                // Crear
                String sqlInsert = "INSERT INTO autores (id_autor, nombre, apellido1) VALUES (?, ?, ?)";
                crearRegistro(con, sqlInsert, idAutor, "Arturo", "Pérez-Reverte");

                // Comprobar existencia
                if (registroExiste(con, "autores", "id_autor", idAutor)) {
                    System.out.println("El autor ha sido creado temporalmente.");
                }

                // Actualizar
                String sqlUpdate = "UPDATE autores SET nacionalidad = ? WHERE id_autor = ?";
                actualizarRegistro(con, sqlUpdate, "Española", idAutor);

                // Consultar
                List<Map<String, Object>> datos = consultarRegistros(con, "SELECT * FROM autores WHERE id_autor = " + idAutor);
                datos.forEach(fila -> System.out.println("Datos recuperados: " + fila));

                // Borrar (limpieza)
                borrarRegistro(con, "autores", "id_autor", idAutor);
                System.out.println("Registro eliminado para finalizar prueba.");

                // Confirmar cambios
                finalizarTransaccion(con);
                System.out.println("--- PRUEBAS FINALIZADAS CON ÉXITO ---");

            } catch (Exception e) {
                System.err.println("Error en el flujo de trabajo: " + e.getMessage());
                deshacerTransaccion(con);
            }

        } catch (SQLException e) {
            System.err.println("No se pudo establecer la conexión inicial.");
        }
    }
}