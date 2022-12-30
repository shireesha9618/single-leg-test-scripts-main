package testsuite.order;

import base.BaseTestClass;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.CreateNewOrderPage;
import pageobjects.HomePage;
import pageobjects.ViewOrderPage;

public class TestSuite_HomeOrders extends BaseTestClass {
    HomePage homePage = HomePage.getInstance();
    CreateNewOrderPage createNewOrderPage = CreateNewOrderPage.getInstance();
    ViewOrderPage viewOrderPage = ViewOrderPage.getInstance();


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.HOME_ORDERS}, description = "TC_04, Verify The Functionality of Open Menu Button")
    public void TC_Orders_04_Verify_The_Functionality_Of_Open_Menu_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillCreateOrder();
        homePage.click_OpenMenu_Btn();
        softAssert.assertTrue(homePage.isPresent_AppsHeader_Lbl(), "Header Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuOrders_Btn(), "Orders Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuDispatch_Btn(), "Dispatch Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuRiders_Btn(), "Riders Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuFacilities_Btn(), "Facilities Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuRouting_Btn(), "Routing Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuTeams_Btn(), "Teams Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuSettings_Btn(), "Settings Open Menu Button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.HOME_ORDERS}, description = "TC_05, Verify The Functionality of Cross Button Of Open Menu")
    public void TC_Orders_05_Verify_The_Functionality_Of_Cross_Button_Of_Open_Menu() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillCreateOrder();
        homePage.click_OpenMenu_Btn();
        softAssert.assertTrue(homePage.isPresent_AppsHeader_Lbl(), "Apps Header Is Present As Expected");
        homePage.click_OpenMenuCross_Btn();
        softAssert.assertTrue(!homePage.isPresent_AppsHeader_Lbl(), "Apps Header Is Not Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.HOME_ORDERS}, description = "TC_06, Verify The Functionality of Create Orders Button Of Open Menu Button")
    public void TC_Orders_06_Verify_The_Functionality_Of_Create_Orders_Button_Of_Open_Menu_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillCreateOrder();
        homePage.click_OpenMenu_Btn();
        softAssert.assertTrue(homePage.isPresent_AppsHeader_Lbl(), "Header Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuOrders_Btn(), "Orders Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuDispatch_Btn(), "Dispatch Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuRiders_Btn(), "Riders Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuFacilities_Btn(), "Facilities Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuRouting_Btn(), "Routing Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuTeams_Btn(), "Teams Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuSettings_Btn(), "Settings Open Menu Button Is Present As Expected");
        homePage.click_OpenMenuCreateOrders_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Create New Order Header Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.HOME_ORDERS}, description = "TC_06, Verify The Functionality of View Orders Button Of Open Menu Button")
    public void TC_Orders_07_Verify_The_Functionality_Of_View_Orders_Button_Of_Open_Menu_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillCreateOrder();
        homePage.click_OpenMenu_Btn();
        softAssert.assertTrue(homePage.isPresent_AppsHeader_Lbl(), "Header Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuOrders_Btn(), "Orders Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuDispatch_Btn(), "Dispatch Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuRiders_Btn(), "Riders Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuFacilities_Btn(), "Facilities Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuRouting_Btn(), "Routing Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuTeams_Btn(), "Teams Open Menu Button Is Present As Expected");
        softAssert.assertTrue(homePage.isPresent_OpenMenuSettings_Btn(), "Settings Open Menu Button Is Present As Expected");
        homePage.click_OpenMenuViewOrders_Btn();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Orders Header Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.HOME_ORDERS}, description = "TC_08, Verify The Functionality of Work Flow Button")
    public void TC_Orders_08_Verify_The_Functionality_Of_Work_Flow_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillCreateOrder();
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.HOME_ORDERS}, description = "TC_09, Verify The Functionality Of Orders Button Of Work Flow")
    public void TC_Orders_09_Verify_The_Functionality_Of_Orders_Button_Of_Work_Flow() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        CommonActions.getInstance().coverJourneyTillCreateOrder();
        homePage.click_DelhiveryLogo_Img();
        softAssert.assertTrue(homePage.isPresent_WorkFlowOrders_Btn(), "Orders Button Is Present As Expected");
        homePage.click_WorkFlowOrders_Btn();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Orders Header Is Present As Expected");
        softAssert.assertAll();
    }
}