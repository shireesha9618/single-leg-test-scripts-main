package pageobjects;

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

import static constants.Constants.WAIT_FOR_FIVE_SECOND;
import static constants.Constants.WAIT_FOR_ONE_SECOND;

public class DispatchPage {
    private static DispatchPage _instance;

    private final Locator header_Lbl = Locator.builder().withWeb(By.id("header_Lbl"));
    private final Locator homeBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/']"));
    private final Locator dispatchListBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/dispatches/'][p[text()='Dispatch List']]"));
    private final Locator dispatchesCount_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Dispatches']/preceding-sibling::p"));
    private final Locator assignedCount_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Assigned']/preceding-sibling::p"));
    private final Locator startedCount_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Started']/preceding-sibling::p"));
    private final Locator ongoingCount_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Ongoing']/preceding-sibling::p"));
    private final Locator closedCount_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Closed']/preceding-sibling::p"));

    private final Locator createDispatch_Btn = Locator.builder().withWeb(By.id("createDispatch"));
    private final Locator searchBar_Txt = Locator.builder().withWeb(By.id("search"));
    private final Locator status_Dropdown = Locator.builder().withWeb(By.xpath("//button/p[text()='Status']"));
    private final Locator statusDropdownAssigned_Checkbox = Locator.builder().withWeb(By.id("Assigned"));
    private final Locator statusDropdownStarted_Checkbox = Locator.builder().withWeb(By.id("Started"));
    private final Locator statusDropdownOngoing_Checkbox = Locator.builder().withWeb(By.id("Ongoing"));
    private final Locator statusDropdownClosed_Checkbox = Locator.builder().withWeb(By.id("Closed"));

    private final Locator tableActions_Dropdown = Locator.builder().withWeb(By.xpath("//button/p[text()='Table Actions']"));
    private final Locator tableActionsDropdownModifyColumn_Link = Locator.builder().withWeb(By.xpath("//a[text()='Modify Columns']"));
    private final Locator tableActionsDropDownModifyColumnsLinkHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Edit Columns']"));
    private final Locator tableActionsDropDownModifyColumnsLinkSearchBar_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Search']"));
    private final Locator tableActionsDropDownModifyColumnsLinkSelectAll_Btn = Locator.builder().withWeb(By.xpath("//p[.='Select All']"));
    private final Locator tableActionsDropDownModifyColumnsLinkOptionsList_Label = Locator.builder().withWeb(By.xpath("//p[text()='Select All']/../../..//label/p"));
    private final Locator tableActionsDropDownModifyColumnsLinkRider_Checkbox = Locator.builder().withWeb(By.id("Rider"));
    private final Locator tableActionsDropDownModifyColumnsLinkVehicle_Checkbox = Locator.builder().withWeb(By.id("Vehicle"));
    private final Locator tableActionsDropDownModifyColumnsLinkStructure_Checkbox = Locator.builder().withWeb(By.id("Structure"));
    private final Locator tableActionsDropDownModifyColumnsLinkStatus_Checkbox = Locator.builder().withWeb(By.id("Status"));
    private final Locator tableActionsDropDownModifyColumnsLinkOrderStatus_Checkbox = Locator.builder().withWeb(By.id("Order status"));
    private final Locator tableActionsDropDownModifyColumnsLinkActions_Checkbox = Locator.builder().withWeb(By.id("Actions"));
    private final Locator tableActionsDropDownModifyColumnsLinkAmount_Checkbox = Locator.builder().withWeb(By.id("Amount"));
    private final Locator tableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label = Locator.builder().withWeb(By.xpath("//div[@data-rbd-droppable-id='droppable']/div/div/p"));
    private final Locator tableActionsDropDownModifyColumnsLinkSave_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Select All']/../../../../../following-sibling::div/button/p[text()='Save']"));
    private final Locator tableActionsDropDownModifyColumnsLinkCancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Select All']/../../../../../following-sibling::div/button/p[text()='Cancel']"));
    private final Locator tableActionsDropDownModifyColumnsLinkCross_Icon = Locator.builder().withWeb(By.xpath("//p[text()='Edit Columns']/following-sibling::*/*"));

