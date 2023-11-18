import java.util.Scanner;

public class Department {
    private String name;
    private Scanner in;

    public Department(String _name) {
        this.name = _name;
        in = new Scanner(System.in);
    }

    public void run() {
        System.out.printf("[Faculty of %s]\n", this.name.toUpperCase());
        boolean run = true;
        while (run) {
            System.out.println("Commands: (W)rite Message, (H)old Exam Board, (E)xit");
            String command = in.nextLine().toUpperCase();
            switch (command) {
                case "W":
                    System.out.println("What is the student's ID?");
                    String id = in.nextLine();
                    System.out.println("What is the message?");
                    String message = in.nextLine();
                    this.writeMessageToStudent(id, message);
                    break;
                case "H":
                    this.holdExamBoard();
                    break;
                case "E":
                    run = false;
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    public boolean holdExamBoard() {
        return true;
    }

    public void writeMessageToStudent(String id, String message) {
        CSVWriter.writeStudentMessage(id, message);
    }
}
