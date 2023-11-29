import java.util.ArrayList;
/**
 * The `Course` class represents an academic course with attributes such as name, semesters,
 * class list, semesters per year, level, and type.
 */
public class Course {

    /**
     * The name of the course.
     */
    private String name;

    /**
     * List of semesters associated with the course.
     */
    private ArrayList<Semester> semesters;

    /**
     * List of students enrolled in the course.
     */
    private ArrayList<Student> classList;

    /**
     * Number of semesters per year for the course.
     */
    private int semPerYear;

    /**
     * The academic level of the course.
     */
    private String level;

    /**
     * The type of the course (e.g., elective, required).
     */
    private String type;

    /**
     * Constructs a new `Course` object with the given name and number of semesters per year.
     *
     * @param name        The name of the course.
     * @param semPerYear  The number of semesters per year for the course.
     */
    public Course(String name, int semPerYear) {
        this.name = name;
        this.semesters = new ArrayList<>();
        this.classList = new ArrayList<>();
        this.semPerYear = semPerYear;
    }

    /**
     * Returns the name of the course.
     *
     * @return The name of the course.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the course.
     *
     * @param name The new name of the course.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the list of semesters associated with the course.
     *
     * @return List of semesters.
     */
    public ArrayList<Semester> getSemesters() {
        return semesters;
    }

    /**
     * Sets the list of semesters associated with the course.
     *
     * @param semesters The new list of semesters.
     */
    public void setSemesters(ArrayList<Semester> semesters) {
        this.semesters = semesters;
    }

    /**
     * Returns the list of students enrolled in the course.
     *
     * @return List of students.
     */
    public ArrayList<Student> getClassList() {
        return classList;
    }

    /**
     * Sets the list of students enrolled in the course.
     *
     * @param classList The new list of students.
     */
    public void setClassList(ArrayList<Student> classList) {
        this.classList = classList;
    }

    /**
     * Returns the number of semesters per year for the course.
     *
     * @return The number of semesters per year.
     */
    public int getSemPerYear() {
        return semPerYear;
    }

    /**
     * Sets the number of semesters per year for the course.
     *
     * @param semPerYear The new number of semesters per year.
     */
    public void setSemPerYear(int semPerYear) {
        this.semPerYear = semPerYear;
    }

    /**
     * Returns the academic level of the course.
     *
     * @return The academic level of the course.
     */
    public String getLevel() {
        return level;
    }

    /**
     * Sets the academic level of the course.
     *
     * @param level The new academic level of the course.
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Returns the type of the course.
     *
     * @return The type of the course.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the course.
     *
     * @param type The new type of the course.
     */
    public void setType(String type) {
        this.type = type;
    }
}
