package pageobjects;

import framework.frontend.locator.Locator;
import org.openqa.selenium.By;

public class AddNewRiderPage {
    private static AddNewRiderPage _instance;
    private final Locator header_Lbl = Locator.builder().withWeb(By.xpath("//h2[@class='text-black text-4xl font-bold']"));
    private final Locator homeBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//p[@class='text-sm font-medium text-[#A3AAC2] hover:text-gray-700'][text()='Home']"));
    private final Locator ridersBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//p[@class='text-sm font-medium text-[#A3AAC2] hover:text-gray-700'][text()='Riders']"));
    private final Locator addNewRiderBreadCrumb_Link = Locator.builder().withWeb(By.xpath("//p[@class='text-sm font-medium text-labels hover:text-gray-700']"));
    private final Locator firstName_Lbl = Locator.builder().withWeb(By.xpath("//label[text()='First Name*']"));
    private final Locator firstName_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter first name']"));
    private final Locator lastName_Lbl = Locator.builder().withWeb(By.xpath("//label[text()='Last Name*']"));
    private final Locator lastName_Txt = Locator.builder().withWeb(By.xpath("//input[@placeholder='Enter Last Name']"));
    private final Locator phoneNumber_Lbl = Locator.builder().withWeb(By.xpath("//label[text()='Phone Number*']"));
    private final Locator phoneNumber_Txt = Locator.builder().withWeb(By.xpath("//input[@class='outline-none block py-2 shadow-sm text-sm placeholder:text-gray-500 text-black rounded border transition border-gray-200 focus:ring-indigo-600 rounded-l-none border-l-none w-full']"));
    private final Locator teams_Lbl = Locator.builder().withWeb(By.xpath("//h4[text()='Teams*']"));
    private final Locator uploadPhoto_Btn = Locator.builder().withWeb(By.xpath("//div[@class='ant-upload ant-upload-select ant-upload-select-text']"));
    private final Locator cancel_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Cancel']"));
    private final Locator addRider_Btn = Locator.builder().withWeb(By.xpath("//p[text()='Add Rider']"));


}

