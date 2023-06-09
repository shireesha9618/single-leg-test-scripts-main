package testsuite.dispatch;

import base.BaseTestClass;
import constants.TestGroup;
import framework.backend.APIResponseException;
import framework.common.assertion.JarvisAssert;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.actions.ActionHelper;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TestSuite_Dispatch extends BaseTestClass {

    CommonActions commonActions = CommonActions.getInstance();
    DispatchPage dispatchPage = DispatchPage.getInstance();
    DispatchDetailPage dispatchDetailPage = DispatchDetailPage.getInstance();
    HomePage homePage = HomePage.getInstance();

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_001, Verify The UI Of Dispatch Page")
    public void TC_Dispatch_001_Verify_UI_Of_Dispatch_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        softAssert.assertTrue(dispatchPage.isPresent_SearchBar_Txt(), "Check Visibility of Searchbar field");
        softAssert.assertTrue(dispatchPage.isPresent_Status_Dropdown(), "Check Visibility of Status dropdown");
        softAssert.assertTrue(dispatchPage.isPresent_TableActions_Dropdown(), "Check Visibility of Table Actions dropdown");
        softAssert.assertTrue(dispatchPage.isPresent_DateFilter_Dropdown(), "Check Visibility of Date Filter dropdown");
        softAssert.assertTrue(dispatchPage.isPresent_FromDateField_Txt(), "Check Visibility of From Date field");
        softAssert.assertTrue(dispatchPage.isPresent_ToDateField_Txt(), "Check Visibility of To Date field");
        softAssert.assertTrue(dispatchPage.isPresent_Refresh_Btn(), "Check Visibility of Refresh button");
        softAssert.assertTrue(dispatchPage.isPresent_DispatchesCount_Lbl(), "Check Visibility of Dispatches count");
        softAssert.assertTrue(dispatchPage.isPresent_AssignedCount_Lbl(), "Check Visibility of Assigned count");
        softAssert.assertTrue(dispatchPage.isPresent_StartedCount_Lbl(), "Check Visibility of Started count");
        softAssert.assertTrue(dispatchPage.isPresent_OngoingCount_Lbl(), "Check Visibility of Ongoing count");
        softAssert.assertTrue(dispatchPage.isPresent_ClosedCount_Lbl(), "Check Visibility of Closed count");
        softAssert.assertTrue(dispatchPage.isPresent_MapsZoomIn_Btn(), "Check Visibility of Map Zoom In btn");
        softAssert.assertTrue(dispatchPage.isPresent_MapsZoomOut_Btn(), "Check Visibility of Map Zoom Out btn");
        softAssert.assertTrue(dispatchPage.isPresent_HomeBreadCrumb_Link(), "Check Visibility of Home breadcrumb");
        softAssert.assertTrue(dispatchPage.isPresent_DispatchListBreadCrumb_Link(), "Check Visibility of Dispatch List breadcrumb");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_002, Verify The UI Of Table Present In Dispatch Page")
    public void TC_Dispatch_002_Verify_The_UI_Of_Table_Present_In_Dispatch_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        List<String> actualTabHeadersLabels = dispatchPage.getText_ShipmentDetailsTableHeaderList_Lbl();
        List<String> expectedTabHeaders = new ArrayList<>(List.of("RIDER", "VEHICLE", "STRUCTURE", "STATUS", "ORDER STATUS", "ACTIONS"));
        softAssert.assertTrue(actualTabHeadersLabels.equals(expectedTabHeaders), "Validate table header label");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_003, Verify The UI Of Table Actions ")
    public void TC_Dispatch_003_Verify_The_UI_Of_Table_Actions() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();
        dispatchPage.click_TableActions_Dropdown();
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropdownModifyColumn_Link(), "Validate presence of Modify Column link");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_004, Verify The Functionality Of Search Bar with valid data")
    public void TC_Dispatch_004_Verify_The_Functionality_Of_Search_Bar_with_valid_data() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        String riderName = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(0);
        dispatchPage.fillWithClear_SearchBar_Txt(riderName.substring(0, 2));
        List<String> riders = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink();
        softAssert.assertEquals(riders.get(0), riderName, "Validate the rider name");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_005, Verify The Functionality Of Search Bar with invalid data")
    public void TC_Dispatch_005_Verify_The_Functionality_Of_Search_Bar_with_invalid_data() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.fillWithClear_SearchBar_Txt(ActionHelper.getRandomNumberString(10));
        List<String> riders = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink();
        softAssert.assertEquals(riders.size(), 0, "Validate zero search results");
        softAssert.assertTrue(dispatchPage.isPresent_ItsEmptyHere_Lbl(), "Validate the presence of It's Empty here label");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_006, Verify The UI Of Status Button")
    public void TC_Dispatch_006_Verify_The_UI_Of_Status_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.click_Status_Dropdown();
        softAssert.assertTrue(dispatchPage.isPresent_StatusDropdownAssigned_Checkbox(), "Validate presence of Assigned checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_StatusDropdownStarted_Checkbox(), "Validate presence of Started checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_StatusDropdownOngoing_Checkbox(), "Validate presence of Ongoing checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_StatusDropdownClosed_Checkbox(), "Validate presence of Closed checkbox");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_007, Verify The Functionality Of Filter The Dispatches With Assigned Status ")
    public void TC_Dispatch_007_Verify_The_Functionality_Of_Filter_The_Dispatches_With_Assigned_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.checkCheckbox_StatusDropdownAssigned_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownOngoing_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownStarted_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownClosed_Checkbox();
        List<String> statusList = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl();
        for (String s : statusList) {
            softAssert.assertEquals(s, "Assigned", "Validate status label");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_008, Verify The Functionality Of Filter The Dispatches With Started Status ")
    public void TC_Dispatch_008_Verify_The_Functionality_Of_Filter_The_Dispatches_With_Started_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.checkCheckbox_StatusDropdownStarted_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownOngoing_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownAssigned_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownClosed_Checkbox();
        List<String> statusList = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl();
        for (String s : statusList) {
            softAssert.assertEquals(s, "Started", "Validate status label");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_009, Verify The Functionality Of Filter The Dispatches With Ongoing Status ")
    public void TC_Dispatch_009_Verify_The_Functionality_Of_Filter_The_Dispatches_With_Ongoing_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.checkCheckbox_StatusDropdownOngoing_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownStarted_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownAssigned_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownClosed_Checkbox();
        List<String> statusList = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl();
        for (String s : statusList) {
            softAssert.assertEquals(s, "Ongoing", "Validate status label");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_010, Verify The Functionality Of Filter The Dispatches With Closed Status ")
    public void TC_Dispatch_010_Verify_The_Functionality_Of_Filter_The_Dispatches_With_Closed_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.checkCheckbox_StatusDropdownClosed_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownStarted_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownAssigned_Checkbox();
        dispatchPage.uncheckCheckbox_StatusDropdownOngoing_Checkbox();
        List<String> statusList = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl();
        for (String s : statusList) {
            softAssert.assertEquals(s, "Closed", "Validate status label");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_011, Verify The Functionality Of Modify Columns For Table Actions Button")
    public void TC_Dispatch_011_Verify_The_Functionality_Of_Modify_Columns_For_Table_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.click_TableActions_Dropdown();
        dispatchPage.click_TableActionsDropdownModifyColumn_Link();
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkHeader_Lbl(), "Validate presence of Edit Columns header");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkSearchBar_Txt(), "Validate presence of Search Bar");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkSelectAll_Btn(), "Validate presence of Select All Button");
        List<String> options = dispatchPage.getText_TableActionsDropDownModifyColumnsLinkOptionsList_Label();
        softAssert.assertEquals(options.get(0), "Rider", "Validate presence of Rider option");
        softAssert.assertEquals(options.get(1), "Vehicle", "Validate presence of Vehicle option");
        softAssert.assertEquals(options.get(2), "Structure", "Validate presence of Structure option");
        softAssert.assertEquals(options.get(3), "Status", "Validate presence of Status option");
        softAssert.assertEquals(options.get(4), "Order status", "Validate presence of Order Status option");
        softAssert.assertEquals(options.get(5), "Actions", "Validate presence of Actions option");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkCancel_Btn(), "Validate presence of Cancel Button");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkSave_Btn(), "Validate presence of Save Button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_012 Verify The Functionality Of Select All Of Modify Columns For Table Actions Button")
    public void TC_Dispatch_012_Verify_The_Functionality_Of_Select_All_Of_Modify_Columns_For_Table_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.click_TableActions_Dropdown();
        dispatchPage.click_TableActionsDropdownModifyColumn_Link();
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkHeader_Lbl(), "Validate presence of Edit Columns header");
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkSelectAll_Btn();
        List<String> options = dispatchPage.getText_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label();
        softAssert.assertEquals(options.get(0), "Rider", "Validate presence of Rider option");
        softAssert.assertEquals(options.get(1), "Vehicle", "Validate presence of Vehicle option");
        softAssert.assertEquals(options.get(2), "Structure", "Validate presence of Structure option");
        softAssert.assertEquals(options.get(3), "Status", "Validate presence of Status option");
        softAssert.assertEquals(options.get(4), "Order Status", "Validate presence of Order Status option");
        softAssert.assertEquals(options.get(5), "Actions", "Validate presence of Actions option");
        dispatchPage.uncheck_TableActionsDropDownModifyColumnsLinkStructure_Checkbox();
        dispatchPage.uncheck_TableActionsDropDownModifyColumnsLinkOrderStatus_Checkbox();
        options = dispatchPage.getText_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label();
        softAssert.assertEquals(options.get(0), "Rider", "Validate presence of Rider option");
        softAssert.assertEquals(options.get(1), "Vehicle", "Validate presence of Vehicle option");
        softAssert.assertEquals(options.get(2), "Status", "Validate presence of Order Status option");
        softAssert.assertEquals(options.get(3), "Actions", "Validate presence of Actions option");
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkSelectAll_Btn();
        options = dispatchPage.getText_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label();
        softAssert.assertEquals(options.get(0), "Rider", "Validate presence of Rider option");
        softAssert.assertEquals(options.get(1), "Vehicle", "Validate presence of Vehicle option");
        softAssert.assertEquals(options.get(2), "Structure", "Validate presence of Structure option");
        softAssert.assertEquals(options.get(3), "Status", "Validate presence of Status option");
        softAssert.assertEquals(options.get(4), "Order Status", "Validate presence of Order Status option");
        softAssert.assertEquals(options.get(5), "Actions", "Validate presence of Actions option");
        dispatchPage.closeEditColumnsPopUp();
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_013, Verify The Functionality Of Drag The Position Of Modify Columns For Table Actions Button")
    public void TC_Dispatch_013_Verify_The_Functionality_Of_Drag_The_Position_Of_Modify_Columns_For_Table_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.click_TableActions_Dropdown();
        dispatchPage.click_TableActionsDropdownModifyColumn_Link();
        List<String> expectedOptions = dispatchPage.getText_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label();
        String temp = expectedOptions.get(0);
        expectedOptions.add(0, expectedOptions.get(1));
        expectedOptions.remove(1);
        expectedOptions.add(1, temp);
        expectedOptions.remove(2);
        dispatchPage.dragAndDrop_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label(0, 1);
        List<String> actualOptions = dispatchPage.getText_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label();
        for (int i = 0; i < expectedOptions.size(); i++)
            softAssert.assertEquals(actualOptions.get(i), expectedOptions.get(i), "Validate order of options");
        dispatchPage.closeEditColumnsPopUp();
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_014, Verify The Functionality Of Checkbox And X Of Modify Columns For Table Actions Button")
    public void TC_Dispatch_014_Verify_The_Functionality_Of_Checkbox_And_X_Of_Modify_Columns_For_Table_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.click_TableActions_Dropdown();
        dispatchPage.click_TableActionsDropdownModifyColumn_Link();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkSelectAll_Btn();
        dispatchPage.uncheck_TableActionsDropDownModifyColumnsLinkRider_Checkbox();
        dispatchPage.uncheck_TableActionsDropDownModifyColumnsLinkActions_Checkbox();
        List<String> availableColumns = dispatchPage.getText_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label();
        softAssert.assertTrue(!availableColumns.contains("Rider"), "Validate absence of Rider as option");
        softAssert.assertTrue(!availableColumns.contains("Actions"), "Validate absence of Actions as option");
        dispatchPage.check_TableActionsDropDownModifyColumnsLinkRider_Checkbox();
        dispatchPage.check_TableActionsDropDownModifyColumnsLinkActions_Checkbox();
        availableColumns = dispatchPage.getText_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label();
        softAssert.assertTrue(availableColumns.contains("Rider"), "Validate presence of Rider as option");
        softAssert.assertTrue(availableColumns.contains("Rider"), "Validate presence of Rider as option");
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkCross_Icon();
        softAssert.assertTrue(dispatchPage.isPresent_Header_Lbl(), "Validate presence of header label");
        softAssert.assertEquals(DispatchPage.getInstance().getText_Header_Lbl(), "Dispatches", "Validate label of header");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_015, Verify The Functionality Of Search Bar Of Modify Columns For Table  Actions Button")
    public void TC_Dispatch_015_Verify_The_Functionality_Of_Search_Bar_Of_Modify_Columns_For_Table__Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.click_TableActions_Dropdown();
        dispatchPage.click_TableActionsDropdownModifyColumn_Link();
        dispatchPage.fillWithClear_TableActionsDropDownModifyColumnsLinkSearchBar_Txt("abcd");
        softAssert.assertTrue(!dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkRider_Checkbox(), "Validate absence of Id Checkbox");
        softAssert.assertTrue(!dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkVehicle_Checkbox(), "Validate absence of Name Checkbox");
        softAssert.assertTrue(!dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkStructure_Checkbox(), "Validate absence of Status Checkbox");
        softAssert.assertTrue(!dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkStatus_Checkbox(), "Validate absence of Facility Type Checkbox");
        softAssert.assertTrue(!dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkOrderStatus_Checkbox(), "Validate absence of order status Checkbox");
        softAssert.assertTrue(!dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkActions_Checkbox(), "Validate absence of Area Checkbox");

        dispatchPage.fillWithClear_TableActionsDropDownModifyColumnsLinkSearchBar_Txt("Status");
        softAssert.assertTrue(!dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkRider_Checkbox(), "Validate absence of rider Checkbox");
        softAssert.assertTrue(!dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkVehicle_Checkbox(), "Validate absence of vehicle Checkbox");
        softAssert.assertTrue(!dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkStructure_Checkbox(), "Validate absence of structure Checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkStatus_Checkbox(), "Validate presence of Status Type Checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkOrderStatus_Checkbox(), "Validate absence of order status Checkbox");
        softAssert.assertTrue(!dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkActions_Checkbox(), "Validate absence of Area Checkbox");
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkCross_Icon();

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_016, Verify The Functionality Of Cancel Button Of Modify Columns For Table Actions Button")
    public void TC_Dispatch_016_Verify_The_Functionality_Of_Cancel_Button_Of_Modify_Columns_For_Table_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.click_TableActions_Dropdown();
        dispatchPage.click_TableActionsDropdownModifyColumn_Link();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkCancel_Btn();
        softAssert.assertTrue(dispatchPage.isPresent_Header_Lbl(), "Validate presence of header label");
        softAssert.assertEquals(DispatchPage.getInstance().getText_Header_Lbl(), "Dispatches", "Validate label of header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_017, Verify The Functionality Of Save Button Of Modify Columns For Table Actions Button")
    public void TC_Dispatch_017_Verify_The_Functionality_Of_Save_Button_Of_Modify_Columns_For_Table_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.click_TableActions_Dropdown();
        dispatchPage.click_TableActionsDropdownModifyColumn_Link();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkSelectAll_Btn();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkSave_Btn();
        List<String> headList = dispatchPage.getText_TableHeader_Labels();
        softAssert.assertEquals(headList.get(0), "RIDER", "Validate presence of RIDER header");
        softAssert.assertEquals(headList.get(1), "VEHICLE", "Validate presence of VEHICLE header");
        softAssert.assertEquals(headList.get(2), "STRUCTURE", "Validate presence of STRUCTURE header");
        softAssert.assertEquals(headList.get(3), "STATUS", "Validate presence of STATUS header");
        softAssert.assertEquals(headList.get(4), "ORDER STATUS", "Validate presence of ORDER STATUS header");

        dispatchPage.click_TableActions_Dropdown();
        dispatchPage.click_TableActionsDropdownModifyColumn_Link();
        dispatchPage.uncheck_TableActionsDropDownModifyColumnsLinkStructure_Checkbox();
        dispatchPage.uncheck_TableActionsDropDownModifyColumnsLinkOrderStatus_Checkbox();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkSave_Btn();
        headList = dispatchPage.getText_TableHeader_Labels();
        softAssert.assertEquals(headList.get(0), "RIDER", "Validate presence of RIDER header");
        softAssert.assertEquals(headList.get(1), "VEHICLE", "Validate presence of VEHICLE header");
        softAssert.assertEquals(headList.get(2), "STATUS", "Validate presence of STATUS header");
        softAssert.assertEquals(headList.get(3), "ACTIONS", "Validate presence of ACTIONS header");

        dispatchPage.click_TableActions_Dropdown();
        dispatchPage.click_TableActionsDropdownModifyColumn_Link();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkSelectAll_Btn();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkSave_Btn();
        headList = dispatchPage.getText_TableHeader_Labels();
        softAssert.assertEquals(headList.get(0), "RIDER", "Validate presence of RIDER header");
        softAssert.assertEquals(headList.get(1), "VEHICLE", "Validate presence of VEHICLE header");
        softAssert.assertEquals(headList.get(2), "STRUCTURE", "Validate presence of STRUCTURE header");
        softAssert.assertEquals(headList.get(3), "STATUS", "Validate presence of STATUS header");
        softAssert.assertEquals(headList.get(4), "ORDER STATUS", "Validate presence of ORDER STATUS header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_018, Verify The Functionality Of Refresh Button In Dispatches page")
    public void TC_Dispatch_018_Verify_The_Functionality_Of_Refresh_Button_In_Dispatches_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();
        dispatchPage.click_FromDate_TxtBox();
        softAssert.assertTrue(dispatchPage.isPresent_CalendarWindow_PopUp(), "Calendar window popup is present as expected");

        dispatchPage.click_Refresh_Btn();
        softAssert.assertTrue(!dispatchPage.isPresent_CalendarWindow_PopUp(), "Calendar window popup is not present as expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_019, Verify The UI of Actions in Dispatch List page")
    public void TC_Dispatch_019_Verify_The_UI_of_Actions_in_Dispatch_List_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();
        dispatchPage.scrollTo_Actions_column();
        dispatchPage.click_FirstOrderActions_Btn();
        softAssert.assertTrue(dispatchPage.isPresent_ShipmentDetailsTableColumnActionsAddOrder_Radio(), "Validate presence of Add Order radio");
        softAssert.assertTrue(dispatchPage.isPresent_ShipmentDetailsTableColumnActionsViewOrder_Radio(), "Validate presence of View Order radio");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_020, Verify The Functionality of View Orders of Actions")
    public void TC_Dispatch_020_Verify_The_Functionality_of_View_Orders_of_Actions() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        String rider = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink(0);
        dispatchPage.click_ShipmentDetailsTableColumnActions_ListBtn(0);
        dispatchPage.click_ShipmentDetailsTableColumnActionsViewOrder_Radio();
        softAssert.assertTrue(dispatchDetailPage.isPresent_Header_Lbl(), "Validate presence of header lbl");
        softAssert.assertEquals(dispatchDetailPage.getText_Header_Lbl(), rider, "Validate header lbl");
        softAssert.assertTrue(dispatchDetailPage.isPresent_DispatchStatus_Lbl(), "Validate presence of Status lbl");
        softAssert.assertTrue(dispatchDetailPage.isPresent_SearchBar_Txt(), "Validate presence of Search bar");
        softAssert.assertTrue(dispatchDetailPage.isPresent_Status_Dropdown(), "Validate presence of Status dropdown");
        softAssert.assertTrue(dispatchDetailPage.isPresent_ScanToAddOrders_Btn(), "Validate presence of Scan To Add Orders btn");
        softAssert.assertTrue(dispatchDetailPage.isPresent_DownloadRunSheet_Btn(), "Validate presence of Download Run Sheet btn");
        softAssert.assertTrue(dispatchDetailPage.isPresent_Refresh_Btn(), "Validate presence of Refresh btn");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_022, Verify The UI of Calender in Dispatches page")
    public void TC_Dispatch_022_Verify_The_UI_of_Calender_in_Dispatches_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.click_DateFilter_Dropdown();
        softAssert.assertTrue(dispatchPage.isPresent_DateFilterDropdownCreatedDate_Radio(), "Validate presence of Created Date radio");
        softAssert.assertTrue(dispatchPage.isPresent_DateFilterDropdownClosureDate_Radio(), "Validate presence of Closure Date radio");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_023, Verify Next And Previous Year Button On Calender")
    public void TC_Dispatch_023_Verify_Next_And_Previous_Year_Button_On_Calender() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();
        dispatchPage.click_FromDate_TxtBox();
        String expectedYear = dispatchPage.getValue_CalendarCreatedByFromYear_Txt();

        dispatchPage.click_CalendarPreviousYear_Btn();
        String actualYear = dispatchPage.getValue_CalendarCreatedByFromYear_Txt();
        softAssert.assertTrue(!actualYear.equals(expectedYear), "Calendar previous Year calendar button is working as expected");
        dispatchPage.click_CalendarLaterYear_Btn();

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_024, Verify Next And Previous Month Button On Calender")
    public void TC_Dispatch_024_Verify_Next_And_Previous_Month_Button_On_Calender() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();
        dispatchPage.click_FromDate_TxtBox();
        String expectedMonth = dispatchPage.getValue_CalendarCreatedByFromMonth_Txt();
        dispatchPage.click_CalendarPreviousMonth_Btn();
        String actualMonth = dispatchPage.getValue_CalendarCreatedByFromMonth_Txt();
        softAssert.assertTrue(!actualMonth.equals(expectedMonth), "Calendar previous month calendar button is working as expected");
        System.out.println(actualMonth + "  " + expectedMonth);
        dispatchPage.click_CalendarLaterMonth_Btn();
        actualMonth = dispatchPage.getValue_CalendarCreatedByFromMonth_Txt();
        softAssert.assertTrue(actualMonth.equals(expectedMonth), "Calendar later month calendar button is working as expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_025, Verify Start Date Is Not Greater Than End Date")
    public void TC_Dispatch_025_Verify_Start_Date_Is_Not_Greater_Than_End_Date() throws ParseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        String createdFromDate = dispatchPage.get_CreatedDispatchDate_Value();
        String expectedFromDate = commonActions.get_PreviousDateForGivenDate_Of(createdFromDate, -1);
        dispatchPage.set_ClosureDispatchDate_As(expectedFromDate);
        dispatchPage.click_Refresh_Btn();
        String createdToDate = dispatchPage.get_ClosureDispatchDate_Value();
        softAssert.assertTrue(!expectedFromDate.equals(createdToDate),"Calendar To date is less than Calendar from date");
        dispatchPage.set_ClosureDispatchDate_As(expectedFromDate);
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_041, Verify The Functionality Of Dispatches count as per the display records in Table")
    public void TC_Dispatch_041_Verify_The_Functionality_Of_Dispatches_count_as_per_the_display_records_in_Table() {
        commonActions.coverJourneyTillDispatches();
        dispatchPage.statusDropdownUnselectAll();

        dispatchPage.checkCheckbox_StatusDropdownAssigned_Checkbox();
        int assignedRecordsCount = dispatchPage.getList_ShipmentDetailsTableColumnRider_ListLink().size();
        dispatchPage.uncheckCheckbox_StatusDropdownAssigned_Checkbox();
        dispatchPage.checkCheckbox_StatusDropdownStarted_Checkbox();
        int startedRecordsCount = dispatchPage.getList_ShipmentDetailsTableColumnRider_ListLink().size();
        dispatchPage.uncheckCheckbox_StatusDropdownStarted_Checkbox();
        dispatchPage.checkCheckbox_StatusDropdownOngoing_Checkbox();
        int ongoingRecordsCount = dispatchPage.getList_ShipmentDetailsTableColumnRider_ListLink().size();
        dispatchPage.uncheckCheckbox_StatusDropdownOngoing_Checkbox();
        dispatchPage.checkCheckbox_StatusDropdownClosed_Checkbox();
        int closedRecordsCount = dispatchPage.getList_ShipmentDetailsTableColumnRider_ListLink().size();
        dispatchPage.uncheckCheckbox_StatusDropdownClosed_Checkbox();
        dispatchPage.statusDropdownSelectAll();

        JarvisAssert.assertTrue(!(dispatchPage.getList_ShipmentDetailsTableColumnRider_ListLink().size() == assignedRecordsCount + startedRecordsCount + ongoingRecordsCount + closedRecordsCount));
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_043, Verify The Functionality Of Open Menu")
    public void TC_Dispatch_043_Verify_The_Functionality_Of_Open_Menu() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        homePage.click_OpenMenu_Btn();
        softAssert.assertTrue(homePage.isPresent_SingleLeg_Btn(), "Validate presence of Single Leg");
        softAssert.assertTrue(homePage.isPresent_OpenMenuOrders_Btn(), "Validate presence of Orders");
        softAssert.assertTrue(homePage.isPresent_OpenMenuCreateOrders_Btn(), "Validate presence of Create Orders");
        softAssert.assertTrue(homePage.isPresent_OpenMenuViewOrders_Btn(), "Validate presence of View Orders");
        softAssert.assertTrue(homePage.isPresent_OpenMenuRouting_Btn(), "Validate presence of Routing");
        softAssert.assertTrue(homePage.isPresent_OpenMenuDispatch_Btn(), "Validate presence of Dispatch");
        softAssert.assertTrue(homePage.isPresent_OpenMenuRiders_Btn(), "Validate presence of Riders");
        softAssert.assertTrue(homePage.isPresent_OpenMenuFacilities_Btn(), "Validate presence of Facilities");
        softAssert.assertTrue(homePage.isPresent_OpenMenuTeams_Btn(), "Validate presence of Teams");
        softAssert.assertTrue(homePage.isPresent_OpenMenuSettings_Btn(), "Validate presence of Settings");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_044, Verify The Functionality of Cross button(X) of Open Menu")
    public void TC_Dispatch_044_Verify_The_Functionality_of_Cross_button_of_Open_Menu() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        homePage.click_OpenMenu_Btn();
        homePage.click_DispatchOpenMenu_Btn();
        homePage.click_OpenMenuCross_Btn();
        softAssert.assertTrue(DispatchPage.getInstance().isPresent_Header_Lbl(), "Validate presence of header lbl");
        softAssert.assertEquals(DispatchPage.getInstance().getText_Header_Lbl(), "Dispatches", "Validate header lbl");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_045, Verify The Functionality Of Workflow button")
    public void TC_Dispatch_045_Verify_The_Functionality_Of_Workflow_button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        homePage.click_WorkFlowOs1_Link();
        softAssert.assertTrue(homePage.isPresent_WorkFlowOrders_Btn(), "Validate presence of Orders");
        softAssert.assertTrue(homePage.isPresent_WorkFlowRouting_Btn(), "Validate presence of Routing");
        softAssert.assertTrue(homePage.isPresent_WorkFlowDispatch_Btn(), "Validate presence of Dispatch");
        softAssert.assertTrue(homePage.isPresent_WorkFlowRiders_Btn(), "Validate presence of Riders");
        softAssert.assertTrue(homePage.isPresent_WorkFlowFacilities_Btn(), "Validate presence of Facilities");
        softAssert.assertTrue(homePage.isPresent_WorkFlowTeams_Btn(), "Validate presence of Teams");
        softAssert.assertTrue(homePage.isPresent_WorkFlowSettings_Btn(), "Validate presence of Settings");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_046, Verify The Functionality Of Teams button of Workflow")
    public void TC_Dispatch_046_Verify_The_Functionality_Of_Teams_button_of_Workflow() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        homePage.click_WorkFlowOs1_Link();
        homePage.click_WorkFlowDispatch_Btn();
        softAssert.assertTrue(DispatchPage.getInstance().isPresent_Header_Lbl(), "Validate presence of header lbl");
        softAssert.assertEquals(DispatchPage.getInstance().getText_Header_Lbl(), "Dispatches", "Validate header lbl");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_021, Verify The Functionality of Add Order Button in Actions")
    public void TC_Dispatch_021_Verify_The_Functionality_of_Add_Order_Button_In_Actions() throws IOException, APIResponseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        String orderId = CommonActions.createAnOrderGetOrderID();
        commonActions.coverJourneyTillDispatches();
        dispatchPage.scrollTo_Actions_column();
        dispatchPage.click_FirstOrderActions_Btn();
        dispatchPage.click_AddOrders_RadioBtn();
        softAssert.assertEquals(AddOrdersPage.getInstance().getText_Header_Txt(), "Add Orders", "Add Orders Page is opened as expected");
        softAssert.assertTrue(AddOrdersPage.getInstance().isPresent_InventoryInHand_Txt(), "Inventory in hand text is present as expected");
        softAssert.assertTrue(AddOrdersPage.getInstance().isPresent_InventoryInHand_Txt(), "Expected Cash To Be Collected text is present as expected");
        softAssert.assertTrue(AddOrdersPage.getInstance().isPresent_YouDontHaveAnyScannedShipments_Txt(), "You Don't Have Any Scanned Shipments text is present as expected");

        int cashCollectedBeforeAddingNewOrder = AddOrdersPage.getInstance().getText_ExpectedCashValue_Txt();
        AddOrdersPage.getInstance().fill_SearchByOrderId_TxtBox(orderId);
        int cashCollectedAfterAddingNewOrder = AddOrdersPage.getInstance().getText_ExpectedCashValue_Txt();
        softAssert.assertTrue(cashCollectedAfterAddingNewOrder > cashCollectedBeforeAddingNewOrder, "Expected Cash to be collected is greater than after adding a new order as expected");
        softAssert.assertTrue(!AddOrdersPage.getInstance().isPresent_YouDontHaveAnyScannedShipments_Txt(), "You Don't Have Any Scanned Shipments text is present as expected");

        AddOrdersPage.getInstance().clickOn_RemoveOrder_Btn(0);
        cashCollectedAfterAddingNewOrder = AddOrdersPage.getInstance().getText_ExpectedCashValue_Txt();

        softAssert.assertEquals(cashCollectedAfterAddingNewOrder, cashCollectedBeforeAddingNewOrder, "Expected Cash to be collected is equals as expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_026 & TC_027, Verify the Dispatch Table Record With Created Date and Closure Date ")
    public void TC_Dispatch_026_And_027_Verify_The_Dispatch_Table_Record_With_Created_Date() throws ParseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();
        String createdDate = dispatchPage.get_CreatedDispatchDate_Value();
        String closureDate = dispatchPage.get_ClosureDispatchDate_Value();
        String expected_CreatedDate_Value = commonActions.get_PreviousDateForGivenDate_Of(createdDate, 30);
        String expected_ClosureDate_Value = commonActions.get_PreviousDateForGivenDate_Of(closureDate, 40);
        List<String> ridersNames = dispatchPage.getRiderNameAsList();
        dispatchPage.set_CreatedDispatchDate_As(expected_CreatedDate_Value);
        List<String> expected_RidersNames = dispatchPage.getRiderNameAsList();
        softAssert.assertTrue(ridersNames.equals(expected_RidersNames), "Dispatches created dates are matched as expected");
        dispatchPage.set_ClosureDispatchDate_As(expected_ClosureDate_Value);
        expected_RidersNames = dispatchPage.getRiderNameAsList();
        softAssert.assertTrue(ridersNames.equals(expected_RidersNames), "Dispatches closure dates are matched as expected");

        dispatchPage.set_CreatedDispatchDate_As(createdDate);
        dispatchPage.set_ClosureDispatchDate_As(closureDate);

        softAssert.assertAll();
    }
}