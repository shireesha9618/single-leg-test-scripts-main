package pageobjects.settings;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.CommonActions;
import utility.Utility;

import java.util.List;

public class JobWorkflowPage {
    private static JobWorkflowPage _instance;
    private final Locator jobWorkflowsHeader_Lbl = Locator.builder().withWeb(By.xpath("//div/p[text()='Job Workflows']"));
    private final Locator jobWorkflowsBreadCrumb_Link = Locator.builder().withWeb(By.id("/settings/workflow/job-workflow/list"));
    private final Locator active_Btn = Locator.builder().withWeb(By.xpath("//button/p[contains(text(),'Active')]"));
    private final Locator draft_Btn = Locator.builder().withWeb(By.xpath("//button/p[contains(text(),'Draft')]"));
    private final Locator create_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Create']/.."));
    private final Locator search_Text = Locator.builder().withWeb(By.id("search"));

    private final Locator tableColumnName_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Name']"));
    private final Locator tableColumnDescription_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Description']"));
    private final Locator tableColumnStatus_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Status']"));
    private final Locator tableColumnProductType_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Product Type']"));
    private final Locator tableColumnShipmentflow_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Shipment Flow']"));
    private final Locator tableColumnPlanningMode_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Planning Mode']"));
    private final Locator tableColumnCreatedBy_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Created By']"));
    private final Locator tableColumnUpdatedOn_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Updated On']"));
    private final Locator tableColumnUpdatedBy_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Updated By']"));
    private final Locator dataTable_Lbl = Locator.builder().withWeb(By.xpath("//div[@class='ant-table-body']"));
    private final Locator dataTableColumnName_List = Locator.builder().withWeb(By.xpath("//tr/td[1][@class]"));

    public static JobWorkflowPage getInstance() {
        if(_instance == null)
            _instance = new JobWorkflowPage();
        return _instance;
    }

    public boolean isPresent_JobWorkflowsHeader_Lbl() {
        return ActionHelper.isPresent(jobWorkflowsHeader_Lbl);
    }

    public String getText_JobWorkflowsHeader_Lbl() {
        return ActionHelper.getText(jobWorkflowsHeader_Lbl);
    }

    public boolean isPresent_JobWorkflowsBreadCrumb_Link() {
        return ActionHelper.isPresent(jobWorkflowsBreadCrumb_Link, 2000);
    }

    public void click_JobWorkflowsBreadCrumb_Link() {
        ActionHelper.click(jobWorkflowsBreadCrumb_Link);
    }

    public boolean isPresent_Active_Btn() {
        return ActionHelper.isPresent(active_Btn);
    }

    public void click_Active_Btn() {
        ActionHelper.click(active_Btn);
    }

    public boolean isPresent_Draft_Btn() {
        return ActionHelper.isPresent(draft_Btn);
    }

    public void click_Draft_Btn() {
        ActionHelper.click(draft_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_Create_Btn() {
        return ActionHelper.isPresent(create_Btn);
    }

    public void click_Create_Btn() {
        ActionHelper.click(create_Btn);
    }

    public boolean isEnabled_Create_Btn() {
        return ActionHelper.isEnabled(create_Btn.getBy());
    }

    public boolean isPresent_Search_Text() {
        return ActionHelper.isPresent(search_Text);
    }

    public void fill_Search_Text(String workflowName) {
        ActionHelper.sendKeysWithClear(search_Text.getBy(), workflowName);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_TableColumnName_Lbl() {
        return ActionHelper.isPresent(tableColumnName_Lbl);
    }

    public boolean isPresent_TableColumnDescription_Lbl() {
        return ActionHelper.isPresent(tableColumnDescription_Lbl);
    }

    public boolean isPresent_TableColumnStatus_Lbl() {
        return ActionHelper.isPresent(tableColumnStatus_Lbl);
    }

    public boolean isPresent_TableColumnProductType_Lbl() {
        return ActionHelper.isPresent(tableColumnProductType_Lbl);
    }

    public boolean isPresent_TableColumnShipmentflow_Lbl() {
        return ActionHelper.isPresent(tableColumnShipmentflow_Lbl);
    }

    public boolean isPresent_TableColumnPlanningMode_Lbl() {
        return ActionHelper.isPresent(tableColumnPlanningMode_Lbl);
    }

    public boolean isPresent_TableColumnCreatedBy_Lbl() {
        return ActionHelper.isPresent(tableColumnCreatedBy_Lbl);
    }

    public boolean isPresent_TableColumnUpdatedOn_Lbl() {
        return ActionHelper.isPresent(tableColumnUpdatedOn_Lbl);
    }

    public void click_DataTable_Lbl() {
        ActionHelper.click(dataTable_Lbl);
    }

    public boolean isPresent_TableColumnUpdatedBy_Lbl() {
        click_DataTable_Lbl();
        Utility.scrollRightUsingKeyboardKey(5);
        return ActionHelper.isPresent(tableColumnUpdatedBy_Lbl, 2000);
    }

    public List<WebElement> getList_DataTableColumnName_List() {
        return ActionHelper.findElements(dataTableColumnName_List);
    }
}
