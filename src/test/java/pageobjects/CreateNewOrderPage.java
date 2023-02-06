package pageobjects;

import com.github.javafaker.Faker;
import constants.Constants;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utility.Utility;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateNewOrderPage {
    private static CreateNewOrderPage _instance;

    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//h2[text()='Create New Order']"));
    private final Locator homeBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/']/p[text()='Home']"));
    private final Locator orderListBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/orders/']/p[text()='Order List']"));
    private final Locator createOrderBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/orders/add/']/p[text()='Create Order']"));

    private final Locator orderDetailsHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Order Details']"));
    private final Locator orderDetailsOrderId_Txt = Locator.builder().withWeb(By.xpath("//input[@name='orderId']"));
    private final Locator orderDetailsScannableBarcodeNumber_Txt = Locator.builder().withWeb(By.xpath("//input[@name='barcodeNumber']"));
    private final Locator orderDetailsOrderDescription_Txt = Locator.builder().withWeb(By.xpath("//input[@name='orderDescription']"));
    private final Locator orderDetailsTeam_Dropdown = Locator.builder().withWeb(By.xpath("(//span[@class='ant-select-selection-search']/following-sibling::span)[2]"));
    private final Locator orderDetailsTotalWeight_Txt = Locator.builder().withWeb(By.xpath("//label[text()='Total Weight (kg)']/following-sibling::div/div/input[@placeholder='Total Weight']"));
    private final Locator orderDetailsTotalVolume_Txt = Locator.builder().withWeb(By.xpath("//label[text()='Total Volume (cu.cm)']/following-sibling::div/div/input[@placeholder='Total Volume']"));

    private final Locator shipmentDetailsHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Shipment Details']"));
    private final Locator shipmentDetailsShipmentID_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Shipment ID']"));
    private final Locator shipmentDetailsShipmentId_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Shipment ID' and @value='']"));
    private final Locator shipmentDetailsDescription_Txt = Locator.builder().withWeb(By.xpath("//tbody/tr/td[2]/div//div/input[@placeholder='Enter Description' and @value='']"));
    private final Locator getShipmentDetailsDescription_Txt = Locator.builder().withWeb(By.xpath("//tbody/tr/td[2]/div//div/input[@placeholder='Enter Description']"));

    private final Locator shipmentDetailsWeight_Txt = Locator.builder().withWeb(By.xpath("//td[3]/div//div/input[@placeholder='Enter Weight']"));
    private final Locator shipmentDetailsVolume_Txt = Locator.builder().withWeb(By.xpath("//td[4]/div//div/input[@placeholder='Enter Volume']"));
    private final Locator setShipmentDetailsVolume_Txt = Locator.builder().withWeb(By.xpath("//tbody/tr/td[4]/div//div/input[@value='0']"));
    private final Locator setShipmentDetailsWeight_Txt = Locator.builder().withWeb(By.xpath("//tbody/tr/td[3]/div//div/input[@value='0']"));
    private final Locator shipmentDetailsDimensionsLength_Txt = Locator.builder().withWeb(By.xpath("//tbody/tr/td[5]/div//div/input[@placeholder='l']"));
    private final Locator shipmentDetailsDimensionsBreadth_Txt = Locator.builder().withWeb(By.xpath("//tbody/tr/td[5]/div//div/input[@placeholder='b']"));
    private final Locator shipmentDetailsDimensionsHeight_Txt = Locator.builder().withWeb(By.xpath("//tbody/tr/td[5]/div//div/input[@placeholder='h']"));
    private final Locator shipmentDetailsDelete_Btn = Locator.builder().withWeb(By.xpath("//td[div//input[@placeholder='h']]/following-sibling::td"));
    private final Locator shipmentDetailsTableColumnShipmentID_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[1]//input"));
    private final Locator shipmentDetailsTableColumnDescription_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[2]//input"));
    private final Locator shipmentDetailsTableColumnWeight_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[3]//input"));
    private final Locator shipmentDetailsTableColumnVolume_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[4]//input"));
    private final Locator shipmentDetailsTableColumnDimensionsLength_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[5]/div/span[1][text()]"));
    private final Locator shipmentDetailsTableColumnDimensionsBreadth_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[5]/div/span[2][text()]"));
    private final Locator shipmentDetailsTableColumnDimensionsHeight_ListLbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[5]/div/span[3][text()]"));
    private final Locator shipmentDetailsTableColumnDelete_ListBtn = Locator.builder().withWeb(By.xpath("//tbody/tr/td[6]"));
    private final Locator shipmentDetailsAddShipment_Btn = Locator.builder().withWeb(By.xpath("//span[text()='Add Shipment']"));

    private final Locator pickupDetailsHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Pickup Details']"));
    private final Locator pickupDetailsFacilityStore_Radio = Locator.builder().withWeb(By.xpath("//input[@value='pickupStore']"));
    private final Locator pickupDetailsCustomAddress_Radio = Locator.builder().withWeb(By.xpath("//input[@value='pickupAaddress']"));
    private final Locator pickupDetailsContactName_Txt = Locator.builder().withWeb(By.xpath("//input[@name='contactName']"));
    private final Locator pickupDetailsContactNumber_Txt = Locator.builder().withWeb(By.xpath("//input[@name='primaryMobile']"));
    private final Locator pickupDetailsSelectAFacility_Dropdown = Locator.builder().withWeb(By.xpath("//label[text()='Facility*']/following-sibling::div//input[@type='search']"));
    private final Locator pickupDetailsSelectAFacility_Txt = Locator.builder().withWeb(By.xpath("//label[text()='Facility*']//following-sibling::div//span[@class='ant-select-selection-item']"));
    private final Locator pickupDetailsPostalCode_Txt = Locator.builder().withWeb(By.xpath("//input[@name='postalCode']"));
    private final Locator pickupDetailsCountry_Select = Locator.builder().withWeb(By.xpath("//select[@placeholder='Enter Country']"));
    private final Locator pickupDetailsAddressLine1_Txt = Locator.builder().withWeb(By.xpath("//input[@name='addressLine1']"));
    private final Locator pickupDetailsAddressLine2_Txt = Locator.builder().withWeb(By.xpath("//input[@name='addressLine2']"));
    private final Locator pickupDetailsState_Txt = Locator.builder().withWeb(By.xpath("//input[@name='state']"));
    private final Locator pickupDetailsCity_Txt = Locator.builder().withWeb(By.xpath("//input[@name='city']"));
    private final Locator pickupDetailsPickupDate_Txt = Locator.builder().withWeb(By.xpath("//input[@name='pickupDate']"));
    private final Locator pickupDetailsPickupSlotFrom_Txt = Locator.builder().withWeb(By.xpath("//input[@name='pickupSlotFrom']"));
    private final Locator pickupDetailsPickupSlotTo_Txt = Locator.builder().withWeb(By.xpath("//input[@name='pickupSlotTo']"));
    private final Locator pickupDetailsClearAll_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Clear All']"));

    private final Locator dropDetailsHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Drop Details']"));
    private final Locator dropDetailsFacilityStore_Radio = Locator.builder().withWeb(By.xpath("//input[@value='store']"));
    private final Locator dropDetailsCustomAddress_Radio = Locator.builder().withWeb(By.xpath("//input[@value='address']"));
    private final Locator dropDetailsContactName_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropContactName']"));
    private final Locator dropDetailsContactNumber_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropPrimaryMobile']"));
    private final Locator dropDetailsSelectAFacility_Dropdown = Locator.builder().withWeb(By.xpath("(//label[text()='Facility*']/following-sibling::div//input[@type='search'])[2]"));
    private final Locator dropDetailsSelectAFacility_Txt = Locator.builder().withWeb(By.xpath("(//label[text()='Facility*']//following-sibling::div//span[@class='ant-select-selection-item'])[2]"));
    private final Locator dropDetailsPostalCode_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropPostalCode']"));
    private final Locator dropDetailsCountry_Select = Locator.builder().withWeb(By.xpath("(//select[@placeholder='Enter Country'])[2]"));
    private final Locator dropDetailsAddressLine1_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropAddressLine1']"));
    private final Locator dropDetailsAddressLine2_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropAddressLine2']"));
    private final Locator dropDetailsState_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropState']"));
    private final Locator dropDetailsCity_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropCity']"));
    private final Locator dropDetailsDropDate_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropDate']"));
    private final Locator dropDetailsDropSlotFrom_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropSlotFrom']"));
    private final Locator dropDetailsDropSlotTo_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropSlotTo']"));
    private final Locator dropDetailsClearAll_Btn = Locator.builder().withWeb(By.xpath("(//div[text()='Clear All'])[2]"));

    private final Locator selectAFacilityDropdownOptions_ListBtn = Locator.builder().withWeb(By.xpath("(//div[@class='rc-virtual-list'])[last()]//p"));

    private final Locator paymentDetailsHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Payment Details']"));
    private final Locator paymentDetailsPaymentType_Select = Locator.builder().withWeb(By.xpath("//select[@placeholder='Select Payment Type']"));
    private final Locator paymentDetailsPaymentTypeSelect_Option = Locator.builder().withWeb(By.xpath("//select[@placeholder='Select Payment Type']/option"));

    private final Locator paymentDetailsOrderAmount_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Order Amount']"));

    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']"));
    private final Locator create_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Create']"));

    private final Locator successToastMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[text()='Order Creation Success']"));
    private final Locator duplicateOrderIdToastMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[text()='Duplicate clientOrderId']"));
    private final Locator samePickupAndDropFacilityToastMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[text()='Same Pickup and Drop facility, Drop facility needs to be different from Pickup facility']"));
    private final Locator onlyPrepaidOrdersAllowedForMultipleShipmentsToastMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[text()='Only prepaid orders allowed for multiple shipments']"));

    private final Locator orderDetailsOrderIdValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='orderId']]/following-sibling::p"));
    private final Locator orderDetailsOrderDescriptionValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='orderDescription']]/following-sibling::p"));
    private final Locator orderDetailsTeamValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[label[text()='Team*']]//input/following-sibling::span"));

    private final Locator shipmentDetailsValidationError_Lbl = Locator.builder().withWeb(By.xpath("//button[p//span[text()='Add Shipment']]/preceding-sibling::p"));

    private final Locator pickupDetailsContactNameValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='contactName']]/following-sibling::p"));
    private final Locator pickupDetailsContactNumberValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/div/input[@name='primaryMobile']]/following-sibling::p"));
    private final Locator pickupDetailsSelectAFacilityValidationError_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Pickup Details']/../following-sibling::div//span[text()='Select a Facility']/parent::div/../following-sibling::p"));
    private final Locator pickupDetailsPostalCodeValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='postalCode']]/following-sibling::p"));
    private final Locator pickupDetailsCountryValidationError_Lbl = Locator.builder().withWeb(By.xpath("//select[@placeholder='Enter Country']/following-sibling::p"));
    private final Locator pickupDetailsAddressLine1ValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='addressLine1']]/following-sibling::p"));
    private final Locator pickupDetailsAddressLine2ValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='addressLine2']]/following-sibling::p"));
    private final Locator pickupDetailsStateValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='state']]/following-sibling::p"));
    private final Locator pickupDetailsCityValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='city']]/following-sibling::p"));
    private final Locator pickupDetailsPickupDateValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='pickupDate']]/following-sibling::p"));

    private final Locator dropDetailsContactNameValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='dropContactName']]/following-sibling::p"));
    private final Locator dropDetailsContactNumberValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/div/input[@name='dropPrimaryMobile']]/following-sibling::p"));
    private final Locator dropDetailsSelectAFacilityValidationError_Lbl = Locator.builder().withWeb(By.xpath("(//label[text()='Select a Facility*']/following-sibling::p)[2]"));
    private final Locator dropDetailsPostalCodeValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='dropPostalCode']]/following-sibling::p"));
    private final Locator dropDetailsCountryValidationError_Lbl = Locator.builder().withWeb(By.xpath("(//select[@placeholder='Enter Country']/following-sibling::p)[2]"));
    private final Locator dropDetailsAddressLine1ValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='dropAddressLine1']]/following-sibling::p"));
    private final Locator dropDetailsAddressLine2ValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='dropAddressLine2']]/following-sibling::p"));
    private final Locator dropDetailsStateValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='dropState']]/following-sibling::p"));
    private final Locator dropDetailsCityValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='dropCity']]/following-sibling::p"));
    private final Locator dropDetailsDropDateValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='dropDate']]/following-sibling::p"));

    private final Locator paymentDetailsPaymentTypeValidationError_Lbl = Locator.builder().withWeb(By.xpath("//select[@placeholder='Select Payment Type']/following-sibling::p"));

    private final Locator addFacility_Btn = Locator.builder().withWeb(By.xpath("//div[@class='ant-select-item ant-select-item-option ant-select-item-option-active']//p"));

    private final Locator addNewFacilityHeader_Lbl = Locator.builder().withWeb(By.xpath("//h2[text()='Add New Facility']"));
    private final Locator addFacilityFacilityName_Txt = Locator.builder().withWeb(By.xpath("//input[@name='basicDetails.name']"));
    private final Locator addFacilityFacilityId_Txt = Locator.builder().withWeb(By.xpath("//input[@name='basicDetails.ID']"));
    private final Locator addFacilityPostalCode_Txt = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.postalCode']"));
    private final Locator addFacilityCountry_Txt = Locator.builder().withWeb(By.xpath("//div[h4[text()='Country*']]/following-sibling::div//input"));
    private final Locator addFacilityAddressLine1_Txt = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.addressLine1']"));
    private final Locator addFacilityAddressLine2_Txt = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.addressLine2']"));
    private final Locator addFacilityState_Txt = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.state']"));
    private final Locator addFacilityCity_Txt = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.city']"));
    private final Locator addFacilityCreate_Btn = Locator.builder().withWeb(By.xpath("//button[p[text()='Create']]"));
    private final Locator addFacilityCancel_Btn = Locator.builder().withWeb(By.xpath("//button[p[text()='Cancel']]"));

    private final Locator addFacilityFacilityNameValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='basicDetails.name']]/following-sibling::p"));
    private final Locator addFacilityFacilityIdValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='basicDetails.ID']]/following-sibling::p"));
    private final Locator addFacilityPostalCodeValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='addressDetails.postalCode']]/following-sibling::p"));
    private final Locator addFacilityAddressLine1ValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='addressDetails.addressLine1']]/following-sibling::p"));
    private final Locator addFacilityAddressLine2ValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='addressDetails.addressLine2']]/following-sibling::p"));
    private final Locator addFacilityStateValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='addressDetails.state']]/following-sibling::p"));
    private final Locator addFacilityCityValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@name='addressDetails.city']]/following-sibling::p"));

    private final Locator addFacilityPinCodeDataNotFoundToastMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[text()='Pincode data not found.']"));
    private final Locator addShipmentRequiredParamShipmentIdToastMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[text()='Required Param Shipment Id']"));
    private final Locator addShipmentRequiredParamDescriptionToastMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[text()='Required Param Description']"));
    private final Locator shipmentDetailsRow = Locator.builder().withWeb(By.xpath("//tbody/tr"));
    Faker sampleData = new Faker();

    public static CreateNewOrderPage getInstance() {
        if (_instance == null) {
            _instance = new CreateNewOrderPage();
        }
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        CommonActions.getInstance().waitTillLoaderDisappears();
        return ActionHelper.isPresent(header_Lbl, 2000);
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

    public boolean isPresent_CreateOrderBreadcrumb_Link() {
        return ActionHelper.isPresent(createOrderBreadcrumb_Link);
    }

    public void click_CreateOrderBreadcrumb_Link() {
        ActionHelper.click(createOrderBreadcrumb_Link);
    }

    public String getText_CreateOrderBreadcrumb_Link() {
        return ActionHelper.getText(createOrderBreadcrumb_Link);
    }

    public boolean isPresent_OrderDetailsHeader_Lbl() {
        return ActionHelper.isPresent(orderDetailsHeader_Lbl);
    }

    public String getText_OrderDetailsHeader_Lbl() {
        return ActionHelper.getText(orderDetailsHeader_Lbl);
    }

    public boolean isPresent_OrderDetailsOrderId_Txt() {
        return ActionHelper.isPresent(orderDetailsOrderId_Txt);
    }

    public void fill_OrderDetailsOrderId_Txt(String value) {
        ActionHelper.findElement(orderDetailsOrderId_Txt).sendKeys(value, Keys.TAB);
    }

    public void fillWithClear_OrderDetailsOrderId_Txt(String value) {
        Utility.selectAllAndClear(orderDetailsOrderId_Txt.getBy());
        ActionHelper.fillWithClear(orderDetailsOrderId_Txt.getBy(), value);
    }

    public void clear_OrderDetailsOrderId_Txt() {
        ActionHelper.clear(orderDetailsOrderId_Txt.getBy());
    }

    public String getValue_OrderDetailsOrderId_Txt() {
        return ActionHelper.getAttribute(orderDetailsOrderId_Txt, "value");
    }

    public boolean isPresent_OrderDetailsScannableBarcodeNumber_Txt() {
        return ActionHelper.isPresent(orderDetailsScannableBarcodeNumber_Txt);
    }

    public void fill_OrderDetailsScannableBarcodeNumber_Txt(String value) {
        ActionHelper.fill(orderDetailsScannableBarcodeNumber_Txt, value);
    }

    public void fillWithClear_OrderDetailsScannableBarcodeNumber_Txt(String value) {
        Utility.selectAllAndClear(orderDetailsScannableBarcodeNumber_Txt.getBy());
        ActionHelper.fillWithClear(orderDetailsScannableBarcodeNumber_Txt.getBy(), value);
    }

    public void clear_OrderDetailsScannableBarcodeNumber_Txt() {
        ActionHelper.clear(orderDetailsScannableBarcodeNumber_Txt.getBy());
    }

    public String getValue_OrderDetailsScannableBarcodeNumber_Txt() {
        return ActionHelper.getAttribute(orderDetailsScannableBarcodeNumber_Txt, "value");
    }

    public boolean isPresent_OrderDetailsOrderDescription_Txt() {
        return ActionHelper.isPresent(orderDetailsOrderDescription_Txt);
    }

    public void fill_OrderDetailsOrderDescription_Txt(String value) {
        ActionHelper.fill(orderDetailsOrderDescription_Txt, value);
    }

    public void fillWithClear_OrderDetailsOrderDescription_Txt(String value) {
        ActionHelper.sendKeysWithClear(orderDetailsOrderDescription_Txt.getBy(), value);
    }

    public void clear_OrderDetailsOrderDescription_Txt() {
        ActionHelper.clear(orderDetailsOrderDescription_Txt.getBy());
    }

    public String getValue_OrderDetailsOrderDescription_Txt() {
        return ActionHelper.getAttribute(orderDetailsOrderDescription_Txt, "value");
    }

    public boolean isPresent_OrderDetailsTeam_Dropdown() {
        return ActionHelper.isPresent(orderDetailsTeam_Dropdown);
    }

    public void click_OrderDetailsTeam_Dropdown() {
        ActionHelper.click(orderDetailsTeam_Dropdown);
    }

    public String getValue_OrderDetailsTeam_Dropdown() {
        return ActionHelper.getAttribute(orderDetailsTeam_Dropdown, "title");
    }

    public void select_OrderDetailsTeam_Dropdown(String input) {
        CommonActions.getInstance().waitTillLoaderDisappears();
        ActionHelper.click(orderDetailsTeam_Dropdown);
        ActionHelper.sendKeys(orderDetailsTeam_Dropdown, Keys.chord(input, Keys.ENTER));
    }

    public boolean isPresent_PickupDetailsHeader_Lbl() {
        return ActionHelper.isPresent(pickupDetailsHeader_Lbl);
    }

    public String getText_PickupDetailsHeader_Lbl() {
        return ActionHelper.getText(pickupDetailsHeader_Lbl);
    }

    public boolean isPresent_PickupDetailsContactName_Txt() {
        return ActionHelper.isPresent(pickupDetailsContactName_Txt);
    }

    public void fill_PickupDetailsContactName_Txt(String value) {
        ActionHelper.fill(pickupDetailsContactName_Txt, value);
    }

    public void fillWithClear_PickupDetailsContactName_Txt(String value) {
        Utility.selectAllAndClear(pickupDetailsContactName_Txt.getBy());
        ActionHelper.fillWithClear(pickupDetailsContactName_Txt.getBy(), value);
    }

    public void clear_PickupDetailsContactName_Txt() {
        ActionHelper.clear(pickupDetailsContactName_Txt.getBy());
    }

    public String getValue_PickupDetailsContactName_Txt() {
        return ActionHelper.getAttribute(pickupDetailsContactName_Txt, "value");
    }

    public boolean isPresent_PickupDetailsContactNumber_Txt() {
        return ActionHelper.isPresent(pickupDetailsContactNumber_Txt);
    }

    public void fill_PickupDetailsContactNumber_Txt(String value) {
        ActionHelper.fill(pickupDetailsContactNumber_Txt, value);
    }

    public void fillWithClear_PickupDetailsContactNumber_Txt(String value) {
        Utility.selectAllAndClear(pickupDetailsContactNumber_Txt.getBy());
        ActionHelper.fillWithClear(pickupDetailsContactNumber_Txt.getBy(), value);
    }

    public void clear_PickupDetailsContactNumber_Txt() {
        ActionHelper.clear(pickupDetailsContactNumber_Txt.getBy());
    }

    public String getValue_PickupDetailsContactNumber_Txt() {
        return ActionHelper.getAttribute(pickupDetailsContactNumber_Txt, "value");
    }

    public boolean isPresent_PickupDetailsSelectAFacility_Dropdown() {
        return ActionHelper.isPresent(pickupDetailsSelectAFacility_Dropdown);
    }

    public void click_PickupDetailsSelectAFacility_Dropdown() {
        ActionHelper.click(pickupDetailsSelectAFacility_Dropdown);
    }

    public String getValue_PickupDetailsSelectAFacility_Dropdown() {
        return ActionHelper.getAttribute(pickupDetailsSelectAFacility_Txt, "title");
    }

    public boolean isPresent_PickupDetailsPostalCode_Txt() {
        return ActionHelper.isPresent(pickupDetailsPostalCode_Txt);
    }

    public void fill_PickupDetailsPostalCode_Txt(String value) {
        ActionHelper.fill(pickupDetailsPostalCode_Txt, value);
    }

    public void fillWithClear_PickupDetailsPostalCode_Txt(String value) {
        Utility.selectAllAndClear(pickupDetailsPostalCode_Txt.getBy());
        ActionHelper.fillWithClear(pickupDetailsPostalCode_Txt.getBy(), value);
    }

    public void clear_PickupDetailsPostalCode_Txt() {
        ActionHelper.clear(pickupDetailsPostalCode_Txt.getBy());
    }

    public String getValue_PickupDetailsPostalCode_Txt() {
        return ActionHelper.getAttribute(pickupDetailsPostalCode_Txt, "title");
    }

    public boolean isPresent_PickupDetailsCountry_Select() {
        return ActionHelper.isPresent(pickupDetailsCountry_Select);
    }

    public void click_PickupDetailsCountry_Select() {
        ActionHelper.click(pickupDetailsCountry_Select);
    }

    public void selectByValue_PickupDetailsCountry_Select(String value) {
        new Select(ActionHelper.findElement(pickupDetailsCountry_Select)).selectByValue(value);
    }

    public void selectByVisibleText_PickupDetailsCountry_Select(String value) {
        new Select(ActionHelper.findElement(pickupDetailsCountry_Select)).selectByVisibleText(value);
    }

    public List<String> getAvailableValues_PickupDetailsCountry_Select() {
        return Utility.getText_ListOfWebElements(new Select(ActionHelper.findElement(pickupDetailsCountry_Select)).getOptions());
    }

    public String getFirstSelectedOption_PickupDetailsCountry_Select() {
        return new Select(ActionHelper.findElement(pickupDetailsCountry_Select)).getFirstSelectedOption().getText();
    }

    public boolean isPresent_PickupDetailsAddressLine1_Txt() {
        return ActionHelper.isPresent(pickupDetailsAddressLine1_Txt);
    }

    public void fill_PickupDetailsAddressLine1_Txt(String value) {
        ActionHelper.fill(pickupDetailsAddressLine1_Txt, value);
    }

    public void fillWithClear_PickupDetailsAddressLine1_Txt(String value) {
        Utility.selectAllAndClear(pickupDetailsAddressLine1_Txt.getBy());
        ActionHelper.fillWithClear(pickupDetailsAddressLine1_Txt.getBy(), value);
    }

    public void clear_PickupDetailsAddressLine1_Txt() {
        ActionHelper.clear(pickupDetailsAddressLine1_Txt.getBy());
    }

    public String getValue_PickupDetailsAddressLine1_Txt() {
        return ActionHelper.getAttribute(pickupDetailsAddressLine1_Txt, "value");
    }

    public boolean isPresent_PickupDetailsAddressLine2_Txt() {
        return ActionHelper.isPresent(pickupDetailsAddressLine2_Txt);
    }

    public void fill_PickupDetailsAddressLine2_Txt(String value) {
        ActionHelper.fill(pickupDetailsAddressLine2_Txt, value);
    }

    public void fillWithClear_PickupDetailsAddressLine2_Txt(String value) {
        Utility.selectAllAndClear(pickupDetailsAddressLine2_Txt.getBy());
        ActionHelper.fillWithClear(pickupDetailsAddressLine2_Txt.getBy(), value);
    }

    public void clear_PickupDetailsAddressLine2_Txt() {
        ActionHelper.clear(pickupDetailsAddressLine2_Txt.getBy());
    }

    public String getValue_PickupDetailsAddressLine2_Txt() {
        return ActionHelper.getAttribute(pickupDetailsAddressLine2_Txt, "value");
    }

    public boolean isPresent_PickupDetailsState_Txt() {
        return ActionHelper.isPresent(pickupDetailsState_Txt);
    }

    public void fill_PickupDetailsState_Txt(String value) {
        ActionHelper.fill(pickupDetailsState_Txt, value);
    }

    public void fillWithClear_PickupDetailsState_Txt(String value) {
        Utility.selectAllAndClear(pickupDetailsState_Txt.getBy());
        ActionHelper.fillWithClear(pickupDetailsState_Txt.getBy(), value);
    }

    public void clear_PickupDetailsState_Txt() {
        ActionHelper.clear(pickupDetailsState_Txt.getBy());
    }

    public String getValue_PickupDetailsState_Txt() {
        return ActionHelper.getAttribute(pickupDetailsState_Txt, "value");
    }

    public boolean isPresent_PickupDetailsCity_Txt() {
        return ActionHelper.isPresent(pickupDetailsCity_Txt);
    }

    public void fill_PickupDetailsCity_Txt(String value) {
        ActionHelper.fill(pickupDetailsCity_Txt, value);
    }

    public void fillWithClear_PickupDetailsCity_Txt(String value) {
        Utility.selectAllAndClear(pickupDetailsCity_Txt.getBy());
        ActionHelper.fillWithClear(pickupDetailsCity_Txt.getBy(), value);
    }

    public void clear_PickupDetailsCity_Txt() {
        ActionHelper.clear(pickupDetailsCity_Txt.getBy());
    }

    public String getValue_PickupDetailsCity_Txt() {
        return ActionHelper.getAttribute(pickupDetailsCity_Txt, "value");
    }

    public boolean isPresent_PickupDetailsClearAll_Btn() {
        return ActionHelper.isPresent(pickupDetailsClearAll_Btn);
    }

    public void click_PickupDetailsClearAll_Btn() {
        ActionHelper.click(pickupDetailsClearAll_Btn);
    }

    public String getText_PickupDetailsClearAll_Btn() {
        return ActionHelper.getText(pickupDetailsClearAll_Btn);
    }

    public boolean isPresent_DropDetailsHeader_Lbl() {
        return ActionHelper.isPresent(dropDetailsHeader_Lbl);
    }

    public String getText_DropDetailsHeader_Lbl() {
        return ActionHelper.getText(dropDetailsHeader_Lbl);
    }

    public boolean isPresent_DropDetailsContactName_Txt() {
        return ActionHelper.isPresent(dropDetailsContactName_Txt);
    }

    public void fill_DropDetailsContactName_Txt(String value) {
        ActionHelper.fill(dropDetailsContactName_Txt, value);
    }

    public void fillWithClear_DropDetailsContactName_Txt(String value) {
        Utility.selectAllAndClear(dropDetailsContactName_Txt.getBy());
        ActionHelper.fillWithClear(dropDetailsContactName_Txt.getBy(), value);
    }

    public void clear_DropDetailsContactName_Txt() {
        ActionHelper.clear(dropDetailsContactName_Txt.getBy());
    }

    public String getValue_DropDetailsContactName_Txt() {
        return ActionHelper.getAttribute(dropDetailsContactName_Txt, "value");
    }

    public boolean isPresent_DropDetailsContactNumber_Txt() {
        return ActionHelper.isPresent(dropDetailsContactNumber_Txt);
    }

    public void fill_DropDetailsContactNumber_Txt(String value) {
        ActionHelper.fill(dropDetailsContactNumber_Txt, value);
    }

    public void fillWithClear_DropDetailsContactNumber_Txt(String value) {
        Utility.selectAllAndClear(dropDetailsContactNumber_Txt.getBy());
        ActionHelper.fillWithClear(dropDetailsContactNumber_Txt.getBy(), value);
    }

    public void clear_DropDetailsContactNumber_Txt() {
        ActionHelper.clear(dropDetailsContactNumber_Txt.getBy());
    }

    public String getValue_DropDetailsContactNumber_Txt() {
        return ActionHelper.getAttribute(dropDetailsContactNumber_Txt, "value");
    }

    public boolean isPresent_DropDetailsSelectAFacility_Dropdown() {
        return ActionHelper.isPresent(dropDetailsSelectAFacility_Dropdown);
    }

    public void click_DropDetailsSelectAFacility_Dropdown() {
        ActionHelper.click(dropDetailsSelectAFacility_Dropdown);
    }

    public String getValue_DropDetailsSelectAFacility_Dropdown() {
        return ActionHelper.getAttribute(dropDetailsSelectAFacility_Dropdown, "value");
    }

    public boolean isPresent_DropDetailsPostalCode_Txt() {
        return ActionHelper.isPresent(dropDetailsPostalCode_Txt);
    }

    public void fill_DropDetailsPostalCode_Txt(String value) {
        ActionHelper.fill(dropDetailsPostalCode_Txt, value);
    }

    public void fillWithClear_DropDetailsPostalCode_Txt(String value) {
        Utility.selectAllAndClear(dropDetailsPostalCode_Txt.getBy());
        ActionHelper.fillWithClear(dropDetailsPostalCode_Txt.getBy(), value);
    }

    public void clear_DropDetailsPostalCode_Txt() {
        ActionHelper.clear(dropDetailsPostalCode_Txt.getBy());
    }

    public String getValue_DropDetailsPostalCode_Txt() {
        return ActionHelper.getAttribute(dropDetailsPostalCode_Txt, "value");
    }

    public boolean isPresent_DropDetailsCountry_Select() {
        return ActionHelper.isPresent(dropDetailsCountry_Select);
    }

    public void click_DropDetailsCountry_Select() {
        ActionHelper.click(dropDetailsCountry_Select);
    }

    public void selectByValue_DropDetailsCountry_Select(String value) {
        new Select(ActionHelper.findElement(dropDetailsCountry_Select)).selectByValue(value);
    }

    public void selectByVisibleText_DropDetailsCountry_Select(String value) {
        new Select(ActionHelper.findElement(dropDetailsCountry_Select)).selectByVisibleText(value);
    }

    public List<String> getAvailableValues_DropDetailsCountry_Select() {
        return Utility.getText_ListOfWebElements(new Select(ActionHelper.findElement(dropDetailsCountry_Select)).getOptions());
    }

    public String getFirstSelectedOption_DropDetailsCountry_Select() {
        return new Select(ActionHelper.findElement(dropDetailsCountry_Select)).getFirstSelectedOption().getText();
    }

    public boolean isPresent_DropDetailsAddressLine1_Txt() {
        return ActionHelper.isPresent(dropDetailsAddressLine1_Txt);
    }

    public void fill_DropDetailsAddressLine1_Txt(String value) {
        ActionHelper.fill(dropDetailsAddressLine1_Txt, value);
    }

    public void fillWithClear_DropDetailsAddressLine1_Txt(String value) {
        Utility.selectAllAndClear(dropDetailsAddressLine1_Txt.getBy());
        ActionHelper.fillWithClear(dropDetailsAddressLine1_Txt.getBy(), value);
    }

    public void clear_DropDetailsAddressLine1_Txt() {
        ActionHelper.clear(dropDetailsAddressLine1_Txt.getBy());
    }

    public String getValue_DropDetailsAddressLine1_Txt() {
        return ActionHelper.getAttribute(dropDetailsAddressLine1_Txt, "value");
    }

    public boolean isPresent_DropDetailsAddressLine2_Txt() {
        return ActionHelper.isPresent(dropDetailsAddressLine2_Txt);
    }

    public void fill_DropDetailsAddressLine2_Txt(String value) {
        ActionHelper.fill(dropDetailsAddressLine2_Txt, value);
    }

    public void fillWithClear_DropDetailsAddressLine2_Txt(String value) {
        Utility.selectAllAndClear(dropDetailsAddressLine2_Txt.getBy());
        ActionHelper.fillWithClear(dropDetailsAddressLine2_Txt.getBy(), value);
    }

    public void clear_DropDetailsAddressLine2_Txt() {
        ActionHelper.clear(dropDetailsAddressLine2_Txt.getBy());
    }

    public String getValue_DropDetailsAddressLine2_Txt() {
        return ActionHelper.getAttribute(dropDetailsAddressLine2_Txt, "value");
    }

    public boolean isPresent_DropDetailsState_Txt() {
        return ActionHelper.isPresent(dropDetailsState_Txt);
    }

    public void fill_DropDetailsState_Txt(String value) {
        ActionHelper.fill(dropDetailsState_Txt, value);
    }

    public void fillWithClear_DropDetailsState_Txt(String value) {
        Utility.selectAllAndClear(dropDetailsState_Txt.getBy());
        ActionHelper.fillWithClear(dropDetailsState_Txt.getBy(), value);
    }

    public void clear_DropDetailsState_Txt() {
        ActionHelper.clear(dropDetailsState_Txt.getBy());
    }

    public String getValue_DropDetailsState_Txt() {
        return ActionHelper.getAttribute(dropDetailsState_Txt, "value");
    }

    public boolean isPresent_DropDetailsCity_Txt() {
        return ActionHelper.isPresent(dropDetailsCity_Txt);
    }

    public void fill_DropDetailsCity_Txt(String value) {
        ActionHelper.fill(dropDetailsCity_Txt, value);
    }

    public void fillWithClear_DropDetailsCity_Txt(String value) {
        Utility.selectAllAndClear(dropDetailsCity_Txt.getBy());
        ActionHelper.fillWithClear(dropDetailsCity_Txt.getBy(), value);
    }

    public void clear_DropDetailsCity_Txt() {
        ActionHelper.clear(dropDetailsCity_Txt.getBy());
    }

    public String getValue_DropDetailsCity_Txt() {
        return ActionHelper.getAttribute(dropDetailsCity_Txt, "value");
    }

    public boolean isPresent_DropDetailsClearAll_Btn() {
        return ActionHelper.isPresent(dropDetailsClearAll_Btn);
    }

    public void click_DropDetailsClearAll_Btn() {
        ActionHelper.click(dropDetailsClearAll_Btn);
    }

    public String getText_DropDetailsClearAll_Btn() {
        return ActionHelper.getText(dropDetailsClearAll_Btn);
    }

    public boolean isPresent_PaymentDetailsHeader_Lbl() {
        return ActionHelper.isPresent(paymentDetailsHeader_Lbl);
    }

    public String getText_PaymentDetailsHeader_Lbl() {
        return ActionHelper.getText(paymentDetailsHeader_Lbl);
    }

    public boolean isPresent_PaymentDetailsPaymentType_Select() {
        return ActionHelper.isPresent(paymentDetailsPaymentType_Select);
    }

    public void click_PaymentDetailsPaymentType_Select() {
        ActionHelper.click(paymentDetailsPaymentType_Select);
    }

    public void selectByValue_PaymentDetailsPaymentType_Select(String value) {
        new Select(ActionHelper.findElement(paymentDetailsPaymentType_Select)).selectByValue(value);
    }

    public void selectByVisibleText_PaymentDetailsPaymentType_Select(String value) {
        new Select(ActionHelper.findElement(paymentDetailsPaymentType_Select)).selectByVisibleText(value);
    }

    public List<String> getAvailableValues_PaymentDetailsPaymentType_Select() {
        return Utility.getText_ListOfWebElements(new Select(ActionHelper.findElement(paymentDetailsPaymentType_Select)).getOptions());
    }

    public boolean isPresent_PaymentDetailsOrderAmount_Txt() {
        return ActionHelper.isPresent(paymentDetailsOrderAmount_Txt);
    }

    public void fill_PaymentDetailsOrderAmount_Txt(String value) {
        ActionHelper.fill(paymentDetailsOrderAmount_Txt, value);
    }

    public void fillWithClear_PaymentDetailsOrderAmount_Txt(String value) {
        Utility.selectAllAndClear(paymentDetailsOrderAmount_Txt.getBy());
        ActionHelper.fillWithClear(paymentDetailsOrderAmount_Txt.getBy(), value);
    }

    public void clear_PaymentDetailsOrderAmount_Txt() {
        ActionHelper.clear(paymentDetailsOrderAmount_Txt.getBy());
    }

    public String getValue_PaymentDetailsOrderAmount_Txt() {
        return ActionHelper.getAttribute(paymentDetailsOrderAmount_Txt, "value");
    }

    public boolean isPresent_Cancel_Btn() {
        return ActionHelper.isPresent(cancel_Btn);
    }

    public void click_Cancel_Btn() {
        ActionHelper.click(cancel_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_Cancel_Btn() {
        return ActionHelper.getText(cancel_Btn);
    }

    public boolean isPresent_Create_Btn() {
        return ActionHelper.isPresent(create_Btn);
    }

    public void click_CreateBtn_WithWait() {
        ActionHelper.click(create_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
        CommonActions.getInstance().click_SkipIfPresent_Btn();
    }

    public void click_Create_Btn() {
        ActionHelper.click(create_Btn);
    }

    public String getText_Create_Btn() {
        return ActionHelper.getText(create_Btn);
    }

    public boolean isPresent_OrderDetailsOrderIdValidationError_Lbl() {
        return ActionHelper.isPresent(orderDetailsOrderIdValidationError_Lbl);
    }

    public String getText_OrderDetailsOrderIdValidationError_Lbl() {
        return ActionHelper.getText(orderDetailsOrderIdValidationError_Lbl);
    }

    public boolean isPresent_OrderDetailsOrderDescriptionValidationError_Lbl() {
        return ActionHelper.isPresent(orderDetailsOrderDescriptionValidationError_Lbl);
    }

    public String getText_OrderDetailsOrderDescriptionValidationError_Lbl() {
        return ActionHelper.getText(orderDetailsOrderDescriptionValidationError_Lbl);
    }

    public boolean isPresent_OrderDetailsTeamValidationError_Lbl() {
        return ActionHelper.isPresent(orderDetailsTeamValidationError_Lbl);
    }

    public String getText_OrderDetailsTeamValidationError_Lbl() {
        return ActionHelper.getText(orderDetailsTeamValidationError_Lbl);
    }

    public boolean isPresent_ShipmentDetailsValidationError_Lbl() {
        return ActionHelper.isPresent(shipmentDetailsValidationError_Lbl);
    }

    public String getText_ShipmentDetailsValidationError_Lbl() {
        return ActionHelper.getText(shipmentDetailsValidationError_Lbl);
    }

    public boolean isPresent_PickupDetailsContactNameValidationError_Lbl() {
        return ActionHelper.isPresent(pickupDetailsContactNameValidationError_Lbl);
    }

    public String getText_PickupDetailsContactNameValidationError_Lbl() {
        return ActionHelper.getText(pickupDetailsContactNameValidationError_Lbl);
    }

    public boolean isPresent_PickupDetailsContactNumberValidationError_Lbl() {
        return ActionHelper.isPresent(pickupDetailsContactNumberValidationError_Lbl);
    }

    public String getText_PickupDetailsContactNumberValidationError_Lbl() {
        return ActionHelper.getText(pickupDetailsContactNumberValidationError_Lbl);
    }

    public boolean isPresent_PickupDetailsSelectAFacilityValidationError_Lbl() {
        return ActionHelper.isPresent(pickupDetailsSelectAFacilityValidationError_Lbl);
    }

    public String getText_PickupDetailsSelectAFacilityValidationError_Lbl() {
        return ActionHelper.getText(pickupDetailsSelectAFacilityValidationError_Lbl);
    }

    public boolean isPresent_PickupDetailsPostalCodeValidationError_Lbl() {
        return ActionHelper.isPresent(pickupDetailsPostalCodeValidationError_Lbl);
    }

    public String getText_PickupDetailsPostalCodeValidationError_Lbl() {
        return ActionHelper.getText(pickupDetailsPostalCodeValidationError_Lbl);
    }

    public boolean isPresent_PickupDetailsCountryValidationError_Lbl() {
        return ActionHelper.isPresent(pickupDetailsCountryValidationError_Lbl);
    }

    public String getText_PickupDetailsCountryValidationError_Lbl() {
        return ActionHelper.getText(pickupDetailsCountryValidationError_Lbl);
    }

    public boolean isPresent_PickupDetailsAddressLine1ValidationError_Lbl() {
        return ActionHelper.isPresent(pickupDetailsAddressLine1ValidationError_Lbl);
    }

    public String getText_PickupDetailsAddressLine1ValidationError_Lbl() {
        return ActionHelper.getText(pickupDetailsAddressLine1ValidationError_Lbl);
    }

    public boolean isPresent_PickupDetailsAddressLine2ValidationError_Lbl() {
        return ActionHelper.isPresent(pickupDetailsAddressLine2ValidationError_Lbl);
    }

    public String getText_PickupDetailsAddressLine2ValidationError_Lbl() {
        return ActionHelper.getText(pickupDetailsAddressLine2ValidationError_Lbl);
    }

    public boolean isPresent_PickupDetailsStateValidationError_Lbl() {
        return ActionHelper.isPresent(pickupDetailsStateValidationError_Lbl);
    }

    public String getText_PickupDetailsStateValidationError_Lbl() {
        return ActionHelper.getText(pickupDetailsStateValidationError_Lbl);
    }

    public boolean isPresent_PickupDetailsCityValidationError_Lbl() {
        return ActionHelper.isPresent(pickupDetailsCityValidationError_Lbl);
    }

    public String getText_PickupDetailsCityValidationError_Lbl() {
        return ActionHelper.getText(pickupDetailsCityValidationError_Lbl);
    }

    public boolean isPresent_PickupDetailsPickupDateValidationError_Lbl() {
        return ActionHelper.isPresent(pickupDetailsPickupDateValidationError_Lbl);
    }

    public String getText_PickupDetailsPickupDateValidationError_Lbl() {
        return ActionHelper.getText(pickupDetailsPickupDateValidationError_Lbl);
    }

    public boolean isPresent_DropDetailsContactNameValidationError_Lbl() {
        return ActionHelper.isPresent(dropDetailsContactNameValidationError_Lbl);
    }

    public String getText_DropDetailsContactNameValidationError_Lbl() {
        return ActionHelper.getText(dropDetailsContactNameValidationError_Lbl);
    }

    public boolean isPresent_DropDetailsContactNumberValidationError_Lbl() {
        return ActionHelper.isPresent(dropDetailsContactNumberValidationError_Lbl);
    }

    public String getText_DropDetailsContactNumberValidationError_Lbl() {
        return ActionHelper.getText(dropDetailsContactNumberValidationError_Lbl);
    }

    public boolean isPresent_DropDetailsSelectAFacilityValidationError_Lbl() {
        return ActionHelper.isPresent(dropDetailsSelectAFacilityValidationError_Lbl);
    }

    public String getText_DropDetailsSelectAFacilityValidationError_Lbl() {
        return ActionHelper.getText(dropDetailsSelectAFacilityValidationError_Lbl);
    }

    public boolean isPresent_DropDetailsPostalCodeValidationError_Lbl() {
        return ActionHelper.isPresent(dropDetailsPostalCodeValidationError_Lbl);
    }

    public String getText_DropDetailsPostalCodeValidationError_Lbl() {
        return ActionHelper.getText(dropDetailsPostalCodeValidationError_Lbl);
    }

    public boolean isPresent_DropDetailsCountryValidationError_Lbl() {
        return ActionHelper.isPresent(dropDetailsCountryValidationError_Lbl);
    }

    public String getText_DropDetailsCountryValidationError_Lbl() {
        return ActionHelper.getText(dropDetailsCountryValidationError_Lbl);
    }

    public boolean isPresent_DropDetailsAddressLine1ValidationError_Lbl() {
        return ActionHelper.isPresent(dropDetailsAddressLine1ValidationError_Lbl);
    }

    public String getText_DropDetailsAddressLine1ValidationError_Lbl() {
        return ActionHelper.getText(dropDetailsAddressLine1ValidationError_Lbl);
    }

    public boolean isPresent_DropDetailsAddressLine2ValidationError_Lbl() {
        return ActionHelper.isPresent(dropDetailsAddressLine2ValidationError_Lbl);
    }

    public String getText_DropDetailsAddressLine2ValidationError_Lbl() {
        return ActionHelper.getText(dropDetailsAddressLine2ValidationError_Lbl);
    }

    public boolean isPresent_DropDetailsStateValidationError_Lbl() {
        return ActionHelper.isPresent(dropDetailsStateValidationError_Lbl);
    }

    public String getText_DropDetailsStateValidationError_Lbl() {
        return ActionHelper.getText(dropDetailsStateValidationError_Lbl);
    }

    public boolean isPresent_DropDetailsCityValidationError_Lbl() {
        return ActionHelper.isPresent(dropDetailsCityValidationError_Lbl);
    }

    public String getText_DropDetailsCityValidationError_Lbl() {
        return ActionHelper.getText(dropDetailsCityValidationError_Lbl);
    }

    public boolean isPresent_DropDetailsDropDateValidationError_Lbl() {
        return ActionHelper.isPresent(dropDetailsDropDateValidationError_Lbl);
    }

    public String getText_DropDetailsDropDateValidationError_Lbl() {
        return ActionHelper.getText(dropDetailsDropDateValidationError_Lbl);
    }

    public boolean isPresent_PaymentDetailsPaymentTypeValidationError_Lbl() {
        return ActionHelper.isPresent(paymentDetailsPaymentTypeValidationError_Lbl);
    }

    public String getText_PaymentDetailsPaymentTypeValidationError_Lbl() {
        return ActionHelper.getText(paymentDetailsPaymentTypeValidationError_Lbl);
    }

    public void click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown() {
        ActionHelper.sendKeysWithClear(pickupDetailsSelectAFacility_Dropdown.getBy(), Keys.chord("DDS" + Keys.UP + Keys.ENTER));
    }

    public void click_AddFacilityBtn_DropDetailsSelectAFacility_Dropdown() {
        ActionHelper.sendKeysWithClear(dropDetailsSelectAFacility_Dropdown.getBy(), Keys.chord("DDS" + Keys.UP + Keys.ENTER));
    }

    public boolean isPresent_AddNewFacilityHeader_Lbl() {
        return ActionHelper.isPresent(addNewFacilityHeader_Lbl, 5000);
    }

    public boolean isPresent_AddFacilityFacilityName_Txt() {
        return ActionHelper.isPresent(addFacilityFacilityName_Txt);
    }

    public void fill_AddFacilityFacilityName_Txt(String value) {
        ActionHelper.fill(addFacilityFacilityName_Txt, value);
    }

    public void fillWithClear_AddFacilityFacilityName_Txt(String value) {
        Utility.selectAllAndClear(addFacilityFacilityName_Txt.getBy());
        ActionHelper.fillWithClear(addFacilityFacilityName_Txt.getBy(), value);
    }

    public void clear_AddFacilityFacilityName_Txt() {
        ActionHelper.clear(addFacilityFacilityName_Txt.getBy());
    }

    public String getValue_AddFacilityFacilityName_Txt() {
        return ActionHelper.getAttribute(addFacilityFacilityName_Txt, "value");
    }

    public boolean isPresent_AddFacilityFacilityId_Txt() {
        return ActionHelper.isPresent(addFacilityFacilityId_Txt);
    }

    public void fill_AddFacilityFacilityId_Txt(String value) {
        ActionHelper.fill(addFacilityFacilityId_Txt, value);
    }

    public void fillWithClear_AddFacilityFacilityId_Txt(String value) {
        ActionHelper.sendKeysWithClear(addFacilityFacilityId_Txt.getBy(), value);
    }

    public void clear_AddFacilityFacilityId_Txt() {
        Utility.selectAllAndClear(addFacilityFacilityId_Txt.getBy());
        ActionHelper.clear(addFacilityFacilityId_Txt.getBy());
    }

    public String getValue_AddFacilityFacilityId_Txt() {
        return ActionHelper.getAttribute(addFacilityFacilityId_Txt, "value");
    }

    public boolean isPresent_AddFacilityPostalCode_Txt() {
        return ActionHelper.isPresent(addFacilityPostalCode_Txt);
    }

    public void fill_AddFacilityPostalCode_Txt(String value) {
        ActionHelper.fill(addFacilityPostalCode_Txt, value);
    }

    public void fillWithClear_AddFacilityPostalCode_Txt(String value) {
        Utility.selectAllAndClear(addFacilityPostalCode_Txt.getBy());
        ActionHelper.fillWithClear(addFacilityPostalCode_Txt.getBy(), value);
    }

    public void clear_AddFacilityPostalCode_Txt() {
        ActionHelper.clear(addFacilityPostalCode_Txt.getBy());
    }

    public String getValue_AddFacilityPostalCode_Txt() {
        return ActionHelper.getAttribute(addFacilityPostalCode_Txt, "value");
    }

    public boolean isPresent_AddFacilityCountry_Txt() {
        return ActionHelper.isPresent(addFacilityCountry_Txt);
    }

    public void fill_AddFacilityCountry_Txt(String value) {
        ActionHelper.fill(addFacilityCountry_Txt, value);
    }

    public void fillWithClear_AddFacilityCountry_Txt(String value) {
        Utility.selectAllAndClear(addFacilityCountry_Txt.getBy());
        ActionHelper.fillWithClear(addFacilityCountry_Txt.getBy(), value);
    }

    public void clear_AddFacilityCountry_Txt() {
        ActionHelper.clear(addFacilityCountry_Txt.getBy());
    }

    public String getValue_AddFacilityCountry_Txt() {
        return ActionHelper.getAttribute(addFacilityCountry_Txt, "value");
    }

    public boolean isClickable_AddFacilityCountry_Txt() {
        return ActionHelper.findElement(addFacilityCountry_Txt.getBy()).getAttribute("class").contains("disabled") ? false : true;
    }

    public boolean isPresent_AddFacilityAddressLine1_Txt() {
        return ActionHelper.isPresent(addFacilityAddressLine1_Txt);
    }

    public void fill_AddFacilityAddressLine1_Txt(String value) {
        ActionHelper.fill(addFacilityAddressLine1_Txt, value);
    }

    public void fillWithClear_AddFacilityAddressLine1_Txt(String value) {
        Utility.selectAllAndClear(addFacilityAddressLine1_Txt.getBy());
        ActionHelper.fillWithClear(addFacilityAddressLine1_Txt.getBy(), value);
    }

    public void clear_AddFacilityAddressLine1_Txt() {
        ActionHelper.clear(addFacilityAddressLine1_Txt.getBy());
    }

    public String getValue_AddFacilityAddressLine1_Txt() {
        return ActionHelper.getAttribute(addFacilityAddressLine1_Txt, "value");
    }

    public boolean isPresent_AddFacilityAddressLine2_Txt() {
        return ActionHelper.isPresent(addFacilityAddressLine2_Txt);
    }

    public void fill_AddFacilityAddressLine2_Txt(String value) {
        ActionHelper.fill(addFacilityAddressLine2_Txt, value);
    }

    public void fillWithClear_AddFacilityAddressLine2_Txt(String value) {
        Utility.selectAllAndClear(addFacilityAddressLine2_Txt.getBy());
        ActionHelper.fillWithClear(addFacilityAddressLine2_Txt.getBy(), value);
    }

    public void clear_AddFacilityAddressLine2_Txt() {
        ActionHelper.clear(addFacilityAddressLine2_Txt.getBy());
    }

    public String getValue_AddFacilityAddressLine2_Txt() {
        return ActionHelper.getAttribute(addFacilityAddressLine2_Txt, "value");
    }

    public boolean isPresent_AddFacilityState_Txt() {
        return ActionHelper.isPresent(addFacilityState_Txt);
    }

    public void fill_AddFacilityState_Txt(String value) {
        ActionHelper.fill(addFacilityState_Txt, value);
    }

    public void fillWithClear_AddFacilityState_Txt(String value) {
        Utility.selectAllAndClear(addFacilityState_Txt.getBy());
        ActionHelper.fillWithClear(addFacilityState_Txt.getBy(), value);
    }

    public void clear_AddFacilityState_Txt() {
        ActionHelper.clear(addFacilityState_Txt.getBy());
    }

    public String getValue_AddFacilityState_Txt() {
        return ActionHelper.getAttribute(addFacilityState_Txt, "value");
    }

    public boolean isPresent_AddFacilityCity_Txt() {
        return ActionHelper.isPresent(addFacilityCity_Txt);
    }

    public void fill_AddFacilityCity_Txt(String value) {
        ActionHelper.fill(addFacilityCity_Txt, value);
    }

    public void fillWithClear_AddFacilityCity_Txt(String value) {
        Utility.selectAllAndClear(addFacilityCity_Txt.getBy());
        ActionHelper.fillWithClear(addFacilityCity_Txt.getBy(), value);
    }

    public void clear_AddFacilityCity_Txt() {
        ActionHelper.clear(addFacilityCity_Txt.getBy());
    }

    public String getValue_AddFacilityCity_Txt() {
        return ActionHelper.getAttribute(addFacilityCity_Txt, "value");
    }

    public boolean isPresent_AddFacilityCreate_Btn() {
        return ActionHelper.isPresent(addFacilityCreate_Btn);
    }

    public void click_AddFacilityCreateBtn_WithWait() {
        Utility.scrollUsingJS(addFacilityCreate_Btn.getBy());
        ActionHelper.click(addFacilityCreate_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void click_AddFacilityCreate_Btn() {
        Utility.scrollUsingJS(addFacilityCreate_Btn.getBy());
        ActionHelper.click(addFacilityCreate_Btn);
    }

    public String getText_AddFacilityCreate_Btn() {
        return ActionHelper.getText(addFacilityCreate_Btn);
    }

    public boolean isPresent_AddFacilityCancel_Btn() {
        return ActionHelper.isPresent(addFacilityCancel_Btn);
    }

    public void click_AddFacilityCancel_Btn() {
        ActionHelper.click(addFacilityCancel_Btn);
    }

    public String getText_AddFacilityCancel_Btn() {
        return ActionHelper.getText(addFacilityCancel_Btn);
    }


    public void addFacility(String facilityName, String postalCode, String addressLine1, String addressLine2) {
        fillWithClear_AddFacilityFacilityName_Txt(facilityName);
        fillWithClear_AddFacilityPostalCode_Txt(postalCode);
        fillWithClear_AddFacilityAddressLine1_Txt(addressLine1);
        fillWithClear_AddFacilityAddressLine2_Txt(addressLine2);
    }

    public Boolean isPresent_AddFacilityFacilityNameValidationMsg_Lbl() {
        return ActionHelper.isPresent(addFacilityFacilityNameValidationMsg_Lbl);
    }

    public String getText_AddFacilityFacilityNameValidationMsg_Lbl() {
        return ActionHelper.getText(addFacilityFacilityNameValidationMsg_Lbl);
    }

    public Boolean isPresent_AddFacilityFacilityIdValidationMsg_Lbl() {
        return ActionHelper.isPresent(addFacilityFacilityIdValidationMsg_Lbl);
    }

    public String getText_AddFacilityFacilityIdValidationMsg_Lbl() {
        return ActionHelper.getText(addFacilityFacilityIdValidationMsg_Lbl);
    }

    public Boolean isPresent_AddFacilityPostalCodeValidationMsg_Lbl() {
        return ActionHelper.isPresent(addFacilityPostalCodeValidationMsg_Lbl);
    }

    public String getText_AddFacilityPostalCodeValidationMsg_Lbl() {
        return ActionHelper.getText(addFacilityPostalCodeValidationMsg_Lbl);
    }

    public Boolean isPresent_AddFacilityAddressLine1ValidationMsg_Lbl() {
        return ActionHelper.isPresent(addFacilityAddressLine1ValidationMsg_Lbl);
    }

    public String getText_AddFacilityAddressLine1ValidationMsg_Lbl() {
        return ActionHelper.getText(addFacilityAddressLine1ValidationMsg_Lbl);
    }

    public Boolean isPresent_AddFacilityAddressLine2ValidationMsg_Lbl() {
        return ActionHelper.isPresent(addFacilityAddressLine2ValidationMsg_Lbl);
    }

    public String getText_AddFacilityAddressLine2ValidationMsg_Lbl() {
        return ActionHelper.getText(addFacilityAddressLine2ValidationMsg_Lbl);
    }

    public Boolean isPresent_AddFacilityStateValidationMsg_Lbl() {
        return ActionHelper.isPresent(addFacilityStateValidationMsg_Lbl);
    }

    public String getText_AddFacilityStateValidationMsg_Lbl() {
        return ActionHelper.getText(addFacilityStateValidationMsg_Lbl);
    }

    public Boolean isPresent_AddFacilityCityValidationMsg_Lbl() {
        return ActionHelper.isPresent(addFacilityCityValidationMsg_Lbl);
    }

    public String getText_AddFacilityCityValidationMsg_Lbl() {
        return ActionHelper.getText(addFacilityCityValidationMsg_Lbl);
    }

    public boolean isPresent_AddFacilityPinCodeDataNotFoundToastMsg_Lbl() {
        return ActionHelper.isPresent(addFacilityPinCodeDataNotFoundToastMsg_Lbl, 5000);
    }

    public boolean isPresent_AddShipmentRequiredParamShipmentIdToastMsg_Lbl() {
        return ActionHelper.isPresent(addShipmentRequiredParamShipmentIdToastMsg_Lbl, 5000);
    }

    public boolean isPresent_AddShipmentRequiredParamDescriptionToastMsg_Lbl() {
        return ActionHelper.isPresent(addShipmentRequiredParamDescriptionToastMsg_Lbl, 5000);
    }

    public void validateAndCreateFacility(String input, String postalCode) throws AWTException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        if (input.equalsIgnoreCase("Pickup"))
            click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        else click_AddFacilityBtn_DropDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(isPresent_AddFacilityFacilityName_Txt(), "Facility name is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityFacilityId_Txt(), "Facility Id is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityPostalCode_Txt(), "Add Facility Postal code is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityAddressLine1_Txt(), "Address Line 1 text box is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityAddressLine2_Txt(), "Address Line 2 text box is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityState_Txt(), "State text box is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityCity_Txt(), "City text box is present as expected");
        click_AddFacilityCreate_Btn();
        softAssert.assertTrue(isPresent_AddFacilityFacilityNameValidationMsg_Lbl(), "Facility name required message is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityPostalCodeValidationMsg_Lbl(), "Postal code required message is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityAddressLine1ValidationMsg_Lbl(), "Address line 1 required message is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityAddressLine2ValidationMsg_Lbl(), "Address line 2 required message is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityStateValidationMsg_Lbl(), "State required message is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityCityValidationMsg_Lbl(), "City required message is present as expected");
        softAssert.assertAll();
        createFacility(postalCode);
    }

    public void set_PickUpFacility_TextBox() {
        ActionHelper.scrollTillElement(pickupDetailsSelectAFacility_Dropdown.getBy());
        ActionHelper.sendKeysWithClear(pickupDetailsSelectAFacility_Dropdown.getBy(), Keys.chord("facility" + Keys.DOWN + Keys.ENTER));
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void set_DropFacility_TextBox() {
        ActionHelper.scrollTillElement(dropDetailsSelectAFacility_Dropdown.getBy());
        ActionHelper.sendKeysWithClear(dropDetailsSelectAFacility_Dropdown.getBy(), Keys.chord("facility" + Keys.DOWN + Keys.ENTER));
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void set_PickUpFacility_TextBox(String value) {
        ActionHelper.click(pickupDetailsSelectAFacility_Dropdown);
        Utility.clickWebElementMatchingText(ActionHelper.findElementsWithoutWait(selectAFacilityDropdownOptions_ListBtn.getBy()), value);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void set_DropFacility_TextBox(String value) {
        ActionHelper.click(dropDetailsSelectAFacility_Dropdown);
        Utility.clickWebElementMatchingText(ActionHelper.findElementsWithoutWait(selectAFacilityDropdownOptions_ListBtn.getBy()), value);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String setPickUpFacilityByIndex(int index) {
        ActionHelper.click(pickupDetailsSelectAFacility_Dropdown);
        WebElement element = ActionHelper.findElementsWithoutWait(selectAFacilityDropdownOptions_ListBtn.getBy()).get(index);
        String text = ActionHelper.getText(element);
        ActionHelper.click(element);
        CommonActions.getInstance().waitTillLoaderDisappears();
        return text;
    }

    public String setDropFacilityByIndex(int index) {
        ActionHelper.click(dropDetailsSelectAFacility_Dropdown);
        WebElement element = ActionHelper.findElementsWithoutWait(selectAFacilityDropdownOptions_ListBtn.getBy()).get(index);
        String text = ActionHelper.getText(element);
        ActionHelper.click(element);
        CommonActions.getInstance().waitTillLoaderDisappears();
        return text;
    }

    public void fill_Pickup_Details(String postalCode, String addressLine1, String addressLine2) {
        fillWithClear_PickupDetailsPostalCode_Txt(postalCode);
        fillWithClear_PickupDetailsAddressLine1_Txt(addressLine1);
        fillWithClear_PickupDetailsAddressLine2_Txt(addressLine2);
    }

    public void fill_Drop_Details(String postalCode, String addressLine1, String addressLine2) {
        fillWithClear_DropDetailsPostalCode_Txt(postalCode);
        fillWithClear_DropDetailsAddressLine1_Txt(addressLine1);
        fillWithClear_DropDetailsAddressLine2_Txt(addressLine2);
    }

    public void validate_PickUpClear_Btn(String postalCode, String addressLine1, String addressLine2) {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        fill_Pickup_Details(postalCode, addressLine1, addressLine2);
        softAssert.assertEquals(getValue_PickupDetailsPostalCode_Txt(), postalCode, "Postal Code is matched expected");
        softAssert.assertEquals(getValue_PickupDetailsAddressLine1_Txt(), addressLine1, "Address Line 1 is matched expected");
        softAssert.assertEquals(getValue_PickupDetailsAddressLine2_Txt(), addressLine2, "Address Line 2 is matched expected");
        click_PickupDetailsClearAll_Btn();
        softAssert.assertEquals(getValue_PickupDetailsPostalCode_Txt(), "", "Postal Code is matched expected");
        softAssert.assertEquals(getValue_PickupDetailsAddressLine1_Txt(), "", "Address Line 1 is matched expected");
        softAssert.assertEquals(getValue_PickupDetailsAddressLine2_Txt(), "", "Address Line 2 is matched expected");
        ActionHelper.waitForLoaderToHide();
    }

    public void validate_DropClearAll_Btn(String postalCode, String addressLine1, String addressLine2) {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        fill_Drop_Details(postalCode, addressLine1, addressLine2);
        softAssert.assertEquals(getValue_DropDetailsPostalCode_Txt(), postalCode, "Postal Code is matched expected");
        softAssert.assertEquals(getValue_DropDetailsAddressLine1_Txt(), addressLine1, "Address Line 1 is matched expected");
        softAssert.assertEquals(getValue_DropDetailsAddressLine2_Txt(), addressLine2, "Address Line 1 is matched expected");
        click_PickupDetailsClearAll_Btn();
        softAssert.assertEquals(getValue_DropDetailsPostalCode_Txt(), "", "Postal Code is matched expected");
        softAssert.assertEquals(getValue_DropDetailsAddressLine1_Txt(), "", "Address Line 1 is matched expected");
        softAssert.assertEquals(getValue_DropDetailsAddressLine2_Txt(), "", "Address Line 1 is matched expected");
        ActionHelper.waitForLoaderToHide();
    }

    public void createFacility(String postalCode) {
        Actions actions = new Actions(DriverManager.getDriver());
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        isPresent_AddFacilityFacilityName_Txt();
        fillWithClear_AddFacilityFacilityName_Txt("Facility " + sampleData.number().digits(4));
        fillWithClear_AddFacilityPostalCode_Txt(postalCode);
        fillWithClear_AddFacilityAddressLine1_Txt("Building No " + sampleData.number().digits(2));
        fillWithClear_AddFacilityAddressLine2_Txt("Street No " + sampleData.number().digits(2));
        softAssert.assertTrue(getValue_AddFacilityState_Txt() != null, "State Text box is not null as expected");
        softAssert.assertTrue(getValue_AddFacilityCity_Txt() != null, "City Text box is not null as expected");
        softAssert.assertAll();
        ActionHelper.click(addFacilityState_Txt);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        click_AddFacilityCreate_Btn();
        ActionHelper.waitForLoaderToHide();
    }

    public boolean isPresent_SuccessToastMsg_Lbl() {
        return ActionHelper.isPresent(successToastMsg_Lbl);
    }

    public boolean isPresent_DuplicateOrderIdToastMsg_Lbl() {
        return ActionHelper.isPresent(duplicateOrderIdToastMsg_Lbl, 5000);
    }

    public boolean isPresent_SamePickupAndDropFacilityToastMsg_Lbl() {
        return ActionHelper.isPresent(samePickupAndDropFacilityToastMsg_Lbl, 5000);
    }

    public boolean isPresent_OnlyPrepaidOrdersAllowedForMultipleShipmentsToastMsg_Lbl() {
        return ActionHelper.isPresent(onlyPrepaidOrdersAllowedForMultipleShipmentsToastMsg_Lbl, 5000);
    }

    public void fillPickupDetailsWithCustomData() {
        click_PickupDetailsCustomAddress_Radio();
        fillWithClear_PickupDetailsContactName_Txt(sampleData.name().firstName());
        fillWithClear_PickupDetailsContactNumber_Txt(sampleData.phoneNumber().subscriberNumber(10));
        fillWithClear_PickupDetailsPostalCode_Txt(Constants.PICKUP_PINCODE);
        fillWithClear_PickupDetailsAddressLine1_Txt(sampleData.address().buildingNumber());
        fillWithClear_PickupDetailsAddressLine2_Txt(sampleData.address().secondaryAddress());
        fillWithClear_PickupDetailsPickupDate_Txt(Utility.getCustomCurrentDateFormatter("dd/MM/yyyy"));
    }

    public void fillDropDetailsWithCustomData() {
        click_DropDetailsCustomAddress_Radio();
        fillWithClear_DropDetailsContactName_Txt(sampleData.name().firstName());
        fillWithClear_DropDetailsContactNumber_Txt(sampleData.phoneNumber().subscriberNumber(10));
        fillWithClear_DropDetailsPostalCode_Txt(Constants.DROP_PINCODE);
        fillWithClear_DropDetailsAddressLine1_Txt(sampleData.address().buildingNumber());
        fillWithClear_DropDetailsAddressLine2_Txt(sampleData.address().secondaryAddress());
        fillWithClear_DropDetailsDropDate_Txt(Utility.getCustomCurrentDateFormatter("dd/MM/yyyy"));
    }

    public boolean isPresent_OrderDetailsTotalWeight_Txt() {
        return ActionHelper.isPresent(orderDetailsTotalWeight_Txt);
    }

    public void fill_OrderDetailsTotalWeight_Txt(String value) {
        ActionHelper.fill(orderDetailsTotalWeight_Txt, value);
    }

    public void fillWithClear_OrderDetailsTotalWeight_Txt(String value) {
        ActionHelper.fillWithClear(orderDetailsTotalWeight_Txt.getBy(), value);
    }

    public void clear_OrderDetailsTotalWeight_Txt() {
        ActionHelper.clear(orderDetailsTotalWeight_Txt.getBy());
    }

    public String getValue_OrderDetailsTotalWeight_Txt() {
        return ActionHelper.getAttribute(orderDetailsTotalWeight_Txt, "value");
    }

    public boolean isPresent_OrderDetailsTotalVolume_Txt() {
        return ActionHelper.isPresent(orderDetailsTotalVolume_Txt);
    }

    public void fill_OrderDetailsTotalVolume_Txt(String value) {
        ActionHelper.fill(orderDetailsTotalVolume_Txt, value);
    }

    public void fillWithClear_OrderDetailsTotalVolume_Txt(String value) {
        ActionHelper.fillWithClear(orderDetailsTotalVolume_Txt.getBy(), value);
    }

    public void clear_OrderDetailsTotalVolume_Txt() {
        ActionHelper.clear(orderDetailsTotalVolume_Txt.getBy());
    }

    public String getValue_OrderDetailsTotalVolume_Txt() {
        return ActionHelper.getAttribute(orderDetailsTotalVolume_Txt, "value");
    }

    public boolean isPresent_ShipmentDetailsHeader_Lbl() {
        return ActionHelper.isPresent(shipmentDetailsHeader_Lbl);
    }

    public String getText_ShipmentDetailsHeader_Lbl() {
        return ActionHelper.getText(shipmentDetailsHeader_Lbl);
    }

    public boolean isPresent_ShipmentDetailsShipmentID_Txt() {
        return ActionHelper.isPresent(shipmentDetailsShipmentID_Txt);
    }

    public void fill_ShipmentDetailsShipmentID_Txt(String value) {
        ActionHelper.fill(shipmentDetailsShipmentID_Txt, value);
    }

    public void fillWithClear_ShipmentDetailsShipmentID_Txt(String value) {
        ActionHelper.fillWithClear(shipmentDetailsShipmentId_Txt.getBy(), value);
    }

    public void clear_ShipmentDetailsShipmentID_Txt() {
        ActionHelper.clear(shipmentDetailsShipmentID_Txt.getBy());
    }

    public String getValue_ShipmentDetailsShipmentID_Txt() {
        return ActionHelper.getAttribute(shipmentDetailsShipmentID_Txt, "value");
    }

    public boolean isPresent_ShipmentDetailsDescription_Txt() {
        return ActionHelper.isPresent(shipmentDetailsDescription_Txt);
    }

    public void fill_ShipmentDetailsDescription_Txt(String value) {
        ActionHelper.fill(shipmentDetailsDescription_Txt, value);
    }

    public void fillWithClear_ShipmentDetailsDescription_Txt(String value) {
        ActionHelper.fillWithClear(shipmentDetailsDescription_Txt.getBy(), value);
    }

    public void clear_ShipmentDetailsDescription_Txt() {
        ActionHelper.clear(shipmentDetailsDescription_Txt.getBy());
    }

    public String getValue_ShipmentDetailsDescription_Txt() {
        return ActionHelper.getAttribute(getShipmentDetailsDescription_Txt, "value");
    }

    public boolean isPresent_ShipmentDetailsWeight_Txt() {
        return ActionHelper.isPresent(shipmentDetailsWeight_Txt);
    }

    public void fill_ShipmentDetailsWeight_Txt(String value) {
        ActionHelper.fill(shipmentDetailsWeight_Txt, value);
    }

    public void fillWithClear_ShipmentDetailsWeight_Txt(String value) {
        ActionHelper.fillWithClear(shipmentDetailsWeight_Txt.getBy(), value);
    }

    public void clear_ShipmentDetailsWeight_Txt() {
        ActionHelper.clear(shipmentDetailsWeight_Txt.getBy());
    }

    public String getValue_ShipmentDetailsWeight_Txt() {
        return ActionHelper.getAttribute(shipmentDetailsWeight_Txt, "value");
    }

    public boolean isPresent_ShipmentDetailsVolume_Txt() {
        return ActionHelper.isPresent(shipmentDetailsVolume_Txt);
    }

    public void fill_ShipmentDetailsVolume_Txt(String value) {
        ActionHelper.fill(shipmentDetailsVolume_Txt, value);
    }

    public void fillWithClear_ShipmentDetailsVolume_Txt(String value) {
        ActionHelper.fillWithClear(shipmentDetailsVolume_Txt.getBy(), value);
    }

    public void clear_ShipmentDetailsVolume_Txt() {
        ActionHelper.clear(shipmentDetailsVolume_Txt.getBy());
    }

    public String getValue_ShipmentDetailsVolume_Txt() {
        return ActionHelper.getAttribute(shipmentDetailsVolume_Txt, "value");
    }

    public boolean isPresent_ShipmentDetailsDimensionsLength_Txt() {
        return ActionHelper.isPresent(shipmentDetailsDimensionsLength_Txt);
    }

    public void fill_ShipmentDetailsDimensionsLength_Txt(String value) {
        ActionHelper.fill(shipmentDetailsDimensionsLength_Txt, value);
    }

    public void fillWithClear_ShipmentDetailsDimensionsLength_Txt(String value) {
        ActionHelper.fillWithClear(shipmentDetailsDimensionsLength_Txt.getBy(), value);
    }

    public void clear_ShipmentDetailsDimensionsLength_Txt() {
        ActionHelper.clear(shipmentDetailsDimensionsLength_Txt.getBy());
    }

    public String getValue_ShipmentDetailsDimensionsLength_Txt() {
        return ActionHelper.getAttribute(shipmentDetailsDimensionsLength_Txt, "value");
    }

    public boolean isPresent_ShipmentDetailsDimensionsBreadth_Txt() {
        return ActionHelper.isPresent(shipmentDetailsDimensionsBreadth_Txt);
    }

    public void fill_ShipmentDetailsDimensionsBreadth_Txt(String value) {
        ActionHelper.fill(shipmentDetailsDimensionsBreadth_Txt, value);
    }

    public void fillWithClear_ShipmentDetailsDimensionsBreadth_Txt(String value) {
        ActionHelper.fillWithClear(shipmentDetailsDimensionsBreadth_Txt.getBy(), value);
    }

    public void clear_ShipmentDetailsDimensionsBreadth_Txt() {
        ActionHelper.clear(shipmentDetailsDimensionsBreadth_Txt.getBy());
    }

    public String getValue_ShipmentDetailsDimensionsBreadth_Txt() {
        return ActionHelper.getAttribute(shipmentDetailsDimensionsBreadth_Txt, "value");
    }

    public boolean isPresent_ShipmentDetailsDimensionsHeight_Txt() {
        return ActionHelper.isPresent(shipmentDetailsDimensionsHeight_Txt);
    }

    public void fill_ShipmentDetailsDimensionsHeight_Txt(String value) {
        ActionHelper.fill(shipmentDetailsDimensionsHeight_Txt, value);
    }

    public void fillWithClear_ShipmentDetailsDimensionsHeight_Txt(String value) {
        ActionHelper.fillWithClear(shipmentDetailsDimensionsHeight_Txt.getBy(), value);
    }

    public void clear_ShipmentDetailsDimensionsHeight_Txt() {
        ActionHelper.clear(shipmentDetailsDimensionsHeight_Txt.getBy());
    }

    public String getValue_ShipmentDetailsDimensionsHeight_Txt() {
        return ActionHelper.getAttribute(shipmentDetailsDimensionsHeight_Txt, "value");
    }

    public boolean isPresent_ShipmentDetailsDelete_Btn() {
        return ActionHelper.isPresent(shipmentDetailsDelete_Btn);
    }

    public void click_ShipmentDetailsDelete_Btn() {
        ActionHelper.click(shipmentDetailsDelete_Btn);
    }

    public String getText_ShipmentDetailsDelete_Btn() {
        return ActionHelper.getText(shipmentDetailsDelete_Btn);
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnShipmentID_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnShipmentID_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnShipmentID_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnShipmentID_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnShipmentID_ListLbl(int index) {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnShipmentID_ListLbl.getBy()).get(index).getAttribute("value");
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnDescription_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDescription_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnDescription_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDescription_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnDescription_ListLbl(int index) {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDescription_ListLbl.getBy()).get(index).getAttribute("value");
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnWeight_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnWeight_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnWeight_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnWeight_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnWeight_ListLbl(int index) {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnWeight_ListLbl.getBy()).get(index).getAttribute("value");
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnVolume_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnVolume_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnVolume_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnVolume_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnVolume_ListLbl(int index) {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnVolume_ListLbl.getBy()).get(index).getAttribute("value");
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnDimensionsLength_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDimensionsLength_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnDimensionsLength_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDimensionsLength_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnDimensionsLength_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDimensionsLength_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnDimensionsBreadth_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDimensionsBreadth_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnDimensionsBreadth_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDimensionsBreadth_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnDimensionsBreadth_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDimensionsBreadth_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnDimensionsHeight_ListLbl() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDimensionsHeight_ListLbl.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnDimensionsHeight_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDimensionsHeight_ListLbl.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnDimensionsHeight_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDimensionsHeight_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ShipmentDetailsTableColumnDelete_ListBtn() {
        return ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDelete_ListBtn.getBy());
    }

    public List<String> getText_ShipmentDetailsTableColumnDelete_ListBtn() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDelete_ListBtn.getBy()));
    }

    public String getText_ShipmentDetailsTableColumnDelete_ListBtn(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(shipmentDetailsTableColumnDelete_ListBtn.getBy()).get(index));
    }

    public void click_ShipmentDetailsTableColumnDelete_ListBtn(int index) {
        ActionHelper.click(ActionHelper.findElements(shipmentDetailsTableColumnDelete_ListBtn.getBy()).get(index));
    }

    public boolean isPresent_ShipmentDetailsAddShipment_Btn() {
        return ActionHelper.isPresent(shipmentDetailsAddShipment_Btn);
    }

    public void click_ShipmentDetailsAddShipment_Btn() {
        ActionHelper.click(shipmentDetailsAddShipment_Btn);
    }

    public String getText_ShipmentDetailsAddShipment_Btn() {
        return ActionHelper.getText(shipmentDetailsAddShipment_Btn);
    }

    public boolean isPresent_PickupDetailsFacilityStore_Radio() {
        return ActionHelper.isPresent(pickupDetailsFacilityStore_Radio);
    }

    public void click_PickupDetailsFacilityStore_Radio() {
        ActionHelper.click(pickupDetailsFacilityStore_Radio);
    }

    public boolean isRadioSelected_PickupDetailsFacilityStore_Radio() {
        return Utility.isRadioSelected(pickupDetailsFacilityStore_Radio.getBy());
    }

    public boolean isPresent_PickupDetailsCustomAddress_Radio() {
        return ActionHelper.isPresent(pickupDetailsCustomAddress_Radio);
    }

    public void click_PickupDetailsCustomAddress_Radio() {
        ActionHelper.click(pickupDetailsCustomAddress_Radio);
    }

    public boolean isRadioSelected_PickupDetailsCustomAddress_Radio() {
        return Utility.isRadioSelected(pickupDetailsCustomAddress_Radio.getBy());
    }

    public boolean isPresent_PickupDetailsPickupDate_Txt() {
        return ActionHelper.isPresent(pickupDetailsPickupDate_Txt);
    }

    public void fill_PickupDetailsPickupDate_Txt(String value) {
        ActionHelper.sendKeysWithClear(pickupDetailsPickupDate_Txt.getBy(), value);
    }

    public void fillWithClear_PickupDetailsPickupDate_Txt(String value) {
        ActionHelper.sendKeysWithClear(pickupDetailsPickupDate_Txt.getBy(), value);
    }

    public void clear_PickupDetailsPickupDate_Txt() {
        ActionHelper.clear(pickupDetailsPickupDate_Txt.getBy());
    }

    public String getValue_PickupDetailsPickupDate_Txt() {
        return ActionHelper.getAttribute(pickupDetailsPickupDate_Txt, "value");
    }

    public boolean isPresent_PickupDetailsPickupSlotFrom_Txt() {
        return ActionHelper.isPresent(pickupDetailsPickupSlotFrom_Txt);
    }

    public void fill_PickupDetailsPickupSlotFrom_Txt(String value) {
        ActionHelper.fill(pickupDetailsPickupSlotFrom_Txt, value);
    }

    public void fillWithClear_PickupDetailsPickupSlotFrom_Txt(String value) {
        ActionHelper.fillWithClear(pickupDetailsPickupSlotFrom_Txt.getBy(), value);
    }

    public void clear_PickupDetailsPickupSlotFrom_Txt() {
        ActionHelper.clear(pickupDetailsPickupSlotFrom_Txt.getBy());
    }

    public String getValue_PickupDetailsPickupSlotFrom_Txt() {
        return ActionHelper.getAttribute(pickupDetailsPickupSlotFrom_Txt, "value");
    }

    public boolean isPresent_PickupDetailsPickupSlotTo_Txt() {
        return ActionHelper.isPresent(pickupDetailsPickupSlotTo_Txt);
    }

    public void fill_PickupDetailsPickupSlotTo_Txt(String value) {
        ActionHelper.fill(pickupDetailsPickupSlotTo_Txt, value);
    }

    public void fillWithClear_PickupDetailsPickupSlotTo_Txt(String value) {
        ActionHelper.fillWithClear(pickupDetailsPickupSlotTo_Txt.getBy(), value);
    }

    public void clear_PickupDetailsPickupSlotTo_Txt() {
        ActionHelper.clear(pickupDetailsPickupSlotTo_Txt.getBy());
    }

    public String getValue_PickupDetailsPickupSlotTo_Txt() {
        return ActionHelper.getAttribute(pickupDetailsPickupSlotTo_Txt, "value");
    }

    public boolean isPresent_DropDetailsFacilityStore_Radio() {
        return ActionHelper.isPresent(dropDetailsFacilityStore_Radio);
    }

    public void click_DropDetailsFacilityStore_Radio() {
        ActionHelper.click(dropDetailsFacilityStore_Radio);
    }

    public boolean isRadioSelected_DropDetailsFacilityStore_Radio() {
        return Utility.isRadioSelected(dropDetailsFacilityStore_Radio.getBy());
    }

    public boolean isPresent_DropDetailsCustomAddress_Radio() {
        return ActionHelper.isPresent(dropDetailsCustomAddress_Radio);
    }

    public void click_DropDetailsCustomAddress_Radio() {
        ActionHelper.click(dropDetailsCustomAddress_Radio);
    }

    public boolean isRadioSelected_DropDetailsCustomAddress_Radio() {
        return Utility.isRadioSelected(dropDetailsCustomAddress_Radio.getBy());
    }

    public boolean isPresent_DropDetailsDropDate_Txt() {
        return ActionHelper.isPresent(dropDetailsDropDate_Txt);
    }

    public void fill_DropDetailsDropDate_Txt(String value) {
        ActionHelper.sendKeysWithClear(dropDetailsDropDate_Txt.getBy(), value);
    }

    public void fillWithClear_DropDetailsDropDate_Txt(String value) {
        ActionHelper.fillWithClear(dropDetailsDropDate_Txt.getBy(), value);
    }

    public void clear_DropDetailsDropDate_Txt() {
        ActionHelper.clear(dropDetailsDropDate_Txt.getBy());
    }

    public String getValue_DropDetailsDropDate_Txt() {
        return ActionHelper.getAttribute(dropDetailsDropDate_Txt, "value");
    }

    public boolean isPresent_DropDetailsDropSlotFrom_Txt() {
        return ActionHelper.isPresent(dropDetailsDropSlotFrom_Txt);
    }

    public void fill_DropDetailsDropSlotFrom_Txt(String value) {
        ActionHelper.fill(dropDetailsDropSlotFrom_Txt, value);
    }

    public void fillWithClear_DropDetailsDropSlotFrom_Txt(String value) {
        ActionHelper.fillWithClear(dropDetailsDropSlotFrom_Txt.getBy(), value);
    }

    public void clear_DropDetailsDropSlotFrom_Txt() {
        ActionHelper.clear(dropDetailsDropSlotFrom_Txt.getBy());
    }

    public String getValue_DropDetailsDropSlotFrom_Txt() {
        return ActionHelper.getAttribute(dropDetailsDropSlotFrom_Txt, "value");
    }

    public boolean isPresent_DropDetailsDropSlotTo_Txt() {
        return ActionHelper.isPresent(dropDetailsDropSlotTo_Txt);
    }

    public void fill_DropDetailsDropSlotTo_Txt(String value) {
        ActionHelper.fill(dropDetailsDropSlotTo_Txt, value);
    }

    public void fillWithClear_DropDetailsDropSlotTo_Txt(String value) {
        ActionHelper.fillWithClear(dropDetailsDropSlotTo_Txt.getBy(), value);
    }

    public void clear_DropDetailsDropSlotTo_Txt() {
        ActionHelper.clear(dropDetailsDropSlotTo_Txt.getBy());
    }

    public String getValue_DropDetailsDropSlotTo_Txt() {
        return ActionHelper.getAttribute(dropDetailsDropSlotTo_Txt, "value");
    }

    public boolean isEnabled_PickupDetailsContactName_Txt() {
        return ActionHelper.findElement(pickupDetailsContactName_Txt).isEnabled();
    }

    public boolean isEnabled_PickupDetailsContactNumber_Txt() {
        return ActionHelper.findElement(pickupDetailsContactNumber_Txt).isEnabled();
    }

    public boolean isEnabled_PickupDetailsSelectAFacility_Dropdown() {
        return ActionHelper.findElement(pickupDetailsSelectAFacility_Dropdown).isEnabled();
    }

    public boolean isEnabled_PickupDetailsPostalCode_Txt() {
        return ActionHelper.findElement(pickupDetailsPostalCode_Txt).isEnabled();
    }

    public boolean isEnabled_PickupDetailsCountry_Select() {
        return ActionHelper.findElement(pickupDetailsCountry_Select).isEnabled();
    }

    public boolean isEnabled_PickupDetailsAddressLine1_Txt() {
        return ActionHelper.findElement(pickupDetailsAddressLine1_Txt).isEnabled();
    }

    public boolean isEnabled_PickupDetailsAddressLine2_Txt() {
        return ActionHelper.findElement(pickupDetailsAddressLine2_Txt).isEnabled();
    }

    public boolean isEnabled_PickupDetailsState_Txt() {
        return ActionHelper.findElement(pickupDetailsState_Txt).isEnabled();
    }

    public boolean isEnabled_PickupDetailsCity_Txt() {
        return ActionHelper.findElement(pickupDetailsCity_Txt).isEnabled();
    }

    public boolean isEnabled_PickupDetailsPickupDate_Txt() {
        return ActionHelper.findElement(pickupDetailsPickupDate_Txt).isEnabled();
    }

    public boolean isEnabled_PickupDetailsPickupSlotFrom_Txt() {
        return ActionHelper.findElement(pickupDetailsPickupSlotFrom_Txt).isEnabled();
    }

    public boolean isEnabled_PickupDetailsPickupSlotTo_Txt() {
        return ActionHelper.findElement(pickupDetailsPickupSlotTo_Txt).isEnabled();
    }

    public boolean isEnabled_DropDetailsContactName_Txt() {
        return ActionHelper.findElement(dropDetailsContactName_Txt).isEnabled();
    }

    public boolean isEnabled_DropDetailsContactNumber_Txt() {
        return ActionHelper.findElement(dropDetailsContactNumber_Txt).isEnabled();
    }

    public boolean isEnabled_DropDetailsSelectAFacility_Dropdown() {
        return ActionHelper.findElement(dropDetailsSelectAFacility_Dropdown).isEnabled();
    }

    public boolean isEnabled_DropDetailsPostalCode_Txt() {
        return ActionHelper.findElement(dropDetailsPostalCode_Txt).isEnabled();
    }

    public boolean isEnabled_DropDetailsCountry_Select() {
        return ActionHelper.findElement(dropDetailsCountry_Select).isEnabled();
    }

    public boolean isEnabled_DropDetailsAddressLine1_Txt() {
        return ActionHelper.findElement(dropDetailsAddressLine1_Txt).isEnabled();
    }

    public boolean isEnabled_DropDetailsAddressLine2_Txt() {
        return ActionHelper.findElement(dropDetailsAddressLine2_Txt).isEnabled();
    }

    public boolean isEnabled_DropDetailsState_Txt() {
        return ActionHelper.findElement(dropDetailsState_Txt).isEnabled();
    }

    public boolean isEnabled_DropDetailsCity_Txt() {
        return ActionHelper.findElement(dropDetailsCity_Txt).isEnabled();
    }

    public boolean isEnabled_DropDetailsDropDate_Txt() {
        return ActionHelper.findElement(dropDetailsDropDate_Txt).isEnabled();
    }

    public boolean isEnabled_DropDetailsDropSlotFrom_Txt() {
        return ActionHelper.findElement(dropDetailsDropSlotFrom_Txt).isEnabled();
    }

    public boolean isEnabled_DropDetailsDropSlotTo_Txt() {
        return ActionHelper.findElement(dropDetailsDropSlotTo_Txt).isEnabled();
    }

    public Map<String, String> addOrderDetails() {
        Map<String, String> finalData = new HashMap<>();
        finalData.put("orderId", ActionHelper.getRandomNumberString(5));
        finalData.put("description", sampleData.artist().name());
        fillWithClear_OrderDetailsOrderId_Txt(finalData.get("orderId"));
        fillWithClear_OrderDetailsOrderDescription_Txt(finalData.get("description"));
        return finalData;
    }


    public List<Map<String, String>> addShipmentDetails(int shipmentCount) {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (int count = 1; count <= shipmentCount; count++) {
            map.put("shipmentId", ActionHelper.getRandomNumberString(5));
            map.put("description", sampleData.artist().name());
            if (count >= 2) {
                click_ShipmentDetailsAddShipment_Btn();
                fillWithClear_ShipmentDetailsShipmentID_Txt(map.get("shipmentId"));
                fillWithClear_ShipmentDetailsDescription_Txt(map.get("description"));
            }

            ActionHelper.fillWithClear(setShipmentDetailsVolume_Txt.getBy(), ActionHelper.getRandomNumberString(2));
            ActionHelper.fillWithClear(setShipmentDetailsWeight_Txt.getBy(), ActionHelper.getRandomNumberString(2));
            list.add(Map.copyOf(map));
            map.clear();
        }
        return list;
    }

    public Map<String, String> addFacilityPickupDetails() {
        Map<String, String> finalData = new HashMap<>();
        ActionHelper.scrollTillElement(pickupDetailsHeader_Lbl.getBy());
        click_PickupDetailsFacilityStore_Radio();
        finalData.put("contactName", sampleData.artist().name());
        finalData.put("contactNumber", ActionHelper.getRandomNumberString(10));
        fillWithClear_PickupDetailsContactName_Txt(finalData.get("contactName"));
        fillWithClear_PickupDetailsContactNumber_Txt(finalData.get("contactNumber"));
        finalData.put("facility", setPickUpFacilityByIndex(1));
        finalData.put("pickupDate", ActionHelper.getCurrentDay() + "-" + ActionHelper.getCurrentMonth() + "-" + ActionHelper.getCurrentYear());
        fill_PickupDetailsPickupDate_Txt(finalData.get("pickupDate"));
        return finalData;
    }

    public Map<String, String> addFacilityPickupDetails(String pickupDate) {
        Map<String, String> finalData = new HashMap<>();
        ActionHelper.scrollTillElement(pickupDetailsHeader_Lbl.getBy());
        click_PickupDetailsFacilityStore_Radio();
        finalData.put("contactName", sampleData.artist().name());
        finalData.put("contactNumber", ActionHelper.getRandomNumberString(10));
        fillWithClear_PickupDetailsContactName_Txt(finalData.get("contactName"));
        fillWithClear_PickupDetailsContactNumber_Txt(finalData.get("contactNumber"));
        finalData.put("facility", setPickUpFacilityByIndex(1));
        finalData.put("pickupDate", pickupDate);
        fill_PickupDetailsPickupDate_Txt(pickupDate);
        return finalData;
    }

    public Map<String, String> addFacilityDropDetails() {
        Map<String, String> finalData = new HashMap<>();
        ActionHelper.scrollTillElement(dropDetailsHeader_Lbl.getBy());
        click_DropDetailsFacilityStore_Radio();
        finalData.put("contactName", sampleData.artist().name());
        finalData.put("contactNumber", ActionHelper.getRandomNumberString(10));
        fillWithClear_DropDetailsContactName_Txt(finalData.get("contactName"));
        fillWithClear_DropDetailsContactNumber_Txt(finalData.get("contactNumber"));
        finalData.put("facility", setDropFacilityByIndex(2));
        finalData.put("dropDate", ActionHelper.getCurrentDay() + "-" + ActionHelper.getCurrentMonth() + "-" + ActionHelper.getCurrentYear());
        fill_DropDetailsDropDate_Txt(finalData.get("dropDate"));
        return finalData;
    }

    public Map<String, String> addFacilityDropDetails(String dropDate) {
        Map<String, String> finalData = new HashMap<>();
        ActionHelper.scrollTillElement(dropDetailsHeader_Lbl.getBy());
        click_DropDetailsFacilityStore_Radio();
        finalData.put("contactName", sampleData.artist().name());
        finalData.put("contactNumber", ActionHelper.getRandomNumberString(10));
        fillWithClear_DropDetailsContactName_Txt(finalData.get("contactName"));
        fillWithClear_DropDetailsContactNumber_Txt(finalData.get("contactNumber"));
        finalData.put("facility", setDropFacilityByIndex(1));
        finalData.put("dropDate", dropDate);
        fill_DropDetailsDropDate_Txt(dropDate);
        return finalData;
    }

    public String addPaymentDetails(String paymentType) {
        String amount = null;
        ActionHelper.scrollTillElement(paymentDetailsHeader_Lbl.getBy());
        Utility.select_FromDropDown_List(paymentDetailsPaymentType_Select.getBy(), paymentDetailsPaymentTypeSelect_Option.getBy(), paymentType);
        if (!paymentType.equals("Prepaid")) {
            amount = ActionHelper.getRandomNumberString(3);
            fillWithClear_PaymentDetailsOrderAmount_Txt(amount);
        }
        return amount;
    }

    public void fillShipmentDetails() {
        fillWithClear_ShipmentDetailsShipmentID_Txt(sampleData.idNumber().valid().replace("-", ""));
        fillWithClear_ShipmentDetailsDescription_Txt(sampleData.backToTheFuture().quote());
        fillWithClear_ShipmentDetailsVolume_Txt("10");
        fillWithClear_ShipmentDetailsWeight_Txt("10");
        fillWithClear_ShipmentDetailsDimensionsBreadth_Txt("10");
        fillWithClear_ShipmentDetailsDimensionsHeight_Txt("10");
        fillWithClear_ShipmentDetailsDimensionsLength_Txt("10");
        click_ShipmentDetailsAddShipment_Btn();
    }

    public int get_TotalNumberOfShipmentRows_Count() {
        return ActionHelper.findElements(shipmentDetailsRow).size();
    }

    public void fillWithClear_ShipmentDetailVolume_Txt(String value) {
        ActionHelper.fillWithClear(setShipmentDetailsVolume_Txt.getBy(), value);
    }

    public void fillWithClear_ShipmentDetailWeight_Txt(String value) {
        ActionHelper.fillWithClear(setShipmentDetailsWeight_Txt.getBy(), value);
    }
}
