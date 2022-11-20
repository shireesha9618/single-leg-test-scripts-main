package testsuite.resources;

import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.sql.DriverAction;

public class TestSuite_Facilities {
    private final Locator skip_Btn = Locator.builder().withWeb(By.cssSelector(".productfruits--btn.productfruits--card-footer-skip-button"));

    public void click_Skip_Btn() {
        ActionHelper.waitForLoaderToHide();
//        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
//        Actions builder = new Actions(DriverManager.getDriver());
//        if(isPresent_Skip_Btn())
////          js.executeScript("arguments[0].click();", skip_Btn);
//            builder
//                    .moveToElement((WebElement) skip_Btn).click().build();
//    }

    }
}
