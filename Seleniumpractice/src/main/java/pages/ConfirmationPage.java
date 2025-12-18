package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    WebDriver driver;

    @FindBy(xpath = "//p[contains(text(),'Id')]")
    WebElement orderDetails;

    @FindBy(xpath = "//h3[@id='totalm']")
    WebElement totalAmount;

    @FindBy(xpath = "//button[text()='OK']")
    WebElement okBtn;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getOrderId() {
        String text = orderDetails.getText(); // e.g., "Id: 12345"
        return text.split(":")[1].trim();
    }

    public String getTotalAmount() {
        return totalAmount.getText().replaceAll("[^0-9]", "");
    }

    public void clickOK() {
        okBtn.click();
    }
}

