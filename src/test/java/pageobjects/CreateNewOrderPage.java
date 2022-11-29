package pageobjects;

import com.github.javafaker.Faker;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

import java.awt.*;
import java.util.List;

public class CreateNewOrderPage {
    private static CreateNewOrderPage _instance;

    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//h2[text()='Create New Order']"));
    private final Locator homeBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/']/p[text()='Home']"));
    private final Locator orderListBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/orders/']/p[text()='Order List']"));
    private final Locator createOrderBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/orders/add/']/p[text()='Create Order']"));

    private final Locator orderDetailsHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Order Details']"));
    private final Locator orderDetailsOrderId_Txt = Locator.builder().withWeb(By.xpath("//input[@name='orderId']"));
    private final Locator orderDetailsScannableBarcodeNumber_Txt = Locator.builder().withWeb(By.xpath("//input[@name='barcodeNumber']"));
    private final Locator orderDetailsOrderDescription_Txt = Locator.builder().withWeb(By.xpath("//textarea[@name='orderDescription']"));
    private final Locator orderDetailsTeam_Dropdown = Locator.builder().withWeb(By.xpath("//div[label[text()='Team*']]//input"));

    private final Locator pickupDetailsHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Pickup Details']"));
    private final Locator pickupDetailsContactName_Txt = Locator.builder().withWeb(By.xpath("//input[@name='contactName']"));
    private final Locator pickupDetailsContactNumber_Txt = Locator.builder().withWeb(By.xpath("//input[@name='primaryMobile']"));
    private final Locator pickupDetailsSelectAFacility_Dropdown = Locator.builder().withWeb(By.xpath("//label[text()='Select a Facility*']/following-sibling::div//input[@type='search']"));
    private final Locator pickupDetailsPostalCode_Txt = Locator.builder().withWeb(By.xpath("//input[@name='postalCode']"));
    private final Locator pickupDetailsCountry_Select = Locator.builder().withWeb(By.xpath("//select[@placeholder='Enter country']"));
    private final Locator pickupDetailsAddressLine1_Txt = Locator.builder().withWeb(By.xpath("//input[@name='addressLine1']"));
    private final Locator pickupDetailsAddressLine2_Txt = Locator.builder().withWeb(By.xpath("//input[@name='addressLine2']"));
    private final Locator pickupDetailsState_Txt = Locator.builder().withWeb(By.xpath("//input[@name='state']"));
    private final Locator pickupDetailsCity_Txt = Locator.builder().withWeb(By.xpath("//input[@name='city']"));
    private final Locator pickupDetailsClearAll_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Clear All']"));

    private final Locator dropDetailsHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Drop Details']"));
    private final Locator dropDetailsContactName_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropContactName']"));
    private final Locator dropDetailsContactNumber_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropPrimaryMobile']"));
    private final Locator dropDetailsSelectAFacility_Dropdown = Locator.builder().withWeb(By.xpath("(//label[text()='Select a Facility*']/following-sibling::div//input[@type='search'])[2]"));
    private final Locator dropDetailsPostalCode_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropPostalCode']"));
    private final Locator dropDetailsCountry_Select = Locator.builder().withWeb(By.xpath("(//select[@placeholder='Enter country'])[2]"));
    private final Locator dropDetailsAddressLine1_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropAddressLine1']"));
    private final Locator dropDetailsAddressLine2_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropAddressLine2']"));
    private final Locator dropDetailsState_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropState']"));
    private final Locator dropDetailsCity_Txt = Locator.builder().withWeb(By.xpath("//input[@name='dropCity']"));
    private final Locator dropDetailsClearAll_Btn = Locator.builder().withWeb(By.xpath("(//div[text()='Clear All'])[2]"));

    private final Locator paymentDetailsHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Payment Details']"));
    private final Locator paymentDetailsPaymentType_Select = Locator.builder().withWeb(By.xpath("//select[@name='paymentDetails.paymentType']"));
    private final Locator paymentDetailsOrderAmount_Txt = Locator.builder().withWeb(By.xpath("//input[@name='paymentDetails.orderAmount']"));

    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']"));
    private final Locator create_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Create']"));

