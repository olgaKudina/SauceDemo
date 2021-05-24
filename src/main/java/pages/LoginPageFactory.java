package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPageFactory extends BasePage {
    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@data-test='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id='bot_column-button']")
    WebElement botLogo;

    @FindBy(xpath = "//*[@data-test='error']")
    WebElement errorMessage;
    public void loginFactory(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
    public void openPage() {
        driver.get("https://www.saucedemo.com/");
    }
}
