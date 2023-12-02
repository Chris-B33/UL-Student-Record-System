/**
 * The 'Student' class represents a student with an id, name, and course and
 * can view a transcript of their grades.
 */
public class Student {
    /**
     * The student's ID number.
     */
    private String id;

    /**
     * The student's name.
     */
    private String name;

    /**
     * The student's course of study.
     */
    private Course course;

    /**
     * Constucts a new Student object with an ID, name and course.
     * 
     * @param _id The ID number of the student.
     */
    public Student(String _id) {
        this.id = _id;
    }

    /**
     * Prints out a student transcript.
     */
    public void getTranscript() {
        Transcript.displayTranscript(this);
    }

    /**
     * Returns the student's ID number.
     * 
     * @return Student's ID.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Returns the student's name.
     * 
     * @return Student's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the name of student's course of study.
     * 
     * @return The name of student's course of study.
     */
    public String getCourseName() {
        return this.course.getName();
    }

    /**
     * Returns the student's course of study.
     * 
     * @return Student's course of study.
     */
    public Course getCourse() {
        return this.course;
    }

    /**
     * Sets the student's course of study.
     * 
     * @param _course course of study.
     */
    public void setCourse(Course _course) {
        this.course = _course;
    }
}