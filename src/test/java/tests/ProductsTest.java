package tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest{
    @Test
    public void addProductToCartTest(){
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
    }

}


