package testsuite.resources;

import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.Constants;
import constants.TestGroup;
import framework.backend.APIResponseException;
import framework.common.assertion.JarvisAssert;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.actions.ActionHelper;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageobjects.*;
import utility.Utility;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TestSuite_Facilities extends BaseTestClass {
    FacilitiesPage facilitiesPage = FacilitiesPage.getInstance();
    CommonActions commonActions = CommonActions.getInstance();
    AddNewFacilityPage addNewFacilityPage = AddNewFacilityPage.getInstance();
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
        softAssert.assertTrue(facilitiesPage.isPresent_PageSize(), "Page Size Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_Prev_Btn(), "Prev Button Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_Next_Btn(), "Next Button Is Present As Expected");

        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameFacilityId(), "Facility Id Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameFacilityName(), "Facility Name Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameStatus(), "Status Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameAddress(), "Address Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameCity(), "City Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameState(), "State Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNamePostalCode(), "Postal Code Table Column Is Present As Expected");
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

        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameFacilityId(), "Facility Id Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameFacilityName(), "Facility Name Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameStatus(), "Status Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameAddress(), "Address Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameCity(), "City Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameState(), "State Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNamePostalCode(), "Postal Code Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameCreatedAt(), "Created At Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameUpdatedAt(), "Updated At Table Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameCreatedBy(), "Created By Column Is Present As Expected");
        softAssert.assertTrue(facilitiesPage.isPresent_TableColumnNameUpdatedBy(), "Updated By Column Is Present As Expected");
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
    public void TC_Facility_005_Verify_The_Functionality_Of_Search_Bar_By_Facility_Name() throws APIResponseException, IOException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String facilityName = addNewFacilityPage.createFacility().get("facilityName");
        facilitiesPage.fill_Search_Txt(facilityName);
        softAssert.assertTrue(facilitiesPage.isPresent_TableDataFacilityName_Lbl(), "Facility Name Data In The Table Is Present As Expected");
        softAssert.assertEquals(facilitiesPage.getText_TableDataFacilityName_Lbl(), facilityName, "Facility Name Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_006, Verify The Functionality Of Search Bar By Facility Id")
    public void TC_Facility_006_Verify_The_Functionality_Of_Search_Bar_By_Facility_Id() throws APIResponseException, IOException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_NewFacility_Btn();
        String facilityId = addNewFacilityPage.createFacility().get("facilityId");
        facilitiesPage.fill_Search_Txt(facilityId);
        softAssert.assertTrue(facilitiesPage.isPresent_TableDataFacilityId_Lbl(), "Facility Id Data In The Table Is Present As Expected");
        softAssert.assertEquals(facilitiesPage.getText_TableDataFacilityId_Lbl(), facilityId, "Facility Id Is Matched As Expected");
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
        facilitiesPage.click_Status_DropDown();
        facilitiesPage.click_StatusDropDownActiveValue_Radio();
        for (String status : facilitiesPage.getList_FacilityTableStatus_Lbl())
            softAssert.assertEquals(status, "Active", "Active Status Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_009, Verify The Functionality Of Filter The Facilities With Pause Status")
    public void TC_Facility_009_Verify_The_Functionality_Of_Filter_The_Facilities_With_Pause_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_Status_DropDown();
        facilitiesPage.click_StatusDropDownPauseValue_Radio();
        for (String status : facilitiesPage.getList_FacilityTableStatus_Lbl())
            softAssert.assertEquals(status, "Pause", "Pause Status Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_010, Verify The Functionality Of Filter The Facilities With Onboarding Status")
    public void TC_Facility_010_Verify_The_Functionality_Of_Filter_The_Facilities_With_Onboarding_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_Status_DropDown();
        facilitiesPage.click_StatusDropDownOnboardingValue_Radio();
        for (String status : facilitiesPage.getList_FacilityTableStatus_Lbl())
            softAssert.assertEquals(status, "Onboarding", "Pause Status Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_011, Verify The Functionality Of Filter The Facilities With Deboard Status")
    public void TC_Facility_011_Verify_The_Functionality_Of_Filter_The_Facilities_With_Deboard_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_Status_DropDown();
        facilitiesPage.click_StatusDropDownOnboardingValue_Radio();
        for (String status : facilitiesPage.getList_FacilityTableStatus_Lbl())
            softAssert.assertEquals(status, "Deboard", "Deboard Status Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_012, Verify The Functionality Of Filter The Facilities With InActive Status")
    public void TC_Facility_012_Verify_The_Functionality_Of_Filter_The_Facilities_With_InActive_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        facilitiesPage.click_Status_DropDown();
        facilitiesPage.click_StatusDropDownOnboardingValue_Radio();
        for (String status : facilitiesPage.getList_FacilityTableStatus_Lbl())
            softAssert.assertEquals(status, "Inactive", "Inactive Status Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_013, Verify The Functionality Of Clear Selection Button In Status")
    public void TC_Facility_013_Verify_The_Functionality_Of_Clear_Selection_Button_In_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillFacility();
        List<String> initialStatusList = facilitiesPage.getList_FacilityTableStatus_Lbl();
        facilitiesPage.click_Status_DropDown();
        facilitiesPage.click_StatusDropDownActiveValue_Radio();
        for (String status : facilitiesPage.getList_FacilityTableStatus_Lbl())
            softAssert.assertEquals(status, "Active", "Active Status Is Present As Expected");
        facilitiesPage.click_StatusDropDownClearSelection_Btn();
        facilitiesPage.click_Status_DropDown();
        List<String> currentStatusList = facilitiesPage.getList_FacilityTableStatus_Lbl();
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
        HashMap<String, String> createFacilityDetails = new HashMap<>(addNewFacilityPage.createFacility());
        HashMap<String, String> getFacilityDetails = new HashMap<>(facilitiesPage.getData_TableFirstData());

        softAssert.assertEquals(createFacilityDetails.get("facilityName"), getFacilityDetails.get("facilityName"), "Facility Name Is Matched As Expected");
        softAssert.assertEquals(createFacilityDetails.get("postalCode"), getFacilityDetails.get("postalCode"), "Postal Code Is Matched As Expected");
        softAssert.assertContains(getFacilityDetails.get("address"), createFacilityDetails.get("addressLine1"), "Address Line 1 Is Present In Table As Expected");
        softAssert.assertContains(getFacilityDetails.get("address"), createFacilityDetails.get("addressLine2"), "Address Line 2 Is Present In Table As Expected");

        facilitiesPage.click_TableDataEdit_Link();
        softAssert.assertTrue(!addNewFacilityPage.isEnabled_FacilityName_Txt(), "Facility Name Text Field Is Disabled As Expected");
        softAssert.assertTrue(!addNewFacilityPage.isEnabled_FacilityId_Txt(), "Facility Id Text Field Is Disabled As Expected");
        softAssert.assertTrue(addNewFacilityPage.isDisabled_Country_Txt(), "Country Text Field Is Disabled As Expected");

        HashMap<String, String> getUpdatedFacilityDetails = new HashMap<>(addNewFacilityPage.updateFacility());
        HashMap<String, String> updatedData = new HashMap<>(facilitiesPage.getData_TableFirstData());
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
        HashMap<String, String> getDataFromTable = new HashMap<>(facilitiesPage.getData_TableFirstData());
        String initialFacilityPostalCode = getDataFromTable.get("postalCode");
        String initialFacilityCity = getDataFromTable.get("city");
        String initialFacilityState = getDataFromTable.get("state");
        facilitiesPage.click_TableDataEdit_Link();
        addNewFacilityPage.click_Cancel_Btn();

        getDataFromTable = new HashMap<>(facilitiesPage.getData_TableFirstData());
        String finalFacilityPostalCode = getDataFromTable.get("postalCode");
        String finalFacilityCity = getDataFromTable.get("city");
        String finalFacilityState = getDataFromTable.get("state");
        softAssert.assertEquals(facilitiesPage.getText_Header_Lbl(), "Facilities", "Facilities Header Is Present After Clicking On Cancel Button In Edit Facility Page");
        softAssert.assertEquals(initialFacilityPostalCode, finalFacilityPostalCode, "Facility Postal Code Is Same As Expected");
        softAssert.assertEquals(initialFacilityCity, finalFacilityCity, "Facility City Name Is Same As Expected");
        softAssert.assertEquals(initialFacilityState, finalFacilityState, "Facility State Name Is Same As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_018, Verify Functionality Of Pagination Paging Block With Next And Previous Button")
    public void TC_Facility_018_Verify_Functionality_Of_Pagination_Paging_Block_With_Next_And_Previous_Button() {
        commonActions.coverJourneyTillFacility();
        facilitiesPage.chooseNoOfRecordToBeDisplayed(5);
        String firstRecord = facilitiesPage.getList_FacilityTableFacilityName_Lbl().get(0);
        facilitiesPage.click_Next_Btn();
        String sixthRecord = facilitiesPage.getList_FacilityTableFacilityName_Lbl().get(0);
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
        String temp = expectedList.get(0);
        expectedList.add(0, expectedList.get(1));
        expectedList.remove(1);
        expectedList.add(1, temp);
        expectedList.remove(2);
        facilitiesPage.dragAndDrop_MoreActionsDropDownModifyColumnDragOptionsList_Lbl(0, 1);
        List<String> actualList = facilitiesPage.getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl();
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
        softAssert.assertEqualsIgnoreCase(headList.get(0), facilitiesPage.getText_TableColumnNameFacilityId(), "Facility Id Is Matched As Expected");
        softAssert.assertEqualsIgnoreCase(headList.get(1), facilitiesPage.getText_TableColumnNameFacilityName(), "Facility Name Is Matched As Expected");
        softAssert.assertEqualsIgnoreCase(headList.get(2), facilitiesPage.getText_TableColumnNameStatus(), "Status Is Matched As Expected");
        softAssert.assertEqualsIgnoreCase(headList.get(3), facilitiesPage.getText_TableColumnNameAddress(), "Address Is Matched As Expected");

        facilitiesPage.click_MoreActions_DropDown();
        facilitiesPage.click_MoreActionsDropDownModifyColumns_Link();
        facilitiesPage.click_MoreActionsDropDownModifyColumnFacilityId_CheckBox();
        facilitiesPage.click_moreActionsDropDownModifyColumnFacilityName_CheckBox();
        headList = facilitiesPage.getText_MoreActionsDropDownModifyColumnDragOptionsList_Lbl();
        facilitiesPage.click_MoreActionsDropDownModifyColumnSave_Btn();
        softAssert.assertEqualsIgnoreCase(headList.get(0), facilitiesPage.getText_TableColumnNameStatus(), "Status Appears On 0th Position As Expected");
        softAssert.assertEqualsIgnoreCase(headList.get(1), facilitiesPage.getText_TableColumnNameAddress(), "Address Appears On 1st Position As Expected");
        softAssert.assertEqualsIgnoreCase(headList.get(2), facilitiesPage.getText_TableColumnNameCity(), "City Appears On 2nd Position As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_025, Verify Functionality Of Next Page Pagination Button")
    public void TC_Facility_025_Verify_Functionality_Of_Next_Page_Pagination_Button() {
        commonActions.coverJourneyTillFacility();
        String firstElement = facilitiesPage.getText_TableDataFacilityName_Lbl();
        facilitiesPage.click_Next_Btn();
        JarvisAssert.assertNotEquals(firstElement, facilitiesPage.getText_TableDataFacilityName_Lbl(), "First Data Of Current Page And First Data Of Next Page Didn't Matched As Expected ");
    }
//import framework.frontend.actions.ActionHelper;
//import framework.frontend.locator.Locator;
//import framework.frontend.managers.DriverManager;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
//
//import java.sql.DriverAction;
//
//public class TestSuite_Facilities {
//
}
