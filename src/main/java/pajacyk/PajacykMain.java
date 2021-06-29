package pajacyk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class PajacykMain {



    WebDriver driver = new ChromeDriver();
    private File fileToSaveData;

    PajacykMain(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.navigate().to("https://www.pajacyk.pl");
    }

    private String getUserInputFromPrompt (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write down ur name plz- ");
        String a= scanner.next();
        System.out.println("ur name is : " + a);
        return a;
    }

    private void saveUserNameToFile (String StringToSave) throws IOException {

        try (FileWriter fileWriter = new FileWriter("test.txt")) {
            fileWriter.write(StringToSave);
        }
    }

    private void checkIfFileExistAndIfNoMakeOne () throws IOException {
        fileToSaveData = new File("test.txt");
        boolean fileExists = fileToSaveData.exists();
        System.out.println("attempt to make a file");
        if(!fileExists){
            FileWriter fileWriter = new FileWriter("test.txt");
            System.out.println("there was no file but now its made");
        }else{
            System.out.println("there is file already");
        }
    }

    private void makeAClickOnPajacyk (){
        driver.findElement(By.xpath("/html/body/div[2]/section/div[5]")).click();
    }

    private void closeConnection (){
        driver.close();
    }

    private void getCountOfClicks (){

        String a = driver.findElement(By.xpath("//html/body/div[2]/section/div[6]/div[1]")).getText();
        System.out.println(a);
    }

    private LocalDateTime getTimeDateNow (){
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime;
    }

    private static void readFileContents() throws IOException {
        System.out.println("Reading contents of file using Scanner class:");
        try (FileReader fileReader = new FileReader("test.txt");
             Scanner scanner=new Scanner(fileReader)){
            while (scanner.hasNext()) {
                System.out.println("zawartość pliku :  " + scanner.next());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        PajacykMain pajacykMain = new PajacykMain();
        pajacykMain.checkIfFileExistAndIfNoMakeOne();
        pajacykMain.saveUserNameToFile(pajacykMain.getUserInputFromPrompt());
        pajacykMain.readFileContents();
        for (int i = 0; i < 10000; i++) {
            System.out.println("ilość naszych kliknięć:     "+ i );
            System.out.println("czas kliknięcia  : " + pajacykMain.getTimeDateNow());
            pajacykMain.makeAClickOnPajacyk();
            Thread.sleep(2000);
            pajacykMain.getCountOfClicks();
            Thread.sleep(10000);
        }
        pajacykMain.closeConnection();
    }
}
