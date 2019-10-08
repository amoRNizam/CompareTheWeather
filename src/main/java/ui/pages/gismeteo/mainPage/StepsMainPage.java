package ui.pages.gismeteo.mainPage;

public class StepsMainPage {
    MainPage mainPage;

    public void citySelection(String nameCity) {
        mainPage = new MainPage();
        mainPage.selectCity(nameCity);
    }

/*    public void selectWeatherForAWeek() {
        mainPage = new MainPage();

        waitElement(mainPage.dropdownMore, 10);
        mainPage.dropdownMore.click();
        waitElement(mainPage.weatherForAWeek, 10);
        mainPage.weatherForAWeek.click();
    }

    public Map<String, String> getTemperatureFromTable() {
        mainPage = new MainPage();
        waitElements(mainPage.listTemperatureFormTable, 10);

        Map<String, String> pogoda = new HashMap<>();
        List<String> temperature = new ArrayList<>();
        List<String> dateList = new ArrayList<>();
        for (WebElement element : mainPage.listTemperatureFormTable) {
            temperature.add(element.getText().replaceAll("[^0-9]", "").trim());
        }
        if (temperature.size()>7) {
            temperature.remove(temperature.size()-1);
        }
        for (String el : temperature) {
            System.out.println("Температура = " + el);
        }

        ///***************************
        for (WebElement element : mainPage.listDate) {
            dateList.add(element.getText().replaceAll("[^0-9]", "").trim());
        }
        if (dateList.size()>7) {
            dateList.remove(dateList.size()-1);
        }
        for (String el : dateList) {
            System.out.println("Дата = " + el);
        }

        //*****
        for (int i = 0; i < 7; i++) {
            pogoda.put(dateList.get(i), temperature.get(i));

        }


        for (Map.Entry<String, String> pair : pogoda.entrySet()) {
            System.out.println(pair.getKey() + " | " + pair.getValue());
        }
        return pogoda;
    }*/
}
