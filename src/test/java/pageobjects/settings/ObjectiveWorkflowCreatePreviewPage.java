package pageobjects.settings;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class ObjectiveWorkflowCreatePreviewPage {
    private static ObjectiveWorkflowCreatePreviewPage _instance;

    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Create a Workflow or select from an existing one']"));
    private final Locator homeBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/']/p[text()='Home']"));
    private final Locator settingsBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/settings/']/p[text()='Settings']"));
    private final Locator workflowBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/settings/workflow/']/p[text()='Workflow']"));
    private final Locator objectiveWorkflowsBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/settings/workflow/objective-workflow/list/']/p[text()='Objective Workflows']"));
    private final Locator objectiveWorkflowCreatePreviewBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//a[@href='/application/settings/workflow/objective-workflow/create-preview/']/p[text()='Objective Workflow Create Preview']"));
    private final Locator searchBar_Txt = Locator.builder().withWeb(By.id("search_ptp"));
    private final Locator status_DropDown = Locator.builder().withWeb(By.xpath("//button[p[text()='Status']]"));
    private final Locator statusDropDownActive_Radio = Locator.builder().withWeb(By.xpath("//span[text()='Active']/preceding-sibling::span/input[@type='radio']"));
    private final Locator statusDropDownDraft_Radio = Locator.builder().withWeb(By.xpath("//span[text()='Draft']/preceding-sibling::span/input[@type='radio']"));
    private final Locator statusDropDownClearSelection_Btn = Locator.builder().withWeb(By.xpath("//button[p[text()='Clear Selection']]"));
    private final Locator objectiveType_DropDown = Locator.builder().withWeb(By.xpath("//button[p[text()='Objective Type']]"));
    private final Locator objectiveTypeDropDownPickup_Radio = Locator.builder().withWeb(By.xpath("//span[text()='Pickup']/preceding-sibling::span/input[@type='radio']"));
    private final Locator objectiveTypeDropDownDrop_Radio = Locator.builder().withWeb(By.xpath("//span[text()='Drop']/preceding-sibling::span/input[@type='radio']"));
    private final Locator objectiveTypeDropDownReturn_Radio = Locator.builder().withWeb(By.xpath("//span[text()='Return']/preceding-sibling::span/input[@type='radio']"));
    private final Locator objectiveTypeDropDownClearSelection_Btn = Locator.builder().withWeb(By.xpath("//button[p[text()='Clear Selection']]"));
    private final Locator newWorkflow_Btn = Locator.builder().withWeb(By.xpath("//a[@href='/application/settings/workflow/objective-workflow/create/']"));
    private final Locator existingWorkflowTitle_ListBtn = Locator.builder().withWeb(By.xpath("//a[contains(@href, '/fpa/objective-workflow/create/?')]/div/div/p"));
    private final Locator existingWorkflowStatus_ListLbl = Locator.builder().withWeb(By.xpath("//a[contains(@href, '/fpa/objective-workflow/create/?')]/div/div[1]/div/h6/p"));
    private final Locator existingWorkflowViewMore_ListLink = Locator.builder().withWeb(By.xpath("//a[contains(@href, '/fpa/objective-workflow/create/?')]/div/div[2]/div/p[text()='View more']"));
    private final Locator existingWorkflowObjective1_ListLbl = Locator.builder().withWeb(By.xpath("//a[contains(@href, '/fpa/objective-workflow/create/?')]/div/div[3]/div[1]/h6/p"));
    private final Locator existingWorkflowObjective2_ListLbl = Locator.builder().withWeb(By.xpath("//a[contains(@href, '/fpa/objective-workflow/create/?')]/div/div[3]/div[2]/h6/p"));

    public static ObjectiveWorkflowCreatePreviewPage getInstance() {
        if (_instance == null) {
            _instance = new ObjectiveWorkflowCreatePreviewPage();
        }
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        return ActionHelper.isPresent(header_Lbl, 5000);
    }

    public String getText_Header_Lbl() {
        return ActionHelper.getText(header_Lbl);
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

    public boolean isPresent_SearchBar_Txt() {
        return ActionHelper.isPresent(searchBar_Txt);
    }

    public void fill_SearchBar_Txt(String value) {
        ActionHelper.fill(searchBar_Txt, value);
    }

    public void fillWithClear_SearchBar_Txt(String value) {
        ActionHelper.fillWithClear(searchBar_Txt.getBy(), value);
    }

    public void clear_SearchBar_Txt() {
        ActionHelper.clear(searchBar_Txt.getBy());
    }

    public String getValue_SearchBar_Txt() {
        return ActionHelper.getAttribute(searchBar_Txt, "value");
    }

    public boolean isPresent_Status_DropDown() {
        return ActionHelper.isPresent(status_DropDown);
    }

    public void click_Status_DropDown() {
        ActionHelper.click(status_DropDown);
    }

    public String getText_Status_DropDown() {
        return ActionHelper.getText(status_DropDown);
    }

    public boolean isPresent_StatusDropDownActive_Radio() {
        return ActionHelper.isPresent(statusDropDownActive_Radio);
    }

    public void click_StatusDropDownActive_Radio() {
        ActionHelper.click(statusDropDownActive_Radio);
    }

    public boolean isPresent_StatusDropDownDraft_Radio() {
        return ActionHelper.isPresent(statusDropDownDraft_Radio);
    }

    public void click_StatusDropDownDraft_Radio() {
        ActionHelper.click(statusDropDownDraft_Radio);
    }

    public boolean isPresent_StatusDropDownClearSelection_Btn() {
        return ActionHelper.isPresent(statusDropDownClearSelection_Btn);
    }

    public void click_StatusDropDownClearSelection_Btn() {
        ActionHelper.click(statusDropDownClearSelection_Btn);
    }

    public String getText_StatusDropDownClearSelection_Btn() {
        return ActionHelper.getText(statusDropDownClearSelection_Btn);
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

    public boolean isPresent_ObjectiveTypeDropDownPickup_Radio() {
        return ActionHelper.isPresent(objectiveTypeDropDownPickup_Radio);
    }

    public void click_ObjectiveTypeDropDownPickup_Radio() {
        ActionHelper.click(objectiveTypeDropDownPickup_Radio);
    }

    public boolean isPresent_ObjectiveTypeDropDownDrop_Radio() {
        return ActionHelper.isPresent(objectiveTypeDropDownDrop_Radio);
    }

    public void click_ObjectiveTypeDropDownDrop_Radio() {
        ActionHelper.click(objectiveTypeDropDownDrop_Radio);
    }

    public boolean isPresent_ObjectiveTypeDropDownReturn_Radio() {
        return ActionHelper.isPresent(objectiveTypeDropDownReturn_Radio);
    }

    public void click_ObjectiveTypeDropDownReturn_Radio() {
        ActionHelper.click(objectiveTypeDropDownReturn_Radio);
    }

    public boolean isPresent_ObjectiveTypeDropDownClearSelection_Btn() {
        return ActionHelper.isPresent(objectiveTypeDropDownClearSelection_Btn);
    }

    public void click_ObjectiveTypeDropDownClearSelection_Btn() {
        ActionHelper.click(objectiveTypeDropDownClearSelection_Btn);
    }

    public String getText_ObjectiveTypeDropDownClearSelection_Btn() {
        return ActionHelper.getText(objectiveTypeDropDownClearSelection_Btn);
    }

    public boolean isPresent_NewWorkflow_Btn() {
        return ActionHelper.isPresent(newWorkflow_Btn);
    }

    public void click_NewWorkflow_Btn() {
        ActionHelper.click(newWorkflow_Btn);
    }

    public String getText_NewWorkflow_Btn() {
        return ActionHelper.getText(newWorkflow_Btn);
    }

    public List<WebElement> getList_ExistingWorkflowTitle_ListBtn() {
        return ActionHelper.findElementsWithoutWait(existingWorkflowTitle_ListBtn.getBy());
    }

    public List<String> getText_ExistingWorkflowTitle_ListBtn() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(existingWorkflowTitle_ListBtn.getBy()));
    }

    public String getText_ExistingWorkflowTitle_ListBtn(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(existingWorkflowTitle_ListBtn.getBy()).get(index));
    }

    public void click_ExistingWorkflowTitle_ListBtn(int index) {
        ActionHelper.click(ActionHelper.findElements(existingWorkflowTitle_ListBtn.getBy()).get(index));
    }

    public List<WebElement> getList_ExistingWorkflowStatus_ListLbl() {
        return ActionHelper.findElementsWithoutWait(existingWorkflowStatus_ListLbl.getBy());
    }

    public List<String> getText_ExistingWorkflowStatus_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(existingWorkflowStatus_ListLbl.getBy()));
    }

    public String getText_ExistingWorkflowStatus_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(existingWorkflowStatus_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ExistingWorkflowViewMore_ListLink() {
        return ActionHelper.findElementsWithoutWait(existingWorkflowViewMore_ListLink.getBy());
    }

    public List<String> getText_ExistingWorkflowViewMore_ListLink() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(existingWorkflowViewMore_ListLink.getBy()));
    }

    public String getText_ExistingWorkflowViewMore_ListLink(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(existingWorkflowViewMore_ListLink.getBy()).get(index));
    }

    public void click_ExistingWorkflowViewMore_ListLink(int index) {
        ActionHelper.click(ActionHelper.findElements(existingWorkflowViewMore_ListLink.getBy()).get(index));
    }

    public List<WebElement> getList_ExistingWorkflowObjective1_ListLbl() {
        return ActionHelper.findElementsWithoutWait(existingWorkflowObjective1_ListLbl.getBy());
    }

    public List<String> getText_ExistingWorkflowObjective1_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(existingWorkflowObjective1_ListLbl.getBy()));
    }

    public String getText_ExistingWorkflowObjective1_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(existingWorkflowObjective1_ListLbl.getBy()).get(index));
    }

    public List<WebElement> getList_ExistingWorkflowObjective2_ListLbl() {
        return ActionHelper.findElementsWithoutWait(existingWorkflowObjective2_ListLbl.getBy());
    }

    public List<String> getText_ExistingWorkflowObjective2_ListLbl() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(existingWorkflowObjective2_ListLbl.getBy()));
    }

    public String getText_ExistingWorkflowObjective2_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(existingWorkflowObjective2_ListLbl.getBy()).get(index));
    }
}
