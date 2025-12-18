package tests;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;
import utils.CSVUtils;
import utils.ScreenshotUtils;

public class PurchaseTest extends BaseTest {

    @Test
    public void purchaseMultipleOrdersFromCSV() throws InterruptedException {

        // Read CSV file
        String path = "src/test/resources/testdata.csv";
        List<HashMap<String, String>> testData = CSVUtils.readCSV(path);

        for (HashMap<String, String> row : testData) {

            test = extent.createTest("Order for: " + row.get("name"));

            try {
                HomePage home = new HomePage(driver);
                home.clickLaptops();
                Thread.sleep(2000);

                LaptopPage laptop = new LaptopPage(driver);
                laptop.selectFirstLaptop();
                Thread.sleep(2000);

                String laptopName = laptop.getLaptopName();
                String laptopPrice = laptop.getLaptopPrice();

                laptop.addToCart();
                Thread.sleep(2000);
                driver.switchTo().alert().accept();

                driver.get("https://www.demoblaze.com/cart.html");
                Thread.sleep(2000);

                CartPage cart = new CartPage(driver);
                Assert.assertEquals(cart.getCartItemName(), laptopName);
                Assert.assertEquals(cart.getTotalPrice(), laptopPrice);
                cart.clickPlaceOrder();
                Thread.sleep(2000);

                OrderPage order = new OrderPage(driver);
                order.fillForm(
                    row.get("name"),
                    row.get("country"),
                    row.get("city"),
                    row.get("card"),
                    row.get("month"),
                    row.get("year")
                );
                order.clickPurchase();
                Thread.sleep(2000);

                ConfirmationPage confirm = new ConfirmationPage(driver);
                String orderId = confirm.getOrderId();
                String totalAmount = confirm.getTotalAmount();

                test.info("Order ID: " + orderId + ", Total Amount: " + totalAmount);
                String screenshotPath = ScreenshotUtils.takeScreenshot(driver, "Order_" + row.get("name"));
                test.addScreenCaptureFromPath(screenshotPath);

                Assert.assertEquals(totalAmount, laptopPrice);
                confirm.clickOK();
                Thread.sleep(2000);

                driver.get("https://www.demoblaze.com/");
                Thread.sleep(2000);

                test.pass("Order completed successfully for: " + row.get("name"));

            } catch (Exception e) {
                String screenshotPath = ScreenshotUtils.takeScreenshot(driver, "Error_" + row.get("name"));
                test.fail(e);
                test.addScreenCaptureFromPath(screenshotPath);
            }
        }
    }
}

