package pageobjects.settings;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import pageobjects.CommonActions;
import utility.Utility;

public class ObjectiveWorkflowCreatePage {
    private static ObjectiveWorkflowCreatePage _instance;

    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//h2[text()='New Objective Workflow']"));
    private final Locator subHeader_Lbl = Locator.builder().withWeb(By.xpath("//h2[text()='New Objective Workflow']/following-sibling::p"));
    private final Locator homeBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/']/p[text()='Home']"));
    private final Locator settingsBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/settings/']/p[text()='Settings']"));
    private final Locator workflowBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/settings/workflow/']/p[text()='Workflow']"));
    private final Locator objectiveWorkflowsBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/settings/workflow/objective-workflow/list/']/p[text()='Objective Workflows']"));
    private final Locator objectiveWorkflowCreatePreviewBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/settings/workflow/objective-workflow/create-preview/']/p[text()='Objective Workflow Create Preview']"));
    private final Locator objectiveWorkflowCreateBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/settings/workflow/objective-workflow/create/']/p[text()='Objective Workflow Create']"));

    private final Locator workflowName_Txt = Locator.builder().withWeb(By.xpath("//div[h4[text()='Workflow Name*']]/following-sibling::div//input"));
    private final Locator objectiveType_DropDown = Locator.builder().withWeb(By.xpath("//div[h4[text()='Objective Type*']]/following-sibling::div//input"));
    private final Locator objectiveTypeDropDownPickup_Btn = Locator.builder().withWeb(By.xpath("//div[@label='Pickup']/div"));
    private final Locator objectiveTypeDropDownDrop_Btn = Locator.builder().withWeb(By.xpath("//div[@label='Drop']/div"));
    private final Locator objectiveTypeDropDownReturn_Btn = Locator.builder().withWeb(By.xpath("//div[@label='Return']/div"));
    private final Locator objectiveTypeDropDownSelectedValue_Lbl = Locator.builder().withWeb(By.xpath("//div[h4[text()='Objective Type*']]/following-sibling::div//span[input]/following-sibling::span"));
    private final Locator paymentMode_DropDown = Locator.builder().withWeb(By.xpath("//div[h4[text()='Payment Mode*']]/following-sibling::div//input"));
    private final Locator paymentModeDropDownPrepaid_Btn = Locator.builder().withWeb(By.xpath("//div[@label='Prepaid']/div"));
    private final Locator paymentModeDropDownCOD_Btn = Locator.builder().withWeb(By.xpath("//div[@label='COD']/div"));
    private final Locator paymentModeDropDownSelectedValue_Lbl = Locator.builder().withWeb(By.xpath("//div[h4[text()='Payment Mode*']]/following-sibling::div//span[input]/following-sibling::span"));
    private final Locator workflowDescription_Txt = Locator.builder().withWeb(By.xpath("//textarea[@name='workflowDescription']"));
    private final Locator create_Btn = Locator.builder().withWeb(By.id("submitForm"));
    private final Locator back_Btn = Locator.builder().withWeb(By.xpath("//button[p[text()='Back']]"));
    private final Locator objectiveWorkflowDuplicatedSuccessfullyToastMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[text()='Objective Workflow duplicated successfully']"));

    private final Locator workflowNameValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[h4[text()='Workflow Name*']]/following-sibling::div/p"));
    private final Locator workflowDescriptionValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//textarea[@name='workflowDescription']/following-sibling::p"));
    private final Locator objectiveTypeValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[h4[text()='Objective Type*']]/following-sibling::div/p"));
    private final Locator paymentModeValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[h4[text()='Payment Mode*']]/following-sibling::div/p"));

    public static ObjectiveWorkflowCreatePage getInstance() {
        if (_instance == null) {
            _instance = new ObjectiveWorkflowCreatePage();
        }
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        return ActionHelper.isPresent(header_Lbl, 5000);
    }

    public String getText_Header_Lbl() {
        return ActionHelper.getText(header_Lbl);
    }

    public boolean isPresent_SubHeader_Lbl() {
        return ActionHelper.isPresent(subHeader_Lbl);
    }

    public String getText_SubHeader_Lbl() {
        return ActionHelper.getText(subHeader_Lbl);
    }

