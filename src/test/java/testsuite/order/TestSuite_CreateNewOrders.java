package testsuite.order;

import api.ApiClient;
import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.Constants;
import constants.TestGroup;
import framework.backend.APIResponseException;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.actions.ActionHelper;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.CreateNewOrderPage;
import pageobjects.HomePage;
import pageobjects.ViewOrderPage;
import utility.Utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class TestSuite_CreateNewOrders extends BaseTestClass {

    CommonActions commonActions = CommonActions.getInstance();
    CreateNewOrderPage createNewOrderPage = CreateNewOrderPage.getInstance();
    ViewOrderPage viewOrderPage = ViewOrderPage.getInstance();
    Faker faker = new Faker();

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_001, Verify The UI Of The Create New Order Page")
    public void TC_CreateNewOrder_001_Verify_UI_Of_The_Create_New_Order_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsHeader_Lbl(), "Check Visibility of Order Details header");
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderId_Txt(), "Check Visibility of Order Id text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderDescription_Txt(), "Check Visibility of Order Description text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsTeam_Dropdown(), "Check Visibility of Team dropdown");
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsTotalWeight_Txt(), "Check Visibility of Total Weight");
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsTotalVolume_Txt(), "Check Visibility of Total Volume");

        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsHeader_Lbl(), "Check Visibility of Shipment Header");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsShipmentID_Txt(), "Check Visibility of Shipment ID");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsDescription_Txt(), "Check Visibility of Shipment Details Description");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsWeight_Txt(), "Check Visibility of Shipment weight");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsVolume_Txt(), "Check Visibility of Shipment Volume");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsDimensionsBreadth_Txt(), "Check Visibility of Shipment Dimensions Breadth");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsDimensionsLength_Txt(), "Check Visibility of Shipment Dimensions Length");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsDimensionsHeight_Txt(), "Check Visibility of Shipment Dimensions Height");

        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsHeader_Lbl(), "Check Visibility of Pickup Details header");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactName_Txt(), "Check Visibility of Contact Name text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNumber_Txt(), "Check Visibility of Contact Number text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsSelectAFacility_Dropdown(), "Check Visibility of Select A Facility text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPostalCode_Txt(), "Check Visibility of Postal Code text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCountry_Select(), "Check Visibility of Country dropdown");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine1_Txt(), "Check Visibility of Address Line 1 text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine2_Txt(), "Check Visibility of Address Line 2 text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsState_Txt(), "Check Visibility of State text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCity_Txt(), "Check Visibility of City text box");

        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsHeader_Lbl(), "Check Visibility of Drop Details header");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactName_Txt(), "Check Visibility of Contact Name text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNumber_Txt(), "Check Visibility of Contact Number text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsSelectAFacility_Dropdown(), "Check Visibility of Select A Facility text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsPostalCode_Txt(), "Check Visibility of Postal Code text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCountry_Select(), "Check Visibility of Country dropdown");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine1_Txt(), "Check Visibility of Address Line 1 text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine2_Txt(), "Check Visibility of Address Line 2 text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsState_Txt(), "Check Visibility of State text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCity_Txt(), "Check Visibility of City text box");

        softAssert.assertTrue(createNewOrderPage.isPresent_PaymentDetailsHeader_Lbl(), "Check Visibility of Payment Details header");
        softAssert.assertTrue(createNewOrderPage.isPresent_PaymentDetailsPaymentType_Select(), "Check Visibility of Payment Type dropdown");
        softAssert.assertTrue(createNewOrderPage.isPresent_PaymentDetailsOrderAmount_Txt(), "Check Visibility of Order Amount text box");

        softAssert.assertTrue(createNewOrderPage.isPresent_Cancel_Btn(), "Check Visibility of Cancel button");
        softAssert.assertTrue(createNewOrderPage.isPresent_Create_Btn(), "Check Visibility of Create button");
        softAssert.assertAll();
    }

    @Test(enabled = false, groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_002, Verify The Functionality of Scannable/Barcode Number Text box")
    public void TC_CreateNewOrder_002_Verify_The_Functionality_of_Scannable_Barcode_Number_Text_box() {
        String input = ActionHelper.getRandomNumberString(6);
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fill_OrderDetailsOrderId_Txt(input);
        softAssert.assertEquals(createNewOrderPage.getValue_OrderDetailsScannableBarcodeNumber_Txt(), input, "Validate value for Scanner/Barcode Number field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_003, Verify The Validation Functionality In Create New Order Page For Mandatory Fields with empty")
    public void TC_CreateNewOrder_003_Verify_The_Validation_Functionality_In_Create_New_Order_Page_For_Mandatory_Fields_with_empty() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_PickupDetailsCustomAddress_Radio();
        createNewOrderPage.click_DropDetailsCustomAddress_Radio();
        createNewOrderPage.click_Create_Btn();

        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderIdValidationError_Lbl(), "Validate presence of validation error message for Order Id field");
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderDescriptionValidationError_Lbl(), "Validate presence of validation error message for Order Description field");

        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsValidationError_Lbl(), "Validate presence of validation error message for shipment details");

        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine1ValidationError_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPickupDateValidationError_Lbl(), "Validate presence of validation error message for pickup date field");

        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine1ValidationError_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsDropDateValidationError_Lbl(), "Validate presence of validation error message for drop date field");

        softAssert.assertTrue(createNewOrderPage.isPresent_PaymentDetailsPaymentTypeValidationError_Lbl(), "Validate presence of validation error message for Payment Type field");

        createNewOrderPage.click_PickupDetailsFacilityStore_Radio();
        createNewOrderPage.click_DropDetailsFacilityStore_Radio();
        createNewOrderPage.click_Create_Btn();

        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderIdValidationError_Lbl(), "Validate presence of validation error message for Order Id field");
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderDescriptionValidationError_Lbl(), "Validate presence of validation error message for Order Description field");

        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsValidationError_Lbl(), "Validate presence of validation error message for shipment details");

        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsSelectAFacilityValidationError_Lbl(), "Validate presence of validation error message for pickup select facility");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPickupDateValidationError_Lbl(), "Validate presence of validation error message for pickup date field");

        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsFacilityStore_Radio(), "Validate presence of validation error message for drop select facility");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsDropDateValidationError_Lbl(), "Validate presence of validation error message for drop date field");

        softAssert.assertTrue(createNewOrderPage.isPresent_PaymentDetailsPaymentTypeValidationError_Lbl(), "Validate presence of validation error message for Payment Type field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_004, Verify The Functionality Of Breadcrumb Menu For Create New Order page")
    public void TC_CreateNewOrder_004_Verify_The_Functionality_Of_Breadcrumb_Menu_For_Create_New_Order_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();

        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        softAssert.assertTrue(createNewOrderPage.isPresent_CreateOrderBreadcrumb_Link(), "Validate presence of Create Order Breadcrumb");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_005, Verify The Functionality Of Cancel Button In Create New Order Page")
    public void TC_CreateNewOrder_005_Verify_The_Functionality_Of_Cancel_Button_In_Create_New_Order_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.click_Cancel_Btn();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_006, Verify The Validation Functionality For Order Id In Create New Order Page For Empty Field")
    public void TC_CreateNewOrder_006_Verify_The_Validation_Functionality_For_Order_Id_In_Create_New_Order_Page_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.clear_OrderDetailsOrderId_Txt();
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderIdValidationError_Lbl(), "Validate presence of validation error message for Order Id field");
        softAssert.assertEquals(createNewOrderPage.getText_OrderDetailsOrderIdValidationError_Lbl(), "Required", "Validate text of validation error message for Order Id field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_007, Verify The Validation Functionality For Order Id In Create New Order Page For Minimum Character")
    public void TC_CreateNewOrder_007_Verify_The_Validation_Functionality_For_Order_Id_In_Create_New_Order_Page_For_Minimum_Character() {
        List<String> inputs = List.of("a", "1", "#");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_OrderDetailsOrderId_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderIdValidationError_Lbl(), "Validate presence of validation error message for Order Id field");
            softAssert.assertEquals(createNewOrderPage.getText_OrderDetailsOrderIdValidationError_Lbl(), "Length must be greater than 2", "Validate validation error message for Order Id field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_008, Verify The Validation Functionality For Order Id In Create New Order Page For Maximum Character")
    public void TC_CreateNewOrder_008_Verify_The_Validation_Functionality_For_Order_Id_In_Create_New_Order_Page_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillWithClear_OrderDetailsOrderId_Txt("Max length " + Utility.generateRandomString(128));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderIdValidationError_Lbl(), "Validate presence of validation error message for Order Id field");
        softAssert.assertEquals(createNewOrderPage.getText_OrderDetailsOrderIdValidationError_Lbl(), "Length must be smaller than 128", "Validate validation error message for Order Id field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_009, Verify The Validation Functionality For Order description textbox In Create New Order Page For Empty Field")
    public void TC_CreateNewOrder_009_Verify_The_Validation_Functionality_For_Order_description_textbox_In_Create_New_Order_Page_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.clear_OrderDetailsOrderDescription_Txt();
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderDescriptionValidationError_Lbl(), "Validate presence of validation error message for Order Description field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_010, Verify maximum limit on order description textbox")
    public void TC_CreateNewOrder_010_Verify_maximum_limit_on_order_description_textbox() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillWithClear_OrderDetailsOrderDescription_Txt("Max length" + Utility.generateRandomString(512));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertEquals(createNewOrderPage.getText_OrderDetailsOrderDescriptionValidationError_Lbl(), "Length must be smaller than 512", "Validate validation error message for Order Description field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_011, Verify minimum limit on description textbox")
    public void TC_CreateNewOrder_011_Verify_minimum_limit_on_description_textbox() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillWithClear_OrderDetailsOrderDescription_Txt(ActionHelper.generateRandomName(2, 2));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertEquals(createNewOrderPage.getText_OrderDetailsOrderDescriptionValidationError_Lbl(), "Length must be greater than 3", "Validate validation error message for Order Description field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_012, Verify The Functionality of Teams Dropdown ")
    public void TC_CreateNewOrder_012_Verify_The_Functionality_of_Teams_Dropdown() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertEquals(createNewOrderPage.getValue_OrderDetailsTeam_Dropdown(), Constants.TEAM, "Validate correct value is selected in Team dropdown");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_013, Verify The UI of Pickup Details of Create New Order")
    public void TC_CreateNewOrder_013_Verify_The_UI_of_Pickup_Details_of_Create_New_Order() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsHeader_Lbl(), "Check Visibility of Pickup Details header");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsFacilityStore_Radio(), "Check Visibility of Facility Store radio");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCustomAddress_Radio(), "Check Visibility of Custom Address radio");
        softAssert.assertTrue(createNewOrderPage.isRadioSelected_PickupDetailsFacilityStore_Radio(), "Validate Facility Store radio is already selected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_014, Verify The Validation Functionality For Contact Name of Pickup Details For Empty Field")
    public void TC_CreateNewOrder_014_Verify_The_Validation_Functionality_For_Contact_Name_of_Pickup_Details_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.clear_PickupDetailsContactName_Txt();
        createNewOrderPage.click_Create_Btn();

        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsContactNameValidationError_Lbl(), "Required", "Validate text of validation error message for Contact Name field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_015, Verify The Validation Functionality For Contact Name of Pickup Details For Minimum Character")
    public void TC_CreateNewOrder_015_Verify_The_Validation_Functionality_For_Contact_Name_of_Pickup_Details_For_Minimum_Character() {
        List<String> inputs = List.of("a", "1", "#");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsContactName_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsContactNameValidationError_Lbl(), "Length must be greater than 3", "Validate validation error message for Contact Name field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_016, Verify The Validation Functionality For Contact Name of Pickup Details For Maximum Character")
    public void TC_CreateNewOrder_016_Verify_The_Validation_Functionality_For_Contact_Name_of_Pickup_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillWithClear_PickupDetailsContactName_Txt("Max length" + Utility.generateRandomString(36));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsContactNameValidationError_Lbl(), "Length must be smaller than 36", "Validate validation error message for Contact Name field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_017, Verify The Validation Functionality For Contact Name of Pickup Details For other than Alphabet")
    public void TC_CreateNewOrder_017_Verify_The_Validation_Functionality_For_Contact_Name_of_Pickup_Details_For_other_than_Alphabet() {
        List<String> inputs = List.of("@@@@@", "aa!@$", "aa112", "aa1@1$", "11223");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsContactName_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsContactNameValidationError_Lbl(), "Not correct format", "Validate validation error message for Contact Name field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_018, Verify The Validation Functionality for Phone number of Pickup Details for empty field")
    public void TC_CreateNewOrder_018_Verify_The_Validation_Functionality_for_Phone_number_of_Pickup_Details_for_empty_field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.clear_PickupDetailsContactNumber_Txt();
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsContactNumberValidationError_Lbl(), "Required", "Validate text of validation error message for Contact Number field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_019, Verify The Validation Functionality for Phone number of Pickup Details for Minimum Character")
    public void TC_CreateNewOrder_019_Verify_The_Validation_Functionality_for_Phone_number_of_Pickup_Details_for_Minimum_Character() {
        List<String> inputs = List.of("111", "232322", "2345666", "987509858");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsContactNumber_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsContactNumberValidationError_Lbl(), "Length must be greater than 10", "Validate text of validation error message for Contact Number field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_020, Verify The Validation Functionality for Phone number of Pickup Details for Maximum Character")
    public void TC_CreateNewOrder_020_Verify_The_Validation_Functionality_for_Phone_number_of_Pickup_Details_for_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_PickupDetailsContactNumber_Txt(ActionHelper.getRandomNumberString(11));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsContactNumberValidationError_Lbl(), "Length must be smaller than 10", "Validate text of validation error message for Contact Number field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_021, Verify The Validation For Phone Number of Pickup Details For  Special character and alphabets")
    public void TC_CreateNewOrder_021_Verify_The_Validation_For_Phone_Number_of_Pickup_Details_For_Special_character_and_alphabets() {
        List<String> inputs = List.of("@@@@@", "aa!@$", "aabbbb", "aab@*$", "aaaaaa");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsContactNumber_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsContactNumberValidationError_Lbl(), "Required", "Validate text of validation error message for Contact Number field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_022, Verify The UI of Select a Facility of Pickup Details")
    public void TC_CreateNewOrder_022_Verify_The_UI_of_Select_a_Facility_of_Pickup_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_023, Verify The Functionality of Select a Facility of Pickup Details")
    public void TC_CreateNewOrder_023_Verify_The_Functionality_of_Select_a_Facility_of_Pickup_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.set_PickUpFacility_TextBox();
        softAssert.assertTrue(!createNewOrderPage.getValue_PickupDetailsSelectAFacility_Dropdown().equals(""), "Validate some value is selected in Select A Facility dropdown");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_024, Verify The UI Of Custom Address For Pickup Details")
    public void TC_CreateNewOrder_024_Verify_The_UI_Of_Custom_Address_For_Pickup_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsHeader_Lbl(), "Check Visibility of Pickup Details header");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPostalCode_Txt(), "Check Visibility of Postal Code text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCountry_Select(), "Check Visibility of Country dropdown");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine1_Txt(), "Check Visibility of Address Line 1 text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine2_Txt(), "Check Visibility of Address Line 2 text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsState_Txt(), "Check Visibility of State text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCity_Txt(), "Check Visibility of City text box");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_025, Verify The Validation Functionality of Custom Address of Pickup Details For Empty Field")
    public void TC_CreateNewOrder_025_Verify_The_Validation_Functionality_of_Custom_Address_of_Pickup_Details_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_PickupDetailsCustomAddress_Radio();
        createNewOrderPage.click_Create_Btn();

        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine1ValidationError_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPickupDateValidationError_Lbl(), "Validate presence of validation error message for pickup date field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_026, Verify The Validation Functionality of Address Line 1 of Pickup Details for Maximum Character")
    public void TC_CreateNewOrder_026_Verify_The_Validation_Functionality_of_Address_Line_1_of_Pickup_Details_for_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.click_PickupDetailsCustomAddress_Radio();
        createNewOrderPage.fillWithClear_PickupDetailsAddressLine1_Txt("Max length" + Utility.generateRandomString(512));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine1ValidationError_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsAddressLine1ValidationError_Lbl(), "Length must be smaller than 512", "Validate text of validation error message for Address Line 1 field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_027, Verify The Validation Functionality of Address Line 2 of Pickup Details for Maximum Character")
    public void TC_CreateNewOrder_027_Verify_The_Validation_Functionality_of_Address_Line_2_of_Pickup_Details_for_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_PickupDetailsCustomAddress_Radio();
        createNewOrderPage.fillWithClear_PickupDetailsAddressLine2_Txt("Max length" + Utility.generateRandomString(128));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine2ValidationError_Lbl(), "Validate presence of validation error message for Address Line 2 field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsAddressLine2ValidationError_Lbl(), "Can be at max 128", "Validate text of validation error message for Address Line 2 field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_028, Verify The Validation Functionality of City of Pickup Details For Special And Numeric Character ")
    public void TC_CreateNewOrder_028_Verify_The_Validation_Functionality_of_City_of_Pickup_Details_For_Special_And_Numeric_Character() {
        List<String> inputs = List.of("@@@@@", "aa!@$", "aa112", "aa1@1$", "11223");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_PickupDetailsCustomAddress_Radio();

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsCity_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsCityValidationError_Lbl(), "Only letter ( A-Z, a-z )", "Validate validation error message for City field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_029, Verify The Validation Functionality of City of Pickup Details For Minimum Character")
    public void TC_CreateNewOrder_029_Verify_The_Validation_Functionality_of_City_of_Pickup_Details_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_PickupDetailsCustomAddress_Radio();

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsCity_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsCityValidationError_Lbl(), "Should be minimum 2", "Validate validation error message for City field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_030, Verify The Validation Functionality of City of Pickup Details For Maximum Character")
    public void TC_CreateNewOrder_030_Verify_The_Validation_Functionality_of_City_of_Pickup_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.click_PickupDetailsFacilityStore_Radio();
        createNewOrderPage.fillWithClear_PickupDetailsCity_Txt("Max length" + Utility.generateRandomString(65));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsCityValidationError_Lbl(), "Can be at max 64", "Validate validation error message for City field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_031, Verify The Validation Functionality of State of Pickup Details For Special And Numeric Character ")
    public void TC_CreateNewOrder_031_Verify_The_Validation_Functionality_of_State_of_Pickup_Details_For_Special_And_Numeric_Character() {
        List<String> inputs = List.of("@@@@@", "aa!@$", "aa112", "aa1@1$", "11223");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_PickupDetailsCustomAddress_Radio();

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsState_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCityValidationError_Lbl(), "Validate presence of validation error message for State field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsCityValidationError_Lbl(), "Only letter ( A-Z, a-z )", "Validate validation error message for State field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_032, Verify The Validation Functionality of State of Pickup Details For Minimum Character")
    public void TC_CreateNewOrder_032_Verify_The_Validation_Functionality_of_State_of_Pickup_Details_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_PickupDetailsCustomAddress_Radio();

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsState_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsStateValidationError_Lbl(), "Should be minimum 2", "Validate validation error message for State field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_033, Verify The Validation Functionality of State of Pickup Details For Maximum Character")
    public void TC_CreateNewOrder_033_Verify_The_Validation_Functionality_of_State_of_Pickup_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_PickupDetailsCustomAddress_Radio();
        createNewOrderPage.fillWithClear_PickupDetailsState_Txt("Max length" + Utility.generateRandomString(65));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsStateValidationError_Lbl(), "Can be at max 64", "Validate validation error message for State field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_034, Verify The Validation Functionality of Postal Code of Pickup Details For Special And Numeric Character ")
    public void TC_CreateNewOrder_034_Verify_The_Validation_Functionality_of_Postal_Code_of_Pickup_Details_For_Special_And_Numeric_Character() {
        List<String> inputs = List.of("@@@@@!", "aa!@$!", "aa1123", "aa1@1$");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_PickupDetailsCustomAddress_Radio();

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsPostalCode_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsPostalCodeValidationError_Lbl(), "Not correct format", "Validate validation error message for Postal Code field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_035, Verify The Validation Functionality of Postal Code of Pickup Details For Minimum Character")
    public void TC_CreateNewOrder_035_Verify_The_Validation_Functionality_of_Postal_Code_of_Pickup_Details_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_PickupDetailsCustomAddress_Radio();

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsPostalCode_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsPostalCodeValidationError_Lbl(), "Should be minimum 2", "Validate validation error message for Postal Code field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_036, Verify The Validation Functionality of Postal code of Pickup Details For Maximum Character")
    public void TC_CreateNewOrder_036_Verify_The_Validation_Functionality_of_Postal_code_of_Pickup_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_PickupDetailsCustomAddress_Radio();
        createNewOrderPage.fillWithClear_PickupDetailsPostalCode_Txt("Max length.");
        createNewOrderPage.click_Create_Btn();

        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsPostalCodeValidationError_Lbl(), "Length must be smaller than 6", "Validate validation error message for Postal Code field");
        softAssert.assertAll();
    }

    @Test(enabled = false, groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_038, Verify The Functionality of Clear Selection button in Pickup Details")
    public void TC_CreateNewOrder_038_Verify_The_Functionality_of_Clear_Selection_button_in_Pickup_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillPickupDetailsWithCustomData();
        createNewOrderPage.click_PickupDetailsClearAll_Btn();

        softAssert.assertEquals(createNewOrderPage.getValue_PickupDetailsPostalCode_Txt(), "", "Validate value of Postal Code field");
        softAssert.assertEquals(createNewOrderPage.getValue_PickupDetailsAddressLine1_Txt(), "", "Validate value of Address Line 1 field");
        softAssert.assertEquals(createNewOrderPage.getValue_PickupDetailsAddressLine2_Txt(), "", "Validate value of Address Line 2 field");
        softAssert.assertEquals(createNewOrderPage.getValue_PickupDetailsState_Txt(), "", "Validate value of State field");
        softAssert.assertEquals(createNewOrderPage.getValue_PickupDetailsCity_Txt(), "", "Validate value of City field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_039, Verify The UI of Drop Details of Create New Order")
    public void TC_CreateNewOrder_039_Verify_The_UI_of_Drop_Details_of_Create_New_Order() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsHeader_Lbl(), "Check Visibility of Drop Details header");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsFacilityStore_Radio(), "Check Visibility of Facility Store radio");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCustomAddress_Radio(), "Check Visibility of Custom Address radio");
        softAssert.assertTrue(createNewOrderPage.isRadioSelected_DropDetailsCustomAddress_Radio(), "Validate Custom Store radio is already selected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_040, Verify The Validation Functionality For Contact Name of Drop Details For Empty Field")
    public void TC_CreateNewOrder_040_Verify_The_Validation_Functionality_For_Contact_Name_of_Drop_Details_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNameValidationError_Lbl(), "Required", "Validate text of validation error message for Contact Name field");
        softAssert.assertAll();
    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_041, Verify The Validation Functionality For Contact Name of Drop Details For Minimum Character")
    public void TC_CreateNewOrder_041_Verify_The_Validation_Functionality_For_Contact_Name_of_Drop_Details_For_Minimum_Character() {
        List<String> inputs = List.of("a", "1", "#");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_DropDetailsContactName_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNameValidationError_Lbl(), "Length must be greater than 3", "Validate validation error message for Contact Name field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_042, Verify The Validation Functionality For Contact Name of Drop Details For Maximum Character")
    public void TC_CreateNewOrder_042_Verify_The_Validation_Functionality_For_Contact_Name_of_Drop_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillWithClear_DropDetailsContactName_Txt("Max length" + Utility.generateRandomString(37));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNameValidationError_Lbl(), "Length must be smaller than 36", "Validate validation error message for Contact Name field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_043, Verify The Validation Functionality For Contact Name of Drop Details For other than Alphabet")
    public void TC_CreateNewOrder_043_Verify_The_Validation_Functionality_For_Contact_Name_of_Drop_Details_For_other_than_Alphabet() {
        List<String> inputs = List.of("@@@@@", "aa!@$", "aa112", "aa1@1$", "11223");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_DropDetailsContactName_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNameValidationError_Lbl(), "Not correct format", "Validate validation error message for Contact Name field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_044, Verify The Validation Functionality for Phone number of DropDetails for empty field")
    public void TC_CreateNewOrder_044_Verify_The_Validation_Functionality_for_Phone_number_of_DropDetails_for_empty_field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.clear_DropDetailsContactNumber_Txt();
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNumberValidationError_Lbl(), "Required", "Validate text of validation error message for Contact Number field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_045, Verify The Validation Functionality for Phone number of Drop Details for Minimum Character")
    public void TC_CreateNewOrder_045_Verify_The_Validation_Functionality_for_Phone_number_of_Drop_Details_for_Minimum_Character() {
        List<String> inputs = List.of("111", "1", "999999999", "22");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_DropDetailsContactNumber_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNumberValidationError_Lbl(), "Length must be greater than 10", "Validate text of validation error message for Contact Number field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_046, Verify The Validation Functionality for Phone number of Drop Details for Maximum Character")
    public void TC_CreateNewOrder_046_Verify_The_Validation_Functionality_for_Phone_number_of_Drop_Details_for_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_DropDetailsCustomAddress_Radio();
        createNewOrderPage.fillWithClear_DropDetailsContactNumber_Txt(ActionHelper.getRandomNumberString(11));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNumberValidationError_Lbl(), "Length must be smaller than 10", "Validate text of validation error message for Contact Number field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_047, Verify The Validation For Phone Number of Drop Details For  Special character and alphabets")
    public void TC_CreateNewOrder_047_Verify_The_Validation_For_Phone_Number_of_Drop_Details_For_Special_character_and_alphabets() {
        List<String> inputs = List.of("@@@@@", "aa!@$", "aa", "aa@$", "aaaaaa");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_DropDetailsContactNumber_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNumberValidationError_Lbl(), "Required", "Validate text of validation error message for Contact Number field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_048, Verify The UI of Select a Facility of Drop Details")
    public void TC_CreateNewOrder_048_Verify_The_UI_of_Select_a_Facility_of_Drop_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.click_AddFacilityBtn_DropDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_049, Verify The Functionality of Select a Facility of Drop Details")
    public void TC_CreateNewOrder_049_Verify_The_Functionality_of_Select_a_Facility_of_Drop_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.set_DropFacility_TextBox();
        softAssert.assertTrue(createNewOrderPage.getValue_DropDetailsSelectAFacility_Dropdown() != "", "Validate some value is selected in Select A Facility dropdown");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_050, Verify The UI Of Custom Address For Drop Details")
    public void TC_CreateNewOrder_050_Verify_The_UI_Of_Custom_Address_For_Drop_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsHeader_Lbl(), "Check Visibility of Drop Details header");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsPostalCode_Txt(), "Check Visibility of Postal Code text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCountry_Select(), "Check Visibility of Country dropdown");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine1_Txt(), "Check Visibility of Address Line 1 text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine2_Txt(), "Check Visibility of Address Line 2 text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsState_Txt(), "Check Visibility of State text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCity_Txt(), "Check Visibility of City text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsClearAll_Btn(), "Check Visibility of Clear All button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_051, Verify The Validation Functionality of Custom Address of Drop Details For Empty Field")
    public void TC_CreateNewOrder_051_Verify_The_Validation_Functionality_of_Custom_Address_of_Drop_Details_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_DropDetailsCustomAddress_Radio();
        createNewOrderPage.click_Create_Btn();

        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine1ValidationError_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsDropDateValidationError_Lbl(), "Validate presence of validation of drop date error message");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_052, Verify The Validation Functionality of Address Line 1 of Drop Details for Maximum Character")
    public void TC_CreateNewOrder_052_Verify_The_Validation_Functionality_of_Address_Line_1_of_Drop_Details_for_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_DropDetailsAddressLine1_Txt("Max length" + Utility.generateRandomString(129));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine1ValidationError_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsAddressLine1ValidationError_Lbl(), "Can be at max 128", "Validate text of validation error message for Address Line 1 field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_053, Verify The Validation Functionality of Address Line 2 of Drop Details for Maximum Character")
    public void TC_CreateNewOrder_053_Verify_The_Validation_Functionality_of_Address_Line_2_of_Drop_Details_for_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_DropDetailsAddressLine2_Txt("Max length" + Utility.generateRandomString(129));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine2ValidationError_Lbl(), "Validate presence of validation error message for Address Line 2 field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsAddressLine2ValidationError_Lbl(), "Can be at max 128", "Validate text of validation error message for Address Line 2 field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_054, Verify The Validation Functionality of City of Drop Details For Special And Numeric Character")
    public void TC_CreateNewOrder_054_Verify_The_Validation_Functionality_of_City_of_Drop_Details_For_Special_And_Numeric_Character() {
        List<String> inputs = List.of("@@@@@", "aa!@$", "aa112", "aa1@1$", "11223");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_DropDetailsCity_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsCityValidationError_Lbl(), "Only letter ( A-Z, a-z )", "Validate validation error message for City field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_055, Verify The Validation Functionality of City of Drop Details For Minimum Character")
    public void TC_CreateNewOrder_055_Verify_The_Validation_Functionality_of_City_of_Drop_Details_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_DropDetailsCity_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsCityValidationError_Lbl(), "Should be minimum 2", "Validate validation error message for City field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_056, Verify The Validation Functionality of City of Drop Details For Maximum Character")
    public void TC_CreateNewOrder_056_Verify_The_Validation_Functionality_of_City_of_Drop_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_DropDetailsCustomAddress_Radio();
        createNewOrderPage.fillWithClear_DropDetailsCity_Txt("Max length" + Utility.generateRandomString(65));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsCityValidationError_Lbl(), "Can be at max 64", "Validate validation error message for City field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_057, Verify The Validation Functionality of State of Drop Details For Special And Numeric Character")
    public void TC_CreateNewOrder_057_Verify_The_Validation_Functionality_of_State_of_Drop_Details_For_Special_And_Numeric_Character() {
        List<String> inputs = List.of("@@@@@", "aa!@$", "aa112", "aa1@1$", "11223");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_DropDetailsState_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCityValidationError_Lbl(), "Validate presence of validation error message for State field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsCityValidationError_Lbl(), "Only letter ( A-Z, a-z )", "Validate validation error message for State field");
        }
        softAssert.assertAll();

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_058, Verify The Validation Functionality of State of Drop Details For Minimum Character")
    public void TC_CreateNewOrder_058_Verify_The_Validation_Functionality_of_State_of_Drop_Details_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_DropDetailsCustomAddress_Radio();

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_DropDetailsState_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsStateValidationError_Lbl(), "Should be minimum 2", "Validate validation error message for State field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_059, Verify The Validation Functionality of State of Drop Details For Maximum Character")
    public void TC_CreateNewOrder_059_Verify_The_Validation_Functionality_of_State_of_Drop_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_DropDetailsCustomAddress_Radio();
        createNewOrderPage.fillWithClear_DropDetailsState_Txt("Max length" + Utility.generateRandomString(65));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsStateValidationError_Lbl(), "Can be at max 64", "Validate validation error message for State field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_060, Verify The Validation Functionality of Postal Code of Drop Details For Special And Numeric Character")
    public void TC_CreateNewOrder_060_Verify_The_Validation_Functionality_of_Postal_Code_of_Drop_Details_For_Special_And_Numeric_Character() {
        List<String> inputSetOne = List.of("@@@@@", "aa!@$", "aa112");
        List<String> inputSetTwo = List.of("aa1@1$", "aaaaaa");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputSetOne) {
            createNewOrderPage.fillWithClear_DropDetailsPostalCode_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsPostalCodeValidationError_Lbl(), "Should be minimum 6", "Validate validation error message for Postal Code field");
        }

        for (String input : inputSetTwo) {
            createNewOrderPage.fillWithClear_DropDetailsPostalCode_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsPostalCodeValidationError_Lbl(), "Not correct format", "Validate validation error message for Postal Code field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_061, Verify The Validation Functionality of Postal Code of Drop Details For Minimum Character")
    public void TC_CreateNewOrder_061_Verify_The_Validation_Functionality_of_Postal_Code_of_Drop_Details_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_DropDetailsCustomAddress_Radio();

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_DropDetailsPostalCode_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsPostalCodeValidationError_Lbl(), "Length must be greater than 6", "Validate validation error message for Postal Code field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_062, Verify The Validation Functionality of Postal code of Drop Details For Maximum Character")
    public void TC_CreateNewOrder_062_Verify_The_Validation_Functionality_of_Postal_code_of_Drop_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_DropDetailsCustomAddress_Radio();
        createNewOrderPage.fillWithClear_DropDetailsPostalCode_Txt("Max length.");
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsPostalCodeValidationError_Lbl(), "Length must be smaller than 6", "Validate validation error message for Postal Code field");
        softAssert.assertAll();
    }

    @Test(enabled = false, groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_064, Verify The Functionality of Clear Selection button in Drop Details")
    public void TC_CreateNewOrder_064_Verify_The_Functionality_of_Clear_Selection_button_in_Drop_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillDropDetailsWithCustomData();
        createNewOrderPage.click_DropDetailsClearAll_Btn();

        softAssert.assertEquals(createNewOrderPage.getValue_DropDetailsPostalCode_Txt(), "", "Validate value of Postal Code field");
        softAssert.assertEquals(createNewOrderPage.getValue_DropDetailsAddressLine1_Txt(), "", "Validate value of Address Line 1 field");
        softAssert.assertEquals(createNewOrderPage.getValue_DropDetailsAddressLine2_Txt(), "", "Validate value of Address Line 2 field");
        softAssert.assertEquals(createNewOrderPage.getValue_DropDetailsState_Txt(), "", "Validate value of State field");
        softAssert.assertEquals(createNewOrderPage.getValue_DropDetailsCity_Txt(), "", "Validate value of City field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_065, To verify payment type dropdown")
    public void TC_CreateNewOrder_065_To_verify_payment_type_dropdown() {
        List<String> expectedValues = new ArrayList<>(List.of("Collect At Pickup", "Collect At Delivery", "Prepaid"));
        Collections.sort(expectedValues);
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        List<String> actualValues = createNewOrderPage.getAvailableValues_PaymentDetailsPaymentType_Select();
        Collections.sort(actualValues);
        for (int i = 0; i < expectedValues.size(); i++)
            softAssert.assertEquals(actualValues.get(i), expectedValues.get(i), "Validate options present for Payment Type dropdown");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_066, Verify The Validation Functionality For Payment Type In Create New Order Page For Empty Field")
    public void TC_CreateNewOrder_066_Verify_The_Validation_Functionality_For_Payment_Type_In_Create_New_Order_Page_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PaymentDetailsPaymentTypeValidationError_Lbl(), "Validate presence of validation error message for Payment Type field");
        softAssert.assertEquals(createNewOrderPage.getText_PaymentDetailsPaymentTypeValidationError_Lbl(), "Required", "Validate text of validation error message for Payment Type field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_067, Verify The Functionality of Collect at Pickup in Payment Type without order Amount")
    public void TC_CreateNewOrder_067_Verify_The_Functionality_of_Collect_at_Pickup_in_Payment_Type_without_order_Amount() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        String orderId = faker.idNumber().valid().replace("-", "");
        createNewOrderPage.fillWithClear_OrderDetailsOrderId_Txt(orderId);
        createNewOrderPage.fillShipmentDetails();
        createNewOrderPage.fillPickupDetailsWithCustomData();
        createNewOrderPage.fillDropDetailsWithCustomData();
        createNewOrderPage.selectByVisibleText_PaymentDetailsPaymentType_Select("Collect At Pickup");
        createNewOrderPage.click_CreateBtn_WithWait();

        viewOrderPage.fillWithClear_SearchBar_Txt(orderId);
        softAssert.assertEquals(viewOrderPage.get_FirstElementOrderId_Txt(), orderId, "Order id is matched as expected");
        softAssert.assertEquals(viewOrderPage.get_FirstElementStatus_Lbl(), "Created", "Status is matched as expected");
        softAssert.assertAll();
    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_068, Verify The Functionality of Collect at Deliver in Payment Type without order Amount")
    public void TC_CreateNewOrder_068_Verify_The_Functionality_of_Collect_at_Deliver_in_Payment_Type_without_order_Amount() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        String orderId = faker.number().digits(10);
        createNewOrderPage.fillWithClear_OrderDetailsOrderId_Txt(orderId);
        createNewOrderPage.fillWithClear_OrderDetailsOrderDescription_Txt(faker.backToTheFuture().quote());

        createNewOrderPage.fillPickupDetailsWithCustomData();
        createNewOrderPage.fillDropDetailsWithCustomData();
        createNewOrderPage.selectByVisibleText_PaymentDetailsPaymentType_Select("Collect At Delivery");
        createNewOrderPage.fillWithClear_PaymentDetailsOrderAmount_Txt("20");
        createNewOrderPage.click_CreateBtn_WithWait();

        viewOrderPage.fillWithClear_SearchBar_Txt(orderId);
        softAssert.assertEquals(viewOrderPage.get_FirstElementOrderId_Txt(), orderId, "Order id is matched as expected");
        softAssert.assertEquals(viewOrderPage.get_FirstElementStatus_Lbl(), "Created", "Status is matched as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_069, Verify The Functionality of Prepaid in Payment Type without order Amount")
    public void TC_CreateNewOrder_069_Verify_The_Functionality_of_Prepaid_in_Payment_Type_without_order_Amount() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        String orderId = faker.number().digits(10);
        createNewOrderPage.fillWithClear_OrderDetailsOrderId_Txt(orderId);
        createNewOrderPage.fillWithClear_OrderDetailsOrderDescription_Txt(faker.backToTheFuture().quote());

        createNewOrderPage.fillPickupDetailsWithCustomData();
        createNewOrderPage.fillDropDetailsWithCustomData();
        createNewOrderPage.selectByVisibleText_PaymentDetailsPaymentType_Select("Prepaid");
        createNewOrderPage.click_CreateBtn_WithWait();

        viewOrderPage.fillWithClear_SearchBar_Txt(orderId);
        softAssert.assertEquals(viewOrderPage.get_FirstElementOrderId_Txt(), orderId, "Order id is matched as expected");
        softAssert.assertEquals(viewOrderPage.get_FirstElementStatus_Lbl(), "Created", "Status is matched as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_070, Verify The Functionality of Collect at Pickup in Payment Type with order Amount")
    public void TC_CreateNewOrder_070_Verify_The_Functionality_of_Collect_at_Pickup_in_Payment_Type_with_order_Amount() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        String orderId = faker.number().digits(10);
        createNewOrderPage.fillWithClear_OrderDetailsOrderId_Txt(orderId);
        createNewOrderPage.fillWithClear_OrderDetailsOrderDescription_Txt(faker.backToTheFuture().quote());

        createNewOrderPage.fillPickupDetailsWithCustomData();
        createNewOrderPage.fillDropDetailsWithCustomData();
        createNewOrderPage.selectByVisibleText_PaymentDetailsPaymentType_Select("Collect At Pickup");
        createNewOrderPage.fillWithClear_PaymentDetailsOrderAmount_Txt(String.valueOf(faker.random().nextInt(100, 1000)));
        createNewOrderPage.click_CreateBtn_WithWait();

        viewOrderPage.fillWithClear_SearchBar_Txt(orderId);
        softAssert.assertEquals(viewOrderPage.get_FirstElementOrderId_Txt(), orderId, "Order id is matched as expected");
        softAssert.assertEquals(viewOrderPage.get_FirstElementStatus_Lbl(), "Created", "Status is matched as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_071, Verify The Functionality of Collect at Deliver in Payment Type with order Amount")
    public void TC_CreateNewOrder_071_Verify_The_Functionality_of_Collect_at_Deliver_in_Payment_Type_with_order_Amount() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        String orderId = faker.number().digits(10);
        createNewOrderPage.fillWithClear_OrderDetailsOrderId_Txt(orderId);
        createNewOrderPage.fillWithClear_OrderDetailsOrderDescription_Txt(faker.backToTheFuture().quote());

        createNewOrderPage.fillPickupDetailsWithCustomData();
        createNewOrderPage.fillDropDetailsWithCustomData();
        createNewOrderPage.selectByVisibleText_PaymentDetailsPaymentType_Select("Collect At Delivery");
        createNewOrderPage.fillWithClear_PaymentDetailsOrderAmount_Txt(String.valueOf(faker.random().nextInt(100, 1000)));
        createNewOrderPage.click_CreateBtn_WithWait();

        viewOrderPage.fillWithClear_SearchBar_Txt(orderId);
        softAssert.assertEquals(viewOrderPage.get_FirstElementOrderId_Txt(), orderId, "Order id is matched as expected");
        softAssert.assertEquals(viewOrderPage.get_FirstElementStatus_Lbl(), "Created", "Status is matched as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_072, Verify The Functionality of Prepaid in Payment Type with order Amount")
    public void TC_CreateNewOrder_072_Verify_The_Functionality_of_Prepaid_in_Payment_Type_with_order_Amount() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        String orderId = faker.number().digits(10);
        createNewOrderPage.fillWithClear_OrderDetailsOrderId_Txt(orderId);
        createNewOrderPage.fillWithClear_OrderDetailsOrderDescription_Txt(faker.backToTheFuture().quote());

        createNewOrderPage.fillPickupDetailsWithCustomData();
        createNewOrderPage.fillDropDetailsWithCustomData();
        createNewOrderPage.selectByVisibleText_PaymentDetailsPaymentType_Select("Prepaid");
        createNewOrderPage.fillWithClear_PaymentDetailsOrderAmount_Txt(String.valueOf(faker.random().nextInt(100, 1000)));
        createNewOrderPage.click_CreateBtn_WithWait();

        viewOrderPage.fillWithClear_SearchBar_Txt(orderId);
        softAssert.assertEquals(viewOrderPage.get_FirstElementOrderId_Txt(), orderId, "Order id is matched as expected");
        softAssert.assertEquals(viewOrderPage.get_FirstElementStatus_Lbl(), "Created", "Status is matched as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_073, Verify The Validation Functionality For Duplicate Order ID In Create New Order Page ")
    public void TC_CreateNewOrder_073_Verify_The_Validation_Functionality_For_Duplicate_Order_ID_In_Create_New_Order_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        String orderId = faker.number().digits(10);
        createNewOrderPage.fillWithClear_OrderDetailsOrderId_Txt(orderId);
        createNewOrderPage.fillWithClear_OrderDetailsOrderDescription_Txt(faker.backToTheFuture().quote());

        createNewOrderPage.fillPickupDetailsWithCustomData();
        createNewOrderPage.fillDropDetailsWithCustomData();
        createNewOrderPage.selectByVisibleText_PaymentDetailsPaymentType_Select("Prepaid");
        createNewOrderPage.click_CreateBtn_WithWait();

        HomePage.getInstance().openCreateOrderPage();

        createNewOrderPage.fillWithClear_OrderDetailsOrderId_Txt(orderId);
        createNewOrderPage.fillWithClear_OrderDetailsOrderDescription_Txt(faker.backToTheFuture().quote());

        createNewOrderPage.fillPickupDetailsWithCustomData();
        createNewOrderPage.fillDropDetailsWithCustomData();
        createNewOrderPage.selectByVisibleText_PaymentDetailsPaymentType_Select("Prepaid");
        createNewOrderPage.click_CreateBtn_WithWait();
        softAssert.assertTrue(createNewOrderPage.isPresent_DuplicateOrderIdToastMsg_Lbl(), "Validate presence of Duplicate Order Id toast msg");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_074, Verify The UI of Add Facility in Select a Facility of Pickup Details")
    public void TC_CreateNewOrder_074_Verify_The_UI_of_Add_Facility_in_Select_a_Facility_of_Pickup_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityFacilityName_Txt(), "Validate presence of Facility Name field");
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityFacilityId_Txt(), "Validate presence of Facility ID field");

        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityPostalCode_Txt(), "Validate presence of Postal Code field");
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityCountry_Txt(), "Validate presence of Country field");
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityAddressLine1_Txt(), "Validate presence of Address Line 1 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityAddressLine2_Txt(), "Validate presence of Address Line 2 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityState_Txt(), "Validate presence of State field");
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityCity_Txt(), "Validate presence of City field");

        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityCreate_Btn(), "Validate presence of Create button");
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityCancel_Btn(), "Validate presence of Cancel button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_075, Verify The Validation Functionality For Name In Add New Facility Page For Empty Field")
    public void TC_CreateNewOrder_075_Verify_The_Validation_Functionality_For_Name_In_Add_New_Facility_Page_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        createNewOrderPage.clear_AddFacilityFacilityName_Txt();
        createNewOrderPage.click_AddFacilityCreate_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityFacilityNameValidationMsg_Lbl(), "Validate presence of validation error message for Facility Name field");
        softAssert.assertEquals(createNewOrderPage.getText_AddFacilityFacilityNameValidationMsg_Lbl(), "Required", "Validate text of validation error message for Facility Name field");
        softAssert.assertAll();
    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_076, Verify The Validation Functionality For Name In Add New Facility Page For Minimum Character")
    public void TC_CreateNewOrder_076_Verify_The_Validation_Functionality_For_Name_In_Add_New_Facility_Page_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_AddFacilityFacilityName_Txt(input);
            createNewOrderPage.click_AddFacilityCreate_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityFacilityNameValidationMsg_Lbl(), "Validate presence of validation error message for Facility Name field");
            softAssert.assertEquals(createNewOrderPage.getText_AddFacilityFacilityNameValidationMsg_Lbl(), "Length must be greater than 3", "Validate validation error message for Facility Name field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_077, Verify The Validation Functionality For Name In Add New Facility Page For Maximum Character")
    public void TC_CreateNewOrder_077_Verify_The_Validation_Functionality_For_Name_In_Add_New_Facility_Page_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        createNewOrderPage.fillWithClear_AddFacilityFacilityName_Txt("Max length" + ActionHelper.generateRandomName(32, 32));
        createNewOrderPage.click_AddFacilityCreate_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityFacilityNameValidationMsg_Lbl(), "Validate presence of validation error message for Facility Name field");
        softAssert.assertEquals(createNewOrderPage.getText_AddFacilityFacilityNameValidationMsg_Lbl(), "Length must be smaller than 32", "Validate validation error message for Facility Name field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_078, Verify The Validation Functionality For Facility ID In Add New Facility Page For Empty Field")
    public void TC_CreateNewOrder_078_Verify_The_Validation_Functionality_For_Facility_ID_In_Add_New_Facility_Page_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        createNewOrderPage.clear_AddFacilityFacilityId_Txt();
        createNewOrderPage.click_AddFacilityCreate_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityFacilityIdValidationMsg_Lbl(), "Validate presence of validation error message for Facility Id field");
        softAssert.assertEquals(createNewOrderPage.getText_AddFacilityFacilityIdValidationMsg_Lbl(), "Required", "Validate text of validation error message for Facility Id field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_079, Verify The Validation Functionality For Facility ID In Add New Facility Page For Minimum Character")
    public void TC_CreateNewOrder_079_Verify_The_Validation_Functionality_For_Facility_ID_In_Add_New_Facility_Page_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_AddFacilityFacilityId_Txt(input);
            createNewOrderPage.click_AddFacilityCreate_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityFacilityIdValidationMsg_Lbl(), "Validate presence of validation error message for Facility Id field");
            softAssert.assertEquals(createNewOrderPage.getText_AddFacilityFacilityIdValidationMsg_Lbl(), "Length must be greater than 3", "Validate validation error message for Facility Id field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_080, Verify The Validation Functionality For Facility ID In Add New Facility Page For Maximum Character")
    public void TC_CreateNewOrder_080_Verify_The_Validation_Functionality_For_Facility_ID_In_Add_New_Facility_Page_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        createNewOrderPage.fillWithClear_AddFacilityFacilityId_Txt(Utility.generateRandomString(33));
        createNewOrderPage.click_AddFacilityCreate_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityFacilityIdValidationMsg_Lbl(), "Validate presence of validation error message for Facility Id field");
        softAssert.assertEquals(createNewOrderPage.getText_AddFacilityFacilityIdValidationMsg_Lbl(), "Length must be smaller than 32", "Validate validation error message for Facility Id field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_081, Verify The Validation Functionality For PostalCode In Add New Facility Page For Empty Field")
    public void TC_CreateNewOrder_081_Verify_The_Validation_Functionality_For_PostalCode_In_Add_New_Facility_Page_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        createNewOrderPage.clear_AddFacilityPostalCode_Txt();
        createNewOrderPage.click_AddFacilityCreate_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityPostalCodeValidationMsg_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertEquals(createNewOrderPage.getText_AddFacilityPostalCodeValidationMsg_Lbl(), "Required", "Validate text of validation error message for Postal Code field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_082, Verify The Validation Functionality For PostalCode In Add New Facility Page For Minimum Character")
    public void TC_CreateNewOrder_082_Verify_The_Validation_Functionality_For_PostalCode_In_Add_New_Facility_Page_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_AddFacilityPostalCode_Txt(input);
            createNewOrderPage.click_AddFacilityCreate_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityPinCodeDataNotFoundToastMsg_Lbl(), "Validate presence of validation toast message for Postal Code field");
            softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityPostalCodeValidationMsg_Lbl(), "Validate presence of validation error message for Postal Code field");
            softAssert.assertEquals(createNewOrderPage.getText_AddFacilityPostalCodeValidationMsg_Lbl(), "Not correct format", "Validate validation error message for Postal Code field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_083, Verify The Validation Functionality For PostalCode In Add New Facility Page For Maximum Character")
    public void TC_CreateNewOrder_083_Verify_The_Validation_Functionality_For_PostalCode_In_Add_New_Facility_Page_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        createNewOrderPage.fillWithClear_AddFacilityPostalCode_Txt(ActionHelper.getRandomNumberString(11));
        createNewOrderPage.click_AddFacilityCreate_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityPinCodeDataNotFoundToastMsg_Lbl(), "Validate presence of validation toast message for Postal Code field");
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityPostalCodeValidationMsg_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertEquals(createNewOrderPage.getText_AddFacilityPostalCodeValidationMsg_Lbl(), "Not correct format", "Validate validation error message for Postal Code field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_084, Verify The Validation Functionality For PostalCode In Add New Facility Page For Other Than Numeric Value")
    public void TC_CreateNewOrder_084_Verify_The_Validation_Functionality_For_PostalCode_In_Add_New_Facility_Page_For_Other_Than_Numeric_Value() {
        List<String> inputs = List.of("abcd", "q@ #aaa", "12rW@e$d", "@!#$%");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_AddFacilityPostalCode_Txt(input);
            createNewOrderPage.click_AddFacilityCreate_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityPinCodeDataNotFoundToastMsg_Lbl(), "Validate presence of validation toast message for Postal Code field");
            softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityPostalCodeValidationMsg_Lbl(), "Validate presence of validation error message for Postal Code field");
            softAssert.assertEquals(createNewOrderPage.getText_AddFacilityPostalCodeValidationMsg_Lbl(), "Not correct format", "Validate validation error message for Postal Code field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_085, Verify the Functionality of Postal Code With valid data")
    public void TC_CreateNewOrder_085_Verify_the_Functionality_of_Postal_Code_With_valid_data() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        String pinCode = Utility.get_PostalCode_Txt();
        createNewOrderPage.fillWithClear_AddFacilityPostalCode_Txt(pinCode);
        createNewOrderPage.click_AddFacilityCreate_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityPinCodeDataNotFoundToastMsg_Lbl() == false, "Validate absence of validation toast message for Postal Code field");
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityPostalCodeValidationMsg_Lbl() == false, "Validate absence of validation error message for Postal Code field");
        softAssert.assertEquals(createNewOrderPage.getValue_AddFacilityPostalCode_Txt(), pinCode, "Validate value for Postal Code field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_086, Verify The Validation Functionality For Postal Code in Add New Facility page with invalid postal code")
    public void TC_CreateNewOrder_086_Verify_The_Validation_Functionality_For_Postal_Code_in_Add_New_Facility_page_with_invalid_postal_code() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        createNewOrderPage.fillWithClear_AddFacilityPostalCode_Txt("1234567");
        createNewOrderPage.click_AddFacilityCreate_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityPinCodeDataNotFoundToastMsg_Lbl(), "Validate presence of validation toast message for Postal Code field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_087, Verify Functionality For Country DropDown In Add New Facility Page")
    public void TC_CreateNewOrder_087_Verify_Functionality_For_Country_DropDown_In_Add_New_Facility_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        softAssert.assertTrue(createNewOrderPage.isClickable_AddFacilityCountry_Txt(), "Validate Country dropdown is disabled");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_088, Verify The Validation Functionality For Address Line 1 In Add New Facility Page For Empty Field")
    public void TC_CreateNewOrder_088_Verify_The_Validation_Functionality_For_Address_Line_1_In_Add_New_Facility_Page_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        createNewOrderPage.clear_AddFacilityAddressLine1_Txt();
        createNewOrderPage.click_AddFacilityCreate_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityAddressLine1ValidationMsg_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertEquals(createNewOrderPage.getText_AddFacilityAddressLine1ValidationMsg_Lbl(), "Required", "Validate text of validation error message for Address Line 1 field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_089, Verify The Validation Functionality For Address Line 1 In Add New Facility Page For Minimum Character")
    public void TC_CreateNewOrder_089_Verify_The_Validation_Functionality_For_Address_Line_1_In_Add_New_Facility_Page_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_AddFacilityAddressLine1_Txt(input);
            createNewOrderPage.click_AddFacilityCreate_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityAddressLine1ValidationMsg_Lbl(), "Validate presence of validation error message for Address Line 1 field");
            softAssert.assertEquals(createNewOrderPage.getText_AddFacilityAddressLine1ValidationMsg_Lbl(), "Not correct format", "Validate text of validation error message for Address Line 1 field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_090, Verify The Validation Functionality For Address Line 1 In Add New Facility Page For Maximum Character")
    public void TC_CreateNewOrder_090_Verify_The_Validation_Functionality_For_Address_Line_1_In_Add_New_Facility_Page_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        createNewOrderPage.fillWithClear_AddFacilityAddressLine1_Txt("Max Length:" + Utility.generateRandomString(121));
        createNewOrderPage.click_AddFacilityCreate_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityAddressLine1ValidationMsg_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertEquals(createNewOrderPage.getText_AddFacilityAddressLine1ValidationMsg_Lbl(), "Not correct format", "Validate text of validation error message for Address Line 1 field");
        softAssert.assertAll();
    }

    @Test(enabled = false, groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_091, Verify The Validation Functionality For Address Line 2 In Add New Facility Page For Empty Field")
    public void TC_CreateNewOrder_091_Verify_The_Validation_Functionality_For_Address_Line_2_In_Add_New_Facility_Page_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        createNewOrderPage.clear_AddFacilityAddressLine2_Txt();
        createNewOrderPage.click_AddFacilityCreate_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityAddressLine2ValidationMsg_Lbl(), "Validate presence of validation error message for Address Line 2 field");
        softAssert.assertEquals(createNewOrderPage.getText_AddFacilityAddressLine2ValidationMsg_Lbl(), "Required", "Validate text of validation error message for Address Line 2 field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_092, Verify The Validation Functionality For Address Line 2 In Add New Facility Page For Minimum Character")
    public void TC_CreateNewOrder_092_Verify_The_Validation_Functionality_For_Address_Line_2_In_Add_New_Facility_Page_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_AddFacilityAddressLine2_Txt(input);
            createNewOrderPage.click_AddFacilityCreate_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityAddressLine2ValidationMsg_Lbl(), "Validate presence of validation error message for Address Line 2 field");
            softAssert.assertEquals(createNewOrderPage.getText_AddFacilityAddressLine2ValidationMsg_Lbl(), "Not correct format", "Validate text of validation error message for Address Line 2 field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_093, Verify The Validation Functionality For Address Line 2 In Add New Facility Page For Maximum Character")
    public void TC_CreateNewOrder_093_Verify_The_Validation_Functionality_For_Address_Line_2_In_Add_New_Facility_Page_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_AddFacilityBtn_PickupDetailsSelectAFacility_Dropdown();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddNewFacilityHeader_Lbl(), "Validate presence of Create New Facility header");

        createNewOrderPage.fillWithClear_AddFacilityAddressLine2_Txt("Max Length:" + Utility.generateRandomString(121));
        createNewOrderPage.click_AddFacilityCreate_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddFacilityAddressLine2ValidationMsg_Lbl(), "Validate presence of validation error message for Address Line 2 field");
        softAssert.assertEquals(createNewOrderPage.getText_AddFacilityAddressLine2ValidationMsg_Lbl(), "Not correct format", "Validate text of validation error message for Address Line 2 field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_094, Verify The Functionality for selecting same facility for pickup and drop")
    public void TC_CreateNewOrder_094_Verify_The_Functionality_for_selecting_same_facility_for_pickup_and_drop() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillWithClear_OrderDetailsOrderId_Txt(faker.number().digits(10));
        createNewOrderPage.fillWithClear_OrderDetailsOrderDescription_Txt(faker.backToTheFuture().quote());
        createNewOrderPage.fill_PickupDetailsContactName_Txt(faker.name().fullName());
        createNewOrderPage.fill_PickupDetailsContactNumber_Txt(faker.phoneNumber().subscriberNumber(10));
        createNewOrderPage.fill_PickupDetailsPickupDate_Txt(ActionHelper.getCurrentDay() + "-" + ActionHelper.getCurrentMonth() + "-" + ActionHelper.getCurrentYear());
        createNewOrderPage.set_PickUpFacility_TextBox();
        createNewOrderPage.fill_DropDetailsContactName_Txt(faker.name().fullName());
        createNewOrderPage.fill_DropDetailsContactNumber_Txt(faker.phoneNumber().subscriberNumber(10));
        createNewOrderPage.click_DropDetailsFacilityStore_Radio();
        createNewOrderPage.set_DropFacility_TextBox();
        createNewOrderPage.fill_DropDetailsDropDate_Txt(ActionHelper.getCurrentDay() + "-" + ActionHelper.getCurrentMonth() + "-" + ActionHelper.getCurrentYear());
        createNewOrderPage.selectByVisibleText_PaymentDetailsPaymentType_Select("Collect At Delivery");
        createNewOrderPage.click_Create_Btn();

        softAssert.assertTrue(createNewOrderPage.isPresent_SamePickupAndDropFacilityToastMsg_Lbl(), "Validate presence of Drop facility needs to be different from Pickup facility toast msg");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_095, Verify The Functionality of Facility/Store radio button of Pickup Details")
    public void TC_CreateNewOrder_095_Verify_The_Functionality_of_FacilityStore_radio_button_of_Pickup_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsHeader_Lbl(), "Check Visibility of Pickup Details header");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsFacilityStore_Radio(), "Check Visibility of Facility Store radio");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCustomAddress_Radio(), "Check Visibility of Custom Address radio");
        softAssert.assertTrue(createNewOrderPage.isRadioSelected_PickupDetailsFacilityStore_Radio(), "Validate Facility Store radio is already selected");

        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsContactName_Txt(), "Check Contact Name should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsContactNumber_Txt(), "Check Contact Number should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsSelectAFacility_Dropdown(), "Check Select A Facility should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsPickupDate_Txt(), "Check Pickup Date should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsPickupSlotFrom_Txt(), "Check Pickup Slot From should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsPickupSlotTo_Txt(), "Check Pickup Slot To should be editable");

        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsPostalCode_Txt() == false, "Check Postal Code shouldn't be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsCountry_Select() == false, "Check Country shouldn't be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsAddressLine1_Txt() == false, "Check Address Line 1 shouldn't be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsAddressLine2_Txt() == false, "Check Address Line 2 shouldn't be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsState_Txt() == false, "Check State shouldn't be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsCity_Txt() == false, "Check City shouldn't be editable");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_096, Verify The Functionality of Custom Address radio button of Pickup Details")
    public void TC_CreateNewOrder_096_Verify_The_Functionality_of_Custom_Address_radio_button_of_Pickup_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsHeader_Lbl(), "Check Visibility of Pickup Details header");
        createNewOrderPage.click_PickupDetailsCustomAddress_Radio();
        softAssert.assertTrue(createNewOrderPage.isRadioSelected_PickupDetailsCustomAddress_Radio(), "Validate Custom Address radio is selected");

        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsContactName_Txt(), "Check Contact Name should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsContactNumber_Txt(), "Check Contact Number should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsPickupDate_Txt(), "Check Pickup Date should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsPickupSlotFrom_Txt(), "Check Pickup Slot From should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsPickupSlotTo_Txt(), "Check Pickup Slot To should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsPostalCode_Txt(), "Check Postal Code should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsCountry_Select(), "Check Country should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsAddressLine1_Txt(), "Check Address Line 1 should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsAddressLine2_Txt(), "Check Address Line 2 should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsState_Txt(), "Check State should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsCity_Txt(), "Check City should be editable");

        softAssert.assertTrue(createNewOrderPage.isEnabled_PickupDetailsSelectAFacility_Dropdown() == false, "Check Select A Facility shouldn't be editable");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_097, Verify The Functionality of Facility/Store radio button of Drop Details")
    public void TC_CreateNewOrder_097_Verify_The_Functionality_of_FacilityStore_radio_button_of_Drop_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsHeader_Lbl(), "Check Visibility of Drop Details header");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsFacilityStore_Radio(), "Check Visibility of Facility Store radio");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCustomAddress_Radio(), "Check Visibility of Custom Address radio");
        softAssert.assertTrue(createNewOrderPage.isRadioSelected_DropDetailsCustomAddress_Radio(), "Validate Custom Address radio is already selected");

        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsContactName_Txt(), "Check Contact Name should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsContactNumber_Txt(), "Check Contact Number should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsDropDate_Txt(), "Check Drop Date should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsDropSlotFrom_Txt(), "Check Drop Slot From should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsDropSlotTo_Txt(), "Check Drop Slot To should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsPostalCode_Txt(), "Check Postal Code should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsCountry_Select(), "Check Country should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsAddressLine1_Txt(), "Check Address Line 1 should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsAddressLine2_Txt(), "Check Address Line 2 should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsState_Txt(), "Check State should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsCity_Txt(), "Check City should be editable");

        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsSelectAFacility_Dropdown() == false, "Check Select A Facility shouldn't be editable");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_098, Verify The Functionality of Custom Address radio button of Drop Details")
    public void TC_CreateNewOrder_098_Verify_The_Functionality_of_Custom_Address_radio_button_of_Drop_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsHeader_Lbl(), "Check Visibility of Drop Details header");
        createNewOrderPage.click_DropDetailsFacilityStore_Radio();
        softAssert.assertTrue(createNewOrderPage.isRadioSelected_DropDetailsFacilityStore_Radio(), "Validate Facility Store radio is selected");

        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsContactName_Txt(), "Check Contact Name should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsContactNumber_Txt(), "Check Contact Number should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsSelectAFacility_Dropdown(), "Check Select A Facility should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsDropDate_Txt(), "Check Drop Date should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsDropSlotFrom_Txt(), "Check Drop Slot From should be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsDropSlotTo_Txt(), "Check Drop Slot To should be editable");

        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsPostalCode_Txt() == false, "Check Postal Code shouldn't be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsCountry_Select() == false, "Check Country shouldn't be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsAddressLine1_Txt() == false, "Check Address Line 1 shouldn't be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsAddressLine2_Txt() == false, "Check Address Line 2 shouldn't be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsState_Txt() == false, "Check State shouldn't be editable");
        softAssert.assertTrue(createNewOrderPage.isEnabled_DropDetailsCity_Txt() == false, "Check City shouldn't be editable");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_099, Verify The UI of Shipment Details of Create New Order Page")
    public void TC_CreateNewOrder_099_Verify_The_UI_of_Shipment_Details_of_Create_New_Order_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsHeader_Lbl(), "Check Visibility of Shipment Details header");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsShipmentID_Txt(), "Check Visibility of Shipment ID field");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsDescription_Txt(), "Check Visibility of Description field");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsWeight_Txt(), "Check Visibility of Weight field");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsVolume_Txt(), "Check Visibility of Volume field");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsDimensionsLength_Txt(), "Check Visibility of Length field");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsDimensionsBreadth_Txt(), "Check Visibility of Breadth field");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsDimensionsHeight_Txt(), "Check Visibility of Height field");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsDelete_Btn(), "Check Visibility of Delete btn");
        softAssert.assertTrue(createNewOrderPage.isPresent_ShipmentDetailsAddShipment_Btn(), "Check Visibility of Add Shipment btn");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_100, Verify The Validation Functionality of Shipment Details for without entering mandatory fields ")
    public void TC_CreateNewOrder_100_Verify_The_Validation_Functionality_of_Shipment_Details_for_without_entering_mandatory_fields() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_Create_Btn();

        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderIdValidationError_Lbl(), "Validate presence of validation error message for Order Id field");
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderDescriptionValidationError_Lbl(), "Validate presence of validation error message for Order Description field");

        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsSelectAFacilityValidationError_Lbl(), "Validate presence of validation error message for Select A Facility field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPostalCodeValidationError_Lbl() == false, "Validate absence of validation error message for Postal Code field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCountryValidationError_Lbl() == false, "Validate absence of validation error message for Country field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine1ValidationError_Lbl() == false, "Validate absence of validation error message for Address Line 1 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsStateValidationError_Lbl() == false, "Validate absence of validation error message for State field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCityValidationError_Lbl() == false, "Validate absence of validation error message for City field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPickupDateValidationError_Lbl(), "Validate presence of validation error message for Pickup Date field");

        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsSelectAFacilityValidationError_Lbl() == false, "Validate absence of validation error message for Select A Facility field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCountryValidationError_Lbl() == false, "Validate absence of validation error message for Country field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine1ValidationError_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsDropDateValidationError_Lbl(), "Validate presence of validation error message for Drop Date field");

        softAssert.assertTrue(createNewOrderPage.isPresent_PaymentDetailsPaymentTypeValidationError_Lbl(), "Validate presence of validation error message for Payment Type field");
        softAssert.assertAll();
    }

    @Test(enabled = false, groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_101, Verify The Functionality of Add Shipment button without entering Shipment Details ")
    public void TC_CreateNewOrder_101_Verify_The_Functionality_of_Add_Shipment_button_without_entering_Shipment_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_ShipmentDetailsAddShipment_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddShipmentRequiredParamShipmentIdToastMsg_Lbl(), "Validate presence of toast error message for Shipment Id field");
        createNewOrderPage.fillWithClear_ShipmentDetailsShipmentID_Txt(ActionHelper.getRandomNumberString(5));
        createNewOrderPage.click_ShipmentDetailsAddShipment_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_AddShipmentRequiredParamDescriptionToastMsg_Lbl(), "Validate presence of toast error message for Description field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_102, Verify The Functionality of Enter Shipment Id TextBox of Shipment Details ")
    public void TC_CreateNewOrder_102_Verify_The_Functionality_of_Enter_Shipment_Id_TextBox_of_Shipment_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        String input = ActionHelper.getRandomNumberString(5);
        createNewOrderPage.fillWithClear_OrderDetailsOrderId_Txt(input);
        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsShipmentID_Txt(), input, "Validate text present in Shipment ID field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_103, Verify The Functionality of Enter Description TextBox of Shipment Details ")
    public void TC_CreateNewOrder_103_Verify_The_Functionality_of_Enter_Description_TextBox_of_Shipment_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        String input = faker.artist().name();
        createNewOrderPage.fillWithClear_OrderDetailsOrderDescription_Txt(input);
        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsDescription_Txt(), input, "Validate text present in Description field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_104, Verify The Functionality of Weight TextBox of Shipment Details ")
    public void TC_CreateNewOrder_104_Verify_The_Functionality_of_Weight_TextBox_of_Shipment_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsWeight_Txt(), "0", "Validate text present in Weight field");
        createNewOrderPage.fillWithClear_ShipmentDetailsWeight_Txt("abcd");
        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsWeight_Txt(), "", "Validate text present in Weight field");
        String input = String.valueOf(ActionHelper.generateRandomIntBetweenRange(1, 50));
        createNewOrderPage.fillWithClear_ShipmentDetailsWeight_Txt(input);
        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsWeight_Txt(), input, "Validate text present in Weight field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_105, Verify The Functionality of Volume TextBox of Shipment Details ")
    public void TC_CreateNewOrder_105_Verify_The_Functionality_of_Volume_TextBox_of_Shipment_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsVolume_Txt(), "0", "Validate text present in Volume field");
        createNewOrderPage.fillWithClear_ShipmentDetailsVolume_Txt("abcd");
        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsVolume_Txt(), "", "Validate text present in Volume field");
        String input = String.valueOf(ActionHelper.generateRandomIntBetweenRange(1, 50));
        createNewOrderPage.fillWithClear_ShipmentDetailsVolume_Txt(input);
        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsVolume_Txt(), input, "Validate text present in Volume field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_106, Verify The Functionality of Dimensions TextBox of Shipment Details ")
    public void TC_CreateNewOrder_106_Verify_The_Functionality_of_Dimensions_TextBox_of_Shipment_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsDimensionsLength_Txt(), "0", "Validate text present in Length field");
        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsDimensionsBreadth_Txt(), "0", "Validate text present in Breadth field");
        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsDimensionsHeight_Txt(), "0", "Validate text present in Height field");

        createNewOrderPage.fillWithClear_ShipmentDetailsDimensionsLength_Txt("abcd");
        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsDimensionsLength_Txt(), "", "Validate text present in Length field");
        createNewOrderPage.fillWithClear_ShipmentDetailsDimensionsBreadth_Txt("abcd");
        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsDimensionsBreadth_Txt(), "", "Validate text present in Breadth field");
        createNewOrderPage.fillWithClear_ShipmentDetailsDimensionsHeight_Txt("abcd");
        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsDimensionsHeight_Txt(), "", "Validate text present in Height field");

        String input = String.valueOf(ActionHelper.generateRandomIntBetweenRange(1, 50));
        createNewOrderPage.fillWithClear_ShipmentDetailsDimensionsLength_Txt(input);
        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsDimensionsLength_Txt(), input, "Validate text present in Length field");
        createNewOrderPage.fillWithClear_ShipmentDetailsDimensionsBreadth_Txt(input);
        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsDimensionsBreadth_Txt(), input, "Validate text present in Breadth field");
        createNewOrderPage.fillWithClear_ShipmentDetailsDimensionsHeight_Txt(input);
        softAssert.assertEquals(createNewOrderPage.getValue_ShipmentDetailsDimensionsHeight_Txt(), input, "Validate text present in Height field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_107, Verify The Functionality of Add Shipment Button of Shipment Details ")
    public void TC_CreateNewOrder_107_Verify_The_Functionality_of_Add_Shipment_Button_of_Shipment_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        String shipmentId = ActionHelper.getRandomNumberString(5);
        String description = faker.artist().name();
        String weight = ActionHelper.getRandomNumberString(2);
        String volume = ActionHelper.getRandomNumberString(3);

        createNewOrderPage.fillWithClear_ShipmentDetailsShipmentID_Txt(shipmentId);
        createNewOrderPage.fillWithClear_ShipmentDetailsDescription_Txt(description);
        createNewOrderPage.fillWithClear_ShipmentDetailsWeight_Txt(weight);
        createNewOrderPage.fillWithClear_ShipmentDetailsVolume_Txt(volume);
        createNewOrderPage.click_ShipmentDetailsAddShipment_Btn();
        softAssert.assertEquals(createNewOrderPage.get_TotalNumberOfShipmentRows_Count(), 2, "Validate the count of rows in the table");
        softAssert.assertEquals(createNewOrderPage.getText_ShipmentDetailsTableColumnShipmentID_ListLbl(0), shipmentId, "Validate Shipment ID in first row");
        softAssert.assertEquals(createNewOrderPage.getText_ShipmentDetailsTableColumnDescription_ListLbl(0), description, "Validate Description in first row");
        softAssert.assertEquals(createNewOrderPage.getText_ShipmentDetailsTableColumnWeight_ListLbl(0), weight, "Validate Weight in first row");
        softAssert.assertEquals(createNewOrderPage.getText_ShipmentDetailsTableColumnVolume_ListLbl(0), volume, "Validate Volume in first row");

        softAssert.assertEquals(createNewOrderPage.getText_ShipmentDetailsTableColumnShipmentID_ListLbl(1), "", "Validate Shipment ID in second row");
        softAssert.assertEquals(createNewOrderPage.getText_ShipmentDetailsTableColumnDescription_ListLbl(1), "", "Validate Description in second row");
        softAssert.assertEquals(createNewOrderPage.getText_ShipmentDetailsTableColumnWeight_ListLbl(1), "0", "Validate Weight in second row");
        softAssert.assertEquals(createNewOrderPage.getText_ShipmentDetailsTableColumnVolume_ListLbl(1), "0", "Validate Volume in second row");
        softAssert.assertEquals(createNewOrderPage.getList_ShipmentDetailsTableColumnDelete_ListBtn().size(), 2, "Validate delete buttons");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_108, Verify The Functionality of Delete Button of Shipment Details ")
    public void TC_CreateNewOrder_108_Verify_The_Functionality_of_Delete_Button_of_Shipment_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        String shipmentId = ActionHelper.getRandomNumberString(5);
        String description = faker.artist().name();
        String weight = ActionHelper.getRandomNumberString(2);
        String volume = ActionHelper.getRandomNumberString(3);

        createNewOrderPage.fillWithClear_ShipmentDetailsShipmentID_Txt(shipmentId);
        createNewOrderPage.fillWithClear_ShipmentDetailsDescription_Txt(description);
        createNewOrderPage.fillWithClear_ShipmentDetailsWeight_Txt(weight);
        createNewOrderPage.fillWithClear_ShipmentDetailsVolume_Txt(volume);
        softAssert.assertEquals(createNewOrderPage.getList_ShipmentDetailsTableColumnShipmentID_ListLbl().size(), 1, "Validate the count of rows in the table before clicking on add button");
        softAssert.assertEquals(createNewOrderPage.getList_ShipmentDetailsTableColumnDelete_ListBtn().size(), 1, "Validate delete button is present in first row");

        createNewOrderPage.click_ShipmentDetailsAddShipment_Btn();

        softAssert.assertEquals(createNewOrderPage.getList_ShipmentDetailsTableColumnShipmentID_ListLbl().size(), 2, "Validate the count of rows in the table after clicking on add button");
        softAssert.assertEquals(createNewOrderPage.getText_ShipmentDetailsTableColumnShipmentID_ListLbl(0), shipmentId, "Validate Shipment ID");
        softAssert.assertEquals(createNewOrderPage.getText_ShipmentDetailsTableColumnDescription_ListLbl(0), description, "Validate Description");
        softAssert.assertEquals(createNewOrderPage.getText_ShipmentDetailsTableColumnWeight_ListLbl(0), weight, "Validate Weight");
        softAssert.assertEquals(createNewOrderPage.getText_ShipmentDetailsTableColumnVolume_ListLbl(0), volume, "Validate Volume");
        softAssert.assertEquals(createNewOrderPage.getList_ShipmentDetailsTableColumnDelete_ListBtn().size(), 2, "Validate delete buttons");

        createNewOrderPage.click_ShipmentDetailsTableColumnDelete_ListBtn(1);

        softAssert.assertEquals(createNewOrderPage.getList_ShipmentDetailsTableColumnShipmentID_ListLbl().size(), 1, "Validate the count of rows in the table");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_117, Verify The Functionality of creating order with Single shipment ")
    public void TC_CreateNewOrder_117_Verify_The_Functionality_of_creating_order_with_Single_shipment() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.addOrderDetails();
        createNewOrderPage.addShipmentDetails(1);
        createNewOrderPage.addFacilityPickupDetails();
        createNewOrderPage.addFacilityDropDetails();
        createNewOrderPage.addPaymentDetails("Prepaid");
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_SuccessToastMsg_Lbl(), "Validate presence of Success toast msg");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_118, Verify The Functionality of creating order with multiple shipments of COD Payment type")
    public void TC_CreateNewOrder_118_Verify_The_Functionality_of_creating_order_with_multiple_shipments_of_COD_Payment_type() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.addOrderDetails();
        createNewOrderPage.addShipmentDetails(2);
        createNewOrderPage.addFacilityPickupDetails();
        createNewOrderPage.addFacilityDropDetails();
        createNewOrderPage.addPaymentDetails("Cash On Delhivery");
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_SuccessToastMsg_Lbl(), "Validate presence of Success toast msg");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_119, Verify The Functionality of creating order with multiple shipments of COD Payment type")
    public void TC_CreateNewOrder_119_Verify_The_Functionality_of_creating_order_with_multiple_shipments_of_COD_Payment_type() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        Map<String, String> orderData = createNewOrderPage.addOrderDetails();
        createNewOrderPage.addShipmentDetails(2);
        createNewOrderPage.addFacilityPickupDetails();
        createNewOrderPage.addFacilityDropDetails();
        createNewOrderPage.addPaymentDetails("Collect At Delivery");
        createNewOrderPage.click_Create_Btn();
        viewOrderPage.fillWithClear_SearchBar_Txt(orderData.get("orderId"));
        softAssert.assertEquals(viewOrderPage.get_FirstElementOrderId_Txt(), orderData.get("orderId"), "Order id is matched as expected");
        softAssert.assertEquals(viewOrderPage.get_FirstElementStatus_Lbl(), "Created", "Status is matched as expected");
        softAssert.assertAll();
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_120, Verify The Functionality of creating order with pickup date is greater than drop date")
    public void TC_CreateNewOrder_120_Verify_The_Functionality_of_creating_order_with_pickup_date_is_greater_than_drop_date() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.addOrderDetails();
        createNewOrderPage.addShipmentDetails(1);
        createNewOrderPage.addFacilityPickupDetails(ActionHelper.getCurrentDay() + "-" + ActionHelper.getCurrentMonth() + "-" + ActionHelper.getCurrentYear());
        createNewOrderPage.addFacilityDropDetails(ActionHelper.getCurrentDay() + "-" + ActionHelper.getCurrentMonth() + "-" + (ActionHelper.getCurrentYear() - 1));
        createNewOrderPage.addPaymentDetails("Collect At Delivery");
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_SuccessToastMsg_Lbl() == false, "Validate presence of error toast msg");
        //ToDo: Expected toast msg is not currently available as this functionality is not working
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT}, description = "TC_121, Verify The Functionality of Total Weight and Total Volume fields")
    public void TC_CreateNewOrder_121_Verify_The_Functionality_of_Total_Weight_and_Total_Volume_fields() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        int totalWeight = 0;
        int totalVolume = 0;
        for (int i = 0; i < 2; i++) {
            createNewOrderPage.fillWithClear_ShipmentDetailsShipmentID_Txt(ActionHelper.getRandomNumberString(5));
            createNewOrderPage.fillWithClear_ShipmentDetailsDescription_Txt(faker.artist().name());
            String weight = ActionHelper.getRandomNumberString(2);
            String volume = ActionHelper.getRandomNumberString(3);
            createNewOrderPage.fillWithClear_ShipmentDetailWeight_Txt(weight);
            createNewOrderPage.fillWithClear_ShipmentDetailVolume_Txt(volume);
            createNewOrderPage.click_ShipmentDetailsAddShipment_Btn();
            totalWeight = totalWeight + Integer.parseInt(weight);
            totalVolume = totalVolume + Integer.parseInt(volume);
            softAssert.assertEquals(createNewOrderPage.getValue_OrderDetailsTotalWeight_Txt(), String.valueOf(totalWeight), "Validate total weight");
            softAssert.assertEquals(createNewOrderPage.getValue_OrderDetailsTotalVolume_Txt(), String.valueOf(totalVolume), "Validate total volume");
        }
        softAssert.assertAll();
    }
}