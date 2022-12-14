package pageobjects;

import base.BaseTestClass;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends BaseTestClass {
    private static HomePage _instance;
    private final Locator loginButton_Btn = Locator.builder().withWeb(By.id("loginButton"));
    private final Locator dispatchMenuItem_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Dispatch']"));
    private final Locator selectTeam_DropDown = Locator.builder().withWeb(By.id("selectTeam"));
    private final Locator selectTeam_Txt = Locator.builder().withWeb(By.xpath("//input[@id='selectTeam']/..//following-sibling::span"));
    private final Locator teamSelector_Dropdown = Locator.builder().withWeb(By.xpath("(//span[@class='ant-select-selection-search']/following-sibling::span)[1]"));
    private final Locator teamSelectorOption_Button = Locator.builder().withWeb(By.xpath("//div[@class='ant-select-item-option-content' and text()='PLACEHOLDER']"));
    private final Locator orderMenuItem_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Orders']"));
    private final Locator createOrderMenuItem_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Create Orders']"));
    private final Locator viewOrderMenuItem_Btn = Locator.builder().withWeb(By.xpath("//p[text()='View Orders']"));
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
    private final Locator delhiveryLogo_Img = Locator.builder().withWeb(By.xpath("//img[@alt='Workflow']"));
    private final Locator loginWithEmail_Lnk = Locator.builder().withWeb(By.id("zocial-oidc-email"));
    private final Locator skip_Btn = Locator.builder().withWeb(By.cssSelector(".productfruits--btn.productfruits--card-footer-skip-button"));
    private final Locator openMenu_Btn = Locator.builder().withWeb(By.xpath("//img[@alt='open menu']/.."));
    private final Locator appsHeader_Lbl = Locator.builder().withWeb(By.xpath("//a[text()='Apps']"));
    private final Locator ordersOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//span[text()='Orders']"));
    private final Locator createOrdersOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Create Orders']"));
    private final Locator viewOrdersOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='View Orders']"));
    private final Locator routingOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Routing']"));
    private final Locator dispatchOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Routing']"));
    private final Locator ridersOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Riders']"));
    private final Locator facilitiesOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Facilities']"));
    private final Locator teamsOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Teams']"));
    private final Locator settingsOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Settings']"));
    private final Locator singleLeg_Btn = Locator.builder().withWeb(By.xpath("//span[text()='Single Leg']"));
    private final Locator openMenuCross_Btn = Locator.builder().withWeb(By.xpath("(//button[@type='button'])[1]"));
    private final Locator workFlowAllAppsHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='All Apps']"));
    private final Locator workFlowOrders_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Orders']"));
    private final Locator workFlowRouting_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Routing']"));
    private final Locator workFlowDispatch_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Dispatch']"));
    private final Locator workFlowRiders_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Riders']"));
    private final Locator workFlowFacilities_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Facilities']"));
    private final Locator workFlowTeams_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Teams']"));
    private final Locator workFlowSettings_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Settings']"));
    private final Locator leftPanel_Btn = Locator.builder().withWeb(By.xpath("//div[contains(@class,'shadow-base')]"));


    public static HomePage getInstance() {
        if (_instance == null)
            _instance = new HomePage();
        return _instance;
    }

    public boolean isPresent_LoginButton_Btn() {
        return ActionHelper.isPresent(loginButton_Btn, 3000);
    }

    public void openDispatchListPage() {
        ActionHelper.click(dispatchMenuItem_Btn);
        ActionHelper.waitForLoaderToHide();
    }

    public void selectTeam(String input) {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(teamSelector_Dropdown);
        ActionHelper.sendKeys(selectTeam_DropDown, Keys.chord(input, Keys.ENTER));
    }

    public void openCreateOrderPage() {
        ActionHelper.click(createOrderMenuItem_Btn);
    }

    public void openViewOrderPage() {
        ActionHelper.waitUntilElementVisible(viewOrderMenuItem_Btn.getBy());
        ActionHelper.click(viewOrderMenuItem_Btn);
        CommonActions.getInstance().click_Skip_Btn();
        DriverManager.getDriver().navigate().refresh();
        CommonActions.getInstance().click_Skip_Btn();
    }


    public boolean isPresent_DelhiveryLogo_Img() {
        return ActionHelper.isPresent(delhiveryLogo_Img, 4000);
    }

    public void click_DelhiveryLogo_Img() {
        ActionHelper.click(delhiveryLogo_Img);
        ActionHelper.waitForLoaderToHide();
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

    public String get_TeamDropdown_Txt() {
        return ActionHelper.getText(selectTeam_Txt);
    }

    public Boolean isPresent_TeamDropdown_Txt() {
        return ActionHelper.isPresent(selectTeam_Txt, 4000);
    }

    public boolean isPresent_OpenMenuOrders_Btn() {
        return ActionHelper.isPresent(ordersOpenMenu_Btn);
    }

    public boolean isPresent_OpenMenuRouting_Btn() {
        return ActionHelper.isPresent(routingOpenMenu_Btn);
    }

    public boolean isPresent_OpenMenuDispatch_Btn() {
        return ActionHelper.isPresent(dispatchOpenMenu_Btn);
    }

    public boolean isPresent_OpenMenuRiders_Btn() {
        return ActionHelper.isPresent(ridersOpenMenu_Btn);
    }

    public void click_OpenMenuRiders_Btn() {
        ActionHelper.click(ridersOpenMenu_Btn);
    }

    public boolean isPresent_OpenMenuFacilities_Btn() {
        return ActionHelper.isPresent(facilitiesOpenMenu_Btn);
    }

    public boolean isPresent_OpenMenuTeams_Btn() {
        return ActionHelper.isPresent(teamsOpenMenu_Btn);
    }

    public boolean isPresent_OpenMenuSettings_Btn() {
        return ActionHelper.isPresent(settingsOpenMenu_Btn);
    }

    public boolean isPresent_AppsHeader_Lbl() {
        return ActionHelper.isPresent(appsHeader_Lbl);
    }

    public boolean isPresent_OpenMenu_Btn() {
        return ActionHelper.isPresent(openMenu_Btn, 3000);
    }

    public void click_OpenMenu_Btn() {
        ActionHelper.click(openMenu_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void click_OpenMenuCross_Btn() {
        ActionHelper.click(openMenuCross_Btn);
    }

    public boolean isPresent_AllAppsHeader_Lbl() {
        return ActionHelper.isPresent(workFlowAllAppsHeader_Lbl);
    }

    public boolean isPresent_WorkFlowOrders_Btn() {
        return ActionHelper.isPresent(workFlowOrders_Btn);
    }

    public boolean isPresent_WorkFlowRouting_Btn() {
        return ActionHelper.isPresent(workFlowRouting_Btn);
    }

    public boolean isPresent_WorkFlowDispatch_Btn() {
        return ActionHelper.isPresent(workFlowDispatch_Btn);
    }

    public boolean isPresent_WorkflowRiders_Btn() {
        return ActionHelper.isPresent(workFlowRiders_Btn);
    }

    public void click_WorkFlowRiders_Btn() {
        ActionHelper.click(workFlowRiders_Btn);
    }

    public boolean isPresent_WorkFlowFacilities_Btn() {
        return ActionHelper.isPresent(workFlowFacilities_Btn);
    }

    public boolean isPresent_WorkFlowTeams_Btn() {
        return ActionHelper.isPresent(workFlowTeams_Btn);
    }

    public boolean isPresent_WorkFlowSettings_Btn() {
        return ActionHelper.isPresent(workFlowSettings_Btn);
    }

    public void expand_ResourcesMenu_Btn() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(resourcesMenu_Btn);
    }

    public void collapse_ResourcesMenu_Btn() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(resourcesMenu_Btn);
    }

    public boolean isPresent_FacilitiesMenu_Btn() {
        return ActionHelper.isPresent(facilitiesMenu_Btn);
    }

    public boolean isPresent_leftPanel_Btn() {
        return ActionHelper.isPresent(leftPanel_Btn, 6000);
    }

    public void expand_LeftPanel_Btn() {
        ActionHelper.click(leftPanel_Btn);
    }

    public void unExpand_LeftPanel_Btn() {
        ActionHelper.click(leftPanel_Btn);
    }

    public boolean isPresent_OrdersMenu_Btn() {
        return ActionHelper.isPresent(ordersMenu_Btn);
    }

    public boolean isPresent_DispatchMenu_Btn() {
        return ActionHelper.isPresent(dispatchMenu_Btn);
    }

    public boolean isPresent_TeamsMenu_Btn() {
        return ActionHelper.isPresent(teamsMenu_Btn);
    }

    public boolean isPresent_SettingsMenu_Btn() {
        return ActionHelper.isPresent(settingsMenu_Btn);
    }
}