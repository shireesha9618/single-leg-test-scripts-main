package testsuite.resources;

import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.RiderEditPage;
import pageobjects.RidersPage;


public class TestSuite_RiderEditPage extends BaseTestClass {
    RiderEditPage riderEditPage = RiderEditPage.getInstance();
    RidersPage ridersPage = RidersPage.getInstance();
    CommonActions commonActions = CommonActions.getInstance();
    Faker sampleData = new Faker();

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.EDIT_RIDER_PAGE}, description = "TC_016, Verify The Functionality Of Edit Button In Riders List Page")
    public void TC_RiderEditPage_16_Verify_The_Functionality_Of_Edit_Button_In_Riders_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        ridersPage.click_Edit_Btn(0);
        softAssert.assertTrue(riderEditPage.isPresent_EditRiderBreadcrumb_Link(), "Edit Rider Breadcrumb Link is Present as Expected");
        softAssert.assertTrue(riderEditPage.isPresent_EditRiderHeader_Lbl(), "Edit Rider Header is Present as Expected");
        softAssert.assertTrue(riderEditPage.getText_FirstName_TxtBox() != null, "Validate First Name TextBox is Not Null");
        softAssert.assertTrue(riderEditPage.getText_LastName_TxtBox() != null, "Validate Last Name TextBox is Not Null");
        softAssert.assertTrue(riderEditPage.getText_PhoneNumber_TxtBox() != null, "Validate Phone Number TextBox is Not Null");
        softAssert.assertTrue(riderEditPage.getText_Teams_TxtBox() != null, "Validate Teams TextBox is Not Null");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.EDIT_RIDER_PAGE}, description = "TC_017, Verify The UI Of Edit Button In Riders List Page")
    public void TC_RiderEditPage_17_Verify_The_UI_Of_Edit_Button_In_Riders_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverUserJourneyTillRiders();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        ridersPage.click_Edit_Btn(0);
        softAssert.assertTrue(riderEditPage.isPresent_EditRiderBreadcrumb_Link(), "Edit Rider Breadcrumb Link is Present as Expected");
        softAssert.assertTrue(riderEditPage.isPresent_EditRiderHeader_Lbl(), "Edit Rider Header is Present as expected");
        softAssert.assertTrue(riderEditPage.isPresent_FirstName_Lbl(), "First Name label is present as expected");
        softAssert.assertTrue(riderEditPage.isPresent_LastName_Lbl(), "Last Name label is Present as expected");
        softAssert.assertTrue(riderEditPage.isPresent_PhoneNumber_Lbl(), "Phone Number is present as expected ");
        softAssert.assertTrue(riderEditPage.isPresent_Teams_Lbl(), "Teams Label is present as expected");
        softAssert.assertTrue(riderEditPage.isPresent_Cancel_Btn(), "Cancel Button is Present As Expected");
        softAssert.assertTrue(riderEditPage.isPresent_Save_Btn(), "Save Button is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.EDIT_RIDER_PAGE}, description = "TC_018, Verify The Functionality Of Cancel Button In Edit Rider Page")
    public void TC_RiderEditPage_018_Verify_The_Functionality_Of_Cancel_Button_In_Edit_Rider_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        String updateFirstName = sampleData.name().firstName();
        String updateLastName = sampleData.name().lastName();
        commonActions.coverUserJourneyTillRiders();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        ridersPage.click_Edit_Btn(0);
        softAssert.assertTrue(riderEditPage.isPresent_EditRiderHeader_Lbl(), "Edit Rider Header is Present as expected");
        softAssert.assertEquals(riderEditPage.getText_EditRiderHeader_Txt(), "Edit Rider", "Header is matched as expected");
        softAssert.assertTrue(riderEditPage.isPresent_EditRiderHeader_Lbl(), "Edit Rider Header is Present as expected");
        String beforeEditFirstName = riderEditPage.getText_FirstName_TxtBox();
        String beforeEditLastName = riderEditPage.getText_LastName_TxtBox();
        riderEditPage.fill_FirstName_TxtBox(updateFirstName);
        riderEditPage.fill_LastName_TxtBox(updateLastName);
        riderEditPage.click_Cancel_Btn();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Check Visibility of header");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Check Text Visibility Of Heading");
        ridersPage.click_Edit_Btn(0);
        String afterEditFirstNameLbl = riderEditPage.getText_FirstName_TxtBox();
        String afterEditLastNameLbl = riderEditPage.getText_LastName_TxtBox();
        softAssert.assertTrue(beforeEditFirstName.equals(afterEditFirstNameLbl), "First Name is Matched as Expected");
        softAssert.assertTrue(beforeEditLastName.equals(afterEditLastNameLbl), "Last Name is Matched as Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.EDIT_RIDER_PAGE}, description = "TC_019, Verify The Functionality Of Save Button In Edit Rider Page")
    public void TC_RiderEditPage_019_Verify_The_Functionality_Of_Save_Button_In_Edit_Rider_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        String updateFirstName = sampleData.name().firstName();
        String updateLastName = sampleData.name().lastName();
        commonActions.coverUserJourneyTillRiders();
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Check Visibility Of Heading");
        ridersPage.click_Edit_Btn(0);
        softAssert.assertTrue(riderEditPage.isPresent_EditRiderHeader_Lbl(), "Edit Rider Header is Present as expected");
        softAssert.assertEquals(riderEditPage.getText_EditRiderHeader_Txt(), "Edit Rider", "Header is matched as expected");
        softAssert.assertTrue(riderEditPage.isPresent_EditRiderHeader_Lbl(), "Edit Rider Header is Present as expected");
        String beforeEditFirstName = riderEditPage.getText_FirstName_TxtBox();
        String beforeEditLastName = riderEditPage.getText_LastName_TxtBox();
        riderEditPage.fill_FirstName_TxtBox(updateFirstName);
        riderEditPage.fill_LastName_TxtBox(updateLastName);
        riderEditPage.click_Save_Btn();
        softAssert.assertTrue(riderEditPage.isPresent_UpdatedSuccessfully_Txt(), "Updated Successfully message is Present as Expeccted");
        softAssert.assertTrue(ridersPage.isPresent_Header_Lbl(), "Check Visibility of header");
        softAssert.assertEquals(ridersPage.getText_RidersHeader_Lbl(), "Riders", "Check Text Visibility Of Heading");
        ridersPage.click_Edit_Btn(0);
        String afterEditFirstName = riderEditPage.getText_FirstName_TxtBox();
        String afterEditLastName = riderEditPage.getText_LastName_TxtBox();
        softAssert.assertTrue(!beforeEditFirstName.equals(afterEditFirstName), "Actual First Name is Not Matched with Updated First Name as Expected");
        softAssert.assertTrue(!beforeEditLastName.equals(afterEditLastName), "Actual Last Name is Not Matched with Updated Last Name as Expected");
        softAssert.assertAll();
    }
}