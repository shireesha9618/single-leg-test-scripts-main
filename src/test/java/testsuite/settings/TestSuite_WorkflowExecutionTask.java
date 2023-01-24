package testsuite.settings;

import api.ApiClient;
import base.BaseTestClass;
import constants.TestGroup;
import framework.backend.APIResponseException;
import framework.common.assertion.JarvisSoftAssert;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.settings.*;

import java.util.Collections;
import java.util.List;

public class TestSuite_WorkflowExecutionTask extends BaseTestClass {
    WorkflowExecutionTaskPage workflowExecutionTaskPage = WorkflowExecutionTaskPage.getInstance();
    WorkflowExecutionTaskEditReasonPage workflowExecutionTaskEditReasonPage = WorkflowExecutionTaskEditReasonPage.getInstance();
    WorkflowExecutionTaskStartPage workflowExecutionTaskStartPage = WorkflowExecutionTaskStartPage.getInstance();
    CommonActions commonActions = CommonActions.getInstance();

    private void coverJourneyTillJobExecutionTask() {
        commonActions.coverJourneyTillSettings();
        SettingsPage.getInstance().click_Workflow_Link();
        WorkflowPage.getInstance().click_ExecutionTask_Link();
    }
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ET_WORKFLOW, TestGroup.BVT},
            description = "TC_001, To Verify Functionality To View And Edit The List Of Allowed Reason Codes")
    public void TC_JobWorkflowSettings_001_To_Verify_Functionality_To_View_And_Edit_The_List_Of_Allowed_Reason_Codes() throws APIResponseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobExecutionTask();
        List<String> expectedReasonCodes = ApiClient.getReasonList();
        workflowExecutionTaskPage.click_StartMenuCardEditReason_Btn();

        List<String> actualSuccessReasonCode = workflowExecutionTaskEditReasonPage.getTextList_successReasonCode_List();
        for(int i=0; i< actualSuccessReasonCode.size(); i++) {
            for(int j=0; j< expectedReasonCodes.size(); j++){
                if(actualSuccessReasonCode.get(i) == expectedReasonCodes.get(j))
                    softAssert.assertTrue(actualSuccessReasonCode.get(i).equals(expectedReasonCodes.get(j)), "Success Reason Code Is Present As Expected");
            }
        }

        List<String> actualEditReasonCode = workflowExecutionTaskEditReasonPage.getTextList_FailureReasonCode_List();
        for(int i=0; i< actualEditReasonCode.size(); i++) {
            for(int j=0; j< expectedReasonCodes.size(); j++){
                if(actualEditReasonCode.get(i) == expectedReasonCodes.get(j))
                    softAssert.assertTrue(actualEditReasonCode.get(i).equals(expectedReasonCodes.get(j)), "Failure Reason Code Is Present As Expected");
            }
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ET_WORKFLOW, TestGroup.BVT},
            description = "TC_002, To Verify The UI For Execution Task Page")
    public void TC_JobWorkflowSettings_002_To_Verify_The_UI_For_Execution_Task_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobExecutionTask();

        softAssert.assertTrue(workflowExecutionTaskPage.isPresent_ExecutionTaskHeader_Lbl(), "Execution Task Header Is Present As Expected");
        softAssert.assertEquals(workflowExecutionTaskPage.getText_ExecutionTaskHeader_Lbl(), "Execution Tasks", "Execution task Header Label Is Matched As Expected");
        softAssert.assertTrue(workflowExecutionTaskPage.isPresent_Search_Txt(), "Search Bar Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskPage.isPresent_StartMenuCard_Link(), "Start Menu Card Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskPage.isPresent_StartMenuCardHeader_Lbl(), "Start Menu Card Header Label Is Present As Expected");
        softAssert.assertEquals(workflowExecutionTaskPage.getText_ExecutionTaskHeader_Lbl(), "Start", "Start Header Label Is Matched As Expected");
        softAssert.assertTrue(workflowExecutionTaskPage.isPresent_StartMenuCardEditReason_Btn(), "Edit Reasons Button Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskPage.isPresent_CardMenu_List(), "Card Menu List Is Present As Expected");
        softAssert.assertEquals(workflowExecutionTaskPage.getTextList_CardMenu_List().size(), 15, "Total Card Menu Option Counts 15 As Expected");

        softAssert.assertAll();
    }
}
