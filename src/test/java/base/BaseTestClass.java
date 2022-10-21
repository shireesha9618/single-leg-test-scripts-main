package base;

import framework.common.generic.GenericFunctions;
import framework.common.listeners.TestNGReportListener;
import framework.frontend.generic.GenericFunctionsWeb;
import framework.frontend.listeners.InvocationListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({InvocationListener.class, TestNGReportListener.class})
public class BaseTestClass {
    GenericFunctions genericFunctions;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws Exception {
        System.out.println("======================== INSIDE BEFORE SUITE ========================");
        genericFunctions = new GenericFunctionsWeb();
        genericFunctions.init();
        System.out.println("======================== BEFORE COMPLETE ========================");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        genericFunctions.quit();
    }

}