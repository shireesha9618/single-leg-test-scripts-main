package pageobjects.settings;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class GeneralPage {
    private static GeneralPage _instance;
    private final Locator generalHeader_Lbl = Locator.builder().withWeb(By.xpath("//h2"));
    private final Locator generalBreadCrumb_Link = Locator.builder().withWeb(By.id("/settings/generalSettings/systemPreferences"));
    private final Locator subHeaderOrganizationDetail_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Organization Details']"));
    private final Locator organizationName_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Organization Name']"));
    private final Locator organizationName_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Organization Name']/following-sibling::p"));
    private final Locator country_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Country']"));
    private final Locator country_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Country']/following-sibling::p"));
    private final Locator headquarter_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Headquarter']"));
    private final Locator headquarter_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Headquarter']/following-sibling::p"));
    private final Locator language_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Language']"));
    private final Locator language_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Language']/following-sibling::p"));

    private final Locator subHeaderDateAndTime_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Date And Time']"));
    private final Locator timeZone_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Timezone']"));
    private final Locator timeZone_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Timezone']/following-sibling::p"));
    private final Locator dateFormat_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Date Format']"));
    private final Locator dateFormat_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Date Format']/following-sibling::p"));
    private final Locator timeFormat_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Time Format']"));
    private final Locator timeFormat_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Time Format']/following-sibling::p"));

    private final Locator subHeaderCurrency_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Currency']"));
    private final Locator currency_Lbl = Locator.builder().withWeb(By.xpath("//p[@class='text-default_black text-sm font-normal' and text()='Currency']"));
    private final Locator currency_Txt = Locator.builder().withWeb(By.xpath("//p[@class='text-default_black text-sm font-normal' and text()='Currency']/following-sibling::p"));

    private final Locator subHeaderUnitsOfMeasurement_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Units of Measurement']"));
    private final Locator volume_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Volume']"));
    private final Locator volume_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Volume']/following-sibling::p"));
    private final Locator weight_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Weight']"));
    private final Locator weight_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Weight']/following-sibling::p"));
    private final Locator area_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Area']"));
    private final Locator area_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Area']/following-sibling::p"));
    private final Locator dimension_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Dimension']"));
    private final Locator dimension_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Dimension']/following-sibling::p"));
    private final Locator temperature_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Temperature']"));
    private final Locator temperature_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Temperature']/following-sibling::p"));

    private final Locator subHeaderOthers_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Others']"));
    private final Locator maxDeliverAttempts_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Max Deliver Attemps']"));
    private final Locator maxDeliverAttempts_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Max Deliver Attemps']/following-sibling::p"));
    private final Locator maxPickupAttempts_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Max Pickup Attemps']"));
    private final Locator maxPickupAttempts_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Max Pickup Attemps']/following-sibling::p"));
    private final Locator routing_Lbl = Locator.builder().withWeb(By.xpath("//p[text()='Routing ']"));
    private final Locator routing_Txt = Locator.builder().withWeb(By.xpath("//p[text()='Routing ']/following-sibling::p"));

    public static GeneralPage getInstance(){
        if(_instance == null)
            _instance = new GeneralPage();
        return _instance;
    }

    public boolean isPresent_GeneralHeader_Lbl() {
        return ActionHelper.isPresent(generalHeader_Lbl);
    }

    public String getText_GeneralHeader_Lbl() {
        return ActionHelper.getText(generalHeader_Lbl);
    }

    public boolean isPresent_GeneralBreadCrumb_Link() {
        return ActionHelper.isPresent(generalBreadCrumb_Link);
    }

    public void click_GeneralBreadCrumb_Link() {
        ActionHelper.click(generalBreadCrumb_Link);
    }

    public boolean isPresent_SubHeaderOrganizationDetail_Lbl() {
        return ActionHelper.isPresent(subHeaderOrganizationDetail_Lbl);
    }

    public String getText_SubHeaderOrganizationDetail_Lbl() {
        return ActionHelper.getText(subHeaderOrganizationDetail_Lbl);
    }

    public boolean isPresent_OrganizationName_Lbl() {
        return ActionHelper.isPresent(organizationName_Lbl);
    }

    public boolean isPresent_OrganizationName_Txt() {
        return ActionHelper.isPresent(organizationName_Txt);
    }

    public String getText_OrganizationName_Txt() {
        return ActionHelper.getText(organizationName_Txt);
    }

    public boolean isPresent_Country_Lbl() {
        return ActionHelper.isPresent(country_Lbl);
    }

    public boolean isPresent_Country_Txt() {
        return ActionHelper.isPresent(country_Txt);
    }

    public String getText_Country_Txt() {
        return ActionHelper.getText(country_Txt);
    }

    public boolean isPresent_Headquarter_Lbl() {
        return ActionHelper.isPresent(headquarter_Lbl);
    }

    public boolean isPresent_Headquarter_Txt() {
        return ActionHelper.isPresent(headquarter_Txt);
    }

    public String getText_headquarter_Txt() {
        return ActionHelper.getText(headquarter_Txt);
    }

    public boolean isPresent_Language_Lbl() {
        return ActionHelper.isPresent(language_Lbl);
    }

    public boolean isPresent_Language_Txt() {
        return ActionHelper.isPresent(language_Txt);
    }

    public String getText_Language_Txt() {
        return ActionHelper.getText(language_Txt);
    }

    public boolean isPresent_SubHeaderDateAndTime_Lbl() {
        return ActionHelper.isPresent(subHeaderDateAndTime_Lbl);
    }

    public String getText_SubHeaderDateAndTime_Lbl() {
        return ActionHelper.getText(subHeaderDateAndTime_Lbl);
    }

    public boolean isPresent_TimeZone_Lbl() {
        return ActionHelper.isPresent(timeZone_Lbl);
    }

    public boolean isPresent_TimeZone_Txt() {
        return ActionHelper.isPresent(timeZone_Txt);
    }

    public String getText_TimeZone_Txt() {
        return ActionHelper.getText(timeZone_Txt);
    }

    public boolean isPresent_DateFormat_Lbl() {
        return ActionHelper.isPresent(dateFormat_Lbl);
    }

    public boolean isPresent_DataFormat_Txt() {
        return ActionHelper.isPresent(dateFormat_Txt);
    }

    public String getText_DateFormat_Txt() {
        return ActionHelper.getText(dateFormat_Txt);
    }

    public boolean isPresent_TimeFormat_Lbl() {
        return ActionHelper.isPresent(timeFormat_Lbl);
    }

    public boolean isPresent_TimeFormat_Txt() {
        return ActionHelper.isPresent(timeFormat_Txt);
    }

    public String getText_TimeFormat_Txt() {
        return ActionHelper.getText(timeFormat_Txt);
    }

    public boolean isPresent_SubHeaderCurrency_Lbl() {
        return ActionHelper.isPresent(subHeaderCurrency_Lbl);
    }

    public String getText_SubHeaderCurrency_Lbl() {
        return ActionHelper.getText(subHeaderCurrency_Lbl);
    }

    public boolean isPresent_Currency_Lbl() {
        return ActionHelper.isPresent(currency_Lbl);
    }

    public boolean isPresent_Currency_Txt() {
        return ActionHelper.isPresent(currency_Txt);
    }

    public String getText_Currency_Txt() {
        return ActionHelper.getText(currency_Txt);
    }

    public boolean isPresent_SubHeaderUnitsOfMeasurement_Lbl() {
        return ActionHelper.isPresent(subHeaderUnitsOfMeasurement_Lbl);
    }

    public String getText_SubHeaderUnitsOfMeasurement_Lbl() {
        return ActionHelper.getText(subHeaderUnitsOfMeasurement_Lbl);
    }

    public boolean isPresent_Volume_Lbl() {
        return ActionHelper.isPresent(volume_Lbl);
    }

    public boolean isPresent_Volume_Txt() {
        return ActionHelper.isPresent(volume_Txt);
    }

    public String getText_Volume_Txt() {
        return ActionHelper.getText(volume_Txt);
    }

    public boolean isPresent_Weight_Lbl() {
        return ActionHelper.isPresent(weight_Lbl);
    }

    public boolean isPresent_Weight_Txt() {
        return ActionHelper.isPresent(weight_Txt);
    }

    public String getText_Weight_Txt() {
        return ActionHelper.getText(weight_Txt);
    }

    public boolean isPresent_Area_Lbl() {
        return ActionHelper.isPresent(area_Lbl);
    }

    public boolean isPresent_Area_Txt() {
        return ActionHelper.isPresent(area_Txt);
    }

    public String getText_Area_Txt() {
        return ActionHelper.getText(area_Txt);
    }

    public boolean isPresent_Dimension_Lbl() {
        return ActionHelper.isPresent(dimension_Lbl);
    }

    public boolean isPresent_Dimension_Txt() {
        return ActionHelper.isPresent(dimension_Txt);
    }

    public String getText_Dimension_Txt() {
        return ActionHelper.getText(dimension_Txt);
    }

    public boolean isPresent_Temperature_Lbl() {
        return ActionHelper.isPresent(temperature_Lbl);
    }

    public boolean isPresent_Temperature_Txt() {
        return ActionHelper.isPresent(temperature_Txt);
    }

    public String getText_Temperature_Txt() {
        return ActionHelper.getText(temperature_Txt);
    }

    public boolean isPresent_SubHeaderOthers_Lbl() {
        return ActionHelper.isPresent(subHeaderOthers_Lbl);
    }

    public String getText_SubHeaderOthers_Lb() {
        return ActionHelper.getText(subHeaderOthers_Lbl);
    }

    public boolean isPresent_MaxDeliverAttempts_Lbl() {
        return ActionHelper.isPresent(maxDeliverAttempts_Lbl);
    }

    public boolean isPresent_MaxDeliverAttempts_Txt() {
        return ActionHelper.isPresent(maxDeliverAttempts_Txt);
    }

    public String getText_MaxDeliverAttempts_Txt() {
        return ActionHelper.getText(maxDeliverAttempts_Txt);
    }

    public boolean isPresent_MaxPickUpAttempts_Lbl() {
        return ActionHelper.isPresent(maxPickupAttempts_Lbl);
    }

    public boolean isPresent_MaxPickUpAttempt_Txt() {
        return ActionHelper.isPresent(maxPickupAttempts_Txt);
    }

    public String getText_MaxPickupAttempts_Txt() {
        return ActionHelper.getText(maxPickupAttempts_Txt);
    }

    public boolean isPresent_Routing_Lbl() {
        return ActionHelper.isPresent(routing_Lbl);
    }

    public boolean isPresent_Routing_Txt() {
        return ActionHelper.isPresent(routing_Txt);
    }

    public String getText_Routing_Txt() {
        return ActionHelper.getText(routing_Txt);
    }
}
