public class Faculty {
    public Faculty() {
        
    }

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

    public void getStudentTranscript(Student student) {
        Student stu = student;
        stu.getTranscript();
    }
}