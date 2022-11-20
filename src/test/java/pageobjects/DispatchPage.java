package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class DispatchPage {
    private static DispatchPage _instance;
    private final Locator dispatchesCount_Lbl = Locator.builder().withWeb(By.xpath("//p[@class='text-black text-base font-normal' and text()='Dispatches']/preceding-sibling::p"));
    private final Locator firstElementName_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]/td[2]//p/a"));
    private final Locator firstElementStatus_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]/td[3]//h6"));
    private final Locator deliveredCountStatus_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]/td[4]/div/div[@class='cursor-pointer '][1]//p"));
    private final Locator firstElementDeliveredCountStatus_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]/td[4]/div/div[@class='cursor-pointer '][1]//p"));
    private final Locator firstElementFailedOrdersCountStatus_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]/td[4]/div/div[@class='cursor-pointer '][2]//p"));
    private final Locator firstElementRemainingOrdersCountStatus_Lbl = Locator.builder().withWeb(By.xpath("//tr[2]/td[4]/div/div[@class='cursor-pointer '][3]//p"));
    private final Locator assignedCount_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Assigned'])/./preceding-sibling::p"));
    private final Locator startedCount_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Started'])/./preceding-sibling::p"));
    private final Locator ongoingCount_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Ongoing'])/./preceding-sibling::p"));
    private final Locator closedCount_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Ongoing'])/./preceding-sibling::p"));


    public static DispatchPage getInstance() {
        if (_instance == null) _instance = new DispatchPage();
        return _instance;
    }

    public void select_FirstElement_Lbl() {
        ActionHelper.click(firstElementName_Lbl);
    }

    public String get_FirstElementStatus_Lbl() {
        return ActionHelper.getText(firstElementStatus_Lbl);
    }

    public String get_FirstElementDeliveredCountStatus_Lbl() {
        return ActionHelper.getText(firstElementDeliveredCountStatus_Lbl);
    }

    public String get_FirstElementFailedOrdersCountStatus_Lbl() {
        return ActionHelper.getText(firstElementFailedOrdersCountStatus_Lbl);
    }

    public String get_FirstElementRemainingOrdersCountStatus_Lbl() {
        return ActionHelper.getText(firstElementRemainingOrdersCountStatus_Lbl);
    }

    public String get_AssignedCount_Lbl() {
        return ActionHelper.getText(assignedCount_Lbl);
    }

    public String get_StartedCount_Lbl() {
        return ActionHelper.getText(startedCount_Lbl);
    }

    public String get_OngoingCount_Lbl() {
        return ActionHelper.getText(ongoingCount_Lbl);
    }

    public String get_ClosedCount_Lbl() {
        return ActionHelper.getText(closedCount_Lbl);
    }

    public String get_DispatchCount_Lbl() {
        return ActionHelper.getText(dispatchesCount_Lbl);
    }


}
