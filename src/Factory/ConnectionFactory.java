package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    String url = "jdbc:mysql://localhost:3306/bibliotecas";
    String user = "root";
    String senha ="adm123";

    public Connection getConnection(){
        try{
            return DriverManager.getConnection(url,user,senha);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
