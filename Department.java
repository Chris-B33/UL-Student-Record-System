import java.io.IOException;
import java.util.ArrayList;

/**
 * The `Department` class represents a department in a college and can hold an
 * exam board to review academic progression and write messages to students.
 */
public class Department {
    private Course course;

    public Department(Course _course) {
        this.course = _course;
    }

    /*
     * Runs exam board to review student progression.
     */
    public void holdExamBoard() {
        int classLength = this.course.getClassList().size();
        ArrayList<Student> classList = this.course.getClassList();
        ArrayList<Semester> semesterList = this.course.getSemesters();

        // Examine qca of each student from last semester
        Semester lastSemester = semesterList.get(0);
        double[] classQCAsSem1 = new double[classLength];
        for (int i = 0; i < classLength; i++) {
            classQCAsSem1[i] = GradeCalculator.calculateQCA(lastSemester, classList.get(i).getId());
        }

        // Repeat for current semester
        Semester thisSemester = semesterList.get(1);
        double[] classQCAsSem2 = new double[classLength];
        for (int i = 0; i < classLength; i++) {
            classQCAsSem2[i] = GradeCalculator.calculateQCA(thisSemester, classList.get(i).getId());
        }

        // See if majority went up
        int count = 0;
        for (int i = 0; i < classLength; i++) {
            if (classQCAsSem2[i] > classQCAsSem1[i]) {
                count++;
            }
            System.out.printf("Student %s: %.2f\n", classList.get(i).getId(), classQCAsSem2[i] - classQCAsSem1[i]);
        }
        System.out.printf("Did the majority of the class increase their QCA: %s\n", count - (classLength / 2) > 0);

        // See if average qca went up
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < classLength; i++) {
            sum1 += classQCAsSem1[i];
            sum2 += classQCAsSem2[i];
        }
        double avg1 = sum1 / classLength;
        double avg2 = sum2 / classLength;

        System.out.printf("Average QCA change: %.2f\n", avg1 - avg2);
    }

    /**
     * Stores a message for a student given their ID
     * 
     * @param id      id of student
     * @param message message to student
     */
    public void writeMessageToStudent(String id, String message) {
        if (Interpreter.returnStudent(id) == null) {
            System.out.println("Student doesn't exist");
            return;
        }

        try {
            CSVWriter.writeStudentMessage(id, message);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Gets the name of the course.
     * 
     * @return String name of the course.
     */
    public String getName() {
        return this.course.getName();
    }
}
