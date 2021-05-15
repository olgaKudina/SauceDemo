package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import static pages.LoginPage.ERROR_MESSAGE;
public class LoginTest extends BaseTest{
    @Test
    public void errorLoginTest (){
        loginPage.openPage();
        loginPage.login("standard_user", "null");
        Assert.assertTrue(loginPage.loginErrorDisplayed());
    }
}
