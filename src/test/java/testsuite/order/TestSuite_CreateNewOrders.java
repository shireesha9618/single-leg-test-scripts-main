package testsuite.order;

import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.actions.ActionHelper;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.CreateNewOrderPage;
import pageobjects.ViewOrderPage;

import java.util.List;

public class TestSuite_CreateNewOrders extends BaseTestClass {

    CommonActions commonActions = CommonActions.getInstance();
    CreateNewOrderPage createNewOrderPage = CreateNewOrderPage.getInstance();
    ViewOrderPage viewOrderPage = ViewOrderPage.getInstance();
    Faker faker = new Faker();

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_001, Verify The UI Of The Create New Order Page")
    public void TC_CreateNewOrder_001_Verify_UI_Of_The_Create_New_Order_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsHeader_Lbl(), "Check Visibility of Order Details header");
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderId_Txt(), "Check Visibility of Order Id text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsScannableBarcodeNumber_Txt(), "Check Visibility of Scannable/Barcode Number text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderDescription_Txt(), "Check Visibility of Order Description text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsTeam_Dropdown(), "Check Visibility of Team dropdown");

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
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsClearAll_Btn(), "Check Visibility of Clear All button");

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
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsClearAll_Btn(), "Check Visibility of Clear All button");

        softAssert.assertTrue(createNewOrderPage.isPresent_PaymentDetailsHeader_Lbl(), "Check Visibility of Payment Details header");
        softAssert.assertTrue(createNewOrderPage.isPresent_PaymentDetailsPaymentType_Select(), "Check Visibility of Payment Type dropdown");
        softAssert.assertTrue(createNewOrderPage.isPresent_PaymentDetailsOrderAmount_Txt(), "Check Visibility of Order Amount text box");

        softAssert.assertTrue(createNewOrderPage.isPresent_Cancel_Btn(), "Check Visibility of Cancel button");
        softAssert.assertTrue(createNewOrderPage.isPresent_Create_Btn(), "Check Visibility of Create button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_002, Verify The Functionality of Scannable/Barcode Number Text box")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_003, Verify The Validation Functionality In Create New Order Page For Mandatory Fields with empty")
    public void TC_CreateNewOrder_003_Verify_The_Validation_Functionality_In_Create_New_Order_Page_For_Mandatory_Fields_with_empty() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_Create_Btn();

        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderId_Txt(), "Validate presence of validation error message for Order Id field");
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderDescriptionValidationError_Lbl(), "Validate presence of validation error message for Order Description field");
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsTeamValidationError_Lbl(), "Validate presence of validation error message for Team field");

        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsSelectAFacilityValidationError_Lbl(), "Validate presence of validation error message for Select A Facility field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCountryValidationError_Lbl(), "Validate presence of validation error message for Country field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine1ValidationError_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine2ValidationError_Lbl(), "Validate presence of validation error message for Address Line 2 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");

        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsSelectAFacilityValidationError_Lbl(), "Validate presence of validation error message for Select A Facility field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCountryValidationError_Lbl(), "Validate presence of validation error message for Country field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine1ValidationError_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine2ValidationError_Lbl(), "Validate presence of validation error message for Address Line 2 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");

        softAssert.assertTrue(createNewOrderPage.isPresent_PaymentDetailsPaymentTypeValidationError_Lbl(), "Validate presence of validation error message for Payment Type field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_004, Verify The Functionality Of Breadcrumb Menu For Create New Order page")
    public void TC_CreateNewOrder_004_Verify_The_Functionality_Of_Breadcrumb_Menu_For_Create_New_Order_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        softAssert.assertTrue(createNewOrderPage.isPresent_CreateOrderBreadcrumb_Link(), "Validate presence of Create Order Breadcrumb");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_005, Verify The Functionality Of Cancel Button In Create New Order Page")
    public void TC_CreateNewOrder_005_Verify_The_Functionality_Of_Cancel_Button_In_Create_New_Order_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_Cancel_Btn();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_006, Verify The Validation Functionality For Order Id In Create New Order Page For Empty Field")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_007, Verify The Validation Functionality For Order Id In Create New Order Page For Minimum Character")
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
            softAssert.assertEquals(createNewOrderPage.getText_OrderDetailsOrderIdValidationError_Lbl(), "", "Validate validation error message for Order Id field");
            //ToDo: Expected Validation error message is not mentioned in the test case and functionality is not working currently
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_008, Verify The Validation Functionality For Order Id In Create New Order Page For Maximum Character")
    public void TC_CreateNewOrder_008_Verify_The_Validation_Functionality_For_Order_Id_In_Create_New_Order_Page_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillWithClear_OrderDetailsOrderId_Txt("Max length " + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30) +
                ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(29));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_OrderDetailsOrderIdValidationError_Lbl(), "Validate presence of validation error message for Order Id field");
        softAssert.assertEquals(createNewOrderPage.getText_OrderDetailsOrderIdValidationError_Lbl(), "", "Validate validation error message for Order Id field");
        //ToDo: Expected Validation error message is not mentioned in the test case and functionality is not working currently
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_009, Verify The Validation Functionality For Order description textbox In Create New Order Page For Empty Field")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_010, Verify maximum limit on order description textbox")
    public void TC_CreateNewOrder_010_Verify_maximum_limit_on_order_description_textbox() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillWithClear_OrderDetailsOrderDescription_Txt("Max length" + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30)
                + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30)
                + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30)
                + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30)
                + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(23));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertEquals(createNewOrderPage.getText_OrderDetailsOrderDescriptionValidationError_Lbl(), "Length Should Be Between 3 And 512", "Validate validation error message for Order Description field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_011, Verify minimum limit on description textbox")
    public void TC_CreateNewOrder_011_Verify_minimum_limit_on_description_textbox() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillWithClear_OrderDetailsOrderDescription_Txt(ActionHelper.getRandomNumberString(2));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertEquals(createNewOrderPage.getText_OrderDetailsOrderDescriptionValidationError_Lbl(), "Length Should Be Between 3 And 512", "Validate validation error message for Order Description field");
        softAssert.assertAll();
    }

    //ToDo: Pending
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_012, Verify The Functionality of Teams Dropdown ")
    public void TC_CreateNewOrder_012_Verify_The_Functionality_of_Teams_Dropdown() {


    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_013, Verify The UI of Pickup Details of Create New Order")
    public void TC_CreateNewOrder_013_Verify_The_UI_of_Pickup_Details_of_Create_New_Order() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsHeader_Lbl(), "Check Visibility of Pickup Details header");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactName_Txt(), "Check Visibility of Contact Name text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNumber_Txt(), "Check Visibility of Contact Number text box");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsSelectAFacility_Dropdown(), "Check Visibility of Select A Facility text box");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_014, Verify The Validation Functionality For Contact Name of Pickup Details For Empty Field")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_015, Verify The Validation Functionality For Contact Name of Pickup Details For Minimum Character")
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
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsContactNameValidationError_Lbl(), "Not Correct format", "Validate validation error message for Contact Name field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_016, Verify The Validation Functionality For Contact Name of Pickup Details For Maximum Character")
    public void TC_CreateNewOrder_016_Verify_The_Validation_Functionality_For_Contact_Name_of_Pickup_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillWithClear_PickupDetailsContactName_Txt("Max length" + ActionHelper.generateRandomName(27, 27));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsContactNameValidationError_Lbl(), "Not Correct format", "Validate validation error message for Contact Name field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_017, Verify The Validation Functionality For Contact Name of Pickup Details For other than Alphabet")
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
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsContactNameValidationError_Lbl(), "Not Correct format", "Validate validation error message for Contact Name field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_018, Verify The Validation Functionality for Phone number of Pickup Details for empty field")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_019, Verify The Validation Functionality for Phone number of Pickup Details for Minimum Character")
    public void TC_CreateNewOrder_019_Verify_The_Validation_Functionality_for_Phone_number_of_Pickup_Details_for_Minimum_Character() {
        List<String> inputs = List.of("111", "aaa", "###", "2b@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsContactNumber_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsContactNumberValidationError_Lbl(), "Not Correct format", "Validate text of validation error message for Contact Number field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_020, Verify The Validation Functionality for Phone number of Pickup Details for Maximum Character")
    public void TC_CreateNewOrder_020_Verify_The_Validation_Functionality_for_Phone_number_of_Pickup_Details_for_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_PickupDetailsContactNumber_Txt(ActionHelper.getRandomNumberString(11));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsContactNumberValidationError_Lbl(), "Not Correct format", "Validate text of validation error message for Contact Number field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_021, Verify The Validation For Phone Number of Pickup Details For  Special character and alphabets")
    public void TC_CreateNewOrder_021_Verify_The_Validation_For_Phone_Number_of_Pickup_Details_For_Special_character_and_alphabets() {
        List<String> inputs = List.of("@@@@@", "aa!@$", "aa112", "aa1@1$", "aaaaaa");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsContactNumber_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsContactNumberValidationError_Lbl(), "Not Correct format", "Validate text of validation error message for Contact Number field");
        }
        softAssert.assertAll();
    }

    //ToDo: Pending
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_022, Verify The UI of Select a Facility of Pickup Details")
    public void TC_CreateNewOrder_022_Verify_The_UI_of_Select_a_Facility_of_Pickup_Details() {


    }

    //ToDo: Pending
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_023, Verify The Functionality of Select a Facility of Pickup Details")
    public void TC_CreateNewOrder_023_Verify_The_Functionality_of_Select_a_Facility_of_Pickup_Details() {


    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_024, Verify The UI Of Custom Address For Pickup Details")
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
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsClearAll_Btn(), "Check Visibility of Clear All button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_025, Verify The Validation Functionality of Custom Address of Pickup Details For Empty Field")
    public void TC_CreateNewOrder_025_Verify_The_Validation_Functionality_of_Custom_Address_of_Pickup_Details_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_Create_Btn();

        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCountryValidationError_Lbl(), "Validate presence of validation error message for Country field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine1ValidationError_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine2ValidationError_Lbl(), "Validate presence of validation error message for Address Line 2 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_026, Verify The Validation Functionality of Address Line 1 of Pickup Details for Maximum Character")
    public void TC_CreateNewOrder_026_Verify_The_Validation_Functionality_of_Address_Line_1_of_Pickup_Details_for_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_PickupDetailsAddressLine1_Txt("Max length" + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30)
                + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(29));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine1ValidationError_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsAddressLine1ValidationError_Lbl(), "Can be at max 128", "Validate text of validation error message for Address Line 1 field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_027, Verify The Validation Functionality of Address Line 2 of Pickup Details for Maximum Character")
    public void TC_CreateNewOrder_027_Verify_The_Validation_Functionality_of_Address_Line_2_of_Pickup_Details_for_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_PickupDetailsAddressLine2_Txt("Max length" + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30)
                + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(29));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsAddressLine2ValidationError_Lbl(), "Validate presence of validation error message for Address Line 2 field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsAddressLine2ValidationError_Lbl(), "Can be at max 128", "Validate text of validation error message for Address Line 2 field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_028, Verify The Validation Functionality of City of Pickup Details For Special And Numeric Character ")
    public void TC_CreateNewOrder_028_Verify_The_Validation_Functionality_of_City_of_Pickup_Details_For_Special_And_Numeric_Character() {
        List<String> inputs = List.of("@@@@@", "aa!@$", "aa112", "aa1@1$", "11223");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsCity_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsCityValidationError_Lbl(), "Only letter ( A-Z, a-z )", "Validate validation error message for City field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_029, Verify The Validation Functionality of City of Pickup Details For Minimum Character")
    public void TC_CreateNewOrder_029_Verify_The_Validation_Functionality_of_City_of_Pickup_Details_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsCity_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsCityValidationError_Lbl(), "Should be minimum 2", "Validate validation error message for City field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_030, Verify The Validation Functionality of City of Pickup Details For Maximum Character")
    public void TC_CreateNewOrder_030_Verify_The_Validation_Functionality_of_City_of_Pickup_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_PickupDetailsCity_Txt("Max length" + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(25));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsCityValidationError_Lbl(), "Can be at max 64", "Validate validation error message for City field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_031, Verify The Validation Functionality of State of Pickup Details For Special And Numeric Character ")
    public void TC_CreateNewOrder_031_Verify_The_Validation_Functionality_of_State_of_Pickup_Details_For_Special_And_Numeric_Character() {
        List<String> inputs = List.of("@@@@@", "aa!@$", "aa112", "aa1@1$", "11223");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsState_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsCityValidationError_Lbl(), "Validate presence of validation error message for State field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsCityValidationError_Lbl(), "Only letter ( A-Z, a-z )", "Validate validation error message for State field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_032, Verify The Validation Functionality of State of Pickup Details For Minimum Character")
    public void TC_CreateNewOrder_032_Verify_The_Validation_Functionality_of_State_of_Pickup_Details_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsState_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsStateValidationError_Lbl(), "Should be minimum 2", "Validate validation error message for State field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_033, Verify The Validation Functionality of State of Pickup Details For Maximum Character")
    public void TC_CreateNewOrder_033_Verify_The_Validation_Functionality_of_State_of_Pickup_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_PickupDetailsState_Txt("Max length" + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(25));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsStateValidationError_Lbl(), "Can be at max 64", "Validate validation error message for State field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_034, Verify The Validation Functionality of Postal Code of Pickup Details For Special And Numeric Character ")
    public void TC_CreateNewOrder_034_Verify_The_Validation_Functionality_of_Postal_Code_of_Pickup_Details_For_Special_And_Numeric_Character() {
        List<String> inputs = List.of("@@@@@", "aa!@$", "aa112", "aa1@1$", "aaaaaa");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsPostalCode_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsPostalCodeValidationError_Lbl(), "Only letter ( A-Z, a-z )", "Validate validation error message for Postal Code field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_035, Verify The Validation Functionality of Postal Code of Pickup Details For Minimum Character")
    public void TC_CreateNewOrder_035_Verify_The_Validation_Functionality_of_Postal_Code_of_Pickup_Details_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_PickupDetailsPostalCode_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
            softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsPostalCodeValidationError_Lbl(), "Should be minimum 2", "Validate validation error message for Postal Code field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_036, Verify The Validation Functionality of Postal code of Pickup Details For Maximum Character")
    public void TC_CreateNewOrder_036_Verify_The_Validation_Functionality_of_Postal_code_of_Pickup_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_PickupDetailsPostalCode_Txt("Max length.");
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_PickupDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertEquals(createNewOrderPage.getText_PickupDetailsPostalCodeValidationError_Lbl(), "Can be at max 10", "Validate validation error message for Postal Code field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_038, Verify The Functionality of Clear Selection button in Pickup Details")
    public void TC_CreateNewOrder_038_Verify_The_Functionality_of_Clear_Selection_button_in_Pickup_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillWithClear_PickupDetailsPostalCode_Txt(faker.address().zipCode());
        createNewOrderPage.selectByValue_PickupDetailsCountry_Select(faker.country().name());
        createNewOrderPage.fillWithClear_PickupDetailsAddressLine1_Txt(faker.address().buildingNumber());
        createNewOrderPage.fillWithClear_PickupDetailsAddressLine2_Txt(faker.address().buildingNumber());
        createNewOrderPage.fillWithClear_PickupDetailsPostalCode_Txt(faker.address().state());
        createNewOrderPage.fillWithClear_PickupDetailsPostalCode_Txt(faker.address().city());
        createNewOrderPage.click_PickupDetailsClearAll_Btn();

        softAssert.assertEquals(createNewOrderPage.getValue_PickupDetailsPostalCode_Txt(), "", "Validate value of Postal Code field");
        softAssert.assertEquals(createNewOrderPage.getFirstSelectedOption_PickupDetailsCountry_Select(), "", "Validate value of Country field");
        softAssert.assertEquals(createNewOrderPage.getValue_PickupDetailsAddressLine1_Txt(), "", "Validate value of Address Line 1 field");
        softAssert.assertEquals(createNewOrderPage.getValue_PickupDetailsAddressLine2_Txt(), "", "Validate value of Address Line 2 field");
        softAssert.assertEquals(createNewOrderPage.getValue_PickupDetailsState_Txt(), "", "Validate value of State field");
        softAssert.assertEquals(createNewOrderPage.getValue_PickupDetailsCity_Txt(), "", "Validate value of City field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_039, Verify The UI of Drop Details of Create New Order")
    public void TC_CreateNewOrder_039_Verify_The_UI_of_Drop_Details_of_Create_New_Order() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

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
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsClearAll_Btn(), "Check Visibility of Clear All button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_040, Verify The Validation Functionality For Contact Name of Drop Details For Empty Field")
    public void TC_CreateNewOrder_040_Verify_The_Validation_Functionality_For_Contact_Name_of_Drop_Details_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.clear_DropDetailsContactName_Txt();
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNameValidationError_Lbl(), "Required", "Validate text of validation error message for Contact Name field");
        softAssert.assertAll();
    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_041, Verify The Validation Functionality For Contact Name of Drop Details For Minimum Character")
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
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNameValidationError_Lbl(), "Not Correct format", "Validate validation error message for Contact Name field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_042, Verify The Validation Functionality For Contact Name of Drop Details For Maximum Character")
    public void TC_CreateNewOrder_042_Verify_The_Validation_Functionality_For_Contact_Name_of_Drop_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillWithClear_DropDetailsContactName_Txt("Max length" + ActionHelper.generateRandomName(27, 27));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNameValidationError_Lbl(), "Validate presence of validation error message for Contact Name field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNameValidationError_Lbl(), "Not Correct format", "Validate validation error message for Contact Name field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_043, Verify The Validation Functionality For Contact Name of Drop Details For other than Alphabet")
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
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNameValidationError_Lbl(), "Not Correct format", "Validate validation error message for Contact Name field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_044, Verify The Validation Functionality for Phone number of DropDetails for empty field")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_045, Verify The Validation Functionality for Phone number of Drop Details for Minimum Character")
    public void TC_CreateNewOrder_045_Verify_The_Validation_Functionality_for_Phone_number_of_Drop_Details_for_Minimum_Character() {
        List<String> inputs = List.of("111", "aaa", "###", "2b@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_DropDetailsContactNumber_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNumberValidationError_Lbl(), "Not Correct format", "Validate text of validation error message for Contact Number field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_046, Verify The Validation Functionality for Phone number of Drop Details for Maximum Character")
    public void TC_CreateNewOrder_046_Verify_The_Validation_Functionality_for_Phone_number_of_Drop_Details_for_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_DropDetailsContactNumber_Txt(ActionHelper.getRandomNumberString(11));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNumberValidationError_Lbl(), "Not Correct format", "Validate text of validation error message for Contact Number field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_047, Verify The Validation For Phone Number of Drop Details For  Special character and alphabets")
    public void TC_CreateNewOrder_047_Verify_The_Validation_For_Phone_Number_of_Drop_Details_For_Special_character_and_alphabets() {
        List<String> inputs = List.of("@@@@@", "aa!@$", "aa112", "aa1@1$", "aaaaaa");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_DropDetailsContactNumber_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsContactNumberValidationError_Lbl(), "Validate presence of validation error message for Contact Number field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsContactNumberValidationError_Lbl(), "Not Correct format", "Validate text of validation error message for Contact Number field");
        }
        softAssert.assertAll();
    }

    //ToDo: Pending
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_048, Verify The UI of Select a Facility of Drop Details")
    public void TC_CreateNewOrder_048_Verify_The_UI_of_Select_a_Facility_of_Drop_Details() {

    }

    //ToDo: Pending
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_049, Verify The Functionality of Select a Facility of Drop Details")
    public void TC_CreateNewOrder_049_Verify_The_Functionality_of_Select_a_Facility_of_Drop_Details() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_050, Verify The UI Of Custom Address For Drop Details")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_051, Verify The Validation Functionality of Custom Address of Drop Details For Empty Field")
    public void TC_CreateNewOrder_051_Verify_The_Validation_Functionality_of_Custom_Address_of_Drop_Details_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.click_Create_Btn();

        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCountryValidationError_Lbl(), "Validate presence of validation error message for Country field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine1ValidationError_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine2ValidationError_Lbl(), "Validate presence of validation error message for Address Line 2 field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_052, Verify The Validation Functionality of Address Line 1 of Drop Details for Maximum Character")
    public void TC_CreateNewOrder_052_Verify_The_Validation_Functionality_of_Address_Line_1_of_Drop_Details_for_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_DropDetailsAddressLine1_Txt("Max length" + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30)
                + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(29));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine1ValidationError_Lbl(), "Validate presence of validation error message for Address Line 1 field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsAddressLine1ValidationError_Lbl(), "Can be at max 128", "Validate text of validation error message for Address Line 1 field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_053, Verify The Validation Functionality of Address Line 2 of Drop Details for Maximum Character")
    public void TC_CreateNewOrder_053_Verify_The_Validation_Functionality_of_Address_Line_2_of_Drop_Details_for_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_DropDetailsAddressLine2_Txt("Max length" + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(30)
                + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(29));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsAddressLine2ValidationError_Lbl(), "Validate presence of validation error message for Address Line 2 field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsAddressLine2ValidationError_Lbl(), "Can be at max 128", "Validate text of validation error message for Address Line 2 field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_054, Verify The Validation Functionality of City of Drop Details For Special And Numeric Character")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_055, Verify The Validation Functionality of City of Drop Details For Minimum Character")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_056, Verify The Validation Functionality of City of Drop Details For Maximum Character")
    public void TC_CreateNewOrder_056_Verify_The_Validation_Functionality_of_City_of_Drop_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_DropDetailsCity_Txt("Max length" + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(25));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsCityValidationError_Lbl(), "Validate presence of validation error message for City field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsCityValidationError_Lbl(), "Can be at max 64", "Validate validation error message for City field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_057, Verify The Validation Functionality of State of Drop Details For Special And Numeric Character")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_058, Verify The Validation Functionality of State of Drop Details For Minimum Character")
    public void TC_CreateNewOrder_058_Verify_The_Validation_Functionality_of_State_of_Drop_Details_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_DropDetailsState_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsStateValidationError_Lbl(), "Should be minimum 2", "Validate validation error message for State field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_059, Verify The Validation Functionality of State of Drop Details For Maximum Character")
    public void TC_CreateNewOrder_059_Verify_The_Validation_Functionality_of_State_of_Drop_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_DropDetailsState_Txt("Max length" + ActionHelper.getRandomNumberString(30) + ActionHelper.getRandomNumberString(25));
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsStateValidationError_Lbl(), "Validate presence of validation error message for State field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsStateValidationError_Lbl(), "Can be at max 64", "Validate validation error message for State field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_060, Verify The Validation Functionality of Postal Code of Drop Details For Special And Numeric Character")
    public void TC_CreateNewOrder_060_Verify_The_Validation_Functionality_of_Postal_Code_of_Drop_Details_For_Special_And_Numeric_Character() {
        List<String> inputs = List.of("@@@@@", "aa!@$", "aa112", "aa1@1$", "aaaaaa");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_DropDetailsPostalCode_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsPostalCodeValidationError_Lbl(), "Only letter ( A-Z, a-z )", "Validate validation error message for Postal Code field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_061, Verify The Validation Functionality of Postal Code of Drop Details For Minimum Character")
    public void TC_CreateNewOrder_061_Verify_The_Validation_Functionality_of_Postal_Code_of_Drop_Details_For_Minimum_Character() {
        List<String> inputs = List.of("q", "1", "@");
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        for (String input : inputs) {
            createNewOrderPage.fillWithClear_DropDetailsPostalCode_Txt(input);
            createNewOrderPage.click_Create_Btn();
            softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
            softAssert.assertEquals(createNewOrderPage.getText_DropDetailsPostalCodeValidationError_Lbl(), "Should be minimum 2", "Validate validation error message for Postal Code field");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_062, Verify The Validation Functionality of Postal code of Drop Details For Maximum Character")
    public void TC_CreateNewOrder_062_Verify_The_Validation_Functionality_of_Postal_code_of_Drop_Details_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        createNewOrderPage.fillWithClear_DropDetailsPostalCode_Txt("Max length.");
        createNewOrderPage.click_Create_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_DropDetailsPostalCodeValidationError_Lbl(), "Validate presence of validation error message for Postal Code field");
        softAssert.assertEquals(createNewOrderPage.getText_DropDetailsPostalCodeValidationError_Lbl(), "Can be at max 10", "Validate validation error message for Postal Code field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_064, Verify The Functionality of Clear Selection button in Drop Details")
    public void TC_CreateNewOrder_064_Verify_The_Functionality_of_Clear_Selection_button_in_Drop_Details() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

        createNewOrderPage.fillWithClear_DropDetailsPostalCode_Txt(faker.address().zipCode());
        createNewOrderPage.selectByValue_DropDetailsCountry_Select(faker.country().name());
        createNewOrderPage.fillWithClear_DropDetailsAddressLine1_Txt(faker.address().buildingNumber());
        createNewOrderPage.fillWithClear_DropDetailsAddressLine2_Txt(faker.address().buildingNumber());
        createNewOrderPage.fillWithClear_DropDetailsPostalCode_Txt(faker.address().state());
        createNewOrderPage.fillWithClear_DropDetailsPostalCode_Txt(faker.address().city());
        createNewOrderPage.click_DropDetailsClearAll_Btn();

        softAssert.assertEquals(createNewOrderPage.getValue_DropDetailsPostalCode_Txt(), "", "Validate value of Postal Code field");
        softAssert.assertEquals(createNewOrderPage.getFirstSelectedOption_DropDetailsCountry_Select(), "", "Validate value of Country field");
        softAssert.assertEquals(createNewOrderPage.getValue_DropDetailsAddressLine1_Txt(), "", "Validate value of Address Line 1 field");
        softAssert.assertEquals(createNewOrderPage.getValue_DropDetailsAddressLine2_Txt(), "", "Validate value of Address Line 2 field");
        softAssert.assertEquals(createNewOrderPage.getValue_DropDetailsState_Txt(), "", "Validate value of State field");
        softAssert.assertEquals(createNewOrderPage.getValue_DropDetailsCity_Txt(), "", "Validate value of City field");
        softAssert.assertAll();
    }

    //ToDo: Pending
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_065, To verify payment type dropdown")
    public void TC_CreateNewOrder_065_To_verify_payment_type_dropdown() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillCreateOrder();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_066, Verify The Validation Functionality For Payment Type In Create New Order Page For Empty Field")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_067, Verify The Functionality of Collect at Pickup in Payment Type without order Amount")
    public void TC_CreateNewOrder_067_Verify_The_Functionality_of_Collect_at_Pickup_in_Payment_Type_without_order_Amount() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_068, Verify The Functionality of Collect at Deliver in Payment Type without order Amount")
    public void TC_CreateNewOrder_068_Verify_The_Functionality_of_Collect_at_Deliver_in_Payment_Type_without_order_Amount() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_069, Verify The Functionality of Prepaid in Payment Type without order Amount")
    public void TC_CreateNewOrder_069_Verify_The_Functionality_of_Prepaid_in_Payment_Type_without_order_Amount() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_070, Verify The Functionality of Collect at Pickup in Payment Type with order Amount")
    public void TC_CreateNewOrder_070_Verify_The_Functionality_of_Collect_at_Pickup_in_Payment_Type_with_order_Amount() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_071, Verify The Functionality of Collect at Deliver in Payment Type with order Amount")
    public void TC_CreateNewOrder_071_Verify_The_Functionality_of_Collect_at_Deliver_in_Payment_Type_with_order_Amount() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_072, Verify The Functionality of Prepaid in Payment Type with order Amount")
    public void TC_CreateNewOrder_072_Verify_The_Functionality_of_Prepaid_in_Payment_Type_with_order_Amount() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_073, Verify The Validation Functionality For Duplicate Order ID In Create New Order Page ")
    public void TC_CreateNewOrder_073_Verify_The_Validation_Functionality_For_Duplicate_Order_ID_In_Create_New_Order_Page() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_074, Verify The UI of Add Facility in Select a Facility of Pickup Details")
    public void TC_CreateNewOrder_074_Verify_The_UI_of_Add_Facility_in_Select_a_Facility_of_Pickup_Details() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_075, Verify The Validation Functionality For Name In Add New Facility Page For Empty Field")
    public void TC_CreateNewOrder_075_Verify_The_Validation_Functionality_For_Name_In_Add_New_Facility_Page_For_Empty_Field() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_076, Verify The Validation Functionality For Name In Add New Facility Page For Minimum Character")
    public void TC_CreateNewOrder_076_Verify_The_Validation_Functionality_For_Name_In_Add_New_Facility_Page_For_Minimum_Character() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_077, Verify The Validation Functionality For Name In Add New Facility Page For Maximum Character")
    public void TC_CreateNewOrder_077_Verify_The_Validation_Functionality_For_Name_In_Add_New_Facility_Page_For_Maximum_Character() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_078, Verify The Validation Functionality For Facility ID In Add New Facility Page For Empty Field")
    public void TC_CreateNewOrder_078_Verify_The_Validation_Functionality_For_Facility_ID_In_Add_New_Facility_Page_For_Empty_Field() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_079, Verify The Validation Functionality For Facility ID In Add New Facility Page For Minimum Character")
    public void TC_CreateNewOrder_079_Verify_The_Validation_Functionality_For_Facility_ID_In_Add_New_Facility_Page_For_Minimum_Character() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_080, Verify The Validation Functionality For Facility ID In Add New Facility Page For Maximum Character")
    public void TC_CreateNewOrder_080_Verify_The_Validation_Functionality_For_Facility_ID_In_Add_New_Facility_Page_For_Maximum_Character() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_081, Verify The Validation Functionality For PostalCode In Add New Facility Page For Empty Field")
    public void TC_CreateNewOrder_081_Verify_The_Validation_Functionality_For_PostalCode_In_Add_New_Facility_Page_For_Empty_Field() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_082, Verify The Validation Functionality For PostalCode In Add New Facility Page For Minimum Character")
    public void TC_CreateNewOrder_082_Verify_The_Validation_Functionality_For_PostalCode_In_Add_New_Facility_Page_For_Minimum_Character() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_083, Verify The Validation Functionality For PostalCode In Add New Facility Page For Maximum Character")
    public void TC_CreateNewOrder_083_Verify_The_Validation_Functionality_For_PostalCode_In_Add_New_Facility_Page_For_Maximum_Character() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_084, Verify The Validation Functionality For PostalCode In Add New Facility Page For Other Than Numeric Value")
    public void TC_CreateNewOrder_084_Verify_The_Validation_Functionality_For_PostalCode_In_Add_New_Facility_Page_For_Other_Than_Numeric_Value() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_085, Verify the Functionality of Postal Code With valid data")
    public void TC_CreateNewOrder_085_Verify_the_Functionlity_of_Postal_Code_With_valid_data() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_086, Verify The Validation Functionality For Postal Code in Add New Facility page with invalid postal code")
    public void TC_CreateNewOrder_086_Verify_The_Validation_Functionality_For_Postal_Code_in_Add_New_Facility_page_with_invalid_postal_code() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_087, Verify Functionality For Country DropDown In Add New Facility Page")
    public void TC_CreateNewOrder_087_Verify_Functionality_For_Country_DropDown_In_Add_New_Facility_Page() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_088, Verify The Validation Functionality For Address Line 1 In Add New Facility Page For Empty Field")
    public void TC_CreateNewOrder_088_Verify_The_Validation_Functionality_For_Address_Line_1_In_Add_New_Facility_Page_For_Empty_Field() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_089, Verify The Validation Functionality For Address Line 1 In Add New Facility Page For Minimum Character")
    public void TC_CreateNewOrder_089_Verify_The_Validation_Functionality_For_Address_Line_1_In_Add_New_Facility_Page_For_Minimum_Character() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_090, Verify The Validation Functionality For Address Line 1 In Add New Facility Page For Maximum Character")
    public void TC_CreateNewOrder_090_Verify_The_Validation_Functionality_For_Address_Line_1_In_Add_New_Facility_Page_For_Maximum_Character() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_091, Verify The Validation Functionality For Address Line 2 In Add New Facility Page For Empty Field")
    public void TC_CreateNewOrder_091_Verify_The_Validation_Functionality_For_Address_Line_2_In_Add_New_Facility_Page_For_Empty_Field() {

    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_092, Verify The Validation Functionality For Address Line 2 In Add New Facility Page For Minimum Character")
    public void TC_CreateNewOrder_092_Verify_The_Validation_Functionality_For_Address_Line_2_In_Add_New_Facility_Page_For_Minimum_Character() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_093, Verify The Validation Functionality For Address Line 2 In Add New Facility Page For Maximum Character")
    public void TC_CreateNewOrder_093_Verify_The_Validation_Functionality_For_Address_Line_2_In_Add_New_Facility_Page_For_Maximum_Character() {

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_ORDER, TestGroup.BVT},
            description = "TC_094, Verify The Functionality for selecting same facility for pickup and drop")
    public void TC_CreateNewOrder_094_Verify_The_Functionality_for_selecting_same_facility_for_pickup_and_drop() {

    }

}