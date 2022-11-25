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

public class CreateOrderPage {
    private static CreateOrderPage _instance;
    private final Locator headerLbl = Locator.builder().withWeb(By.xpath("//h2[text()='Create New Order']"));
    private final Locator orderId_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='orderId']"));
    private final Locator barcodeNumber_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='barcodeNumber']"));
    private final Locator description_TxtBox = Locator.builder().withWeb(By.xpath("//textarea[@placeholder='Enter order description']"));
    private final Locator team_DropDown = Locator.builder().withWeb(By.xpath("//div[@class='rc-virtual-list-holder']"));
    private final Locator postalCode_TextBox = Locator.builder().withWeb(By.xpath("//input[@name='postalCode']"));
    private final Locator addressLine1_TextBox = Locator.builder().withWeb(By.xpath("//input[@name='addressLine1']"));
    private final Locator addressLine2_TextBox = Locator.builder().withWeb(By.xpath("//input[@name='addressLine2']"));
    private final Locator state_TextBox = Locator.builder().withWeb(By.xpath("//input[@name='state']"));
    private final Locator city_TextBox = Locator.builder().withWeb(By.xpath("//input[@name='city']"));
    private final Locator pickupFacility_DropDown = Locator.builder().withWeb(By.xpath("//h4[text()='Pickup Details']/../following-sibling::div//label[text()='Select a Facility*']/..//input[@class='ant-select-selection-search-input']"));
    private final Locator contactName_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='contactName']"));
    private final Locator primaryMobileNumber_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='primaryMobile']"));

    private final Locator dropContactName_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='dropContactName']"));
    private final Locator dropPrimaryMobileNumber_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='dropPrimaryMobile']"));
    private final Locator dropPostalCode_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='dropPostalCode']"));
    private final Locator dropAddress1_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='dropAddressLine1']"));
    private final Locator dropAddress2_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='dropAddressLine2']"));
    private final Locator dropState_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='dropState']"));
    private final Locator dropCity_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='dropCity']"));
    private final Locator selectPaymentType_TxtBox = Locator.builder().withWeb(By.xpath("//select[@name='paymentDetails.paymentType']"));
    private final Locator orderAmount_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='paymentDetails.orderAmount']"));
    private final Locator submit_Btn = Locator.builder().withWeb(By.xpath("//button[@id='submitForm']"));
    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']/.."));
    private final Locator teamSelect_Btn = Locator.builder().withWeb(By.xpath("//label[text()='Team*']/..//input"));
    private final Locator orderDetailsProductType_Select = Locator.builder().withWeb(By.xpath("//h4[text()='Payment Type*']/../following-sibling::div/select"));
    private final Locator enterFacility = Locator.builder().withWeb(By.xpath("(//span[@class='ant-select-selection-placeholder'])[1]"));
    private final Locator dropFacility_DropDown = Locator.builder().withWeb(By.xpath("//h4[text()='Drop Details']/../following-sibling::div//label[text()='Select a Facility*']/..//input[@class='ant-select-selection-search-input']"));
    private final Locator dropContactName_TextBox = Locator.builder().withWeb(By.xpath("//input[@name='dropContactName']"));
    private final Locator dropMobileNumber_TextBox = Locator.builder().withWeb(By.xpath("//input[@name='dropPrimaryMobile']"));
    private final Locator orderAmount_TextBox = Locator.builder().withWeb(By.xpath("//input[@name='paymentDetails.orderAmount']"));
    private final Locator addFacility_Btn = Locator.builder().withWeb(By.xpath("//div[@class='ant-select-item ant-select-item-option ant-select-item-option-active']//p"));

    private final Locator facilityName_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='basicDetails.name']"));
    private final Locator facilityId_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='basicDetails.ID']"));
    private final Locator addFacilityPostalCode_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.postalCode']"));
    private final Locator addFacilityAddressLine1_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.addressLine1']"));
    private final Locator addFacilityAddressLine2_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.addressLine2']"));
    private final Locator addFacilityState_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.state']"));
    private final Locator addFacilityCity_TxtBox = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.city']"));
    private final Locator facilityNameRequiredMandatory_Msg = Locator.builder().withWeb(By.xpath("//p[text()='Required']/..//input[@name='basicDetails.name']"));
    private final Locator postalCodeRequiredMandatory_Msg = Locator.builder().withWeb(By.xpath("//p[text()='Required']/..//input[@name='addressDetails.postalCode']"));
    private final Locator addressLine1RequiredMandatory_Msg = Locator.builder().withWeb(By.xpath("//p[text()='Required']/..//input[@name='addressDetails.addressLine1']"));
    private final Locator addressLine2RequiredMandatory_Msg = Locator.builder().withWeb(By.xpath("//p[text()='Required']/..//input[@name='addressDetails.addressLine2']"));
    private final Locator stateRequiredMandatory_Msg = Locator.builder().withWeb(By.xpath("//p[text()='Required']/..//input[@name='addressDetails.state']"));
    private final Locator cityRequiredMandatory_Msg = Locator.builder().withWeb(By.xpath("//p[text()='Required']/..//input[@name='addressDetails.city']"));
    private final Locator createFacility_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Create']/.."));
    private final Locator cancelFacility_Btn = Locator.builder().withWeb(By.xpath("(//p[text()='Cancel']/..)[1]"));
    private final Locator pickUpClearAll_Btn = Locator.builder().withWeb(By.xpath("(//div[text()='Clear All'])[1]"));
    private final Locator dropClearAll_Btn = Locator.builder().withWeb(By.xpath("(//div[text()='Clear All'])[2]"));
    private final Locator state_TxtBox = Locator.builder().withWeb(By.xpath("//h4[text()='State*']"));
    Faker sampleData = new Faker();

    public static CreateOrderPage getInstance() {
        if (_instance == null) _instance = new CreateOrderPage();
        return _instance;
    }

    public Boolean isPresent_OrderId_TxtBox() {
        return ActionHelper.isPresent(orderId_TxtBox);
    }

    public Boolean isPresent_BarcodeNumber_TxtBox() {
        return ActionHelper.isPresent(barcodeNumber_TxtBox);
    }

    public Boolean isPresent_Description_TxtBox() {
        return ActionHelper.isPresent(description_TxtBox);
    }

    public Boolean isPresent_Team_DropDown() {
        return ActionHelper.isPresent(teamSelect_Btn);
    }

    public Boolean isPresent_PickupContactName_DropDown() {
        return ActionHelper.isPresent(contactName_TxtBox);
    }

    public Boolean isPresent_PrimaryMobileNumber_TxtBox() {
        return ActionHelper.isPresent(primaryMobileNumber_TxtBox);
    }

    public Boolean isPresent_DropContactName_TxtBox() {
        return ActionHelper.isPresent(dropContactName_TxtBox);
    }

    public Boolean isPresent_DropPrimaryMobileNumber_TxtBox() {
        return ActionHelper.isPresent(dropPrimaryMobileNumber_TxtBox);
    }

    public Boolean isPresent_SelectPaymentType_TxtBox() {
        return ActionHelper.isPresent(selectPaymentType_TxtBox);
    }

    public Boolean isPresent_OrderAmount_TxtBox() {
        return ActionHelper.isPresent(orderAmount_TxtBox);
    }

    public Boolean isPresent_Submit_Btn() {
        return ActionHelper.isPresent(submit_Btn);
    }

    public Boolean isPresent_Cancel_Btn() {
        return ActionHelper.isPresent(cancel_Btn);
    }

    public Boolean isPresent_Header_Lbl() {
        return ActionHelper.isPresent(headerLbl);
    }

    public void team() {
        ActionHelper.sendKeysWithClear(teamSelect_Btn.getBy(), Keys.chord("TestingTeam" + Keys.TAB));
    }

    public void selectByValue_OrderDetailsProductType_Select(String value) {
        Utility.scrollUsingJS(orderDetailsProductType_Select.getBy());
        (new Select(ActionHelper.findElement(orderDetailsProductType_Select))).selectByVisibleText(value);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void set_OrderId(String orderId) {
        ActionHelper.sendKeysWithClear(orderId_TxtBox.getBy(), orderId);
    }

    public void set_Description(String description) {
        ActionHelper.sendKeysWithClear(description_TxtBox.getBy(), Keys.chord(description + Keys.TAB));
    }

    public void set_PickUpFacility_TextBox() {
        ActionHelper.sendKeysWithClear(pickupFacility_DropDown.getBy(), Keys.chord("facility" + Keys.ENTER));
        ActionHelper.waitForLoaderToHide();
    }

    public void set_DropFacility_TextBox() {
        ActionHelper.sendKeysWithClear(dropFacility_DropDown.getBy(), Keys.chord("facility" + Keys.ENTER));
        ActionHelper.waitForLoaderToHide();
    }

    public void set_ContactName_TextBox(String contactName) {
        ActionHelper.sendKeys(contactName_TxtBox, contactName);
    }

    public void set_PrimaryMobileNumber_TxtBox(String primaryMobileNumber) {
        ActionHelper.sendKeysWithClear(primaryMobileNumber_TxtBox.getBy(), primaryMobileNumber);
    }

    public void set_DropContactName_TextBox(String contactName) {
        ActionHelper.sendKeys(dropContactName_TextBox, contactName);
    }

    public void click_Submit_Btn() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(submit_Btn);
        CommonActions.getInstance().click_Skip_Btn();
        ActionHelper.waitForLoaderToHide();
        DriverManager.getDriver().navigate().refresh();
        CommonActions.getInstance().click_Skip_Btn();
    }

    public void set_DropMobileNumber_TextBox(String dropMobileNumber) {
        ActionHelper.sendKeys(dropMobileNumber_TextBox, dropMobileNumber);
    }

    public void set_OrderAmount(String amount) {
        ActionHelper.sendKeysWithClear(orderAmount_TextBox.getBy(), amount);
    }

    public String get_BarcodeNumber_Txt() {
        return ActionHelper.getText(barcodeNumber_TxtBox);
    }


    public void click_AddFacility_Btn(String input) {
        if (input.equals("Pickup"))
            ActionHelper.sendKeysWithClear(pickupFacility_DropDown.getBy(), Keys.chord("DDS" + Keys.UP + Keys.ENTER));
        else
            ActionHelper.sendKeysWithClear(dropFacility_DropDown.getBy(), Keys.chord("DDS" + Keys.UP + Keys.ENTER));
    }

    public Boolean isPresent_FacilityName_TxtBox() {
        return ActionHelper.isPresent(facilityName_TxtBox, 10000);
    }

    public void set_FacilityName_TxtBox(String facilityName) {
        ActionHelper.sendKeysWithClear(facilityName_TxtBox.getBy(), facilityName);
    }

    public Boolean isPresent_FacilityId_TxtBox() {
        return ActionHelper.isPresent(facilityId_TxtBox);
    }

    public String get_FacilityId_TxtBox() {
        return ActionHelper.getText(facilityId_TxtBox.getBy());
    }

    public Boolean isPresent_AddFacilityPostalCode_TxtBox() {
        return ActionHelper.isPresent(addFacilityPostalCode_TxtBox);
    }

    public void set_AddFacilityPostalCode_TxtBox(String postalCode) {
        ActionHelper.sendKeysWithClear(addFacilityPostalCode_TxtBox.getBy(), Keys.chord(postalCode + Keys.TAB));
        ActionHelper.waitForLoaderToHide();
    }

    public Boolean isPresent_AddressLine1_TxtBox() {
        return ActionHelper.isPresent(addFacilityAddressLine1_TxtBox);
    }

    public void set_AddFacilityAddressLine1_TxtBox(String address) {
        ActionHelper.sendKeysWithClear(addFacilityAddressLine1_TxtBox.getBy(), Keys.chord(address + Keys.TAB));
    }

    public Boolean isPresent_AddressLine2_TxtBox() {
        return ActionHelper.isPresent(addFacilityAddressLine2_TxtBox);
    }

    public void set_AddFacilityAddressLine2_TxtBox(String address) {
        ActionHelper.sendKeysWithClear(addFacilityAddressLine2_TxtBox.getBy(), address);
    }

    public Boolean isPresent_State_TxtBox() {
        return ActionHelper.isPresent(addFacilityState_TxtBox);
    }

    public String get_AddFacilityState_TxtBox() {
        return ActionHelper.getText(addFacilityState_TxtBox);
    }

    public Boolean isPresent_City_TxtBox() {
        return ActionHelper.isPresent(addFacilityCity_TxtBox);
    }

    public String get_AddFacilityCity_TxtBox() {
        return ActionHelper.getText(addFacilityCity_TxtBox);
    }

    public void addFacility(String facilityName, String postalCode, String addressLine1, String addressLine2) {
        set_FacilityName_TxtBox(facilityName);
        set_AddFacilityPostalCode_TxtBox(postalCode);
        set_AddFacilityAddressLine1_TxtBox(addressLine1);
        set_AddFacilityAddressLine2_TxtBox(addressLine2);
    }

    public void click_CreateFacility_Btn() {
        ActionHelper.click(createFacility_Btn);
    }

    public void click_CancelFacility_Btn() {
        ActionHelper.click(cancelFacility_Btn);
    }

    public Boolean isPresent_FacilityNameRequiredMandatory_Msg() {
        return ActionHelper.isPresent(facilityNameRequiredMandatory_Msg);
    }

    public Boolean isPresent_PostalCodeRequiredMandatory_Msg() {
        return ActionHelper.isPresent(postalCodeRequiredMandatory_Msg);
    }

    public Boolean isPresent_AddressLine1RequiredMandatory_Msg() {
        return ActionHelper.isPresent(addressLine1RequiredMandatory_Msg);
    }

    public Boolean isPresent_AddressLine2RequiredMandatory_Msg() {
        return ActionHelper.isPresent(addressLine2RequiredMandatory_Msg);
    }

    public Boolean isPresent_StateRequiredMandatory_Msg() {
        return ActionHelper.isPresent(stateRequiredMandatory_Msg);
    }

    public Boolean isPresent_CityRequiredMandatory_Msg() {
        return ActionHelper.isPresent(cityRequiredMandatory_Msg);
    }

    public void set_PickupPostalCode_TxtBox(String postalCode) {
        ActionHelper.sendKeysWithClear(postalCode_TextBox.getBy(), postalCode);
    }

    public String get_PickupPostalCode_TxtBox() {
        return ActionHelper.getAttribute(postalCode_TextBox, "value");
    }

    public void set_AddressLine1_TxtBox(String address) {
        ActionHelper.sendKeysWithClear(addressLine1_TextBox.getBy(), address);
    }

    public String get_AddressLine1_TxtBox() {
        return ActionHelper.getAttribute(addressLine1_TextBox, "value");
    }

    public void set_AddressLine2_TxtBox(String address) {
        ActionHelper.sendKeysWithClear(addressLine2_TextBox.getBy(), address);
    }

    public String get_AddressLine2_TxtBox() {
        return ActionHelper.getAttribute(addressLine2_TextBox, "value");
    }

    public void set_DropPostalCode_TxtBox(String postalCode) {
        ActionHelper.waitUntilElementVisible(dropPostalCode_TxtBox.getBy());
        ActionHelper.sendKeysWithClear(dropPostalCode_TxtBox.getBy(), postalCode);
    }

    public String get_DropPostalCode_TxtBox() {
        return ActionHelper.getAttribute(dropPostalCode_TxtBox, "value");
    }

    public void set_DropAddressLine1_TxtBox(String address) {
        ActionHelper.sendKeysWithClear(dropAddress1_TxtBox.getBy(), address);
    }

    public String get_DropAddressLine1_TxtBox() {
        return ActionHelper.getAttribute(dropAddress1_TxtBox, "value");
    }

    public void set_DropAddressLine2_TxtBox(String address) {
        ActionHelper.sendKeysWithClear(dropAddress2_TxtBox.getBy(), address);
    }

    public String get_DropAddressLine2_TxtBox() {
        return ActionHelper.getAttribute(dropAddress2_TxtBox, "value");
    }

    public void validateAndCreateFacility(String input, String postalCode) throws AWTException {
        click_AddFacility_Btn(input);
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(isPresent_FacilityName_TxtBox(), "Facility name is present as expected");
        softAssert.assertTrue(isPresent_FacilityId_TxtBox(), "Facility Id is present as expected");
        softAssert.assertTrue(isPresent_AddFacilityPostalCode_TxtBox(), "Add Facility Postal code is present as expected");
        softAssert.assertTrue(isPresent_AddressLine1_TxtBox(), "Address Line 1 text box is present as expected");
        softAssert.assertTrue(isPresent_AddressLine2_TxtBox(), "Address Line 2 text box is present as expected");
        softAssert.assertTrue(isPresent_State_TxtBox(), "State text box is present as expected");
        softAssert.assertTrue(isPresent_City_TxtBox(), "City text box is present as expected");
        click_CreateFacility_Btn();
        softAssert.assertTrue(isPresent_FacilityNameRequiredMandatory_Msg(), "Facility name required message is present as expected");
        softAssert.assertTrue(isPresent_PostalCodeRequiredMandatory_Msg(), "Postal code required message is present as expected");
        softAssert.assertTrue(isPresent_AddressLine1RequiredMandatory_Msg(), "Address line 1 required message is present as expected");
        softAssert.assertTrue(isPresent_AddressLine2RequiredMandatory_Msg(), "Address line 2 required message is present as expected");
        softAssert.assertTrue(isPresent_StateRequiredMandatory_Msg(), "State required message is present as expected");
        softAssert.assertTrue(isPresent_CityRequiredMandatory_Msg(), "City required message is present as expected");
        softAssert.assertAll();
        createFacility(postalCode);
    }

    public void fill_Pickup_Details(String postalCode, String addressLine1, String addressLine2) {
        set_PickupPostalCode_TxtBox(postalCode);
        set_AddressLine1_TxtBox(addressLine1);
        set_AddressLine2_TxtBox(addressLine2);
    }

    public void fill_Drop_Details(String postalCode, String addressLine1, String addressLine2) {
        set_DropPostalCode_TxtBox(postalCode);
        set_DropAddressLine1_TxtBox(addressLine1);
        set_DropAddressLine2_TxtBox(addressLine2);
    }

    public void click_PickUpClearAll_Btn() {
        ActionHelper.click(pickUpClearAll_Btn);
    }

    public void click_DropClearAll_Btn() {
        ActionHelper.click(dropClearAll_Btn);
    }

    public void validate_PickUpClear_Btn(String postalCode, String addressLine1, String addressLine2) {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        fill_Pickup_Details(postalCode, addressLine1, addressLine2);
        softAssert.assertEquals(get_PickupPostalCode_TxtBox(), postalCode, "Postal Code is matched expected");
        softAssert.assertEquals(get_AddressLine1_TxtBox(), addressLine1, "Address Line 1 is matched expected");
        softAssert.assertEquals(get_AddressLine2_TxtBox(), addressLine2, "Address Line 2 is matched expected");
        click_PickUpClearAll_Btn();
        softAssert.assertEquals(get_PickupPostalCode_TxtBox(), "", "Postal Code is matched expected");
        softAssert.assertEquals(get_AddressLine1_TxtBox(), "", "Address Line 1 is matched expected");
        softAssert.assertEquals(get_AddressLine2_TxtBox(), "", "Address Line 2 is matched expected");
        ActionHelper.waitForLoaderToHide();
    }

    public void validate_DropClearAll_Btn(String postalCode, String addressLine1, String addressLine2) {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        fill_Drop_Details(postalCode, addressLine1, addressLine2);
        softAssert.assertEquals(get_DropPostalCode_TxtBox(), postalCode, "Postal Code is matched expected");
        softAssert.assertEquals(get_DropAddressLine1_TxtBox(), addressLine1, "Address Line 1 is matched expected");
        softAssert.assertEquals(get_DropAddressLine2_TxtBox(), addressLine2, "Address Line 1 is matched expected");
        click_DropClearAll_Btn();
        softAssert.assertEquals(get_DropPostalCode_TxtBox(), "", "Postal Code is matched expected");
        softAssert.assertEquals(get_DropAddressLine1_TxtBox(), "", "Address Line 1 is matched expected");
        softAssert.assertEquals(get_DropAddressLine2_TxtBox(), "", "Address Line 1 is matched expected");
        ActionHelper.waitForLoaderToHide();
    }

    public void createFacility(String postalCode) {
        Actions actions = new Actions(DriverManager.getDriver());
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        isPresent_FacilityName_TxtBox();
        set_FacilityName_TxtBox("Facility " + sampleData.number().digits(4));
        set_AddFacilityPostalCode_TxtBox(postalCode);
        set_AddFacilityAddressLine1_TxtBox("Building No " + sampleData.number().digits(2));
        set_AddFacilityAddressLine2_TxtBox("Street No " + sampleData.number().digits(2));
        softAssert.assertTrue(get_AddFacilityState_TxtBox() != null, "State Text box is not null as expected");
        softAssert.assertTrue(get_AddFacilityCity_TxtBox() != null, "City Text box is not null as expected");
        softAssert.assertAll();
        ActionHelper.click(addFacilityState_TxtBox);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        click_CreateFacility_Btn();
        ActionHelper.waitForLoaderToHide();
    }
}

