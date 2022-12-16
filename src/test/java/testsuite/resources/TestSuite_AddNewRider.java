package testsuite.resources;

import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.Constants;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.managers.DriverManager;
import org.testng.annotations.Test;
import pageobjects.AddNewRiderPage;
import pageobjects.CommonActions;
import pageobjects.RidersPage;
import utils.Utils;


public class TestSuite_AddNewRider extends BaseTestClass {
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
            addNewRiderPage.fillWithClear_RiderFirstName_TxtBox(value);
            softAssert.assertEquals(addNewRiderPage.get_FirstNameValidation_Txt(), "Not correct format", "First Name Validation Message Is Matched As Expected");
        }
        softAssert.assertAll();
    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_049, Verify The Validation Functionality For First Name In Add New Rider Page For Maximum Character")
    public void TC_Riders_049_Verify_The_Validation_Functionality_For_First_Name_In_Add_New_Rider_Page_For_Maximum_Character() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Header Is Present As Expected");
        ridersPage.click_NewRider_Btn();

        String[] dataForMaximum = {Utils.generateRandomName(37, 40), String.valueOf(sampleData.number().digits(37)), "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"};
        for (String value : dataForMaximum) {
            addNewRiderPage.fillWithClear_RiderFirstName_TxtBox(value);
            softAssert.assertEquals(addNewRiderPage.get_FirstNameValidation_Txt(), "Not correct format", "First Name Validation Message Is Matched As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_050, Verify The Validation Functionality For First Name In Add New Rider Page other than Alphabet")
    public void TC_Riders_050_Verify_The_Validation_Functionality_For_First_Name_In_Add_New_Rider_Page_Other_Than_Alphabet() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Header Is Present As Expected");

        ridersPage.click_NewRider_Btn();
        String[] dataForSpecialCharacters = {"@@@@@", "aa112", "aa!@$", "11223"};
        for (String value : dataForSpecialCharacters) {
            addNewRiderPage.fillWithClear_RiderFirstName_TxtBox(value);
            softAssert.assertEquals(addNewRiderPage.get_FirstNameValidation_Txt(), "Not correct format", "First Name Validation Message Is Matched As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_051, Verify The Validation Functionality For Last Name In Add New Rider Page For Empty Field")
    public void TC_Riders_051_Verify_The_Validation_Functionality_For_Last_Name_In_Add_New_Rider_Page_For_Empty_Field() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");

        ridersPage.click_NewRider_Btn();
        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Header Is Present As Expected");

        addNewRiderPage.click_AddRider_Btn();
        softAssert.assertEquals(addNewRiderPage.get_LastNameValidation_Txt(), "Required", "Last Name Validation Message Is Matched As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_052, Verify The Validation Functionality For Last Name In Add New Rider Page For Minimum Character")
    public void TC_Riders_052_Verify_The_Validation_Functionality_For_Last_Name_In_Add_New_Rider_Page_For_Minimum_Character() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");
        ridersPage.click_NewRider_Btn();

        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Header Is Present As Expected");
        String[] dataForMinimum = {"a", "1", "@"};
        for (String value : dataForMinimum) {
            addNewRiderPage.fillWithClear_RiderLastName_TxtBox(value);
            softAssert.assertEquals(addNewRiderPage.get_LastNameValidation_Txt(), "Not correct format", "Last Name Validation Message Is Matched As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_053, Verify The Validation Functionality For Last Name In Add New Rider Page For Maximum Character")
    public void TC_Riders_053_Verify_The_Validation_Functionality_For_Last_Name_In_Add_New_Rider_Page_For_Maximum_Character() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");

        ridersPage.click_NewRider_Btn();
        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Header Is Present As Expected");
        String[] dataForMaximum = {Utils.generateRandomName(37, 40), String.valueOf(sampleData.number().digits(37)), "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"};

        for (String value : dataForMaximum) {
            addNewRiderPage.fillWithClear_RiderLastName_TxtBox(value);
            softAssert.assertEquals(addNewRiderPage.get_LastNameValidation_Txt(), "Not correct format", "Last Name Validation Message Is Matched As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_054, Verify The Validation Functionality For Last Name In Add New Rider Page other than Alphabet")
    public void TC_Riders_054_Verify_The_Validation_Functionality_For_Last_Name_In_Add_New_Rider_Page_Other_Than_Alphabet() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");

        ridersPage.click_NewRider_Btn();
        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Header Is Present As Expected");

        String[] dataForSpecialCharacters = {"@@@@@", "aa112", "aa!@$", "11223"};
        for (String value : dataForSpecialCharacters) {
            addNewRiderPage.fillWithClear_RiderLastName_TxtBox(value);
            softAssert.assertEquals(addNewRiderPage.get_LastNameValidation_Txt(), "Not correct format", "Last Name Validation Message Is Matched As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_055, Verify The Validation Functionality For Phone Number In Add New User Page For Empty Field")
    public void TC_Riders_055_Verify_The_Validation_Functionality_For_Phone_Number_In_Add_New_User_Page_For_Empty_Field() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");

        ridersPage.click_NewRider_Btn();
        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Header Is Present As Expected");

        addNewRiderPage.click_AddRider_Btn();
        softAssert.assertEquals(addNewRiderPage.get_PhoneNumberValidation_Txt(), "Required", "Phone Number Validation Message Is Matched as expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_056, Verify The Validation Functionality For Phone Number In Add New Rider Page For Minimum Character")
    public void TC_Riders_056_Verify_The_Validation_Functionality_For_Phone_Number_In_Add_New_Rider_Page_For_Minimum_Character() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();

        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");
        ridersPage.click_NewRider_Btn();

        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Header Is Present As Expected");
        String[] dataForMinimum = {"1", "a", "@", "1234", "123456789"};
        for (String value : dataForMinimum) {
            addNewRiderPage.fillWithClear_PhoneNumber_TxtBox(value);
            softAssert.assertEquals(addNewRiderPage.get_PhoneNumberValidation_Txt(), "Not correct format", "Phone Number Validation Message Is Matched as expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_057, Verify The Validation Functionality For Phone Number In Add New Rider Page For Maximum Character")
    public void TC_Riders_057_Verify_The_Validation_Functionality_For_Phone_Number_In_Add_New_Rider_Page_For_Maximum_Character() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");

        ridersPage.click_NewRider_Btn();
        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Header Is Present As Expected");
        String[] dataForMaximum = {Utils.generateRandomName(37, 40), String.valueOf(sampleData.number().digits(37)), "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"};
        for (String value : dataForMaximum) {
            addNewRiderPage.fillWithClear_PhoneNumber_TxtBox(value);
            softAssert.assertEquals(addNewRiderPage.get_PhoneNumberValidation_Txt(), "Not correct format", "Phone Number Validation Message Is Matched as expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_058, Verify The Validation Functionality For Phone Number In Add New Rider Page For Other Than Alphabet")
    public void TC_Riders_058_Verify_The_Validation_Functionality_For_Phone_Number_In_Add_New_Rider_Page_For_Other_Than_Alphabet() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();

        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");
        ridersPage.click_NewRider_Btn();
        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Header Is Present As Expected");

        String[] dataForSpecialCharacters = {"@@@@@", "aa112", "aa!@$", "1122@"};
        for (String value : dataForSpecialCharacters) {
            addNewRiderPage.fillWithClear_PhoneNumber_TxtBox(value);
            softAssert.assertEquals(addNewRiderPage.get_PhoneNumberValidation_Txt(),"Not correct format","Phone Number Validation Message Is Matched as expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_059, Verify The Validation Functionality For Teams In Add New User Page For Empty Field")
    public void TC_Riders_059_Verify_The_Validation_Functionality_For_Teams_In_Add_New_User_Page_For_Empty_Field() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");

        ridersPage.click_NewRider_Btn();

        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Header Is Present As Expected");
        addNewRiderPage.click_AddRider_Btn();

        softAssert.assertEquals(addNewRiderPage.get_TeamsValidation_Txt(), "Please add atleast one", "Teams Validation Message Is Matched as expected");

        softAssert.assertAll();

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_060, Verify The Functionality of Teams Dropdown in Add New Rider Page")
    public void TC_Riders_060_Verify_The_Functionality_Of_Teams_DropDown_In_Add_New_Rider_Page() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");
        ridersPage.click_NewRider_Btn();
        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Header Is Present As Expected");

        addNewRiderPage.select_TeamsDropDown_Btn(Constants.TEAM);
        softAssert.assertEquals(addNewRiderPage.get_TeamsDropDownList_Txt(), "QATeam", "Team Name Is Matched As Expected");

        addNewRiderPage.click_RemoveTeamCross_Btn();
        softAssert.assertTrue(!addNewRiderPage.isPresent_TeamsDropDownList_Txt(), "QATeam Is Not Present As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_071, Verify The Functionality Of Add New Rider Page Without Filling Mandatory Fields")
    public void TC_Riders_071_Verify_The_Functionality_Of_Add_New_Rider_Page_Without_Filling_Mandatory_Fields() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");
        ridersPage.click_NewRider_Btn();
        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Header Is Present As Expected");

        addNewRiderPage.click_AddRider_Btn();
        softAssert.assertEquals(addNewRiderPage.get_FirstNameValidation_Txt(), "Required", "First Name Validation Message Is Matched As Expected");
        softAssert.assertEquals(addNewRiderPage.get_LastNameValidation_Txt(), "Required", "Last Name Validation Message Is Matched As Expected");
        softAssert.assertEquals(addNewRiderPage.get_PhoneNumberValidation_Txt(), "Required", "Phone Number Validation Message Is Matched as expected");
        softAssert.assertEquals(addNewRiderPage.get_TeamsValidation_Txt(), "Please add atleast one", "Teams Validation Message Is Matched as expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_072, Verify The Functionality Of Cancel Button In Add New Rider Page")
    public void TC_Riders_072_Verify_The_Functionality_Of_Cancel_Button_In_Add_New_Rider_Page() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");
        ridersPage.click_NewRider_Btn();
        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Header Is Present As Expected");

        addNewRiderPage.fillWithClear_RiderFirstName_TxtBox(sampleData.name().firstName());
        addNewRiderPage.fillWithClear_RiderLastName_TxtBox(sampleData.name().lastName());
        addNewRiderPage.fillWithClear_PhoneNumber_TxtBox(sampleData.number().digits(10));
        addNewRiderPage.click_Cancel_Btn();
        softAssert.assertTrue(!addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Header Is Not Present As Expected");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Riders Header is Matched As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ADD_NEW_RIDER_PAGE}, description = "TC_073, Verify The Functionality Of Add Rider Button In Add New Rider Page")
    public void TC_Riders_073_Verify_The_Functionality_Of_Add_Rider_Button_In_Add_New_Rider_Page() {
        commonActions.coverUserJourneyTillRiders();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Riders Header Is Present As Expected");
        ridersPage.click_NewRider_Btn();
        softAssert.assertTrue(addNewRiderPage.isPresent_Header_Lbl(), "Add New Rider Header Is Present As Expected");

        addNewRiderPage.fillWithClear_RiderFirstName_TxtBox(sampleData.name().firstName());
        addNewRiderPage.fillWithClear_RiderLastName_TxtBox(sampleData.name().lastName());
        addNewRiderPage.fillWithClear_PhoneNumber_TxtBox(sampleData.number().digits(10));
        addNewRiderPage.select_TeamsDropDown_Btn(Constants.TEAM);
        String riderName = addNewRiderPage.get_FirstName_Txt() + addNewRiderPage.get_LastName_Txt();
        addNewRiderPage.click_AddRider_Btn();
        softAssert.assertEquals(addNewRiderPage.getText_Msg_Lbl(), "Created Successfully", "Message Is Matched As Expected");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Riders Header is Matched As Expected");

        ridersPage.fillWithClear_Search_Txt(riderName);
        softAssert.assertTrue(ridersPage.isPresent_TableDataRiderName_Lbl(), "Rider Is Present As Expected");
        softAssert.assertEquals(ridersPage.getSize_RidersTableRiderName(), 1, "One Record Is As Expected");

        softAssert.assertAll();
    }
}