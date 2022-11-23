package pageobjects;

import base.BaseTestClass;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class HomePage extends BaseTestClass {
    private static HomePage _instance;
    private final Locator ordersMenu_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Orders']"));
    private final Locator createOrdersMenu_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Create Orders']"));
    private final Locator viewOrdersMenu_Btn = Locator.builder().withWeb(By.xpath("//p[text()='View Orders']"));
    private final Locator dispatchMenu_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Dispatch']"));
    private final Locator resourcesMenu_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Resources']"));
    private final Locator ridersMenu_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Riders']"));
    private final Locator facilitiesMenu_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Facilities']"));
    private final Locator teamsMenu_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Teams']"));
    private final Locator settingsMenu_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Settings']"));
    private final Locator userProfile_Img = Locator.builder().withWeb(By.xpath("//div[@class='flex items-center']/div/p"));
    private final Locator logout_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Logout']"));
    private final Locator delhiveryLogo_Img = Locator.builder().withWeb(By.id("//img[@alt='Workflow']"));
    private final Locator loginWithEmail_Lnk = Locator.builder().withWeb(By.id("zocial-otp-email"));
    private final Locator skip_Btn = Locator.builder().withWeb(By.cssSelector(".productfruits--btn.productfruits--card-footer-skip-button"));

    public static HomePage getInstance() {
        if (_instance == null)
            _instance = new HomePage();
        return _instance;
    }

    public boolean isPresent_DelhiveryLogo_Img() {
        return ActionHelper.isPresent(delhiveryLogo_Img,2000);
    }

    public void click_DelhiveryLogo_Img() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(delhiveryLogo_Img);
    }

    public boolean isPresent_UserProfile_Img() {
        return ActionHelper.isPresent(userProfile_Img, 2000);
    }

    public void click_UserProfile_Img() {
        ActionHelper.waitUntilElementVisible(userProfile_Img.getBy());
        ActionHelper.click(userProfile_Img);
    }

    public boolean isPresent_Logout_Btn() {
        return ActionHelper.isPresent(logout_Btn, 5000);
    }

    public void click_Logout_Btn() {
        if (isPresent_Logout_Btn())
            ActionHelper.click(logout_Btn);
        ActionHelper.waitUntilElementVisible(loginWithEmail_Lnk.getBy());
    }

    public void openRidersPage() {
        ActionHelper.waitForLoaderToHide();
        click_Resources_Btn();
        click_RidersMenu_Btn();
    }

    public boolean isPresent_ResourcesMenu_Btn() {
        return ActionHelper.isPresent(resourcesMenu_Btn, 2000);
    }

    public void click_Resources_Btn() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(resourcesMenu_Btn);
    }

    public boolean isPresent_RidersMenu_Btn() {
        return ActionHelper.isPresent(ridersMenu_Btn, 2000);
    }

    public void click_RidersMenu_Btn() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(ridersMenu_Btn);
    }

    public boolean isPresent_Skip_Btn() {
        return ActionHelper.isPresent(skip_Btn, 10000);
    }
}