package pageobjects.settings;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class UserPage {
    private static UserPage _instance;
    private final Locator userHeader_Lbl = Locator.builder().withWeb(By.xpath("//div[@class='h-full']//p[text()='Users']"));

    public static UserPage getInstance() {
        if(_instance == null)
            _instance = new UserPage();
        return _instance;
    }

    public boolean isPresent_UserHeader_Lbl() {
        return ActionHelper.isPresent(userHeader_Lbl);
    }

    public String getText_UserHeader_Lbl() {
        return ActionHelper.getText(userHeader_Lbl);
    }
}
