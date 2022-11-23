package pageobjects;

import constants.Constants;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utility.Utility.acceptAlertIfPresent;

public class CommonActions {
    private static CommonActions _instance;
    private final Locator skip_Btn = Locator.builder().withWeb(By.cssSelector(".productfruits--btn.productfruits--card-footer-skip-button"));
    private final Locator loader_Img = Locator.builder().withWeb(By.cssSelector("*[class*='animate-spin']"));

    public static CommonActions getInstance() {
        if (_instance == null)
            _instance = new CommonActions();
        return _instance;
    }

    public void coverJourneyTillCreateOrder() {
        performCommonAction();
        click_Skip_Btn();
        HomePage.getInstance().selectTeam(Constants.TEAM);
        HomePage.getInstance().openCreateOrderPage();
    }

    public void click_Skip_Btn() {
//        ActionHelper.waitForLoaderToHide();
//        Shadow shadow = new Shadow(DriverManager.getDriver());
//        WebElement element = shadow.findElement("button[type='button'][data-pfbind-text='footer.skipButton.text']");
//        if (element.isDisplayed())
//            element.click();
    }


    public Boolean isPresent_Skip_Btn() {
        return ActionHelper.isPresent(skip_Btn, 3000);
    }

    public void performCommonAction() {
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        acceptAlertIfPresent();
        waitTillLoaderDisappears();
        checkAndPerformLogin();
        waitTillLoaderDisappears();
    }

    public void waitTillLoaderAppears() {
        ActionHelper.waitUntilElementVisible(loader_Img.getBy());
    }

    public void waitTillLoaderDisappears() {
        ActionHelper.waitForElementToHide(loader_Img);
    }

    public void checkAndPerformLogin() {
//        if (HomePage.getInstance().isPresent_LoginButton_Btn())
        LoginPage.getInstance().performLoginWithEmail(Constants.EMAIL_ID, Constants.EMAIL_PASSWORD);
    }


}

