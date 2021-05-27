package tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import java.util.concurrent.TimeUnit;
public class ProductsTest extends BaseTest{

    @Test(retryAnalyzer = Retry.class)
    public void addProductToCartTest(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
    }
    @Test(retryAnalyzer = Retry.class)
    public void RemoveButtonOnProduct(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        //productsPage.addToCartSauseLabsBackpack();
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed());
    }
    @Test
    public void RemoveButtonWorksFromProductsPage(){
        loginPage.openPage();
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
        productsPage.addProductToCart("Sauce Labs Bike Light");
        productsPage.removeSauceLabsBikeLight();
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed());
    }
}


