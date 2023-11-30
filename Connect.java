import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public Connection getDbConnection()
    {
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "Ufar2020");
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            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
            return null;
        }
    }
}
