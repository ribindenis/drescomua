import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestPage {

    private WebDriver driver;

    public RequestPage(WebDriver driver) {
        this.driver = driver;
    }

    private By mainHeadings = By.xpath("//h1[contains(text(),'ОФОРМЛЕНИЕ ЗАКАЗА')]");
    private By linkField = By.xpath("//input[@placeholder='https://www.amazon.com/gp/product/B01KITZKDE']");
    private By costField = By.xpath("//input[@placeholder='380$']");
    private By emailField = By.xpath("//input[@placeholder='380$']");
    private By phoneField = By.xpath("//input[@name='phone']");
    private By errorInvalidCreds = By.xpath("//span[contains(text(), 'color: red')]");
    private By checkButton = By.xpath("//div[@class='free_blog rig']//div[@class='free_check']//label[1]//span[1]");
    private By succesfulOrderText = By.xpath("//span[contains(text(), 'color: green')]");
    private By orderButton = By.xpath("//a[@class='order_btn']");

    public String getMainHeadings (){
        return driver.findElement(mainHeadings).getText();
    }

    public RequestPage typeLink (String link){
        driver.findElement(linkField).sendKeys(link);
        return this;
    }

    public RequestPage typeCost (String cost){
        driver.findElement(costField).sendKeys(cost);
        return this;
    }

    public RequestPage typeEmail (String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public RequestPage typePhoneNumber (String phone){
        driver.findElement(phoneField).sendKeys(phone);
        return this;
    }

    public String getErrorText (){
        return driver.findElement(errorInvalidCreds).getText();
    }


    public String getSuccesfulOrder (){
        return driver.findElement(succesfulOrderText).getText();
    }

    public RequestPage getOrder (String link, String cost, String email, String phone){
        this.typeLink(link);
        this.typeCost(cost);
        this.typeEmail(email);
        this.typePhoneNumber(phone);
        driver.findElement(checkButton).click();
        driver.findElement(orderButton).click();
        return new RequestPage(driver);
    }


}
