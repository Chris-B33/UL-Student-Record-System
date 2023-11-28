import java.util.ArrayList;
public class Module
{
    private String name;
    private String code;
    private double credits;
    private String fileName;
    private ArrayList<String> enrolledStudents;

    public Module(String name, String code) {
        this.name = name;
        this.code = code;
        this.credits = credits;
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
    public double getCredits() {
        return credits;
    }
    public void setCredits(double credits) {
        this.credits = credits;
    }
    public String getFile() {
        return fileName;
    }
    public void setFile(String fileName) {
        this.fileName = fileName;
    }
    public ArrayList<String> getEnrolledStudents() {
        return enrolledStudents;
    }
    public void setEnrolledStudents(ArrayList<String> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}

