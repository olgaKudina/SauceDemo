package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CartTest extends BaseTest {

    @Test
    public void getProductPriceInCartTest2(){    //failed test
        productSteps.loginAndAddProduct("standard_user", "secret_sauce", "Sauce Labs Backpack");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"), "$29.99");
    }

    @Test(retryAnalyzer = Retry.class)
    public void quantityInCartTest() {
        cartSteps.loginAddProductOpenCartPage("standard_user", "secret_sauce", "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(cartPage.getProductQuantity("Sauce Labs Bolt T-Shirt"), "1");
    }

    @Test
    public void getProductPriceInCartTest() {
        cartSteps.loginAddProductOpenCartPage("standard_user", "secret_sauce", "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }
}
