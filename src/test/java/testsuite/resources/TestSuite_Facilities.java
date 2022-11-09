package testsuite.resources;

import constants.TestGroup;
import framework.common.assertion.JarvisAssert;
import framework.common.assertion.JarvisSoftAssert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class TestSuite_Facilities {
    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.FACILITY, TestGroup.BVT},
            description = "TC_001, Verify The UI Of Facilities Page")
    public void TC_Facility_001_Verify_The_UI_Of_Facilities_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();

    }
}
