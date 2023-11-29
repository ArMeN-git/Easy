import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO implements ProjectImpl {
    private List<Project> projects = new ArrayList<>();
    private Statement statement = null;

    public ProjectDAO() {
        try {
            Connect connection = new Connect();
            statement = connection.connectToDB().createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addProjectsFromDb(){
        try {
            ResultSet resultSet = statement.executeQuery("select * from Projects");
            while (resultSet.next()){
                Project project = new Project(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                projects.add(project);
            }
        } catch (SQLException e)  {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public boolean create(Project project) {
        String query = "insert into Projects values (null, " + "'" + project.getProjectName() + "', '" + project.getYear() + "', '" + project.getStudentId() + ")";
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
            ResultSet countResult = statement.executeQuery("select count(*) from Projects");
            countResult.next();
            int rowCount = countResult.getInt(1);

            objects = new Object[rowCount][6];
            ResultSet resultSet = statement.executeQuery("select * from Projects");

            for (int i = 0; resultSet.next(); i++) {
                for (int j = 0; j < 4; j++) {
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
        String query = "update Projects set projectname = '" + name + "' where id = " + id;
        try {
            statement.executeUpdate(query);
        } catch (SQLException e)  {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        String query = "delete from Projects where id = " + id;
        try {
            statement.executeUpdate(query);
        } catch (SQLException e)  {
            System.out.println(e.getMessage());
        }
        return true;
    }
}