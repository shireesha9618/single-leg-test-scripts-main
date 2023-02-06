package pageobjects.settings;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import utility.Utility;

public class VehicleCustomAttribute {
    private static VehicleCustomAttribute _instance;
    private final Locator customAttributesHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Custom Attributes']"));
    private final Locator search_Txt = Locator.builder().withWeb(By.id("search_ptp"));
    private final Locator addCustomAttribute = Locator.builder().withWeb(By.xpath("//p[text()='Add Custom Attributes']/.."));

    private final Locator dataTypeDropDown_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Data Type']/parent::button"));
    private final Locator dataTypeDropDownInteger_RadioBtn = Locator.builder().withWeb(By.xpath("//span[text()='Integer']/parent::label"));
    private final Locator dataTypeDropDownString_RadioBtn = Locator.builder().withWeb(By.xpath("//span[text()='String']/parent::label"));
    private final Locator dataTypeDropDownFloat_RadioBtn = Locator.builder().withWeb(By.xpath("//span[text()='Float']/parent::label"));
    private final Locator dataTypeDropDown_List = Locator.builder().withWeb(By.xpath("//label[@class='ant-radio-wrapper']/.."));
    private final Locator dataTypeDropDownClearSelection_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Clear Selection']//button"));

    private final Locator tableActionsDropDown_DropDownBtn = Locator.builder().withWeb(By.xpath("//p[text()='Table Actions']/.."));
    private final Locator tableActionsDropDownExportAsCSV_Link = Locator.builder().withWeb(By.xpath("//a[text()='Export as CSV']"));
    private final Locator tableActionsDropDownModifyColumns_Link = Locator.builder().withWeb(By.xpath("//a[text()='Modify Columns']"));
    private final Locator tableActionsModifyColumnsHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Edit Columns']"));
    private final Locator tableActionsModifyColumnsSearch_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Search']"));
    private final Locator tableActionsModifyColumnsSelectAll_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Select All']/.."));
    private final Locator tableActionsModifyColumnsAttributeName_CheckBox = Locator.builder().withWeb(By.xpath("//p[text()='Attribute Name']"));
    private final Locator tableActionsModifyColumnsDescription_CheckBox = Locator.builder().withWeb(By.xpath("//p[text()='Description']"));
    private final Locator tableActionsModifyColumnsDataType_CheckBox = Locator.builder().withWeb(By.xpath("//p[text()='Data Type']"));
    private final Locator tableActionsModifyColumnsAttributeType_CheckBox = Locator.builder().withWeb(By.xpath("//p[text()='Attribute Type']"));
    private final Locator tableActionsModifyColumnsAttributeName_DragDrop = Locator.builder().withWeb(By.xpath("//div[@data-rbd-draggable-id='Attribute Name']"));
    private final Locator tableActionsModifyColumnsDescription_DragDrop = Locator.builder().withWeb(By.xpath("//div[@data-rbd-draggable-id='Description']"));
    private final Locator tableActionsModifyColumnsDataType_DragDrop = Locator.builder().withWeb(By.xpath("//div[@data-rbd-draggable-id='Data Type']"));
    private final Locator tableActionsModifyColumnsAttributeType_DragDrop = Locator.builder().withWeb(By.xpath("//div[@data-rbd-draggable-id='Attribute Type']"));
    private final Locator tableActionsModifyColumnsCancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']/.."));
    private final Locator tableActionsModifyColumnsSave_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Save']/.."));

    public static VehicleCustomAttribute getInstance() {
        if(_instance == null)
            _instance = new VehicleCustomAttribute();
        return _instance;
    }

    public boolean isPresent_CustomAttributesHeader_Lbl() {
        return ActionHelper.isPresent(customAttributesHeader_Lbl);
    }

    public String getText_CustomAttributesHeader_Lbl() {
        return ActionHelper.getText(customAttributesHeader_Lbl);
    }

    public boolean isPresent_Search_Txt() {
        return ActionHelper.isPresent(search_Txt);
    }

    public void fill_Search_Txt(String attributeName) {
        Utility.sendKeysWithClear(search_Txt.getBy(), attributeName);
    }

    public boolean isPresent_AddCustomAttribute() {
        return ActionHelper.isPresent(addCustomAttribute);
    }

    public void click_AddCustomAttribute() {
        ActionHelper.click(addCustomAttribute);
    }

    public boolean isPresent_DataTypeDropDown_Btn() {
        return ActionHelper.isPresent(dataTypeDropDown_Btn);
    }

    public void click_DataTypeDropDown_Btn() {
        ActionHelper.click(dataTypeDropDown_Btn);
    }

    public boolean isPresent_DataTypeDropDownInteger_RadioBtn() {
        return ActionHelper.isPresent(dataTypeDropDownInteger_RadioBtn);
    }

    public boolean isPresent_DataTypeDropDownString_RadioBtn() {
        return ActionHelper.isPresent(dataTypeDropDownString_RadioBtn);
    }

    public boolean isPresent_DataTypeDropDownFloat_RadioBtn() {
        return ActionHelper.isPresent(dataTypeDropDownFloat_RadioBtn);
    }

    public void click_DataTypeDropDown_RadioBtn(String option) {
        Utility.select_FromDropDown_List(dataTypeDropDown_Btn.getBy(), dataTypeDropDown_List.getBy(), option);
    }

