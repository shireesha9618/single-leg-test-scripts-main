package pageobjects.settings;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import utility.Utility;

public class JobWorkflowActivePage {
    private static JobWorkflowActivePage _instance;
    private final Locator jobWorkflowDetailHeader_Lbl = Locator.builder().withWeb(By.xpath("//div[@class='flex space-x-4']/p"));
    private final Locator activeStatus_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='active']"));
    private final Locator viewServiceAttributes_Btn = Locator.builder().withWeb(By.xpath("//p[text()='View Service Attributes']/.."));
    private final Locator makeACopy_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Make a copy']/.."));
    private final Locator deactivate_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Deactivate']/.."));

    private final Locator descriptionSubHeader_Lbl = Locator.builder().withWeb(By.xpath("//h6[text()='Description']"));
    private final Locator objectives_Lbl = Locator.builder().withWeb(By.xpath("//h6[contains(text(),'Objectives ')]"));
    private final Locator search_Txt = Locator.builder().withWeb(By.name("search-bar"));
    private final Locator tags_DropDown = Locator.builder().withWeb(By.className("css-1d8n9bt"));

    private final Locator diagram_Lbl = Locator.builder().withWeb(By.id("canvas"));
    private final Locator zoomIn_Btn = Locator.builder().withWeb(By.xpath("//button[text()='+']"));
    private final Locator zoomOut_Btn = Locator.builder().withWeb(By.xpath("//button[text()='-']"));
    private final Locator reset_Btn = Locator.builder().withWeb(By.xpath("//button[text()='RESET']"));

    private final Locator popUpWindowDeactivateWorkflowHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='De-activate Workflow']"));
    private final Locator popUpWindowCancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']/.."));
    private final Locator popUpWindowDeactivate_Btn = Locator.builder().withWeb(By.xpath("//div[contains(@class,'flex box-border')]//p[text()='Deactivate']/.."));

    private final Locator objectiveDiagram_Lbl = Locator.builder().withWeb(By.xpath("//div[@class='djs-container']//*[name()='svg']//*[name()='g' and contains(@class,'viewport')]//*[name()='g' and contains(@class,'layer-base')]//*[name()='g'][14]/*[name()='g'][1]/*[name()='rect'][1]"));

    private final Locator objectiveConfiguration_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Objective Configuration']/.."));
    private final Locator executionTaskWorkflowHeader_Lbl = Locator.builder().withWeb(By.xpath("//div[@class='w-full']//span"));
    private final Locator objectiveConfigurationName_Lbl = Locator.builder().withWeb(By.xpath("//div[text()='Name*']"));
    private final Locator connectors_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Connectors']/.."));
    private final Locator connector1_Lbl = Locator.builder().withWeb(By.xpath("//legend[text()='Connector 1']"));
    private final Locator connector1Destination_Lbl = Locator.builder().withWeb(By.xpath("//legend[text()='Connector 1']/..//div[text()='Destination']"));
    private final Locator connector1Status_Lbl = Locator.builder().withWeb(By.xpath("//legend[text()='Connector 1']/..//div[text()='Status']"));
    private final Locator connector1Reason_Lbl = Locator.builder().withWeb(By.xpath("//legend[text()='Connector 1']/..//div[text()='Reason']"));
    private final Locator connector2_Lbl = Locator.builder().withWeb(By.xpath("//legend[text()='Connector 2']"));
    private final Locator connector2Destination_Lbl = Locator.builder().withWeb(By.xpath("//legend[text()='Connector 2']/..//div[text()='Destination']"));
    private final Locator connector2Status_Lbl = Locator.builder().withWeb(By.xpath("//legend[text()='Connector 2']/..//div[text()='Status']"));
    private final Locator connector2Reason_Lbl = Locator.builder().withWeb(By.xpath("//legend[text()='Connector 2']/..//div[text()='Reason']"));

    private final Locator objectiveName_Lbl = Locator.builder().withWeb(By.xpath("(//section//div[@class='flex justify-between'])[1]"));


    public static JobWorkflowActivePage getInstance() {
        if (_instance == null)
            _instance = new JobWorkflowActivePage();
        return _instance;
    }

    public boolean isPresent_JobWorkflowDetailHeader_Lbl() {
        return ActionHelper.isPresent(jobWorkflowDetailHeader_Lbl);
    }

    public String getText_JobWorkflowDetailHeader_Lbl() {
        return ActionHelper.getText(jobWorkflowDetailHeader_Lbl).replace("Job Workflow - ", "");
    }

    public boolean isPresent_ActiveStatus_Lbl() {
        return ActionHelper.isPresent(activeStatus_Lbl);
    }

    public boolean isPresent_ViewServiceAttributes_Btn() {
        return ActionHelper.isPresent(viewServiceAttributes_Btn);
    }

    public void click_ViewServiceAttributes_Btn() {
        ActionHelper.click(viewServiceAttributes_Btn);
    }

    public boolean isPresent_MakeACopy_Btn() {
        return ActionHelper.isPresent(makeACopy_Btn);
    }

    public void click_MakeACopy_Btn() {
        ActionHelper.click(makeACopy_Btn);
    }

    public boolean isPresent_Deactivate_Btn() {
        return ActionHelper.isPresent(deactivate_Btn);
    }

    public void click_Deactivate_Btn() {
        ActionHelper.click(deactivate_Btn);
    }

    public boolean isPresent_DescriptionSubHeader_Lbl() {
        return ActionHelper.isPresent(descriptionSubHeader_Lbl);
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

    public boolean isPresent_PopUpWindowWorkflowAlreadyExistHeader_Lbl() {
        return ActionHelper.isPresent(popUpWindowDeactivateWorkflowHeader_Lbl);
    }

    public String getText_PopUpWindowWorkflowAlreadyExistHeader_Lbl() {
        return ActionHelper.getText(popUpWindowDeactivateWorkflowHeader_Lbl);
    }

    public boolean isPresent_PopUpWindowCancel_Btn() {
        return ActionHelper.isPresent(popUpWindowCancel_Btn);
    }

    public void click_PopUpWindowCancel_Btn() {
        ActionHelper.click(popUpWindowCancel_Btn);
    }

    public boolean isPresent_PopUpWindowDeactivate_Btn() {
        return ActionHelper.isPresent(popUpWindowDeactivate_Btn, 3000);
    }

    public void click_PopUpWindowDeactivate_Btn() {
        ActionHelper.click(popUpWindowDeactivate_Btn);
    }

    public boolean isPresent_ObjectiveName_Lbl() {
        return ActionHelper.isPresent(objectiveName_Lbl);
    }

    public String getText_ObjectiveName_Lbl() {
        return ActionHelper.getText(objectiveName_Lbl);
    }

    public String getText_ActiveStatus_Lbl() {
        return ActionHelper.getText(activeStatus_Lbl);
    }

    public boolean isPresent_ObjectiveConfiguration_Btn() {
        return ActionHelper.isPresent(objectiveConfiguration_Btn);
    }

    public void click_ObjectiveConfiguration_Btn() {
        ActionHelper.click(objectiveConfiguration_Btn);
    }

    public boolean isPresent_Connectors_Btn() {
        return ActionHelper.isPresent(connectors_Btn);
    }

    public void click_Connectors_Btn() {
        ActionHelper.click(connectors_Btn);
    }

    public boolean isPresent_ExecutionTaskWorkflowHeader_Lbl() {
        return ActionHelper.isPresent(executionTaskWorkflowHeader_Lbl);
    }

    public String getText_ExecutionTaskWorkflowHeader_Lbl() {
        return ActionHelper.getText(executionTaskWorkflowHeader_Lbl);
    }

    public boolean isPresent_ObjectiveConfigurationName_Lbl() {
        return ActionHelper.isPresent(objectiveConfigurationName_Lbl);
    }

    public String getText_ObjectiveConfigurationName_Lbl() {
        return ActionHelper.getText(objectiveConfigurationName_Lbl);
    }

    public boolean isPresent_Connector1_Lbl() {
        return ActionHelper.isPresent(connector1_Lbl);
    }

    public boolean isPresent_Connector1Destination_Lbl() {
        return ActionHelper.isPresent(connector1Destination_Lbl);
    }

    public String getText_Connector1Destination_Lbl() {
        return ActionHelper.getText(connector1Destination_Lbl);
    }

    public boolean isPresent_Connector1Status_Lbl() {
        return ActionHelper.isPresent(connector1Status_Lbl);
    }

    public String getText_Connector1Status_Lbl() {
        return ActionHelper.getText(connector1Status_Lbl);
    }

    public boolean isPresent_Connector1Reason_Lbl() {
        return ActionHelper.isPresent(connector1Reason_Lbl);
    }

    public String getText_Connector1Reason_Lbl() {
        return ActionHelper.getText(connector1Reason_Lbl);
    }

    public boolean isPresent_Connector2_Lbl() {
        return ActionHelper.isPresent(connector2_Lbl);
    }

    public boolean isPresent_Connector2Destination_Lbl() {
        return ActionHelper.isPresent(connector2Destination_Lbl);
    }

    public String getText_Connector2Destination_Lbl() {
        return ActionHelper.getText(connector2Destination_Lbl);
    }

    public boolean isPresent_Connector2Status_Lbl() {
        return ActionHelper.isPresent(connector2Status_Lbl);
    }

    public String getText_Connector2Status_Lbl() {
        return ActionHelper.getText(connector2Status_Lbl);
    }

    public boolean isPresent_Connector2Reason_Lbl() {
        return ActionHelper.isPresent(connector2Reason_Lbl);
    }

    public String getText_Connector2Reason_Lbl() {
        return ActionHelper.getText(connector2Reason_Lbl);
    }

    public boolean isPresent_ObjectiveDiagram_Lbl() {
        return ActionHelper.isPresent(objectiveDiagram_Lbl);
    }

    public void click_ObjectiveDiagram_Lbl() {
        ActionHelper.click(objectiveDiagram_Lbl);
    }
}
