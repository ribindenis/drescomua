import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutSuccess {
    private WebDriver driver;

    public CheckOutSuccess(WebDriver driver) {
        this.driver = driver;
    }

    private By succesfulOrderText = By.xpath("//h1[contains(text(),'Спасибо!')]");
    private By backToShopButton = By.xpath("//a[@title='Вернуться в магазин']");

    public String getSuccesfulText(){
        return driver.findElement(succesfulOrderText).getText();
    }
}
