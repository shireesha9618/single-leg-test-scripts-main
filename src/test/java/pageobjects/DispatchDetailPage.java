package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.openqa.selenium.By;

public class DispatchDetailPage {
    private static DispatchDetailPage _instance;
    private final Locator dispatchStatus_Lbl = Locator.builder().withWeb(By.xpath("(//div[@id='headerLabel']/../div)[2]"));
    private final Locator totalShipmentCount_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Total Shipments']/preceding-sibling::p"));
    private final Locator totalShipmentCountText_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Total Shipments']"));
    private final Locator inventoryInHand_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Inventory in hand']/preceding-sibling::p"));
    private final Locator inventoryInHandText_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Inventory in hand']"));
    private final Locator expectedCashInHand_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Expected cash']/preceding-sibling::p"));
    private final Locator expectedCashInHandText_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Expected cash']"));
    private final Locator cashInHand_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Cash in hand']/preceding-sibling::p"));
    private final Locator cashInHandText_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Cash in hand']"));
    private final Locator firstElementScannableId_Lbl = Locator.builder().withWeb(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[2]"));
    private final Locator firstElementStatus_Lbl = Locator.builder().withWeb(By.xpath("//tbody[@class='ant-table-tbody']/tr[2]/td[3]"));
    private final Locator refresh_Btn = Locator.builder().withWeb(By.id("refreshButton"));
    private final Locator publishDispatch_Btn = Locator.builder().withWeb(By.xpath("//button[@id='publishDispatchButton']"));
    private final Locator confirmPublishDispatch_Btn = Locator.builder().withWeb(By.xpath("//button[@id='publishButton']"));
    private final Locator confirmPublishDispatchHeader_Lbl = Locator.builder().withWeb(By.xpath("//h1[@id='publishHeader']//h1[@id='publishHeader']"));
    private final Locator cancelPublishDispatch_Lbl = Locator.builder().withWeb(By.xpath("//button[@id='cancelButton']"));
    public static DispatchDetailPage getInstance() {
        if (_instance == null) _instance = new DispatchDetailPage();
        return _instance;
    }

    public String get_TotalShipmentCount_Lbl() {
        return ActionHelper.getText(totalShipmentCount_Lbl);
    }

    public String get_InventoryInHand_Lbl() {
        return ActionHelper.getText(inventoryInHand_Lbl);
    }

    public String get_ExpectedCashInHand_Lbl() {
        return ActionHelper.getText(expectedCashInHand_Lbl);
    }

    public String get_CashInHand_Lbl() {
        return ActionHelper.getText(cashInHand_Lbl);
    }

    public String get_FirstElementScannableId_Lbl() {
        ActionHelper.gotoSleep(5000);
        return ActionHelper.getText(firstElementScannableId_Lbl);
    }

    public String get_FirstElementStatus_Lbl() {
        return ActionHelper.getText(firstElementStatus_Lbl);
    }

    public String get_DispatchStatus_Lbl() {
        return ActionHelper.getText(dispatchStatus_Lbl);
    }

    public void click_PublishDispatch_Btn()
    {
        ActionHelper.click(publishDispatch_Btn);
        ActionHelper.gotoSleep(3000);
    }
    public void click_ConfirmPublishDispatch_Btn()
    {
        ActionHelper.click(confirmPublishDispatch_Btn);
        ActionHelper.gotoSleep(5000);
        DriverManager.getDriver().navigate().refresh();
    }
    public Boolean isPresent_ConfirmPublishDispatchHeader_Lbl()
    {
        return ActionHelper.isPresent(confirmPublishDispatchHeader_Lbl);
    }

}
