package pageobjects;

import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class CreateNewTeamPage {
    private static CreateNewTeamPage _instance;
    private final Locator teamName_TextBox = Locator.builder().withWeb(By.xpath("//input[@name='teamDetails.name']"));
    private final Locator teamID_TextBox = Locator.builder().withWeb(By.xpath("teamDetails.ID"));
    private final Locator selectTeamManager_Dropdown = Locator.builder().withWeb(By.xpath("//span[text()='Select Team Manager']"));
    private final Locator selectRider_Dropdown = Locator.builder().withWeb(By.xpath("//span[text()='Select Rider']"));

    public static CreateNewTeamPage getInstance() {
        if (_instance == null) {
            _instance = new CreateNewTeamPage();
        }
        return _instance;
    }
}
