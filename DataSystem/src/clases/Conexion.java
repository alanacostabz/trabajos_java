package clases;
import java.sql.*;

public class Conexion {
   // Conexion local
    public static Connection conectar() {
       try {
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/bd_ds", "root", "");
           return conn;
       } catch(SQLException e) {
           System.out.println("Ha ocurrido un error en la conexión local, " + e.getMessage());
       }
       return null;
    }
    
}
