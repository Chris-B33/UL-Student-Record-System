public class Student {
    private String id;
    private String name;
    private Course course;

    public Student(String _id) {
        this.id = _id;
    }

    public void getTranscript() {
        Transcript.displayTranscript(this);
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCourseName() {
        return this.course.getName();
    }

    public Course getCourse() {
        return this.course;
    }
}
