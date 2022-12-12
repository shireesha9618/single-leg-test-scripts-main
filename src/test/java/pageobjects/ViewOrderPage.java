package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.HashMap;
import java.util.List;

public class ViewOrderPage {
    private static ViewOrderPage _instance;

    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//h1[text()='Orders']"));
    private final Locator homeBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/']/p[text()='Home']"));
    private final Locator orderListBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/orders/']/p[text()='Order List']"));

    private final Locator newOrder_Btn = Locator.builder().withWeb(By.xpath("//span[text()='New Order']"));

    private final Locator assignRider_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Assign Rider']"));
    private final Locator assignRider_DropDown = Locator.builder().withWeb(By.xpath("//div[text()='Assign Rider']//following-sibling::div"));
    private final Locator assignRiderDropDownManual_Opt = Locator.builder().withWeb(By.xpath("//p[text()='Manual']"));
    private final Locator assignRiderDropDownAutomatic_Opt = Locator.builder().withWeb(By.xpath("//p[text()='Automatic']"));

    private final Locator toBeAssigned_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='To be Assigned']/preceding-sibling::p"));
    private final Locator toBeDispatched_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='To be dispatched']/preceding-sibling::p"));
    private final Locator dispatched_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Dispatched']/preceding-sibling::p"));
    private final Locator delivered_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Delivered']/preceding-sibling::p"));
    private final Locator failed_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Failed']/preceding-sibling::p"));
    private final Locator remaining_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Remaining']/preceding-sibling::p"));
    private final Locator startDispatches_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Start Dispatches']"));
    private final Locator trackDispatches_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Track Dispatches']"));

    private final Locator searchBar_Txt = Locator.builder().withWeb(By.id("search"));
    private final Locator status_Dropdown = Locator.builder().withWeb(By.xpath("//p[contains(text(), 'Status: ')]"));
    private final Locator statusDropdownCreated_Radio = Locator.builder().withWeb(By.xpath("//input[@value='inprogress:scheduled']"));
    private final Locator statusDropdownAssigned_Radio = Locator.builder().withWeb(By.xpath("//input[@value='inprogress:assigned']"));
    private final Locator statusDropdownInProgress_Radio = Locator.builder().withWeb(By.xpath("//input[@value='inprogress:active']"));
    private final Locator statusDropdownCompleted_Radio = Locator.builder().withWeb(By.xpath("//input[@value='closed:delivered']"));
    private final Locator statusDropdownCreationFailed_Radio = Locator.builder().withWeb(By.xpath("//input[@value='closed:failed']"));
    private final Locator statusDropdownCancelled_Radio = Locator.builder().withWeb(By.xpath("//input[@value='closed:cancelled']"));
    private final Locator statusDropdownFailed_Radio = Locator.builder().withWeb(By.xpath("//input[@value='closed:undelivered']"));
    private final Locator statusDropdownClearSelection_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Clear Selection']"));

    private final Locator dateFilter_Dropdown = Locator.builder().withWeb(By.xpath("//div[div[@id='wrapper']]/following-sibling::div//button/button/p"));
    private final Locator dateFilterDropdownCreatedDate_Radio = Locator.builder().withWeb(By.xpath("//input[@value='createdAt']"));
    private final Locator dateFilterDropdownClosureDate_Radio = Locator.builder().withWeb(By.xpath("//input[@value='updatedAt']"));
    private final Locator dateField_Btn = Locator.builder().withWeb(By.id("rangePicker"));
    private final Locator calendarPreviousYear_Btn = Locator.builder().withWeb(By.xpath("//span[@class='ant-picker-super-prev-icon']"));
    private final Locator calendarPreviousMonth_Btn = Locator.builder().withWeb(By.xpath("//span[@class='ant-picker-prev-icon']"));
    private final Locator calendarNextMonth_Btn = Locator.builder().withWeb(By.xpath("(//span[@class='ant-picker-next-icon'])[last()]"));
    private final Locator calendarNextYear_Btn = Locator.builder().withWeb(By.xpath("(//span[@class='ant-picker-super-next-icon'])[last()]"));
    private final Locator calendarMonth_Btn = Locator.builder().withWeb(By.xpath("//button[@class='ant-picker-month-btn']"));
    private final Locator calendarYear_Btn = Locator.builder().withWeb(By.xpath("//button[@class='ant-picker-year-btn']"));
    private final Locator calendarChooseDateMonthYear_Btn = Locator.builder().withWeb(By.xpath("//tbody/tr/td[@title='PLACEHOLDER']"));
    private final Locator refresh_Btn = Locator.builder().withWeb(By.id("refresh_Btn"));

    private final Locator tabHeader_ListLbl = Locator.builder().withWeb(By.xpath("//th[contains(@class,'ant-table-cell') and text()]"));
    private final Locator tabHeaderCheckbox_ListCheckbox = Locator.builder().withWeb(By.xpath("//tr[contains(@class, 'ant-table-row')]/td//span"));
    private final Locator tabHeaderOrderId_ListLink = Locator.builder().withWeb(By.xpath("//tr[contains(@class, 'ant-table-row')]/td/a/a"));
    private final Locator tabHeaderStatus_ListLbl = Locator.builder().withWeb(By.xpath("//tr[contains(@class, 'ant-table-row')]/td[3]/div/h6"));
    private final Locator tabHeaderNoOfShipments_ListLbl = Locator.builder().withWeb(By.xpath("//tr[contains(@class, 'ant-table-row')]/td[4]/span"));
    private final Locator tabHeaderWeight_ListLbl = Locator.builder().withWeb(By.xpath("//tr[contains(@class, 'ant-table-row')]/td[5]/span"));
    private final Locator tabHeaderVolume_ListLbl = Locator.builder().withWeb(By.xpath("//tr[contains(@class, 'ant-table-row')]/td[6]/span"));
    private final Locator tabHeaderPickupAddress_ListLbl = Locator.builder().withWeb(By.xpath("//tr[contains(@class, 'ant-table-row')]/td[7]/span"));
    private final Locator tabHeaderDropAddress_ListLbl = Locator.builder().withWeb(By.xpath("//tr[contains(@class, 'ant-table-row')]/td[8]/span"));
    private final Locator tabHeaderPickupPostalCode_ListLbl = Locator.builder().withWeb(By.xpath("//tr[contains(@class, 'ant-table-row')]/td[9]/span"));
    private final Locator tabHeaderDropPostalCode_ListLbl = Locator.builder().withWeb(By.xpath("//tr[contains(@class, 'ant-table-row')]/td[10]/span"));
    private final Locator tabHeaderPaymentType_ListLbl = Locator.builder().withWeb(By.xpath("//tr[contains(@class, 'ant-table-row')]/td[11]/div/h6"));
    private final Locator tabHeaderAmount_ListLbl = Locator.builder().withWeb(By.xpath("//tr[contains(@class, 'ant-table-row')]/td[12]/span"));

    private final Locator firstElementOrderId_Txt = Locator.builder().withWeb(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[2]"));
    private final Locator firstElementStatus_Lbl = Locator.builder().withWeb(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[3]"));
    private final Locator firstElementNoOfShipment_Lbl = Locator.builder().withWeb(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[4]"));

    private final Locator assignRiderDropDownManualHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Manual Assignment']"));
    private final Locator assignRiderDropDownManualRider_DropDown = Locator.builder().withWeb(By.xpath("//div[@class='space-y-2']"));
    private final Locator assignRiderDropDownManualRiderDropDownData_Lbl = Locator.builder().withWeb(By.xpath("(//div[@class='flex flex-col']/p[1])[1]"));
    private final Locator assignRiderDropDownManualAssign_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Assign']"));
    private final Locator assignRiderDropDownManualAssignAndStart_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Assign and Start']"));
    private final Locator assignRiderSearch_TextBox = Locator.builder().withWeb(By.xpath("//h4[text()='Rider*']/..//following-sibling::div//input"));
    private final Locator resourceLeftMenuItem = Locator.builder().withWeb(By.xpath("//p[text()='Resources']"));
    private final Locator facilitiesLeftSubMenuItem = Locator.builder().withWeb(By.xpath("//p[text()='Facilities']"));

    public static ViewOrderPage getInstance() {
        if (_instance == null) {
            _instance = new ViewOrderPage();
        }
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        return ActionHelper.isPresent(header_Lbl, 5000);
    }

    public String getText_Header_Lbl() {
        return ActionHelper.getText(header_Lbl);
    }

    public boolean isPresent_HomeBreadcrumb_Link() {
        return ActionHelper.isPresent(homeBreadcrumb_Link);
    }

    public void click_HomeBreadcrumb_Link() {
        ActionHelper.click(homeBreadcrumb_Link);
    }

    public String getText_HomeBreadcrumb_Link() {
        return ActionHelper.getText(homeBreadcrumb_Link);
    }

    public boolean isPresent_OrderListBreadcrumb_Link() {
        return ActionHelper.isPresent(orderListBreadcrumb_Link);
    }

    public void click_OrderListBreadcrumb_Link() {
        ActionHelper.click(orderListBreadcrumb_Link);
    }

    public String getText_OrderListBreadcrumb_Link() {
        return ActionHelper.getText(orderListBreadcrumb_Link);
    }

    public boolean isPresent_NewOrder_Btn() {
        return ActionHelper.isPresent(newOrder_Btn);
    }

    public void click_NewOrder_Btn() {
        ActionHelper.click(newOrder_Btn);
    }

    public String getText_NewOrder_Btn() {
        return ActionHelper.getText(newOrder_Btn);
    }

    public boolean isPresent_AssignRider_Btn() {
        return ActionHelper.isPresent(assignRider_Btn);
    }

    public void click_AssignRider_Btn() {
        ActionHelper.click(assignRider_Btn);
    }

    public boolean isPresent_AssignRider_DropDown() {
        return ActionHelper.isPresent(assignRider_DropDown);
    }

    public void click_AssignRider_DropDown() {
        ActionHelper.click(assignRider_DropDown);
    }

    public boolean isPresent_AssignRiderDropDownManual_Opt() {
        return ActionHelper.isPresent(assignRiderDropDownManual_Opt);
    }

    public void click_AssignRiderDropDownManual_Opt() {
        ActionHelper.click(assignRiderDropDownManual_Opt);
    }

    public boolean isPresent_AssignRiderDropDownAutomatic_Opt() {
        return ActionHelper.isPresent(assignRiderDropDownAutomatic_Opt);
    }

    public void click_AssignRiderDropDownAutomatic_Opt() {
        ActionHelper.click(assignRiderDropDownAutomatic_Opt);
    }

    public boolean isPresent_ToBeAssigned_Lbl() {
        return ActionHelper.isPresent(toBeAssigned_Lbl);
    }

    public String getText_ToBeAssigned_Lbl() {
        ActionHelper.waitUntilElementVisible(toBeAssigned_Lbl.getBy());
        return ActionHelper.getText(toBeAssigned_Lbl);
    }

    public boolean isPresent_ToBeDispatched_Lbl() {
        return ActionHelper.isPresent(toBeDispatched_Lbl);
    }

    public String getText_ToBeDispatched_Lbl() {
        ActionHelper.waitUntilElementVisible(toBeDispatched_Lbl.getBy());
        return ActionHelper.getText(toBeDispatched_Lbl);
    }

    public boolean isPresent_Dispatched_Lbl() {
        return ActionHelper.isPresent(dispatched_Lbl);
    }

    public String getText_Dispatched_Lbl() {
        return ActionHelper.getText(dispatched_Lbl);
    }

    public boolean isPresent_Delivered_Lbl() {
        return ActionHelper.isPresent(delivered_Lbl);
    }

    public String getText_Delivered_Lbl() {
        return ActionHelper.getText(delivered_Lbl);
    }

    public boolean isPresent_Failed_Lbl() {
        return ActionHelper.isPresent(failed_Lbl);
    }

    public String getText_Failed_Lbl() {
        return ActionHelper.getText(failed_Lbl);
    }

    public boolean isPresent_Remaining_Lbl() {
        return ActionHelper.isPresent(remaining_Lbl);
    }

    public String getText_Remaining_Lbl() {
        return ActionHelper.getText(remaining_Lbl);
    }

    public boolean isPresent_StartDispatches_Btn() {
        return ActionHelper.isPresent(startDispatches_Btn);
    }

    public void click_StartDispatches_Btn() {
        ActionHelper.click(startDispatches_Btn);
    }

    public String getText_StartDispatches_Btn() {
        return ActionHelper.getText(startDispatches_Btn);
    }

    public boolean isPresent_TrackDispatches_Btn() {
        return ActionHelper.isPresent(trackDispatches_Btn);
    }

    public void click_TrackDispatches_Btn() {
        ActionHelper.click(trackDispatches_Btn);
    }

    public String getText_TrackDispatches_Btn() {
        return ActionHelper.getText(trackDispatches_Btn);
    }

    public boolean isPresent_SearchBar_Txt() {
        return ActionHelper.isPresent(searchBar_Txt);
    }

    public void fill_SearchBar_Txt(String value) {
        ActionHelper.fill(searchBar_Txt, value);
    }

    public void fillWithClear_SearchBar_Txt(String value) {
        ActionHelper.fillWithClear(searchBar_Txt.getBy(), value);
        ActionHelper.waitForLoaderToHide();
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

    public boolean isPresent_StatusDropdownCreated_Radio() {
        return ActionHelper.isPresent(statusDropdownCreated_Radio);
    }

    public void click_StatusDropdownCreated_Radio() {
        ActionHelper.click(statusDropdownCreated_Radio);
    }

    public boolean isPresent_StatusDropdownAssigned_Radio() {
        return ActionHelper.isPresent(statusDropdownAssigned_Radio);
    }

    public void click_StatusDropdownAssigned_Radio() {
        ActionHelper.click(statusDropdownAssigned_Radio);
    }

    public boolean isPresent_StatusDropdownInProgress_Radio() {
        return ActionHelper.isPresent(statusDropdownInProgress_Radio);
    }

    public void click_StatusDropdownInProgress_Radio() {
        ActionHelper.click(statusDropdownInProgress_Radio);
    }

    public boolean isPresent_StatusDropdownCompleted_Radio() {
        return ActionHelper.isPresent(statusDropdownCompleted_Radio);
    }

    public void click_StatusDropdownCompleted_Radio() {
        ActionHelper.click(statusDropdownCompleted_Radio);
    }

    public boolean isPresent_StatusDropdownCreationFailed_Radio() {
        return ActionHelper.isPresent(statusDropdownCreationFailed_Radio);
    }

    public void click_StatusDropdownCreationFailed_Radio() {
        ActionHelper.click(statusDropdownCreationFailed_Radio);
    }

    public boolean isPresent_StatusDropdownCancelled_Radio() {
        return ActionHelper.isPresent(statusDropdownCancelled_Radio);
    }

    public void click_StatusDropdownCancelled_Radio() {
        ActionHelper.click(statusDropdownCancelled_Radio);
    }

    public boolean isPresent_StatusDropdownFailed_Radio() {
        return ActionHelper.isPresent(statusDropdownFailed_Radio);
    }

    public void click_StatusDropdownFailed_Radio() {
        ActionHelper.click(statusDropdownFailed_Radio);
    }

    public boolean isPresent_StatusDropdownClearSelection_Btn() {
        return ActionHelper.isPresent(statusDropdownClearSelection_Btn);
    }

    public void click_StatusDropdownClearSelection_Btn() {
        ActionHelper.click(statusDropdownClearSelection_Btn);
    }

    public String getText_StatusDropdownClearSelection_Btn() {
        return ActionHelper.getText(statusDropdownClearSelection_Btn);
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

    public boolean isPresent_DateField_Btn() {
        return ActionHelper.isPresent(dateField_Btn);
    }

    public void click_DateField_Btn() {
        ActionHelper.click(dateField_Btn);
    }

    public String getText_DateField_Btn() {
        return ActionHelper.getText(dateField_Btn);
    }

    public boolean isPresent_CalendarPreviousYear_Btn() {
        return ActionHelper.isPresent(calendarPreviousYear_Btn);
    }

    public void click_CalendarPreviousYear_Btn() {
        ActionHelper.click(calendarPreviousYear_Btn);
    }

    public String getText_CalendarPreviousYear_Btn() {
        return ActionHelper.getText(calendarPreviousYear_Btn);
    }

    public boolean isPresent_CalendarPreviousMonth_Btn() {
        return ActionHelper.isPresent(calendarPreviousMonth_Btn);
    }

    public void click_CalendarPreviousMonth_Btn() {
        ActionHelper.click(calendarPreviousMonth_Btn);
    }

    public String getText_CalendarPreviousMonth_Btn() {
        return ActionHelper.getText(calendarPreviousMonth_Btn);
    }

    public boolean isPresent_CalendarNextMonth_Btn() {
        return ActionHelper.isPresent(calendarNextMonth_Btn);
    }

    public void click_CalendarNextMonth_Btn() {
        ActionHelper.click(calendarNextMonth_Btn);
    }

    public String getText_CalendarNextMonth_Btn() {
        return ActionHelper.getText(calendarNextMonth_Btn);
    }

    public boolean isPresent_CalendarNextYear_Btn() {
        return ActionHelper.isPresent(calendarNextYear_Btn);
    }

    public void click_CalendarNextYear_Btn() {
        ActionHelper.click(calendarNextYear_Btn);
    }

    public String getText_CalendarNextYear_Btn() {
        return ActionHelper.getText(calendarNextYear_Btn);
    }

    public boolean isPresent_calendarMonth_Btn() {
        return ActionHelper.isPresent(calendarMonth_Btn);
    }

    public void click_calendarMonth_Btn() {
        ActionHelper.click(calendarMonth_Btn);
    }

    public String getText_calendarMonth_Btn() {
        return ActionHelper.getText(calendarMonth_Btn);
    }

    public boolean isPresent_calendarYear_Btn() {
        return ActionHelper.isPresent(calendarYear_Btn);
    }

    public void click_calendarYear_Btn() {
        ActionHelper.click(calendarYear_Btn);
    }

    public String getText_calendarYear_Btn() {
        return ActionHelper.getText(calendarYear_Btn);
    }

    public boolean isPresent_calendarChooseDateMonthYear_Btn() {
        return ActionHelper.isPresent(calendarChooseDateMonthYear_Btn);
    }

    public void click_calendarChooseDateMonthYear_Btn() {
        ActionHelper.click(calendarChooseDateMonthYear_Btn);
    }

    public String getText_calendarChooseDateMonthYear_Btn() {
        return ActionHelper.getText(calendarChooseDateMonthYear_Btn);
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

    public List<WebElement> getList_TabHeader_ListLbl() {
        return ActionHelper.findElementsWithoutWait(tabHeader_ListLbl.getBy());
    }

    public List<String> getText_TabHeader_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(tabHeader_ListLbl.getBy()));
    }

    public String getText_TabHeader_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(tabHeader_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_TabHeaderCheckbox_ListCheckbox() {
        return ActionHelper.findElementsWithoutWait(tabHeaderCheckbox_ListCheckbox.getBy());
    }

    public void checkCheckbox_TabHeaderCheckbox_ListCheckbox(int index) {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.waitUntilElementVisible(tabHeaderCheckbox_ListCheckbox.getBy());
        Utility.checkCheckbox(ActionHelper.findElements(tabHeaderCheckbox_ListCheckbox.getBy()).get(index));
    }

    public List<WebElement> getList_TabHeaderOrderId_ListLink() {
        return ActionHelper.findElementsWithoutWait(tabHeaderOrderId_ListLink.getBy());
    }

    public List<String> getText_TabHeaderOrderId_ListLink() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(tabHeaderOrderId_ListLink.getBy()));
    }

    public String getText_TabHeaderOrderId_ListLink(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(tabHeaderOrderId_ListLink.getBy()).get(index));
    }

    public void click_TabHeaderOrderId_ListLink(int index) {
        ActionHelper.click(ActionHelper.findElements(tabHeaderOrderId_ListLink.getBy()).get(index));
    }

    public List<WebElement> getList_TabHeaderStatus_ListLbl() {
        return ActionHelper.findElementsWithoutWait(tabHeaderStatus_ListLbl.getBy());
    }

    public List<String> getText_TabHeaderStatus_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(tabHeaderStatus_ListLbl.getBy()));
    }

    public String getText_TabHeaderStatus_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(tabHeaderStatus_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_TabHeaderNoOfShipments_ListLbl() {
        return ActionHelper.findElementsWithoutWait(tabHeaderNoOfShipments_ListLbl.getBy());
    }

    public List<String> getText_TabHeaderNoOfShipments_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(tabHeaderNoOfShipments_ListLbl.getBy()));
    }

    public String getText_TabHeaderNoOfShipments_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(tabHeaderNoOfShipments_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_TabHeaderWeight_ListLbl() {
        return ActionHelper.findElementsWithoutWait(tabHeaderWeight_ListLbl.getBy());
    }

    public List<String> getText_TabHeaderWeight_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(tabHeaderWeight_ListLbl.getBy()));
    }

    public String getText_TabHeaderWeight_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(tabHeaderWeight_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_TabHeaderVolume_ListLbl() {
        return ActionHelper.findElementsWithoutWait(tabHeaderVolume_ListLbl.getBy());
    }

    public List<String> getText_TabHeaderVolume_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(tabHeaderVolume_ListLbl.getBy()));
    }

    public String getText_TabHeaderVolume_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(tabHeaderVolume_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_TabHeaderPickupAddress_ListLbl() {
        return ActionHelper.findElementsWithoutWait(tabHeaderPickupAddress_ListLbl.getBy());
    }

    public List<String> getText_TabHeaderPickupAddress_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(tabHeaderPickupAddress_ListLbl.getBy()));
    }

    public String getText_TabHeaderPickupAddress_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(tabHeaderPickupAddress_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_TabHeaderDropAddress_ListLbl() {
        return ActionHelper.findElementsWithoutWait(tabHeaderDropAddress_ListLbl.getBy());
    }

    public List<String> getText_TabHeaderDropAddress_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(tabHeaderDropAddress_ListLbl.getBy()));
    }

    public String getText_TabHeaderDropAddress_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(tabHeaderDropAddress_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_TabHeaderPickupPostalCode_ListLbl() {
        return ActionHelper.findElementsWithoutWait(tabHeaderPickupPostalCode_ListLbl.getBy());
    }

    public List<String> getText_TabHeaderPickupPostalCode_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(tabHeaderPickupPostalCode_ListLbl.getBy()));
    }

    public String getText_TabHeaderPickupPostalCode_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(tabHeaderPickupPostalCode_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_TabHeaderDropPostalCode_ListLbl() {
        return ActionHelper.findElementsWithoutWait(tabHeaderDropPostalCode_ListLbl.getBy());
    }

    public List<String> getText_TabHeaderDropPostalCode_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(tabHeaderDropPostalCode_ListLbl.getBy()));
    }

    public String getText_TabHeaderDropPostalCode_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(tabHeaderDropPostalCode_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_TabHeaderPaymentType_ListLbl() {
        return ActionHelper.findElementsWithoutWait(tabHeaderPaymentType_ListLbl.getBy());
    }

    public List<String> getText_TabHeaderPaymentType_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(tabHeaderPaymentType_ListLbl.getBy()));
    }

    public String getText_TabHeaderPaymentType_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(tabHeaderPaymentType_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_TabHeaderAmount_ListLbl() {
        return ActionHelper.findElementsWithoutWait(tabHeaderAmount_ListLbl.getBy());
    }

    public List<String> getText_TabHeaderAmount_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(tabHeaderAmount_ListLbl.getBy()));
    }

    public String getText_TabHeaderAmount_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(tabHeaderAmount_ListLbl.getBy()).get(index));
    }

    public HashMap<String, String> getOrderSummary() {
        HashMap<String, String> orderSummary = new HashMap<>();
        orderSummary.put("ToBeAssignedData", getText_ToBeAssigned_Lbl());
        orderSummary.put("ToBeDispatchedData", getText_ToBeDispatched_Lbl());
        orderSummary.put("DispatchedData", getText_Dispatched_Lbl());
        orderSummary.put("DeliveredData", getText_Delivered_Lbl());
        orderSummary.put("FailedData", getText_Failed_Lbl());
        orderSummary.put("RemainingData", getText_Remaining_Lbl());
        return orderSummary;
    }

    public boolean isPresent_AssignRiderDropDownManualHeader_Lbl() {
        return ActionHelper.isPresent(assignRiderDropDownManualHeader_Lbl);
    }

    public boolean isPresent_AssignRiderDropDownManualRider_DropDown() {
        return ActionHelper.isPresent(assignRiderDropDownManualRider_DropDown);
    }

    public void click_AssignRiderDropDownManualRider_DropDown() {
        ActionHelper.click(assignRiderDropDownManualRider_DropDown);
        ActionHelper.waitForLoaderToHide();
    }

    public boolean isPresent_AssignRiderDropDownManualRiderDropDownData_Lbl() {
        return ActionHelper.isPresent(assignRiderDropDownManualRiderDropDownData_Lbl);
    }

    public void click_AssignRiderDropDownManualRiderDropDownData_Lbl() {
        ActionHelper.click(assignRiderDropDownManualRiderDropDownData_Lbl);
    }

    public boolean isPresent_AssignRiderDropDownManualAssign_Btn() {
        return ActionHelper.isPresent(assignRiderDropDownManualAssign_Btn);
    }

    public void click_AssignRiderDropDownManualAssign_Btn() {
        ActionHelper.click(assignRiderDropDownManualAssign_Btn);
    }

    public boolean isPresent_AssignRiderDropDownManualAssignAndStart_Btn() {
        return ActionHelper.isPresent(assignRiderDropDownManualAssignAndStart_Btn);
    }

    public void click_AssignRiderDropDownManualAssignAndStart_Btn() {
        ActionHelper.click(assignRiderDropDownManualAssignAndStart_Btn);
    }

    public String get_FirstElementOrderId_Txt() {
        ActionHelper.waitUntilElementVisible(firstElementOrderId_Txt.getBy());
        return ActionHelper.getText(firstElementOrderId_Txt);
    }

    public String get_FirstElementStatus_Lbl() {
        return ActionHelper.getText(firstElementStatus_Lbl);
    }

    public String get_FirstElementNoOfShipment_Lbl() {
        return ActionHelper.getText(firstElementNoOfShipment_Lbl);
    }

    public void set_AssignRiderSearch_TextBox(String input) {
        ActionHelper.sendKeys(assignRiderSearch_TextBox, input);
    }

    public boolean isPresent_FacilitiesLeftSubMenuItem() {
        return ActionHelper.isPresent(facilitiesLeftSubMenuItem);
    }

    public void click_ResourceLeftMenuItem() {
        ActionHelper.click(resourceLeftMenuItem);
    }

    public void click_FacilitiesLeftSubMenuItem() {
        if (isPresent_FacilitiesLeftSubMenuItem())
            ActionHelper.click(facilitiesLeftSubMenuItem);
        else {
            click_ResourceLeftMenuItem();
            ActionHelper.click(facilitiesLeftSubMenuItem);
        }
    }
}
