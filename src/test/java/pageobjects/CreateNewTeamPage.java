package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import utility.Utility;

public class CreateNewTeamPage {
    private static CreateNewTeamPage _instance;
    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//h2[text()='Create Teams']"));
    private final Locator teamName_TextBox = Locator.builder().withWeb(By.xpath("//input[@name='teamDetails.name']"));
    private final Locator teamID_TextBox = Locator.builder().withWeb(By.xpath("//input[@name='teamDetails.ID']"));
    private final Locator selectTeamManager_Dropdown = Locator.builder().withWeb(By.xpath("//span[text()='Select Team Manager']"));
    private final Locator selectRider_Dropdown = Locator.builder().withWeb(By.xpath("//h4[text()='Rider']/../following-sibling::div//div[@class='ant-select-selector']"));
    private final Locator create_Btn = Locator.builder().withWeb(By.xpath("//button[@id='submitForm']"));
    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']/.."));
    private final Locator homeBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/']"));
    private final Locator teams_BreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/teams']"));
    private final Locator createNewTeam_BreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/teams/add']"));
    private final Locator teamNameValidation_Txt = Locator.builder().withWeb(By.xpath("//h4[text()='Name*']/../following-sibling::div//p"));
    private final Locator teamIDValidation_Txt = Locator.builder().withWeb(By.xpath("//h4[text()='ID*']/../following-sibling::div//p"));
    private final Locator createdSuccessfullyMsg_Txt = Locator.builder().withWeb(By.xpath("//div[@class='h-full']//div[text()='Created Successfully']"));
    private final Locator errorMsg_Txt = Locator.builder().withWeb(By.xpath("//div[@class='h-full']//div[contains(text(), 'In participant')]"));

    public static CreateNewTeamPage getInstance() {
        if (_instance == null) {
            _instance = new CreateNewTeamPage();
        }
        return _instance;
    }

    public void set_TeamName_TextBox(String teamName) {
        ActionHelper.sendKeysWithClear(teamName_TextBox.getBy(), teamName);
    }

    public void set_TeamID_TextBox(String teamID) {
        ActionHelper.sendKeysWithClear(teamID_TextBox.getBy(), teamID);
    }

    public String get_TeamName_TextBox() {
        return ActionHelper.getText(teamName_TextBox.getBy());
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

    public Boolean isPresent_Header_lbl() {
        return ActionHelper.isPresent(header_Lbl,3000);
    }

    public boolean isPresent_Cancel_Btn() {
        return ActionHelper.isPresent(cancel_Btn);
    }

    public boolean isPresent_Create_Btn() {
        return ActionHelper.isPresent(create_Btn);
    }

    public boolean isPresent_HomeBreadcrumb_Lbl() {
        return ActionHelper.isPresent(homeBreadCrumb_Link);
    }

    public boolean isPresent_CreateTeamsBreadcrumbMenu_Lbl() {
        return ActionHelper.isPresent(createNewTeam_BreadCrumb_Link);
    }

    public boolean isPresent_TeamsBreadcrumbMenu_Lbl() {
        return ActionHelper.isPresent(teams_BreadCrumb_Link);
    }

    public boolean isPresent_Header_Lbl() {
        CommonActions.getInstance().waitTillLoaderDisappears();
        return ActionHelper.isPresent(header_Lbl);
    }

    public String getText_Header_Txt() {
        return ActionHelper.getText(header_Lbl);
    }

    public boolean isPresent_Name_TxtBox() {
        return ActionHelper.isPresent(teamName_TextBox);
    }

    public boolean isPresent_Id_TxtBox() {
        return ActionHelper.isPresent(teamID_TextBox);
    }

    public boolean isPresent_TeamManager_DropDown() {
        return ActionHelper.isPresent(selectTeamManager_Dropdown);
    }

    public boolean isPresent_Rider_DropDown() {
        return ActionHelper.isPresent(selectRider_Dropdown);
    }

    public void fillWithClear_TeamName_TxtBox(String input) {
        Utility.selectAllAndClear(teamName_TextBox.getBy());
        ActionHelper.fillWithClear(teamName_TextBox.getBy(), input);
    }

    public String get_NameValidation_Txt() {
        return ActionHelper.getText(teamNameValidation_Txt);
    }

    public void fillWithClear_TeamID_TxtBox(String input) {
        Utility.selectAllAndClear(teamID_TextBox.getBy());
        ActionHelper.fillWithClear(teamID_TextBox.getBy(), input);
    }

    public String get_IDValidation_Txt() {
        return ActionHelper.getText(teamIDValidation_Txt);
    }

    public String getText_ErrorMsg_Lbl() {
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        return ActionHelper.getText(errorMsg_Txt);
    }

    public void fillWithClear_Rider_TxtBox(String input) {
        Utility.selectAllAndClear(selectRider_Dropdown.getBy());
        ActionHelper.fillWithClear(selectRider_Dropdown.getBy(), input);
    }
}