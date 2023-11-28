import java.io.*;
import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/**
 * This class provides methods to write and manipulate CSV files.
 * @author (Dara O'Malley)
 * @ID (22349243)
 */
public class CSVWriter {
    private static String messagesFileName = "messages.csv";// = path to file must have done for message system to work.

    /**
     * Sets the file name for the messages file.
     *
     * @param fileName The name of the file.
     */
    public static void setMessagesFileName(String fileName) {
        messagesFileName = fileName;
    }

    /*
     * CSVFile layout example
     *
     * student1Id,result1,result2,result3
     * student2Id,result1,result2,result3
     * student3Id,result1,result2,result3
     * student4Id,result1,result2,result3
     * 
     */
    /**
     * Inserts a grade for a student in a CSV file.
     *
     * @param id The ID of the student.
     * @param grade The grade to be inserted.
     * @param moduleName The name of the module.
     * @throws IOException If an input or output exception occurred.
     */
    public static void insertGrade(String id, double grade, String moduleName) throws IOException {
        File csvFile = new File(moduleName);
        List<String> lines = Files.readAllLines(csvFile.toPath(), StandardCharsets.UTF_8);

        for (int i = 0; i < lines.size(); i++) {
            String[] results = lines.get(i).split(",");
            if (results[0].equals(id)) {
                lines.set(i, lines.get(i) + "," + grade);
                break;
            }
        }

        Files.write(csvFile.toPath(), lines, StandardCharsets.UTF_8);
    }

    /*
     * CSVFile layout example
     *
     * student1Id,result1,result2,result3
     * student2Id,result1,result2,result3
     * student3Id,result1,result2,result3
     * student4Id,result1,result2,result3
     * 
     */
    /**
     * Removes a grade for a student in a CSV file.
     *
     * @param id The ID of the student.
     * @param index The index of the grade to be removed.
     * @param moduleName The name of the module.
     * @throws IOException If an input or output exception occurred.
     */
    public static void removeGrade(String id, int index, String moduleName) throws IOException {
        Path path = Paths.get(moduleName);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        for (int i = 0; i < lines.size(); i++) {
            String[] results = lines.get(i).split(",");
            if (results[0].equals(id)) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < results.length; j++) {
                    if (j != index) {
                        sb.append(results[j]);
                        if (j != results.length - 1) {
                            sb.append(",");
                        }
                    }
                }
                lines.set(i, sb.toString());
                break;
            }
        }
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    /*
     * CSVFile layout example
     *
     * student1Id,message1,message2,message3
     * student2Id,message1,message2,message3
     * student3Id,message1,message2,message3
     * student4Id,message1,message2,message3
     * 
     */
    /**
     * Writes a message for a student in a CSV file.
     *
     * @param id The ID of the student.
     * @param message The message to be written.
     * @throws IOException If an input or output exception occurred.
     */
    public static void writeStudentMessage(String id, String message) throws IOException {
        Path path = Paths.get("messages.csv");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        for (int i = 0; i < lines.size(); i++) {
            String[] messages = lines.get(i).split(",");
            if (messages[0].equals(id)) {
                lines.set(i, lines.get(i) + "," + message);
                break;
            }
        }
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    /*
     * CSVFile layout example
     *
     * student1Id,result1,result2,result3
     * student2Id,result1,result2,result3
     * student3Id,result1,result2,result3
     * student4Id,result1,result2,result3
     * 
     */
    /**
     * Adds a student to a CSV file.
     *
     * @param fileName The name of the file.
     * @param id The ID of the student.
     */
    public static void addStudent(String fileName, String id) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.write(id);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
