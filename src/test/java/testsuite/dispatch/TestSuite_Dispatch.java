package testsuite.dispatch;

import api.ApiClient;
import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.TestGroup;
import framework.backend.APIResponseException;
import framework.common.assertion.JarvisAssert;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.actions.ActionHelper;
import framework.utils.APIClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;
import java.util.HashMap;

public class TestSuite_Dispatch extends BaseTestClass {
    CreateOrderPage createOrderPage = CreateOrderPage.getInstance();
    Faker sampleData = new Faker();

    @Test(groups = {TestGroup.SMOKE, TestGroup.REGRESSION},
            description = "Verify The UI Of Home Page",
            priority = 1)
    public void TC_Home_001_Verify_The_UI_Of_Home_Page() throws IOException, APIResponseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillCreateOrder();
        String orderId = "29379841321768769";
        String description = ActionHelper.generateRandomName(6, 6);
        softAssert.assertTrue(createOrderPage.isPresent_Header_Lbl(), "Header Label is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_OrderId_TxtBox(), "Order Id is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_BarcodeNumber_TxtBox(), "Barcode Number Text Box is present as expected");
        softAssert.assertTrue(createOrderPage.isPresent_Description_TxtBox(), "present4");
        softAssert.assertTrue(createOrderPage.isPresent_Team_DropDown(), "present5");
        softAssert.assertTrue(createOrderPage.isPresent_PickupContactName_DropDown(), "present6");
        softAssert.assertTrue(createOrderPage.isPresent_PrimaryMobileNumber_TxtBox(), "present7");
        softAssert.assertTrue(createOrderPage.isPresent_DropContactName_TxtBox(), "DSFdsa");
        softAssert.assertTrue(createOrderPage.isPresent_DropPrimaryMobileNumber_TxtBox(), "present8");
        softAssert.assertTrue(createOrderPage.isPresent_SelectPaymentType_TxtBox(), "present9");
        softAssert.assertTrue(createOrderPage.isPresent_OrderAmount_TxtBox(), "DSFdsa");
        softAssert.assertTrue(createOrderPage.isPresent_Submit_Btn(), "DSFdsa");
        softAssert.assertTrue(createOrderPage.isPresent_Cancel_Btn(), "present11");

        createOrderPage.set_OrderId(orderId);
        softAssert.assertTrue(createOrderPage.get_BarcodeNumber_Txt() != null, "Barcode Label is not null as expected");

        createOrderPage.set_Description(description);
        createOrderPage.set_ContactName_TextBox(sampleData.name().firstName());
        createOrderPage.set_PrimaryMobileNumber_TxtBox(sampleData.phoneNumber().subscriberNumber(10));
//        createOrderPage.validateAddFacility("Pickup");
//        createOrderPage.validateAddFacility("Drop");
        createOrderPage.validate_PickUpClear_Btn("208014", "SASD", "Adadsad");

        createOrderPage.set_PickUpFacility_TextBox("Gurgaon DC");

        createOrderPage.set_DropContactName_TextBox(sampleData.name().firstName());
        createOrderPage.set_DropMobileNumber_TextBox(sampleData.phoneNumber().subscriberNumber(10));
        createOrderPage.validate_DropClearAll_Btn("208014", "SASD", "Adadsad");

        createOrderPage.set_DropFacility_TextBox("NoidaFacility");



        ActionHelper.gotoSleep(4000);

        createOrderPage.selectByValue_OrderDetailsProductType_Select("Collect At Delivery");//sperate fuction
        String orderAmount=sampleData.number().digits(3);
        createOrderPage.set_OrderAmount(orderAmount);
        createOrderPage.click_Submit_Btn();
        ViewOrdersPage.getInstance().click_Refresh_Btn();
        softAssert.assertTrue(ViewOrdersPage.getInstance().isPresent_ViewOrdersHeader_Lbl(), "View Order Header Label is present as expected");
        softAssert.assertEquals(ViewOrdersPage.getInstance().getText_ToBeAssignData_Lbl(),"1","matched");
        softAssert.assertEquals(ViewOrdersPage.getInstance().getText_ToBeDispatchedData_Lbl(),"0","matched");
        softAssert.assertEquals(ViewOrdersPage.getInstance().getText_DispatchedData_Lbl(),"0","matched");
        softAssert.assertEquals(ViewOrdersPage.getInstance().getText_DeliveredData_Lbl(),"0","matched");
        softAssert.assertEquals(ViewOrdersPage.getInstance().getText_FailedData_Lbl(),"0","matched");
        softAssert.assertEquals(ViewOrdersPage.getInstance().getText_RemainingData_Lbl(),"0","matched");


        ViewOrdersPage.getInstance().fill_Search_TxtField(orderId);

