import java.util.ArrayList;

public interface ProjectImpl {
    boolean create(Project project);
    Object[][] read();
    boolean update(int id, String name);
    boolean delete(int id);
}
