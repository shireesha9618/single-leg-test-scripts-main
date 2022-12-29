package testsuite.settings;

import base.BaseTestClass;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import org.testng.annotations.Test;
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
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.EXECUTION_TASK, TestGroup.BVT},
            description = "TC_002, To Verify The UI For Execution Task")
    public void TC_Facility_002_To_Verify_The_UI_For_Execution_Task() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillExecutionTask();
        softAssert.assertTrue(workflowExecutionTaskPage.isPresent_ExecutionTaskHeader_Lbl(), "Execution Task Header Is Present As Expected");
        softAssert.assertEquals(workflowExecutionTaskPage.getText_ExecutionTaskHeader_Lbl(), "Execution Tasks", "Execution Tasks Header Label Is Matched As Expected");
        softAssert.assertTrue(workflowExecutionTaskPage.isPresent_Search_Txt(), "Search Text Field Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskPage.isPresent_StartMenuCard_Link(), "Start Menu Card Link Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskPage.isPresent_StartMenuCardHeader_Lbl(), "Start Menu Card Link Header Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskPage.isPresent_StartMenuCardEditReason_Btn(), "Start Menu Card Link Edit Reason Button Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskPage.isEnabled_StartMenuCardEditReason_Btn(), "Start Menu Card Edit Reason Button Is Enabled As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.EXECUTION_TASK, TestGroup.BVT},
            description = "TC_003, To Verify The UI For ET Table")
    public void TC_Facility_003_To_Verify_The_UI_For_ET_Table() {

    }
}
