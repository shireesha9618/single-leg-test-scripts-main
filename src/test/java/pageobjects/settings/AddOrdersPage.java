package pageobjects.settings;


import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;


public class AddOrdersPage {
    private static AddOrdersPage _instance;
    private final Locator header_txt = Locator.builder().withWeb(By.xpath("//h1//div[contains(text(),'Add Orders')]"));
    private final Locator search_by_Order_Id_Txt_Box = Locator.builder().withWeb(By.id("package-id-inp"));


    public static AddOrdersPage getInstance() {
        if (_instance == null)
            _instance = new AddOrdersPage();
        return _instance;
    }

    public String get_Header_txt() {
        return ActionHelper.getText(header_txt);
    }

    public void send_TxtOn_Search_BY_Order_Id_Txt_Box(String orderId) {
        ActionHelper.sendKeys(search_by_Order_Id_Txt_Box, orderId);
    }
}
