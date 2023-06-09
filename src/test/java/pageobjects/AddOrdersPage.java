package pageobjects;


import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

import java.util.List;

import static constants.Constants.WAIT_FOR_ONE_SECOND;

public class AddOrdersPage {
    private static AddOrdersPage _instance;
    private final Locator header_Txt = Locator.builder().withWeb(By.xpath("//h1//div[contains(text(),'Add Orders')]"));
    private final Locator addToDispatch_Btn = Locator.builder().withWeb(By.xpath("//div[contains(@class,'ml-auto')]//button/p"));
    private final Locator searchbyOrderId_TxtBox = Locator.builder().withWeb(By.id("package-id-inpt"));
    private final Locator removeOrder_Btn = Locator.builder().withWeb(By.xpath("//tbody/tr/td[1]//*[name()='svg']"));
    private final Locator youDontHaveAnyScannedShipments_Txt = Locator.builder().withWeb(By.xpath("//p[contains(text(),'You don’t have any scanned shipments')]"));
    private final Locator inventoryInHand_Lbl = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Inventory in hand']"));
    private final Locator inventoryInHand_Value = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Inventory in hand']/preceding-sibling::p"));
    private final Locator expectedCashToBeCollected_Lbl = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Expected cash to be collected']"));
    private final Locator expectedCash_Value = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Expected cash to be collected']/preceding-sibling::p"));

    public static AddOrdersPage getInstance() {
        if (_instance == null) _instance = new AddOrdersPage();
        return _instance;
    }

    public String getText_Header_Txt() {
        return ActionHelper.getText(header_Txt);
    }

    public void fill_SearchByOrderId_TxtBox(String orderId) {
        ActionHelper.sendKeys(searchbyOrderId_TxtBox, orderId);
        ActionHelper.waitForLoaderToHide();
    }

    public void clickOn_RemoveOrder_Btn(int orderIndexNumber) {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.click(ActionHelper.findElements(removeOrder_Btn).get(orderIndexNumber));
        ActionHelper.waitForLoaderToHide();
    }

    public boolean isPresent_YouDontHaveAnyScannedShipments_Txt() {
        return ActionHelper.isPresent(youDontHaveAnyScannedShipments_Txt);
    }

    public boolean isEnabled_Dispatch_Btn() {
        return ActionHelper.isEnabled(ActionHelper.findElement(addToDispatch_Btn), WAIT_FOR_ONE_SECOND);
    }

    public boolean isPresent_InventoryInHand_Txt() {
        return ActionHelper.isPresent(inventoryInHand_Value);
    }

    public boolean isPresent_ExpectedCashToBeCollected_Txt() {
        return ActionHelper.isPresent(expectedCashToBeCollected_Lbl);
    }

    public int getText_ExpectedCashValue_Txt() {
        ActionHelper.waitForLoaderToHide();
        ActionHelper.waitUntilElementVisible(expectedCash_Value.getBy());
        return Integer.parseInt(ActionHelper.getText(expectedCash_Value).split("\\.")[0]);
    }

    public void click_AddToDispatch_Btn() {
        ActionHelper.click(addToDispatch_Btn);
    }

    public void fill_SearchByOrderIdOnScanOrdersPage_TxtBox(List<String> orderIds) {
        if (orderIds.size() > 0) {
            DispatchDetailPage.getInstance().click_ScanToAddOrders_Btn();
            for (String orderId : orderIds) {
                ActionHelper.sendKeysWithClear(searchbyOrderId_TxtBox.getBy(), orderId);
                System.out.println(orderId);
                ActionHelper.waitForLoaderToHide();
            }
            AddOrdersPage.getInstance().click_AddToDispatch_Btn();
            AddToDispatchPage.getInstance().click_AddToDispatch_Btn();
        }
    }

}