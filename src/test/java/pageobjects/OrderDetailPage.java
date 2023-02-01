package pageobjects;

import constants.Constants;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import utility.Utility;

import java.util.List;

public class OrderDetailPage {
    private static OrderDetailPage _instance;

    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//h1"));
    private final Locator subHeader_Lbl = Locator.builder().withWeb(By.xpath("//h1/following-sibling::h5"));
    private final Locator status_Lbl = Locator.builder().withWeb(By.xpath("//h6"));
    private final Locator createdOn_Lbl = Locator.builder().withWeb(By.xpath("//div[h6]/following-sibling::span/p"));

    private final Locator homeBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li//a[@href='/fpa/']"));
    private final Locator orderListBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/orders/list']//a[@href='/fpa/orders/list/']"));
    private final Locator orderDetailsBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/orders/detail']//a[contains(@href, '/fpa/orders/detail/')]"));

    private final Locator cancelOrder_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel Order']"));
    private final Locator cancelOrderBtnHeader_Lbl = Locator.builder().withWeb(By.xpath("//h1[text()='Cancel Order']"));
    private final Locator cancelOrderBtnSubHeader_Lbl = Locator.builder().withWeb(By.xpath("//h1[text()='Cancel Order']/following-sibling::p"));
    private final Locator cancelOrderBtnBack_Btn = Locator.builder().withWeb(By.xpath("//h1[text()='Cancel Order']/following-sibling::div/button[p[text()='Back']]"));
    private final Locator cancelOrderBtnCancelOrder_Btn = Locator.builder().withWeb(By.xpath("//h1[text()='Cancel Order']/following-sibling::div/button[p[text()='Cancel Order']]"));

    private final Locator orderDetailsHeader_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Order Details'])[2]"));
    private final Locator orderDetailsDescription_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Description']/following-sibling::p"));
    private final Locator orderDetailsTeam_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Team']/following-sibling::p"));

    private final Locator paymentDetailsHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Payment Details']"));
    private final Locator paymentDetailsPaymentType_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Payment Type']/following-sibling::p"));
    private final Locator paymentDetailsAmount_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Amount']/following-sibling::p"));

    private final Locator trackingDetailsHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Tracking Details']"));
    private final Locator trackingDetailsEventCodeList_Lbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[1]"));
    private final Locator trackingDetailsStatusDateList_Lbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[2]/span"));
    private final Locator trackingDetailsRemarksList_Lbl = Locator.builder().withWeb(By.xpath("//tbody/tr/td[3]/span"));

    private final Locator pickupAndDropDetailsHeader_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Pickup & drop Details']"));
    private final Locator pickupAndDropDetailsPickupAddressLine1ShowHide_Btn = Locator.builder().withWeb(By.xpath("(//p[text()='Pickup Address']/following-sibling::div)[1]/div"));
    private final Locator pickupAndDropDetailsPickupAddressLine1_Lbl = Locator.builder().withWeb(By.xpath("((//p[text()='Pickup Address']/following-sibling::div)[1]/div/div)[1]"));
    private final Locator pickupAndDropDetailsPickupAddressLine2_Lbl = Locator.builder().withWeb(By.xpath("((//p[text()='Pickup Address']/following-sibling::div)[1]/div/div)[2]"));
    private final Locator pickupAndDropDetailsPickupDateTime_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Pickup Address']/following-sibling::div/span)[1]"));
    private final Locator pickupAndDropDetailsPickupPOCName_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Pickup Address']/following-sibling::div/span)[2]"));
    private final Locator pickupAndDropDetailsPickupTimeSlot_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Pickup Address']/following-sibling::div/span)[3]"));
    private final Locator pickupAndDropDetailsPickupPOCNumberShowHide_Btn = Locator.builder().withWeb(By.xpath("(//p[text()='Pickup Address']/following-sibling::div/span)[4]/div/div"));
    private final Locator pickupAndDropDetailsPickupPOCNumber_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Pickup Address']/following-sibling::div/span)[4]/div/div/div"));
    private final Locator pickupAndDropDetailsDropAddressLine1ShowHide_Btn = Locator.builder().withWeb(By.xpath("(//p[text()='Drop Address']/following-sibling::div)[1]/div"));
    private final Locator pickupAndDropDetailsDropAddressLine1_Lbl = Locator.builder().withWeb(By.xpath("((//p[text()='Drop Address']/following-sibling::div)[1]/div/div)[1]"));
    private final Locator pickupAndDropDetailsDropAddressLine2_Lbl = Locator.builder().withWeb(By.xpath("((//p[text()='Drop Address']/following-sibling::div)[1]/div/div)[2]"));
    private final Locator pickupAndDropDetailsDropDateTime_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Drop Address']/following-sibling::div/span)[1]"));
    private final Locator pickupAndDropDetailsDropPOCName_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Drop Address']/following-sibling::div/span)[2]"));
    private final Locator pickupAndDropDetailsDropTimeSlot_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Drop Address']/following-sibling::div/span)[3]"));
    private final Locator pickupAndDropDetailsDropPOCNumberShowHide_Btn = Locator.builder().withWeb(By.xpath("(//p[text()='Drop Address']/following-sibling::div/span)[4]/div/div"));
    private final Locator pickupAndDropDetailsDropPOCNumber_Lbl = Locator.builder().withWeb(By.xpath("(//p[text()='Drop Address']/following-sibling::div/span)[4]/div/div/div"));

