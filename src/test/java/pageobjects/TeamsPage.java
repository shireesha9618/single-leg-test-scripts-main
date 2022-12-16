package pageobjects;

import base.BaseTestClass;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class TeamsPage extends BaseTestClass {
    private static TeamsPage _instance;

    private final Locator searchTeam_TextBox = Locator.builder().withWeb(By.xpath("//input[@id='search_ptp']"));
    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Team']"));
    private final Locator newTeam_Btn = Locator.builder().withWeb(By.xpath("//p[contains(text(),'New')]/.."));
    private final Locator teamBreadcrumb_Lbl = Locator.builder().withWeb(By.xpath("//li[@id='/teams']"));
    private final Locator status_Dropdown = Locator.builder().withWeb(By.xpath("//p[text()='Status']"));
    private final Locator moreActions_Dropdown = Locator.builder().withWeb(By.xpath("//p[text()='More Actions']/.."));
    private final Locator moreActionsDropDownExportAsCSV_Link = Locator.builder().withWeb(By.xpath("//a[text()='Export as CSV']"));
    private final Locator moreActionsDropDownModifyColumns_Link = Locator.builder().withWeb(By.xpath("//a[text()='Modify Columns']"));
    private final Locator teamData_Lbl = Locator.builder().withWeb(By.xpath("//tbody/tr[@data-row-key]"));
    private final Locator statusDropDownActiveValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='active:active']"));
    private final Locator statusDropDownPauseValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='active:pause']"));
    private final Locator statusDropDownDeBoardValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='active:deboard']"));
    private final Locator statusDropDownInactiveValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='inactive:inactive']"));
    private final Locator statusDropDownTerminalValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='inactive:terminal']"));
    private final Locator statusDropDownDeboardingValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='active:deboarding']"));
    private final Locator statusDropDownOnboardingValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='onboarding:onboarding']"));
    private final Locator statusDropDownValueList_Lbl = Locator.builder().withWeb(By.xpath("//span[@class='ant-radio']/following-sibling::span"));
    private final Locator statusDropDownClearSelection_Btn = Locator.builder().withWeb(By.xpath("//button[p[text()='Clear Selection']]"));
    private final Locator status_DropDown = Locator.builder().withWeb(By.xpath("//button/p[text()='Status']"));
    private final Locator teamsTableStatusColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][3]"));
    private final Locator statusDropDownAvailableValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='active:available']"));

    public static TeamsPage getInstance() {
        if (_instance == null)
            _instance = new TeamsPage();
        return _instance;
    }

    public Boolean isPresent_Header_Lbl() {
        return ActionHelper.isPresent(header_Lbl);
    }

    public void click_NewTeam_Btn() {
        ActionHelper.click(newTeam_Btn);
    }

    public Boolean isPresent_NewTeam_Btn() {
        return ActionHelper.isPresent(newTeam_Btn);
    }

    public Boolean isPresent_TeamBreadcrumb_Lbl() {
        return ActionHelper.isPresent(teamBreadcrumb_Lbl);
    }

    public Boolean isPresent_Status_Dropdown() {
        return ActionHelper.isPresent(status_Dropdown);
    }

    public void click_MoreActions_Dropdown() {
        ActionHelper.click(moreActions_Dropdown);
    }

    public Boolean isPresent_MoreActions_Dropdown() {
        return ActionHelper.isPresent(moreActions_Dropdown);
    }

    public Boolean isPresent_Search_TextBox() {
        return ActionHelper.isPresent(searchTeam_TextBox);
    }

    public boolean isPresent_MoreActionsDropDownExportAsCSV_Link() {
        return ActionHelper.isPresent(moreActionsDropDownExportAsCSV_Link);
    }

    public void click_MoreActionsDropDownExportAsCSV_Link() {
        ActionHelper.click(moreActionsDropDownExportAsCSV_Link);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumns_Link() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumns_Link);
    }

    public void click_MoreActionsDropDownModifyColumns_Link() {
        ActionHelper.click(moreActionsDropDownModifyColumns_Link);
    }

    public void set_SearchTeam_TextBox(String input) {
        ActionHelper.sendKeysWithClear(searchTeam_TextBox.getBy(), input);
        ActionHelper.gotoSleep(10000);
    }

    public int get_size() {
        List<WebElement> data = ActionHelper.findElements(searchTeam_TextBox.getBy());
        return data.size();
    }

    public boolean isEnabled_StatusDropDownActiveValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownActiveValue_Radio.getBy(), 4000);
    }

    public void click_StatusDropDownActiveValue_Radio() {
        Utility.clickRadio(statusDropDownActiveValue_Radio.getBy());
        ActionHelper.waitForLoaderToHide();
    }

    public boolean isEnabled_StatusDropDownPauseValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownPauseValue_Radio.getBy(), 4000);
    }

    public void click_StatusDropDownPauseValue_Radio() {
        Utility.clickRadio(statusDropDownPauseValue_Radio.getBy());
        ActionHelper.waitForLoaderToHide();
    }

    public boolean isEnabled_StatusDropDownDeBoardValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownDeBoardValue_Radio.getBy(), 4000);
    }

    public void click_StatusDropDownDeBoardValue_Radio() {
        Utility.clickRadio(statusDropDownDeBoardValue_Radio.getBy());
        ActionHelper.waitForLoaderToHide();
    }

    public boolean isEnabled_StatusDropDownInactiveValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownInactiveValue_Radio.getBy(), 4000);
    }

    public void click_StatusDropDownTerminalValue_Radio() {
        Utility.clickRadio(statusDropDownTerminalValue_Radio.getBy());
        ActionHelper.waitForLoaderToHide();
    }

    public boolean isEnabled_StatusDropDownTerminalValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownTerminalValue_Radio.getBy(), 4000);
    }

    public void click_StatusDropDownInactiveValue_Radio() {
        Utility.clickRadio(statusDropDownInactiveValue_Radio.getBy());
        ActionHelper.waitForLoaderToHide();
    }

    public void click_StatusDropDownDeBoardingValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownDeboardingValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isEnabled_StatusDropDownOnboardingValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownOnboardingValue_Radio.getBy(), 2000);
    }

    public void click_StatusDropDownOnboardingValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownOnboardingValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isPresent_StatusDropDownClearSelection_Btn() {
        return ActionHelper.isPresent(statusDropDownClearSelection_Btn, 2000);
    }

    public void click_StatusDropDownClearSelection_Btn() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownClearSelection_Btn);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isPresent_Status_Btn() {
        return ActionHelper.isPresent(status_DropDown);
    }

    public void fill_Status_Btn(String inputText) {
        ActionHelper.fillWithClear(status_DropDown.getBy(), inputText);
    }

    public void close_Status_DropDown() {
        ActionHelper.click(status_DropDown);
    }

    public void open_Status_DropDown() {
        ActionHelper.click(status_DropDown);
    }

    public ArrayList<String> getTxt_TeamsTableStatusColumnList_Link() {
        List<WebElement> statusRecord = ActionHelper.findElements(teamsTableStatusColumnList_Link);
        ArrayList<String> allStatus = new ArrayList<>();
        for (WebElement webElement : statusRecord) {
            allStatus.add(String.valueOf(webElement.getText()));
        }
        return allStatus;
    }

    public void click_StatusDropDownAvailableValue_Radio() {
        Utility.clickRadio(statusDropDownAvailableValue_Radio.getBy());
        ActionHelper.waitForLoaderToHide();
    }

    public void createTeam() {
        Utility.clickRadio(statusDropDownAvailableValue_Radio.getBy());
        ActionHelper.waitForLoaderToHide();
    }
}
