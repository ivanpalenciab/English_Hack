
package connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
    Connection connection;
    static String bd = "english_hack";
    static String port = "3306";
    static String login = "root";
    static String password = "admin";

    public DBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:"+this.port+"/"+this.bd;
            connection = DriverManager.getConnection(url,this.login,this.password);
            System.out.println("conexion");
            if (connection == null){
                System.out.println("Conexion fallida");
            }else {
                System.out.println("Conexion exitosa");
            }
        } catch (Exception ex) {
            System.out.println("Conexion Fallida");
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public void desconectar(){
        connection = null;
    }
}