    public static OrderDetailPage getInstance() {
        if (_instance == null)
            _instance = new OrderDetailPage();
        return _instance;
    }

    public boolean isPresent_Header_Lbl() {
        return ActionHelper.isPresent(header_Lbl, Constants.WAIT_FOR_FIVE_SECOND);
    }

    public String getText_Header_Lbl() {
        return ActionHelper.getText(header_Lbl);
    }

    public boolean isPresent_SubHeader_Lbl() {
        return ActionHelper.isPresent(subHeader_Lbl);
    }

    public String getText_SubHeader_Lbl() {
        return ActionHelper.getText(subHeader_Lbl).replace("\n", "");
    }

    public boolean isPresent_Status_Lbl() {
        return ActionHelper.isPresent(status_Lbl);
    }

    public String getText_Status_Lbl() {
        return ActionHelper.getText(status_Lbl);
    }

    public boolean isPresent_CreatedOn_Lbl() {
        return ActionHelper.isPresent(createdOn_Lbl);
    }

    public String getText_CreatedOn_Lbl() {
        return ActionHelper.getText(createdOn_Lbl);
    }

    public boolean isPresent_HomeBreadCrumb_Link() {
        return ActionHelper.isPresent(homeBreadCrumb_Link);
    }

    public void click_HomeBreadCrumb_Link() {
        ActionHelper.click(homeBreadCrumb_Link);
    }

    public boolean isPresent_OrderListBreadCrumb_Link() {
        return ActionHelper.isPresent(orderListBreadCrumb_Link);
    }

    public void click_OrderListBreadCrumb_Link() {
        ActionHelper.click(orderListBreadCrumb_Link);
    }

    public boolean isPresent_OrderDetailsBreadCrumb_Link() {
        return ActionHelper.isPresent(orderDetailsBreadCrumb_Link);
    }

    public void click_OrderDetailsBreadCrumb_Link() {
        ActionHelper.click(orderDetailsBreadCrumb_Link);
    }

    public boolean isPresent_CancelOrder_Btn() {
        return ActionHelper.isPresent(cancelOrder_Btn);
    }

