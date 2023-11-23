
import java.io.IOException;
import java.util.Scanner;

public class Department {
    private String name;

    public Department(String _name) {
        this.name = _name;
    }

    

    public boolean holdExamBoard() {
        return true;
    }

    public void writeMessageToStudent(String id, String message) {
        try {
            CSVWriter.writeStudentMessage(id, message);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public String getName()
    {
        return name;
    }
}
