import java.util.ArrayList;
import java.io.*;

public class CSVReader {
    private static String messagesFileName = "messages.csv";

    public static void setMessagesFileName(String fileName) {
        messagesFileName = fileName;
    }

    /**
     * CSVFile layout example
     *
     * 0,NG
     * 1,F
     * 30,D2
     * 35,D1
     * 40,C3
     * 48,C2
     * 52,C1
     * 56,B3
     * 60,B2
     * 64,B1
     * 72,A2
     * 80,A1
     * 
     */
    public static void readGradingScheme(String fileName, int[] bounds, String[] grades) throws IOException {
        String line = "";
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] gradeScheme = line.split(splitBy);

                bounds[i] = Integer.parseInt(gradeScheme[0]);
                grades[i] = gradeScheme[1];

                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * CSVFile layout example
     *
     * student1Id,result1,result2,result3
     * student2Id,result1,result2,result3
     * student3Id,result1,result2,result3
     * student4Id,result1,result2,result3
     * 
     */
    public static ArrayList<String> readClassRole(String fileName) {
        ArrayList<String> classRole = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            String splitBy = ",";
            while ((line = br.readLine()) != null) {
                String[] roleData = line.split(splitBy);
                String id = roleData[0];

                String s = id;

                classRole.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classRole;
    }

    /**
     * CSVFile layout example
     *
     * student1Id,result1,result2,result3
     * student2Id,result1,result2,result3
     * student3Id,result1,result2,result3
     * student4Id,result1,result2,result3
     * 
     */
    public static ArrayList<Double> readStudentResult(String fileName, String id) {
        ArrayList<Double> stuResults = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            String splitBy = ",";

            while ((line = br.readLine()) != null) {
                String[] results = line.split(splitBy);
                String resultId = results[0];

                if (resultId.equals(id)) {
                    for (int i = 1; i < results.length; i++) {
                        stuResults.add(Double.valueOf(results[i]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stuResults;
    }

    /**
     * CSVFile layout example
     *
     * student1Id,message1,message2,message3
     * student2Id,message1,message2,message3
     * student3Id,message1,message2,message3
     * student4Id,message1,message2,message3
     * 
     */
    public static ArrayList<String> readStudentMessages(String id) {
        ArrayList<String> messages = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(messagesFileName))) {
            String line = "";
            String inbox = "";

            while ((line = br.readLine()) != null) {
                String[] messageData = line.split(",");
                String messageId = messageData[0];

                if (messageId.equals(id)) {
                    for (int i = 1; i < messageData.length; i++) {
                        messages.add(messageData[i]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return messages;
    }

    /**
     * CSVFile layout example
     *
     * student1Id,student1Name
     * student2Id,student2Name
     * student3Id,student3Name
     * student4Id,student4Name
     * 
     */
    public static ArrayList<String> initStudentId(String fileName) {
        ArrayList<String> idList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            String splitBy = ",";
            while ((line = br.readLine()) != null) {
                String[] roleData = line.split(splitBy);
                String id = roleData[0];

                String s = id;

                idList.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return idList;
    }
}
