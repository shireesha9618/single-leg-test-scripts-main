package pageobjects.settings;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import utility.Utility;

public class JobWorkflowDraftPage {
    private static JobWorkflowDraftPage _instance;
    private final Locator jobWorkflowDetailHeader_Lbl = Locator.builder().withWeb(By.xpath("//div[@class='flex space-x-4']/p"));
    private final Locator draftStatus_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='draft']"));
    private final Locator viewServiceAttributes_Btn = Locator.builder().withWeb(By.xpath("//p[text()='View Service Attributes']/.."));
    private final Locator saveAsDraft_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Save as Draft']/.."));
    private final Locator validate_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Validate']/.."));

    private final Locator objectives_Lbl = Locator.builder().withWeb(By.xpath("//h6[contains(text(),'Objectives ')]"));
    private final Locator search_Txt = Locator.builder().withWeb(By.name("search-bar"));
    private final Locator tags_DropDown = Locator.builder().withWeb(By.className("css-1d8n9bt"));

    private final Locator diagram_Lbl = Locator.builder().withWeb(By.id("canvas"));
    private final Locator zoomIn_Btn = Locator.builder().withWeb(By.xpath("//button[text()='+']"));
    private final Locator zoomOut_Btn = Locator.builder().withWeb(By.xpath("//button[text()='-']"));
    private final Locator reset_Btn = Locator.builder().withWeb(By.xpath("//button[text()='RESET']"));

    private final Locator saveAsDraftPopUp_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Save As Draft']/.."));
    private final Locator cancelPopUp_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']/.."));

    private final Locator serviceAttributeHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Service Attributes']"));
    private final Locator serviceAttributeDoorStepAttributeSubHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Doorstep Attributes']"));
    private final Locator doorStepAttributeKYCVerification_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='KYC Verification']"));
    private final Locator doorStepAttributeKYCVerification_Txt = Locator.builder().withWeb(By.xpath("//p[text()='KYC Verification']/following-sibling::p"));
    private final Locator doorStepAttributeOTPVerification_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='OTP Verification']"));
    private final Locator doorStepAttributeOTPVerification_Txt = Locator.builder().withWeb(By.xpath("//p[text()='OTP Verification']/following-sibling::p"));
    private final Locator doorStepAttributeQCVerification_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='QC Verification']"));
    private final Locator doorStepAttributeQCVerification_Txt = Locator.builder().withWeb(By.xpath("//p[text()='QC Verification']/following-sibling::p"));
    private final Locator doorStepAttributeSignatureCollection_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Signature Collection']"));
    private final Locator doorStepAttributeSignatureCollection_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Signature Collection']/following-sibling::p"));
    private final Locator doorStepAttributePaymentOption_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Payment Option']"));
    private final Locator doorStepAttributePaymentOption_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Payment Option']/following-sibling::p"));
    private final Locator doorStepAttributePaymentType_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Payment Type']"));
    private final Locator doorStepAttributePaymentType_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Payment Type']/following-sibling::p"));

    private final Locator serviceAttributeOrderAttributeSubHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Order Attributes']"));
    private final Locator orderAttributePlanningMode_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Planning Mode']"));
    private final Locator orderAttributePlanningMode_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Planning Mode']/following-sibling::p"));
    private final Locator orderAttributeProductType_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Product Type']"));
    private final Locator orderAttributeProductType_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Product Type']/following-sibling::p"));
    private final Locator orderAttributeShipmentFlow_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Shipment Flow']"));
    private final Locator orderAttributeShipmentFlow_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Shipment Flow']/following-sibling::p"));
    private final Locator serviceAttributeBack_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Back']/.."));
    private final Locator validationMessagePopUp_Lbl = Locator.builder().withWeb(By.xpath("//div[@class='flex items-start']//p"));
    private final Locator dismiss_Btn = Locator.builder().withWeb(By.xpath("//div[@class='flex items-start']//button[text()]"));
    private final Locator close_Btn = Locator.builder().withWeb(By.xpath("//span[text()='Close']/.."));

    public static JobWorkflowDraftPage getInstance() {
        if (_instance == null)
            _instance = new JobWorkflowDraftPage();
        return _instance;
    }

    public boolean isPresent_JobWorkflowDetailHeader_Lbl() {
        return ActionHelper.isPresent(jobWorkflowDetailHeader_Lbl);
    }

    public String getText_JobWorkflowDetailHeader_Lbl() {
        return ActionHelper.getText(jobWorkflowDetailHeader_Lbl).replace("Job Workflow - ", "");
    }

    public boolean isPresent_DraftStatus_Lbl() {
        return ActionHelper.isPresent(draftStatus_Lbl);
    }

    public String getText_DraftStatus_Lbl() {
        return ActionHelper.getText(draftStatus_Lbl);
    }

    public boolean isPresent_ViewServiceAttributes_Btn() {
        return ActionHelper.isPresent(viewServiceAttributes_Btn);
    }

    public void click_ViewServiceAttributes_Btn() {
        ActionHelper.click(viewServiceAttributes_Btn);
    }

    public boolean isPresent_SaveAsDraft_Btn() {
        return ActionHelper.isPresent(saveAsDraft_Btn);
    }

    public void click_SaveAsDraft_Btn() {
        ActionHelper.click(saveAsDraft_Btn);
    }

    public boolean isPresent_Validate_Btn() {
        return ActionHelper.isPresent(validate_Btn);
    }

    public void click_Validate_Btn() {
        ActionHelper.click(validate_Btn);
    }

    public boolean isPresent_Objectives_Lbl() {
        return ActionHelper.isPresent(objectives_Lbl);
    }

    public boolean isPresent_Search_Txt() {
        return ActionHelper.isPresent(search_Txt);
    }

    public void fill_Search_Txt(String objectiveName) {
        Utility.sendKeysWithClear(search_Txt.getBy(), objectiveName);
    }

    public boolean isPresent_Tags_DropDown() {
        return ActionHelper.isPresent(tags_DropDown);
    }

    public void click_Tags_DropDown() {
        ActionHelper.click(tags_DropDown);
    }

    public boolean isPresent_Diagram_Lbl() {
        return ActionHelper.isPresent(diagram_Lbl);
    }

    public boolean isPresent_ZoomIn_Btn() {
        return ActionHelper.isPresent(zoomIn_Btn);
    }

    public void click_ZoomIn_Btn() {
        ActionHelper.click(zoomIn_Btn);
    }

    public boolean isPresent_ZoomOut_Btn() {
        return ActionHelper.isPresent(zoomOut_Btn);
    }

    public void click_ZoomOut_Btn() {
        ActionHelper.click(zoomOut_Btn);
    }

    public boolean isPresent_Reset_Btn() {
        return ActionHelper.isPresent(reset_Btn);
    }

    public void click_Reset_Btn() {
        ActionHelper.click(reset_Btn);
    }

    public boolean isPresent_SaveAsDraftPopUp_Btn() {
        return ActionHelper.isPresent(saveAsDraftPopUp_Btn);
    }

    public void click_SaveAsDraftPopUp_Btn() {
        ActionHelper.click(saveAsDraftPopUp_Btn);
    }

    public boolean isPresent_CancelPopUp_Btn() {
        return ActionHelper.isPresent(cancelPopUp_Btn);
    }

    public void click_CancelPopUp_Btn() {
        ActionHelper.click(cancelPopUp_Btn);
    }

    public boolean isPresent_ServiceAttributeHeader_Lbl() {
        return ActionHelper.isPresent(serviceAttributeHeader_Lbl);
    }

    public String getText_ServiceAttributeHeader_Lbl() {
        return ActionHelper.getText(serviceAttributeHeader_Lbl);
    }

    public boolean isPresent_ServiceAttributeDoorStepAttributeSubHeader_Lbl() {
        return ActionHelper.isPresent(serviceAttributeDoorStepAttributeSubHeader_Lbl);
    }

    public String getText_ServiceAttributeDoorStepAttributeSubHeader_Lbl() {
        return ActionHelper.getText(serviceAttributeDoorStepAttributeSubHeader_Lbl);
    }

    public boolean isPresent_DoorStepAttributeKYCVerification_Lbl() {
        return ActionHelper.isPresent(doorStepAttributeKYCVerification_Lbl);
    }

    public boolean isPresent_DoorStepAttributeKYCVerification_Txt() {
        return ActionHelper.isPresent(doorStepAttributeKYCVerification_Txt);
    }

    public String getText_DoorStepAttributeKYCVerification_Txt() {
        return ActionHelper.getText(doorStepAttributeKYCVerification_Txt);
    }

    public boolean isPresent_DoorStepAttributeOTPVerification_Lbl() {
        return ActionHelper.isPresent(doorStepAttributeOTPVerification_Lbl);
    }

    public boolean isPresent_DoorStepAttributeOTPVerification_Txt() {
        return ActionHelper.isPresent(doorStepAttributeOTPVerification_Txt);
    }

    public String getText_DoorStepAttributeOTPVerification_Txt() {
        return ActionHelper.getText(doorStepAttributeOTPVerification_Txt);
    }

    public boolean isPresent_DoorStepAttributeQCVerification_Lbl() {
        return ActionHelper.isPresent(doorStepAttributeQCVerification_Lbl);
    }

    public boolean isPresent_DoorStepAttributeQCVerification_Txt() {
        return ActionHelper.isPresent(doorStepAttributeQCVerification_Txt);
    }

    public String getText_DoorStepAttributeQCVerification_Txt() {
        return ActionHelper.getText(doorStepAttributeQCVerification_Txt);
    }

    public boolean isPresent_DoorStepAttributeSignatureCollection_Lbl() {
        return ActionHelper.isPresent(doorStepAttributeSignatureCollection_Lbl);
    }

    public boolean isPresent_DoorStepAttributeSignatureCollection_Txt() {
        return ActionHelper.isPresent(doorStepAttributeSignatureCollection_Txt);
    }

    public String getText_DoorStepAttributeSignatureCollection_Txt() {
        return ActionHelper.getText(doorStepAttributeSignatureCollection_Txt);
    }

    public boolean isPresent_DoorStepAttributePaymentOption_Lbl() {
        return ActionHelper.isPresent(doorStepAttributePaymentOption_Lbl);
    }

    public boolean isPresent_DoorStepAttributePaymentOption_Txt() {
        return ActionHelper.isPresent(doorStepAttributePaymentOption_Txt);
    }

    public String getText_DoorStepAttributePaymentOption_Txt() {
        return ActionHelper.getText(doorStepAttributePaymentOption_Txt);
    }

    public boolean isPresent_DoorStepAttributePaymentType_Lbl() {
        return ActionHelper.isPresent(doorStepAttributePaymentType_Lbl);
    }

    public boolean isPresent_DoorStepAttributePaymentType_Txt() {
        return ActionHelper.isPresent(doorStepAttributePaymentType_Txt);
    }

    public String getText_DoorStepAttributePaymentType_Txt() {
        return ActionHelper.getText(doorStepAttributePaymentType_Txt);
    }

    public boolean isPresent_ServiceAttributeOrderAttributeSubHeader_Lbl() {
        return ActionHelper.isPresent(serviceAttributeOrderAttributeSubHeader_Lbl);
    }

    public String getText_ServiceAttributeOrderAttributeSubHeader_Lbl() {
        return ActionHelper.getText(serviceAttributeOrderAttributeSubHeader_Lbl);
    }

    public boolean isPresent_OrderAttributePlanningMode_Lbl() {
        return ActionHelper.isPresent(orderAttributePlanningMode_Lbl);
    }

    public boolean isPresent_OrderAttributePlanningMode_Txt() {
        return ActionHelper.isPresent(orderAttributePlanningMode_Txt);
    }

    public String getText_OrderAttributePlanningMode_Txt() {
        return ActionHelper.getText(orderAttributePlanningMode_Txt);
    }

    public boolean isPresent_OrderAttributeProductType_Lbl() {
        return ActionHelper.isPresent(orderAttributeProductType_Lbl);
    }

    public boolean isPresent_OrderAttributeProductType_Txt() {
        return ActionHelper.isPresent(orderAttributeProductType_Txt);
    }

    public String getText_OrderAttributeProductType_Txt() {
        return ActionHelper.getText(orderAttributeProductType_Txt);
    }

    public boolean isPresent_OrderAttributeShipmentFlow_Lbl() {
        return ActionHelper.isPresent(orderAttributeShipmentFlow_Lbl);
    }

    public boolean isPresent_OrderAttributeShipmentFlow_Txt() {
        return ActionHelper.isPresent(orderAttributeShipmentFlow_Txt);
    }

    public String getText_OrderAttributeShipmentFlow_Txt() {
        return ActionHelper.getText(orderAttributeShipmentFlow_Txt);
    }

    public boolean isPresent_ServiceAttributeBack_Btn() {
        return ActionHelper.isPresent(serviceAttributeBack_Btn);
    }

    public void click_ServiceAttributeBack_Btn() {
        ActionHelper.click(serviceAttributeBack_Btn);
    }

    public boolean isPresent_ValidationMessagePopUp_Lbl() {
        return ActionHelper.isPresent(validationMessagePopUp_Lbl);
    }

    public String getText_ValidationMessagePopUp_Lbl() {
        return ActionHelper.getText(validationMessagePopUp_Lbl);
    }

    public boolean isPresent_Dismiss_Btn() {
        return ActionHelper.isPresent(dismiss_Btn);
    }

    public void click_Dismiss_Btn() {
        ActionHelper.click(dismiss_Btn);
    }

    public boolean isPresent_Close_Btn() {
        return ActionHelper.isPresent(close_Btn);
    }

    public void click_Close_Btn() {
        ActionHelper.click(close_Btn);
    }
}
