package ui.pages.meteoinfo.weatherForecastPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static ui.base.WebTestRunner.webDriver;

public class WeatherForecastPage {
    public WeatherForecastPage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "(//td[@class = 'td_short_gr']//span[contains(text(), '°')])[position() <8]")
    public List<WebElement> listTemperatureFormTable;

    @FindBy(xpath = "(//td[@class = 'td_short_gr']//nobr)[position() <8]")
    public List<WebElement> listDate;
}
