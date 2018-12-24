import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyOrdersPage {
    private WebDriver driver;

    public MyOrdersPage(WebDriver driver) {
        this.driver = driver;
    }
    private By myOrders = By.xpath("//h1[contains(text(),'Мои заказы')]");

    public String getHeading(){
        return driver.findElement(myOrders).getText();
    }
}


