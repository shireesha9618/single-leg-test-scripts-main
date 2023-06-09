package pageobjects;

import constants.Constants;
import framework.common.assertion.JarvisAssert;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class RidersPage {
    private static RidersPage _instance;
    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//div/p[text()='Riders']"));
    private final Locator homeBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//p[text()='Home']"));
    private final Locator ridersBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/riders']//p"));
    private final Locator emptyTable_Txt = Locator.builder().withWeb(By.xpath("//h3"));
    private final Locator search_Bar = Locator.builder().withWeb(By.xpath("//input[@id='search_ptp']"));
    private final Locator status_DropDown = Locator.builder().withWeb(By.xpath("//button/p[text()='Status']"));
    private final Locator dropDownList_Lbl = Locator.builder().withWeb(By.xpath("//div[@class='ant-select-item-option-content']"));
    private final Locator statusDropDownAvailableValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='active:available']"));
    private final Locator statusDropDownBusyValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='active:busy']"));
    private final Locator statusDropDownUnAvailableValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='active:unavailable']"));
    private final Locator statusDropDownAllocatedValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='active:allocated']"));
    private final Locator statusDropDownTerminalValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='inactive:terminal']"));
    private final Locator statusDropDownDeboardingValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='active:deboarding']"));
    private final Locator statusDropDownInactiveValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='inactive:inactive']"));
    private final Locator statusDropDownOnboardingValue_Radio = Locator.builder().withWeb(By.xpath("//input[@value='onboarding:onboarding']"));
    private final Locator statusDropDownValueList_Lbl = Locator.builder().withWeb(By.xpath("//span[@class='ant-radio']/following-sibling::span"));
    private final Locator statusDropDownClearSelection_Btn = Locator.builder().withWeb(By.xpath("//button[p[text()='Clear Selection']]"));
    private final Locator teams_DropDown = Locator.builder().withWeb(By.xpath("//button//p[text()='Teams']"));
    private final Locator moreActions_DropDown = Locator.builder().withWeb(By.xpath("//button/p[text()='More Actions']"));
    private final Locator exportCSV_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Export as CSV']"));
    private final Locator modifyColumns_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Modify Columns']"));
    private final Locator moreActionsDropDownModifyColumnsLinkHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Edit Columns']"));
    private final Locator moreActionsDropDownModifyColumnsLinkSearchBar_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Search']"));
    private final Locator moreActionsDropDownModifyColumnsLinkSelectAll_Btn = Locator.builder().withWeb(By.xpath("//div[contains(@class, 'px')]/button[1]/p"));
    private final Locator moreActionsDropDownModifyColumnsLinkOptionsList_Label = Locator.builder().withWeb(By.xpath("//p[text()='Select All']/../../..//label/p"));
    private final Locator moreActionsDropDownModifyColumnsLinkRiderName_Checkbox = Locator.builder().withWeb(By.xpath("//input[@id='Rider Name']"));
    private final Locator moreActionsDropDownModifyColumnsLinkRiderId_Checkbox = Locator.builder().withWeb(By.xpath("//input[@id='Rider Id']"));
    private final Locator moreActionsDropDownModifyColumnsLinkStatus_Checkbox = Locator.builder().withWeb(By.xpath("//input[@id='Status']"));
    private final Locator moreActionsDropDownModifyColumnsLinkPhoneNumber_Checkbox = Locator.builder().withWeb(By.xpath("//input[@id='Phone Number']"));
    private final Locator moreActionsDropDownModifyColumnsLinkTeams_Checkbox = Locator.builder().withWeb(By.xpath("//input[@id='Teams']"));
    private final Locator moreActionsDropDownModifyColumnsLinkCreatedAt_Checkbox = Locator.builder().withWeb(By.xpath("//input[@id='Created At']"));
    private final Locator moreActionsDropDownModifyColumnsLinkCreatedBy_Checkbox = Locator.builder().withWeb(By.xpath("//input[@id='Created By']"));
    private final Locator moreActionsDropDownModifyColumnsLinkUpdatedAt_Checkbox = Locator.builder().withWeb(By.xpath("//input[@id='Updated At']"));
    private final Locator moreActionsDropDownModifyColumnsLinkUpdatedBy_Checkbox = Locator.builder().withWeb(By.xpath("//input[@id='Updated By']"));
    private final Locator moreActionsDropDownModifyColumnsLinkSave_Btn = Locator.builder().withWeb(By.xpath("//button//p[text()='Save']"));
    private final Locator moreActionsDropDownModifyColumnsLinkCancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']/.."));
    private final Locator moreActionsDropDownModifyColumnsLinkCross_Icon = Locator.builder().withWeb(By.xpath("//p[text()='Edit Columns']/following-sibling::*/*"));
    private final Locator moreActionsDropDownModifyColumnsStatusCross_Icon = Locator.builder().withWeb(By.xpath("//div[@data-rbd-drag-handle-draggable-id='Status']/button"));
    private final Locator editColumnsSearchRightList_Link = Locator.builder().withWeb(By.xpath("//div[@data-rbd-droppable-id='droppable']/div"));
    private final Locator editColumnsSearchLeftList_Link = Locator.builder().withWeb(By.xpath("//label[@Class='w-full']"));
    private final Locator addNewRider_Btn = Locator.builder().withWeb(By.xpath("//button/p[text()='New ']"));
    private final Locator tabHeaderList_Lbl = Locator.builder().withWeb(By.xpath("//thead/tr/th[text()]"));
    private final Locator ridersTableRiderIdColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][1]"));
    private final Locator ridersTableRiderNameColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][2]/p"));
    private final Locator ridersTablePhoneNumberColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][3]"));
    private final Locator ridersTableStatusColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][4]"));
    private final Locator ridersTableEditColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][6]"));
    private final Locator ridersTableTeamsColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][5]"));
    private final Locator paginationDropdown_Btn = Locator.builder().withWeb(By.xpath(" //li/div/div[@class='ant-select-selector']"));
    private final Locator paginationSelectedItem_Lbl = Locator.builder().withWeb(By.xpath("//div[contains(@class,'pagination')]//span[@title]"));
    private final Locator paginationPerPageOptionsList_Lbl = Locator.builder().withWeb(By.xpath("//div[contains(text(),' / page')]"));
    private final Locator paginationBlockList_Lbl = Locator.builder().withWeb(By.xpath("//li[contains(@class,'pagination-item')]"));
    private final Locator moreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label = Locator.builder().withWeb(By.xpath("//div[@data-rbd-droppable-id='droppable']/div/div/p"));
    private final Locator next_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Next']"));
    private final Locator previous_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Prev']"));
    private final Locator edit_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Edit']"));
    private final Locator status_RadioBtn = Locator.builder().withWeb(By.xpath("//label[@class='ant-radio-wrapper']/span[2]"));
    private final Locator tableDataRiderId_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]//td[2]"));
    private final Locator tableDataRiderName_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]//td[3]"));
    private final Locator tableData_CheckBox = Locator.builder().withWeb(By.xpath("//td//label[@class='ant-checkbox-wrapper']"));
    private final Locator changeStatus_Btn = Locator.builder().withWeb(By.xpath("//button//p[text()='Change Status']"));
    private final Locator changeStatusHeader_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Change Status'])[2]"));
    private final Locator state_TextBox = Locator.builder().withWeb(By.xpath("//p[text()='State']/..//span[text()]"));
    private final Locator stateHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='State']"));
    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='State']/../parent::div/following-sibling::div/button/p[text()='Cancel']"));
    private final Locator save_Btn = Locator.builder().withWeb(By.xpath("//p[text()='State']/../parent::div/following-sibling::div/button/p[text()='Save']"));
    private final Locator paginationPage5Block_Btn = Locator.builder().withWeb(By.xpath("//li[@title='5']/p"));
    private final Locator paginationPrevious5Pages_Btn = Locator.builder().withWeb(By.xpath("//li[@title='Previous 5 Pages']//a"));
    private final Locator paginationNext5Pages_Btn = Locator.builder().withWeb(By.xpath("//li[@title='Next 5 Pages']//a"));
    private final Locator teams_List = Locator.builder().withWeb(By.xpath("//div//label[@role='none']/p"));
    private final Locator selectState_DropDown = Locator.builder().withWeb(By.xpath("//div[@class='ant-select-item ant-select-item-option']/."));
    private final Locator ridersTableCheckBoxList_Link = Locator.builder().withWeb(By.xpath("//input[@class='ant-checkbox-input']/.."));
    private final Locator tableDataRiderStatus_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]//td[5]"));
    private final Locator tableDataEdit_Link = Locator.builder().withWeb(By.xpath("(//p[text()='Edit'])[1]"));
    private final Locator teamSelector_Dropdown = Locator.builder().withWeb(By.xpath("(//span[@class='ant-select-selection-search']/following-sibling::span)[1]"));
    private final Locator teamSelect_List = Locator.builder().withWeb(By.xpath("//div[@class='ant-select-item-option-content']"));
    private final Locator tableDataCheckBox_Checked = Locator.builder().withWeb(By.xpath("//span[@class='ant-checkbox ant-checkbox-checked']"));
    private final Locator selectAll_CheckBox = Locator.builder().withWeb(By.xpath("//span[@class='select-all']"));

    public static RidersPage getInstance() {
        if (_instance == null)
            _instance = new RidersPage();
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        return ActionHelper.isPresent(header_Lbl);
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

    public String getText_RidersHeader_Lbl() {
        return ActionHelper.getText(header_Lbl);
    }

    public List<String> getText_TableHeaderList_Lbl() {
        return Utility.getSortedListOfText_ListOfWebElementsWhileScrollingUsingJS(tabHeaderList_Lbl.getBy());
    }

    public boolean isPresent_Search_Bar() {
        ActionHelper.waitForLoaderToHide();
        return ActionHelper.isPresent(search_Bar);
    }

    public void fillWithClear_SearchBar_Bar(String input) {
        ActionHelper.fillWithClear(search_Bar.getBy(), input);
    }

    public boolean isPresent_RidersTableRiderNameColumnList_Link() {
        return ActionHelper.isPresent(ridersTableRiderNameColumnList_Link);
    }

    public int getSize_RidersTableRiderNameColumnList_Link() {
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        ActionHelper.waitUntilAllElementsVisible(ridersTableRiderNameColumnList_Link.getBy());
        List<WebElement> allLeftRecord = ActionHelper.findElements(ridersTableRiderNameColumnList_Link);
        return allLeftRecord.size();
    }

    public boolean isPresent_RidersTableRiderIdColumnList_Link() {
        return ActionHelper.isPresent(ridersTableRiderIdColumnList_Link);
    }

    public int getSize_RidersTableRiderIdColumnList_Link() {
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        ActionHelper.waitUntilAllElementsVisible(ridersTableRiderIdColumnList_Link.getBy());
        List<WebElement> allLeftRecord = ActionHelper.findElements(ridersTableRiderIdColumnList_Link);
        return allLeftRecord.size();
    }

    public boolean isPresent_RidersTablePhoneNumberColumnList_Link() {
        return ActionHelper.isPresent(ridersTablePhoneNumberColumnList_Link);
    }

    public int getSize_RidersTablePhoneNumberColumnList_Link() {
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        ActionHelper.waitUntilAllElementsVisible(ridersTablePhoneNumberColumnList_Link.getBy());
        List<WebElement> allLeftRecord = ActionHelper.findElements(ridersTablePhoneNumberColumnList_Link);
        return allLeftRecord.size();
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

    public boolean isEnabled_StatusDropDownAvailableValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownAvailableValue_Radio.getBy(), Constants.WAIT_FOR_FIVE_SECOND);
    }

    public void click_StatusDropDownAvailableValue_Radio() {
        Utility.clickRadio(statusDropDownAvailableValue_Radio.getBy());
        ActionHelper.waitForLoaderToHide();
    }

    public boolean isEnabled_StatusDropDownBusyValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownBusyValue_Radio.getBy(), Constants.WAIT_FOR_TWO_SECOND);
    }

    public void click_StatusDropDownBusyValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownBusyValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isEnabled_StatusDropDownUnAvailableValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownUnAvailableValue_Radio.getBy(), Constants.WAIT_FOR_TWO_SECOND);
    }

    public void click_StatusDropDownUnAvailableValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownUnAvailableValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isEnabled_StatusDropDownTerminalValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownTerminalValue_Radio.getBy(), Constants.WAIT_FOR_TWO_SECOND);
    }

    public void click_StatusDropDownTerminalValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownTerminalValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isEnabled_StatusDropDownAllocatedValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownAllocatedValue_Radio.getBy(), Constants.WAIT_FOR_TWO_SECOND);
    }

    public void click_StatusDropDownAllocatedValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownAllocatedValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isEnabled_StatusDropDownInActiveValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownInactiveValue_Radio.getBy(), Constants.WAIT_FOR_TWO_SECOND);
    }

    public void click_StatusDropDownInActiveValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownInactiveValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isEnabled_StatusDropDownDeBoardingValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownDeboardingValue_Radio.getBy(), Constants.WAIT_FOR_TWO_SECOND);
    }

    public void click_StatusDropDownDeBoardingValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownDeboardingValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isEnabled_StatusDropDownOnboardingValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownOnboardingValue_Radio.getBy(), Constants.WAIT_FOR_TWO_SECOND);
    }

    public void click_StatusDropDownOnboardingValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownOnboardingValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isPresent_StatusDropDownClearSelection_Btn() {
        return ActionHelper.isPresent(statusDropDownClearSelection_Btn, Constants.WAIT_FOR_TWO_SECOND);
    }

    public void click_StatusDropDownClearSelection_Btn() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownClearSelection_Btn);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isPresent_Teams_DropDown() {
        return ActionHelper.isPresent(teams_DropDown);
    }

    public boolean isPresent_MoreActions_Btn() {
        return ActionHelper.isPresent(moreActions_DropDown);
    }

    public void click_MoreActions_Btn() {
        ActionHelper.click(moreActions_DropDown);
    }

    public boolean isPresent_ExportCSV_Btn() {
        return ActionHelper.isPresent(exportCSV_Btn);
    }

    public String getText_ExportCSV_Btn() {
        return ActionHelper.getText(exportCSV_Btn);
    }

    public void click_ExportCSV_Btn() {
        ActionHelper.click(exportCSV_Btn);
    }

    public boolean isPresent_NewRider_Btn() {
        return ActionHelper.isPresent(addNewRider_Btn);
    }

    public void click_NewRider_Btn() {
        ActionHelper.click(addNewRider_Btn);
    }

    public void click_Next_Btn() {
        CommonActions.getInstance().waitTillLoaderDisappears();
        ActionHelper.click(next_Btn);
    }

    public void click_Previous_Btn() {
        CommonActions.getInstance().waitTillLoaderDisappears();
        ActionHelper.click(previous_Btn);
    }

    public boolean isPresent_TableActions_DropDown() {
        return ActionHelper.isPresent(moreActions_DropDown);
    }

    public void click_MoreActions_DropDown() {
        ActionHelper.click(moreActions_DropDown);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsLinkSelectAll_Btn() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkSelectAll_Btn);
    }

    public void click_MoreActionsDropDownModifyColumnsLinkSelectAll_Btn() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkSelectAll_Btn);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsLinkSave_Btn() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkSave_Btn, Constants.WAIT_FOR_TWO_SECOND);
    }

    public void click_MoreActionsDropDownModifyColumnsLinkSave_Btn() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkSave_Btn);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsLinkCancel_Btn() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkCancel_Btn, Constants.WAIT_FOR_TWO_SECOND);
    }

    public void click_MoreActionsDropDownModifyColumnsLinkCancel_Btn() {
        ActionHelper.waitUntilElementClickable(moreActionsDropDownModifyColumnsLinkCancel_Btn);
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsStatusCross_Icon() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsStatusCross_Icon, Constants.WAIT_FOR_TWO_SECOND);
    }

    public void click_MoreActionsDropDownModifyColumnsStatusCross_Icon() {
        ActionHelper.click(moreActionsDropDownModifyColumnsStatusCross_Icon);
    }

    public List<String> getText_TabHeaderList_Lbl() {
        return Utility.getText_ListOfWebElements(tabHeaderList_Lbl.getBy());
    }

    public boolean isPresent_ModifyColumns_Btn() {
        return ActionHelper.isPresent(modifyColumns_Btn);
    }

    public String getText_ModifyColumns_Btn() {
        return ActionHelper.getText(modifyColumns_Btn);
    }

    public void click_ModifyColumns_Btn() {
        ActionHelper.click(modifyColumns_Btn);
    }

    public boolean isPresent_EditColumnsHeader_Lbl() {
        ActionHelper.waitForLoaderToHide();
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkHeader_Lbl, Constants.WAIT_FOR_FIVE_SECOND);
    }

    public boolean isPresent_ModifyColumns_SearchBar() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkSearchBar_Txt);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumns_Link() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkHeader_Lbl);
    }

    public String getText_MoreActionsDropDownModifyColumns_Link() {
        return ActionHelper.getText(moreActionsDropDownModifyColumnsLinkHeader_Lbl);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsRiderName_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkRiderName_Checkbox);
    }

    public void click_MoreActionsDropDownModifyColumnsRiderName_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkRiderName_Checkbox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsRiderId_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkRiderId_Checkbox);
    }

    public void click_MoreActionsDropDownModifyColumnsRiderId_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkRiderId_Checkbox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsPhoneNumber_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkPhoneNumber_Checkbox);
    }

    public void click_MoreActionsDropDownModifyColumnsPhoneNumber_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkPhoneNumber_Checkbox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsStatus_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkStatus_Checkbox);
    }

    public void click_MoreActionsDropDownModifyColumnsStatus_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkStatus_Checkbox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsTeams_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkTeams_Checkbox);
    }

    public void click_MoreActionsDropDownModifyColumnsTeams_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkTeams_Checkbox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsCreatedAt_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkCreatedAt_Checkbox);
    }

    public void click_MoreActionsDropDownModifyColumnsCreatedAt_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkCreatedAt_Checkbox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsUpdatedAt_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkUpdatedAt_Checkbox);
    }

    public void click_MoreActionsDropDownModifyColumnsUpdatedAt_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkUpdatedAt_Checkbox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsCreatedBy_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkCreatedBy_Checkbox);
    }

    public void click_MoreActionsDropDownModifyColumnsCreatedBy_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkCreatedBy_Checkbox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsUpdatedBy_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkUpdatedBy_Checkbox);

    }

    public void click_MoreActionsDropDownModifyColumnsUpdatedBy_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkUpdatedBy_Checkbox);
    }

    public boolean isPresent_EmptyTable_Txt() {
        return ActionHelper.isPresent(emptyTable_Txt);
    }

    public String getText_EmptyTable_Txt() {
        return ActionHelper.getText(emptyTable_Txt);
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
        List<WebElement> statusRecord = ActionHelper.findElements(ridersTableStatusColumnList_Link);
        ArrayList<String> allStatus = new ArrayList<>();
        for (WebElement webElement : statusRecord) {
            allStatus.add(String.valueOf(webElement.getText()));
        }
        return allStatus;
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

    public void unCheck_EditColumnsRiderName_CheckBox() {
        ActionHelper.uncheckCheckbox(moreActionsDropDownModifyColumnsLinkRiderName_Checkbox.getBy());
    }

    public void unCheck_EditColumnsRiderId_CheckBox() {
        ActionHelper.uncheckCheckbox(moreActionsDropDownModifyColumnsLinkRiderId_Checkbox.getBy());
    }

    public void unCheck_EditColumnsStatus_CheckBox() {
        ActionHelper.uncheckCheckbox(moreActionsDropDownModifyColumnsLinkStatus_Checkbox.getBy());
    }

    public void unCheck_EditColumnsTeams_CheckBox() {
        ActionHelper.uncheckCheckbox(moreActionsDropDownModifyColumnsLinkTeams_Checkbox.getBy());
    }

    public void unCheck_EditColumnsPhoneNumber_CheckBox() {
        ActionHelper.uncheckCheckbox(moreActionsDropDownModifyColumnsLinkPhoneNumber_Checkbox.getBy());
    }

    public void unCheck_EditColumnsCreatedAt_CheckBox() {
        ActionHelper.uncheckCheckbox(moreActionsDropDownModifyColumnsLinkCreatedAt_Checkbox.getBy());
    }

    public void unCheck_EditColumnsUpdatedAt_CheckBox() {
        ActionHelper.uncheckCheckbox(moreActionsDropDownModifyColumnsLinkUpdatedAt_Checkbox.getBy());
    }

    public void unCheck_EditColumnsCreatedBy_CheckBox() {
        ActionHelper.uncheckCheckbox(moreActionsDropDownModifyColumnsLinkCreatedBy_Checkbox.getBy());
    }

    public void unCheck_EditColumnsUpdatedBy_CheckBox() {
        ActionHelper.uncheckCheckbox(moreActionsDropDownModifyColumnsLinkUpdatedBy_Checkbox.getBy());
    }

    public List<String> getText_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label() {
        return Utility.getText_ListOfWebElements(moreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label.getBy());
    }

    public void dragAndDrop_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label(int fromIndex,
                                                                                          int toIndex) {
        List<WebElement> elements = ActionHelper.findElements(moreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.clickAndHold(elements.get(fromIndex)).moveByOffset(-10, 0).moveToElement(elements.get(toIndex)).release().pause(Constants.WAIT_FOR_FIVE_SECOND).perform();
    }

    public void click_EditColumnsSelectAllWithSave_Btn() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkSelectAll_Btn);
        new Actions(DriverManager.getDriver()).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkSave_Btn);
    }

    public void clickAndChoose_MoreActionsDropDownMenuOptions_Btn(String menuItem) {
        Utility.select_FromDropDown_List(moreActions_DropDown.getBy(), modifyColumns_Btn.getBy(), menuItem);
    }

    public void fill_EditColumnsSearch_Txt(String input) {
        ActionHelper.fillWithClear(moreActionsDropDownModifyColumnsLinkSearchBar_Txt.getBy(), input);
    }

    public void choose_NoOfRecordsToBeDisplayed_PerPage(int no) {
        ActionHelper.click(paginationSelectedItem_Lbl);
        Utility.clickWebElementContainingText(ActionHelper.findElements(paginationPerPageOptionsList_Lbl), String.valueOf(no));
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public List<WebElement> getElements_RiderTableRiderIdColumnList_Link() {
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        return ActionHelper.findElements(ridersTableRiderIdColumnList_Link.getBy());
    }

    public boolean isPresent_Edit_Btn() {
        return ActionHelper.isPresent(edit_Btn);
    }

    public void click_Edit_Btn(int index) {
        ActionHelper.click(ActionHelper.findElements(edit_Btn).get(index));
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
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

    public void open_Status_DropDown() {
        ActionHelper.click(status_DropDown);
    }

    public String getText_TableDataRiderName_Lbl() {
        return ActionHelper.getText(tableDataRiderName_Lbl.getBy());
    }

    public void check_TableData_CheckBox(int index) {
        ActionHelper.waitUntilElementVisible(tableData_CheckBox.getBy());
        Utility.checkCheckbox(ActionHelper.findElements(tableData_CheckBox.getBy()).get(index));
    }

    public void uncheck_TableData_CheckBox(int index) {
        ActionHelper.waitUntilElementVisible(tableDataCheckBox_Checked.getBy());
        Utility.checkCheckbox(ActionHelper.findElements(tableDataCheckBox_Checked.getBy()).get(index));
    }

    public boolean isPresent_ChangeStatus_Btn() {
        return ActionHelper.isPresent(changeStatus_Btn);
    }

    public void click_ChangeStatus_Btn() {
        ActionHelper.click(changeStatus_Btn);
    }

    public boolean isPresent_ChangeStatusHeader_Lbl() {
        return ActionHelper.isPresent(changeStatusHeader_Lbl);
    }

    public String getText_ChangeStatusHeader_Lbl() {
        return ActionHelper.getText(changeStatusHeader_Lbl);
    }

    public boolean isPresent_Cancel_Btn() {
        return ActionHelper.isPresent(cancel_Btn);
    }

    public void click_Cancel_Btn() {
        ActionHelper.click(cancel_Btn);
    }

    public boolean isPresent_Save_Btn() {
        return ActionHelper.isPresent(save_Btn);
    }

    public void click_Save_Btn() {
        ActionHelper.click(save_Btn);
    }

    public boolean isEnabled_Save_Btn() {
        return ActionHelper.isEnabled(save_Btn.getBy());
    }

    public boolean isPresent_State_TextBox() {
        return ActionHelper.isPresent(state_TextBox);
    }

    public void getTxt_SelectState_DropDown(String state) {
        ActionHelper.click(state_TextBox);
    }

    public void click_PaginationPageFifthBlock_Btn() {
        ActionHelper.click(paginationPage5Block_Btn);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public void click_PaginationPreviousFivePages_Btn() {
        ActionHelper.click(paginationPrevious5Pages_Btn);
        ActionHelper.waitForLoaderToHide();
    }

    public void click_PaginationNextFivePages_Btn() {
        ActionHelper.click(paginationNext5Pages_Btn);
        ActionHelper.waitForLoaderToHide();
    }

    public void select_PaginationBlockList_Lbl(String pageNo) {
        for (WebElement element : ActionHelper.findElements(paginationBlockList_Lbl))
            if (element.getAttribute("title").equals(pageNo))
                ActionHelper.click(element);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public List<String> getText_TableDataRiderName_List() {
        ActionHelper.waitUntilElementVisible(ridersTableRiderNameColumnList_Link.getBy());
        return Utility.getText_ListOfWebElements(ridersTableRiderNameColumnList_Link.getBy());
    }

    public void click_Teams_CheckBox(String input) {
        open_Teams_DropDown();
        List<WebElement> list = ActionHelper.findElements(teams_List.getBy());
        for (WebElement element : list) {
            String statusTxt = element.getText();
            if (statusTxt.toLowerCase().contains(input.toLowerCase())) {
                Utility.clickRadio(element);
                break;
            }
        }
        CommonActions.getInstance().waitTillLoaderDisappears();
        close_Teams_DropDown();
    }

    private void close_Teams_DropDown() {
        ActionHelper.click(teams_DropDown);
    }

    private void open_Teams_DropDown() {
        ActionHelper.click(teams_DropDown);
    }

    public boolean isPresent_TableDataRiderName_Lbl() {
        return ActionHelper.isPresent(tableDataRiderName_Lbl);
    }

    public String getText_TableDataRiderId_Lbl() {
        return ActionHelper.getText(tableDataRiderId_Lbl.getBy());
    }

    public boolean isPresent_SelectState_DropDown(String state) {
        return ActionHelper.isPresent(selectState_DropDown);
    }

    public void fillWithClear_Search_Txt(String riderName) {
        ActionHelper.fillWithClear(search_Bar.getBy(), riderName);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public List<String> getTxt_RidersTableTeamsColumnList_Link() {
        ActionHelper.findElements(ridersTableTeamsColumnList_Link);
        return Utility.getText_ListOfWebElements(ridersTableTeamsColumnList_Link.getBy());
    }

    public void clickAndChoose_SelectStateDropDownMenuOptions_Btn(String menuItem) {
        click_CheckBoxChangeStatus_Btn();
        Utility.select_FromDropDown_List(state_TextBox.getBy(), selectState_DropDown.getBy(), menuItem);
        click_Save_Btn();
    }

    public void click_ridersTableCheckBoxList_Link() {
        ActionHelper.click(ridersTableCheckBoxList_Link);
    }

    public void click_CheckBoxChangeStatus_Btn() {
        click_ridersTableCheckBoxList_Link();
        click_ChangeStatus_Btn();
    }

    public int getSize_RidersTableRiderName() {
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        ActionHelper.waitUntilAllElementsVisible(tableDataRiderName_Lbl.getBy());
        return ActionHelper.findElements(tableDataRiderName_Lbl).size();
    }

    public void click_TableDataEdit_Link() {
        ActionHelper.waitUntilElementVisible(tableDataEdit_Link.getBy());
        ActionHelper.click(tableDataEdit_Link);
    }

    public List<String> get_RidersTeamList_Text() {
        ActionHelper.click(teams_DropDown);
        return Utility.getText_ListOfWebElements(teams_List.getBy());
    }

    public List<String> get_TeamList_Text() {
        ActionHelper.click(teamSelector_Dropdown);
        return Utility.getText_ListOfWebElements(teamSelect_List.getBy());
    }

    public void chooseAndCancel_SelectStateDropDownMenuOptions_Btn(String menuItem) {
        click_CheckBoxChangeStatus_Btn();
        Utility.select_FromDropDown_List(state_TextBox.getBy(), selectState_DropDown.getBy(), menuItem);
        click_Cancel_Btn();
    }

    public boolean isPresent_SelectAll_CheckBox() {
        return ActionHelper.isPresent(selectAll_CheckBox);
    }

    public void click_SelectAll_CheckBox() {
        ActionHelper.click(selectAll_CheckBox);
    }

    public boolean validateTeamsTableRecordEqualsToPerPaginationOptions() {
        ActionHelper.waitUntilAllElementsVisible(ridersTableRiderIdColumnList_Link.getBy());
        String getTextPaginationSelectedItem_Lbl[] = ActionHelper.findElement(paginationSelectedItem_Lbl).getText().split(" ");
        return (getElements_RiderTableRiderIdColumnList_Link().size() <= Integer.parseInt(getTextPaginationSelectedItem_Lbl[0]));
    }
}