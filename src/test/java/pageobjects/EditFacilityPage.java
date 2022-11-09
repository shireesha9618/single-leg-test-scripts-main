package pageobjects;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class EditFacilityPage {
    private static EditFacilityPage _instance;
    private final Locator facilities_BreadCrumb = Locator.builder().withWeb(By.xpath("//a[@href='/application/facilities/']"));
    private final Locator editFacility_BreadCrumb = Locator.builder().withWeb(By.xpath("//a[@href='/application/facilities/edit/']"));
    private final Locator editFacilityHeader_Lbl = Locator.builder().withWeb(By.xpath("//h2"));
    private final Locator basicDetailsSubHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Basic Details']"));
    private final Locator facilityName_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Facility Name*']"));
    private final Locator facilityName_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Facility Name']"));
    private final Locator facilityId_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Facility ID*']"));
    private final Locator facilityId_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Facility ID']"));
    private final Locator addressDetailsSubHeader_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Address Details']"));
    private final Locator postalCode_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Postal Code*']"));
    private final Locator postalCode_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Postal Code']"));
    private final Locator country_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Country*']"));
    private final Locator country_Txt = Locator.builder().withWeb(By.xpath("//span[@title='India']"));
    private final Locator addressLine1_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Address Line 1*']"));
    private final Locator addressLine1_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Address Line 1']"));
    private final Locator addressLine2_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Address Line 2*']"));
    private final Locator addressLine2_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Address Line 2']"));
    private final Locator city_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='City*']"));
    private final Locator city_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter City']"));
    private final Locator state_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='State*']"));
    private final Locator state_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter State']"));
    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']"));
    private final Locator save_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Save']"));

    public static EditFacilityPage getInstance() {
        if (_instance == null) _instance = new EditFacilityPage();
        return _instance;
    }

    public boolean isPresent_Facilities_BreadCrumb() {
        return ActionHelper.isPresent(facilities_BreadCrumb);
    }

    public void click_Facilities_BreadCrumb() {
        ActionHelper.click(facilities_BreadCrumb);
    }

    public boolean isPresent_EditFacility_BreadCrumb() {
        return ActionHelper.isPresent(editFacility_BreadCrumb);
    }

    public void click_EditFacility_BreadCrumb() {
        ActionHelper.click(editFacility_BreadCrumb);
    }

    public boolean isPresent_EditFacilityHeader_Lbl() {
        return ActionHelper.isPresent(editFacilityHeader_Lbl);
    }

    public void click_EditFacilityHeader_Lbl() {
        ActionHelper.click(editFacilityHeader_Lbl);
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
        ActionHelper.fillWithClear(facilityName_Txt.getBy(), facilityName);
    }

    public boolean isPresent_FacilityId_Lbl() {
        return ActionHelper.isPresent(facilityId_Lbl);
    }

    public boolean isPresent_FacilityId_Txt() {
        return ActionHelper.isPresent(facilityId_Txt);
    }

    public void fill_FacilityId_Txt(String facilityId) {
        ActionHelper.fillWithClear(facilityId_Txt.getBy(), facilityId);
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
        ActionHelper.fillWithClear(postalCode_Txt.getBy(), postalCode);
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

    public boolean isPresent_AddressLine1_Lbl() {
        return ActionHelper.isPresent(addressLine1_Lbl);
    }

    public boolean isPresent_AddressLine1_Txt() {
        return ActionHelper.isPresent(addressLine1_Txt);
    }

    public void fill_AddressLine1_Txt(String addressLine1) {
        ActionHelper.fillWithClear(addressLine1_Txt.getBy(), addressLine1);
    }

    public boolean isPresent_AddressLine2_Lbl() {
        return ActionHelper.isPresent(addressLine2_Lbl);
    }

    public boolean isPresent_AddressLine2_Txt() {
        return ActionHelper.isPresent(addressLine2_Txt);
    }

    public void fill_AddressLine2_Txt(String addressLine2) {
        ActionHelper.fillWithClear(addressLine2_Txt.getBy(), addressLine2);
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

    public boolean isPresent_State_Lbl() {
        return ActionHelper.isPresent(state_Lbl);
    }

    public boolean isPresent_State_Txt() {
        return ActionHelper.isPresent(state_Txt);
    }

    public void fill_State_Txt(String state) {
        ActionHelper.fillWithClear(state_Txt.getBy(), state);
    }

    public boolean isPresent_Cancel_Btn() {
        return ActionHelper.isPresent(cancel_Btn);
    }

    public void click_Cancel_Btn() {
        ActionHelper.click(cancel_Btn);
    }

    public boolean isPresent_Save_Btn() {
        return ActionHelper.isPresent(save_Btn);
    }

    public void click_Save_Btn() {
        ActionHelper.click(save_Btn);
    }
}
