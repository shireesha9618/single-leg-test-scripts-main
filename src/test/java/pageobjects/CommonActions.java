package pageobjects;

import constants.Constants;
import framework.common.assertion.JarvisAssert;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class CommonActions {
    private static CommonActions _instance;
    private final Locator loader_Txt = Locator.builder().withWeb(By.xpath("//div[text()='Loading...']"));
    private final Locator paginationCurrentlyShowingAndTotalCount_Lbl = Locator.builder().withWeb(By.className("ant-pagination-total-text"));
    private final Locator paginationNext_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Next']"));
    private final Locator paginationPrevious_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Prev']"));


    public static CommonActions getInstance() {
        if (_instance == null)
            _instance = new CommonActions();
        return _instance;
    }

    public void performCommonAction() {
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        Utility.acceptAlertIfPresent();
        checkAndPerformLogin();
    }

    public void checkAndPerformLogin() {
        if (LoginPage.getInstance().isPresent_LoginWithEmail_Lnk())
            LoginPage.getInstance().performLoginWithEmail(Constants.EMAIL_ID, Constants.EMAIL_PASSWORD);
    }

    public void coverUserJourneyTillRiders() {
        performCommonAction();
        ActionHelper.waitForLoaderToHide();
        click_Skip_Btn();
        HomePage.getInstance().openRidersPage();
        ActionHelper.waitForLoaderToHide();
        JarvisAssert.assertTrue(RidersPage.getInstance().isPresent_Header_Lbl());
    }

    public void waitTillLoaderTxtDisappears() {
        ActionHelper.waitForElementToHide(loader_Txt);
    }

    public void click_Skip_Btn() {
        ActionHelper.waitForLoaderToHide();
        Shadow shadow = new Shadow(DriverManager.getDriver());
        WebElement element = shadow.findElement("button[type='button'][data-pfbind-text='footer.skipButton.text']");
        String text = element.getText();
        if (element.isDisplayed())
            element.click();
    }

    public String getText_PaginationCurrentlyShowingCount_Lbl() {
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        return ActionHelper.getText(paginationCurrentlyShowingAndTotalCount_Lbl).split(" ")[1];
    }
}