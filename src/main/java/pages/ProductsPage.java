package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ProductsPage extends HeaderPage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public static final String ADD_TO_CART_BOTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    public void addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BOTTON, productName))).click();
    }
}
