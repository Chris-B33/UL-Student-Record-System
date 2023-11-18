import java.util.ArrayList;
import java.util.Scanner;

public class Interpreter {
    private ArrayList<Course> courses;

    public static void main(String[] args) {
        initializeDatabase();

        Scanner in = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("Commands: (S)tudent, (F)aculty, (D)epartment, (E)xit");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "S":
                    System.out.println("What is your Student ID?");
                    String id = in.nextLine();
                    getMessages(id);
                    Student student = new Student(id);
                    student.run();
                    break;
                case "F":
                    Faculty faculty = new Faculty();
                    faculty.run();
                    break;
                case "D":
                    System.out.println("What is the name of your department?");
                    Department department = new Department(in.nextLine());
                    department.run();
                    break;
                case "E":
                    run = false;
                    break;
                default:
                    System.out.println("Invalid entry.");
            }
        }
        in.close();
    }

    private static void initializeDatabase() {

    }

    private static void getMessages(String id) {
        ArrayList<Student> messages = CSVReader.readStudentMessages(id);

        for (int i = 0; i < messages.size(); i++) {
            System.out.println(messages.get(i));
        }
    }
}
