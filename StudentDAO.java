import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements StudentImpl{
    private Statement statement;

    public StudentDAO()
    {
        try{
            Connect c = new Connect();
            statement = c.getDbConnection().createStatement();
            fillStudentsData();
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean create(Student s) {
        try{
            String query = "insert into student values (null, " + "'"  + s.getName() + "'," + "'"  + s.getSurname() + "'," + "'"  + s.getBirthday() + "');";
            statement.executeUpdate(query);
            return true;
        }
        catch (SQLException ex){
            System.out.print(ex.getMessage());
            return false;
        }
    }

    @Override
    public Object[][] getStudents() {
        try{
            Object[][] data = null;
            List<Object[]> rows = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("select * from Student");
            while (resultSet.next())
            {
                Object[] row = new Object[4];
                for (int i = 0; i < 4; i++)
                {
                    row[i] = resultSet.getObject(i + 1);
                }
                rows.add(row);
            }

            data = new Object[rows.size()][];
            rows.toArray(data);
            return data;
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Object[][] getStudentsWithUniqueNameLettersAndMaxAge(int minAge) {
        try{
            Object[][] data = null;
            List<Object[]> rows = new ArrayList<>();
            LocalDate now = LocalDate.now();
            LocalDate diff = LocalDate.of(now.getYear() - minAge, now.getMonthValue(), now.getDayOfMonth());
            ResultSet resultSet = statement.executeQuery("select * from Student where Birthday > " + "'" + diff + "'");
            while (resultSet.next())
            {
                String name = resultSet.getString("Name");
                if (containsUniqueLetters(name)) {
                    Object[] row = new Object[4];
                    for (int i = 0; i < 4; i++) {
                        row[i] = resultSet.getObject(i + 1);
                    }
                    rows.add(row);
                }
            }

            data = new Object[rows.size()][];
            rows.toArray(data);
            return data;
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    private Boolean containsUniqueLetters(String text)
    {
        // booleans of length of ascii table symbols
        // to check if letter was already added
        boolean[] letters = new boolean[128];

        for (int i = 0; i < text.length(); i++)
        {
            int index = text.charAt(i) - '0';
            if (letters[index] == true)
            {
                return false;
            }
            else
            {
                letters[index] = true;
            }
        }
        return true;
    }

    private void fillStudentsData()
    {
        create(new Student("Marine", "Karapetyan", LocalDate.of(2003, 5, 4)));
        create(new Student("Narine", "Marutyan", LocalDate.of(2001, 5, 4)));
        create(new Student("Gor", "Gasparyan", LocalDate.of(1997, 5, 13)));
        create(new Student("Lusine", "Petrosyan", LocalDate.of(2002, 5, 4)));
        create(new Student("Meri", "Sahakyan", LocalDate.of(1996, 7, 4)));
    }
}
