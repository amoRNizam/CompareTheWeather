package ui.pages.gismeteo.weatherForecastPage;

import org.openqa.selenium.WebElement;

import java.util.*;

import static ui.utils.Waits.waitElement;
import static ui.utils.Waits.waitElements;

public class StepsWeatherForecastPage {

    WeatherForecastPage weatherForecastPage;

    public void selectWeatherForAWeek() {
        weatherForecastPage = new WeatherForecastPage();

        waitElement(weatherForecastPage.dropdownMore, 10);
        weatherForecastPage.dropdownMore.click();

        waitElement(weatherForecastPage.weatherForAWeek, 10);
        weatherForecastPage.weatherForAWeek.click();
    }

    public Map<String, String> getTemperatureFromTable() {
        weatherForecastPage = new WeatherForecastPage();
        waitElements(weatherForecastPage.listTemperatureFormTable, 10);

        Map<String, String> pogoda = new HashMap<>();
        List<String> temperature = new ArrayList<>();
        List<Integer> dateList = new ArrayList<>();

        // записываем температуру
        for (WebElement element : weatherForecastPage.listTemperatureFormTable) {
            temperature.add(element.getText().replaceAll("[^0-9]", "").trim());
        }

        // записываем даты
        for (WebElement element : weatherForecastPage.listDate) {
            dateList.add(Integer.parseInt(element.getText().replaceAll("[^0-9]", "").trim()));
        }
        Collections.sort(dateList);

        // заполняем в HashMap дату и температуру
        for (int i = 0; i < 7; i++) {
            pogoda.put(String.valueOf(dateList.get(i)), temperature.get(i));
        }
        return pogoda;
    }
}
