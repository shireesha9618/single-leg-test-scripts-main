package pageobjects;

import constants.Constants;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

import java.util.List;

import static constants.Constants.*;

public class DispatchDetailPage {
    private static DispatchDetailPage _instance;

    private final Locator header_Lbl = Locator.builder().withWeb(By.id("headerLabel"));
    private final Locator dispatchStatus_Lbl = Locator.builder().withWeb(By.xpath("//h6"));
    private final Locator edit_Img = Locator.builder().withWeb(By.xpath("//div[@id='headerLabel']/following-sibling::*"));
    private final Locator dispatchDetailBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//p[text()='Dispatch Detail']"));
    private final Locator totalShipmentCount_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Total Shipments']/preceding-sibling::p"));
    private final Locator totalShipmentCountText_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Total Shipments']"));
    private final Locator inventoryInHand_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Inventory in hand']/preceding-sibling::p"));
    private final Locator inventoryInHandText_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Inventory in hand']"));
    private final Locator expectedCashInHand_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Expected cash to be collected']/preceding-sibling::p"));
    private final Locator expectedCashInHandText_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Expected cash to be collected']"));
    private final Locator cashInHand_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Cash in hand']/preceding-sibling::p"));
    private final Locator cashInHandText_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Cash in hand']"));
    private final Locator firstElementScannableId_Lbl = Locator.builder().withWeb(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[2]"));
    private final Locator firstElementStatus_Lbl = Locator.builder().withWeb(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[3]"));
    private final Locator publishDispatch_Btn = Locator.builder().withWeb(By.xpath("//button[@id='publishDispatchButton']"));
    private final Locator publishDispatchCancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']"));
    private final Locator confirmPublishDispatch_Btn = Locator.builder().withWeb(By.xpath("//button[@id='publishButton']"));
    private final Locator removeFromDispatch_Btn = Locator.builder().withWeb(By.xpath("//button[@id='removeJobFromDispatchButton']/p"));
    private final Locator confirmPublishDispatchHeader_Lbl = Locator.builder().withWeb(By.xpath("//h1[@id='publishHeader']"));
    private final Locator cancelPublishDispatch_Lbl = Locator.builder().withWeb(By.xpath("//button[@id='cancelButton']"));

    private final Locator createDispatch_Btn = Locator.builder().withWeb(By.id("createDispatch"));
    private final Locator searchBar_Txt = Locator.builder().withWeb(By.id("search"));
    private final Locator status_Dropdown = Locator.builder().withWeb(By.xpath("//button/p[text()='Status']"));
    private final Locator statusDropdownAssigned_Radio = Locator.builder().withWeb(By.xpath("//input[@value='ASSIGNED']"));
    private final Locator statusDropdownInProgress_Radio = Locator.builder().withWeb(By.xpath("//input[@value='IN_PROGRESS']"));
    private final Locator statusDropdownCompleted_Radio = Locator.builder().withWeb(By.xpath("//input[@value='COMPLETED']"));

    private final Locator tableActions_Dropdown = Locator.builder().withWeb(By.xpath("//button/p[text()='Table Actions']"));
    private final Locator tableActionsDropdownModifyColumn_Link = Locator.builder().withWeb(By.xpath("//a[text()='Modify Columns']"));
    private final Locator tableActionsDropDownModifyColumnsLinkHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Edit Columns']"));
    private final Locator tableActionsDropDownModifyColumnsLinkSearchBar_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Search']"));
    private final Locator tableActionsDropDownModifyColumnsLinkSelectAll_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Select All']"));
    private final Locator tableActionsDropDownModifyColumnsLinkOptionsList_Label = Locator.builder().withWeb(By.xpath("//p[text()='Select All']/../../..//label/p"));
    private final Locator tableActionsDropDownModifyColumnsLinkOrderId_Checkbox = Locator.builder().withWeb(By.id("Order id"));
    private final Locator tableActionsDropDownModifyColumnsLinkStatus_Checkbox = Locator.builder().withWeb(By.id("Status"));
    private final Locator tableActionsDropDownModifyColumnsLinkNoOfShipments_Checkbox = Locator.builder().withWeb(By.id("no. of shipments"));
    private final Locator tableActionsDropDownModifyColumnsLinkWeight_Checkbox = Locator.builder().withWeb(By.id("Weight"));
    private final Locator tableActionsDropDownModifyColumnsLinkVolume_Checkbox = Locator.builder().withWeb(By.id("Volume"));
    private final Locator tableActionsDropDownModifyColumnsLinkPickupAddress_Checkbox = Locator.builder().withWeb(By.id("PICKUP ADDRESS"));
    private final Locator tableActionsDropDownModifyColumnsLinkDropAddress_Checkbox = Locator.builder().withWeb(By.id("DROP ADDRESS"));
    private final Locator tableActionsDropDownModifyColumnsLinkPickupPinCode_Checkbox = Locator.builder().withWeb(By.id("PICKUP PINCODE"));
    private final Locator tableActionsDropDownModifyColumnsLinkDropPinCode_Checkbox = Locator.builder().withWeb(By.id("DROP PINCODE"));
    private final Locator tableActionsDropDownModifyColumnsLinkPickupDate_Checkbox = Locator.builder().withWeb(By.id("PICKUP DATE"));
    private final Locator tableActionsDropDownModifyColumnsLinkDropDate_Checkbox = Locator.builder().withWeb(By.id("DROP DATE"));
    private final Locator tableActionsDropDownModifyColumnsLinkPickupContact_Checkbox = Locator.builder().withWeb(By.id("Pickup Contact"));
    private final Locator tableActionsDropDownModifyColumnsLinkDropContact_Checkbox = Locator.builder().withWeb(By.id("Drop contact"));
    private final Locator tableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label = Locator.builder().withWeb(By.xpath("//div[@data-rbd-droppable-id='droppable']/div/div/p"));
    private final Locator tableActionsDropDownModifyColumnsLinkSave_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Select All']/../../../../../following-sibling::div/button/p[text()='Save']"));
    private final Locator tableActionsDropDownModifyColumnsLinkCancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Select All']/../../../../../following-sibling::div/button/p[text()='Cancel']"));
    private final Locator tableActionsDropDownModifyColumnsLinkCross_Icon = Locator.builder().withWeb(By.xpath("//p[text()='Edit Columns']/following-sibling::*/*"));

    private final Locator scanToAddOrders_Btn = Locator.builder().withWeb(By.xpath("//span[normalize-space()='Scan to Add Orders']"));
    private final Locator refresh_Btn = Locator.builder().withWeb(By.id("refreshButton"));
    private final Locator downloadRunSheet_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Download Run Sheet']"));

    private final Locator shipmentDetailsTableColumnCheckbox_ListCheckbox = Locator.builder().withWeb(By.xpath("//td[@class='ant-table-cell ant-table-selection-column']//input"));
    private final Locator shipmentDetailsTableColumnPickupAddressShowHideName_ListBtn = Locator.builder().withWeb(By.xpath("//tbody/tr[td//input]/td[7]/div/div[1]/*"));
    private final Locator shipmentDetailsTableColumnPickupAddressName_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr[td//input]/td[7]/div/div[2]/p[1]"));
    private final Locator shipmentDetailsTableColumnPickupAddressAddress_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr[td//input]/td[7]/div/div[2]/p[2]"));
    private final Locator shipmentDetailsTableColumnDropAddressShowHideName_ListBtn = Locator.builder().withWeb(By.xpath("//tbody/tr[td//input]/td[8]/div/div[1]/*"));
    private final Locator shipmentDetailsTableColumnDropAddressName_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr[td//input]/td[8]/div/div[2]/p[1]"));
    private final Locator shipmentDetailsTableColumnDropAddressAddress_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr[td//input]/td[8]/div/div[2]/p[2]"));
    private final Locator shipmentDetailsTableColumnPickupContactShowHideNumber_ListBtn = Locator.builder().withWeb(By.xpath("//tbody/tr[td//input]/td[13]/div/div[1]/*"));
    private final Locator shipmentDetailsTableColumnPickupContactName_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr[td//input]/td[13]/p"));
    private final Locator shipmentDetailsTableColumnPickupContactNumber_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr[td//input]/td[13]/div/div[2]/p[1]"));
    private final Locator shipmentDetailsTableColumnDropContactShowHideNumber_ListBtn = Locator.builder().withWeb(By.xpath("//tbody/tr[td//input]/td[14]/div/div[1]/*"));
    private final Locator shipmentDetailsTableColumnDropContactName_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr[td//input]/td[14]/p"));
    private final Locator shipmentDetailsTableColumnDropContactNumber_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr[td//input]/td[14]/div/div[2]/p[1]"));

    private final Locator assignRiderPopupHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Edit Assignment']"));
    private final Locator assignRiderPopupVehicleMode_Txt = Locator.builder().withWeb(By.xpath("//div[h4[text()='Vehicle Model*']]/following-sibling::div//input"));
    private final Locator assignRiderPopupVehicleId_Txt = Locator.builder().withWeb(By.xpath("//div[h4[text()='Vehicle ID']]/following-sibling::div//input"));
    private final Locator assignRiderPopupRider_Txt = Locator.builder().withWeb(By.xpath("//div[h4[text()='Rider']]/following-sibling::div//input"));
    private final Locator assignRiderPopupRiderList_Options = Locator.builder().withWeb(By.xpath("//div[@class='ant-select-item ant-select-item-option']"));
    private final Locator assignRiderPopupOptions_ListBtn = Locator.builder().withWeb(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div"));
    private final Locator assignRiderPopupCross_Img = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Edit Assignment']/../*[name()='svg']"));
    private final Locator assignRiderPopupAssign_Btn = Locator.builder().withWeb(By.id("submitForm"));
    private final Locator assignRiderPopupCancel_Btn = Locator.builder().withWeb(By.xpath("//div[@class='flex justify-end']//button[@type='button']"));
    private final Locator assignRiderPopupVehicleModel_TxtBox = Locator.builder().withWeb(By.xpath("//div[h4[text()='Vehicle Model*']]/following-sibling::div//input"));
    private final Locator assignRiderPopupVehicleModelList_Options = Locator.builder().withWeb(By.xpath("//div[@class='ant-select-item ant-select-item-option']/div[@class='ant-select-item-option-content']"));

    private final Locator successfullyUpdatedPopup_Lbl = Locator.builder().withWeb(By.xpath("//div[contains(@class,'shadow-md max-w-md transition-all transform duration')]"));
    private final Locator reloadingDispatchDataPopup_Lbl = Locator.builder().withWeb(By.xpath("//div[text()='Reloading dispatch data']"));
    private final Locator orderId_Txt = Locator.builder().withWeb(By.xpath("//tr[contains(@data-row-key,'job')]/td[2]"));
    private final Locator dispatchList_Btn = Locator.builder().withWeb(By.xpath("//p[contains(text(),'Dispatch List')]"));
    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//p[contains(text(),'Dispatch List')]"));

    public static DispatchDetailPage getInstance() {
        if (_instance == null) _instance = new DispatchDetailPage();
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        return ActionHelper.isPresent(header_Lbl, WAIT_FOR_FIVE_SECOND);
    }

    public String getText_Header_Lbl() {
        return ActionHelper.getText(header_Lbl);
    }

    public String get_TotalShipmentCount_Lbl() {
        return ActionHelper.getText(totalShipmentCount_Lbl);
    }

    public String get_InventoryInHand_Lbl() {
        return ActionHelper.getText(inventoryInHand_Lbl);
    }

    public String get_ExpectedCashInHand_Lbl() {
        return ActionHelper.getText(expectedCashInHand_Lbl);
    }

    public String get_CashInHand_Lbl() {
        return ActionHelper.getText(cashInHand_Lbl);
    }

    public String get_FirstElementScannableId_Lbl() {
        ActionHelper.waitForLoaderToHide();
        return ActionHelper.getText(firstElementScannableId_Lbl);
    }

    public String get_FirstElementStatus_Lbl() {
        return ActionHelper.getText(firstElementStatus_Lbl);
    }

    public boolean isPresent_DispatchStatus_Lbl() {
        return ActionHelper.isPresent(dispatchStatus_Lbl);
    }

    public String getText_DispatchStatus_Lbl() {
        return ActionHelper.getText(dispatchStatus_Lbl);
    }

    public boolean isPresent_dispatchDetailBreadCrumb_Link() {
        return ActionHelper.isPresent(dispatchDetailBreadCrumb_Link);
    }

    public void click_PublishDispatch_Btn() {
        ActionHelper.click(publishDispatch_Btn);
        ActionHelper.waitForLoaderToHide();
    }

    public void click_ConfirmPublishDispatch_Btn() {
        ActionHelper.click(confirmPublishDispatch_Btn);
        ActionHelper.waitForLoaderToHide();
        DriverManager.getDriver().navigate().refresh();
    }

    public Boolean isPresent_ConfirmPublishDispatchHeader_Lbl() {
        return ActionHelper.isPresent(confirmPublishDispatchHeader_Lbl);
    }

    public void click_PublishDispatchCancel_Btn() {
        ActionHelper.click(publishDispatchCancel_Btn);
    }

    public boolean isPresent_PublishDispatchCancel_Btn() {
        return ActionHelper.isPresent(publishDispatchCancel_Btn);
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
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void fillWithClear_SearchBar_Txt(String value) {
        ActionHelper.fillWithClear(searchBar_Txt.getBy(), value);
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

    public boolean isPresent_StatusDropdownAssigned_Radio() {
        return ActionHelper.isPresent(statusDropdownAssigned_Radio);
    }

    public void checkCheckbox_StatusDropdownAssigned_Radio() {
        Utility.checkCheckbox(statusDropdownAssigned_Radio.getBy());
    }

    public boolean isPresent_StatusDropdownInProgress_Radio() {
        return ActionHelper.isPresent(statusDropdownInProgress_Radio);
    }

    public void checkCheckbox_StatusDropdownInProgress_Radio() {
        Utility.checkCheckbox(statusDropdownInProgress_Radio.getBy());
    }

    public boolean isPresent_StatusDropdownCompleted_Radio() {
        return ActionHelper.isPresent(statusDropdownCompleted_Radio);
    }

    public void checkCheckbox_StatusDropdownCompleted_Radio() {
        Utility.checkCheckbox(statusDropdownCompleted_Radio.getBy());
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
        ActionHelper.click(tableActionsDropdownModifyColumn_Link);
    }

    public String getText_TableActionsDropdownModifyColumn_Link() {
        return ActionHelper.getText(tableActionsDropdownModifyColumn_Link);
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkHeader_Lbl() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkHeader_Lbl, Constants.WAIT_FOR_FIVE_SECOND);
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
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkCross_Icon() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkCross_Icon);
    }

    public void click_TableActionsDropDownModifyColumnsLinkCross_Icon() {
        ActionHelper.click(tableActionsDropDownModifyColumnsLinkCross_Icon);
    }

    public boolean isPresent_ScanToAddOrders_Btn() {
        return ActionHelper.isPresent(scanToAddOrders_Btn);
    }

    public void click_ScanToAddOrders_Btn() {
        ActionHelper.click(scanToAddOrders_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_ScanToAddOrders_Btn() {
        return ActionHelper.getText(scanToAddOrders_Btn);
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
        Actions actions = new Actions(DriverManager.getDriver());
        actions.clickAndHold(elements.get(fromIndex)).moveByOffset(-10, 0).moveToElement(elements.get(toIndex)).release().pause(Constants.WAIT_FOR_FIVE_SECOND).perform();
    }


    public boolean isPresent_TableActionsDropDownModifyColumnsLinkOrderId_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkOrderId_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkOrderId_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkOrderId_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkNoOfShipments_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkNoOfShipments_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkNoOfShipments_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkNoOfShipments_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkWeight_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkWeight_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkWeight_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkWeight_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkStatus_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkStatus_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkStatus_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkStatus_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkVolume_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkVolume_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkVolume_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkVolume_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkPickupAddress_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkPickupAddress_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkPickupAddress_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkPickupAddress_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkDropAddress_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkDropAddress_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkDropAddress_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkDropAddress_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkPickupPinCode_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkPickupPinCode_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkPickupPinCode_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkPickupPinCode_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkDropPinCode_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkDropPinCode_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkDropPinCode_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkDropPinCode_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkPickupDate_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkPickupDate_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkPickupDate_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkPickupDate_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkDropDate_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkDropDate_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkDropDate_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkDropDate_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkPickupContact_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkPickupContact_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkPickupContact_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkPickupContact_Checkbox.getBy());
    }

    public boolean isPresent_TableActionsDropDownModifyColumnsLinkDropContact_Checkbox() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumnsLinkDropContact_Checkbox);
    }

    public void click_TableActionsDropDownModifyColumnsLinkDropContact_Checkbox() {
        Utility.checkCheckbox(tableActionsDropDownModifyColumnsLinkDropContact_Checkbox.getBy());
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

    public boolean isPresent_DownloadRunSheet_Btn() {
        return ActionHelper.isPresent(downloadRunSheet_Btn);
    }

    public void click_DownloadRunSheet_Btn() {
        ActionHelper.click(downloadRunSheet_Btn);
    }

    public String getText_DownloadRunSheet_Btn() {
        return ActionHelper.getText(downloadRunSheet_Btn);
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnCheckbox_ListCheckbox() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnCheckbox_ListCheckbox.getBy());
    }

    public void checkCheckbox_ShipmentDetailsTableColumnCheckbox_ListCheckbox(int index) {
        Utility.checkCheckbox(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnCheckbox_ListCheckbox.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnPickupAddressShowHideName_ListBtn() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupAddressShowHideName_ListBtn.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnPickupAddressShowHideName_ListBtn() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupAddressShowHideName_ListBtn.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnPickupAddressShowHideName_ListBtn(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupAddressShowHideName_ListBtn.getBy()).get(index));
    }

    public void click_ShipmentDetailsTableColumnPickupAddressShowHideName_ListBtn(int index) {
        ActionHelper.click(ActionHelper.findElements(shipmentDetailsTableColumnPickupAddressShowHideName_ListBtn.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnPickupAddressName_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupAddressName_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnPickupAddressName_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupAddressName_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnPickupAddressName_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupAddressName_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnPickupAddressAddress_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupAddressAddress_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnPickupAddressAddress_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupAddressAddress_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnPickupAddressAddress_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupAddressAddress_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnDropAddressShowHideName_ListBtn() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropAddressShowHideName_ListBtn.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnDropAddressShowHideName_ListBtn() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropAddressShowHideName_ListBtn.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnDropAddressShowHideName_ListBtn(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropAddressShowHideName_ListBtn.getBy()).get(index));
    }

    public void click_ShipmentDetailsTableColumnDropAddressShowHideName_ListBtn(int index) {
        ActionHelper.click(ActionHelper.findElements(shipmentDetailsTableColumnDropAddressShowHideName_ListBtn.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnDropAddressName_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropAddressName_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnDropAddressName_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropAddressName_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnDropAddressName_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropAddressName_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnDropAddressAddress_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropAddressAddress_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnDropAddressAddress_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropAddressAddress_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnDropAddressAddress_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropAddressAddress_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnPickupContactShowHideNumber_ListBtn() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupContactShowHideNumber_ListBtn.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnPickupContactShowHideNumber_ListBtn() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupContactShowHideNumber_ListBtn.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnPickupContactShowHideNumber_ListBtn(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupContactShowHideNumber_ListBtn.getBy()).get(index));
    }

    public void click_ShipmentDetailsTableColumnPickupContactShowHideNumber_ListBtn(int index) {
        ActionHelper.click(ActionHelper.findElements(shipmentDetailsTableColumnPickupContactShowHideNumber_ListBtn.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnPickupContactName_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupContactName_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnPickupContactName_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupContactName_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnPickupContactName_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupContactName_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnPickupContactNumber_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupContactNumber_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnPickupContactNumber_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupContactNumber_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnPickupContactNumber_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnPickupContactNumber_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnDropContactShowHideNumber_ListBtn() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropContactShowHideNumber_ListBtn.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnDropContactShowHideNumber_ListBtn() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropContactShowHideNumber_ListBtn.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnDropContactShowHideNumber_ListBtn(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropContactShowHideNumber_ListBtn.getBy()).get(index));
    }

    public void click_ShipmentDetailsTableColumnDropContactShowHideNumber_ListBtn(int index) {
        ActionHelper.click(ActionHelper.findElements(shipmentDetailsTableColumnDropContactShowHideNumber_ListBtn.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnDropContactName_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropContactName_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnDropContactName_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropContactName_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnDropContactName_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropContactName_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnDropContactNumber_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropContactNumber_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnDropContactNumber_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropContactNumber_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnDropContactNumber_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDropContactNumber_ListLbl.getBy()).get(index));
    }

    public boolean isPresent_AssignRiderPopupHeader_Lbl() {
        return ActionHelper.isPresent(assignRiderPopupHeader_Lbl, WAIT_FOR_ONE_SECOND);
    }

    public String getText_AssignRiderPopupHeader_Lbl() {
        return ActionHelper.getText(assignRiderPopupHeader_Lbl);
    }

    public boolean isPresent_AssignRiderPopupVehicleMode_Txt() {
        return ActionHelper.isPresent(assignRiderPopupVehicleMode_Txt);
    }

    public void fill_AssignRiderPopupVehicleMode_Txt(String value) {
        ActionHelper.fill(assignRiderPopupVehicleMode_Txt, value);
    }

    public void fillWithClear_AssignRiderPopupVehicleMode_Txt(String value) {
        ActionHelper.fillWithClear(assignRiderPopupVehicleMode_Txt.getBy(), value);
    }

    public void clear_AssignRiderPopupVehicleMode_Txt() {
        ActionHelper.clear(assignRiderPopupVehicleMode_Txt.getBy());
    }

    public String getValue_AssignRiderPopupVehicleMode_Txt() {
        return ActionHelper.getAttribute(assignRiderPopupVehicleMode_Txt, "value");
    }

    public boolean isPresent_AssignRiderPopupVehicleId_Txt() {
        return ActionHelper.isPresent(assignRiderPopupVehicleId_Txt);
    }

    public void fill_AssignRiderPopupVehicleId_Txt(String value) {
        ActionHelper.fill(assignRiderPopupVehicleId_Txt, value);
    }

    public void fillWithClear_AssignRiderPopupVehicleId_Txt(String value) {
        ActionHelper.fillWithClear(assignRiderPopupVehicleId_Txt.getBy(), value);
    }

    public void clear_AssignRiderPopupVehicleId_Txt() {
        ActionHelper.clear(assignRiderPopupVehicleId_Txt.getBy());
    }

    public String getValue_AssignRiderPopupVehicleId_Txt() {
        return ActionHelper.getAttribute(assignRiderPopupVehicleId_Txt, "value");
    }

    public boolean isPresent_AssignRiderPopupRider_Txt() {
        return ActionHelper.isPresent(assignRiderPopupRider_Txt);
    }

    public void fill_AssignRiderPopupRider_Txt(String value) {
        ActionHelper.fill(assignRiderPopupRider_Txt, value);
    }

    public void fillWithClear_AssignRiderPopupRider_Txt(String value) {
        ActionHelper.fillWithClear(assignRiderPopupRider_Txt.getBy(), value);
    }

    public void clear_AssignRiderPopupRider_Txt() {
        ActionHelper.clear(assignRiderPopupRider_Txt.getBy());
    }

    public String getValue_AssignRiderPopupRider_Txt() {
        return ActionHelper.getAttribute(assignRiderPopupRider_Txt, "value");
    }

    public boolean isPresent_Edit_Img() {
        return ActionHelper.isPresent(edit_Img);
    }

    public void click_Edit_Img() {
        ActionHelper.click(edit_Img);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_AssignRiderPopupCross_Img() {
        return ActionHelper.isPresent(assignRiderPopupCross_Img);
    }

    public void click_AssignRiderPopupCross_Img() {
        ActionHelper.click(assignRiderPopupCross_Img);
    }

    public boolean isPresent_AssignRiderPopupAssign_Btn() {
        return ActionHelper.isPresent(assignRiderPopupAssign_Btn);
    }

    public void click_AssignRiderPopupAssign_Btn() {
        ActionHelper.click(assignRiderPopupAssign_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_AssignRiderPopupAssign_Btn() {
        return ActionHelper.getText(assignRiderPopupAssign_Btn);
    }

    public boolean isPresent_AssignRiderPopupCancel_Btn() {
        return ActionHelper.isPresent(assignRiderPopupCancel_Btn);
    }

    public void click_AssignRiderPopupCancel_Btn() {
        ActionHelper.click(assignRiderPopupCancel_Btn);
    }

    public String getText_AssignRiderPopupCancel_Btn() {
        return ActionHelper.getText(assignRiderPopupCancel_Btn);
    }

    public boolean isPresent_SuccessfullyUpdatedPopup_Lbl() {
        return ActionHelper.isPresent(successfullyUpdatedPopup_Lbl, WAIT_FOR_FIVE_SECOND);
    }

    public boolean isPresent_ReloadingDispatchDataPopup_Lbl() {
        return ActionHelper.isPresent(reloadingDispatchDataPopup_Lbl, WAIT_FOR_FIVE_SECOND);
    }

    public List<WebElement> getList_AssignRiderPopupOptions_ListBtn() {
        return ActionHelper.findElementsWithoutWait(assignRiderPopupOptions_ListBtn.getBy());
    }

    public List<String> getText_AssignRiderPopupOptions_ListBtn() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(assignRiderPopupOptions_ListBtn.getBy()));
    }

    public String getText_AssignRiderPopupOptions_ListBtn(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(assignRiderPopupOptions_ListBtn.getBy()).get(index));
    }

    public void click_AssignRiderPopupOptions_ListBtn(int index) {
        ActionHelper.click(ActionHelper.findElements(assignRiderPopupOptions_ListBtn.getBy()).get(index));
    }

    public void click_RemoveFromDispatch_Btn() {
        ActionHelper.click(removeFromDispatch_Btn.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void clickAndChoose_PaginationDropDownOptions_Btn(int pagination) {
        waitTillAllOrdersAreLoaded();
        CommonActions.getInstance().choosePaginationOption(pagination);
        waitTillAllOrdersAreLoaded();
    }

    public void waitTillAllOrdersAreLoaded() {
        List<WebElement> orders = CommonActions.getInstance().getWebElementList_TableDataList_Lbl("ORDER ID");
        ActionHelper.waitUntilElementClickable(orders.get(orders.size() - 1));
    }

    public String getValue_OrderId_Txt(int orderIdIndex) {
        ActionHelper.waitUntilElementVisible(orderId_Txt.getBy());
        return ActionHelper.getText(ActionHelper.findElements(orderId_Txt).get(orderIdIndex));
    }

    public boolean isPresent_OrderId_Txt() {
        return ActionHelper.isPresent(orderId_Txt, WAIT_FOR_ONE_SECOND);
    }

    public void click_DispatchList_Btn() {
        Utility.scrollUsingJS(dispatchList_Btn.getBy());
        ActionHelper.click(dispatchList_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_OrderId_Txt(int indexOfOrder) {
        return ActionHelper.isPresent(ActionHelper.findElements(orderId_Txt).get(indexOfOrder), WAIT_FOR_ONE_SECOND);
    }

    public void scrollToOrderId(int indexOfOrder) {
        Utility.validatePageScrollUp(ActionHelper.findElements(orderId_Txt).get(indexOfOrder));
    }

    public void click_Cancel_Btn() {
        ActionHelper.click(cancel_Btn);
    }

    public void select_PopUpRider_As(String riderName) {
        CommonActions.getInstance().clickElementUsingActionClass(ActionHelper.findElement(assignRiderPopupRider_Txt));
        for (WebElement rider : DriverManager.getDriver().findElements(assignRiderPopupRiderList_Options.getBy())) {
            if (rider.getText().toLowerCase().contains(riderName.toLowerCase())) {
                Utility.scrollTillToTheElement(rider);
                CommonActions.getInstance().clickElementUsingActionClass(rider);
                break;
            }

        }
    }

    public void select_PopUpVehicleModel_As(String vehicleModelNAme) {
        CommonActions.getInstance().clickElementUsingActionClass(ActionHelper.findElement(assignRiderPopupVehicleModel_TxtBox));
        for (WebElement rider : DriverManager.getDriver().findElements(assignRiderPopupVehicleModelList_Options.getBy())) {
            if (rider.getText().toLowerCase().contains(vehicleModelNAme.toLowerCase())) {
                Utility.scrollTillToTheElement(rider);
                CommonActions.getInstance().clickElementUsingActionClass(rider);
                break;
            }
        }
    }

    public void select_PopUpVehicleId_As(String vehicleId) {
        CommonActions.getInstance().clickElementUsingActionClass(ActionHelper.findElement(assignRiderPopupVehicleId_Txt));
        for (WebElement rider : DriverManager.getDriver().findElements(assignRiderPopupVehicleModelList_Options.getBy())) {
            if (rider.getText().toLowerCase().contains(vehicleId.toLowerCase())) {
                Utility.scrollTillToTheElement(rider);
                CommonActions.getInstance().clickElementUsingActionClass(rider);
                break;
            }
        }
    }

    public String getText_UpdatedPopup_Txt() {
        ActionHelper.waitUntilElementVisible(successfullyUpdatedPopup_Lbl.getBy());
        ActionHelper.isPresent(successfullyUpdatedPopup_Lbl,WAIT_FOR_TWO_SECOND);
        return ActionHelper.getText(successfullyUpdatedPopup_Lbl);
    }
}
