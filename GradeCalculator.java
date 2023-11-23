import java.util.ArrayList;
public class GradeCalculator
{
    public static String getGrade(Module module, String id) {
        String grade = "";
        String file = module.getFile();
        ArrayList<Double> studentResults = CSVReader.readStudentResults(file, id);
        int[] bounds = new int[12];
        String[] grades = new String[12];
        CSVReader.readGradeFile(GradingScheme.csv, bounds, grades);
        
        double total = 0;
        int index = 0;
        
        for (Double results : studentResults){
            total += results;
        }
        for (int i = 0; i<bounds.length; i++){
            if(total > bounds[i]){
                index = i;
            }
        }
        return grades[index];
    }
    public static double calculateQCS(Module module, String id) {
        String grade = getGrade(module, id);
        double modCredits = module.getCredits();
        double modQCA = 0.0;
        int i = 0;

        if (grade.equals("A1")) {
            modQCA += 4.0;
            i++;
        } else if (grade.equals("A2")) {
            modQCA += 3.6;
            i++;
        } else if (grade.equals("B1")){
            modQCA += 3.2;
            i++;
        } else if (grade.equals("B2")) {
            modQCA += 3.0;
            i++;
        } else if (grade.equals("B3")) {
            modQCA += 2.8;
            i++;
        } else if (grade.equals("C1")) {
            modQCA += 2.6;
            i++;
        } else if (grade.equals("C2")) {
            modQCA += 2.4;
            i++;
        } else if (grade.equals("C3")) {
            modQCA += 2.0;
            i++;
        } else if (grade.equals("D1")) {
            modQCA += 1.6;
            i++;
        } else if (grade.equals("D2")) {
            modQCA += 1.2;
            i++;
        } else if (grade.equals("F")) {
            modQCA += 0.00;
            i++;
        } else if (grade.equals("NG")) {
            modQCA += 0.00;
            i++;
        } else {
            System.out.println("I");
        }

        double QCS = modQCA*modCredits;
        System.out.println(QCS);
    }
    public static double calculateQCA(Semester semester, String id) {
        double semCredits= semester.getCredits();
        double QCS = calculateQCS();
        double semQCA = QCS/semCredits;
        System.out.println(semQCA);
    }
    public static double calculateQCA(Course course, String id) {
        double totalQCA = 0.0;
        double totalCredits = 0.0;
        
        // //if semester weighting counts to final add semQCA
        // //semQCAs added = totalQCAs
        // if (.getWeighting>0){
            // semQCA += totalQCA;
            // semCredits += totalCredits;
        // }
        
        double finalQCA = totalQCA/totalCredits;

        if (finalQCA >= 3.40) {
            System.out.println("First class honours");
        } else if (finalQCA < 3.40 && finalQCA >= 3.00) {
            System.out.println("Second class honours grade 1 (2.1)");
        } else if (finalQCA < 3.00 && finalQCA >= 2.60) {
            System.out.println("Second class honours grade 2 (2.2)");
        } else if (finalQCA < 2.60 && finalQCA >= 2.00) {
            System.out.println("Third class honours");
        } else {
            System.out.println("");
        }
    }
}
