public class Faculty {
    public Faculty() {

    }

    public void addGradeToModule(Student student, Module module, double grade) {
        try {
            CSVWriter.insertGrade(student.getId(), grade, module.getCode() + ".csv");
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void getStudentTranscript(Student student) {
        if (Interpreter.returnStudent(student.getId()) == null) {
            System.out.println("Student doesn't exist");
        }
        student.getTranscript();
    }
}