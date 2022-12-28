package testsuite.teams;

import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.Constants;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.managers.DriverManager;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.TeamDetailsPage;
import pageobjects.TeamEditPage;
import pageobjects.TeamsPage;

import java.util.HashMap;

public class TestSuite_TeamDetails extends BaseTestClass {
    CommonActions commonActions = CommonActions.getInstance();
    TeamsPage teamsPage = TeamsPage.getInstance();
    TeamDetailsPage teamDetailsPage = TeamDetailsPage.getInstance();
    TeamEditPage teamEditPage = TeamEditPage.getInstance();
    Faker sampleData = new Faker();

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_01, Verify The UI Of Team Details Page")
    public void TC_Teams_01_Verify_The_UI_Of_Teams_Details_Page() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        teamsPage.click_NewTeam_Btn();

        String teamName = teamsPage.createNewTeam().get("teamName");
        teamsPage.fillWithClear_Search_Txt(teamName);
        softAssert.assertTrue(teamsPage.getText_TeamsTableTeamNameColumnList_Link().equals(teamName), "Team Name in Teams table is matched as expected");

        teamsPage.click_TeamsTableIDList_Link(0);
        softAssert.assertTrue(teamDetailsPage.isPresent_Header_Lbl(), "Header Is Present As Expected");
        softAssert.assertTrue(teamName.equals(teamDetailsPage.getText_Header_Lbl()), "Team Name In Team name Label is matched as expected");
        softAssert.assertTrue(teamDetailsPage.isPresent_Edit_Btn(), "Edit Button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_02, Verify The Functionality Of Breadcrumb Menu For Create Teams Page")
    public void TC_Teams_02_Verify_The_Functionality_Of_Breadcrumb_Menu_For_Create_Teams_Page() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        teamsPage.click_NewTeam_Btn();

        String teamName = teamsPage.createNewTeam().get("teamName");
        teamsPage.fillWithClear_Search_Txt(teamName);
        softAssert.assertTrue(teamsPage.getText_TeamsTableTeamNameColumnList_Link().equals(teamName), "Team Name in Teams table is matched as expected");

        teamsPage.click_TeamsTableIDList_Link(0);
        softAssert.assertTrue(teamDetailsPage.isPresent_Header_Lbl(), "Header Is Present As Expected");
        softAssert.assertTrue(teamDetailsPage.isPresent_Edit_Btn(), "Edit Button Is Present As Expected");
        softAssert.assertTrue(teamDetailsPage.isPresent_TeamDetailsBreadCrumb_Link(), "Team Details Breadcrumb Link Is Present As Expected");

        teamDetailsPage.click_TeamsBreadCrumb_Link();
        softAssert.assertEquals(DriverManager.getDriver().getCurrentUrl(), Constants.Urls.BASE_URL + "teams/", "URL is matched as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_03, Verify The Functionality Of edit button in teams details page")
    public void TC_Teams_03_Verify_The_Functionality_Of_Edit_Button_In_Teams_Details_Page() {
        HashMap<String, String> teamDetails = teamsPage.createNewTeam();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");

        teamsPage.fillWithClear_Search_Txt(teamDetails.get("teamName"));
        teamsPage.click_TeamsTableIDList_Link(0);
        softAssert.assertTrue(teamDetailsPage.isPresent_Header_Lbl(), "Team Details Header is present as expected");

        teamDetailsPage.click_Edit_Btn();
        softAssert.assertTrue(teamEditPage.isPresent_Header_lbl(), "Edit Teams Header Is Present As Expected");
        softAssert.assertEquals(teamEditPage.get_TeamName_TextBox(), teamDetails.get("teamName"), "Team Id is matched as expected");
        softAssert.assertEquals(teamEditPage.get_TeamID_TextBox(), teamDetails.get("teamId"), "Team Name is matched as expected");
        softAssert.assertTrue(TeamEditPage.getInstance().isPresent_Save_Btn(), "Save Button Is Present As Expected");
        softAssert.assertTrue(TeamEditPage.getInstance().isPresent_Cancel_Btn(), "Cancel Button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_04,Verify The Functionality Of Cancel Button of Edit Teams")
    public void TC_Teams_04_Verify_The_Functionality_Of_Cancel_Button_Of_Edit_Teams() {
        String teamName = sampleData.name().firstName();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();

        HashMap<String, String> teamDetails = teamsPage.createNewTeam();
        String beforeEditTeamName = teamDetails.get("teamName");
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");

        teamsPage.fillWithClear_Search_Txt(teamDetails.get("teamName"));
        teamsPage.click_TeamsTableIDList_Link(0);
        softAssert.assertTrue(teamDetailsPage.isPresent_Header_Lbl(), "Team Details Header is present as Expected");

        teamDetailsPage.click_Edit_Btn();
        softAssert.assertTrue(teamEditPage.isPresent_Header_lbl(), "Edit Teams Header Is Present As Expected");

        teamEditPage.fillWithClear_teamName_TextBox(teamName);
        teamEditPage.click_Cancel_Btn();
        softAssert.assertTrue(teamDetailsPage.isPresent_Header_Lbl(), "Team Details Header is present as Expected");

        teamDetailsPage.click_Edit_Btn();
        String afterEditTeamName = teamEditPage.get_TeamName_TextBox();
        softAssert.assertTrue(beforeEditTeamName.equals(afterEditTeamName), "Team Name is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.TEAMS}, description = "TC_05,Verify The Functionality Of Save Button of Edit Teams")
    public void TC_Teams_05_Verify_The_Functionality_Of_Save_Button_Of_Edit_Teams() {
        String teamName = sampleData.name().firstName();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();

        HashMap<String, String> teamDetails = teamsPage.createNewTeam();
        String beforeEditTeamName = teamDetails.get("teamName");
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");

        teamsPage.fillWithClear_Search_Txt(teamDetails.get("teamName"));
        teamsPage.click_TeamsTableIDList_Link(0);
        softAssert.assertTrue(teamDetailsPage.isPresent_Header_Lbl(), "Team Details Header is present as Expected");

        teamDetailsPage.click_Edit_Btn();
        softAssert.assertTrue(teamEditPage.isPresent_Header_lbl(), "Edit Teams Header Is Present As Expected");

        teamEditPage.fillWithClear_teamName_TextBox(teamName);
        teamEditPage.click_Create_Btn();
        softAssert.assertTrue(teamDetailsPage.isPresent_Header_Lbl(), "Team Details Header is present as Expected");

        teamDetailsPage.click_Edit_Btn();
        String afterEditTeamName = teamEditPage.get_TeamName_TextBox();
        softAssert.assertTrue(!beforeEditTeamName.equals(afterEditTeamName), "Team Name is Not Matched As Expected");
        softAssert.assertAll();
    }
}