import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ribindenis\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://thedres.com.ua/");


    }

}
