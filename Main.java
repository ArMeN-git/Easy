import java.sql.Date;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        MyWindow myWindow = new MyWindow();

        StudentDAO group = new StudentDAO();
        group.addStudentsFromDb();
        group.updateFee();
        group.deleteStudentWithHighestFee();
        System.out.println(Arrays.deepToString(group.studentsWithPrimeName()));
        System.out.println(Arrays.deepToString(group.studentsWithEvenLastname()));

//        System.out.println(group.getStudents());
//        GregorianCalendar st2date = new GregorianCalendar(2002, 3, 17);
//        Student student = new Student("Ann", "Varosyan", new Date(st2date.getTimeInMillis()), 1000000);
//        group.create(student);
//        group.update(3, "Anna");
//        group.addStudentsFromDb();
//        System.out.println(group.getStudents());
//        group.delete(3);
//        System.out.println(group.getStudents());
    }
}