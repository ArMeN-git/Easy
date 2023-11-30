import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class MyWindow extends JFrame {
    JTable allStudents;
    JTable specificStudents;

    private StudentDAO studentDAO = new StudentDAO();

    public MyWindow()
    {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);
        setSize(800, 800);

        String[] columns = {"Id", "Name", "Surname", "Birthday"};

        addTableToWindow("All Students", studentDAO.getStudents(), columns, allStudents, 500, 400);

        addTableToWindow("Students whose names don't contain duplicates and they are under 22", studentDAO.getStudentsWithUniqueNameLettersAndMaxAge(22), columns, specificStudents, 600, 600);
    }

    public void addTableToWindow(String title, Object[][] data, Object[] columns, JTable table, int width, int height)
    {
        add(new JLabel(title));
        table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(width, height));
        add(scrollPane);
    }
}
