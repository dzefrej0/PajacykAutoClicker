package pajacyk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    
    public static void main(String[] args) throws InterruptedException {

        PajacykMain pajacykMain = new PajacykMain();

        pajacykMain.makeAClickOnPajacyk();
        Thread.sleep(3000);
        pajacykMain.getCountOfClicks();
        Thread.sleep(3000);
        pajacykMain.closeConnection();
    }
}