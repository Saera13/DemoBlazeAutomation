package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopPage {

	 WebDriver driver;

	    @FindBy(xpath = "//a[@class='hrefch']")
	    WebElement firstLaptop;

	    @FindBy(xpath = "//h2[@class='name']")
	    WebElement laptopName;

	    @FindBy(xpath = "//h3[@class='price-container']")
	    WebElement laptopPrice;

	    @FindBy(xpath = "//a[text()='Add to cart']")
	    WebElement addToCartBtn;

	    public LaptopPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void selectFirstLaptop() {
	        firstLaptop.click();
	    }

	    public String getLaptopName() {
	        return laptopName.getText();
	    }

	    public String getLaptopPrice() {
	        return laptopPrice.getText().replaceAll("[^0-9]", "");
	    }

	    public void addToCart() {
	        addToCartBtn.click();
	    }
}
