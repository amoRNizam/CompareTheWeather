package weatherComparisonBetweenSites;

import org.testng.annotations.Test;
import ui.base.WebTestRunner;
import ui.enums.WeatherForecastSites;
import ui.pages.ChecksSteps;
import ui.pages.gismeteo.mainPage.StepsMainPage;
import ui.pages.gismeteo.weatherForecastPage.StepsWeatherForecastPage;

import java.util.Map;


public class WeatherComparisonBetweenSitesTest extends WebTestRunner {

    @Test(description = "Сравнение погоды на неделю между 'gismeteo' и 'meteoinfo'")
    public void weatherComparisonBetweenGismeteoAndMeteoinfo() {
        ChecksSteps checksSteps = new ChecksSteps();
        StepsWeatherForecastPage stepsWeatherForecastPageGismeteo = new StepsWeatherForecastPage();
        StepsMainPage stepsMainPageGismeteo = new StepsMainPage();
        ui.pages.meteoinfo.mainPage.StepsMainPage stepsMainPageMeteoinfo = new ui.pages.meteoinfo.mainPage.StepsMainPage();
        ui.pages.meteoinfo.weatherForecastPage.StepsWeatherForecastPage stepsWeatherForecastPageMeteoinfo = new ui.pages.meteoinfo.weatherForecastPage.StepsWeatherForecastPage();

        Map<String, String> pogodaGismeteo;
        Map<String, String> pogodaMeteoinfo;

        // Перейти на сайт gismeteo
        goToWebsite(WeatherForecastSites.gismeteo.value);

        // выбрать город
        stepsMainPageGismeteo.citySelection("Воронеж");

        // выбрать погоду за неделю
        stepsWeatherForecastPageGismeteo.selectWeatherForAWeek();

        // получить список температур по датам
        pogodaGismeteo = stepsWeatherForecastPageGismeteo.getTemperatureFromTable();

        // Перейти на сайт Meteoinfo
        goToWebsite(WeatherForecastSites.meteoinfo.value);

        // выбрать город
        stepsMainPageMeteoinfo.citySelection("Воронеж");

        // получить список температур по датам
        pogodaMeteoinfo = stepsWeatherForecastPageMeteoinfo.getTemperatureFromTable();

        // Сравнить прогноз температур на Gismeteo и Meteoinfo
        checksSteps.checkingForTemperatureMatches(pogodaGismeteo, pogodaMeteoinfo);
    }
}
