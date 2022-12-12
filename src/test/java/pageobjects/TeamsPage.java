package pageobjects;

import base.BaseTestClass;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class TeamsPage extends BaseTestClass {
    private final Locator searchTeam_TextBox = Locator.builder().withWeb(By.xpath("//input[@id='search_ptp']"));


}
