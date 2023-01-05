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

    private final Locator popUpWindowWorkflowAlreadyExistHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Workflow already exists']"));
    private final Locator popUpWindowBack_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Back']/.."));
    private final Locator popUpWindowDeactivate_Btn = Locator.builder().withWeb(By.xpath("//p[text()='De-activate Existing Workflow']/.."));

    public static JobWorkflowActivePage getInstance() {
        if(_instance == null)
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

    public  boolean isPresent_ViewServiceAttributes_Btn() {
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
        return ActionHelper.isPresent(popUpWindowWorkflowAlreadyExistHeader_Lbl);
    }

    public String getText_PopUpWindowWorkflowAlreadyExistHeader_Lbl() {
        return ActionHelper.getText(popUpWindowWorkflowAlreadyExistHeader_Lbl);
    }

    public boolean isPresent_PopUpWindowBack_Btn() {
        return ActionHelper.isPresent(popUpWindowBack_Btn);
    }

    public void click_PopUpWindowBack_Btn() {
        ActionHelper.click(popUpWindowBack_Btn);
    }

    public boolean isPresent_PopUpWindowDeactivate_Btn() {
        return ActionHelper.isPresent(popUpWindowDeactivate_Btn);
    }

    public void click_PopUpWindowDeactivate_Btn() {
        ActionHelper.click(popUpWindowDeactivate_Btn);
    }
}
