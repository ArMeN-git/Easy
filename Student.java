import java.util.Arrays;
public class Student
{
    private String name;
    private String sname;
    private int age;
    private static final String university = "UFAR";
    private static final String Faculty = "IMA";
    private int[] grades;

    public Student(String name, String sname, int age, int[] grades) {
        this.name = name;
        this.sname = sname;
        this.age = age;
        this.grades = grades;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public static String getUniversity() {
        return university;
    }

    public static String getFaculty() {
        return Faculty;
    }
    @Override
    public String toString()
    {
        return name + " " + sname + " " + age + " " + university +" " + Faculty + " "  + "GPA:" + this.average();
    }
    public float average()
    {
        float average = 0;
        for (int i = 0; i < grades.length; ++i) {
            average += grades[i];
        }
        return average / grades.length;
    }


    public boolean isPrime() {
        for (int i = 0; i < this.grades.length; ++i) {
            boolean isPrime = true;
            for (int j = 2; j <= grades[i] / 2; j++) {

                if (this.grades[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true)
                return true;

        }
        return false;
    }
    public boolean ISAveragePrime()
    {
        float average = this.average();
        for (int i = 2; i <= average/ 2; i++) {

            if (average % i == 0)
            {
                return false;
            }
        }
        return true;
    }
    public boolean IsPalindrome()
    {
        int low = 0;

        int high = (name.length()) - 1;
        boolean isPalindrome = true;
        while (low < high) {
            if (name.toLowerCase().charAt(low)!= name.toLowerCase().charAt(high))
            {
                isPalindrome = false;
                break;
            }

            low++;
            high--;
        }
        return isPalindrome;
    }

    //array-ում թիվա ման գալիս orinak 15
    public boolean FindNumber()
    {
        for (int i = 0;i <this.grades.length;i++ )
        {
            if (grades[i] == 15)
                return true;
        }
        return false;
    }
}