    private final Locator orderDetailsOrderIdValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@placeholder='Enter order id']]/following-sibling::span"));
    private final Locator orderDetailsOrderDescriptionValidationError_Lbl = Locator.builder().withWeb(By.xpath("//textarea[@placeholder='Enter order description']/following-sibling::span"));
    private final Locator orderDetailsTeamValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[label[text()='Team*']]//input/following-sibling::span"));

    private final Locator pickupDetailsContactNameValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@placeholder='Enter Contact Name*']]/following-sibling::span"));
    private final Locator pickupDetailsContactNumberValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@placeholder='Enter Contact Number*']]/following-sibling::span"));
    private final Locator pickupDetailsSelectAFacilityValidationError_Lbl = Locator.builder().withWeb(By.xpath("//label[text()='Select a Facility*']/following-sibling::div//span[input[@type='search']]/following-sibling::span"));
    private final Locator pickupDetailsPostalCodeValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@placeholder='Enter postal code*']]/following-sibling::span"));
    private final Locator pickupDetailsCountryValidationError_Lbl = Locator.builder().withWeb(By.xpath("//select[@placeholder='Enter country']/following-sibling::span"));
    private final Locator pickupDetailsAddressLine1ValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@placeholder='Enter address line 1']]/following-sibling::span"));
    private final Locator pickupDetailsAddressLine2ValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@placeholder='Enter address line 2']]/following-sibling::span"));
    private final Locator pickupDetailsStateValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@placeholder='Enter state']]/following-sibling::span"));
    private final Locator pickupDetailsCityValidationError_Lbl = Locator.builder().withWeb(By.xpath("//div[div/input[@placeholder='Enter city']]/following-sibling::span"));

    private final Locator dropDetailsContactNameValidationError_Lbl = Locator.builder().withWeb(By.xpath("(//div[div/input[@placeholder='Enter Contact Name*']])[2]/following-sibling::span"));
    private final Locator dropDetailsContactNumberValidationError_Lbl = Locator.builder().withWeb(By.xpath("(//div[div/input[@placeholder='Enter Contact Number*']])[2]/following-sibling::span"));
    private final Locator dropDetailsSelectAFacilityValidationError_Lbl = Locator.builder().withWeb(By.xpath("(//label[text()='Select a Facility*']/following-sibling::div//span[input[@type='search']])[2]/following-sibling::span"));
    private final Locator dropDetailsPostalCodeValidationError_Lbl = Locator.builder().withWeb(By.xpath("(//div[div/input[@placeholder='Enter postal code*']])[2]/following-sibling::span"));
    private final Locator dropDetailsCountryValidationError_Lbl = Locator.builder().withWeb(By.xpath("(//select[@placeholder='Enter country'])[2]/following-sibling::span"));
    private final Locator dropDetailsAddressLine1ValidationError_Lbl = Locator.builder().withWeb(By.xpath("(//div[div/input[@placeholder='Enter address line 1']])[2]/following-sibling::span"));
    private final Locator dropDetailsAddressLine2ValidationError_Lbl = Locator.builder().withWeb(By.xpath("(//div[div/input[@placeholder='Enter address line 2']])[2]/following-sibling::span"));
    private final Locator dropDetailsStateValidationError_Lbl = Locator.builder().withWeb(By.xpath("(//div[div/input[@placeholder='Enter state']])[2]/following-sibling::span"));
    private final Locator dropDetailsCityValidationError_Lbl = Locator.builder().withWeb(By.xpath("(//div[div/input[@placeholder='Enter city']])[2]/following-sibling::span"));

    private final Locator paymentDetailsPaymentTypeValidationError_Lbl = Locator.builder().withWeb(By.xpath("//select[@name='paymentDetails.paymentType']/following-sibling::span"));

    private final Locator addFacility_Btn = Locator.builder().withWeb(By.xpath("//div[@class='ant-select-item ant-select-item-option ant-select-item-option-active']//p"));

    private final Locator addFacilityFacilityName_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='basicDetails.name']"));
    private final Locator addFacilityFacilityId_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='basicDetails.ID']"));
    private final Locator addFacilityPostalCode_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.postalCode']"));
    private final Locator addFacilityAddressLine1_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.addressLine1']"));
    private final Locator addFacilityAddressLine2_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.addressLine2']"));
    private final Locator addFacilityState_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.state']"));
    private final Locator addFacilityCity_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.city']"));
    private final Locator addFacilityFacilityNameRequiredMandatory_Msg = Locator.builder().withWeb(By.xpath("//p[text()='Required']/..//input[@name='basicDetails.name']"));
    private final Locator addFacilityPostalCodeRequiredMandatory_Msg = Locator.builder().withWeb(By.xpath("//p[text()='Required']/..//input[@name='addressDetails.postalCode']"));
    private final Locator addFacilityAddressLine1RequiredMandatory_Msg = Locator.builder().withWeb(By.xpath("//p[text()='Required']/..//input[@name='addressDetails.addressLine1']"));
    private final Locator addFacilityAddressLine2RequiredMandatory_Msg = Locator.builder().withWeb(By.xpath("//p[text()='Required']/..//input[@name='addressDetails.addressLine2']"));
    private final Locator addFacilityStateRequiredMandatory_Msg = Locator.builder().withWeb(By.xpath("//p[text()='Required']/..//input[@name='addressDetails.state']"));
    private final Locator addFacilityCityRequiredMandatory_Msg = Locator.builder().withWeb(By.xpath("//p[text()='Required']/..//input[@name='addressDetails.city']"));
    private final Locator addFacilityCreateFacility_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Create']/.."));
    private final Locator addFacilityCancelFacility_Btn = Locator.builder().withWeb(By.xpath("(//p[text()='Cancel']/..)[1]"));
    Faker sampleData = new Faker();

    public static CreateNewOrderPage getInstance() {
        if (_instance == null) {
            _instance = new CreateNewOrderPage();
        }
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        return ActionHelper.isPresent(header_Lbl);
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
        ActionHelper.fillWithClear(orderDetailsOrderDescription_Txt.getBy(), value);
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

    public String getText_OrderDetailsTeam_Dropdown() {
        return ActionHelper.getText(orderDetailsTeam_Dropdown);
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

    public String getText_PickupDetailsSelectAFacility_Dropdown() {
        return ActionHelper.getText(pickupDetailsSelectAFacility_Dropdown);
    }

    public boolean isPresent_PickupDetailsPostalCode_Txt() {
        return ActionHelper.isPresent(pickupDetailsPostalCode_Txt);
    }

    public void fill_PickupDetailsPostalCode_Txt(String value) {
        ActionHelper.fill(pickupDetailsPostalCode_Txt, value);
    }

    public void fillWithClear_PickupDetailsPostalCode_Txt(String value) {
        ActionHelper.fillWithClear(pickupDetailsPostalCode_Txt.getBy(), value);
    }

    public void clear_PickupDetailsPostalCode_Txt() {
        ActionHelper.clear(pickupDetailsPostalCode_Txt.getBy());
    }

    public String getValue_PickupDetailsPostalCode_Txt() {
        return ActionHelper.getAttribute(pickupDetailsPostalCode_Txt, "value");
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

    public String getText_DropDetailsSelectAFacility_Dropdown() {
        return ActionHelper.getText(dropDetailsSelectAFacility_Dropdown);
    }

    public boolean isPresent_DropDetailsPostalCode_Txt() {
        return ActionHelper.isPresent(dropDetailsPostalCode_Txt);
    }

    public void fill_DropDetailsPostalCode_Txt(String value) {
        ActionHelper.fill(dropDetailsPostalCode_Txt, value);
    }

    public void fillWithClear_DropDetailsPostalCode_Txt(String value) {
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

    public Boolean isPresent_AddFacilityFacilityName_TxtBox() {
        return ActionHelper.isPresent(addFacilityFacilityName_TxtBox, 10000);
    }

    public void set_AddFacilityFacilityName_TxtBox(String facilityName) {
        ActionHelper.sendKeysWithClear(addFacilityFacilityName_TxtBox.getBy(), facilityName);
    }

    public Boolean isPresent_AddFacilityFacilityId_TxtBox() {
        return ActionHelper.isPresent(addFacilityFacilityId_TxtBox);
    }

    public String get_addFacilityFacilityId_TxtBox() {
        return ActionHelper.getText(addFacilityFacilityId_TxtBox.getBy());
    }

    public Boolean isPresent_AddFacilityPostalCode_TxtBox() {
        return ActionHelper.isPresent(addFacilityPostalCode_TxtBox);
    }

    public void set_AddFacilityPostalCode_TxtBox(String postalCode) {
        ActionHelper.sendKeysWithClear(addFacilityPostalCode_TxtBox.getBy(), Keys.chord(postalCode + Keys.TAB));
        ActionHelper.waitForLoaderToHide();
    }

    public Boolean isPresent_AddFacilityAddressLine1_TxtBox() {
        return ActionHelper.isPresent(addFacilityAddressLine1_TxtBox);
    }

    public void set_AddFacilityAddressLine1_TxtBox(String address) {
        ActionHelper.sendKeysWithClear(addFacilityAddressLine1_TxtBox.getBy(), Keys.chord(address + Keys.TAB));
    }

    public Boolean isPresent_AddFacilityAddressLine2_TxtBox() {
        return ActionHelper.isPresent(addFacilityAddressLine2_TxtBox);
    }

    public void set_AddFacilityAddressLine2_TxtBox(String address) {
        ActionHelper.sendKeysWithClear(addFacilityAddressLine2_TxtBox.getBy(), address);
    }

    public Boolean isPresent_AddFacilityState_TxtBox() {
        return ActionHelper.isPresent(addFacilityState_TxtBox);
    }

    public String get_AddFacilityState_TxtBox() {
        return ActionHelper.getText(addFacilityState_TxtBox);
    }

    public Boolean isPresent_AddFacilityCity_TxtBox() {
        return ActionHelper.isPresent(addFacilityCity_TxtBox);
    }

    public String get_AddFacilityCity_TxtBox() {
        return ActionHelper.getText(addFacilityCity_TxtBox);
    }

    public void addFacility(String facilityName, String postalCode, String addressLine1, String addressLine2) {
        set_AddFacilityFacilityName_TxtBox(facilityName);
        set_AddFacilityPostalCode_TxtBox(postalCode);
        set_AddFacilityAddressLine1_TxtBox(addressLine1);
        set_AddFacilityAddressLine2_TxtBox(addressLine2);
    }

    public void click_AddFacilityCreateFacility_Btn() {
        ActionHelper.click(addFacilityCreateFacility_Btn);
    }

    public void click_AddFacilityCancelFacility_Btn() {
        ActionHelper.click(addFacilityCancelFacility_Btn);
    }

    public Boolean isPresent_AddFacilityFacilityNameRequiredMandatory_Msg() {
        return ActionHelper.isPresent(addFacilityFacilityNameRequiredMandatory_Msg);
    }

    public Boolean isPresent_AddFacilityPostalCodeRequiredMandatory_Msg() {
        return ActionHelper.isPresent(addFacilityPostalCodeRequiredMandatory_Msg);
    }

    public Boolean isPresent_AddFacilityAddressLine1RequiredMandatory_Msg() {
        return ActionHelper.isPresent(addFacilityAddressLine1RequiredMandatory_Msg);
    }

    public Boolean isPresent_AddFacilityAddressLine2RequiredMandatory_Msg() {
        return ActionHelper.isPresent(addFacilityAddressLine2RequiredMandatory_Msg);
    }

    public Boolean isPresent_AddFacilityStateRequiredMandatory_Msg() {
        return ActionHelper.isPresent(addFacilityStateRequiredMandatory_Msg);
    }

    public Boolean isPresent_AddFacilityCityRequiredMandatory_Msg() {
        return ActionHelper.isPresent(addFacilityCityRequiredMandatory_Msg);
    }

    public void validateAndCreateFacility(String input, String postalCode) throws AWTException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        if (input.equalsIgnoreCase("Pickup"))
            click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        else click_AddFacilityBtn_DropDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(isPresent_AddFacilityFacilityName_TxtBox(), "Facility name is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityFacilityId_TxtBox(), "Facility Id is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityPostalCode_TxtBox(), "Add Facility Postal code is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityAddressLine1_TxtBox(), "Address Line 1 text box is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityAddressLine2_TxtBox(), "Address Line 2 text box is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityState_TxtBox(), "State text box is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityCity_TxtBox(), "City text box is present as expected");
        click_AddFacilityCreateFacility_Btn();
        softAssert.assertTrue(isPresent_AddFacilityFacilityNameRequiredMandatory_Msg(), "Facility name required message is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityPostalCodeRequiredMandatory_Msg(), "Postal code required message is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityAddressLine1RequiredMandatory_Msg(), "Address line 1 required message is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityAddressLine2RequiredMandatory_Msg(), "Address line 2 required message is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityStateRequiredMandatory_Msg(), "State required message is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityCityRequiredMandatory_Msg(), "City required message is present as expected");
        softAssert.assertAll();
        createFacility(postalCode);
    }

    public void set_PickUpFacility_TextBox() {
        ActionHelper.sendKeysWithClear(pickupDetailsSelectAFacility_Dropdown.getBy(), Keys.chord("facility" + Keys.ENTER));
        ActionHelper.waitForLoaderToHide();
    }

    public void set_DropFacility_TextBox() {
        ActionHelper.sendKeysWithClear(dropDetailsSelectAFacility_Dropdown.getBy(), Keys.chord("facility" + Keys.ENTER));
        ActionHelper.waitForLoaderToHide();
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
        isPresent_AddFacilityFacilityName_TxtBox();
        set_AddFacilityFacilityName_TxtBox("Facility " + sampleData.number().digits(4));
        set_AddFacilityPostalCode_TxtBox(postalCode);
        set_AddFacilityAddressLine1_TxtBox("Building No " + sampleData.number().digits(2));
        set_AddFacilityAddressLine2_TxtBox("Street No " + sampleData.number().digits(2));
        softAssert.assertTrue(get_AddFacilityState_TxtBox() != null, "State Text box is not null as expected");
        softAssert.assertTrue(get_AddFacilityCity_TxtBox() != null, "City Text box is not null as expected");
        softAssert.assertAll();
        ActionHelper.click(addFacilityState_TxtBox);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        click_AddFacilityCreateFacility_Btn();
        ActionHelper.waitForLoaderToHide();
    }
}
