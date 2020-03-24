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

    public static void save(String fullName, int age, String comment, String assistantName) throws IOException {
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
    }
    public static void load(String read) throws FileNotFoundException {
        File myObj = new File("filename.txt");

        try {
            Scanner  myOb = new Scanner(myObj);


        while (myObj.createNewFile()) {
            String data = myOb.nextLine();
            System.out.println(data);
        }
            myOb.close();
        } catch (FileNotFoundException e) {
            logger.error("An error occurred.");
            e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        System.out.print("please enter fullName");
         fullName = sc.nextLine();

         System.out.print("Age");
         age = sc.nextInt();

        System.out.print("comment");
        comment = sc.nextLine();

        System.out.print("assistantName");
        assistantName = sc.nextLine();
    }
    }


