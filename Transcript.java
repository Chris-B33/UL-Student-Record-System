import java.time.LocalDate;
import java.util.*;

public class Transcript {
    public static void displayTranscript(Student student) {
        Course c = student.getCourse();

        Transcript.header(student);

        System.out.printf("Name       %s \n\n\n", student.getName());
        System.out.printf("Course     %s \n", student.getCourseName() );

        ArrayList<Semester> semesters = c.getSemesters();
        for(int i = 0; i < semesters.size(); i++){
            Transcript.semesterBox(semesters.get(i));
        }

    }

    private static void header(Student stu){
        String box = "+------------------------------------------------------------------------------------------------------------------------+";
        String gap = "|                                                                                                                        |";

        System.out.println(box);
        System.out.println("|                                     University of Limerick                                                             |");
        System.out.println(gap);
        System.out.println("|" + LocalDate.now() + "                          Student Full Transcript                                       " + stu.getId()  + "              |");
        System.out.println(gap);
        System.out.println(box);
    }

    private static void semesterBox(Semester sem){
        String boxQCA = "+--------------------------------------------------------------------------------------------+---------------------------+";
        String gapQCA = "|                                                                                            |                           |";

        System.out.println(boxQCA);
        System.out.println("| " + sem.getYear() + "         " + sem.getSemNum() + "                                                                        |            Session To-Date|"); //year n semester n session to date
        System.out.println(gapQCA);
        System.out.println("|Module       Title                                             Regn Type  Grade   Credits   |Factor      1.000          |");
        System.out.println(gapQCA);
        
        ArrayList<Module> modules = sem.getModules();
        for(int i = 0; i < modules.size(); i++){
            System.out.println("|" + modules.get(i).getModuleCode() + "      " + modules.get(i).getModuleName() + "                         N             C3   6       |Cred Hours  30.00   30.00  |");
            // get grades n stuff
        } 

    }

}
