package pageobjects.settings;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import pageobjects.CommonActions;
import utility.Utility;

public class JobWorkflowCreatePage {
    private static JobWorkflowCreatePage _instance;
    private final Locator newJobWorkflowHeader_Lbl = Locator.builder().withWeb(By.xpath("//h2"));
    private final Locator jobWorkflowCreateBreadCrumb_Link = Locator.builder().withWeb(By.id("/settings/workflow/job-workflow/create"));

    private final Locator workflowName_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Workflow Name*']"));
    private final Locator workflowName_Txt = Locator.builder().withWeb(By.xpath("//input[@name='workflowName']"));
    private final Locator workflowNameValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Workflow Name*']/../following-sibling::div//p"));
    private final Locator workflowDescription_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Workflow Description']"));
    private final Locator workflowDescription_Txt = Locator.builder().withWeb(By.name("workflowDescription"));
    private final Locator workflowDescriptionValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Workflow Description']/../following-sibling::div//p"));
    private final Locator jobWorkType_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Job Type*']"));
    private final Locator jobWorkType_Txt = Locator.builder().withWeb(By.xpath("//input[@disabled]"));

    private final Locator otherAttributesSubHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Order Attributes*']"));
    private final Locator productType_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Product Type']"));
    private final Locator productType_Txt = Locator.builder().withWeb(By.id("rc_select_1"));
    private final Locator productType_List = Locator.builder().withWeb(By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[1]/div"));
    private final Locator productTypeValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Product Type']/../following-sibling::div//p"));
    private final Locator shipmentFlow_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Shipment Flow']"));
    private final Locator shipmentFlow_Txt = Locator.builder().withWeb(By.id("rc_select_2"));
    private final Locator shipmentFlowValidationMsg_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Shipment Flow']/../following-sibling::div//p"));

    private final Locator doorStepAttributesSubHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Doorstep Attributes']"));
    private final Locator kycVerification_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='KYC Verification']"));
    private final Locator kycVerification_Btn = Locator.builder().withWeb(By.xpath("//p[text()='KYC Verification']/../following-sibling::button"));
    private final Locator otpVerification_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='OTP Verification']"));
    private final Locator otpVerification_Btn = Locator.builder().withWeb(By.xpath("//p[text()='OTP Verification']/../following-sibling::button"));
    private final Locator qcVerification_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='QC Verification']"));
    private final Locator qcVerification_Btn = Locator.builder().withWeb(By.xpath("//p[text()='QC Verification']/../following-sibling::button"));
    private final Locator signatureCollection_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Signature Collection']"));
    private final Locator signatureCollection_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Signature Collection']/../following-sibling::button"));
    private final Locator paymentOption_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Payment Option*']"));
    private final Locator paymentOption_Txt = Locator.builder().withWeb(By.id("rc_select_7"));
    private final Locator paymentType_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Payment Type*']"));
    private final Locator paymentType_Txt = Locator.builder().withWeb(By.id("rc_select_8"));
    private final Locator back_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Back']/.."));
    private final Locator create_Btn = Locator.builder().withWeb(By.id("submitForm"));
    String dropDownList = "//div[@class='rc-virtual-list-holder-inner']//div[text()='abc']";
    String productTypeDropDownList = "(//div[@class='rc-virtual-list-holder-inner'])[1]";

    public static JobWorkflowCreatePage getInstance() {
        if (_instance == null)
            _instance = new JobWorkflowCreatePage();
        return _instance;
    }

    public boolean isPresent_NewJobWorkflowHeader_Lbl() {
        return ActionHelper.isPresent(newJobWorkflowHeader_Lbl);
    }

    public String getText_NewJobWorkflowHeader_Lbl() {
        return ActionHelper.getText(newJobWorkflowHeader_Lbl);
    }

    public boolean isPresent_JobWorkflowCreateBreadCrumb_Link() {
        return ActionHelper.isPresent(jobWorkflowCreateBreadCrumb_Link);
    }

    public void click_JobWorkflowCreateBreadCrumb_Link() {
        ActionHelper.click(jobWorkflowCreateBreadCrumb_Link);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_WorkflowName_Lbl() {
        return ActionHelper.isPresent(workflowName_Lbl);
    }

    public boolean isPresent_WorkflowName_Txt() {
        return ActionHelper.isPresent(workflowName_Txt);
    }

    public void fill_WorkflowName_Txt(String workflowName) {
        ActionHelper.sendKeysWithClear(workflowName_Txt.getBy(), workflowName);
    }

    public boolean isPresent_WorkflowNameValidationMsg_Lbl() {
        return ActionHelper.isPresent(workflowNameValidationMsg_Lbl);
    }

    public String getText_WorkflowNameValidationMsg_Lbl() {
        return ActionHelper.getText(workflowNameValidationMsg_Lbl);
    }

    public boolean isPresent_WorkflowDescription_Lbl() {
        return ActionHelper.isPresent(workflowDescription_Lbl);
    }

    public boolean isPresent_WorkflowDescription_Txt() {
        return ActionHelper.isPresent(workflowDescription_Txt);
    }

    public void fill_WorkflowDescription_Txt(String workflowDescription) {
        ActionHelper.sendKeysWithClear(workflowDescription_Txt.getBy(), workflowDescription);
    }

    public boolean isPresent_WorkflowDescriptionValidationMsg_Lbl() {
        return ActionHelper.isPresent(workflowDescriptionValidationMsg_Lbl);
    }

    public String getText_WorkflowDescriptionValidationMsg_Lbl() {
        return ActionHelper.getText(workflowDescriptionValidationMsg_Lbl);
    }

    public boolean isPresent_JobWorkType_Lbl() {
        return ActionHelper.isPresent(jobWorkType_Lbl);
    }

    public boolean isPresent_JobWorkType_Txt() {
        return ActionHelper.isPresent(jobWorkType_Txt);
    }

    public boolean isDisabled_JobWorkType_Txt() {
        return ActionHelper.findElement(jobWorkType_Txt).getAttribute("disabled").equals("true");
    }

    public boolean isPresent_OtherAttributesSubHeader_Lbl() {
        return ActionHelper.isPresent(otherAttributesSubHeader_Lbl);
    }

    public boolean isPresent_ProductType_Lbl() {
        return ActionHelper.isPresent(productType_Lbl);
    }

    public boolean isPresent_ProductType_Txt() {
        return ActionHelper.isPresent(productType_Txt);
    }

    public void fill_ProductType_Txt(String productType) {
        ActionHelper.sendKeysWithClear(productType_Txt.getBy(), productType);
    }

    public boolean isPresent_ProductTypeValidationMsg_Lbl() {
        return ActionHelper.isPresent(productTypeValidationMsg_Lbl);
    }

    public String getText_ProductTypeValidationMsg_Lbl() {
        return ActionHelper.getText(productTypeValidationMsg_Lbl);
    }

    public void select_ProductType_Txt(String productType) {
        Utility.select_FromDropDown_List(productType_Txt.getBy(), productType_List.getBy(), productType);
    }

    public boolean isPresent_ShipmentFlow_Lbl() {
        return ActionHelper.isPresent(shipmentFlow_Lbl);
    }

    public boolean isPresent_ShipmentFlow_Txt() {
        return ActionHelper.isPresent(shipmentFlow_Txt);
    }

    public void fill_ShipmentFlow_Txt(String shipmentFlow) {
        ActionHelper.sendKeysWithClear(shipmentFlow_Txt.getBy(), shipmentFlow);
    }

    public void select_ShipmentFlow_Txt(String shipmentFlow) {
        Locator shipment = Locator.builder().withWeb(By.xpath(dropDownList.replace("abc", shipmentFlow)));
        ActionHelper.click(shipmentFlow_Txt);
        ActionHelper.click(shipment);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_ShipmentFlowValidationMsg_Lbl() {
        return ActionHelper.isPresent(shipmentFlowValidationMsg_Lbl);
    }

    public String getText_ShipmentFlowValidationMsg_Lbl() {
        return ActionHelper.getText(shipmentFlowValidationMsg_Lbl);
    }

    public boolean isPresent_DoorStepAttributesSubHeader_Lbl() {
        return ActionHelper.isPresent(doorStepAttributesSubHeader_Lbl);
    }

    public String getText_DoorStepAttributesSubHeader_Lbl() {
        return ActionHelper.getText(doorStepAttributesSubHeader_Lbl);
    }

    public boolean isChecked_Btn(Locator locator) {
        return (ActionHelper.getAttribute(locator.getBy(), "data-headlessui-state")).equals("checked");
    }

    public boolean isPresent_KYCVerification_Lbl() {
        return ActionHelper.isPresent(kycVerification_Lbl);
    }

    public boolean isPresent_KYCVerification_Btn() {
        return ActionHelper.isPresent(kycVerification_Btn);
    }

    public void check_KYCVerification_Btn() {
        if (!isChecked_Btn(kycVerification_Btn))
            ActionHelper.click(kycVerification_Btn);
    }

    public void unCheck_KYCVerification_Btn() {
        if (isChecked_Btn(kycVerification_Btn))
            ActionHelper.click(kycVerification_Btn);
    }

    public boolean isPresent_OTPVerification_Lbl() {
        return ActionHelper.isPresent(otpVerification_Lbl);
    }

    public boolean isPresent_OTPVerification_Btn() {
        return ActionHelper.isPresent(otpVerification_Btn);
    }

    public void check_OTPVerification_Btn() {
        if (!isChecked_Btn(otpVerification_Btn))
            ActionHelper.click(otpVerification_Btn);
    }

    public void unCheck_OTPVerification_Btn() {
        if (isChecked_Btn(otpVerification_Btn))
            ActionHelper.click(otpVerification_Btn);
    }

    public boolean isPresent_QCVerification_Lbl() {
        return ActionHelper.isPresent(qcVerification_Lbl);
    }

    public boolean isPresent_QCVerification_Btn() {
        return ActionHelper.isPresent(qcVerification_Btn);
    }

    public void check_QCVerification_Btn() {
        if (!isChecked_Btn(qcVerification_Btn))
            ActionHelper.click(qcVerification_Btn);
    }

    public void unCheck_QCVerification_Btn() {
        if (isChecked_Btn(qcVerification_Btn))
            ActionHelper.click(qcVerification_Btn);
    }

    public boolean isPresent_SignatureCollection_Lbl() {
        return ActionHelper.isPresent(signatureCollection_Lbl);
    }

    public boolean isPresent_SignatureCollection_Btn() {
        return ActionHelper.isPresent(signatureCollection_Btn);
    }

    public void check_SignatureCollection_Btn() {
        if (!isChecked_Btn(signatureCollection_Btn))
            ActionHelper.click(signatureCollection_Btn);
    }

    public void unCheck_SignatureCollection_Btn() {
        if (isChecked_Btn(signatureCollection_Btn))
            ActionHelper.click(signatureCollection_Btn);
    }

    public boolean isPresent_PaymentOption_Lbl() {
        return ActionHelper.isPresent(paymentOption_Lbl);
    }

    public boolean isPresent_PaymentOption_Txt() {
        return ActionHelper.isPresent(paymentOption_Txt);
    }

    public void click_PaymentOption_Txt(String paymentOption) {
        Locator paymentMethod = Locator.builder().withWeb(By.xpath(dropDownList.replace("abc", paymentOption)));
        ActionHelper.click(paymentOption_Txt);
        ActionHelper.click(paymentMethod);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_PaymentType_Lbl() {
        return ActionHelper.isPresent(paymentType_Lbl);
    }

    public boolean isPresent_PaymentType_Txt() {
        return ActionHelper.isPresent(paymentType_Txt);
    }

    public void click_PaymentType_Txt(String paymentType) {
        Locator paymentMethod = Locator.builder().withWeb(By.xpath(dropDownList.replace("abc", paymentType)));
        ActionHelper.click(paymentType_Txt);
        ActionHelper.click(paymentMethod);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_Back_Btn() {
        return ActionHelper.isPresent(back_Btn);
    }

    public void click_Back_Btn() {
        ActionHelper.click(back_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_Create_Btn() {
        return ActionHelper.isPresent(create_Btn);
    }

    public void click_Create_Btn() {
        ActionHelper.click(create_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_ProductType_Txt() {
        return ActionHelper.getText(productType_Txt);
    }

    public String getText_ShipmentFlow_Txt() {
        return ActionHelper.getText(shipmentFlow_Txt);
    }
}
