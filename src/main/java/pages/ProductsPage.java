package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ProductsPage extends HeaderPage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public static final String ADD_TO_CART_BOTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";

    @Step("Add product: {productName} to Cart")
    public ProductsPage addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BOTTON, productName))).click();
        return this;
    }

    @Step ("Add to Cart Sauce backpack")
    public void addToCartSauseLabsBackpack(){
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }

    @Step("Is Remove Button displayed")
    public boolean isRemoveButtonDisplayed(){
        if (driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).isDisplayed());
        return true;
    }

    @Step ("Remove Sauce Labs Bike Light")
    public void removeSauceLabsBikeLight(){
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bike-light\"]")).click();
    }

    @Step("Check if Add To Cart Button is Displayed")
    public boolean isAddToCartButtonDisplayed () {
        if (driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).isDisplayed());
        return true;
    }
}
