package pageobjects;

import com.github.javafaker.Faker;
import constants.Constants;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import utility.Utility;

import java.util.HashMap;


public class AddNewRiderPage {
    private static AddNewRiderPage _instance;
    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//h2[text()='Add New Rider']"));
    private final Locator homeBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//p[text()='Home']"));
    private final Locator ridersBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/riders']//p"));
    private final Locator addNewRiderBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/riders/add']//p"));
    private final Locator firstName_Lbl = Locator.builder().withWeb(By.xpath("//label[text()='First Name*']"));
    private final Locator firstName_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter first name']"));
    private final Locator lastName_Lbl = Locator.builder().withWeb(By.xpath("//label[text()='Last Name*']"));
    private final Locator lastName_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Last Name']"));
    private final Locator phoneNumber_Lbl = Locator.builder().withWeb(By.xpath("//label[text()='Phone Number*']"));
    private final Locator phoneNumber_Txt = Locator.builder().withWeb(By.xpath("//input[contains(@type,'number')]"));
    private final Locator teams_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Teams*']"));
    private final Locator uploadPhoto_Btn = Locator.builder().withWeb(By.xpath("//div[contains(@class, 'ant-upload')]"));
    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']/.."));
    private final Locator addRider_Btn = Locator.builder().withWeb(By.xpath("//button[@id='submitForm']"));
    private final Locator firstNameValidation_Txt = Locator.builder().withWeb(By.xpath("//label[text()='First Name*']/following-sibling::p"));
    private final Locator teamsDropDown_TextBox = Locator.builder().withWeb(By.xpath("//div[@class='ant-select-selection-overflow']"));
    private final Locator lastNameValidation_Txt = Locator.builder().withWeb(By.xpath("//label[text()='Last Name*']/following-sibling::p"));
    private final Locator phoneNumberValidation_Txt = Locator.builder().withWeb(By.xpath("//label[text()='Phone Number*']/following-sibling::p"));
    private final Locator teamsValidation_Txt = Locator.builder().withWeb(By.xpath("//h4[text()='Teams*']/../following-sibling::div/p"));
    private final Locator teamDropDown_List = Locator.builder().withWeb(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div"));
    private final Locator teamDropDownQaTeam_Txt = Locator.builder().withWeb(By.xpath("//div//span[attribute::title]/span[text()]"));
    private final Locator teamCross_Btn = Locator.builder().withWeb(By.xpath("//span[@aria-label='close']"));
    private final Locator createdSuccessfullyMsg_Txt = Locator.builder().withWeb(By.xpath("//div[@class='h-full']//div[text()='Created Successfully']"));
    Faker sampleData = new Faker();

    public static AddNewRiderPage getInstance() {
        if (_instance == null)
            _instance = new AddNewRiderPage();
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        CommonActions.getInstance().waitTillLoaderDisappears();
        return ActionHelper.isPresent(header_Lbl);
    }

    public String getText_Header_Txt() {
        return ActionHelper.getText(header_Lbl);
    }

    public boolean isPresent_HomeBreadcrumb_Lbl() {
        return ActionHelper.isPresent(homeBreadCrumb_Link);
    }

    public void click_HomeBreadcrumbMenu_Lbl() {
        ActionHelper.click(homeBreadCrumb_Link);
    }

    public boolean isPresent_RidersBreadcrumb_Lbl() {
        return ActionHelper.isPresent(ridersBreadCrumb_Link);
    }

    public void click_RidersBreadcrumbMenu_Lbl() {
        ActionHelper.click(ridersBreadCrumb_Link);
    }

    public boolean isPresent_AddNewRiderBreadcrumbMenu_Lbl() {
        return ActionHelper.isPresent(addNewRiderBreadCrumb_Link);
    }

    public void click_AddNewRiderBreadcrumbMenu_Lbl() {
        ActionHelper.click(addNewRiderBreadCrumb_Link);
    }

    public boolean isPresent_Cancel_Btn() {
        return ActionHelper.isPresent(cancel_Btn);
    }

    public void click_Cancel_Btn() {
        ActionHelper.click(cancel_Btn);
    }

    public boolean isPresent_AddRider_Btn() {
        return ActionHelper.isPresent(addRider_Btn);
    }

    public void click_AddRider_Btn() {
        ActionHelper.click(addRider_Btn);
    }

    public boolean isPresent_FirstName_TxtBox() {
        ActionHelper.waitUntilElementVisible(firstName_Txt.getBy());
        return ActionHelper.isPresent(firstName_Txt);
    }

    public boolean isPresent_LastName_TxtBox() {
        return ActionHelper.isPresent(lastName_Txt);
    }

    public boolean isPresent_PhoneNumber_TxtBox() {
        return ActionHelper.isPresent(phoneNumber_Txt);
    }

    public boolean isPresent_UploadPhoto_Btn() {
        return ActionHelper.isPresent(uploadPhoto_Btn);
    }

    public boolean isPresent_Teams_TxtBox() {
        return ActionHelper.isPresent(teams_Lbl);
    }

    public void fillWithClear_RiderFirstName_TxtBox(String input) {
        ActionHelper.fillWithClear(firstName_Txt.getBy(), input);
    }

    public void fillWithClear_RiderLastName_TxtBox(String input) {
        ActionHelper.fillWithClear(lastName_Txt.getBy(), input);
    }

    public void fillWithClear_PhoneNumber_TxtBox(String phoneNumber) {
        ActionHelper.fillWithClear(phoneNumber_Txt.getBy(), phoneNumber);
    }

    public String get_FirstNameValidation_Txt() {
        return ActionHelper.getText(firstNameValidation_Txt);
    }

    public String get_LastNameValidation_Txt() {
        return ActionHelper.getText(lastNameValidation_Txt);
    }

    public String get_PhoneNumberValidation_Txt() {
        return ActionHelper.getText(phoneNumberValidation_Txt);
    }

    public String get_TeamsValidation_Txt() {
        return ActionHelper.getText(teamsValidation_Txt);
    }

    public boolean isPresent_TeamsDropDownList_Txt() {
        return ActionHelper.isPresent(teamDropDownQaTeam_Txt);
    }

    public String get_TeamsDropDownList_Txt() {
        return ActionHelper.getText(teamDropDownQaTeam_Txt);
    }

    public void select_TeamsDropDown_Btn(String teamName) {
        Utility.select_FromDropDown_List(teamsDropDown_TextBox.getBy(), teamDropDown_List.getBy(), teamName);
        close_SelectTeams_DropDown();
    }

    public void click_RemoveTeamCross_Btn() {
        ActionHelper.click(teamCross_Btn);
    }

    public boolean isPresent_CreatedSuccessfullyMsg_Txt() {
        return ActionHelper.isPresent(createdSuccessfullyMsg_Txt);
    }

    public String get_FirstName_Txt() {
        return ActionHelper.getText(firstName_Txt);
    }

    public String get_LastName_Txt() {
        return ActionHelper.getText(lastName_Txt);
    }

    public String getText_Msg_Lbl() {
        return ActionHelper.getText(createdSuccessfullyMsg_Txt);
    }

    public HashMap<String, String> createAndGetRiderDetails() {
        HashMap<String, String> createNewRider = new HashMap<>();

        createNewRider.put("riderFirstName", sampleData.name().firstName());
        createNewRider.put("riderLastName", sampleData.name().lastName());
        createNewRider.put("phoneNumber", sampleData.number().digits(10));
        createNewRider.put("teamName", Constants.TEAM);

        fillWithClear_RiderFirstName_TxtBox(createNewRider.get("riderFirstName"));
        fillWithClear_RiderLastName_TxtBox(createNewRider.get("riderLastName"));
        fillWithClear_PhoneNumber_TxtBox(createNewRider.get("phoneNumber"));
        select_TeamsDropDown_Btn(createNewRider.get("teamName"));

        click_AddRider_Btn();
        CommonActions.getInstance().waitTillLoaderDisappears();
        return createNewRider;
    }

    private void close_SelectTeams_DropDown() {
        ActionHelper.click(teamsDropDown_TextBox);
    }

    public String get_PhoneNumber_Txt() {
        return ActionHelper.getText(phoneNumber_Txt);
    }
}