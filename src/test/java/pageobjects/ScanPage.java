package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class ScanPage {
    private static ScanPage _instance;
    private final Locator enterShipmentId_Txt = Locator.builder().withWeb(By.id("package-id-inpt"));
    private final Locator scanBreadcrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/dispatches/scan']/div/a"));
    private final Locator inventoryInHand_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Inventory in hand']/preceding-sibling::p"));
    private final Locator expectedCashToBeCollected_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Expected cash to be collected']/preceding-sibling::p"));
    private final Locator addToDispatch_Btn = Locator.builder().withWeb(By.xpath("//button[p[text()='Add to dispatch']]"));
    private final Locator confirmAddToDispatch_Btn = Locator.builder().withWeb(By.xpath("(//button[@type='button'])[3]"));
    private final Locator shipmentCount_Lbl = Locator.builder().withWeb(By.xpath("(//div[@class='flex'])[4]//p"));
    private final Locator deleteShipment_Btn = Locator.builder().withWeb(By.cssSelector("[class*='h-4 w-4 text-red-500 cursor-pointer']"));
    private final Locator deleteIconForAddedPackage_Btn = Locator.builder().withWeb(By.xpath("//tr[@class='ant-table-row ant-table-row-level-0']//*[local-name()='svg']"));
    private final Locator proceed_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Proceed'])[1]"));
    private final Locator changeSummaryDialog_Lbl = Locator.builder().withWeb(By.xpath("//h1[text()='Change Summary']"));
    private final Locator cancelDialog_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']"));
    private final Locator proceedDialog_Btn = Locator.builder().withWeb(By.xpath("(//p[text()='Proceed'])[2]"));
    private final Locator dispatchName_lbl = Locator.builder().withWeb(By.xpath("//h1/div"));
    private final Locator addToDispatchConfirmatoryMessage_Txt = Locator.builder().withWeb(By.xpath("//h1[text()='Add to dispatch']/..//p"));
    private final Locator firstShipmentStatus_Lbl = Locator.builder().withWeb(By.xpath("//tr/td[3]/div/h6"));
    private final Locator noOfPackageScanned_Txt = Locator.builder().withWeb(By.xpath("//input[@name='package-id']/../following-sibling::p"));
    private final Locator totalNumberOfShipment_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Total Shipments']/preceding-sibling::p"));
    private final Locator totalExpectedCash_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Expected cash']/preceding-sibling::p"));
    private final Locator cancelAddToDispatch_Btn = Locator.builder().withWeb(By.xpath("(//button[@type='button'])[2]"));
    private final Locator addToDispatchHeader_Lbl = Locator.builder().withWeb(By.xpath("//h1[text()='Add to dispatch']"));
    private final Locator packageNotFound_Lbl = Locator.builder().withWeb(By.xpath("//div[text()='Package not Found']"));

    public static ScanPage getInstance() {
        if (_instance == null) _instance = new ScanPage();
        return _instance;
    }

    public String getText_ShipmentCount_Lbl() {
        return ActionHelper.getText(shipmentCount_Lbl);
    }

    public void click_ScanBreadcrumb_Link() {
        ActionHelper.click(scanBreadcrumb_Link);
    }

    public boolean isPresent_ScanBreadcrumb_Link() {
        return ActionHelper.isPresent(scanBreadcrumb_Link);
    }

    public String getText_DispatchName_lbl() {
        return ActionHelper.getText(dispatchName_lbl);
    }

    public boolean isPresent_EnterShipmentId_Txt() {
        return ActionHelper.isPresent(enterShipmentId_Txt, 30000);
    }

    public void fill_EnterShipmentId_Txt(String shipment) {
        ActionHelper.fillWithClear(enterShipmentId_Txt.getBy(), shipment);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void fill_EnterShipmentId_WithOutWait_Txt(String shipment) {
        ActionHelper.fillWithClear(enterShipmentId_Txt.getBy(), shipment);
        CommonActions.getInstance().waitTillLoaderTxtDisappears();
    }

    public void click_DeleteShipment_Btn() {
        ActionHelper.click(deleteShipment_Btn);
    }

    public boolean isPresent_AddToDispatch_Btn() {
        return ActionHelper.isPresent(addToDispatch_Btn, 30000);
    }

    public void click_AddToDispatch_Btn() {
        ActionHelper.waitUntilElementVisible(addToDispatch_Btn.getBy());
        ActionHelper.click(addToDispatch_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public void click_ConfirmAddToDispatch_Btn() {
        ActionHelper.waitUntilElementVisible(confirmAddToDispatch_Btn.getBy());
        ActionHelper.click(confirmAddToDispatch_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_DeleteIconForAddedPackage_Btn() {
        return ActionHelper.isPresent(deleteIconForAddedPackage_Btn, 30000);
    }

    public void click_DeleteIconForAddedPackage_Btn() {
        ActionHelper.click(deleteIconForAddedPackage_Btn);
    }

    public String get_ConfirmatoryMessage_Txt() {
        return ActionHelper.getText(addToDispatchConfirmatoryMessage_Txt);
    }

    public String get_FirstShipmentStatus_Lbl() {
        ActionHelper.waitUntilElementVisible(firstShipmentStatus_Lbl.getBy());
        return ActionHelper.getText(firstShipmentStatus_Lbl);
    }

    public String get_NoOfPackageScanned_Txt() {
        return ActionHelper.getText(noOfPackageScanned_Txt);
    }

    public boolean isPresent_TotalNumberOfShipments_Txt() {
        return ActionHelper.isPresent(totalNumberOfShipment_Txt);
    }

    public String get_TotalNumberOfShipments_Txt() {
        return ActionHelper.getText(totalNumberOfShipment_Txt);
    }

    public boolean isPresent_TotalExpectedCash_Txt() {
        return ActionHelper.isPresent(totalExpectedCash_Txt);
    }

    public String get_TotalNumberOfExpectedCash_Txt() {
        return ActionHelper.getText(totalExpectedCash_Txt);
    }

    public Boolean isPresent_ConfirmAddToDispatch_Btn() {
        return ActionHelper.isPresent(confirmAddToDispatch_Btn);
    }

    public Boolean isPresent_CancelAddToDispatch_Btn() {
        return ActionHelper.isPresent(cancelAddToDispatch_Btn);
    }

    public Boolean isPresent_AddToDispatchHeader_Lbl() {
        return ActionHelper.isPresent(addToDispatchHeader_Lbl);
    }

    public String get_PackageNotFound_Txt() {
        ActionHelper.waitUntilElementVisible(packageNotFound_Lbl.getBy());
        return ActionHelper.getText(packageNotFound_Lbl);
    }

    public boolean isPresent_InventoryInHand_Lbl() {
        return ActionHelper.isPresent(inventoryInHand_Lbl);
    }

    public String getText_InventoryInHand_Lbl() {
        return ActionHelper.getText(inventoryInHand_Lbl);
    }

    public boolean isPresent_ExpectedCashToBeCollected_Lbl() {
        return ActionHelper.isPresent(expectedCashToBeCollected_Lbl);
    }

    public String getText_ExpectedCashToBeCollected_Lbl() {
        return ActionHelper.getText(expectedCashToBeCollected_Lbl);
    }
}