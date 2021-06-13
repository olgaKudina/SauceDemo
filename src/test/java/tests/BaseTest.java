package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CartPage;
import pages.LoginPage;
import pages.LoginPageFactory;
import pages.ProductsPage;
import steps.CartSteps;
import steps.ProductSteps;
import java.util.concurrent.TimeUnit;

    @Listeners(TestListener.class)
    public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    LoginPageFactory loginPageFactory;
    ProductSteps productSteps;
    CartSteps cartSteps;

    @BeforeMethod
    public void initTest(ITestContext context){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
        PageFactory.initElements(driver,this);
        productSteps = new ProductSteps(driver);
        cartSteps = new CartSteps(driver);

        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);

    }
    @AfterMethod
    public void endTest(){
        driver.quit();
    }
}
