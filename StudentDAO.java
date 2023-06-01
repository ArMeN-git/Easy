import java.util.Arrays;
import java.util.Date;

public class StudentDAO {
    Student[] students;


    public void AddStudents() {
        Student student1 = new Student("Anna", "Hambardzumyan", new Date(2001, 11, 10), new int[]{30,12,30,15,2});
        Student student2 = new Student("Diana", "Hovakimyan", new Date(2000, 11, 10), new int[]{16, 19, 13, 14, 6});
        Student student3 = new Student("Liana", "Mkrtchyan", new Date(2001, 9, 8), new int[]{14, 14, 15, 18, 20});
        Student student4 = new Student("Ani", "Andriasyan", new Date(1998, 11, 10), new int[]{20, 12, 16, 17, 5});
        Student student5 = new Student("Narine", "Hakobyan", new Date(1997, 11, 10), new int[]{13, 12, 16, 17, 5});
        Student student6 = new Student("Ani", "Mnacakanyan", new Date(2004, 11, 10), new int[]{20, 20, 16, 20, 5});
        Student student7 = new Student("Karen", "Kirakosyan", new Date(2003, 11, 10), new int[]{13, 12, 16, 17, 5});
        this.students = new Student[]{student1, student2, student3, student4, student5, student6, student7};
    }

    // գրել եթե ուզումա window, որ կարողանանք window կլասում student ներին վերցնենք որ ցույց տանք
    public Student[] GetAllStudents()
    {
        return students;
    }

    public void gradesSort() {
        int n = this.students.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                if (this.students[j].average() < this.students[j + 1].average()) {
                    Student temporary = this.students[j];
                    this.students[j] = this.students[j + 1];
                    this.students[j + 1] = temporary;
                }
            }
        }
    }
}