import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Visitor {

    private static String fullName;
    private static int age;
    private static String comment;
    private static String assistantName;

    private static final Logger logger = LogManager.getLogger(Visitor.class.getName());

    public static boolean save(String fullName, int age, String comment, String assistantName) throws IOException {
        try{
            File myObj = new File("visitor_"+fullName.replace(" ","_")+".txt");

            if(myObj.createNewFile()){
                logger.info("File has been created"+ myObj.getName());
            }
            else{
                logger.error("File already exist");

            }

            FileWriter FW = new FileWriter(myObj);

            FW.write(
                    "full name: "+fullName
                            + "\n"+"age: "+age
                            + "\n" +"comments: "+ comment
                            +"\n"+"assistanceName: "+ assistantName
                            + "\n" +"Time: "+ LocalTime.now()
                            + "\n"+ "Date: "+ LocalDate.now());
            FW.close();


        }

        catch (IOException e) {
            logger.error("An error occurred");
            e.printStackTrace();
        }
        return true;
    }
    public static String load(String fullName) throws FileNotFoundException {

        try{
            File visitorFile = new File("visitor_ " +
                    fullName.replace(" ", "_")+".txt");
            Scanner reader = new Scanner(visitorFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            logger.error("File not Found");
            e.getStackTrace();

        }
        return fullName;
    }
    public static void main(String[] args) throws IOException{
        String read = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter fullName");
        fullName = sc.nextLine();
        System.out.println("Age");
        age = sc.nextInt();
        System.out.println("comment");
        comment = sc.next();
        System.out.println("assistantName");
        assistantName = sc.next();
        save(fullName,age,comment,assistantName);
//        load(fullName);
    }
}


