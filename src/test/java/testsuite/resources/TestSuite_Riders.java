package testsuite.resources;

import base.BaseTestClass;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite_Riders extends BaseTestClass {
    LoginPage loginPage = LoginPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    RidersPage ridersPage = RidersPage.getInstance();
    CommonActions commonActions = CommonActions.getInstance();
    AddNewRiderPage addNewRiderPage = AddNewRiderPage.getInstance();

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_01, Verify The UI Of Riders Page")
    public void TC_Riders_01_Verify_The_UI_Of_Riders_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Check Text Visibility Of Heading");
        softAssert.assertTrue(ridersPage.isPresent_RidersBreadcrumb_Lbl(), "Check Visibility Of Breadcrumb Menu");
        softAssert.assertTrue(ridersPage.isPresent_Status_Btn(), "Check Visibility Of Status");
        softAssert.assertTrue(ridersPage.isPresent_MoreActions_Btn(), "Check Visibility Of More Actions Button");
        softAssert.assertTrue(ridersPage.isPresent_Teams_DropDown(), "Check Visibility Of Teams DropDown");
        softAssert.assertTrue(ridersPage.isPresent_NewRider_Btn(), "Check Visibility Of New Rider Button");
        softAssert.assertTrue(ridersPage.isPresent_Search_Bar(), "Check Visibility Of Search Bar");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_02, Verify The UI Of Table Present In Riders Page")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_03, Verify The UI Of More Actions button")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_06, Verify The UI Of Status button")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_07_08_09_010_011_012_013_014, Verify The Functionality Of Filter The Rider With All Status")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_15, Verify The Functionality Of ClearSelection In Status")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_022,  Verify The Functionality Of Modify Columns For More Actions Button")
    public void TC_Riders_22_Verify_The_Functionality_Of_ModifyColumns_For_More_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        ridersPage.click_MoreActions_Btn();
        ridersPage.click_ModifyColumns_Btn();
        softAssert.assertTrue(ridersPage.isPresent_ModifyColumns_SearchBar(), "Validate presence of Search Bar");
        softAssert.assertTrue(ridersPage.isPresent_EditColumnsHeader_Lbl(), "Validate presence of Edit Columns Header");
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
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_023, Verify The Functionality Of Select All Of Modify Columns For More Actions Button")
    public void TC_Riders_23_Verify_The_Functionality_Of_Select_All_Of_Modify_Columns_For_MoreActions_Button() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Check Text Visibility Of Heading");
        ridersPage.click_MoreActions_Btn();
        ridersPage.click_ModifyColumns_Btn();
        ridersPage.click_MoreActionsDropDownModifyColumnsLinkSelectAll_Btn();
        softAssert.assertEquals(ridersPage.getSize_EditColumnsSearchRightList_Link(), ridersPage.getSize_EditColumnsSearchLeftList_Link(), "Select All Work Left & Right Record are Same");
        ridersPage.unCheck_EditColumnsRiderName_CheckBox();
        ridersPage.unCheck_EditColumnsStatus_CheckBox();
        softAssert.assertTrue(ridersPage.getSize_EditColumnsSearchRightList_Link() != ridersPage.getSize_EditColumnsSearchLeftList_Link(), "Left And Right Record Is Not Same As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_024, Verify The Functionality Of Drag The Position Of Modify Columns For Actions Button")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_025, Verify The Functionality Of Checkbox And X Of Modify Columns For Actions Button")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_026, Verify The Functionality Of Search Bar Of Modify Columns For Actions Button")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_027, Verify The Functionality Of Cancel Button Of Modify Columns For More Actions Button")
    public void TC_Riders_027_Verify_The_Functionality_Of_Cancel_Button_Of_Modify_Columns_For_More_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        ridersPage.click_MoreActions_DropDown();
        ridersPage.clickAndChoose_MoreActionsDropDownMenuOptions_Btn("Modify Columns");
        ridersPage.click_MoreActionsDropDownModifyColumnsLinkCancel_Btn();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Validate presence of Riders List header label");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_28, Verify The Functionality Of Save Button Of Modify Columns For More Actions Button")
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "Riders_29, Verify Functionality Of Next Page Pagination Button")
    public void TC_Riders_29_Verify_Functionality_Of_Next_Page_Pagination_Button() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        List<String> currentPageElements = ridersPage.getText_TableDataRiderName_List();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-5", "Validate no of records displayed");
        commonActions.click_PaginationNext_Btn();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "6-10", "Validate no of records displayed");
        List<String> nextPageElements = ridersPage.getText_TableDataRiderName_List();
        JarvisAssert.assertTrue(!currentPageElements.equals(nextPageElements), "Current Page Elements And Next Page Elements Are Not Matched As Expected ");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_30, Verify Functionality Of Previous Page Pagination Button")
    public void TC_Riders_30_Verify_Functionality_Of_Previous_Page_Pagination_Button() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-5", "Validate no of records displayed");
        commonActions.click_PaginationNext_Btn();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "6-10", "Validate no of records displayed");
        List<String> nextPageElements = ridersPage.getText_TableDataRiderName_List();
        commonActions.click_PaginationPrevious_Btn();
        List<String> prevPageElements = ridersPage.getText_TableDataRiderName_List();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-5", "Validate no of records displayed");
        JarvisAssert.assertTrue(!nextPageElements.equals(prevPageElements), "Next Page Elements And Previous Page Elements Are Not Matched As Expected ");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_31 Verify Functionality Of Vertically Scroll Of Rider Table Using Mouse Scroll Wheel")
    public void TC_Riders_031_Verify_Functionality_Of_Vertically_Scroll_Of_Rider_Table_Using_Mouse_Scroll_Wheel() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        ridersPage.choose_NoOfRecordsToBeDisplayed_PerPage(20);
        List<WebElement> elements = ridersPage.getElements_RiderTableRiderIdColumnList_Link();
        Utility.validatePageScrollDown(elements.get(elements.size() - 1));
        softAssert.assertTrue(ActionHelper.isPresent(elements.get(elements.size() - 1), 3000), "Validate last element is present");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_32, Verify Functionality Of Vertically Scroll Of Rider Table Using Keyboard")
    public void TC_Riders_032_Verify_Functionality_Of_Vertically_Scroll_Of_Rider_Table_Using_Keyboard() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        ridersPage.choose_NoOfRecordsToBeDisplayed_PerPage(10);
        List<WebElement> elements = ridersPage.getElements_RiderTableRiderIdColumnList_Link();
        Utility.scrollDownUsingKeyboardKey(10);
        softAssert.assertTrue(ActionHelper.isPresent(elements.get(elements.size() - 1), 3000), "Validate last element is present");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_33, Verify Displaying Of Rider Table Records As Per Pagination Value")
    public void TC_Riders_033_Verify_Displaying_Of_Rider_Table_Records_As_Per_Pagination_Value() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        ridersPage.choose_NoOfRecordsToBeDisplayed_PerPage(10);
        softAssert.assertTrue(ridersPage.validateTeamsTableRecordEqualsToPerPaginationOptions(), "Table Has Not More Than 10 Record Present As Expected");

        ridersPage.choose_NoOfRecordsToBeDisplayed_PerPage(20);
        softAssert.assertTrue(ridersPage.validateTeamsTableRecordEqualsToPerPaginationOptions(), "Table Has Not More Than 20 Record Present As Expected");

        ridersPage.choose_NoOfRecordsToBeDisplayed_PerPage(50);
        softAssert.assertTrue(ridersPage.validateTeamsTableRecordEqualsToPerPaginationOptions(), "Table Has Not More Than 50 Record Present As Expected");

        ridersPage.choose_NoOfRecordsToBeDisplayed_PerPage(5);
        softAssert.assertTrue(ridersPage.validateTeamsTableRecordEqualsToPerPaginationOptions(), "Table Has Not More Than 5 Record Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_34, Verify Functionality Of Pagination Paging Block")
    public void TC_Riders_034_Verify_Functionality_Of_Pagination_Paging_Block() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        ridersPage.choose_NoOfRecordsToBeDisplayed_PerPage(20);
        List<WebElement> webElement = new ArrayList<>(ridersPage.getElements_RiderTableRiderIdColumnList_Link());
        String firstBlockElement = webElement.get(0).getText();
        String secondBlockElement = webElement.get(5).getText();
        ridersPage.choose_NoOfRecordsToBeDisplayed_PerPage(5);
        ridersPage.select_PaginationBlockList_Lbl("1");
        String webElementForFirstBlock = new ArrayList<>(ridersPage.getElements_RiderTableRiderIdColumnList_Link()).get(0).getText();
        softAssert.assertEquals(webElementForFirstBlock, firstBlockElement, "Pagination First Block Record Is Matched As Expected");
        ridersPage.select_PaginationBlockList_Lbl("2");
        String webElementForSecondBlock = new ArrayList<>(ridersPage.getElements_RiderTableRiderIdColumnList_Link()).get(0).getText();
        softAssert.assertEquals(webElementForSecondBlock, secondBlockElement, "Pagination Second Block Record Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_35, Verify Functionality Of Pagination Paging Block With Next And Previous Button")
    public void TC_Riders_035_Verify_Functionality_Of_Pagination_Paging_Block_With_Next_And_Previous_Button() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ridersPage.choose_NoOfRecordsToBeDisplayed_PerPage(5);
        ridersPage.click_Next_Btn();
        List<WebElement> webElementAfterNext = new ArrayList<>(ridersPage.getElements_RiderTableRiderIdColumnList_Link());
        String nextBlockElement = webElementAfterNext.get(0).getText();
        ridersPage.click_Previous_Btn();
        List<WebElement> webElementAfterPrevious = new ArrayList<>(ridersPage.getElements_RiderTableRiderIdColumnList_Link());
        String prevBlockElement = webElementAfterPrevious.get(0).getText();
        ridersPage.select_PaginationBlockList_Lbl("2");
        String webElementForSecondBlock = new ArrayList<>(ridersPage.getElements_RiderTableRiderIdColumnList_Link()).get(0).getText();
        softAssert.assertEquals(webElementForSecondBlock, nextBlockElement, "Pagination Second Block Record Is Matched With Next As Expected");
        ridersPage.select_PaginationBlockList_Lbl("1");
        String webElementForFirstBlock = new ArrayList<>(ridersPage.getElements_RiderTableRiderIdColumnList_Link()).get(0).getText();
        softAssert.assertEquals(webElementForFirstBlock, prevBlockElement, "Pagination First Block Record Is Matched With Previous As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_36, Verify Functionality Of Pagination Paging Block With Next 5 pages And Previous 5 pages Button")
    public void TC_Riders_36_Verify_Functionality_Of_Pagination_Paging_Block_With_Next5pages_And_Previous5pages_Button() {
        commonActions.coverUserJourneyTillRiders();
        ridersPage.choose_NoOfRecordsToBeDisplayed_PerPage(5);
        ridersPage.select_PaginationBlockList_Lbl("5");
        ridersPage.click_PaginationPreviousFivePages_Btn();
        String twentyFirstRecord = ridersPage.getElements_RiderTableRiderIdColumnList_Link().get(0).getText();
        ridersPage.click_PaginationNextFivePages_Btn();
        String twentySixthRecord = ridersPage.getElements_RiderTableRiderIdColumnList_Link().get(0).getText();
        JarvisAssert.assertNotEquals(twentyFirstRecord, twentySixthRecord, "The Two Record Names Didn't Matched As Expected");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_37, Verify Functionality Of Pagination Per Page With Paging Block And Next Button")
    public void TC_Riders_37_Verify_Functionality_Of_Pagination_Per_Page_With_Paging_Block_And_Next_Button() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ridersPage.choose_NoOfRecordsToBeDisplayed_PerPage(10);
        String elementAfterTenthPagination = new ArrayList<>(ridersPage.getElements_RiderTableRiderIdColumnList_Link()).get(5).getText();
        ridersPage.choose_NoOfRecordsToBeDisplayed_PerPage(5);
        String elementAfterFifthPagination = new ArrayList<>(ridersPage.getElements_RiderTableRiderIdColumnList_Link()).get(0).getText();
        ridersPage.click_Next_Btn();
        String elementAfterNext = new ArrayList<>(ridersPage.getElements_RiderTableRiderIdColumnList_Link()).get(0).getText();
        softAssert.assertEquals(elementAfterTenthPagination, elementAfterNext, "Pagination 10 Per Page Record Is Matched With Next As Expected");
        ridersPage.click_Previous_Btn();
        String elementAfterPrev = new ArrayList<>(ridersPage.getElements_RiderTableRiderIdColumnList_Link()).get(0).getText();
        softAssert.assertEquals(elementAfterFifthPagination, elementAfterPrev, "Pagination 5 Per Page Record Is Matched With Prev As Expected");
        ridersPage.select_PaginationBlockList_Lbl("2");
        String elementForSecondBlock = new ArrayList<>(ridersPage.getElements_RiderTableRiderIdColumnList_Link()).get(0).getText();
        softAssert.assertEquals(elementForSecondBlock, elementAfterNext, "Pagination 2 Block Record Is Matched With Next As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_38, Verify The Functionality Of New Rider Button")
    public void TC_Riders_038_Verify_The_Functionality_Of_New_Rider_Button() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Header is Present As Expected");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Riders Header is Matched As Expected");
        ridersPage.click_NewRider_Btn();
        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Heading Is Present As Expected");
        softAssert.assertTrue(addNewRiderPage.isPresent_Cancel_Btn(), "Cancel Button Is Present As Expected");
        softAssert.assertTrue(addNewRiderPage.isPresent_AddRider_Btn(), "Add Rider Button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_040, Verify The Functionality Of CheckBox Present In Riders Table for any record")
    public void TC_Riders_040_Verify_The_Functionality_Of_CheckBox_Present_In_Riders_Table_For_Any_Record() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Header is Present As Expected");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Riders Header is Matched As Expected");
        ridersPage.check_TableData_CheckBox(0);
        softAssert.assertTrue(ridersPage.isPresent_ChangeStatus_Btn(), "Change Status Button is Present as Expected");
    }

    @Test(enabled = false,groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_039, Verify The Functionality Of Select All CheckBox Present In Riders Table Heading")
    public void TC_Riders_039_Verify_The_Functionality_Of_Select_All_CheckBox_Present_In_Riders_Table_Heading() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Header is Present As Expected");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Riders Header is Matched As Expected");
        softAssert.assertTrue(ridersPage.isPresent_SelectAll_CheckBox(),"Select All CheckBox Is Present As Expected");
        ridersPage.click_SelectAll_CheckBox();
        softAssert.assertTrue(ridersPage.isPresent_ChangeStatus_Btn(), "Change Status Button is Present as Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_041, Verify The Functionality Of Unchecking the CheckBox")
    public void TC_Riders_041_Verify_The_Functionality_Of_Unchecking_The_CheckBox() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Header is Present As Expected");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Riders Header is Matched As Expected");
        ridersPage.check_TableData_CheckBox(0);
        softAssert.assertTrue(ridersPage.isPresent_ChangeStatus_Btn(), "Change Status Button is Present as Expected");
        ridersPage.uncheck_TableData_CheckBox(0);
        softAssert.assertTrue(!ridersPage.isPresent_ChangeStatus_Btn(), "Change Status Button is Not Present as Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_021, Verify The Functionality of Teams Dropdown in Riders Page")
    public void TC_Riders_021_Verify_The_Functionality_Of_Teams_DropDown_In_Riders_Page() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Header Is Present As Expected");
        ridersPage.click_Teams_CheckBox(Constants.TEAM);
        if (!ridersPage.isPresent_EmptyTable_Txt()) {
            List<String> allTeams = ridersPage.getTxt_RidersTableTeamsColumnList_Link();
            for (String teams : allTeams) {
                softAssert.assertTrue(teams.contains(Constants.TEAM), "For All Record As Expected ");
            }
        }
        else {
            softAssert.assertTrue(ridersPage.isPresent_EmptyTable_Txt(), "Table Has No Record Empty Table");
            softAssert.assertEquals(ridersPage.getText_EmptyTable_Txt(), "It is Empty here", "Table Empty Is Matched As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_074, Verify The Dock And UnDock Functionality For Resources Menu Button")
    public void TC_Riders_074_075_Verify_The_Dock_And_UnDock_Functionality_For_Resources_Menu_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverUserJourneyTillRiders();
        homePage.click_Resources_Btn();
        softAssert.assertTrue(!homePage.isPresent_RidersMenu_Btn(), "Riders Menu Button Is Not Present As Expected");
        softAssert.assertTrue(!homePage.isPresent_FacilitiesMenu_Btn(), "Facilities Menu Button Is Not Present As Expected");
        homePage.click_Resources_Btn();
        softAssert.assertTrue(homePage.isPresent_RidersMenu_Btn(), "Riders Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_FacilitiesMenu_Btn(), "Facilities Menu Button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_076, Verify The Functionality Dock and Undock of Left Panel")
    public void TC_Riders_076_Verify_The_Functionality_Of_Dock_And_UnDock_Of_Left_Panel() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverUserJourneyTillRiders();
        homePage.dock_LeftPanel_Btn();
        softAssert.assertTrue(!homePage.isPresent_OrdersMenu_Btn(), "Orders Icon Is Present As Expected");
        softAssert.assertTrue(!homePage.isPresent_DispatchMenu_Btn(), "Dispatch Icon Is Present As Expected");
        softAssert.assertTrue(!homePage.isPresent_ResourcesMenu_Btn(), "Resources Icon Is Present As Expected");
        softAssert.assertTrue(!homePage.isPresent_TeamsMenu_Btn(), "Teams Icon Is Present As Expected");
        softAssert.assertTrue(!homePage.isPresent_SettingsMenu_Btn(), "Settings Icon Is Present As Expected");
        homePage.unDock_LeftPanel_Btn();
        softAssert.assertTrue(homePage.isPresent_OrdersMenu_Btn(), "Orders Menu Button Along With Icon Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_DispatchMenu_Btn(), "Dispatch Menu Button Along With Icon Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_ResourcesMenu_Btn(), "Resources Menu Button Along With Icon Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_TeamsMenu_Btn(), "Teams Menu Button Along With Icon Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_SettingsMenu_Btn(), "Settings Menu Button Along With Icon Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_077, Verify The Functionality of Open Menu Button")
    public void TC_Riders_077_Verify_The_Functionality_Of_Open_Menu_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverUserJourneyTillRiders();
        homePage.click_OpenMenu_Btn();
        softAssert.assertTrue(homePage.isPresent_AppsHeader_Lbl(), "Header Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuOrders_Btn(), "Orders Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuDispatch_Btn(), "Dispatch Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuRiders_Btn(), "Riders Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuFacilities_Btn(), "Facilities Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuRouting_Btn(), "Routing Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuTeams_Btn(), "Teams Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuSettings_Btn(), "Settings Open Menu Button Is Present As Expected");
        homePage.click_OpenMenuRiders_Btn();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_078, Verify The Functionality of Cross Button Of Open Menu")
    public void TC_Riders_078_Verify_The_Functionality_Of_Cross_Button_Of_Open_Menu() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverUserJourneyTillRiders();
        homePage.click_OpenMenu_Btn();
        softAssert.assertTrue(homePage.isPresent_AppsHeader_Lbl(), "Apps Header Is Present As Expected");
        homePage.click_OpenMenuCross_Btn();
        softAssert.assertTrue(!homePage.isPresent_AppsHeader_Lbl(), "Apps Header Is Not Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_079, Verify The Functionality of Work Flow Button")
    public void TC_Riders_079_Verify_The_Functionality_Of_Work_Flow_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverUserJourneyTillRiders();
        homePage.click_DelhiveryLogo_Img();
        softAssert.assertTrue(homePage.isPresent_AllAppsHeader_Lbl(), "All Apps Header Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_WorkFlowOrders_Btn(), "Orders Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_WorkFlowDispatch_Btn(), "Dispatch Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_WorkFlowRouting_Btn(), "Routing Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_WorkflowRiders_Btn(), "Riders Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_WorkFlowFacilities_Btn(), "Facilities Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_WorkFlowTeams_Btn(), "Teams Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_WorkFlowSettings_Btn(), "Settings Button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_080, Verify The Functionality Of Riders Button Of Work Flow")
    public void TC_Riders_080_Verify_The_Functionality_Of_Riders_Button_Of_Work_Flow() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverUserJourneyTillRiders();
        homePage.click_DelhiveryLogo_Img();
        softAssert.assertTrue(homePage.isPresent_WorkflowRiders_Btn(), "Riders Button Is Present As Expected");
        homePage.click_WorkFlowRiders_Btn();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_042, Verify The Functionality of Change Status Button")
    public void TC_Riders_042_Verify_The_Functionality_Of_Change_Status_Button() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Header is Present As Expected");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Riders Header is Matched As Expected");
        ridersPage.check_TableData_CheckBox(0);
        softAssert.assertTrue(ridersPage.isPresent_ChangeStatus_Btn(), "Change Status Button is Present as Expected");
        ridersPage.click_ChangeStatus_Btn();
        softAssert.assertTrue(ridersPage.isPresent_ChangeStatusHeader_Lbl(), "Change Status Header is Present as Expected");
        softAssert.assertEquals(ridersPage.getText_ChangeStatusHeader_Lbl(), "Change Status", "Header is Matched as Expected");
        softAssert.assertTrue(ridersPage.isPresent_State_TextBox(), "State TextBox is Present as Expected");
        softAssert.assertTrue(ridersPage.isPresent_Cancel_Btn(), "Cancel button is Present As Expected");
        softAssert.assertTrue(ridersPage.isPresent_Save_Btn(), "Save Button Is Present As Expected");
        String[] statusList = {"Available", "Allocated", "Deboarding", "Inactive", "Onboarding", "Busy", "Unavailable", "Terminal"};
        for (String state : statusList) {
            ExtentLogger.logPass("Validating" + state + "Status radiobutton");
            ridersPage.isPresent_SelectState_DropDown(state);
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_005, Verify The Functionality Of Search Bar By Rider Name")
    public void TC_Riders_005_Verify_The_Functionality_Of_Search_Bar_By_Rider_Name() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        ridersPage.click_NewRider_Btn();
        String riderName = addNewRiderPage.createAndGetRiderDetails().get("riderFirstName");

        ridersPage.fillWithClear_Search_Txt(riderName);
        softAssert.assertTrue(ridersPage.isPresent_TableDataRiderName_Lbl(), "Rider Name Data In The Table Is Present As Expected");
        softAssert.assertEquals(ridersPage.getSize_RidersTableRiderName(), 1, "One Record Is As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_044, Verify The Functionality Of Save Button In Change Status Page")
    public void TC_Riders_044_Verify_The_Functionality_Of_Save_Button_In_Change_Status_Page() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ridersPage.click_NewRider_Btn();
        String riderName = addNewRiderPage.createAndGetRiderDetails().get("riderFirstName");
        ridersPage.fillWithClear_Search_Txt(riderName);
        ExtentLogger.logPass("Changing Status From Available State To Allocated State");
        ridersPage.clickAndChoose_SelectStateDropDownMenuOptions_Btn("Allocated");
        ridersPage.click_Status_RadioBtn("Allocated");
        softAssert.assertEquals(ridersPage.getSize_RidersTableRiderName(), 1, "One Record Found As Expected");

        ExtentLogger.logPass("Changing Status From Allocated State To Available State");
        ridersPage.clickAndChoose_SelectStateDropDownMenuOptions_Btn("Available");
        ridersPage.click_Status_RadioBtn("Available");
        softAssert.assertEquals(ridersPage.getSize_RidersTableRiderName(), 1, "One Record Found As Expected");

        ExtentLogger.logPass("Changing Status From Available State To Deboarding State");
        ridersPage.clickAndChoose_SelectStateDropDownMenuOptions_Btn("Deboarding");
        ridersPage.click_Status_RadioBtn("Deboarding");
        softAssert.assertEquals(ridersPage.getSize_RidersTableRiderName(), 1, "One Record Found As Expected");

        ExtentLogger.logPass("Changing Status From Deboarding State To Inactive State");
        ridersPage.clickAndChoose_SelectStateDropDownMenuOptions_Btn("Inactive");
        ridersPage.click_Status_RadioBtn("Inactive");
        softAssert.assertEquals(ridersPage.getSize_RidersTableRiderName(), 1, "One Record Found As Expected");

        ExtentLogger.logPass("Changing Status From Inactive State To Available State");
        ridersPage.clickAndChoose_SelectStateDropDownMenuOptions_Btn("Available");
        ridersPage.click_Status_RadioBtn("Available");
        softAssert.assertEquals(ridersPage.getSize_RidersTableRiderName(), 1, "One Record Found As Expected");
        softAssert.assertAll();

        ExtentLogger.logPass("Changing Status From Available State To Unavailable State");
        ridersPage.clickAndChoose_SelectStateDropDownMenuOptions_Btn("Unavailable");
        ridersPage.click_Status_RadioBtn("Unavailable");
        softAssert.assertEquals(ridersPage.getSize_RidersTableRiderName(), 1, "One Record Found As Expected");

        ExtentLogger.logPass("Changing Status From Unavailable State To Available State");
        ridersPage.clickAndChoose_SelectStateDropDownMenuOptions_Btn("Available");
        ridersPage.click_Status_RadioBtn("Available");
        softAssert.assertEquals(ridersPage.getSize_RidersTableRiderName(), 1, "One Record Found As Expected");

        ExtentLogger.logPass("Changing Status From Available State To Busy State");
        ridersPage.clickAndChoose_SelectStateDropDownMenuOptions_Btn("Busy");
        ridersPage.click_Status_RadioBtn("Busy");
        softAssert.assertEquals(ridersPage.getSize_RidersTableRiderName(), 1, "One Record Found As Expected");
        softAssert.assertAll();
    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_020, Verify The UI Of Teams DropDown")
    public void TC_Riders_020_Verify_The_UI_Of_Teams_DropDown() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Header is Present As Expected");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Riders Header is Matched As Expected");
        List<String> teamsListInHome = ridersPage.get_TeamList_Text();
        softAssert.assertTrue(ridersPage.isPresent_Teams_DropDown(), "Teams DropDown Is Present As Expected");
        List<String> teamsListInRiders = ridersPage.get_RidersTeamList_Text();
        softAssert.assertTrue(teamsListInRiders.contains(teamsListInHome), "Both Teams List Are Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_043, Verify The Functionality Of Cancel Button In Change Status Page")
    public void TC_Riders_043_Verify_The_Functionality_Of_Cancel_Button_In_Change_Status_Page() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ridersPage.click_NewRider_Btn();
        String riderName = addNewRiderPage.createAndGetRiderDetails().get("riderFirstName");
        ridersPage.fillWithClear_Search_Txt(riderName);
        ridersPage.chooseAndCancel_SelectStateDropDownMenuOptions_Btn("Allocated");
        softAssert.assertTrue(ridersPage.isPresent_ChangeStatus_Btn(), "Change Status Button is Present as Expected");
        ridersPage.uncheck_TableData_CheckBox(0);
        softAssert.assertTrue(!ridersPage.isPresent_ChangeStatus_Btn(), "Change Status Button is Not Present as Expected");
        ridersPage.click_Status_RadioBtn("Allocated");
        softAssert.assertTrue(ridersPage.isPresent_EmptyTable_Txt(), "Empty Table Message is Present As Expected");
        softAssert.assertEquals(ridersPage.getText_EmptyTable_Txt(), "No search results found", "Message Is Matched As Expected");
        softAssert.assertAll();
    }
}