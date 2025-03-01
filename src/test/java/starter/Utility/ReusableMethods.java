package starter.Utility;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.PageObjectsPages.Develop.PartPageDev;
import starter.PageObjectsPages.Develop.QCSPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ReusableMethods extends PageObject {

    ReusableUtilities reusableUtilities;

    public static @FindBy(xpath = "//div[@id='pmi_templateplatformMultiList']/a/span") WebElementFacade technologyPlatformFieldButton;

    public static @FindBy(xpath = "//div[@id='pmi_itemtypeMultiList']/a/span") WebElementFacade itemTypeFieldButton;

    public static @FindBy(xpath = "//*[@id='pmi_templateplatformMultiList']/div//span[@class='dropdown-search']/input") WebElementFacade dropDownSearchFieldForTechnologyPlatform;

    public static @FindBy(xpath = "//*[@id='pmi_itemtypeMultiList']/div//span[@class='dropdown-search']/input") WebElementFacade dropDownSearchFieldForItemType;

    public static @FindBy(xpath = "//div[@id='pmi_templateplatformMultiList']//a[@class='dropdown-clear-all']") WebElementFacade technologyPlatformDropDownClear;

    public static @FindBy(xpath = "//div[@id='pmi_itemtypeMultiList']//a[@class='dropdown-clear-all']") WebElementFacade itemTypeDropDownClear;

    public static @FindBy(xpath = "//div[@id='pmi_templateplatformMultiList']//span[@class='dropdown-selected']") List<WebElementFacade> getTheSelectedTechnologyList;

    public static @FindBy(xpath = "//div[@id='pmi_itemtypeMultiList']//span[@class='dropdown-selected']") List<WebElementFacade> getTheSelectedItemTypeList;

    public static @FindBy(xpath = "//*[@id='pmi_templateplatformMultiList']/div//span[@class='dropdown-search']/input") WebElementFacade dropDownSearchTechnologyPlatform;

    public static @FindBy(xpath = "//button[@title='Add Files']") WebElementFacade addAttachmentBtn;

    public static @FindBy(xpath = "//button[@title='Delete pmi_QCSAttachments']") WebElementFacade deleteAttachmentBtnForQcs;

    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr") List<WebElementFacade> tableRows;

    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[1]/div/table/tr/td[2]") List<WebElementFacade> firstResults;

    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[1]/div/table/tr[2]/td[2]") WebElementFacade secondResults;

    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[2]") WebElementFacade tableRowFirstElement;

    public static @FindBy(xpath = "//button[@class='aras-button aras-button_primary aras-buttons-bar__button']") WebElementFacade searchOkButton;

    public static @FindBy(xpath = "//button[@title='Run Search']") WebElementFacade runSearchButton;

    public static @FindBy(xpath = "//iframe[@class='content-block__iframe']") WebElementFacade parentFrame;
    public static @FindBy(xpath = "(//iframe[@class='content-block__iframe'])[2]") WebElementFacade parentFrameForSecondTab;

    public static @FindBy(xpath = "//iframe[@id='instance']") WebElementFacade childFrame;

    public static @FindBy(xpath = "//*[@class='aras-dialog__iframe']") WebElementFacade dialogueFrame;

    public static @FindBy(xpath = "//button[@title='Save']") WebElementFacade saveButton;

    public static @FindBy(xpath = "//button[@title='Clear Search Criteria']") WebElementFacade clearSearchCriteria;
    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li[1]/span[1]") WebElementFacade closeTheFirstOpenedTab;
    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li[2]/span[1]") WebElementFacade TheSecondOpenedTab;

    public static @FindBy(xpath = "//button[@title='Edit']") WebElementFacade editButton;
    public static @FindBy(xpath = "(//button[@title='Edit'])[2]") WebElementFacade editButtonInSecondTab;

    public static @FindBy(xpath = "//span[@class='aras-dialog-alert__text']") WebElementFacade errorMessage;

    public static By arasSpinner = By.cssSelector("iframe#dimmer_spinner");
    Actions actions = new Actions(Serenity.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();

    public void selectMultipleTechnologyPlatforms(String[] technologyPlatformOptions) {
        $(technologyPlatformFieldButton).click();  // Click the Technology Platform field to open the dropdown

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(dropDownSearchFieldForTechnologyPlatform); // Wait for the dropdown search field to appear

        $(dropDownSearchFieldForTechnologyPlatform).sendKeys(technologyPlatformOptions[0].trim());  // Select the first technology platform from the dropdown

        withTimeoutOf(Duration.ofSeconds(100))
                .waitFor(By.xpath("//li[text()='" + technologyPlatformOptions[0].trim() + "']"));
        waitABit(2000);

        $(By.xpath("//li[text()='" + technologyPlatformOptions[0].trim() + "']")).click();

        for (int i = 1; i < technologyPlatformOptions.length; i++) { // Loop through the remaining technology platform options

            String currentSearchText = $(dropDownSearchFieldForTechnologyPlatform).getAttribute("value").trim(); // Clear the previous search text in the dropdown search field

            for (int j = 0; j < currentSearchText.length(); j++) {
                $(dropDownSearchFieldForTechnologyPlatform).sendKeys(Keys.BACK_SPACE);
            }

            $(dropDownSearchFieldForTechnologyPlatform).sendKeys(technologyPlatformOptions[i].trim()); // Search for and select the next technology platform

            withTimeoutOf(Duration.ofSeconds(100))
                    .waitFor(By.xpath("//li[text()='" + technologyPlatformOptions[i].trim() + "']"));
            waitABit(2000);

            $(By.xpath("//li[text()='" + technologyPlatformOptions[i].trim() + "']")).click();
        }
    }

    public void selectMultipleItemTypes(String[] itemTypeOptions) {
        $(itemTypeFieldButton).click(); // Click on the Item Type field to activate the dropdown

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(dropDownSearchFieldForItemType); // Wait for the dropdown search input field to appear

        $(dropDownSearchFieldForItemType).sendKeys(itemTypeOptions[0].trim()); // Select the first item type from the dropdown

        withTimeoutOf(Duration.ofSeconds(100))
                .waitFor(By.xpath("//li[text()='" + itemTypeOptions[0].trim() + "']"));
        waitABit(2000);

        $(By.xpath("//li[text()='" + itemTypeOptions[0].trim() + "']")).click();


        for (int i = 1; i < itemTypeOptions.length; i++) { // Loop through the remaining item type options

            String currentSearchText = $(dropDownSearchFieldForItemType).getAttribute("value").trim(); // Clear the existing search text in the dropdown field
            System.out.println(currentSearchText + " : Current search text for Item Types");

            for (int j = 0; j < currentSearchText.length(); j++) {
                $(dropDownSearchFieldForItemType).sendKeys(Keys.BACK_SPACE);
            }

            $(dropDownSearchFieldForItemType).sendKeys(itemTypeOptions[i].trim()); // Search for and select the next item type

            withTimeoutOf(Duration.ofSeconds(100))
                    .waitFor(By.xpath("//li[text()='" + itemTypeOptions[i].trim() + "']"));
            waitABit(2000);

            $(By.xpath("//li[text()='" + itemTypeOptions[i].trim() + "']")).click();
        }
    }

    public void clearMultiListAndUpdateWithNewList(String listName, String[] newListValues, WebElementFacade dropDownClear, WebElementFacade listFieldBtn) {
        waitUntilElementVisible(listFieldBtn).click();
        waitUntilElementVisible(dropDownClear).click();
        if (listName.equalsIgnoreCase("technologyPlatforms")) {
            selectMultipleTechnologyPlatforms(newListValues);
        } else if (listName.equalsIgnoreCase("itemTypes")) {
            selectMultipleItemTypes(newListValues);
        }
    }

    public void validateSelectedValues(List<WebElementFacade> selectedValues, String[] expectedValues, String itemName) {

        List<String> selectedValuesList = selectedValues.stream()
                .map(WebElementFacade::getText)// Convert selected values to a list of strings
                .collect(Collectors.toList());

        List<String> expectedList = Arrays.asList(expectedValues); // Convert expected values array to a list for easy comparison

        if (selectedValuesList.size() != expectedList.size()) { // Check if the sizes match
            Assert.fail("Number of selected values for " + itemName + " does not match the expected number.");
        }

        if (selectedValuesList.equals(expectedList)) { // Compare the lists directly
            System.out.println(itemName + ": Values are correctly updated.");
        } else {
            Assert.fail(itemName + ": Values are not updated. Edit failed. Actual: "
                    + selectedValuesList + " Expected: " + expectedList);
        }
    }


    public void validateAddingAndRemovingAttachments(WebElementFacade attachmentRelationshipFrame) {
        switchToAttachmentTabFrame(attachmentRelationshipFrame);

        waitUntilElementVisible(addAttachmentBtn).click(); // Click 'Add Attachment' button and track attachment count before adding
        int attachmentCountBeforeAdding = tableRows.size();

        switchToDialogFrame();  // Switch to the dialog frame for searching attachments
        waitUntilElementVisible(clearSearchCriteria).click();
        waitABit(2000);
        waitUntilElementVisible(runSearchButton).click();

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(firstResults); // Wait for search results
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(secondResults);

        reusableUtilities.pressAndHoldControl($(secondResults));     // Select the second search result
        waitUntilElementVisible(searchOkButton).click();

        Serenity.getDriver().switchTo().parentFrame(); // Switch back to parent frame and save the changes
        waitUntilElementVisible(saveButton).click();

        switchToAttachmentTabFrame(attachmentRelationshipFrame); // Switch back to the attachment tab frame and validate the attachment count
        List<WebElementFacade> attachmentRows = tableRows;
        Assert.assertEquals("Attachments should be added to the tab", 2 + attachmentCountBeforeAdding, attachmentRows.size());

        waitUntilElementVisible(tableRowFirstElement).click(); // Remove the first attachment and verify the attachment count again
        waitUntilElementVisible(deleteAttachmentBtnForQcs).click();
        Serenity.getDriver().switchTo().parentFrame();
        waitUntilElementVisible(saveButton).click();

        switchToAttachmentTabFrame(attachmentRelationshipFrame); // Switch back to the attachment tab frame and validate that one attachment is removed
        waitABit(4000); // Optional delay, depending on UI behavior
        attachmentRows = tableRows;
        Assert.assertEquals("Attachments should be removed from the tab", 1 + attachmentCountBeforeAdding, attachmentRows.size());
    }

    public void searchItemByCode(WebElementFacade itemCodeFieldWebElement, String itemCode) {
        switchToSearchSectionFrame(itemCodeFieldWebElement);
        clearSearchFields();
        enterItemCodeAndSearch(itemCodeFieldWebElement, itemCode);
        selectSearchResult(itemCode);
        closeFirstOpenedTab();
    }

    public void searchItemByCodeForMassSearch(WebElementFacade itemCodeFieldWebElement, String itemCode) {
        switchToSearchSectionFrame(itemCodeFieldWebElement);
        clearSearchFields();
        enterItemCodeAndSearchForMassSearch(itemCodeFieldWebElement, itemCode);
    }

    public static String waitForResponseWithSearch(By responseLocator, By searchButtonLocator, int timeoutInMinutes) {
        WebDriver driver = Serenity.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        int elapsedMinutes = 0;

        while (elapsedMinutes < timeoutInMinutes) {
            try {
                // Check if the response element is visible
                WebElementFacade responseElement = (WebElementFacade) wait.until(ExpectedConditions.visibilityOfElementLocated(responseLocator));
                // If visible, return the response text
                return responseElement.getText();
            } catch (Exception e) {
                // If not visible, click the search button
                System.out.println("Element not visible. Clicking the search button...");
                driver.findElement(searchButtonLocator).click();
                // Wait for 1 minute before checking again
                try {
                    Thread.sleep(Duration.ofMinutes(1).toMillis());
                } catch (InterruptedException ex) {
                    throw new RuntimeException("Thread sleep interrupted", ex);
                }
                elapsedMinutes++;
            }
        }

        throw new RuntimeException("Timeout: Element text not visible after " + timeoutInMinutes + " minutes.");
    }

    private void switchToAttachmentTabFrame(WebElementFacade attachmentRelationshipFrame) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(attachmentRelationshipFrame);
    }

    private void switchToDialogFrame() {
        Serenity.getDriver().switchTo().parentFrame().switchTo().frame(dialogueFrame);
    }

    public WebElementFacade waitUntilElementVisible(WebElementFacade element) {
        return withTimeoutOf(Duration.ofSeconds(800)).waitFor(element);
    }

    private void switchToSearchSectionFrame(WebElementFacade itemCodeField) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
    }

    private void clearSearchFields() {
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(clearSearchCriteria);
        $(clearSearchCriteria).click();
        waitABit(2000); // Optional wait
    }

    private void enterItemCodeAndSearch(WebElementFacade itemCodeFieldWebElement, String itemCode) {
        waitUntilElementVisible(itemCodeFieldWebElement).click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type(itemCode);
        waitUntilElementVisible(runSearchButton).click();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//*[text()='" + itemCode + "']"));
    }

    private void enterItemCodeAndSearchForMassSearch(WebElementFacade itemCodeFieldWebElement, String itemCode) {
        waitUntilElementVisible(itemCodeFieldWebElement).click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type(itemCode);
        waitUntilElementVisible(runSearchButton).click();
        waitABit(7000);
    }

    private void selectSearchResult(String itemCode) {
        actions.moveToElement($(By.xpath("//*[text()='" + itemCode + "']"))).doubleClick().build().perform();
    }

    public void closeFirstOpenedTab() {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(TheSecondOpenedTab);
        waitABit(2000);
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(closeTheFirstOpenedTab).click();
    }

    public void closeSecondOpenedTab() {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(TheSecondOpenedTab).click();
        waitABit(2000);
    }

    public void clickOnEdit() {
        try {
            WebDriver driver = Serenity.getDriver();
            driver.switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(parentFrame);
            driver.switchTo().frame(parentFrame);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();

        } catch (Exception e) {
            if ($(errorMessage).isCurrentlyVisible()) {
                $(QCSPage.alertOkButton).click();
                if ($(editButton).isCurrentlyVisible()) {
                    $(editButton).click();
                }
            }
        }
    }

    public void clickOnEditForSecondTab() {
        try {
            WebDriver driver = Serenity.getDriver();
            driver.switchTo().defaultContent().switchTo().frame(parentFrameForSecondTab);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();

        } catch (Exception e) {
            if ($(errorMessage).isCurrentlyVisible()) {
                $(QCSPage.alertOkButton).click();
                if ($(editButton).isCurrentlyVisible()) {
                    $(editButton).click();
                }
            }
        }
    }

    public void recordReportData(String title, String content) {
        Serenity.recordReportData()
                .withTitle(title)
                .andContents(content);
    }

    public void waitUntilArasSpinnerToDisappear() {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(180, TimeUnit.SECONDS).waitForElementsToDisappear(arasSpinner);
    }


}



