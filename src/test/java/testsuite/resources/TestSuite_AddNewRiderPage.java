package testsuite.resources;

import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.Constants;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.actions.ActionHelper;
import framework.frontend.managers.DriverManager;
import org.testng.annotations.Test;
import pageobjects.AddNewRiderPage;
import pageobjects.CommonActions;
import pageobjects.RidersPage;

public class TestSuite_AddNewRiderPage extends BaseTestClass {
    RidersPage ridersPage = RidersPage.getInstance();
    AddNewRiderPage addNewRiderPage = AddNewRiderPage.getInstance();
    CommonActions commonActions = CommonActions.getInstance();
    Faker sampleData = new Faker();


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_045, Verify The UI Of New Rider Button")
    public void TC_Riders_045_Verify_The_UI_Of_New_Rider_Button() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ridersPage.click_NewRider_Btn();
        softAssert.assertTrue(addNewRiderPage.isPresent_HomeBreadcrumb_Lbl(), "Home Breadcrumb Link Is Present As Expected");
        softAssert.assertTrue(addNewRiderPage.isPresent_AddNewRiderBreadcrumbMenu_Lbl(), "Add New Rider Breadcrumb Link Is Present As Expected");
        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Heading Is Present As Expected");
        softAssert.assertEquals(addNewRiderPage.getText_Header_Txt(), "Add New Rider", "Header Text Is Matched As Expected");
        softAssert.assertTrue(addNewRiderPage.isPresent_FirstName_TxtBox(), "First Name Text Box Is Present As Expected");
        softAssert.assertTrue(addNewRiderPage.isPresent_LastName_TxtBox(), "Last Name Text Box Is Present As Expected");
        softAssert.assertTrue(addNewRiderPage.isPresent_PhoneNumber_TxtBox(), "Phone Number Text Box Is Present As Expected");
        softAssert.assertTrue(addNewRiderPage.isPresent_Teams_TxtBox(), "Teams Text Box Is Present As Expected");
        softAssert.assertTrue(addNewRiderPage.isPresent_UploadPhoto_Btn(), "UploadPhoto Button Is Present As Expected");
        softAssert.assertTrue(addNewRiderPage.isPresent_Cancel_Btn(), "Cancel Button Is Present As Expected");
        softAssert.assertTrue(addNewRiderPage.isPresent_AddRider_Btn(), "Add New User Button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_46, Verify The Functionality Of Breadcrumb Menu For Add New Rider Page")
    public void TC_Riders_046_Verify_The_Functionality_Of_Breadcrumb_Menu_For_Add_New_Rider_Page() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(!addNewRiderPage.isPresent_AddNewRiderBreadcrumbMenu_Lbl(), "Add New Rider link in breadcrumb is not present as expected");
        ridersPage.click_NewRider_Btn();
        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Header Is Present As expected");
        softAssert.assertTrue(addNewRiderPage.isPresent_AddNewRiderBreadcrumbMenu_Lbl(), "Add New User link in breadcrumb is present as expected");
        softAssert.assertEquals(DriverManager.getDriver().getCurrentUrl(), Constants.Urls.BASE_URL + "riders/add/", "URL is matched as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_047, Verify The Validation Functionality For First Name In Add New Rider Page For Empty Field")
    public void TC_Riders_047_Verify_The_Validation_Functionality_For_First_Name_In_Add_New_Rider_Page_For_Empty_Field() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Header Is Present As Expected");
        ridersPage.click_NewRider_Btn();
        addNewRiderPage.click_AddRider_Btn();
        softAssert.assertEquals(addNewRiderPage.get_FirstNameValidation_Txt(), "Required", "First Name Validation Message Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_048, Verify The Validation Functionality For First Name In Add New Rider Page For Minimum Character")
    public void TC_Riders_048_Verify_The_Validation_Functionality_For_First_Name_In_Add_New_Rider_Page_For_Minimum_Character() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Header Is Present As Expected");
        ridersPage.click_NewRider_Btn();
        String[] dataForMinimum = {"a", "1", "@"};
        for (String value : dataForMinimum) {
            addNewRiderPage.set_RiderFirstName_TxtBox(value);
            softAssert.assertEquals(addNewRiderPage.get_FirstNameValidation_Txt(), "Only A-Z, a-z, min: 2, max: 36", "First Name Validation Message Is Matched As Expected");
            softAssert.assertAll();
        }
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_049, Verify The Validation Functionality For First Name In Add New Rider Page For Maximum Character")
    public void TC_Riders_049_Verify_The_Validation_Functionality_For_First_Name_In_Add_New_Rider_Page_For_Maximum_Character() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Header Is Present As Expected");
        ridersPage.click_NewRider_Btn();
        String[] dataForMaximum = {ActionHelper.generateRandomName(37, 40), String.valueOf(sampleData.number().digits(37)), "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"};
        for (String value : dataForMaximum) {
            addNewRiderPage.set_RiderFirstName_TxtBox(value);
            softAssert.assertEquals(addNewRiderPage.get_FirstNameValidation_Txt(), "Only A-Z, a-z, min: 2, max: 36", "First Name Validation Message Is Matched As Expected");
            softAssert.assertAll();
        }
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_050, Verify The Validation Functionality For First Name In Add New Rider Page other than Alphabet")
    public void TC_Riders_050_Verify_The_Validation_Functionality_For_First_Name_In_Add_New_Rider_Page_Other_Than_Alphabet() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Header Is Present As Expected");
        ridersPage.click_NewRider_Btn();
        String[] dataForSpecialCharacters = {"@@@@@", "aa112", "aa!@$", "11223"};
        for (String value : dataForSpecialCharacters) {
            addNewRiderPage.set_RiderFirstName_TxtBox(value);
            softAssert.assertEquals(addNewRiderPage.get_FirstNameValidation_Txt(), "Only A-Z, a-z, min: 2, max: 36", "First Name Validation Message Is Matched As Expected");
            softAssert.assertAll();
        }
    }
}