    public boolean isPresent_DataTypeDropDownClearSelection_Btn() {
        return ActionHelper.isPresent(dataTypeDropDownClearSelection_Btn);
    }

    public void click_DataTypeDropDownClearSelection_Btn() {
        ActionHelper.click(dataTypeDropDownClearSelection_Btn);
    }

    public boolean isPresent_TableActionsDropDown_DropDownBtn() {
        return ActionHelper.isPresent(tableActionsDropDown_DropDownBtn);
    }

    public void click_TableActionsDropDown_DropDownBtn() {
        ActionHelper.click(tableActionsDropDown_DropDownBtn);
    }

    public boolean isPresent_TableActionsDropDownExportAsCSV_Link() {
        return ActionHelper.isPresent(tableActionsDropDownExportAsCSV_Link);
    }

    public void click_TableActionsDropDownExportAsCSV_Link() {
        ActionHelper.click(tableActionsDropDownExportAsCSV_Link);
    }

    public boolean isPresent_TableActionsDropDownModifyColumns_Link() {
        return ActionHelper.isPresent(tableActionsDropDownModifyColumns_Link);
    }

    public void click_TableActionsDropDownModifyColumns_Link() {
        ActionHelper.click(tableActionsDropDownModifyColumns_Link);
    }

    public boolean isPresent_TableActionsModifyColumnsHeader_Lbl() {
        return ActionHelper.isPresent(tableActionsModifyColumnsHeader_Lbl);
    }

    public String getText_TableActionsModifyColumnsHeader_Lbl() {
        return ActionHelper.getText(tableActionsModifyColumnsHeader_Lbl);
    }

    public boolean isPresent_TableActionsModifyColumnsSearch_Txt() {
        return ActionHelper.isPresent(tableActionsModifyColumnsSearch_Txt);
    }

    public void fill_TableActionsModifyColumnsSearch_Txt(String columnName) {
        Utility.sendKeysWithClear(tableActionsModifyColumnsSearch_Txt.getBy(), columnName);
    }

    public boolean isPresent_TableActionsModifyColumnsSelectAll_Btn() {
        return ActionHelper.isPresent(tableActionsModifyColumnsSelectAll_Btn);
    }

    public void click_TableActionsModifyColumnsSelectAll_Btn() {
        ActionHelper.click(tableActionsModifyColumnsSelectAll_Btn);
    }

    public boolean isPresent_TableActionsModifyColumnsAttributeName_CheckBox() {
        return ActionHelper.isPresent(tableActionsModifyColumnsAttributeName_CheckBox);
    }

    public void click_TableActionsModifyColumnsAttributeName_CheckBox() {
        Utility.checkCheckbox(tableActionsModifyColumnsAttributeName_CheckBox.getBy());
    }

    public boolean isPresent_TableActionsModifyColumnsDescription_CheckBox() {
        return ActionHelper.isPresent(tableActionsModifyColumnsDescription_CheckBox);
    }

    public void click_TableActionsModifyColumnsDescription_CheckBox() {
        Utility.checkCheckbox(tableActionsModifyColumnsDescription_CheckBox.getBy());
    }

    public boolean isPresent_TableActionsModifyColumnsDataType_CheckBox() {
        return ActionHelper.isPresent(tableActionsModifyColumnsDataType_CheckBox);
    }

    public void click_TableActionsModifyColumnsDataType_CheckBox() {
        Utility.checkCheckbox(tableActionsModifyColumnsDataType_CheckBox.getBy());
    }

    public boolean isPresent_TableActionsModifyColumnsAttributeType_CheckBox() {
        return ActionHelper.isPresent(tableActionsModifyColumnsAttributeType_CheckBox);
    }

    public void click_TableActionsModifyColumnsAttributeType_CheckBox() {
        Utility.checkCheckbox(tableActionsModifyColumnsAttributeType_CheckBox.getBy());
    }

    public boolean isPresent_TableActionsModifyColumnsAttributeName_DragDrop() {
        return ActionHelper.isPresent(tableActionsModifyColumnsAttributeName_DragDrop);
    }

    public boolean isPresent_TableActionsModifyColumnsDescription_DragDrop() {
        return ActionHelper.isPresent(tableActionsModifyColumnsDescription_DragDrop);
    }

    public boolean isPresent_TableActionsModifyColumnsDataType_DragDrop() {
        return ActionHelper.isPresent(tableActionsModifyColumnsDataType_DragDrop);
    }

    public boolean isPresent_TableActionsModifyColumnsAttributeType_DragDrop() {
        return ActionHelper.isPresent(tableActionsModifyColumnsAttributeType_DragDrop);
    }

    public boolean isPresent_TableActionsModifyColumnsCancel_Btn() {
        return ActionHelper.isPresent(tableActionsModifyColumnsCancel_Btn);
    }

    public void click_TableActionsModifyColumnsCancel_Btn() {
        ActionHelper.click(tableActionsModifyColumnsCancel_Btn);
    }

    public boolean isPresent_TableActionsModifyColumnsSave_Btn() {
        return ActionHelper.isPresent(tableActionsModifyColumnsSave_Btn);
    }

    public void click_TableActionsModifyColumnsSave_Btn() {
        ActionHelper.click(tableActionsModifyColumnsSave_Btn);
    }
}
