package pageobjects;

import com.github.javafaker.Faker;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

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
    private final Locator phoneNumber_Txt = Locator.builder().withWeb(By.xpath("(//label[text()='Phone Number*']/..//input[@type='text'])[2]"));
    private final Locator teams_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Teams*']"));
    private final Locator uploadPhoto_Btn = Locator.builder().withWeb(By.xpath("//div[contains(@class, 'ant-upload')]"));
    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']/.."));
    private final Locator addRider_Btn = Locator.builder().withWeb(By.xpath("//button[@id='submitForm']"));
    private final Locator firstNameValidation_Txt = Locator.builder().withWeb(By.xpath("//label[text()='First Name*']/following-sibling::p"));
    private final Locator teamsDropDown_TextBox = Locator.builder().withWeb(By.xpath("//span[text()='Select Teams']"));
    private final Locator lastNameValidation_Txt = Locator.builder().withWeb(By.xpath("//label[text()='Last Name*']/following-sibling::p"));

    Faker sampleData = new Faker();

    public static AddNewRiderPage getInstance() {
        if (_instance == null)
            _instance = new AddNewRiderPage();
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        ActionHelper.waitForLoaderToHide();
        return ActionHelper.isPresent(header_Lbl, 3000);
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
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
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

    public void set_RiderFirstName_TxtBox(String input) {
        ActionHelper.fillWithClear(firstName_Txt.getBy(), input);
    }

    public void fill_RiderLastName_Txt(String input) {
        ActionHelper.fillWithClear(lastName_Txt.getBy(), input);
    }

    public void fill_PhoneNumber_Txt(String phoneNumber) {
        ActionHelper.fillWithClear(phoneNumber_Txt.getBy(), phoneNumber);
    }

    public String get_FirstNameValidation_Txt() {
        return ActionHelper.getText(firstNameValidation_Txt);
    }
}