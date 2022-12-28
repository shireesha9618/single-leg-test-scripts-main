package testsuite.teams;

import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.Constants;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.managers.DriverManager;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.CreateNewTeamPage;
import pageobjects.HomePage;
import pageobjects.TeamsPage;
import utils.Utils;

import java.util.HashMap;

public class TestSuite_CreateNewTeam extends BaseTestClass {
    HomePage homePage = HomePage.getInstance();
    CommonActions commonActions = CommonActions.getInstance();
    TeamsPage teamsPage = TeamsPage.getInstance();
    CreateNewTeamPage createNewTeamPage = CreateNewTeamPage.getInstance();
    Faker sampleData = new Faker();


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_01, Verify The UI Of Create Teams Page")
    public void TC_Teams_01_Verify_The_UI_Of_Create_Teams_Page() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        teamsPage.click_NewTeam_Btn();
        softAssert.assertTrue(createNewTeamPage.isPresent_HomeBreadcrumb_Lbl(), "Home Breadcrumb Link Is Present As Expected");
        softAssert.assertTrue(createNewTeamPage.isPresent_TeamsBreadcrumbMenu_Lbl(), "Teams Breadcrumb Link Is Present As Expected");
        softAssert.assertTrue(createNewTeamPage.isPresent_CreateTeamsBreadcrumbMenu_Lbl(), "Create Teams Breadcrumb Link Is Present As Expected");
        softAssert.assertTrue(createNewTeamPage.isPresent_Header_Lbl(), "Create Teams Heading Is Present As Expected");
        softAssert.assertEquals(createNewTeamPage.getText_Header_Txt(), "Create Teams", "Header Text Is Matched As Expected");
        softAssert.assertTrue(createNewTeamPage.isPresent_Name_TxtBox(), "Name Text Box Is Present As Expected");
        softAssert.assertTrue(createNewTeamPage.isPresent_Id_TxtBox(), "ID Text Box Is Present As Expected");
        softAssert.assertTrue(createNewTeamPage.isPresent_TeamManager_DropDown(), "Team Manager Text Box Is Present As Expected");
        softAssert.assertTrue(createNewTeamPage.isPresent_Rider_DropDown(), "Rider Text Box Is Present As Expected");
        softAssert.assertTrue(createNewTeamPage.isPresent_Cancel_Btn(), "Cancel Button Is Present As Expected");
        softAssert.assertTrue(createNewTeamPage.isPresent_Create_Btn(), "Create Button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_02, Verify The Functionality Of Breadcrumb Menu For Create Teams Page")
    public void TC_Teams_02_Verify_The_Functionality_Of_Breadcrumb_Menu_For_Create_Teams_Page() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(!createNewTeamPage.isPresent_CreateTeamsBreadcrumbMenu_Lbl(), "Create Teams Breadcrumb Link Is Not Present As Expected");

        teamsPage.click_NewTeam_Btn();
        softAssert.assertTrue(createNewTeamPage.isPresent_Header_Lbl(), "Create Teams Header Is Present As expected");
        softAssert.assertTrue(createNewTeamPage.isPresent_CreateTeamsBreadcrumbMenu_Lbl(), "Create Teams Breadcrumb Link Is Present As Expected");
        softAssert.assertEquals(DriverManager.getDriver().getCurrentUrl(), Constants.Urls.BASE_URL + "teams/add/", "URL is matched as expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_03, Verify The Functionality Of Cancel Button In Create Teams Page")
    public void TC_Teams_03_Verify_The_Functionality_Of_Cancel_Button_In_Create_Teams_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();

        teamsPage.click_NewTeam_Btn();
        String teamName = teamsPage.createNewTeam().get("teamName");
        teamsPage.fillWithClear_Search_Txt(teamName);
        HashMap<String, String> expectedTeamTableDetails = new HashMap<>(teamsPage.getData_TableFirstData_List());

        teamsPage.click_NewTeam_Btn();
        createNewTeamPage.click_Cancel_Btn();
        HashMap<String, String> actualTeamTableDetails = new HashMap<>(teamsPage.getData_TableFirstData_List());

        softAssert.assertEquals(expectedTeamTableDetails.get("teamId"), actualTeamTableDetails.get("teamId"), "Team Id Is Not Changed As Expected");
        softAssert.assertEquals(expectedTeamTableDetails.get("teamName"), actualTeamTableDetails.get("teamName"), "Team Name Is Not Changed As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_04, Verify The Validation Functionality For Without Filling Mandatory Fields")
    public void TC_Teams_04_Verify_The_Validation_Functionality_For_Without_Filling_Mandatory_Fields() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Teams Header Is Present As Expected");

