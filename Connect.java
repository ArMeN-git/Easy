import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    Connection con = null;
    public Connection connectToDB(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaexam", "root", "root");
            return con;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return con;
    }
}