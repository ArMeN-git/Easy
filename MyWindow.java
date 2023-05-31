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

    public void ShowAllStudents()
    {
        JTextField textField = new JTextField();
        textField.setBackground(new Color(15,230,230));
        textField.setText("All students");
        add(textField);
        labels = new JLabel[this.dao.GetAllStudents().length];
        createLabels(labels, dao.GetAllStudents());
    }

    public void ShowStudentsSortedByGrades()
    {
        JTextField textField = new JTextField();
        textField.setBackground(new Color(15,230,230));
        textField.setText("Students sorted by grades");
        add(textField);
        labels = new JLabel[this.dao.GetAllStudents().length];
        dao.gradesSort();
        createLabels(labels, dao.GetAllStudents());
    }

    public void ShowStudentsSortedByAlphabetical()
    {
        JTextField textField = new JTextField();
        textField.setBackground(new Color(15,230,230));
        textField.setText("Students sorted by names and surnames");
        add(textField);
        labels = new JLabel[this.dao.GetAllStudents().length];
        dao.alphabeticalSort();
        createLabels(labels, dao.GetAllStudents());
    }

    // եթե պետքա մեթոդ, որը տպումա ինր որ student ին յուրահատուկ ձԵով, ասենք կարմիր գույնով, հատուկ տեքստով
    // DAO ից ուղղակի վերցնում ենք student ներին, ու նույն ձԵ իրանց վրա for անում ոնց որ DAO ում էինք անում
    // տպել Անի ին  կարմիրով
    public void ShowSuperStudentInRed()
    {
        Student[] students = dao.GetAllStudents();
        for (int i = 0; i < students.length; i++)
        {
            if (students[i].getName() == "Ani")
            {
                JTextField textField = new JTextField();
                textField.setBackground(new Color(255,0,0));
                textField.setText("ANI");
                add(textField);
                return;
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