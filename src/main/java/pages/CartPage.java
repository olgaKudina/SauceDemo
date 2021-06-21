package pages;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class CartPage extends HeaderPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    String CART_URL = "https://www.saucedemo.com/cart.html";
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class='cart_quantity']";
    private static final String PRODUCT_NAME = "//*[@class='inventory_item_name']";

    @Step("Open Cart page")
    public void openPage() {
        driver.get(CART_URL);
    }

    @Step("Get Product {productName} price")
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    @Step("Get Product {productName} quantity")
    public String getProductQuantity(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY, productName))).getText();
    }

    @Step ("Get Product name")
    public String getProductName(){
        return driver.findElement(By.xpath(PRODUCT_NAME)).getText();
    }

}


