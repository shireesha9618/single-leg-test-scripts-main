package pageobjects.settings;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import pageobjects.CommonActions;

public class ObjectiveWorkflowPage {
    private static ObjectiveWorkflowPage _instance;
    private final Locator search_Txt = Locator.builder().withWeb(By.id("search"));

    public static ObjectiveWorkflowPage getInstance() {
        if(_instance == null)
            _instance = new ObjectiveWorkflowPage();
        return _instance;
    }

    public boolean isPresent_Search_Txt() {
        return ActionHelper.isPresent(search_Txt);
    }

    public void fill_Search_Txt(String objectiveName) {
        ActionHelper.sendKeysWithClear(search_Txt.getBy(), objectiveName);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }
}
