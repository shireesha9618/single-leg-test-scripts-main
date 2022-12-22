package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class SettingsWorkflowPage {
    private static SettingsWorkflowPage _instance;
    private final Locator workflowHeader_Lbl = Locator.builder().withWeb(By.xpath("//div[@class='h-full']//p[text()='Workflow']"));
    private final Locator workflowBreadCrumb_Link = Locator.builder().withWeb(By.id("/settings/[ptpType]"));
    private final Locator executionTask_Link = Locator.builder().withWeb(By.xpath("//p[text()='Execution Task']/ancestor::a"));
    private final Locator objectiveWorkflow_Link = Locator.builder().withWeb(By.xpath("//p[text()='Objective Workflow']/ancestor::a"));
    private final Locator jobWorkflow_Link = Locator.builder().withWeb(By.xpath("//p[text()='Job Workflow']/ancestor::a"));

    public static SettingsWorkflowPage getInstance() {
        if(_instance == null)
            _instance = new SettingsWorkflowPage();
        return _instance;
    }

    public boolean isPresent_WorkflowHeader_Lbl() {
        return ActionHelper.isPresent(workflowHeader_Lbl);
    }

    public String getText_WorkflowHeader_Lbl() {
        return ActionHelper.getText(workflowHeader_Lbl);
    }

    public boolean isPresent_workflowBreadCrumb_Link() {
        return ActionHelper.isPresent(workflowBreadCrumb_Link);
    }

    public void click_WorkflowBreadCrumb_Link() {
        ActionHelper.click(workflowBreadCrumb_Link);
    }

    public boolean isPresent_ExecutionTask_Link() {
        return ActionHelper.isPresent(executionTask_Link);
    }

    public void click_ExecutionTask_Link() {
        ActionHelper.click(executionTask_Link);
    }

    public boolean isPresent_ObjectiveWorkflow_Link() {
        return ActionHelper.isPresent(objectiveWorkflow_Link);
    }

    public boolean isPresent_JobWorkflow_Link() {
        return ActionHelper.isPresent(jobWorkflow_Link);
    }

    public void click_JobWorkflow_Link() {
        ActionHelper.click(jobWorkflow_Link);
    }
}
