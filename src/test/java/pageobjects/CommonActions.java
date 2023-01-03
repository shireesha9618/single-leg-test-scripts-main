package pageobjects;

import constants.Constants;
import framework.common.assertion.JarvisAssert;
import framework.common.logger.ExtentLogger;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

import java.util.List;

import static utility.Utility.acceptAlertIfPresent;

public class CommonActions {
    private static CommonActions _instance;
    private final Locator loader_Txt = Locator.builder().withWeb(By.xpath("//div[text()='Loading...']"));
    private final Locator paginationCurrentlyShowingAndTotalCount_Lbl = Locator.builder().withWeb(By.className("ant-pagination-total-text"));
    private final Locator paginationSelectedItem_Lbl = Locator.builder().withWeb(By.xpath("//div[contains(@class,'pagination')]//span[@title]"));
    private final Locator paginationNext_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Next']"));
    private final Locator paginationPrevious_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Prev']"));
    private final Locator paginationResults_Lbl = Locator.builder().withWeb(By.cssSelector(".ant-pagination-total-text"));
    private final Locator paginationPerPageOptionsList_Lbl = Locator.builder().withWeb(By.xpath("//div[contains( text(), ' / page')]"));
    private final Locator paginationBlockList_Lbl = Locator.builder().withWeb(By.xpath("//li[contains(@class, 'pagination-item')]"));
    private final Locator showingNoOfRecords_Lbl = Locator.builder().withWeb(By.xpath("//li[contains(text() ,'Showing')]"));
    private final Locator status_RadioBtn = Locator.builder().withWeb(By.xpath("//label[@class='ant-radio-wrapper']/span[2]"));
    private final Locator status_DropDown = Locator.builder().withWeb(By.xpath("//button/p[text()='Status']"));
    private final Locator skip_Btn = Locator.builder().withWeb(By.cssSelector(".productfruits--btn.productfruits--card-footer-skip-button"));
    private final Locator loader_Img = Locator.builder().withWeb(By.cssSelector("*[class*='animate-spin']"));
    private final Locator selectTeam1 = Locator.builder().withWeb(By.id("selectTeam"));
    private final Locator teamSelector_Dropdown = Locator.builder().withWeb(By.xpath("(//span[@class='ant-select-selection-search']/following-sibling::span)[1]"));
    private final Locator pageSize_Txt = Locator.builder().withWeb(By.xpath("//div[@aria-label='Page Size']"));
    private final Locator paginationBlockList_Txt = Locator.builder().withWeb(By.xpath("//li[contains(@class, 'pagination-item')]"));
    private final Locator moreActionsDropDownModifyColumnsLinkSelectAll_Btn = Locator.builder().withWeb(By.xpath("//div[contains(@class, 'px')]/button[1]/p"));
    private final Locator moreActionsDropDownModifyColumnsLinkSave_Btn = Locator.builder().withWeb(By.xpath("//button//p[text()='Save']"));
    private final Locator emptyTableMsg_Lbl = Locator.builder().withWeb(By.xpath("//tr[@class='ant-table-placeholder']//h3"));
    private final Locator dataTable_Lbl = Locator.builder().withWeb(By.xpath("//tr[@data-row-key]"));

    String chooseNoOfRecordToBeDisplayed = "//div[text()='ab / page']";
    String elementInFirstRow = "//tr[2]/td[index]";
    String elementColumnDataList = "//tr[@class='ant-table-row ant-table-row-level-0']//td[index]";

    private final Locator calendarFromMonth_Btn = Locator.builder().withWeb(By.xpath("(//div[@class='ant-picker-header-view'])[1]/button[1]"));
    private final Locator calendarFromYear_Btn = Locator.builder().withWeb(By.xpath("(//div[@class='ant-picker-header-view'])[1]/button[2]"));
    private final Locator calendarToMonth_Btn = Locator.builder().withWeb(By.xpath("(//div[@class='ant-picker-header-view'])[2]/button[1]"));
    private final Locator calendarToYear_Btn = Locator.builder().withWeb(By.xpath("(//div[@class='ant-picker-header-view'])[2]/button[2]"));
    private final Locator calendarPreviousYear_Btn = Locator.builder().withWeb(By.xpath("//span[@class='ant-picker-super-prev-icon']"));
    private final Locator calendarPreviousMonth_Btn = Locator.builder().withWeb(By.xpath("//span[@class='ant-picker-prev-icon']"));
    private final Locator calendarNextMonth_Btn = Locator.builder().withWeb(By.xpath("(//span[@class='ant-picker-next-icon'])[last()]"));
    private final Locator calendarNextYear_Btn = Locator.builder().withWeb(By.xpath("(//span[@class='ant-picker-super-next-icon'])[last()]"));
    private final Locator calendarMonth_Btn = Locator.builder().withWeb(By.xpath("//button[@class='ant-picker-month-btn']"));
    private final Locator calendarYear_Btn = Locator.builder().withWeb(By.xpath("//button[@class='ant-picker-year-btn']"));
    private final Locator calendarChooseDateMonthYear_Btn = Locator.builder().withWeb(By.xpath("//tbody/tr/td[@title='PLACEHOLDER']"));

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

