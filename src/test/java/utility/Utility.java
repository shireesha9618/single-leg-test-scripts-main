package utility;

import com.github.javafaker.Faker;
import framework.common.logger.ExtentLogger;
import framework.frontend.actions.ActionHelper;
import framework.frontend.locator.Locator;
import framework.frontend.managers.DriverManager;
import org.joda.time.DateTime;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CommonActions;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class Utility {

    public static int mapMonthNameToNo(String monthName) {
        switch (monthName) {
            case "Jan":
                return 1;
            case "Feb":
                return 2;
            case "Mar":
                return 3;
            case "Apr":
                return 4;
            case "May":
                return 5;
            case "Jun":
                return 6;
            case "Jul":
                return 7;
            case "Aug":
                return 8;
            case "Sep":
                return 9;
            case "Oct":
                return 10;
            case "Nov":
                return 11;
            case "Dec":
                return 12;
            default:
                return -1;

        }
    }

    public static List<String> getText_ListOfWebElements(List<WebElement> elements) {
        List<String> labels = new ArrayList<>();
        for (WebElement element : elements)
            labels.add(element.getText());
        return labels;
    }

    public static List<String> getText_ListOfWebElements(By by) {
        CommonActions.getInstance().waitTillLoaderDisappears();
        return getText_ListOfWebElements(ActionHelper.findElementsWithoutWait(by));
    }

    public static List<String> getSortedListOfText_ListOfWebElementsWhileScrollingUsingJS(By by) {
        Set<String> labels = new TreeSet<>();
        labels.addAll(getText_ListOfWebElements(DriverManager.getDriver().findElements(by)));
        scrollUsingJSToTheLastElement(by);
        labels.addAll(getText_ListOfWebElements(DriverManager.getDriver().findElements(by)));
        labels.remove("");
        return new ArrayList<>(labels);
    }

    public static void selectAllAndClear(By by) {
        WebElement webElement = ActionHelper.findElement(by);
        webElement.click();
        webElement.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.CONTROL, "a"})});
        webElement.sendKeys(new CharSequence[]{Keys.BACK_SPACE});
    }

    public static int generateRandomNoInRange(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }

    public static Locator fillPlaceholderValueInXpath(Locator locator, String value) {
        String xpathSubStrings[] = locator.getBy().toString().split(" ");
        xpathSubStrings[xpathSubStrings.length - 1] = xpathSubStrings[xpathSubStrings.length - 1].replace(
                "PLACEHOLDER", value);

        String xpath = "";
        for (int i = 1; i < xpathSubStrings.length; i++) {
            if (xpath == "") xpath = xpathSubStrings[i];
            else xpath = xpath + " " + xpathSubStrings[i];
        }
        return Locator.builder().withWeb(By.xpath(xpath));
    }

    public static void checkCheckbox(By by) {
        WebElement element = DriverManager.getDriver().findElement(by);
        checkCheckbox(element);
    }

    public static void checkCheckbox(WebElement element) {
        ActionHelper.waitUntilElementClickable(element);
        ActionHelper.click(element);
        ExtentLogger.logPass("Checking Checkbox ");
    }

    public static void clickRadio(By by) {
        WebElement element = DriverManager.getDriver().findElement(by);
        clickRadio(element);
    }

    public static void clickRadio(WebElement element) {
        ActionHelper.waitUntilElementClickable(element);
        ActionHelper.click(element);
        ExtentLogger.logPass("Clicking Radio ");
    }

    public static String getRecordCountFromTabHeaderLabel(String label) {
        String labelSubStrings[] = label.split(" ");
        return labelSubStrings[labelSubStrings.length - 1].replace("(", "").replace(")", "");
    }

    public static boolean clickWebElementMatchingText(List<WebElement> elements, String text) {
        boolean found = false;
        for (WebElement element : elements) {
            if (ActionHelper.getText(element).equals(text)) {
                ActionHelper.click(element);
                found = true;
                break;
            }
        }
        return found;
    }

    public static boolean clickWebElementContainingText(List<WebElement> elements, String text) {
        boolean found = false;
        for (WebElement element : elements) {
            if (ActionHelper.getText(element).contains(text)) {
                ActionHelper.click(element);
                found = true;
                break;
            }
        }
        return found;
    }

    public static LocalDate getPreviousMonth(LocalDate currentDate, long minusMonth) {
        LocalDate previousMonth = currentDate.minusMonths(minusMonth);
        return previousMonth;
    }

    public static LocalDate getNextMonth(LocalDate currentDate, long plusMonth) {
        LocalDate nextMonth = currentDate.plusMonths(plusMonth);
        return nextMonth;
    }

    public static LocalDate getPreviousYear(LocalDate currentDate, long minusYear) {
        LocalDate previousYear = currentDate.minusYears(minusYear);
        return previousYear;
    }

    public static LocalDate getNextYear(LocalDate currentDate, long plusYear) {
        LocalDate nextYear = currentDate.plusYears(plusYear);
        return nextYear;
    }

    public static boolean validatePageScrollDown(WebElement lastElement) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        int locationBeforeScroll = lastElement.getLocation().getY();
        js.executeScript("arguments[0].scrollIntoView(true);", lastElement);
        int locationAfterScroll = lastElement.getLocation().getY();

        return (locationBeforeScroll != locationAfterScroll);
    }

    public static boolean validatePageScrollUp(WebElement firstElement) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        int locationBeforeScroll = firstElement.getLocation().getY();
        js.executeScript("arguments[0].scrollIntoView(true);", firstElement);
        int locationAfterScroll = firstElement.getLocation().getY();
        js.executeScript("arguments[0].scrollIntoView(true);", firstElement);

        return (locationBeforeScroll != locationAfterScroll);
    }

    public static void scrollUpUsingKeyboardKey() {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.sendKeys(Keys.UP).build().perform();
    }

    public static void scrollDownUsingKeyboardKey() {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.sendKeys(Keys.DOWN).build().perform();
    }

    public static void scrollDownUsingKeyboardKey(int keyPressCount) {
        Actions actions = new Actions(DriverManager.getDriver());
        for (int i = 0; i < keyPressCount; i++)
            actions.sendKeys(Keys.DOWN);
        actions.build().perform();
    }


    public static boolean validatePageScrollLeftAndRight(Locator rightRecord, Locator leftRecord) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        int locationBeforeScroll = ActionHelper.findElement(leftRecord).getLocation().getX();
        new Actions(DriverManager.getDriver()).moveToElement(ActionHelper.findElement(leftRecord)).click().build().perform();
        js.executeScript("arguments[0].scrollIntoView(true);", ActionHelper.findElement(rightRecord));
        new Actions(DriverManager.getDriver()).sendKeys(ActionHelper.findElement(rightRecord), Keys.ARROW_RIGHT).build().perform();
        int locationAfterScroll = ActionHelper.findElement(leftRecord).getLocation().getX();
        js.executeScript("arguments[0].scrollIntoView(true);", ActionHelper.findElement(leftRecord));
        return (locationBeforeScroll != locationAfterScroll);
    }

    public static boolean validatePageScrollLeftAndRight(WebElement fromElement, WebElement toElement) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", fromElement);
        int xCoordinateBeforeScroll = fromElement.getLocation().getX();
        js.executeScript("arguments[0].scrollIntoView(true);", toElement);
        int xCoordinateAfterScroll = toElement.getLocation().getX();
        return (xCoordinateBeforeScroll != xCoordinateAfterScroll);
    }

    public static void waitTillNoOfElementsToBe(Locator locator, int count, int timeoutInMilliSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeoutInMilliSeconds / 1000);
        wait.until(ExpectedConditions.numberOfElementsToBe(locator.getBy(), count));
    }

    public static void scrollUsingJS(By by) {
        WebDriver driver = DriverManager.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
    }


    public static void scrollUsingJSToTheLastElement(By by) {
        WebDriver driver = DriverManager.getDriver();
        List<WebElement> elements = driver.findElements(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elements.get(elements.size() - 1));
    }


    public static By addIndexingToXpath(By by, int index) {
        return By.xpath("(" + by.toString().split("By.xpath: ")[1] + ")[" + ++index + "]");
    }

    public static void clickIgnoringStaleElementReferenceException(By by, int pollingInterval) {
        Wait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(DriverManager.getExplicitWait()))
                .pollingEvery(Duration.ofSeconds(pollingInterval))
                .ignoring(ElementClickInterceptedException.class, StaleElementReferenceException.class);

        wait.until(driver -> {
            driver.findElement(by).click();
            return true;
        });
    }

    public static void clickIgnoringStaleElementReferenceException(By by, int index, int pollingInterval) {
        Wait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(DriverManager.getExplicitWait()))
                .pollingEvery(Duration.ofSeconds(pollingInterval))
                .ignoring(ElementClickInterceptedException.class, StaleElementReferenceException.class);

        wait.until(driver -> {
            driver.findElements(by).get(index).click();
            return true;
        });
    }

    public static void refreshPage() {
        DriverManager.getDriver().navigate().refresh();
    }

    public static void sendKeysWithClear(By by, String input) {
        if (input.length() >= 1) {
            WebDriver driver = DriverManager.getDriver();
            WebElement webElement = driver.findElement(by);
            webElement.click();
            Actions a = new Actions(DriverManager.getDriver());
            a.moveToElement(DriverManager.getDriver().findElement(by)).doubleClick();
            a.click().build().perform();
            webElement.sendKeys(new CharSequence[]{Keys.BACK_SPACE});
            webElement.sendKeys(new CharSequence[]{input});
        }
    }

    public static void acceptAlertIfPresent() {
        try {
            Alert alert = DriverManager.getDriver().switchTo().alert();
            acceptAlertIfPresent();
            alert.dismiss();
            alert.accept();
        } catch (Exception ignored) {

        }
    }

    public static void select_FromDropDown_List(By dropDownBtn, By optionsList_Locator, String option) {
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(ActionHelper.findElement(dropDownBtn)).click().sendKeys(option).perform();
        for (WebElement optionFromList : ActionHelper.findElements(optionsList_Locator)) {
            if (optionFromList.getText().toLowerCase().contains(option.toLowerCase())) {
                optionFromList.click();
                break;
            }
        }
    }

    public static boolean validateFileDownloadedSuccessfully(String downloadFolderPath, String fileName, int timeoutSeconds) {
        try {
            FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
                    .withTimeout(Duration.ofSeconds(timeoutSeconds))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(Exception.class);
            wait.until((x) -> {
                File[] files = new File(downloadFolderPath).listFiles();
                for (File file : files) {
                    if (file.getName().equals(fileName)) {
                        return true;
                    }
                }
                return false;
            });
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static String generateRandomString(int length) {
        String output = "";
        while (output.length() < length) output = output + new Faker().address().fullAddress();
        return output.substring(0, length);
    }

    public static String get_PostalCode_Txt() {
        String[] postalCode = {"201301", "506001", "110001", "201313", "845305", "233001", "225001", "243601", "204101", "221002",
                "450331", "464001", "462026", "456006", "416416", "641001", "638455", "571201", "580001", "743425", "700027", "788701", "781301"};
        int randomPostalCode = new Random().nextInt(postalCode.length);
        return postalCode[randomPostalCode];
    }

    public static String addNumbersInStringFormat(String... nos) {
        int total = 0;
        for (String no : nos) total = total + Integer.parseInt(no);
        return String.valueOf(total);
    }

    public static String getNextMonth(String month) {
        List<String> monthsList = List.of("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        int index = (monthsList.indexOf(month) + 1) % monthsList.size();
        return monthsList.get(index);
    }

    public static String getPreviousMonth(String month) {
        List<String> monthsList = List.of("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        int index = (monthsList.indexOf(month) + monthsList.size() - 1) % monthsList.size();
        return monthsList.get(index);
    }

    public static String getNextYear(String year) {
        return String.valueOf(Integer.parseInt(year) + 1);
    }

    public static String getPreviousYear(String year) {
        return String.valueOf(Integer.parseInt(year) - 1);
    }

    public static String getCustomCurrentDateFormatter(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, Locale.ENGLISH);
        return LocalDate.now().format(formatter);
    }

    public static boolean isChecked_Input_CheckBox(By by) {
        return isChecked_Input_CheckBox(ActionHelper.findElement(by));
    }

    public static boolean isChecked_Input_CheckBox(WebElement element) {
        return element.getAttribute("class").contains("checked");
    }

    public static void sendKeysWithClear(WebElement element, String input) {
        if (input.length() >= 1) {
            element.click();
            element.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.CONTROL, "a"})});
            element.sendKeys(new CharSequence[]{Keys.BACK_SPACE});
            element.sendKeys(new CharSequence[]{input});
        }
    }

    public static int getCurrentHourOfDay() {
        return new DateTime().getHourOfDay();
    }

    public static int getCurrentMinuteOfHour() {
        return new DateTime().getMinuteOfHour();
    }

    public static boolean isRadioSelected(By by) {
        return isRadioSelected(ActionHelper.findElement(by));
    }

    public static boolean isRadioSelected(WebElement element) {
        return element.isSelected();
    }

    public static void scrollRightUsingKeyboardKey(int keyPressCount) {
        Actions actions = new Actions(DriverManager.getDriver());
        for (int i = 0; i < keyPressCount; i++)
            actions.sendKeys(Keys.RIGHT);
        actions.build().perform();
    }
}
