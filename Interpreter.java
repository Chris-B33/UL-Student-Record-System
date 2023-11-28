import java.util.ArrayList;
import java.util.Scanner;

public class Interpreter {
    private static User user;
    private static ArrayList<Course> courseList = new ArrayList<>();

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
                    Student student = returnStudent(id);
                    user = new User("Student", student);
                    user.run();
                    break;
                case "F":
                    Faculty faculty = new Faculty();
                    user = new User("Faculty", faculty);
                    user.run();
                    break;
                case "D":
                    System.out.println("What is the name of your course?");
                    Department department = new Department(initializeDatabase(in.nextLine()));
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

    private static Course initializeDatabase(String _name) {
        Course course1 = initCourse(String.format("%s.csv", _name),
                "Artificial Intelligence and Machine Learning",
                2,
                "Bachelor",
                "Taught");

        ArrayList<Semester> semList = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
            double weight = 0;
            double cred = 30;
            if (i < 3) {
                weight = 0;
            } else if (i < 5) {
                weight = 1;
            } else if (i < 7) {
                weight = 2;
            } else if (i < 9) {
                weight = 2;
            }
            Semester s = initSemester(i, weight, cred);
            semList.add(s);
        }
        course1.setSemesters(semList);

        ArrayList<Module> modList = CSVReader.initModList("LM174ModList.csv");

        for (Module mod : modList) {
            int i = 1;
            int j = 0;
            if (i / 5 == 1) {
                j++;
            }

            course1.getSemesters().get(j).getModules().add(mod);
            i++;
        }

        courseList.add(course1);
        return course1;
    }

    private static void getMessages(String id) {
        ArrayList<String> messages = CSVReader.readStudentMessages(id);

        for (int i = 0; i < messages.size(); i++) {
            System.out.println(messages.get(i));
        }
    }

    private static Course initCourse(String fileName, String courseName, int semPerYear, String level, String type) {
        Course c = new Course(courseName, semPerYear);
        ArrayList<String> ids = CSVReader.initStudentId(fileName);
        ArrayList<Student> courseList = new ArrayList<Student>();

        for (int i = 0; i < ids.size(); i++) {
            Student stu = new Student(ids.get(i));
            stu.setCourse(c);
            courseList.add(stu);
        }

        c.setClassList(courseList);
        c.setLevel(level);
        c.setType(type);
        return c;
    }

    private static Semester initSemester(int number, double weighting, double credits) {
        Semester s = new Semester(number, weighting);
        s.setCredits(credits);
        return s;
    }

    public static Module initModule(String fileName, String name, String code, double credits) {
        Module m = new Module(name, code);

        m.setEnrolledStudents(CSVReader.readClassRole(fileName));

        m.setCredits(credits);

        return m;
    }

    public static Student returnStudent(String id) {
        for (Course c : courseList) {
            ArrayList<Student> studList = c.getClassList();
            for (Student s : studList) {
                if (s.getId().equals(id)) {
                    return s;
                }
            }
        }
        return null;
    }
}
