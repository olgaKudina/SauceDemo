package tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import java.util.concurrent.TimeUnit;
public class ProductsTest extends BaseTest{
    @Test
    public void addProductToCartTest(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
    }
    @Test
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
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bike Light");
        productsPage.removeSauceLabsBikeLight();
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed());
    }
}


