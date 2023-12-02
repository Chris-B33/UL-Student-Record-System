import java.util.ArrayList;

/**
 * The `Module` class represents an academic module with attributes such as
 * name, code, credits,
 * file name, and a list of enrolled students.
 */
public class Module {

    /**
     * The name of the module.
     */
    private String name;

    /**
     * The code associated with the module.
     */
    private String code;

    /**
     * The number of credits assigned to the module.
     */
    private double credits;

    /**
     * The name of the file associated with the module.
     */
    private String fileName;

    /**
     * List of student IDs enrolled in the module.
     */
    private ArrayList<String> enrolledStudents;

    /**
     * Constructs a new `Module` object with the given name and code.
     *
     * @param name The name of the module.
     * @param code The code associated with the module.
     */
    public Module(String name, String code) {
        this.name = name;
        this.code = code;
        this.enrolledStudents = new ArrayList<>();
    }

    /**
     * Adds a student to the list of enrolled students in the module.
     *
     * @param id The ID of the student to be added.
     */
    public void addStudent(String id) {
        enrolledStudents.add(id);
    }

    /**
     * Removes a student from the list of enrolled students in the module.
     *
     * @param id The ID of the student to be removed.
     */
    public void dropStudent(String id) {
        enrolledStudents.remove(id);
    }

    /**
     * Returns the name of the module.
     *
     * @return The name of the module.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the module.
     *
     * @param name The new name of the module.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the code associated with the module.
     *
     * @return The code of the module.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code associated with the module.
     *
     * @param code The new code of the module.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns the number of credits assigned to the module.
     *
     * @return The number of credits for the module.
     */
    public double getCredits() {
        return credits;
    }

    /**
     * Sets the number of credits assigned to the module.
     *
     * @param credits The new number of credits for the module.
     */
    public void setCredits(double credits) {
        this.credits = credits;
    }

    /**
     * Returns the name of the file associated with the module.
     *
     * @return The file name of the module.
     */
    public String getFile() {
        return fileName;
    }

    /**
     * Sets the name of the file associated with the module.
     *
     * @param fileName The new file name of the module.
     */
    public void setFile(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Returns the list of student IDs enrolled in the module.
     *
     * @return List of enrolled student IDs.
     */
    public ArrayList<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    /**
     * Sets the list of student IDs enrolled in the module.
     *
     * @param enrolledStudents The new list of enrolled student IDs.
     */
    public void setEnrolledStudents(ArrayList<String> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}
