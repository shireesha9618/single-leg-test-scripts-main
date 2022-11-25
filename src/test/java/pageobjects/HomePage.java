package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage {
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


    private final Locator resourcesMenu_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Resources']"));
    private final Locator ridersMenu_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Riders']"));

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

    public void openRidersPage() {
        ActionHelper.waitForLoaderToHide();
        click_Resources_Btn();
        click_RidersMenu_Btn();
    }

    public void click_Resources_Btn() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(resourcesMenu_Btn);
    }

    public void click_RidersMenu_Btn() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(ridersMenu_Btn);
    }

    public String get_TeamDropdown_Txt() {
        return ActionHelper.getText(selectTeam_Txt);
    }

    public Boolean isPresent_TeamDropdown_Txt() {
        return ActionHelper.isPresent(selectTeam_Txt, 4000);
    }
}
