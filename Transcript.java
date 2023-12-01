import java.time.LocalDate;
import java.util.*;

public class Transcript {
    public static void displayTranscript(Student student) {
        Course c = student.getCourse();

        Transcript.header(student);

        //System.out.printf("Name       %s \n\n\n", student.getName());
        System.out.printf("Course     %s \n", student.getCourseName() );

        ArrayList<Semester> semesters = c.getSemesters();
        for(int i = 0; i < semesters.size(); i++){
            if (semesters.get(i).getModules().size() > 0)
            {
                Transcript.semesterBox(semesters.get(i), student);
            }
            
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

    private static void semesterBox(Semester sem, Student student){
        String boxQCA = "+--------------------------------------------------------------------------------------------+---------------------------+";
        String gapQCA = "|                                                                                            |                           |";

        
        
        System.out.println(boxQCA);
        System.out.println("| " + sem.getYear() + "         " + "SEM" + sem.getNumber() + "                                                                             |            Session To-Date|"); 
        System.out.println(gapQCA);
        System.out.println("|Module       Title                                                        Grade   Credits   |                           |");
        System.out.println(gapQCA);
        
        ArrayList<Module> modules = sem.getModules();
        for(int i = 0; i < modules.size(); i++){
            String modname = String.format("%-65s",modules.get(i).getName());
            String qcs = String.format("%.2f",GradeCalculator.calculateQCS(modules.get(i), student.getId()));
            String qcsDisplay = String.format("%-19s",qcs);
            System.out.println("|" + modules.get(i).getCode() + "      " + modname + GradeCalculator.getGrade(modules.get(i), student.getId()) + "   " + modules.get(i).getCredits() + "       |QCS     " + qcsDisplay + "|");
        } 
        
        String qca = String.format("%.2f",GradeCalculator.calculateQCA(sem, student.getId()));
        String qcaDisplay = String.format("%-18s",qca);
        System.out.println("|                                                                                            |QCA      " + qcaDisplay +"|");
        System.out.println(boxQCA);
    }

}
