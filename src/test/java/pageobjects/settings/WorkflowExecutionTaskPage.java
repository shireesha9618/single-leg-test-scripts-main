package pageobjects.settings;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class WorkflowExecutionTaskPage {
    private static WorkflowExecutionTaskPage _instance;
    private final Locator executionTaskHeader_Lbl = Locator.builder().withWeb(By.xpath("//div/p[text()='Execution Tasks']"));
    private final Locator executionTaskBreadCrumb_Link = Locator.builder().withWeb(By.id("/settings/workflow/execution-task/list"));
    private final Locator search_Txt = Locator.builder().withWeb(By.id("search"));
    private final Locator startMenuCard_Link = Locator.builder().withWeb(By.xpath("//p[text()='Start']/ancestor::a"));
    private final Locator startMenuCardHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Start']"));
    private final Locator startMenuCardEditReason_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Start']/../following-sibling::div/div"));

    public static WorkflowExecutionTaskPage getInstance() {
        if(_instance == null)
            _instance = new WorkflowExecutionTaskPage();
        return _instance;
    }

    public boolean isPresent_ExecutionTaskHeader_Lbl() {
        return ActionHelper.isPresent(executionTaskHeader_Lbl);
    }

    public String getText_ExecutionTaskHeader_Lbl() {
        return ActionHelper.getText(executionTaskHeader_Lbl);
    }

    public boolean isPresent_ExecutionTaskBreadCrumb_Link() {
        return ActionHelper.isPresent(executionTaskBreadCrumb_Link);
    }

    public void click_ExecutionTaskBreadCrumb_Link() {
        ActionHelper.click(executionTaskBreadCrumb_Link);
    }

    public boolean isPresent_Search_Txt() {
        return ActionHelper.isPresent(search_Txt);
    }

    public void fill_Search_Txt(String executionTask) {
        ActionHelper.sendKeysWithClear(search_Txt.getBy(), executionTask);
    }

    public boolean isPresent_StartMenuCard_Link() {
        return ActionHelper.isPresent(startMenuCard_Link);
    }

    public void click_StartMenuCard_Link() {
        ActionHelper.click(startMenuCard_Link);
    }

    public boolean isPresent_StartMenuCardHeader_Lbl() {
        return ActionHelper.isPresent(startMenuCardHeader_Lbl);
    }

    public String getText_StartMenuCardHeader_Lbl() {
        return ActionHelper.getText(startMenuCardHeader_Lbl);
    }

    public boolean isPresent_StartMenuCardEditReason_Btn() {
        return ActionHelper.isPresent(startMenuCardEditReason_Btn);
    }

    public void click_StartMenuCardEditReason_Btn() {
        ActionHelper.click(startMenuCardEditReason_Btn);
    }

    public boolean isEnabled_StartMenuCardEditReason_Btn() {
        return ActionHelper.isEnabled(startMenuCardEditReason_Btn.getBy());
    }
}
