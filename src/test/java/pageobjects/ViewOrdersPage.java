package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class ViewOrdersPage {
    private static ViewOrdersPage _instance;
    private final Locator ordersHeader_Lbl = Locator.builder().withWeb(By.id("header_Lbl"));
    private final Locator home_BreadCrumb = Locator.builder().withWeb(By.id("/"));
    private final Locator orderList_BreadCrumb = Locator.builder().withWeb(By.id("/orders"));
    private final Locator resourceLeftMenuItem = Locator.builder().withWeb(By.xpath("//p[text()='Resources']"));
    private final Locator facilitiesLeftSubMenuItem = Locator.builder().withWeb(By.xpath("//p[text()='Facilities']"));
    private final Locator newOrder_Btn = Locator.builder().withWeb(By.xpath("//span[text()='New Order']"));
    private final Locator assignRider_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Assign Rider']"));
    private final Locator assignRider_DropDown = Locator.builder().withWeb(By.xpath("//div[text()='Assign Rider']//following-sibling::div"));
    private final Locator assignRiderDropDownManual_Opt = Locator.builder().withWeb(By.xpath("//p[text()='Manual']"));
    private final Locator assignRiderDropDownAutomatic_Opt = Locator.builder().withWeb(By.xpath("//p[text()='Automatic']"));
    private final Locator toBeAssign_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='To be Assigned']"));
    private final Locator toBeAssignData_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='To be Assigned']/preceding-sibling::p"));
    private final Locator toBeDispatched_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='To be dispatched']"));
    private final Locator toBeDispatchedData_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='To be dispatched']/preceding-sibling::p"));
    private final Locator startDispatches_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Start Dispatches']"));
    private final Locator dispatched_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Dispatched']"));
    private final Locator dispatchedData_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Dispatched']/preceding-sibling::p"));
    private final Locator trackDispatches_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Track Dispatches']"));
    private final Locator delivered_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Delivered']"));
    private final Locator deliveredData_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Delivered']/preceding-sibling::p"));
    private final Locator failed_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Failed']"));
    private final Locator failedData_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Failed']/preceding-sibling::p"));
    private final Locator remaining_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Remaining']"));
    private final Locator remainingData_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Remaining']/preceding-sibling::p"));
    private final Locator search_TxtField = Locator.builder().withWeb(By.id("search"));
    private final Locator status_Btn = Locator.builder().withWeb(By.id("headlessui-menu-button-30"));
    private final Locator createdDate_Btn = Locator.builder().withWeb(By.id("headlessui-menu-button-31"));
    private final Locator startDate_Txt = Locator.builder().withWeb(By.id("rangePicker"));
    private final Locator endDate_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='End date']"));
    private final Locator clearDate_Lnk = Locator.builder().withWeb(By.xpath("//span[@class='ant-picker-clear']"));
    private final Locator refresh_Btn = Locator.builder().withWeb(By.id("refresh_Btn"));
    private final Locator tableColumnNameOrderId = Locator.builder().withWeb(By.xpath("//th[text()='ORDER ID']"));
    private final Locator tableColumnNameStatus = Locator.builder().withWeb(By.xpath("//th[text()='STATUS']"));
    private final Locator tableColumnNameNoOfShipments = Locator.builder().withWeb(By.xpath("//th[text()='NO. OF SHIPMENTS']"));
    private final Locator tableColumnNameWeight = Locator.builder().withWeb(By.xpath("//th[text()='WEIGHT']"));
    private final Locator tableColumnNameVolume = Locator.builder().withWeb(By.xpath("//th[text()='VOLUME']"));
    private final Locator tableColumnNamePickupAddress = Locator.builder().withWeb(By.xpath("//th[text()='PICKUP ADRESS']"));
    private final Locator tableColumnNameDropAddress = Locator.builder().withWeb(By.xpath("//th[text()='DROP ADDRESS']"));
    private final Locator tableOrderId_CheckBox = Locator.builder().withWeb(By.xpath("(//tbody[@class='ant-table-tbody']//span)[1]"));

    private final Locator assignRiderDropDownManualHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Manual Assignment']"));
    private final Locator assignRiderDropDownManualRider_DropDown = Locator.builder().withWeb(By.xpath("//div[@class='space-y-2']"));
    private final Locator assignRiderDropDownManualRiderDropDownData_Lbl = Locator.builder().withWeb(By.xpath("(//div[@class='flex flex-col']/p[1])[1]"));
    private final Locator assignRiderDropDownManualAssign_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Assign']"));
    private final Locator assignRiderDropDownManualAssignAndStart_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Assign and Start']"));

    public static ViewOrdersPage getInstance() {
        if (_instance == null) _instance = new ViewOrdersPage();
        return _instance;
    }

    public boolean isPresent_OrdersHeader_Lbl() {
        return ActionHelper.isPresent(ordersHeader_Lbl);
    }

    public String getText_OrdersHeader_Lbl() {
        return ActionHelper.getText(ordersHeader_Lbl);
    }

    public boolean isPresent_Home_BreadCrumb() {
        return ActionHelper.isPresent(home_BreadCrumb);
    }

    public void click_Home_BreadCrumb() {
        ActionHelper.click(home_BreadCrumb);
    }

    public boolean isPresent_OrderList_BreadCrumb() {
        return ActionHelper.isPresent(orderList_BreadCrumb);
    }

    public void click_OrderList_BreadCrumb() {
        ActionHelper.click(orderList_BreadCrumb);
    }

    public boolean isPresent_ResourceLeftMenuItem() {
        return ActionHelper.isPresent(resourceLeftMenuItem);
    }

    public void click_ResourceLeftMenuItem() {
        ActionHelper.click(resourceLeftMenuItem);
    }

    public boolean isPresent_FacilitiesLeftSubMenuItem() {
        return ActionHelper.isPresent(facilitiesLeftSubMenuItem);
    }

    public void click_FacilitiesLeftSubMenuItem() {
        if(isPresent_FacilitiesLeftSubMenuItem())
            ActionHelper.click(facilitiesLeftSubMenuItem);
        else {
            click_ResourceLeftMenuItem();
            ActionHelper.click(facilitiesLeftSubMenuItem);
        }
    }

    public boolean isPresent_NewOrder_Btn() {
        return ActionHelper.isPresent(newOrder_Btn);
    }

    public void click_NewOrder_Btn() {
        ActionHelper.click(newOrder_Btn);
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
        return  ActionHelper.isPresent(assignRiderDropDownManual_Opt);
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

    public boolean isPresent_ToBeAssign_Lbl() {
        return ActionHelper.isPresent(toBeAssign_Lbl);
    }

    public boolean isPresent_ToBeAssignData_Lbl() {
        return ActionHelper.isPresent(toBeAssignData_Lbl);
    }

    public String getText_ToBeAssignData_Lbl() {
        return ActionHelper.getText(toBeAssignData_Lbl);
    }

    public boolean isPresent_ToBeDispatched_Lbl() {
        return ActionHelper.isPresent(toBeDispatched_Lbl);
    }

    public boolean isPresent_ToBeDispatchedData_Lbl() {
        return ActionHelper.isPresent(toBeDispatchedData_Lbl);
    }

    public String getText_ToBeDispatchedData_Lbl() {
        return ActionHelper.getText(toBeDispatchedData_Lbl);
    }

    public boolean isPresent_StartDispatches_Btn() {
        return ActionHelper.isPresent(startDispatches_Btn);
    }

    public void click_StartDispatches_Btn() {
        ActionHelper.click(startDispatches_Btn);
    }

    public boolean isPresent_Dispatched_Lbl() {
        return ActionHelper.isPresent(dispatched_Lbl);
    }

    public boolean isPresent_DispatchedData_Lbl() {
        return ActionHelper.isPresent(dispatchedData_Lbl);
    }

    public String getText_DispatchedData_Lbl() {
        return ActionHelper.getText(dispatchedData_Lbl);
    }

    public boolean isPresent_TrackDispatches_Btn() {
        return ActionHelper.isPresent(trackDispatches_Btn);
    }

    public void click_TrackDispatches_Btn() {
        ActionHelper.click(trackDispatches_Btn);
    }

    public boolean isPresent_Delivered_Lbl() {
        return ActionHelper.isPresent(delivered_Lbl);
    }

    public boolean isPresent_DeliveredData_Lbl() {
        return ActionHelper.isPresent(deliveredData_Lbl);
    }

    public String getText_DeliveredData_Lbl() {
        return ActionHelper.getText(deliveredData_Lbl);
    }

    public boolean isPresent_Failed_Lbl() {
        return ActionHelper.isPresent(failed_Lbl);
    }

    public boolean isPresent_FailedData_Lbl() {
        return ActionHelper.isPresent(failedData_Lbl);
    }

    public String getText_FailedData_Lbl() {
        return ActionHelper.getText(failedData_Lbl);
    }

    public boolean isPresent_Remaining_Lbl() {
        return ActionHelper.isPresent(remaining_Lbl);
    }

    public boolean isPresent_RemainingData_Lbl() {
        return ActionHelper.isPresent(remainingData_Lbl);
    }

    public String getText_RemainingData_Lbl() {
        return ActionHelper.getText(remainingData_Lbl);
    }

    public boolean isPresent_Search_TxtField() {
        return ActionHelper.isPresent(search_TxtField);
    }

    public void fill_Search_TxtField(String orderId) {
        ActionHelper.fillWithClear(search_TxtField.getBy(), orderId );
    }

    public boolean isPresent_Status_Btn() {
        return ActionHelper.isPresent(status_Btn);
    }

    public void click_Status_Btn() {
        ActionHelper.click(status_Btn);
    }

    public boolean isPresent_CreatedDate_Btn() {
        return ActionHelper.isPresent(createdDate_Btn);
    }

    public void click_CreatedDate_Btn() {
        ActionHelper.click(createdDate_Btn);
    }

    public boolean isPresent_StartDate_Txt() {
        return ActionHelper.isPresent(startDate_Txt);
    }

    public void click_StartDate_Txt() {
        ActionHelper.click(startDate_Txt);
    }

    public boolean isPresent_EndDate_Txt() {
        return ActionHelper.isPresent(endDate_Txt);
    }

    public void click_EndDate_Txt() {
        ActionHelper.click(endDate_Txt);
    }

    public boolean isPresent_ClearDate_Lnk() {
        return ActionHelper.isPresent(clearDate_Lnk);
    }

    public void click_ClearDate_Lnk() {
        ActionHelper.click(clearDate_Lnk);
    }

    public boolean isPresent_Refresh_Btn() {
        return ActionHelper.isPresent(refresh_Btn);
    }
    public void click_Refresh_Btn() {
        ActionHelper.click(refresh_Btn);
    }

    public boolean isPresent_TableColumnNameOrderId() {
        return ActionHelper.isPresent(tableColumnNameOrderId);
    }

    public boolean isPresent_TableColumnNameStatus() {
        return ActionHelper.isPresent(tableColumnNameStatus);
    }

    public boolean isPresent_TableColumnNameNoOfShipments() {
        return ActionHelper.isPresent(tableColumnNameNoOfShipments);
    }

    public boolean isPresent_TableColumnNameWeight() {
        return ActionHelper.isPresent(tableColumnNameWeight);
    }

    public boolean isPresent_TableColumnNameVolume() {
        return ActionHelper.isPresent(tableColumnNameVolume);
    }

    public boolean isPresent_TableColumnNamePickupAddress() {
        return ActionHelper.isPresent(tableColumnNamePickupAddress);
    }

    public boolean isPresent_TableColumnNameDropAddress() {
        return ActionHelper.isPresent(tableColumnNameDropAddress);
    }

    public boolean isPresent_TableOrderId_CheckBox() {
        return ActionHelper.isPresent(tableOrderId_CheckBox);
    }

    public void click_TableOrderId_CheckBox() {
        ActionHelper.click(tableOrderId_CheckBox);
    }

    public boolean isPresent_AssignRiderDropDownManualHeader_Lbl() {
        return ActionHelper.isPresent(assignRiderDropDownManualHeader_Lbl);
    }

    public boolean isPresent_AssignRiderDropDownManualRider_DropDown() {
        return ActionHelper.isPresent(assignRiderDropDownManualRider_DropDown);
    }

    public void click_AssignRiderDropDownManualRider_DropDown() {
        ActionHelper.click(assignRiderDropDownManualRider_DropDown);
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
}
