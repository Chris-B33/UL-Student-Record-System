import java.util.Scanner;

public class User {
    private String userType;
    private Object userObject;

    /**
     * Constructor for objects of class User
     */
    public User(String _userType, Object _userObject) {
        this.userType = _userType;
        this.userObject = _userObject;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        boolean run = true;

        if (userType.equals("Student")) {
            Student stud = (Student) userObject;
            while (run) {
                System.out.println("Commands: (G)et transcript, (E)xit");
                String command = in.nextLine().toUpperCase();
                switch (command) {
                    case "G":
                        stud.getTranscript();
                        break;
                    case "E":
                        run = false;
                        break;
                    default:
                        System.out.println("Invalid command.");
                }
            }
        } else if (userType.equals("Faculty")) {
            Faculty facu = (Faculty) userObject;
            while (run) {
                System.out.println("Commands: (A)dd grade, (G)et transcript, (E)xit");
                String command = in.nextLine().toUpperCase();
                switch (command) {
                    case "A":
                        facu.addGradeToModule(null, null, 0);
                        break;
                    case "G":
                        System.out.println("Enter Student ID?");
                        String id = in.nextLine();
                        Student student = Interpreter.returnStudent(id);
                        facu.getStudentTranscript(student);
                        break;
                    case "E":
                        run = false;
                        break;
                    default:
                        System.out.println("Invalid command.");
                }
            }
        } else if (userType.equals("Department")) {
            Department depa = (Department) userObject;
            System.out.printf("[Faculty of %s]\n", (depa.getName()).toUpperCase());
            while (run) {
                System.out.println("Commands: (W)rite Message, (H)old Exam Board, (E)xit");
                String command = in.nextLine().toUpperCase();
                switch (command) {
                    case "W":
                        System.out.println("What is the student's ID?");
                        String id = in.nextLine();
                        System.out.println("What is the message?");
                        String message = in.nextLine();
                        depa.writeMessageToStudent(id, message);
                        break;
                    case "H":
                        depa.holdExamBoard();
                        break;
                    case "E":
                        run = false;
                        break;
                    default:
                        System.out.println("Invalid command.");
                }
            }
        }
        // DO NOT CLOSE SCANNER HERE.
        // JAVA ONLY ALLOWS ONE FOR PROGRAM.
        // CLOSING HERE CLOSES ALL.
    }
}
