public class Project {
    private int id;
    private String projectName;
    private int year;
    private int studentId;

    public Project() {
    }

    public Project(int id, String projectName, int year, int studentId) {
        this.id = id;
        this.projectName = projectName;
        this.year = year;
        this.studentId = studentId;
    }

    public Project(String projectName, int year, int studentId) {
        this.projectName = projectName;
        this.year = year;
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", year=" + year +
                ", studentId=" + studentId +
                '}';
    }
}