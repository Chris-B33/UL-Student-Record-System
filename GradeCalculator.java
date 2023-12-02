import java.util.ArrayList;

/**
 * The `GradeCalculator` class provides methods to calculate and retrieve
 * grades, Quality Credit Score (QCS),
 * and Quality Credit Average (QCA) for modules, semesters, and courses based on
 * a grading scheme.
 */
public class GradeCalculator {
    /**
     * Retrieves the grade for a given student in a specific module.
     *
     * @param module The module for which the grade is to be determined.
     * @param id     The student ID.
     * @return The calculated grade.
     */
    public static String getGrade(Module module, String id) {
        String file = module.getFile();
        ArrayList<Double> studentResults = CSVReader.readStudentResult(file, id);
        int[] bounds = new int[12];
        String[] grades = new String[12];
        try {
            CSVReader.readGradingScheme("GradingScheme.csv", bounds, grades);
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }

        double total = 0;
        int index = 0;

        for (Double results : studentResults) {
            total += results;
        }
        for (int i = 0; i < bounds.length; i++) {
            if (total > bounds[i]) {
                index = i;
            }
        }
        return grades[index];
    }

    /**
     * Calculates the Quality Credit Score (QCS) for a given student in a specific
     * module.
     *
     * @param module The module for which QCS is to be calculated.
     * @param id     The student ID.
     * @return The calculated QCS.
     */
    public static double calculateQCS(Module module, String id) {
        String grade = getGrade(module, id);
        double modCredits = module.getCredits();
        double modQCA = 0.0;

        if (grade.equals("A1")) {
            modQCA += 4.0;
        } else if (grade.equals("A2")) {
            modQCA += 3.6;
        } else if (grade.equals("B1")) {
            modQCA += 3.2;
        } else if (grade.equals("B2")) {
            modQCA += 3.0;
        } else if (grade.equals("B3")) {
            modQCA += 2.8;
        } else if (grade.equals("C1")) {
            modQCA += 2.6;
        } else if (grade.equals("C2")) {
            modQCA += 2.4;
        } else if (grade.equals("C3")) {
            modQCA += 2.0;
        } else if (grade.equals("D1")) {
            modQCA += 1.6;
        } else if (grade.equals("D2")) {
            modQCA += 1.2;
        } else if (grade.equals("F")) {
            modQCA += 0.00;
        } else if (grade.equals("NG")) {
            modQCA += 0.00;
        }

        double modQCS = modQCA * modCredits;
        return modQCS;
    }

    /**
     * Calculates the Quality Credit Average (QCA) for a given student in a specific
     * semester.
     *
     * @param semester The semester for which QCA is to be calculated.
     * @param id       The student ID.
     * @return The calculated QCA.
     */
    public static double calculateQCA(Semester semester, String id) {
        double semCredits = semester.getCredits();
        ArrayList<Module> mods = semester.getModules();

        double modQCS = 0;
        double QCS = 0;
        double semQCA = 0;

        for (int i = 0; i < mods.size(); i++) {
            modQCS = calculateQCS(mods.get(i), id);
            QCS += modQCS;
        }
        semQCA = QCS / semCredits;
        return semQCA;
    }

    /**
     * Calculates the Quality Credit Average (QCA) for a given student in a specific
     * semester and course.
     *
     * @param course   The course to which the semester belongs.
     * @param semester The semester for which QCA is to be calculated.
     * @param id       The student ID.
     * @return The calculated QCA.
     */
    public static double calculateQCA(Course course, Semester semester, String id) {
        ArrayList<Semester> semNum = course.getSemesters();
        double semWeighting = semester.getWeighting();
        double semQCA = 0;
        double semCredits = semester.getCredits();

        double totalQCA = 0;
        double totalCredits = 0;
        double finalQCA = 0;

        for (int i = 0; i < semNum.size(); i++) {
            semQCA = calculateQCA(semNum.get(i), id);
            if (semWeighting > 0) {
                totalCredits += semCredits * semWeighting;
            } else {
                totalCredits += semCredits;
            }
            totalQCA += semQCA;
        }

        finalQCA = totalQCA / totalCredits;
        return finalQCA;

        // if (finalQCA >= 3.40) {
        // System.out.println("First class honours");
        // } else if (finalQCA < 3.40 && finalQCA >= 3.00) {
        // System.out.println("Second class honours grade 1 (2.1)");
        // } else if (finalQCA < 3.00 && finalQCA >= 2.60) {
        // System.out.println("Second class honours grade 2 (2.2)");
        // } else if (finalQCA < 2.60 && finalQCA >= 2.00) {
        // System.out.println("Third class honours");
        // } else {
        // System.out.println("");
        // }
    }
}