    public void coverJourneyTillViewOrder() {
        performCommonAction();
        click_SkipIfPresent_Btn();
        HomePage.getInstance().selectTeam(Constants.TEAM);
        HomePage.getInstance().openViewOrderPage();
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
        //HomePage.getInstance().openFacilitesPage();
        waitTillLoaderDisappears();
    }

    public void coverJourneyTillRider() {
        performCommonAction();
        click_SkipIfPresent_Btn();
        HomePage.getInstance().openRidersPage();
    }

    public Boolean isPresent_Skip_Btn() {
        return ActionHelper.isPresent(skip_Btn, 3000);
    }

    public String getText_PaginationCurrentlyShowingCount_Lbl() {
        waitTillLoaderTxtDisappears();
        return ActionHelper.getText(paginationCurrentlyShowingAndTotalCount_Lbl).split(" ")[1];
    }

    public String getText_PaginationTotalCount_Lbl() {
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
        return ActionHelper.getText(paginationCurrentlyShowingAndTotalCount_Lbl).split(" ")[3];
    }

    public boolean isPresent_PaginationSelectedItem_Lbl() {
        return ActionHelper.isPresent(paginationSelectedItem_Lbl);
    }

    public void click_PaginationSelectedItem_Lbl() {
        ActionHelper.click(paginationSelectedItem_Lbl);
    }

    public String getText_PaginationSelectedItem_Lbl() {
        return ActionHelper.getText(paginationSelectedItem_Lbl);
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

    public void coverJourneyTillTeams() {
        performCommonAction();
        click_SkipIfPresent_Btn();
        HomePage.getInstance().openTeamsPage();
    }

    public void resetColumns() {
        TeamsPage.getInstance().clickAndChoose_MoreActionsDropDownMenuOptions_Btn("Modify Columns");
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkSelectAll_Btn);
        new Actions(DriverManager.getDriver()).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        ActionHelper.click(moreActionsDropDownModifyColumnsLinkSave_Btn);
    }

    public int indexOfTableColumnName(String input) {
        int index = 0;
        List<WebElement> columName = ActionHelper.findElementsWithoutWait(By.xpath("//th[contains(@class,'ant-table-cell') and text()]"));
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

    public void coverJourneyTillSettings() {
        performCommonAction();
        click_SkipIfPresent_Btn();
        HomePage.getInstance().selectTeam(Constants.TEAM);
        HomePage.getInstance().click_SettingsMenu_Btn();
        waitTillLoaderDisappears();
    }

    public String getCurrentPageUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }

    public int get_TableData_Count() {
        return ActionHelper.findElements(dataTable_Lbl).size();
    }

    public boolean isPresent_PaginationResults_Lbl() {
        return ActionHelper.isPresent(paginationResults_Lbl);
    }

    public String getText_PaginationResults_Lbl() {
        return ActionHelper.getText(paginationResults_Lbl);
    }

    public String getText_PaginationPerPageOptionsList_Lbl(int index) {
        return ActionHelper.getText(ActionHelper.findElements(paginationPerPageOptionsList_Lbl).get(index));
    }

    public List<String> getText_PaginationPerPageOptionsList_Lbl() {
        return Utility.getText_ListOfWebElements(paginationPerPageOptionsList_Lbl.getBy());
    }

