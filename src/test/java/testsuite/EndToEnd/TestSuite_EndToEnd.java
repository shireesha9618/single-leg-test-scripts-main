package testsuite.EndToEnd;

import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.TestGroup;
import framework.backend.APIResponseException;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.actions.ActionHelper;
import framework.frontend.managers.DriverManager;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;
import java.util.HashMap;

public class TestSuite_EndToEnd extends BaseTestClass {
    CreateOrderPage createOrderPage = CreateOrderPage.getInstance();
    ViewOrdersPage viewOrdersPage=ViewOrdersPage.getInstance();
    DispatchDetailPage dispatchDetailPage=DispatchDetailPage.getInstance();
    DispatchPage dispatchPage=DispatchPage.getInstance();
    HomePage homePage=HomePage.getInstance();
    Faker sampleData = new Faker();

    @Test(groups = {TestGroup.SMOKE, TestGroup.REGRESSION},
            description = "Verify End to End Test Case",
            priority = 1)
    public void TC_EndToEnd_Verify_End_To_End_Flow() throws IOException, APIResponseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillCreateOrder();
        HashMap<String,String> orderSummaryBeforeOrderCreation=viewOrdersPage.getOrderSummary();
        HomePage.getInstance().openDispatchListPage();
        HashMap<String,String> dispatchSummaryBeforeOrderCreation=dispatchPage.getDispatchSummary();

        HomePage.getInstance().openCreateOrderPage();
        String orderId = String.valueOf(sampleData.number().digits(10));
        String description = ActionHelper.generateRandomName(6, 6);
        softAssert.assertTrue(createOrderPage.isPresent_Header_Lbl(), "Header Label is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_OrderId_TxtBox(), "Order Id is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_BarcodeNumber_TxtBox(), "Barcode Number Text Box is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_Description_TxtBox(), "Description textBox is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_Team_DropDown(), "Team Dropdown is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_PickupContactName_DropDown(), "Pickup Contact Name is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_PrimaryMobileNumber_TxtBox(), "Primary Mobile Number is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_DropContactName_TxtBox(), "Drop Contact Name is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_DropPrimaryMobileNumber_TxtBox(), "Drop Primary Mobile Number is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_SelectPaymentType_TxtBox(), "Select Payment Type is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_OrderAmount_TxtBox(), "Order Amount is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_Submit_Btn(), "Submit Button is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_Cancel_Btn(), "Cancel button is present as expected");

        createOrderPage.set_OrderId(orderId);
        softAssert.assertTrue(createOrderPage.get_BarcodeNumber_Txt() != null, "Barcode Label is not null as expected");

        createOrderPage.set_Description(description);
        createOrderPage.set_ContactName_TextBox(sampleData.name().firstName());
        createOrderPage.set_PrimaryMobileNumber_TxtBox(sampleData.phoneNumber().subscriberNumber(10));
        createOrderPage.validate_PickUpClear_Btn("208014", "Building1", "Street14");

        createOrderPage.validateAndCreateFacility("Pickup","208014");
        createOrderPage.set_PickUpFacility_TextBox("Gurgaon DC");

        createOrderPage.set_DropContactName_TextBox(sampleData.name().firstName());
        createOrderPage.set_DropMobileNumber_TextBox(sampleData.phoneNumber().subscriberNumber(10));
        createOrderPage.validate_DropClearAll_Btn("208014", "Building1", "Street15");

        createOrderPage.validateAndCreateFacility("Drop","250002");
        createOrderPage.set_DropFacility_TextBox("NoidaFacility");

        createOrderPage.selectByValue_OrderDetailsProductType_Select("Prepaid");
        createOrderPage.selectByValue_OrderDetailsProductType_Select("Collect At Delivery");
        String orderAmount=sampleData.number().digits(3);
        createOrderPage.set_OrderAmount(orderAmount);
        createOrderPage.click_Submit_Btn();
        viewOrdersPage.click_Refresh_Btn();
        HashMap<String,String> orderSummaryAfterOrderCreation=viewOrdersPage.getOrderSummary();

        softAssert.assertTrue(viewOrdersPage.isPresent_ViewOrdersHeader_Lbl(), "View Order Header Label is present as expected");
        softAssert.assertEquals(Integer.parseInt(orderSummaryBeforeOrderCreation.get("ToBeAssignedData")),Integer.parseInt(orderSummaryAfterOrderCreation.get("ToBeAssignedData"))-1,"To be assigned data is matched as expected");
        softAssert.assertEquals(orderSummaryBeforeOrderCreation.get("ToBeDispatchedData"),orderSummaryAfterOrderCreation.get("ToBeDispatchedData"),"To be dispatched data is matched as expected");
        softAssert.assertEquals(orderSummaryBeforeOrderCreation.get("DispatchedData"),orderSummaryAfterOrderCreation.get("DispatchedData"),"Dispatched assigned data is matched as expected");
        softAssert.assertEquals(orderSummaryBeforeOrderCreation.get("DeliveredData"),orderSummaryAfterOrderCreation.get("DeliveredData"),"Delivered data is matched as expected");
        softAssert.assertEquals(orderSummaryBeforeOrderCreation.get("FailedData"),orderSummaryAfterOrderCreation.get("FailedData"),"Failed Data is matched as expected");
        softAssert.assertEquals(orderSummaryBeforeOrderCreation.get("RemainingData"),orderSummaryAfterOrderCreation.get("RemainingData"),"Remaining data is matched as expected");

        ViewOrdersPage.getInstance().fill_Search_TxtField(orderId);

