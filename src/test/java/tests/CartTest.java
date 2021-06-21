package tests;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
@Log4j2
public class CartTest extends BaseTest {

    @Test
    public void getProductPriceInCartTest2(){    //failed test
        productSteps.loginAndAddProduct("standard_user", "secret_sauce", "Sauce Labs Backpack");
        log.info("Log Open page URL and Add product");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"), "$29.99");
    }

    @Test(retryAnalyzer = Retry.class)
    public void quantityInCartTest() {
        cartSteps.loginAddProductOpenCartPage("standard_user", "secret_sauce", "Sauce Labs Bolt T-Shirt");
        //log.info(String.format("Fill in Product name:'%s'", productName));
        Assert.assertEquals(cartPage.getProductQuantity("Sauce Labs Bolt T-Shirt"), "1");
    }

    @Test
    public void getProductPriceInCartTest() {
        cartSteps.loginAddProductOpenCartPage("standard_user", "secret_sauce", "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }
}
