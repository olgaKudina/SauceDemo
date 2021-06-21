package pages;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
@Log4j2
public class LoginPage extends  BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");
    public static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    public static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");
    public static final By BOT_LOGO = By.xpath("//*[@id='bot_column-button']");
    String SAUCEDEMO_URL = "https://www.saucedemo.com/";

    @Step("Fill in {username} and {password} in Login field")
    public ProductsPage login(String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        log.info("Log Login and redirect to Products Page");
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Step("Opening Login page")
    public LoginPage openPage(){
        driver.get(SAUCEDEMO_URL);
        return this;
    }

    public boolean loginErrorDisplayed(){
        boolean isErrorTextDisplayed = driver.findElement(ERROR_MESSAGE).isDisplayed();
        return true;
    }

    public void waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(BOT_LOGO));
    }
}
