import java.util.Scanner;

public class Department {
    private String name;

    public Department(String _name) {
        this.name = _name;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
    }

    public String getName() {
        return this.name;
    }

    public boolean holdExamBoard() {
        return true;
    }

    public void writeMessageToStudent(String id, String message) {

    }
}
