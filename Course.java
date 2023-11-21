import java.util.ArrayList;
public class Course
{
    private String name;
    private ArrayList<Semester> semesters;
    private ArrayList<Student> classList;

    public Course(String name) {
        this.name = name;
        this.semesters = new ArrayList<>();
        this.classList = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Semester> getSemesters() {
        return semesters;
    }
    public void setSemesters(ArrayList<Semester> semesters) {
        this.semesters = semesters;
    }
    public ArrayList<Student> getClassList() {
        return classList;
    }
    public void setClassList(ArrayList<Student> classList) {
        this.classList = classList;
    }
}
