package testsuite.endtoend;

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
import pageobjects.DispatchDetailPage;
import pageobjects.DispatchPage;
import pageobjects.HomePage;
import pageobjects.ViewOrderPage;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class TestSuite_EndToEnd extends BaseTestClass {
    CreateNewOrderPage createOrderPage = CreateNewOrderPage.getInstance();
    ViewOrderPage viewOrdersPage = ViewOrderPage.getInstance();
    DispatchDetailPage dispatchDetailPage = DispatchDetailPage.getInstance();
    DispatchPage dispatchPage = DispatchPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    Faker sampleData = new Faker();

    @Test(groups = {TestGroup.SMOKE, TestGroup.REGRESSION},
            description = "Verify End to End Test Case",
            priority = 1)
    public void TC_EndToEnd_Verify_End_To_End_From_Order_To_Publish_Dispatch_Flow() throws IOException, APIResponseException, AWTException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillCreateOrder();
        softAssert.assertTrue(HomePage.getInstance().isPresent_TeamDropdown_Txt(), "Team dropdown text is present as expected");
        softAssert.assertTrue(HomePage.getInstance().get_TeamDropdown_Txt() != null, "Teams dropdown is not null as expected");
        HomePage.getInstance().selectTeam(Constants.TEAM);

        HashMap<String, String> orderSummaryBeforeOrderCreation = viewOrdersPage.getOrderSummary();
        HomePage.getInstance().openDispatchListPage();
        HashMap<String, String> dispatchSummaryBeforeOrderCreation = dispatchPage.getDispatchSummary();

        HomePage.getInstance().openCreateOrderPage();
        String orderId = String.valueOf(sampleData.number().digits(10));
        String description = ActionHelper.generateRandomName(6, 6);
        softAssert.assertTrue(createOrderPage.isPresent_Header_Lbl(), "Header Label is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_OrderDetailsOrderId_Txt(), "Order Id is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_OrderDetailsScannableBarcodeNumber_Txt(), "Barcode Number Text Box is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_OrderDetailsOrderDescription_Txt(), "Description textBox is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_OrderDetailsTeam_Dropdown(), "Team Dropdown is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_PickupDetailsContactName_Txt(), "Pickup Contact Name is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_PickupDetailsContactNumber_Txt(), "Primary Mobile Number is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_DropDetailsContactName_Txt(), "Drop Contact Name is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_DropDetailsContactNumber_Txt(), "Drop Primary Mobile Number is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_PaymentDetailsPaymentType_Select(), "Select Payment Type is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_PaymentDetailsOrderAmount_Txt(), "Order Amount is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_Create_Btn(), "Submit Button is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_Cancel_Btn(), "Cancel button is present as expected");

        createOrderPage.fillWithClear_OrderDetailsOrderId_Txt(orderId);
        softAssert.assertTrue(createOrderPage.getValue_OrderDetailsScannableBarcodeNumber_Txt() != null, "Barcode Label is not null as expected");

        createOrderPage.fillWithClear_OrderDetailsOrderDescription_Txt(description);
        createOrderPage.fill_PickupDetailsContactName_Txt(sampleData.name().firstName());
        createOrderPage.fillWithClear_PickupDetailsContactNumber_Txt(sampleData.phoneNumber().subscriberNumber(10));
        createOrderPage.validate_PickUpClear_Btn(Constants.PICKUP_PINCODE, "Building " + sampleData.number().digits(2), "Street" + sampleData.number().digits(2));

        createOrderPage.validateAndCreateFacility("Pickup", Constants.PICKUP_PINCODE);
        createOrderPage.set_PickUpFacility_TextBox();

        createOrderPage.fillWithClear_DropDetailsContactName_Txt(sampleData.name().firstName());
        createOrderPage.fillWithClear_DropDetailsContactNumber_Txt(sampleData.phoneNumber().subscriberNumber(10));
        createOrderPage.validate_DropClearAll_Btn(Constants.PICKUP_PINCODE, "Building " + sampleData.number().digits(2), "Street " + sampleData.number().digits(2));

        createOrderPage.validateAndCreateFacility("Drop", Constants.DROP_PINCODE);
        createOrderPage.set_DropFacility_TextBox();

        createOrderPage.selectByVisibleText_PaymentDetailsPaymentType_Select("Prepaid");
        createOrderPage.selectByVisibleText_PaymentDetailsPaymentType_Select("Collect At Delivery");
        String orderAmount = sampleData.number().digits(3);
        createOrderPage.fillWithClear_PaymentDetailsOrderAmount_Txt(orderAmount);
        createOrderPage.click_Create_Btn();
        viewOrdersPage.click_Refresh_Btn();
        HashMap<String, String> orderSummaryAfterOrderCreation = viewOrdersPage.getOrderSummary();

        softAssert.assertTrue(viewOrdersPage.isPresent_Header_Lbl(), "View Order Header Label is present as expected");
        softAssert.assertEquals(Integer.parseInt(orderSummaryBeforeOrderCreation.get("ToBeAssignedData")), Integer.parseInt(orderSummaryAfterOrderCreation.get("ToBeAssignedData")) - 1, "To be assigned data is matched as expected");
        softAssert.assertEquals(orderSummaryBeforeOrderCreation.get("ToBeDispatchedData"), orderSummaryAfterOrderCreation.get("ToBeDispatchedData"), "To be dispatched data is matched as expected");
        softAssert.assertEquals(orderSummaryBeforeOrderCreation.get("DispatchedData"), orderSummaryAfterOrderCreation.get("DispatchedData"), "Dispatched assigned data is matched as expected");
        softAssert.assertEquals(orderSummaryBeforeOrderCreation.get("DeliveredData"), orderSummaryAfterOrderCreation.get("DeliveredData"), "Delivered data is matched as expected");
        softAssert.assertEquals(orderSummaryBeforeOrderCreation.get("FailedData"), orderSummaryAfterOrderCreation.get("FailedData"), "Failed Data is matched as expected");
        softAssert.assertEquals(orderSummaryBeforeOrderCreation.get("RemainingData"), orderSummaryAfterOrderCreation.get("RemainingData"), "Remaining data is matched as expected");

        viewOrdersPage.fillWithClear_SearchBar_Txt(orderId);

        softAssert.assertEquals(viewOrdersPage.get_FirstElementOrderId_Txt(), orderId, "Order id is matched as expected");
        softAssert.assertEquals(viewOrdersPage.get_FirstElementStatus_Lbl(), "Created", "Status is matched as expected");
        softAssert.assertEquals(viewOrdersPage.get_FirstElementNoOfShipment_Lbl(), "1", "No of Shipment is matched as expected");
        viewOrdersPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrdersPage.click_AssignRider_Btn();
        viewOrdersPage.click_AssignRiderDropDownManual_Opt();
        viewOrdersPage.click_AssignRiderDropDownManualRider_DropDown();
        viewOrdersPage.click_AssignRiderDropDownManualRiderDropDownData_Lbl();
        viewOrdersPage.click_AssignRiderDropDownManualAssign_Btn();
        ActionHelper.waitForLoaderToHide();

        HomePage.getInstance().openViewOrderPage();
        HashMap<String, String> orderSummaryAfterDispatchCreation = viewOrdersPage.getOrderSummary();

        softAssert.assertEquals(Integer.parseInt(orderSummaryAfterOrderCreation.get("ToBeAssignedData")), Integer.parseInt(orderSummaryAfterDispatchCreation.get("ToBeAssignedData")) + 1, "To be Assigned data is matched as expected");
        softAssert.assertEquals(Integer.parseInt(orderSummaryAfterOrderCreation.get("ToBeDispatchedData")), Integer.parseInt(orderSummaryAfterDispatchCreation.get("ToBeDispatchedData")), "To be dispatched data is matched as expected");
        softAssert.assertEquals(Integer.parseInt(orderSummaryAfterOrderCreation.get("DispatchedData")), Integer.parseInt(orderSummaryAfterDispatchCreation.get("DispatchedData")), "Dispatched data is matched as expected");
        softAssert.assertEquals(orderSummaryAfterOrderCreation.get("DeliveredData"), orderSummaryAfterDispatchCreation.get("DeliveredData"), "Delivered data is matched as expected");
        softAssert.assertEquals(orderSummaryAfterOrderCreation.get("FailedData"), orderSummaryAfterDispatchCreation.get("FailedData"), "Failed data is matched as expected");
        softAssert.assertEquals(orderSummaryAfterOrderCreation.get("RemainingData"), orderSummaryAfterDispatchCreation.get("RemainingData"), "Remaining data is matched as expected");

        homePage.openDispatchListPage();
        softAssert.assertTrue(DispatchPage.getInstance().isPresent_Header_Lbl(), "Header is present as expected");
        HashMap<String, String> dispatchSummaryAfterOrderCreation = DispatchPage.getInstance().getDispatchSummary();
        softAssert.assertEquals(dispatchPage.get_FirstElementStatus_Lbl(), "Assigned", "Status is matched as expected");
        softAssert.assertEquals(Integer.parseInt(dispatchSummaryBeforeOrderCreation.get("DispatchCount")), Integer.parseInt(dispatchSummaryAfterOrderCreation.get("DispatchCount")) - 1, "Dispatched Count is matched as expected");
        softAssert.assertEquals(Integer.parseInt(dispatchSummaryBeforeOrderCreation.get("AssignedCount")), Integer.parseInt(dispatchSummaryAfterOrderCreation.get("AssignedCount")) - 1, "Assigned count is matched as expected");
        softAssert.assertEquals(dispatchSummaryBeforeOrderCreation.get("StartedCount"), (dispatchSummaryAfterOrderCreation.get("StartedCount")), "started count is matched as expected");
        softAssert.assertEquals(dispatchSummaryBeforeOrderCreation.get("OngoingCount"), dispatchSummaryAfterOrderCreation.get("OngoingCount"), "Ongoing count is matched as expected");
        softAssert.assertEquals(dispatchSummaryBeforeOrderCreation.get("ClosedCount"), dispatchSummaryAfterOrderCreation.get("ClosedCount"), "Closed Count is matched as expected");

        softAssert.assertEquals(dispatchPage.get_FirstElementStatus_Lbl(), "Assigned", "Status is matched as expected");
        softAssert.assertEquals(Integer.parseInt(dispatchSummaryBeforeOrderCreation.get("DispatchCount")), Integer.parseInt(dispatchSummaryAfterOrderCreation.get("DispatchCount")) - 1, "Dispatched Count is matched as expected");
        softAssert.assertEquals(Integer.parseInt(dispatchSummaryBeforeOrderCreation.get("AssignedCount")), Integer.parseInt(dispatchSummaryAfterOrderCreation.get("AssignedCount")) - 1, "Assigned count is matched as expected");
        softAssert.assertEquals(dispatchSummaryBeforeOrderCreation.get("StartedCount"), (dispatchSummaryAfterOrderCreation.get("StartedCount")), "started count is matched as expected");
        softAssert.assertEquals(dispatchSummaryBeforeOrderCreation.get("OngoingCount"), dispatchSummaryAfterOrderCreation.get("OngoingCount"), "Ongoing count is matched as expected");
        softAssert.assertEquals(dispatchSummaryBeforeOrderCreation.get("ClosedCount"), dispatchSummaryAfterOrderCreation.get("ClosedCount"), "Closed Count is matched as expected");

        softAssert.assertEquals(dispatchPage.get_FirstElementStatus_Lbl(), "Assigned", "Status is matched as expected");
        softAssert.assertEquals(dispatchPage.get_FirstElementDeliveredCountStatus_Lbl(), "0", "Status is matched as expected");
        softAssert.assertEquals(dispatchPage.get_FirstElementFailedOrdersCountStatus_Lbl(), "0", "Status is matched as expected");
        softAssert.assertEquals(dispatchPage.get_FirstElementRemainingOrdersCountStatus_Lbl(), "1", "Status is matched as expected");

        DispatchPage.getInstance().select_FirstElement_Lbl();
        softAssert.assertEquals(dispatchDetailPage.get_DispatchStatus_Lbl(), "Assigned", "Status is matched as expected");
        softAssert.assertEquals(dispatchDetailPage.get_TotalShipmentCount_Lbl(), "1", "Count is matched as expected");
        softAssert.assertEquals(dispatchDetailPage.get_ExpectedCashInHand_Lbl(), orderAmount + ".00 INR", "Expected Cash In Hand is matched as expected");

        softAssert.assertEquals(dispatchDetailPage.get_FirstElementScannableId_Lbl(), orderId, "Order Id is matched as expected");
        softAssert.assertEquals(dispatchDetailPage.get_FirstElementStatus_Lbl(), "Assigned", "Status is matched as expected");
        dispatchDetailPage.click_PublishDispatch_Btn();
        dispatchDetailPage.click_ConfirmPublishDispatch_Btn();
        softAssert.assertEquals(dispatchDetailPage.get_DispatchStatus_Lbl(), "Started", "Status is matched as expected");
        softAssert.assertEquals(dispatchDetailPage.get_InventoryInHand_Lbl(), "0", "Inventory is matched as expected");
        softAssert.assertEquals(dispatchDetailPage.get_ExpectedCashInHand_Lbl(), orderAmount + ".00 INR", "Expected Cash In Hand is matched as expected");
        softAssert.assertEquals(dispatchDetailPage.get_CashInHand_Lbl(), "0", "Cash In Hand is matched as expected");

        softAssert.assertAll();
    }
}