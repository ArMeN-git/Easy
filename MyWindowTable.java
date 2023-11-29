import javax.swing.*;
import java.awt.*;

public class MyWindowTable extends JFrame {
    JTable studentsTable;
    JTable studentsTableFee;
    JTable studentsTableHighestFee;
    JTable studentsTableEvenLastname;
    JTable studentsTablePrimeName;
    JTable projectsTable;
    StudentDAO studentDAO = new StudentDAO();
    ProjectDAO projectDAO = new ProjectDAO();

    public MyWindowTable() {
        String[] studentColumnNames = {"Student ID", "Name", "Lastname", "BirthDay", "Fee"};

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addTableAndLabel("All students", studentDAO.read(), studentColumnNames, studentsTable, 200, 100);

        studentDAO.addStudentsFromDb();
        studentDAO.updateFee();
        addTableAndLabel("Decreasing fees for students by 10%", studentDAO.read(), studentColumnNames, studentsTableFee, 200, 100);

        studentDAO.addStudentsFromDb();
        studentDAO.deleteStudentWithHighestFee();
        addTableAndLabel("Deleted a student whose fee is the highest", studentDAO.read(), studentColumnNames, studentsTableHighestFee, 200, 100);

        addTableAndLabel("Students whose lastname contains even number of letters", studentDAO.studentsWithEvenLastname(), studentColumnNames, studentsTableEvenLastname, 200, 100);

        addTableAndLabel("Students whose name contains a prime number of letters", studentDAO.studentsWithPrimeName(), studentColumnNames, studentsTablePrimeName, 200, 100);

        String[] projectColumnNames = {"Project ID", "Student ID", "Project Name", "Year"};
        addTableAndLabel("Projects", projectDAO.read(), projectColumnNames, projectsTable, 200, 100);

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addTableAndLabel(String labelText, Object[][] data, String[] columnNames, JTable table, int width, int height) {
        add(new JLabel(labelText));
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(width, height));
        add(scrollPane);
    }

}