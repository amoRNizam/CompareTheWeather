package ui.enums;

public enum DriverPaths {
    chrome("src/main/resources/drivers/chromedriver.exe");

    public String value;

    DriverPaths(String value) {
        this.value = value;
    }
}
