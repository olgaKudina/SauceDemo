package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class LoginTest extends BaseTest{
    @FindBy(xpath = "//button[contains(.,'Add')]")
    WebElement addButton;

    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deleteButton;
    @Test
    public void errorLoginTest (){
        loginPage.openPage();
        loginPage.login("standard_user", "null");
        Assert.assertTrue(loginPage.loginErrorDisplayed());
    }
    @Test
    public void loginFactoryTest(){
        loginPageFactory.openPage();
        //loginPageFactory.loginFactory("standard_user", "secret_sauce");
        //loginPageFactory.loginFactory(System.getenv("username"), System.getenv("password"));
        loginPageFactory.loginFactory(System.getenv().getOrDefault("username", PropertyReader.getProperty("username")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));

    }

    @Test
    public void demoWithPageFactory() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButtonElement = addButton;
        addButtonElement.click();
        WebElement deleteButtonElement = deleteButton;
        deleteButtonElement.click();
        addButtonElement.click();
        deleteButtonElement.click();
    }
}