    public void click_CancelOrder_Btn() {
        ActionHelper.click(cancelOrder_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_CancelOrderBtnHeader_Lbl() {
        return ActionHelper.isPresent(cancelOrderBtnHeader_Lbl);
    }

    public String getText_CancelOrderBtnSubHeader_Lbl() {
        return ActionHelper.getText(cancelOrderBtnSubHeader_Lbl);
    }

    public boolean isPresent_CancelOrderBtnBack_Btn() {
        return ActionHelper.isPresent(cancelOrderBtnBack_Btn);
    }

    public void click_CancelOrderBtnBack_Btn() {
        ActionHelper.click(cancelOrderBtnBack_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_CancelOrderBtnCancelOrder_Btn() {
        return ActionHelper.isPresent(cancelOrderBtnCancelOrder_Btn);
    }

    public void click_CancelOrderBtnCancelOrder_Btn() {
        ActionHelper.click(cancelOrderBtnCancelOrder_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_OrderDetailsHeader_Lbl() {
        return ActionHelper.isPresent(orderDetailsHeader_Lbl, Constants.WAIT_FOR_FIVE_SECOND);
    }

    public boolean isPresent_OrderDetailsDescription_Lbl() {
        return ActionHelper.isPresent(orderDetailsDescription_Lbl);
    }

    public String getText_OrderDetailsDescription_Lbl() {
        return ActionHelper.getText(orderDetailsDescription_Lbl);
    }

    public boolean isPresent_OrderDetailsTeam_Lbl() {
        return ActionHelper.isPresent(orderDetailsTeam_Lbl);
    }

    public String getText_OrderDetailsTeam_Lbl() {
        return ActionHelper.getText(orderDetailsTeam_Lbl);
    }

    public boolean isPresent_PaymentDetailsHeader_Lbl() {
        return ActionHelper.isPresent(paymentDetailsHeader_Lbl, Constants.WAIT_FOR_FIVE_SECOND);
    }

    public boolean isPresent_PaymentDetailsPaymentType_Lbl() {
        return ActionHelper.isPresent(paymentDetailsPaymentType_Lbl);
    }

    public String getText_PaymentDetailsPaymentType_Lbl() {
        return ActionHelper.getText(paymentDetailsPaymentType_Lbl);
    }

    public boolean isPresent_PaymentDetailsAmount_Lbl() {
        return ActionHelper.isPresent(paymentDetailsAmount_Lbl);
    }

    public String getText_PaymentDetailsAmount_Lbl() {
        return ActionHelper.getText(paymentDetailsAmount_Lbl);
    }

    public boolean isPresent_TrackingDetailsHeader_Lbl() {
        return ActionHelper.isPresent(trackingDetailsHeader_Lbl, Constants.WAIT_FOR_FIVE_SECOND);
    }

    public List<String> getText_TrackingDetailsEventCodeList_Lbl() {
        return Utility.getText_ListOfWebElements(trackingDetailsEventCodeList_Lbl.getBy());
    }

    public List<String> getText_TrackingDetailsStatusDateList_Lbl() {
        return Utility.getText_ListOfWebElements(trackingDetailsStatusDateList_Lbl.getBy());
    }

    public List<String> getText_TrackingDetailsRemarksList_Lbl() {
        return Utility.getText_ListOfWebElements(trackingDetailsRemarksList_Lbl.getBy());
    }

    public boolean isPresent_PickupAndDropDetailsHeader_Lbl() {
        Utility.scrollUsingJS(pickupAndDropDetailsHeader_Lbl.getBy());
        return ActionHelper.isPresent(pickupAndDropDetailsHeader_Lbl);
    }

    public boolean isPresent_PickupAndDropDetailsPickupAddressLine1ShowHide_Btn() {
        return ActionHelper.isPresent(pickupAndDropDetailsPickupAddressLine1ShowHide_Btn);
    }

    public void click_PickupAndDropDetailsPickupAddressLine1ShowHide_Btn() {
        ActionHelper.click(pickupAndDropDetailsPickupAddressLine1ShowHide_Btn);
    }

    public boolean isPresent_PickupAndDropDetailsPickupAddressLine1_Lbl() {
        return ActionHelper.isPresent(pickupAndDropDetailsPickupAddressLine1_Lbl);
    }

    public String getText_PickupAndDropDetailsPickupAddressLine1_Lbl() {
        return ActionHelper.getText(pickupAndDropDetailsPickupAddressLine1_Lbl);
    }

    public boolean isPresent_PickupAndDropDetailsPickupAddressLine2_Lbl() {
        return ActionHelper.isPresent(pickupAndDropDetailsPickupAddressLine2_Lbl);
    }

    public String getText_PickupAndDropDetailsPickupAddressLine2_Lbl() {
        return ActionHelper.getText(pickupAndDropDetailsPickupAddressLine2_Lbl);
    }

    public boolean isPresent_PickupAndDropDetailsPickupDateTime_Lbl() {
        return ActionHelper.isPresent(pickupAndDropDetailsPickupDateTime_Lbl);
    }

    public String getText_PickupAndDropDetailsPickupDateTime_Lbl() {
        return ActionHelper.getText(pickupAndDropDetailsPickupDateTime_Lbl);
    }

    public boolean isPresent_PickupAndDropDetailsPickupPOCName_Lbl() {
        return ActionHelper.isPresent(pickupAndDropDetailsPickupPOCName_Lbl);
    }

    public String getText_PickupAndDropDetailsPickupPOCName_Lbl() {
        return ActionHelper.getText(pickupAndDropDetailsPickupPOCName_Lbl);
    }

    public boolean isPresent_PickupAndDropDetailsPickupTimeSlot_Lbl() {
        return ActionHelper.isPresent(pickupAndDropDetailsPickupTimeSlot_Lbl);
    }

    public String getText_PickupAndDropDetailsPickupTimeSlot_Lbl() {
        return ActionHelper.getText(pickupAndDropDetailsPickupTimeSlot_Lbl);
    }

    public boolean isPresent_PickupAndDropDetailsPickupPOCNumberShowHide_Btn() {
        return ActionHelper.isPresent(pickupAndDropDetailsPickupPOCNumberShowHide_Btn);
    }

    public String getText_PickupAndDropDetailsPickupPOCNumberShowHide_Btn() {
        return ActionHelper.getText(pickupAndDropDetailsPickupPOCNumberShowHide_Btn);
    }

    public void click_PickupAndDropDetailsPickupPOCNumberShowHide_Btn() {
        ActionHelper.click(pickupAndDropDetailsPickupPOCNumberShowHide_Btn);
    }

    public boolean isPresent_PickupAndDropDetailsPickupPOCNumber_Lbl() {
        return ActionHelper.isPresent(pickupAndDropDetailsPickupPOCNumber_Lbl);
    }

    public String getText_PickupAndDropDetailsPickupPOCNumber_Lbl() {
        return ActionHelper.getText(pickupAndDropDetailsPickupPOCNumber_Lbl);
    }

    public boolean isPresent_PickupAndDropDetailsDropAddressLine1ShowHide_Btn() {
        return ActionHelper.isPresent(pickupAndDropDetailsDropAddressLine1ShowHide_Btn);
    }

    public void click_PickupAndDropDetailsDropAddressLine1ShowHide_Btn() {
        ActionHelper.click(pickupAndDropDetailsDropAddressLine1ShowHide_Btn);
    }

    public boolean isPresent_PickupAndDropDetailsDropAddressLine1_Lbl() {
        return ActionHelper.isPresent(pickupAndDropDetailsDropAddressLine1_Lbl);
    }

    public String getText_PickupAndDropDetailsDropAddressLine1_Lbl() {
        return ActionHelper.getText(pickupAndDropDetailsDropAddressLine1_Lbl);
    }

    public boolean isPresent_PickupAndDropDetailsDropAddressLine2_Lbl() {
        return ActionHelper.isPresent(pickupAndDropDetailsDropAddressLine2_Lbl);
    }

    public String getText_PickupAndDropDetailsDropAddressLine2_Lbl() {
        return ActionHelper.getText(pickupAndDropDetailsDropAddressLine2_Lbl);
    }

    public boolean isPresent_PickupAndDropDetailsDropDateTime_Lbl() {
        return ActionHelper.isPresent(pickupAndDropDetailsDropDateTime_Lbl);
    }

    public String getText_PickupAndDropDetailsDropDateTime_Lbl() {
        return ActionHelper.getText(pickupAndDropDetailsDropDateTime_Lbl);
    }

    public boolean isPresent_PickupAndDropDetailsDropPOCName_Lbl() {
        return ActionHelper.isPresent(pickupAndDropDetailsDropPOCName_Lbl);
    }

    public String getText_PickupAndDropDetailsDropPOCName_Lbl() {
        return ActionHelper.getText(pickupAndDropDetailsDropPOCName_Lbl);
    }

    public boolean isPresent_PickupAndDropDetailsDropTimeSlot_Lbl() {
        return ActionHelper.isPresent(pickupAndDropDetailsDropTimeSlot_Lbl);
    }

    public String getText_PickupAndDropDetailsDropTimeSlot_Lbl() {
        return ActionHelper.getText(pickupAndDropDetailsDropTimeSlot_Lbl);
    }

    public boolean isPresent_PickupAndDropDetailsDropPOCNumberShowHide_Btn() {
        return ActionHelper.isPresent(pickupAndDropDetailsDropPOCNumberShowHide_Btn);
    }

    public String getText_PickupAndDropDetailsDropPOCNumberShowHide_Btn() {
        return ActionHelper.getText(pickupAndDropDetailsDropPOCNumberShowHide_Btn);
    }

    public void click_PickupAndDropDetailsDropPOCNumberShowHide_Btn() {
        ActionHelper.click(pickupAndDropDetailsDropPOCNumberShowHide_Btn);
    }

    public boolean isPresent_PickupAndDropDetailsDropPOCNumber_Lbl() {
        return ActionHelper.isPresent(pickupAndDropDetailsDropPOCNumber_Lbl);
    }

    public String getText_PickupAndDropDetailsDropPOCNumber_Lbl() {
        return ActionHelper.getText(pickupAndDropDetailsDropPOCNumber_Lbl);
    }


}
