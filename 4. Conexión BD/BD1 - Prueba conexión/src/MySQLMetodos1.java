import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

// Tipos de bloques para captura de excepciones
// try-catch
// try-catch-finally
// try-with-resource

public class MySQLMetodos1 {

    public static Connection conectarBD_1(String url, String user, String pass) {
        Connection conexion;
        try {
            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión con MySQL establecida.");
            return conexion;
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("ERROR: La conexión con MySQL ha fallado.");
            return null;
        }
    }

    // OJO: este método devuelve una conexión ya cerrada por haberla creado con el try-with-resource
    /*
    public static Connection conectarBD_2(String url, String user, String pass) {
        try (Connection con = DriverManager.getConnection(url, user, pass);){
            System.out.println("Conexión con MySQL establecida.");
            return con;
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("ERROR: La conexión con MySQL ha fallado.");
            return null;
        }
    }
    */

    // Utilizando throws SQLException
    public static Connection conectarBD_3(String url, String user, String pass) throws SQLException  {
        Connection con = DriverManager.getConnection(url, user, pass);
        System.out.println("Conexión con MySQL establecida.");
        return con;
    }

    public static ResultSet consultaSQL(Statement sentencia, String sql) {
        try {
            return sentencia.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("ERROR: La sentencia SQL ha fallado.");
            e.printStackTrace();
            return null;
        }
    }

    public static int modificacionSQL(Statement sentencia, String sql) {
        try {
            return sentencia.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("ERROR: La sentencia SQL ha fallado.");
            e.printStackTrace();
            return -1;
        }
    }

    // Ojo: esta función solo funciona con registros de tipo Usuario, no sirve para cualquiera
    // Es solo ilustrativa de como hacer métodos similares en una clase
    public static void mostrarRegistros(ResultSet resultado) {
        // Mientras queden resultados por procesar
        try {
            while(resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellido1 = resultado.getString("apellido1");
                String nacionalidad = resultado.getString("nacionalidad");
                String fnac = resultado.getString("fecha_nac");
            
                String salida = "\n\nAutor:\n------\nNombre: " + nombre + "\nApellido: " + apellido1 + "\nNacionalidad: " + nacionalidad + "\nNacimiento: " + fnac;
    
                System.out.println(salida);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: La sentencia SQL ha fallado.");
            e.printStackTrace();
        } 
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String user = "root";
        String password = "";
        String sql = "SELECT * FROM autores";

        try (Connection conexion = conectarBD_1(url, user, password);
            Statement sentencia = conexion.createStatement()) {

            // Ejecutamos una sentencia SQL
            ResultSet resultado = consultaSQL(sentencia, sql);
            if (resultado != null) {
                mostrarRegistros(resultado);
            }
        
            // Ejecutamos un INSERT
            int filasAfectadas = modificacionSQL(sentencia, "INSERT INTO autores (id_autor, nombre, apellido1, nacionalidad, fecha_nac) VALUES ('43', 'Efrén', 'Sánchez', 'España', '1982-11-30')");
            if (filasAfectadas < 0) System.out.println("ERROR: El INSERT ha fallado.");
            else System.out.println("Número de filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
