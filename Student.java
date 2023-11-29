import java.sql.Date;

public class Student {
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private int ID;
    private String name;
    private String lastname;
    private Date birthdate;
    private int fee;

    public Student() {
    }

    public Student(String name, String lastname, Date birthdate, int fee) {
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.fee = fee;
    }

    public Student(int ID, String name, String lastname, Date birthdate, int fee) {
        this.ID = ID;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                ", fee=" + fee +
                '}';
    }
}