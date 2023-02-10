import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;


public class Main {

    WebDriver driver;


    public void launchWebsite(){
        System.setProperty("Webdriver.chrome.driver","/Users/ppshetty/Downloads/chromedriver_mac64/chromedriver");
        driver =new ChromeDriver();
        driver.get("https://www.makemytrip.com/");

    }

    public void screenshots() throws IOException {
        //taking screenshots
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File("/Users/ppshetty/Desktop/ss.png");
        FileHandler.copy(src,trg);

    }

    public void elementSs() throws IOException {
        WebElement ele = driver.findElement(By.xpath("//img[@alt='Make My Trip']"));
        File src=ele.getScreenshotAs(OutputType.FILE);
        File trg=new File("/Users/ppshetty/Desktop/logo.png");
        FileHandler.copy(src,trg);
    }

    public void test(){
        //ticks the roundtrip button
        WebElement radioBtn = driver.findElement(By.xpath("//li[@data-cy='roundTrip']"));
        radioBtn.click();

    }


    public static void main(String[] args) throws IOException {
        Main obj1 =new Main();
        obj1.launchWebsite();
        obj1.test();
        obj1.screenshots();
        obj1.elementSs();

    }
}