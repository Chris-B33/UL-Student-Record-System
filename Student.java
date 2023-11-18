import java.util.Scanner;

public class Student {
    private String id;
    private Scanner in;

    public Student(String _id) {
        this.id = _id;
        in = new Scanner(System.in);
    }

    public void run() {
        System.out.printf("[Student ID: %s]\n", this.id);
        boolean run = true;
        while (run) {
            System.out.println("Commands: (G)et transcript, (E)xit");
            String command = in.nextLine().toUpperCase();
            switch (command) {
                case "G":
                    this.getTranscript();
                    break;
                case "E":
                    run = false;
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

    public void getTranscript() {

    }
}
