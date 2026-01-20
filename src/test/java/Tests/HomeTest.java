package Tests;

import Drivers.WebDriverFactory;
import Pages.HomePage;
import Utils.PropertyReader;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressTest {
    WebDriver webDriver;

    @BeforeMethod
    public void setup() {
        webDriver = WebDriverFactory.initDriver();
        String baseUrl= PropertyReader.getProperty("baseUrl");
        webDriver.get(baseUrl);
    }
    @Test
    public void validCantViewAddress() {
        Allure.getLifecycle().updateTestCase(testResult -> testResult.setName("validCantViewOrders"));

        new HomePage(webDriver).isAtHomePage("amazon")
                .openOrders();

    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
