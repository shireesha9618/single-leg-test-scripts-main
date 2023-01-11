package pageobjects;


import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

import static constants.Constants.WAIT_FOR_ONE_SECOND;


public class AddOrdersPage {
    private static AddOrdersPage _instance;
    private final Locator header_txt = Locator.builder().withWeb(By.xpath("//h1//div[contains(text(),'Add Orders')]"));
    private final Locator addTo_Dispatch_Btn = Locator.builder().withWeb(By.xpath("//div[contains(@class,'ml-auto')]//button/p"));
    private final Locator search_by_Order_Id_Txt_Box = Locator.builder().withWeb(By.id("package-id-inpt"));
    private final Locator remove_Order_Btn = Locator.builder().withWeb(By.xpath("//tbody/tr[2]/td[1]//*[name()='svg']"));
    private final Locator youDontHaveAnyScannedShipments_Txt = Locator.builder().withWeb(By.xpath("//p[contains(text(),'You don’t have any scanned shipments')]"));
    private final Locator inventory_In_Hand_Lbl = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Inventory in hand']"));
    private final Locator inventory_In_Hand_Value = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Inventory in hand']/preceding-sibling::p"));
    private final Locator expectedCash_To_Be_Collected_Lbl = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Expected cash to be collected']"));
    private final Locator expected_Cash_Value = Locator.builder().withWeb(By.xpath("//p[normalize-space()='Expected cash to be collected']/preceding-sibling::p"));

    public static AddOrdersPage getInstance() {
        if (_instance == null)
            _instance = new AddOrdersPage();
        return _instance;
    }

    public String get_Header_txt() {
        return ActionHelper.getText(header_txt);
    }

    public void send_TxtOn_Search_By_Order_Id_Txt_Box(String orderId) {
        ActionHelper.sendKeys(search_by_Order_Id_Txt_Box, orderId);
    }

    public void clickOn_Remove_Order_Btn() {
        ActionHelper.gotoSleep(WAIT_FOR_ONE_SECOND);
        ActionHelper.click(remove_Order_Btn);
        ActionHelper.waitForLoaderToHide();
    }

    public boolean is_YouDontHaveAnyScannedShipments_Txt_Present() {
        return ActionHelper.isPresent(youDontHaveAnyScannedShipments_Txt);
    }

    public boolean is_Dispatch_Btn_Enabled() {
        return ActionHelper.isEnabled(ActionHelper.findElement(addTo_Dispatch_Btn), WAIT_FOR_ONE_SECOND);
    }

    public boolean is_Inventory_In_Hand_Txt_Present() {
        return ActionHelper.isPresent(inventory_In_Hand_Lbl);
    }

    public boolean is_ExpectedCash_To_Be_Collected_Txt_Present() {
        return ActionHelper.isPresent(expectedCash_To_Be_Collected_Lbl);
    }

    public int get_Expected_Cash(){
        ActionHelper.gotoSleep(WAIT_FOR_ONE_SECOND);
        return Integer.parseInt(ActionHelper.getText(expected_Cash_Value).split("\\.")[0]);
    }
}
