package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FacilitiesPage {
    private static FacilitiesPage _instance;
    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//div/p[text()='Facilities']"));
    private final Locator homeBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/']"));
    private final Locator facilitiesBreadCrumb_Link = Locator.builder().withWeb(By.id("/facilities"));
    private final Locator newFacility_Btn = Locator.builder().withWeb(By.xpath("//div[@class='flex space-x-4']//p"));
    private final Locator search_Txt = Locator.builder().withWeb(By.id("search_ptp"));
    private final Locator status_DropDown = Locator.builder().withWeb(By.xpath("//button/p[text()='Status']"));
    private final Locator statusDropDownOnboardingValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='onboarding:onboarding']"));
    private final Locator statusDropDownActiveValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='active:active']"));
    private final Locator statusDropDownPauseValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='active:pause']"));
    private final Locator statusDropDownDeboardValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='active:deboard']"));
    private final Locator statusDropDownInactiveValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='inactive:inactive']"));
    private final Locator statusDropDownTerminalValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='inactive:terminal']"));
    private final Locator statusDropDownClearSelection_Btn = Locator.builder().withWeb(By.xpath("//button/p[text()='Clear Selection']"));
    private final Locator moreActions_DropDown = Locator.builder().withWeb(By.xpath("//p[text()='More Actions']/.."));
    private final Locator moreActionsDropDownExportAsCSV_Link = Locator.builder().withWeb(By.xpath("//a[text()='Export as CSV']"));
    private final Locator moreActionsDropDownModifyColumns_Link = Locator.builder().withWeb(By.xpath("//a[text()='Modify Columns']"));

    private final Locator moreActionsDropDownModifyColumnHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Edit Columns']"));
    private final Locator moreActionsDropDownModifyColumnsSearch_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Search']"));
    private final Locator moreActionsDropDownModifyColumnsSelectAll_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Select All']"));
    private final Locator moreActionsDropDownModifyColumnFacilityId_CheckBox = Locator.builder().withWeb(By.id("Facility Id"));
    private final Locator moreActionsDropDownModifyColumnFacilityName_CheckBox = Locator.builder().withWeb(By.id("Facility Name"));
    private final Locator moreActionsDropDownModifyColumnStatus_CheckBox = Locator.builder().withWeb(By.id("Status"));
    private final Locator moreActionsDropDownModifyColumnAddress_CheckBox = Locator.builder().withWeb(By.id("Address"));
    private final Locator moreActionsDropDownModifyColumnCity_CheckBox = Locator.builder().withWeb(By.id("City"));
    private final Locator moreActionsDropDownModifyColumnState_CheckBox = Locator.builder().withWeb(By.id("State"));
    private final Locator moreActionsDropDownModifyColumnPostalCode_CheckBox = Locator.builder().withWeb(By.id("Postal Code"));
    private final Locator moreActionsDropDownModifyColumnCreatedAt_CheckBox = Locator.builder().withWeb(By.id("Created At"));
    private final Locator moreActionsDropDownModifyColumnUpdatedAt_CheckBox = Locator.builder().withWeb(By.id("Updated At"));
    private final Locator moreActionsDropDownModifyColumnCreatedBy_CheckBox = Locator.builder().withWeb(By.id("Created By"));
    private final Locator moreActionsDropDownModifyColumnUpdatedBy_CheckBox = Locator.builder().withWeb(By.id("Updated By"));
    private final Locator moreActionsDropDownModifyColumnDragOptionsList_Lbl = Locator.builder().withWeb(By.xpath("//div[@data-rbd-droppable-id='droppable']/div/div"));
    private final Locator moreActionsDropDownModifyColumnCheckBoxDataList_CheckBox = Locator.builder().withWeb(By.xpath("//div[@class='flex space-x-2 items-center']"));
    private final Locator moreActionDropDownModifyColumnCancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']"));
    private final Locator moreActionsDropDownModifyColumnSave_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Save']"));

    private final Locator tableColumnNames_Lbl = Locator.builder().withWeb(By.xpath("//th[@class='ant-table-cell']"));
    private final Locator tableColumnNameFacilityId_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Facility Id']"));
    private final Locator tableColumnNameFacilityName_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Facility Name']"));
    private final Locator tableColumnNameStatus_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Status']"));
    private final Locator tableColumnNameAddress_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Address']"));
    private final Locator tableColumnNameCity_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='City']"));
    private final Locator tableColumnNameState_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='State']"));
    private final Locator tableColumnNamePostalCode_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Postal Code']"));
    private final Locator tableColumnNameCreatedAt_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Created At']"));
    private final Locator tableColumnNameUpdatedAt_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Updated At']"));
    private final Locator tableColumnNameCreatedBy_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Created By']"));
    private final Locator tableColumnNameUpdatedBy_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Updated By']"));
    private final Locator tableData_CheckBox = Locator.builder().withWeb(By.xpath("(//tr[2]//span)[1]"));
    private final Locator tableDataCheckBox_List = Locator.builder().withWeb(By.xpath("//label[contains(@class,'ant-checkbox')]"));
    private final Locator tableDataEdit_Link = Locator.builder().withWeb(By.xpath("(//p[text()='Edit'])[1]"));
    private final Locator facilityTableFacilityIdList_Lbl = Locator.builder().withWeb(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//td[2]"));
    private final Locator deactivate_Btn = Locator.builder().withWeb(By.xpath("//div[@class='flex space-x-3']/button"));
    private final Locator deactivateFacilityHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Deactivate Facility']"));
    private final Locator deactivateFacilityCancel_Btn = Locator.builder().withWeb(By.xpath("//div[@class='w-full flex justify-center items-center scale-100']//p[text()='Cancel']"));
    private final Locator deactivateFacilityDeactivate_Btn = Locator.builder().withWeb(By.xpath("//button[@type='button']/p[text()='Deactivate']"));

    private final Locator userProfile_Btn = Locator.builder().withWeb(By.id("headlessui-menu-button-1"));
    private final Locator logout_Btn = Locator.builder().withWeb(By.id("headlessui-menu-item-15"));
    private final Locator status_RadioBtn = Locator.builder().withWeb(By.xpath("//label[@class='ant-radio-wrapper']/span[2]"));
    private final Locator tableColumnSelectAll_CheckBox = Locator.builder().withWeb(By.xpath("//th[@class='ant-table-cell ant-table-selection-column']"));
    String elementInFirstRow = "//tr[2]/td[index]";
    String elementColumnDataList = "//tr[@class='ant-table-row ant-table-row-level-0']//td[index]";

    public static FacilitiesPage getInstance() {
        if (_instance == null) _instance = new FacilitiesPage();
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        return ActionHelper.isPresent(header_Lbl);
    }

    public String getText_Header_Lbl() {
        return ActionHelper.getText(header_Lbl);
    }

    public boolean isPresent_HomeBreadCrumb_Link() {
        return ActionHelper.isPresent(homeBreadCrumb_Link);
    }

    public void click_HomeBreadCrumb_Link() {
        ActionHelper.click(homeBreadCrumb_Link);
    }

    public boolean isPresent_FacilitiesBreadCrumb_Link() {
        return ActionHelper.isPresent(facilitiesBreadCrumb_Link);
    }

    public void click_FacilitiesBreadCrumb_Link() {
        ActionHelper.click(facilitiesBreadCrumb_Link);
    }

    public boolean isPresent_NewFacility_Btn() {
        return ActionHelper.isPresent(newFacility_Btn);
    }

    public void click_NewFacility_Btn() {
        ActionHelper.click(newFacility_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_Search_Txt() {
        return ActionHelper.isPresent(search_Txt, 5000);
    }

    public void fill_Search_Txt(String facilityName) {
        ActionHelper.waitUntilElementVisible(search_Txt.getBy());
        ActionHelper.sendKeysWithClear(search_Txt.getBy(), facilityName);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_Status_DropDown() {
        return ActionHelper.isPresent(status_DropDown, 2000);
    }

    public void click_Status_DropDown() {
        ActionHelper.click(status_DropDown);
    }

    public boolean isEnabled_StatusDropDownOnboardingValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownOnboardingValue_Radio.getBy());
    }

    public void click_StatusDropDownOnboardingValue_Radio() {
        ActionHelper.click(statusDropDownOnboardingValue_Radio);
    }

    public boolean isEnabled_StatusDropDownActiveValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownActiveValue_Radio.getBy());
    }

    public void click_StatusDropDownActiveValue_Radio() {
        Utility.clickRadio(statusDropDownActiveValue_Radio.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isEnabled_StatusDropDownPauseValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownPauseValue_Radio.getBy());
    }

    public void click_StatusDropDownPauseValue_Radio() {
        Utility.clickRadio(statusDropDownPauseValue_Radio.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isEnabled_StatusDropDownDeboardValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownDeboardValue_Radio.getBy());
    }

    public void click_StatusDropDownDeboardValue_Radio() {
        Utility.clickRadio(statusDropDownDeboardValue_Radio.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isEnabled_StatusDropDownInactiveValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownInactiveValue_Radio.getBy());
    }

    public void click_StatusDropDownInactiveValue_Radio() {
        Utility.clickRadio(statusDropDownInactiveValue_Radio.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isEnabled_StatusDropDownTerminalValue_Radio() {
        return ActionHelper.isEnabled(statusDropDownTerminalValue_Radio.getBy());
    }

    public void click_StatusDropDownTerminalValue_Radio() {
        Utility.clickRadio(statusDropDownTerminalValue_Radio.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_StatusDropDownClearSelection_Btn() {
        return ActionHelper.isPresent(statusDropDownClearSelection_Btn, 5000);
    }

    public void click_StatusDropDownClearSelection_Btn() {
        ActionHelper.click(statusDropDownClearSelection_Btn);
    }

    public boolean isPresent_MoreActions_DropDown() {
        return ActionHelper.isPresent(moreActions_DropDown);
    }

    public void click_MoreActions_DropDown() {
        ActionHelper.click(moreActions_DropDown);
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

    public boolean isPresent_MoreActionsDropDownModifyColumnHeader_Lbl() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnHeader_Lbl);
    }

    public String getText_MoreActionsDropDownModifyColumnHeader_Lbl() {
        return ActionHelper.getText(moreActionsDropDownModifyColumnHeader_Lbl);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsSearch_Txt() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsSearch_Txt);
    }

    public void fill_MoreActionsDropDownModifyColumnsSearch_Txt(String tableColumnName) {
        ActionHelper.fillWithClear(moreActionsDropDownModifyColumnsSearch_Txt.getBy(), tableColumnName);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsSelectAll_Btn() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsSelectAll_Btn, 2000);
    }

    public void click_MoreActionsDropDownModifyColumnsSelectAll_Btn() {
        ActionHelper.click(moreActionsDropDownModifyColumnsSelectAll_Btn);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnFacilityId_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnFacilityId_CheckBox);
    }

    public void click_MoreActionsDropDownModifyColumnFacilityId_CheckBox() {
        Utility.checkCheckbox(moreActionsDropDownModifyColumnFacilityId_CheckBox.getBy());
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnFacilityName_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnFacilityName_CheckBox);
    }

    public void click_moreActionsDropDownModifyColumnFacilityName_CheckBox() {
        Utility.checkCheckbox(moreActionsDropDownModifyColumnFacilityName_CheckBox.getBy());
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnStatus_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnStatus_CheckBox);
    }

    public void click_MoreActionsDropDownModifyColumnStatus_CheckBox() {
        Utility.checkCheckbox(moreActionsDropDownModifyColumnStatus_CheckBox.getBy());
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnAddress_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnAddress_CheckBox);
    }

    public void click_moreActionsDropDownModifyColumnAddress_CheckBox() {
        Utility.checkCheckbox(moreActionsDropDownModifyColumnAddress_CheckBox.getBy());
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnCity_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnCity_CheckBox);
    }

    public void click_moreActionsDropDownModifyColumnCity_CheckBox() {
        Utility.checkCheckbox(moreActionsDropDownModifyColumnCity_CheckBox.getBy());
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnState_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnState_CheckBox);
    }

    public void click_moreActionsDropDownModifyColumnState_CheckBox() {
        Utility.checkCheckbox(moreActionsDropDownModifyColumnState_CheckBox.getBy());
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnPostalCode_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnPostalCode_CheckBox);
    }

    public void click_MoreActionsDropDownModifyColumnPostalCode_CheckBox() {
        Utility.checkCheckbox(moreActionsDropDownModifyColumnPostalCode_CheckBox.getBy());
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnCreatedAt_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnCreatedAt_CheckBox);
    }

    public void click_moreActionsDropDownModifyColumnCreatedAt_CheckBox() {
        Utility.checkCheckbox(moreActionsDropDownModifyColumnCreatedAt_CheckBox.getBy());
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnUpdatedAt_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnUpdatedAt_CheckBox);
    }

    public void click_MoreActionsDropDownModifyColumnUpdatedAt_CheckBox() {
        Utility.checkCheckbox(moreActionsDropDownModifyColumnUpdatedAt_CheckBox.getBy());
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnCreatedBy_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnCreatedBy_CheckBox);
    }

    public void click_MoreActionsDropDownModifyColumnCreatedBy_CheckBox() {
        Utility.checkCheckbox(moreActionsDropDownModifyColumnCreatedBy_CheckBox.getBy());
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnUpdatedBy_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnUpdatedBy_CheckBox);
    }

    public void click_MoreActionsDropDownModifyColumnUpdatedBy_CheckBox() {
        Utility.checkCheckbox(moreActionsDropDownModifyColumnUpdatedBy_CheckBox.getBy());
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnDragOptionsList_Lbl() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnDragOptionsList_Lbl);
    }

    public List<String> getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl() {
        return Utility.getText_ListOfWebElements(moreActionsDropDownModifyColumnDragOptionsList_Lbl.getBy());
    }

    public void dragAndDrop_MoreActionsDropDownModifyColumnDragOptionsList_Lbl(int fromIndex, int toIndex) {
        List<WebElement> elements = ActionHelper.findElements(moreActionsDropDownModifyColumnDragOptionsList_Lbl);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.clickAndHold(elements.get(fromIndex)).moveByOffset(-10, 0).moveToElement(elements.get(toIndex)).release().pause(5000).perform();
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnCheckBoxDataList_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnCheckBoxDataList_CheckBox);
    }

    public boolean isPresent_MoreActionDropDownModifyColumnCancel_Btn() {
        return ActionHelper.isPresent(moreActionDropDownModifyColumnCancel_Btn);
    }

    public void click_MoreActionDropDownModifyColumnCancel_Btn() {
        ActionHelper.click(moreActionDropDownModifyColumnCancel_Btn);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnSave_Btn() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnSave_Btn);
    }

    public void click_MoreActionsDropDownModifyColumnSave_Btn() {
        ActionHelper.click(moreActionsDropDownModifyColumnSave_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_TableColumnNames_List() {
        return ActionHelper.isPresent(tableColumnNames_Lbl);
    }

    public List<String> getText_TableColumnNames_List() {
        return Utility.getText_ListOfWebElements(tableColumnNames_Lbl.getBy());
    }

    public boolean isPresent_TableColumnNameFacilityId_Lbl() {
        return ActionHelper.isPresent(tableColumnNameFacilityId_Lbl);
    }

    public String getText_TableColumnNameFacilityId_Lbl() {
        return ActionHelper.getText(tableColumnNameFacilityId_Lbl);
    }

    public boolean isPresent_TableColumnNameFacilityName_Lbl() {
        return ActionHelper.isPresent(tableColumnNameFacilityName_Lbl);
    }

    public String getText_TableColumnNameFacilityName_Lbl() {
        return ActionHelper.getText(tableColumnNameFacilityName_Lbl);
    }

    public boolean isPresent_TableColumnNameStatus_Lbl() {
        return ActionHelper.isPresent(tableColumnNameStatus_Lbl);
    }

    public String getText_TableColumnNameStatus_Lbl() {
        return ActionHelper.getText(tableColumnNameStatus_Lbl);
    }

    public boolean isPresent_TableColumnNameAddress_Lbl() {
        return ActionHelper.isPresent(tableColumnNameAddress_Lbl);
    }

    public String getText_TableColumnNameAddress_Lbl() {
        return ActionHelper.getText(tableColumnNameAddress_Lbl);
    }

    public boolean isPresent_TableColumnNameCity_Lbl() {
        return ActionHelper.isPresent(tableColumnNameCity_Lbl);
    }

    public String getText_TableColumnNameCity_Lbl() {
        return ActionHelper.getText(tableColumnNameCity_Lbl);
    }

    public boolean isPresent_TableColumnNameState_Lbl() {
        return ActionHelper.isPresent(tableColumnNameState_Lbl);
    }

    public boolean isPresent_TableColumnNamePostalCode_Lbl() {
        return ActionHelper.isPresent(tableColumnNamePostalCode_Lbl);
    }

    public boolean isPresent_TableColumnNameCreatedAt_Lbl() {
        return ActionHelper.isPresent(tableColumnNameCreatedAt_Lbl);
    }

    public boolean isPresent_TableColumnNameUpdatedAt_Lbl() {
        return ActionHelper.isPresent(tableColumnNameUpdatedAt_Lbl);
    }

    public boolean isPresent_TableColumnNameCreatedBy_Lbl() {
        return ActionHelper.isPresent(tableColumnNameCreatedBy_Lbl);
    }

    public boolean isPresent_TableColumnNameUpdatedBy_Lbl() {
        return ActionHelper.isPresent(tableColumnNameUpdatedBy_Lbl);
    }

    public boolean isPresent_TableData_CheckBox() {
        return ActionHelper.isPresent(tableData_CheckBox);
    }

    public void click_TableData_CheckBox() {
        if (!isChecked_FirstData_CheckBox())
            Utility.checkCheckbox(tableData_CheckBox.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_TableDataEdit_Link() {
        return ActionHelper.isPresent(tableDataEdit_Link);
    }

    public void click_TableDataEdit_Link() {
        ActionHelper.waitUntilElementVisible(tableDataEdit_Link.getBy());
        ActionHelper.click(tableDataEdit_Link);
    }

    public List<WebElement> getList_FacilityTableFacilityId_Lbl() {
        return ActionHelper.findElements(facilityTableFacilityIdList_Lbl.getBy());
    }

    public boolean isPresent_Deactivate_Btn() {
        return ActionHelper.isPresent(deactivate_Btn, 2000);
    }

    public void click_Deactivate_Btn() {
        ActionHelper.click(deactivate_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_DeactivateFacilityHeader_Lbl() {
        return ActionHelper.isPresent(deactivateFacilityHeader_Lbl, 2000);
    }

    public String getText_DeactivateFacilityHeader_Lbl() {
        return ActionHelper.getText(deactivateFacilityHeader_Lbl);
    }

    public boolean isPresent_DeactivateFacilityCancel_Btn() {
        return ActionHelper.isPresent(deactivateFacilityCancel_Btn);
    }

    public void click_DeactivateFacilityCancel_Btn() {
        ActionHelper.click(deactivateFacilityCancel_Btn);
    }

    public boolean isPresent_DeactivateFacilityDeactivate_Btn() {
        return ActionHelper.isPresent(deactivateFacilityDeactivate_Btn, 2000);
    }

    public void click_DeactivateFacilityDeactivate_Btn() {
        ActionHelper.click(deactivateFacilityDeactivate_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_UserProfile_Btn() {
        return ActionHelper.isPresent(userProfile_Btn);
    }

    public void click_UserProfile_Btn() {
        ActionHelper.click(userProfile_Btn);
    }

    public boolean isPresent_Logout_Btn() {
        return ActionHelper.isPresent(logout_Btn);
    }

    public void click_Logout_Btn() {
        ActionHelper.click(logout_Btn);
    }

    public HashMap<String, String> getData_TableFirstData_List() {
        HashMap<String, String> tableData = new HashMap<>();
        String facilityId = getText_TableData_Lbl("FACILITY ID");
        String facilityName = getText_TableData_Lbl("FACILITY NAME");
        String postalCode = getText_TableData_Lbl("POSTAL CODE"); /*getText_TableDataPostalCode_Lbl()*/
        ;
        String address = getText_TableData_Lbl("ADDRESS");
        String city = getText_TableData_Lbl("CITY");
        String state = getText_TableData_Lbl("STATE");

        tableData.put("facilityId", facilityId);
        tableData.put("facilityName", facilityName);
        tableData.put("postalCode", postalCode);
        tableData.put("address", address);
        tableData.put("city", city);
        tableData.put("state", state);

        return tableData;
    }

    public void click_Status_RadioBtn(String input) {
        ActionHelper.click(status_DropDown);
        List<WebElement> list = ActionHelper.findElements(status_RadioBtn.getBy());
        for (WebElement element : list) {
            String statusTxt = element.getText();
            if (statusTxt.toLowerCase().contains(input.toLowerCase())) {
                Utility.clickRadio(element);
                break;
            }
        }
        ActionHelper.click(status_DropDown);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isChecked_FirstData_CheckBox() {
        return Utility.isChecked_Input_CheckBox(tableData_CheckBox.getBy());
    }

    public void click_TableDataToUnCheck_CheckBox() {
        if (isChecked_FirstData_CheckBox())
            Utility.checkCheckbox(tableData_CheckBox.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_TableColumnSelectAll_CheckBox() {
        return ActionHelper.isPresent(tableColumnSelectAll_CheckBox);
    }

    public void check_TableColumnSelectAll_CheckBox() {
        Utility.checkCheckbox(tableColumnSelectAll_CheckBox.getBy());
    }

    public List<String> getClass_CheckBox_List() {
        List<WebElement> element = ActionHelper.findElements(By.xpath("//label[contains(@class,'ant-checkbox')]"));
        List<String> classList = new ArrayList<>(element.size());
        for (int i = 0; i < element.size(); i++) {
            classList.add(element.get(i).getAttribute("class"));
        }
        return classList;
    }

    public int indexOfTableColumnName(String input) {
        int index = 0;
        List<WebElement> columName = ActionHelper.findElements(By.xpath("//tr[1]/th"));
        for (WebElement element : columName) {
            if (element.getText().equals(input)) {
                index = columName.indexOf(element);
                break;
            }
        }
        return index + 1;
    }

    public String getText_TableData_Lbl(String tableColumnName) {
        String index = String.valueOf(indexOfTableColumnName(tableColumnName));
        Locator data = Locator.builder().withWeb(By.xpath(elementInFirstRow.replace("index", index)));
        return ActionHelper.getText(data);
    }

    public List<String> getList_TableDataList_Lbl(String tableColumnName) {
        String index = String.valueOf(indexOfTableColumnName(tableColumnName));
        Locator data = Locator.builder().withWeb(By.xpath(elementColumnDataList.replace("index", index)));
        return Utility.getText_ListOfWebElements(ActionHelper.findElements(data));
    }

    public boolean isPresent_TableData_Lbl(String tableColumnName) {
        String index = String.valueOf(indexOfTableColumnName(tableColumnName));
        Locator data = Locator.builder().withWeb(By.xpath(elementInFirstRow.replace("index", index)));
        return ActionHelper.isPresent(data);
    }
}
