package testsuite.dispatch;

import base.BaseTestClass;
import constants.TestGroup;
import framework.backend.APIResponseException;
import framework.common.assertion.JarvisSoftAssert;
import org.testng.annotations.Test;
import pageobjects.*;
import utility.Utility;

import java.io.IOException;
import java.util.List;

public class TestSuite_DispatchDetails extends BaseTestClass {

    CommonActions commonActions = CommonActions.getInstance();
    DispatchPage dispatchPage = DispatchPage.getInstance();
    DispatchDetailPage dispatchDetailPage = DispatchDetailPage.getInstance();
    ScanPage scanPage = ScanPage.getInstance();
    AddOrdersPage addOrdersPage = new AddOrdersPage();
    AddToDispatchPage addToDispatchPage = new AddToDispatchPage();

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
        dispatchDetailPage.click_Edit_Img();

        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupCross_Img(), "Validate Cross icon");
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupVehicleMode_Txt(), "Validate Vehicle Mode dropdown");
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupVehicleId_Txt(), "Validate Vehicle Id dropdown");
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupRider_Txt(), "Validate Rider dropdown");
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupCancel_Btn(), "Validate Cancel button");
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupAssign_Btn(), "Validate Assign button");
        dispatchDetailPage.click_Cancel_Btn();
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_004, Verify Functionality Of (X) in Assign Rider page")
    public void TC_DispatchDetail_004_Verify_Functionality_Of_X_in_Assign_Rider_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.statusDropdownUnselectAll();
        dispatchPage.checkCheckbox_StatusDropdownAssigned_Checkbox();
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(1);
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(1);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(1);
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertEquals(dispatchDetailPage.getText_DispatchStatus_Lbl(), status, "Validate status");
        dispatchDetailPage.click_Edit_Img();
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupHeader_Lbl(),"Edit Assignment Pop header label is present as expected");
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
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(1);
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(1);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(1);
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertEquals(dispatchDetailPage.getText_DispatchStatus_Lbl(), status, "Validate status");
        dispatchDetailPage.click_Edit_Img();
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupHeader_Lbl(),"Edit Assignment Pop header label is present as expected");
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
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(1);
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(1);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(1);
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header");
        softAssert.assertEquals(dispatchDetailPage.getText_DispatchStatus_Lbl(), status, "Validate status");
        dispatchDetailPage.click_Edit_Img();
        softAssert.assertTrue(dispatchDetailPage.isPresent_AssignRiderPopupHeader_Lbl(),"Edit Assignment Pop header label is present as expected");

        dispatchDetailPage.select_PopUpVehicleId_As("AP03XYZ");
        dispatchDetailPage.select_PopUpRider_As("Refugio");
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
    public void TC_DispatchDetail_008_Verify_Functionality_Of_Remove_From_Dispatch_Button_In_Dispatch_Detail() throws IOException, APIResponseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();
        dispatchPage.uncheckCheckbox_StatusDropdownClosed_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownOngoing_Checkbox();
        dispatchPage.checkCheckbox_StatusDropdownAssigned_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownStarted_Checkbox();
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);

        commonActions.chooseNoOfRecordsToBeDisplayedPerPage(50);

        int numberOfOrdersPresent = dispatchPage.getList_ShipmentDetailsTableColumnRider_ListLink().size();
        List<String> orderIds = CommonActions.createOrdersGetIdsAsList(2 - numberOfOrdersPresent);

        addOrdersPage.fill_SearchByOrderIdOnScanOrdersPage_TxtBox(orderIds);
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
        int statusIndex  = dispatchPage.getValue_IndexOfStatusListLbl_Txt("Assigned");
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(statusIndex);
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(statusIndex);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(statusIndex);
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
        int statusIndex  = dispatchPage.getValue_IndexOfStatusListLbl_Txt("Assigned");
        String status = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl(statusIndex);
        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(statusIndex);
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(statusIndex);
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
        softAssert.assertTrue(commonActions.getWebElementList_TableDataList_Lbl("ORDER ID").size() <= 10, "Validate records present are not more than 10");
        dispatchDetailPage.clickAndChoose_PaginationDropDownOptions_Btn(20);
        softAssert.assertTrue(commonActions.getWebElementList_TableDataList_Lbl("ORDER ID").size() <= 20, "Validate records present are not more than 20");
        dispatchDetailPage.clickAndChoose_PaginationDropDownOptions_Btn(50);
        softAssert.assertTrue(commonActions.getWebElementList_TableDataList_Lbl("ORDER ID").size() <= 50, "Validate records present are not more than 50");
        dispatchDetailPage.clickAndChoose_PaginationDropDownOptions_Btn(100);
        softAssert.assertTrue(commonActions.getWebElementList_TableDataList_Lbl("ORDER ID").size() <= 100, "Validate records present are not more than 100");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_013, Verify UI Of Add To Dispatch Button On Dispatch Scan")
    public void TC_DispatchDetail_013_Verify_UI_Of_Add_To_Dispatch_Button_On_Dispatch_Scan() throws IOException, APIResponseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        String orderId = CommonActions.createAnOrderGetOrderID();
        commonActions.coverJourneyTillDispatches();
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(1);
        softAssert.assertTrue(dispatchDetailPage.isPresent_dispatchDetailBreadCrumb_Link(), "Validate presence of Dispatch Detail breadcrumb");
        dispatchDetailPage.click_ScanToAddOrders_Btn();
        addOrdersPage.fill_SearchByOrderId_TxtBox(orderId);
        softAssert.assertTrue(addOrdersPage.isEnabled_Dispatch_Btn(), "Add to Dispatch button is enabled as expected");
        addOrdersPage.click_AddToDispatch_Btn();
        softAssert.assertTrue(addToDispatchPage.isPresent_Header_lbl(), "Add to dispatch header is present as expected");
        softAssert.assertTrue(addToDispatchPage.isPresent_AddToDispatch_Btn(), "Add to dispatch button is present as expected");
        softAssert.assertTrue(addToDispatchPage.isPresent_Cancel_Btn(), "Cancel button is present as expected");
        addToDispatchPage.click_Cancel_Btn();
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_014, Verify Functionality Of Add To Dispatch Button On Dispatch Scan")
    public void TC_DispatchDetail_014_Verify_Functionality_Of_Add_To_Dispatch_Button_On_Dispatch_Scan() throws IOException, APIResponseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        String orderId = CommonActions.createAnOrderGetOrderID();
        commonActions.coverJourneyTillDispatches();
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(1);
        softAssert.assertTrue(dispatchDetailPage.isPresent_dispatchDetailBreadCrumb_Link(), "Validate presence of Dispatch Detail breadcrumb");
        dispatchDetailPage.click_ScanToAddOrders_Btn();
        addOrdersPage.fill_SearchByOrderId_TxtBox(orderId);
        softAssert.assertTrue(addOrdersPage.isEnabled_Dispatch_Btn(), "Add to Dispatch button is enabled as expected");
        addOrdersPage.click_AddToDispatch_Btn();
        softAssert.assertTrue(addToDispatchPage.isPresent_Header_lbl(), "Add to dispatch header is present as expected");

        addToDispatchPage.click_AddToDispatch_Btn();
        dispatchDetailPage.fillWithClear_SearchBar_Txt(orderId);
        softAssert.assertEquals(dispatchDetailPage.getValue_OrderId_Txt(0), orderId, "The Added order is added to dispatch as expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_015, Verify Functionality Of Scan Packages On Dispatch Scan With Valid Data")
    public void TC_DispatchDetail_015_Verify_Functionality_Of_Scan_Packages_On_Dispatch_Scan_With_Valid_Data() throws IOException, APIResponseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        String orderIdOne = CommonActions.createAnOrderGetOrderID();
        String orderIdTwo = CommonActions.createAnOrderGetOrderID();
        System.out.println(orderIdTwo + " " + orderIdOne);
        commonActions.coverJourneyTillDispatches();
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(1);
        softAssert.assertTrue(dispatchDetailPage.isPresent_dispatchDetailBreadCrumb_Link(), "Validate presence of Dispatch Detail breadcrumb");
        dispatchDetailPage.click_ScanToAddOrders_Btn();
        addOrdersPage.fill_SearchByOrderId_TxtBox(orderIdOne);
        softAssert.assertTrue(addOrdersPage.isEnabled_Dispatch_Btn(), "Add to Dispatch button is enabled as expected");
        softAssert.assertEquals(scanPage.get_NoOfPackageScanned_Txt(), "1 package scanned. Continue scanning to add more", "Package added text is showing as expected");
        addOrdersPage.fill_SearchByOrderId_TxtBox(orderIdTwo);
        softAssert.assertEquals(scanPage.get_NoOfPackageScanned_Txt(), "2 packages scanned. Continue scanning to add more", "Newly scanned Package added text is showing as expected");
        addOrdersPage.clickOn_RemoveOrder_Btn(1);
        softAssert.assertEquals(scanPage.get_NoOfPackageScanned_Txt(), "1 package scanned. Continue scanning to add more", "Package added text is showing as expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_016, Verify Functionality Of Scan Packages On Dispatch Scan With Valid Data")
    public void TC_DispatchDetail_016_Verify_Functionality_Of_Scan_Packages_On_Dispatch_Scan_With_InValid_Data() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();

        commonActions.coverJourneyTillDispatches();
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(1);
        softAssert.assertTrue(dispatchDetailPage.isPresent_dispatchDetailBreadCrumb_Link(), "Validate presence of Dispatch Detail breadcrumb");
        String orderId = dispatchDetailPage.getValue_OrderId_Txt(0);
        dispatchDetailPage.click_ScanToAddOrders_Btn();
        addOrdersPage.fill_SearchByOrderId_TxtBox(orderId);

        softAssert.assertContainsIgnoreCase(scanPage.getText_PopUpMessage_Txt(), "package_error", "Error pop up message when you added order which is already part of another dispatch is present as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_017 & TC_018, Verify Functionality Of Next Page Pagination Button")
    public void TC_DispatchDetail_017_And_TC_018_Verify_Functionality_Of_Next_Page_Pagination_Button() throws IOException, APIResponseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();
        dispatchPage.uncheckCheckbox_StatusDropdownClosed_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownOngoing_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownAssigned_Checkbox();
        dispatchPage.checkCheckbox_StatusDropdownStarted_Checkbox();
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        commonActions.chooseNoOfRecordsToBeDisplayedPerPage(50);

        int numberOfOrdersPresent = dispatchPage.getList_ShipmentDetailsTableColumnRider_ListLink().size();
        List<String> orderIds = CommonActions.createOrdersGetIdsAsList(11 - numberOfOrdersPresent);

        softAssert.assertTrue(dispatchDetailPage.isPresent_dispatchDetailBreadCrumb_Link(), "Validate presence of Dispatch Detail breadcrumb");
        addOrdersPage.fill_SearchByOrderIdOnScanOrdersPage_TxtBox(orderIds);
        commonActions.chooseNoOfRecordsToBeDisplayedPerPage(10);
        commonActions.click_PaginationNext_Btn();
        softAssert.assertTrue(dispatchDetailPage.isPresent_OrderId_Txt(), "Next page button is working as expected");
        commonActions.click_PaginationPrevious_Btn();
        softAssert.assertTrue(dispatchDetailPage.isPresent_OrderId_Txt(), "Previous page button is working as expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_020 & TC_021, Verify Functionality Of Pagination Paging Block With Next And Previous Button")
    public void TC_DispatchDetail_020_And_TC_021_Verify_Functionality_Of_Pagination_Paging_Block_With_Next_And_Previous_Button() throws IOException, APIResponseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();
        dispatchPage.uncheckCheckbox_StatusDropdownClosed_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownOngoing_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownAssigned_Checkbox();
        dispatchPage.checkCheckbox_StatusDropdownStarted_Checkbox();
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        commonActions.chooseNoOfRecordsToBeDisplayedPerPage(50);

        int numberOfOrdersPresent = dispatchPage.getList_ShipmentDetailsTableColumnRider_ListLink().size();
        List<String> orderIds = CommonActions.createOrdersGetIdsAsList(11 - numberOfOrdersPresent);

        softAssert.assertTrue(dispatchDetailPage.isPresent_dispatchDetailBreadCrumb_Link(), "Validate presence of Dispatch Detail breadcrumb");
        addOrdersPage.fill_SearchByOrderIdOnScanOrdersPage_TxtBox(orderIds);

        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        commonActions.chooseNoOfRecordsToBeDisplayedPerPage(10);
        commonActions.click_PaginationNext_Btn();
        softAssert.assertTrue(dispatchDetailPage.isPresent_OrderId_Txt(), "Next page button is working as expected");
        String expectedEleventhOrderId = dispatchDetailPage.getValue_OrderId_Txt(0);

        commonActions.click_PaginationPrevious_Btn();
        softAssert.assertTrue(dispatchDetailPage.isPresent_OrderId_Txt(), "Previous page button is working as expected");
        String expectedFirstOrderId = dispatchDetailPage.getValue_OrderId_Txt(0);
        commonActions.select_PaginationBlock_Txt(2);
        String actualEleventhOrderId = dispatchDetailPage.getValue_OrderId_Txt(0);
        softAssert.assertEquals(actualEleventhOrderId, expectedEleventhOrderId, "Pagination block second page button is working as expected");

        commonActions.select_PaginationBlock_Txt(1);
        String actualFirstOrderId = dispatchDetailPage.getValue_OrderId_Txt(0);
        softAssert.assertEquals(actualFirstOrderId, expectedFirstOrderId, "Pagination block first page button is working as expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_023, Verify Functionality Of Pagination Per Page With Paging Block And Next Button")
    public void TC_DispatchDetail_023_Verify_Functionality_Of_Pagination_Per_Page_With_Paging_Block_And_Next_Button() throws IOException, APIResponseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();
        dispatchPage.uncheckCheckbox_StatusDropdownClosed_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownOngoing_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownAssigned_Checkbox();
        dispatchPage.checkCheckbox_StatusDropdownStarted_Checkbox();
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        commonActions.chooseNoOfRecordsToBeDisplayedPerPage(50);

        int numberOfOrdersPresent = dispatchPage.getList_ShipmentDetailsTableColumnRider_ListLink().size();
        List<String> orderIds = CommonActions.createOrdersGetIdsAsList(11 - numberOfOrdersPresent);

        softAssert.assertTrue(dispatchDetailPage.isPresent_dispatchDetailBreadCrumb_Link(), "Validate presence of Dispatch Detail breadcrumb");
        addOrdersPage.fill_SearchByOrderIdOnScanOrdersPage_TxtBox(orderIds);

        commonActions.chooseNoOfRecordsToBeDisplayedPerPage(20);
        String expectedEleventhOrderId = dispatchDetailPage.getValue_OrderId_Txt(10);
        commonActions.chooseNoOfRecordsToBeDisplayedPerPage(10);
        String expectedFirstOrderId = dispatchDetailPage.getValue_OrderId_Txt(0);
        commonActions.click_PaginationNext_Btn();
        String actualEleventhOrderId = dispatchDetailPage.getValue_OrderId_Txt(0);
        softAssert.assertEquals(actualEleventhOrderId, expectedEleventhOrderId, "1Pagination Next button is working as expected");

        commonActions.click_PaginationPrevious_Btn();
        String actualFirstOrderId = dispatchDetailPage.getValue_OrderId_Txt(0);

        softAssert.assertEquals(actualFirstOrderId, expectedFirstOrderId, "2Pagination previous button is working as expected");

        commonActions.select_PaginationBlock_Txt(2);
        actualEleventhOrderId = dispatchDetailPage.getValue_OrderId_Txt(0);
        softAssert.assertEquals(actualEleventhOrderId, expectedEleventhOrderId, "Pagination block second page button is working as expected");

        softAssert.assertAll();
    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH_DETAIL, TestGroup.BVT},
            description = "TC_024 & TC_25, Verify Functionality Of Vertically Scroll Of Facilities Table Using Mouse Scroll Wheel")
    public void TC_DispatchDetail_024_And_TC_025_Verify_Functionality_Of_Vertically_Scroll_Of_Facilities_Table_Using_Mouse_Scroll_Wheel() throws IOException, APIResponseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();
        dispatchPage.uncheckCheckbox_StatusDropdownClosed_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownOngoing_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownAssigned_Checkbox();
        dispatchPage.checkCheckbox_StatusDropdownStarted_Checkbox();
        dispatchPage.click_ShipmentDetailsTableColumnRider_ListLink(0);
        commonActions.chooseNoOfRecordsToBeDisplayedPerPage(50);

        int numberOfOrdersPresent = dispatchPage.getList_ShipmentDetailsTableColumnRider_ListLink().size();
        List<String> orderIds = CommonActions.createOrdersGetIdsAsList(11 - numberOfOrdersPresent);

        softAssert.assertTrue(dispatchDetailPage.isPresent_dispatchDetailBreadCrumb_Link(), "Validate presence of Dispatch Detail breadcrumb");
        addOrdersPage.fill_SearchByOrderIdOnScanOrdersPage_TxtBox(orderIds);
        commonActions.chooseNoOfRecordsToBeDisplayedPerPage(10);
        Utility.scrollDownUsingKeyboardKey(5);
        softAssert.assertTrue(dispatchDetailPage.isPresent_OrderId_Txt(9),"Vertically Scroll In Table Using KeyBoard is working as expected");
        dispatchDetailPage.scrollToOrderId(0);
        softAssert.assertTrue(dispatchDetailPage.isPresent_OrderId_Txt(0),"Vertically Scroll In Table Using mouse scroll is working as expected");
        dispatchDetailPage.scrollToOrderId(9);
        softAssert.assertTrue(dispatchDetailPage.isPresent_OrderId_Txt(9),"Vertically Scroll In Table Using mouse scroll is working as expected");

        softAssert.assertAll();
    }


}