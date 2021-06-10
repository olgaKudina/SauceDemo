package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;

public class CartSteps {
    private CartPage cartPage;
    private LoginPage loginPage;

    public CartSteps(WebDriver driver) {
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
    }
    @Step("Login, add product and open CartPage")
    public CartSteps loginAddProductOpenCartPage (String username, String password, String productName) {
        loginPage
                .openPage()
                .login(System.getProperty("username", username), System.getProperty("password", password))
                .addProductToCart(productName);
        cartPage.openPage();
        return this;
    }
}
