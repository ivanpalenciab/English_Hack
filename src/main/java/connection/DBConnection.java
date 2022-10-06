
package connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
    Connection connection;
    static String bd = "railway";
    static String port = "6542";
    static String login = "root";
    static String password = "aXcxQLTLlT2TiSf8ZSVu";
    static String ip = "containers-us-west-63.railway.app";

    public DBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://"+this.ip+":"+this.port+"/"+this.bd;
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
    
    public void disconnect(){
        connection = null;
    }
}