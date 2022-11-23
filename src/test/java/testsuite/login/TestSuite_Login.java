package testsuite.login;

import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.Constants;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.actions.ActionHelper;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class TestSuite_Login extends BaseTestClass {
    LoginPage loginPage = LoginPage.getInstance();
    HomePage homePage = HomePage.getInstance();
    CommonActions commonActions = CommonActions.getInstance();
    Faker sampleData = new Faker();

    @Test(groups = {TestGroup.SMOKE, TestGroup.LOGIN}, description = "TC_01, Verify UI Of Login Launch Page")
    public void TC_Login_001_Verify_UI_Of_Login_Launch_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        loginPage.navigateToLoginScreen();
        softAssert.assertTrue(loginPage.isPresent_LoginWithOtp_Lnk(), "Login with OTP Is Present As Expected");
        softAssert.assertTrue(loginPage.isPresent_LoginWithEmail_Lnk(), "Login with Email Is Present As Expected");
        softAssert.assertTrue(loginPage.isPresent_LoginWitGoogle_Lnk(), "Login with Google Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.LOGIN}, description = "TC_02, Verify UI Of Login Using Email")
    public void TC_Login_002_Verify_UI_Of_Login_Using_Email() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        loginPage.click_LoginWithEmail_Lnk();
        softAssert.assertTrue(loginPage.isPresent_UserId_Txt(), "User Id Text Box Is Present");
        softAssert.assertTrue(loginPage.isPresent_SendOTP_Btn(), "Send OTP Button Is Present");
        softAssert.assertEquals(loginPage.getText_PlaceHolder_Txt(), "Enter email", "Email placeholder text is present");
        softAssert.assertTrue(!loginPage.isEnabled_SendOTP_Btn(), "Send OTP button is disabled as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.LOGIN}, description = "TC_003, Verify Functionality Of Email Id Using Valid Data")
    public void TC_Login_003_Verify_The_Functionality_Of_Email_Id_With_Valid_Data() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        loginPage.click_LoginWithEmail_Lnk();
        loginPage.fill_UserId_Txt(Constants.EMAIL_ID);
        softAssert.assertTrue(loginPage.isPresent_UserId_Txt(), "User id text field is present as expected");
        softAssert.assertTrue(loginPage.isEnabled_SendOTP_Btn(), "Send OTP button is Enabled as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.LOGIN}, description = "TC_04, Verify Functionality Of Email Id Using Invalid Data")
    public void TC_Login_004_Verify_The_Functionality_Of_Email_Id_With_Invalid_Data() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        loginPage.click_LoginWithEmail_Lnk();
        loginPage.fill_UserId_Txt("abcd@gmail.c");
        softAssert.assertTrue(!loginPage.isEnabled_SendOTP_Btn(), "Send otp button is disabled as expected");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.LOGIN}, description = "TC_05, Verify The Functionality Of Login With Valid OTP")
    public void TC_Login_005_Verify_the_Functionality_of_Login_with_Valid_OTP() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        loginPage.performLoginWithEmail(Constants.EMAIL_ID, Constants.EMAIL_PASSWORD);
        softAssert.assertTrue(homePage.isPresent_DelhiveryLogo_Img(), "Delhivery Logo is present as expected");
        softAssert.assertTrue(homePage.isPresent_Skip_Btn(), "Skip button is present as expected");
        commonActions.click_Skip_Btn();
        softAssert.assertTrue(homePage.isPresent_UserProfile_Img(),"Menu Button is Present as expected");
        homePage.click_UserProfile_Img();
        softAssert.assertTrue(homePage.isPresent_Logout_Btn(),"Logout Button is Present As Expected");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.LOGIN}, description = "TC_06, Verify The Functionality Of Login With Invalid OTP")
    public void TC_Login_006_Verify_The_Functionality_of_Login_With_Invalid_OTP() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        loginPage.click_LoginWithEmail_Lnk();
        loginPage.fill_UserId_Txt(Constants.EMAIL_ID);
        loginPage.click_SendOTP_Btn();
        loginPage.fill_Otp_Txt(ActionHelper.getRandomNumberString(6));
        loginPage.click_Login_Btn();
        softAssert.assertTrue(loginPage.isPresent_LoginOTPIncorrectErrorMsg_Txt(), "Incorrect OTP msg should be displayed as expected");
        softAssert.assertEquals(loginPage.getText_LoginOTPIncorrectErrorMsg_Txt(),"Incorrect OTP","Error Message is Matched as Expected");
        softAssert.assertTrue(loginPage.isPresent_LoginOTPReEnterErrorMsg_Txt(),"ReEnter OTP message");
        softAssert.assertTrue(loginPage.isPresent_SendOTP_Btn(), "Send otp button should appear as expected");
        softAssert.assertTrue(loginPage.isPresent_LoginResendOTP_Btn(),"ReSend Otp button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.LOGIN}, description = "TC_07, Verify The Functionality Of Resend OTP ")
    public void TC_Login_007_Verify_The_Functionality_Of_Resend_OTP() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        loginPage.click_LoginWithEmail_Lnk();
        loginPage.fill_UserId_Txt(Constants.EMAIL_ID);
        loginPage.click_SendOTP_Btn();
        softAssert.assertTrue(loginPage.isPresent_LoginResendOTP_Btn(), "Resend button is present as expected");
        String otp = loginPage.getOTP(Constants.EMAIL_ID, Constants.EMAIL_PASSWORD);
        softAssert.assertTrue(otp.length() == 6, "Validate 1st OTP is received");
        loginPage.click_LoginResendOTP_Btn();
        String updatedOtp = loginPage.getOTP(Constants.EMAIL_ID, Constants.EMAIL_PASSWORD);
        softAssert.assertTrue(updatedOtp.length() == 6, "Validate 2nd OTP is received");
        softAssert.assertTrue(!otp.equals(updatedOtp), "Validate both OTPs are different");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.LOGIN}, description = "TC_08, Verify the Functionality of Login with not registered user")
    public void TC_Login_008_Verify_the_Functionality_of_Login_with_not_registered_user() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        loginPage.click_LoginWithEmail_Lnk();
        loginPage.fill_UserId_Txt(sampleData.internet().emailAddress());
        loginPage.click_SendOTP_Btn();
        softAssert.assertTrue(loginPage.isPresent_LoginUserErrorMsg_Txt(), "User not registered message is displayed as expected");
        softAssert.assertEquals(loginPage.getText_LoginUserErrorMsg_Txt(),"User not registered","Error Message Is Matched As Expected");
        softAssert.assertTrue(loginPage.isPresent_UserId_Txt(), "Email text box should reappear as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.LOGIN}, description = "TC_011, Verify the Functionality of login with OTP")
    public void TC_Login_011_Verify_The_Functionality_Of_Login_With_OTP() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        loginPage.click_LoginWithOTP_Lnk();
        softAssert.assertTrue(loginPage.isPresent_UserId_Txt(), "Mobile Number field is present");
        softAssert.assertEquals(loginPage.getText_CountryCode_Txt(), "+91", "Country code +91 is selected as default");
        softAssert.assertEquals(loginPage.getText_PlaceHolder_Txt(), "Enter Mobile Number", "Mobile number placeholder text is present");
        softAssert.assertTrue(!loginPage.isEnabled_SendOTP_Btn(), "Send otp button is disabled as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.LOGIN}, description = "TC_19, Verify User Is Able To Logout Successfully")
    public void TC_Login_019_Verify_User_Is_Able_To_Logout_Successfully() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        loginPage.performLoginWithEmail(Constants.EMAIL_ID, Constants.EMAIL_PASSWORD);
        commonActions.click_Skip_Btn();
        loginPage.performLogout();
        softAssert.assertTrue(loginPage.isPresent_LoginWithEmail_Lnk(), "Login with email is present as expected");
        softAssert.assertTrue(loginPage.isPresent_LoginWithOtp_Lnk(), "Login with OTP is present as expected");
        softAssert.assertAll();
    }
}