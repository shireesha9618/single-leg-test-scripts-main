package pageobjects;

import base.BaseTestClass;
import framework.common.assertion.JarvisAssert;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TeamsPage extends BaseTestClass {
    private static TeamsPage _instance;

    private final Locator searchTeam_TextBox = Locator.builder().withWeb(By.xpath("//input[@id='search_ptp']"));
    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Teams']"));
    private final Locator newTeam_Btn = Locator.builder().withWeb(By.xpath("//p[contains(text(),'New')]/.."));
    private final Locator teamBreadcrumb_Lbl = Locator.builder().withWeb(By.xpath("//li[@id='/teams']"));
    private final Locator moreActions_Dropdown = Locator.builder().withWeb(By.xpath("//p[text()='More Actions']/.."));
    private final Locator moreActionsDropDownExportAsCSV_Link = Locator.builder().withWeb(By.xpath("//a[text()='Export as CSV']"));
    private final Locator moreActionsDropDownModifyColumns_Link = Locator.builder().withWeb(By.xpath("//a[text()='Modify Columns']"));
    private final Locator teamData_Lbl = Locator.builder().withWeb(By.xpath("//tbody/tr[@data-row-key]"));
    private final Locator statusDropDownValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value]"));
    private final Locator statusDropDownPauseValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='active:pause']"));
    private final Locator statusDropDownDeBoardValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='active:deboard']"));
    private final Locator statusDropDownInactiveValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='inactive:inactive']"));
    private final Locator statusDropDownTerminalValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='inactive:terminal']"));
    private final Locator statusDropDownDeboardingValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='active:deboarding']"));
    private final Locator statusDropDownOnboardingValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='onboarding:onboarding']"));
    private final Locator statusDropDownValueList_Lbl = Locator.builder().withWeb(By.xpath("//span[@class='ant-radio']/following-sibling::span"));
    private final Locator statusDropDownClearSelection_Btn = Locator.builder().withWeb(By.xpath("//button[p[text()='Clear Selection']]"));
    private final Locator status_DropDown = Locator.builder().withWeb(By.xpath("//p[text()='Status']//parent::button"));
    private final Locator teamsTableStatusColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][3]"));
    private final Locator status_RadioBtn = Locator.builder().withWeb(By.xpath("//label[@class='ant-radio-wrapper']/span[2]"));
    private final Locator emptyTable_Txt = Locator.builder().withWeb(By.xpath("//h3"));
    private final Locator edit_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Edit']"));
    private final Locator moreActions_DropDown = Locator.builder().withWeb(By.xpath("//button/p[text()='More Actions']"));
    private final Locator modifyColumns_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Modify Columns']"));
    private final Locator moreActionsDropDownModifyColumnsLinkSelectAll_Btn = Locator.builder().withWeb(By.xpath("//div[contains(@class, 'px')]/button[1]/p"));
    private final Locator moreActionsDropDownModifyColumnsLinkSave_Btn = Locator.builder().withWeb(By.xpath("//button//p[text()='Save']"));
    private final Locator tabHeaderList_Lbl = Locator.builder().withWeb(By.xpath("//thead/tr/th[text()]"));
    private final Locator editColumn_List = Locator.builder().withWeb(By.xpath("//label[@class='w-full']/p"));
    private final Locator moreActionsDropDownModifyColumnsLinkCancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']/.."));
    private final Locator moreActionsDropDownModifyColumnsLinkSearchBar_Txt = Locator.builder().withWeb(By.xpath("//input[@type='text' and @value]"));
    private final Locator moreActionsDropDownModifyColumnsLinkHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Edit Columns']"));
    private final Locator editColumnsSearchRightList_Link = Locator.builder().withWeb(By.xpath("//div[@data-rbd-droppable-id='droppable']/div"));
    private final Locator editColumnsSearchLeftList_Link = Locator.builder().withWeb(By.xpath("//label[@Class='w-full']"));
    private final Locator editColumn_Checkbox = Locator.builder().withWeb(By.xpath("//label[@class='w-full']/p/../parent::div/input"));
    private final Locator moreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label = Locator.builder().withWeb(By.xpath("//div[@data-rbd-droppable-id='droppable']/div/div/p"));
    private final Locator moreActionsDropDownModifyColumnsLinkStatus_Checkbox = Locator.builder().withWeb(By.xpath("//input[@id='Status']"));
    private final Locator moreActionsDropDownModifyColumnsStatusCross_Icon = Locator.builder().withWeb(By.xpath("//div[@data-rbd-drag-handle-draggable-id='Status']/button"));
    private final Locator teamsTableRiderIDColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][1]/a/a"));
    private final Locator teamsTableTeamNameColumnList_Link = Locator.builder().withWeb(By.xpath("//td[@class='ant-table-cell'][2]"));
    private final Locator paginationSelectedItem_Lbl = Locator.builder().withWeb(By.xpath("//div[contains(@class,'pagination')]//span[@title]"));
    private final Locator paginationPerPageOptionsList_Lbl = Locator.builder().withWeb(By.xpath("//div[contains(text(),' / page')]"));
    private final Locator teamsTableTeamIdColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][1]"));
    private final Locator paginationBlockList_Lbl = Locator.builder().withWeb(By.xpath("//li[contains(@class,'pagination-item')]"));
    private final Locator next_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Next']"));
    private final Locator previous_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Prev']"));
    private final Locator tableData_CheckBox = Locator.builder().withWeb(By.xpath("//td//label[@class='ant-checkbox-wrapper']"));
    private final Locator deactivate_Btn = Locator.builder().withWeb(By.xpath("//body/div/div/div/div/div/div/button[1]"));
    private final Locator selectAll_CheckBox = Locator.builder().withWeb(By.xpath("//span[@class='select-all']"));
    private final Locator tableDataCheckBox_Checked = Locator.builder().withWeb(By.xpath("//span[@class='ant-checkbox ant-checkbox-checked']"));
    private final Locator deactivateTeamHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Deactivate Team']"));
    private final Locator deactivateTeamCancel_Btn = Locator.builder().withWeb(By.xpath("//p[contains(text(), 'Are you')]/../parent::div/following-sibling::div/button/p[text()='Cancel']"));
    private final Locator deactivateTeamDeactivate_Btn = Locator.builder().withWeb(By.xpath("//p[contains(text(), 'Are you')]/../parent::div/following-sibling::div/button/p[text()='Deactivate']"));
    private final Locator teamsTableIDList_Link = Locator.builder().withWeb(By.xpath("//tr[contains(@class, 'ant-table-row')]/td/a"));
    private final Locator search_Bar = Locator.builder().withWeb(By.xpath("//input[@id='search_ptp']"));

    public static TeamsPage getInstance() {
        if (_instance == null)
            _instance = new TeamsPage();
        return _instance;
    }

    public Boolean isPresent_Header_Lbl() {
        CommonActions.getInstance().waitTillLoaderDisappears();
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
        return ActionHelper.isPresent(status_DropDown);
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
        return ActionHelper.isEnabled(statusDropDownValue_Radio.getBy(), 4000);
    }

    public void click_StatusDropDownValue_Radio(String input) {
        List<WebElement> elementsList = ActionHelper.findElements(statusDropDownValue_Radio);
        for (WebElement element : elementsList) {
            if (element.getAttribute("value").equals(input))
                Utility.clickRadio(statusDropDownValue_Radio.getBy());
        }
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
        TeamsPage.getInstance().open_Status_DropDown();
        ActionHelper.click(statusDropDownClearSelection_Btn);
        TeamsPage.getInstance().close_Status_DropDown();
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
        ActionHelper.waitForLoaderToHide();
        List<WebElement> statusRecord = ActionHelper.findElements(teamsTableStatusColumnList_Link);
        ArrayList<String> allStatus = new ArrayList<>();
        for (WebElement webElement : statusRecord) {
            allStatus.add(String.valueOf(webElement.getText()));
        }
        return allStatus;
    }

    public void click_Status_RadioBtn(String input) {
        open_Status_DropDown();
        List<WebElement> list = ActionHelper.findElements(status_RadioBtn.getBy());
        for (WebElement element : list) {
            String statusTxt = element.getText();
            if (statusTxt.toLowerCase().contains(input.toLowerCase())) {
                Utility.clickRadio(element);
                break;
            }
        }
        ActionHelper.waitForLoaderToHide();
        close_Status_DropDown();
    }

    public boolean isPresent_EmptyTable_Txt() {
        return ActionHelper.isPresent(emptyTable_Txt);
    }

    public void validate_Status_RadioBtn(String status) {
        if (!isPresent_EmptyTable_Txt()) {
            for (String value : getTxt_RidersTableStatusColumnList_Link())
                JarvisAssert.assertEquals(value, status, status + " Status Is Present As Expected");
        } else {
            JarvisAssert.assertTrue(isPresent_EmptyTable_Txt(), "Table Has No Record Empty Table");
            JarvisAssert.assertEquals(getText_EmptyTable_Txt(), "It is Empty here", "Table Empty Is Matched As Expected");
        }
    }

    public ArrayList<String> getTxt_RidersTableStatusColumnList_Link() {
        List<WebElement> statusRecord = ActionHelper.findElements(teamsTableStatusColumnList_Link);
        ArrayList<String> allStatus = new ArrayList<>();
        for (WebElement webElement : statusRecord) {
            allStatus.add(String.valueOf(webElement.getText()));
        }
        return allStatus;
    }

    public String getText_EmptyTable_Txt() {
        return ActionHelper.getText(emptyTable_Txt);
    }

    public HashMap<String, String> createNewTeam() {
        HashMap<String, String> teamDetails = new HashMap<>();
        String teamName = "Team" + Utility.generateRandomNoInRange(1, 1000);
        CommonActions.getInstance().coverJourneyTillTeams();
        TeamsPage.getInstance().click_NewTeam_Btn();
        CreateNewTeamPage.getInstance().set_TeamName_TextBox(teamName);
        teamDetails.put("teamId", CreateNewTeamPage.getInstance().get_TeamID_TextBox());
        teamDetails.put("teamName", teamName);
        CreateNewTeamPage.getInstance().click_Create_Btn();
        return teamDetails;
    }

    public void click_Edit_Btn(int index) {
        ActionHelper.click(ActionHelper.findElements(edit_Btn).get(index));
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public void clickAndChoose_MoreActionsDropDownMenuOptions_Btn(String menuItem) {
        Utility.select_FromDropDown_List(moreActions_DropDown.getBy(), modifyColumns_Btn.getBy(), menuItem);
    }

    public void click_EditColumnsSelectAllWithSave_Btn() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkSelectAll_Btn);
        new Actions(DriverManager.getDriver()).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkSave_Btn);
    }

    public List<String> getText_TableHeaderList_Lbl() {
        return Utility.getSortedListOfText_ListOfWebElementsWhileScrollingUsingJS(tabHeaderList_Lbl.getBy());
    }

    public Boolean isPresent_EdiColumnName_Lbl(String input) {
        boolean status = false;
        List<String> columnList = Utility.getText_ListOfWebElements(editColumn_List.getBy());
        for (String columnName : columnList) {
            if (columnName.equals(input))
                status = true;
        }
        return status;
    }

    public void click_MoreActionsDropDownModifyColumnsLinkSave_Btn() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkSave_Btn);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsLinkCancel_Btn() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkCancel_Btn, 2000);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsLinkSave_Btn() {
        Utility.scrollUsingJSToTheLastElement(moreActionsDropDownModifyColumnsLinkSave_Btn.getBy());
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkSave_Btn, 2000);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsLinkSelectAll_Btn() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkSelectAll_Btn);
    }

    public boolean isPresent_ModifyColumns_SearchBar() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkSearchBar_Txt);
    }

    public boolean isPresent_EditColumnsHeader_Lbl() {
        ActionHelper.waitForLoaderToHide();
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkHeader_Lbl, 5000);
    }

    public void click_MoreActionsDropDownModifyColumnsLinkSelectAll_Btn() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkSelectAll_Btn);
    }

    public int getSize_EditColumnsSearchRightList_Link() {
        ActionHelper.waitUntilAllElementsVisible(editColumnsSearchRightList_Link.getBy());
        List<WebElement> allRightRecord = ActionHelper.findElements(editColumnsSearchRightList_Link);
        return allRightRecord.size();
    }

    public int getSize_EditColumnsSearchLeftList_Link() {
        ActionHelper.waitUntilAllElementsVisible(editColumnsSearchLeftList_Link.getBy());
        List<WebElement> allLeftRecord = ActionHelper.findElements(editColumnsSearchLeftList_Link);
        return allLeftRecord.size();
    }

    public void check_EdiColumnName_CheckBox(String input) {
        List<WebElement> columnList = ActionHelper.findElements(editColumn_Checkbox.getBy());
        for (WebElement element : columnList) {
            if (element.getAttribute("name").equals(input))
                element.click();
            break;
        }
    }

    public void unCheck_EdiColumnName_CheckBox(String input) {
        List<WebElement> columnList = ActionHelper.findElements(editColumn_Checkbox.getBy());
        for (WebElement element : columnList) {
            if (element.getAttribute("name").equals(input))
                element.click();
        }
    }

    public List<String> getText_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label() {
        return Utility.getText_ListOfWebElements(moreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label.getBy());
    }

    public void dragAndDrop_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label(int fromIndex,
                                                                                          int toIndex) {
        List<WebElement> elements = ActionHelper.findElements(moreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.clickAndHold(elements.get(fromIndex)).moveByOffset(-10, 0).moveToElement(elements.get(toIndex)).release().pause(5000).perform();
    }

    public void click_MoreActionsDropDownModifyColumnsStatus_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkStatus_Checkbox);
    }

    public void click_MoreActionsDropDownModifyColumnsStatusCross_Icon() {
        ActionHelper.click(moreActionsDropDownModifyColumnsStatusCross_Icon);
    }

    public void fill_EditColumnsSearch_Txt(String input) {
        ActionHelper.fillWithClear(moreActionsDropDownModifyColumnsLinkSearchBar_Txt.getBy(), input);
    }

    public void click_MoreActionsDropDownModifyColumnsLinkCancel_Btn() {
        Utility.scrollUsingJSToTheLastElement(moreActionsDropDownModifyColumnsLinkCancel_Btn.getBy());
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkCancel_Btn);
    }

    public List<String> getText_TableDataTeamID_List() {
        ActionHelper.waitUntilElementVisible(teamsTableRiderIDColumnList_Link.getBy());
        return Utility.getText_ListOfWebElements(teamsTableRiderIDColumnList_Link.getBy());
    }

    public List<String> getText_TableDataTeamName_List() {
        CommonActions.getInstance().waitTillLoaderDisappears();
        return Utility.getText_ListOfWebElements(teamsTableTeamNameColumnList_Link.getBy());
    }

    public void choose_NoOfRecordsToBeDisplayed_PerPage(int no) {
        ActionHelper.click(paginationSelectedItem_Lbl);
        Utility.clickWebElementContainingText(ActionHelper.findElements(paginationPerPageOptionsList_Lbl), String.valueOf(no));
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public List<WebElement> getElements_TeamsTableTeamIdColumnList_Link() {
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        return ActionHelper.findElements(teamsTableTeamIdColumnList_Link.getBy());
    }

    public boolean validateTeamsTableRecordEqualsToPerPaginationOptions() {
        ActionHelper.waitUntilAllElementsVisible(teamsTableTeamIdColumnList_Link.getBy());
        String getTextPaginationSelectedItem_Lbl[] = ActionHelper.findElement(paginationSelectedItem_Lbl).getText().split(" ");
        return (getElements_TeamsTableTeamIdColumnList_Link().size() <= Integer.parseInt(getTextPaginationSelectedItem_Lbl[0]));
    }

    public void select_PaginationBlockList_Lbl(String pageNo) {
        for (WebElement element : ActionHelper.findElements(paginationBlockList_Lbl))
            if (element.getAttribute("title").equals(pageNo))
                ActionHelper.click(element);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void click_Next_Btn() {
        CommonActions.getInstance().waitTillLoaderDisappears();
        ActionHelper.click(next_Btn);
    }

    public void click_Previous_Btn() {
        CommonActions.getInstance().waitTillLoaderDisappears();
        ActionHelper.click(previous_Btn);
    }

    public String getText_TeamsHeader_Lbl() {
        return ActionHelper.getText(header_Lbl);
    }

    public void check_TableData_CheckBox(int index) {
        ActionHelper.waitUntilElementVisible(tableData_CheckBox.getBy());
        Utility.checkCheckbox(ActionHelper.findElements(tableData_CheckBox.getBy()).get(index));
    }

    public boolean isPresent_Deactivate_Btn() {
        return ActionHelper.isPresent(deactivate_Btn);
    }

    public boolean isPresent_SelectAll_CheckBox() {
        return ActionHelper.isPresent(selectAll_CheckBox);
    }

    public void click_SelectAll_CheckBox() {
        ActionHelper.click(selectAll_CheckBox);
    }

    public void uncheck_TableData_CheckBox(int index) {
        ActionHelper.waitUntilElementVisible(tableDataCheckBox_Checked.getBy());
        Utility.checkCheckbox(ActionHelper.findElements(tableDataCheckBox_Checked.getBy()).get(index));
    }

    public void click_Deactivate_Btn() {
        ActionHelper.click(deactivate_Btn);
    }

    public boolean isPresent_DeactivateTeamHeader_Lbl() {
        return ActionHelper.isPresent(deactivateTeamHeader_Lbl);
    }

    public String getText_DeactivateTeamHeader_Lbl() {
        return ActionHelper.getText(deactivateTeamHeader_Lbl);
    }


    public boolean isPresent_DeactivateTeamCancel_Btn() {
        return ActionHelper.isPresent(deactivateTeamCancel_Btn);
    }

    public boolean isPresent_DeactivateTeamDeactivate_Btn() {
        return ActionHelper.isPresent(deactivateTeamDeactivate_Btn);
    }

    public void click_DeactivateTeamDeactivate_Btn() {
        ActionHelper.click(deactivateTeamDeactivate_Btn);
    }

    public void click_DeactivateTeamCancel_Btn() {
        ActionHelper.click(deactivateTeamCancel_Btn);
    }

    public String getText_TeamsTableIdList_Lbl(int index) {
        return ActionHelper.getText(ActionHelper.findElements(teamsTableTeamIdColumnList_Link).get(index));
    }

    public void click_TeamsTableIDList_Link(int index) {
        ActionHelper.click(ActionHelper.findElements(teamsTableIDList_Link).get(index));
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void fillWithClear_Search_Txt(String teamName) {
        ActionHelper.fillWithClear(search_Bar.getBy(), teamName);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_TeamsTableTeamIdColumnList_Link() {
        return ActionHelper.getText(teamsTableTeamIdColumnList_Link);
    }

    public String getText_TeamsTableTeamNameColumnList_Link() {
        return ActionHelper.getText(teamsTableTeamNameColumnList_Link);
    }
}
