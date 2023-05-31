import java.util.Arrays;

public class StudentDAO {
    Student[] students;


    public void AddStudents() {
        Student student1 = new Student("Anna", "Barseghyan", 20, new int[]{30,12,30,15,2});
        Student student2 = new Student("Diana", "Sargsyan", 24, new int[]{16, 19, 13, 14, 6});
        Student student3 = new Student("Liana", "Aghamalyan", 21, new int[]{14, 14, 15, 18, 20});
        Student student4 = new Student("Ani", "Aghamalyan", 23, new int[]{13, 12, 16, 17, 5});
        this.students = new Student[]{student1, student2, student3, student4};
        //System.out.println(Arrays.toString(students));
    }

    // գրել եթե ուզումա window, որ կարողանանք window կլասում student ներին վերցնենք որ ցույց տանք
    public Student[] GetAllStudents()
    {
        return students;
    }

    ////Գնահատականների միջինն ա տպում(Array-ի մեջ պահելով):
    public int printAverage()
    {
        for (int i = 0; i < students.length; i++)
        {
            System.out.println(students[i].average());
        }
        return 0;
    }

    // Գնահատականների միջինն Սորտավորումը bubble sort Ալգորիտմի միջոցով։
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

    ////// <<<<< Կանչելով gradesSort ֆունկցիան սորտավորում ենք անունները ըստ գնահատականների
    // ու տպում ենք Օրինակ Average Grade 14 -համապատասխան ուսանողի տվյալներով Array-ը։
    public void printStudentsGrades() {
        this.gradesSort();
        Student[] student = this.students;

        for (int i = 0; i < student.length; i++) {
            Student s = student[i];
            System.out.print("Average Grade" + " " + student[i].average() + " - ");
            System.out.println(s);
        }

    }
    /// <<<<< Սորտավորում ենք Անունները ըստ այբենական կարգով ,
    // եթե անունները նույնն են, ապա ստուգում ենք նաև ազգանունները։
    public void alphabeticalSort() {
        int n = this.students.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                if (this.students[j].getName().compareTo(this.students[j + 1].getName()) > 0) {
                    Student temporary = this.students[j];
                    this.students[j] = this.students[j + 1];
                    this.students[j + 1] = temporary;
                } else if (this.students[j].getName().compareTo(this.students[j + 1].getName()) == 0) {
                    if (this.students[j].getSname().compareTo(this.students[j + 1].getSname()) > 0) {
                        Student temporary = this.students[j];
                        this.students[j] = this.students[j + 1];
                        this.students[j + 1] = temporary;
                    }
                }
            }
        }
    }
    ////// <<<<< Կանչելով alphabeticalSort() ֆունկցիան սորտավորում ենք անունները
    // տպում ենք Օրինակ Աննա Բարսեղյան եվ այլն։
    public void printStudentsAlphabetical() {
        this.alphabeticalSort();
        Student[] student = this.students;

        for (int i = 0; i < student.length; i++) {
            Student s = student[i];
            System.out.println(s);
        }

    }
    //տպում է ուսանողներին ում անունը պալինդռոմ է և ում գնահատականի մեջ կա գոնե է պարզ թվի
    public void primeAndPalindrome()
    {
        for (int i = 0; i < students.length; i++) {
            if (students[i].isPrime() && students[i].IsPalindrome()) {
                System.out.println(students[i]);
            }
        }
    }
    ///is average is prime
    public void PrintPrimeAverage()
    {
        for (int i = 0; i < students.length; i++) {
            if (students[i].ISAveragePrime())
            {
                System.out.println(students[i]);
            }
        }
    }
    //գտնել Էն ուսանողներին ովքեր ունեն 15 գնահատական
    public void FindNumber()
    {
        for (int i = 0; i < students.length; i++) {
            if (students[i].FindNumber())
            {
                System.out.println(students[i]);
            }
        }
    }
    public void FixedAverage() {
        for (int i = 0; i < students.length; i++)
            if (students[i].average() > 15 && (students[i].getName()).charAt(0)=='A') {
                System.out.println(students[i]);
            }
    }
}
