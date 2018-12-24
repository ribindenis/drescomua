import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInButton = By.xpath("//li[@class='auth-block hide-in-mobile']//a[@title='Войти']");
    private By signInEmailField = By.xpath("//li[@class='auth-block hide-in-mobile']//div[@class='login-block']//input[@placeholder='Email']");
    private By signInPasswordField = By.xpath("//li[@class='auth-block hide-in-mobile']//div[@class='fly-form login yourshop-form']//input[@placeholder='Пароль']");
    private By buyButton = By.xpath("//div[@class='slick-slide slick-current slick-active']//div[@class='product-item not-mobile']//form[@class='addtocart']//div//input[@value='Купить']");
    private By buyToBasketButton = By.xpath("//div[@class='submit']//input[@value='Купить']");
    private By signUpButton = By.xpath("//li[@class='auth-block hide-in-mobile']//a[@title='Зарегистрироваться']");

    private By basketButton = By.xpath("//a[@title='Корзина']");

    private By basketMainButton = By.xpath("//i[@class='cart_icon']");

    private By requestButton = By.xpath("//a[contains(text(),'Заказать')]");

    private By callBackButton = By.xpath("//a[@class='call-back-button']");

    public LoginPage clickSignIn() {
        driver.findElement(signInButton).click();
        WebElement enterButton = driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//input[@value='Войти']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(enterButton).click().build().perform();
        return new LoginPage(driver);
    }

    public String getCallBackHeading(){
        MainPage mainPage = new MainPage(driver);
        mainPage.callBackButton();
        return driver.findElement(By.xpath("//p[contains(text(),'Здравствуйте!')]")).getText();
    }

    public SignUpPage clickSignUpLink() {
        driver.findElement(signInButton).click();
        WebElement registryLink = driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//div[@class='fly-form login yourshop-form']//div[@class='login-block']//div[@class='interactive']//div[@class='wa-form']//form//div[@class='wa-field']//div[@class='wa-submit']//div//a[@title='Регистрация'][contains(text(),'Регистрация')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(registryLink).click().build().perform();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUp(){
        driver.findElement(signUpButton).click();
        WebElement registryButton = driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//input[@value='Зарегистрироваться']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(registryButton).click().build().perform();
        return new SignUpPage(driver);
    }

    public BasketPage clickFullBasketMain() throws InterruptedException{
        driver.findElement(buyButton).click();
        driver.findElement(buyToBasketButton).click();
        Thread.sleep(1000);
        driver.findElement(basketMainButton).click();
        return new BasketPage(driver);
    }

    public BasketPage clickFullBasket() throws InterruptedException{
        driver.findElement(buyButton).click();
        driver.findElement(buyToBasketButton).click();
        Thread.sleep(1000);
        driver.findElement(basketButton).click();
        return new BasketPage(driver);
    }

    public BasketPage clickBasket() {
        driver.findElement(basketButton).click();
        return new BasketPage(driver);
    }

    public BasketPage clickBasketMain() {
        driver.findElement(basketMainButton).click();
        return new BasketPage(driver);
    }

    public RequestPage clickRequestButton() {
        driver.findElement(requestButton).click();
        return new RequestPage(driver);
    }

    public MainPage callBackButton() {
        driver.findElement(callBackButton).click();
        WebElement sendQuestion = driver.findElement(By.xpath("//a[@class='oc-btn oc-btn-accept']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(sendQuestion).click().build().perform();
        return this;
    }

    public LoginPage login(String email, String password) {
        driver.findElement(signInButton).click();
        driver.findElement(signInEmailField).sendKeys(email);
        driver.findElement(signInPasswordField).sendKeys(password);
        driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//input[@value='Войти']")).click();
        return new LoginPage(driver);
    }

    public MyOrdersPage loginWithValidCreds(String email, String password){
        driver.findElement(signInButton).click();
        driver.findElement(signInEmailField).sendKeys(email);
        driver.findElement(signInPasswordField).sendKeys(password);
        driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//input[@value='Войти']")).click();
        return new MyOrdersPage(driver);
    }

    public ForgotPassword forgetPassword(String email) {
        driver.findElement(signInButton).click();
        WebElement linkForgetPassword = driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//a[@class='f-forgotpasswd'][contains(text(),'Забыли пароль?')]"));
        linkForgetPassword.click();
        WebElement recoveryEmailField = driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//div[@class='forgotpasswd']//input[@placeholder='Email']"));
        recoveryEmailField.sendKeys(email);
        WebElement recoverPasswordButton = driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//input[@value='Сбросить пароль']"));
        recoverPasswordButton.click();
        return new ForgotPassword(driver);
    }

    public SignUpPage signUp(String userName, String userSurname, String email, String password, String confirmPassword, String captcha) throws InterruptedException {
        driver.findElement(signUpButton).click();
        WebElement signUpUserName = driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//input[@placeholder='Имя']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(signUpUserName).sendKeys(signUpUserName, userName).build().perform();
        WebElement signUpUserSurname = driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//input[@placeholder='Фамилия']"));
        actions.sendKeys(signUpUserSurname, userSurname).build().perform();
        WebElement signUpEmail = driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//div[@class='fly-form signup yourshop-form']//input[@placeholder='Email']"));
        actions.moveToElement(signUpEmail).sendKeys(signUpEmail, email).build().perform();
        WebElement signUpPassword = driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//div[@class='fly-form signup yourshop-form']//input[@placeholder='Пароль']"));
        actions.moveToElement(signUpPassword).sendKeys(signUpPassword, password).build().perform();
        WebElement signUpConfirmPassword = driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//input[@placeholder='Подтвердите пароль']"));
        actions.moveToElement(signUpConfirmPassword).sendKeys(signUpConfirmPassword, confirmPassword).build().perform();
        Thread.sleep(20000);
        WebElement signUpCaptcha = driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//input[@name='captcha']"));
        actions.moveToElement(signUpCaptcha).sendKeys(signUpCaptcha, captcha).build().perform();
        driver.findElement(By.xpath("//li[@class='auth-block hide-in-mobile']//input[@value='Зарегистрироваться']")).click();
        return new SignUpPage(driver);
    }

    public CheckOutSuccess quickBasketOrder(String userName, String phone, String email) throws InterruptedException{
        driver.findElement(buyButton).click();
        driver.findElement(buyToBasketButton).click();
        Thread.sleep(1000);
        WebElement basketButton = driver.findElement(By.xpath("//a[@title='Корзина']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(basketButton).build().perform();
        WebElement quickOrderButton = driver.findElement(By.xpath("//div[@title='Быстрая покупка']"));
        actions.moveToElement(quickOrderButton).click().build().perform();
        driver.findElement(By.xpath("//input[@name='quickorder_fields[firstname]']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='quickorder_fields[phone]']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@name='quickorder_fields[email]']")).sendKeys(email);
        driver.findElement(By.xpath("//div[contains(text(),'Отправить')]")).click();
        return new CheckOutSuccess(driver);
    }

    public BasketPage toBasketFromButton() throws InterruptedException{
        driver.findElement(buyButton).click();
        driver.findElement(buyToBasketButton).click();
        Thread.sleep(1000);
        WebElement basketButton = driver.findElement(By.xpath("//a[@title='Корзина']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(basketButton).build().perform();
        WebElement toBasketButton = driver.findElement(By.xpath("//a[@title='В корзину']"));
        actions.moveToElement(toBasketButton).click().build().perform();
        return new BasketPage(driver);
    }






}