    public boolean isPresent_HomeBreadcrumb_Link() {
        return ActionHelper.isPresent(homeBreadcrumb_Link);
    }

    public void click_HomeBreadcrumb_Link() {
        ActionHelper.click(homeBreadcrumb_Link);
    }

    public String getText_HomeBreadcrumb_Link() {
        return ActionHelper.getText(homeBreadcrumb_Link);
    }

    public boolean isPresent_SettingsBreadcrumb_Link() {
        return ActionHelper.isPresent(settingsBreadcrumb_Link);
    }

    public void click_SettingsBreadcrumb_Link() {
        ActionHelper.click(settingsBreadcrumb_Link);
    }

    public boolean isPresent_WorkflowBreadcrumb_Link() {
        return ActionHelper.isPresent(workflowBreadcrumb_Link);
    }

    public void click_WorkflowBreadcrumb_Link() {
        ActionHelper.click(workflowBreadcrumb_Link);
    }

    public boolean isPresent_ObjectiveWorkflowsBreadcrumb_Link() {
        return ActionHelper.isPresent(objectiveWorkflowsBreadcrumb_Link);
    }

    public void click_ObjectiveWorkflowsBreadcrumb_Link() {
        ActionHelper.click(objectiveWorkflowsBreadcrumb_Link);
    }

    public String getText_ObjectiveWorkflowsBreadcrumb_Link() {
        return ActionHelper.getText(objectiveWorkflowsBreadcrumb_Link);
    }

    public boolean isPresent_ObjectiveWorkflowCreatePreviewBreadcrumb_Link() {
        return ActionHelper.isPresent(objectiveWorkflowCreatePreviewBreadcrumb_Link);
    }

    public void click_ObjectiveWorkflowCreatePreviewBreadcrumb_Link() {
        ActionHelper.click(objectiveWorkflowCreatePreviewBreadcrumb_Link);
    }

    public String getText_ObjectiveWorkflowCreatePreviewBreadcrumb_Link() {
        return ActionHelper.getText(objectiveWorkflowCreatePreviewBreadcrumb_Link);
    }

    public boolean isPresent_ObjectiveWorkflowCreateBreadcrumb_Link() {
        return ActionHelper.isPresent(objectiveWorkflowCreateBreadcrumb_Link);
    }

    public void click_ObjectiveWorkflowCreateBreadcrumb_Link() {
        ActionHelper.click(objectiveWorkflowCreateBreadcrumb_Link);
    }

    public String getText_ObjectiveWorkflowCreateBreadcrumb_Link() {
        return ActionHelper.getText(objectiveWorkflowCreateBreadcrumb_Link);
    }

    public boolean isPresent_WorkflowName_Txt() {
        return ActionHelper.isPresent(workflowName_Txt);
    }

    public void fill_WorkflowName_Txt(String value) {
        ActionHelper.fill(workflowName_Txt, value);
    }

    public void fillWithClear_WorkflowName_Txt(String value) {
        Utility.selectAllAndClear(workflowName_Txt.getBy());
        ActionHelper.fill(workflowName_Txt, value);
    }

    public void clear_WorkflowName_Txt() {
        Utility.selectAllAndClear(workflowName_Txt.getBy());
    }

    public String getValue_WorkflowName_Txt() {
        return ActionHelper.getAttribute(workflowName_Txt, "value");
    }

    public boolean isPresent_ObjectiveType_DropDown() {
        return ActionHelper.isPresent(objectiveType_DropDown);
    }

    public void click_ObjectiveType_DropDown() {
        ActionHelper.click(objectiveType_DropDown);
    }

    public String getText_ObjectiveType_DropDown() {
        return ActionHelper.getText(objectiveType_DropDown);
    }

    public void click_ObjectiveTypeDropDownDrop_Btn() {
        ActionHelper.click(objectiveTypeDropDownDrop_Btn);
    }

    public void click_ObjectiveTypeDropDownPickup_Btn() {
        ActionHelper.click(objectiveTypeDropDownPickup_Btn);
    }

    public void click_ObjectiveTypeDropDownReturn_Btn() {
        ActionHelper.click(objectiveTypeDropDownReturn_Btn);
    }

