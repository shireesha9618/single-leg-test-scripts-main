package pageobjects;


import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

import static constants.Constants.WAIT_FOR_ONE_SECOND;


public class AddOrdersPage {
    private static AddOrdersPage _instance;
    private final Locator header_txt = Locator.builder().withWeb(By.xpath("//h1//div[contains(text(),'Add Orders')]"));
    private final Locator addToDispatch_Btn = Locator.builder().withWeb(By.xpath("//div[contains(@class,'ml-auto')]//button/p"));
    private final Locator searchbyOrderId_TxtBox = Locator.builder().withWeb(By.id("package-id-inpt"));
    private final Locator remove_Order_Btn = Locator.builder().withWeb(By.xpath("//tbody/tr[2]/td[1]//*[name()='svg']"));
    private final Locator youDontHaveAnyScannedShipments_Txt = Locator.builder().withWeb(By.xpath("//p[contains(text(),'You don’t have any scanned shipments')]"));
    private final Locator inventoryInHand_Lbl = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Inventory in hand']"));
    private final Locator inventoryInHand_Value = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Inventory in hand']/preceding-sibling::p"));
    private final Locator expectedCashToBeCollected_Lbl = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Expected cash to be collected']"));
    private final Locator expectedCash_Value = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Expected cash to be collected']/preceding-sibling::p"));

    public static AddOrdersPage getInstance() {
        if (_instance == null)
            _instance = new AddOrdersPage();
        return _instance;
    }

    public String get_Header_txt() {
        return ActionHelper.getText(header_txt);
    }

    public void sendTxtOn_SearchByOrderId_TxtBox(String orderId) {
        ActionHelper.sendKeys(searchbyOrderId_TxtBox, orderId);
        ActionHelper.waitForLoaderToHide();
    }

    public void clickOn_RemoveOrder_Btn() {
        ActionHelper.gotoSleep(WAIT_FOR_ONE_SECOND);
        ActionHelper.click(remove_Order_Btn);
        ActionHelper.waitForLoaderToHide();
    }

    public boolean is_YouDontHaveAnyScannedShipments_TxtPresent() {
        return ActionHelper.isPresent(youDontHaveAnyScannedShipments_Txt);
    }

    public boolean is_Dispatch_BtnEnabled() {
        return ActionHelper.isEnabled(ActionHelper.findElement(addToDispatch_Btn), WAIT_FOR_ONE_SECOND);
    }

    public boolean is_InventoryInHand_TxtPresent() {
        return ActionHelper.isPresent(inventoryInHand_Value);
    }

    public boolean is_ExpectedCashToBeCollected_TxtPresent() {
        return ActionHelper.isPresent(expectedCashToBeCollected_Lbl);
    }

    public int get_Expected_Cash(){
        ActionHelper.gotoSleep(WAIT_FOR_ONE_SECOND);
        return Integer.parseInt(ActionHelper.getText(expectedCash_Value).split("\\.")[0]);
    }
}
