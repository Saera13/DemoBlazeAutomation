package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.CSVUtils;
import utils.RetryAnalyzer;

import java.util.Map;

public class EndToEndTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void purchaseLaptopUsingCSV() {

        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        OrderPage order = new OrderPage(driver);

        home.selectLaptopCategory();
        home.selectLaptop();

        String productPrice = product.getPrice();
        product.addToCart();

        cart.openCart();
        cart.verifyProduct();
        cart.clickPlaceOrder();

        Map<String, String> data =
                CSVUtils.getTestData("src/test/resources/testdata.csv");

        order.fillOrderForm(data);

        String amount = cart.getPurchaseAmount();
        Assert.assertEquals(amount, productPrice);
    }
}	
