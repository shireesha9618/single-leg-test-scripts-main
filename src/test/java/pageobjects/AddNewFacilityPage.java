package pageobjects;

import com.github.javafaker.Faker;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utility.Utility;

import java.util.HashMap;

public class AddNewFacilityPage {
    private static AddNewFacilityPage _instance;
    private final Locator facilities_BreadCrumb = Locator.builder().withWeb(By.xpath("//a[@href='/application/facilities/']"));
    private final Locator addNewFacility_BreadCrumb = Locator.builder().withWeb(By.xpath("//a[@href='/application/facilities/add/']"));
    private final Locator addNewFacilityHeader_Lbl = Locator.builder().withWeb(By.xpath("//h2[text()='Add New Facility']"));
    private final Locator editFacility_BreadCrumb = Locator.builder().withWeb(By.xpath("//a[@href='/application/facilities/edit/']"));
    private final Locator editFacilityHeader_Lbl = Locator.builder().withWeb(By.xpath("//h2[text()='Edit Facility']"));
    private final Locator basicDetailsSubHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Basic Details']"));
    private final Locator facilityName_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Facility Name*']"));
    private final Locator facilityName_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Facility Name']"));
    private final Locator facilityId_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Facility ID*']"));
    private final Locator facilityId_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Facility ID']"));
    private final Locator addressDetailsSubHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Address Details']"));
    private final Locator postalCode_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Postal Code*']"));
    private final Locator postalCode_Txt = Locator.builder().withWeb(By.xpath("//input[@name='addressDetails.postalCode']"));
    private final Locator country_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Country*']"));
    private final Locator country_Txt = Locator.builder().withWeb(By.xpath("//div[@class='ant-select-selector']//input[@disabled='']"));

