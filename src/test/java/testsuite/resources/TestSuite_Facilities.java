package testsuite.resources;

import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.Constants;
import constants.TestGroup;
import framework.common.assertion.JarvisAssert;
import framework.common.assertion.JarvisSoftAssert;
import framework.common.logger.ExtentLogger;
import framework.frontend.actions.ActionHelper;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageobjects.*;
import utility.Utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestSuite_Facilities extends BaseTestClass {
    FacilitiesPage facilitiesPage = FacilitiesPage.getInstance();
    CommonActions commonActions = CommonActions.getInstance();
    AddNewFacilityPage addNewFacilityPage = AddNewFacilityPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    Faker sampleData = new Faker();

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_001, Verify The UI Of Facilities Page")
    public void TC_Facility_001_Verify_The_UI_Of_Facilities_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        softAssert.assertTrue(facilitiesPage.isPresent_Header_Lbl(), "Header Label Is Present As Expected");
        softAssert.assertEquals(facilitiesPage.getText_Header_Lbl(), "Facilities", "Header Label Text Is Matched As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_HomeBreadCrumb_Link(), "Home Bread Crumb Link Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_FacilitiesBreadCrumb_Link(), "Facilities Bread Crumb Link Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_NewFacility_Btn(), "New Facility Button Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_Search_Txt(), "Search Text Field Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_Status_DropDown(), "Status Drop Down Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActions_DropDown(), "More Actions Drop Down Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_PageSize_Txt(), "Page Size Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_PaginationPrevious_Btn(), "Prev Button Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_PaginationNext_Btn(), "Next Button Is Present As Expected");

        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameFacilityId_Lbl(), "Facility Id Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameFacilityName_Lbl(), "Facility Name Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameStatus_Lbl(), "Status Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameAddress_Lbl(), "Address Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameCity_Lbl(), "City Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameState_Lbl(), "State Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNamePostalCode_Lbl(), "Postal Code Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableData_CheckBox(), "Check Box In Table Data Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableDataEdit_Link(), "Edit Link In Table Data Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_002, Verify The UI Of Table Present In Facilities Page")
    public void TC_Facility_002_Verify_The_UI_Of_Table_Present_In_Facilities_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_MoreActions_DropDown();
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownExportAsCSV_Link(), "Export As CSV Link Is Present Under More Actions Drop Down As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumns_Link(), "Modify Columns Link Is Present Under More Actions Drop Down As Expected");
        facilitiesPage.click_MoreActionsDropDownModifyColumns_Link();

        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnsSearch_Txt(), "Search Text Box Inside Modify Columns Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnsSelectAll_Btn(), "Select All Button Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnFacilityId_CheckBox(), "Facility Id Check Box Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnFacilityName_CheckBox(), "Facility Name Check Box Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnStatus_CheckBox(), "Status Check Box Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnAddress_CheckBox(), "Address Check Box Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnCity_CheckBox(), "City Check Box Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnState_CheckBox(), "State Check Box Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnPostalCode_CheckBox(), "Postal Code Check Box Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnCreatedAt_CheckBox(), "Created At Check Box Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnUpdatedAt_CheckBox(), "Updated At Check Box Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnCreatedBy_CheckBox(), "Created By Check Box Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnUpdatedBy_CheckBox(), "Updated By Check Box Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionDropDownModifyColumnCancel_Btn(), "Cancel Button Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnSave_Btn(), "Save Button Is Present As Expected");

        facilitiesPage.click_MoreActionsDropDownModifyColumnsSelectAll_Btn();
        facilitiesPage.click_MoreActionsDropDownModifyColumnSave_Btn();

        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameFacilityId_Lbl(), "Facility Id Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameFacilityName_Lbl(), "Facility Name Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameStatus_Lbl(), "Status Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameAddress_Lbl(), "Address Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameCity_Lbl(), "City Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameState_Lbl(), "State Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNamePostalCode_Lbl(), "Postal Code Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameCreatedAt_Lbl(), "Created At Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameUpdatedAt_Lbl(), "Updated At Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameCreatedBy_Lbl(), "Created By Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameUpdatedBy_Lbl(), "Updated By Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableData_CheckBox(), "Check Box In Table Data Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableDataEdit_Link(), "Edit Link In Table Data Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_003, Verify The UI Of More Actions")
    public void TC_Facility_003_Verify_The_UI_Of_More_Actions() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_MoreActions_DropDown();
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownExportAsCSV_Link(), "Export As CSV Link Is Present Under More Actions Drop Down As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumns_Link(), "Modify Columns Link Is Present Under More Actions Drop Down As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_005, Verify The Functionality Of Search Bar By Facility Name")
    public void TC_Facility_005_Verify_The_Functionality_Of_Search_Bar_By_Facility_Name() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String facilityName = addNewFacilityPage.createNewFacility().get("facilityName");
        facilitiesPage.fill_Search_Txt(facilityName);
        softAssert.assertTrue(commonActions.isPresent_TableData_Lbl("FACILITY NAME"), "Facility Name Data In The Table Is Present As Expected");
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("FACILITY NAME", true), facilityName, "Facility Name Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_006, Verify The Functionality Of Search Bar By Facility Id")
    public void TC_Facility_006_Verify_The_Functionality_Of_Search_Bar_By_Facility_Id() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String facilityId = addNewFacilityPage.createNewFacility().get("facilityId");
        facilitiesPage.fill_Search_Txt(facilityId);
        softAssert.assertTrue(commonActions.isPresent_TableData_Lbl("FACILITY ID"), "Facility Id Data In The Table Is Present As Expected");
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("FACILITY ID", true), facilityId, "Facility Id Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_007, Verify The UI Of Status Button")
    public void TC_Facility_007_Verify_The_UI_Of_Status_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_Status_DropDown();
        softAssert.assertTrue(facilitiesPage.isEnabled_StatusDropDownActiveValue_Radio(), "Active Radio Button Is Enabled As Expected");
        softAssert.assertTrue(facilitiesPage.isEnabled_StatusDropDownPauseValue_Radio(), "Pause Radio Button Is Enabled As Expected");
        softAssert.assertTrue(facilitiesPage.isEnabled_StatusDropDownDeboardValue_Radio(), "Deboard Radio Button Is Enabled As Expected");
        softAssert.assertTrue(facilitiesPage.isEnabled_StatusDropDownInactiveValue_Radio(), "Inactive Radio Button Is Enabled As Expected");
        softAssert.assertTrue(facilitiesPage.isEnabled_StatusDropDownTerminalValue_Radio(), "Terminal Radio Button Is Enabled As Expected");
        softAssert.assertTrue(facilitiesPage.isEnabled_StatusDropDownOnboardingValue_Radio(), "Onboarding Radio Button Is Enabled As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_StatusDropDownClearSelection_Btn(), "Clear Selection Button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_008, Verify The Functionality Of Filter The Facilities With Active Status")
    public void TC_Facility_008_Verify_The_Functionality_Of_Filter_The_Facilities_With_Active_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_Status_RadioBtn("Active");
        if (commonActions.isPresent_EmptyTableMsg_Lbl()) {
            softAssert.assertEquals(commonActions.getText_EmptyTableMsg_Lbl(), "It is Empty here", "Validation Message For Empty Table Is Matched As Expected");
            softAssert.assertTrue(facilitiesPage.isPresent_AddFacility_Btn(), "Add Facility Button Is Present As Expected");
        } else {
            List<String> facilityTableStatusList = commonActions.getList_TableDataList_Lbl("STATUS");
            for (String status : facilityTableStatusList)
                softAssert.assertEquals(status, "Active", "Active Status Is Present As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_009, Verify The Functionality Of Filter The Facilities With Pause Status")
    public void TC_Facility_009_Verify_The_Functionality_Of_Filter_The_Facilities_With_Pause_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_Status_RadioBtn("Pause");
        if (commonActions.isPresent_EmptyTableMsg_Lbl()) {
            softAssert.assertEquals(commonActions.getText_EmptyTableMsg_Lbl(), "It is Empty here", "Validation Message For Empty Table Is Matched As Expected");
            softAssert.assertTrue(facilitiesPage.isPresent_AddFacility_Btn(), "Add Facility Button Is Present As Expected");
        } else {
            List<String> facilityTableStatusList = commonActions.getList_TableDataList_Lbl("STATUS");
            for (String status : facilityTableStatusList)
                softAssert.assertEquals(status, "Pause", "Pause Status Is Present As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_010, Verify The Functionality Of Filter The Facilities With Onboarding Status")
    public void TC_Facility_010_Verify_The_Functionality_Of_Filter_The_Facilities_With_Onboarding_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_Status_RadioBtn("Onboarding");
        if (commonActions.isPresent_EmptyTableMsg_Lbl()) {
            softAssert.assertEquals(commonActions.getText_EmptyTableMsg_Lbl(), "It is Empty here", "Validation Message For Empty Table Is Matched As Expected");
            softAssert.assertTrue(facilitiesPage.isPresent_AddFacility_Btn(), "Add Facility Button Is Present As Expected");
        } else {
            List<String> facilityTableStatusList = commonActions.getList_TableDataList_Lbl("STATUS");
            for (String status : facilityTableStatusList)
                softAssert.assertEquals(status, "Onboarding", "Onboarding Status Is Present As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_011, Verify The Functionality Of Filter The Facilities With Deboard Status")
    public void TC_Facility_011_Verify_The_Functionality_Of_Filter_The_Facilities_With_Deboard_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_Status_RadioBtn("Deboard");
        if (commonActions.isPresent_EmptyTableMsg_Lbl()) {
            softAssert.assertEquals(commonActions.getText_EmptyTableMsg_Lbl(), "It is Empty here", "Validation Message For Empty Table Is Matched As Expected");
            softAssert.assertTrue(facilitiesPage.isPresent_AddFacility_Btn(), "Add Facility Button Is Present As Expected");
        } else {
            List<String> facilityTableStatusList = commonActions.getList_TableDataList_Lbl("STATUS");
            for (String status : facilityTableStatusList)
                softAssert.assertEquals(status, "Deboard", "Deboard Status Is Present As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_012, Verify The Functionality Of Filter The Facilities With InActive Status")
    public void TC_Facility_012_Verify_The_Functionality_Of_Filter_The_Facilities_With_InActive_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_Status_RadioBtn("Inactive");
        if (commonActions.isPresent_EmptyTableMsg_Lbl()) {
            softAssert.assertEquals(commonActions.getText_EmptyTableMsg_Lbl(), "It is Empty here", "Validation Message For Empty Table Is Matched As Expected");
            softAssert.assertTrue(facilitiesPage.isPresent_AddFacility_Btn(), "Add Facility Button Is Present As Expected");
        } else {
            List<String> facilityTableStatusList = commonActions.getList_TableDataList_Lbl("STATUS");
            for (String status : facilityTableStatusList)
                softAssert.assertEquals(status, "Inactive", "Inactive Status Is Present As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_013, Verify The Functionality Of Clear Selection Button In Status")
    public void TC_Facility_013_Verify_The_Functionality_Of_Clear_Selection_Button_In_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();

        List<String> initialStatusList = commonActions.getList_TableDataList_Lbl("STATUS");
        facilitiesPage.click_Status_RadioBtn("Active");
        List<String> tableDataActiveStatus = commonActions.getList_TableDataList_Lbl("STATUS");
        for (String status : tableDataActiveStatus)
            softAssert.assertEquals(status, "Active", "Active Status Is Present As Expected");

        facilitiesPage.click_Status_DropDown();
        facilitiesPage.click_StatusDropDownClearSelection_Btn();
        List<String> currentStatusList = commonActions.getList_TableDataList_Lbl("STATUS");
        for (int i = 0; i < initialStatusList.size(); i++)
            softAssert.assertEquals(currentStatusList.get(i), initialStatusList.get(i), "Status Value Is Same As Initial Status Value As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_014, Verify The Functionality Of Edit Button In Facilities Page")
    public void TC_Facility_014_Verify_The_Functionality_Of_Edit_Button_In_Facilities_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        HashMap<String, String> fillFacilityDetails = new HashMap<>(addNewFacilityPage.createNewFacility());
        HashMap<String, String> getFacilityDetails = new HashMap<>(facilitiesPage.getData_TableFirstData_List());

        softAssert.assertEquals(fillFacilityDetails.get("facilityName"), getFacilityDetails.get("facilityName"), "Facility Name Is Matched As Expected");
        softAssert.assertEquals(fillFacilityDetails.get("postalCode"), getFacilityDetails.get("postalCode"), "Postal Code Is Matched As Expected");
        softAssert.assertContains(getFacilityDetails.get("address"), fillFacilityDetails.get("addressLine1"), "Address Line 1 Is Present In Table As Expected");
        softAssert.assertContains(getFacilityDetails.get("address"), fillFacilityDetails.get("addressLine2"), "Address Line 2 Is Present In Table As Expected");

        facilitiesPage.click_TableDataEdit_Link();
        softAssert.assertTrue(!addNewFacilityPage.isEnabled_FacilityName_Txt(), "Facility Name Text Field Is Disabled As Expected");
        softAssert.assertTrue(!addNewFacilityPage.isEnabled_FacilityId_Txt(), "Facility Id Text Field Is Disabled As Expected");
        softAssert.assertTrue(addNewFacilityPage.isDisabled_Country_Txt(), "Country Text Field Is Disabled As Expected");

        HashMap<String, String> getUpdatedFacilityDetails = new HashMap<>(addNewFacilityPage.fillEditFacilityPage());
        addNewFacilityPage.click_Save_Btn();
        HashMap<String, String> updatedData = new HashMap<>(facilitiesPage.getData_TableFirstData_List());
        softAssert.assertEquals(updatedData.get("facilityId"), getFacilityDetails.get("facilityId"), "Facility Id Is Matched Before And After Update Facility As Expected");
        softAssert.assertEquals(updatedData.get("facilityName"), getFacilityDetails.get("facilityName"), "Facility Name Is Matched Before And After Update Facility As Expected");
        softAssert.assertEquals(getUpdatedFacilityDetails.get("postalCode"), updatedData.get("postalCode"), "Postal Code Is Matched As Expected");
        softAssert.assertContains(updatedData.get("address"), getUpdatedFacilityDetails.get("addressLine1"), "Address Line 1 Is Present In Table As Expected");
        softAssert.assertContains(updatedData.get("address"), getUpdatedFacilityDetails.get("addressLine2"), "Address Line 2 Is Present In Table As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_015, Verify The UI Of Edit Facility")
    public void TC_Facility_015_Verify_The_UI_Of_Edit_Facility() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.createNewFacility();
        facilitiesPage.click_TableDataEdit_Link();

        softAssert.assertTrue(!addNewFacilityPage.isEnabled_FacilityName_Txt(), "Facility Name Text Field Is Disabled As Expected");
        softAssert.assertTrue(!addNewFacilityPage.isEnabled_FacilityId_Txt(), "Facility Id Text Field Is Disabled As Expected");
        softAssert.assertTrue(addNewFacilityPage.isDisabled_Country_Txt(), "Country Text Field Is Disabled As Expected");
        softAssert.assertTrue(!addNewFacilityPage.isEmpty_PostalCode_Txt(), "Postal Code Text Field Is Not Empty As Expected");
        softAssert.assertTrue(!addNewFacilityPage.isEmpty_AddressLine1_Txt(), "Address Line 1 Text Field Is Not Empty As Expected");
        softAssert.assertTrue(!addNewFacilityPage.isEmpty_AddressLine2_Txt(), "Address Line 2 Text Field Is Not Empty As Expected");
        softAssert.assertTrue(!addNewFacilityPage.isEmpty_State_Txt(), "State Text Field Is Not Empty As Expected");
        softAssert.assertTrue(!addNewFacilityPage.isEmpty_City_Txt(), "City Text Field Is Not Empty As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_016, Verify The Functionality Of Cancel Button Of Edit Facility")
    public void TC_Facility_016_Verify_The_Functionality_Of_Cancel_Button_Of_Edit_Facility() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String facilityName = addNewFacilityPage.createNewFacility().get("facilityName");

        facilitiesPage.fill_Search_Txt(facilityName);
        facilitiesPage.click_TableDataEdit_Link();

        HashMap<String, String> fillData = new HashMap<>(addNewFacilityPage.fillEditFacilityPage());
        addNewFacilityPage.click_Cancel_Btn();
        String updatedFacilityPostalCode = fillData.get("postalCode");
        String updatedFacilityCity = fillData.get("city");
        String updatedFacilityState = fillData.get("state");

        facilitiesPage.fill_Search_Txt(facilityName);
        HashMap<String, String> getNewDataFromTable = new HashMap<>(facilitiesPage.getData_TableFirstData_List());
        String newFacilityPostalCode = getNewDataFromTable.get("postalCode");
        String newFacilityCity = getNewDataFromTable.get("city");
        String newFacilityState = getNewDataFromTable.get("state");

        softAssert.assertEquals(facilitiesPage.getText_Header_Lbl(), "Facilities", "Facilities Header Is Present After Clicking On Cancel Button In Edit Facility Page");
        softAssert.assertTrue(!newFacilityPostalCode.equals(updatedFacilityPostalCode), "Facility Postal Code Did Not Matched As Expected");
        softAssert.assertTrue(!newFacilityCity.equals(updatedFacilityCity), "Facility City Name Did Not Matched As Expected");
        softAssert.assertTrue(!newFacilityState.equals(updatedFacilityState), "Facility State Name Did Not Matched As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_018, Verify Functionality Of Pagination Paging Block With Next And Previous Button")
    public void TC_Facility_018_Verify_Functionality_Of_Pagination_Paging_Block_With_Next_And_Previous_Button() {
        commonActions.coverJourneyTillFacility();
        commonActions.chooseNoOfRecordToBeDisplayed(5);
        String firstRecord = commonActions.getList_TableDataList_Lbl("FACILITY NAME").get(0);
        commonActions.click_PaginationNext_Btn();
        String sixthRecord = commonActions.getList_TableDataList_Lbl("FACILITY NAME").get(0);
        JarvisAssert.assertNotEquals(firstRecord, sixthRecord, "The Two Record Names Didn't Matched As Expected");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_020, Verify The Functionality Of Drag The Position Of Modify Columns For More Actions Button")
    public void TC_Facility_020_Verify_The_Functionality_Of_Drag_The_Position_Of_Modify_Columns_For_More_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();

        facilitiesPage.click_MoreActions_DropDown();
        facilitiesPage.click_MoreActionsDropDownModifyColumns_Link();
        List<String> expectedList = facilitiesPage.getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl();
        ExtentLogger.logInfo("Dragging 0th Position Table Column to 1st Position");
        String temp = expectedList.get(0);
        expectedList.add(0, expectedList.get(1));
        expectedList.remove(1);
        expectedList.add(1, temp);
        expectedList.remove(2);
        facilitiesPage.dragAndDrop_MoreActionsDropDownModifyColumnDragOptionsList_Lbl(0, 1);
        List<String> actualList = facilitiesPage.getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl();
        for (int i = 0; i < expectedList.size(); i++)
            softAssert.assertEquals(expectedList.get(i), actualList.get(i), "Drag Options Are In The Same Order As Expected");
        facilitiesPage.click_MoreActionsDropDownModifyColumnSave_Btn();

        facilitiesPage.click_MoreActions_DropDown();
        facilitiesPage.click_MoreActionsDropDownModifyColumns_Link();
        expectedList = facilitiesPage.getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl();
        ExtentLogger.logInfo("Dragging 3rd Position Table Column To 5th Position");
        temp = expectedList.get(3);
        expectedList.add(3, expectedList.get(4));
        expectedList.remove(4);
        expectedList.add(4, expectedList.get(5));
        expectedList.remove(5);
        expectedList.add(5, temp);
        expectedList.remove(6);
        facilitiesPage.dragAndDrop_MoreActionsDropDownModifyColumnDragOptionsList_Lbl(3, 5);
        actualList = facilitiesPage.getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl();
        for (int i = 0; i < expectedList.size(); i++)
            softAssert.assertEquals(expectedList.get(i), actualList.get(i), "Drag Options Are In The Same Order As Expected");
        facilitiesPage.click_MoreActionsDropDownModifyColumnSave_Btn();

        facilitiesPage.click_MoreActions_DropDown();
        facilitiesPage.click_MoreActionsDropDownModifyColumns_Link();
        expectedList = facilitiesPage.getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl();
        ExtentLogger.logInfo("Dragging 5th Position Table Column To 6th Position");
        temp = expectedList.get(5);
        expectedList.add(5, expectedList.get(6));
        expectedList.remove(6);
        expectedList.add(6, temp);
        expectedList.remove(7);
        facilitiesPage.dragAndDrop_MoreActionsDropDownModifyColumnDragOptionsList_Lbl(5, 6);
        actualList = facilitiesPage.getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl();
        for (int i = 0; i < expectedList.size(); i++)
            softAssert.assertEquals(expectedList.get(i), actualList.get(i), "Drag Options Are In The Same Order As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_021, Verify The Functionality Of Checkbox And X Of Modify Columns For More Actions Button")
    public void TC_Facility_021_Verify_The_Functionality_Of_Checkbox_And_X_Of_Modify_Columns_For_More_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_MoreActions_DropDown();
        facilitiesPage.click_MoreActionsDropDownModifyColumns_Link();
        facilitiesPage.click_MoreActionsDropDownModifyColumnsSelectAll_Btn();
        softAssert.assertTrue(facilitiesPage.getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl().contains("City"), "City Column Name Is Present In Drag And Drop Options List As Expected");
        softAssert.assertTrue(facilitiesPage.getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl().contains("State"), "State Column Name Is Present In Drag And Drop Options List As Expected");

        facilitiesPage.click_moreActionsDropDownModifyColumnState_CheckBox();
        facilitiesPage.click_moreActionsDropDownModifyColumnCity_CheckBox();
        softAssert.assertTrue(!facilitiesPage.getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl().contains("City"), "City Column Name Is Absent In Drag And Drop Options List As Expected");
        softAssert.assertTrue(!facilitiesPage.getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl().contains("State"), "State Column Name Is Present In Drag And Drop Options List As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_022, Verify The Functionality Of Search Bar Of Modify Columns For More Actions Button")
    public void TC_Facility_022_Verify_The_Functionality_Of_Search_Bar_Of_Modify_Columns_For_More_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_MoreActions_DropDown();
        facilitiesPage.click_MoreActionsDropDownModifyColumns_Link();
        facilitiesPage.fill_MoreActionsDropDownModifyColumnsSearch_Txt("abcd");
        softAssert.assertTrue(!facilitiesPage.isPresent_MoreActionsDropDownModifyColumnCheckBoxDataList_CheckBox(), "Check Box List Disappeared As Expected");
        facilitiesPage.fill_MoreActionsDropDownModifyColumnsSearch_Txt("facility name");
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnFacilityName_CheckBox(), "Facility Name Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_023, Verify The Functionality Of Cancel Button Of Modify Columns For More Actions Button")
    public void TC_Facility_023_Verify_The_Functionality_Of_Cancel_Button_Of_Modify_Columns_For_More_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_MoreActions_DropDown();
        facilitiesPage.click_MoreActionsDropDownModifyColumns_Link();
        String editFacility = facilitiesPage.getText_MoreActionsDropDownModifyColumnHeader_Lbl();
        softAssert.assertTrue(facilitiesPage.isPresent_MoreActionsDropDownModifyColumnHeader_Lbl(), "Edit Column Header Label Is Present As Expected");
        facilitiesPage.click_MoreActionDropDownModifyColumnCancel_Btn();
        softAssert.assertTrue(facilitiesPage.isPresent_Header_Lbl(), "Facility Header Label Is Matched");
        softAssert.assertTrue(!facilitiesPage.getText_Header_Lbl().equals(editFacility), "Facility Header Label And Edit Facility Header Label Didn't Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_024, Verify The Functionality Of Save Button Of Modify Columns For More Actions Button")
    public void TC_Facility_024_Verify_The_Functionality_Of_Save_Button_Of_Modify_Columns_For_More_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();

        facilitiesPage.click_MoreActions_DropDown();
        facilitiesPage.click_MoreActionsDropDownModifyColumns_Link();
        facilitiesPage.click_MoreActionsDropDownModifyColumnsSelectAll_Btn();

        List<String> headList = facilitiesPage.getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl();

        facilitiesPage.click_MoreActionsDropDownModifyColumnSave_Btn();
        softAssert.assertEqualsIgnoreCase(headList.get(0), facilitiesPage.getText_TableColumnNameFacilityId_Lbl(), "Facility Id Is Matched As Expected");
        softAssert.assertEqualsIgnoreCase(headList.get(1), facilitiesPage.getText_TableColumnNameFacilityName_Lbl(), "Facility Name Is Matched As Expected");
        softAssert.assertEqualsIgnoreCase(headList.get(2), facilitiesPage.getText_TableColumnNameStatus_Lbl(), "Status Is Matched As Expected");
        softAssert.assertEqualsIgnoreCase(headList.get(3), facilitiesPage.getText_TableColumnNameAddress_Lbl(), "Address Is Matched As Expected");

        facilitiesPage.click_MoreActions_DropDown();
        facilitiesPage.click_MoreActionsDropDownModifyColumns_Link();
        facilitiesPage.click_MoreActionsDropDownModifyColumnFacilityId_CheckBox();
        facilitiesPage.click_moreActionsDropDownModifyColumnFacilityName_CheckBox();

        headList = facilitiesPage.getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl();

        facilitiesPage.click_MoreActionsDropDownModifyColumnSave_Btn();
        softAssert.assertEqualsIgnoreCase(headList.get(0), facilitiesPage.getText_TableColumnNameStatus_Lbl(), "Status Appears On 0th Position As Expected");
        softAssert.assertEqualsIgnoreCase(headList.get(1), facilitiesPage.getText_TableColumnNameAddress_Lbl(), "Address Appears On 1st Position As Expected");
        softAssert.assertEqualsIgnoreCase(headList.get(2), facilitiesPage.getText_TableColumnNameCity_Lbl(), "City Appears On 2nd Position As Expected");

        facilitiesPage.click_MoreActions_DropDown();
        facilitiesPage.click_MoreActionsDropDownModifyColumns_Link();
        facilitiesPage.click_MoreActionsDropDownModifyColumnCreatedBy_CheckBox();
        facilitiesPage.click_MoreActionsDropDownModifyColumnUpdatedBy_CheckBox();
        facilitiesPage.click_MoreActionsDropDownModifyColumnFacilityId_CheckBox();
        facilitiesPage.click_moreActionsDropDownModifyColumnFacilityName_CheckBox();
        facilitiesPage.click_MoreActionsDropDownModifyColumnSave_Btn();
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_025, Verify Functionality Of Next Page Pagination Button")
    public void TC_Facility_025_Verify_Functionality_Of_Next_Page_Pagination_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        String currentPaginationCount = commonActions.getText_PaginationCurrentlyShowingCount_Lbl();
        commonActions.click_PaginationNext_Btn();
        softAssert.assertTrue(!commonActions.getText_PaginationCurrentlyShowingCount_Lbl().equals(currentPaginationCount), "Current Page Count Is Different In Both Pages As Expected ");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_017, Verify The Functionality Of Save Button Of Edit Facilities")
    public void TC_Facility_017_Verify_The_Functionality_Of_Save_Button_Of_Edit_Facilities() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();

        facilitiesPage.click_NewFacility_Btn();
        String facilityName = addNewFacilityPage.createNewFacility().get("facilityName");
        facilitiesPage.fill_Search_Txt(facilityName);
        String facilityId = facilitiesPage.getData_TableFirstData_List().get("facilityId");

        facilitiesPage.click_TableDataEdit_Link();
        softAssert.assertEquals(addNewFacilityPage.getText_EditFacilityHeader_Lbl(), "Edit Facility", "Edit Facility Header Is Matched As Expected");
        String newPostalCode = Utility.get_PostalCode_Txt();
        String newAddressLine1 = sampleData.address().streetName();
        addNewFacilityPage.fill_PostalCode_Txt(newPostalCode);
        addNewFacilityPage.fill_AddressLine1_Txt(newAddressLine1);
        addNewFacilityPage.click_Save_Btn();

        HashMap<String, String> getUpdatedFacilityDetails = new HashMap<>(facilitiesPage.getData_TableFirstData_List());
        softAssert.assertEquals(facilityId, getUpdatedFacilityDetails.get("facilityId"), "Facility Id Is Matched As Expected");
        softAssert.assertTrue(getUpdatedFacilityDetails.get("postalCode").equals(newPostalCode), "Postal Code Is Changed As Expected");
        softAssert.assertTrue(getUpdatedFacilityDetails.get("address").contains(newAddressLine1), "Address Line 1 Address Is Changed As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_019, Verify Functionality Of Pagination Per Page With Paging Block And Next Button")
    public void TC_Facility_019_Verify_Functionality_Of_Pagination_Per_Page_With_Paging_Block_And_Next_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();

        commonActions.chooseNoOfRecordToBeDisplayed(10);
        softAssert.assertEquals(commonActions.getList_TableDataList_Lbl("FACILITY ID").size(), 10, "Total Data Counts 10 As Expected");
        String sixthElement = commonActions.getList_TableDataList_Lbl("FACILITY ID").get(5);

        commonActions.chooseNoOfRecordToBeDisplayed(5);
        softAssert.assertEquals(commonActions.getList_TableDataList_Lbl("FACILITY ID").size(), 5, "Total Data Counts 5 As Expected");
        String firstElement = commonActions.getList_TableDataList_Lbl("FACILITY ID").get(0);

        commonActions.click_PaginationNext_Btn();
        softAssert.assertEquals(commonActions.getList_TableDataList_Lbl("FACILITY ID").get(0), sixthElement, "Sixth Record Of First Page And First Record of Second Page Is Matched As Expected");

        commonActions.click_PaginationPrevious_Btn();
        softAssert.assertEquals(commonActions.getList_TableDataList_Lbl("FACILITY ID").get(0), firstElement, "Validate Record Matched As Expected");

        commonActions.select_PaginationBlock_Txt(2);
        softAssert.assertEquals(commonActions.getList_TableDataList_Lbl("FACILITY ID").get(0), sixthElement, "Records Matched On Clicking Pagination Block 2 As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_026, Verify Functionality Of Previous Page Pagination Button")
    public void TC_Facility_026_Verify_Functionality_Of_Previous_Page_Pagination_Button() {
        commonActions.coverJourneyTillFacility();
        commonActions.click_PaginationNext_Btn();
        String currentPaginationCount = commonActions.getText_PaginationCurrentlyShowingCount_Lbl();
        commonActions.click_PaginationPrevious_Btn();
        JarvisAssert.assertNotEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), currentPaginationCount, "Current Page Count Is Different Than Previous Page As Expected ");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_027, Verify Functionality Of Vertically Scroll Of Facilities Table Using Mouse Scroll Wheel")
    public void TC_Facility_027_Verify_Functionality_Of_Vertically_Scroll_Of_Facilities_Table_Using_Mouse_Scroll_Wheel() {
        commonActions.coverJourneyTillFacility();
        commonActions.chooseNoOfRecordToBeDisplayed(20);
        List<WebElement> elements = facilitiesPage.getList_FacilityTableFacilityId_Lbl();
        Utility.validatePageScrollDown(elements.get(elements.size() - 1));
        JarvisAssert.assertTrue(ActionHelper.isPresent(elements.get(elements.size() - 1), 2000), "Validate Last Element Is Present");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_028, Verify Vertically Scroll In Facilities Table Using KeyBoard")
    public void TC_Facility_028_Verify_Vertically_Scroll_In_Facilities_Table_Using_KeyBoard() {
        commonActions.coverJourneyTillFacility();
        commonActions.chooseNoOfRecordToBeDisplayed(20);
        List<WebElement> elements = facilitiesPage.getList_FacilityTableFacilityId_Lbl();
        Utility.scrollDownUsingKeyboardKey(10);
        JarvisAssert.assertTrue(ActionHelper.isPresent(elements.get(elements.size() - 1), 2000), "Validate Last Element Is Present");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_029, Verify Displaying Of Facilities Table Records As Per Pagination Value")
    public void TC_Facility_029_Verify_Displaying_Of_Facilities_Table_Records_As_Per_Pagination_Value() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();

        commonActions.chooseNoOfRecordToBeDisplayed(10);
        List<String> elements = commonActions.getList_TableDataList_Lbl("FACILITY ID");
        softAssert.assertEquals(elements.size(), Integer.parseInt(commonActions.getText_PageSize_Txt()), "Number Of Data Displayed 10 As Expected");

        commonActions.chooseNoOfRecordToBeDisplayed(20);
        elements = commonActions.getList_TableDataList_Lbl("FACILITY ID");
        softAssert.assertEquals(elements.size(), Integer.parseInt(commonActions.getText_PageSize_Txt()), "Number Of Data Displayed 20 As Expected");

        commonActions.chooseNoOfRecordToBeDisplayed(50);
        elements = commonActions.getList_TableDataList_Lbl("FACILITY ID");
        softAssert.assertEquals(elements.size(), Integer.parseInt(commonActions.getText_PageSize_Txt()), "Number Of Data Displayed 50 As Expected");

        commonActions.chooseNoOfRecordToBeDisplayed(5);
        elements = commonActions.getList_TableDataList_Lbl("FACILITY ID");
        softAssert.assertEquals(elements.size(), Integer.parseInt(commonActions.getText_PageSize_Txt()), "Number Of Data Displayed 5 As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_030, Verify Functionality Of Pagination Paging Block")
    public void TC_Facility_030_Verify_Functionality_Of_Pagination_Paging_Block() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        commonActions.select_PaginationBlock_Txt(2);
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(2), "Page 2 Is Selected As Expected");
        commonActions.select_PaginationBlock_Txt(1);
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(1), "Page 1 Is Selected As Expected");
        commonActions.select_PaginationBlock_Txt(3);
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(3), "Page 3 Is Selected As Expected");
        commonActions.select_PaginationBlock_Txt(4);
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(4), "Page 4 Is Selected As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_031, Verify Functionality Of Pagination Paging Block With Next And Previous Button")
    public void TC_Facility_031_Verify_Functionality_Of_Pagination_Paging_Block_With_Next_And_Previous_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        commonActions.click_PaginationNext_Btn();
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(2), "Page 2 Is Selected As Expected");
        commonActions.click_PaginationPrevious_Btn();
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(1), "Page 1 Is Selected As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_032, Verify Functionality Of Pagination Paging Block With Next 5 Pages And Previous 5 Pages Button")
    public void TC_Facility_032_Verify_Functionality_Of_Pagination_Paging_Block_With_Next5Pages_And_Previous5Pages_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        for (int i = 0; i < 5; i++)
            commonActions.click_PaginationNext_Btn();
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(6), "Page 6 Is Selected As Expected");
        for (int i = 0; i < 5; i++)
            commonActions.click_PaginationPrevious_Btn();
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(1), "Page 1 Is Selected As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_033, Verify Functionality Of Pagination Per Page With Paging Block And Next Button")
    public void TC_Facility_033_Verify_Functionality_Of_Pagination_Per_Page_With_Paging_Block_And_Next_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        String firstRecord = commonActions.getText_TableData_Lbl("FACILITY NAME", true);
        commonActions.click_PaginationNext_Btn();
        String sixthRecord = commonActions.getText_TableData_Lbl("FACILITY NAME", true);
        commonActions.click_PaginationPrevious_Btn();
        commonActions.chooseNoOfRecordToBeDisplayed(10);
        List<String> facilityNameRecords = commonActions.getList_TableDataList_Lbl("FACILITY NAME");
        softAssert.assertEquals(facilityNameRecords.get(0), firstRecord, "Facility Name Of 1st Position Is Matched As Expected");
        softAssert.assertEquals(facilityNameRecords.get(5), sixthRecord, "Facility Name Of 6th Position Is Matched With Next Page First Record As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_034, Verify The Functionality Of New Facility Button")
    public void TC_Facility_034_Verify_The_Functionality_Of_New_Facility_Button() {
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        JarvisAssert.assertEquals(addNewFacilityPage.getText_AddNewFacilityHeader_Lbl(), "Add New Facility", "Add New Facility Header Is Matched As Expected");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_036, Verify The Functionality Of CheckBox Present In Facility Table For Any Record")
    public void TC_Facility_036_Verify_The_Functionality_Of_CheckBox_Present_In_Facility_Table_Heading() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.createNewFacility();
        facilitiesPage.click_TableData_CheckBox();
        softAssert.assertTrue(facilitiesPage.isChecked_FirstData_CheckBox(), "Check Box In Table Data Is Checked As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_Deactivate_Btn(), "Deactivate Button Appears As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_037, Verify The Functionality Of Unchecking The CheckBox")
    public void TC_Facility_037_Verify_The_Functionality_Of_Unchecking_The_CheckBox() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.createNewFacility();
        facilitiesPage.click_TableData_CheckBox();
        softAssert.assertTrue(facilitiesPage.isChecked_FirstData_CheckBox(), "Check Box Is Checked As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_Deactivate_Btn(), "Deactivate Button Appears As Expected");
        facilitiesPage.click_TableDataToUnCheck_CheckBox();
        softAssert.assertTrue(!facilitiesPage.isPresent_Deactivate_Btn(), "Deactivate Button Disappeared As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_038, Verify The Functionality Of Deactivate Button")
    public void TC_Facility_038_Verify_The_Functionality_Of_Deactivate_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.createNewFacility();
        facilitiesPage.click_TableData_CheckBox();

        facilitiesPage.click_Deactivate_Btn();
        softAssert.assertTrue(facilitiesPage.isPresent_DeactivateFacilityHeader_Lbl(), "Deactivate Facility Header Is Present As Expected");
        softAssert.assertEquals(facilitiesPage.getText_DeactivateFacilityHeader_Lbl(), "Deactivate Facility", "Deactivate Facility Header Is Matched With Header As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_DeactivateFacilityCancel_Btn(), "Cancel Button In Deactivate Page Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_DeactivateFacilityDeactivate_Btn(), "Deactivate Button In Deactivate Page Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_039, Verify The Functionality Of Cancel Button In Deactivate Page")
    public void TC_Facility_039_Verify_The_Functionality_Of_Cancel_Button_In_Deactivate_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.createNewFacility();
        String facilityPageHeader = facilitiesPage.getText_Header_Lbl();
        String statusOfData = commonActions.getText_TableData_Lbl("STATUS", true);
        facilitiesPage.click_TableData_CheckBox();
        softAssert.assertTrue(facilitiesPage.isPresent_Deactivate_Btn(), "Deactivate Button Above Table Appears As Expected");

        facilitiesPage.click_Deactivate_Btn();
        softAssert.assertEquals(facilitiesPage.getText_DeactivateFacilityHeader_Lbl(), "Deactivate Facility", "Deactivate Facility Header Is Matched As Expected");
        facilitiesPage.click_DeactivateFacilityCancel_Btn();
        softAssert.assertEquals(facilitiesPage.getText_Header_Lbl(), facilityPageHeader, "Facility Header Is Matched As Expected");
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("STATUS", true), statusOfData, "Status Is Active And Didn't Changed As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_040, Verify The Functionality Of Deactivate Button In Deactivate Page")
    public void TC_Facility_040_Verify_The_Functionality_Of_Deactivate_Button_In_Deactivate_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.createNewFacility();
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("STATUS", true), "Active", "Status Is Active As Expected");
        facilitiesPage.click_TableData_CheckBox();
        JarvisAssert.assertTrue(facilitiesPage.isPresent_Deactivate_Btn(), "Deactivate Button Above Table Appears As Expected");

        facilitiesPage.click_Deactivate_Btn();
        softAssert.assertTrue(facilitiesPage.isPresent_DeactivateFacilityHeader_Lbl(), "Deactivate Facility Header Label Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_DeactivateFacilityCancel_Btn(), "Deactivate Facility Cancel Button Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_DeactivateFacilityDeactivate_Btn(), "Deactivate Facility Deactivate Button Is Present As Expected");

        facilitiesPage.click_DeactivateFacilityDeactivate_Btn();
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("STATUS", true), "Inactive", "Status Changed To Inactive As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_041, Verify The UI Of Add New Facility Page")
    public void TC_Facility_041_Verify_The_UI_Of_Add_New_Facility_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        softAssert.assertEquals(addNewFacilityPage.getText_AddNewFacilityHeader_Lbl(), "Add New Facility", "Add New Facility Header Label Is Matched As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_AddNewFacility_BreadCrumb(), "Add New Facility Bread Crumb Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_BasicDetailsSubHeader_Lbl(), "Basic Details Sub Header Label Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_FacilityName_Lbl(), "Facility Name Label Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_FacilityId_Txt(), "Facility Name Text Field Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_FacilityId_Lbl(), "Facility Id Label Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_FacilityId_Txt(), "Facility Id Text Field Is Present As Expected");

        softAssert.assertTrue(addNewFacilityPage.isPresent_AddressDetailsSubHeader_Lbl(), "Address Detail Sub Header Label Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_PostalCode_Lbl(), "Postal Code Label Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_PostalCode_Txt(), "Postal Code Text Field Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_Country_Lbl(), "Country Label Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_Country_Txt(), "Country Text Field Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isDisabled_Country_Txt(), "Country Text Field Is Disabled As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_AddressLine1_Lbl(), "Address Line 1 Label Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_AddressLine1_Txt(), "Address Line 1 Text Field Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_AddressLine2_Lbl(), "Address Line 2 Label Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_AddressLine2_Txt(), "Address Line 2 Text Field Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_City_Lbl(), "City Label Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_City_Txt(), "City Text Field Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_State_Lbl(), "State Label Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_State_Txt(), "State Text Field Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_Cancel_Btn(), "Cancel Button Is Present As Expected");
        softAssert.assertTrue(addNewFacilityPage.isPresent_Create_Btn(), "Create Button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_042, Verify The Functionality Of Breadcrumb Menu For Add New Facility Page")
    public void TC_Facility_042_Verify_The_Functionality_Of_Breadcrumb_Menu_For_Add_New_Facility_Page() {
        commonActions.coverJourneyTillFacility();
        String facilityHeader = facilitiesPage.getText_Header_Lbl();
        facilitiesPage.click_NewFacility_Btn();
        facilitiesPage.click_FacilitiesBreadCrumb_Link();
        JarvisAssert.assertEquals(facilitiesPage.getText_Header_Lbl(), facilityHeader, "Facility Header Is Matched As Expected");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_043, Verify The Functionality Of Cancel Button In Add New Facility Page")
    public void TC_Facility_043_Verify_The_Functionality_Of_Cancel_Button_In_Add_New_Facility_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();

        facilitiesPage.click_NewFacility_Btn();
        String facilityName = addNewFacilityPage.createNewFacility().get("facilityName");
        facilitiesPage.fill_Search_Txt(facilityName);
        HashMap<String, String> expectedFacilityTableDetails = new HashMap<>(facilitiesPage.getData_TableFirstData_List());

        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.click_Cancel_Btn();
        HashMap<String, String> actualFacilityTableDetails = new HashMap<>(facilitiesPage.getData_TableFirstData_List());

        softAssert.assertEquals(expectedFacilityTableDetails.get("facilityId"), actualFacilityTableDetails.get("facilityId"), "Facility Id Is Not Changed As Expected");
        softAssert.assertEquals(expectedFacilityTableDetails.get("facilityName"), actualFacilityTableDetails.get("facilityName"), "Facility Name Is Not Changed As Expected");
        softAssert.assertEquals(expectedFacilityTableDetails.get("postalCode"), actualFacilityTableDetails.get("postalCode"), "Postal Code Is Not Changed As Expected");
        softAssert.assertEquals(expectedFacilityTableDetails.get("city"), actualFacilityTableDetails.get("city"), "City Name Is Not Changed As Expected");
        softAssert.assertEquals(expectedFacilityTableDetails.get("state"), actualFacilityTableDetails.get("state"), "State Name Is Not Changed As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_044, Verify The Validation Functionality For Name In Add New Facility Page For Empty Field")
    public void TC_Facility_044_Verify_The_Validation_Functionality_For_Name_In_Add_New_Facility_Page_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        softAssert.assertEquals(addNewFacilityPage.getText_AddNewFacilityHeader_Lbl(), "Add New Facility", "Add New Facility Header Is Matched As Expected");
        addNewFacilityPage.fill_PostalCode_Txt(Utility.get_PostalCode_Txt());
        addNewFacilityPage.fill_AddressLine1_Txt(sampleData.address().streetName().replaceAll("[^a-zA-Z0-9]", ""));
        addNewFacilityPage.fill_AddressLine2_Txt(sampleData.address().streetName().replaceAll("[^a-zA-Z0-9]", ""));
        addNewFacilityPage.click_Create_Btn();
        softAssert.assertEquals(addNewFacilityPage.getText_FacilityNameErrorMsg_Lbl(), "Required", "Facility Name Required Error Message Appeared As Expected");
        softAssert.assertAll();
    }

    @Test(enabled = false, groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_004, Verify The Functionality Of Export As CSV For More Actions Button")
    public void TC_Facility_004_Verify_The_Functionality_Of_Export_As_CSV_For_More_Actions_Button() throws IOException {
        new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "temp" + System.getProperty("file.separator"));
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_MoreActions_DropDown();
        facilitiesPage.click_MoreActionsDropDownExportAsCSV_Link();
        JarvisAssert.assertTrue(Utility.validateFileDownloadedSuccessfully(System.getProperty("user.dir") + System.getProperty("file.separator") + "temp" + System.getProperty("file.separator"), "facilities_list.csv", 10));
    }

    @Test(enabled = false, groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_035, Verify The Functionality Of CheckBox Present In Facility Table Heading")
    public void TC_Facility_035_Verify_The_Functionality_Of_CheckBox_Present_In_Facility_Table_Heading() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.createNewFacility();
        facilitiesPage.check_TableColumnSelectAll_CheckBox();
        List<String> checkBoxClassList = new ArrayList<>(facilitiesPage.getClass_CheckBox_List());
        for (String checkBox : checkBoxClassList) {
            softAssert.assertTrue(checkBox.contains("wrapper-checked"), "Table Data Is Checked As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_045, Verify The Validation Functionality For Name In Add New Facility Page For Minimum Character")
    public void TC_Facility_045_Verify_The_Validation_Functionality_For_Name_In_Add_New_Facility_Page_For_Minimum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String[] facilityNameSampleData = {"q", "1", "@"};
        for (String facilityName : facilityNameSampleData) {
            addNewFacilityPage.fill_FacilityName_Txt(facilityName);
            addNewFacilityPage.click_Create_Btn();
            softAssert.assertEquals(addNewFacilityPage.getText_FacilityNameErrorMsg_Lbl(), "Should be minimum 3", "Facility Name Minimum Character Error Message Appeared As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_046, Verify The Validation Functionality For Name In Add New Facility Page For Maximum Character")
    public void TC_Facility_046_Verify_The_Validation_Functionality_For_Name_In_Add_New_Facility_Page_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        softAssert.assertEquals(addNewFacilityPage.getText_AddNewFacilityHeader_Lbl(), "Add New Facility", "Add New Facility Header Is Matched As Expected");
        addNewFacilityPage.fill_FacilityName_Txt(Utility.generateRandomString(50));
        addNewFacilityPage.click_Create_Btn();
        softAssert.assertEquals(addNewFacilityPage.getText_FacilityNameErrorMsg_Lbl(), "Can be at max 32", "Facility Name Maximum Character Error Message Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_047, Verify The Validation Functionality For Facility ID In Add New Facility Page For Empty Field")
    public void TC_Facility_047_Verify_The_Validation_Functionality_For_Facility_ID_In_Add_New_Facility_Page_For_Empty_Field() {
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.fill_FacilityName_Txt("Facility " + sampleData.name().lastName());
        String emptyFacilityId = "";
        addNewFacilityPage.fill_FacilityId_Txt(emptyFacilityId);
        addNewFacilityPage.click_Create_Btn();
        JarvisAssert.assertEquals(addNewFacilityPage.getText_FacilityIdErrorMsg_Lbl(), "Required", "Facility Id Required Error Message Is Present As Expected");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_048, Verify The Validation Functionality For Facility ID In Add New Facility Page For Minimum Character")
    public void TC_Facility_048_Verify_The_Validation_Functionality_For_Facility_ID_In_Add_New_Facility_Page_For_Minimum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.fill_FacilityName_Txt("Facility " + sampleData.name().lastName());
        String[] sampleData = {"q", "1", "@"};
        for (String facilityId : sampleData) {
            addNewFacilityPage.fill_FacilityId_Txt(facilityId);
            addNewFacilityPage.click_Create_Btn();
            softAssert.assertEquals(addNewFacilityPage.getText_FacilityIdErrorMsg_Lbl(), "Should be minimum 3", "Facility Id Minimum Character Error Message Appeared As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_049, Verify The Validation Functionality For Facility ID In Add New Facility Page For Maximum Character")
    public void TC_Facility_049_Verify_The_Validation_Functionality_For_Facility_ID_In_Add_New_Facility_Page_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String sampleFacilityId = Utility.generateRandomString(40);
        softAssert.assertEquals(addNewFacilityPage.getText_AddNewFacilityHeader_Lbl(), "Add New Facility", "Add New Facility Header Is Matched As Expected");
        addNewFacilityPage.fill_FacilityId_Txt(sampleFacilityId);
        addNewFacilityPage.click_Create_Btn();
        softAssert.assertEquals(addNewFacilityPage.getText_FacilityIdErrorMsg_Lbl(), "Can be at max 32", "Facility Id Maximum Character Error Message Appeared As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_050, Verify The Validation Functionality For PostalCode In Add New Facility Page For Empty Field")
    public void TC_Facility_050_Verify_The_Validation_Functionality_For_PostalCode_In_Add_New_Facility_Page_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        softAssert.assertEquals(addNewFacilityPage.getText_AddNewFacilityHeader_Lbl(), "Add New Facility", "Add New Facility Header Is Matched As Expected");

        addNewFacilityPage.fill_FacilityName_Txt("Facility " + sampleData.name().lastName());
        addNewFacilityPage.fill_AddressLine1_Txt(sampleData.address().streetName());
        addNewFacilityPage.fill_AddressLine2_Txt(sampleData.address().streetName());

        addNewFacilityPage.click_Create_Btn();

        softAssert.assertEquals(addNewFacilityPage.getText_PostalCodeErrorMsg_Lbl(), "Required", "Postal Code Required Error Message Appeared As Expected");
        softAssert.assertEquals(addNewFacilityPage.getText_StateErrorMsg_Lbl(), "Required", "State Required Error Message Appeared As Expected");
        softAssert.assertEquals(addNewFacilityPage.getText_CityErrorMsg_Lbl(), "Required", "City Required Error Message Appeared As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_051, Verify The Validation Functionality For PostalCode In Add New Facility Page For Minimum Character")
    public void TC_Facility_051_Verify_The_Validation_Functionality_For_PostalCode_In_Add_New_Facility_Page_For_Minimum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String[] postalCodeSampleData = {"34", "1", "980"};
        for (String postalCode : postalCodeSampleData) {
            addNewFacilityPage.fill_PostalCode_Txt(postalCode);
            softAssert.assertEquals(addNewFacilityPage.getText_PopUpErrorMsg_Lbl(), "Pincode data not found.", "Pin Code Data Not Found Message Appears As Expected");
            addNewFacilityPage.click_Create_Btn();
            softAssert.assertEquals(addNewFacilityPage.getText_PostalCodeErrorMsg_Lbl(), "Not correct format", "Postal Code Minimum Character Error Message Appeared As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_052, Verify The Validation Functionality For PostalCode In Add New Facility Page For Maximum Character")
    public void TC_Facility_052_Verify_The_Validation_Functionality_For_PostalCode_In_Add_New_Facility_Page_For_Maximum_Character() throws IllegalAccessError {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.fill_PostalCode_Txt(String.valueOf(sampleData.number().digits(15)));
        softAssert.assertEquals(addNewFacilityPage.getText_PopUpErrorMsg_Lbl(), "Pincode data not found.", "Pin Code Data Not Found Message Appeared As Expected");
        addNewFacilityPage.click_Create_Btn();
        softAssert.assertEquals(addNewFacilityPage.getText_PostalCodeErrorMsg_Lbl(), "Not correct format", "Postal Code Maximum Character Error Message Appeared As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_053, Verify The Validation Functionality For PostalCode In Add New Facility Page For Other Than Numeric Value")
    public void TC_Facility_053_Verify_The_Validation_Functionality_For_PostalCode_In_Add_New_Facility_Page_For_Other_Than_Numeric_Value() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String[] invalidPostalCode = {"@", "112#$dsw", "acvf", "32^_WR988"};
        for (String postalCode : invalidPostalCode) {
            addNewFacilityPage.fill_PostalCode_Txt(postalCode);
            softAssert.assertEquals(addNewFacilityPage.getText_PopUpErrorMsg_Lbl(), "Pincode data not found.", "Pin Code Data Not Found Message Pop Up Appeared As Expected");
            addNewFacilityPage.click_Create_Btn();
            softAssert.assertEquals(addNewFacilityPage.getText_PostalCodeErrorMsg_Lbl(), "Not correct format", "Postal Code Incorrect Format Error Message Appeared As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_054, Verify The Functionality Of Postal Code With Valid Data")
    public void TC_Facility_054_Verify_The_Functionality_Of_Postal_Code_With_Valid_Data() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        String validPostalCode = Utility.get_PostalCode_Txt();
        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.fill_FacilityName_Txt("Facility " + sampleData.name().lastName());
        addNewFacilityPage.fill_PostalCode_Txt(validPostalCode);
        commonActions.waitTillLoaderDisappears();
        addNewFacilityPage.fill_AddressLine1_Txt(sampleData.address().streetName());
        addNewFacilityPage.fill_AddressLine2_Txt(sampleData.address().streetName());
        softAssert.assertTrue(!addNewFacilityPage.isPresent_PopUpErrorMsg_Lbl(), "Pop Up Error Message Is Not Present As Expected");
        addNewFacilityPage.click_Create_Btn();
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("POSTAL CODE", true), validPostalCode, "Postal Code Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_055, Verify The Validation Functionality For Postal Code In Add New Facility Page With Invalid Postal Code")
    public void TC_Facility_055_Verify_The_Validation_Functionality_For_Postal_Code_In_Add_New_Facility_Page_With_Invalid_Postal_Code() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.fill_PostalCode_Txt("123456789");
        softAssert.assertEquals(addNewFacilityPage.getText_PopUpErrorMsg_Lbl(), "Pincode data not found.", "Pin Code Data Not Found Text Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_056, Verify Functionality For Country DropDown In Add New Facility Page")
    public void TC_Facility_056_Verify_Functionality_For_Country_DropDown_In_Add_New_Facility_Page() {
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        JarvisAssert.assertTrue(addNewFacilityPage.isDisabled_Country_Txt(), "Country Text Field Is Disabled As Expected");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_057, Verify The Validation Functionality For Address Line 1 In Add New Facility Page For Empty Field")
    public void TC_Facility_057_Verify_The_Validation_Functionality_For_AddressLine1_In_Add_New_Facility_Page_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.fill_FacilityName_Txt("Facility " + sampleData.name().lastName());
        addNewFacilityPage.fill_PostalCode_Txt(Utility.get_PostalCode_Txt());
        addNewFacilityPage.fill_AddressLine2_Txt(sampleData.address().streetName());
        addNewFacilityPage.click_Create_Btn();
        softAssert.assertEquals(addNewFacilityPage.getText_AddressLine1ErrorMsg_Lbl(), "Required", "Address Line 1 Required Error Message Appeared As Expected");
        softAssert.assertAll();
    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_058, Verify The Validation Functionality For Address Line 1 In Add New Facility Page For Minimum Character")
    public void TC_Facility_058_Verify_The_Validation_Functionality_For_AddressLine1_In_Add_New_Facility_Page_For_Minimum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String[] addressLine1SampleData = {"q", "1", "@"};
        for (String addressLine1 : addressLine1SampleData) {
            addNewFacilityPage.fill_AddressLine1_Txt(addressLine1);
            addNewFacilityPage.click_Create_Btn();
            softAssert.assertEquals(addNewFacilityPage.getText_AddressLine1ErrorMsg_Lbl(), "Should be minimum 2", "Address Line 1 Minimum Character Error Message Appeared As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_059, Verify The Validation Functionality For Address Line 1 In Add New Facility Page For Maximum Character")
    public void TC_Facility_059_Verify_The_Validation_Functionality_For_AddressLine1_In_Add_New_Facility_Page_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String addressLine1 = Utility.generateRandomString(140);
        addNewFacilityPage.fill_AddressLine1_Txt(addressLine1);
        addNewFacilityPage.click_Create_Btn();
        softAssert.assertEquals(addNewFacilityPage.getText_AddressLine1ErrorMsg_Lbl(), "Can be at max 24", "Address Line 1 Maximum Character Validation Message Appeared As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_060, Verify The Validation Functionality For Address Line 2 In Add New Facility Page For Empty Field")
    public void TC_Facility_060_Verify_The_Validation_Functionality_For_AddressLine2_In_Add_New_Facility_Page_For_Empty_Field() {
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String facilityName = "Facility " + sampleData.name().lastName().replaceAll("[^a-zA-Z0-9]", "");
        String facilityId = addNewFacilityPage.getText_FacilityId_Txt();
        addNewFacilityPage.fill_FacilityName_Txt(facilityName);
        addNewFacilityPage.fill_PostalCode_Txt(Utility.get_PostalCode_Txt());
        commonActions.waitTillLoaderDisappears();
        addNewFacilityPage.fill_AddressLine1_Txt(sampleData.address().streetName());
        addNewFacilityPage.click_Create_Btn();
        commonActions.waitTillLoaderDisappears();

        facilitiesPage.fill_Search_Txt(facilityName);
        JarvisAssert.assertEquals(commonActions.getText_TableData_Lbl("FACILITY ID", true), facilityId, "Facility Is Created With Empty Address Line 2 As Expected");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_061, Verify The Validation Functionality For Address Line 2 In Add New Facility Page For Minimum Character")
    public void TC_Facility_061_Verify_The_Validation_Functionality_For_AddressLine2_In_Add_New_Facility_Page_For_Minimum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String[] addressLine2SampleData = {"q", "1", "@"};
        for (String addressLine2 : addressLine2SampleData) {
            addNewFacilityPage.fill_AddressLine2_Txt(addressLine2);
            addNewFacilityPage.click_Create_Btn();
            softAssert.assertEquals(addNewFacilityPage.getText_AddressLine2ErrorMsg_Lbl(), "Should be minimum 2", "Address Line 2 Minimum Character Error Message Appeared As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_062, Verify The Validation Functionality For Address Line 2 In Add New Facility Page For Maximum Character")
    public void TC_Facility_062_Verify_The_Validation_Functionality_For_AddressLine2_In_Add_New_Facility_Page_For_Maximum_Character() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String addressLine2 = Utility.generateRandomString(140);
        addNewFacilityPage.fill_AddressLine2_Txt(addressLine2);
        addNewFacilityPage.click_Create_Btn();
        softAssert.assertEquals(addNewFacilityPage.getText_AddressLine2ErrorMsg_Lbl(), "Can be at max 130", "Address Line 2 Maximum Character Validation Message Appeared As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_063, Verify The Functionality Of Add New Facility Page Without Entering Mandatory Fields")
    public void TC_Facility_063_Verify_The_Functionality_Of_Add_New_Facility_Page_Without_Entering_Mandatory_Fields() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        addNewFacilityPage.click_Create_Btn();
        softAssert.assertEquals(addNewFacilityPage.getText_FacilityNameErrorMsg_Lbl(), "Required", "Facility Name Required Error Message Appeared As Expected");
        softAssert.assertEquals(addNewFacilityPage.getText_PostalCodeErrorMsg_Lbl(), "Required", "Postal Code Required Error Message Appeared As Expected");
        softAssert.assertEquals(addNewFacilityPage.getText_AddressLine1ErrorMsg_Lbl(), "Required", "Address Line 1 Required Error Message Appeared As Expected");
        softAssert.assertEquals(addNewFacilityPage.getText_StateErrorMsg_Lbl(), "Required", "State Required Error Message Appeared As Expected");
        softAssert.assertEquals(addNewFacilityPage.getText_CityErrorMsg_Lbl(), "Required", "City Required Error Message Appeared As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_064, Verify The Functionality Of Add New Facility Page With Duplicate Facility ID")
    public void TC_Facility_064_Verify_The_Functionality_Of_Add_New_Facility_Page_With_Duplicate_Facility_ID() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();

        facilitiesPage.click_NewFacility_Btn();
        String facilityName = addNewFacilityPage.createNewFacility().get("facilityName");
        facilitiesPage.fill_Search_Txt(facilityName);
        String duplicateFacilityId = facilitiesPage.getData_TableFirstData_List().get("facilityId");

        facilitiesPage.click_NewFacility_Btn();
        String expectedErrorPopMsg = "In participant create request, participant with given unique code is already exists";
        addNewFacilityPage.fill_FacilityName_Txt("Facility " + sampleData.name().lastName());
        addNewFacilityPage.fill_FacilityId_Txt(duplicateFacilityId);
        addNewFacilityPage.fillEditFacilityPage();
        addNewFacilityPage.click_Create_Btn();
        softAssert.assertEquals(addNewFacilityPage.getText_DuplicateIdErrorMsgPopUp_Lbl(), expectedErrorPopMsg, "Duplicate Id Validation Error Message Appeared As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_065, Verify The Functionality Of Create Button In Add New Facility Page")
    public void TC_Facility_065_Verify_The_Functionality_Of_Create_Button_In_Add_New_Facility_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String facilityName = addNewFacilityPage.createNewFacility().get("facilityName");
        facilitiesPage.fill_Search_Txt(facilityName);
        softAssert.assertTrue(commonActions.isPresent_TableData_Lbl("FACILITY NAME"), "Facility Name Data In The Table Is Present As Expected");
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("FACILITY NAME", true), facilityName, "Facility Name Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_066, Verify The Functionality Of Dock And Undock For Resources")
    public void TC_Facility_066_Verify_The_Functionality_Of_Dock_And_Undock_For_Resources() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().performCommonAction();
        CommonActions.getInstance().click_SkipIfPresent_Btn();
        homePage.selectTeam(Constants.TEAM);
        softAssert.assertTrue(homePage.isPresent_ResourcesMenu_Btn(), "Resources Menu Button Is Present As Expected");
        homePage.click_Resources_Btn();
        softAssert.assertTrue(homePage.isPresent_FacilitiesMenuItem_Btn(), "Facilities Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_RidersMenu_Btn(), "Riders Menu Button Is Present As Expected");

        homePage.click_Resources_Btn();
        softAssert.assertTrue(!homePage.isPresent_FacilitiesMenuItem_Btn(), "Facilities Menu Button Is Present As Expected");
        softAssert.assertTrue(!homePage.isPresent_RidersMenu_Btn(), "Riders Menu Button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_067, Verify The Functionality Of Dock And Undock For Resources")
    public void TC_Facility_067_Verify_The_Functionality_Of_Dock_And_Undock_For_Resources() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();

        homePage.unExpand_LeftPanel_Btn();
        softAssert.assertTrue(!homePage.isPresent_OrdersMenu_Btn(), "Orders Icon Is Present As Expected");
        softAssert.assertTrue(!homePage.isPresent_DispatchMenu_Btn(), "Dispatch Icon Is Present As Expected");
        softAssert.assertTrue(!homePage.isPresent_ResourcesMenu_Btn(), "Resources Icon Is Present As Expected");
        softAssert.assertTrue(!homePage.isPresent_TeamsMenu_Btn(), "Teams Icon Is Present As Expected");
        softAssert.assertTrue(!homePage.isPresent_SettingsMenu_Btn(), "Settings Icon Is Present As Expected");

        homePage.expand_LeftPanel_Btn();
        softAssert.assertTrue(homePage.isPresent_OrdersMenu_Btn(), "Orders Menu Button Along With Icon Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_DispatchMenu_Btn(), "Dispatch Menu Button Along With Icon Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_ResourcesMenu_Btn(), "Resources Menu Button Along With Icon Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_TeamsMenu_Btn(), "Teams Menu Button Along With Icon Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_SettingsMenu_Btn(), "Settings Menu Button Along With Icon Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_068, Verify The Functionality Of Open Menu")
    public void TC_Facility_068_Verify_The_Functionality_Of_Open_Menu() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        softAssert.assertTrue(homePage.isPresent_OpenMenu_Btn(), "Open Menu Button Is Present As Expected");

        homePage.click_OpenMenu_Btn();
        softAssert.assertTrue(homePage.isPresent_OpenMenuOrders_Btn(), "Open Menu Orders Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuCreateOrders_Btn(), "Create Order Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuViewOrders_Btn(), "View Order Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuRouting_Btn(), "Open Menu Routing Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuDispatch_Btn(), "Open Menu Dispatch Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuRiders_Btn(), "Open Menu Riders Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuFacilities_Btn(), "Open Menu Facilities Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuTeams_Btn(), "Open Menu Teams Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuSettings_Btn(), "Open Menu Settings Button Is Present As Expected");

        homePage.click_OpenMenuFacility_Btn();
        softAssert.assertEquals(facilitiesPage.getText_Header_Lbl(), "Facilities", "Facility Page Opened As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_069, Verify The Functionality Of Cross Button(X) Of Open Menu")
    public void TC_Facility_069_Verify_The_Functionality_Of_Cross_Button_Of_Open_Menu() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        homePage.click_OpenMenu_Btn();
        homePage.click_OpenMenuFacility_Btn();
        softAssert.assertEquals(facilitiesPage.getText_Header_Lbl(), "Facilities", "Facility Page Opened As Expected");

        homePage.click_OpenMenu_Btn();
        homePage.click_OpenMenuCross_Btn();
        softAssert.assertEquals(facilitiesPage.getText_Header_Lbl(), "Facilities", "Facilities Header Is Matched, Page Didn't Change As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_070, Verify The Functionality Of Workflow Button")
    public void TC_Facility_070_Verify_The_Functionality_Of_Workflow_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        softAssert.assertTrue(homePage.isPresent_WorkFlowOs1_Link(), "OS1 Work Flow Link Is Present As Expected");

        homePage.click_WorkFlowOs1_Link();
        softAssert.assertTrue(homePage.isPresent_WorkFlowOrders_Btn(), "Work Flow Orders Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_WorkFlowRouting_Btn(), "Work Flow Routing Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_WorkFlowDispatch_Btn(), "Work Flow Dispatched Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_WorkFlowRiders_Btn(), "Work Flow Riders Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_WorkFlowFacilities_Btn(), "Work Flow Facility Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_WorkFlowTeams_Btn(), "Work Flow Team Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_WorkFlowSettings_Btn(), "Work Flow Setting Button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_071, Verify The Functionality Of Facilities Button Of Workflow")
    public void TC_Facility_071_Verify_The_Functionality_Of_Facilities_Button_Of_Workflow() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        String expectedFacilityPageHeader = facilitiesPage.getText_Header_Lbl();
        homePage.click_WorkFlowOs1_Link();
        homePage.click_WorkFlowFacilities_Btn();
        softAssert.assertEquals(facilitiesPage.getText_Header_Lbl(), expectedFacilityPageHeader, "Facility Header Label Is Matched As Expected");
        softAssert.assertAll();
    }
}
