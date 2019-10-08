package ui.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.enums.DriverPaths;

import static java.lang.System.setProperty;

public class ApplicationManager {
    private static WebDriver webDriver;

    protected WebDriver init() {
        setProperty("webdriver.chrome.driver", DriverPaths.chrome.value);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        return webDriver;
    }

    protected void stop() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
