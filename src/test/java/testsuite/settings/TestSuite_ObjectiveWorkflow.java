package testsuite.settings;

import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.Constants;
import constants.TestGroup;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.actions.ActionHelper;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.settings.ObjectiveWorkflowCreatePage;
import pageobjects.settings.ObjectiveWorkflowCreatePreviewPage;
import pageobjects.settings.ObjectiveWorkflowDetailPage;
import pageobjects.settings.ObjectiveWorkflowsListPage;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite_ObjectiveWorkflow extends BaseTestClass {

    CommonActions commonActions = CommonActions.getInstance();
    ObjectiveWorkflowsListPage objectiveWorkflowsListPage = ObjectiveWorkflowsListPage.getInstance();
    ObjectiveWorkflowDetailPage objectiveWorkflowDetailPage = ObjectiveWorkflowDetailPage.getInstance();
    ObjectiveWorkflowCreatePreviewPage objectiveWorkflowCreatePreviewPage = ObjectiveWorkflowCreatePreviewPage.getInstance();
    ObjectiveWorkflowCreatePage objectiveWorkflowCreatePage = ObjectiveWorkflowCreatePage.getInstance();
    Faker faker = new Faker();

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_001, Verify The UI Of Objective")
    public void TC_ObjectiveWorkflows_001_Verify_The_UI_Of_Objective() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();

        List<String> actualTabHeadersLabels = objectiveWorkflowsListPage.getText_TableHeader_ListLbl();
        List<String> expectedTabHeaders = new ArrayList<>(List.of("NAME", "OBJECTIVE TYPE", "PAYMENT TYPE", "STATUS", "DESCRIPTION",
                "CREATED ON", "CREATED BY", "UPDATED ON", "UPDATED BY"));
        Collections.sort(expectedTabHeaders);
        softAssert.assertTrue(actualTabHeadersLabels.equals(expectedTabHeaders), "Validate the Tab Headers");
        softAssert.assertTrue(objectiveWorkflowsListPage.isPresent_ObjectiveType_DropDown(), "Check Visibility of Objective Type dropdown");
        softAssert.assertTrue(objectiveWorkflowsListPage.isPresent_ActiveTab_Btn(), "Check Visibility of Active tab");
        softAssert.assertTrue(objectiveWorkflowsListPage.isPresent_DraftTab_Btn(), "Check Visibility of Draft tab");
        softAssert.assertTrue(objectiveWorkflowsListPage.isPresent_SearchBar_Txt(), "Check Visibility of Search bar");
        softAssert.assertTrue(objectiveWorkflowsListPage.isPresent_Create_Btn(), "Check Visibility of Create button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_04, Verify The Validation Functionality Of Create Button In New Objective Workflow Page For Maximum Character Limit")
    public void TC_ObjectiveWorkflows_004_Verify_The_Validation_Functionality_Of_Create_Button_In_New_Objective_Workflow_Page_For_Maximum_Character_Limit() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_Create_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePreviewPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePreviewPage.click_NewWorkflow_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_Header_Lbl(), "Check Visibility of Header");

        objectiveWorkflowCreatePage.fill_WorkflowName_Txt(Utility.getRepeatingCharacterString('A', 25));
        objectiveWorkflowCreatePage.click_Create_Btn();
        softAssert.assertEquals(objectiveWorkflowCreatePage.getText_WorkflowNameValidationMsg_Lbl(), "Length must be smaller than 24", "Validate validation error for Workflow Name field");

        objectiveWorkflowCreatePage.clear_WorkflowName_Txt();
        objectiveWorkflowCreatePage.fill_WorkflowDescription_Txt(Utility.getRepeatingCharacterString('A', 151));
        objectiveWorkflowCreatePage.click_Create_Btn();
        softAssert.assertEquals(objectiveWorkflowCreatePage.getText_WorkflowNameValidationMsg_Lbl(), "Required", "Validate required validation error for Workflow Name field");
        softAssert.assertEquals(objectiveWorkflowCreatePage.getText_WorkflowDescriptionValidationMsg_Lbl(), "Length must be smaller than 150", "Validate validation error for Workflow Description field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_30, To Verify Deactivate functionality for Active workflow", enabled = false)
    public void TC_ObjectiveWorkflows_030_To_Verify_Deactivate_functionality_for_Active_workflow() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_ActiveTab_Btn();
        String name = commonActions.getText_TableData_Lbl("NAME");
        ActionHelper.click(commonActions.getWebElement_TableData_Lbl("NAME"));
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(objectiveWorkflowDetailPage.getText_Header_Lbl(), "Objective Workflow - " + name, "Check header text");
        objectiveWorkflowDetailPage.click_Deactivate_Btn();
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_DeactivatePopUpHeader_Lbl(), "Check Visibility of Deactivate header");
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_DeactivatePopUpCancel_Btn(), "Check Visibility of Cancel button");
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_DeactivatePopUpDeactivate_Btn(), "Check Visibility of Deactivate button");
        objectiveWorkflowDetailPage.click_DeactivatePopUpDeactivate_Btn();
        objectiveWorkflowsListPage.click_DraftTab_Btn();
        objectiveWorkflowsListPage.fillWithClear_SearchBar_Txt(name);
        List<String> nameList = commonActions.getTextList_TableDataList_Lbl("NAME");
        softAssert.assertEquals(nameList.size(), 1, "Validate size of Name list");
        softAssert.assertEquals(nameList.get(0), name, "Validate the Name");
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("STATUS"), "Draft", "Validate the Status");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_33, To verify filter functionality using Objective Type and status of the workflow")
    public void TC_ObjectiveWorkflows_033_To_verify_filter_functionality_using_Objective_Type_and_status_of_the_workflow() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_ActiveTab_Btn();
        objectiveWorkflowsListPage.fillWithClear_SearchBar_Txt("qa");
        List<String> nameList = commonActions.getTextList_TableDataList_Lbl("NAME");
        softAssert.assertTrue(nameList.size() != 0, "Validate size of Name list");
        for (String name : nameList)
            softAssert.assertTrue(name.toUpperCase().contains("QA"), "Validate the Name");

        objectiveWorkflowsListPage.clear_SearchBar_Txt();
        List<String> expectedObjectiveList = commonActions.getTextList_TableDataList_Lbl("OBJECTIVE TYPE");
        objectiveWorkflowsListPage.click_ObjectiveType_DropDown();
        objectiveWorkflowsListPage.click_ObjectiveTypeDropDownPickup_Radio();
        for (String objective : commonActions.getTextList_TableDataList_Lbl("OBJECTIVE TYPE"))
            softAssert.assertEquals(objective, "Pickup", "Validate the Objective");
        objectiveWorkflowsListPage.click_ObjectiveTypeDropDownDrop_Radio();
        for (String objective : commonActions.getTextList_TableDataList_Lbl("OBJECTIVE TYPE"))
            softAssert.assertEquals(objective, "Drop", "Validate the Objective");
        objectiveWorkflowsListPage.click_ObjectiveTypeDropDownReturn_Radio();
        for (String objective : commonActions.getTextList_TableDataList_Lbl("OBJECTIVE TYPE"))
            softAssert.assertEquals(objective, "Return", "Validate the Objective");
        objectiveWorkflowsListPage.click_ObjectiveTypeDropDownClearSelection_Btn();
        List<String> actualObjectiveList = commonActions.getTextList_TableDataList_Lbl("OBJECTIVE TYPE");
        softAssert.assertTrue(actualObjectiveList.equals(expectedObjectiveList), "Validate the Objective List");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_34, Verify The UI Of Create Button")
    public void TC_ObjectiveWorkflows_034_Verify_The_UI_Of_Create_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_Create_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePreviewPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePreviewPage.click_NewWorkflow_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_WorkflowName_Txt(), "Check Visibility of Workflow Name field");
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_WorkflowDescription_Txt(), "Check Visibility of Workflow Description field");
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_ObjectiveType_DropDown(), "Check Visibility of Objective Type field");
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_PaymentMode_DropDown(), "Check Visibility of Payment Mode Header");
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_Back_Btn(), "Check Visibility of Back button");
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_Create_Btn(), "Check Visibility of Create button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_35, Verify The Functionality Of Back Button In New Objective Workflow Page")
    public void TC_ObjectiveWorkflows_035_Verify_The_Functionality_Of_Back_Button_In_New_Objective_Workflow_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_Create_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePreviewPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePreviewPage.click_NewWorkflow_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePage.click_Back_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePreviewPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_36, Verify The Validation Functionality Of Create Button with mandatory fields")
    public void TC_ObjectiveWorkflows_036_Verify_The_Validation_Functionality_Of_Create_Button_with_mandatory_fields() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        String name = "Z" + faker.name().firstName();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_Create_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePreviewPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePreviewPage.click_NewWorkflow_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePage.createWorkflow(name, faker.weather().description());
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(objectiveWorkflowDetailPage.getText_Header_Lbl(), "Objective Workflow - " + name, "Check Header text");
        softAssert.assertEquals(objectiveWorkflowDetailPage.getText_SubHeader_Lbl(), "Draft", "Check Header text");
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_SaveAsDraft_Btn(), "Check Visibility of Save  As Draft button");
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_Validate_Btn(), "Check Visibility of Validate button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_37, To verify UI for Save As Draft button")
    public void TC_ObjectiveWorkflows_037_To_verify_UI_for_Save_As_Draft_button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        String name = "Z" + faker.name().firstName();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_Create_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePreviewPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePreviewPage.click_NewWorkflow_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePage.createWorkflow(name, faker.weather().description());
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(objectiveWorkflowDetailPage.getText_Header_Lbl(), "Objective Workflow - " + name, "Check Header text");
        objectiveWorkflowDetailPage.click_SaveAsDraft_Btn();
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_SaveAsDraftPopUpHeader_Lbl(), "Check Visibility of header");
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_SaveAsDraftPopUpCancel_Btn(), "Check Visibility of Cancel button");
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_SaveAsDraftPopUpSaveAsDraft_Btn(), "Check Visibility of Save As Draft button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_38, To verify Cancel Button UI  for Save As Draft button")
    public void TC_ObjectiveWorkflows_038_To_verify_Cancel_Button_UI__for_Save_As_Draft_button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        String name = "Z" + faker.name().firstName();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_Create_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePreviewPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePreviewPage.click_NewWorkflow_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePage.createWorkflow(name, faker.weather().description());
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(objectiveWorkflowDetailPage.getText_Header_Lbl(), "Objective Workflow - " + name, "Check Header text");
        objectiveWorkflowDetailPage.click_SaveAsDraft_Btn();
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_SaveAsDraftPopUpHeader_Lbl(), "Check Visibility of header");
        objectiveWorkflowDetailPage.click_SaveAsDraftPopUpCancel_Btn();
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(objectiveWorkflowDetailPage.getText_Header_Lbl(), "Objective Workflow - " + name, "Check Header text");
        softAssert.assertEquals(objectiveWorkflowDetailPage.getText_SubHeader_Lbl(), "Draft", "Check Header text");
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_SaveAsDraft_Btn(), "Check Visibility of Save  As Draft button");
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_Validate_Btn(), "Check Visibility of Validate button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_41, Verify The Validation Functionality Of Create Button In New Objective Workflow Page For Empty Field")
    public void TC_ObjectiveWorkflows_041_Verify_The_Validation_Functionality_Of_Create_Button_In_New_Objective_Workflow_Page_For_Empty_Field() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        softAssert.assertTrue(objectiveWorkflowsListPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowsListPage.click_Create_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePreviewPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePreviewPage.click_NewWorkflow_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePage.click_Create_Btn();
        softAssert.assertEquals(objectiveWorkflowCreatePage.getText_WorkflowNameValidationMsg_Lbl(), "Required", "Check validation msg");
        softAssert.assertEquals(objectiveWorkflowCreatePage.getText_ObjectiveTypeValidationMsg_Lbl(), "Required", "Check validation msg");
        softAssert.assertEquals(objectiveWorkflowCreatePage.getText_PaymentModeValidationMsg_Lbl(), "Required", "Check validation msg");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_42, Verify functionality of creating Make a Copy WF ")
    public void TC_ObjectiveWorkflows_042_Verify_functionality_of_creating_Make_a_Copy_WF() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        softAssert.assertTrue(objectiveWorkflowsListPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        String name = commonActions.getText_TableData_Lbl("NAME");
        ActionHelper.click(commonActions.getWebElement_TableData_Lbl("NAME"));
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertTrue(objectiveWorkflowDetailPage.getText_Header_Lbl().equalsIgnoreCase("Objective Workflow - " + name), "Check header text");
        String description = objectiveWorkflowDetailPage.getText_Description_Lbl();
        String objectiveType = objectiveWorkflowDetailPage.getText_ObjectiveType_Lbl();
        objectiveWorkflowDetailPage.click_MakeACopy_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(objectiveWorkflowCreatePage.getValue_WorkflowName_Txt(), "Copy_" + name, "Check Name");
        softAssert.assertEquals(objectiveWorkflowCreatePage.getText_ObjectiveTypeDropDownSelectedValue_Lbl(), objectiveType, "Check Objective Type");
        softAssert.assertEquals(objectiveWorkflowCreatePage.getValue_WorkflowDescription_Txt(), description, "Check Description");
        objectiveWorkflowCreatePage.fillWithClear_WorkflowName_Txt(faker.name().firstName());
        objectiveWorkflowCreatePage.click_Create_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_ObjectiveWorkflowDuplicatedSuccessfullyToastMsg_Lbl(), "Check Visibility of success  toast msg");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_43, Verify The Validation Functionality For Workflow Name and Description In New objective Workflow Page")
    public void TC_ObjectiveWorkflows_043_Verify_The_Validation_Functionality_For_Workflow_Name_and_Description_In_New_Objective_Workflow_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_Create_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePreviewPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePreviewPage.click_NewWorkflow_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_Header_Lbl(), "Check Visibility of Header");

        objectiveWorkflowCreatePage.fill_WorkflowName_Txt(Utility.getRepeatingCharacterString('A', 25));
        objectiveWorkflowCreatePage.click_Create_Btn();
        softAssert.assertEquals(objectiveWorkflowCreatePage.getText_WorkflowNameValidationMsg_Lbl(), "Length must be smaller than 24", "Validate validation error for Workflow Name field");

        objectiveWorkflowCreatePage.clear_WorkflowName_Txt();
        objectiveWorkflowCreatePage.fill_WorkflowDescription_Txt(Utility.getRepeatingCharacterString('A', 151));
        objectiveWorkflowCreatePage.click_Create_Btn();
        softAssert.assertEquals(objectiveWorkflowCreatePage.getText_WorkflowNameValidationMsg_Lbl(), "Required", "Validate required validation error for Workflow Name field");
        softAssert.assertEquals(objectiveWorkflowCreatePage.getText_WorkflowDescriptionValidationMsg_Lbl(), "Length must be smaller than 150", "Validate validation error for Workflow Description field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_44, Verify The Functionality Of Create Button In New Objective Workflow Page")
    public void TC_ObjectiveWorkflows_044_Verify_The_Functionality_Of_Create_Button_In_New_Objective_Workflow_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        String name = "Z" + faker.name().firstName();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_Create_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePreviewPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePreviewPage.click_NewWorkflow_Btn();
        softAssert.assertTrue(objectiveWorkflowCreatePage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowCreatePage.createWorkflow(name, faker.weather().description());
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(objectiveWorkflowDetailPage.getText_Header_Lbl(), "Objective Workflow - " + name, "Check Header text");
        softAssert.assertEquals(objectiveWorkflowDetailPage.getText_SubHeader_Lbl(), "Draft", "Check Header text");
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_SaveAsDraft_Btn(), "Check Visibility of Save  As Draft button");
        softAssert.assertTrue(objectiveWorkflowDetailPage.isPresent_Validate_Btn(), "Check Visibility of Validate button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_45, Verify The UI Of Table Present In Objective Workflows Page")
    public void TC_ObjectiveWorkflows_045_Verify_The_UI_Of_Table_Present_In_Objective_Workflows_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        List<String> actualTabHeadersLabels = objectiveWorkflowsListPage.getText_TableHeader_ListLbl();
        List<String> expectedTabHeaders = new ArrayList<>(List.of("NAME", "OBJECTIVE TYPE", "PAYMENT TYPE", "STATUS", "DESCRIPTION",
                "CREATED ON", "CREATED BY", "UPDATED ON", "UPDATED BY"));
        Collections.sort(expectedTabHeaders);
        softAssert.assertTrue(actualTabHeadersLabels.equals(expectedTabHeaders), "Validate Table Header label is matched as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_46, Verify The UI Of Objective Type Button")
    public void TC_ObjectiveWorkflows_046_Verify_The_UI_Of_Objective_Type_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_ActiveTab_Btn();
        softAssert.assertTrue(objectiveWorkflowsListPage.isPresent_ObjectiveType_DropDown(), "Validate the presence of Objective Type dropdown");
        objectiveWorkflowsListPage.click_ObjectiveType_DropDown();
        softAssert.assertTrue(objectiveWorkflowsListPage.isSelected_ObjectiveTypeDropDownReturn_Radio() == false, "Validate the Return radio is not selected by default");
        softAssert.assertTrue(objectiveWorkflowsListPage.isSelected_ObjectiveTypeDropDownPickup_Radio() == false, "Validate the Pickup radio is not selected by default");
        softAssert.assertTrue(objectiveWorkflowsListPage.isSelected_ObjectiveTypeDropDownDrop_Radio() == false, "Validate the Drop radio is not selected by default");
        softAssert.assertTrue(objectiveWorkflowsListPage.isPresent_ObjectiveTypeDropDownClearSelection_Btn(), "Validate the presence of Clear Selection btn");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_47, Verify The Functionality Of Filter The Objectives With Pickup")
    public void TC_ObjectiveWorkflows_047_Verify_The_Functionality_Of_Filter_The_Objective_With_Pickup() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_ActiveTab_Btn();
        objectiveWorkflowsListPage.click_ObjectiveType_DropDown();
        objectiveWorkflowsListPage.click_ObjectiveTypeDropDownPickup_Radio();
        for (String objective : commonActions.getTextList_TableDataList_Lbl("OBJECTIVE TYPE"))
            softAssert.assertEquals(objective, "Pickup", "Validate the Objective");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_48, Verify The Functionality Of Filter The Objectives With Return")
    public void TC_ObjectiveWorkflows_048_Verify_The_Functionality_Of_Filter_The_Objective_With_Return() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_ActiveTab_Btn();
        objectiveWorkflowsListPage.click_ObjectiveType_DropDown();
        objectiveWorkflowsListPage.click_ObjectiveTypeDropDownDrop_Radio();
        for (String objective : commonActions.getTextList_TableDataList_Lbl("OBJECTIVE TYPE"))
            softAssert.assertEquals(objective, "Drop", "Validate the Objective");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_49, Verify The Functionality Of Filter The Objectives With Drop")
    public void TC_ObjectiveWorkflows_049_Verify_The_Functionality_Of_Filter_The_Objective_With_Drop() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_ActiveTab_Btn();
        objectiveWorkflowsListPage.click_ObjectiveType_DropDown();
        objectiveWorkflowsListPage.click_ObjectiveTypeDropDownReturn_Radio();
        for (String objective : commonActions.getTextList_TableDataList_Lbl("OBJECTIVE TYPE"))
            softAssert.assertEquals(objective, "Return", "Validate the Objective");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_50, Verify The Functionality Of Clear Selection Button In Objective Type")
    public void TC_ObjectiveWorkflows_050_Verify_The_Functionality_Of_Clear_Selection_Button_In_Objective_Type() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_ActiveTab_Btn();
        List<String> expectedObjectiveList = commonActions.getTextList_TableDataList_Lbl("OBJECTIVE TYPE");
        objectiveWorkflowsListPage.click_ObjectiveType_DropDown();
        objectiveWorkflowsListPage.click_ObjectiveTypeDropDownPickup_Radio();
        for (String objective : commonActions.getTextList_TableDataList_Lbl("OBJECTIVE TYPE"))
            softAssert.assertEquals(objective, "Pickup", "Validate the Objective");
        objectiveWorkflowsListPage.click_ObjectiveTypeDropDownClearSelection_Btn();
        List<String> actualObjectiveList = commonActions.getTextList_TableDataList_Lbl("OBJECTIVE TYPE");
        softAssert.assertTrue(actualObjectiveList.equals(expectedObjectiveList), "Validate the Objectives");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_51, Verify The Functionality Of Search Bar In Objective Workflows Page With Invalid WorkFlow Name")
    public void TC_ObjectiveWorkflows_051_Verify_The_Functionality_Of_Search_Bar_In_Objective_Workflows_Page_With_Invalid_WorkFlow_Name() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        softAssert.assertTrue(objectiveWorkflowsListPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowsListPage.fillWithClear_SearchBar_Txt("@@!z##^^*((0");
        softAssert.assertTrue(objectiveWorkflowsListPage.isPresent_ItIsEmptyHere_Lbl(), "Validate presence of It is Empty here message");
        softAssert.assertTrue(objectiveWorkflowsListPage.isPresent_NoObjectiveWorkflowsFound_Lbl(), "Validate presence of No Objective Workflows found message");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_52, Verify Functionality Of Vertically Scroll Of Objective Workflow Table Using Mouse Scroll Wheel")
    public void TC_ObjectiveWorkflows_052_Verify_Functionality_Of_Vertically_Scroll_Of_Objective_Workflow_Table_Using_Mouse_Scroll_Wheel() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        List<WebElement> elements = commonActions.getWebElementList_TableDataList_Lbl("NAME");
        Utility.validatePageScrollDown(elements.get(elements.size() - 1));
        softAssert.assertTrue(ActionHelper.isPresent(elements.get(elements.size() - 1), Constants.WAIT_FOR_FIVE_SECOND), "Validate last element is present");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_53, Verify Vertically Scroll In Objective Workflow Table Using KeyBoard")
    public void TC_ObjectiveWorkflows_053_Verify_Vertically_Scroll_In_Objective_Workflow_Table_Using_KeyBoard() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        List<WebElement> elements = commonActions.getWebElementList_TableDataList_Lbl("NAME");
        Utility.scrollDownUsingKeyboardKey(10);
        softAssert.assertTrue(ActionHelper.isPresent(elements.get(elements.size() - 1), Constants.WAIT_FOR_FIVE_SECOND), "Validate last element is present");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_54, Verify Displaying Of Objective Workflow Table Records In Active Tab As Per Pagination Value")
    public void TC_ObjectiveWorkflows_054_Verify_Displaying_Of_Objective_Workflow_Table_Records_In_Active_Tab_As_Per_Pagination_Value() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_ActiveTab_Btn();
        objectiveWorkflowsListPage.clickAndChoose_PaginationDropDownOptions_Btn(10);
        softAssert.assertTrue(commonActions.getWebElementList_TableDataList_Lbl("NAME").size() <= 10, "Validate records present are not more than 10");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_55, Verify Displaying Of Objective Workflow Table Records In Draft Tab As Per Pagination Value")
    public void TC_ObjectiveWorkflows_055_Verify_Displaying_Of_Objective_Workflow_Table_Records_In_Draft_Tab_As_Per_Pagination_Value() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        objectiveWorkflowsListPage.click_DraftTab_Btn();
        objectiveWorkflowsListPage.clickAndChoose_PaginationDropDownOptions_Btn(10);
        softAssert.assertTrue(commonActions.getWebElementList_TableDataList_Lbl("NAME").size() <= 10, "Validate records present are not more than 10");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_56, Verify Functionality Of Pagination Paging Block")
    public void TC_ObjectiveWorkflows_056_Verify_Functionality_Of_Pagination_Paging_Block() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        commonActions.selectPaginationBlock("2");
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(2), "Validate correct pagination block is selected");
        commonActions.selectPaginationBlock("1");
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(1), "Validate correct pagination block is selected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_57, Verify Functionality Of Pagination Paging Block With Next And Previous Button")
    public void TC_ObjectiveWorkflows_057_Verify_Functionality_Of_Pagination_Paging_Block_With_Next_And_Previous_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        String firstRecord = commonActions.getText_TableData_Lbl("NAME");
        commonActions.click_PaginationNext_Btn();
        String eleventhRecord = commonActions.getText_TableData_Lbl("NAME");
        commonActions.click_PaginationPrevious_Btn();

        commonActions.selectPaginationBlock("2");
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(2), "Validate correct pagination block is selected");
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("NAME"), eleventhRecord, "Validate eleventh record being displayed");
        commonActions.selectPaginationBlock("1");
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(1), "Validate correct pagination block is selected");
        softAssert.assertEquals(commonActions.getText_TableData_Lbl("NAME"), firstRecord, "Validate first record being displayed");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_58, Verify Functionality Of Pagination Per Page With Paging Block And Next Button")
    public void TC_ObjectiveWorkflows_058_Verify_Functionality_Of_Pagination_Per_Page_With_Paging_Block_And_Next_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        String firstRecord = commonActions.getText_TableData_Lbl("NAME");
        commonActions.selectPaginationBlock("2");
        String eleventhRecord = commonActions.getText_TableData_Lbl("NAME");

        commonActions.click_PaginationPrevious_Btn();
        softAssert.assertTrue(firstRecord.equals(commonActions.getText_TableData_Lbl("NAME")), "Validate the record is same as 1st");
        commonActions.click_PaginationNext_Btn();
        softAssert.assertTrue(eleventhRecord.equals(commonActions.getText_TableData_Lbl("NAME")), "Validate the record is same as 11th");

        commonActions.selectPaginationBlock("1");
        softAssert.assertTrue(firstRecord.equals(commonActions.getText_TableData_Lbl("NAME")), "Validate the record is same as 1st");
        commonActions.selectPaginationBlock("2");
        softAssert.assertTrue(eleventhRecord.equals(commonActions.getText_TableData_Lbl("NAME")), "Validate the record is same as 11th");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_60, Verify The Functionality Of Status Of Record Present In Active Tab")
    public void TC_ObjectiveWorkflows_060_Verify_The_Functionality_Of_Status_Of_Record_Present_In_Active_Tab() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        softAssert.assertTrue(objectiveWorkflowsListPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowsListPage.click_ActiveTab_Btn();
        for (String text : commonActions.getTextList_TableDataList_Lbl("STATUS"))
            softAssert.assertEquals(text, "Active", "Validate status");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.OBJECTIVE_WORKFLOW, TestGroup.BVT},
            description = "TC_61, Verify The Functionality Of Status Of Record Present In Draft Tab")
    public void TC_ObjectiveWorkflows_061_Verify_The_Functionality_Of_Status_Of_Record_Present_In_Draft_Tab() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillObjectiveWorkflowListPage();
        softAssert.assertTrue(objectiveWorkflowsListPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        objectiveWorkflowsListPage.click_DraftTab_Btn();
        for (String text : commonActions.getTextList_TableDataList_Lbl("STATUS"))
            softAssert.assertEquals(text, "Draft", "Validate status");
        softAssert.assertAll();
    }
}
