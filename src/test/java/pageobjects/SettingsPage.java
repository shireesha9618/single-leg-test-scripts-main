package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class SettingsPage {
    private static SettingsPage _instance;
    private final Locator settingPageHeader_Lbl = Locator.builder().withWeb(By.xpath("//div[@class='h-full']//p[text()='Settings']"));
    private final Locator settingBreadCrumb_Link = Locator.builder().withWeb(By.id("/settings"));
    private final Locator general_Link = Locator.builder().withWeb(By.xpath("//p[text()='abc']/ancestor::a"));
    private final Locator workflow_Link = Locator.builder().withWeb(By.xpath("//p[text()='Workflow']/ancestor::a"));
    private final Locator users_Link = Locator.builder().withWeb(By.xpath("//p[text()='Users']/ancestor::a"));
    CommonActions commonActions = CommonActions.getInstance();

    public static SettingsPage getInstance() {
        if (_instance == null)
            _instance = new SettingsPage();
        return _instance;
    }

    public boolean isPresent_SettingPageHeader_Lbl() {
        return ActionHelper.isPresent(settingPageHeader_Lbl);
    }

    public String getText_SettingPageHeader_Lbl() {
        return ActionHelper.getText(settingPageHeader_Lbl);
    }

    public boolean isPresent_SettingBreadCrumb_Link() {
        return ActionHelper.isPresent(settingBreadCrumb_Link);
    }

    public void click_settingBreadCrumb_Link() {
        ActionHelper.click(settingBreadCrumb_Link);
    }

    public boolean isPresent_General_Link() {
        return ActionHelper.isPresent(general_Link);
    }

    public void click_General_Link() {
        ActionHelper.click(general_Link);
        commonActions.waitTillLoaderDisappears();
    }

    public boolean isPresent_Workflow_Link() {
        return ActionHelper.isPresent(workflow_Link);
    }

    public void click_Workflow_Link() {
        ActionHelper.click(workflow_Link);
        commonActions.waitTillLoaderDisappears();
    }

    public boolean isPresent_Users_Link() {
        return ActionHelper.isPresent(users_Link);
    }

    public void click_Users_Link() {
        ActionHelper.click(users_Link);
        commonActions.waitTillLoaderDisappears();
    }
}
