import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ribindenis\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://thedres.com.ua/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest(){
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadings();
        Assert.assertEquals("ВХОД", heading);
    }

    @Test
    public void signUpFromSignInTest(){
        SignUpPage signUpPage = mainPage.clickSignUpLink();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("РЕГИСТРАЦИЯ", heading);
    }

    @Test
    public void signUpTest(){
        SignUpPage signUpPage = mainPage.clickSignUp();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("РЕГИСТРАЦИЯ", heading);
    }

    @Test
    public void loginWithInvalidCredsTest(){
        LoginPage loginPage = mainPage.login("useremail@gmail.com","qwerty");
        String error = loginPage.getErrorText();
        Assert.assertEquals("Неправильный email или пароль", error);
    }

    @Test
    public void loginWithValidCredsTest(){
        MyOrdersPage myOrdersPage = mainPage.loginWithValidCreds("admin", "nbvjatq2010");
        String succes = myOrdersPage.getHeading();
        Assert.assertEquals("МОИ ЗАКАЗЫ",succes);
    }

    @Test
    public void forgetPasswordInvalidPasswordTest(){
        ForgotPassword forgotPassword = mainPage.forgetPassword("email@email.com");
        String error = forgotPassword.getErrorText();
        Assert.assertEquals("Пользователь с таким email адресом не найден.", error);
    }

    @Test
    public void signUpInvalidCaptchaTest() throws InterruptedException {
        SignUpPage signUpPage = mainPage.signUp("Denis","Rybin","email@email","qwerty","qwerty","erer");
        String error = signUpPage.getErrorCaptcha();
        Assert.assertEquals("Капча введена неверно", error);
    }

    @Test
    public void signUpInvalidEmailTest() throws InterruptedException{
        SignUpPage signUpPage = mainPage.signUp("Denis","Rybin","email","qwerty","qwerty","");
        String error = signUpPage.getErrorEmailHeading();
        Assert.assertEquals("Email-адрес введен неправильно", error);
    }

    @Test
    public void signUpInvalidConfirmPasswordTest() throws InterruptedException{
        SignUpPage signUpPage = mainPage.signUp("Denis", "Rybin","email@gmail.com","qwerty","qwerty1","");
        String error = signUpPage.getErrorPasswordConfirm();
        Assert.assertEquals("Пароли не совпадают",error);
    }

    @Test
    public void emptyBasketMainTest(){
        BasketPage basketPage = mainPage.clickBasketMain();
        String emptybasket = basketPage.getEmptyBasketText();
        Assert.assertEquals("Ваша корзина пуста.",emptybasket);
    }

    @Test
    public void fullBasketMainTest() throws InterruptedException{
        BasketPage basketPage = mainPage.clickFullBasketMain();
        Object fullBasket = basketPage.getMainFullBasket();
        Assert.assertEquals("Кол-во:", fullBasket);
    }
    @Test
    public void clickEmptyBasketTest(){
        BasketPage basketPage = mainPage.clickBasket();
        String emptybasket = basketPage.getEmptyBasketText();
        Assert.assertNotEquals("Ваша корзина пуста", emptybasket);
    }
    @Test
    public void clickFullBasketTest() throws InterruptedException{
        BasketPage basketPage = mainPage.clickFullBasket();
        Object fullBasket = basketPage.getMainFullBasket();
        Assert.assertEquals("Кол-во:",fullBasket);
    }
    @Test
    public void clickRequestButtonTest(){
        RequestPage requestPage = mainPage.clickRequestButton();
        String heading = requestPage.getMainHeadings();
        Assert.assertEquals("ОФОРМЛЕНИЕ ЗАКАЗА", heading);
    }
    @Test
    public void clickCallBackButtonTest(){
        String heading = mainPage.getCallBackHeading();
        Assert.assertEquals("Здравствуйте!",heading);
    }
    @Test
    public void checkOutQuickOrderTest() throws InterruptedException {
        CheckOutSuccess checkOutSuccess = mainPage.quickBasketOrder("Denis", "0661753307", "test@test.com");
        String heading = checkOutSuccess.getSuccesfulText();
        Assert.assertEquals("СПАСИБО!",heading);
    }
    @Test
    public void toBusketFromFly()throws InterruptedException{
        BasketPage basketPage = mainPage.toBasketFromButton();
        String fullBasket = basketPage.getMainFullBasket();
        Assert.assertEquals("Кол-во:", fullBasket);
    }









}
