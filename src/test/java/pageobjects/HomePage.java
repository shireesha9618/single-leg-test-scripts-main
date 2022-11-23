package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage {
    private static HomePage _instance;
    private final Locator loginButton_Btn = Locator.builder().withWeb(By.id("loginButton"));

    private final Locator selectTeam = Locator.builder().withWeb(By.id("selectTeam"));
    private final Locator teamSelector_Dropdown = Locator.builder().withWeb(By.xpath("(//span[@class='ant-select-selection-search']/following-sibling::span)[1]"));

    private final Locator dispatchMenuItem_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Dispatch']"));
    private final Locator createOrderMenuItem_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Create Orders']"));
    private final Locator viewOrderMenuItem_Btn = Locator.builder().withWeb(By.xpath("//p[text()='View Orders']"));

    public static HomePage getInstance() {
        if (_instance == null)
            _instance = new HomePage();
        return _instance;
    }

    public boolean isPresent_LoginButton_Btn() {
        return ActionHelper.isPresent(loginButton_Btn, 3000);
    }

    public void selectTeam(String input) {
        ActionHelper.click(teamSelector_Dropdown);
        ActionHelper.sendKeys(selectTeam, Keys.chord(input, Keys.ENTER));
    }

    public void openCreateOrderPage() {
        ActionHelper.click(createOrderMenuItem_Btn);
    }

    public void openViewOrderPage() {
        ActionHelper.click(viewOrderMenuItem_Btn);
        CommonActions.getInstance().click_Skip_Btn();
    }
}
