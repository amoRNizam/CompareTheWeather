package ui.pages;

import org.assertj.core.api.SoftAssertions;

import java.util.Map;

public class ChecksSteps {

    public void checkingForTemperatureMatches(Map<String, String> oneListTemper, Map<String, String> twoListTemper) {
        SoftAssertions softAssertions = new SoftAssertions();
        for (Map.Entry<String, String> pair : oneListTemper.entrySet()) {
            softAssertions.assertThat(twoListTemper.get(pair.getKey()) + "°")
                    .as("Погода на " + pair.getKey() + " число различается!")
                    .isEqualTo(pair.getValue() + "°");
        }
        softAssertions.assertAll();
    }
}
