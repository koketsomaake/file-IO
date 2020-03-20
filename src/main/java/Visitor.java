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

    public static void save(String fullName, int age, String comments, String assistantName) throws IOException {
        try{
        File myObj = new File("visitor_"+fullName.replace(" ","_")+".txt");

        FileWriter FW = new FileWriter(myObj);

        FW.write(
                "full name: "+fullName
                + "\n"+"age: "+age
                + "\n" +"comments: "+ comments
                +"\n"+"assistanceName: "+ assistantName
                + "\n" +"Time: "+ LocalTime.now()
                + "\n"+ "Date: "+ LocalDate.now());
        FW.close();

            if(myObj.createNewFile()){
                logger.info("File has been created"+ myObj.getName());
            }
                else{
                System.out.println("File already exist");
            }
            }

        catch (IOException e) {
            logger.error("An error occurred");
            e.printStackTrace();
        }
    }
    public static void load(String read) throws FileNotFoundException {
        File myObj = new File("filename.txt");
//        Scanner myReader = null;
        try {
            Scanner  myReader = new Scanner(myObj);


        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
            myReader.close();
        } catch (FileNotFoundException e) {
            logger.error("An error occurred.");
            e.getMessage();
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter fullName");
         fullName = sc.nextLine();
        System.out.println("please enter age");
        age = sc.nextInt();
        System.out.println("comment");
        comment = sc.nextLine();
        System.out.println("Assistant name");
        assistantName = sc.nextLine();

        System.out.println();
        }
    }


