package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Laptop category
    @FindBy(linkText = "Laptops")
    WebElement laptopsCategory;

    // First laptop in list
    @FindBy(xpath = "//a[@class='hrefch']")
    WebElement firstLaptop;

    // Click on Laptops
    public void clickLaptops() {
        laptopsCategory.click();
    }

    // Select first laptop
    public void selectFirstLaptop() {
        firstLaptop.click();
    }
}
