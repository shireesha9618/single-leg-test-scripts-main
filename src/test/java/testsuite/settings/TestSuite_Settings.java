package testsuite.settings;

import base.BaseTestClass;
import constants.Constants;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import org.testng.annotations.Test;
import pageobjects.*;
import pageobjects.settings.GeneralPage;
import pageobjects.settings.SettingsPage;
import pageobjects.settings.UserPage;
import pageobjects.settings.WorkflowPage;

public class TestSuite_Settings extends BaseTestClass {
    CommonActions commonActions = CommonActions.getInstance();
    SettingsPage settingsPage = SettingsPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    String settingPageUrl = Constants.BASE_URL + "settings/";

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.SETTING, TestGroup.BVT},
            description = "TC_001, Verify The UI Of Settings Page")
    public void TC_Facility_001_Verify_The_UI_Of_Settings_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillSettings();
        softAssert.assertTrue(settingsPage.isPresent_SettingPageHeader_Lbl(), "Setting Page Header LabelIs Present As Expected");
        softAssert.assertEquals(settingsPage.getText_SettingPageHeader_Lbl(), "Settings", "Setting Page Header Label Is Matched As Expected");
        softAssert.assertTrue(settingsPage.isPresent_SettingBreadCrumb_Link(), "Setting BreadCrumb Link Is Preset As Expected");
        softAssert.assertTrue(settingsPage.isPresent_General_Link(), "General Link Is Present As Expected");
        softAssert.assertTrue(settingsPage.isPresent_Workflow_Link(), "Workflow Link Is Present As Expected");
        softAssert.assertTrue(settingsPage.isPresent_Users_Link(), "Users Link Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.SETTING, TestGroup.BVT},
            description = "TC_002, Verify The Functionality Of Breadcrumb Menu For Settings Page")
    public void TC_Facility_002_Verify_The_Functionality_Of_Breadcrumb_Menu_For_Settings_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillSettings();
        String expectedSettingHeader = settingsPage.getText_SettingPageHeader_Lbl();
        settingsPage.click_General_Link();
        softAssert.assertTrue(GeneralPage.getInstance().isPresent_GeneralHeader_Lbl(), "General Header Label Is Present As Expected");
        settingsPage.click_settingBreadCrumb_Link();
        softAssert.assertEquals(settingsPage.getText_SettingPageHeader_Lbl(), expectedSettingHeader, "Settings Header Label Is Matched As Expected");
        softAssert.assertEquals(commonActions.getCurrentPageUrl(), settingPageUrl, "Settings Page URL Is Matched With Expected URl As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.SETTING, TestGroup.BVT},
            description = "TC_003, Verify The Functionality Of General Sub Menu Setting Option")
    public void TC_Facility_003_Verify_The_Functionality_Of_General_Sub_Menu_Setting_Option() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillSettings();
        String expectedGeneralPageURL = settingPageUrl + "generalSettings/systemPreferences/";
        settingsPage.click_General_Link();
        softAssert.assertTrue(GeneralPage.getInstance().isPresent_GeneralHeader_Lbl(), "General Header Label Is Present As Expected");
        softAssert.assertEquals(GeneralPage.getInstance().getText_GeneralHeader_Lbl(), "General", "General Header Label Is Matched As Expected");
        softAssert.assertEquals(commonActions.getCurrentPageUrl(), expectedGeneralPageURL, "General Page URL Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.SETTING, TestGroup.BVT},
            description = "TC_005, Verify The Functionality Of Workflow Sub Menu Setting Option")
    public void TC_Facility_005_Verify_The_Functionality_Of_Workflow_Sub_Menu_Setting_Option() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillSettings();
        String expectedGeneralPageURL = settingPageUrl + "workflow/";
        settingsPage.click_Workflow_Link();
        softAssert.assertTrue(WorkflowPage.getInstance().isPresent_WorkflowHeader_Lbl(), "Workflow Header Label Is Present As Expected");
        softAssert.assertEquals(WorkflowPage.getInstance().getText_WorkflowHeader_Lbl(), "Workflow", "Workflow Header Label Is Matched As Expected");
        softAssert.assertEquals(commonActions.getCurrentPageUrl(), expectedGeneralPageURL, "Workflow Page URL Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.SETTING, TestGroup.BVT},
            description = "TC_006, Verify The Functionality Of Users Sub Menu Setting Option")
    public void TC_Facility_006_Verify_The_Functionality_Of_Users_Sub_Menu_Setting_Option() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillSettings();
        String expectedGeneralPageURL = settingPageUrl + "users/list/?ptpType=workflow";
        settingsPage.click_Users_Link();
        softAssert.assertTrue(UserPage.getInstance().isPresent_UserHeader_Lbl(), "Users Header Label Is Present As Expected");
        softAssert.assertEquals(UserPage.getInstance().getText_UserHeader_Lbl(), "Users", "Users Header Label Is Matched As Expected");
        softAssert.assertEquals(commonActions.getCurrentPageUrl(), expectedGeneralPageURL, "Users Page URL Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.SETTING, TestGroup.BVT},
            description = "TC_007, Verify The Functionality Dock And Undock Of Left Panel")
    public void TC_Facility_007_Verify_The_Functionality_Dock_And_Undock_Of_Left_Panel() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillSettings();

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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.SETTING, TestGroup.BVT},
            description = "TC_008, Verify The Functionality Of Open Menu")
    public void TC_Facility_008_Verify_The_Functionality_Of_Open_Menu() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillSettings();

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

        homePage.click_OpenMenuSettings_Btn();
        softAssert.assertEquals(settingsPage.getText_SettingPageHeader_Lbl(), "Settings", "Settings Header Label Is Matched As Expected");
        softAssert.assertEquals(commonActions.getCurrentPageUrl(), settingPageUrl, "Settings Page URL Is Matched With Expected URl As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.SETTING, TestGroup.BVT},
            description = "TC_009, Verify The Functionality Of Cross Button(X) Of Open Menu")
    public void TC_Facility_009_Verify_The_Functionality_Of_Cross_Button_Of_Open_Menu() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillSettings();

        homePage.click_OpenMenu_Btn();
        homePage.click_OpenMenuSettings_Btn();
        softAssert.assertEquals(settingsPage.getText_SettingPageHeader_Lbl(), "Settings", "Settings Page Is Opened As Expected");

        homePage.click_OpenMenu_Btn();
        homePage.click_OpenMenuCross_Btn();
        softAssert.assertEquals(settingsPage.getText_SettingPageHeader_Lbl(), "Settings", "Settings Header Label Is Matched, Page Didn't Changed As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.SETTING, TestGroup.BVT},
            description = "TC_010, Verify The Functionality Of Workflow Button")
    public void TC_Facility_010_Verify_The_Functionality_Of_Workflow_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillSettings();

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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.SETTING, TestGroup.BVT},
            description = "TC_011, Verify The Functionality Of Settings Button Of Workflow")
    public void TC_Facility_011_Verify_The_Functionality_Of_Settings_Button_Of_Workflow() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillSettings();
        String expectedSettingsPageHeader = settingsPage.getText_SettingPageHeader_Lbl();
        homePage.click_WorkFlowOs1_Link();
        homePage.click_WorkFlowSettings_Btn();
        softAssert.assertEquals(settingsPage.getText_SettingPageHeader_Lbl(), expectedSettingsPageHeader, "Facility Header Label Is Matched As Expected");
        softAssert.assertEquals(commonActions.getCurrentPageUrl(), settingPageUrl, "Settings Page URL Is Matched With Expected URl As Expected");
        softAssert.assertAll();
    }
}
