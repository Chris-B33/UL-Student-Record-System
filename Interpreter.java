import java.util.ArrayList;
import java.util.Scanner;

public class Interpreter {
    private static User user;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("Commands: (S)tudent, (F)aculty, (D)epartment, (E)xit");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "S":
                    System.out.println("What is your Student ID?");
                    String id = in.nextLine();
                    System.out.printf("[Student ID: %s]\n", id);
                    getMessages(id);
                    Student student = new Student(id);
                    user = new User("Student", student);
                    user.run();
                    break;
                case "F":
                    Faculty faculty = new Faculty();
                    user = new User("Faculty", faculty);
                    user.run();
                    break;
                case "D":
                    System.out.println("What is the name of your department?");
                    Department department = new Department(in.nextLine());
                    user = new User("Department", department);
                    user.run();
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
        // initialize Students from csv example
        String fileName = "";
        Course c = new Course("LM174", 2);
        ArrayList<String> ids = CSVReader.initStudentId(fileName);
        ArrayList<Student> courseList = new ArrayList<Student>();

        for (int i = 0; i < ids.size(); i++) {
            Student stu = new Student(ids.get(i));
            courseList.add(stu);
        }

        c.setClassList(courseList);
    }

    private static void getMessages(String id) {
        ArrayList<String> messages = CSVReader.readStudentMessages(id);

        for (int i = 0; i < messages.size(); i++) {
            System.out.println(messages.get(i));
        }
    }
}
