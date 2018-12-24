import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
    private WebDriver driver;

    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//input[@name='login']");
    private By heading = By.xpath("//h1[contains(text(),'Восстановление пароля')]");
    private By rememberPassword = By.xpath("//a[contains(text(),'Я вспомнил пароль!')]");
    private By error = By.xpath("//em[@class='wa-error-msg']");
    private By resetPasswordButton = By.xpath("//div[@class='wa-value wa-submit']//input[@value='Сбросить пароль']");

    public ForgotPassword typeLogin (String email){
        driver.findElement(loginField).clear();
        driver.findElement(loginField).sendKeys(email);
        return this;
    }

    public String getHeading(){
        return driver.findElement(heading).getText();
    }
    public String getErrorText(){
        return driver.findElement(error).getText();
    }

    public ForgotPassword resetWithInvalidCreds(String email){
        this.typeLogin(email);
        driver.findElement(resetPasswordButton).click();
        return new ForgotPassword(driver);
    }

    public LoginPage rememberPassword(){
        driver.findElement(rememberPassword).click();
        return new LoginPage(driver);
    }
}
