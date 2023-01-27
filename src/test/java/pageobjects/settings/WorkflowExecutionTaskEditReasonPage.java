package pageobjects.settings;

import constants.Constants;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.CommonActions;
import utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class WorkflowExecutionTaskEditReasonPage {
    private static WorkflowExecutionTaskEditReasonPage _instance;
    private final Locator editReasonHeader_Lbl = Locator.builder().withWeb(By.xpath("//h2"));
    private final Locator executionTask_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Execution Task*']"));
    private final Locator successReasonCodes_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Success Reason Code(s)']"));
    private final Locator successReasonCode_List = Locator.builder().withWeb(By.xpath("//h4[text()='Success Reason Code(s)']/../following-sibling::div//span[@title]"));
    private final Locator failureReasonCode_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Failure Reason Code(s)']"));
    private final Locator failureReasonCode_List = Locator.builder().withWeb(By.xpath("//h4[text()='Failure Reason Code(s)']/../following-sibling::div//span[@title]"));
    private final Locator back_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Back']/.."));
    private final Locator save_Btn = Locator.builder().withWeb(By.id("submitForm"));
    private final Locator reasonCodeCross_Icon = Locator.builder().withWeb(By.xpath("(//div[@class='ant-select-selection-overflow']/div//span[@aria-label='close'])[1]"));
    private final Locator reasonCodeDropDown_List = Locator.builder().withWeb(By.xpath("//div[@class='rc-virtual-list-holder-inner']//div[@aria-selected='false']/div"));
    private final Locator successReasonCode_TxtField = Locator.builder().withWeb(By.xpath("//h4[text()='Success Reason Code(s)']/../following-sibling::div"));
    private final Locator failureReasonCode_TxtField = Locator.builder().withWeb(By.xpath("//h4[text()='Failure Reason Code(s)']/../following-sibling::div"));

    public static WorkflowExecutionTaskEditReasonPage getInstance() {
        if (_instance == null)
            _instance = new WorkflowExecutionTaskEditReasonPage();
        return _instance;
    }

    public boolean isPresent_EditReasonHeader_Lbl() {
        return ActionHelper.isPresent(editReasonHeader_Lbl, Constants.WAIT_FOR_THREE_SEC);
    }

    public String getText_EditReasonHeader_Lbl() {
        return ActionHelper.getText(editReasonHeader_Lbl);
    }

    public boolean isPresent_ExecutionTask_Lbl() {
        return ActionHelper.isPresent(executionTask_Lbl);
    }

    public boolean isPresent_SuccessReasonCodes_Lbl() {
        return ActionHelper.isPresent(successReasonCodes_Lbl);
    }

    public boolean isPresent_SuccessReasonCode_List() {
        return ActionHelper.isPresent(successReasonCode_List);
    }

    public List<String> getTextList_SuccessReasonCode_List() {
        return Utility.getText_ListOfWebElements(successReasonCode_List.getBy());
    }

    public boolean isPresent_FailureReasonCode_Lbl() {
        return ActionHelper.isPresent(failureReasonCode_Lbl);
    }

    public boolean isPresent_FailureReasonCode_List() {
        return ActionHelper.isPresent(failureReasonCode_List);
    }

    public List<String> getTextList_FailureReasonCode_List() {
        return Utility.getText_ListOfWebElements(failureReasonCode_List.getBy());
    }

    public boolean isPresent_Back_Btn() {
        return ActionHelper.isPresent(back_Btn);
    }

    public void click_Back_Btn() {
        ActionHelper.click(back_Btn);
    }

    public boolean isPresent_Save_Btn() {
        return ActionHelper.isPresent(save_Btn);
    }

    public void click_Save_Btn() {
        ActionHelper.click(save_Btn);
    }

    public boolean isPresent_ReasonCodeCross_Icon() {
        return ActionHelper.isPresent(reasonCodeCross_Icon);
    }

    public void click_ReasonCodeCross_Icon() {
        ActionHelper.click(reasonCodeCross_Icon);
    }

    private int getReasonCodeCount(String reasonCode) {
        int reasonCodeCount = 0;
        switch (reasonCode) {
            case "success":
                reasonCodeCount = WorkflowExecutionTaskEditReasonPage.getInstance().getTextList_SuccessReasonCode_List().size();
                break;
            case "failure":
                reasonCodeCount = WorkflowExecutionTaskEditReasonPage.getInstance().getTextList_FailureReasonCode_List().size();
                break;
        }
        return reasonCodeCount;
    }

    public boolean isPresent_SuccessReasonCode_TxtField() {
        return ActionHelper.isPresent(successReasonCode_TxtField);
    }

    public void click_SuccessReasonCode_TxtField() {
        ActionHelper.click(successReasonCode_TxtField);
    }


    public Set<String> allowedReasonCodesList(String reasonCode) {
        Set<String> reasonCodeList = new TreeSet<>();
        switch (reasonCode) {
            case "success":
                click_SuccessReasonCode_TxtField();
                break;
            case "failure":
                click_FailureReasonCode_TxtField();
                break;
        }
        CommonActions.getInstance().waitTillLoaderDisappears();
        ActionHelper.waitUntilElementVisible(reasonCodeDropDown_List.getBy());
        Utility.scrollDownUsingKeyboardKey(7);
        List<WebElement> reasonCodes;
        for (int i = 0; i < 11; i++) {
            Utility.scrollDownUsingKeyboardKey(7);
            ActionHelper.gotoSleep(4000);
            reasonCodes = ActionHelper.findElementsWithoutWait(reasonCodeDropDown_List.getBy());
            for (WebElement element : reasonCodes) {
                if (!element.getText().isEmpty())
                    reasonCodeList.add(element.getText());
            }
        }
        return reasonCodeList;
    }

    public void clickReasonCodes(String reasonCode, int noOfReasonCodes) {
        int count = 0;
        switch (reasonCode) {
            case "success":
                click_SuccessReasonCode_TxtField();
                break;
            case "failure":
                click_FailureReasonCode_TxtField();
                break;
        }
        CommonActions.getInstance().waitTillLoaderDisappears();
        ActionHelper.waitUntilElementVisible(reasonCodeDropDown_List.getBy());
        List<WebElement> reasonCodes = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Utility.scrollDownUsingKeyboardKey(7);
            reasonCodes = ActionHelper.findElementsWithoutWait(reasonCodeDropDown_List.getBy());
        }

        for (int i = 0; i < reasonCodes.size(); i++) {
            ActionHelper.click(reasonCodes.get(i));
            count++;
            if (noOfReasonCodes == count)
                break;
        }
    }

    public boolean isPresent_FailureReasonCode_TxtField() {
        return ActionHelper.isPresent(failureReasonCode_TxtField);
    }

    public void click_FailureReasonCode_TxtField() {
        ActionHelper.click(failureReasonCode_TxtField);
    }
}
