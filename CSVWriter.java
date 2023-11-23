import java.io.*;
import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class CSVWriter
{
    private static String messagesFileName;// = path to file must have done for message system to work.
    
    public static void insertGrade(String id, double grade, String moduleName) throws IOException 
    {
        File csvFile = new File(moduleName);
        List<String> lines = Files.readAllLines(csvFile.toPath(), StandardCharsets.UTF_8);
        
        for (int i = 0; i < lines.size(); i++)
        {
            String[] results = lines.get(i).split(",");
            if (results[0].equals(id))
            {
                lines.set(i,lines.get(i) + "," + grade);
                break;
            }
        }
        
        Files.write(csvFile.toPath(), lines, StandardCharsets.UTF_8);
    }

    public static void removeGrade(String id, int index, String moduleName) throws IOException 
    {
        Path path = Paths.get(moduleName);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        
        for (int i = 0; i < lines.size(); i++)
        {
            String[] results = lines.get(i).split(",");
            if (results[0].equals(id))
            {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < results.length; j++)
                {
                    if (j != index)
                    {
                        sb.append(results[j]);
                        if (j != results.length - 1)
                        {
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

    public static void writeStudentMessage(String id, String message) throws IOException 
    {
        Path path = Paths.get(messagesFileName);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        
        for (int i = 0; i < lines.size(); i++)
        {
            String[] messages = lines.get(i).split(",");
            if (messages[0].equals(id))
            {
                lines.set(i,lines.get(i) + "," + message);
                break;
            }
        }
        Files.write(path, lines, StandardCharsets.UTF_8);
    }
    
    public static void addStudent(String fileName, String id)
    {
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



