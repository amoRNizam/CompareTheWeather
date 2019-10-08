package ui.pages.gismeteo.mainPage;

public class StepsMainPage {
    MainPage mainPage;

    public void citySelection(String nameCity) {
        mainPage = new MainPage();
        mainPage.selectCity(nameCity);
    }
}
