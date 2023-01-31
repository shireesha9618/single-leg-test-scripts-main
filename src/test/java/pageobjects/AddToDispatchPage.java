package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static constants.Constants.WAIT_FOR_ONE_SECOND;

public class AddToDispatchPage {

    private static AddToDispatchPage _instance;
    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//h1[normalize-space()='Add to dispatch']"));
    private final Locator addToDispatch_Btn = Locator.builder().withWeb(By.xpath("//button[@type='button']//p[normalize-space()='Add to dispatch']"));
    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//p[normalize-space()='cancel']"));


    public static AddToDispatchPage getInstance() {
        if (_instance == null) {
            _instance = new AddToDispatchPage();
        }
        return _instance;
    }

    public Boolean isPresent_Header_lbl() {
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        return ActionHelper.isPresent(header_Lbl, WAIT_FOR_ONE_SECOND);
    }

    public Boolean isPresent_AddToDispatch_Btn() {
        return ActionHelper.isPresent(addToDispatch_Btn);
    }

    public Boolean isPresent_Cancel_Btn() {
        return ActionHelper.isPresent(cancel_Btn);
    }

    public void click_Cancel_Btn() {
        ActionHelper.click(cancel_Btn);
    }

    public void click_AddToDispatch_Btn() {
        ActionHelper.waitUntilElementClickable(addToDispatch_Btn);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(ActionHelper.findElement(addToDispatch_Btn)).click().build().perform();
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

}