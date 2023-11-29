import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class StudentDAO implements StudentImpl{
    private List<Student> students = new ArrayList<>();
    private Statement statement = null;

    public StudentDAO() {
        try {
            Connect connection = new Connect();
            statement = connection.connectToDB().createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudentsFromDb(){
        try {
            ResultSet resultSet = statement.executeQuery("select * from Student");
            while (resultSet.next()){
                Student st = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4), resultSet.getInt(5));
                students.add(st);
            }
        } catch (SQLException e)  {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean create(Student student) {
        String query = "insert into Student values (null, " + "'" + student.getName() + "', '" + student.getLastname() + "', '" + student.getBirthdate() + "', " + student.getFee() + ")";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e)  {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public Object[][] read() {
        Object[][] objects = null;
        try {
            ResultSet countResult = statement.executeQuery("select count(*) from Student");
            countResult.next();
            int rowCount = countResult.getInt(1);

            objects = new Object[rowCount][6];
            ResultSet resultSet = statement.executeQuery("select * from student");

            for (int i = 0; resultSet.next(); i++) {
                for (int j = 0; j < 5; j++) {
                    objects[i][j] = resultSet.getObject(j + 1);
                }
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return objects;
    }

    @Override
    public boolean update(int id, String name) {
        String query = "update Student set name = '" + name + "' where id = " + id;
        try {
            statement.executeUpdate(query);
        } catch (SQLException e)  {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        String query = "delete from Student where id = " + id;
        try {
            statement.executeUpdate(query);
        } catch (SQLException e)  {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean updateFee() {
        try {
            for (int i = 0; i < students.size(); i++) {
                int currentFee = students.get(i).getFee();
                int updatedFee = currentFee - ((currentFee * 10) / 100);

                students.get(i).setFee(updatedFee);

                int studentId = students.get(i).getID();
                String query = "UPDATE Student SET fee = " + updatedFee + " WHERE id = " + studentId;
                statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    Student highestFee() {
        int maxFee = students.get(0).getFee();
        Student studentWithMaxFee = students.get(0);

        for (int i = 1; i < students.size(); i++) {
            int currentFee = students.get(i).getFee();
            if (currentFee > maxFee) {
                maxFee = currentFee;
                studentWithMaxFee = students.get(i);
            }
        }

        return studentWithMaxFee;
    }

    @Override
    public boolean deleteStudentWithHighestFee() {
        Student student = highestFee();

        int studentId = student.getID();
        String query = "DELETE FROM Student WHERE id = " + studentId;
        try {
            statement.executeUpdate(query);
            students.remove(student);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


    boolean isEven(String lastname) {
        return lastname.length() % 2 == 0;
    }

    @Override
    public Object[][] studentsWithEvenLastname() {
        Object[][] objects = null;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Student");
            List<Object[]> tempList = new ArrayList<>();

            while (resultSet.next()) {
                String lastname = resultSet.getString("SurName");
                if (isEven(lastname)) {
                    Object[] row = new Object[5];
                    for (int j = 0; j < 5; j++) {
                        row[j] = resultSet.getObject(j + 1);
                    }
                    tempList.add(row);
                }
            }

            objects = new Object[tempList.size()][];
            tempList.toArray(objects);

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return objects;
    }

    boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[][] studentsWithPrimeName() {
        Object[][] objects = null;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Student");
            List<Object[]> tempList = new ArrayList<>();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                if (isPrime(name.length())) {
                    Object[] row = new Object[5];
                    for (int j = 0; j < 5; j++) {
                        row[j] = resultSet.getObject(j + 1);
                    }
                    tempList.add(row);
                }
            }
            objects = new Object[tempList.size()][];
            tempList.toArray(objects);

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return objects;
    }


    @Override
    public void updateFee2() {
        try {
            String query = "update students set fee = fee + (fee * 10 / 100)";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteStudentWithHighestFee2() {
        try {
            String query = "delete from students where fee =(select fee from (select max(fee) as fee from students) as temp)";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public void deleteManyStudents() {
        try {
            ResultSet resultSet = statement.executeQuery("select * from students");

            while (resultSet.next()) {
                Student student = new Student();

                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                Date birthday = resultSet.getDate(4);
                int fee = resultSet.getInt(5);

                student.setID(id);
                student.setName(name);
                student.setLastname(surname);
                student.setBirthdate(birthday);
                student.setFee(fee);

                if (name.length() > 5) {
                    delete(id);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteMaxAge() {
        try {
            String query = "DELETE FROM students WHERE YEAR(birthday) = (SELECT MIN(year) FROM (SELECT YEAR(birthday) as year FROM students) AS subquery)";
            statement.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public String[] columnNames() {
        String[] column;
        try {
            ResultSet resultSet = statement.executeQuery("select * from students");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            int columnCount = resultSetMetaData.getColumnCount();
            column = new String[columnCount];

            for (int i = 0; i < column.length; i++) {
                column[i] = resultSetMetaData.getColumnName(i + 1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return column;
    }
}