import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BasketPage {
    private WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }


    private By titleMain = By.xpath("//h1[contains(text(),'Корзина')]");
    private By checkToDelete = By.xpath("//a[@title='Удалить из корзины']");
    private By quickOrderButton = By.xpath("//div[@class='float-right']//i[contains(text(),'Быстрая покупка')]");
    private By toProductsCategory = By.xpath("//a[@title='Продолжить покупки']");
    private By emptyBasketText = By.xpath("//p[contains(text(),'Ваша корзина пуста.')]");

    public String getMainTitle (){
        return driver.findElement(titleMain).getText();
    }
    public String getMainFullBasket(){
        return  driver.findElement(By.xpath("//div[@class='align-center cart-cell quantity']")).getText();
    }


    public BasketPage deleteProducts (){
        List<WebElement> checkProducts = driver.findElements(checkToDelete);
        for(WebElement checkProduct: checkProducts){
            checkProduct.click();
        }
        driver.switchTo().alert().accept();
        return this;
    }
    public String getEmptyBasketText(){
        return driver.findElement(emptyBasketText).getText();
    }

    public CheckOutSuccess orderConfirm (String userName, String phone, String email){
        driver.findElement(quickOrderButton).click();
        Actions actions = new Actions(driver);
        WebElement firstName = driver.findElement(By.xpath("//input[@name='quickorder_fields[firstname]']"));
        actions.moveToElement(firstName).sendKeys(userName);
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='quickorder_fields[phone]']"));
        actions.moveToElement(phoneNumber).sendKeys(phone);
        WebElement emaiField = driver.findElement(By.xpath("//input[@name='quickorder_fields[email]']"));
        actions.moveToElement(emaiField).sendKeys(email);
        WebElement sendOrder = driver.findElement(By.xpath("//div[contains(text(),'Отправить')]"));
        actions.moveToElement(sendOrder).click();
        return new CheckOutSuccess(driver);
    }
}
