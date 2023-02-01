package constants;


import framework.backend.APIResponseException;
import framework.backend.ApiFunctions;
import framework.backend.http.HTTPMethodType;
import framework.backend.http.Request;
import framework.common.utils.Utils;

import java.util.HashMap;

public class Constants {

    public static final String MOBILE_NO = "8377095609";
    public static final String FACILITY_NAME = "Test Hub";
    public static final String EMAIL_ID = "feautomationuser@gmail.com";
    public static final String EMAIL_PASSWORD = "ceeqdbpbodukvahm";
    public static final String SYSTEM_DATE_FORMAT = "dd-MM-yyyy";
    public static final String ENV = Utils.getValueFromConfig("environment");
    public static final String DISPATCH_TYPE_ID = Utils.getValueFromConfig("DISPATCH_TYPE_ID");
    public static final String UU_ID = Utils.getValueFromConfig("UU_ID");
    public static String clientId = Utils.getValueFromConfig("clientId");
    public static String clientSecret = Utils.getValueFromConfig("clientSecret");
    public static String X_COREOS_REQUEST_ID = Utils.getValueFromConfig("X_COREOS_REQUEST_ID");
    public static String X_COREOS_TID = Utils.getValueFromConfig("X_COREOS_TID");
    public static String X_COREOS_USERINFO = Utils.getValueFromConfig("X_COREOS_USERINFO");

    public static String BASE_URL = Utils.getValueFromConfig("BASE_URL");
    public static String AUTH_URL = Utils.getValueFromConfig("AUTH_URL");
    public static final String USER_ID = Utils.getValueFromConfig("USER_ID");
    public static final String USER_NAME = "fe user";

    public static Long RESPONSE_TIME = 5000L;
    public static String userOwnerID = Utils.getValueFromConfig("userOwnerID");
    public static String MANAGER = Utils.getValueFromConfig("manager");
    public static String WORK_LOCATION = Utils.getValueFromConfig("worklocation");
    public static String FUNCTION = "FE";
    public static String CATEGORY = "Regular";
    public static String EMPLOYMENT_TYPE = "Full-time";
    public static String DESIGNATION = "Field-Executive";
    public static String DESCRIPTION = "Designation description";
    public static String USER_GROUP = "Field-Executive";
    public static String API_VERSION = Utils.getValueFromConfig("ApiVersion");

    public static String FACILITY_TYPE = Utils.getValueFromConfig("FACILITY_TYPE");
    public static String FACILITY_PROPERTY_ID = Utils.getValueFromConfig("FACILITY_PROPERTY_ID");
    public static String FACILITY_OWNER_ID = Utils.getValueFromConfig("FACILITY_OWNER_ID");
    public static String NEW_REPORTING_CENTRE = Utils.getValueFromConfig("REPORTING_CENTRE");

    public static String ORDER_AMOUNT = Utils.getValueFromConfig("ORDER_AMOUNT");
    public static String TEAM = "QATeam";
    public static String PICKUP_PINCODE = "208014";
    public static String DROP_PINCODE = "281001";
    public static String RIDER = "Arpit kishoruser";
    public static String TEAM_MANAGER = "feAutomation user";
    public static final int WAIT_FOR_ONE_SECOND = 1000;
    public static final int WAIT_FOR_TWO_SECOND = 2000;
    public static final int WAIT_FOR_THREE_SECOND = 3000;
    public static final int WAIT_FOR_FIVE_SECOND = 5000;
    public static final int WAIT_FOR_TEN_SECOND = 10000;

    private Constants() {

    }

    public static final class Urls {
        public static final String BASE_URL = Utils.getValueFromConfig("BASE_URL");
        public static final String AUTH_URL = Utils.getValueFromConfig("AUTH_URL");
        public static final String GRAPHQL_URL = Utils.getValueFromConfig("GRAPHQL_URL");
        public static final String API_URL = Utils.getValueFromConfig("API_URL");
        public static final String COREOS_URL = Utils.getValueFromConfig("COREOS_URL");
        public static final String ORDER_URL = Utils.getValueFromConfig("ORDER_URL");

