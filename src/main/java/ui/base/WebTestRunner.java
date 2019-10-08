package ui.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebTestRunner extends ApplicationManager {
    public static WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        webDriver = init();
    }

    @AfterMethod
    public void tearDown() {
        stop();
    }

    /**
     * Переход по url адресу
     *
     * @param url
     */
    public static void goToWebsite(String url) {
        webDriver.get(url);
    }
}
