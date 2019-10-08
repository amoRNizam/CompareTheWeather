package ui.pages.gismeteo.weatherForecastPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static ui.base.WebTestRunner.webDriver;

public class WeatherForecastPage {
    public WeatherForecastPage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//a[@class = 'dropdown__handle subnav_link']")
    WebElement dropdownMore;

    @FindBy(xpath = "//li[@role= 'menuitem']//a[contains(text(), 'Неделя')]")
    WebElement weatherForAWeek;

    @FindBy(xpath = "(//div[@class = 'maxt']//span[@class = 'unit unit_temperature_c'])[position() <8]")
    List<WebElement> listTemperatureFormTable;

    @FindBy(xpath = "(//div[@class = 'widget__row widget__row_table widget__row_temperature']" +
            "//ancestor::div[@class = 'widget__container']//child::span[contains(@class, 'w_date__date')])[position() <8]")
    List<WebElement> listDate;
}
