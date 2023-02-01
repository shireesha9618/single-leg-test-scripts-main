package pageobjects.settings;

import constants.Constants;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import pageobjects.CommonActions;
import utility.Utility;

import java.util.List;

public class ObjectiveWorkflowDetailPage {
    private static ObjectiveWorkflowDetailPage _instance;

    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//div[div/h6]/preceding-sibling::p"));
    private final Locator subHeader_Lbl = Locator.builder().withWeb(By.xpath("//h6/p"));
    private final Locator makeACopy_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Make a copy']"));
    private final Locator deactivate_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Deactivate']"));
    private final Locator deactivatePopUpHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='De-activate Workflow']"));
    private final Locator deactivatePopUpCross_Img = Locator.builder().withWeb(By.xpath("//p[text()='De-activate Workflow']/following-sibling::*"));
    private final Locator deactivatePopUpMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[p[text()='De-activate Workflow']]/following-sibling::div/div"));
    private final Locator deactivatePopUpCancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']"));
    private final Locator deactivatePopUpDeactivate_Btn = Locator.builder().withWeb(By.xpath("(//p[text()='Deactivate'])[last()]"));
    private final Locator saveAsDraft_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Save as Draft']"));
    private final Locator saveAsDraftPopUpHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Do you want to save this workflow as draft?']"));
    private final Locator saveAsDraftPopUpCancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']"));
    private final Locator saveAsDraftPopUpSaveAsDraft_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Save As Draft']"));
    private final Locator validate_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Validate']"));
    private final Locator description_Lbl = Locator.builder().withWeb(By.xpath("//h6[text()='Description']/following-sibling::p"));
    private final Locator objectiveType_Lbl = Locator.builder().withWeb(By.xpath("//h6[text()='Description']/following-sibling::div/span"));

    public static ObjectiveWorkflowDetailPage getInstance() {
        if (_instance == null) {
            _instance = new ObjectiveWorkflowDetailPage();
        }
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        return ActionHelper.isPresent(header_Lbl, Constants.WAIT_FOR_FIVE_SECOND);
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

    public boolean isPresent_MakeACopy_Btn() {
        return ActionHelper.isPresent(makeACopy_Btn);
    }

    public void click_MakeACopy_Btn() {
        ActionHelper.click(makeACopy_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_MakeACopy_Btn() {
        return ActionHelper.getText(makeACopy_Btn);
    }

    public boolean isPresent_Deactivate_Btn() {
        return ActionHelper.isPresent(deactivate_Btn);
    }

    public void click_Deactivate_Btn() {
        ActionHelper.click(deactivate_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_Deactivate_Btn() {
        return ActionHelper.getText(deactivate_Btn);
    }

    public boolean isPresent_DeactivatePopUpHeader_Lbl() {
        return ActionHelper.isPresent(deactivatePopUpHeader_Lbl);
    }

    public String getText_DeactivatePopUpHeader_Lbl() {
        return ActionHelper.getText(deactivatePopUpHeader_Lbl);
    }

    public boolean isPresent_DeactivatePopUpCross_Img() {
        return ActionHelper.isPresent(deactivatePopUpCross_Img);
    }

    public void click_DeactivatePopUpCross_Img() {
        ActionHelper.click(deactivatePopUpCross_Img);
    }

    public boolean isPresent_DeactivatePopUpMsg_Lbl() {
        return ActionHelper.isPresent(deactivatePopUpMsg_Lbl);
    }

    public String getText_DeactivatePopUpMsg_Lbl() {
        return ActionHelper.getText(deactivatePopUpMsg_Lbl);
    }

    public boolean isPresent_DeactivatePopUpCancel_Btn() {
        return ActionHelper.isPresent(deactivatePopUpCancel_Btn);
    }

    public void click_DeactivatePopUpCancel_Btn() {
        ActionHelper.click(deactivatePopUpCancel_Btn);
    }

    public String getText_DeactivatePopUpCancel_Btn() {
        return ActionHelper.getText(deactivatePopUpCancel_Btn);
    }

    public boolean isPresent_DeactivatePopUpDeactivate_Btn() {
        return ActionHelper.isPresent(deactivatePopUpDeactivate_Btn);
    }

    public void click_DeactivatePopUpDeactivate_Btn() {
        ActionHelper.click(deactivatePopUpDeactivate_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_DeactivatePopUpDeactivate_Btn() {
        return ActionHelper.getText(deactivatePopUpDeactivate_Btn);
    }

    public boolean isPresent_SaveAsDraft_Btn() {
        return ActionHelper.isPresent(saveAsDraft_Btn);
    }

    public void click_SaveAsDraft_Btn() {
        ActionHelper.click(saveAsDraft_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_SaveAsDraftPopUpHeader_Lbl() {
        return ActionHelper.isPresent(saveAsDraftPopUpHeader_Lbl);
    }

    public boolean isPresent_SaveAsDraftPopUpSaveAsDraft_Btn() {
        return ActionHelper.isPresent(saveAsDraftPopUpSaveAsDraft_Btn);
    }

    public void click_SaveAsDraftPopUpSaveAsDraft_Btn() {
        ActionHelper.click(saveAsDraftPopUpSaveAsDraft_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_SaveAsDraftPopUpCancel_Btn() {
        return ActionHelper.isPresent(saveAsDraftPopUpCancel_Btn);
    }

    public void click_SaveAsDraftPopUpCancel_Btn() {
        ActionHelper.click(saveAsDraftPopUpCancel_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_Validate_Btn() {
        return ActionHelper.isPresent(validate_Btn);
    }

    public void click_Validate_Btn() {
        ActionHelper.click(validate_Btn);
    }

    public String getText_Description_Lbl() {
        return ActionHelper.getText(description_Lbl);
    }

    public String getText_ObjectiveType_Lbl() {
        return ActionHelper.getText(objectiveType_Lbl.getBy());
    }
}
