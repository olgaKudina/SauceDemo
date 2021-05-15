package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CartPage extends HeaderPage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void openPage() {
        driver.get("https://www.saucedemo.com/cart.html");
    }
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    private static final String PRODUCT_QUANTUTY = PRODUCT_ITEM + "//*[@class=\"cart_quantity\"]";
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }
    public String getProductQuantity(String productName){
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTUTY, productName))).getText();
    }
 }


