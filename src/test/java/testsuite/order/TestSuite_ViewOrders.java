package testsuite.order;

import base.BaseTestClass;
import com.github.javafaker.Faker;
import constants.Constants;
import constants.TestGroup;
import framework.common.assertion.JarvisAssert;
import framework.common.assertion.JarvisSoftAssert;
import framework.frontend.actions.ActionHelper;
import framework.frontend.managers.DriverManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageobjects.CommonActions;
import pageobjects.CreateNewOrderPage;
import pageobjects.DispatchPage;
import pageobjects.OrderDetailPage;
import pageobjects.ViewOrderPage;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite_ViewOrders extends BaseTestClass {

    CommonActions commonActions = CommonActions.getInstance();
    CreateNewOrderPage createNewOrderPage = CreateNewOrderPage.getInstance();
    OrderDetailPage orderDetailPage = OrderDetailPage.getInstance();
    ViewOrderPage viewOrderPage = ViewOrderPage.getInstance();
    Faker faker = new Faker();

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_001, Verify The UI Of Orders Page")
    public void TC_ViewOrder_001_Verify_UI_Of_Orders_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        softAssert.assertTrue(viewOrderPage.isPresent_SearchBar_Txt(), "Check Visibility of Searchbar field");
        softAssert.assertTrue(viewOrderPage.isPresent_NewOrder_Btn(), "Check Visibility of New Order button");
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRider_Btn(), "Check Visibility of Assign Rider button");
        softAssert.assertTrue(viewOrderPage.isEnabled_AssignRider_Btn(), "Check Visibility of Assign Rider button");
        softAssert.assertTrue(viewOrderPage.isPresent_FromDateField_Txt(), "Check Visibility of Date field");
        softAssert.assertTrue(viewOrderPage.isPresent_Refresh_Btn(), "Check Visibility of Refresh button");
        softAssert.assertTrue(viewOrderPage.isPresent_ToBeAssigned_Lbl(), "Check Visibility of To Be Assigned count");
        softAssert.assertTrue(viewOrderPage.isPresent_ToBeDispatched_Lbl(), "Check Visibility of To Be Dispatched count");
        softAssert.assertTrue(viewOrderPage.isPresent_Dispatched_Lbl(), "Check Visibility of Dispatched count");
        softAssert.assertTrue(viewOrderPage.isPresent_Delivered_Lbl(), "Check Visibility of Delivered count");
        softAssert.assertTrue(viewOrderPage.isPresent_Failed_Lbl(), "Check Visibility of Failed count");
        softAssert.assertTrue(viewOrderPage.isPresent_Remaining_Lbl(), "Check Visibility of Remaining count");
        softAssert.assertTrue(viewOrderPage.isPresent_OrderListBreadcrumb_Link(), "Check Visibility of Order List breadcrumb");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_002, Verify The UI Of Table Present In Order Page")
    public void TC_ViewOrder_002_Verify_The_UI_Of_Table_Present_In_Order_Page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        List<String> actualTabHeadersLabels = viewOrderPage.getText_TabHeader_ListLbl();
        List<String> expectedTabHeaders = new ArrayList<>(List.of("ORDER ID", "STATUS", "PICKUP ADDRESS", "DROP ADDRESS", "PICKUP POSTAL CODE",
                "DROP POSTAL CODE", "PAYMENT TYPE", "AMOUNT"));
        Collections.sort(actualTabHeadersLabels);
        Collections.sort(expectedTabHeaders);
        for (int size = 0; size < actualTabHeadersLabels.size(); size++) {
            softAssert.assertEquals(actualTabHeadersLabels.get(size), expectedTabHeaders.get(size), "Table Header label is matched as expected.");
        }
        softAssert.assertTrue(viewOrderPage.getList_TabHeaderCheckbox_ListCheckbox().size() > 0, "Validate presence of checkboxes");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_003, Verify The Functionality Of Search Bar")
    public void TC_ViewOrder_003_Verify_The_Functionality_Of_Search_Bar() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        String orderId = viewOrderPage.getText_TabHeaderOrderId_ListLink(0);
        viewOrderPage.fillWithClear_SearchBar_Txt(orderId);
        List<String> orderList = viewOrderPage.getText_TabHeaderOrderId_ListLink();
        softAssert.assertEquals(orderList.size(), 1, "Validate no of orders");
        softAssert.assertEquals(orderList.get(0), orderId, "Validate Order Id");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_004, Verify The UI Of Status Button")
    public void TC_ViewOrder_004_Verify_The_UI_Of_Status_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.click_Status_Dropdown();
        softAssert.assertTrue(viewOrderPage.isPresent_StatusDropdownCreated_Radio(), "Validate presence of Created radio button");
        softAssert.assertTrue(viewOrderPage.isPresent_StatusDropdownAssigned_Radio(), "Validate presence of Assigned radio button");
        softAssert.assertTrue(viewOrderPage.isPresent_StatusDropdownInProgress_Radio(), "Validate presence of In Progress radio button");
        softAssert.assertTrue(viewOrderPage.isPresent_StatusDropdownCompleted_Radio(), "Validate presence of Completed radio button");
        softAssert.assertTrue(viewOrderPage.isPresent_StatusDropdownCreationFailed_Radio(), "Validate presence of Creation Failed radio button");
        softAssert.assertTrue(viewOrderPage.isPresent_StatusDropdownCancelled_Radio(), "Validate presence of Cancelled radio button");
        softAssert.assertTrue(viewOrderPage.isPresent_StatusDropdownFailed_Radio(), "Validate presence of Failed radio button");
        softAssert.assertTrue(viewOrderPage.isPresent_StatusDropdownClearSelection_Btn(), "Validate presence of Clear Selection button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_005, Verify The Functionality Of Filter The Orders With Created Status ")
    public void TC_ViewOrder_005_Verify_The_Functionality_Of_Filter_The_Orders_With_Created_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.click_Status_Dropdown();
        viewOrderPage.click_StatusDropdownCreated_Radio();
        for (String text : viewOrderPage.getText_TabHeaderStatus_ListLbl())
            softAssert.assertEquals(text, "Created", "Validate status is Created");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_006, Verify The Functionality Of Filter The Orders With Assigned Status ")
    public void TC_ViewOrder_006_Verify_The_Functionality_Of_Filter_The_Orders_With_Assigned_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.click_Status_Dropdown();
        viewOrderPage.click_StatusDropdownAssigned_Radio();
        for (String text : viewOrderPage.getText_TabHeaderStatus_ListLbl())
            softAssert.assertEquals(text, "Assigned", "Validate status is Assigned");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_007, Verify The Functionality Of Filter The Orders With In progress Status ")
    public void TC_ViewOrder_007_Verify_The_Functionality_Of_Filter_The_Orders_With_In_progress_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.click_Status_Dropdown();
        viewOrderPage.click_StatusDropdownInProgress_Radio();
        for (String text : viewOrderPage.getText_TabHeaderStatus_ListLbl())
            softAssert.assertEquals(text, "In-Progress", "Validate status is In-Progress");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_008, Verify The Functionality Of Filter The Orders With Completed Status ")
    public void TC_ViewOrder_008_Verify_The_Functionality_Of_Filter_The_Orders_With_Completed_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.click_Status_Dropdown();
        viewOrderPage.click_StatusDropdownCompleted_Radio();
        for (String text : viewOrderPage.getText_TabHeaderStatus_ListLbl())
            softAssert.assertEquals(text, "Completed", "Validate status is Completed");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_009, Verify The Functionality Of Filter The Orders With Creation Failed Status ")
    public void TC_ViewOrder_009_Verify_The_Functionality_Of_Filter_The_Orders_With_Creation_Failed_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.click_Status_Dropdown();
        viewOrderPage.click_StatusDropdownCreationFailed_Radio();
        for (String text : viewOrderPage.getText_TabHeaderStatus_ListLbl())
            softAssert.assertEquals(text, "Creation Failed", "Validate status is Creation Failed");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_010, Verify The Functionality Of Filter The Orders With Failed Status ")
    public void TC_ViewOrder_010_Verify_The_Functionality_Of_Filter_The_Orders_With_Failed_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.click_Status_Dropdown();
        viewOrderPage.click_StatusDropdownFailed_Radio();
        for (String text : viewOrderPage.getText_TabHeaderStatus_ListLbl())
            softAssert.assertEquals(text, "Failed", "Validate status is Failed");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_011, Verify The Functionality Of Filter The Orders With Cancelled Status ")
    public void TC_ViewOrder_011_Verify_The_Functionality_Of_Filter_The_Orders_With_Cancelled_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.click_Status_Dropdown();
        viewOrderPage.click_StatusDropdownCancelled_Radio();
        for (String text : viewOrderPage.getText_TabHeaderStatus_ListLbl())
            softAssert.assertEquals(text, "Cancelled", "Validate status is Cancelled");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_012, Verify The Functionality Of Clear Selection Button In Status")
    public void TC_ViewOrder_012_Verify_The_Functionality_Of_Clear_Selection_Button_In_Status() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        List<String> initialStatusList = viewOrderPage.getText_TabHeaderStatus_ListLbl();
        viewOrderPage.click_Status_Dropdown();
        viewOrderPage.click_DateFilterDropdownCreatedDate_Radio();
        for (String text : viewOrderPage.getText_TabHeaderStatus_ListLbl())
            softAssert.assertEquals(text, "Created", "Validate status is Created");

        viewOrderPage.click_StatusDropdownClearSelection_Btn();
        List<String> currentStatusList = viewOrderPage.getText_TabHeaderStatus_ListLbl();
        for (int i = 0; i < initialStatusList.size(); i++)
            softAssert.assertEquals(currentStatusList.get(i), initialStatusList.get(i), "Validate status is the same as initial values");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_013, Verify The Functionality Of Refresh Button In Orders page")
    public void TC_ViewOrder_013_Verify_The_Functionality_Of_Refresh_Button_In_Orders_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        String orderId = viewOrderPage.get_FirstElementOrderId_Txt();
        viewOrderPage.fillWithClear_SearchBar_Txt(orderId);
        List<String> orders = viewOrderPage.getText_TabHeaderOrderId_ListLink();
        softAssert.assertEquals(orders.size(), 1, "Size is matched as expected " + "1");
        softAssert.assertEquals(orders.get(0), orderId, "Validate Order Id");
        viewOrderPage.click_Refresh_Btn();
        softAssert.assertTrue(viewOrderPage.getText_TabHeaderOrderId_ListLink().size() > 1, "Validate no. of records to be more than 1");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_014, Verify The Functionality Of  in view orders count as per the display records")
    public void TC_ViewOrder_014_Verify_The_Functionality_Of_in_view_orders_count_as_per_the_display_records() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        softAssert.assertEquals(Utility.addNumbersInStringFormat(viewOrderPage.getText_ToBeAssigned_Lbl(),
                viewOrderPage.getText_ToBeDispatched_Lbl(), viewOrderPage.getText_Dispatched_Lbl(), viewOrderPage.getText_Delivered_Lbl(),
                viewOrderPage.getText_Failed_Lbl(), viewOrderPage.getText_Remaining_Lbl()), CommonActions.getInstance().getText_PaginationTotalCount_Lbl(),
                "Validate the total no. of records being displayed");
        softAssert.assertAll();
    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_015, Verify The UI of Calender in Orders page")
    public void TC_ViewOrder_015_Verify_The_UI_of_Calender_in_Orders_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.click_DateFilter_Dropdown();
        softAssert.assertTrue(viewOrderPage.isPresent_DateFilterDropdownCreatedDate_Radio(), "Validate presence of Created Date radio button");
        softAssert.assertTrue(viewOrderPage.isPresent_DateFilterDropdownClosureDate_Radio(), "Validate presence of Closure Date radio button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_016, Verify Next And Previous Year Button On Calender")
    public void TC_ViewOrder_016_Verify_Next_And_Previous_Year_Button_On_Calender() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.click_FromDateField_Txt();
        String currentFromYear = commonActions.getText_CalendarFromYear_Btn();
        String currentToYear = commonActions.getText_CalendarToYear_Btn();
        commonActions.click_CalendarNextYear_Btn();
        softAssert.assertEquals(commonActions.getText_CalendarFromYear_Btn(), Utility.getNextYear(currentFromYear), "Validate the value of From Year");
        softAssert.assertEquals(commonActions.getText_CalendarToYear_Btn(), Utility.getNextYear(currentToYear), "Validate the value of To Year");

        currentFromYear = commonActions.getText_CalendarFromYear_Btn();
        currentToYear = commonActions.getText_CalendarToYear_Btn();
        commonActions.click_CalendarPreviousYear_Btn();
        softAssert.assertEquals(commonActions.getText_CalendarFromYear_Btn(), Utility.getPreviousYear(currentFromYear), "Validate the value of From Year");
        softAssert.assertEquals(commonActions.getText_CalendarToYear_Btn(), Utility.getPreviousYear(currentToYear), "Validate the value of To Year");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_017, Verify The Default start date and end date in Calender")
    public void TC_ViewOrder_017_Verify_The_Default_start_date_and_end_date_in_Calender() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        softAssert.assertEquals(viewOrderPage.getValue_FromDateField_Txt(), ActionHelper.getCustomPreviousDateFormatter("yyyy-MM-dd", 1), "Validate from date value");
        softAssert.assertEquals(viewOrderPage.getValue_ToDateField_Txt(), Utility.getCustomCurrentDateFormatter("yyyy-MM-dd"), "Validate to date value");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_018, Verify Next And Previous Month Button On Calender")
    public void TC_ViewOrder_018_Verify_Next_And_Previous_Month_Button_On_Calender() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.click_FromDateField_Txt();
        String currentFromMonth = commonActions.getText_CalendarFromMonth_Btn();
        String currentToMonth = commonActions.getText_CalendarToMonth_Btn();
        commonActions.click_CalendarNextMonth_Btn();
        softAssert.assertEquals(commonActions.getText_CalendarFromMonth_Btn(), Utility.getNextMonth(currentFromMonth), "Validate the value of From Month");
        softAssert.assertEquals(commonActions.getText_CalendarToMonth_Btn(), Utility.getNextMonth(currentToMonth), "Validate the value of To Month");

        currentFromMonth = commonActions.getText_CalendarFromMonth_Btn();
        currentToMonth = commonActions.getText_CalendarToMonth_Btn();
        commonActions.click_CalendarPreviousMonth_Btn();
        softAssert.assertEquals(commonActions.getText_CalendarFromMonth_Btn(), Utility.getPreviousMonth(currentFromMonth), "Validate the value of From Month");
        softAssert.assertEquals(commonActions.getText_CalendarToMonth_Btn(), Utility.getPreviousMonth(currentToMonth), "Validate the value of To Month");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_019, Verify Start Date Is Not Greater Than End Date")
    public void TC_ViewOrder_019_Verify_Start_Date_Is_Not_Greater_Than_End_Date() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        softAssert.assertEquals(viewOrderPage.getValue_FromDateField_Txt(), ActionHelper.getCustomPreviousDateFormatter("yyyy-MM-dd", 1), "Validate from date value");
        softAssert.assertEquals(viewOrderPage.getValue_ToDateField_Txt(), Utility.getCustomCurrentDateFormatter("yyyy-MM-dd"), "Validate to date value");
        viewOrderPage.click_FromDateField_Txt();
        softAssert.assertEquals(commonActions.getText_CalendarFromMonth_Btn(), ActionHelper.getCurrentMonthName().substring(0, 3), "Validate current month being displayed in from month");
        softAssert.assertEquals(commonActions.getText_CalendarFromYear_Btn(), String.valueOf(ActionHelper.getCurrentYear()), "Validate current year being displayed in from year");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_020, Verify Order Table Record With Created Date")
    public void TC_ViewOrder_020_Verify_Order_Table_Record_With_Created_Date() {
        String fromDate = "2022-09-20";
        String toDate = "2022-10-20";
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.click_FromDateField_Txt();
        commonActions.fillDatesInCalendar(fromDate, toDate);
        softAssert.assertEquals(viewOrderPage.getValue_FromDateField_Txt(), fromDate, "Validate from date");
        softAssert.assertEquals(viewOrderPage.getValue_ToDateField_Txt(), toDate, "Validate to date");
        if (viewOrderPage.getList_TabHeaderOrderId_ListLink().size() > 0) {
            String orderId = viewOrderPage.getText_TabHeaderOrderId_ListLink(0);
            viewOrderPage.click_TabHeaderOrderId_ListLink(0);
            softAssert.assertTrue(orderDetailPage.isPresent_Header_Lbl(), "Validate presence of header");
            softAssert.assertTrue(orderDetailPage.getText_Header_Lbl().contains(orderId), "Validate order id in header");
            String[] actualCreatedOnDate = orderDetailPage.getText_CreatedOn_Lbl().split(" ")[2].split("-");
            String[] expectedDate = fromDate.split("-");
            softAssert.assertEquals(actualCreatedOnDate[2], expectedDate[0], "Validate year");
            softAssert.assertEquals(actualCreatedOnDate[1], expectedDate[1], "Validate month");
            softAssert.assertTrue(Integer.parseInt(actualCreatedOnDate[0]) >= Integer.parseInt(expectedDate[2]), "Validate day");
        }
        softAssert.assertAll();
    }


    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_021, Verify Order Table Record With Closure Date")
    public void TC_ViewOrder_021_Verify_Order_Table_Record_With_Closure_Date() {
        String fromDate = Utility.getPreviousYear(String.valueOf(ActionHelper.getCurrentYear())) + "-" + ActionHelper.getCurrentMonth() + "-" + ActionHelper.getCurrentDay();
        String toDate = ActionHelper.getCurrentYear() + "-" + ActionHelper.getCurrentMonth() + "-" + ActionHelper.getCurrentDay();
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        commonActions.fillDatesInCalendar(fromDate, toDate);
        softAssert.assertEquals(viewOrderPage.getValue_FromDateField_Txt(), fromDate, "Validate from date");
        softAssert.assertEquals(viewOrderPage.getValue_ToDateField_Txt(), toDate, "Validate to date");
        int size = viewOrderPage.getList_TabHeaderOrderId_ListLink().size();
        if (size > 0) {
            String orderId = viewOrderPage.getText_TabHeaderOrderId_ListLink(size - 1);
            viewOrderPage.click_TabHeaderOrderId_ListLink(size - 1);
            softAssert.assertTrue(orderDetailPage.isPresent_Header_Lbl(), "Validate presence of header");
            softAssert.assertTrue(orderDetailPage.getText_Header_Lbl().contains(orderId), "Validate order id in header");
            String[] actualCreatedOnDate = orderDetailPage.getText_CreatedOn_Lbl().split(" ")[2].split("-");
            String[] expectedDate = toDate.split("-");
            softAssert.assertEquals(actualCreatedOnDate[2], expectedDate[0], "Validate year");
            softAssert.assertEquals(actualCreatedOnDate[1], expectedDate[1], "Validate month");
            softAssert.assertTrue(Integer.parseInt(actualCreatedOnDate[0]) <= Integer.parseInt(expectedDate[2]), "Validate day");
        }
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_022, Verify Functionality Of Next Page Pagination Button")
    public void TC_ViewOrder_022_Verify_Functionality_Of_Next_Page_Pagination_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        JarvisAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-10");
        commonActions.click_PaginationNext_Btn();
        JarvisAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "11-20");
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_023, Verify Functionality Of Previous Page Pagination Button")
    public void TC_ViewOrder_023_Verify_Functionality_Of_Previous_Page_Pagination_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-10", "Pagination is matched as expected");
        commonActions.click_PaginationNext_Btn();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "11-20", "Pagination is matched as expected");
        commonActions.click_PaginationPrevious_Btn();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-10", "Pagination is matched as expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_024, Verify Displaying Of Facilities Table Records As Per Pagination Value")
    public void TC_ViewOrder_024_Verify_Displaying_Of_Facilities_Table_Records_As_Per_Pagination_Value() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.clickAndChoose_PaginationDropDownOptions_Btn(10);
        softAssert.assertTrue(viewOrderPage.getList_TabHeaderOrderId_ListLink().size() <= 10, "Validate records present are not more than 10");
        viewOrderPage.clickAndChoose_PaginationDropDownOptions_Btn(20);
        softAssert.assertTrue(viewOrderPage.getList_TabHeaderOrderId_ListLink().size() <= 20, "Validate records present are not more than 20");
        viewOrderPage.clickAndChoose_PaginationDropDownOptions_Btn(50);
        softAssert.assertTrue(viewOrderPage.getList_TabHeaderOrderId_ListLink().size() <= 50, "Validate records present are not more than 50");
        viewOrderPage.clickAndChoose_PaginationDropDownOptions_Btn(100);
        softAssert.assertTrue(viewOrderPage.getList_TabHeaderOrderId_ListLink().size() <= 100, "Validate records present are not more than 100");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_025, Verify Functionality Of Pagination Paging Block")
    public void TC_ViewOrder_025_Verify_Functionality_Of_Pagination_Paging_Block() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        commonActions.selectPaginationBlock("2");
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(2), "Validate correct pagination block is selected");
        commonActions.selectPaginationBlock("3");
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(3), "Validate correct pagination block is selected");
        commonActions.selectPaginationBlock("1");
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(1), "Validate correct pagination block is selected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_026, Verify Functionality Of Pagination Paging Block With Next And Previous Button")
    public void TC_ViewOrder_026_Verify_Functionality_Of_Pagination_Paging_Block_With_Next_And_Previous_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-10", "Validate no of records displayed");
        String firstRecord = viewOrderPage.getText_TabHeaderOrderId_ListLink().get(0);

        commonActions.click_PaginationNext_Btn();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "11-20", "Validate no of records displayed");
        String eleventhRecord = viewOrderPage.getText_TabHeaderOrderId_ListLink().get(0);
        softAssert.assertTrue(!firstRecord.equals(eleventhRecord), "Validate the records are different");

        commonActions.click_PaginationPrevious_Btn();
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-10", "Validate no of records displayed");
        softAssert.assertTrue(firstRecord.equals(viewOrderPage.getText_TabHeaderOrderId_ListLink().get(0)), "Validate the records are same");

        commonActions.selectPaginationBlock("2");
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(2), "Validate correct pagination block is selected");
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "11-20", "Validate no of records displayed");
        softAssert.assertTrue(eleventhRecord.equals(viewOrderPage.getText_TabHeaderOrderId_ListLink().get(0)), "Validate the records are same");

        commonActions.selectPaginationBlock("1");
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(1), "Validate correct pagination block is selected");
        softAssert.assertEquals(commonActions.getText_PaginationCurrentlyShowingCount_Lbl(), "1-10", "Validate no of records displayed");
        softAssert.assertTrue(firstRecord.equals(viewOrderPage.getText_TabHeaderOrderId_ListLink().get(0)), "Validate the records are same");
        softAssert.assertAll();

    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_027, Verify Functionality Of Pagination Paging Block With Next 5 pages And Previous 5 pages Button")
    public void TC_ViewOrder_027_Verify_Functionality_Of_Pagination_Paging_Block_With_Next_5_pages_And_Previous_5_pages_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        int i;
        for (i = 1; i < 6; i++) {
            softAssert.assertTrue(commonActions.isPaginationBlockSelected(i), "Page Is Selected As Expected");
            commonActions.click_PaginationNext_Btn();
        }
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(i + 1), "Page Is Selected As Expected");

        for (i = 6; i > 1; i--) {
            softAssert.assertTrue(commonActions.isPaginationBlockSelected(i), "Page Is Selected As Expected");
            commonActions.click_PaginationPrevious_Btn();
        }
        softAssert.assertTrue(commonActions.isPaginationBlockSelected(i), "Page Is Selected As Expected");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_028, Verify Functionality Of Pagination Per Page With Paging Block And Next Button")
    public void TC_ViewOrder_028_Verify_Functionality_Of_Pagination_Per_Page_With_Paging_Block_And_Next_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.clickAndChoose_PaginationDropDownOptions_Btn(20);
        softAssert.assertTrue(viewOrderPage.getList_TabHeaderOrderId_ListLink().size() <= 20, "Validate records present are not more than 20");
        String eleventhRecord = viewOrderPage.getText_TabHeaderOrderId_ListLink().get(10);

        viewOrderPage.clickAndChoose_PaginationDropDownOptions_Btn(10);
        softAssert.assertTrue(viewOrderPage.getList_TabHeaderOrderId_ListLink().size() <= 10, "Validate records present are not more than 10");
        String firstRecord = viewOrderPage.getText_TabHeaderOrderId_ListLink().get(0);

        commonActions.click_PaginationNext_Btn();
        softAssert.assertTrue(eleventhRecord.equals(viewOrderPage.getText_TabHeaderOrderId_ListLink().get(0)), "Validate the records are same");

        commonActions.click_PaginationPrevious_Btn();
        softAssert.assertTrue(firstRecord.equals(viewOrderPage.getText_TabHeaderOrderId_ListLink().get(0)), "Validate the records are same");

        commonActions.selectPaginationBlock("2");
        softAssert.assertTrue(eleventhRecord.equals(viewOrderPage.getText_TabHeaderOrderId_ListLink().get(0)), "Validate the records are same");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_029, Verify Functionality Of Vertically Scroll Of Facilities Table Using Mouse Scroll Wheel")
    public void TC_ViewOrder_029_Verify_Functionality_Of_Vertically_Scroll_Of_Facilities_Table_Using_Mouse_Scroll_Wheel() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        commonActions.chooseNoOfRecordsToBeDisplayedPerPage(20);
        List<WebElement> elements = viewOrderPage.getList_TabHeaderOrderId_ListLink();
        Utility.validatePageScrollDown(elements.get(elements.size() - 1));
        softAssert.assertTrue(ActionHelper.isPresent(elements.get(elements.size() - 1), 5000), "Validate last element is present");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_030, Verify Vertically Scroll In Facilities Table Using KeyBoard")
    public void TC_ViewOrder_030_Verify_Vertically_Scroll_In_Facilities_Table_Using_KeyBoard() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        commonActions.chooseNoOfRecordsToBeDisplayedPerPage(20);
        List<WebElement> elements = viewOrderPage.getList_TabHeaderOrderId_ListLink();
        Utility.scrollDownUsingKeyboardKey(10);
        softAssert.assertTrue(ActionHelper.isPresent(elements.get(elements.size() - 1), 5000), "Validate last element is present");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_031, Verify The Functionality Of CheckBox Present In Orders Table Heading")
    public void TC_ViewOrder_031_Verify_The_Functionality_Of_CheckBox_Present_In_Orders_Table_Heading() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        softAssert.assertTrue(!viewOrderPage.isEnabled_AssignRider_Btn(), "Validate Assigned Rider button is disabled");
        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        softAssert.assertTrue(viewOrderPage.isCheckboxChecked_TabHeaderCheckbox_ListCheckbox(0), "Validate that the checkbox is checked");
        softAssert.assertTrue(viewOrderPage.isEnabled_AssignRider_Btn(), "Validate Assigned Rider button is enabled");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_032, Verify The Functionality Of CheckBox Present In Orders Table for any record")
    public void TC_ViewOrder_032_Verify_The_Functionality_Of_CheckBox_Present_In_Orders_Table_for_any_record() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        softAssert.assertTrue(!viewOrderPage.isEnabled_AssignRider_Btn(), "Validate Assigned Rider button is disabled");
        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(1);
        softAssert.assertTrue(viewOrderPage.isCheckboxChecked_TabHeaderCheckbox_ListCheckbox(1), "Validate that the checkbox is checked");
        softAssert.assertTrue(viewOrderPage.isEnabled_AssignRider_Btn(), "Validate Assigned Rider button is enabled");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_033, Verify The Functionality Of Unchecking the CheckBox ")
    public void TC_ViewOrder_033_Verify_The_Functionality_Of_Unchecking_the_CheckBox() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        softAssert.assertTrue(!viewOrderPage.isEnabled_AssignRider_Btn(), "Validate Assigned Rider button is disabled");
        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        softAssert.assertTrue(viewOrderPage.isCheckboxChecked_TabHeaderCheckbox_ListCheckbox(0), "Validate that the checkbox is checked");
        softAssert.assertTrue(viewOrderPage.isEnabled_AssignRider_Btn(), "Validate Assigned Rider button is enabled");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        softAssert.assertTrue(!viewOrderPage.isCheckboxChecked_TabHeaderCheckbox_ListCheckbox(0), "Validate that the checkbox is unchecked");
        softAssert.assertTrue(!viewOrderPage.isEnabled_AssignRider_Btn(), "Validate Assigned Rider button is disabled");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_034, Verify UI Of Assign Rider Button")
    public void TC_ViewOrder_034_Verify_UI_Of_Assign_Rider_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownManual_Opt(), "Validate presence of Manual option");
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomatic_Opt(), "Validate presence of Automatic option");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_035, Verify The Functionality Of Manual button in Assign Rider Button ")
    public void TC_ViewOrder_035_Verify_The_Functionality_Of_Manual_button_in_Assign_Rider_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownManual_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownManualHeader_Lbl(), "Validate presence of Manual Assignment header");
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownManualRider_DropDown(), "Validate presence of Rider drop down");
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownManualAssign_Btn(), "Validate presence of Assign button");
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownManualAssignAndStart_Btn(), "Validate presence of Assign And Start button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_036, Verify The Functionality Of Assign button in manual Assign")
    public void TC_ViewOrder_036_Verify_The_Functionality_Of_Assign_button_in_manual_Assign() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownManual_Opt();
        viewOrderPage.set_AssignRiderDropDownManualRider_DropDown("Rider");
        viewOrderPage.click_AssignRiderDropDownManualAssign_Btn();
        softAssert.assertTrue(viewOrderPage.isPresent_DispatchCreationInProgressPopUpMsg_Lbl(), "Validate presence of Dispatch Creation In Progress popup");
        softAssert.assertTrue(viewOrderPage.isPresent_DispatchCreatedPopUpMsg_Lbl(), "Validate presence of Dispatch Created popup");
        softAssert.assertTrue(DispatchPage.getInstance().isPresent_Header_Lbl(), "Validate presence of Dispatch header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_037, Verify The Functionality Of Assign And Start button in manual Assign ")
    public void TC_ViewOrder_037_Verify_The_Functionality_Of_Assign_And_Start_button_in_manual_Assign() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownManual_Opt();
        viewOrderPage.set_AssignRiderDropDownManualRider_DropDown("Rider");
        viewOrderPage.click_AssignRiderDropDownManualAssignAndStart_Btn();
        softAssert.assertTrue(viewOrderPage.isPresent_DispatchCreationInProgressPopUpMsg_Lbl(), "Validate presence of Dispatch Creation In Progress popup");
        softAssert.assertTrue(viewOrderPage.isPresent_DispatchPublishedPopUpMsg_Lbl(), "Validate presence of Dispatch Published popup");
        softAssert.assertTrue(DispatchPage.getInstance().isPresent_Header_Lbl(), "Validate presence of Dispatch header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_038, Verify The Functionality Of Automatic button in Assign Rider Button ")
    public void TC_ViewOrder_038_Verify_The_Functionality_Of_Automatic_button_in_Assign_Rider_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentSearchBar_Txt(), "Validate presence of Search Bar");
        softAssert.assertTrue(viewOrderPage.getList_AssignRiderDropDownAutomaticAssignmentCheckbox_ListCheckbox().size() > 0, "Validate minimum 1 rider is present");
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentCancel_Btn(), "Validate presence of Cancel button");
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentAssignRiders_Btn(), "Validate presence of Assign Riders button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_039, Verify The Functionality Of Search Bar of Automatic in Assign Rider Button ")
    public void TC_ViewOrder_039_Verify_The_Functionality_Of_Search_Bar_of_Automatic_in_Assign_Rider_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        String riderName = viewOrderPage.getText_AssignRiderDropDownAutomaticAssignmentRiderName_ListLink(0);
        viewOrderPage.fillWithClear_AssignRiderDropDownAutomaticAssignmentSearchBar_Txt(riderName);
        List<String> riderList = viewOrderPage.getText_AssignRiderDropDownAutomaticAssignmentRiderName_ListLink();
        softAssert.assertEquals(riderList.size(), 1, "Validate no of riders");
        softAssert.assertEquals(riderList.get(0), riderName, "Validate Rider Name");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_040, Verify The Functionality Of Search Bar in Automatic Assign")
    public void TC_ViewOrder_040_Verify_The_Functionality_Of_Search_Bar_in_Automatic_Assign() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        viewOrderPage.fillWithClear_AssignRiderDropDownAutomaticAssignmentSearchBar_Txt("zzzz");
        softAssert.assertTrue(viewOrderPage.isPresent_ItsEmptyHereMsg_Lbl(), "Validate presence of It's Empty Here msg");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_041, Verify The Functionality Of Cancel button in Automatic Assign")
    public void TC_ViewOrder_041_Verify_The_Functionality_Of_Cancel_button_in_Automatic_Assign() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentCancel_Btn();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_042, Verify The UI Of Table Present in Automatic Assign ")
    public void TC_ViewOrder_042_Verify_The_UI_Of_Table_Present_in_Automatic_Assign() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");

        List<String> actualTabHeadersLabels = viewOrderPage.getText_AssignRiderDropDownAutomaticAssignmentTabHeader_ListLbl();
        List<String> expectedTabHeaders = new ArrayList<>(List.of("RIDER NAME", "START TIME", "END TIME", "MAXIMUM SHIPMENTS"));
        Collections.sort(expectedTabHeaders);
        for (int size = 0; size < actualTabHeadersLabels.size(); size++) {
            softAssert.assertEquals(actualTabHeadersLabels.get(size), expectedTabHeaders.get(size), "Table Header label is matched as expected.");
        }
        softAssert.assertTrue(viewOrderPage.getList_AssignRiderDropDownAutomaticAssignmentCheckbox_ListCheckbox().size() > 0, "Validate presence of checkboxes");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_043, Verify The Functional Of Checkbox Present in Automatic Assign")
    public void TC_ViewOrder_043_Verify_The_Functional_Of_Checkbox_Present_in_Automatic_Assign() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        viewOrderPage.checkCheckbox_AssignRiderDropDownAutomaticAssignmentCheckbox_ListCheckbox(0);
        softAssert.assertTrue(viewOrderPage.isCheckboxChecked_AssignRiderDropDownAutomaticAssignmentCheckbox_ListCheckbox(0), "Validate checkbox is checked");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_044, Verify The Functionality Of Start Time in Automatic Assign")
    public void TC_ViewOrder_044_Verify_The_Functionality_Of_Start_Time_in_Automatic_Assign() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentStartTime_ListTxt(0);
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentHour_ListBtn("10");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentMinute_ListBtn("05");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentOK_Btn();
        softAssert.assertEquals(viewOrderPage.getValue_AssignRiderDropDownAutomaticAssignmentStartTime_ListTxt(0), "10:05", "Validate checkbox is checked");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_045, Verify The Functionality Of Ok button of Start time in Automatic Assign")
    public void TC_ViewOrder_045_Verify_The_Functionality_Of_Ok_button_of_Start_time_in_Automatic_Assign() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentStartTime_ListTxt(0);
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentHour_ListBtn("10");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentMinute_ListBtn("05");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentOK_Btn();
        softAssert.assertEquals(viewOrderPage.getValue_AssignRiderDropDownAutomaticAssignmentStartTime_ListTxt(0), "10:05", "Validate checkbox is checked");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_046, Verify The Functionality Of Now button of Start time in Automatic Assign")
    public void TC_ViewOrder_046_Verify_The_Functionality_Of_Now_button_of_Start_time_in_Automatic_Assign() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentStartTime_ListTxt(0);
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentNow_Btn();
        softAssert.assertEquals(viewOrderPage.getValue_AssignRiderDropDownAutomaticAssignmentStartTime_ListTxt(0), Utility.getCurrentHourOfDay() + ":" + Utility.getCurrentMinuteOfHour(), "Validate checkbox is checked");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_047, Verify The Functionality Of Vertically Scroll Of Start TimeTable Using Mouse Scroll Wheel")
    public void TC_ViewOrder_047_Verify_The_Functionality_Of_Vertically_Scroll_Of_Start_TimeTable_Using_Mouse_Scroll_Wheel() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentStartTime_ListTxt(0);
        List<WebElement> elements = viewOrderPage.getList_AssignRiderDropDownAutomaticAssignmentHour_ListBtn();
        Utility.validatePageScrollDown(elements.get(elements.size() - 1));
        softAssert.assertTrue(ActionHelper.isPresent(elements.get(elements.size() - 1), 5000), "Validate last element is present");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_048, Verify The Functionality Of Vertically Scroll Of Start TimeTable Using Mouse Scroll Wheel")
    public void TC_ViewOrder_048_Verify_The_Functionality_Of_Vertically_Scroll_Of_Start_TimeTable_Using_Mouse_Scroll_Wheel() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentStartTime_ListTxt(0);
        List<WebElement> elements = viewOrderPage.getList_AssignRiderDropDownAutomaticAssignmentMinute_ListBtn();
        Utility.validatePageScrollDown(elements.get(elements.size() - 1));
        softAssert.assertTrue(ActionHelper.isPresent(elements.get(elements.size() - 1), 5000), "Validate last element is present");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_049, Verify The Functionality Of Drop Time in Automatic Assign")
    public void TC_ViewOrder_049_Verify_The_Functionality_Of_Drop_Time_in_Automatic_Assign() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentEndTime_ListTxt(0);
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentHour_ListBtn("10");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentMinute_ListBtn("05");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentOK_Btn();
        softAssert.assertEquals(viewOrderPage.getValue_AssignRiderDropDownAutomaticAssignmentStartTime_ListTxt(0), "10:05", "Validate checkbox is checked");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_050, Verify The Functionality Of Ok button of Drop time in Automatic Assign")
    public void TC_ViewOrder_050_Verify_The_Functionality_Of_Ok_button_of_Drop_time_in_Automatic_Assign() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentEndTime_ListTxt(0);
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentHour_ListBtn("10");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentMinute_ListBtn("05");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentOK_Btn();
        softAssert.assertEquals(viewOrderPage.getValue_AssignRiderDropDownAutomaticAssignmentStartTime_ListTxt(0), "10:05", "Validate checkbox is checked");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_051, Verify The Functionality Of Now button of Drop time in Automatic Assign")
    public void TC_ViewOrder_051_Verify_The_Functionality_Of_Now_button_of_Drop_time_in_Automatic_Assign() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentEndTime_ListTxt(0);
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentNow_Btn();
        softAssert.assertEquals(viewOrderPage.getValue_AssignRiderDropDownAutomaticAssignmentStartTime_ListTxt(0), Utility.getCurrentHourOfDay() + ":" + Utility.getCurrentMinuteOfHour(), "Validate checkbox is checked");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_052, Verify The Functionality Of Vertically Scroll Of Drop Time Table Using Mouse Scroll Wheel")
    public void TC_ViewOrder_052_Verify_The_Functionality_Of_Vertically_Scroll_Of_Drop_Time_Table_Using_Mouse_Scroll_Wheel() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentEndTime_ListTxt(0);
        List<WebElement> elements = viewOrderPage.getList_AssignRiderDropDownAutomaticAssignmentHour_ListBtn();
        Utility.validatePageScrollDown(elements.get(elements.size() - 1));
        softAssert.assertTrue(ActionHelper.isPresent(elements.get(elements.size() - 1), 5000), "Validate last element is present");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_053, Verify The Functionality Of Vertically Scroll Of Drop Time Table Using Mouse Scroll Wheel")
    public void TC_ViewOrder_053_Verify_The_Functionality_Of_Vertically_Scroll_Of_Drop_Time_Table_Using_Mouse_Scroll_Wheel() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        viewOrderPage.click_AssignRiderDropDownAutomaticAssignmentEndTime_ListTxt(0);
        List<WebElement> elements = viewOrderPage.getList_AssignRiderDropDownAutomaticAssignmentMinute_ListBtn();
        Utility.validatePageScrollDown(elements.get(elements.size() - 1));
        softAssert.assertTrue(ActionHelper.isPresent(elements.get(elements.size() - 1), 5000), "Validate last element is present");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_054, Verify The Functionality of Maximum Shipments in Automatic Assign")
    public void TC_ViewOrder_054_Verify_The_Functionality_of_Maximum_Shipments_in_Automatic_Assign() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        viewOrderPage.checkCheckbox_TabHeaderCheckbox_ListCheckbox(0);
        viewOrderPage.click_AssignRider_DropDown();
        viewOrderPage.click_AssignRiderDropDownAutomatic_Opt();
        softAssert.assertTrue(viewOrderPage.isPresent_AssignRiderDropDownAutomaticAssignmentHeader_Lbl(), "Validate presence of Automatic Assignment header");
        viewOrderPage.fillWithClear_AssignRiderDropDownAutomaticAssignmentMaximumShipments_Txt("111");
        softAssert.assertEquals(viewOrderPage.getValue_AssignRiderDropDownAutomaticAssignmentMaximumShipments_Txt(), "111", "Validate value in Maximum Shipments field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_055, Verify The Functionality of Order Details page")
    public void TC_ViewOrder_055_Verify_The_Functionality_of_Order_Details_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        String orderId = viewOrderPage.getText_TabHeaderOrderId_ListLink(0);
        viewOrderPage.click_TabHeaderOrderId_ListLink(0);
        softAssert.assertTrue(orderDetailPage.isPresent_Header_Lbl(), "Validate presence of header");
        softAssert.assertTrue(orderDetailPage.getText_Header_Lbl().contains(orderId), "Validate order id in header");

        softAssert.assertTrue(orderDetailPage.isPresent_OrderDetailsHeader_Lbl(), "Validate presence of Order Details header");
        softAssert.assertTrue(orderDetailPage.isPresent_OrderDetailsDescription_Lbl(), "Validate presence of Description field");
        softAssert.assertTrue(orderDetailPage.isPresent_OrderDetailsTeam_Lbl(), "Validate presence of Team field");

        softAssert.assertTrue(orderDetailPage.isPresent_PaymentDetailsHeader_Lbl(), "Validate presence of Payment Details header");
        softAssert.assertTrue(orderDetailPage.isPresent_PaymentDetailsPaymentType_Lbl(), "Validate presence of Payment Type field");
        softAssert.assertTrue(orderDetailPage.isPresent_PaymentDetailsAmount_Lbl(), "Validate presence of Amount field");

        softAssert.assertTrue(orderDetailPage.isPresent_PickupAndDropDetailsHeader_Lbl(), "Validate presence of Pickup & drop Details header");
        softAssert.assertTrue(orderDetailPage.isPresent_PickupAndDropDetailsPickupAddressLine1_Lbl(), "Validate presence of Pickup Address Line 1 field");
        softAssert.assertTrue(orderDetailPage.isPresent_PickupAndDropDetailsPickupAddressLine2_Lbl(), "Validate presence of Pickup Address Line 2 field");
        softAssert.assertTrue(orderDetailPage.isPresent_PickupAndDropDetailsPickupDateTime_Lbl(), "Validate presence of Pickup Date Time field");
        softAssert.assertTrue(orderDetailPage.isPresent_PickupAndDropDetailsPickupPOCName_Lbl(), "Validate presence of Pickup POC Name field");
        softAssert.assertTrue(orderDetailPage.isPresent_PickupAndDropDetailsPickupTimeSlot_Lbl(), "Validate presence of Pickup Time Slot field");
        softAssert.assertTrue(orderDetailPage.isPresent_PickupAndDropDetailsPickupPOCNumber_Lbl(), "Validate presence of Pickup POC Number field");

        softAssert.assertTrue(orderDetailPage.isPresent_PickupAndDropDetailsDropAddressLine1_Lbl(), "Validate presence of Drop Address Line 1 field");
        softAssert.assertTrue(orderDetailPage.isPresent_PickupAndDropDetailsDropAddressLine2_Lbl(), "Validate presence of Drop Address Line 2 field");
        softAssert.assertTrue(orderDetailPage.isPresent_PickupAndDropDetailsDropDateTime_Lbl(), "Validate presence of Drop Date Time field");
        softAssert.assertTrue(orderDetailPage.isPresent_PickupAndDropDetailsDropPOCName_Lbl(), "Validate presence of Drop POC Name field");
        softAssert.assertTrue(orderDetailPage.isPresent_PickupAndDropDetailsDropTimeSlot_Lbl(), "Validate presence of Drop Time Slot field");
        softAssert.assertTrue(orderDetailPage.isPresent_PickupAndDropDetailsDropPOCNumber_Lbl(), "Validate presence of Drop POC Number field");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_056, Verify The Functionality Of Cancel Button In Orders Details page  ")
    public void TC_ViewOrder_056_Verify_The_Functionality_Of_Cancel_Button_In_Orders_Details_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        String orderId = viewOrderPage.getText_TabHeaderOrderId_ListLink(0);
        viewOrderPage.click_TabHeaderOrderId_ListLink(0);
        softAssert.assertTrue(orderDetailPage.isPresent_Header_Lbl(), "Validate presence of header");
        softAssert.assertTrue(orderDetailPage.getText_Header_Lbl().contains(orderId), "Validate order id in header");

        orderDetailPage.click_CancelOrder_Btn();
        softAssert.assertTrue(orderDetailPage.isPresent_CancelOrderBtnHeader_Lbl(), "Check Visibility of Header for Cancel Order pop up");
        softAssert.assertEquals(orderDetailPage.getText_CancelOrderBtnSubHeader_Lbl(), "Are you sure you want to cancel this order? This action cannot be undone.", "Validate sub header");
        softAssert.assertTrue(orderDetailPage.isPresent_CancelOrderBtnBack_Btn(), "Check Visibility of Back button");
        softAssert.assertTrue(orderDetailPage.isPresent_CancelOrderBtnCancelOrder_Btn(), "Check Visibility of Cancel Order button");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_057, Verify The Functionality Of Back Button In Cancel Order page  ")
    public void TC_ViewOrder_057_Verify_The_Functionality_Of_Back_Button_In_Cancel_Order_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        String orderId = viewOrderPage.getText_TabHeaderOrderId_ListLink(0);
        viewOrderPage.click_TabHeaderOrderId_ListLink(0);
        softAssert.assertTrue(orderDetailPage.isPresent_Header_Lbl(), "Validate presence of header");
        softAssert.assertTrue(orderDetailPage.getText_Header_Lbl().contains(orderId), "Validate order id in header");

        orderDetailPage.click_CancelOrder_Btn();
        softAssert.assertTrue(orderDetailPage.isPresent_CancelOrderBtnHeader_Lbl(), "Check Visibility of Header for Cancel Order pop up");
        orderDetailPage.click_CancelOrderBtnBack_Btn();
        softAssert.assertTrue(orderDetailPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_058, Verify The Functionality Of Cancel Button In Cancel Order page  ")
    public void TC_ViewOrder_058_Verify_The_Functionality_Of_Cancel_Button_In_Cancel_Order_page() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        String orderId = viewOrderPage.getText_TabHeaderOrderId_ListLink(0);
        viewOrderPage.click_TabHeaderOrderId_ListLink(0);
        softAssert.assertTrue(orderDetailPage.isPresent_Header_Lbl(), "Validate presence of header");
        softAssert.assertTrue(orderDetailPage.getText_Header_Lbl().contains(orderId), "Validate order id in header");

        orderDetailPage.click_CancelOrder_Btn();
        softAssert.assertTrue(orderDetailPage.isPresent_CancelOrderBtnHeader_Lbl(), "Check Visibility of Header for Cancel Order pop up");
        softAssert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains(Constants.Urls.BASE_URL + "orders/detail/?id=orders:"), "Validate current url");
        orderDetailPage.click_CancelOrderBtnCancelOrder_Btn();
        softAssert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains(Constants.Urls.BASE_URL + "orders/detail/?id=orders:"), "Validate current url");
        softAssert.assertTrue(orderDetailPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(orderDetailPage.getText_Status_Lbl(), "Cancelled", "Validate order status");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_059, Verify The Functionality of New Order Button")
    public void TC_ViewOrder_059_Verify_The_Functionality_of_New_Order_Button() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        viewOrderPage.click_NewOrder_Btn();
        softAssert.assertTrue(createNewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");
        softAssert.assertEquals(createNewOrderPage.getText_Header_Lbl(), "Create New Order", "Validate Header");
        softAssert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains(Constants.Urls.BASE_URL + "orders/add/"), "Validate current url");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT},
            description = "TC_060, Verify The Functionality Of masking of Pickup address")
    public void TC_ViewOrder_060_Verify_The_Functionality_Of_masking_of_Pickup_address() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        String orderId = viewOrderPage.getText_TabHeaderOrderId_ListLink(0);
        viewOrderPage.click_TabHeaderOrderId_ListLink(0);
        softAssert.assertTrue(orderDetailPage.isPresent_Header_Lbl(), "Validate presence of header");
        softAssert.assertTrue(orderDetailPage.getText_Header_Lbl().contains(orderId), "Validate order id in header");

        softAssert.assertTrue(orderDetailPage.getText_PickupAndDropDetailsPickupAddressLine1_Lbl().equals("xxxxxxxxxxx") == true, "Validate Address Line 1 data is masked");
        orderDetailPage.click_PickupAndDropDetailsPickupAddressLine1ShowHide_Btn();
        softAssert.assertTrue(orderDetailPage.getText_PickupAndDropDetailsPickupAddressLine1_Lbl().equals("xxxxxxxxxxx") == false, "Validate Address Line 1 data is unmasked");

        softAssert.assertTrue(orderDetailPage.getText_PickupAndDropDetailsPickupPOCNumber_Lbl().equals("xxxxxxxxxxx") == true, "Validate POC Number data is masked");
        orderDetailPage.click_PickupAndDropDetailsPickupPOCNumberShowHide_Btn();
        softAssert.assertTrue(orderDetailPage.getText_PickupAndDropDetailsPickupPOCNumber_Lbl().equals("xxxxxxxxxxx") == false, "Validate POC Number data is unmasked");
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.SMOKE, TestGroup.SANITY, TestGroup.VIEW_ORDERS, TestGroup.BVT, TestGroup.FLAKY_TESTS},
            description = "TC_061, Verify The Functionality Of masking of Drop address")
    public void TC_ViewOrder_061_Verify_The_Functionality_Of_masking_of_Drop_address() {
        JarvisSoftAssert softAssert = new JarvisSoftAssert();
        commonActions.coverJourneyTillViewOrder();
        softAssert.assertTrue(viewOrderPage.isPresent_Header_Lbl(), "Check Visibility of Header");

        String orderId = viewOrderPage.getText_TabHeaderOrderId_ListLink(0);
        viewOrderPage.click_TabHeaderOrderId_ListLink(0);
        softAssert.assertTrue(orderDetailPage.isPresent_Header_Lbl(), "Validate presence of header");
        softAssert.assertTrue(orderDetailPage.getText_Header_Lbl().contains(orderId), "Validate order id in header");

        softAssert.assertTrue(orderDetailPage.getText_PickupAndDropDetailsDropAddressLine1_Lbl().equals("xxxxxxxxxxx") == true, "Validate Address Line 1 data is masked");
        orderDetailPage.click_PickupAndDropDetailsDropAddressLine1ShowHide_Btn();
        softAssert.assertTrue(orderDetailPage.getText_PickupAndDropDetailsDropAddressLine1_Lbl().equals("xxxxxxxxxxx") == false, "Validate Address Line 1 data is unmasked");

        softAssert.assertTrue(orderDetailPage.getText_PickupAndDropDetailsDropPOCNumber_Lbl().equals("xxxxxxxxxxx") == true, "Validate POC Number data is masked");
        orderDetailPage.click_PickupAndDropDetailsDropPOCNumberShowHide_Btn();
        softAssert.assertTrue(orderDetailPage.getText_PickupAndDropDetailsDropPOCNumber_Lbl().equals("xxxxxxxxxxx") == false, "Validate POC Number data is unmasked");
        softAssert.assertAll();
    }


}
