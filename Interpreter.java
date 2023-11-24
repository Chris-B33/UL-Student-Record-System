import java.util.ArrayList;
import java.util.Scanner;

public class Interpreter {
    private ArrayList<Course> courses;
    
    private static User user;

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
                    user = new User("Student", student);
                    user.run();
                    //Student student = new Student(id);
                    //student.run();
                    break;
                case "F":
                    Faculty faculty = new Faculty();
                    user = new User("Faculty", faculty);
                    user.run();
                    //faculty.run();
                    break;
                case "D":
                    System.out.println("What is the name of your department?");
                    Department department = new Department(in.nextLine());
                    user = new User("Department", department);
                    user.run();
                    //department.run();
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
        Course c = new Course("LM174", 2);
        ArrayList<String> ids = CSVReader.initStudentId(fileName);
        ArrayList<String> names = CSVReader.initStudentName(fileName);
        ArrayList<Student> courseList;
        
        for (int i = 0; i < ids.size() && i < names.size(); i++)
        {
            Student stu = new Student(ids.get(i), names.get(i), c);
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
