package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static pages.LoginPage.ERROR;
public class LoginTest extends BaseTest{
    @Test
    public void ErrorLoginTest (){
        loginPage.openPage();
        loginPage.login("standard_user", "null");
        boolean IsErrorTextDisplayed = driver.findElement(By.xpath("//*[@data-test='error']")).isDisplayed();
        Assert.assertTrue(IsErrorTextDisplayed);
    }
}
