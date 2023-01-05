package testsuite.settings;

import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.settings.*;
import utility.Utility;

import java.util.List;

public class TestSuite_SettingJobWorkflow extends BaseTestClass {
    JobWorkflowPage jobWorkflowPage = JobWorkflowPage.getInstance();
    CommonActions commonActions = CommonActions.getInstance();
    JobWorkflowCreatePreviewPage jobWorkflowCreatePreviewPage = JobWorkflowCreatePreviewPage.getInstance();
    JobWorkflowCreatePage jobWorkflowCreatePage = JobWorkflowCreatePage.getInstance();
    Faker sampleData = new Faker();

    private void coverJourneyTillJobWorkflow() {
        commonActions.coverJourneyTillSettings();
        SettingsPage.getInstance().click_Workflow_Link();
        WorkflowPage.getInstance().click_JobWorkflow_Link();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_001, Verify The UI Of Job")
    public void TC_JobWorkflowSettings_001_Verify_The_UI_Of_Job() {
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
    public void TC_JobWorkflowSettings_002_Verify_The_UI_Of_Create_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Create_Btn();
        jobWorkflowCreatePreviewPage.click_NewWorkflow_Link();
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_NewJobWorkflowHeader_Lbl(), "New Job Workflow Header Label Is Present As Expected");
        softAssert.assertEquals(jobWorkflowCreatePage.getText_NewJobWorkflowHeader_Lbl(), "New Job Workflow", "New Job Workflow Header Label Is Matched As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_JobWorkflowCreateBreadCrumb_Link(), "Job Workflow Create BreadCrumb Link Is Present As Expected");

        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_WorkflowName_Lbl(), "Workflow Name Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_WorkflowName_Txt(), "Workflow Name Text Field Is Present As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_WorkflowDescription_Lbl(), "Workflow Description Label Name Is Present As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_WorkflowDescription_Txt(), "Workflow Description Text Field Is Present As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_JobWorkType_Lbl(), "Job Work Type Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_JobWorkType_Txt(), "Job Work Type Text Field Is Present As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isDisabled_JobWorkType_Txt(), "Job Work Type Text Field Is Disabled As Expected");

        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_OtherAttributesSubHeader_Lbl(), "Other Attributes Sub Header Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_ProductType_Lbl(), "Product Type Label Name Is Present As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_ProductType_Txt(), "Product Type Text Field Is Present As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_ShipmentFlow_Lbl(), "Shipment Flow Label Name Is Present As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_ShipmentFlow_Txt(), "Shipment Flow Text Field Is Present As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_Back_Btn(), "Back Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_Create_Btn(), "Create Button Is Present As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_003, Verify The Functionality Of Filter The Jobs With Active Status")
    public void TC_JobWorkflowSettings_003_Verify_The_Functionality_Of_Filter_The_Jobs_With_Active_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Create_Btn();
        jobWorkflowCreatePreviewPage.click_StatusActive_RadioBtn();
        List<String> statusList = jobWorkflowCreatePreviewPage.getText_CardMenuStatus_List();
        for(String status : statusList) {
            softAssert.assertEquals(status, "Active", "Active Status Is Appeared As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_004, Verify The Functionality Of Filter The Jobs With Draft Status ")
    public void TC_JobWorkflowSettings_004_Verify_The_Functionality_Of_Filter_The_Jobs_With_Draft_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Create_Btn();
        jobWorkflowCreatePreviewPage.click_StatusDraft_RadioBtn();
        List<String> statusList = jobWorkflowCreatePreviewPage.getText_CardMenuStatus_List();
        for(String status : statusList) {
            softAssert.assertEquals(status, "Draft", "Active Status Is Appeared As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_005, Verify The Functionality Of Clear Selection Button In Status")
    public void TC_JobWorkflowSettings_005_Verify_The_Functionality_Of_Clear_Selection_Button_In_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Create_Btn();
        jobWorkflowCreatePreviewPage.click_StatusDraft_RadioBtn();
        List<String> draftStatusList = jobWorkflowCreatePreviewPage.getText_CardMenuStatus_List();
        jobWorkflowCreatePreviewPage.click_StatusClearSelection_Btn();
        List<String> statusList = jobWorkflowCreatePreviewPage.getText_CardMenuStatus_List();
        for(int i = 0; i < statusList.size(); i++) {
            if(!draftStatusList.get(i).equals(statusList.get(i))) {
                softAssert.assertTrue(!draftStatusList.get(i).equals(statusList.get(i)), "Status Is Different On Clear Selection As Expected");
            }
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_006, Verify The Functionality Of Back Button In New Job Workflow Page")
    public void TC_JobWorkflowSettings_006_Verify_The_Functionality_Of_Back_Button_In_New_Job_Workflow_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Create_Btn();
        String expectedCreatePreviewHeader = jobWorkflowCreatePreviewPage.getText_CreatePreviewHeader_Lbl();
        String expectedCurrentURL = commonActions.getCurrentPageUrl();

        jobWorkflowCreatePreviewPage.click_NewWorkflow_Link();
        softAssert.assertEquals(jobWorkflowCreatePage.getText_NewJobWorkflowHeader_Lbl(), "New Job Workflow", "New Job Workflow Header Label Is Matched As Expected");

        jobWorkflowCreatePage.click_Back_Btn();
        softAssert.assertEquals(jobWorkflowCreatePreviewPage.getText_CreatePreviewHeader_Lbl(), expectedCreatePreviewHeader, "Create Preview Header Label Is Matched As Expected");
        softAssert.assertTrue(commonActions.getCurrentPageUrl().equals(expectedCurrentURL), "Current Page URL Is Matched As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_007, Verify The Validation Functionality Of Create Button In New Job Workflow Page For Empty Field")
    public void TC_JobWorkflowSettings_007_Verify_The_Validation_Functionality_Of_Create_Button_In_New_Job_Workflow_Page_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Create_Btn();
        jobWorkflowCreatePreviewPage.click_NewWorkflow_Link();
        jobWorkflowCreatePage.click_Create_Btn();

        softAssert.assertEquals(jobWorkflowCreatePage.getText_NewJobWorkflowHeader_Lbl(), "New Job Workflow", "New Job Workflow Header Is Matched As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_WorkflowNameValidationMsg_Lbl(), "Work Flow Name Validation Message Appeared As Expected");
        softAssert.assertEquals(jobWorkflowCreatePage.getText_WorkflowNameValidationMsg_Lbl(), "Required", "Work Flow Name Required Validation Message Matched As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_ProductTypeValidationMsg_Lbl(), "Product Type Validation Message Appeared As Expected");
        softAssert.assertEquals(jobWorkflowCreatePage.getText_ProductTypeValidationMsg_Lbl(), "Required", "Product Type Required Validation Message Matched As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_ShipmentFlowValidationMsg_Lbl(), "Shipment Flow Validation Message Appeared As Expected");
        softAssert.assertEquals(jobWorkflowCreatePage.getText_ShipmentFlowValidationMsg_Lbl(), "Required", "Shipment Flow Validation Message Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_008, Verify The Validation Functionality New Job Workflow Page For Invalid DropDown")
    public void TC_JobWorkflowSettings_008_Verify_The_Validation_Functionality_New_Job_Workflow_Page_For_Invalid_DropDown() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Create_Btn();
        jobWorkflowCreatePreviewPage.click_NewWorkflow_Link();

        jobWorkflowCreatePage.fill_ShipmentFlow_Txt(sampleData.name().lastName());
        jobWorkflowCreatePage.fill_ProductType_Txt(sampleData.name().firstName());
        jobWorkflowCreatePage.click_Create_Btn();

        softAssert.assertEquals(jobWorkflowCreatePage.getText_ProductTypeValidationMsg_Lbl(), "Required", "Product Type Required Validation Message Appeared As Expected");
        softAssert.assertEquals(jobWorkflowCreatePage.getText_ShipmentFlowValidationMsg_Lbl(), "Required", "Shipment Flow Required Validation Message Appeared As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_009, Verify The Validation Functionality Of Workflow Name And Description In New Job Workflow Page For Maximum And Special Character Limit")
    public void TC_JobWorkflowSettings_009_Verify_The_Validation_Functionality_Of_Workflow_Name_And_Description_In_New_Job_Workflow_Page_For_And_Special_Character_Limit() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Create_Btn();
        jobWorkflowCreatePreviewPage.click_NewWorkflow_Link();

        String[] sampleData = {"@@#@@@", "^&&8976", "!$4"};
        for(String sample : sampleData) {
            jobWorkflowCreatePage.fill_WorkflowName_Txt(sample);
            jobWorkflowCreatePage.click_Create_Btn();
            softAssert.assertTrue(jobWorkflowCreatePage.isPresent_WorkflowNameValidationMsg_Lbl(), "Work Flow Name Incorrect Format Validation Message Appeared As Expected");
            softAssert.assertEquals(jobWorkflowCreatePage.getText_WorkflowNameValidationMsg_Lbl(), "Not correct format", "Work Flow Name Incorrect Format Validation Message Matched As Expected");
        }

        jobWorkflowCreatePage.fill_WorkflowName_Txt(Utility.generateRandomString(30));
        jobWorkflowCreatePage.fill_WorkflowDescription_Txt(Utility.generateRandomString(160));
        jobWorkflowCreatePage.click_Create_Btn();
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_WorkflowNameValidationMsg_Lbl(), "Work Flow Name Maximum Length Validation Message Appeared As Expected");
        softAssert.assertEquals(jobWorkflowCreatePage.getText_WorkflowNameValidationMsg_Lbl(), "Can be at max 24", "Work Flow Name Maximum Length Validation Message Appeared As Expected");
        softAssert.assertTrue(jobWorkflowCreatePage.isPresent_WorkflowDescriptionValidationMsg_Lbl(), "Work Flow Description Maximum Length Validation Message Appeared As Expected");
        softAssert.assertEquals(jobWorkflowCreatePage.getText_WorkflowDescriptionValidationMsg_Lbl(), "Can be at max 150", "Work Flow Description Maximum Length Validation Message Matched As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_010, Verify The Validation Functionality Of Create Button In New Job Workflow Page For Minimum Character Limit")
    public void TC_JobWorkflowSettings_010_Verify_The_Validation_Functionality_Of_Create_Button_In_New_Job_Workflow_Page_For_Minimum_Character_Limit() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Create_Btn();
        jobWorkflowCreatePreviewPage.click_NewWorkflow_Link();

        String[] sampleData = {"a", "abc", "bclt"};
        for(String sample : sampleData) {
            jobWorkflowCreatePage.fill_WorkflowName_Txt(sample);
            jobWorkflowCreatePage.click_Create_Btn();
            softAssert.assertTrue(jobWorkflowCreatePage.isPresent_WorkflowNameValidationMsg_Lbl(), "Work Flow Name Minimum Length Validation Message Appeared As Expected");
            softAssert.assertEquals(jobWorkflowCreatePage.getText_WorkflowNameValidationMsg_Lbl(), "Should be minimum 1", "Work Flow Name Incorrect Format Validation Message Matched As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_014, Verify The UI Of Table Present In Job Workflows Page")
    public void TC_JobWorkflowSettings_014_Verify_The_UI_Of_Table_Present_In_Job_Workflows_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnName_Lbl(), "Table Column Name Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnDescription_Lbl(), "Table Column Description Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnStatus_Lbl(), "Table Column Status Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnProductType_Lbl(), "Table Column Product Type Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnShipmentflow_Lbl(), "Table Column Shipment Flow Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnPlanningMode_Lbl(), "Table Column Planning Mode Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnCreatedBy_Lbl(), "Table Column Created By Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnUpdatedOn_Lbl(), "Table Column Updated On Is Present As Expected");
        softAssert.assertTrue(jobWorkflowPage.isPresent_TableColumnUpdatedBy_Lbl(), "Table Column Updated By Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_015, Verify The Functionality Of Search Bar In Job Workflows Page With Invalid WorkFlow Name")
    public void TC_JobWorkflowSettings_015_Verify_The_Functionality_Of_Search_Bar_In_Job_Workflows_Page_With_Invalid_WorkFlow_Name() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        jobWorkflowPage.fill_Search_Text("@##5$de");
        softAssert.assertTrue(commonActions.isPresent_EmptyTableMsg_Lbl(), "Empty Table Message Appeared As Expected");
        softAssert.assertEquals(commonActions.getText_EmptyTableMsg_Lbl(), "It is Empty here", "Empty Validation Message Is Matched As Expected");
        softAssert.assertAll();
    }
}
