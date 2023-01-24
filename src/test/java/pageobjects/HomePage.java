package pageobjects;

import base.BaseTestClass;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utility.Utility;

import static constants.Constants.WAIT_FOR_ONE_SECOND;

public class HomePage extends BaseTestClass {
    private static HomePage _instance;
    private final Locator loginButton_Btn = Locator.builder().withWeb(By.id("loginButton"));
    private final Locator dispatchMenuItem_Btn = Locator.builder().withWeb(By.xpath("(//a[normalize-space()='Dispatch'])[1]"));
    private final Locator selectTeam_DropDown = Locator.builder().withWeb(By.id("selectTeam"));
    private final Locator selectTeam_Txt = Locator.builder().withWeb(By.xpath("//input[@id='selectTeam']/..//following-sibling::span"));
    private final Locator teamSelector_Dropdown = Locator.builder().withWeb(By.xpath("(//span[@class='ant-select-selection-search']/following-sibling::span)[1]"));
    private final Locator teamSelectorOption_Button = Locator.builder().withWeb(By.xpath("//div[@class='ant-select-item-option-content' and text()='PLACEHOLDER']"));
    private final Locator orderMenuItem_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Orders']"));
    private final Locator createOrderMenuItem_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Create Orders']"));
    private final Locator viewOrderMenuItem_Btn = Locator.builder().withWeb(By.xpath("//a[text()='View Orders']"));
    private final Locator ordersMenu_Icon = Locator.builder().withWeb(By.xpath("//div[@id='sidebar-0']//p[text()='Orders']/preceding-sibling::*"));
    private final Locator ordersMenu_Btn = Locator.builder().withWeb(By.xpath("//div[@id='sidebar-0']//p[text()='Orders']"));
    private final Locator createOrdersMenu_Btn = Locator.builder().withWeb(By.xpath("//div[@id='sidebar-0']//p[text()='Create Orders']"));
    private final Locator viewOrdersMenu_Btn = Locator.builder().withWeb(By.xpath("//div[@id='sidebar-0']//p[text()='View Orders']"));
    private final Locator dispatchMenu_Icon = Locator.builder().withWeb(By.xpath("//div[@id='sidebar-1']//p[text()='Dispatch']/preceding-sibling::*"));
    private final Locator dispatchMenu_Btn = Locator.builder().withWeb(By.xpath("//div[@id='sidebar-1']//p[text()='Dispatch']"));
    private final Locator resourcesMenu_Icon = Locator.builder().withWeb(By.xpath("//div[@id='sidebar-2']//p[text()='Resources']/preceding-sibling::*"));
    private final Locator resourcesMenu_Btn = Locator.builder().withWeb(By.xpath("//div[@id='sidebar-2']//p[text()='Resources']"));
    private final Locator ridersMenu_Btn = Locator.builder().withWeb(By.xpath("//nav[@aria-label='Sidebar']//a[contains(@href,'riders')]"));
    private final Locator facilitiesMenu_Btn = Locator.builder().withWeb(By.xpath("//nav[@aria-label='Sidebar']//a[contains(@href,'facilities')]"));
    private final Locator teamsMenu_Btn = Locator.builder().withWeb(By.xpath("//nav[@aria-label='Sidebar']//a[contains(@href,'teams')]"));
    private final Locator settingsMenu_Btn = Locator.builder().withWeb(By.xpath("//nav[@aria-label='Sidebar']//a[contains(@href,'settings')]"));
    private final Locator teamsMenu_Icon = Locator.builder().withWeb(By.xpath("//div[@id='sidebar-3']//p[text()='Teams']/preceding-sibling::*"));
    private final Locator settingsMenu_Icon = Locator.builder().withWeb(By.xpath("//p[text()='Settings']/preceding-sibling::*"));
    private final Locator userProfile_Img = Locator.builder().withWeb(By.xpath("//div[@class='flex items-center']/div/p"));
    private final Locator logout_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Logout']"));
    private final Locator delhiveryLogo_Img = Locator.builder().withWeb(By.xpath("//img[@alt='Workflow']"));
    private final Locator loginWithEmail_Lnk = Locator.builder().withWeb(By.id("zocial-oidc-email"));
    private final Locator skip_Btn = Locator.builder().withWeb(By.cssSelector(".productfruits--btn.productfruits--card-footer-skip-button"));
    private final Locator teamSelect_Btn = Locator.builder().withWeb(By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div"));
    private final Locator teamSelect_List = Locator.builder().withWeb(By.xpath("//div[@class='ant-select-item-option-content']"));
    private final Locator openMenu_Btn = Locator.builder().withWeb(By.xpath("//img[@alt='open menu']"));
    private final Locator appsHeader_Lbl = Locator.builder().withWeb(By.xpath("//a[text()='Apps']"));
    private final Locator ordersOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//span[text()='Orders']"));
    private final Locator createOrdersOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Create Orders']"));
    private final Locator viewOrdersOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='View Orders']"));
    private final Locator routingOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Routing']"));
    private final Locator dispatchOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//nav[@aria-label='Sidebar']//a[contains(text(),'Dispatch')]"));
    private final Locator ridersOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Riders']"));
    private final Locator facilitiesOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Facilities']"));
    private final Locator teamsOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Teams']"));
    private final Locator settingsOpenMenu_Btn = Locator.builder().withWeb(By.xpath("//a[text()='Settings']"));
    private final Locator singleLeg_Btn = Locator.builder().withWeb(By.xpath("//span[text()='Single Leg']"));
    private final Locator openMenuCross_Btn = Locator.builder().withWeb(By.xpath("(//button[@type='button'])[1]"));
    private final Locator workFlowOs1_Link = Locator.builder().withWeb(By.xpath("//header//img[@alt='Workflow']"));
    private final Locator workFlowAllAppsHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='All Apps']"));
    private final Locator workFlowOrders_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Orders']"));
    private final Locator workFlowRouting_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Routing']"));
    private final Locator workFlowDispatch_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Dispatch']"));
    private final Locator workFlowRiders_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Riders']"));
    private final Locator workFlowFacilities_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Facilities']"));
    private final Locator workFlowTeams_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Teams']"));
    private final Locator workFlowSettings_Btn = Locator.builder().withWeb(By.xpath("//div[text()='Settings']"));
    private final Locator leftPanel_Btn = Locator.builder().withWeb(By.xpath("//div[contains(@class,'shadow-base')]"));
    private final Locator closeSideBar_Icon = Locator.builder().withWeb(By.id("closeSideBar"));
    private final Locator openSideBar_Icon = Locator.builder().withWeb(By.id("openSideBar"));
    private final Locator menu_Icon = Locator.builder().withWeb(By.cssSelector("img[alt='open menu']"));
    private final Locator closeMenu_Btn = Locator.builder().withWeb(By.xpath("(//*[name()='svg'][@data-icon='circle-xmark'])[1]"));

    public static HomePage getInstance() {
        if (_instance == null)
            _instance = new HomePage();
        return _instance;
    }

    public boolean isPresent_LoginButton_Btn() {
        return ActionHelper.isPresent(loginButton_Btn, 3000);
    }

    public void openDispatchListPage() {
        HomePage.getInstance().click_OpenMenu_Btn();
        ActionHelper.waitUntilElementClickable(dispatchOpenMenu_Btn);
        ActionHelper.click(dispatchOpenMenu_Btn);
        ActionHelper.waitForLoaderToHide();
    }

    public void selectTeam(String input) {
        CommonActions.getInstance().waitTillLoaderDisappears();
        Utility.select_FromDropDown_List(teamSelector_Dropdown.getBy(), teamSelect_List.getBy(), input);
    }

    public void openCreateOrderPage() {
        click_OpenMenu_Btn();
        ActionHelper.click(createOrderMenuItem_Btn);
    }

    public void openViewOrderPage() {
        click_OpenMenu_Btn();
        ActionHelper.waitUntilElementVisible(viewOrderMenuItem_Btn.getBy());
        ActionHelper.click(viewOrderMenuItem_Btn);
        CommonActions.getInstance().click_SkipIfPresent_Btn();
        DriverManager.getDriver().navigate().refresh();
        CommonActions.getInstance().click_SkipIfPresent_Btn();
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
        // commenting for now as resources dropdown is not present click_Resources_Btn();
        click_RidersMenu_Btn();
    }

    public boolean isPresent_ResourcesMenu_Icon() {
        return ActionHelper.isPresent(resourcesMenu_Icon);
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
        click_OpenMenu_Btn();
        ActionHelper.click(ridersMenu_Btn);
    }

    public boolean isPresent_Skip_Btn() {
        return ActionHelper.isPresent(skip_Btn, 10000);
    }

    public String get_TeamDropdown_Txt() {
        return ActionHelper.getText(selectTeam_Txt);
    }

    public Boolean isPresent_TeamDropdown_Txt() {
        return ActionHelper.isPresent(selectTeam_Txt, 10000);
    }

    public void selectTeam2(String input) {
        ActionHelper.waitForLoaderToHide();
        Utility.select_FromDropDown_List(teamSelector_Dropdown.getBy(), teamSelect_Btn.getBy(), input);
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

    public void click_DispatchOpenMenu_Btn() {
        ActionHelper.click(dispatchOpenMenu_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
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

    public boolean isPresent_SingleLeg_Btn() {
        return ActionHelper.isPresent(singleLeg_Btn);
    }

    public boolean isPresent_AppsHeader_Lbl() {
        return ActionHelper.isPresent(appsHeader_Lbl);
    }

    public boolean isPresent_OpenMenu_Btn() {
        return ActionHelper.isPresent(openMenu_Btn, 3000);
    }

    public void click_OpenMenu_Btn() {
        ActionHelper.click(openMenu_Btn);
    }

    public void click_OpenMenuCross_Btn() {
        int TIMEOUT = 5000;
        if (ActionHelper.isPresent(openMenuCross_Btn, TIMEOUT))
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

    public void click_WorkFlowDispatch_Btn() {
        ActionHelper.click(workFlowDispatch_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
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

    public void unDock_LeftPanel_Btn() {
        ActionHelper.click(leftPanel_Btn);
    }

    public void dock_LeftPanel_Btn() {
        ActionHelper.click(leftPanel_Btn);
    }

    public boolean isPresent_OrdersMenu_Icon() {
        return ActionHelper.isPresent(ordersMenu_Icon);
    }

    public boolean isPresent_OrdersMenu_Btn() {
        return ActionHelper.isPresent(ordersMenu_Btn);
    }

    public boolean isPresent_DispatchMenu_Icon() {
        return ActionHelper.isPresent(dispatchMenu_Icon);
    }

    public boolean isPresent_DispatchMenu_Btn() {
        return ActionHelper.isPresent(dispatchMenu_Btn);
    }

    public boolean isPresent_TeamsMenu_Icon() {
        return ActionHelper.isPresent(teamsMenu_Icon);
    }

    public boolean isPresent_TeamsMenu_Btn() {
        return ActionHelper.isPresent(teamsMenu_Btn);
    }

    public boolean isPresent_SettingsMenu_Icon() {
        return ActionHelper.isPresent(settingsMenu_Icon);
    }

    public boolean isPresent_SettingsMenu_Btn() {
        return ActionHelper.isPresent(settingsMenu_Btn);
    }

    public boolean isPresent_FacilitiesMenuItem_Btn() {
        return ActionHelper.isPresent(facilitiesMenu_Btn);
    }

    public void click_FacilitiesMenuItem_Btn() {
        click_OpenMenu_Btn();
        ActionHelper.click(facilitiesOpenMenu_Btn);
    }

    public void openTeamsPage() {
        click_OpenMenu_Btn();
        ActionHelper.click(teamsMenu_Btn);
    }

    public void click_OpenMenuFacility_Btn() {
        ActionHelper.click(facilitiesOpenMenu_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_WorkFlowRiders_Btn() {
        return ActionHelper.isPresent(workFlowRiders_Btn);
    }

    public void click_WorkFlowFacilities_Btn() {
        ActionHelper.click(workFlowFacilities_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void unExpand_ResourcesMenu_Btn() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(resourcesMenu_Btn);
    }

    public boolean isPresent_LeftPanel_Btn() {
        return ActionHelper.isPresent(leftPanel_Btn, 5000);
    }

    public void expand_LeftPanel_Btn() {
        ActionHelper.click(leftPanel_Btn);
    }

    public void unExpand_LeftPanel_Btn() {
        ActionHelper.click(leftPanel_Btn);
    }

    public boolean isPresent_OpenMenuCreateOrders_Btn() {
        return ActionHelper.isPresent(createOrdersOpenMenu_Btn);
    }

    public boolean isPresent_OpenMenuViewOrders_Btn() {
        return ActionHelper.isPresent(viewOrdersOpenMenu_Btn);
    }

    public boolean isPresent_WorkFlowOs1_Link() {
        return ActionHelper.isPresent(workFlowOs1_Link);
    }

    public void click_WorkFlowOs1_Link() {
        ActionHelper.click(workFlowOs1_Link);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void click_OpenSideBar_Icon() {
        ActionHelper.click(openSideBar_Icon);
    }

    public void click_CloseSideBar_Icon() {
        ActionHelper.click(closeSideBar_Icon);
    }

    public void click_SettingsMenu_Btn() {
        click_OpenMenu_Btn();
        click_OpenMenuSettings_Btn();
    }

    public void click_OpenMenuSettings_Btn() {
        ActionHelper.click(settingsOpenMenu_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void click_WorkFlowSettings_Btn() {
        ActionHelper.click(workFlowSettings_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void click_OpenMenuTeams_Btn() {
        ActionHelper.click(teamsOpenMenu_Btn);
    }

    public void click_WorkFlowTeams_Btn() {
        ActionHelper.click(workFlowTeams_Btn);
    }

    public boolean isPresent_CreateOrderMenu_Btn() {
        return ActionHelper.isPresent(createOrdersMenu_Btn);
    }

    public boolean isPresent_ViewOrdersMenu_Btn() {
        return ActionHelper.isPresent(viewOrdersMenu_Btn);
    }

    public void click_OpenMenuCreateOrders_Btn() {
        ActionHelper.click(createOrderMenuItem_Btn);
    }

    public void click_OpenMenuViewOrders_Btn() {
        ActionHelper.click(viewOrdersOpenMenu_Btn);
    }

    public void click_WorkFlowOrders_Btn() {
        ActionHelper.click(workFlowOrders_Btn);
    }
}