        softAssert.assertEquals(ViewOrdersPage.getInstance().get_FirstElementOrderId_Txt(), orderId, "Order id is matched as expected");
        softAssert.assertEquals(ViewOrdersPage.getInstance().get_FirstElementStatus_Lbl(), "Created", "Status is matched as expected");
        softAssert.assertEquals(ViewOrdersPage.getInstance().get_FirstElementNoOfShipment_Lbl(), "1", "No of Shipment is matched as expected");

        ViewOrdersPage.getInstance().click_TableOrderId_CheckBox();
        ViewOrdersPage.getInstance().click_AssignRider_Btn();
        ViewOrdersPage.getInstance().click_AssignRiderDropDownManual_Opt();
        ViewOrdersPage.getInstance().click_AssignRiderDropDownManualRider_DropDown();
        ViewOrdersPage.getInstance().click_AssignRiderDropDownManualRiderDropDownData_Lbl();
        ViewOrdersPage.getInstance().click_AssignRiderDropDownManualAssign_Btn();
        ActionHelper.waitForLoaderToHide();

        HomePage.getInstance().openViewOrderPage();
        softAssert.assertEquals(ViewOrdersPage.getInstance().getText_ToBeAssignData_Lbl(), "0", "matched");
        softAssert.assertEquals(ViewOrdersPage.getInstance().getText_ToBeDispatchedData_Lbl(), "1", "matched");
        softAssert.assertEquals(ViewOrdersPage.getInstance().getText_DispatchedData_Lbl(), "1", "matched");
        softAssert.assertEquals(ViewOrdersPage.getInstance().getText_DeliveredData_Lbl(), "0", "matched");
        softAssert.assertEquals(ViewOrdersPage.getInstance().getText_FailedData_Lbl(), "0", "matched");
        softAssert.assertEquals(ViewOrdersPage.getInstance().getText_RemainingData_Lbl(), "1", "matched");

        HomePage.getInstance().openDispatchListPage();
        softAssert.assertEquals(DispatchPage.getInstance().get_DispatchCount_Lbl(), "1", "matched");
        softAssert.assertEquals(DispatchPage.getInstance().get_AssignedCount_Lbl(), "0", "matched");
        softAssert.assertEquals(DispatchPage.getInstance().get_StartedCount_Lbl(), "1", "matched");
        softAssert.assertEquals(DispatchPage.getInstance().get_OngoingCount_Lbl(), "0", "matched");
        softAssert.assertEquals(DispatchPage.getInstance().get_ClosedCount_Lbl(), "0", "matched");
        softAssert.assertEquals(DispatchPage.getInstance().get_FirstElementStatus_Lbl(), "Created", "Status is matched as expected");
        softAssert.assertEquals(DispatchPage.getInstance().get_FirstElementDeliveredCountStatus_Lbl(), "0", "Status is matched as expected");
        softAssert.assertEquals(DispatchPage.getInstance().get_FirstElementFailedOrdersCountStatus_Lbl(), "0", "Status is matched as expected");
        softAssert.assertEquals(DispatchPage.getInstance().get_FirstElementRemainingOrdersCountStatus_Lbl(), "1", "Status is matched as expected");

        DispatchPage.getInstance().select_FirstElement_Lbl();
        softAssert.assertEquals(DispatchDetailPage.getInstance().get_DispatchStatus_Lbl(), "Assigned", "Status is matched as expected");
        softAssert.assertEquals(DispatchDetailPage.getInstance().get_TotalShipmentCount_Lbl(), "1", "Count is matched as expected");
        softAssert.assertEquals(DispatchDetailPage.getInstance().get_ExpectedCashInHand_Lbl(),orderAmount+".00 INR" , "Expected Cash In Hand is matched as expected");

        softAssert.assertEquals(DispatchDetailPage.getInstance().get_FirstElementScannableId_Lbl(), orderId, "Order Id is matched as expected");
        softAssert.assertEquals(DispatchDetailPage.getInstance().get_FirstElementStatus_Lbl(), "Assigned", "Status is matched as expected");
        DispatchDetailPage.getInstance().click_PublishDispatch_Btn();
//        softAssert.assertTrue(DispatchDetailPage.getInstance().isPresent_ConfirmPublishDispatchHeader_Lbl(),"Confirm Dispatch Header is present as expected");
        DispatchDetailPage.getInstance().click_ConfirmPublishDispatch_Btn();
        softAssert.assertEquals(DispatchDetailPage.getInstance().get_DispatchStatus_Lbl(), "Started", "Status is matched as expected");
        softAssert.assertEquals(DispatchDetailPage.getInstance().get_InventoryInHand_Lbl(), "0", "Inventory is matched as expected");
        softAssert.assertEquals(DispatchDetailPage.getInstance().get_ExpectedCashInHand_Lbl(),orderAmount+".00 INR" , "Expected Cash In Hand is matched as expected");
        softAssert.assertEquals(DispatchDetailPage.getInstance().get_CashInHand_Lbl(), "0", "Cash In Hand is matched as expected");

        softAssert.assertAll();




    }
}
