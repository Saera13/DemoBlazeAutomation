package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	

    WebDriver driver;

    @FindBy(xpath = "//h3[@class='price-container']")
    WebElement price;

    @FindBy(linkText = "Add to cart")
    WebElement addToCartBtn;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        return price.getText().replaceAll("[^0-9]", "");
    }

    public void addToCart() {
        addToCartBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

}
