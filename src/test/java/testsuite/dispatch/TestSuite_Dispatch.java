package testsuite.dispatch;

import base.BaseTestClass;
import constants.TestGroup;
import framework.backend.APIResponseException;
import framework.common.assertion.JarvisAssert;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.actions.ActionHelper;
import org.testng.annotations.Test;
import pageobjects.*;
import utility.Utility;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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
        Collections.sort(expectedTabHeaders);
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
        dispatchPage.fillWithClear_SearchBar_Txt(riderName);
        List<String> riders = dispatchPage.getText_ShipmentDetailsTableColumnRider_ListLink();
        softAssert.assertEquals(riders.size(), 1, "Validate count of search results");
        softAssert.assertEquals(riders.get(0), riderName, "Validate the rider name");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_005, Verify The Functionality Of Search Bar with invalid data")
    public void TC_Dispatch_005_Verify_The_Functionality_Of_Search_Bar_with_invalid_data() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.fillWithClear_SearchBar_Txt(ActionHelper.getRandomNumberString(5));
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

        dispatchPage.click_Status_Dropdown();
        dispatchPage.checkCheckbox_StatusDropdownAssigned_Checkbox();
        List<String> statusList = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl();
        for (int i = 0; i < statusList.size(); i++) {
            softAssert.assertEquals(statusList.get(i), "Assigned", "Validate status label");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_008, Verify The Functionality Of Filter The Dispatches With Started Status ")
    public void TC_Dispatch_008_Verify_The_Functionality_Of_Filter_The_Dispatches_With_Started_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.click_Status_Dropdown();
        dispatchPage.checkCheckbox_StatusDropdownStarted_Checkbox();
        List<String> statusList = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl();
        for (int i = 0; i < statusList.size(); i++) {
            softAssert.assertEquals(statusList.get(i), "Started", "Validate status label");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_009, Verify The Functionality Of Filter The Dispatches With Ongoing Status ")
    public void TC_Dispatch_009_Verify_The_Functionality_Of_Filter_The_Dispatches_With_Ongoing_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.click_Status_Dropdown();
        dispatchPage.checkCheckbox_StatusDropdownOngoing_Checkbox();
        List<String> statusList = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl();
        for (int i = 0; i < statusList.size(); i++) {
            softAssert.assertEquals(statusList.get(i), "Ongoing", "Validate status label");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_010, Verify The Functionality Of Filter The Dispatches With Closed Status ")
    public void TC_Dispatch_010_Verify_The_Functionality_Of_Filter_The_Dispatches_With_Closed_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.click_Status_Dropdown();
        dispatchPage.checkCheckbox_StatusDropdownClosed_Checkbox();
        List<String> statusList = dispatchPage.getText_ShipmentDetailsTableColumnStatus_ListLbl();
        for (int i = 0; i < statusList.size(); i++) {
            softAssert.assertEquals(statusList.get(i), "Closed", "Validate status label");
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
        softAssert.assertEquals(options.get(4), "Order Status", "Validate presence of Order Status option");
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
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkStructure_Checkbox();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkOrderStatus_Checkbox();
        options = dispatchPage.getText_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label();
        softAssert.assertEquals(options.get(0), "Rider", "Validate presence of Rider option");
        softAssert.assertEquals(options.get(1), "Vehicle", "Validate presence of Vehicle option");
        softAssert.assertEquals(options.get(2), "Order Status", "Validate presence of Order Status option");
        softAssert.assertEquals(options.get(3), "Actions", "Validate presence of Actions option");
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkSelectAll_Btn();
        options = dispatchPage.getText_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label();
        softAssert.assertEquals(options.get(0), "Rider", "Validate presence of Rider option");
        softAssert.assertEquals(options.get(1), "Vehicle", "Validate presence of Vehicle option");
        softAssert.assertEquals(options.get(2), "Structure", "Validate presence of Structure option");
        softAssert.assertEquals(options.get(3), "Status", "Validate presence of Status option");
        softAssert.assertEquals(options.get(4), "Order Status", "Validate presence of Order Status option");
        softAssert.assertEquals(options.get(5), "Actions", "Validate presence of Actions option");
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
        softAssert.assertTrue(dispatchPage.getText_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label().contains("Facility Type"), "Validate presence of Facility Type as option");
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkRider_Checkbox();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkActions_Checkbox();
        List<String> availableColumns = dispatchPage.getText_TableActionsDropDownModifyColumnsLinkSelectedOptionsList_Label();
        softAssert.assertTrue(availableColumns.contains("Rider") == false, "Validate absence of Rider as option");
        softAssert.assertTrue(availableColumns.contains("Actions") == false, "Validate absence of Actions as option");
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkRider_Checkbox();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkActions_Checkbox();
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
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkRider_Checkbox() == false, "Validate absence of Id Checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkVehicle_Checkbox() == false, "Validate absence of Name Checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkStructure_Checkbox() == false, "Validate absence of Status Checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkStatus_Checkbox() == false, "Validate absence of Facility Type Checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkOrderStatus_Checkbox() == false, "Validate absence of Operating Duration Checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkActions_Checkbox() == false, "Validate absence of Area Checkbox");

        dispatchPage.fillWithClear_TableActionsDropDownModifyColumnsLinkSearchBar_Txt("Status");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkRider_Checkbox() == false, "Validate absence of Id Checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkVehicle_Checkbox() == false, "Validate absence of Name Checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkStructure_Checkbox() == false, "Validate absence of Status Checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkStatus_Checkbox() == true, "Validate presence of Facility Type Checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkOrderStatus_Checkbox() == false, "Validate absence of Operating Duration Checkbox");
        softAssert.assertTrue(dispatchPage.isPresent_TableActionsDropDownModifyColumnsLinkActions_Checkbox() == false, "Validate absence of Area Checkbox");
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
        List<String> headList = dispatchPage.getText_ShipmentDetailsTableColumnStructure_ListLbl();
        softAssert.assertEquals(headList.get(0), "RIDER", "Validate presence of RIDER header");
        softAssert.assertEquals(headList.get(1), "VEHICLE", "Validate presence of VEHICLE header");
        softAssert.assertEquals(headList.get(2), "STRUCTURE", "Validate presence of STRUCTURE header");
        softAssert.assertEquals(headList.get(3), "STATUS", "Validate presence of STATUS header");
        softAssert.assertEquals(headList.get(4), "ORDER STATUS", "Validate presence of ORDER STATUS header");
        softAssert.assertEquals(headList.get(5), "ACTIONS", "Validate presence of ACTIONS header");

        dispatchPage.click_TableActions_Dropdown();
        dispatchPage.click_TableActionsDropdownModifyColumn_Link();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkStructure_Checkbox();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkOrderStatus_Checkbox();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkSave_Btn();
        headList = dispatchPage.getText_ShipmentDetailsTableColumnStructure_ListLbl();
        softAssert.assertEquals(headList.get(0), "RIDER", "Validate presence of RIDER header");
        softAssert.assertEquals(headList.get(1), "VEHICLE", "Validate presence of VEHICLE header");
        softAssert.assertEquals(headList.get(2), "STATUS", "Validate presence of STATUS header");
        softAssert.assertEquals(headList.get(3), "ACTIONS", "Validate presence of ACTIONS header");

        dispatchPage.click_TableActions_Dropdown();
        dispatchPage.click_TableActionsDropdownModifyColumn_Link();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkSelectAll_Btn();
        dispatchPage.click_TableActionsDropDownModifyColumnsLinkSave_Btn();
        headList = dispatchPage.getText_ShipmentDetailsTableColumnStructure_ListLbl();
        softAssert.assertEquals(headList.get(0), "RIDER", "Validate presence of RIDER header");
        softAssert.assertEquals(headList.get(1), "VEHICLE", "Validate presence of VEHICLE header");
        softAssert.assertEquals(headList.get(2), "STRUCTURE", "Validate presence of STRUCTURE header");
        softAssert.assertEquals(headList.get(3), "STATUS", "Validate presence of STATUS header");
        softAssert.assertEquals(headList.get(4), "ORDER STATUS", "Validate presence of ORDER STATUS header");
        softAssert.assertEquals(headList.get(5), "ACTIONS", "Validate presence of ACTIONS header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_018, Verify The Functionality Of Refresh Button In Dispatches page")
    public void TC_Dispatch_018_Verify_The_Functionality_Of_Refresh_Button_In_Dispatches_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.click_Refresh_Btn();
        softAssert.assertEquals(dispatchPage.getList_ShipmentDetailsTableColumnRider_ListLink().size(), 0, "Validate data is not visible");
        softAssert.assertEquals(dispatchPage.getListWithExplicitWait_ShipmentDetailsTableColumnRider_ListLink().size(), 0, "Validate data is visible again");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_019, Verify The UI of Actions in Dispatch List page")
    public void TC_Dispatch_019_Verify_The_UI_of_Actions_in_Dispatch_List_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.click_ShipmentDetailsTableColumnActions_ListBtn(0);
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM yyyy");
        String currentDate = ActionHelper.getCurrentDate().format(formatter);
        String plusOneYearDate = Utility.getNextYear(ActionHelper.getCurrentDate(), 1).format(formatter);
        softAssert.assertEquals(commonActions.getText_CalendarFromMonth_Btn(), currentDate.split(" ")[0], "Validate month being displayed");
        softAssert.assertEquals(commonActions.getText_CalendarFromYear_Btn(), currentDate.split(" ")[1], "Validate year being displayed");

        commonActions.click_CalendarNextYear_Btn();
        softAssert.assertEquals(commonActions.getText_CalendarFromMonth_Btn(), plusOneYearDate.split(" ")[0], "Validate month being displayed");
        softAssert.assertEquals(commonActions.getText_CalendarFromYear_Btn(), plusOneYearDate.split(" ")[0], "Validate year being displayed");

        commonActions.click_CalendarPreviousYear_Btn();
        softAssert.assertEquals(commonActions.getText_CalendarFromMonth_Btn(), currentDate.split(" ")[0], "Validate month being displayed");
        softAssert.assertEquals(commonActions.getText_CalendarFromYear_Btn(), currentDate.split(" ")[1], "Validate year being displayed");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_024, Verify Next And Previous Month Button On Calender")
    public void TC_Dispatch_024_Verify_Next_And_Previous_Month_Button_On_Calender() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM yyyy");
        String currentDate = ActionHelper.getCurrentDate().format(formatter);
        String plusOneMonthDate = Utility.getNextMonth(ActionHelper.getCurrentDate(), 1).format(formatter);
        softAssert.assertEquals(commonActions.getText_CalendarFromMonth_Btn(), currentDate.split(" ")[0], "Validate month being displayed");
        softAssert.assertEquals(commonActions.getText_CalendarFromYear_Btn(), currentDate.split(" ")[1], "Validate year being displayed");

        commonActions.click_CalendarNextMonth_Btn();
        softAssert.assertEquals(commonActions.getText_CalendarFromMonth_Btn(), plusOneMonthDate.split(" ")[0], "Validate month being displayed");
        softAssert.assertEquals(commonActions.getText_CalendarFromYear_Btn(), plusOneMonthDate.split(" ")[0], "Validate year being displayed");

        commonActions.click_CalendarPreviousMonth_Btn();
        softAssert.assertEquals(commonActions.getText_CalendarFromMonth_Btn(), currentDate.split(" ")[0], "Validate month being displayed");
        softAssert.assertEquals(commonActions.getText_CalendarFromYear_Btn(), currentDate.split(" ")[1], "Validate year being displayed");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_025, Verify Start Date Is Not Greater Than End Date")
    public void TC_Dispatch_025_Verify_Start_Date_Is_Not_Greater_Than_End_Date() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        dispatchPage.fillWithClear_FromDateField_Txt(Utility.getCustomCurrentDateFormatter("dd-MM-yyyy"));
        dispatchPage.fillWithClear_ToDateField_Txt(ActionHelper.getCustomPreviousDateFormatter("dd-MM-yyyy", 97));
        softAssert.assertEquals(dispatchPage.getValue_ToDateField_Txt(), "", "Start Date Is Not Greater Than End Date For All Tab");
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
        JarvisAssert.assertEquals(dispatchPage.getList_ShipmentDetailsTableColumnRider_ListLink().size(), assignedRecordsCount + startedRecordsCount + ongoingRecordsCount + closedRecordsCount);
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.DISPATCH, TestGroup.BVT},
            description = "TC_042, Verify The Functionality Dock and Undock of Left Panel")
    public void TC_Dispatch_042_Verify_The_Functionality_Dock_and_Undock_of_Left_Panel() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillDispatches();

        homePage.click_CloseSideBar_Icon();
        softAssert.assertTrue(homePage.isPresent_OrdersMenu_Icon(), "Validate presence of Order menu icon");
        softAssert.assertTrue(homePage.isPresent_OrdersMenu_Btn() == false, "Validate absence of Order menu btn");
        softAssert.assertTrue(homePage.isPresent_DispatchMenu_Icon(), "Validate presence of Dispatch menu icon");
        softAssert.assertTrue(homePage.isPresent_DispatchMenu_Btn() == false, "Validate absence of Dispatch menu btn");
        softAssert.assertTrue(homePage.isPresent_ResourcesMenu_Icon(), "Validate presence of Resources menu icon");
        softAssert.assertTrue(homePage.isPresent_ResourcesMenu_Btn() == false, "Validate absence of Resources menu btn");
        softAssert.assertTrue(homePage.isPresent_TeamsMenu_Icon(), "Validate presence of Teams menu icon");
        softAssert.assertTrue(homePage.isPresent_TeamsMenu_Btn() == false, "Validate absence of Teams menu btn");
        softAssert.assertTrue(homePage.isPresent_SettingsMenu_Icon(), "Validate presence of Settings menu icon");
        softAssert.assertTrue(homePage.isPresent_SettingsMenu_Btn() == false, "Validate absence of Settings menu btn");

        homePage.click_OpenSideBar_Icon();
        softAssert.assertTrue(homePage.isPresent_OrdersMenu_Icon(), "Validate presence of Order menu icon");
        softAssert.assertTrue(homePage.isPresent_OrdersMenu_Btn(), "Validate presence of Order menu btn");
        softAssert.assertTrue(homePage.isPresent_DispatchMenu_Icon(), "Validate presence of Dispatch menu icon");
        softAssert.assertTrue(homePage.isPresent_DispatchMenu_Btn(), "Validate presence of Dispatch menu btn");
        softAssert.assertTrue(homePage.isPresent_ResourcesMenu_Icon(), "Validate presence of Resources menu icon");
        softAssert.assertTrue(homePage.isPresent_ResourcesMenu_Btn(), "Validate presence of Resources menu btn");
        softAssert.assertTrue(homePage.isPresent_TeamsMenu_Icon(), "Validate presence of Teams menu icon");
        softAssert.assertTrue(homePage.isPresent_TeamsMenu_Btn(), "Validate presence of Teams menu btn");
        softAssert.assertTrue(homePage.isPresent_SettingsMenu_Icon(), "Validate presence of Settings menu icon");
        softAssert.assertTrue(homePage.isPresent_SettingsMenu_Btn(), "Validate presence of Settings menu btn");
        softAssert.assertAll();
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
        String order_Id = Utility.createAnOrder_Get_Order_ID();
        commonActions.coverJourneyTillDispatches();
        dispatchPage.scrollTo_Actions_column();
        dispatchPage.clickOn_FirstOrder_Actions_Btn();
        dispatchPage.clickOn_Add_Orders_Radio_Btn();
        softAssert.assertEquals(AddOrdersPage.getInstance().get_Header_txt(), "Add Orders", "Add Orders Page is opened as expected");
        softAssert.assertTrue(AddOrdersPage.getInstance().is_InventoryInHand_TxtPresent(), "Inventory in hand text is present as expected");
        softAssert.assertTrue(AddOrdersPage.getInstance().is_ExpectedCashToBeCollected_TxtPresent(), "Expected Cash To Be Collected text is present as expected");
        softAssert.assertTrue(AddOrdersPage.getInstance().is_YouDontHaveAnyScannedShipments_TxtPresent(), "You Don't Have Any Scanned Shipments text is present as expected");

        int cash_Collected_Before_Adding_New_Order = AddOrdersPage.getInstance().get_Expected_Cash();
        AddOrdersPage.getInstance().sendTxtOn_SearchByOrderId_TxtBox(order_Id);
        int cash_Collected_After_Adding_New_Order = AddOrdersPage.getInstance().get_Expected_Cash();
        softAssert.assertTrue(cash_Collected_After_Adding_New_Order > cash_Collected_Before_Adding_New_Order, "Expected Cash to be collected is greater than after adding a new order as expected");
        softAssert.assertTrue(!AddOrdersPage.getInstance().is_YouDontHaveAnyScannedShipments_TxtPresent(), "You Don't Have Any Scanned Shipments text is present as expected");

        AddOrdersPage.getInstance().clickOn_RemoveOrder_Btn();
        cash_Collected_After_Adding_New_Order = AddOrdersPage.getInstance().get_Expected_Cash();

        softAssert.assertEquals(cash_Collected_After_Adding_New_Order, cash_Collected_Before_Adding_New_Order, "Expected Cash to be collected is equals as expected");

        softAssert.assertAll();
    }

}
