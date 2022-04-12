package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnecctionPostgres {
    
    private static Connection connection;
    
    private ConnecctionPostgres(){
        String url = "jdbc:postgresql://localhost/persistenciadatosjava";
        String user = "postgres";
        String password = "QAZplm123";

        try {
            connection = DriverManager.getConnection(url, user, password);
        }catch (java.sql.SQLException sqle) {
            System.out.println("Error " + sqle);
        }
    }
    public synchronized static Connection getConnectionPostgres(){
        if (connection == null) new ConnecctionPostgres();
        return connection;
    }
}
