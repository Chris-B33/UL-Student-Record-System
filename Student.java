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
        return this.course.getName();
    }
    
    public Course getCourse(){
        return this.course;
    }
}
