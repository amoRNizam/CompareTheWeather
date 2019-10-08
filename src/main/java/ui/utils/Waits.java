package ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui.base.WebTestRunner;

import java.util.List;

public class Waits extends WebTestRunner {

    public static WebElement waitElement(WebElement webElement, int secWait) {
        WebDriverWait wait = new WebDriverWait(webDriver, secWait);
        WebElement element = null;
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException e) {
            Assert.fail("Элемент не найден \n" + e);
        }
        return element;
    }

    public static WebElement waitVisibilityOfElementLocated(By locator, int secWait) {
        WebDriverWait wait = new WebDriverWait(webDriver, secWait);
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            Assert.fail("Элемент не найден \n" + e);
        }
        return element;
    }

    public static void waitElements(List<WebElement> elements, int secWait) {
        WebDriverWait wait = new WebDriverWait(webDriver, secWait);
        try {
            List<WebElement> listElements = wait.until(ExpectedConditions.visibilityOfAllElements(elements));

            Assert.assertTrue(listElements.size() > 1, "Список элементов пуст!");
            for (WebElement element : listElements) {
                wait.until(ExpectedConditions.elementToBeClickable(element));
            }
        } catch (TimeoutException e) {
            Assert.fail("Элемент не найден \n" + e);
        }
    }
}