    private final Locator addressLine1_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Address Line 1*']"));
    private final Locator addressLine1_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Address Line 1']"));
    private final Locator addressLine2_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Address Line 2']"));
    private final Locator addressLine2_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Address Line 2']"));
    private final Locator city_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='City*']"));
    private final Locator city_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter City']"));
    private final Locator state_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='State*']"));
    private final Locator state_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter State']"));
    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']"));
    private final Locator save_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Save']"));
    private final Locator create_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Create']/.."));
    private final Locator facilityNameErrorMsg_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Facility Name*']/../following-sibling::div//p"));
    private final Locator facilityIdErrorMsg_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Facility ID*']/../following-sibling::div//p"));
    private final Locator postalCodeErrorMsg_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Postal Code*']/../following-sibling::div//p"));
    private final Locator popUpErrorMsg_Lbl = Locator.builder().withWeb(By.xpath("//div[contains(@class,'shadow-md max-w-md')]"));
    private final Locator addressLine1ErrorMsg_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Address Line 1*']/../following-sibling::div//p"));
    private final Locator addressLine2ErrorMsg_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Address Line 2*']/../following-sibling::div//p"));
    private final Locator stateErrorMsg_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='State*']/../following-sibling::div//p"));
    private final Locator cityErrorMsg_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='City*']/../following-sibling::div//p"));
    private final Locator duplicateIdErrorMsgPopUp_Lbl = Locator.builder().withWeb(By.xpath("//div[contains(text(),'code is already exists')]"));
    Faker sampleData = new Faker();

    public static AddNewFacilityPage getInstance() {
        if (_instance == null) _instance = new AddNewFacilityPage();
        return _instance;
    }

    public boolean isPresent_Facilities_BreadCrumb() {
        return ActionHelper.isPresent(facilities_BreadCrumb);
    }

    public void click_Facilities_BreadCrumb() {
        ActionHelper.click(facilities_BreadCrumb);
    }

    public boolean isPresent_AddNewFacility_BreadCrumb() {
        return ActionHelper.isPresent(addNewFacility_BreadCrumb);
    }

    public void click_AddNewFacility_BreadCrumb() {
        ActionHelper.click(addNewFacility_BreadCrumb);
    }

    public boolean isPresent_EditFacility_BreadCrumb() {
        return ActionHelper.isPresent(editFacility_BreadCrumb);
    }

    public void click_EditFacility_BreadCrumb() {
        ActionHelper.click(editFacility_BreadCrumb);
    }

    public boolean isPresent_EditFacilityHeader_Lbl() {
        ActionHelper.waitUntilElementVisible(editFacilityHeader_Lbl.getBy());
        return ActionHelper.isPresent(editFacilityHeader_Lbl);
    }

    public String getText_EditFacilityHeader_Lbl() {
        return ActionHelper.getText(editFacilityHeader_Lbl);
    }

    public boolean isPresent_AddNewFacilityHeader_Lbl() {
        ActionHelper.waitUntilElementVisible(addNewFacilityHeader_Lbl.getBy());
        return ActionHelper.isPresent(addNewFacilityHeader_Lbl);
    }

    public String getText_AddNewFacilityHeader_Lbl() {
        return ActionHelper.getText(addNewFacilityHeader_Lbl);
    }

    public boolean isPresent_BasicDetailsSubHeader_Lbl() {
        return ActionHelper.isPresent(basicDetailsSubHeader_Lbl);
    }

    public boolean isPresent_FacilityName_Lbl() {
        return ActionHelper.isPresent(facilityName_Lbl);
    }

    public boolean isPresent_FacilityName_Txt() {
        return ActionHelper.isPresent(facilityName_Txt);
    }

    public void fill_FacilityName_Txt(String facilityName) {
        ActionHelper.sendKeysWithClear(facilityName_Txt.getBy(), facilityName);
    }

    public boolean isEnabled_FacilityName_Txt() {
        return ActionHelper.isEnabled(facilityName_Txt.getBy());
    }

    public String getText_FacilityName_Txt() {
        return ActionHelper.getText(facilityName_Txt);
    }

    public boolean isPresent_FacilityId_Lbl() {
        return ActionHelper.isPresent(facilityId_Lbl);
    }

    public boolean isPresent_FacilityId_Txt() {
        return ActionHelper.isPresent(facilityId_Txt);
    }

    public boolean isEnabled_FacilityId_Txt() {
        return ActionHelper.isEnabled(facilityId_Txt.getBy());
    }

    public void fill_FacilityId_Txt(String facilityId) {
        ActionHelper.sendKeysWithClear(facilityId_Txt.getBy(), Keys.chord(facilityId));
    }

    public boolean isPresent_AddressDetailsSubHeader_Lbl() {
        return ActionHelper.isPresent(addressDetailsSubHeader_Lbl);
    }

    public boolean isPresent_PostalCode_Lbl() {
        return ActionHelper.isPresent(postalCode_Lbl);
    }

    public boolean isPresent_PostalCode_Txt() {
        return ActionHelper.isPresent(postalCode_Txt);
    }

    public void fill_PostalCode_Txt(String postalCode) {
        ActionHelper.sendKeysWithClear(postalCode_Txt.getBy(), Keys.chord(postalCode));
    }

    public String getText_PostalCode_Txt() {
        return ActionHelper.getText(postalCode_Txt);
    }

    public boolean isEmpty_PostalCode_Txt() {
        return ActionHelper.findElement(postalCode_Txt).getAttribute("value").length() == 0;
    }

    public boolean isPresent_Country_Lbl() {
        return ActionHelper.isPresent(country_Lbl);
    }

    public boolean isPresent_Country_Txt() {
        return ActionHelper.isPresent(country_Txt);
    }

    public void fill_Country_Txt(String country) {
        ActionHelper.fillWithClear(country_Txt.getBy(), country);
    }

    public boolean isDisabled_Country_Txt() {
        return ActionHelper.findElement(country_Txt).getAttribute("disabled").equals("true");
    }

    public boolean isPresent_AddressLine1_Lbl() {
        return ActionHelper.isPresent(addressLine1_Lbl);
    }

    public boolean isPresent_AddressLine1_Txt() {
        return ActionHelper.isPresent(addressLine1_Txt);
    }

    public void fill_AddressLine1_Txt(String addressLine1) {
        ActionHelper.sendKeysWithClear(addressLine1_Txt.getBy(), Keys.chord(addressLine1));
    }

    public boolean isEmpty_AddressLine1_Txt() {
        return ActionHelper.findElement(addressLine1_Txt).getAttribute("value").length() == 0;
    }

    public boolean isPresent_AddressLine2_Lbl() {
        return ActionHelper.isPresent(addressLine2_Lbl);
    }

    public boolean isPresent_AddressLine2_Txt() {
        return ActionHelper.isPresent(addressLine2_Txt);
    }

    public boolean isEmpty_AddressLine2_Txt() {
        return ActionHelper.findElement(addressLine2_Txt).getAttribute("value").length() == 0;
    }

    public void fill_AddressLine2_Txt(String addressLine2) {
        ActionHelper.sendKeysWithClear(addressLine2_Txt.getBy(), Keys.chord(addressLine2));
    }

    public boolean isPresent_City_Lbl() {
        return ActionHelper.isPresent(city_Lbl);
    }

    public boolean isPresent_City_Txt() {
        return ActionHelper.isPresent(city_Txt);
    }

    public void fill_City_Txt(String city) {
        ActionHelper.fillWithClear(city_Txt.getBy(), city);
    }

    public boolean isEmpty_City_Txt() {
        return ActionHelper.findElement(city_Txt).getAttribute("value").length() == 0;
    }

    public boolean isPresent_State_Lbl() {
        return ActionHelper.isPresent(state_Lbl);
    }

    public boolean isPresent_State_Txt() {
        return ActionHelper.isPresent(state_Txt);
    }

    public void fill_State_Txt(String state) {
        ActionHelper.fillWithClear(state_Txt.getBy(), state);
    }

    public boolean isEmpty_State_Txt() {
        return ActionHelper.findElement(state_Txt).getAttribute("value").length() == 0;
    }

    public boolean isPresent_Cancel_Btn() {
        return ActionHelper.isPresent(cancel_Btn);
    }

    public void click_Cancel_Btn() {
        ActionHelper.waitUntilElementClickable(cancel_Btn);
        ActionHelper.click(cancel_Btn);
    }

    public boolean isPresent_Save_Btn() {
        return ActionHelper.isPresent(save_Btn);
    }

    public void click_Save_Btn() {
        ActionHelper.click(save_Btn);
        CommonActions.getInstance().waitTillLoaderDisappears();
    }

    public boolean isPresent_Create_Btn() {
        return ActionHelper.isPresent(create_Btn);
    }

    public void click_Create_Btn() {
        ActionHelper.click(create_Btn);
    }

    public HashMap<String, String> createNewFacility() {
        HashMap<String, String> fillFacilityDetails = new HashMap<>();
        String facilityName = "facility" + sampleData.name().lastName().replaceAll("[^a-zA-Z0-9]", "");
        String facilityId = getText_FacilityId_Txt();
        String postalCode = Utility.get_PostalCode_Txt();
        String addressLine1 = sampleData.address().streetName().replaceAll("[^a-zA-Z0-9]", "");
        String addressLine2 = sampleData.address().streetName().replaceAll("[^a-zA-Z0-9]", "");

        fillFacilityDetails.put("facilityName", facilityName);
        fillFacilityDetails.put("facilityId", facilityId);
        fillFacilityDetails.put("postalCode", postalCode);
        fillFacilityDetails.put("addressLine1", addressLine1);
        fillFacilityDetails.put("addressLine2", addressLine2);

        fill_FacilityName_Txt(facilityName);
        fill_PostalCode_Txt(postalCode);
        CommonActions.getInstance().waitTillLoaderDisappears();
        fill_AddressLine1_Txt(addressLine1);
        fill_AddressLine2_Txt(addressLine2);

        click_Create_Btn();
        CommonActions.getInstance().waitTillLoaderDisappears();
        return fillFacilityDetails;
    }

    public HashMap<String, String> fillEditFacilityPage() {
        HashMap<String, String> updateFacility = new HashMap<>();
        String postalCode = Utility.get_PostalCode_Txt();
        String addressLine1 = sampleData.address().streetName().replaceAll("[^a-zA-Z0-9]", "");
        String addressLine2 = sampleData.address().streetName().replaceAll("[^a-zA-Z0-9]", "");

        updateFacility.put("postalCode", postalCode);
        updateFacility.put("addressLine1", addressLine1);
        updateFacility.put("addressLine2", addressLine2);

        fill_PostalCode_Txt(postalCode);
        CommonActions.getInstance().waitTillLoaderDisappears();
        fill_AddressLine1_Txt(addressLine1);
        fill_AddressLine2_Txt(addressLine2);

        return updateFacility;
    }

    public String getText_FacilityId_Txt() {
        return ActionHelper.getAttribute(facilityId_Txt, "value");
    }

    public String getText_FacilityNameErrorMsg_Lbl() {
        ActionHelper.waitUntilElementVisible(facilityNameErrorMsg_Lbl.getBy());
        return ActionHelper.getText(facilityNameErrorMsg_Lbl);
    }

    public String getText_FacilityIdErrorMsg_Lbl() {
        return ActionHelper.getText(facilityIdErrorMsg_Lbl);
    }

    public String getText_PostalCodeErrorMsg_Lbl() {
        return ActionHelper.getText(postalCodeErrorMsg_Lbl);
    }

    public boolean isPresent_PopUpErrorMsg_Lbl() {
        return ActionHelper.isPresent(popUpErrorMsg_Lbl);
    }

    public String getText_AddressLine1ErrorMsg_Lbl() {
        return ActionHelper.getText(addressLine1ErrorMsg_Lbl);
    }

    public String getText_AddressLine2ErrorMsg_Lbl() {
        return ActionHelper.getText(addressLine2ErrorMsg_Lbl);
    }

    public String getText_StateErrorMsg_Lbl() {
        return ActionHelper.getText(stateErrorMsg_Lbl);
    }

    public String getText_CityErrorMsg_Lbl() {
        return ActionHelper.getText(cityErrorMsg_Lbl);
    }

    public String getText_PopUpErrorMsg_Lbl() {
        return ActionHelper.getText(popUpErrorMsg_Lbl);
    }

    public String getText_DuplicateIdErrorMsgPopUp_Lbl() {
        return ActionHelper.getText(duplicateIdErrorMsgPopUp_Lbl);
    }
}
