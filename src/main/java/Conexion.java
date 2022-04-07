import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public void getConection(){
        String url = "jdbc:postgresql://localhost/persistenciadatosjava?user=postgres&password=QAZplm123";
        try {
            Connection connection = null;
            connection = DriverManager.getConnection(url);
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        }catch (java.sql.SQLException sqle) {
            System.out.println("Error " + sqle);
        }
    }
}
