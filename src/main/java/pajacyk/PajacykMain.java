package pajacyk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PajacykMain {

    WebDriver driver = new ChromeDriver();

    PajacykMain(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.navigate().to("https://www.pajacyk.pl");
    }

    public void makeAClickOnPajacyk (){
        driver.findElement(By.xpath("/html/body/div[2]/section/div[5]")).click();
    }

    public void closeConnection (){
        driver.close();
    }

    public void getCountOfClicks (){

        String a = driver.findElement(By.xpath("//html/body/div[2]/section/div[6]/div[1]")).getText();
        System.out.println(a);
    }

    public LocalDateTime getTimeDateNow (){
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime;
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        PajacykMain pajacykMain = new PajacykMain();
        for (int i = 0; i < 10000; i++) {

            System.out.println("ilość naszych kliknięć:     "+ i );
            System.out.println("czas kliknięcia  : " + pajacykMain.getTimeDateNow());
            pajacykMain.makeAClickOnPajacyk();
            Thread.sleep(1000);
            pajacykMain.getCountOfClicks();
            Thread.sleep(10000);
        }

        pajacykMain.closeConnection();
    }
}