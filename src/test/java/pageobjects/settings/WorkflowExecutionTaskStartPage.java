package pageobjects.settings;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import utility.Utility;

import java.util.List;

public class WorkflowExecutionTaskStartPage {
    private static WorkflowExecutionTaskStartPage _instance;
    private final Locator executionTaskDetailHeader_Lbl = Locator.builder().withWeb(By.xpath("//h1"));
    private final Locator createdOn_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Created On']"));
    private final Locator createdOnData_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Created On']/../.."));
    private final Locator updatedOn_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Updated On']"));
    private final Locator updatedOnData_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Updated On']/../.."));
    private final Locator aboutSubHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='About']"));
    private final Locator reasonCodeSubHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Reason Codes']"));
    private final Locator reasonCodeSubHeaderSuccessList_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Success']/following-sibling::p//p"));
    private final Locator reasonCodeSubHeaderFailureList_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Failure']/following-sibling::p//p"));

    public static WorkflowExecutionTaskStartPage getInstance() {
        if(_instance == null)
            _instance = new WorkflowExecutionTaskStartPage();
        return _instance;
    }

    public boolean isPresent_ExecutionTaskDetailHeader_Lbl() {
        return ActionHelper.isPresent(executionTaskDetailHeader_Lbl);
    }

    public String getText_ExecutionTaskDetailHeader_Lbl() {
        return ActionHelper.getText(executionTaskDetailHeader_Lbl);
    }

    public boolean isPresent_CreatedOn_Lbl() {
        return ActionHelper.isPresent(createdOn_Lbl);
    }

    public boolean isPresent_CreatedOnData_Lbl() {
        return ActionHelper.isPresent(createdOnData_Lbl);
    }

    public String getText_CreatedOnData_Lbl() {
        return ActionHelper.getAttribute(createdOnData_Lbl, "aria-label");
    }

    public boolean isPresent_UpdatedOn_Lbl() {
        return ActionHelper.isPresent(updatedOn_Lbl);
    }

    public String getText_UpdatedOnData_Lbl() {
        return ActionHelper.getAttribute(updatedOnData_Lbl, "aria-label");
    }

    public boolean isPresent_AboutSubHeader_Lbl() {
        return ActionHelper.isPresent(aboutSubHeader_Lbl);
    }

    public boolean isPresent_ReasonCodeSubHeader_Lbl() {
        return ActionHelper.isPresent(reasonCodeSubHeader_Lbl);
    }

    public boolean isPresent_ReasonCodeSubHeaderSuccessList_Lbl() {
        return ActionHelper.isPresent(reasonCodeSubHeaderSuccessList_Lbl);
    }

    public List<String> getList_ReasonCodeSubHeaderSuccessList_Lbl() {
      return Utility.getText_ListOfWebElements(reasonCodeSubHeaderSuccessList_Lbl.getBy());
    }

    public boolean isPresent_ReasonCodeSubHeaderFailureList_Lbl() {
        return ActionHelper.isPresent(reasonCodeSubHeaderFailureList_Lbl);
    }

    public List<String> getList_ReasonCodeSubHeaderFailureList_Lbl() {
        return Utility.getText_ListOfWebElements(reasonCodeSubHeaderFailureList_Lbl.getBy());
    }
}