    public void chooseNoOfRecordsToBeDisplayedPerPage(int no) {
        click_PaginationSelectedItem_Lbl();
        Utility.clickWebElementContainingText(ActionHelper.findElements(paginationPerPageOptionsList_Lbl), String.valueOf(no));
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void selectPaginationBlock(String label) {
        ActionHelper.scrollTillElement(paginationBlockList_Lbl.getBy());
        ActionHelper.waitUntilElementClickable(paginationBlockList_Lbl);
        int index = 0;
        for (WebElement element : ActionHelper.findElements(paginationBlockList_Lbl)) {
            if (element.getAttribute("title").equals(label)) break;
            index++;
        }
        Utility.clickIgnoringStaleElementReferenceException(paginationBlockList_Lbl.getBy(), index, 5);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_ShowingNoOfRecords_Lbl() {
        return ActionHelper.getText(showingNoOfRecords_Lbl);
    }

    public void choosePaginationOption(int pagination) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(ActionHelper.findElement(paginationSelectedItem_Lbl)).click().build().perform();
        for (WebElement options : ActionHelper.findElements(paginationPerPageOptionsList_Lbl)) {
            if (options.getText().equals(pagination + " / page")) {
                actions.moveToElement(options).click().build().perform();
                break;
            }
        }
    }

    public String getText_CalendarFromMonth_Btn() {
        return ActionHelper.getText(calendarFromMonth_Btn);
    }

    public String getText_CalendarFromYear_Btn() {
        return ActionHelper.getText(calendarFromYear_Btn);
    }

    public String getText_CalendarToMonth_Btn() {
        return ActionHelper.getText(calendarToMonth_Btn);
    }

    public String getText_CalendarToYear_Btn() {
        return ActionHelper.getText(calendarToYear_Btn);
    }

    public boolean isPresent_CalendarPreviousYear_Btn() {
        return ActionHelper.isPresent(calendarPreviousYear_Btn);
    }

    public void click_CalendarPreviousYear_Btn() {
        ActionHelper.click(calendarPreviousYear_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_CalendarPreviousYear_Btn() {
        return ActionHelper.getText(calendarPreviousYear_Btn);
    }

    public boolean isPresent_CalendarPreviousMonth_Btn() {
        return ActionHelper.isPresent(calendarPreviousMonth_Btn);
    }

    public void click_CalendarPreviousMonth_Btn() {
        ActionHelper.click(calendarPreviousMonth_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_CalendarPreviousMonth_Btn() {
        return ActionHelper.getText(calendarPreviousMonth_Btn);
    }

    public boolean isPresent_CalendarNextMonth_Btn() {
        return ActionHelper.isPresent(calendarNextMonth_Btn);
    }

    public void click_CalendarNextMonth_Btn() {
        ActionHelper.click(calendarNextMonth_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_CalendarNextMonth_Btn() {
        return ActionHelper.getText(calendarNextMonth_Btn);
    }

    public boolean isPresent_CalendarNextYear_Btn() {
        return ActionHelper.isPresent(calendarNextYear_Btn);
    }

    public void click_CalendarNextYear_Btn() {
        ActionHelper.click(calendarNextYear_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public String getText_CalendarNextYear_Btn() {
        return ActionHelper.getText(calendarNextYear_Btn);
    }

    public boolean isPresent_CalendarMonth_Btn() {
        return ActionHelper.isPresent(calendarMonth_Btn);
    }

    public void click_CalendarMonth_Btn() {
        ActionHelper.click(calendarMonth_Btn);
    }

    public String getText_CalendarMonth_Btn() {
        return ActionHelper.getText(calendarMonth_Btn);
    }

    public boolean isPresent_CalendarYear_Btn() {
        return ActionHelper.isPresent(calendarYear_Btn);
    }

    public void click_CalendarYear_Btn() {
        ActionHelper.click(calendarYear_Btn);
    }

    public String getText_CalendarYear_Btn() {
        return ActionHelper.getText(calendarYear_Btn);
    }

    public boolean isPresent_CalendarChooseDateMonthYear_Btn() {
        return ActionHelper.isPresent(calendarChooseDateMonthYear_Btn);
    }

    public void click_CalendarChooseDateMonthYear_Btn() {
        ActionHelper.click(calendarChooseDateMonthYear_Btn);
    }

    public String getText_CalendarChooseDateMonthYear_Btn() {
        return ActionHelper.getText(calendarChooseDateMonthYear_Btn);
    }

    public void fillDatesInCalendar(String inputFromDate, String inputToDate) {
        DateTime dateToBeSelected = new DateTime(inputFromDate);
        while (Integer.parseInt(getText_CalendarFromYear_Btn()) > dateToBeSelected.getYear())
            click_CalendarPreviousYear_Btn();
        while (Integer.parseInt(getText_CalendarFromYear_Btn()) < dateToBeSelected.getYear())
            click_CalendarNextYear_Btn();
        while (Utility.mapMonthNameToNo(getText_CalendarFromMonth_Btn()) > dateToBeSelected.getMonthOfYear())
            click_CalendarPreviousYear_Btn();
        while (Utility.mapMonthNameToNo(getText_CalendarFromMonth_Btn()) < dateToBeSelected.getMonthOfYear())
            click_CalendarNextYear_Btn();
        ActionHelper.click(Utility.fillPlaceholderValueInXpath(calendarChooseDateMonthYear_Btn, inputFromDate));
        CommonActions.getInstance().waitTillLoaderDisappears();

        dateToBeSelected = new DateTime(inputToDate);
        while (Integer.parseInt(getText_CalendarToYear_Btn()) < dateToBeSelected.getYear())
            click_CalendarNextYear_Btn();
        while (Utility.mapMonthNameToNo(getText_CalendarToMonth_Btn()) > dateToBeSelected.getMonthOfYear())
            click_CalendarPreviousYear_Btn();
        while (Utility.mapMonthNameToNo(getText_CalendarToMonth_Btn()) < dateToBeSelected.getMonthOfYear())
            click_CalendarNextYear_Btn();
        ActionHelper.click(Utility.fillPlaceholderValueInXpath(calendarChooseDateMonthYear_Btn, inputToDate));
        CommonActions.getInstance().waitTillLoaderDisappears();
    }
}