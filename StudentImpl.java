import java.util.ArrayList;

public interface StudentImpl {
    boolean create(Student student);
    Object[][] read();
    boolean update(int id, String name);
    boolean delete(int id);
    boolean updateFee();
    boolean deleteStudentWithHighestFee();
    Object[][]  studentsWithEvenLastname();
    Object[][]  studentsWithPrimeName();
    void updateFee2();
    boolean deleteStudentWithHighestFee2();
    void deleteManyStudents();
    void deleteMaxAge();
}