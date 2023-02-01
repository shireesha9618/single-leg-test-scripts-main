package pageobjects.settings;

import constants.Constants;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.CommonActions;
import utility.Utility;

import java.util.List;

public class ObjectiveWorkflowsListPage {
    private static ObjectiveWorkflowsListPage _instance;

    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//div/p[text()='Objective Workflows']"));
    private final Locator create_Btn = Locator.builder().withWeb(By.xpath("//button[p[text()='Create']]"));
    private final Locator tabs_ListBtn = Locator.builder().withWeb(By.cssSelector("nav[aria-label='Tabs']>div>button>p"));
    private final Locator activeTab_Btn = Locator.builder().withWeb(By.xpath("//button[p[contains(text(), 'Active')]]"));
    private final Locator draftTab_Btn = Locator.builder().withWeb(By.xpath("//button[p[contains(text(), 'Draft')]]"));
    private final Locator searchBar_Txt = Locator.builder().withWeb(By.id("search"));
    private final Locator objectiveType_DropDown = Locator.builder().withWeb(By.xpath("//button[p[text()='Objective Type']]"));
    private final Locator objectiveTypeDropDownPickup_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='Pickup']"));
    private final Locator objectiveTypeDropDownDrop_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='Drop']"));
    private final Locator objectiveTypeDropDownReturn_Radio = Locator.builder().withWeb(By.xpath("//input[@type='radio' and @value='Return']"));
    private final Locator objectiveTypeDropDownClearSelection_Btn = Locator.builder().withWeb(By.xpath("//button[p[text()='Clear Selection']]"));
    private final Locator tableHeader_ListLbl = Locator.builder().withWeb(By.xpath("//th[contains(@class,'ant-table-cell') and text()]"));
    private final Locator tableHeaderName_ListLink = Locator.builder().withWeb(By.xpath("//tr[contains(@class, 'ant-table-row')]/td/a/a"));
    private final Locator itIsEmptyHere_Lbl = Locator.builder().withWeb(By.xpath("//h3[text()='It is Empty here']"));
    private final Locator noObjectiveWorkflowsFound_Lbl = Locator.builder().withWeb(By.xpath("//td[text()='No Objective Workflows found']"));

    public static ObjectiveWorkflowsListPage getInstance() {
        if (_instance == null) {
            _instance = new ObjectiveWorkflowsListPage();
        }
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        return ActionHelper.isPresent(header_Lbl);
    }

    public String getText_Header_Lbl() {
        return ActionHelper.getText(header_Lbl);
    }

    public boolean isPresent_Create_Btn() {
        return ActionHelper.isPresent(create_Btn);
    }

    public void click_Create_Btn() {
        ActionHelper.click(create_Btn);
    }

    public String getText_Create_Btn() {
        return ActionHelper.getText(create_Btn);
    }

    public List<WebElement> getList_Tabs_ListBtn() {
        return ActionHelper.findElementsWithoutWait(tabs_ListBtn.getBy());
    }

    public List<String> getText_Tabs_ListBtn() {
        return Utility.getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(tabs_ListBtn.getBy()));
    }

    public String getText_Tabs_ListBtn(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(tabs_ListBtn.getBy()).get(index));
    }

    public void click_Tabs_ListBtn(int index) {
        ActionHelper.click(ActionHelper.findElements(tabs_ListBtn.getBy()).get(index));
    }

    public boolean isPresent_ActiveTab_Btn() {
        return ActionHelper.isPresent(activeTab_Btn);
    }

    public void click_ActiveTab_Btn() {
        ActionHelper.click(activeTab_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_ActiveTab_Btn() {
        return ActionHelper.getText(activeTab_Btn);
    }

    public boolean isPresent_DraftTab_Btn() {
        return ActionHelper.isPresent(draftTab_Btn);
    }

    public void click_DraftTab_Btn() {
        ActionHelper.click(draftTab_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_DraftTab_Btn() {
        return ActionHelper.getText(draftTab_Btn);
    }

    public boolean isPresent_SearchBar_Txt() {
        return ActionHelper.isPresent(searchBar_Txt);
    }

    public void fill_SearchBar_Txt(String value) {
        ActionHelper.fill(searchBar_Txt, value);
    }

    public void fillWithClear_SearchBar_Txt(String value) {
        ActionHelper.fillWithClear(searchBar_Txt.getBy(), value);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void clear_SearchBar_Txt() {
        Utility.selectAllAndClear(searchBar_Txt.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getValue_SearchBar_Txt() {
        return ActionHelper.getAttribute(searchBar_Txt, "value");
    }

    public boolean isPresent_ObjectiveType_DropDown() {
        return ActionHelper.isPresent(objectiveType_DropDown);
    }

    public void click_ObjectiveType_DropDown() {
        ActionHelper.click(objectiveType_DropDown);
        ActionHelper.waitUntilElementVisible(objectiveTypeDropDownClearSelection_Btn.getBy());
    }

    public String getText_ObjectiveType_DropDown() {
        return ActionHelper.getText(objectiveType_DropDown);
    }

    public boolean isSelected_ObjectiveTypeDropDownPickup_Radio() {
        return Utility.isRadioSelected(objectiveTypeDropDownPickup_Radio.getBy());
    }

    public void click_ObjectiveTypeDropDownPickup_Radio() {
        Utility.clickRadio(objectiveTypeDropDownPickup_Radio.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isSelected_ObjectiveTypeDropDownDrop_Radio() {
        return Utility.isRadioSelected(objectiveTypeDropDownDrop_Radio.getBy());
    }

    public void click_ObjectiveTypeDropDownDrop_Radio() {
        Utility.clickRadio(objectiveTypeDropDownDrop_Radio.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isSelected_ObjectiveTypeDropDownReturn_Radio() {
        return Utility.isRadioSelected(objectiveTypeDropDownReturn_Radio.getBy());
    }

    public void click_ObjectiveTypeDropDownReturn_Radio() {
        Utility.clickRadio(objectiveTypeDropDownReturn_Radio.getBy());
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_ObjectiveTypeDropDownClearSelection_Btn() {
        return ActionHelper.isPresent(objectiveTypeDropDownClearSelection_Btn, Constants.WAIT_FOR_FIVE_SECOND);
    }

    public void click_ObjectiveTypeDropDownClearSelection_Btn() {
        ActionHelper.click(objectiveTypeDropDownClearSelection_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_ObjectiveTypeDropDownClearSelection_Btn() {
        return ActionHelper.getText(objectiveTypeDropDownClearSelection_Btn);
    }

    public List<WebElement> getList_TableHeader_ListLbl() {
        return ActionHelper.findElementsWithoutWait(tableHeader_ListLbl.getBy());
    }

    public List<String> getText_TableHeader_ListLbl() {
        return Utility.getSortedListOfText_ListOfWebElementsWhileScrollingUsingJS(tableHeader_ListLbl.getBy());
    }

    public String getText_TableHeader_ListLbl(int index) {
        return ActionHelper.getText(ActionHelper.findElementsWithoutWait(tableHeader_ListLbl.getBy()).get(index));
    }

    public boolean isPresent_ItIsEmptyHere_Lbl() {
        return ActionHelper.isPresent(itIsEmptyHere_Lbl);
    }

    public boolean isPresent_NoObjectiveWorkflowsFound_Lbl() {
        return ActionHelper.isPresent(noObjectiveWorkflowsFound_Lbl);
    }

    public void clickAndChoose_PaginationDropDownOptions_Btn(int pagination) {
        waitTillAllObjectiveWorkflowsAreLoaded();
        CommonActions.getInstance().choosePaginationOption(pagination);
        waitTillAllObjectiveWorkflowsAreLoaded();
    }

    public void waitTillAllObjectiveWorkflowsAreLoaded() {
        ActionHelper.waitUntilAllElementsVisible(tableHeaderName_ListLink.getBy());
        List<WebElement> names = ActionHelper.findElements(tableHeaderName_ListLink);
        ActionHelper.waitUntilElementClickable(names.get(names.size() - 1));
    }
}
