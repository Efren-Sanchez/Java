import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class MySQLSentencias1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String user = "root";
        String password = "";
        Statement sentencia;
        String sql;
        ResultSet resultado;

        try (Connection conexion = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión con MySQL establecida.");

            try {
                sentencia = conexion.createStatement();
                sql = "SELECT * FROM autores";
                resultado = sentencia.executeQuery(sql);
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
            }
            conexion.close();
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("ERROR: La conexión con MySQL ha fallado.");
            System.exit(1);
        }
    }
}