    public String getText_ObjectiveTypeDropDownSelectedValue_Lbl() {
        return ActionHelper.getText(objectiveTypeDropDownSelectedValue_Lbl);
    }

    public boolean isPresent_PaymentMode_DropDown() {
        return ActionHelper.isPresent(paymentMode_DropDown);
    }

    public void click_PaymentMode_DropDown() {
        ActionHelper.click(paymentMode_DropDown);
    }

    public String getText_PaymentMode_DropDown() {
        return ActionHelper.getText(paymentMode_DropDown);
    }

    public void click_PaymentModeDropDownPrepaid_Btn() {
        ActionHelper.click(paymentModeDropDownPrepaid_Btn);
    }

    public void click_PaymentModeDropDownCOD_Btn() {
        ActionHelper.click(paymentModeDropDownCOD_Btn);
    }

    public String getText_PaymentModeDropDownSelectedValue_Lbl() {
        return ActionHelper.getText(paymentModeDropDownSelectedValue_Lbl);
    }

    public boolean isPresent_WorkflowDescription_Txt() {
        return ActionHelper.isPresent(workflowDescription_Txt);
    }

    public void fill_WorkflowDescription_Txt(String value) {
        ActionHelper.fill(workflowDescription_Txt, value);
    }

    public void fillWithClear_WorkflowDescription_Txt(String value) {
        ActionHelper.fillWithClear(workflowDescription_Txt.getBy(), value);
    }

    public void clear_WorkflowDescription_Txt() {
        ActionHelper.clear(workflowDescription_Txt.getBy());
    }

    public String getValue_WorkflowDescription_Txt() {
        return ActionHelper.getAttribute(workflowDescription_Txt, "value");
    }

    public boolean isPresent_Create_Btn() {
        return ActionHelper.isPresent(create_Btn);
    }

    public void click_Create_Btn() {
        ActionHelper.click(create_Btn);
    }

    public String getText_Create_Btn() {
        return ActionHelper.getText(create_Btn);
    }

    public boolean isPresent_Back_Btn() {
        return ActionHelper.isPresent(back_Btn);
    }

    public void click_Back_Btn() {
        ActionHelper.click(back_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_Back_Btn() {
        return ActionHelper.getText(back_Btn);
    }

    public boolean isPresent_WorkflowNameValidationMsg_Lbl() {
        return ActionHelper.isPresent(workflowNameValidationMsg_Lbl);
    }

    public String getText_WorkflowNameValidationMsg_Lbl() {
        return ActionHelper.getText(workflowNameValidationMsg_Lbl);
    }

    public boolean isPresent_WorkflowDescriptionValidationMsg_Lbl() {
        return ActionHelper.isPresent(workflowDescriptionValidationMsg_Lbl);
    }

    public String getText_WorkflowDescriptionValidationMsg_Lbl() {
        return ActionHelper.getText(workflowDescriptionValidationMsg_Lbl);
    }

    public boolean isPresent_ObjectiveTypeValidationMsg_Lbl() {
        return ActionHelper.isPresent(objectiveTypeValidationMsg_Lbl);
    }

    public String getText_ObjectiveTypeValidationMsg_Lbl() {
        return ActionHelper.getText(objectiveTypeValidationMsg_Lbl);
    }

    public boolean isPresent_PaymentModeValidationMsg_Lbl() {
        return ActionHelper.isPresent(paymentModeValidationMsg_Lbl);
    }

    public String getText_PaymentModeValidationMsg_Lbl() {
        return ActionHelper.getText(paymentModeValidationMsg_Lbl);
    }

    public boolean isPresent_ObjectiveWorkflowDuplicatedSuccessfullyToastMsg_Lbl() {
        return ActionHelper.isPresent(objectiveWorkflowDuplicatedSuccessfullyToastMsg_Lbl, 10000);
    }

    public void createWorkflow(String name, String description) {
        fillWithClear_WorkflowName_Txt(name);
        click_ObjectiveType_DropDown();
        click_ObjectiveTypeDropDownPickup_Btn();
        click_PaymentMode_DropDown();
        click_PaymentModeDropDownPrepaid_Btn();
        fillWithClear_WorkflowDescription_Txt(description);
        click_Create_Btn();
    }
}
