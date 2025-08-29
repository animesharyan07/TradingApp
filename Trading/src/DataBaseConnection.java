
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    private static final String url="jdbc:postgresql://localhost:5432/AnimeshDB";
    private static final String user="postgres";
    private static final String password = "12345";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
