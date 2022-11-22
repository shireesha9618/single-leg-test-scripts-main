package pageobjects;

import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class AddNewRiderPage {
    private static AddNewRiderPage _instance;
    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//h2[text()='Add New Rider']"));
    private final Locator homeBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//p[text()='Home']"));
    private final Locator ridersBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/riders']//p"));
    private final Locator addNewRiderBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//li[@id='/riders/add']//p"));
    private final Locator firstName_Lbl = Locator.builder().withWeb(By.xpath("//label[text()='First Name*']"));
    private final Locator firstName_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter first name']"));
    private final Locator lastName_Lbl = Locator.builder().withWeb(By.xpath("//label[text()='Last Name*']"));
    private final Locator lastName_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Last Name']"));
    private final Locator phoneNumber_Lbl = Locator.builder().withWeb(By.xpath("//label[text()='Phone Number*']"));
    private final Locator phoneNumber_Txt = Locator.builder().withWeb(By.xpath("(//label[text()='Phone Number*']/..//input[@type='text'])[2]"));
    private final Locator teams_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Teams*']"));
    private final Locator uploadPhoto_Btn = Locator.builder().withWeb(By.xpath("//div[contains(@class, 'ant-upload')]"));
    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']/.."));
    private final Locator addRider_Btn = Locator.builder().withWeb(By.xpath("//button[@id='submitForm']"));
}

