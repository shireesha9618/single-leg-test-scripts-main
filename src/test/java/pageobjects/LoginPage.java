package pageobjects;

import base.BaseTestClass;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.utils.GmailHelper;
import org.openqa.selenium.By;


public class LoginPage extends BaseTestClass {
    private static LoginPage _instance;
    private final Locator loginWithEmail_Lnk = Locator.builder().withWeb(By.id("zocial-oidc-email"));
    private final Locator loginWithOTP_Lnk = Locator.builder().withWeb(By.id("zocial-otp-login"));
    private final Locator loginWithGoogle_Lnk = Locator.builder().withWeb(By.id("zocial-google"));
    private final Locator userId_Txt = Locator.builder().withWeb(By.id("dp-email-input"));
    private final Locator sendOTP_Btn = Locator.builder().withWeb(By.id("dp-submit-btn"));
    private final Locator countryCode_Txt = Locator.builder().withWeb(By.id("countryCode"));
    private final String otp_Txt = "otp-xyz";
    private final Locator login_Btn = Locator.builder().withWeb(By.xpath("//button[text()='Login']"));
    private final Locator errorMessage_Lbl = Locator.builder().withWeb(By.xpath("//span[@class='dp-server-error-msg dp-error-red']"));
    private final Locator userIdAfterLogin_Txt = Locator.builder().withWeb(By.id("mobileNumber"));
    private final Locator loginHomeScreen_Btn = Locator.builder().withWeb(By.id("loginButton"));
    public static LoginPage getInstance() {
        if (_instance == null) _instance = new LoginPage();
        return _instance;
    }
    public synchronized void performLoginWithEmail(String emailID, String emailPassword) {
        System.out.println("============ PERFORM LOGIN ============");
        navigateToLoginScreen();
        click_LoginWithEmail_Lnk();
        fill_UserId_Txt(emailID);
        click_SendOTP_Btn();
        String otp = GmailHelper.getInstance().getLatestOTPFromEmail(emailID, emailPassword);
        fill_Otp_Txt(otp);
        click_Login_Btn();
    }
    public boolean isPresent_UserId_Txt() {
        return ActionHelper.isPresent(userId_Txt, 3000);
    }

    public void fill_UserId_Txt(String userId) {
        ActionHelper.fillWithClear(userId_Txt.getBy(), userId);
    }

    public void fill_Otp_Txt(String otp) {
        for (int i = 0; i < otp.length(); i++) {
            By by = By.id(otp_Txt.replace("xyz", String.valueOf(i)));
            ActionHelper.sendKeysWithClear(by, String.valueOf(otp.charAt(i)));
        }
    }

    public void click_SendOTP_Btn() {
        ActionHelper.click(sendOTP_Btn);
    }

    public void click_LoginWithEmail_Lnk() {
        navigateToLoginScreen();
        ActionHelper.click(loginWithEmail_Lnk);
    }

    public boolean isPresent_SendOTP_Btn() {
        return ActionHelper.isPresent(sendOTP_Btn, 3000);
    }

    public boolean isPresent_LoginHomeScreen_Btn() {
        return ActionHelper.isPresent(loginHomeScreen_Btn, 1000);
    }

    public void click_Login_Btn() {
        ActionHelper.click(login_Btn);
    }


    public boolean isPresent_LoginWithEmail_Lnk() {
        return ActionHelper.isPresent(loginWithEmail_Lnk);
    }

    public boolean isPresent_ErrorMessage_Lbl() {
        return ActionHelper.isPresent(errorMessage_Lbl);
    }

    public String getText_ErrorMessage_Lbl() {
        ActionHelper.waitUntilElementVisible(errorMessage_Lbl.getBy());
        return ActionHelper.getText(errorMessage_Lbl.getBy());
    }

    public void delete_UserIdAfterLogin_Txt() {
        ActionHelper.sendKeysWithClear(userIdAfterLogin_Txt.getBy(), " ");
    }

    public String getText_UserIdAfterLogin_Txt() {
        return ActionHelper.getAttribute(userIdAfterLogin_Txt, "value");
    }

    public String getText_userIdValidationMessage_Txt() {
        return ActionHelper.findElement(userId_Txt).getAttribute("validationMessage");
    }

    public boolean isEnabled_SendOTP_Btn() {
        return ActionHelper.isEnabled(sendOTP_Btn.getBy());
    }

    public boolean isPresent_LoginWithOtp_Lnk() {
        return ActionHelper.isPresent(loginWithOTP_Lnk);
    }

    public boolean isPresent_LoginWitGoogle_Lnk() {
        return ActionHelper.isPresent(loginWithGoogle_Lnk);
    }

    public void click_LoginWithOTP_Lnk() {
        navigateToLoginScreen();
        ActionHelper.click(loginWithOTP_Lnk);
    }

    public String getText_CountryCode_Txt() {
        return ActionHelper.getAttribute(countryCode_Txt.getBy(), "value");
    }

    public String getText_PlaceHolder_Txt() {
        return ActionHelper.getAttribute(userId_Txt.getBy(), "placeholder");
    }

    public void navigateToLoginScreen() {
        if (isPresent_LoginHomeScreen_Btn())
            ActionHelper.click(loginHomeScreen_Btn);
    }
}