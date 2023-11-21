import java.util.Scanner;

public class Faculty {
    private Scanner in;

    public Faculty() {
        in = new Scanner(System.in);
    }

    public void run() {
        boolean run = true;
        while (run) {
            System.out.println("Commands: (A)dd grade, (G)et transcript, (E)xit");
            String command = in.nextLine().toUpperCase();
            switch (command) {
                case "A":
                    this.addGradeToModule(null, null, 0);
                    break;
                case "G":
                    this.getStudentTranscript(null);
                    break;
                case "E":
                    run = false;
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    public void addGradeToModule(Student student, Module module, double grade) {
        
    }

    public void getStudentTranscript(Student student) {
        Student stu = student;
        stu.getTranscript();
    }
}