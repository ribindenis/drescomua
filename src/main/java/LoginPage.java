import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By loginField = By.xpath("//div[@role='main']//input[@name='login']");
    private By loginPasswordField = By.xpath("//div[@role='main']//input[@name='password']");
    private By signInButton = By.xpath("//div[@class='wa-value wa-submit']//input[@value='Войти']");
    private By heading = By.xpath("//h1[contains(text(),'Вход')]");
    private By error = By.xpath("//em[@class='wa-error-msg']");
    private By createAccLink = By.xpath("//form[@method='post']//div[2]//div[2]");
    private By forgotPasswordLink = By.xpath("//div[@class='content']//form[@method='post']//div[1]//div[1]");


    public LoginPage typeUserName(String email){
        driver.findElement(loginField).clear();
        driver.findElement(loginField).sendKeys(email);
        return this;
    }
    public LoginPage typePassword(String password){
        driver.findElement(loginPasswordField).clear();
        driver.findElement(loginPasswordField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithInvalidCreds(String email, String password){
        this.typeUserName(email);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadings(){
        return driver.findElement(heading).getText();
    }
    public String getErrorText(){
        return driver.findElement(error).getText();
    }

    public ForgotPassword forgotPassword(){
        driver.findElement(forgotPasswordLink).click();
        return new ForgotPassword(driver);
    }

    public SignUpPage createAccaunt(){
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }


}
