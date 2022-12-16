package pageobjects;

import constants.Constants;
import framework.common.assertion.JarvisAssert;
import framework.common.logger.ExtentLogger;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

import static utility.Utility.acceptAlertIfPresent;

public class CommonActions {
    private static CommonActions _instance;
    private final Locator loader_Txt = Locator.builder().withWeb(By.xpath("//div[text()='Loading...']"));
    private final Locator paginationCurrentlyShowingAndTotalCount_Lbl = Locator.builder().withWeb(By.className("ant-pagination-total-text"));
    private final Locator paginationNext_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Next']"));
    private final Locator paginationPrevious_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Prev']"));
    private final Locator status_RadioBtn = Locator.builder().withWeb(By.xpath("//label[@class='ant-radio-wrapper']/span[2]"));
    private final Locator status_DropDown = Locator.builder().withWeb(By.xpath("//button/p[text()='Status']"));
    private final Locator skip_Btn = Locator.builder().withWeb(By.cssSelector(".productfruits--btn.productfruits--card-footer-skip-button"));
    private final Locator loader_Img = Locator.builder().withWeb(By.cssSelector("*[class*='animate-spin']"));
    private final Locator selectTeam1 = Locator.builder().withWeb(By.id("selectTeam"));
    private final Locator teamSelector_Dropdown = Locator.builder().withWeb(By.xpath("(//span[@class='ant-select-selection-search']/following-sibling::span)[1]"));
    private final Locator pageSize_Txt = Locator.builder().withWeb(By.xpath("//div[@aria-label='Page Size']"));
    private final Locator paginationBlockList_Txt = Locator.builder().withWeb(By.xpath("//li[contains(@class, 'pagination-item')]"));
    private final Locator emptyTableMsg_Lbl = Locator.builder().withWeb(By.xpath("//tr[@class='ant-table-placeholder']//h3"));
    private final Locator addFacility_Btn = Locator.builder().withWeb(By.xpath("//tr[@class='ant-table-placeholder']//td//td"));
    String chooseNoOfRecordToBeDisplayed = "//div[text()='ab / page']";
    String elementInFirstRow = "//tr[2]/td[index]";
    String elementColumnDataList = "//tr[@class='ant-table-row ant-table-row-level-0']//td[index]";

    public static CommonActions getInstance() {
        if (_instance == null) _instance = new CommonActions();
        return _instance;
    }

    public void selectTeamFromHeader(String input) {
        ActionHelper.click(teamSelector_Dropdown);
        ActionHelper.sendKeys(selectTeam1, Keys.chord(input, Keys.ENTER));
    }

    public void waitTillLoaderAppears() {
        ActionHelper.waitUntilElementVisible(loader_Img.getBy());
    }

    public void waitTillLoaderDisappears() {
        ActionHelper.waitForElementToHide(loader_Img);
    }

    public void performCommonAction() {
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        acceptAlertIfPresent();
        waitTillLoaderDisappears();
        checkAndPerformLogin();
        waitTillLoaderDisappears();
    }

    public void checkAndPerformLogin() {
        if (LoginPage.getInstance().isPresent_LoginWithEmail_Lnk())
            LoginPage.getInstance().performLoginWithEmail(Constants.EMAIL_ID, Constants.EMAIL_PASSWORD);
    }

    public void coverUserJourneyTillRiders() {
        performCommonAction();
        waitTillLoaderDisappears();
        click_SkipIfPresent_Btn();
        HomePage.getInstance().openRidersPage();
        waitTillLoaderDisappears();
        JarvisAssert.assertTrue(RidersPage.getInstance().isPresent_Header_Lbl());
    }

    public void coverJourneyTillDispatches() {
        performCommonAction();
        click_SkipIfPresent_Btn();
        HomePage.getInstance().openDispatchListPage();
    }

    public void coverJourneyTillCreateOrder() {
        performCommonAction();
        click_SkipIfPresent_Btn();
        HomePage.getInstance().selectTeam(Constants.TEAM);
        HomePage.getInstance().openCreateOrderPage();
    }

    public void waitTillLoaderTxtDisappears() {
        ActionHelper.waitForElementToHide(loader_Txt);
    }

    public void click_SkipIfPresent_Btn() {
        try {
            ActionHelper.waitForLoaderToHide();
            String skipButton = "return document.querySelector(\"body > div.productfruits--container\").shadowRoot.querySelector(\"button.productfruits--btn.productfruits--card-footer-skip-button\")";
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            WebElement element = (WebElement) js.executeScript(skipButton);
            if (element.isDisplayed())
                element.click();
        } catch (Exception e) {
            ExtentLogger.logPass(e.toString());
        }
    }