        teamsPage.click_NewTeam_Btn();
        softAssert.assertTrue(createNewTeamPage.isPresent_Header_Lbl(), "Create Teams Header Is Present As expected");

        createNewTeamPage.fillWithClear_TeamID_TxtBox("");
        createNewTeamPage.click_Create_Btn();
        softAssert.assertEquals(createNewTeamPage.get_NameValidation_Txt(), "Required", "Name Validation Message Is Matched As Expected");
        softAssert.assertEquals(createNewTeamPage.get_IDValidation_Txt(), "Required", "Name Validation Message Is Matched As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_05, Verify The Validation Functionality For First Name In Create Teams Page For Minimum Character")
    public void TC_Teams_05_Verify_The_Validation_Functionality_For_Name_In_Create_Teams_Page_For_Minimum_Character() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Teams Header Is Present As Expected");

        teamsPage.click_NewTeam_Btn();
        softAssert.assertTrue(createNewTeamPage.isPresent_Header_Lbl(), "Create Teams Header Is Present As expected");

        createNewTeamPage.click_Create_Btn();
        String[] dataForMinimum = {"a", "1", "@"};
        for (String value : dataForMinimum) {
            createNewTeamPage.fillWithClear_TeamName_TxtBox(value);
            softAssert.assertEquals(createNewTeamPage.get_NameValidation_Txt(), "Should be minimum 3", "Name Validation Message Is Matched As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_06, Verify The Validation Functionality For Name In Create Teams Page For Maximum Character")
    public void TC_Teams_06_Verify_The_Validation_Functionality_For_Name_In_Create_Teams_Page_For_Maximum_Character() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Teams Header Is Present As Expected");

        teamsPage.click_NewTeam_Btn();
        softAssert.assertTrue(createNewTeamPage.isPresent_Header_Lbl(), "Create Teams Header Is Present As expected");

        createNewTeamPage.click_Create_Btn();
        String[] dataForMaximum = {Utils.generateRandomName(129, 130), String.valueOf(sampleData.number().digits(130))};
        for (String value : dataForMaximum) {
            createNewTeamPage.fillWithClear_TeamName_TxtBox(value);
            softAssert.assertEquals(createNewTeamPage.get_NameValidation_Txt(), "Can be at max 128", "Name Validation Message Is Matched As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_07, Verify The Validation Functionality For Name In Create Teams Page other than Alphabet")
    public void TC_Teams_07_Verify_The_Validation_Functionality_For_Name_In_Create_Teams_Page_Other_Than_Alphabet() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Teams Header Is Present As Expected");

        teamsPage.click_NewTeam_Btn();
        softAssert.assertTrue(createNewTeamPage.isPresent_Header_Lbl(), "Create Teams Header Is Present As expected");

        createNewTeamPage.click_Create_Btn();
        String[] dataForSpecialCharacters = {"@@@@@", "aa112@", "aa!@$"};
        for (String value : dataForSpecialCharacters) {
            createNewTeamPage.fillWithClear_TeamName_TxtBox(value);
            softAssert.assertEquals(createNewTeamPage.get_NameValidation_Txt(), "Not correct format", "Name Validation Message Is Matched As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_08, Verify The Validation Functionality For First Name In Create Teams Page For Minimum Character")
    public void TC_Teams_08_Verify_The_Validation_Functionality_For_Id_In_Create_Teams_Page_For_Minimum_Character() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Teams Header Is Present As Expected");

        teamsPage.click_NewTeam_Btn();
        softAssert.assertTrue(createNewTeamPage.isPresent_Header_Lbl(), "Create Teams Header Is Present As expected");

        createNewTeamPage.click_Create_Btn();
        String[] dataForMinimum = {"a", "1", "@"};
        for (String value : dataForMinimum) {
            createNewTeamPage.fillWithClear_TeamID_TxtBox(value);
            softAssert.assertEquals(createNewTeamPage.get_IDValidation_Txt(), "Should be minimum 3", "Name Validation Message Is Matched As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_09, Verify The Validation Functionality For Id In Create Teams Page For Maximum Character")
    public void TC_Teams_09_Verify_The_Validation_Functionality_For_Id_In_Create_Teams_Page_For_Maximum_Character() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Teams Header Is Present As Expected");

        teamsPage.click_NewTeam_Btn();
        softAssert.assertTrue(createNewTeamPage.isPresent_Header_Lbl(), "Create Teams Header Is Present As expected");

        createNewTeamPage.click_Create_Btn();
        String[] dataForMaximum = {Utils.generateRandomName(129, 130), String.valueOf(sampleData.number().digits(130))};
        for (String value : dataForMaximum) {
            createNewTeamPage.fillWithClear_TeamID_TxtBox(value);
            softAssert.assertEquals(createNewTeamPage.get_IDValidation_Txt(), "Can be at max 128", "Id Validation Message Is Matched As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_10, Verify The Validation Functionality For Id In Create Teams Page other than Alphabet")
    public void TC_Teams_10_Verify_The_Validation_Functionality_For_Id_In_Create_Teams_Page_Other_Than_Alphabet() {
        commonActions.coverJourneyTillTeams();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(teamsPage.isPresent_Header_Lbl(), "Teams Header Is Present As Expected");

        teamsPage.click_NewTeam_Btn();
        softAssert.assertTrue(createNewTeamPage.isPresent_Header_Lbl(), "Create Teams Header Is Present As expected");

        createNewTeamPage.click_Create_Btn();
        String[] dataForSpecialCharacters = {"@@@@@", "aa112@", "aa !@$"};
        for (String value : dataForSpecialCharacters) {
            createNewTeamPage.fillWithClear_TeamID_TxtBox(value);
            softAssert.assertEquals(createNewTeamPage.get_IDValidation_Txt(), "No spaces or special characters allowed", "Name Validation Message Is Matched As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_013, Verify The Functionality Of Create Button In Create Teams Page")
    public void TC_Teams_013_Verify_The_Functionality_Of_Create_Button_In_Create_Teams_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();

        teamsPage.click_NewTeam_Btn();
        String teamName = teamsPage.createNewTeam().get("teamName");
        teamsPage.fillWithClear_Search_Txt(teamName);
        softAssert.assertTrue(commonActions.isPresent_TableData_Lbl("TEAM NAME"), "Team Name Data In The Table Is Present As Expected");
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("TEAM NAME"), teamName, "Team Name Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_014, Verify The Functionality Of Create Team With Duplicate Team Name")
    public void TC_Teams_014_Verify_The_Functionality_Of_Create_Team_With_Duplicate_Team_Name() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();
        String teamName = commonActions.getText_TableData_Lbl("TEAM NAME");
        teamsPage.click_NewTeam_Btn();
        createNewTeamPage.fillWithClear_TeamName_TxtBox(teamName);
        createNewTeamPage.click_Create_Btn();

        teamsPage.fillWithClear_Search_Txt(teamName);
        softAssert.assertTrue(commonActions.isPresent_TableData_Lbl("TEAM NAME"), "Team Name Data In The Table Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_015, Verify The Functionality Of Create Team With Duplicate Team Name")
    public void TC_Teams_015_Verify_The_Functionality_Of_Create_Team_With_Duplicate_Team_Name() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();
        String teamId = commonActions.getText_TableData_Lbl("TEAM ID");

        teamsPage.click_NewTeam_Btn();
        createNewTeamPage.fillWithClear_TeamName_TxtBox(Utils.generateRandomName(129,130));
        createNewTeamPage.fillWithClear_TeamName_TxtBox(teamId);
        createNewTeamPage.click_Create_Btn();

        teamsPage.fill_EditColumnsSearch_Txt(teamId);
        softAssert.assertTrue(commonActions.isPresent_TableData_Lbl("TEAM ID"), "Team Id Data In The Table Is Present As Expected");
        softAssert.assertEquals(teamsPage.get_size(), 1, "One Record Is As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.CREATE_NEW_TEAM}, description = "TC_012, Verify The Functionality Of Create Team With Duplicate Team Name")
    public void TC_Teams_012_Verify_The_Functionality_Of_Rider_DropDown_Create_Teams_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillTeams();
        teamsPage.click_NewTeam_Btn();
        softAssert.assertTrue(createNewTeamPage.isPresent_Header_lbl(),"Create Teams Header Is Present As Expected");
        softAssert.assertTrue(createNewTeamPage.isPresent_Rider_DropDown(),"Rider DropDown Is Present As Expected");
        createNewTeamPage.fillWithClear_Rider_TxtBox("Arpit");
        

    }
}