package ui.enums;

public enum WeatherForecastSites {

    meteoinfo("https://meteoinfo.ru"),
    gismeteo("https://www.gismeteo.ru");

    public String value;

    WeatherForecastSites(String value) {
        this.value = value;
    }
}
