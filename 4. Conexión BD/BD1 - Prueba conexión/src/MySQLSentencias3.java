import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class MySQLSentencias3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String user = "root";
        String password = "";
        Connection conexion = null;
        Statement sentencia;
        String sql;
        ResultSet resultado;

        // Establecemos conexión con la BD
        try {
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión con MySQL establecida.");
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("ERROR: La conexión con MySQL ha fallado.");
            System.exit(1);
        }

        // Ejecutamos la sentencia SQL
        try {
            sentencia = conexion.createStatement();
            sql = "SELECT COUNT(*) cantidad FROM autores";
            resultado = sentencia.executeQuery(sql);
            
            // El iterador se posiciona antes del primer resultado. Hay que avanzar
            resultado.next();
            int cantidad = resultado.getInt("cantidad");

            if (cantidad == 0) 
                System.out.println("No hay Autores en la BD");
            else {
                sql = "SELECT * FROM autores";
                resultado = sentencia.executeQuery(sql);
    
                // Mientras queden resultados por procesar
                while(resultado.next()) {
                    String nombre = resultado.getString("nombre");
                    String apellido1 = resultado.getString("apellido1");
                    String nacionalidad = resultado.getString("nacionalidad");
                    String fnac = resultado.getString("fecha_nac");
                
                    String salida = "\n\nAutor:\n------\nNombre: " + nombre + "\nApellido: " + apellido1 + "\nNacionalidad: " + nacionalidad + "\nNacimiento: " + fnac;
    
                    System.out.println(salida);
                }
            }
            sentencia.close();
            resultado.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("ERROR: La sentencia SQL ha fallado.");
            e.printStackTrace();
        } 
    }
}