    private final Locator dateFilter_Dropdown = Locator.builder().withWeb(By.xpath("//div[@class='h-full flex border rounded-md']//p"));
    private final Locator dateFilterDropdownCreatedDate_Radio = Locator.builder().withWeb(By.xpath("//span[normalize-space()='Created Date']"));
    private final Locator dateFilterDropdownClosureDate_Radio = Locator.builder().withWeb(By.xpath("//span[normalize-space()='Closure Date']"));
    private final Locator fromDateField_Txt = Locator.builder().withWeb(By.id("rangePicker"));
    private final Locator toDateField_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='End date']"));
    private final Locator refresh_Btn = Locator.builder().withWeb(By.id("refresh_Btn"));

    private final Locator shipmentDetailsTableHeaderList_Lbl = Locator.builder().withWeb(By.xpath("//thead/tr/th[text()]"));
    private final Locator shipmentDetailsTableColumnRadio_ListRadio = Locator.builder().withWeb(By.xpath("//tbody/tr/td//input"));
    private final Locator shipmentDetailsTableColumnRider_ListLink = Locator.builder().withWeb(By.xpath("//tbody/tr/td//a"));
    private final Locator shipmentDetailsTableColumnVehicle_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[3]/div[br]"));
    private final Locator shipmentDetailsTableColumnStructure_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[3][div[br]]/following-sibling::td[1]/div"));
    private final Locator shipmentDetailsTableColumnStatus_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td/div/h6"));
    private final Locator shipmentDetailsTableColumnOrderStatusDelivered_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[6]/div/div[1]/div/p"));
    private final Locator shipmentDetailsTableColumnOrderStatusFailed_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[6]/div/div[2]/div/p"));
    private final Locator shipmentDetailsTableColumnOrderStatusRemaining_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[6]/div/div[3]/div/p"));
    private final Locator shipmentDetailsTableColumnActions_ListBtn = Locator.builder().withWeb(By.xpath("//tbody/tr/td[8]//button"));
    private final Locator shipmentDetailsTableColumnActionsAddOrder_Radio = Locator.builder().withWeb(By.xpath("//span[normalize-space()='Add Orders']"));
    private final Locator shipmentDetailsTableColumnActionsViewOrder_Radio = Locator.builder().withWeb(By.xpath("//span[normalize-space()='View Orders']"));
    private final Locator itsEmptyHere_Lbl = Locator.builder().withWeb(By.xpath("//h3[contains(.,\"It's empty here\")]"));

    private final Locator mapsZoomIn_Btn = Locator.builder().withWeb(By.xpath("//a[@title='Zoom in']"));
    private final Locator mapsZoomOut_Btn = Locator.builder().withWeb(By.xpath("//a[@title='Zoom out']"));

    private final Locator firstElementName_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]/td[2]//p/a"));
    private final Locator firstElementStatus_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]/td[3]//h6"));
    private final Locator deliveredCountStatus_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]/td[4]/div/div[@class='cursor-pointer '][1]//p"));
    private final Locator firstElementDeliveredCountStatus_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]/td[4]/div/div[@class='cursor-pointer '][1]//p"));
    private final Locator firstElementFailedOrdersCountStatus_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]/td[4]/div/div[@class='cursor-pointer '][2]//p"));
    private final Locator firstElementRemainingOrdersCountStatus_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]/td[4]/div/div[@class='cursor-pointer '][3]//p"));
    private final Locator dispatches_Table_Header = Locator.builder().withWeb(By.className("ant-table-header"));
    private final Locator actions_Header = Locator.builder().withWeb(By.xpath("//th[normalize-space()='Actions']"));
    private final Locator actions_Btn = Locator.builder().withWeb(By.xpath("//tr/td[8]//button"));
    private final Locator addOrders_RadioBtn = Locator.builder().withWeb(By.xpath("(//div[@class='ant-space ant-space-vertical']//span)[1]"));
    private final Locator viewOrders_RadioBtn = Locator.builder().withWeb(By.xpath("(//div[@class='ant-space ant-space-vertical']//span)[1]"));
    private final Locator calender_WindowBtn = Locator.builder().withWeb(By.xpath("//div[@class='ant-picker-panels']"));
    private final Locator createdDate_TxtBox = Locator.builder().withWeb(By.xpath("//input[@id='rangePicker']"));
    private final Locator closureDate_TxtBox = Locator.builder().withWeb(By.xpath("//input[@placeholder='End date']"));
    private final Locator riderNme_Txt = Locator.builder().withWeb(By.xpath("//tbody[@class='ant-table-tbody']//td[2]//p"));
    private final Locator closeEditColumns_PopUp = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Edit Columns']/following-sibling::*[name()='svg']"));
    private final Locator dispatchTableHeaders_Txt = Locator.builder().withWeb(By.xpath("//th[@class='ant-table-cell']"));
    private final Locator previousYearCalendar_Btn = Locator.builder().withWeb(By.xpath("(//button[@class='ant-picker-header-super-prev-btn'])[1]"));
    private final Locator previousMonthCalendar_Btn = Locator.builder().withWeb(By.xpath("(//span[@class='ant-picker-prev-icon'])[1]"));
    private final Locator laterYearCalendar_Btn = Locator.builder().withWeb(By.xpath("(//button[@class='ant-picker-header-super-next-btn'])[2]"));
    private final Locator laterMonthCalendar_Btn = Locator.builder().withWeb(By.xpath("(//span[@class='ant-picker-next-icon'])[2]"));
    private final Locator createdFromYearCalendar_Txt = Locator.builder().withWeb(By.xpath("(//button[@class='ant-picker-year-btn'])[1]"));
    private final Locator createdFromMonthCalendar_Txt = Locator.builder().withWeb(By.xpath("(//button[@class='ant-picker-month-btn'])[1]"));


    public static DispatchPage getInstance() {
        if (_instance == null) _instance = new DispatchPage();
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        return ActionHelper.isPresent(header_Lbl, 5000);
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

    public boolean isPresent_DispatchListBreadCrumb_Link() {
        return ActionHelper.isPresent(dispatchListBreadCrumb_Link);
    }

    public void click_DispatchListBreadCrumb_Link() {
        ActionHelper.click(dispatchListBreadCrumb_Link);
    }

    public boolean isPresent_DispatchesCount_Lbl() {
        return ActionHelper.isPresent(dispatchesCount_Lbl);
    }

    public String getText_DispatchesCount_Lbl() {
        return ActionHelper.getText(dispatchesCount_Lbl);
    }

    public boolean isPresent_AssignedCount_Lbl() {
        return ActionHelper.isPresent(assignedCount_Lbl);
    }

    public String getText_AssignedCount_Lbl() {
        return ActionHelper.getText(assignedCount_Lbl);
    }

    public boolean isPresent_StartedCount_Lbl() {
        return ActionHelper.isPresent(startedCount_Lbl);
    }

    public String getText_StartedCount_Lbl() {
        return ActionHelper.getText(startedCount_Lbl);
    }

    public boolean isPresent_OngoingCount_Lbl() {
        return ActionHelper.isPresent(ongoingCount_Lbl);
    }

    public String getText_OngoingCount_Lbl() {
        return ActionHelper.getText(ongoingCount_Lbl);
    }

    public boolean isPresent_ClosedCount_Lbl() {
        return ActionHelper.isPresent(closedCount_Lbl);
    }

    public String getText_ClosedCount_Lbl() {
        return ActionHelper.getText(closedCount_Lbl);
    }

    public boolean isPresent_CreateDispatch_Btn() {
        return ActionHelper.isPresent(createDispatch_Btn);
    }

    public void click_CreateDispatch_Btn() {
        ActionHelper.click(createDispatch_Btn);
    }

    public String getText_CreateDispatch_Btn() {
        return ActionHelper.getText(createDispatch_Btn);
    }

    public boolean isPresent_SearchBar_Txt() {
        return ActionHelper.isPresent(searchBar_Txt);
    }

    public void fill_SearchBar_Txt(String value) {
        ActionHelper.fill(searchBar_Txt, value);
    }

    public void fillWithClear_SearchBar_Txt(String value) {
        ActionHelper.fillWithClear(searchBar_Txt.getBy(), value);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void clear_SearchBar_Txt() {
        ActionHelper.clear(searchBar_Txt.getBy());
    }

    public String getValue_SearchBar_Txt() {
        return ActionHelper.getAttribute(searchBar_Txt, "value");
    }

    public boolean isPresent_Status_Dropdown() {
        return ActionHelper.isPresent(status_Dropdown);
    }

    public void click_Status_Dropdown() {
        ActionHelper.click(status_Dropdown);
    }

    public String getText_Status_Dropdown() {
        return ActionHelper.getText(status_Dropdown);
    }

    public void statusDropdownSelectAll() {
        checkCheckbox_StatusDropdownAssigned_Checkbox();
        checkCheckbox_StatusDropdownStarted_Checkbox();
        checkCheckbox_StatusDropdownOngoing_Checkbox();
        checkCheckbox_StatusDropdownClosed_Checkbox();
    }

    public void statusDropdownUnselectAll() {
        uncheckCheckbox_StatusDropdownAssigned_Checkbox();
        uncheckCheckbox_StatusDropdownStarted_Checkbox();
        uncheckCheckbox_StatusDropdownOngoing_Checkbox();
        uncheckCheckbox_StatusDropdownClosed_Checkbox();
    }

    public boolean isPresent_StatusDropdownAssigned_Checkbox() {
        return ActionHelper.isPresent(statusDropdownAssigned_Checkbox);
    }

    public void checkCheckbox_StatusDropdownAssigned_Checkbox() {
        click_Status_Dropdown();
        Utility.checkCheckbox(statusDropdownAssigned_Checkbox.getBy());
        click_Status_Dropdown();
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void uncheckCheckbox_StatusDropdownAssigned_Checkbox() {
        click_Status_Dropdown();
        Utility.uncheckCheckbox(statusDropdownAssigned_Checkbox.getBy());
        click_Status_Dropdown();
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_StatusDropdownStarted_Checkbox() {
        return ActionHelper.isPresent(statusDropdownStarted_Checkbox);
    }

    public void checkCheckbox_StatusDropdownStarted_Checkbox() {
        click_Status_Dropdown();
        Utility.checkCheckbox(statusDropdownStarted_Checkbox.getBy());
        click_Status_Dropdown();
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void uncheckCheckbox_StatusDropdownStarted_Checkbox() {
        click_Status_Dropdown();
        Utility.uncheckCheckbox(statusDropdownStarted_Checkbox.getBy());
        click_Status_Dropdown();
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_StatusDropdownOngoing_Checkbox() {
        return ActionHelper.isPresent(statusDropdownOngoing_Checkbox);
    }

    public void checkCheckbox_StatusDropdownOngoing_Checkbox() {
        click_Status_Dropdown();
        Utility.checkCheckbox(statusDropdownOngoing_Checkbox.getBy());
        click_Status_Dropdown();
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void uncheckCheckbox_StatusDropdownOngoing_Checkbox() {
        click_Status_Dropdown();
        Utility.uncheckCheckbox(statusDropdownOngoing_Checkbox.getBy());
        click_Status_Dropdown();
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_StatusDropdownClosed_Checkbox() {
        return ActionHelper.isPresent(statusDropdownClosed_Checkbox);
    }

    public void checkCheckbox_StatusDropdownClosed_Checkbox() {
        click_Status_Dropdown();
        Utility.checkCheckbox(statusDropdownClosed_Checkbox.getBy());
        click_Status_Dropdown();
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void uncheckCheckbox_StatusDropdownClosed_Checkbox() {
        click_Status_Dropdown();
        Utility.uncheckCheckbox(statusDropdownClosed_Checkbox.getBy());
        click_Status_Dropdown();
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_TableActions_Dropdown() {
        return ActionHelper.isPresent(tableActions_Dropdown);
    }

    public void click_TableActions_Dropdown() {
        ActionHelper.click(tableActions_Dropdown);
    }

    public String getText_TableActions_Dropdown() {
        return ActionHelper.getText(tableActions_Dropdown);
    }

    public boolean isPresent_TableActionsDropdownModifyColumn_Link() {
        return ActionHelper.isPresent(tableActionsDropdownModifyColumn_Link);
    }

    public void click_TableActionsDropdownModifyColumn_Link() {
        ActionHelper.waitUntilElementClickable(tableActionsDropdownModifyColumn_Link);
        ActionHelper.click(tableActionsDropdownModifyColumn_Link);
    }

    public String getText_TableActionsDropdownModifyColumn_Link() {
        return ActionHelper.getText(tableActionsDropdownModifyColumn_Link);
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkHeader_Lbl() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkHeader_Lbl, 5000);
    }

    public String getText_TableActionsDropDownModifyColumnsLinkHeader_Lbl() {
        return ActionHelper.getText(tableActionsDropDownModifyColumnsLinkHeader_Lbl);
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkSearchBar_Txt() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkSearchBar_Txt);
    }

    public void fillWithClear_TableActionsDropDownModifyColumnsLinkSearchBar_Txt(String input) {
        ActionHelper.fillWithClear(tableActionsDropDownModifyColumnsLinkSearchBar_Txt.getBy(), input);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkSelectAll_Btn() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkSelectAll_Btn);
    }

    public void click_TableActionsDropDownModifyColumnsLinkSelectAll_Btn() {
        ActionHelper.click(tableActionsDropDownModifyColumnsLinkSelectAll_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkSave_Btn() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkSave_Btn);
    }

    public void click_TableActionsDropDownModifyColumnsLinkSave_Btn() {
        ActionHelper.click(tableActionsDropDownModifyColumnsLinkSave_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkCancel_Btn() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkCancel_Btn);
    }

    public void click_TableActionsDropDownModifyColumnsLinkCancel_Btn() {
        ActionHelper.click(tableActionsDropDownModifyColumnsLinkCancel_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkCross_Icon() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkCross_Icon);
    }

    public void click_TableActionsDropDownModifyColumnsLinkCross_Icon() {
        ActionHelper.click(tableActionsDropDownModifyColumnsLinkCross_Icon);
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkOptionsList_Label() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkOptionsList_Label);
    }

    public List<String> getText_TableActionsDropDownModifyColumnsLinkOptionsList_Label() {
        return Utility.getText_ListOfWebElements(tableActionsDropDownModifyColumnsLinkOptionsList_Label.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label);
    }

    public List<String> getText_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label() {
        return Utility.getText_ListOfWebElements(tableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label.getBy());
    }

    public void dragAndDrop_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label(int fromIndex, int toIndex) {
        List<WebElement> elements = ActionHelper.findElements(tableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label);
        new Actions(DriverManager.getDriver()).clickAndHold(elements.get(fromIndex)).moveByOffset(-10, 0).moveToElement(elements.get(toIndex)).release().pause(5000).perform();
    }


    public boolean isPresent_TableActionsDropDownModifyColumnsLinkRider_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkRider_Checkbox);
    }

    public void uncheck_TableActionsDropDownModifyColumnsLinkRider_Checkbox() {
        Utility.uncheckCheckbox(tableActionsDropDownModifyColumnsLinkRider_Checkbox.getBy());
    }

    public void check_TableActionsDropDownModifyColumnsLinkRider_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkRider_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkVehicle_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkVehicle_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkVehicle_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkVehicle_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkStructure_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkStructure_Checkbox);
    }

    public void uncheck_TableActionsDropDownModifyColumnsLinkStructure_Checkbox() {
        Utility.uncheckCheckbox(tableActionsDropDownModifyColumnsLinkStructure_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkStatus_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkStatus_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkStatus_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkStatus_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkOrderStatus_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkOrderStatus_Checkbox);
    }

    public void uncheck_TableActionsDropDownModifyColumnsLinkOrderStatus_Checkbox() {
        Utility.uncheckCheckbox(tableActionsDropDownModifyColumnsLinkOrderStatus_Checkbox.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkActions_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkActions_Checkbox);
    }

    public void uncheck_TableActionsDropDownModifyColumnsLinkActions_Checkbox() {
        Utility.uncheckCheckbox(tableActionsDropDownModifyColumnsLinkActions_Checkbox.getBy());
    }

    public void check_TableActionsDropDownModifyColumnsLinkActions_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkActions_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkAmount_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkAmount_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkAmount_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkAmount_Checkbox.getBy());
    }

    public boolean isPresent_DateFilter_Dropdown() {
        return ActionHelper.isPresent(dateFilter_Dropdown);
    }

    public void click_DateFilter_Dropdown() {
        ActionHelper.click(dateFilter_Dropdown);
    }

    public String getText_DateFilter_Dropdown() {
        return ActionHelper.getText(dateFilter_Dropdown);
    }

    public boolean isPresent_DateFilterDropdownCreatedDate_Radio() {
        return ActionHelper.isPresent(dateFilterDropdownCreatedDate_Radio);
    }

    public void click_DateFilterDropdownCreatedDate_Radio() {
        ActionHelper.click(dateFilterDropdownCreatedDate_Radio);
    }

    public boolean isPresent_DateFilterDropdownClosureDate_Radio() {
        return ActionHelper.isPresent(dateFilterDropdownClosureDate_Radio);
    }

    public void click_DateFilterDropdownClosureDate_Radio() {
        ActionHelper.click(dateFilterDropdownClosureDate_Radio);
    }

    public boolean isPresent_FromDateField_Txt() {
        return ActionHelper.isPresent(fromDateField_Txt);
    }

    public void click_FromDateField_Txt() {
        ActionHelper.click(fromDateField_Txt);
    }

    public String getValue_FromDateField_Txt() {
        return ActionHelper.getAttribute(fromDateField_Txt, "value");
    }

    public void fillWithClear_FromDateField_Txt(String input) {
        ActionHelper.fillWithClear(fromDateField_Txt.getBy(), input + Keys.ENTER);
    }

    public boolean isPresent_ToDateField_Txt() {
        return ActionHelper.isPresent(toDateField_Txt);
    }

    public void click_ToDateField_Txt() {
        ActionHelper.click(toDateField_Txt);
    }

    public String getValue_ToDateField_Txt() {
        return ActionHelper.getAttribute(toDateField_Txt, "value");
    }

    public void fillWithClear_ToDateField_Txt(String input) {
        ActionHelper.fillWithClear(toDateField_Txt.getBy(), input + Keys.ENTER);
    }

    public boolean isPresent_Refresh_Btn() {
        return ActionHelper.isPresent(refresh_Btn);
    }

    public void click_Refresh_Btn() {
        ActionHelper.click(refresh_Btn);
    }

    public String getText_Refresh_Btn() {
        return ActionHelper.getText(refresh_Btn);
    }

    public List<String> getText_ShipmentDetailsTableHeaderList_Lbl() {
        return Utility.getText_ListOfWebElements(shipmentDetailsTableHeaderList_Lbl.getBy());
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnRadio_ListRadio() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnRadio_ListRadio.getBy());
    }

    public void click_ShipmentDetailsTableColumnRadio_ListRadio(int index) {
        ActionHelper.click(ActionHelper.findElements(shipmentDetailsTableColumnRadio_ListRadio.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnRider_ListLink() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnRider_ListLink.getBy());
    }

    public List<WebElement> getListWithExplicitWait_ShipmentDetailsTableColumnRider_ListLink() {
        return ActionHelper.findElements(shipmentDetailsTableColumnRider_ListLink.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnRider_ListLink() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnRider_ListLink.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnRider_ListLink(int index) {
        return ActionHelper.getText(ActionHelper.findElements(shipmentDetailsTableColumnRider_ListLink.getBy()).get(index));
    }

    public void click_ShipmentDetailsTableColumnRider_ListLink(int index) {
        ActionHelper.click(ActionHelper.findElements(shipmentDetailsTableColumnRider_ListLink.getBy()).get(index));
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnVehicle_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnVehicle_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnVehicle_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnVehicle_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnVehicle_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnVehicle_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnStructure_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnStructure_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnStructure_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnStructure_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnStructure_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnStructure_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnStatus_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnStatus_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnStatus_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnStatus_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnStatus_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnStatus_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnOrderStatusDelivered_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnOrderStatusDelivered_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnOrderStatusDelivered_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnOrderStatusDelivered_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnOrderStatusDelivered_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnOrderStatusDelivered_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnOrderStatusFailed_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnOrderStatusFailed_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnOrderStatusFailed_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnOrderStatusFailed_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnOrderStatusFailed_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnOrderStatusFailed_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnOrderStatusRemaining_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnOrderStatusRemaining_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnOrderStatusRemaining_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnOrderStatusRemaining_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnOrderStatusRemaining_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnOrderStatusRemaining_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnActions_ListBtn() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnActions_ListBtn.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnActions_ListBtn() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnActions_ListBtn.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnActions_ListBtn(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnActions_ListBtn.getBy()).get(index));
    }

    public void click_ShipmentDetailsTableColumnActions_ListBtn(int index) {
        ActionHelper.click(ActionHelper.findElements(shipmentDetailsTableColumnActions_ListBtn.getBy()).get(index));
    }

    public boolean isPresent_ShipmentDetailsTableColumnActionsAddOrder_Radio() {
        return ActionHelper.isPresent(shipmentDetailsTableColumnActionsAddOrder_Radio);
    }

    public void click_ShipmentDetailsTableColumnActionsAddOrder_Radio() {
        ActionHelper.click(shipmentDetailsTableColumnActionsAddOrder_Radio);
    }

    public boolean isPresent_ShipmentDetailsTableColumnActionsViewOrder_Radio() {
        return ActionHelper.isPresent(shipmentDetailsTableColumnActionsViewOrder_Radio);
    }

    public void click_ShipmentDetailsTableColumnActionsViewOrder_Radio() {
        ActionHelper.click(shipmentDetailsTableColumnActionsViewOrder_Radio);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_ItsEmptyHere_Lbl() {
        return ActionHelper.isPresent(itsEmptyHere_Lbl, WAIT_FOR_FIVE_SECOND);
    }

    public void select_FirstElement_Lbl() {
        ActionHelper.click(firstElementName_Lbl);
    }

    public String get_FirstElementStatus_Lbl() {
        DriverManager.getDriver().navigate().refresh();
        return ActionHelper.getText(firstElementStatus_Lbl);
    }

    public String get_FirstElementDeliveredCountStatus_Lbl() {
        return ActionHelper.getText(firstElementDeliveredCountStatus_Lbl);
    }

    public String get_FirstElementFailedOrdersCountStatus_Lbl() {
        return ActionHelper.getText(firstElementFailedOrdersCountStatus_Lbl);
    }

    public String get_FirstElementRemainingOrdersCountStatus_Lbl() {
        return ActionHelper.getText(firstElementRemainingOrdersCountStatus_Lbl);
    }

    public String get_AssignedCount_Lbl() {
        return ActionHelper.getText(assignedCount_Lbl);
    }

    public String get_StartedCount_Lbl() {
        return ActionHelper.getText(startedCount_Lbl);
    }

    public String get_OngoingCount_Lbl() {
        return ActionHelper.getText(ongoingCount_Lbl);
    }

    public String get_ClosedCount_Lbl() {
        return ActionHelper.getText(closedCount_Lbl);
    }

    public String get_DispatchCount_Lbl() {
        ActionHelper.waitUntilElementVisible(dispatchesCount_Lbl.getBy());
        return ActionHelper.getText(dispatchesCount_Lbl);
    }

    public HashMap<String, String> getDispatchSummary() {
        HashMap<String, String> orderSummary = new HashMap<>();
        orderSummary.put("DispatchCount", getText_DispatchesCount_Lbl());
        orderSummary.put("AssignedCount", getText_AssignedCount_Lbl());
        orderSummary.put("StartedCount", getText_StartedCount_Lbl());
        orderSummary.put("OngoingCount", getText_OngoingCount_Lbl());
        orderSummary.put("ClosedCount", getText_ClosedCount_Lbl());
        return orderSummary;
    }

    public boolean isPresent_MapsZoomIn_Btn() {
        return ActionHelper.isPresent(mapsZoomIn_Btn);
    }

    public void click_MapsZoomIn_Btn() {
        ActionHelper.click(mapsZoomIn_Btn);
    }

    public boolean isPresent_MapsZoomOut_Btn() {
        return ActionHelper.isPresent(mapsZoomOut_Btn);
    }

    public void click_MapsZoomOut_Btn() {
        ActionHelper.click(mapsZoomOut_Btn);
    }

    public void click_DispatchesTable_Header() {
        ActionHelper.click(dispatches_Table_Header);
    }

    public void scrollTo_Actions_column() {
        click_DispatchesTable_Header();
        for (int i = 1; i < 6; i++) {
            if (ActionHelper.isPresent(actions_Header, WAIT_FOR_ONE_SECOND)) {
                break;
            } else
                Utility.scrollRightUsingKeyboardKey(i);
        }
    }

    private void click_Actions_BtnOf(int order_Number) {
        ActionHelper.findElements(actions_Btn).get(order_Number).click();
    }

    public void click_FirstOrderActions_Btn() {
        click_Actions_BtnOf(0);
    }

    public void click_AddOrders_RadioBtn() {
        ActionHelper.waitUntilElementVisible(addOrders_RadioBtn.getBy());
        ActionHelper.click(addOrders_RadioBtn);
    }

    public String get_CreatedDispatchDate_Value() {
        return ActionHelper.getAttribute(createdDate_TxtBox, "value");
    }

    public String get_ClosureDispatchDate_Value() {
        return ActionHelper.getAttribute(closureDate_TxtBox, "value");
    }

    public void set_CreatedDispatchDate_As(String date) {
        ActionHelper.findElements(createdDate_TxtBox).clear();
        ActionHelper.sendKeys(createdDate_TxtBox, date);
        click_Refresh_Btn();
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void set_ClosureDispatchDate_As(String date) {
        ActionHelper.findElements(closureDate_TxtBox).clear();
        ActionHelper.sendKeys(closureDate_TxtBox, date);
        click_Refresh_Btn();
    }

    public List<String> getRiderNameAsList() {
        List<String> rider_Names = new ArrayList<>();
        try {
            List<WebElement> riders = ActionHelper.findElements(riderNme_Txt);
            for (int i = 0; i < riders.size(); i++) {
                rider_Names.add(riders.get(i).getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rider_Names;
    }

    public void closeEditColumnsPopUp() {
        ActionHelper.click(closeEditColumns_PopUp);
    }

    public List<String> getText_TableHeader_Labels() {
        return Utility.getText_ListOfWebElements(dispatchTableHeaders_Txt.getBy());
    }

    public void click_FromDate_TxtBox() {
        ActionHelper.click(createdDate_TxtBox);
    }

    public boolean isPresent_CalendarWindow_PopUp() {
        return ActionHelper.isPresent(calender_WindowBtn);
    }

    public void click_CalendarPreviousYear_Btn() {
        ActionHelper.click(previousYearCalendar_Btn);
    }

    public void click_CalendarPreviousMonth_Btn() {
        ActionHelper.click(previousMonthCalendar_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void click_CalendarLaterYear_Btn() {
        ActionHelper.click(laterYearCalendar_Btn);
    }

    public void click_CalendarLaterMonth_Btn() {
        ActionHelper.click(laterMonthCalendar_Btn);
    }

    public String getValue_CalendarCreatedByFromYear_Txt() {
        ActionHelper.waitUntilElementVisible(createdFromYearCalendar_Txt.getBy());
        return ActionHelper.getText(createdFromYearCalendar_Txt);
    }

    public String getValue_CalendarCreatedByFromMonth_Txt() {
        return ActionHelper.getText(createdFromMonthCalendar_Txt);
    }

}