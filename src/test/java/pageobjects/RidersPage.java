package pageobjects;

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
    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//p[@class='text-gray-900 text-3xl font-bold capitalize']"));
    private final Locator homeBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//p[@class='text-sm font-medium text-[#A3AAC2] hover:text-gray-700']"));
    private final Locator ridersBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//p[@class='text-sm font-medium text-labels hover:text-gray-700']"));
    private final Locator emptyTable_Txt = Locator.builder().withWeb(By.xpath("//div[@class='ant-table-expanded-row-fixed']//h3"));
    private final Locator search_Bar = Locator.builder().withWeb(By.xpath("//input[@id='search_ptp']"));
    private final Locator status_DropDown = Locator.builder().withWeb(By.xpath("//button/p[text()='Status']"));
    private final Locator dropDownList_Lbl = Locator.builder().withWeb(By.xpath("//div[@class='ant-select-item-option-content']"));
    private final Locator statusDropDownAvailableValue_Radio = Locator.builder().withWeb(By.xpath("//span[text()='Available']"));
    private final Locator statusDropDownBusyValue_Radio = Locator.builder().withWeb(By.xpath("//span[text()='Busy']"));
    private final Locator statusDropDownUnAvailableValue_Radio = Locator.builder().withWeb(By.xpath("//span[text()='Unavailable']"));
    private final Locator statusDropDownAllocatedValue_Radio = Locator.builder().withWeb(By.xpath("//span[text()='Allocated']"));
    private final Locator statusDropDownTerminalValue_Radio = Locator.builder().withWeb(By.xpath("//span[text()='Terminal']"));
    private final Locator statusDropDownDeboardingValue_Radio = Locator.builder().withWeb(By.xpath("//span[text()='Deboarding']"));
    private final Locator statusDropDownInactiveValue_Radio = Locator.builder().withWeb(By.xpath("//span[text()='Inactive']"));
    private final Locator statusDropDownOnboardingValue_Radio = Locator.builder().withWeb(By.xpath("//span[text()='Onboarding']"));
    private final Locator statusDropDownValueList_Lbl = Locator.builder().withWeb(By.xpath("//span[@class='ant-radio']/following-sibling::span"));
    private final Locator statusDropDownClearSelection_Btn = Locator.builder().withWeb(By.xpath("//button[p[text()='Clear Selection']]"));
    private final Locator teams_DropDown = Locator.builder().withWeb(By.xpath("(//p[@class='text-black text-sm font-medium'])[2]"));
    private final Locator teamsDropDownBengalur_Checkbox = Locator.builder().withWeb(By.xpath("//input[@id='teams:9b59bca6-57c7-4256-aa65-880616298a0e']"));
    private final Locator teamsDropDownTestAlpha_Checkbox = Locator.builder().withWeb(By.xpath("//input[@id='teams:eb3f5173-0e88-4cb2-9f35-dc0b3fb28099']"));
    private final Locator moreActions_DropDown = Locator.builder().withWeb(By.xpath("//button/p[text()='More Actions']"));
    private final Locator exportCSV_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Export as CSV']"));
    private final Locator modifyColumns_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Modify Columns']"));
    private final Locator moreActionsDropDownModifyColumnsLinkHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Edit Columns']"));
    private final Locator moreActionsDropDownModifyColumnsLinkSearchBar_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Search']"));
    private final Locator moreActionsDropDownModifyColumnsLinkSelectAll_Btn = Locator.builder().withWeb(By.xpath("//p[@class='text-indigo-600 text-xs font-medium']"));
    private final Locator moreActionsDropDownModifyColumnsLinkOptionsList_Label = Locator.builder().withWeb(By.xpath("//p[text()='Select All']/../../..//label/p"));
    private final Locator moreActionsDropDownModifyColumnsLinkRiderName_Checkbox = Locator.builder().withWeb(By.id("Rider Name"));
    private final Locator moreActionsDropDownModifyColumnsLinkRiderId_Checkbox = Locator.builder().withWeb(By.id("Rider Id"));
    private final Locator moreActionsDropDownModifyColumnsLinkStatus_Checkbox = Locator.builder().withWeb(By.id("Status"));
    private final Locator moreActionsDropDownModifyColumnsLinkPhoneNumber_Checkbox = Locator.builder().withWeb(By.id("Phone Number"));
    private final Locator moreActionsDropDownModifyColumnsLinkTeams_Checkbox = Locator.builder().withWeb(By.id("Teams"));
    private final Locator moreActionsDropDownModifyColumnsLinkCreatedAt_Checkbox = Locator.builder().withWeb(By.id("Created At"));
    private final Locator moreActionsDropDownModifyColumnsLinkCreatedBy_Checkbox = Locator.builder().withWeb(By.id("Created By"));
    private final Locator moreActionsDropDownModifyColumnsLinkUpdatedAt_Checkbox = Locator.builder().withWeb(By.id("Updated At"));
    private final Locator moreActionsDropDownModifyColumnsLinkUpdatedBy_Checkbox = Locator.builder().withWeb(By.id("Updated By"));
    private final Locator moreActionsDropDownModifyColumnsLinkSave_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Save']"));
    private final Locator moreActionsDropDownModifyColumnsLinkCancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']"));
    private final Locator moreActionsDropDownModifyColumnsLinkCross_Icon = Locator.builder().withWeb(By.xpath("//p[text()='Edit Columns']/following-sibling::*/*"));
    private final Locator moreActionsDropDownModifyColumnsStatusCross_Icon = Locator.builder().withWeb(By.xpath("//div[@data-rbd-drag-handle-draggable-id='Status']/button"));
    private final Locator editColumnsSearchRightList_Link = Locator.builder().withWeb(By.xpath("//div[@data-rbd-droppable-id='droppable']/div"));
    private final Locator editColumnsSearchLeftList_Link = Locator.builder().withWeb(By.xpath("//div[@class='space-y-4']/div[@class='flex space-x-2 items-center']"));
    private final Locator addNewRider_Btn = Locator.builder().withWeb(By.xpath("   //button/p[text()='New ']"));
    private final Locator tabHeaderList_Lbl = Locator.builder().withWeb(By.xpath("//thead/tr/th[text()]"));
    private final Locator ridersTableRiderIdColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][1]"));
    private final Locator ridersTableRiderNameColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][2]/p"));
    private final Locator ridersTablePhoneNumberColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][3]"));
    private final Locator ridersTableStatusColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][4]"));
    private final Locator ridersTableEditColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][5]"));
    private final Locator ridersTableTeamsColumnList_Link = Locator.builder().withWeb(By.xpath("//tr/td[@class='ant-table-cell'][6]"));
    private final Locator paginationDropdown_Btn = Locator.builder().withWeb(By.xpath(" //li/div/div[@class='ant-select-selector']"));
    private final Locator paginationSelectedItem_Lbl = Locator.builder().withWeb(By.xpath("//div[contains(@class,'pagination')]//span[@title]"));
    private final Locator paginationPerPageOptionsList_Lbl = Locator.builder().withWeb(By.xpath("//div[contains( text(), ' / page')]"));
    private final Locator paginationBlockList_Lbl = Locator.builder().withWeb(By.xpath("//li[contains(@class, 'pagination-item')]"));
    private final Locator paginationPage1Block_Btn = Locator.builder().withWeb(By.xpath("//li[@title='1']/p"));
    private final Locator paginationPage2Block_Btn = Locator.builder().withWeb(By.xpath("//li[@title='2']/p"));
    private final Locator paginationPage3Block_Btn = Locator.builder().withWeb(By.xpath("//li[@title='3']/p"));
    private final Locator moreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label = Locator.builder().withWeb(By.xpath("//div[@data-rbd-droppable-id='droppable']/div/div/p"));
    private final Locator next_Btn = Locator.builder().withWeb(By.xpath("//li[@title='Next Page']/p/p[text()='Next']"));
    private final Locator previous_Btn = Locator.builder().withWeb(By.xpath("//li[@title='Previous Page']/p/p[text()='Prev']"));
    private final Locator edit_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Edit']"));
    public static RidersPage getInstance() {
        if (_instance == null)
            _instance = new RidersPage();
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        ActionHelper.waitForLoaderToHide();
        return ActionHelper.isPresent(header_Lbl, 3000);
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
   public boolean isPresent_RidersTableRiderNameColumnList_Link(){
        return ActionHelper.isPresent(ridersTableRiderNameColumnList_Link);
   }
    public int getSize_RidersTableRiderNameColumnList_Link() {
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        ActionHelper.waitUntilAllElementsVisible(ridersTableRiderNameColumnList_Link.getBy());
        List<WebElement> allLeftRecord = ActionHelper.findElements(ridersTableRiderNameColumnList_Link);
        return allLeftRecord.size();
    }
    public boolean isPresent_RidersTableRiderIdColumnList_Link(){
        return ActionHelper.isPresent(ridersTableRiderIdColumnList_Link);
    }
    public int getSize_RidersTableRiderIdColumnList_Link() {
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        ActionHelper.waitUntilAllElementsVisible(ridersTableRiderIdColumnList_Link.getBy());
        List<WebElement> allLeftRecord = ActionHelper.findElements(ridersTableRiderIdColumnList_Link);
        return allLeftRecord.size();
    }
    public boolean isPresent_RidersTablePhoneNumberColumnList_Link(){
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

    public void click_Status_Btn() {
        ActionHelper.click(status_DropDown);
    }

    public boolean isEnabled_StatusDropDownAvailableValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownAvailableValue_Radio.getBy(), 2000);
    }

    public void click_StatusDropDownAvailableValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownAvailableValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isEnabled_StatusDropDownBusyValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownBusyValue_Radio.getBy(), 2000);
    }

    public void click_StatusDropDownBusyValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownBusyValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isEnabled_StatusDropDownUnAvailableValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownUnAvailableValue_Radio.getBy(), 2000);
    }

    public void click_StatusDropDownUnAvailableValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownUnAvailableValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isEnabled_StatusDropDownTerminalValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownTerminalValue_Radio.getBy(), 2000);
    }

    public void click_StatusDropDownTerminalValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownTerminalValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isEnabled_StatusDropDownAllocatedValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownAllocatedValue_Radio.getBy(), 2000);
    }

    public void click_StatusDropDownAllocatedValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownAllocatedValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isEnabled_StatusDropDownInActiveValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownInactiveValue_Radio.getBy(), 2000);
    }

    public void click_StatusDropDownInActiveValue_Radio() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(statusDropDownInactiveValue_Radio);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public boolean isEnabled_StatusDropDownDeBoardingValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownDeboardingValue_Radio.getBy(), 2000);
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

    public boolean isPresent_Teams_Btn() {
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

    public void click_Next_Btn() {
        ActionHelper.click(next_Btn);
    }

    public void click_Previous_Btn() {
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
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkSave_Btn, 2000);
    }

    public void click_MoreActionsDropDownModifyColumnsLinkSave_Btn() {
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkSave_Btn);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsLinkCancel_Btn() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkCancel_Btn, 2000);
    }

    public void click_MoreActionsDropDownModifyColumnsLinkCancel_Btn() {ActionHelper.waitUntilElementClickable(moreActionsDropDownModifyColumnsLinkCancel_Btn);
        //ActionHelper.click(moreActionsDropDownModifyColumnsLinkCancel_Btn);
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsStatusCross_Icon() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsStatusCross_Icon, 2000);
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
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsLinkHeader_Lbl);
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
        actions.clickAndHold(elements.get(fromIndex)).moveByOffset(-10, 0).moveToElement(elements.get(toIndex)).release().pause(5000).perform();
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

    public void chooseNoOfRecordsToBeDisplayedPerPage(int no) {
        ActionHelper.click(paginationSelectedItem_Lbl);
        Utility.clickWebElementContainingText(ActionHelper.findElements(paginationPerPageOptionsList_Lbl), String.valueOf(no));
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }
    public List<WebElement> getElements_RiderTableRiderIdColumnList_Link() {
        ActionHelper.waitUntilAllElementsVisible(ridersTableRiderIdColumnList_Link.getBy());
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        return ActionHelper.findElements(ridersTableRiderIdColumnList_Link.getBy());
    }
   public boolean isPresent_Edit_Btn(){
        return ActionHelper.isPresent(edit_Btn);
   }
   public void click_Edit_Btn(int index) {
        ActionHelper.click(ActionHelper.findElements(edit_Btn).get(index));
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }
}
