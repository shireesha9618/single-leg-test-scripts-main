package pageobjects;

import constants.Constants;
import constants.Enums;
import framework.backend.APIResponseException;
import framework.backend.ApiFunctions;
import framework.backend.GraphQLHelper;
import framework.backend.http.HTTPMethodType;
import framework.backend.http.Request;
import framework.backend.http.Response;
import framework.common.logger.ExtentLogger;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import io.github.sukgu.Shadow;
import org.openqa.selenium.*;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import static constants.Constants.headers;
import static utility.Utility.acceptAlertIfPresent;

public class CommonActions {
    private static CommonActions _instance;
    private final Locator skip_Btn = Locator.builder().withWeb(By.cssSelector(".productfruits--btn.productfruits--card-footer-skip-button"));
    private final Locator loader_Img = Locator.builder().withWeb(By.cssSelector("*[class*='animate-spin']"));
    //p[text()='Dispatch']
    String cssSelectorForHost1 = ".productfruits--container";
    private final Locator sadas = Locator.builder().withWeb(By.xpath("//div[@id='selectTeam_list']/following-sibling::div//div[@class='ant-select-item ant-select-item-option']"));
    private final Locator sadasdsfd = Locator.builder().withWeb(By.xpath("//label[text()='Team*']/../div/div"));

    public static CommonActions getInstance() {
        if (_instance == null)
            _instance = new CommonActions();
        return _instance;
    }

    public void coverJourneyTillDispatches() {
        performCommonAction();
//        JarvisAssert.assertTrue(HomePage.getInstance().isPresent_DelhiveryLogo_Img(), "Validate Delhivery Logo is present");
//        HomePage.getInstance().selectFacility(Constants.FACILITY_NAME);
//        HomePage.getInstance().openJobList();
        click_Skip_Btn();
        HomePage.getInstance().openDispatchListPage();

    }
    public void coverJourneyTillCreateOrder() {
        performCommonAction();
        click_Skip_Btn();
        HomePage.getInstance().selectTeam2(Constants.TEAM);
        HomePage.getInstance().openCreateOrderPage();
    }

    public void click_Skip_Btn() {
        ActionHelper.waitForLoaderToHide();
        Shadow shadow = new Shadow(DriverManager.getDriver());
        WebElement element = shadow.findElement("button[type='button'][data-pfbind-text='footer.skipButton.text']");
        if (element.isDisplayed())
            element.click();
    }

    public Boolean isPresent_Skip_Btn() {
        return ActionHelper.isPresent(skip_Btn, 3000);
    }

    public void performCommonAction() {
        ActionHelper.getURL(Constants.Urls.BASE_URL);
        acceptAlertIfPresent();
        waitTillLoaderDisappears();
        checkAndPerformLogin();
        waitTillLoaderDisappears();
    }

    public void waitTillLoaderAppears() {
        ActionHelper.waitUntilElementVisible(loader_Img.getBy());
    }

    public void waitTillLoaderDisappears() {
        ActionHelper.waitForElementToHide(loader_Img);
    }

    public void checkAndPerformLogin() {
//        if (HomePage.getInstance().isPresent_LoginButton_Btn())
        LoginPage.getInstance().performLoginWithEmail(Constants.EMAIL_ID, Constants.EMAIL_PASSWORD);
    }

    public void setJobStatusToInProgress(String jobId, String dispatchId, String jobType, String shipmentId, Integer cash) throws FileNotFoundException, UnsupportedEncodingException, APIResponseException {

        if (jobType.equalsIgnoreCase("COD")) {
            updateJobStatus(jobId, dispatchId, jobType, Enums.JobObjectiveRef.Pickup, Enums.ObjectiveStatus.STARTED, "");
            updateJobStatus(jobId, dispatchId, jobType, Enums.JobObjectiveRef.Pickup, Enums.ObjectiveStatus.CLOSED, Enums.Codes.COD_PICKUP_CLOSED.getValue());
            updateLedgerIn(jobId, dispatchId, "CONTAINER", shipmentId, cash);
        } else {
            updateJobStatus(jobId, dispatchId, jobType, Enums.JobObjectiveRef.Pickup, Enums.ObjectiveStatus.STARTED, "");
            updateJobStatus(jobId, dispatchId, jobType, Enums.JobObjectiveRef.Pickup, Enums.ObjectiveStatus.CLOSED, Enums.Codes.PREPAID_PICKUP_CLOSED.getValue());
            updateLedgerIn(jobId, dispatchId, "CONTAINER", shipmentId, cash);
        }
    }
    public void updateLedgerIn(String jobId, String dispatchId, String container, String shipmentId, Integer cash) throws FileNotFoundException, UnsupportedEncodingException, APIResponseException {
        String payloadPath = System.getProperty("user.dir") + "/src/test/java/payload/ledger.json";

        HashMap<String, Object> ledgerSetPayload = new HashMap<>();
        ledgerSetPayload.put("$.jobId", jobId);
        ledgerSetPayload.put("$.custodyEntityAmount", cash);
        ledgerSetPayload.put("$.custodyEntity", container);
        ledgerSetPayload.put("$.custodyEntityId", shipmentId);
        ledgerSetPayload.put("$.dispatchId", dispatchId);

        String ledgerPayload = GraphQLHelper.getInstance().setGraphQLPayload(payloadPath, ledgerSetPayload);
        Request request = new Request(Constants.Urls.COREOS_URL + "/ledgers/custody-in", HTTPMethodType.POST, ledgerPayload, headers);
        ApiFunctions.getInstance().doPost(request);
    }

