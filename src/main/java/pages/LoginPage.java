package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage extends  BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");
    public static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    public static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");
    public static final By BOT_LOGO = By.xpath("//*[@id='bot_column-button']");
    public ProductsPage login(String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }
    public LoginPage openPage(){
        driver.get("https://www.saucedemo.com/");
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
