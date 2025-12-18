package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    @FindBy(xpath = "//tr[@class='success']/td[2]")
    WebElement cartItemName;

    @FindBy(id = "totalp")
    WebElement totalPrice;

    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement placeOrderBtn;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCartItemName() {
        return cartItemName.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void clickPlaceOrder() {
        placeOrderBtn.click();
    }
}
