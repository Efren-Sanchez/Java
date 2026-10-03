import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase final para la gestión de operaciones en una base de datos MySQL.
 * Proporciona métodos genéricos para realizar operaciones CRUD, gestión de transacciones
 * y consultas de metadatos.
 * 
 * @author Usuario
 * @version 1.0
 */
public class MySQLManagerFinal1 {

    // Configuración de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    /**
     * Establece una conexión con la base de datos definida en las constantes.
     * 
     * @return Objeto Connection activo.
     * @throws SQLException Si ocurre un error al intentar conectar.
     */
    public static Connection conectarBd() throws SQLException {
        try {
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("[SISTEMA] Conexión establecida con éxito.");
            return conexion;
        } catch (SQLException e) {
            System.err.println("[ERROR] Error en la conexión: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Busca el valor máximo de una columna de ID y devuelve el siguiente valor (MAX + 1).
     * 
     * @param conexion   Conexión activa a la base de datos.
     * @param tabla      Nombre de la tabla.
     * @param columnaId  Nombre de la columna que actúa como clave primaria numérica.
     * @return El siguiente ID disponible (1 si la tabla está vacía).
     */
    public static int consultarSiguienteId(Connection conexion, String tabla, String columnaId) {
        String consulta = "SELECT MAX(" + columnaId + ") FROM " + tabla;
        try (Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(consulta)) {
            
            if (resultado.next()) {
                int maximoActual = resultado.getInt(1);
                return maximoActual + 1;
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] No se pudo calcular el siguiente ID: " + e.getMessage());
        }
        return 1;
    }

    /**
     * Comprueba si un registro existe en base a una columna y un valor específico.
     * 
     * @param conexion   Conexión activa.
     * @param tabla      Nombre de la tabla.
     * @param columna    Columna a buscar.
     * @param valor      Valor a comparar.
     * @return true si el registro existe, false en caso contrario.
     */
    public static boolean registroExiste(Connection conexion, String tabla, String columna, Object valor) {
        String consulta = "SELECT COUNT(*) FROM " + tabla + " WHERE " + columna + " = ?";
        try (PreparedStatement sentencia = conexion.prepareStatement(consulta)) {
            sentencia.setObject(1, valor);
            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return resultado.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] Error al verificar existencia: " + e.getMessage());
        }
        return false;
    }

    /**
     * Ejecuta una inserción de forma genérica.
     * 
     * @param conexion    Conexión activa.
     * @param consultaSql Sentencia INSERT con marcadores '?'.
     * @param parametros  Valores para sustituir los marcadores.
     * @return Número de filas afectadas.
     */
    public static int crearRegistro(Connection conexion, String consultaSql, Object... parametros) {
        return ejecutarActualizacion(conexion, consultaSql, parametros);
    }

    /**
     * Ejecuta una actualización de forma genérica.
     * 
     * @param conexion    Conexión activa.
     * @param consultaSql Sentencia UPDATE con marcadores '?'.
     * @param parametros  Valores para sustituir los marcadores.
     * @return Número de filas afectadas.
     */
    public static int actualizarRegistro(Connection conexion, String consultaSql, Object... parametros) {
        return ejecutarActualizacion(conexion, consultaSql, parametros);
    }

    /**
     * Borra un registro de la base de datos.
     * 
     * @param conexion   Conexión activa.
     * @param tabla      Nombre de la tabla.
     * @param columnaId  Nombre de la columna identificadora.
     * @param valorId    Valor del ID a borrar.
     * @return Número de filas afectadas.
     */
    public static int borrarRegistro(Connection conexion, String tabla, String columnaId, Object valorId) {
        String consulta = "DELETE FROM " + tabla + " WHERE " + columnaId + " = ?";
        return ejecutarActualizacion(conexion, consulta, valorId);
    }

    /**
     * Método interno privado para evitar repetición de código en INSERT, UPDATE y DELETE.
     */
    private static int ejecutarActualizacion(Connection conexion, String consulta, Object... parametros) {
        try (PreparedStatement sentencia = conexion.prepareStatement(consulta)) {
            for (int i = 0; i < parametros.length; i++) {
                sentencia.setObject(i + 1, parametros[i]);
            }
            return sentencia.executeUpdate();
        } catch (SQLException e) {
            System.err.println("[ERROR] Error en la operación de escritura: " + e.getMessage());
            return -1;
        }
    }

    /**
     * Realiza una consulta SELECT y devuelve los resultados en una lista de mapas.
     * 
     * @param conexion    Conexión activa.
     * @param consultaSql Sentencia SELECT completa.
     * @return Lista de filas, donde cada fila es un Mapa (Clave: Nombre Columna, Valor: Dato).
     */
    public static List<Map<String, Object>> consultarRegistros(Connection conexion, String consultaSql) {
        List<Map<String, Object>> resultados = new ArrayList<>();
        try (Statement sentencia = conexion.createStatement();
             ResultSet conjuntoResultados = sentencia.executeQuery(consultaSql)) {
            
            ResultSetMetaData metadatos = conjuntoResultados.getMetaData();
            int numeroColumnas = metadatos.getColumnCount();

            while (conjuntoResultados.next()) {
                Map<String, Object> fila = new HashMap<>();
                for (int i = 1; i <= numeroColumnas; i++) {
                    fila.put(metadatos.getColumnName(i), conjuntoResultados.getObject(i));
                }
                resultados.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] Error en la consulta: " + e.getMessage());
        }
        return resultados;
    }

    // ==========================================
    // MÉTODOS DE GESTIÓN DE TRANSACCIONES
    // ==========================================

    /**
     * Desactiva el auto-commit para iniciar una transacción manual.
     */
    public static void iniciarTransaccion(Connection conexion) throws SQLException {
        if (conexion != null) conexion.setAutoCommit(false);
    }

    /**
     * Confirma los cambios realizados y reactiva el auto-commit.
     */
    public static void finalizarTransaccion(Connection conexion) throws SQLException {
        if (conexion != null) {
            conexion.commit();
            conexion.setAutoCommit(true);
        }
    }

    /**
     * Deshace todos los cambios realizados desde el inicio de la transacción.
     */
    public static void deshacerTransaccion(Connection conexion) {
        try {
            if (conexion != null) conexion.rollback();
        } catch (SQLException e) {
            System.err.println("[ERROR] No se pudo deshacer la transacción: " + e.getMessage());
        }
    }

    // ==========================================
    // MÉTODO PRINCIPAL (PRUEBAS)
    // ==========================================

    public static void main(String[] args) {
        // El try-with-resources asegura el cierre de la conexión al finalizar
        try (Connection con = conectarBd()) {

            System.out.println("--- INICIO DE PRUEBAS ---");

            // 1. Consultar Siguiente ID
            int proximoId = consultarSiguienteId(con, "autores", "id_autor");
            System.out.println("Siguiente ID disponible para autor: " + proximoId);

            // 2. Iniciar Transacción para seguridad
            iniciarTransaccion(con);

            try {
                // 3. Crear Registro
                String sqlInsert = "INSERT INTO autores (id_autor, nombre, apellido1, nacionalidad, fecha_nac) VALUES (?, ?, ?, ?, ?)";
                int creados = crearRegistro(con, sqlInsert, proximoId, "Gabriel", "García Márquez", "Colombia", "1927-03-06");
                
                if (creados > 0) System.out.println("Registro creado correctamente.");

                // 4. Verificar Existencia
                if (registroExiste(con, "autores", "id_autor", proximoId)) {
                    System.out.println("Confirmado: El autor existe en la base de datos.");
                }

                // 5. Actualizar Registro
                String sqlUpdate = "UPDATE autores SET nacionalidad = ? WHERE id_autor = ?";
                actualizarRegistro(con, sqlUpdate, "México (Residente)", proximoId);
                System.out.println("Registro actualizado.");

                // 6. Consultar Registros
                System.out.println("\n--- LISTA DE REGISTROS ---");
                List<Map<String, Object>> lista = consultarRegistros(con, "SELECT * FROM autores ORDER BY id_autor DESC LIMIT 3");
                for (Map<String, Object> fila : lista) {
                    System.out.println("ID: " + fila.get("id_autor") + " | Nombre: " + fila.get("nombre") + " " + fila.get("apellido1"));
                }

                // 7. Borrar Registro (Opcional, para mantener limpia la BD)
                borrarRegistro(con, "autores", "id_autor", proximoId);
                System.out.println("Registro de prueba borrado.");

                // Si todo ha ido bien, confirmamos la transacción
                finalizarTransaccion(con);
                System.out.println("\n--- TRANSACCIÓN COMPLETADA CON ÉXITO ---");

            } catch (Exception e) {
                // Si algo falla dentro de la lógica, deshacemos todo
                System.err.println("Algo falló durante la transacción. Deshaciendo cambios...");
                deshacerTransaccion(con);
            }

        } catch (SQLException e) {
            System.err.println("Error crítico de SQL: " + e.getMessage());
        }
    }
}