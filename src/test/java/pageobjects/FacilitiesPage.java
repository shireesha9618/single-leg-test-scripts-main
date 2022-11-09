package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class FacilitiesPage {
    private static FacilitiesPage _instance;
    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//div[@class='flex justify-between']/p"));
    private final Locator homeBreadCrumb_Link = Locator.builder().withWeb(By.xpath("homeBreadCrumb_Link"));
    private final Locator facilitiesBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/facilities']"));
    private final Locator newFacility_Btn = Locator.builder().withWeb(By.xpath("//div[@class='flex space-x-4']//p"));
    private final Locator search_Txt = Locator.builder().withWeb(By.id("search_ptp"));
    private final Locator status_DropDown = Locator.builder().withWeb(By.xpath("//button/p[text()='Status']"));
    private final Locator statusDropDownOnboardingValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='onboarding:onboarding']"));
    private final Locator statusDropDownActiveValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='active:active']"));
    private final Locator statusDropDownPauseValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='active:pause']"));
    private final Locator statusDropDownDeboardValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='active:deboard']"));
    private final Locator statusDropDownInactiveValue_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='inactive:inactive']"));
    private final Locator statusDropDownClearSelection_Btn = Locator.builder().withWeb(By.xpath("//button[p[text()='Clear Selection']]"));
    private final Locator moreActions_DropDown = Locator.builder().withWeb(By.xpath("//button/p[text()='More Actions']"));
    private final Locator moreActionsDropDownExportAsCSV_Link = Locator.builder().withWeb(By.xpath("//a[text()='Export as CSV']"));
    private final Locator moreActionsDropDownModifyColumns_Link = Locator.builder().withWeb(By.xpath("//a[text()='Modify Columns']"));

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
    private final Locator moreActionDropDownModifyColumnCancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']"));
    private final Locator moreActionsDropDownModifyColumnSave_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Save']"));

    private final Locator tableColumnNameFacilityId = Locator.builder().withWeb(By.xpath("//th[text()='Facility Id']"));
    private final Locator tableColumnNameFacilityName = Locator.builder().withWeb(By.xpath("//th[text()='Facility Name']"));
    private final Locator tableColumnNameStatus = Locator.builder().withWeb(By.xpath("//th[text()='Status']"));
    private final Locator tableColumnNameAddress = Locator.builder().withWeb(By.xpath("//th[text()='Address']"));
    private final Locator tableColumnNameCity = Locator.builder().withWeb(By.xpath("//th[text()='City']"));
    private final Locator tableColumnNameState = Locator.builder().withWeb(By.xpath("//th[text()='State']"));
    private final Locator tableColumnNamePostalCode = Locator.builder().withWeb(By.xpath("//th[text()='Postal Code']"));
    private final Locator tableData_CheckBox = Locator.builder().withWeb(By.xpath("//tr[2]/td[1]"));
    private final Locator tableDataEdit_Link = Locator.builder().withWeb(By.xpath("(//p[text()='Edit'])[1]"));
    private final Locator prev_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Prev']"));
    private final Locator next_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Next']"));

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
    }

    public boolean isPresent_Search_Txt() {
        return ActionHelper.isPresent(search_Txt);
    }

    public void fill_Search_Txt(String facilityName) {
        ActionHelper.fillWithClear(search_Txt.getBy(), facilityName);
    }

    public boolean isPresent_Status_DropDown() {
        return ActionHelper.isPresent(status_DropDown);
    }

    public void click_Status_DropDown() {
        ActionHelper.click(status_DropDown);
    }

    public boolean isPresent_StatusDropDownOnboardingValue_Radio() {
        return ActionHelper.isPresent(statusDropDownOnboardingValue_Radio);
    }

    public void click_StatusDropDownOnboardingValue_Radio() {
        ActionHelper.click(statusDropDownOnboardingValue_Radio);
    }

    public boolean isPresent_StatusDropDownActiveValue_Radio() {
        return ActionHelper.isPresent(statusDropDownActiveValue_Radio);
    }

    public void click_StatusDropDownActiveValue_Radio() {
        ActionHelper.click(statusDropDownActiveValue_Radio);
    }

    public boolean isPresent_StatusDropDownPauseValue_Radio() {
        return ActionHelper.isPresent(statusDropDownPauseValue_Radio);
    }

    public void click_StatusDropDownPauseValue_Radio() {
        ActionHelper.click(statusDropDownPauseValue_Radio);
    }

    public boolean isPresent_StatusDropDownDeboardValue_Radio() {
        return ActionHelper.isPresent(statusDropDownDeboardValue_Radio);
    }

    public void click_StatusDropDownDeboardValue_Radio() {
        ActionHelper.click(statusDropDownDeboardValue_Radio);
    }

    public boolean isPresent_StatusDropDownInactiveValue_Radio() {
        return ActionHelper.isPresent(statusDropDownInactiveValue_Radio);
    }

    public void click_StatusDropDownInactiveValue_Radio() {
        ActionHelper.click(statusDropDownInactiveValue_Radio);
    }

    public boolean isPresent_StatusDropDownClearSelection_Btn() {
        return ActionHelper.isPresent(statusDropDownClearSelection_Btn);
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

    public boolean isPresent_MoreActionsDropDownModifyColumnsSearch_Txt() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsSearch_Txt);
    }

    public void fill_MoreActionsDropDownModifyColumnsSearch_Txt(String tableColumnName) {
        ActionHelper.fill(moreActionsDropDownModifyColumnsSearch_Txt, tableColumnName);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnsSelectAll_Btn() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnsSelectAll_Btn);
    }

    public void click_MoreActionsDropDownModifyColumnsSelectAll_Btn() {
        ActionHelper.click(moreActionsDropDownModifyColumnsSelectAll_Btn);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnFacilityId_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnFacilityId_CheckBox);
    }

    public void click_MoreActionsDropDownModifyColumnFacilityId_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnFacilityId_CheckBox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnFacilityName_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnFacilityName_CheckBox);
    }

    public void click_moreActionsDropDownModifyColumnFacilityName_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnFacilityName_CheckBox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnStatus_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnStatus_CheckBox);
    }

    public void click_MoreActionsDropDownModifyColumnStatus_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnStatus_CheckBox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnAddress_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnAddress_CheckBox);
    }

    public void click_moreActionsDropDownModifyColumnAddress_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnAddress_CheckBox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnCity_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnCity_CheckBox);
    }

    public void click_moreActionsDropDownModifyColumnCity_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnCity_CheckBox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnState_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnState_CheckBox);
    }

    public void click_moreActionsDropDownModifyColumnState_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnState_CheckBox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnPostalCode_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnPostalCode_CheckBox);
    }

    public void click_MoreActionsDropDownModifyColumnPostalCode_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnPostalCode_CheckBox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnCreatedAt_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnCreatedAt_CheckBox);
    }

    public void click_moreActionsDropDownModifyColumnCreatedAt_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnCreatedAt_CheckBox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnUpdatedAt_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnUpdatedAt_CheckBox);
    }

    public void click_MoreActionsDropDownModifyColumnUpdatedAt_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnUpdatedAt_CheckBox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnCreatedBy_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnCreatedBy_CheckBox);
    }

    public void click_MoreActionsDropDownModifyColumnCreatedBy_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnCreatedBy_CheckBox);
    }

    public boolean isPresent_MoreActionsDropDownModifyColumnUpdatedBy_CheckBox() {
        return ActionHelper.isPresent(moreActionsDropDownModifyColumnUpdatedBy_CheckBox);
    }

    public void click_MoreActionsDropDownModifyColumnUpdatedBy_CheckBox() {
        ActionHelper.click(moreActionsDropDownModifyColumnUpdatedBy_CheckBox);
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
    }

    public boolean isPresent_TableColumnNameFacilityId() {
        return ActionHelper.isPresent(tableColumnNameFacilityId);
    }

    public boolean isPresent_TableColumnNameFacilityName() {
        return ActionHelper.isPresent(tableColumnNameFacilityName);
    }

    public boolean isPresent_TableColumnNameStatus() {
        return ActionHelper.isPresent(tableColumnNameStatus);
    }

    public boolean isPresent_TableColumnNameAddress() {
        return ActionHelper.isPresent(tableColumnNameAddress);
    }

    public boolean isPresent_TableColumnNameCity() {
        return ActionHelper.isPresent(tableColumnNameCity);
    }

    public boolean isPresent_TableColumnNameState() {
        return ActionHelper.isPresent(tableColumnNameState);
    }

    public boolean isPresent_TableColumnNamePostalCode() {
        return ActionHelper.isPresent(tableColumnNamePostalCode);
    }

    public boolean isPresent_TableData_CheckBox() {
        return ActionHelper.isPresent(tableData_CheckBox);
    }

    public void click_TableData_CheckBox() {
        ActionHelper.click(tableData_CheckBox);
    }

    public boolean isPresent_TableDataEdit_Link() {
        return ActionHelper.isPresent(tableDataEdit_Link);
    }

    public void click_TableDataEdit_Link() {
        ActionHelper.click(tableDataEdit_Link);
    }

    public boolean isPresent_Prev_Btn() {
        return ActionHelper.isPresent(prev_Btn);
    }

    public void click_Prev_Btn() {
        ActionHelper.click(prev_Btn);
    }

    public boolean isPresent_Next_Btn() {
        return ActionHelper.isPresent(next_Btn);
    }

    public void click_Next_Btn() {
        ActionHelper.click(next_Btn);
    }
}
