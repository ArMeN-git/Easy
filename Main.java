public class Main
{
    public static void main(String[] args)
    {
        StudentDAO dao = new StudentDAO();
        dao.AddStudents();

        MyWindow window = new MyWindow(dao);
        window.ShowListOfStudents();
        window.ShowStudentsByGrades();
        window.ShowStudentsWithGivenConditions();
    }
}