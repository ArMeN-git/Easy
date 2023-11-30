import java.time.LocalDate;

public class Student {
    private int Id;
    private String Name;
    private String Surname;
    private LocalDate Birthday;

    public Student(String name, String surname, LocalDate birthday) {
        Name = name;
        Surname = surname;
        Birthday = birthday;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public LocalDate getBirthday() {
        return Birthday;
    }

    public void setBirthday(LocalDate birthday) {
        Birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Birthday=" + Birthday +
                '}';
    }
}
