package pageobjects;

import constants.Constants;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class CommonActions {
    private static CommonActions _instance;
    private final Locator loader_Img = Locator.builder().withWeb(By.cssSelector("*[class*='animate-spin']"));
    private final Locator selectTeam1 = Locator.builder().withWeb(By.id("selectTeam"));
    private final Locator skip_Btn = Locator.builder().withWeb(By.cssSelector(".productfruits--btn.productfruits--card-footer-skip-button"));
    private final Locator teamSelector_Dropdown = Locator.builder().withWeb(By.xpath("(//span[@class='ant-select-selection-search']/following-sibling::span)[1]"));

    public static CommonActions getInstance() {
        if (_instance == null) _instance = new CommonActions();
        return _instance;
    }

    public void selectTeamFromHeader(String input) {
        ActionHelper.click(teamSelector_Dropdown);
        ActionHelper.sendKeys(selectTeam1, Keys.chord(input, Keys.ENTER));
    }
    public void coverJourneyTillDispatches() {
        performCommonAction();
        click_Skip_Btn();
        HomePage.getInstance().openDispatchListPage();
    }

    public void coverJourneyTillCreateOrder () {
        performCommonAction();
        click_Skip_Btn();
        ActionHelper.waitForLoaderToHide();
    }

    public void click_Skip_Btn () {
        ActionHelper.waitForLoaderToHide();
        Shadow shadow = new Shadow(DriverManager.getDriver());
        WebElement element = shadow.findElement("button[type='button'][data-pfbind-text='footer.skipButton.text']");
        String text = element.getText();
        if (element.isDisplayed())
            element.click();
    }

    public void performCommonAction () {
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        Utility.acceptAlertIfPresent();
        waitTillLoaderDisappears();
        //LoginPage.getInstance().performLoginWithEmail(Constants.EMAIL_ID, Constants.EMAIL_PASSWORD);
        checkAndPerformLogin();
        waitTillLoaderDisappears();
        click_Skip_Btn();
        selectTeamFromHeader("QATeam");
    }

    public void coverJourneyTillFacility () {
        performCommonAction();
        ViewOrdersPage.getInstance().click_FacilitiesLeftSubMenuItem();
    }

    public Boolean isPresent_Skip_Btn () {
        return ActionHelper.isPresent(skip_Btn, 3000);
    }

    public void waitTillLoaderAppears () {
        ActionHelper.waitUntilElementVisible(loader_Img.getBy());
    }

    public void waitTillLoaderDisappears () {
        ActionHelper.waitForElementToHide(loader_Img);
    }

    public void checkAndPerformLogin () {
        LoginPage.getInstance().performLoginWithEmail(Constants.EMAIL_ID, Constants.EMAIL_PASSWORD);
    }

    public void coverJourneyTillRider () {
        performCommonAction();
        click_Skip_Btn();
        HomePage.getInstance().openRidersPage();
    }

    public void coverJourneyTillViewOrder () {
        performCommonAction();
        click_Skip_Btn();
        HomePage.getInstance().openViewOrderPage();
    }
}

