package testsuite.settings;

import base.BaseTestClass;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.settings.JobWorkflowPage;
import pageobjects.settings.SettingsPage;
import pageobjects.settings.WorkflowPage;

public class TestSuite_SettingJobWorkflow extends BaseTestClass {
    JobWorkflowPage jobWorkflowPage = JobWorkflowPage.getInstance();
    CommonActions commonActions = CommonActions.getInstance();

    private void coverJourneyTillJobWorkflow() {
        commonActions.coverJourneyTillSettings();
        SettingsPage.getInstance().click_Workflow_Link();
        WorkflowPage.getInstance().click_JobWorkflow_Link();
    }
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_001, Verify The UI Of Job")
    public void TC_Facility_001_Verify_The_UI_Of_Job() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        softAssert.assertTrue(jobWorkflowPage.isPresent_JobWorkflowsHeader_Lbl(), "Job Workflow Header Label Is present As Expected");
        softAssert.assertEquals(jobWorkflowPage.getText_JobWorkflowsHeader_Lbl(), "Job Workflows", "Job Workflows Header Label Is Matched As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_JobWorkflowsBreadCrumb_Link(), "Jobs Workflow Bread Crumb Link Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_Search_Text(), "Search Text Field Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_Create_Btn(), "Create Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isEnabled_Create_Btn(), "Create Button Is Enabled As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_Active_Btn(), "Active Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_Draft_Btn(), "Draft Button Is Present As Expected");

        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnName_Lbl(), "Table Column Name Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnDescription_Lbl(), "Table Column Description Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnStatus_Lbl(), "Table Column Status Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnProductType_Lbl(), "Table Column Product Type Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnShipmentflow_Lbl(), "Table Column Shipment Flow Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnPlanningMode_Lbl(), "Table Column Planning Mode Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnCreatedBy_Lbl(), "Table Column Created By Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnUpdatedOn_Lbl(), "Table Column Updated On Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnUpdatedBy_Lbl(), "Table Column Updated By Is Present As Expected");

        softAssert.assertTrue(commonActions.isPresent_PageSize_Txt(), "Page Size Text Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_PaginationNext_Btn(), "Pagination Next Button Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_PaginationPrevious_Btn(), "Pagination Previous Button Is Present As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_002, Verify The UI Of Create Button")
    public void TC_Facility_002_Verify_The_UI_Of_Create_Button() {

    }
}
