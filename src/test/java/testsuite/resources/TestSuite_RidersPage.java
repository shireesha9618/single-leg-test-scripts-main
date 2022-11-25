package testsuite.resources;

import base.BaseTestClass;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import framework.common.logger.ExtentLogger;
import org.testng.annotations.Test;
import pageobjects.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestSuite_RidersPage extends BaseTestClass {
    LoginPage loginPage = LoginPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    RidersPage ridersPage = RidersPage.getInstance();
    CommonActions commonActions = CommonActions.getInstance();

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS}, description = "TC_01, Verify The UI Of Riders Page")
    public void TC_Riders_01_Verify_The_UI_Of_Riders_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Check Text Visibility Of Heading");
        softAssert.assertTrue(ridersPage.isPresent_RidersBreadcrumb_Lbl(), "Check Visibility Of Breadcrumb Menu");
        softAssert.assertTrue(ridersPage.isPresent_Status_Btn(), "Check Visibility Of Status");
        softAssert.assertTrue(ridersPage.isPresent_MoreActions_Btn(), "Check Visibility Of More Actions Button");
        softAssert.assertTrue(ridersPage.isPresent_Teams_Btn(), "Check Visibility Of Teams Button");
        softAssert.assertTrue(ridersPage.isPresent_NewRider_Btn(), "Check Visibility Of New Rider Button");
        softAssert.assertTrue(ridersPage.isPresent_Search_Bar(), "Check Visibility Of Search Bar");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS}, description = "TC_02, Verify The UI Of Table Present In Riders Page")
    public void TC_Riders_02_Verify_The_UI_Of_Table_Present_In_Riders_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        ridersPage.clickAndChoose_MoreActionsDropDownMenuOptions_Btn("Modify Columns");
        ridersPage.click_EditColumnsSelectAllWithSave_Btn();
        List<String> actualTabHeadersLabels = ridersPage.getText_TableHeaderList_Lbl();
        List<String> expectedTabHeaders = new ArrayList<>(List.of("RIDER ID", "RIDER NAME", "PHONE NUMBER", "STATUS", "TEAMS", "CREATED AT", "UPDATED AT",
                "CREATED BY", "UPDATED BY"));
        Collections.sort(actualTabHeadersLabels);
        Collections.sort(expectedTabHeaders);
        for (int size = 0; size < actualTabHeadersLabels.size(); size++) {
            softAssert.assertEquals(actualTabHeadersLabels.get(size), expectedTabHeaders.get(size), "Table Header label is matched as expected " + expectedTabHeaders.get(size));
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS}, description = "TC_03, Verify The UI Of More Actions button")
    public void TC_Riders_03_Verify_The_UI_Of_More_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Check Text Visibility Of Heading");
        ridersPage.click_MoreActions_Btn();
        softAssert.assertTrue(ridersPage.isPresent_ModifyColumns_Btn(), "Validate presence of Modify Columns option");
        softAssert.assertEquals(ridersPage.getText_ModifyColumns_Btn(), "Modify Columns", "Modify Columns text is matched as expected");
        softAssert.assertTrue(ridersPage.isPresent_ExportCSV_Btn(), "Validate presence of Export as CSV option");
        softAssert.assertEquals(ridersPage.getText_ExportCSV_Btn(), "Export as CSV", "Export as CSV text is matched as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS}, description = "TC_06, Verify The UI Of Status button")
    public void TC_Riders_06_Verify_The_UI_Of_Status_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        ridersPage.open_Status_DropDown();
        softAssert.assertTrue(ridersPage.isEnabled_StatusDropDownAvailableValue_Radio(), "Validate presence of Available radio button");
        softAssert.assertTrue(ridersPage.isEnabled_StatusDropDownBusyValue_Radio(), "Validate presence of Busy radio button");
        softAssert.assertTrue(ridersPage.isEnabled_StatusDropDownUnAvailableValue_Radio(), "Validate presence of Unavailable radio button");
        softAssert.assertTrue(ridersPage.isEnabled_StatusDropDownAllocatedValue_Radio(), "Validate presence of Allocated radio button");
        softAssert.assertTrue(ridersPage.isEnabled_StatusDropDownTerminalValue_Radio(), "Validate presence of Terminal radio button");
        softAssert.assertTrue(ridersPage.isEnabled_StatusDropDownOnboardingValue_Radio(), "Validate presence of Onboarding radio button");
        softAssert.assertTrue(ridersPage.isEnabled_StatusDropDownInActiveValue_Radio(), "Validate presence of Inactive radio button");
        softAssert.assertTrue(ridersPage.isEnabled_StatusDropDownDeBoardingValue_Radio(), "Validate presence of Deboarding radio button");
        softAssert.assertTrue(ridersPage.isPresent_StatusDropDownClearSelection_Btn(), "Validate presence of Clear Selection button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS}, description = "TC_07_08_09_010_011_012_013_014, Verify The Functionality Of Filter The Rider With All Status")
    public void TC_Riders_07_08_09_010_011_012_013_014_Verify_The_Functionality_Of_Filter_The_Rider_With_All_Status() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Check Text Visibility Of Heading");
        String[] statusList = {"Available", "Allocated", "Deboarding", "Inactive", "Onboarding", "Busy", "Unavailable", "Terminal"};
        for (String status : statusList) {
            ExtentLogger.logPass("Validating" + status + "Status radiobutton");
            ridersPage.click_Status_RadioBtn(status);
            ridersPage.validate_Status_RadioBtn(status);
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS}, description = "TC_15, Verify The Functionality Of ClearSelection In Status")
    public void TC_Riders_15_Verify_The_Functionality_Of_ClearSelection_In_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        List<String> initialStatusList = ridersPage.getTxt_RidersTableStatusColumnList_Link();
        ridersPage.open_Status_DropDown();
        ridersPage.click_StatusDropDownAvailableValue_Radio();
        for (String text : ridersPage.getTxt_RidersTableStatusColumnList_Link())
            softAssert.assertEquals(text, "Available", "Status Is Available For All Record As Expected ");
        ridersPage.click_StatusDropDownClearSelection_Btn();
        List<String> currentStatusList = ridersPage.getTxt_RidersTableStatusColumnList_Link();
        for (int i = 0; i < initialStatusList.size(); i++)
            softAssert.assertEquals(currentStatusList.get(i), initialStatusList.get(i), "Validate Status is the same as initial values");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS}, description = "TC_022,  Verify The Functionality Of Modify Columns For More Actions Button")
    public void TC_Riders_22_Verify_The_Functionality_Of_ModifyColumns_For_More_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        ridersPage.click_MoreActions_Btn();
        ridersPage.click_ModifyColumns_Btn();
        softAssert.assertTrue(ridersPage.isPresent_ModifyColumns_SearchBar(), "Validate presence of Search Bar");
        softAssert.assertTrue(ridersPage.isPresent_MoreActionsDropDownModifyColumnsRiderName_CheckBox(), "Validate presence of Rider Name Checkbox");
        softAssert.assertTrue(ridersPage.isPresent_MoreActionsDropDownModifyColumnsRiderId_CheckBox(), "Validate presence of Rider Id Checkbox");
        softAssert.assertTrue(ridersPage.isPresent_MoreActionsDropDownModifyColumnsPhoneNumber_CheckBox(), "Validate presence of Phone Number Checkbox");
        softAssert.assertTrue(ridersPage.isPresent_MoreActionsDropDownModifyColumnsStatus_CheckBox(), "Validate presence of Status Checkbox");
        softAssert.assertTrue(ridersPage.isPresent_MoreActionsDropDownModifyColumnsTeams_CheckBox(), "Validate presence of Teams Checkbox");
        softAssert.assertTrue(ridersPage.isPresent_MoreActionsDropDownModifyColumnsCreatedAt_CheckBox(), "Validate presence of Created At Checkbox");
        softAssert.assertTrue(ridersPage.isPresent_MoreActionsDropDownModifyColumnsUpdatedAt_CheckBox(), "Validate presence of Updated At Checkbox");
        softAssert.assertTrue(ridersPage.isPresent_MoreActionsDropDownModifyColumnsCreatedBy_CheckBox(), "Validate presence of Created By Checkbox");
        softAssert.assertTrue(ridersPage.isPresent_MoreActionsDropDownModifyColumnsUpdatedBy_CheckBox(), "Validate presence of Created By Checkbox");
        softAssert.assertTrue(ridersPage.isPresent_MoreActionsDropDownModifyColumnsLinkSave_Btn(), "Validate presence of Save Button");
        softAssert.assertTrue(ridersPage.isPresent_MoreActionsDropDownModifyColumnsLinkCancel_Btn(), "Validate presence of Cancel Checkbox");
        softAssert.assertTrue(ridersPage.isPresent_MoreActionsDropDownModifyColumnsLinkSelectAll_Btn(), "Validate presence of SelectAll Button");
        softAssert.assertTrue(ridersPage.isPresent_EditColumnsHeader_Lbl(), "Validate presence of Edit Columns Header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS}, description = "TC_023, Verify The Functionality Of Select All Of Modify Columns For More Actions Button")
    public void TC_Riders_23_Verify_The_Functionality_Of_Select_All_Of_Modify_Columns_For_MoreActions_Button() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Check Text Visibility Of Heading");
        ridersPage.click_MoreActions_Btn();
        ridersPage.click_ModifyColumns_Btn();
        ridersPage.click_MoreActionsDropDownModifyColumnsLinkSelectAll_Btn();
        softAssert.assertTrue(ridersPage.getSize_EditColumnsSearchRightList_Link() == ridersPage.getSize_EditColumnsSearchLeftList_Link(), "Left And Right Record Is Same As Expected");
        softAssert.assertEquals(ridersPage.getSize_EditColumnsSearchRightList_Link(), ridersPage.getSize_EditColumnsSearchLeftList_Link(), "Select All Work Left & Right Record are Same");
        ridersPage.unCheck_EditColumnsRiderName_CheckBox();
        ridersPage.unCheck_EditColumnsStatus_CheckBox();
        softAssert.assertTrue(ridersPage.getSize_EditColumnsSearchRightList_Link() != ridersPage.getSize_EditColumnsSearchLeftList_Link(), "Left And Right Record Is Not Same As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS}, description = "TC_024, Verify The Functionality Of Drag The Position Of Modify Columns For Actions Button")
    public void TC_Riders_24_Verify_The_Functionality_Of_Drag_The_Position_Of_Modify_Columns_For_More_Actions_Button() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ridersPage.click_MoreActions_Btn();
        ridersPage.click_ModifyColumns_Btn();
        List<String> expectedOptions = ridersPage.getText_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label();
        String temp = expectedOptions.get(0);
        expectedOptions.add(0, expectedOptions.get(1));
        expectedOptions.remove(1);
        expectedOptions.add(1, temp);
        expectedOptions.remove(2);
        ridersPage.dragAndDrop_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label(0, 1);
        List<String> actualOptions = ridersPage.getText_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label();
        for (int count = 0; count < expectedOptions.size(); count++)
            softAssert.assertEquals(actualOptions.get(count), expectedOptions.get(count), "Validate order of options");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS}, description = "TC_025, Verify The Functionality Of Checkbox And X Of Modify Columns For Actions Button")
    public void TC_Riders_25_Verify_The_Functionality_Of_Checkbox_And_X_Of_Modify_Columns_For_Actions_Button() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ridersPage.clickAndChoose_MoreActionsDropDownMenuOptions_Btn("Modify Columns");
        ridersPage.click_MoreActionsDropDownModifyColumnsLinkSelectAll_Btn();
        softAssert.assertTrue(ridersPage.getText_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label().contains("Status"), "Validate presence of Status as option");
        ridersPage.click_MoreActionsDropDownModifyColumnsStatus_CheckBox();
        softAssert.assertTrue(!ridersPage.getText_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label().contains("Status"), "Validate absence of Status as option");
        ridersPage.click_MoreActionsDropDownModifyColumnsStatus_CheckBox();
        softAssert.assertTrue(ridersPage.getText_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label().contains("Status"), "Validate presence of Status as option");
        ridersPage.click_MoreActionsDropDownModifyColumnsStatusCross_Icon();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS}, description = "TC_026, Verify The Functionality Of Search Bar Of Modify Columns For Actions Button")
    public void TC_Riders_26_Verify_The_Functionality_Of_Search_Bar_Of_Modify_Columns_For_Actions_Button() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Check Text Visibility Of Heading");
        ridersPage.clickAndChoose_MoreActionsDropDownMenuOptions_Btn("Modify Columns");
        ridersPage.fill_EditColumnsSearch_Txt("Test");
        softAssert.assertTrue(!ridersPage.isPresent_MoreActionsDropDownModifyColumnsRiderName_CheckBox(), "Validate absence of Rider Name Checkbox");
        softAssert.assertTrue(!ridersPage.isPresent_MoreActionsDropDownModifyColumnsRiderId_CheckBox(), "Validate absence of Rider Id Checkbox");
        softAssert.assertTrue(!ridersPage.isPresent_MoreActionsDropDownModifyColumnsStatus_CheckBox(), "Validate absence of Status Checkbox");
        softAssert.assertTrue(!ridersPage.isPresent_MoreActionsDropDownModifyColumnsTeams_CheckBox(), "Validate absence of Teams Checkbox");
        softAssert.assertTrue(!ridersPage.isPresent_MoreActionsDropDownModifyColumnsPhoneNumber_CheckBox(), "Validate absence of Phone Number Checkbox");
        softAssert.assertTrue(!ridersPage.isPresent_MoreActionsDropDownModifyColumnsCreatedAt_CheckBox(), "Validate absence of Created At Checkbox");
        softAssert.assertTrue(!ridersPage.isPresent_MoreActionsDropDownModifyColumnsUpdatedAt_CheckBox(), "Validate absence of Updated At Checkbox");
        softAssert.assertTrue(!ridersPage.isPresent_MoreActionsDropDownModifyColumnsCreatedBy_CheckBox(), "Validate absence of Created By Checkbox");
        softAssert.assertTrue(!ridersPage.isPresent_MoreActionsDropDownModifyColumnsUpdatedBy_CheckBox(), "Validate absence of Updated By Checkbox");
        ridersPage.fill_EditColumnsSearch_Txt("Teams");
        softAssert.assertTrue(ridersPage.isPresent_MoreActionsDropDownModifyColumnsTeams_CheckBox(), "Validate Presence of Teams Checkbox");
        softAssert.assertEquals(ridersPage.getSize_EditColumnsSearchLeftList_Link(), 1, "One Record Is Visible On Left Pane As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS}, description = "TC_027, Verify The Functionality Of Cancel Button Of Modify Columns For More Actions Button")
    public void TC_Riders_027_Verify_The_Functionality_Of_Cancel_Button_Of_Modify_Columns_For_More_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        ridersPage.click_MoreActions_DropDown();
        ridersPage.clickAndChoose_MoreActionsDropDownMenuOptions_Btn("Modify Columns");
        ridersPage.click_MoreActionsDropDownModifyColumnsLinkCancel_Btn();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Validate presence of Riders List header label");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS}, description = "TC_28, Verify The Functionality Of Save Button Of Modify Columns For More Actions Button")
    public void TC_Riders_028_Verify_The_Functionality_Of_Save_Button_Of_Modify_Columns_For_More_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        ridersPage.clickAndChoose_MoreActionsDropDownMenuOptions_Btn("Modify Columns");
        ridersPage.click_EditColumnsSelectAllWithSave_Btn();
        List<String> actualTabHeadersLabels = ridersPage.getText_TableHeaderList_Lbl();
        List<String> expectedTabHeaders = new ArrayList<>(List.of("RIDER ID", "RIDER NAME", "PHONE NUMBER", "STATUS", "TEAMS", "CREATED AT", "UPDATED AT",
                "CREATED BY", "UPDATED BY"));
        Collections.sort(actualTabHeadersLabels);
        Collections.sort(expectedTabHeaders);
        for (int size = 0; size < actualTabHeadersLabels.size(); size++) {
            softAssert.assertEquals(actualTabHeadersLabels.get(size), expectedTabHeaders.get(size), "Table Header label is matched as expected " + expectedTabHeaders.get(size));
        }
        ridersPage.clickAndChoose_MoreActionsDropDownMenuOptions_Btn("Modify Columns");
        ridersPage.click_MoreActionsDropDownModifyColumnsLinkSelectAll_Btn();
        ridersPage.unCheck_EditColumnsRiderId_CheckBox();
        ridersPage.unCheck_EditColumnsRiderName_CheckBox();
        ridersPage.unCheck_EditColumnsPhoneNumber_CheckBox();
        ridersPage.unCheck_EditColumnsTeams_CheckBox();
        ridersPage.click_MoreActionsDropDownModifyColumnsLinkSave_Btn();
        List<String> actualTabHeadersLabelsAfter = ridersPage.getText_TableHeaderList_Lbl();
        List<String> expectedTabHeadersAfter = new ArrayList<>(List.of("STATUS", "CREATED AT", "UPDATED AT", "CREATED BY", "UPDATED BY"));
        Collections.sort(actualTabHeadersLabelsAfter);
        Collections.sort(expectedTabHeadersAfter);
        for (int size = 0; size < actualTabHeadersLabelsAfter.size(); size++) {
            softAssert.assertEquals(actualTabHeadersLabelsAfter.get(size), expectedTabHeadersAfter.get(size), "After Uncheck Table Header label is matched as expected " + expectedTabHeadersAfter.get(size));
        }
        softAssert.assertAll();
    }
}
