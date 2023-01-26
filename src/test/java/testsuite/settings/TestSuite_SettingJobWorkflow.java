package testsuite.settings;

import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.TestGroup;
import framework.common.assertion.JarvisAssert;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.actions.ActionHelper;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.HomePage;
import pageobjects.settings.*;
import utility.Utility;

import java.util.HashMap;
import java.util.List;

public class TestSuite_SettingJobWorkflow extends BaseTestClass {
    JobWorkflowPage jobWorkflowPage = JobWorkflowPage.getInstance();
    CommonActions commonActions = CommonActions.getInstance();
    JobWorkflowCreatePreviewPage jobWorkflowCreatePreviewPage = JobWorkflowCreatePreviewPage.getInstance();
    JobWorkflowCreatePage jobWorkflowCreatePage = JobWorkflowCreatePage.getInstance();
    JobWorkflowActivePage jobWorkflowActivePage = JobWorkflowActivePage.getInstance();
    JobWorkflowDraftPage jobWorkflowDraftPage = JobWorkflowDraftPage.getInstance();
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

        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("NAME"), "Table Column Name Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("DESCRIPTION"), "Table Column Description Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("STATUS"), "Table Column Status Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("PRODUCT TYPE"), "Table Column Product Type Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("SHIPMENT FLOW"), "Table Column Shipment Flow Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("PLANNING MODE"), "Table Column Planning Mode Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("CREATED BY"), "Table Column Created By Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("UPDATED ON"), "Table Column Updated On Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("UPDATED BY"), "Table Column Updated By Is Present As Expected");

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
        for (String status : statusList) {
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
        for (String status : statusList) {
            softAssert.assertEquals(status, "Draft", "Active Status Is Appeared As Expected");
            softAssert.assertEquals(status, "Draft", "Draft Status Appeared As Expected");
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
        for (int i = 0; i < draftStatusList.size(); i++) {
            softAssert.assertTrue(draftStatusList.get(i).equals("Draft"), "Draft Status Appeared As Expected");
        }
        jobWorkflowCreatePreviewPage.click_StatusClearSelection_Btn();
        List<String> statusList = jobWorkflowCreatePreviewPage.getText_CardMenuStatus_List();
        for (int i = 0; i < statusList.size(); i++) {
            if (!draftStatusList.get(i).equals(statusList.get(i))) {
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
        String shipmentFlow = jobWorkflowCreatePage.getText_ShipmentFlow_Txt();
        String productType = jobWorkflowCreatePage.getText_ProductType_Txt();
        jobWorkflowCreatePage.click_Create_Btn();

        softAssert.assertEquals(shipmentFlow.length(), 0, "Invalid Data Is Not Accepted In Shipment Flow As Expected");
        softAssert.assertEquals(productType.length(), 0, "Invalid Data Is Not Accepted In Product Type As Expected");
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
        for (String sample : sampleData) {
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
        for (String sample : sampleData) {
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
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("NAME"), "Table Column Name Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("DESCRIPTION"), "Table Column Description Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("STATUS"), "Table Column Status Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("PRODUCT TYPE"), "Table Column Product Type Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("SHIPMENT FLOW"), "Table Column Shipment Flow Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("PLANNING MODE"), "Table Column Planning Mode Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("CREATED BY"), "Table Column Created By Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("UPDATED ON"), "Table Column Updated On Is Present As Expected");
        softAssert.assertTrue(commonActions.isPresent_TableColumnName_Lbl("UPDATED BY"), "Table Column Updated By Is Present As Expected");
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

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_016, Verify The Functionality Of Search Bar In Job Workflows Page With Valid WorkFlow Name")
    public void TC_JobWorkflowSettings_016_Verify_The_Functionality_Of_Search_Bar_In_Job_Workflows_Page_With_Valid_WorkFlow_Name() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        String jobWorkflowName = commonActions.getText_TableData_Lbl("NAME");
        jobWorkflowPage.fill_Search_Text(jobWorkflowName);
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("NAME"), jobWorkflowName, "Job Data Appears On Searching As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_017, Verify The Functionality Of Status Of Record Present In Active Tab")
    public void TC_JobWorkflowSettings_017_Verify_The_Functionality_Of_Status_Of_Record_Present_In_Active_Tab() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Active_Btn();
        List<String> statusList = commonActions.getTextList_TableDataList_Lbl("STATUS");
        for (String status : statusList) {
            softAssert.assertEquals(status, "Active", "Status Is Active As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_018, Verify The Functionality Of Status Of Record Present In Draft Tab")
    public void TC_JobWorkflowSettings_018_Verify_The_Functionality_Of_Status_Of_Record_Present_In_Draft_Tab() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        List<String> statusList = commonActions.getTextList_TableDataList_Lbl("STATUS");
        for (String status : statusList) {
            softAssert.assertEquals(status, "Draft", "Status Is Draft As Expected");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_019, Verify Functionality Of Next Page Pagination Button")
    public void TC_JobWorkflowSettings_019_Verify_Functionality_Of_Next_Page_Pagination_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        String firstDataWorkflow = commonActions.getText_TableData_Lbl("NAME");
        commonActions.click_PaginationNext_Btn();
        String elevenDataWorkflow = commonActions.getText_TableData_Lbl("NAME");
        softAssert.assertTrue(!firstDataWorkflow.equals(elevenDataWorkflow), "First Data And Eleventh Data Didn't Not Matched As Expected");
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(2), "Page 2 Is Selected As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_020, Verify Functionality Of Previous Page Pagination Button")
    public void TC_JobWorkflowSettings_020_Verify_Functionality_Of_Previous_Page_Pagination_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        commonActions.click_PaginationNext_Btn();
        String elevenDataWorkflow = commonActions.getText_TableData_Lbl("NAME");
        commonActions.click_PaginationPrevious_Btn();
        String firstDataWorkflow = commonActions.getText_TableData_Lbl("NAME");
        softAssert.assertTrue(!elevenDataWorkflow.equals(firstDataWorkflow), "First Data And Eleventh Data Didn't Not Matched As Expected");
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(1), "Page 1 Is Selected As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_021, Verify Functionality Of Vertically Scroll Of Job Workflow Table Using Mouse Scroll Wheel")
    public void TC_JobWorkflowSettings_021_Verify_Functionality_Of_Vertically_Scroll_Of_Job_Workflow_Table_Using_Mouse_Scroll_Wheel() {
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        List<WebElement> jobWorkflow = jobWorkflowPage.getList_DataTableColumnName_List();
        Utility.validatePageScrollDown(jobWorkflow.get(jobWorkflow.size() - 1));
        JarvisAssert.assertTrue(ActionHelper.isPresent(jobWorkflow.get(jobWorkflow.size() - 1), 2000), "Validate Last Element Is Present As Expected");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_022, Verify Vertically Scroll In Job Workflow Table Using KeyBoard")
    public void TC_JobWorkflowSettings_022_Verify_Vertically_Scroll_In_Job_Workflow_Table_Using_KeyBoard() {
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        List<WebElement> jobWorkflow = jobWorkflowPage.getList_DataTableColumnName_List();
        Utility.scrollDownUsingKeyboardKey(5);
        JarvisAssert.assertTrue(ActionHelper.isPresent(jobWorkflow.get(jobWorkflow.size() - 1), 2000), "Validate Last Element Is Present");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_023, Verify Displaying Of Job Workflow Table Records In Active Tab As Per Pagination Value")
    public void TC_JobWorkflowSettings_023_Verify_Displaying_Of_Job_Workflow_Table_Records_In_Active_Tab_As_Per_Pagination_Value() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Active_Btn();
        softAssert.assertTrue(commonActions.getText_PaginationSelectedItem_Lbl().contains("10"), "Ten Data Elements Is Selected In Pagination Value As Expected");
        commonActions.chooseNoOfRecordToBeDisplayed(5);
        softAssert.assertTrue(commonActions.getText_PaginationSelectedItem_Lbl().contains("5"), "Five Data Elements Is Selected In Pagination Value As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_024, Verify Displaying Of Job Workflow Table Records In Draft Tab As Per Pagination Value")
    public void TC_JobWorkflowSettings_024_Verify_Displaying_Of_Job_Workflow_Table_Records_In_Draft_Tab_As_Per_Pagination_Value() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        softAssert.assertTrue(commonActions.getText_PaginationSelectedItem_Lbl().contains("10"), "Ten Data Elements Is Selected In Pagination Value As Expected");
        softAssert.assertEquals(commonActions.getTextList_TableDataList_Lbl("NAME").size(), 10, "Number Of Data Displayed Counts 10 As Expected");
        commonActions.chooseNoOfRecordToBeDisplayed(20);
        softAssert.assertTrue(commonActions.getText_PaginationSelectedItem_Lbl().contains("20"), "Twenty Data Elements Is Selected In Pagination Value As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_025, Verify Functionality Of Pagination Paging Block")
    public void TC_JobWorkflowSettings_025_Verify_Functionality_Of_Pagination_Paging_Block() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        commonActions.select_PaginationBlock_Txt(2);
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(2), "Second Page Is Selected As Expected");
        commonActions.select_PaginationBlock_Txt(5);
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(5), "Fifth Page Is Selected As Expected");
        commonActions.selectPaginationBlock("4");
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(4), "First Page Is Selected As Expected");
        commonActions.selectPaginationBlock("3");
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(3), "Third Page Is Selected As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_026, Verify Functionality Of Pagination Paging Block With Next And Previous Button")
    public void TC_JobWorkflowSettings_026_Verify_Functionality_Of_Pagination_Paging_Block_With_Next_And_Previous_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        String firstJobName = commonActions.getText_TableData_Lbl("NAME");
        commonActions.click_PaginationNext_Btn();
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(2), "Page 2 Is Selected As Expected");
        commonActions.click_PaginationPrevious_Btn();
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(1), "Page 1 Is Selected As Expected");
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("NAME"), firstJobName, "First Page First Data Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_027, Verify Functionality Of Pagination Per Page With Paging Block And Next Button")
    public void TC_JobWorkflowSettings_027_Verify_Functionality_Of_Pagination_Per_Page_With_Paging_Block_And_Next_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        commonActions.click_PaginationNext_Btn();
        String EleventhJobName = commonActions.getText_TableData_Lbl("NAME");
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(2), "Page 2 Is Selected On Clicking Next As Expected");
        commonActions.click_PaginationPrevious_Btn();
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(1), "Page 1 Is Selected As Expected");
        commonActions.select_PaginationBlock_Txt(2);
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(2), "Page 2 Is Selected On Selecting 2 From Block As Expected");
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("NAME"), EleventhJobName, "Second Page First Data Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_028, Verify The UI Of Table Record Present In Active Tab")
    public void TC_JobWorkflowSettings_028_Verify_The_UI_Of_Table_Record_Present_In_Active_Tab() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Active_Btn();
        String expectedJobName = commonActions.getText_TableData_Lbl("NAME");
        commonActions.click_TableData_Link("NAME");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_JobWorkflowDetailHeader_Lbl(), "Job Workflow Detail Header Is Present As Expected");
        softAssert.assertEqualsIgnoreCase(jobWorkflowActivePage.getText_JobWorkflowDetailHeader_Lbl(), expectedJobName, "Job Workflow Detail Header Label Is Matched As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ActiveStatus_Lbl(), "Active Status Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ViewServiceAttributes_Btn(), "View Service Attributes Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_MakeACopy_Btn(), "Make A Copy Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_Deactivate_Btn(), "Deactivate Button Is Present As Expected");

        softAssert.assertTrue(jobWorkflowActivePage.isPresent_DescriptionSubHeader_Lbl(), "Description Sub Header Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_Objectives_Lbl(), "Objectives Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_Search_Txt(), "Search Text Field Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_Tags_DropDown(), "Tags Drop Down Is Present As Expected");

        softAssert.assertTrue(jobWorkflowActivePage.isPresent_Diagram_Lbl(), "Diagram Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ZoomIn_Btn(), "Zoom In Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ZoomOut_Btn(), "Zoom Out Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_Reset_Btn(), "Reset Button Is Present As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_033, Verify The Functionality Of Search Bar Of Table Record Present In Active Tab")
    public void TC_JobWorkflowSettings_033_Verify_The_Functionality_Of_Search_Bar_Of_Table_Record_Present_In_Active_Tab() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Active_Btn();
        String expectedTableData = commonActions.getText_TableData_Lbl("NAME");
        jobWorkflowPage.fill_Search_Text(expectedTableData);
        String actualTableData = commonActions.getText_TableData_Lbl("NAME");
        softAssert.assertEquals(actualTableData, expectedTableData, "Actual Job Workflow Name Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_034, Verify The Functionality Of Objective Present Below Search Bar Of Table Record Present In Active Tab Should Matched To Objective Workflows")
    public void TC_JobWorkflowSettings_034_Verify_The_Functionality_Of_Objective_Present_Below_Search_Bar_Of_Table_Record_Present_In_Active_Tab_Should_Matched_To_Objective_Workflows() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Active_Btn();
        commonActions.click_TableData_Link("NAME");
        String expectedObjectiveName = jobWorkflowActivePage.getText_ObjectiveName_Lbl();
        HomePage.getInstance().click_SettingsMenu_Btn();
        SettingsPage.getInstance().click_Workflow_Link();
        WorkflowPage.getInstance().click_ObjectiveWorkflow_Link();
        ObjectiveWorkflowsListPage.getInstance().fill_SearchBar_Txt(expectedObjectiveName);
        String actualObjectiveName = commonActions.getText_TableData_Lbl("NAME");
        softAssert.assertEquals(expectedObjectiveName, actualObjectiveName, "Objective Name Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_036, Verify The Functionality Of Cancel Button In Disable Workflow")
    public void TC_JobWorkflowSettings_036_Verify_The_Functionality_Of_Cancel_Button_In_Disable_Workflow() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Active_Btn();
        commonActions.click_TableData_Link("NAME");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_Deactivate_Btn(), "Deactivate Button Is Present As Expected");
        String expectedStatus = jobWorkflowActivePage.getText_ActiveStatus_Lbl();

        jobWorkflowActivePage.click_Deactivate_Btn();
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_PopUpWindowWorkflowAlreadyExistHeader_Lbl(), "Pop Up Window Header Is Present As Expected");
        softAssert.assertEquals(jobWorkflowActivePage.getText_PopUpWindowWorkflowAlreadyExistHeader_Lbl(), "De-activate Workflow", "Deactivate Workflow Pop Up Window Header");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_PopUpWindowDeactivate_Btn(), "Deactivate Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_PopUpWindowCancel_Btn(), "Cancel Button Is Present As Expected");

        jobWorkflowActivePage.click_PopUpWindowCancel_Btn();
        softAssert.assertEquals(jobWorkflowActivePage.getText_ActiveStatus_Lbl(), expectedStatus, "Status Is Active As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_037, Verify The Functionality Of Objective Box In Job Workflow Diagram Of Table Record Present In Active Tab")
    public void TC_JobWorkflowSettings_037_Verify_The_Functionality_Of_Objective_Box_In_Job_Workflow_Diagram_Of_Table_Record_Present_In_Active_Tab() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Active_Btn();
        commonActions.click_TableData_Link("NAME");

        jobWorkflowActivePage.click_ObjectiveDiagram_Lbl();
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ObjectiveConfiguration_Btn(), "Objective Configuration Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_Connectors_Btn(), "Connector Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ExecutionTaskWorkflowHeader_Lbl(), "Execution Tas Workflow Header Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ObjectiveConfigurationName_Lbl(), "Objective Configuration Name Label Is Present AS Expected");

        jobWorkflowActivePage.click_Connectors_Btn();
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ConnectorOne_Lbl(), "Connector 1 Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ConnectorOneDestination_Lbl(), "Connector 1 Destination Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ConnectorOneStatus_Lbl(), "Connector 1 Status Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ConnectorOneReason_Lbl(), "Connector 1 Reason Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ConnectorTwo_Lbl(), "Connector 2 Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ConnectorTwoDestination_Lbl(), "Connector 2 Destination Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ConnectorTwoStatus_Lbl(), "Connector 2 Status Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowActivePage.isPresent_ConnectorTwoReason_Lbl(), "Connector 2 Reason Label Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_038, Verify The UI Of Table Record Present In Draft Tab")
    public void TC_JobWorkflowSettings_038_Verify_The_UI_Of_Table_Record_Present_In_Draft_Tab() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        String expectedJobName = commonActions.getText_TableData_Lbl("NAME");
        commonActions.click_TableData_Link("NAME");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_JobWorkflowDetailHeader_Lbl(), "Job Workflow Detail Header Is Present As Expected");
        softAssert.assertEqualsIgnoreCase(jobWorkflowDraftPage.getText_JobWorkflowDetailHeader_Lbl(), expectedJobName, "Job Workflow Detail Header Label Is Matched As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_DraftStatus_Lbl(), "Active Status Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_ViewServiceAttributes_Btn(), "View Service Attributes Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_SaveAsDraft_Btn(), "Make A Copy Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_Validate_Btn(), "Deactivate Button Is Present As Expected");

        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_Objectives_Lbl(), "Objectives Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_Search_Txt(), "Search Text Field Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_Tags_DropDown(), "Tags Drop Down Is Present As Expected");

        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_Diagram_Lbl(), "Diagram Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_ZoomIn_Btn(), "Zoom In Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_ZoomOut_Btn(), "Zoom Out Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_Reset_Btn(), "Reset Button Is Present As Expected");

        softAssert.assertAll();
    }

    @Test(enabled = false, groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_029, Verify Functionality Of Make A Copy Button")
    public void TC_JobWorkflowSettings_029_Verify_Functionality_Of_Make_A_Copy_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Active_Btn();
        commonActions.click_TableData_Link("NAME");
        jobWorkflowActivePage.click_MakeACopy_Btn();
        String expectedJobWorkflowName = jobWorkflowCreatePage.getText_WorkflowName_Txt();
        jobWorkflowCreatePage.select_ProductType_Txt();
        jobWorkflowCreatePage.click_Create_Btn();
        jobWorkflowCreatePreviewPage.fill_Search_Txt(expectedJobWorkflowName);
        softAssert.assertEquals(jobWorkflowCreatePreviewPage.getText_CardMenuWorkflowName_Lbl(), expectedJobWorkflowName, "Expected Job Workflow Name Is Matched");
        softAssert.assertEquals(jobWorkflowCreatePreviewPage.getText_CardMenuStatus_Lbl(), "Active", "Status Is Active As Expected");
        softAssert.assertAll();
    }

    @Test(enabled = false, groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_035, Verify The Functionality Of Deactivate Button Of Table Record Present In Active Tab")
    public void TC_JobWorkflowSettings_035_Verify_The_Functionality_Of_Deactivate_Button_Of_Table_Record_Present_In_Active_Tab() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Active_Btn();
        String expectedJobWorkflowName = commonActions.getText_TableData_Lbl("NAME");
        commonActions.click_TableData_Link("NAME");
        jobWorkflowActivePage.click_Deactivate_Btn();
        jobWorkflowActivePage.click_PopUpWindowDeactivate_Btn();
        jobWorkflowCreatePreviewPage.fill_Search_Txt(expectedJobWorkflowName);
        softAssert.assertEquals(jobWorkflowCreatePreviewPage.getText_CardMenuWorkflowName_Lbl(), expectedJobWorkflowName, "Expected Job Workflow Name Is Matched");
        softAssert.assertEquals(jobWorkflowCreatePreviewPage.getText_CardMenuStatus_Lbl(), "Inactive", "Status Is Inactive As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_011, Verify The Validation Functionality Of Create Button In New Job Workflow Page For Duplicate Record")
    public void TC_JobWorkflowSettings_011_Verify_The_Validation_Functionality_Of_Create_Button_In_New_Job_Workflow_Page_For_Duplicate_Record() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Create_Btn();
        String duplicateJobWorkflow = jobWorkflowCreatePreviewPage.getText_CardMenuWorkflowName_Lbl();
        String expectedDuplicateErrorMsg = "Please use a unique name for the new workflow.";
        jobWorkflowCreatePreviewPage.click_NewWorkflow_Link();

        jobWorkflowCreatePage.fill_WorkflowName_Txt(duplicateJobWorkflow);
        jobWorkflowCreatePage.fill_WorkflowDescription_Txt(sampleData.lorem().sentence(10));
        jobWorkflowCreatePage.select_ProductType_Txt();
        jobWorkflowCreatePage.select_ShipmentFlow_Txt("None");
        jobWorkflowCreatePage.click_Create_Btn();

        softAssert.assertEquals(commonActions.getText_PopUpErrorMsg_Lbl(), expectedDuplicateErrorMsg, "Duplicate Error Appeared As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_012, Verify The Functionality Of Create Button In New Job Workflow Page")
    public void TC_JobWorkflowSettings_012_Verify_The_Functionality_Of_Create_Button_In_New_JobWorkflow_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        String validationSuccessMsg = "Job Workflow created successfully";
        jobWorkflowPage.click_Create_Btn();
        jobWorkflowCreatePreviewPage.click_NewWorkflow_Link();
        String jobWorkflowName = jobWorkflowCreatePage.fillCreateJobWorkflow().get("workflowName");
        jobWorkflowCreatePage.click_Create_Btn();
        softAssert.assertEquals(commonActions.getText_PopUpErrorMsg_Lbl(), validationSuccessMsg, "Success Message Appeared As Expected");
        softAssert.assertEqualsIgnoreCase(jobWorkflowDraftPage.getText_JobWorkflowDetailHeader_Lbl(), jobWorkflowName, "Job Workflow Header Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_013, Verify The Functionality Of Table Record Matched With Create Button Record")
    public void TC_JobWorkflowSettings_013_Verify_The_Functionality_Of_Table_Record_Matched_With_Create_Button_Record() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        String validationSuccessMsg = "Job Workflow created successfully";
        jobWorkflowPage.click_Create_Btn();
        jobWorkflowCreatePreviewPage.click_NewWorkflow_Link();
        String jobWorkflowName = jobWorkflowCreatePage.fillCreateJobWorkflow().get("workflowName");
        jobWorkflowCreatePage.click_Create_Btn();
        softAssert.assertEquals(commonActions.getText_PopUpErrorMsg_Lbl(), validationSuccessMsg, "Success Message Appeared As Expected");

        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        jobWorkflowPage.fill_Search_Text(jobWorkflowName);
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("NAME"), jobWorkflowName, "Job Workflow Name Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_042, Verify The Functionality Of Search Bar Of Table Record Present In Draft Tab")
    public void TC_JobWorkflowSettings_042_Verify_The_Functionality_Of_Search_Bar_Of_Table_Record_Present_In_Draft_Tab() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        String expectedJobWorkflowName = commonActions.getText_TableData_Lbl("NAME");
        jobWorkflowPage.fill_Search_Text(expectedJobWorkflowName);
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("NAME"), expectedJobWorkflowName, "Job Workflow Record Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_043, Verify The Functionality Of Record Present In Objective Of Job Workflow Description Page Should Matched To Objective Workflows Table Record")
    public void TC_JobWorkflowSettings_043_Verify_The_Functionality_Of_Record_Present_In_Objective_Of_Job_Workflow_Description_Page_Should_To_Objective_Workflows_Table_Record() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        commonActions.click_TableData_Link("NAME");
        String expectedObjectiveName = jobWorkflowActivePage.getText_ObjectiveName_Lbl();
        HomePage.getInstance().click_SettingsMenu_Btn();
        SettingsPage.getInstance().click_Workflow_Link();
        WorkflowPage.getInstance().click_ObjectiveWorkflow_Link();
        ObjectiveWorkflowsListPage.getInstance().fill_SearchBar_Txt(expectedObjectiveName);
        String actualObjectiveName = commonActions.getText_TableData_Lbl("NAME");
        softAssert.assertEquals(expectedObjectiveName, actualObjectiveName, "Objective Name Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_051, Verify The UI Of Save As Draft Button In Job Workflow Description Page")
    public void TC_JobWorkflowSettings_051_Verify_The_UI_Of_Save_As_Draft_Button_In_Job_Workflow_Description_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        commonActions.click_TableData_Link("NAME");
        jobWorkflowDraftPage.click_SaveAsDraft_Btn();
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_SaveAsDraftPopUp_Btn(), "Save As Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_CancelPopUp_Btn(), "Cancel Button Is Present As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_052, Verify The Functionality Of Cancel Button In Save As Draft Tab")
    public void TC_JobWorkflowSettings_052_Verify_The_Functionality_Of_Cancel_Button_In_Save_As_Draft_Tab() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        commonActions.click_TableData_Link("NAME");
        String expectedJobWorkflowName = jobWorkflowDraftPage.getText_JobWorkflowDetailHeader_Lbl();
        jobWorkflowDraftPage.click_SaveAsDraft_Btn();
        jobWorkflowDraftPage.click_CancelPopUp_Btn();
        softAssert.assertEquals(jobWorkflowDraftPage.getText_JobWorkflowDetailHeader_Lbl(), expectedJobWorkflowName, "Job Workflow Name Is Matched As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_055, Verify The UI Of View Service Attributes Button In Job Workflow Description Page")
    public void TC_JobWorkflowSettings_055_Verify_The_UI_Of_View_Service_Attributes_Button_In_Job_Workflow_Description_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        commonActions.click_TableData_Link("NAME");
        jobWorkflowDraftPage.click_ViewServiceAttributes_Btn();

        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_ServiceAttributeHeader_Lbl(), "Service Attributes Header Label Is Matched As Expected");
        softAssert.assertEquals(jobWorkflowDraftPage.getText_ServiceAttributeHeader_Lbl(), "Service Attributes", "Service Attributes Header Label Is Matched As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_ServiceAttributeDoorStepAttributeSubHeader_Lbl(), "Door Step Attributes Sub Header Is Present As Expected");
        softAssert.assertEquals(jobWorkflowDraftPage.getText_ServiceAttributeDoorStepAttributeSubHeader_Lbl(), "Doorstep Attributes", "Doorstep Attributes Sub Header Label Is Matched As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_DoorStepAttributeKYCVerification_Lbl(), "KYC Verification Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_DoorStepAttributeKYCVerification_Txt(), "KYC Verification Data Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_DoorStepAttributeOTPVerification_Lbl(), "OTP Verification Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_DoorStepAttributeOTPVerification_Txt(), "OTP Verification Data Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_DoorStepAttributeQCVerification_Lbl(), "QC Verification Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_DoorStepAttributeQCVerification_Txt(), "QC Verification Data Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_DoorStepAttributeSignatureCollection_Lbl(), "Signature Collection Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_DoorStepAttributeSignatureCollection_Txt(), "Signature Collections Data Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_DoorStepAttributePaymentOption_Lbl(), "Payment Option Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_DoorStepAttributePaymentOption_Txt(), "Payment Option Data Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_DoorStepAttributePaymentType_Lbl(), "Payment Type Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_DoorStepAttributePaymentType_Txt(), "Payment Type Data Is Present As Expected");

        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_ServiceAttributeOrderAttributeSubHeader_Lbl(), "Order Attribute Sub Header Is Present As Expected");
        softAssert.assertEquals(jobWorkflowDraftPage.getText_ServiceAttributeOrderAttributeSubHeader_Lbl(), "Order Attributes", "Order Attributes Sub Header Label Is Matched As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_OrderAttributePlanningMode_Lbl(), "Planning Mode Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_OrderAttributePlanningMode_Txt(), "Planning Mode Data Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_OrderAttributeProductType_Lbl(), "Product Type Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_OrderAttributeProductType_Txt(), "Product Type Data Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_OrderAttributeShipmentFlow_Lbl(), "Shipment Flow Label Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_OrderAttributeShipmentFlow_Txt(), "Shipment Flow Data Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_ServiceAttributeBack_Btn(), "Back Button Is Present As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_056, Verify The Functionality Of Back Button In Service Attributes Page")
    public void TC_JobWorkflowSettings_056_Verify_The_Functionality_Of_Back_Button_In_Service_Attributes_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        commonActions.click_TableData_Link("NAME");
        String expectedJobWorkflowName = jobWorkflowDraftPage.getText_JobWorkflowDetailHeader_Lbl();
        jobWorkflowDraftPage.click_ViewServiceAttributes_Btn();
        jobWorkflowDraftPage.click_ServiceAttributeBack_Btn();
        softAssert.assertEquals(jobWorkflowDraftPage.getText_JobWorkflowDetailHeader_Lbl(), expectedJobWorkflowName, "User Is Direct To Description Page As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_057, Verify The Functionality Of Create Button Record Matched With Service Attributes Page")
    public void TC_JobWorkflowSettings_057_Verify_The_Functionality_Of_Create_Button_Record_Matched_With_Service_Attributes_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Create_Btn();
        jobWorkflowCreatePreviewPage.click_NewWorkflow_Link();
        HashMap<String, String> fillJobWorkflow = new HashMap<>(jobWorkflowCreatePage.fillCreateJobWorkflow());
        HashMap<String, String> getDetailJobWorkflow = new HashMap<>(jobWorkflowCreatePage.getDetail_JobWorkflow());
        jobWorkflowCreatePage.click_Create_Btn();
        softAssert.assertEqualsIgnoreCase(getDetailJobWorkflow.get("workflowName"), jobWorkflowDraftPage.getText_JobWorkflowDetailHeader_Lbl(), "Job Workflow Header Is Matched As Expected");

        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        jobWorkflowPage.fill_Search_Text(fillJobWorkflow.get("workflowName"));
        commonActions.click_TableData_Link("NAME");

        jobWorkflowDraftPage.click_ViewServiceAttributes_Btn();
        softAssert.assertEquals(jobWorkflowDraftPage.getText_DoorStepAttributeSignatureCollection_Txt(), getDetailJobWorkflow.get("signatureCollection"), "Signature Collection Is Enabled As Expected");
        softAssert.assertEquals(jobWorkflowDraftPage.getText_DoorStepAttributePaymentOption_Txt(), getDetailJobWorkflow.get("paymentOption"), "Payment Option Data Is Matched As Expected");
        softAssert.assertEquals(jobWorkflowDraftPage.getText_DoorStepAttributePaymentType_Txt(), getDetailJobWorkflow.get("paymentType"), "Payment Type Data Is Matched As Expected");
        softAssert.assertEquals(jobWorkflowDraftPage.getText_OrderAttributeProductType_Txt(), getDetailJobWorkflow.get("productType"), "Product Type Data Is Matched As Expected");
        softAssert.assertEquals(jobWorkflowDraftPage.getText_OrderAttributeShipmentFlow_Txt(), getDetailJobWorkflow.get("shipmentFlow"), "Shipment Flow Data Is Matched As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_058, Verify The UI Of Validate Button")
    public void TC_JobWorkflowSettings_058_Verify_The_UI_Of_Validate_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        commonActions.click_TableData_Link("NAME");
        jobWorkflowDraftPage.click_Validate_Btn();
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_Close_Btn(), "Close Button Appear On Pop As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_Dismiss_Btn(), "Dismiss Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_ValidationMessagePopUp_Lbl(), "Validation Message On The Pop Up Appeared As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_059, Verify Functionality Of Close Button In Error Validation Message Popup")
    public void TC_JobWorkflowSettings_059_Verify_Functionality_Of_Close_Button_In_Error_Validation_Message_Popup() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        commonActions.click_TableData_Link("NAME");

        jobWorkflowDraftPage.click_Validate_Btn();
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_Close_Btn(), "Close Button Appear On Pop As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_Dismiss_Btn(), "Dismiss Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_ValidationMessagePopUp_Lbl(), "Validation Message On The Pop Up Appeared As Expected");

        jobWorkflowDraftPage.click_Close_Btn();
        softAssert.assertTrue(!jobWorkflowDraftPage.isPresent_Close_Btn(), "Close Button Appear On Pop As Expected");
        softAssert.assertTrue(!jobWorkflowDraftPage.isPresent_Dismiss_Btn(), "Dismiss Button Is Present As Expected");
        softAssert.assertTrue(!jobWorkflowDraftPage.isPresent_ValidationMessagePopUp_Lbl(), "Validation Message On The Pop Up Appeared As Expected");

        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.JOB_WORKFLOW, TestGroup.BVT},
            description = "TC_060, Verify Functionality Of Dismiss Button In Error Validation Message Popup")
    public void TC_JobWorkflowSettings_060_Verify_Functionality_Of_Dismiss_Button_In_Error_Validation_Message_Popup() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        coverJourneyTillJobWorkflow();
        jobWorkflowPage.click_Draft_Btn();
        commonActions.click_TableData_Link("NAME");

        jobWorkflowDraftPage.click_Validate_Btn();
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_Close_Btn(), "Close Button Appear On Pop As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_Dismiss_Btn(), "Dismiss Button Is Present As Expected");
        softAssert.assertTrue(jobWorkflowDraftPage.isPresent_ValidationMessagePopUp_Lbl(), "Validation Message On The Pop Up Appeared As Expected");

        jobWorkflowDraftPage.click_Dismiss_Btn();
        softAssert.assertTrue(!jobWorkflowDraftPage.isPresent_Close_Btn(), "Close Button Appear On Pop As Expected");
        softAssert.assertTrue(!jobWorkflowDraftPage.isPresent_Dismiss_Btn(), "Dismiss Button Is Present As Expected");
        softAssert.assertTrue(!jobWorkflowDraftPage.isPresent_ValidationMessagePopUp_Lbl(), "Validation Message On The Pop Up Appeared As Expected");

        softAssert.assertAll();
    }
}
