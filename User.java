import java.util.Scanner;

/**
 * The `User` class represents a user of various types and has different
 * commands for each type of user.
 */
public class User {
    private String userType;
    private Object userObject;

    /**
     * Constructor for objects of class User
     * 
     * @param _userType   type of the user as a String
     * @param _userObject type of the user as an Object
     */
    public User(String _userType, Object _userObject) {
        this.userType = _userType;
        this.userObject = _userObject;
    }

    /**
     * Runs the sub-interpreter.
     */
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
                String id;
                switch (command) {
                    case "A":
                        System.out.println("What is the Student's ID?");
                        id = in.nextLine();
                        if (Interpreter.returnStudent(id) == null) {
                            System.out.println("Student doesn't exist");
                            break;
                        }
                        System.out.println("What is the module's name?");
                        String code = in.nextLine().toUpperCase();
                        if (Interpreter.returnModule(code) == null) {
                            System.out.println("Module doesn't exist");
                            break;
                        }
                        Module mod = Interpreter.returnModule(code);
                        // Module m = new Module(code, code);
                        // m.setEnrolledStudents(CSVReader.readClassRole(code + ".csv"));
                        System.out.println("What is the result?");
                        String grade = in.nextLine();
                        facu.addGradeToModule(new Student(id), mod, Double.parseDouble(grade));
                        break;
                    case "G":
                        System.out.println("Enter Student ID?");
                        id = in.nextLine();
                        if (Interpreter.returnStudent(id) == null) {
                            System.out.println("Student doesn't exist");
                            break;
                        }
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
                        if (Interpreter.returnStudent(id) == null) {
                            System.out.println("Student doesn't exist");
                            break;
                        }
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
