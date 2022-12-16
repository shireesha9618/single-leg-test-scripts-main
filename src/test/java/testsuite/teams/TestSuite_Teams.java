package testsuite.teams;

import base.BaseTestClass;
import constants.Constants;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.TeamsPage;

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
//        softAssert.assertTrue(teamsPage.isPresent_Status_Dropdown(), "Status Dropdown is present as expected");
        softAssert.assertTrue(teamsPage.isPresent_MoreActions_Dropdown(), "More Action Dropdown is present as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.TEAMS}, description = "TC_03, Verify The UI Of More Actions ")
    public void TC_Teams_001_Verify_The_UI_Of_More_Actions() {
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
        commonActions.coverJourneyTillTeams();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Header is present as expected");
        teamsPage.set_SearchTeam_TextBox(Constants.TEAM);
        softAssert.assertEquals(teamsPage.get_size(), 1, "matched");
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
    //to test

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_12, Verify The Functionality Of ClearSelection In Status")
    public void TC_Teams_12_Verify_The_Functionality_Of_ClearSelection_In_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();
        List<String> initialStatusList = teamsPage.getTxt_TeamsTableStatusColumnList_Link();
        teamsPage.open_Status_DropDown();
        teamsPage.click_StatusDropDownAvailableValue_Radio();
        for (String text : teamsPage.getTxt_TeamsTableStatusColumnList_Link())
            softAssert.assertEquals(text, "Available", "Status Is Available For All Record As Expected ");
        teamsPage.click_StatusDropDownClearSelection_Btn();
        List<String> currentStatusList = teamsPage.getTxt_TeamsTableStatusColumnList_Link();
        for (int i = 0; i < initialStatusList.size(); i++)
            softAssert.assertEquals(currentStatusList.get(i), initialStatusList.get(i), "Validate Status is the same as initial values");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.RIDERS_PAGE}, description = "TC_13, Verify The Functionality Of edit button in teams page")
    public void TC_Teams_13_Verify_The_Functionality_Of_Edit_Button_In_Teams_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();

    }

}
