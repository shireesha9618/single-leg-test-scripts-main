package pageobjects;

import base.BaseTestClass;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class TeamDetailsPage extends BaseTestClass {
    private static TeamDetailsPage _instance;
    private final Locator headerTeamName_Lbl = Locator.builder().withWeb(By.xpath("//h1"));
    private final Locator subHeader_Lbl = Locator.builder().withWeb(By.xpath("//h1/following-sibling::span/p"));
    private final Locator homeBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/']"));
    private final Locator teams_BreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/teams']"));
    private final Locator teamDetailsBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//p[text()='Team Details']"));
    private final Locator status_Lbl = Locator.builder().withWeb(By.xpath("//h6/p"));
    private final Locator edit_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Edit']"));


    public static TeamDetailsPage getInstance() {
        if (_instance == null)
            _instance = new TeamDetailsPage();
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        CommonActions.getInstance().waitTillLoaderDisappears();
        return ActionHelper.isPresent(headerTeamName_Lbl);
    }

    public String getText_Header_Lbl() {
        return ActionHelper.getText(headerTeamName_Lbl);
    }

    public boolean isPresent_Edit_Btn() {
        return ActionHelper.isPresent(edit_Btn);
    }

    public void click_Edit_Btn() {
        ActionHelper.click(edit_Btn);
    }

    public boolean isPresent_TeamDetailsBreadCrumb_Link() {
        return ActionHelper.isPresent(teamDetailsBreadCrumb_Link);
    }

    public void click_TeamsBreadCrumb_Link() {
        ActionHelper.click(teams_BreadCrumb_Link);
    }
}
