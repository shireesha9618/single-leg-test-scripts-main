package testsuite.order;

import base.BaseTestClass;
import org.testng.annotations.Test;
import pageobjects.CommonActions;

public class TestSuite_CreateOrders extends BaseTestClass {


    @Test
    public void test(){
        CommonActions.getInstance().coverJourneyTillCreateOrder();
    }
}
