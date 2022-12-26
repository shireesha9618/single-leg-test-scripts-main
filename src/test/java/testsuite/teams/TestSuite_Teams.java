package testsuite.teams;

import base.BaseTestClass;
import constants.TestGroup;
import framework.common.assertion.JarvisAssert;
import framework.common.assertion.JarvisSoftAssert;
import framework.common.logger.ExtentLogger;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.TeamEditPage;
import pageobjects.TeamsPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TestSuite_Teams extends BaseTestClass {

    CommonActions commonActions = CommonActions.getInstance();
    TeamsPage teamsPage = TeamsPage.getInstance();

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
            teamsPage.validate_Status_RadioBtn(status);
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
            teamsPage.validate_Status_RadioBtn(status);
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
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is present as expected");
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
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is present as expected");
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
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is present as expected");
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
        for (int record = 0; record < actualTabHeadersLabels.size(); record++) {
            softAssert.assertEquals(actualTabHeadersLabels.get(record), expectedTabHeaders.get(record), "Table Header label is matched as expected " + expectedTabHeaders.get(record));
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
        for (int record = 0; record < actualTabHeadersLabelsAfter.size(); record++) {
            softAssert.assertEquals(actualTabHeadersLabelsAfter.get(record), expectedTabHeadersAfter.get(record), "After Uncheck Table Header label is matched as expected " + expectedTabHeadersAfter.get(record));
        }
        commonActions.resetColumns();
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_024, Verify Functionality Of Next Page Pagination Button")
    public void TC_Teams_024_Verify_Functionality_Of_Next_Page_Pagination_Button() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        List<String> currentPageElements = teamsPage.getText_TableDataTeamID_List();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-5", "Validate no of records displayed");
        commonActions.click_PaginationNext_Btn();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "6-10", "Validate no of records displayed");
        List<String> nextPageElements = teamsPage.getText_TableDataTeamID_List();
        JarvisAssert.assertTrue(!currentPageElements.equals(nextPageElements), "Current Page Elements And Next Page Elements Are Not Matched As Expected ");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_025, Verify Functionality Of Previous Page Pagination Button")
    public void TC_Teams_025_Verify_Functionality_Of_Previous_Page_Pagination_Button() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-5", "Validate no of records displayed");
        commonActions.click_PaginationNext_Btn();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "6-10", "Validate no of records displayed");
        List<String> nextPageElements = teamsPage.getText_TableDataTeamID_List();
        commonActions.click_PaginationPrevious_Btn();
        List<String> prevPageElements = teamsPage.getText_TableDataTeamID_List();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-5", "Validate no of records displayed");
        JarvisAssert.assertTrue(!nextPageElements.equals(prevPageElements), "Next Page Elements And Previous Page Elements Are Not Matched As Expected ");
        softAssert.assertAll();
    }
}