package starter.Utility;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import javax.annotation.Nullable;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ReusableUtilities extends PageObject {

    public void doubleClick(By element) {
        Actions a = new Actions(Serenity.getDriver());
        a.moveToElement($(element)).doubleClick().build().perform();
    }

    public String getTheTodayDateWithRequiredFormat(String formatterText){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatterText);
        return today.format(formatter);
    }

    public String getTheInnerTextOfActiveElement(){
        return (String) ((JavascriptExecutor) Serenity.getDriver()).executeScript(
                "return arguments[0].value || arguments[0].innerText;",
                Serenity.getDriver().switchTo().activeElement()
        );
    }

    public <T> boolean compareTwoLists(java.util.List<T> list1, java.util.List<T> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        java.util.List<T> tempList = new ArrayList<>(list2);
        for (T element : list1) {
            if (!tempList.remove(element)) {
                return false;
            }
        }

        return true;
    }

    public String getTodayDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy");
        return today.format(formatter);
    }

    public String getTomorrowDate() {
        LocalDate today = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy");
        return today.format(formatter);
    }

    public String DateConverter (String inputDateString){
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm:ss a");
            LocalDateTime inputDateTime = LocalDateTime.parse(inputDateString, inputFormatter);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            String outputDateString = inputDateTime.format(outputFormatter);
            System.out.println("Converted date: " + outputDateString);
            return outputDateString;
    }


    public void deSelectFromDropDown(WebElement dropDown, String visibleText) {
        Select select = new Select(dropDown);
        select.deselectByVisibleText(visibleText);
    }

    public void pressAndHoldControl(WebElement element) {
        Actions action = new Actions(Serenity.getDriver());
        action.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build().perform();
    }

    public String pasteClipboard() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor flavor = DataFlavor.stringFlavor;
        String text = "";
        if (clipboard.isDataFlavorAvailable(flavor)) {
            try {
                text = (String) clipboard.getData(flavor);
                System.out.println(text);
            } catch (UnsupportedFlavorException | IOException e) {
                System.out.println(e);
            }
        }
        return text;
    }

    public void clickByJavaScript(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) Serenity.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }


    public void rightClick(By element) {
        Actions action = new Actions(Serenity.getDriver());
        WebElement link = Serenity.getDriver().findElement(element);
        action.contextClick(link).perform();
    }

    public void mouseHover(WebElement element) {
        Actions action = new Actions(Serenity.getDriver());
        action.moveToElement(element);
    }

    public void pressEnter(By element) {
        Serenity.getDriver().findElement(element).sendKeys(Keys.ENTER);
    }

    public void pressEnterWithoutElement() {
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    public void pressTab() {
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
    }

    public void pressShiftTab() {
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.SHIFT, Keys.TAB);
    }

    public void pressZoomOut() {
        $(Serenity.getDriver().findElement(By.tagName("html"))).sendKeys(Keys.CONTROL, Keys.SUBTRACT);
    }

    public void setBrowserZoom(int i) {
        ((JavascriptExecutor) Serenity.getDriver()).executeScript("document.body.style.zoom='" + i + "%';");
    }

    public void pressControlA() {
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.CONTROL, "a");
    }

    public void pressBackspace() {
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
    }

    public void pressDelete() {
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.DELETE);
    }

    public void pressEnd() {
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.END);
    }

    public void pressRightNavigation() {
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.RIGHT);
    }

    public void pressLeftNavigation() {
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.LEFT);
    }

    public void pressDownNavigation() {
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.DOWN);
    }

    public void pressUpNavigation() {
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.UP);
    }

    public void pressEscape() {
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.ESCAPE);
    }

    public void pressShiftDown() {
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.SHIFT, Keys.DOWN);
    }

    public void pressControlClick(By element) {
        Actions actions = new Actions(Serenity.getDriver());
        actions.keyDown(Keys.LEFT_CONTROL)
                .click($(element))
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }

    public void conditionalWait(String waitType, By element, String Text) {
        switch (waitType) {
            case "visibility":
                withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(element);
                break;
            case "invisibility":
                withTimeoutOf(100, TimeUnit.SECONDS).waitForElementsToDisappear(element);
                break;
        }
    }

    public void performAction(String objectType, WebElement obj, String value) {

        if (objectType.equalsIgnoreCase("Text")) {
            $(obj).waitUntilClickable().clear();
            $(obj).waitUntilClickable().sendKeys(value);
        } else if (objectType.equalsIgnoreCase("Button")) {
            $(obj).waitUntilClickable().click();
        } else if (objectType.equalsIgnoreCase("Select")) {
            $(obj).selectByVisibleText(value);
        } else {
            $(obj).waitUntilClickable().click();
        }
    }

    public void scrollToAnElement(By element) {
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", $(element));
    }

    public String getValueThroughJS(By name) {
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        String s = (String) js.executeScript("return document.getElementsByName('" + name + "')[0].value");
        return s;
    }

    public void uploadFile(By element, String fileLink) throws InterruptedException, AWTException {
        //upload(fileLink).to(find(element));
        WebElement browse = Serenity.getDriver().findElement(element);
        // using linkText, to click on browse element
        browse.click(); // Click on browse option on the webpage
        Thread.sleep(2000); // suspending execution for specified time period

        // creating object of Robot class
        Robot rb = new Robot();

        // copying File path to Clipboard
        StringSelection str = new StringSelection(fileLink);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Control+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    public void waitmethods(String locator, WebElement element, String text, int index) {
        String waittype = null;

        switch (waittype) {
            case "elementclickable":
                waitForCondition().until(ExpectedConditions.elementToBeClickable(element));
                break;
            case "alertpresent":
                waitForCondition().until(ExpectedConditions.alertIsPresent());
                break;
            case "invisibility":
                waitForCondition().until(ExpectedConditions.invisibilityOf(element));
                break;
            case "checktext":
                waitForCondition().until(ExpectedConditions.titleIs(text));
                break;
            case "frameavailabilty":
                waitForCondition().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
                break;
            case "visibility":
                waitForCondition().until(ExpectedConditions.visibilityOf(element));
                break;

        }
    }

    public void fluentwaitmethods(String locator, WebElement element, String text, int index, int timeout, int duration) {
        String waittype = null;

        switch (waittype) {
            case "elementclickable":
                waitForCondition().withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(duration)).until(ExpectedConditions.elementToBeClickable(element));
                break;
            case "alertpresent":
                waitForCondition().withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(duration)).until(ExpectedConditions.alertIsPresent());
                break;
            case "invisibility":
                waitForCondition().withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(duration)).until(ExpectedConditions.invisibilityOf(element));
                break;
            case "checktext":
                waitForCondition().withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(duration)).until(ExpectedConditions.titleIs(text));
                break;
            case "frameavailabilty":
                waitForCondition().withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(duration)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
                break;
            case "visibility":
                waitForCondition().withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(duration)).until(ExpectedConditions.visibilityOf(element));
                break;


        }
    }


    public void insertValueOnActiveItem(WebElement obj, String value) {
        int counter = 0;
        while (counter < 3) {
            try {
                $(obj).waitUntilClickable().click();
                Serenity.getDriver().switchTo().activeElement().sendKeys(value);
            } catch (NoSuchElementException e) {
                counter = counter + 1;
            }
            if (counter == 2)
                break;
        }
    }

    public void switchFrame(@Nullable WebElement obj, String nameORid, int index) {
        if (obj != null) {
            Serenity.getDriver().switchTo().frame(obj);
        }
        if (nameORid != "") {
            Serenity.getDriver().switchTo().frame(nameORid);
        }
        if (index > 0) {
            Serenity.getDriver().switchTo().frame(index);
        }
    }

    public String getObjectProperty(WebElement obj, String propertyName) {
        String prop = "";
        if (propertyName.equalsIgnoreCase("Text")) {
            prop = $(obj).getText().toString().trim();
        } else if (propertyName.equalsIgnoreCase("Tag")) {
            prop = $(obj).getTagName().toString().trim();
        } else if (propertyName.equalsIgnoreCase("Value")) {
            prop = $(obj).getValue().toString().trim();
        } else if (propertyName.equalsIgnoreCase("textContent")) {
            prop = $(obj).getAttribute("textContent").toString().trim();
        } else {
            prop = $(obj).getAttribute(propertyName).toString().trim();
        }
        return prop;
    }

    public void clickUsingJavaScriptExecutor(WebElement obj) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
            js.executeScript("arguments[0].click();", obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectingClassification(By selectOption) {
        doubleClick(selectOption);
        Serenity.getDriver().switchTo().parentFrame();
    }

    public void selectingItem(By searchOption, By selectOption, By okButton, String itemName) {
        $(searchOption).clear();
        performAction("text", $(searchOption), itemName);
        pressEnter(searchOption);
        conditionalWait("visibility", selectOption, "");
        performAction("button", $(selectOption), "");
        performAction("button", $(okButton), "");
        Serenity.getDriver().switchTo().parentFrame();
    }

    public void windowHandling() {
        String mainWindowHandle = Serenity.getDriver().getWindowHandle();
        Set<String> allWindowHandles = Serenity.getDriver().getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                Serenity.getDriver().switchTo().window(ChildWindow);
            }
            Serenity.getDriver().close();
            Serenity.getDriver().switchTo().window(mainWindowHandle);
        }
    }

    public void pressAltTab() {
        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_TAB);

            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_ALT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectEffectiveDate(By calender, By iframe, By nextMonthButton, By year, By previousYearButton, By month, By date) {
        performAction("Button", $(calender), "");
        Serenity.getDriver().switchTo().parentFrame();
        conditionalWait("Visibility", iframe, "");
        switchFrame($(iframe), "", 0);
        conditionalWait("Visibility", nextMonthButton, "");
        if ($(year).isCurrentlyVisible()) {
            performAction("Button", $(year), "");
        } else {
            while (!$(year).isCurrentlyVisible()) {
                performAction("Button", $(previousYearButton), "");
                if ($(year).isCurrentlyVisible()) {
                    performAction("Button", $(year), "");
                    break;
                }
            }
        }
        waitABit(4000);
        if (!$(month).isCurrentlyVisible()) {
            while (!$(month).isCurrentlyVisible()) {
                performAction("Button", $(nextMonthButton), "");
                waitABit(2000);
                if ($(month).isCurrentlyVisible()) {
                    break;
                }
            }
        }
        conditionalWait("Visibility", date, "");
        doubleClick(date);
        waitABit(5000);
        Serenity.getDriver().switchTo().defaultContent();
    }

    public void moveToAnElementAndClick(WebElement element) {
        Actions actions = new Actions(Serenity.getDriver());
        actions.moveToElement(element).click();
    }


}