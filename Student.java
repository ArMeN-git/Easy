import java.util.Arrays;
import java.util.Date;

public class Student
{
    private String name;
    private String sname;
    private int[] grades;
    private Date birthDate;

    public Student(String name, String sname, Date birthDate, int[] grades) {
        this.name = name;
        this.sname = sname;
        this.grades = grades;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    @Override
    public String toString()
    {
        return name + " " + sname + " " + birthDate + " " + "GPA:" + this.average();
    }

    public float average()
    {
        float average = 0;
        for (int i = 0; i < grades.length; ++i) {
            average += grades[i];
        }
        return average / grades.length;
    }

    public boolean checkGrades()
    {
        int count = 0;
        for (int i = 0; i < this.grades.length; i++)
        {
            if (this.grades[i] == 20)
                count++;
        }
        if (count >= 2)
            return true;
        return false;
    }

    public boolean checkDuplicateLetters()
    {
        boolean[] chars = new boolean[127];
        for (int i = 0; i < this.name.length(); i++)
        {
            if (chars[this.name.charAt(i)] == true)
                return true;
            chars[this.name.charAt(i)] = true;
        }
        return false;
    }
}