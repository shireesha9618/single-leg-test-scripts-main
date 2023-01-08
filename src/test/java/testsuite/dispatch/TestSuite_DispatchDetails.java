package testsuite.dispatch;

import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.DispatchDetailPage;
import pageobjects.DispatchPage;
import pageobjects.HomePage;
import pageobjects.ScanPage;

public class TestSuite_DispatchDetails {

    CommonActions commonActions = CommonActions.getInstance();
    DispatchPage dispatchPage = DispatchPage.getInstance();
    DispatchDetailPage dispatchDetailPage = DispatchDetailPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    ScanPage scanPage = ScanPage.getInstance();

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_001, Verify UI Of Dispatch Record/Detail For Assigned Status")
    public void TC_DispatchDetail_001_Verify_UI_Of_Dispatch_Record_Detail_For_Assigned_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.statusDropdownUnselectAll();
        dispatchPage.checkCheckbox_StatusDropdownAssigned_Checkbox();
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(0);
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(0);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);

        softAssert.assertTrue(dispatchDetailPage.isPresent_dispatchDetailBreadCrumb_Link(), "Validate presence of Dispatch Detail breadcrumb");
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertEquals(dispatchDetailPage.getText_DispatchStatus_Lbl(), status, "Validate status");
        softAssert.assertTrue(dispatchDetailPage.isPresent_SearchBar_Txt(), "Validate presence of Search bar");
        softAssert.assertTrue(dispatchDetailPage.isPresent_Status_Dropdown(), "Validate presence of Status dropdown");
        softAssert.assertTrue(dispatchDetailPage.isPresent_ScanToAddOrders_Btn(), "Validate presence of Scan To Add Orders button");
        softAssert.assertTrue(dispatchDetailPage.isPresent_DownloadRunSheet_Btn(), "Validate presence of Download Run Sheet button");
        softAssert.assertTrue(dispatchDetailPage.isPresent_Refresh_Btn(), "Validate presence of Refresh button");
        for (String text : dispatchDetailPage.getText_ShipmentDetailsTableColumnStatus_ListLbl())
            softAssert.assertEquals(text, "Assigned", "Validate status of Orders");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_002, Verify UI Of Dispatch Record/Detail For Started Status")
    public void TC_DispatchDetail_002_Verify_UI_Of_Dispatch_Record_Detail_For_Started_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.statusDropdownUnselectAll();
        dispatchPage.checkCheckbox_StatusDropdownStarted_Checkbox();
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(0);
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(0);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);

        softAssert.assertTrue(dispatchDetailPage.isPresent_dispatchDetailBreadCrumb_Link(), "Validate presence of Dispatch Detail breadcrumb");
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertEquals(dispatchDetailPage.getText_DispatchStatus_Lbl(), status, "Validate status");
        softAssert.assertTrue(dispatchDetailPage.isPresent_SearchBar_Txt(), "Validate presence of Search bar");
        softAssert.assertTrue(dispatchDetailPage.isPresent_Status_Dropdown(), "Validate presence of Status dropdown");
        softAssert.assertTrue(dispatchDetailPage.isPresent_ScanToAddOrders_Btn(), "Validate presence of Scan To Add Orders button");
        softAssert.assertTrue(dispatchDetailPage.isPresent_DownloadRunSheet_Btn(), "Validate presence of Download Run Sheet button");
        softAssert.assertTrue(dispatchDetailPage.isPresent_Refresh_Btn(), "Validate presence of Refresh button");
        for (String text : dispatchDetailPage.getText_ShipmentDetailsTableColumnStatus_ListLbl())
            softAssert.assertEquals(text, "Assigned", "Validate status of Orders");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_003, Verify Functionality Of Small edit icon in dispatch details page")
    public void TC_DispatchDetail_003_Verify_Functionality_Of_Small_edit_icon_in_dispatch_details_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.statusDropdownUnselectAll();
        dispatchPage.checkCheckbox_StatusDropdownAssigned_Checkbox();
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(0);
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(0);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertEquals(dispatchDetailPage.getText_DispatchStatus_Lbl(), status, "Validate status");
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupHeader_Lbl(), "Validate Assign Rider header");
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupCross_Img(), "Validate Cross icon");
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupVehicleMode_Txt(), "Validate Vehicle Mode dropdown");
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupVehicleId_Txt(), "Validate Vehicle Id dropdown");
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupRider_Txt(), "Validate Rider dropdown");
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupCancel_Btn(), "Validate Cancel button");
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupAssign_Btn(), "Validate Assign button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_004, Verify Functionality Of (X) in Assign Rider page")
    public void TC_DispatchDetail_004_Verify_Functionality_Of_X_in_Assign_Rider_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.statusDropdownUnselectAll();
        dispatchPage.checkCheckbox_StatusDropdownAssigned_Checkbox();
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(0);
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(0);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertEquals(dispatchDetailPage.getText_DispatchStatus_Lbl(), status, "Validate status");
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkCross_Icon();
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_005, Verify Functionality Of Cancel button in Assign Rider page")
    public void TC_DispatchDetail_005_Verify_Functionality_Of_Cancel_button_in_Assign_Rider_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.statusDropdownUnselectAll();
        dispatchPage.checkCheckbox_StatusDropdownAssigned_Checkbox();
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(0);
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(0);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertEquals(dispatchDetailPage.getText_DispatchStatus_Lbl(), status, "Validate status");
        dispatchDetailPage.click_AssignRiderPopupCancel_Btn();
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_006, Verify Functionality Of Assign button in Assign Rider page")
    public void TC_DispatchDetail_006_Verify_Functionality_Of_Assign_button_in_Assign_Rider_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.statusDropdownUnselectAll();
        dispatchPage.checkCheckbox_StatusDropdownAssigned_Checkbox();
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(0);
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(0);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertEquals(dispatchDetailPage.getText_DispatchStatus_Lbl(), status, "Validate status");
        dispatchDetailPage.click_AssignRiderPopupAssign_Btn();
        dispatchDetailPage.getText_AssignRiderPopupOptions_ListBtn(0);
        dispatchDetailPage.click_AssignRiderPopupAssign_Btn();
        softAssert.assertTrue(dispatchDetailPage.isPresent_SuccessfullyUpdatedPopup_Lbl(), "Validate presence of Success toast msg");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_007, Verify The Functionality Of Refresh Button of Dispatch Detail page")
    public void TC_DispatchDetail_007_Verify_The_Functionality_Of_Refresh_Button_of_Dispatch_Detail_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(0);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        dispatchDetailPage.click_Refresh_Btn();
        softAssert.assertTrue(dispatchDetailPage.isPresent_ReloadingDispatchDataPopup_Lbl(), "Validate presence of reloading dispatch data toast msg");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_008, Verify Functionality Of Remove From Dispatch Button In Dispatch Detail")
    public void TC_DispatchDetail_008_Verify_Functionality_Of_Remove_From_Dispatch_Button_In_Dispatch_Detail() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.statusDropdownUnselectAll();
        dispatchPage.checkCheckbox_StatusDropdownAssigned_Checkbox();
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(0);
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(0);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertEquals(dispatchDetailPage.getText_DispatchStatus_Lbl(), status, "Validate status");
        int size = dispatchDetailPage.getList_ShipmentDetailsTableColumnCheckbox_ListCheckbox().size();
        dispatchDetailPage.checkCheckbox_ShipmentDetailsTableColumnCheckbox_ListCheckbox(0);
        dispatchDetailPage.click_RemoveFromDispatch_Btn();
        softAssert.assertEquals(dispatchDetailPage.getList_ShipmentDetailsTableColumnCheckbox_ListCheckbox().size(), size - 1, "Validate no of shipments");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_010, Verify UI Of Publish Dispatch In Dispatch Detail")
    public void TC_DispatchDetail_010_Verify_UI_Of_Publish_Dispatch_In_Dispatch_Detail() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.statusDropdownUnselectAll();
        dispatchPage.checkCheckbox_StatusDropdownAssigned_Checkbox();
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(0);
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(0);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertEquals(dispatchDetailPage.getText_DispatchStatus_Lbl(), status, "Validate status");
        dispatchDetailPage.click_PublishDispatch_Btn();
        softAssert.assertTrue(dispatchDetailPage.isPresent_PublishDispatchCancel_Btn(), "Validate presence of Cancel button");
        softAssert.assertTrue(dispatchDetailPage.isPresent_ConfirmPublishDispatchHeader_Lbl(), "Validate presence of Publish Dispatch button");
        dispatchDetailPage.click_PublishDispatchCancel_Btn();
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_011, Verify Functionality Of Publish Dispatch In Dispatch Detail/Verify Functionality To Assign A Dispatch")
    public void TC_DispatchDetail_011_Verify_Functionality_Of_Publish_Dispatch_In_Dispatch_Detail_Verify_Functionality_To_Assign_A_Dispatch() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.statusDropdownUnselectAll();
        dispatchPage.checkCheckbox_StatusDropdownAssigned_Checkbox();
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(0);
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(0);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertEquals(dispatchDetailPage.getText_DispatchStatus_Lbl(), status, "Validate status");
        dispatchDetailPage.click_PublishDispatch_Btn();
        dispatchDetailPage.click_ConfirmPublishDispatch_Btn();
        softAssert.assertEquals(dispatchDetailPage.getText_DispatchStatus_Lbl(), "Started", "Validate status");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_012, Verify UI Of Scan To Add Jobs In Dispatch Detail")
    public void TC_DispatchDetail_012_Verify_UI_Of_Scan_To_Add_Jobs_In_Dispatch_Detail() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.statusDropdownUnselectAll();
        dispatchPage.checkCheckbox_StatusDropdownStarted_Checkbox();
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(0);
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(0);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertEquals(dispatchDetailPage.getText_DispatchStatus_Lbl(), status, "Validate status");
        dispatchDetailPage.click_ScanToAddOrders_Btn();
        softAssert.assertTrue(scanPage.isPresent_InventoryInHand_Lbl(), "Validate presence of Inventory In Hand lbl");
        softAssert.assertTrue(scanPage.isPresent_ExpectedCashToBeCollected_Lbl(), "Validate presence of Expected Cash To Be Collected lbl");
        softAssert.assertTrue(scanPage.isPresent_EnterShipmentId_Txt(), "Validate presence of Enter Shipment ID txt");
        softAssert.assertTrue(scanPage.isPresent_AddToDispatch_Btn(), "Validate presence of Add To Dispatch btn");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_019, Verify Displaying Of Facilities Table Records As Per Pagination Value")
    public void TC_DispatchDetail_019_Verify_Displaying_Of_Facilities_Table_Records_As_Per_Pagination_Value() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(0);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");

        dispatchDetailPage.clickAndChoose_PaginationDropDownOptions_Btn(10);
        softAssert.assertTrue(dispatchDetailPage.getList_ShipmentDetailsTableColumnOrderId_ListLbl().size() <= 10, "Validate records present are not more than 10");
        dispatchDetailPage.clickAndChoose_PaginationDropDownOptions_Btn(20);
        softAssert.assertTrue(dispatchDetailPage.getList_ShipmentDetailsTableColumnOrderId_ListLbl().size() <= 20, "Validate records present are not more than 20");
        dispatchDetailPage.clickAndChoose_PaginationDropDownOptions_Btn(50);
        softAssert.assertTrue(dispatchDetailPage.getList_ShipmentDetailsTableColumnOrderId_ListLbl().size() <= 50, "Validate records present are not more than 50");
        dispatchDetailPage.clickAndChoose_PaginationDropDownOptions_Btn(100);
        softAssert.assertTrue(dispatchDetailPage.getList_ShipmentDetailsTableColumnOrderId_ListLbl().size() <= 100, "Validate records present are not more than 100");
        softAssert.assertAll();
    }
}
