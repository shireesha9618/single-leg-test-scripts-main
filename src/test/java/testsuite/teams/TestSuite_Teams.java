package testsuite.teams;

import base.BaseTestClass;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import framework.common.logger.ExtentLogger;
import framework.frontend.actions.ActionHelper;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageobjects.*;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TestSuite_Teams extends BaseTestClass {

    CommonActions commonActions = CommonActions.getInstance();
    TeamsPage teamsPage = TeamsPage.getInstance();
    CreateNewTeamPage createNewTeamPage = CreateNewTeamPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    TeamDetailsPage teamDetailsPage = TeamDetailsPage.getInstance();


    @Test(groups = {TestGroup.SMOKE, TestGroup.TEAMS}, description = "TC_01, Verify The UI Of Teams Page")
    public void TC_Teams_001_Verify_The_UI_Of_Teams_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is present as expected");
        softAssert.assertTrue(teamsPage.isPresent_TeamBreadcrumb_Lbl(), "Team Breadcrumb is present as expected");
        softAssert.assertTrue(teamsPage.isPresent_NewTeam_Btn(), "New Team Button is present as expected");
        softAssert.assertTrue(teamsPage.isPresent_Search_TextBox(), "Search TextBox is present as expected");
        softAssert.assertTrue(teamsPage.isPresent_Status_Dropdown(), "Status Dropdown is present as expected");
        softAssert.assertTrue(teamsPage.isPresent_MoreActions_Dropdown(), "More Action Dropdown is present as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_02, Verify The UI Of Table Present In Teams Page")
    public void TC_Teams_002_Verify_The_UI_Of_Table_Present_In_Teams_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();
        teamsPage.clickAndChoose_MoreActionsDropDownMenuOptions_Btn("Modify Columns");
        teamsPage.click_EditColumnsSelectAllWithSave_Btn();
        List<String> actualTabHeadersLabels = teamsPage.getText_TableHeaderList_Lbl();
        List<String> expectedTabHeaders = new ArrayList<>(List.of("TEAM ID", "TEAM NAME", "STATUS", "# OF TEAM MANAGERS", "# OF RIDERS", "CREATED AT", "UPDATED AT",
                "CREATED BY", "UPDATED BY"));
        Collections.sort(actualTabHeadersLabels);
        Collections.sort(expectedTabHeaders);
        for (int record = 0; record < actualTabHeadersLabels.size(); record++) {
            softAssert.assertEquals(actualTabHeadersLabels.get(record), expectedTabHeaders.get(record), "Table Header label is matched as expected " + expectedTabHeaders.get(record));
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.TEAMS}, description = "TC_03, Verify The UI Of More Actions ")
    public void TC_Teams_003_Verify_The_UI_Of_More_Actions() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is present as expected");
        teamsPage.click_MoreActions_Dropdown();
        softAssert.assertTrue(teamsPage.isPresent_MoreActionsDropDownExportAsCSV_Link(), "More Actions DropDown Export As CSV is present as expected");
        softAssert.assertTrue(teamsPage.isPresent_MoreActionsDropDownModifyColumns_Link(), "More Actions DropDown Modify Columns is present as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.TEAMS}, description = "TC_05, Verify The Functionality Of Search Bar")
    public void TC_Teams_005_Verify_The_Functionality_Of_Search_Bar() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        HashMap<String, String> teamData = teamsPage.createNewTeam();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is present as expected");
        teamsPage.set_SearchTeam_TextBox(teamData.get("teamName"));
        softAssert.assertEquals(commonActions.get_TableData_Count(), 1, "Data count is matched as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.TEAMS}, description = "TC_06,Verify The UI Of Status Button")
    public void TC_Teams_006_Verify_The_UI_Of_Status_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();
        teamsPage.open_Status_DropDown();
        softAssert.assertTrue(teamsPage.isEnabled_StatusDropDownActiveValue_Radio(), "Validate presence of Available radio button");
        softAssert.assertTrue(teamsPage.isEnabled_StatusDropDownPauseValue_Radio(), "Validate presence of Busy radio button");
        softAssert.assertTrue(teamsPage.isEnabled_StatusDropDownDeBoardValue_Radio(), "Validate presence of Unavailable radio button");
        softAssert.assertTrue(teamsPage.isEnabled_StatusDropDownInactiveValue_Radio(), "Validate presence of Allocated radio button");
        softAssert.assertTrue(teamsPage.isEnabled_StatusDropDownTerminalValue_Radio(), "Validate presence of Terminal radio button");
        softAssert.assertTrue(teamsPage.isEnabled_StatusDropDownOnboardingValue_Radio(), "Validate presence of Onboarding radio button");
        softAssert.assertTrue(teamsPage.isPresent_StatusDropDownClearSelection_Btn(), "Validate presence of Clear Selection button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_07_08_09_010_011, Verify The Functionality Of Filter The Rider With All Status")
    public void TC_Teams_07_08_09_010_011_Verify_The_Functionality_Of_Filter_The_Teams_With_All_Status() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is present as expected");
        String[] statusList = {"Active", "Pause", "Deboard", "Inactive", "Terminal", "Onboarding"};
        for (String status : statusList) {
            ExtentLogger.logPass("Validating" + status + "Status radiobutton");
            teamsPage.click_Status_RadioBtn(status);
            if (!teamsPage.isPresent_EmptyTable_Txt()) {
                for (String value : teamsPage.getTxt_RidersTableStatusColumnList_Link())
                    softAssert.assertEquals(value, status, status + " Status Is Present As Expected");
            } else {
                softAssert.assertTrue(teamsPage.isPresent_EmptyTable_Txt(), "Table Has No Record Empty Table");
                softAssert.assertEquals(teamsPage.getText_EmptyTable_Txt(), "It is Empty here", "Table Empty Is Matched As Expected");
            }
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_12, Verify The Functionality Of ClearSelection In Status")
    public void TC_Teams_012_Verify_The_Functionality_Of_ClearSelection_In_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();
        List<String> initialStatusList = teamsPage.getTxt_TeamsTableStatusColumnList_Link();
        String[] statusList = {"Active", "Pause", "Deboard", "Inactive", "Terminal", "Onboarding"};
        for (String status : statusList) {
            teamsPage.click_Status_RadioBtn(status);
            if (!teamsPage.isPresent_EmptyTable_Txt()) {
                for (String value : teamsPage.getTxt_RidersTableStatusColumnList_Link())
                    softAssert.assertEquals(value, status, status + " Status Is Present As Expected");
            } else {
                softAssert.assertTrue(teamsPage.isPresent_EmptyTable_Txt(), "Table Has No Record Empty Table");
                softAssert.assertEquals(teamsPage.getText_EmptyTable_Txt(), "It is Empty here", "Table Empty Is Matched As Expected");
            }
            teamsPage.click_StatusDropDownClearSelection_Btn();
            List<String> currentStatusList = teamsPage.getTxt_TeamsTableStatusColumnList_Link();
            for (int record = 0; record < initialStatusList.size(); record++)
                softAssert.assertEquals(currentStatusList.get(record), initialStatusList.get(record), "Validate Status is the same as initial values");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_13, Verify The Functionality Of edit button in teams page")
    public void TC_Teams_013_Verify_The_Functionality_Of_Edit_Button_In_Teams_Page() {
        HashMap<String, String> teamDetails = teamsPage.createNewTeam();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is present as expected");
        teamsPage.set_SearchTeam_TextBox(teamDetails.get("teamName"));
        teamsPage.click_Edit_Btn(0);
        softAssert.assertTrue(TeamEditPage.getInstance().isPresent_Header_lbl(), "Edit team Header is present as expected");
        softAssert.assertEquals(TeamEditPage.getInstance().get_TeamName_TextBox(), teamDetails.get("teamName"), "Team Id is matched as expected");
        softAssert.assertEquals(TeamEditPage.getInstance().get_TeamID_TextBox(), teamDetails.get("teamId"), "Team Name is matched as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_14, Verify The UI of Edit Teams")
    public void TC_Teams_014_Verify_The_UI_Of_Edit_Teams() {
        HashMap<String, String> teamDetails = teamsPage.createNewTeam();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is present as expected");
        teamsPage.set_SearchTeam_TextBox(teamDetails.get("teamName"));
        teamsPage.click_Edit_Btn(0);
        softAssert.assertTrue(TeamEditPage.getInstance().isPresent_Header_lbl(), "Edit team Header is present as expected");
        softAssert.assertEquals(TeamEditPage.getInstance().get_TeamName_TextBox(), teamDetails.get("teamName"), "Team Id is matched as expected");
        softAssert.assertEquals(TeamEditPage.getInstance().get_TeamID_TextBox(), teamDetails.get("teamId"), "Team Name is matched as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_015,Verify The Functionality Of Cancel Button of Edit Teams")
    public void TC_Teams_015_Verify_The_Functionality_Of_Cancel_Button_Of_Edit_Teams() {
        HashMap<String, String> teamDetails = teamsPage.createNewTeam();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        teamsPage.set_SearchTeam_TextBox(teamDetails.get("teamName"));
        teamsPage.click_Edit_Btn(0);
        softAssert.assertTrue(TeamEditPage.getInstance().isPresent_Header_lbl(), "Edit team Header is present as expected");
        softAssert.assertEquals(TeamEditPage.getInstance().get_TeamName_TextBox(), teamDetails.get("teamName"), "Team Id is matched as expected");
        softAssert.assertEquals(TeamEditPage.getInstance().get_TeamID_TextBox(), teamDetails.get("teamId"), "Team Name is matched as expected");
        TeamEditPage.getInstance().click_Cancel_Btn();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Teams Header is present as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_017,  Verify The Functionality Of Modify Columns For More Actions Button")
    public void TC_Teams_017_Verify_The_Functionality_Of_ModifyColumns_For_More_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();
        teamsPage.click_MoreActions_Dropdown();
        teamsPage.click_MoreActionsDropDownModifyColumns_Link();
        softAssert.assertTrue(teamsPage.isPresent_ModifyColumns_SearchBar(), "Validate presence of Search Bar");
        softAssert.assertTrue(teamsPage.isPresent_EditColumnsHeader_Lbl(), "Validate presence of Edit Columns Header");
        softAssert.assertTrue(teamsPage.isPresent_MoreActionsDropDownModifyColumnsLinkSelectAll_Btn(), "Validate presence of SelectAll Button");
        softAssert.assertTrue(teamsPage.isPresent_EdiColumnName_Lbl("Team Id"), "Validate presence of Rider Name Checkbox");
        softAssert.assertTrue(teamsPage.isPresent_EdiColumnName_Lbl("Team Name"), "Validate presence of Rider Id Checkbox");
        softAssert.assertTrue(teamsPage.isPresent_EdiColumnName_Lbl("Status"), "Validate presence of Phone Number Checkbox");
        softAssert.assertTrue(teamsPage.isPresent_EdiColumnName_Lbl("# of Team Managers"), "Validate presence of Status Checkbox");
        softAssert.assertTrue(teamsPage.isPresent_EdiColumnName_Lbl("# of Riders"), "Validate presence of Teams Checkbox");
        softAssert.assertTrue(teamsPage.isPresent_EdiColumnName_Lbl("Created At"), "Validate presence of Created At Checkbox");
        softAssert.assertTrue(teamsPage.isPresent_EdiColumnName_Lbl("Updated At"), "Validate presence of Updated At Checkbox");
        softAssert.assertTrue(teamsPage.isPresent_EdiColumnName_Lbl("Created By"), "Validate presence of Created By Checkbox");
        softAssert.assertTrue(teamsPage.isPresent_EdiColumnName_Lbl("Updated By"), "Validate presence of Created By Checkbox");
        softAssert.assertTrue(teamsPage.isPresent_MoreActionsDropDownModifyColumnsLinkSave_Btn(), "Validate presence of Save Button");
        softAssert.assertTrue(teamsPage.isPresent_MoreActionsDropDownModifyColumnsLinkCancel_Btn(), "Validate presence of Cancel Checkbox");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_018, Verify The Functionality Of Select All Of Modify Columns For More Actions Button")
    public void TC_Teams_018_Verify_The_Functionality_Of_Select_All_Of_Modify_Columns_For_MoreActions_Button() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Check Text Visibility Of Heading");
        teamsPage.click_MoreActions_Dropdown();
        teamsPage.click_MoreActionsDropDownModifyColumns_Link();
        teamsPage.click_MoreActionsDropDownModifyColumnsLinkSelectAll_Btn();
        softAssert.assertEquals(teamsPage.getSize_EditColumnsSearchRightList_Link(), teamsPage.getSize_EditColumnsSearchLeftList_Link(), "Select All Work Left & Right Record are Same");
        teamsPage.unCheck_EdiColumnName_CheckBox("Team Id");
        teamsPage.unCheck_EdiColumnName_CheckBox("Team Name");
        softAssert.assertTrue(teamsPage.getSize_EditColumnsSearchRightList_Link() != teamsPage.getSize_EditColumnsSearchLeftList_Link(), "Left And Right Record Is Not Same As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_019, Verify The Functionality Of Drag The Position Of Modify Columns For More Actions Button")
    public void TC_Teams_019_Verify_The_Functionality_Of_Drag_The_Position_Of_Modify_Columns_For_More_Actions_Button() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        teamsPage.click_MoreActions_Dropdown();
        teamsPage.click_MoreActionsDropDownModifyColumns_Link();
        List<String> expectedOptions = teamsPage.getText_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label();
        String temp = expectedOptions.get(0);
        expectedOptions.add(0, expectedOptions.get(1));
        expectedOptions.remove(1);
        expectedOptions.add(1, temp);
        expectedOptions.remove(2);
        teamsPage.dragAndDrop_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label(0, 1);
        List<String> actualOptions = teamsPage.getText_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label();
        for (int count = 0; count < expectedOptions.size(); count++)
            softAssert.assertEquals(actualOptions.get(count), expectedOptions.get(count), "Validate order of options");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_020, Verify The Functionality Of Checkbox And X Of Modify Columns For Actions Button")
    public void TC_Teams_020_Verify_The_Functionality_Of_Checkbox_And_X_Of_Modify_Columns_For_Actions_Button() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        teamsPage.clickAndChoose_MoreActionsDropDownMenuOptions_Btn("Modify Columns");
        teamsPage.click_MoreActionsDropDownModifyColumnsLinkSelectAll_Btn();
        softAssert.assertTrue(teamsPage.getText_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label().contains("Status"), "Validate presence of Status as option");
        teamsPage.click_MoreActionsDropDownModifyColumnsStatus_CheckBox();
        softAssert.assertTrue(!teamsPage.getText_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label().contains("Status"), "Validate absence of Status as option");
        teamsPage.click_MoreActionsDropDownModifyColumnsStatus_CheckBox();
        softAssert.assertTrue(teamsPage.getText_MoreActionsDropDownModifyColumnsLinkSelectedOptionsList_Label().contains("Status"), "Validate presence of Status as option");
        teamsPage.click_MoreActionsDropDownModifyColumnsStatusCross_Icon();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_021, Verify The Functionality Of Search Bar Of Modify Columns For Actions Button")
    public void TC_Teams_021_Verify_The_Functionality_Of_Search_Bar_Of_Modify_Columns_For_Actions_Button() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        teamsPage.clickAndChoose_MoreActionsDropDownMenuOptions_Btn("Modify Columns");
        teamsPage.fill_EditColumnsSearch_Txt("Test");
        softAssert.assertTrue(!teamsPage.isPresent_EdiColumnName_Lbl("Team Id"), "Validate presence of Rider Name Checkbox");
        softAssert.assertTrue(!teamsPage.isPresent_EdiColumnName_Lbl("Team Name"), "Validate presence of Rider Id Checkbox");
        softAssert.assertTrue(!teamsPage.isPresent_EdiColumnName_Lbl("Status"), "Validate presence of Phone Number Checkbox");
        softAssert.assertTrue(!teamsPage.isPresent_EdiColumnName_Lbl("# of Team Managers"), "Validate presence of Status Checkbox");
        softAssert.assertTrue(!teamsPage.isPresent_EdiColumnName_Lbl("# of Riders"), "Validate presence of Teams Checkbox");
        softAssert.assertTrue(!teamsPage.isPresent_EdiColumnName_Lbl("Created At"), "Validate presence of Created At Checkbox");
        softAssert.assertTrue(!teamsPage.isPresent_EdiColumnName_Lbl("Updated At"), "Validate presence of Updated At Checkbox");
        softAssert.assertTrue(!teamsPage.isPresent_EdiColumnName_Lbl("Created By"), "Validate presence of Created By Checkbox");
        softAssert.assertTrue(!teamsPage.isPresent_EdiColumnName_Lbl("Updated By"), "Validate presence of Created By Checkbox");
        teamsPage.fill_EditColumnsSearch_Txt("Team Id");
        softAssert.assertTrue(teamsPage.isPresent_EdiColumnName_Lbl("Team Id"), "Validate Presence of Teams Checkbox");
        softAssert.assertEquals(teamsPage.getSize_EditColumnsSearchLeftList_Link(), 1, "One Record Is Visible On Left Pane As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_022, Verify The Functionality Of Cancel Button Of Modify Columns For More Actions Button")
    public void TC_Teams_022_Verify_The_Functionality_Of_Cancel_Button_Of_Modify_Columns_For_More_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();
        teamsPage.click_MoreActions_Dropdown();
        teamsPage.clickAndChoose_MoreActionsDropDownMenuOptions_Btn("Modify Columns");
        teamsPage.click_MoreActionsDropDownModifyColumnsLinkCancel_Btn();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Validate presence of Teams List header label");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_23, Verify The Functionality Of Save Button Of Modify Columns For More Actions Button")
    public void TC_Teams_023_Verify_The_Functionality_Of_Save_Button_Of_Modify_Columns_For_More_Actions_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();
        teamsPage.clickAndChoose_MoreActionsDropDownMenuOptions_Btn("Modify Columns");
        teamsPage.click_EditColumnsSelectAllWithSave_Btn();
        List<String> actualTabHeadersLabels = teamsPage.getText_TableHeaderList_Lbl();
        List<String> expectedTabHeaders = new ArrayList<>(List.of("TEAM ID", "TEAM NAME", "STATUS", "# OF TEAM MANAGERS", "# OF RIDERS", "CREATED AT", "UPDATED AT",
                "CREATED BY", "UPDATED BY"));
        Collections.sort(actualTabHeadersLabels);
        Collections.sort(expectedTabHeaders);
        for (int size = 0; size < actualTabHeadersLabels.size(); size++) {
            softAssert.assertEquals(actualTabHeadersLabels.get(size), expectedTabHeaders.get(size), "Table Header label is matched as expected " + expectedTabHeaders.get(size));
        }
        teamsPage.clickAndChoose_MoreActionsDropDownMenuOptions_Btn("Modify Columns");
        teamsPage.click_MoreActionsDropDownModifyColumnsLinkSelectAll_Btn();
        teamsPage.unCheck_EdiColumnName_CheckBox("Team Id");
        teamsPage.unCheck_EdiColumnName_CheckBox("Status");
        teamsPage.unCheck_EdiColumnName_CheckBox("Created At");
        teamsPage.unCheck_EdiColumnName_CheckBox("Updated By");
        teamsPage.click_MoreActionsDropDownModifyColumnsLinkSave_Btn();
        List<String> actualTabHeadersLabelsAfter = teamsPage.getText_TableHeaderList_Lbl();
        List<String> expectedTabHeadersAfter = new ArrayList<>(List.of("TEAM NAME", "# OF TEAM MANAGERS", "# OF RIDERS", "UPDATED AT", "CREATED BY", "UPDATED BY"));
        Collections.sort(actualTabHeadersLabelsAfter);
        Collections.sort(expectedTabHeadersAfter);
        for (int size = 0; size < actualTabHeadersLabelsAfter.size(); size++) {
            softAssert.assertEquals(actualTabHeadersLabelsAfter.get(size), expectedTabHeadersAfter.get(size), "After Uncheck Table Header label is matched as expected " + expectedTabHeadersAfter.get(size));
        }
        commonActions.resetColumns();
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_024, Verify Functionality Of Next Page Pagination Button")
    public void TC_Teams_024_Verify_Functionality_Of_Next_Page_Pagination_Button() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        List<String> currentPageElements = commonActions.getList_TableDataList_Lbl("TEAM ID");
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-5", "Validate no of records displayed");
        commonActions.click_PaginationNext_Btn();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "6-10", "Validate no of records displayed");
        List<String> nextPageElements = commonActions.getList_TableDataList_Lbl("TEAM ID");
        softAssert.assertTrue(!currentPageElements.equals(nextPageElements), "Current Page Elements And Next Page Elements Are Not Matched As Expected ");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_025, Verify Functionality Of Previous Page Pagination Button")
    public void TC_Teams_025_Verify_Functionality_Of_Previous_Page_Pagination_Button() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-5", "Validate no of records displayed");
        commonActions.click_PaginationNext_Btn();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "6-10", "Validate no of records displayed");
        List<String> nextPageElements = commonActions.getList_TableDataList_Lbl("TEAM ID");
        commonActions.click_PaginationPrevious_Btn();
        List<String> prevPageElements = commonActions.getList_TableDataList_Lbl("TEAM ID");
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-5", "Validate no of records displayed");
        softAssert.assertTrue(!nextPageElements.equals(prevPageElements), "Next Page Elements And Previous Page Elements Are Not Matched As Expected ");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_026 Verify Functionality Of Vertically Scroll Of Teams Table Using Mouse Scroll Wheel")
    public void TC_Teams_026_Verify_Functionality_Of_Vertically_Scroll_Of_Teams_Table_Using_Mouse_Scroll_Wheel() {
        CommonActions.getInstance().coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.chooseNoOfRecordToBeDisplayed(10);
        List<WebElement> elements = teamsPage.getElements_TeamsTableTeamIdColumnList_Link();
        Utility.validatePageScrollDown(elements.get(elements.size() - 1));
        softAssert.assertTrue(ActionHelper.isPresent(elements.get(elements.size() - 1), 3000), "Validate last element is present");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_027, Verify Functionality Of Vertically Scroll Of Teams Table Using Keyboard")
    public void TC_Teams_027_Verify_Functionality_Of_Vertically_Scroll_Of_Teams_Table_Using_Keyboard() {
        CommonActions.getInstance().coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.chooseNoOfRecordToBeDisplayed(10);
        List<WebElement> elements = teamsPage.getElements_TeamsTableTeamIdColumnList_Link();
        Utility.scrollDownUsingKeyboardKey(10);
        softAssert.assertTrue(ActionHelper.isPresent(elements.get(elements.size() - 1), 3000), "Validate last element is present");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_028, Verify Displaying Of Teams Table Records As Per Pagination Value")
    public void TC_Teams_028_Verify_Displaying_Of_Teams_Table_Records_As_Per_Pagination_Value() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillTeams();
        commonActions.chooseNoOfRecordToBeDisplayed(10);
        softAssert.assertTrue(teamsPage.validateTeamsTableRecordEqualsToPerPaginationOptions(), "Table Has Not More Than 10 Record Present As Expected");

        commonActions.chooseNoOfRecordToBeDisplayed(20);
        softAssert.assertTrue(teamsPage.validateTeamsTableRecordEqualsToPerPaginationOptions(), "Table Has Not More Than 20 Record Present As Expected");

        commonActions.chooseNoOfRecordToBeDisplayed(50);
        softAssert.assertTrue(teamsPage.validateTeamsTableRecordEqualsToPerPaginationOptions(), "Table Has Not More Than 50 Record Present As Expected");

        commonActions.chooseNoOfRecordToBeDisplayed(5);
        softAssert.assertTrue(teamsPage.validateTeamsTableRecordEqualsToPerPaginationOptions(), "Table Has Not More Than 5 Record Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_029, Verify Functionality Of Pagination Paging Block")
    public void TC_Teams_029_Verify_Functionality_Of_Pagination_Paging_Block() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillTeams();
        commonActions.chooseNoOfRecordToBeDisplayed(50);
        List<WebElement> webElement = new ArrayList<>(teamsPage.getElements_TeamsTableTeamIdColumnList_Link());
        String firstBlockElement = webElement.get(0).getText();
        String secondBlockElement = webElement.get(5).getText();
        commonActions.chooseNoOfRecordToBeDisplayed(5);
        commonActions.select_PaginationBlock_Txt(1);
        String webElementForFirstBlock = new ArrayList<>(teamsPage.getElements_TeamsTableTeamIdColumnList_Link()).get(0).getText();
        softAssert.assertEquals(webElementForFirstBlock, firstBlockElement, "Pagination First Block Record Is Matched As Expected");

        commonActions.select_PaginationBlock_Txt(2);
        String webElementForSecondBlock = new ArrayList<>(teamsPage.getElements_TeamsTableTeamIdColumnList_Link()).get(0).getText();

        softAssert.assertEquals(webElementForSecondBlock, secondBlockElement, "Pagination Second Block Record Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_030, Verify Functionality Of Pagination Paging Block With Next And Previous Button")
    public void TC_Teams_030_Verify_Functionality_Of_Pagination_Paging_Block_With_Next_And_Previous_Button() {
        CommonActions.getInstance().coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.chooseNoOfRecordToBeDisplayed(5);
        commonActions.click_PaginationNext_Btn();
        List<WebElement> webElementAfterNext = new ArrayList<>(teamsPage.getElements_TeamsTableTeamIdColumnList_Link());
        String nextBlockElement = webElementAfterNext.get(0).getText();
        commonActions.click_PaginationPrevious_Btn();
        List<WebElement> webElementAfterPrevious = new ArrayList<>(teamsPage.getElements_TeamsTableTeamIdColumnList_Link());
        String prevBlockElement = webElementAfterPrevious.get(0).getText();

        commonActions.select_PaginationBlock_Txt(2);
        String webElementForSecondBlock = new ArrayList<>(teamsPage.getElements_TeamsTableTeamIdColumnList_Link()).get(0).getText();
        softAssert.assertEquals(webElementForSecondBlock, nextBlockElement, "Pagination Second Block Record Is Matched With Next As Expected");

        commonActions.select_PaginationBlock_Txt(1);
        String webElementForFirstBlock = new ArrayList<>(teamsPage.getElements_TeamsTableTeamIdColumnList_Link()).get(0).getText();
        softAssert.assertEquals(webElementForFirstBlock, prevBlockElement, "Pagination First Block Record Is Matched With Previous As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_031, Verify Functionality Of Pagination Per Page With Paging Block And Next Button")
    public void TC_Teams_031_Verify_Functionality_Of_Pagination_Per_Page_With_Paging_Block_And_Next_Button() {
        CommonActions.getInstance().coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.chooseNoOfRecordToBeDisplayed(10);
        String elementAfterTenthPagination = new ArrayList<>(teamsPage.getElements_TeamsTableTeamIdColumnList_Link()).get(5).getText();
        commonActions.chooseNoOfRecordToBeDisplayed(5);
        String elementAfterFifthPagination = new ArrayList<>(teamsPage.getElements_TeamsTableTeamIdColumnList_Link()).get(0).getText();
        commonActions.click_PaginationNext_Btn();
        String elementAfterNext = new ArrayList<>(teamsPage.getElements_TeamsTableTeamIdColumnList_Link()).get(0).getText();
        softAssert.assertEquals(elementAfterTenthPagination, elementAfterNext, "Pagination 10 Per Page Record Is Matched With Next As Expected");

        commonActions.click_PaginationPrevious_Btn();
        String elementAfterPrev = new ArrayList<>(teamsPage.getElements_TeamsTableTeamIdColumnList_Link()).get(0).getText();
        softAssert.assertEquals(elementAfterFifthPagination, elementAfterPrev, "Pagination 5 Per Page Record Is Matched With Prev As Expected");

        commonActions.select_PaginationBlock_Txt(2);
        String elementForSecondBlock = new ArrayList<>(teamsPage.getElements_TeamsTableTeamIdColumnList_Link()).get(0).getText();
        softAssert.assertEquals(elementForSecondBlock, elementAfterNext, "Pagination 2 Block Record Is Matched With Next As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_032, Verify The Functionality Of New Team Button")
    public void TC_Teams_032_Verify_The_Functionality_Of_New_Team_Button() {
        CommonActions.getInstance().coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is Present As Expected");
        softAssert.assertEquals(teamsPage.getText_TeamsHeader_Lbl(), "Teams", "Teams Header is Matched As Expected");
        teamsPage.click_NewTeam_Btn();
        softAssert.assertTrue(createNewTeamPage.isPresent_Header_lbl(), "Create Teams Heading Is Present As Expected");
        softAssert.assertTrue(createNewTeamPage.isPresent_Cancel_Btn(), "Cancel Button Is Present As Expected");
        softAssert.assertTrue(createNewTeamPage.isPresent_Create_Btn(), "Create Button Is Present As Expected");
        softAssert.assertAll();
    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_033, Verify The UI Of Table Record")
    public void TC_Teams_033_Verify_The_UI_Of_Table_Record() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();
        teamsPage.click_NewTeam_Btn();

        String teamName = teamsPage.createNewTeam().get("teamName");
        teamsPage.fillWithClear_Search_Txt(teamName);
        softAssert.assertTrue(teamsPage.getText_TeamsTableTeamNameColumnList_Link().equals(teamName), "Team Name in Teams table is matched as expected");

        teamsPage.click_TableData_Lbl("TEAM ID");
        softAssert.assertTrue(teamDetailsPage.isPresent_Header_Lbl(), "Header Is Present As Expected");
        softAssert.assertTrue(teamName.equals(teamDetailsPage.getText_Header_Lbl()), "Team Name In Team name Label is matched as expected");
        softAssert.assertTrue(teamDetailsPage.isPresent_Edit_Btn(), "Edit Button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(enabled = false, groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_034, Verify The Functionality Of Select All CheckBox Present In Teams Table Heading")
    public void TC_Teams_034_Verify_The_Functionality_Of_Select_All_CheckBox_Present_In_Teams_Table_Heading() {
        CommonActions.getInstance().coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is Present As Expected");
        softAssert.assertEquals(teamsPage.getText_TeamsHeader_Lbl(), "Teams", "Teams Header is Matched As Expected");
        softAssert.assertTrue(teamsPage.isPresent_SelectAll_CheckBox(), "Select All CheckBox Is Present As Expected");
        teamsPage.click_SelectAll_CheckBox();
        softAssert.assertTrue(teamsPage.isPresent_Deactivate_Btn(), "Deactivate Button is Present as Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_035, Verify The Functionality Of CheckBox Present In Teams Table for any record")
    public void TC_Teams_035_Verify_The_Functionality_Of_CheckBox_Present_In_Teams_Table_For_Any_Record() {
        CommonActions.getInstance().coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is Present As Expected");
        softAssert.assertEquals(teamsPage.getText_TeamsHeader_Lbl(), "Teams", "Teams Header is Matched As Expected");

        teamsPage.check_TableData_CheckBox(0);
        softAssert.assertTrue(teamsPage.isPresent_Deactivate_Btn(), "Deactivate Button is Present as Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_036, Verify The Functionality Of Unchecking the CheckBox")
    public void TC_Teams_036_Verify_The_Functionality_Of_Unchecking_The_CheckBox() {
        CommonActions.getInstance().coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is Present As Expected");
        softAssert.assertEquals(teamsPage.getText_TeamsHeader_Lbl(), "Teams", "Teams Header is Matched As Expected");

        teamsPage.check_TableData_CheckBox(0);
        softAssert.assertTrue(teamsPage.isPresent_Deactivate_Btn(), "Deactivate Button is Present as Expected");

        teamsPage.uncheck_TableData_CheckBox(0);
        softAssert.assertTrue(!teamsPage.isPresent_Deactivate_Btn(), "Deactivate Button is Not Present as Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_037, Verify The Functionality of Deactivate Button")
    public void TC_Riders_037_Verify_The_Functionality_Of_Deactivate_Button() {
        CommonActions.getInstance().coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is Present As Expected");
        softAssert.assertEquals(teamsPage.getText_TeamsHeader_Lbl(), "Teams", "Teams Header is Matched As Expected");

        teamsPage.check_TableData_CheckBox(0);
        softAssert.assertTrue(teamsPage.isPresent_Deactivate_Btn(), "Deactivate Button is Present as Expected");

        teamsPage.click_Deactivate_Btn();
        softAssert.assertTrue(teamsPage.isPresent_DeactivateTeamHeader_Lbl(), "Deactivate Team Header Is Present As Expected");
        softAssert.assertEquals(teamsPage.getText_DeactivateTeamHeader_Lbl(), "Deactivate Team", "Deactivate Facility Header Is Matched With Header As Expected");
        softAssert.assertTrue(teamsPage.isPresent_DeactivateTeamCancel_Btn(), "Cancel Button In Deactivate Page Is Present As Expected");
        softAssert.assertTrue(teamsPage.isPresent_DeactivateTeamDeactivate_Btn(), "Deactivate Button In Deactivate Page Is Present As Expected");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_038, Verify The Functionality Of Cancel Button In Deactivate Page")
    public void TC_Facility_038_Verify_The_Functionality_Of_Cancel_Button_In_Deactivate_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillTeams();
        teamsPage.click_NewTeam_Btn();
        teamsPage.createNewTeam();
        String teamPageHeader = teamsPage.getText_TeamsHeader_Lbl();
        String statusOfData = commonActions.getText_TableData_Lbl("STATUS");
        teamsPage.check_TableData_CheckBox(0);
        softAssert.assertTrue(teamsPage.isPresent_Deactivate_Btn(), "Deactivate Button Is Present As Expected");

        teamsPage.click_Deactivate_Btn();
        softAssert.assertEquals(teamsPage.getText_DeactivateTeamHeader_Lbl(), "Deactivate Team", "Deactivate Team Header Is Matched With Header As Expected");

        teamsPage.click_DeactivateTeamCancel_Btn();
        softAssert.assertEquals(teamsPage.getText_TeamsHeader_Lbl(), teamPageHeader, "Teams Header Is Matched As Expected");
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("STATUS"), statusOfData, "Status Is Active And Didn't Changed As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_039, Verify The Functionality Of Deactivate Button In Deactivate Page")
    public void TC_Teams_039_Verify_The_Functionality_Of_Deactivate_Button_In_Deactivate_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();
        teamsPage.click_NewTeam_Btn();
        teamsPage.createNewTeam();
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("STATUS"), "Active", "Status Is Active As Expected");

        teamsPage.check_TableData_CheckBox(0);
        softAssert.assertTrue(teamsPage.isPresent_Deactivate_Btn(), "Deactivate Button Is Present As Expected");

        TeamsPage.getInstance().click_Deactivate_Btn();
        softAssert.assertEquals(teamsPage.getText_DeactivateTeamHeader_Lbl(), "Deactivate Team", "Deactivate Team Header Is Matched With Header As Expected");

        TeamsPage.getInstance().click_DeactivateTeamDeactivate_Btn();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Teams Header Is Present As Expected");
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("STATUS"), "Inactive", "Status Changed To Inactive As Expected");
        softAssert.assertAll();
    }

    @Test(enabled = false, groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_040, Verify The Functionality Dock and Undock of Left Panel")
    public void TC_Teams_040_Verify_The_Functionality_Of_Dock_And_UnDock_Of_Left_Panel() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillTeams();
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_041, Verify The Functionality of Open Menu Button")
    public void TC_Teams_041_Verify_The_Functionality_Of_Open_Menu_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillTeams();
        homePage.click_OpenMenu_Btn();
        softAssert.assertTrue(homePage.isPresent_AppsHeader_Lbl(), "Header Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuOrders_Btn(), "Orders Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuDispatch_Btn(), "Dispatch Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuRiders_Btn(), "Riders Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuFacilities_Btn(), "Facilities Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuRouting_Btn(), "Routing Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuTeams_Btn(), "Teams Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuSettings_Btn(), "Settings Open Menu Button Is Present As Expected");

        homePage.click_OpenMenuTeams_Btn();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Teams Header Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_042, Verify The Functionality of Cross Button Of Open Menu")
    public void TC_Teams_042_Verify_The_Functionality_Of_Cross_Button_Of_Open_Menu() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillTeams();
        homePage.click_OpenMenu_Btn();
        softAssert.assertTrue(homePage.isPresent_AppsHeader_Lbl(), "Apps Header Is Present As Expected");

        homePage.click_OpenMenuCross_Btn();
        softAssert.assertTrue(!homePage.isPresent_AppsHeader_Lbl(), "Apps Header Is Not Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_043, Verify The Functionality of Work Flow Button")
    public void TC_Teams_043_Verify_The_Functionality_Of_Work_Flow_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillTeams();
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_044, Verify The Functionality Of Teams Button Of Work Flow")
    public void TC_Teams_044_Verify_The_Functionality_Of_Teams_Button_Of_Work_Flow() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillTeams();
        homePage.click_DelhiveryLogo_Img();
        softAssert.assertTrue(homePage.isPresent_WorkFlowTeams_Btn(), "Teams Button Is Present As Expected");

        homePage.click_WorkFlowTeams_Btn();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Teams Header Is Present As Expected");
        softAssert.assertAll();
    }
}