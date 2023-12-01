import java.util.ArrayList;
import java.util.Scanner;

/**
 * The `Interpreter` class initializes all data and runs the command-line
 * interface.
 */
public class Interpreter {
    private static User user;
    private static ArrayList<Course> courseList = new ArrayList<>();

    /**
     * The main method that runs when this file is ran.
     * 
     * @param args None needed
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean run = true;
        initializeDatabase();

        while (run) {
            System.out.println("Commands: (S)tudent, (F)aculty, (D)epartment, (E)xit");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "S":
                    System.out.println("What is your Student ID?");
                    String id = in.nextLine();
                    if (returnStudent(id) == null) {
                        System.out.println("Student doesn't exist");
                        break;
                    }
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
                    Department department = new Department(courseList.get(0));
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

    private static void getMessages(String id) {
        ArrayList<String> messages = CSVReader.readStudentMessages(id);
        for (int i = 0; i < messages.size(); i++) {
            System.out.println(messages.get(i));
        }
    }

    /**
     * Initialize database of courses from csv files.
     */
    private static void initializeDatabase() {
        Course course1 = initCourse("LM174.csv",
                "Artificial Intelligence and Machine Learning",
                2,
                "Bachelor",
                "Taught");

        ArrayList<Semester> semList = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
            double weight = 0;
            double cred = 30;
            if (i < 3) {
                weight = 1;
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

        int moduleIndex = 0;
        for (Semester sem : semList) {
            while (moduleIndex < modList.size() && sem.getModules().size() < 5) {
                sem.getModules().add(modList.get(moduleIndex));
                moduleIndex++;
            }
            if (moduleIndex >= modList.size()) {
                break;
            }
        }
        courseList.add(course1);
    }

    /**
     * Initializes a course given arguments.
     * 
     * @param fileName   name of the file
     * @param courseName name of the course
     * @param semPerYear amount of semesters per year
     * @param level      level of the course
     * @param type       type of degree studied
     * @return Course The course that was initialized.
     */
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

    /**
     * Initializes a semester given certain arguments.
     * 
     * @param number    number within course
     * @param weighting weighting of semester compared to other years
     * @param credits   credits given per semester
     * @return Semester the initialized semester.
     */
    private static Semester initSemester(int number, double weighting, double credits) {
        Semester s = new Semester(number, weighting);
        s.setCredits(credits);
        return s;
    }

    /**
     * Initializes a module given certain arguments.
     * 
     * @param fileName name of the file
     * @param name     name of the module
     * @param code     code name of the file
     * @param credits  credits alotted to modle
     * @return Module Module object with these arguments
     */
    public static Module initModule(String fileName, String name, String code, double credits) {
        Module m = new Module(name, code);
        m.setFile("data/" + fileName);
        m.setEnrolledStudents(CSVReader.readClassRole(fileName));
        m.setCredits(credits);
        return m;
    }

    /**
     * Gets a student from the initialized courses.
     * 
     * @param id id of the student
     * @return Student the student that was initialized
     */
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

    /**
     * Returns a "Module" object given arguments and exists as a csv.
     *
     * @param code the code name of the module
     * 
     * @return Module the module object
     */
    public static Module returnModule(String code) {
        for (Course c : courseList) {
            ArrayList<Semester> semList = c.getSemesters();
            for (Semester sem : semList) {
                ArrayList<Module> modList = sem.getModules();
                for (Module mod : modList) {
                    // System.out.println(s.getId());
                    if (mod.getCode().equals(code)) {
                        return mod;
                    }
                }
            }
        }
        return null;
    }
}
