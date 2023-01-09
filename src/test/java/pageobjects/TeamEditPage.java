package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import utility.Utility;

public class TeamEditPage {

    private static TeamEditPage _instance;
    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//h2[text()='Edit Teams']"));
    private final Locator teamName_TextBox = Locator.builder().withWeb(By.xpath("//input[@name='teamDetails.name']"));
    private final Locator teamID_TextBox = Locator.builder().withWeb(By.xpath("//input[@name='teamDetails.ID']"));
    private final Locator selectTeamManager_Dropdown = Locator.builder().withWeb(By.xpath("//span[text()='Select Team Manager']"));
    private final Locator selectRider_Dropdown = Locator.builder().withWeb(By.xpath("//span[text()='Select Rider']"));
    private final Locator create_Btn = Locator.builder().withWeb(By.xpath("//button[@id='submitForm']"));
    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']/.."));

    public static TeamEditPage getInstance() {
        if (_instance == null) {
            _instance = new TeamEditPage();
        }
        return _instance;
    }

    public Boolean isPresent_Header_lbl() {
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        return ActionHelper.isPresent(header_Lbl, 5000);
    }

    public void set_TeamName_TextBox(String teamName) {
        ActionHelper.sendKeysWithClear(teamName_TextBox.getBy(), teamName);
    }

    public void set_TeamID_TextBox(String teamID) {
        ActionHelper.sendKeysWithClear(teamID_TextBox.getBy(), teamID);
    }

    public String get_TeamName_TextBox() {
        return ActionHelper.getAttribute(teamName_TextBox.getBy(), "value");
    }

    public String get_TeamID_TextBox() {
        return ActionHelper.getAttribute(teamID_TextBox.getBy(), "value");
    }

    public void click_Create_Btn() {
        ActionHelper.click(create_Btn);
    }

    public void click_Cancel_Btn() {
        ActionHelper.click(cancel_Btn);
    }

    public boolean isPresent_Cancel_Btn() {
        return ActionHelper.isPresent(cancel_Btn);
    }

    public boolean isPresent_Save_Btn() {
        return ActionHelper.isPresent(create_Btn);
    }

    public void fillWithClear_teamName_TextBox(String input) {
        ActionHelper.sendKeysWithClear(teamName_TextBox.getBy(), input);
    }
}