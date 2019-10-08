package ui.pages.gismeteo.mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.base.WebTestRunner;

import static ui.utils.Waits.waitElement;
import static ui.utils.Waits.waitVisibilityOfElementLocated;

public class MainPage extends WebTestRunner {

    public MainPage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "js-search")
    WebElement citySearchFormInput;


    public void selectCity(String nameCity) {
        // вводим название города в поле формы поиска
        waitElement(citySearchFormInput, 10);
        citySearchFormInput.sendKeys(nameCity);

        // выпадающий список городов в форме поиска города
        String locator = String.format("//span[@class = 'founditem__link']//child::b[text() = '%s']", nameCity);

        // нажимаем на город из списка
        WebElement city = waitVisibilityOfElementLocated(By.xpath(locator), 10);
        city.click();
    }
}
