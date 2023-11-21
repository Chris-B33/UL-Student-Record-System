import java.util.Scanner;

public class Student {
    private String id;
    private String name;
    private Course course;

    public Student(String _id, String n, Course c) {
        this.id = _id;
        this.name = n;
        this.course = c;
    }

    public void run() {
        System.out.printf("[Student ID: %s]\n", this.id);

        Scanner in = new Scanner(System.in);
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
        Transcript.displayTranscript(this);
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getCourseName(){
        return this.course.getCourseName();
    }
    
    public Course getCourse(){
        return this.course;
    }
}