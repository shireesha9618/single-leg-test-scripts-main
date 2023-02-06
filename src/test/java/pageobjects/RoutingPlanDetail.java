package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class RoutingPlanDetail {
    private static RoutingPlanDetail _instance;
    private final Locator enterPlanDetailHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Enter Plan Details']"));
    private final Locator planByVehicleModel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Plan by Vehicle Model']/ancestor::button"));
    private final Locator search_TxtBox = Locator.builder().withWeb(By.xpath("//input[@placeholder='Search Vehicle by ID']"));
    private final Locator modelName_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Model Name']/../.."));
    private final Locator planDate_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Plan Date']"));
    private final Locator planDateData_Lbl = Locator.builder().withWeb(By.xpath("//input[@placeholder='Select date']"));

    private final Locator tableColumnNameVehicleModelTesting_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Vehicle Model testing testing testing']"));
    private final Locator tableColumnNameVehicleId_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Vehicle ID']"));
    private final Locator tableColumnNameRiderName_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Rider Name']"));
    private final Locator tableColumnNameStartTime_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Start Time']"));
    private final Locator tableColumnNameEndTime_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='End Time']"));
    private final Locator tableColumnNameMaxDistance_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Max. Distance (KM)']"));
    private final Locator tableColumnNameMaxTime_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Max. Time (Hours)']"));
    private final Locator tableColumnNameMaxShipments_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Max. Shipments']"));
    private final Locator tableColumnNameMaxWeight_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Max. Weight (KG)']"));
    private final Locator tableColumnNameMaxVolume_Lbl = Locator.builder().withWeb(By.xpath("//th[text()='Max. Volume (CU.M)}']"));

    private final Locator vehicleId_List = Locator.builder().withWeb(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']/td/select[not(contains(@name,'Select Rider'))]"));
    private final Locator vehicleModelTestingCheckbox_List = Locator.builder().withWeb(By.xpath("(//tr[@class='ant-table-row ant-table-row-level-0']/td/p/input)[abc]"));

    private final Locator addItem_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Add Item']/ancestor::button"));
    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//div[contains(@class,'items-center scale-100')]//p[text()='Cancel']/.."));
    private final Locator createPlan_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Create Plan']/.."));

    String selectedRiderNameList = "(//tr[@class='ant-table-row ant-table-row-level-0']/td/select[@name])[abc]";
    String riderNameList = "(//select[@name])[abc]/option";
    String maxDistanceTxtField = "(//input[@name='MaxDistance'])[abc]";
    String maxTimeTxtField = "(//input[@name='MaxTime'])[abc]";
    String maxShipmentsTxtField = "(//input[@name='MaxShipments'])[abc]";
    String maxWeightTxtField = "(//input[@name='MaxWeight'])[abc]";
    String maxVolumeTxtField = "(//input[@name='MaxVolume'])[abc]";

    public static RoutingPlanDetail getInstance(){
        if(_instance == null)
            _instance = new RoutingPlanDetail();
        return _instance;
    }

    public boolean isPresent_EnterPlanDetailHeader_Lbl() {
        return ActionHelper.isPresent(enterPlanDetailHeader_Lbl);
    }

    public String getText_EnterPlanDetailHeader_Lbl() {
        return ActionHelper.getText(enterPlanDetailHeader_Lbl);
    }

    public boolean isPresent_PlanByVehicleModel_Btn() {
        return ActionHelper.isPresent(planByVehicleModel_Btn);
    }

    public void click_PlanByVehicleModel_Btn() {
        ActionHelper.click(planByVehicleModel_Btn);
    }

    public boolean isPresent_Search_TxtBox() {
        return ActionHelper.isPresent(search_TxtBox);
    }

    public void fill_Search_TxtBox(String vehicleId) {
        ActionHelper.sendKeysWithClear(search_TxtBox.getBy(), vehicleId);
    }

    public boolean isPresent_ModelName_Btn() {
        return ActionHelper.isPresent(modelName_Btn);
    }

    public void click_ModelName_Btn() {
        ActionHelper.click(modelName_Btn);
    }

    public boolean isPresent_PlanDate_Lbl() {
        return ActionHelper.isPresent(planDate_Lbl);
    }

    public boolean isPresent_PlanDateData_Lbl() {
        return ActionHelper.isPresent(planDateData_Lbl);
    }

    public void click_PlanDateData_Lbl() {
        ActionHelper.click(planDateData_Lbl);
    }

    public boolean isPresent_TableColumnNameVehicleModelTesting_Lbl() {
        return ActionHelper.isPresent(tableColumnNameVehicleModelTesting_Lbl);
    }

    public boolean isPresent_TableColumnNameVehicleId_Lbl() {
        return ActionHelper.isPresent(tableColumnNameVehicleId_Lbl);
    }

    public boolean isPresent_TableColumnNameRiderName_Lbl() {
        return ActionHelper.isPresent(tableColumnNameRiderName_Lbl);
    }

    public boolean isPresent_TableColumnNameStartTime_Lbl() {
        return ActionHelper.isPresent(tableColumnNameStartTime_Lbl);
    }

    public boolean isPresent_TableColumnNameEndTime_Lbl() {
        return ActionHelper.isPresent(tableColumnNameEndTime_Lbl);
    }

    public boolean isPresent_TableColumnNameMaxDistance_Lbl() {
        return ActionHelper.isPresent(tableColumnNameMaxDistance_Lbl);
    }

    public boolean isPresent_TableColumnNameMaxTime_Lbl() {
        return ActionHelper.isPresent(tableColumnNameMaxTime_Lbl);
    }

    public boolean isPresent_TableColumnNameMaxShipments_Lbl() {
        return ActionHelper.isPresent(tableColumnNameMaxShipments_Lbl);
    }

    public boolean isPresent_TableColumnNameMaxWeight_Lbl() {
        return ActionHelper.isPresent(tableColumnNameMaxWeight_Lbl);
    }

    public boolean isPresent_TableColumnNameMaxVolume_Lbl() {
        return ActionHelper.isPresent(tableColumnNameMaxVolume_Lbl);
    }

    public boolean isPresent_AddItem_Btn() {
        return ActionHelper.isPresent(addItem_Btn);
    }

    public void click_AddItem_Btn() {
        ActionHelper.click(addItem_Btn);
    }

    public boolean isPresent_Cancel_Btn() {
        return ActionHelper.isPresent(cancel_Btn);
    }

    public void click_Cancel_Btn() {
        ActionHelper.click(cancel_Btn);
    }

    public boolean isPresent_CreatePlan_Btn() {
        return ActionHelper.isPresent(createPlan_Btn);
    }

    public void click_CreatePlan_Btn() {
        ActionHelper.click(createPlan_Btn);
    }

    public boolean isPresent_VehicleId_List() {
        return ActionHelper.isPresent(vehicleId_List);
    }

    public List<String> getTextList_VehicleId_List() {
        return Utility.getText_ListOfWebElements(vehicleId_List.getBy());
    }

    public boolean isPresent_VehicleModelTestingCheckbox_List() {
        return ActionHelper.isPresent(vehicleModelTestingCheckbox_List);
    }

    public void click_VehicleModelTestingCheckbox_List(String vehicleId) {
        int index = getTextList_VehicleId_List().indexOf(vehicleId);
        List<WebElement> checkBoxList = ActionHelper.findElements(vehicleModelTestingCheckbox_List);
        Utility.checkCheckbox(checkBoxList.get(index));
    }

    public boolean isPresent_SelectedRiderName_List() {
        return ActionHelper.isPresent(Locator.builder().withWeb(By.xpath(selectedRiderNameList.replace("[abc]", ""))));
    }

    public void select_SelectedRiderName_List(String vehicleId) {
        int index = getTextList_VehicleId_List().indexOf(vehicleId);
        Locator riderName_List = Locator.builder().withWeb(By.xpath(riderNameList.replace("abc", String.valueOf(index))));
        Locator selectedRiderName_List = Locator.builder().withWeb(By.xpath(selectedRiderNameList.replace("abc", String.valueOf(index))));
        Utility.select_FromDropDown_List(selectedRiderName_List.getBy(), riderName_List.getBy(), vehicleId);
    }

    public void fill_MaxDistance_Txt(String vehicleId, String maxDistance) {
        int index = getTextList_VehicleId_List().indexOf(vehicleId);
        Locator maxDistance_Txt = Locator.builder().withWeb(By.xpath(maxDistanceTxtField.replace("abc", String.valueOf(index))));
        ActionHelper.sendKeysWithClear(maxDistance_Txt.getBy(), maxDistance);
    }

    public void fill_MaxTime_Txt(String vehicleId, String maxTime) {
        int index = getTextList_VehicleId_List().indexOf(vehicleId);
        Locator maxTime_Txt = Locator.builder().withWeb(By.xpath(maxTimeTxtField.replace("abc", String.valueOf(index))));
        ActionHelper.sendKeysWithClear(maxTime_Txt.getBy(), maxTime);
    }

    public void fill_MaxShipment_Txt(String vehicleId, String maxShipment) {
        int index = getTextList_VehicleId_List().indexOf(vehicleId);
        Locator maxShipment_Txt = Locator.builder().withWeb(By.xpath(maxShipmentsTxtField.replace("abc", String.valueOf(index))));
        ActionHelper.sendKeysWithClear(maxShipment_Txt.getBy(), maxShipment);
    }

    public void fill_MaxWeight_Txt(String vehicleId, String maxWeight) {
        int index = getTextList_VehicleId_List().indexOf(vehicleId);
        Locator maxWeight_Txt = Locator.builder().withWeb(By.xpath(maxWeightTxtField.replace("abc", String.valueOf(index))));
        ActionHelper.sendKeysWithClear(maxWeight_Txt.getBy(), maxWeight);
    }

    public void fill_MaxVolume_Txt(String vehicleId, String maxVolume) {
        int index = getTextList_VehicleId_List().indexOf(vehicleId);
        Locator maxVolume_Txt = Locator.builder().withWeb(By.xpath(maxVolumeTxtField.replace("abc", String.valueOf(index))));
        ActionHelper.sendKeysWithClear(maxVolume_Txt.getBy(), maxVolume);
    }
}
