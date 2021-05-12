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
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        boolean IsRemoveButtonDisplayed = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).isDisplayed();
        Assert.assertTrue(IsRemoveButtonDisplayed);
    }
    @Test
    public void RemoveButtonWorksFromProductsPage(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bike Light");
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bike-light\"]")).click();
        boolean IsAddToCartButtonDisplayed = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).isDisplayed();
        Assert.assertTrue(IsAddToCartButtonDisplayed);
    }
}


