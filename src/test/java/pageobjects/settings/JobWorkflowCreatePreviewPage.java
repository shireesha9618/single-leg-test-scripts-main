package pageobjects.settings;

import constants.Constants;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import pageobjects.CommonActions;
import utility.Utility;

import java.util.List;

public class JobWorkflowCreatePreviewPage {
    private static JobWorkflowCreatePreviewPage _instance;
    private final Locator createPreviewHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[contains(text(),'Create a Workflow')]"));
    private final Locator jobWorkflowCreatePreviewBreadCrumb_Link = Locator.builder().withWeb(By.id("/settings/workflow/job-workflow/create-preview"));
    private final Locator search_Txt = Locator.builder().withWeb(By.id("search_ptp"));

    private final Locator status_Btn = Locator.builder().withWeb(By.xpath("//button/button"));
    private final Locator statusActive_RadioBtn = Locator.builder().withWeb(By.xpath("//span[text()='Active']"));
    private final Locator statusDraft_RadioBtn = Locator.builder().withWeb(By.xpath("//span[text()='Draft']"));
    private final Locator statusClearSelection_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Clear Selection']"));

    private final Locator newWorkflow_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/settings/workflow/job-workflow/create/']"));
    private final Locator cardMenuWorkflowName_List = Locator.builder().withWeb(By.xpath("//div[@class='flex flex-col space-y-2']/p"));
    private final Locator cardMenuWorkflowName_Lbl = Locator.builder().withWeb(By.xpath("(//div[@class='flex flex-col space-y-2']/p)[1]"));
    private final Locator cardMenuStatus_List = Locator.builder().withWeb(By.xpath("//div[@class='flex flex-col space-y-2']/div"));
    private final Locator cardMenuViewMore_Link = Locator.builder().withWeb(By.xpath("(//p[text()='View more'])[1]"));
    private final Locator cardMenuViewServiceAttributes_Link = Locator.builder().withWeb(By.xpath("(//p[text()='View Service Attributes'])[1]"));
    private final Locator cardMenuStatus_Lbl = Locator.builder().withWeb(By.xpath("(//h6/p)[1]"));

    public static JobWorkflowCreatePreviewPage getInstance() {
        if(_instance == null)
            _instance = new JobWorkflowCreatePreviewPage();
        return _instance;
    }

    public boolean isPresent_CreatePreviewHeader_Lbl() {
        return ActionHelper.isPresent(createPreviewHeader_Lbl);
    }

    public String getText_CreatePreviewHeader_Lbl() {
        return ActionHelper.getText(createPreviewHeader_Lbl);
    }

    public boolean isPresent_JobWorkflowCreatePreviewBreadCrumb_Link() {
        return ActionHelper.isPresent(jobWorkflowCreatePreviewBreadCrumb_Link);
    }

    public void click_JobWorkflowCreatePreviewBreadCrumb_Link() {
        ActionHelper.click(jobWorkflowCreatePreviewBreadCrumb_Link);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_Search_Txt() {
        return ActionHelper.isPresent(search_Txt);
    }

    public void fill_Search_Txt(String workflowName) {
        ActionHelper.sendKeysWithClear(search_Txt.getBy(), workflowName);
    }

    public boolean isPresent_Status_Btn() {
        return ActionHelper.isPresent(status_Btn);
    }

    public void click_Status_Btn() {
        ActionHelper.click(status_Btn);
    }

    public boolean isPresent_StatusActive_RadioBtn() {
        return ActionHelper.isPresent(statusActive_RadioBtn, Constants.WAIT_FOR_THREE_SECOND);
    }

    public void click_StatusActive_RadioBtn() {
        if (!isPresent_StatusActive_RadioBtn()) {
            click_Status_Btn();
        }
        Utility.clickRadio(statusActive_RadioBtn.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_StatusDraft_RadioBtn() {
        return ActionHelper.isPresent(statusDraft_RadioBtn);
    }

    public void click_StatusDraft_RadioBtn() {
        if (!isPresent_StatusDraft_RadioBtn()) {
            click_Status_Btn();
        }
        Utility.clickRadio(statusDraft_RadioBtn.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_StatusClearSelection_Btn() {
        return ActionHelper.isPresent(statusClearSelection_Btn);
    }

    public void click_StatusClearSelection_Btn() {
        if(!isPresent_StatusClearSelection_Btn())
            click_Status_Btn();
        ActionHelper.click(statusClearSelection_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_NewWorkflow_Link() {
        return ActionHelper.isPresent(newWorkflow_Link);
    }

    public void click_NewWorkflow_Link() {
        ActionHelper.click(newWorkflow_Link);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_CardMenuWorkflowName_List() {
        return ActionHelper.isPresent(cardMenuWorkflowName_List);
    }

    public List<String> getText_CardMenuWorkflowName_List() {
        return Utility.getText_ListOfWebElements(cardMenuWorkflowName_List.getBy());
    }

    public boolean isPresent_CardMenuWorkflowName_Lbl() {
        return ActionHelper.isPresent(cardMenuWorkflowName_Lbl);
    }

    public String getText_CardMenuWorkflowName_Lbl() {
        return ActionHelper.getText(cardMenuWorkflowName_Lbl);
    }

    public boolean isPresent_CardMenuStatus_List() {
        return ActionHelper.isPresent(cardMenuStatus_List);
    }

    public List<String> getText_CardMenuStatus_List() {
        return Utility.getText_ListOfWebElements(cardMenuStatus_List.getBy());
    }

    public boolean isPresent_CardMenuViewMore_Link() {
        return ActionHelper.isPresent(cardMenuViewMore_Link);
    }

    public void click_CardMenuViewMore_Link() {
        ActionHelper.click(cardMenuViewMore_Link);
    }

    public boolean isPresent_CardMenuViewServiceAttributes_Link() {
        return ActionHelper.isPresent(cardMenuViewServiceAttributes_Link);
    }

    public void click_CardMenuViewServiceAttributes_Link() {
        ActionHelper.click(cardMenuViewServiceAttributes_Link);
    }

    public boolean isPresent_CardMenuStatus_Lbl() {
        return ActionHelper.isPresent(cardMenuStatus_Lbl);
    }

    public String getText_CardMenuStatus_Lbl() {
        return ActionHelper.getText(cardMenuStatus_Lbl);
    }
}
