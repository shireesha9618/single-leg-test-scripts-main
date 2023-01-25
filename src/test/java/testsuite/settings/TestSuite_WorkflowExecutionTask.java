package testsuite.settings;

import api.ApiClient;
import base.BaseTestClass;
import constants.TestGroup;
import framework.backend.APIResponseException;
import framework.common.assertion.JarvisSoftAssert;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.settings.*;

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
        commonActions.waitTillLoaderDisappears();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ET_WORKFLOW, TestGroup.BVT},
            description = "TC_001, To Verify Functionality To View And Edit The List Of Allowed Reason Codes")
    public void TC_JobWorkflowSettings_001_To_Verify_Functionality_To_View_And_Edit_The_List_Of_Allowed_Reason_Codes() throws APIResponseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobExecutionTask();
        List<String> expectedReasonCodes = ApiClient.getReasonList();
        workflowExecutionTaskPage.click_StartMenuCardEditReason_Btn();

        List<String> actualSuccessReasonCode = workflowExecutionTaskEditReasonPage.getTextList_SuccessReasonCode_List();
        for (int i = 0; i < actualSuccessReasonCode.size(); i++) {
            for (int j = 0; j < expectedReasonCodes.size(); j++) {
                if (actualSuccessReasonCode.get(i) == expectedReasonCodes.get(j))
                    softAssert.assertTrue(actualSuccessReasonCode.get(i).equals(expectedReasonCodes.get(j)), "Success Reason Code Is Present As Expected");
            }
        }

        List<String> actualEditReasonCode = workflowExecutionTaskEditReasonPage.getTextList_FailureReasonCode_List();
        for (int i = 0; i < actualEditReasonCode.size(); i++) {
            for (int j = 0; j < expectedReasonCodes.size(); j++) {
                if (actualEditReasonCode.get(i) == expectedReasonCodes.get(j))
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
        softAssert.assertEquals(workflowExecutionTaskPage.getText_StartMenuCardHeader_Lbl(), "Start", "Start Header Label Is Matched As Expected");
        softAssert.assertTrue(workflowExecutionTaskPage.isPresent_StartMenuCardEditReason_Btn(), "Edit Reasons Button Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskPage.isPresent_CardMenu_List(), "Card Menu List Is Present As Expected");
        softAssert.assertEquals(workflowExecutionTaskPage.getTextList_CardMenu_List().size(), 15, "Total Card Menu Option Counts 15 As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ET_WORKFLOW, TestGroup.BVT},
            description = "TC_003, To Verify The UI For Execution Task Table")
    public void TC_JobWorkflowSettings_003_To_Verify_The_UI_For_Execution_Task_Table() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobExecutionTask();
        workflowExecutionTaskPage.click_StartMenuCardEditReason_Btn();
        softAssert.assertTrue(workflowExecutionTaskEditReasonPage.isPresent_EditReasonHeader_Lbl(), "Edit Reason Header Label Is Present As Expected");
        softAssert.assertEquals(workflowExecutionTaskEditReasonPage.getText_EditReasonHeader_Lbl(), "Edit Reason(s)", "Edit Reason Header Label Is Matched As Expected");
        softAssert.assertTrue(workflowExecutionTaskEditReasonPage.isPresent_ExecutionTask_Lbl(), "Execution Task Label Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskEditReasonPage.isPresent_SuccessReasonCodes_Lbl(), "Success Reason Codes Label Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskEditReasonPage.isPresent_SuccessReasonCode_List(), "Success Reason Codes List Label Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskEditReasonPage.isPresent_FailureReasonCode_Lbl(), "Failure Reason Codes Label Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskEditReasonPage.isPresent_FailureReasonCode_List(), "Failure Reason Codes List Label Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ET_WORKFLOW, TestGroup.BVT},
            description = "TC_004, To Verify The UI For Execution Task Page")
    public void TC_JobWorkflowSettings_004_To_Verify_The_UI_For_ET_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobExecutionTask();
        workflowExecutionTaskPage.click_StartMenuCard_Link();

        softAssert.assertTrue(workflowExecutionTaskStartPage.isPresent_ExecutionTaskDetailHeader_Lbl(), "Execution Task Start Header Is Present As Expected");
        softAssert.assertEquals(workflowExecutionTaskStartPage.getText_ExecutionTaskDetailHeader_Lbl(), "Start", "Start Header Is Matched As Expected");
        softAssert.assertTrue(workflowExecutionTaskStartPage.isPresent_CreatedOn_Lbl(), "Created On Label Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskStartPage.isPresent_CreatedOnData_Lbl(), "Created On Date Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskStartPage.isPresent_UpdatedOn_Lbl(), "Updated On Label Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskStartPage.isPresent_UpdatedOnData_Lbl(), "Updated On Date Is Present As Expected");

        softAssert.assertTrue(workflowExecutionTaskStartPage.isPresent_AboutSubHeader_Lbl(), "About Sub Header Label Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskStartPage.isPresent_Description_Lbl(), "Description Label Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskStartPage.isPresent_ReasonCodeSubHeader_Lbl(), "Reason Sub Header Label Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskStartPage.isPresent_Description_Lbl(), "Description Label Is Matched As Expected");
        softAssert.assertTrue(workflowExecutionTaskStartPage.isPresent_ReasonCodeSubHeader_Lbl(), "Reason Code Sub Header Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskStartPage.isPresent_ReasonCodeSubHeaderSuccessList_Lbl(), "Success Reason Code Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskStartPage.isPresent_ReasonCodeSubHeaderFailureList_Lbl(), "Failure Reason Code Is Present As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ET_WORKFLOW, TestGroup.BVT},
            description = "TC_005, To Verify The UI For Edit Reasons Page")
    public void TC_JobWorkflowSettings_005_To_Verify_The_UI_For_Edit_Reasons_Page() throws APIResponseException {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobExecutionTask();
        workflowExecutionTaskPage.click_PickMenuCardEditReason_Btn();
        List<String> expectedReasonCodes = ApiClient.getReasonList();

        softAssert.assertTrue(workflowExecutionTaskEditReasonPage.isPresent_EditReasonHeader_Lbl(), "Edit Reason Header Label Is Present As Expected");
        softAssert.assertEquals(workflowExecutionTaskEditReasonPage.getText_EditReasonHeader_Lbl(), "Edit Reason(s)", "Edit Reason Header Label Is Matched As Expected");
        softAssert.assertTrue(workflowExecutionTaskEditReasonPage.isPresent_ExecutionTask_Lbl(), "Execution Task Label Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskEditReasonPage.isPresent_SuccessReasonCodes_Lbl(), "Success Reason Codes Label Is Present As Expected");
        softAssert.assertTrue(workflowExecutionTaskEditReasonPage.isPresent_FailureReasonCode_Lbl(), "Failure Reason Codes Label Is Present As Expected");

        List<String> actualSuccessReasonCode = workflowExecutionTaskEditReasonPage.getTextList_SuccessReasonCode_List();
        for (int i = 0; i < actualSuccessReasonCode.size(); i++) {
            for (int j = 0; j < expectedReasonCodes.size(); j++) {
                if (actualSuccessReasonCode.get(i) == expectedReasonCodes.get(j))
                    softAssert.assertTrue(actualSuccessReasonCode.get(i).equals(expectedReasonCodes.get(j)), "Success Reason Code Is Present As Expected");
            }
        }

        List<String> actualEditReasonCode = workflowExecutionTaskEditReasonPage.getTextList_FailureReasonCode_List();
        for (int i = 0; i < actualEditReasonCode.size(); i++) {
            for (int j = 0; j < expectedReasonCodes.size(); j++) {
                if (actualEditReasonCode.get(i) == expectedReasonCodes.get(j))
                    softAssert.assertTrue(actualEditReasonCode.get(i).equals(expectedReasonCodes.get(j)), "Failure Reason Code Is Present As Expected");
            }
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ET_WORKFLOW, TestGroup.BVT},
            description = "TC_006, To Verify The Back Button Functionality On Edit Reasons Page")
    public void TC_JobWorkflowSettings_006_To_Verify_The_Back_Button_Functionality_On_Edit_Reasons_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobExecutionTask();
        String expectedExecutionTaskHeader = workflowExecutionTaskPage.getText_ExecutionTaskHeader_Lbl();
        String expectedURl = commonActions.getCurrentPageUrl();
        workflowExecutionTaskPage.click_PickMenuCardEditReason_Btn();
        softAssert.assertTrue(!workflowExecutionTaskEditReasonPage.getText_EditReasonHeader_Lbl().equals(expectedExecutionTaskHeader), "Header Label Didn't Matched As Expected");
        softAssert.assertTrue(!commonActions.getCurrentPageUrl().equals(expectedURl), "URL Is Different As Expected");
        workflowExecutionTaskEditReasonPage.click_Back_Btn();
        softAssert.assertEquals(workflowExecutionTaskPage.getText_ExecutionTaskHeader_Lbl(), expectedExecutionTaskHeader, "Execution Task Header Is Matched As Expected");
        softAssert.assertEquals(commonActions.getCurrentPageUrl(), expectedURl, "Current URL Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(enabled = false, groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ET_WORKFLOW, TestGroup.BVT},
            description = "TC_007, To Verify The Save Button Functionality On Edit Reasons Page")
    public void TC_JobWorkflowSettings_007_To_Verify_The_Save_Button_Functionality_On_Edit_Reasons_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobExecutionTask();
        workflowExecutionTaskPage.click_PickMenuCardEditReason_Btn();
        List<String> editReasonCode = workflowExecutionTaskEditReasonPage.getTextList_SuccessReasonCode_List();
        workflowExecutionTaskEditReasonPage.click_ReasonCodeCross_Icon();
        workflowExecutionTaskEditReasonPage.click_Save_Btn();
        softAssert.assertTrue(commonActions.isPresent_PopUpValidationMsg_Lbl(), "Success Validation Message Is Present As Expected");
        commonActions.waitTillLoaderDisappears();
        softAssert.assertEquals(workflowExecutionTaskPage.getText_ExecutionTaskHeader_Lbl(), "Execution Tasks", "Execution Task Page Is Directed And Header Is Matched As Expected");

        workflowExecutionTaskPage.click_PickMenuCardEditReason_Btn();
        softAssert.assertTrue(workflowExecutionTaskEditReasonPage.getTextList_SuccessReasonCode_List().size() != editReasonCode.size(), "List Of Reason Is Not Same As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ET_WORKFLOW, TestGroup.BVT},
            description = "TC_011, To Verify Functionality Of Search Bar With Valid And Invalid ET")
    public void TC_JobWorkflowSettings_011_To_Verify_Functionality_Of_Search_Bar_With_Valid_And_Invalid_ET() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobExecutionTask();
        String expectedValidET = "Pick";
        String invalidET = "abcd";

        workflowExecutionTaskPage.fill_Search_Txt(expectedValidET);
        softAssert.assertEquals(workflowExecutionTaskPage.getTextList_CardMenu_List().get(0), expectedValidET, "Execution Task Appeared On Searching As Expected");

        workflowExecutionTaskPage.fill_Search_Txt(invalidET);
        softAssert.assertEquals(workflowExecutionTaskPage.getTextList_CardMenu_List().size(), 0, "Execution Task Didn't Appeared On Searching As Expected");
        softAssert.assertTrue(workflowExecutionTaskPage.isPresent_ExecutionTaskValidationMsg_Lbl(), "Execution Task Validation Message Is Displayed As Expected");
        softAssert.assertEquals(workflowExecutionTaskPage.getText_ExecutionTaskValidationMsg_Lbl(), "No Execution Tasks found", "Validation Message Is Matched As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.ET_WORKFLOW, TestGroup.BVT},
            description = "TC_014, To Verify The Count Of ET Available")
    public void TC_JobWorkflowSettings_014_To_Verify_The_Count_Of_ET_Available() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobExecutionTask();
        softAssert.assertEquals(workflowExecutionTaskPage.getTextList_CardMenu_List().size(), 15, "Total Execution Task Counts 15 As Expected");
        softAssert.assertAll();
    }
}
