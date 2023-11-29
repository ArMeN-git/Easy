import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class MyWindow extends JFrame implements ActionListener {
    JLabel nameLab = new JLabel("Name");
    JTextField name = new JTextField(10);
    JLabel lastnameLab = new JLabel("Lastname");
    JTextField lastname = new JTextField(10);
    JLabel feeLab = new JLabel("Fee");
    JTextField fee = new JTextField(10);
    JLabel dayLab = new JLabel("Day");
    JTextField day = new JTextField(3);
    JLabel monthLab = new JLabel("Month");
    JTextField month = new JTextField(5);
    JLabel yearLab = new JLabel("Year");
    JTextField year = new JTextField(5);

    JButton buttonAdd = new JButton("Add");
    JButton buttonDel = new JButton("Delete");
    JButton buttonUpd = new JButton("Update");
    JLabel idLab = new JLabel("Student ID");
    JTextField id = new JTextField(10);
    JLabel nameLabUD = new JLabel("Name");
    JTextField nameUD = new JTextField(10);
    JLabel nothing = new JLabel("                                                                                       ");
    JButton buttonView = new JButton("View");
    StudentDAO group = new StudentDAO();

    public MyWindow() throws HeadlessException {
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(600, 600);
        add(nameLab);
        add(name);
        add(lastnameLab);
        add(lastname);
        add(dayLab);
        add(day);
        add(monthLab);
        add(month);
        add(yearLab);
        add(year);
        add(feeLab);
        add(fee);

        add(buttonAdd);
        add(buttonView);

        buttonAdd.addActionListener(this);
        buttonView.addActionListener(this);

        add(nothing);
        add(idLab);
        add(id);
        add(nameLabUD);
        add(nameUD);

        add(buttonDel);
        add(buttonUpd);

        buttonDel.addActionListener(this);
        buttonUpd.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonView) {
            MyWindowTable myWindowTable = new MyWindowTable();
        }
        if (e.getSource() == buttonAdd) {
            Student st = new Student(name.getText(), lastname.getText(), new Date(Integer.parseInt(year.getText()), Integer.parseInt(month.getText()), Integer.parseInt(day.getText())), Integer.parseInt(fee.getText()));
            group.create(st);
            group.addStudentsFromDb();
            name.setText("");
            lastname.setText("");
            day.setText("");
            month.setText("");
            year.setText("");
            fee.setText("");

            System.out.println(group.getStudents());
        }
        if (e.getSource() == buttonDel) {
            group.delete(Integer.parseInt(id.getText()));
            id.setText("");
            nameUD.setText("");
        }
        if (e.getSource() == buttonUpd) {
            group.update(Integer.parseInt(id.getText()), nameUD.getText());
            id.setText("");
            nameUD.setText("");
        }
    }
}