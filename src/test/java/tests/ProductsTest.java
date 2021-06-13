package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ProductsTest extends BaseTest{

    @Test(retryAnalyzer = Retry.class)
    public void productAddedToCartTest(){
        productSteps.loginAndAddProduct("standard_user", "secret_sauce", "Sauce Labs Backpack");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductName(), "Sauce Labs Backpack");
    }

    @Test(retryAnalyzer = Retry.class)
    public void RemoveButtonIsPresentOnProduct(){
        productSteps.loginAndAddProduct("standard_user", "secret_sauce", "Sauce Labs Backpack");
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed());
    }

    @Test
    public void RemoveButtonWorksFromProductsPage(){
        productSteps.loginAndAddProduct("standard_user", "secret_sauce", "Sauce Labs Bike Light");
        productsPage.removeSauceLabsBikeLight();
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed());
    }
}


