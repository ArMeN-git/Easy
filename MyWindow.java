import javax.swing.*;
import java.awt.*;
public class MyWindow extends JFrame {

    private JLabel[] labels;
    private StudentDAO dao;

    public MyWindow(StudentDAO dao) {

        setVisible(true);
        setLayout(new FlowLayout());
        setSize(800, 500);
        this.dao = dao;
        //labels = new JLabel[dao.GetAllStudents().length];
        //createLabels(labels, dao.GetAllStudents());
    }

    public void ShowListOfStudents()
    {
        JTextField textField = new JTextField();
        textField.setBackground(new Color(15,230,230));
        textField.setText("All students");
        add(textField);
        labels = new JLabel[this.dao.GetAllStudents().length];
        createLabels(labels, dao.GetAllStudents());
    }

    public void ShowStudentsByGrades()
    {
        JTextField textField = new JTextField();
        textField.setBackground(new Color(15,230,230));
        textField.setText("Students sorted by grades");
        add(textField);
        labels = new JLabel[this.dao.GetAllStudents().length];
        dao.gradesSort();
        createLabels(labels, dao.GetAllStudents());
    }

    public void ShowStudentsWithGivenConditions()
    {
        var students = dao.GetAllStudents();
        for (int i = 0; i < students.length; i++)
        {
            if (students[i].checkGrades() && !students[i].checkDuplicateLetters())
            {
                JTextField textField = new JTextField();
                textField.setBackground(new Color(15,230,230));
                textField.setText("Students with conditions");
                add(textField);
                labels = new JLabel[1];
                createLabels(labels, new Student[]{students[i]});
            }
        }
    }
    public void createLabels(JLabel[] labels, Student[] students) {
        for (int i = 0; i < students.length; i++) {
            labels[i] = new JLabel(students[i].toString());
            add(labels[i]);
        }
    }
}