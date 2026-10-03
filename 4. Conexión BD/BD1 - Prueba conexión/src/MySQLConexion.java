import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/programacion";
        String user = "root";
        String password = "";

        try (Connection conexion = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa a MySQL.");
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
