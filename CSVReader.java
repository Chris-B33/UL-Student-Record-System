import java.util.ArrayList;
import java.io.*;

public class CSVReader
{
    private static String messagesFileName;// = path to file must have done for message system to work.
    
    public static void readGradingScheme(String fileName, int[] bounds, String[] grades) throws IOException
    {
        String line = "";
        String splitBy = ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            int i = 0;
            while ((line = br.readLine()) != null)
            {
                String[] gradeScheme = line.split(splitBy);
                
                bounds[i] = Integer.parseInt(gradeScheme[0]);
                grades[i] = gradeScheme[1];
                
                i++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Student> readClassRole(String fileName)
    {
        ArrayList<Student> classRole = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line = "";
            String splitBy = ",";
            while ((line = br.readLine()) != null)
            {
                String[] roleData = line.split(splitBy);
                String id = roleData[0];
                
                Student s = new Student(id);
                
                classRole.add(s);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        return classRole;
    }
    
    public static ArrayList<String> readStudentMessages(String id)
    {
        ArrayList<String> messages = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(messagesFileName)))
        {
            String line = "";
            String inbox = "";
            
            while ((line = br.readLine()) != null)
            {
                String[] messageData = line.split(",");
                String messageId = messageData[0];
                
                if (messageId.equals(id))
                {
                    for (int i = 1; i < messageData.length; i++)
                    {
                        messages.add(messageData[i]);
                    }
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return messages;
    }
}
