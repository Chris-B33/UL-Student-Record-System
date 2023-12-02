/**
 * The 'Faculty' class allows a member of the faculty in a college to view 
 * transcripts for students and give students a grade for a module.
 */
public class Faculty {
    /**
     * Adds a students result for a module to a CSV file.
     * 
     * @param student   The student receiving the result.
     * @param module    The module the result is for.
     * @param grade     The result from 0 to 100 for the exam or project.
     */
    public void addGradeToModule(Student student, Module module, double grade) {
        try
        {
            CSVWriter.insertGrade(student.getId(), grade, module.getName());
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    /**
     * Gets a students transcript.
     * 
     * @param student   The student whos transcript is shown.
     */
    public void getStudentTranscript(Student student) {
        Student stu = student;
        stu.getTranscript();
    }
}