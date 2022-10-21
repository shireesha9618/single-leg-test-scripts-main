package pageobjects;

import base.BaseTestClass;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;


public class LoginPage extends BaseTestClass {
    private static LoginPage _instance;

    public static LoginPage getInstance() {
        if (_instance == null) _instance = new LoginPage();
        return _instance;
    }
}
