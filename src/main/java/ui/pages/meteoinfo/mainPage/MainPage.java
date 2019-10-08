package ui.pages.meteoinfo.mainPage;

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

    @FindBy(xpath = "//span[@id = 'select2-sel_search-container']//parent::span[@role = 'combobox']")
    public WebElement citySelectionField;

    @FindBy(className = "select2-search__field")
    public WebElement citySearchInput;


    public void selectCity(String nameCity) {
        // нажимаем на выпадающее поле выбора города
        waitElement(citySelectionField, 10);
        citySelectionField.click();

        // вводим название города в поле поиска
        citySearchInput.sendKeys(nameCity);

        // результаты поиска
        String locator = String.format("//span[@class = 'select2-results' and contains(string(), '%s')]", nameCity);

        // нажимаем на город из результатов поиска
        WebElement city = waitVisibilityOfElementLocated(By.xpath(locator), 10);
        city.click();
    }
}