    public void coverJourneyTillFacility() {
        performCommonAction();
        click_SkipIfPresent_Btn();
        HomePage.getInstance().selectTeam(Constants.TEAM);
        HomePage.getInstance().click_FacilitiesMenuItem_Btn();
        waitTillLoaderDisappears();
    }

    public void coverJourneyTillRider() {
        performCommonAction();
        click_SkipIfPresent_Btn();
        HomePage.getInstance().openRidersPage();
    }

    public void coverJourneyTillViewOrder() {
        performCommonAction();
        click_SkipIfPresent_Btn();
        HomePage.getInstance().openViewOrderPage();
    }

    public Boolean isPresent_Skip_Btn() {
        return ActionHelper.isPresent(skip_Btn, 3000);
    }

    public String getText_PaginationCurrentlyShowingCount_Lbl() {
        waitTillLoaderTxtDisappears();
        return ActionHelper.getText(paginationCurrentlyShowingAndTotalCount_Lbl).split(" ")[1];
    }

    public boolean isPresent_PaginationNext_Btn() {
        return ActionHelper.isPresent(paginationNext_Btn);
    }

    public void click_PaginationNext_Btn() {
        ActionHelper.click(paginationNext_Btn);
        waitTillLoaderDisappears();
    }

    public boolean isPresent_PaginationPrevious_Btn() {
        return ActionHelper.isPresent(paginationPrevious_Btn);
    }

    public void click_PaginationPrevious_Btn() {
        ActionHelper.click(paginationPrevious_Btn);
        waitTillLoaderDisappears();
    }

    public boolean isPresent_PageSize_Txt() {
        return ActionHelper.isPresent(pageSize_Txt);
    }

    public void click_PageSize_Txt() {
        ActionHelper.click(pageSize_Txt);
    }

    public String getText_PageSize_Txt() {
        String[] dataSize = ActionHelper.getText(pageSize_Txt).split("/");
        return dataSize[0].replace(" ", "");
    }

    public void chooseNoOfRecordToBeDisplayed(int noOfData) {
        click_PageSize_Txt();
        ActionHelper.click(ActionHelper.findElement(By.xpath(chooseNoOfRecordToBeDisplayed.replace("ab", String.valueOf(noOfData)))));
        waitTillLoaderDisappears();
    }

    public void select_PaginationBlock_Txt(int pageNo) {
        for (WebElement element : ActionHelper.findElements(paginationBlockList_Txt))
            if (element.getAttribute("title").equals(String.valueOf(pageNo))) ActionHelper.click(element);
        waitTillLoaderDisappears();
    }

    public boolean isPaginationBlockSelected(int label) {
        for (WebElement element : ActionHelper.findElements(paginationBlockList_Txt))
            if (element.getAttribute("title").equals(String.valueOf(label)) && element.getAttribute("class").contains("item-active"))
                return true;
        return false;
    }

    public int indexOfTableColumnName(String input) {
        int index = 0;
        List<WebElement> columName = ActionHelper.findElements(By.xpath("//tr[1]/th"));
        for (WebElement element : columName) {
            if (element.getText().equals(input)) {
                index = columName.indexOf(element);
                break;
            }
        }
        return index + 1;
    }

    public String getText_TableData_Lbl(String tableColumnName) {
        String index = String.valueOf(indexOfTableColumnName(tableColumnName));
        Locator data = Locator.builder().withWeb(By.xpath(elementInFirstRow.replace("index", index)));
        return ActionHelper.getText(data);
    }

    public List<String> getList_TableDataList_Lbl(String tableColumnName) {
        String index = String.valueOf(indexOfTableColumnName(tableColumnName));
        Locator data = Locator.builder().withWeb(By.xpath(elementColumnDataList.replace("index", index)));
        return Utility.getText_ListOfWebElements(ActionHelper.findElements(data));
    }

    public boolean isPresent_TableData_Lbl(String tableColumnName) {
        String index = String.valueOf(indexOfTableColumnName(tableColumnName));
        Locator data = Locator.builder().withWeb(By.xpath(elementInFirstRow.replace("index", index)));
        return ActionHelper.isPresent(data);
    }

    public boolean isPresent_EmptyTableMsg_Lbl() {
        return ActionHelper.isPresent(emptyTableMsg_Lbl, 4000);
    }

    public String getText_EmptyTableMsg_Lbl() {
        return ActionHelper.getText(emptyTableMsg_Lbl);
    }

    public boolean isPresent_AddFacility_Btn() {
        return ActionHelper.isPresent(addFacility_Btn);
    }
}