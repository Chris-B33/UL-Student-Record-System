import java.util.ArrayList;
public class Module
{
    private String name;
    private String code;
    private ArrayList<String> enrolledStudents;

    public Module(String name, String code) {
        this.name = name;
        this.code = code;
        this.enrolledStudents = new ArrayList<>();
    }
    public void addStudent(String id) {
        enrolledStudents.add(id);
    }
    public void dropStudent(String id) {
        enrolledStudents.remove(id);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public ArrayList<String> getEnrolledStudents() {
        return enrolledStudents;
    }
    public void setEnrolledStudents(ArrayList<String> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}
