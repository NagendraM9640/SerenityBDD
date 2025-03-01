package starter.PageObjectsPages;

import io.cucumber.java.eo.Se;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import starter.PageObjectsPages.Develop.ItemCodeStore;
import starter.PageObjectsPages.Develop.PartPageDev;
import starter.PageObjectsPages.Develop.QCSPage;
import starter.Utility.ExcelUtilities;
import starter.Utility.ReusableUtilities;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MigratedDataMSpecPage extends PageObject {

    ARAS_HomePage home = new ARAS_HomePage();
    ReusableUtilities reusableUtilities = new ReusableUtilities();
    ARASLoginPageObjects arasLoginPageObjects = new ARASLoginPageObjects();
    ARAS_HomePage arasHomePage = new ARAS_HomePage();
    PartPageDev partPage = new PartPageDev();
    Actions action = new Actions(Serenity.getDriver());
    public static @FindBy(xpath = "//td[@data-head-id='item_number_D']") WebElementFacade itemCodeFieldInSearchMspec;
    public static @FindBy(xpath = "(//td[contains(text(), 'Active')]/ancestor::tr[1]/td[3])[position() > 1]") WebElementFacade assignedTo;
    public static @FindBy(xpath = "(//td[contains(text(), 'Active')])[position() > 1]") WebElementFacade activeButton;

    public static @FindBy(xpath = "//iframe[@class='content-block__iframe']") WebElementFacade parentFrame;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_item_number_D']") WebElementFacade mcoNumberField;
    public static @FindBy(xpath = "//span[@class='sys_item_link pmi_ebom_item']") WebElementFacade eBOMItemLink;
    public static @FindBy(xpath = "//input[@name='major_rev']") WebElementFacade revisionField;

    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr") List<WebElementFacade> tableRows;
    public static @FindBy(xpath = "(//iframe[@class='content-block__iframe'])[2]") WebElementFacade secondParentFrame;
    public static @FindBy(xpath = "//iframe[@title='pmi_LocalPartParameters Relationship']") WebElementFacade parametersFrame;
    public static @FindBy(xpath = "//iframe[@title='pmi_LocalPartBOM Relationship']") WebElementFacade BOMTabIframe;
    public static @FindBy(xpath = "//button[@title='Add mSpec BOM']") WebElementFacade addMspec;
    public static @FindBy(xpath = "(//iframe[@class='content-block__iframe'])[3]") WebElementFacade thirdParentFrame;
    public static @FindBy(xpath = "//span[text()='Apply']") WebElementFacade ApplyButton;
    public static @FindBy(xpath = "//*[@name='pmi_item_number']") WebElementFacade mSpecItemCode;
    public static @FindBy(xpath = "//input[@name='pmi_plant']") WebElementFacade plantNameField;
    public static @FindBy(xpath = "//select[@name='pmi_change_drivers']") WebElementFacade changeDriversField;
    public static @FindBy(xpath = "//iframe[@title='pmi_mSpecMCO_AffectedItem Relationship']") WebElementFacade mSpecMCOAffectedItemRelationshipIframe;
    public static @FindBy(xpath = "//button[@title='Add mSpec MCO Affected Items']") WebElementFacade addMspecMCOAffectedItems;
    public static @FindBy(xpath = "//select[@title='ItemType']") WebElementFacade itemTypeInSearch;
    public static @FindBy(xpath = "//td[@data-head-id='item_number_D']") WebElementFacade itemNumberInSearch;
    public static @FindBy(xpath = "//td[@data-head-id='item_number_R']") WebElementFacade itemCodeInSearch;

    public static @FindBy(xpath = "//button[@class='aras-button aras-button_primary aras-buttons-bar__button']") WebElementFacade arasSearchOkButton;

    public static @FindBy(xpath = "//iframe[@id='instance']") WebElementFacade childFrame;

    public static @FindBy(xpath = "(//*[@class='aras-grid-row-cell '])[1]") WebElementFacade searchResults;

    public static @FindBy(xpath = "//*[text()='OK']") WebElementFacade ok;

    public static @FindBy(xpath = "//*[text()='Done']") WebElementFacade doneButton;

    public static @FindBy(xpath = "//button[@title='Clear Search Criteria']") WebElementFacade clearSearchCriteria;

    public static @FindBy(xpath = "//iframe[@class='aras-dialog__iframe']") WebElementFacade dialogueFrame;

    public static @FindBy(xpath = "//iframe[contains(@name,'innovator_')]") WebElementFacade newFrameForCreatePartFrame;

    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li[1]/span[1]") WebElementFacade closeFirstTab;
    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li[2]/span[1]") WebElementFacade closeSecondTab;
    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li[3]/span[1]") WebElementFacade closeThirdTab;

    public static @FindBy(xpath = "//button[@title='Run Search']") WebElementFacade runSearchButton;

    public static @FindBy(xpath = "//button[@title='Save']") WebElementFacade saveButton;
    public static @FindBy(xpath = "//input[@name='pmi_item_number']") WebElementFacade mcoNumber;
    public static ByShadow calanderSwitchButton = ByShadow.cssSelector("div.aras-calendar__switch>button", "aras-calendar.aras-calendar");
    public static ByShadow calanderGrids = ByShadow.cssSelector("div.aras-calendar__grid>div", "aras-calendar.aras-calendar");

    WebDriver driver = Serenity.getDriver();
    List<String> eBomRevisions = new ArrayList<>();
    JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();

    public void addEffectivityDate(String date) {
        String day = date.trim().split("-")[0];
        String month = date.trim().split("-")[1];
        String year = date.trim().split("-")[2];
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(240)).waitFor(parentFrame);
        Serenity.getDriver().switchTo().frame(parentFrame).switchTo().frame(MigratedDataPartPage.childFrame);
        withTimeoutOf(Duration.ofSeconds(240)).waitFor(QCSPage.Objects.effectiveDateSelector.objects).click();
        waitABit(3000);
        Serenity.getDriver().switchTo().parentFrame();
        String currentText = $(calanderSwitchButton).getAttribute("outerText").toString().trim();
        if (currentText.contains(month) && currentText.contains(year)) {
            waitABit(2000);
        } else if (currentText.contains(month) && !currentText.contains(year)) {
            evaluateJavascript("arguments[0].click();", $(calanderSwitchButton));
            waitABit(3000);
            List<WebElementFacade> Month = findAll(calanderGrids);
            for (WebElementFacade object : Month) {
                if (object.getAttribute("textContent").trim().equalsIgnoreCase(month.substring(0, 3))) {
                    evaluateJavascript("arguments[0].click();", object);
                    break;
                }
            }
        } else if (!currentText.contains(month) && !currentText.contains(year)) {
            evaluateJavascript("arguments[0].click();", $(calanderSwitchButton));
            waitABit(4000);
            evaluateJavascript("arguments[0].click();", $(calanderSwitchButton));
            WebElementFacade Year = $(ByShadow.cssSelector("div[data-value='" + year + "']", "aras-calendar.aras-calendar"));
            evaluateJavascript("arguments[0].click();", Year);
            waitABit(4000);
            List<WebElementFacade> Month = findAll(calanderGrids);
            for (WebElementFacade object : Month) {
                if (object.getAttribute("textContent").trim().equalsIgnoreCase(month.substring(0, 3))) {
                    evaluateJavascript("arguments[0].click();", object);
                    break;
                }
            }
        }
        waitABit(4000);
        List<WebElementFacade> Day = findAll(ByShadow.cssSelector("div[data-value='" + day + "']", "aras-calendar.aras-calendar"));
        evaluateJavascript("arguments[0].click();", Day.get(Day.size() - 1));
        waitABit(5000);
        Serenity.takeScreenshot();
        ApplyButton.click();
    }

    public List<String> searchWithMSpecItemCodeAndFetchEBOMRevisionAndStoreIt(String itemCodeCriteria, List<String> itemCodes) {
        try {
            driver.switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(parentFrame);
            driver.switchTo().frame(parentFrame);
            withTimeoutOf(Duration.ofSeconds(90)).waitFor(MigratedDataPartPages.clearSearchCriteria).click();
            waitABit(2000);
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(itemCodeFieldInSearchMspec).click();
            $(driver.switchTo().activeElement()).type(itemCodeCriteria);
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(MigratedDataPartPages.runSearchButton).click();
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(MigratedDataPartPages.searchResultsInGrid);
            waitABit(10000);
            itemCodes.forEach(code -> {
                String revision = $(By.xpath("//td[text()='" + code + "']//following-sibling::td[8]")).getAttribute("textContent");
                System.out.println("mSpecCode: " + code + "And It's eBOM Rev is: " + revision);
                eBomRevisions.add(revision);
            });

            System.out.println(eBomRevisions + " :eBOM Rev List");

        } catch (Exception e) {
            System.err.println("Error during search mSpec and fetch eBOM Revision: " + e.getMessage());
        }
        return eBomRevisions;
    }

    public void refreshThePageAndNavigateMCOCreatePage() {
        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
            Serenity.getDriver().navigate().refresh();
            waitABit(5000);
            home.verifyHomePage();
            home.navigating("Change Management/MCOs/Create New MCO");
        } catch (Exception e) {
            System.err.println("Error during page refresh and navigation: " + e.getMessage());
        }
    }

    public void createTheMCOWithRequiredDetails(String plantName, String changeDesc, String changeDrivers, String searchCriteria) throws Exception {
        System.out.println(reusableUtilities.getTomorrowDate() + " Tomorrows Date");
        addEffectivityDate(reusableUtilities.getTomorrowDate());
        driver.switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(240)).waitFor(parentFrame);
        driver.switchTo().frame(parentFrame);
        withTimeoutOf(Duration.ofSeconds(240)).waitFor(MigratedDataPartPage.childFrame);
        driver.switchTo().frame(MigratedDataPartPage.childFrame);
        plantNameField.sendKeys(plantName);
        $("").sendKeys(changeDesc);
        changeDriversField.selectByVisibleText(changeDrivers);
    }

    public String addMspecsToTheMCO(String mSpecSearchCriteria) throws Exception {
        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(mSpecMCOAffectedItemRelationshipIframe);
            js.executeScript("arguments[0].scrollIntoView();", $(addMspecMCOAffectedItems));
            $(addMspecMCOAffectedItems).click();
            Serenity.getDriver().switchTo().parentFrame().switchTo().frame(dialogueFrame);
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(itemTypeInSearch);
            reusableUtilities.selectFromDropdown($(itemTypeInSearch), "mSpec");
            waitABit(3000);
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(clearSearchCriteria);
            waitABit(3000);
            $(clearSearchCriteria).click();
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(itemNumberInSearch);
            $(itemNumberInSearch).click();
            $(Serenity.getDriver().switchTo().activeElement()).type(mSpecSearchCriteria);
            waitABit(2000);
            reusableUtilities.pressShiftTab();
            waitABit(2000);
            $(Serenity.getDriver().switchTo().activeElement()).type("Released");
            waitABit(1000);
            $(runSearchButton).click();
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(searchResults);
            reusableUtilities.pressControlA();
            $(arasSearchOkButton).click();
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
            doneButton.click();
            waitABit(5000);
            Serenity.getDriver().switchTo().frame(childFrame);
            System.out.println("MCO Number: " + mcoNumber.getAttribute("value"));
            return mcoNumber.getAttribute("value");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Something wrong while search and add mSpecs in MCO" + e.getMessage());
        }

    }

    public List<String> userFillEBomRevisionAndNewLifecycleFields(List<String> itemCodes) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(mSpecMCOAffectedItemRelationshipIframe);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(MigratedDataPartPages.searchModesInSearchDialogue).selectByVisibleText("Simple");
        itemCodes.forEach(itemCode -> {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(mSpecMCOAffectedItemRelationshipIframe);
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(MigratedDataPartPages.clearSearchCriteria).click();
            waitABit(2000);
            itemCodeInSearch.click();
            $(Serenity.getDriver().switchTo().activeElement()).type(itemCode + "*");
            runSearchButton.click();
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(MigratedDataPartPages.searchResultsInGrid);
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(By.xpath("//td[text()='" + itemCode + "']//following-sibling::td[5]/span")).waitUntilClickable().click();
            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(secondParentFrame);
            Serenity.getDriver().switchTo().frame(secondParentFrame).switchTo().frame(childFrame);
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(eBOMItemLink).click();
            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(thirdParentFrame);
            Serenity.getDriver().switchTo().frame(thirdParentFrame).switchTo().frame(childFrame);
            String revision = withTimeoutOf(Duration.ofSeconds(120)).waitFor(revisionField).getAttribute("value");
            eBomRevisions.add(revision);
            System.out.println(itemCode + ": " + "EBOM Revision: " + revision);
            Serenity.getDriver().switchTo().defaultContent();
            closeThirdTab.click();
            closeSecondTab.click();
            fillEbomRevisionAndTargetLifeCycle(revision);
        });

        return eBomRevisions;
    }

    public void fillEbomRevisionAndTargetLifeCycle(String revision) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        MigratedDataPartPage.editButton.click();
        Serenity.getDriver().switchTo().frame(mSpecMCOAffectedItemRelationshipIframe);
        withTimeoutOf(Duration.ofSeconds(90)).waitFor(tableRows);
        waitABit(3000);
        System.out.println(tableRows.size() + "tableRows size");
        for (WebElement row : tableRows) {
            List<WebElement> tds = row.findElements(By.tagName("td"));
            for (int i = 0; i < tds.size(); i++) {
                if (i == 2) {
                    tds.get(i).click();
                    reusableUtilities.pressRightNavigation();
                    reusableUtilities.pressRightNavigation();
                    reusableUtilities.pressShiftTab();
                    $(Serenity.getDriver().switchTo().activeElement()).type(revision);
                    waitABit(1000);
                    reusableUtilities.pressTab();
                    $(Serenity.getDriver().switchTo().activeElement()).type("Released");
                }
            }
        }
        Serenity.getDriver().switchTo().parentFrame();
        doneButton.click();
    }

    public String fetchMCONumber() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        return $(mcoNumber).getAttribute("value").trim();
    }

    public void switchToECOWorkflowFrame() {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(60)).waitFor(newFrameForCreatePartFrame);
        Serenity.getDriver().switchTo().frame(newFrameForCreatePartFrame);
        if ($(MigratedDataPartPages.newFrameForm1).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(MigratedDataPartPages.newFrameForm1).switchTo().frame(MigratedDataPartPages.newFrameForm2).switchTo().frame(MigratedDataPartPages.newFrameToSeeSubFamilyWorkFlow);
        } else {
            Serenity.getDriver().switchTo().frame(MigratedDataPartPages.newFrameForm).switchTo().frame(MigratedDataPartPages.newFrameForm2).switchTo().frame(MigratedDataPartPages.newFrameToSeeSubFamilyWorkFlow);
        }
    }

    public String validateECOWorkFlowStatus() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        return $(MigratedDataPartPages.ecoStatus).waitUntilVisible().getText().trim();
    }

    public boolean isECOReleased() {
        String statusField = validateECOWorkFlowStatus();
        System.out.println("MCO current state is: " + statusField);
        return statusField.equalsIgnoreCase("Released");
    }


    public void userShouldCompleteTheSignOffProcessOfMCO() throws Exception {
        String mcoNumber = fetchMCONumber();
        ItemCodeStore.storeTheData("mcoNumber", mcoNumber);
        switchToECOWorkflowFrame();
        try {
            while (!isECOReleased()) {
                String nextUser = completeCurrentVoteAndGetTheNameOfNextApprovers();
                System.out.println(nextUser + "nextUser");
                if (isECOReleased()) {
                    System.out.println("MCO Released...");
                    break;
                } else System.out.println("MCO Not Released");
                if (nextUser != null) {
                    System.out.println(ItemCodeStore.getStoredData("nextApproverName") + " next approvers");
                    switchToUserAndContinue(ItemCodeStore.getStoredData("nextApproverName"), mcoNumber);
                } else {
                    System.out.println("Null so closing MCO");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Something went wrong" + e.getMessage());
        }
    }


    public void switchToUserAndContinue(String nextVoteAssignedUser, String mcoNumber) throws IOException {
        String[] credentials = retrieveUserCredentials("src/test/resources/TestData/UserCredentials.xlsx", "Sheet1", nextVoteAssignedUser);
        System.out.println(Arrays.toString(credentials) + "Credentials");
        if (credentials != null) {
            performLogOutLoginAndNavigateToECO(credentials[0], mcoNumber);
        } else {
            System.out.println("User credential not found......Please update the credentials sheet....");
            Assert.fail("User credential not found for......Please update the credentials sheet....");
        }
    }

    public void performLogOutLoginAndNavigateToECO(String credentials, String ecoNumber) {
        arasLoginPageObjects.logOutAndLogin();
        arasLoginPageObjects.Login(credentials);
        arasHomePage.verifyHomePage();
        arasHomePage.navigating("Change Management/MCOs/Search MCOs");
        searchMCOItemsFromSearchSection(ecoNumber);
        partPage.userClicksOnTab("Signoffs");
    }

    public boolean isCurrentUser(String activeUser) {
        Serenity.getDriver().switchTo().defaultContent();
        String title = $(MigratedDataPartPages.currentUserDetails).getAttribute("title");
        System.out.println("Current Login User is: " + title);
        return title.contains(activeUser);
    }

    public String completeCurrentVoteAndGetTheNameOfNextApprovers() {
        try {
            switchToECOWorkflowFrame();
            while (isVoteNowButtonVisible()) {
                MigratedDataPartPages.voteNowBtn.click();
                String activity = MigratedDataPartPages.activityType.getText().trim();
                System.out.println("Activity: " + activity);
                completeVoteProcess(activity);
                checkAnyUnwantedErrorsIsDisplayed();
            }
            if (MigratedDataPartPages.activeButton.isCurrentlyVisible()) {
                System.out.println("Vote Now is not visible but Active is visible");
                String nextApproverName = MigratedDataPartPages.assignedTo.getText().trim();
                System.out.println("Next Vote is assigned to: " + nextApproverName);
                ItemCodeStore.storeTheData("nextApproverName", nextApproverName);
                return nextApproverName;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Boolean completeCurrentVoteAndGetTheNameOfNextApprover() {
        try {
            switchToECOWorkflowFrame();
            if (isVoteNowButtonVisible()) {
                System.out.println("Vote Now is visible");
                String activeApproverName = MigratedDataPartPages.assignedTo.getText().trim();
                MigratedDataPartPages.voteNowBtn.click();
                String activity = MigratedDataPartPages.activityType.getText().trim();
                System.out.println("Activity: " + activity);
                completeVoteProcess(activity);
                checkAnyUnwantedErrorsIsDisplayed();
                if (!isVoteNowButtonVisible()) {
                    String nextApproverName = MigratedDataPartPages.assignedTo.getText().trim();
                    ItemCodeStore.storeTheData("nextApproverName", nextApproverName);
                    return false;
                }
            } else if (MigratedDataPartPages.activeButton.isCurrentlyVisible()) {
                System.out.println("Vote Now is not visible but Active is visible");
                String nextApproverName = MigratedDataPartPages.assignedTo.getText().trim();
                System.out.println("Next Vote is assigned to: " + nextApproverName);
                ItemCodeStore.storeTheData("nextApproverName", nextApproverName);
                return false;
            } else {
                System.out.println("Vote Now and Active both are not visible");
                return null; // No active user found
            }
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logging framework
            return null;
        }
        return null;
    }

    public boolean isVoteNowButtonVisible() {
        switchToECOWorkflowFrame();
        try {
            if (MigratedDataPartPages.voteNowBtn.isCurrentlyVisible()) {
                return $(MigratedDataPartPages.voteNowBtn).isCurrentlyVisible();
            } else {
                System.out.println("Vote Now button is not visible immediately so waiting......");
                withTimeoutOf(Duration.ofSeconds(20)).waitFor(MigratedDataPartPages.voteNowBtn);
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void completeVoteProcess(String activity) {
        validateWorkflowWindow(); // Validate the workflow window
        if (activity.trim().equalsIgnoreCase("Pending")) {
            userSelectsSendToReviewVoteList("Submit for Define Change");
        } else if (activity.trim().equalsIgnoreCase("Define Change")) {
            userSelectsSendToReviewVoteList("Submit for Approval");
        } else if (activity.trim().equalsIgnoreCase("Approval")) {
            userSelectsSendToReviewVoteList("Approve");
        } else if (activity.trim().equalsIgnoreCase("Business Release")) {
            userSelectsSendToReviewVoteList("Complete");
        } else {
            throw new RuntimeException("Unknown activity type: " + activity);
        }
        userClicksCompleteButton(); // Finalize the process
    }

    public void userShouldEnterTheEsignature() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(MigratedDataPartPages.newFrameForWorkFlow);
        Serenity.getDriver().switchTo().frame(MigratedDataPartPages.newFrameForWorkFlow);
        $(MigratedDataPartPages.eSignatureField).sendKeys("innovator");
    }

    public void userClicksCompleteButton() {
        validateWorkflowWindow();
        $(MigratedDataPartPages.completeButton).waitUntilClickable().click();
        if ($(MigratedDataPartPages.continueButton).isCurrentlyVisible()) {
            $(MigratedDataPartPages.continueButton).click();
        }
        //Serenity.recordReportData().withTitle("Complete Button Clicked").andContents("Clicked the complete button successfully.");
    }

    public void userSelectsSendToReviewVoteList(String option) {
        validateWorkflowWindow();
        $(MigratedDataPartPages.VoteList).selectByVisibleText(option.trim());
        Serenity.recordReportData().withTitle("Vote List Updated").andContents("Selected the option: " + option + " from the Vote List.");
    }

    public void validateWorkflowWindow() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(MigratedDataPartPages.newFrameForWorkFlow);
        Serenity.getDriver().switchTo().frame(MigratedDataPartPages.newFrameForWorkFlow);
    }

    public void checkAnyUnwantedErrorsIsDisplayed() throws Exception {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        if ($(MigratedDataPartPages.errorMessage).isCurrentlyVisible()) {
            String errorMessageText = $(MigratedDataPartPages.errorMessage).getText();
            waitABit(5000);
            throw new Exception("An error occurred: " + errorMessageText);
        }
    }

    public static String[] retrieveUserCredentials(String filePath, String sheetName, String targetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath); // Open the Excel file and access the specified sheet
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        Iterator<Row> rowIterator = sheet.iterator(); // Iterate through each row in the sheet
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell nameCell = row.getCell(0);

            if (nameCell.getStringCellValue().equalsIgnoreCase(targetName)) { // If the target name matches the first column, retrieve the credentials
                String username = row.getCell(1).getStringCellValue();
                String password = row.getCell(2).getStringCellValue();
                workbook.close();  // Close the workbook and return the credentials
                return new String[]{username, password};
            }
        }

        workbook.close();  // Close the workbook if the target name is not found
        return null;  // Return null if no matching entry is found
    }

    public void searchMCOItemsFromSearchSection(String itemCode) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(mcoNumberField);
        waitABit(2000);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(clearSearchCriteria).click();
        waitABit(2000);

        $(mcoNumberField).click();
        waitABit(2000);

        Serenity.getDriver().switchTo().activeElement().sendKeys(itemCode);
        waitABit(2000);

        $(runSearchButton).waitUntilClickable().click();

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//*[text()='" + itemCode + "']"));

        waitABit(3000);

        WebElement resultElement = $(By.xpath("//*[text()='" + itemCode + "']"));
        action.moveToElement(resultElement).doubleClick().perform();

        waitABit(2000);
        Serenity.getDriver().switchTo().defaultContent();

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(MigratedDataPartPages.activeTabsList.get(1));
        MigratedDataPartPages.activeTabsList.get(0).click();
    }

    public void userOpensMspecFromAffectedItems(String itemCode) throws Exception {
        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(MigratedDataPartPages.affectedItemsTab).click();
            Serenity.getDriver().switchTo().frame(mSpecMCOAffectedItemRelationshipIframe);
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(MigratedDataPartPages.searchModesInSearchDialogue).selectByVisibleText("Simple");

            withTimeoutOf(Duration.ofSeconds(120)).waitFor(MigratedDataPartPages.clearSearchCriteria).click();
            waitABit(2000);
            itemCodeInSearch.click();
            $(Serenity.getDriver().switchTo().activeElement()).type(itemCode);
            runSearchButton.click();
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(MigratedDataPartPages.searchResultsInGrid);
            if ($(By.xpath("//td[text()='" + itemCode + "']")).isCurrentlyVisible()) {
                withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//td[text()='" + itemCode + "']")).click();
            }

            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(MigratedDataPartPages.TheSecondOpenedTab);

            //Wait till the part is opened
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(secondParentFrame).switchTo().frame(childFrame);
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(mSpecItemCode);
        } catch (Exception e) {
            throw new Exception("Something went wrong.... or mSpec not found in affected Items tab");
        }
    }

    public void validateTheLifeCycle(String lifecycle) throws Exception {
        try {
            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(secondParentFrame);
            Serenity.getDriver().switchTo().frame(secondParentFrame).switchTo().frame(childFrame);
            waitABit(3000);
            String partLifecycle = $(By.xpath("//input[@name='state']")).getAttribute("value");
            if (lifecycle.equalsIgnoreCase(partLifecycle)) {
                Assert.assertTrue(true); // Lifecycle is as expected
            } else {
                throw new Exception("Test Fail: Part lifeCycle is not in " + lifecycle + " state, current state is: " + partLifecycle);
            }
        } catch (Exception e) {
            throw new Exception("Error while validating lifecycle: " + e.getMessage(), e);
        }
    }

    public String getTheMspecID() throws Exception {
        try {
            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(secondParentFrame);
            Serenity.getDriver().switchTo().frame(secondParentFrame);
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(MigratedDataPartPages.shareButton);
            waitABit(2000);
            $(MigratedDataPartPages.shareButton).click();
            waitABit(1000);
            $(Serenity.getDriver().findElement(By.xpath("//span[text()='Copy ID']"))).click();

            // Retrieve part ID from clipboard
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(MigratedDataPartPages.TheSecondOpenedTab).click();
            return (String) clipboard.getData(DataFlavor.stringFlavor);

        } catch (Exception e) {
            throw new Exception("Error while fetching Part ID: " + e.getMessage(), e);
        }
    }

    public void takeTheScreenshotsForMspecData(String folderName) throws IOException {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(secondParentFrame);
        Serenity.getDriver().switchTo().frame(secondParentFrame);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(BOMTabIframe);
        Serenity.getDriver().switchTo().frame(BOMTabIframe);
        js.executeScript("arguments[0].scrollIntoView();", $(addMspec));
        addSearchCriteriaForBOMTab(folderName, "BOM tab");
        partPage.userClicksOnTab("Parameter");
        waitABit(2000);
        addSearchCriteria(MigratedDataPartPages.textFieldInSearchMode, "*", folderName, "Parameters_tab_text");
        addSearchCriteria(MigratedDataPartPages.targetFieldInSearchMode, "*", folderName, "Parameters_tab_target");
        //addSearchCriteria(listValueFieldInSearchMode, "N", folderName, "Parameters_tab_listValues");
    }

    public void addSearchCriteria(WebElementFacade targetElement, String targetValue, String folderName, String screenshotName) throws IOException {
        partPage.setZoomLevel(1.0);
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(secondParentFrame);
        Serenity.getDriver().switchTo().frame(secondParentFrame).switchTo().frame(parametersFrame);
        js.executeScript("arguments[0].scrollIntoView();", MigratedDataPartPages.searchModesInSearchDialogue);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(MigratedDataPartPages.searchModesInSearchDialogue).selectByVisibleText("Simple");
        waitABit(2000);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(clearSearchCriteria).click();
        waitABit(2000);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(targetElement).click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type(targetValue);
        runSearchButton.click();
        waitABit(2000);

        final String SHADOW_HOST_SELECTOR = "aras-input[title='Results per Page']";
        final String INPUT_SELECTOR = "input[title='Results per Page']";

        WebElement shadowHost = Serenity.getDriver().findElement(By.cssSelector(SHADOW_HOST_SELECTOR));
        SearchContext shadowRoot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        WebElement inputElement = shadowRoot.findElement(By.cssSelector(INPUT_SELECTOR));

        System.out.println(inputElement.getText() + " :setSearchResults");

        inputElement.click();
        reusableUtilities.pressControlA();
        reusableUtilities.pressBackspace();
        waitABit(2000);
        inputElement.sendKeys(String.valueOf(5));
        runSearchButton.click();

        waitABit(5000);
        int pageNum = 1;
        System.out.println(MigratedDataPartPages.nextPage.isDisabled() + " :nextPageButton");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(secondParentFrame).switchTo().frame(parametersFrame);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(MigratedDataPartPages.searchModesInSearchDialogue).selectByVisibleText("Hidden");
        ExcelUtilities.captureScreenshotForPartsData(folderName, screenshotName + "Page_" + pageNum);
        waitABit(2000);
        while (!MigratedDataPartPages.nextPage.isDisabled()) {
            pageNum++;
            MigratedDataPartPages.nextPage.click();
            waitABit(5000);
            ExcelUtilities.captureScreenshotForPartsData(folderName, screenshotName + "Page_" + pageNum);
        }
    }

    public void addSearchCriteriaForBOMTab(String folderName, String screenshotName) throws IOException {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(secondParentFrame);
        waitABit(3000);
        Serenity.getDriver().switchTo().frame(secondParentFrame).switchTo().frame(BOMTabIframe);
        js.executeScript("arguments[0].scrollIntoView();", MigratedDataPartPages.searchModesInSearchDialogue);
        runSearchButton.click();
        waitABit(1500);

        final String SHADOW_HOST_SELECTOR = "aras-input[title='Results per Page']";
        final String INPUT_SELECTOR = "input[title='Results per Page']";

        WebElement shadowHost = Serenity.getDriver().findElement(By.cssSelector(SHADOW_HOST_SELECTOR));
        SearchContext shadowRoot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        WebElement inputElement = shadowRoot.findElement(By.cssSelector(INPUT_SELECTOR));

        System.out.println(inputElement.getText() + " :setSearchResults");

        inputElement.click();
        reusableUtilities.pressControlA();
        reusableUtilities.pressBackspace();
        waitABit(2000);
        inputElement.sendKeys(String.valueOf(5));
        runSearchButton.click();

        waitABit(5000);
        int pageNum = 1;
        System.out.println(MigratedDataPartPages.nextPage.isDisabled() + " :nextPageButton");
        ExcelUtilities.captureScreenshotForPartsData(folderName, screenshotName + "Page_" + pageNum);
        waitABit(2000);
        while (!MigratedDataPartPages.nextPage.isDisabled()) {
            pageNum++;
            MigratedDataPartPages.nextPage.click();
            waitABit(3000);
            ExcelUtilities.captureScreenshotForPartsData(folderName, screenshotName + "Page_" + pageNum);
        }
    }
}
