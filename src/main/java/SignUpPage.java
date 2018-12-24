import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {this.driver = driver;}
    private By mainHeading = By.xpath("//h1[contains(text(),'Регистрация')]");
    private By userNameField = By.xpath("//div[@role='main']//input[@title='Имя']");
    private By emailField = By.xpath("//div[@role='main']//input[@title='Email']");
    private By errorEmail = By.xpath("//em[contains(text(), 'Email')]");
    private By userPasswordField = By.xpath("//div[@role='main']//div[@class='wa-value']//input[@name='data[password]']");
    private By errorPassword = By.xpath("//em[contains(text(), 'Пароли не совпадают')]");
    private By userPasswordConfirmField = By.xpath("//div[@role='main']//div[@class='wa-value']//input[@name='data[password_confirm]']");
    private By captchaField = By.xpath("//div[@role='main']//input[@name='captcha']");
    private By errorCaptchaField = By.xpath("//em[contains(text(), 'Капча введена неверно')]");
    private By registryButton = By.xpath("//input[@value='Регистрация']");


    public SignUpPage typeUserName (String userName){
        driver.findElement(userNameField).clear();
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public SignUpPage typeuserEmail (String userEmail){
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(userEmail);
        return this;
    }

    public SignUpPage typeCaptcha (String captcha){
        driver.findElement(captchaField).clear();
        driver.findElement(captchaField).sendKeys(captcha);
        return this;
    }

    public SignUpPage typeuserPasswordConfirm (String userPasswordConfirm){
        driver.findElement(userPasswordConfirmField).clear();
        driver.findElement(userPasswordConfirmField).sendKeys(userPasswordConfirm);
        return this;
    }

    public SignUpPage errorSignUpWithInvalidCreds (String userEmail, String userPassword, String userPasswordConfirm, String captcha){
        this.typeuserEmail(userEmail);
        this.typeuserPassword(userPassword);
        this.typeuserPasswordConfirm(userPasswordConfirm);
        this.typeCaptcha(captcha);
        driver.findElement(registryButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage typeuserPassword (String userPassword){
        driver.findElement(userPasswordField).clear();
        driver.findElement(userPasswordField).sendKeys(userPassword);
        return this;
    }

    public String getHeadingText(){
        return driver.findElement(mainHeading).getText();
    }
    public String getErrorEmailHeading(){
        return driver.findElement(errorEmail).getText();
    }
    public String getErrorPasswordConfirm(){
        return driver.findElement(errorPassword).getText();
    }
    public String getErrorCaptcha(){
        return driver.findElement(errorCaptchaField).getText();
    }

    public LoginPage enterLoginPage(){
        driver.findElement(By.xpath("//a[contains(text(),'войдите')]")).click();
        return new LoginPage(driver);
    }






}