        public static final String VEHICLE_STATUS_EVENT_CODE_ACTIVE_AVAILABLE = Utils.getValueFromConfig("VEHICLE_STATUS_EVENT_CODE_ACTIVE_AVAILABLE");
        public static final String VEHICLE_STATUS_EVENT_CODE_ACTIVE_INUSE = Utils.getValueFromConfig("VEHICLE_STATUS_EVENT_CODE_ACTIVE_INUSE");
        public static final String VEHICLE_STATUS_EVENT_CODE_ACTIVE_UNAVAILABLE = Utils.getValueFromConfig("VEHICLE_STATUS_EVENT_CODE_ACTIVE_UNAVAILABLE");
        public static final String VEHICLE_STATUS_EVENT_CODE_INACTIVE_INACTIVE = Utils.getValueFromConfig("VEHICLE_STATUS_EVENT_CODE_INACTIVE_INACTIVE");
        public static final String VEHICLE_STATUS_EVENT_CODE_ONBOARDING_ONBOARDING = Utils.getValueFromConfig("VEHICLE_STATUS_EVENT_CODE_ONBOARDING_ONBOARDING");

        public static final String FACILITY_STATUS_EVENT_CODE_ONBOARDING_ONBOARDING = Utils.getValueFromConfig("FACILITY_STATUS_EVENT_CODE_ONBOARDING_ONBOARDING");
        public static final String FACILITY_STATUS_EVENT_CODE_ACTIVE_ACTIVE = Utils.getValueFromConfig("FACILITY_STATUS_EVENT_CODE_ACTIVE_ACTIVE");
        public static final String FACILITY_STATUS_EVENT_CODE_ACTIVE_PAUSE = Utils.getValueFromConfig("FACILITY_STATUS_EVENT_CODE_ACTIVE_PAUSE");
        public static final String FACILITY_STATUS_EVENT_CODE_ACTIVE_DEBOARD = Utils.getValueFromConfig("FACILITY_STATUS_EVENT_CODE_ACTIVE_DEBOARD");
        public static final String FACILITY_STATUS_EVENT_CODE_INACTIVE_INACTIVE = Utils.getValueFromConfig("FACILITY_STATUS_EVENT_CODE_INACTIVE_INACTIVE");

        public static final String USER_STATUS_EVENT_CODE_ACTIVE_AVAILABLE = "E-945";
        public static final String USER_STATUS_EVENT_CODE_ACTIVE_ALLOCATED = "E-943";
        public static final String USER_STATUS_EVENT_CODE_ACTIVE_DEBOARDING = "E-944";
        public static final String USER_STATUS_EVENT_CODE_INACTIVE_INACTIVE = "E-946";

    }

    public static final HashMap<String, String> headers = new HashMap<>();

    public static String ACCESS_TOKEN;

    static {
        try {
            ACCESS_TOKEN = getAccessToken();
        } catch (APIResponseException e) {
            e.printStackTrace();
        }
        headers.put("X-COREOS-TID", ENV);
        headers.put("X-COREOS-ACCESS", ACCESS_TOKEN);
        headers.put("Content-Type", "application/json");
        headers.put("X-COREOS-REQUEST-ID", "1234");
        headers.put("X-COREOS-USERINFO", "{\"id\":\"automation\"}");

    }

    public static final String getAccessToken() throws APIResponseException {

        String payload = "{\n" +
                "  \"clientId\": \"platform:app:solutions-qa\",\n" +
                "    \"clientSecret\": \"6a4104c6-b933-4e21-be7a-52fe346dc4e2\",\n" +
                "    \"audience\": \"platform:app:coreos\"\n" +
                "}";

        HashMap<String, String> header = new HashMap<String, String>();
        header.put("X-COREOS-REQUEST-ID", "testId");
        header.put("X-COREOS-TID", ENV);
        header.put("Content-Type", "application/json");

        Request request = new Request(Urls.AUTH_URL, HTTPMethodType.POST, payload, header);
        ApiFunctions.getInstance().doPost(request);

        String accessToken = ApiFunctions.getInstance().getValueAtJsonPath("data.accessToken");
        return accessToken;
    }
}