    public void updateJobStatus(String jobId, String dispatchId, String jobType, Enums.JobObjectiveRef objectiveRef, Enums.ObjectiveStatus jobStatus, String code) throws FileNotFoundException, UnsupportedEncodingException, APIResponseException {
        String payloadPath = System.getProperty("user.dir") + "/src/test/java/payload/ExecutionWorkFlow.json";

        HashMap<String, Object> executionWorkFlowSetPayload = new HashMap<>();
        executionWorkFlowSetPayload.put("$.status", jobStatus.getValue());
        executionWorkFlowSetPayload.put("$.jobId", jobId);
        executionWorkFlowSetPayload.put("$.dispatchId", dispatchId);
        executionWorkFlowSetPayload.put("$.code", code);

        String workFlowInstanceId = getWorkFlowInstanceId(jobType, jobId, objectiveRef);
        ExtentLogger.logInfo("**********Fetched execution work flow id is*************" + workFlowInstanceId);

        String executionWorkFlowPayload = GraphQLHelper.getInstance().setGraphQLPayload(payloadPath, executionWorkFlowSetPayload);
        Request request = new Request(Constants.Urls.COREOS_URL + "/workflows/" + workFlowInstanceId, HTTPMethodType.POST, executionWorkFlowPayload, headers);
        ApiFunctions.getInstance().doPost(request);
    }

    public String getWorkFlowInstanceId(String jobType, String jobId, Enums.JobObjectiveRef objectiveRef) throws FileNotFoundException, UnsupportedEncodingException, APIResponseException {
        String payloadPath = System.getProperty("user.dir") + "/src/test/java/payload/getWorkFlowInstance.json";
        String getWorkFlowPayLoad = GraphQLHelper.getInstance().getGraphQLPayload(payloadPath).jsonString().replace("job:0e2c69a5-ada6-4b50-9a6b-13249e4f5a88", jobId);
        Response response = GraphQLHelper.getInstance().graphQLQuery(Constants.Urls.GRAPHQL_URL, HTTPMethodType.POST, headers, getWorkFlowPayLoad);

        String workFlowInstanceId = null;
        if (jobType.equalsIgnoreCase("cod")) {

            switch (objectiveRef.getValue()) {
                case "Pickup":
                    workFlowInstanceId = ApiFunctions.getInstance().getValueAtJsonPath(response.getResponse(), "data.job.objectives[0].workflowInstance.id");
                    break;
                case "COD_Deliver":
                    workFlowInstanceId = ApiFunctions.getInstance().getValueAtJsonPath(response.getResponse(), "data.job.objectives[1].workflowInstance.id");
                    break;
                case "Return_Cash":
                    workFlowInstanceId = ApiFunctions.getInstance().getValueAtJsonPath(response.getResponse(), "data.job.objectives[2].workflowInstance.id");
                    break;
                case "Return":
                    workFlowInstanceId = ApiFunctions.getInstance().getValueAtJsonPath(response.getResponse(), "data.job.objectives[3].workflowInstance.id");
                    break;
            }

        } else {

            switch (objectiveRef.getValue()) {
                case "Pickup":
                    workFlowInstanceId = ApiFunctions.getInstance().getValueAtJsonPath(response.getResponse(), "data.job.objectives[0].workflowInstance.id");
                    break;
                case "Prepaid_Deliver":
                    workFlowInstanceId = ApiFunctions.getInstance().getValueAtJsonPath(response.getResponse(), "data.job.objectives[1].workflowInstance.id");
                    break;
                case "Return":
                    workFlowInstanceId = ApiFunctions.getInstance().getValueAtJsonPath(response.getResponse(), "data.job.objectives[2].workflowInstance.id");
                    break;
            }
        }
        ExtentLogger.logInfo("*************Work Flow Instance ID is **********" + workFlowInstanceId);
        return workFlowInstanceId;
    }

    public void clicksdas(String input)
    {
        ActionHelper.click(sadasdsfd);
        List<WebElement> eme=ActionHelper.findElements(sadas.getBy());
        System.out.println("DSADSDd"+eme);
        for(WebElement wew:eme)
        {
            String m=wew.getText();
            if(m.equals(input))
            {
                wew.click();
            }
        }
    }

}

