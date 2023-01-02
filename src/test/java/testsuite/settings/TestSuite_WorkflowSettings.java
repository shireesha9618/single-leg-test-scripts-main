package testsuite.settings;

import base.BaseTestClass;
import pageobjects.CommonActions;
import pageobjects.settings.SettingsPage;
import pageobjects.settings.WorkflowExecutionTaskPage;
import pageobjects.settings.WorkflowPage;

public class TestSuite_WorkflowSettings extends BaseTestClass {
    CommonActions commonActions = CommonActions.getInstance();
    WorkflowExecutionTaskPage workflowExecutionTaskPage = WorkflowExecutionTaskPage.getInstance();
    SettingsPage settingsPage = SettingsPage.getInstance();
    private void coverJourneyTillExecutionTask() {
        commonActions.coverJourneyTillSettings();
        settingsPage.click_Workflow_Link();
        WorkflowPage.getInstance().click_ExecutionTask_Link();
    }
}