        softAssert.assertEquals(viewOrdersPage.get_FirstElementOrderId_Txt(), orderId, "Order id is matched as expected");
        softAssert.assertEquals(viewOrdersPage.get_FirstElementStatus_Lbl(), "Created", "Status is matched as expected");
        softAssert.assertEquals(viewOrdersPage.get_FirstElementNoOfShipment_Lbl(), "1", "No of Shipment is matched as expected");

        viewOrdersPage.click_TableOrderId_CheckBox();
        viewOrdersPage.click_AssignRider_Btn();
        viewOrdersPage.click_AssignRiderDropDownManual_Opt();
        viewOrdersPage.click_AssignRiderDropDownManualRider_DropDown();
        viewOrdersPage.click_AssignRiderDropDownManualRiderDropDownData_Lbl();
        viewOrdersPage.click_AssignRiderDropDownManualAssign_Btn();
        ActionHelper.waitForLoaderToHide();

        HomePage.getInstance().openViewOrderPage();
        HashMap<String,String> orderSummaryAfterDispatchCreation=viewOrdersPage.getOrderSummary();

        softAssert.assertEquals(Integer.parseInt(orderSummaryAfterOrderCreation.get("ToBeAssignedData")),Integer.parseInt(orderSummaryAfterDispatchCreation.get("ToBeAssignedData"))+1,"To be Assigned data is matched as expected");
        softAssert.assertEquals(Integer.parseInt(orderSummaryAfterOrderCreation.get("ToBeDispatchedData")),Integer.parseInt(orderSummaryAfterDispatchCreation.get("ToBeDispatchedData")),"To be dispatched data is matched as expected");
        softAssert.assertEquals(Integer.parseInt(orderSummaryAfterOrderCreation.get("DispatchedData")),Integer.parseInt(orderSummaryAfterDispatchCreation.get("DispatchedData")),"Dispatched data is matched as expected");
        softAssert.assertEquals(orderSummaryAfterOrderCreation.get("DeliveredData"),orderSummaryAfterDispatchCreation.get("DeliveredData"),"Delivered data is matched as expected");
        softAssert.assertEquals(orderSummaryAfterOrderCreation.get("FailedData"),orderSummaryAfterDispatchCreation.get("FailedData"),"Failed data is matched as expected");
        softAssert.assertEquals(orderSummaryAfterOrderCreation.get("RemainingData"),orderSummaryAfterDispatchCreation.get("RemainingData"),"Remaining data is matched as expected");

        homePage.openDispatchListPage();
        HashMap<String,String> dispatchSummaryAfterOrderCreation=DispatchPage.getInstance().getDispatchSummary();
        softAssert.assertEquals(dispatchPage.get_FirstElementStatus_Lbl(), "Assigned", "Status is matched as expected");
        softAssert.assertEquals(Integer.parseInt(dispatchSummaryBeforeOrderCreation.get("DispatchCount")), Integer.parseInt(dispatchSummaryAfterOrderCreation.get("DispatchCount"))-1, "Dispatched Count is matched as expected");
        softAssert.assertEquals(Integer.parseInt(dispatchSummaryBeforeOrderCreation.get("AssignedCount")), Integer.parseInt(dispatchSummaryAfterOrderCreation.get("AssignedCount"))-1, "Assigned count is matched as expected");
        softAssert.assertEquals(dispatchSummaryBeforeOrderCreation.get("StartedCount"), (dispatchSummaryAfterOrderCreation.get("StartedCount")), "started count is matched as expected");
        softAssert.assertEquals(dispatchSummaryBeforeOrderCreation.get("OngoingCount"), dispatchSummaryAfterOrderCreation.get("OngoingCount"), "Ongoing count is matched as expected");
        softAssert.assertEquals(dispatchSummaryBeforeOrderCreation.get("ClosedCount"), dispatchSummaryAfterOrderCreation.get("ClosedCount"), "Closed Count is matched as expected");

        DriverManager.getDriver().navigate().refresh();
        softAssert.assertEquals(dispatchPage.get_FirstElementStatus_Lbl(), "Assigned", "Status is matched as expected");
        softAssert.assertEquals(Integer.parseInt(dispatchSummaryBeforeOrderCreation.get("DispatchCount")), Integer.parseInt(dispatchSummaryAfterOrderCreation.get("DispatchCount"))-1, "Dispatched Count is matched as expected");
        softAssert.assertEquals(Integer.parseInt(dispatchSummaryBeforeOrderCreation.get("AssignedCount")), Integer.parseInt(dispatchSummaryAfterOrderCreation.get("AssignedCount"))-1, "Assigned count is matched as expected");
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
        softAssert.assertEquals(dispatchDetailPage.get_ExpectedCashInHand_Lbl(),orderAmount+".00 INR" , "Expected Cash In Hand is matched as expected");

        softAssert.assertEquals(dispatchDetailPage.get_FirstElementScannableId_Lbl(), orderId, "Order Id is matched as expected");
        softAssert.assertEquals(dispatchDetailPage.get_FirstElementStatus_Lbl(), "Assigned", "Status is matched as expected");
        dispatchDetailPage.click_PublishDispatch_Btn();
        dispatchDetailPage.click_ConfirmPublishDispatch_Btn();
        softAssert.assertEquals(dispatchDetailPage.get_DispatchStatus_Lbl(), "Started", "Status is matched as expected");
        softAssert.assertEquals(dispatchDetailPage.get_InventoryInHand_Lbl(), "0", "Inventory is matched as expected");
        softAssert.assertEquals(dispatchDetailPage.get_ExpectedCashInHand_Lbl(),orderAmount+".00 INR" , "Expected Cash In Hand is matched as expected");
        softAssert.assertEquals(dispatchDetailPage.get_CashInHand_Lbl(), "0", "Cash In Hand is matched as expected");

        softAssert.assertAll();
    }
}
