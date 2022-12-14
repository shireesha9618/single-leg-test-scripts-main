package pageobjects;

import com.github.javafaker.Faker;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;


public class RiderEditPage {
    private static RiderEditPage _instance;
    private final Locator homeBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//p[text()='Home']"));
    private final Locator ridersBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/riders']"));
    private final Locator editRiderBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/riders/edit']"));
    private final Locator editRiderHeader_Lbl = Locator.builder().withWeb(By.xpath("//h2[text()='Edit Rider']"));
    private final Locator firstName_Lbl = Locator.builder().withWeb(By.xpath("//label[text()='First Name*']"));
    private final Locator firstName_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter first name']"));
    private final Locator lastName_Lbl = Locator.builder().withWeb(By.xpath("//label[text()='Last Name*']"));
    private final Locator lastName_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Last Name']"));
    private final Locator phoneNumber_Lbl = Locator.builder().withWeb(By.xpath("//label[text()='Phone Number*']"));
    private final Locator phoneNumber_Txt = Locator.builder().withWeb(By.xpath("(//label[text()='Phone Number*']/..//input[@type='text'])[2]"));
    private final Locator teams_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Teams*']"));
    private final Locator uploadPhoto_Btn = Locator.builder().withWeb(By.xpath("//div[contains(@class, 'ant-upload')]"));
    private final Locator editRiderSave_Btn = Locator.builder().withWeb(By.xpath("//button[@id='submitForm']//p"));
    private final Locator editRiderCancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']/.."));
    private final Locator updatedSuccessfully_Txt = Locator.builder().withWeb(By.xpath("//div[@class='h-full']//div[text()='Updated Successfully']"));
    Faker sampleData = new Faker();

    public static RiderEditPage getInstance() {
        if (_instance == null)
            _instance = new RiderEditPage();
        return _instance;
    }

    public boolean isPresent_Cancel_Btn() {
        return ActionHelper.isPresent(editRiderCancel_Btn);
    }

    public void click_Cancel_Btn() {
        ActionHelper.click(editRiderCancel_Btn);
    }

    public boolean isPresent_Save_Btn() {
        return ActionHelper.isPresent(editRiderSave_Btn);
    }

    public void click_Save_Btn() {
        ActionHelper.click(editRiderSave_Btn);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isPresent_FirstName_Lbl() {
        return ActionHelper.isPresent(firstName_Lbl);
    }

    public void click_FirstName_Txt() {
        ActionHelper.click(firstName_Txt);
    }

    public void fill_FirstName_TxtBox(String input) {
        ActionHelper.sendKeysWithClear(firstName_Txt.getBy(), input);
    }

    public String getText_LastName_Lbl() {
        return ActionHelper.getText(lastName_Lbl);
    }

    public void fill_LastName_TxtBox(String input) {
        ActionHelper.sendKeysWithClear(lastName_Txt.getBy(), input);
    }

    public boolean isPresent_LastName_Lbl() {
        return ActionHelper.isPresent(lastName_Lbl);
    }

    public void click_LastName_Txt() {
        ActionHelper.click(lastName_Txt);
    }

    public boolean isPresent_PhoneNumber_Lbl() {
        return ActionHelper.isPresent(phoneNumber_Lbl);
    }

    public boolean isPresent_Teams_Lbl() {
        return ActionHelper.isPresent(teams_Lbl);
    }

    public boolean isPresent_EditRiderBreadcrumb_Link() {
        return ActionHelper.isPresent(editRiderBreadCrumb_Link);
    }

    public boolean isPresent_EditRiderHeader_Lbl() {
        return ActionHelper.isPresent(editRiderHeader_Lbl);
    }

    public String getText_EditRiderHeader_Txt() {
        return ActionHelper.getText(editRiderHeader_Lbl);
    }

    public boolean isPresent_UpdatedSuccessfully_Txt() {
        return ActionHelper.isPresent(updatedSuccessfully_Txt);
    }

    public String getText_UpdatedSuccessfully_Txt() {
        return ActionHelper.getText(updatedSuccessfully_Txt);
    }

    public String getText_FirstName_TxtBox() {
        return ActionHelper.getText(firstName_Txt);
    }

    public String getText_LastName_TxtBox() {
        return ActionHelper.getText(lastName_Txt);
    }

    public String getText_PhoneNumber_TxtBox() {
        return ActionHelper.getText(phoneNumber_Lbl);
    }

    public String getText_Teams_TxtBox() {
        return ActionHelper.getText(teams_Lbl);
    }

    public void fillWithClear_RiderFirstName_TxtBox(String input) {
        ActionHelper.fillWithClear(firstName_Txt.getBy(), input);
    }

    public void fillWithClear_RiderLastName_TxtBox(String input) {
        ActionHelper.fillWithClear(lastName_Txt.getBy(), input);
    }

    public String get_FirstName_Txt() {
        return ActionHelper.getAttribute(firstName_Txt, "value");
    }

    public String get_LastName_Txt() {
        return ActionHelper.getAttribute(lastName_Txt, "value");
    }
}